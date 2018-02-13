package com.biyao.system.action;

import com.biyao.book.dao.IBookCommentDAO;
import com.biyao.book.dao.IBookIntroductDAO;
import com.biyao.book.model.BookComment;
import com.biyao.book.model.BookCommentExample;
import com.biyao.book.model.BookIntroduct;
import com.biyao.book.model.BookIntroductExample;
import com.biyao.system.model.SysUserInfo;
import com.biyao.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hxs
 * @Description:首页跳转
 * @Date:on 2018/1/3
 */

@Controller
@RequestMapping("/system")
public class IndexAction{

    @Autowired
    private IBookIntroductDAO iBookIntroductDAO;

    @Autowired
    private IBookCommentDAO iBookCommentDAO;

    //展示系统所有书
    @RequestMapping("/allBook")
    public String allBook(Model model, PageUtil page) {
        BookIntroductExample example = new BookIntroductExample();
        example.setOrderByClause("create_time DESC");

        //获取分页总数
        int count = iBookIntroductDAO.countByExample(example);
        page.setTotalRecord(count);

        //获取首页展示数据
        List<BookIntroduct> books = null;
        if(count > 0){
            example.setMysqlOffset(page.getStartRow());
            example.setMysqlLength(page.getPageSize());
            books = iBookIntroductDAO.selectByExample(example);
        }
        model.addAttribute("books",books);
        model.addAttribute("page",page);
        return "index";
    }

    //展示书的详情
    @RequestMapping("/bookDetail/{bookId}")
    public String bookDetail(@PathVariable int bookId, Model model) {

        //获取书的详情
        BookIntroduct book = iBookIntroductDAO.selectByPrimaryKey(bookId);
        model.addAttribute("book",book);
        return "searchBook/bookDetail";
    }

    //搜索书的列表
    @RequestMapping("/searchBooks")
    public String searchBooks(Model model,HttpServletRequest request, PageUtil page) {
        String searchKey = request.getParameter("searchKey");

        //条件
        Map condition = new HashMap();
        condition.put("searchKey",searchKey);

        //搜索书的列表
        int count = iBookIntroductDAO.countBooks(condition);
        page.setTotalRecord(count);

        //获取首页展示数据
        List<BookIntroduct> books = null;
        if(count > 0){

            //条件
            condition.put("mysqlOffset",page.getStartRow());
            condition.put("mysqlLength",page.getPageSize());
            books = iBookIntroductDAO.searchBooks(condition);
        }
        model.addAttribute("books",books);
        model.addAttribute("page",page);
        model.addAttribute("searchKey",searchKey);
        return "index";
    }

    //展示书的系列、作者、个人图书馆
    @RequestMapping("/searchByCondition/{type}")
    public String searchSeries(@PathVariable int type, Model model,HttpServletRequest request, PageUtil page) {

        //跳转地址
        String address = null;

        //获取书的系列、作者、图书馆
        String bookSeries = request.getParameter("bookSeries");
        String bookAuro = request.getParameter("bookAuro");
        String library = request.getParameter("library");

        //通过条件搜索书的列表
        int count = 0;
        BookIntroductExample example = new BookIntroductExample();
        example.setOrderByClause("create_time DESC");
        BookIntroductExample.Criteria criteria = example.createCriteria();
        if(type == 1){
            criteria.andBookSeriesEqualTo(bookSeries);
            model.addAttribute("searchKey",bookSeries);
            address = "searchBook/bookSeries";
        }else if(type == 2){
            criteria.andBookAuthorEqualTo(bookAuro);
            model.addAttribute("searchKey",bookAuro);
            address = "searchBook/bookAuthority";
        }else if(type == 3){
            criteria.andBookLibraryEqualTo(library);
            model.addAttribute("searchKey",library);
            address = "searchBook/bookLibrary";
        }

        count = iBookIntroductDAO.countByExample(example);
        page.setTotalRecord(count);

        //获取首页展示数据
        List<BookIntroduct> books = null;
        if(count > 0){
            example.setMysqlOffset(page.getStartRow());
            example.setMysqlLength(page.getPageSize());
            books = iBookIntroductDAO.selectByExample(example);
        }
        model.addAttribute("books",books);
        model.addAttribute("page",page);

        return address;
    }

    //展示书的系列、作者、个人图书馆
    @RequestMapping("/searchLoginBooks/{type}")
    public String searchLoginBooks(@PathVariable int type, Model model,HttpServletRequest request, PageUtil page) {

        //跳转地址
        String address = null;

        //获取书的系列、作者、图书馆
        String bookSeries = request.getParameter("bookSeries");
        String bookAuro = request.getParameter("bookAuro");
        String library = request.getParameter("library");

        //通过条件搜索书的列表
        int count = 0;
        BookIntroductExample example = new BookIntroductExample();
        example.setOrderByClause("create_time DESC");
        BookIntroductExample.Criteria criteria = example.createCriteria();
        if(type == 1){
            criteria.andBookSeriesEqualTo(bookSeries);
            model.addAttribute("searchKey",bookSeries);
            address = "searchBook/book_series";
        }else if(type == 2){
            criteria.andBookAuthorEqualTo(bookAuro);
            model.addAttribute("searchKey",bookAuro);
            address = "searchBook/book_authority";
        }else if(type == 3){
            criteria.andBookLibraryEqualTo(library);
            model.addAttribute("searchKey",library);
            address = "searchBook/book_library";
        }

        count = iBookIntroductDAO.countByExample(example);
        page.setTotalRecord(count);

        //获取首页展示数据
        List<BookIntroduct> books = null;
        if(count > 0){
            example.setMysqlOffset(page.getStartRow());
            example.setMysqlLength(page.getPageSize());
            books = iBookIntroductDAO.selectByExample(example);
        }
        model.addAttribute("books",books);
        model.addAttribute("page",page);

        return address;
    }

    //登录进去展示别人的书籍
    @RequestMapping("/showOtherBookByCondition")
    public String showOtherBookByCondition(Model model, PageUtil page,HttpServletRequest request) {

        //获取当前用户
        SysUserInfo currentUser = (SysUserInfo) request.getSession().getAttribute("currentUser");
        String searchKey = request.getParameter("searchKey");

        //条件
        Map condition = new HashMap();
        condition.put("searchKey",searchKey);
//        condition.put("account",currentUser.getLoginAccount());

        //搜索书的列表
        int count = iBookIntroductDAO.countBooks(condition);
        page.setTotalRecord(count);

        //获取首页展示数据
        List<BookIntroduct> books = null;
        if(count > 0){

            //条件
            condition.put("mysqlOffset",page.getStartRow());
            condition.put("mysqlLength",page.getPageSize());
            books = iBookIntroductDAO.searchBooks(condition);
        }
        model.addAttribute("books",books);
        model.addAttribute("page",page);
        model.addAttribute("searchKey",searchKey);
        return "myIndex";
    }

    //登录进去展示书的详情
    @RequestMapping("/bookOtherDetail/{bookId}")
    public String bookOtherDetail(@PathVariable int bookId, Model model) {

        //获取书的详情
        BookIntroduct book = iBookIntroductDAO.selectByPrimaryKey(bookId);

        //获取书的评论
        BookCommentExample example = new BookCommentExample();
        example.setOrderByClause("create_time");
        example.createCriteria().andBookIdEqualTo(bookId+"");
        List<BookComment> bookComments = iBookCommentDAO.selectByExample(example);
        model.addAttribute("book",book);
        model.addAttribute("bookComments",bookComments);
        return "searchBook/book_detail";
    }


}
