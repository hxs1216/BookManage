package com.biyao.system.action;

import com.biyao.common.base.Message;
import com.biyao.common.util.ObjToJson;
import com.biyao.system.dao.ISysUserInfoDAO;
import com.biyao.system.model.SysUserInfo;
import com.biyao.system.model.SysUserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: hxs
 * @Description:注册页面的增删改查
 */
@Controller
@RequestMapping("/system")
public class RegistAction {

    @Autowired
    private ISysUserInfoDAO iSysUserInfoDAO;
    private Message message = null;
    private ObjToJson objToJson = new ObjToJson();

    //注册功能
    @ResponseBody
    @RequestMapping(value="/regist")
    public String showPeiReport(SysUserInfo user, HttpServletRequest httpServletRequest, Model model){
        message = new Message();

        //判断个人图书馆的名字是否重复
        SysUserInfoExample example = new SysUserInfoExample();
        example.createCriteria().andLibraryNameEqualTo(user.getLibraryName());
        int libraryCount = iSysUserInfoDAO.countByExample(example);

        //判断个账号是否重复
        example.clear();
        example.createCriteria().andLoginAccountEqualTo(user.getLoginAccount());
        int accountNum = iSysUserInfoDAO.countByExample(example);

        if(libraryCount>0){
            message.setContent("该图书馆的名字已经存在");
            message.setShow("1");
        }else if(accountNum>0){
            message.setContent("该账号已经存在");
            message.setShow("2");
        }else {
            iSysUserInfoDAO.insert(user);
            message.setContent("注册成功");
            message.setShow("3");
        }
        String json=objToJson.getJson(message);
        return json;
    }

}
