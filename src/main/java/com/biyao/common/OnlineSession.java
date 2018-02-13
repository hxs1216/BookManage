package com.biyao.common;

/**
 * @Author: hxs
 * @Description:在线用户信息
 * @Date:on 2017/9/8
 */
public final class OnlineSession {

	// 获取当前在线用户
	private String loginAccount = null;

	//远程地址
	private String gsMc = null;

	//Ip
	private String ip = null;

	//登录时间
	private String onlineTime = null;

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getGsMc() {
		return gsMc;
	}

	public void setGsMc(String gsMc) {
		this.gsMc = gsMc;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}

	public OnlineSession(String loginAccount, String gsMc, String ip, String onlineTime) {
		this.loginAccount = loginAccount;
		this.gsMc = gsMc;
		this.ip = ip;
		this.onlineTime = onlineTime;
	}

	public OnlineSession() {
	}

	@Override
	public String toString() {
		return "OnlineSession{" +
				"loginAccount='" + loginAccount + '\'' +
				", gsMc='" + gsMc + '\'' +
				", ip='" + ip + '\'' +
				", onlineTime='" + onlineTime + '\'' +
				'}';
	}
}
