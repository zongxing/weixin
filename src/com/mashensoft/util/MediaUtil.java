package com.mashensoft.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MediaUtil {
	public static void updateFile(String filepath) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token="+AccessTokenUtil.getTokenFromWeixin()+"&type=image";
		//String url = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+AccessTokenUtil.getTokenFromWeixin()+"&type=image";
		System.out.println(url);
		try {
			String content = NetworkUtil.updateFile(url, new FileInputStream(filepath),filepath);
			System.out.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
