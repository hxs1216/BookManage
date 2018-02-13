package com.biyao.system.action;

import com.biyao.book.dao.IBookIntroductDAO;
import com.biyao.book.model.BookIntroduct;
import com.biyao.book.model.BookIntroductExample;
import com.biyao.common.OnlineSession;
import com.biyao.common.base.Message;
import com.biyao.common.listener.SessionListener;
import com.biyao.common.util.ObjToJson;
import com.biyao.common.util.SysConfigUtil;
import com.biyao.system.dao.ISysUserInfoDAO;
import com.biyao.system.model.SysUserInfo;
import com.biyao.system.model.SysUserInfoExample;
import com.biyao.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: hxs
 * @Description:登录系统
 */

@Controller
@RequestMapping("/system")
public class LoginAction{

    @Autowired
    private ISysUserInfoDAO iSysUserInfoDAO;

    @Autowired
    private IBookIntroductDAO iBookIntroductDAO;

    private Message message = null;
    private ObjToJson objToJson = new ObjToJson();

    @ResponseBody
    @RequestMapping("/loginAction")
    public String loginIn(@ModelAttribute("user") SysUserInfo user, HttpServletRequest request, HttpSession session){
        message = new Message();

        //时间格式、菜单
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(user != null){
            String userId = user.getLoginAccount().trim();
            String pwd = user.getUserPwd();

            //获取用户信息
            SysUserInfoExample userFind = new SysUserInfoExample();
            SysUserInfoExample.Criteria cr = userFind.createCriteria();
            cr.andLoginAccountEqualTo(userId);
            List<SysUserInfo> userList = iSysUserInfoDAO.selectByExample(userFind);

            if (userList.size() == 0) {

                // 回到登录页面，提示错误信息
                message.setContent("用户不存在");
                message.setShow("1");
            }else {
                user = userList.get(0);
                if (user != null && !pwd.equals(SysConfigUtil.configProperties.getProperty("initpass")) && !pwd.equals(user.getUserPwd())) {

                    // 回到登录页面，提示错误信息
                    message.setContent("密码错误,请重新输入");
                    message.setShow("2");
                }
            }

            if(StringUtils.isEmpty(message.getShow())){

                // 将当前用户存入session监听器当中的对象当中
                session.setAttribute("currentUser", user);

                // 在线用户信息保存
                session.setAttribute(SessionListener.curUser,new OnlineSession(user.getLoginAccount(), request.getRemoteAddr(),session.getId(),simpleFormat.format(new Date())));
            }
        }
        String json=objToJson.getJson(message);
        return json;
    }

    @RequestMapping("/loginIn")
    public String loginIn(Model model, PageUtil page,HttpServletRequest request) {

        //获取当前用户
        SysUserInfo currentUser = (SysUserInfo) request.getSession().getAttribute("currentUser");

        BookIntroductExample example = new BookIntroductExample();
        example.setOrderByClause("create_time DESC");
//        example.createCriteria().andBookAccountNotEqualTo(currentUser.getLoginAccount());

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
        return "myIndex";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "forward:/system/allBook";
    }

}
