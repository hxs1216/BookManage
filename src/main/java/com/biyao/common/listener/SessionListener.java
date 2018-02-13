/**
 * 
 */
package com.biyao.common.listener;

import com.biyao.common.OnlineSession;
import com.biyao.common.util.SysConfigUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: hxs
 * @Description:在线用户信息
 * @Date:on 2017/9/8
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
	
	public final static String curUser = "onlineUser";
	
	private List<String> outerNames = null;

	private static List<OnlineSession> sessions = new ArrayList<OnlineSession>();
	
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		arg0.getSession().removeAttribute(curUser);
	}

	public void attributeAdded(HttpSessionBindingEvent sbe) {
		//System.out.println("attributeAdded"+sbe.getName());
		if (SessionListener.curUser.equals(sbe.getName())) {
			outerNames = Arrays.asList(SysConfigUtil.configProperties.getProperty("outer.online.names").split(","));
			boolean has = false;
			OnlineSession value = (OnlineSession)sbe.getValue();
			if (outerNames.contains(value.getLoginAccount())) {
				return;
			}
			for (OnlineSession obj : sessions) {
				if (obj.getLoginAccount().equals(value.getLoginAccount())) {
					has = true;
					break;
				}
			}
			if (!has) {
				sessions.add(value);
			}
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent sbe) {
		if (curUser.equals(sbe.getName())) {
			OnlineSession value = (OnlineSession)sbe.getValue();
			for (OnlineSession obj : (List<OnlineSession>)sessions) {
				if (obj.getLoginAccount().equals(value.getLoginAccount())) {
					sessions.remove(obj);
					break;
				}
			}
			
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent sbe) {
		
	}

	public static List<OnlineSession> getSessions() {
		return sessions;
	}

}
