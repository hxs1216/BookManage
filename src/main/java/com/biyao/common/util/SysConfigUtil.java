package com.biyao.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SysConfigUtil {

	public static String uploadPath = "Upload";

	/**
	 * config配置文件信息
	 */
	public static Properties configProperties;
	private static ServletContext servletContext;

	public static void init(ServletContext sc) {
		servletContext = sc;
	}

	public static Object getBean(String clazz) {
		return WebApplicationContextUtils.getWebApplicationContext(servletContext).getBean(clazz);
	}
}
