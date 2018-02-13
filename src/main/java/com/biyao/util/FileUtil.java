package com.biyao.util;

import com.biyao.common.util.SysConfigUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;


/**
 * @Author: hxs
 * @Description:ftp上传下载删除封装
 * @Date:on 2018/1/5
 */
public class FileUtil {

	private  static String fptIp;
	private  static int fptPort;
	private  static String fptUser;
	private  static String fptPass;

	/**
	 * 初始化账号密码
	 */
	private static void initFtp(){
		if(fptIp==null){
			fptIp=SysConfigUtil.configProperties.getProperty("ftp.ip");
			fptPort= Integer.parseInt(SysConfigUtil.configProperties.getProperty("ftp.port"));
			fptUser=SysConfigUtil.configProperties.getProperty("ftp.username");
			fptPass=SysConfigUtil.configProperties.getProperty("ftp.password");
			fptPass = (fptPass==null)?"":fptPass;
		}
	}

	/**
	 * 获取网络文件内容
	 * @param fileHttpPath 文件Http路径
	 * @throws Exception
	 */
	public static String getHttpFile(String fileHttpPath) throws Exception {
		URL url = new URL(fileHttpPath);
		URLConnection uc = url.openConnection();
		InputStreamReader is = new InputStreamReader(uc.getInputStream(),"utf-8");
		StringBuffer strBuff = new StringBuffer();
		BufferedReader br = new BufferedReader(is);
		String str="";
		while ((str=br.readLine()) != null) {
			strBuff.append(str);
		}
		br.close();
		is.close();
		return strBuff.toString();

	}

	/**
	 * 保存网络文件
	 * @param fileHttpPath 文件网络地址
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @throws Exception
	 */
	public static File saveHttpFile(String fileHttpPath, String filePath, String fileName) throws Exception {
		URL url = new URL(fileHttpPath);
		URLConnection uc = url.openConnection();
		InputStreamReader is = new InputStreamReader(uc.getInputStream(),"utf-8");
		BufferedReader br = new BufferedReader(is);

		File file=new File(filePath+"/"+fileName);
		FileOutputStream fout = new FileOutputStream(file);
		String str="";
		try {
			while ((str=br.readLine()) != null) {
				fout.write(str.getBytes("utf-8"));
			}
		} catch (Exception e) {
			return null;
		} finally {
			fout.close();
			is.close();
			br.close();
		}
		return file;

	}

	/**
	 * 创建FTP连接(发现ftp服务器目录不存在，不会自动创建服务器目录)
	 * @param path 上传到ftp服务器哪个路径下
	 * @throws Exception
	 */
	public static FTPClient connectSimple(String path){
		try {
			FTPClient ftp = new FTPClient();
			initFtp();
			int reply;
			ftp.connect(fptIp, fptPort);
			ftp.login(fptUser, fptPass);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return null;
			}
			if (!ftp.changeWorkingDirectory(path)) {
				return null;
			}
			return ftp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 创建FTP连接(发现ftp服务器目录不存在，将根据传入目录在服务器上创建目录)
	 * @param path 传入路径格式  xx/xx/xx，传空时，默认赋值 当前日的 yyyy/MM/dd做为传入目录
	 * @return 无法成功创建连接返回null
	 */
	public static String connect(FTPClient ftp, String path){
		try {
			Date today = new Date();
			if (path == null || "".equals(path)) {
				path = DateUtil.format(today, "yyyy/MM/dd");
			}
			initFtp();
			int reply;
			ftp.connect(fptIp, fptPort);
			ftp.login(fptUser, fptPass);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

			// 设置为linux 模式
			FTPClientConfig conf = new FTPClientConfig( FTPClientConfig.SYST_UNIX);
			ftp.configure(conf);

			// 设置为被动模式
			ftp.enterLocalPassiveMode();
			ftp.setRemoteVerificationEnabled(false);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return null;
			}
			if (!ftp.changeWorkingDirectory(path)) {
				String[] paths = path.split("/");
				String p = path.substring(0, path.lastIndexOf("/"));
				int index = paths.length-1;
				for (; index>0; index--) {
					if (ftp.changeWorkingDirectory(p)) {
						break;
					}
					p = path.substring(0, path.lastIndexOf("/"));
				}
				for (; index<paths.length; index++) {
					ftp.mkd(paths[index]);
					ftp.changeWorkingDirectory(paths[index]);
				}
			}
			return path;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * @param file 上传的文件或文件夹
	 * @throws Exception
	 */
	public static void UploadFtpFile(FTPClient ftp, File file) throws Exception {
		if (file.isDirectory()) {
			ftp.makeDirectory(file.getName());
			ftp.changeWorkingDirectory(file.getName());
			String[] files = file.list();
			for (int i = 0; i < files.length; i++) {
				File file1 = new File(file.getPath() + "\\" + files[i]);
				if (file1.isDirectory()) {
					UploadFtpFile(ftp,file1);
					ftp.changeToParentDirectory();
				} else {
					File file2 = new File(file.getPath() + "\\" + files[i]);
					FileInputStream input = new FileInputStream(file2);
					ftp.storeFile(file2.getName(), input);
					input.close();
				}
			}
		} else {
			File file2 = new File(file.getPath());
			FileInputStream input = new FileInputStream(file2);
			ftp.storeFile(file2.getName(), input);
			input.close();
		}
		ftp.logout();
	}

	/**
	 * 上传文件
	 * @param content 文件内容
	 * @param fileName 文件名称（包括后缀，如：文件.txt）
	 */
	public static boolean UploadFtpFile(FTPClient ftp, String content, String fileName){
		try{
			InputStream inStr=new ByteArrayInputStream(content.getBytes("GBK"));
			ftp.storeFile(fileName, inStr);
			ftp.logout();
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 上传文件
	 * @param fileName 文件名称（包括后缀，如：文件.txt）
	 */
	public static boolean UploadFtpFile(FTPClient ftp, File upFile, String fileName){
		try{
			InputStream inStr = new FileInputStream(upFile);
			ftp.storeFile(fileName, inStr);
			ftp.logout();
		}catch(Exception ex){
			return false;
		}
		return true;
	}

	/**
	 * 上传文件
	 * @param fileName 文件名称（包括后缀，如：文件.txt）
	 */
	public static boolean UploadFtpFile(FTPClient ftp, InputStream inputStream, String fileName){
		try{
			ftp.storeFile(fileName, inputStream);
			ftp.logout();
		}catch(Exception ex){
			return false;
		}
		return true;
	}

	/**
	 * 从FTP下载文件并保存在本地
	 * @param ftp
	 * @param fileAllPath 本地存储完整路径，包括文件名称
	 * @param getFilename ftp文件名称
	 * @throws Exception
	 */
	public static boolean downFtpFile(FTPClient ftp, String fileAllPath, String getFilename) throws Exception {

		String fileFloldString=fileAllPath.substring(0,fileAllPath.lastIndexOf("/"));
		File localFile = new File(fileFloldString);
		if(!localFile.exists()){
			localFile.mkdirs();
		}
		localFile = new File(fileAllPath);
		if(!localFile.exists()){
			localFile.createNewFile();
		}
		OutputStream is = new FileOutputStream(localFile);
		boolean isSuccess=ftp.retrieveFile(getFilename, is);
		is.close();
		ftp.logout();
		return isSuccess;

	}

	/**
	 * 从FTP中获取文件的文件流
	 * @param ftp
	 * @param ftpFilename
	 * @param fos
	 * @throws Exception
	 */
	public static void downFtpFile(FTPClient ftp, String ftpFilename, OutputStream fos) throws Exception {
		ftp.retrieveFile(ftpFilename, fos);
		ftp.logout();
	}

	/**
	 * 从FTP下载文件并返回文件内容
	 * @param ftp
	 * @param getFilename
	 * @throws Exception
	 */
	public static String downFtpFile(FTPClient ftp, String getFilename) throws Exception {
		try{
			InputStreamReader is = new InputStreamReader(ftp.retrieveFileStream(getFilename),"GBK");
			StringBuffer strBuff = new StringBuffer();
			BufferedReader br = new BufferedReader(is);
			String str="";
			while ( (str=br.readLine()) != null) {
				if (strBuff.length()>0) {
					strBuff.append("\n");
				}
				strBuff.append(str);
			}
			br.close();
			is.close();
			ftp.logout();
			return strBuff.toString();
		}catch(Exception ex){
			return "";
		}
	}

	/**
	 * 删除FTP文件
	 * @throws Exception
	 */
	public static void delFile(FTPClient ftp, String fileName) throws Exception {
		ftp.deleteFile(fileName);
		ftp.logout();
	}

	/**
	 * 创建并写入文件
	 * @param content 文件内容
	 * @param filename 文件名称（包括后缀，如：文件.txt）
	 * @param filePath 文件存放路径（不输入时，存入网站根目录下upLoadFile目录下）
	 * @return
	 * @throws Exception
	 */
	public static File writeFile(String content, String filename, String filePath){
		FileOutputStream o = null;
		if(StringUtils.isEmpty(filePath)){
			filePath=getWebRoot();;
		}
		File fileName=new File(filePath+filename);
		try {
			o = new FileOutputStream(fileName);
			o.write(content.getBytes("GBK"));
			o.close();
		} catch (Exception e) {
			return null;
		} finally {
		}
		return fileName;
	}

	public static String creatFile(String path){
		if(StringUtils.isEmpty(path)){
			path = DateUtil.format(new Date(), "yyyy")+"/"+DateUtil.format(new Date(), "MM")+"/"+DateUtil.format(new Date(), "dd");
		}
		String folder=getWebRoot()+SysConfigUtil.uploadPath+"/"+path;
		File localFile = new File(folder);
		if(!localFile.exists()){
			localFile.mkdirs();
		}
		return folder;
	}

	/**
	 * 获取应用根目录
	 *
	 * @return
	 */
	public static String getWebRoot() {
		String filePath=Class.class.getClass().getResource("/").getPath();
		filePath=filePath.substring(0,filePath.indexOf("/WEB-INF/"))+"/";
		return filePath;

	}

	//获取图片类型
	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos > -1) {
			return fileName.substring(pos);
		}
		return "";
	}

	//获取图片名称
	public static String getImageName(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos > -1) {
			return fileName.substring(0,pos);
		}
		return "";
	}

	//将inputStream转换成byte[]数组
	public static byte[] inputStreamToByte(InputStream inputStream){
		byte[] in = null;
		try{
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[1024];
			int length = 0;
			while ((length = inputStream.read(buff, 0, 1024)) > 0) {
				swapStream.write(buff, 0, length);
			}
			in = swapStream.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
		}
		return in;
	}


}
