package com.biyao.common.util;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * @Author: hxs
 * @Description:Properties方法的二次封装
 * @Date:on 2017/9/8
 */
public class PropertiesHelper {

	public static Properties load(String fileName) throws IOException {
		Properties prop = new Properties();
		prop.load(PropertiesHelper.class.getResourceAsStream(fileName));
		return prop;
	}

//   /**
//    * 加载配置
//    * @param fileName
//    * @param u 编码方式
//    */
//	public static Properties load(String fileName, String u) throws IOException {
//		Properties prop = new Properties();
//		URL in = PropertiesHelper.class.getResource(fileName);
//
//		//将文件内容以UTF-8解码
//		FileInputStream fis = new FileInputStream(java.net.URLDecoder.decode(in.getFile(), "UTF-8"));
//		InputStreamReader isr = new InputStreamReader(fis, u);
//		prop.load(isr);
//		return prop;
//	}


	//对文件内容进行修改保存
	public static void update(String fileName, String key, String value)
			throws IOException, URISyntaxException {
		Properties prop = new Properties();
		File file = new File(fileName);
		InputStream fis = new FileInputStream(file);
		prop.load(fis);
		fis.close();
		OutputStream fos = new FileOutputStream(fileName);
		prop.setProperty(key, value);
		prop.store(fos, "");
		fos.close();
	}
}
