package com.biyao.book.action;

import com.biyao.book.dao.IBookCommentDAO;
import com.biyao.book.dao.IBookIntroductDAO;
import com.biyao.book.model.BookComment;
import com.biyao.book.model.BookCommentExample;
import com.biyao.book.model.BookIntroduct;
import com.biyao.book.model.BookIntroductExample;
import com.biyao.common.base.Message;
import com.biyao.common.util.ObjToJson;
import com.biyao.system.dao.ISysDictionaryDAO;
import com.biyao.system.model.SysDictionary;
import com.biyao.system.model.SysDictionaryExample;
import com.biyao.system.model.SysUserInfo;
import com.biyao.util.DateUtil;
import com.biyao.util.FileUtil;
import com.biyao.util.PageUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author: hxs
 * @Description:我的个人图书馆
 */

@Controller
@RequestMapping("/book")
public class MyLibrary {

    @Resource
    private IBookIntroductDAO iBookIntroductDAO;

    @Resource
    private ISysDictionaryDAO iSysDictionaryDAO;

    @Resource
    private IBookCommentDAO iBookCommentDAO;

    private Message message = null;
    private ObjToJson objToJson = new ObjToJson();

    //展示个人图书馆所有书
    @RequestMapping("/myLibrary")
    public String myLibrary(HttpServletRequest request, Model model, PageUtil page) {

        //获取当前用户
        SysUserInfo currentUser = (SysUserInfo) request.getSession().getAttribute("currentUser");

        //获取个人图书馆书的数量
        BookIntroductExample example = new BookIntroductExample();
        example.setOrderByClause("update_time DESC");
        example.createCriteria().andBookAccountEqualTo(currentUser.getLoginAccount());
        int count = iBookIntroductDAO.countByExample(example);
        page.setTotalRecord(count);

        List<BookIntroduct> books = null;
        if(count > 0){

            //条件
            example.setMysqlOffset(page.getStartRow());
            example.setMysqlLength(page.getPageSize());
            books = iBookIntroductDAO.selectByExample(example);
        }

        model.addAttribute("books",books);
        model.addAttribute("page",page);
        return "myLibrary/myLibrary";
    }

    //展开书目添加页面
    @RequestMapping("/bookShow")
    public String addBook(HttpServletRequest httpServletRequest, Model model) {

        //类型字段、年龄段、状态
        SysDictionaryExample example = new SysDictionaryExample();
        List<SysDictionary> dictionary = iSysDictionaryDAO.selectByExample(example);
        model.addAttribute("dictionary",dictionary);
        return "myLibrary/bookAdd";
    }

    //添加新的书目
    @ResponseBody
    @RequestMapping("/bookAdd")
    public String bookAdd(BookIntroduct book, HttpServletRequest request, Model model) {
        message = new Message();

        //获取当前用户
        SysUserInfo currentUser = (SysUserInfo) request.getSession().getAttribute("currentUser");
        try {

            //创建时间
            book.setCreateTime(new Date());
            book.setUpdateTime(new Date());
            book.setBookAccount(currentUser.getLoginAccount());
            book.setBookLibrary(currentUser.getLibraryName());
            iBookIntroductDAO.insert(book);
            message.setContent("书目添加成功");
            message.setShow("true");
        }catch(Exception e){
            e.printStackTrace();
            message.setContent("书目添加失败");
            message.setShow("false");
        }

        String json=objToJson.getJson(message);
        return json;
    }

    //展示编辑页面
    @RequestMapping("/editBookShow/{id}")
    public String editBookShow(@PathVariable String id, HttpServletRequest httpServletRequest, Model model){
        BookIntroduct book = iBookIntroductDAO.selectByPrimaryKey(Integer.parseInt(id));

        //类型字段、年龄段、状态
        SysDictionaryExample example1 = new SysDictionaryExample();
        List<SysDictionary> dictionary = iSysDictionaryDAO.selectByExample(example1);

        //展示评论
        BookCommentExample example = new BookCommentExample();
        example.setOrderByClause("create_time");
        example.createCriteria().andBookIdEqualTo(id);
        List<BookComment> bookComments = iBookCommentDAO.selectByExample(example);

        model.addAttribute("book",book);
        model.addAttribute("dictionary",dictionary);
        model.addAttribute("bookComments",bookComments);
        return "myLibrary/bookEdit";
    }

    //编辑书目
    @ResponseBody
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable String id,BookIntroduct book, Model model){
        message = new Message();
        try {

            //修改时间
            book.setUpdateTime(new Date());
            BookIntroductExample example = new BookIntroductExample();
            example.createCriteria().andIdEqualTo(Integer.parseInt(id));
            iBookIntroductDAO.updateByExampleSelective(book,example);
            message.setContent("书目修改成功");
            message.setShow("true");
        }catch(Exception e){
            e.printStackTrace();
            message.setContent("书目修改失败");
            message.setShow("false");
        }

        String json=objToJson.getJson(message);
        return json;
    }

    //删除书目
    @ResponseBody
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable String id,Model model){
        message = new Message();
        try {
            iBookIntroductDAO.deleteByPrimaryKey(Integer.parseInt(id));

            //删除评论
            BookCommentExample example = new BookCommentExample();
            example.createCriteria().andBookIdEqualTo(id);
            iBookCommentDAO.deleteByExample(example);
            message.setContent("书目删除成功");
            message.setShow("true");
        }catch(Exception e){
            e.printStackTrace();
            message.setContent("书目删除失败");
            message.setShow("false");
        }

        String json=objToJson.getJson(message);
        return json;
    }

    //上传图片
    @ResponseBody
    @RequestMapping("/uploadImage")
    public String loginIn(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile multipartFile) throws IOException {
        String fileFileName = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getFileItem().getInputStream();

        //连接ftp并上传图片
        final String path = "book/"+ DateUtil.format(DateUtil.now(), "yyyy/MM/dd");
        final String name = "book_"+System.currentTimeMillis()+FileUtil.getExtention(fileFileName);
        FTPClient ftp = new FTPClient();
        FileUtil.connect(ftp, path);
        FileUtil.UploadFtpFile(ftp, inputStream, name);
        return path+"/"+name;
    }

    //对书进行评论
    @RequestMapping("/addComment")
    public String addComment(BookComment comment, HttpServletRequest request, Model model) {

        //获取当前用户
        SysUserInfo currentUser = (SysUserInfo) request.getSession().getAttribute("currentUser");
        Date date = new Date();

        comment.setCreateTime(date);
        comment.setUpdateTime(date);
        comment.setCommentPerson(currentUser.getLibraryName());
        comment.setExpress1(currentUser.getLoginAccount());
        iBookCommentDAO.insert(comment);
        return "forward:/system/bookOtherDetail/"+comment.getBookId();
    }

}
