package com.biyao.common.listener;

/**
 * @Author: hxs
 * @Description:加载配置文件或定时任务
 * @Date:on 2017/9/6
 */

import com.biyao.common.util.PropertiesHelper;
import com.biyao.common.util.SysConfigUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

    public MyListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.out.println("初始化共享读书平台");
            SysConfigUtil.configProperties = PropertiesHelper.load("/jdbc.properties");
            SysConfigUtil.init(sce.getServletContext());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        SysConfigUtil.configProperties = null;
    }

}
