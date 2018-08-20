package com.mashensoft.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class AccessTokenUtil {
	public static String token;

	public static String getTokenFromWeixin() {
		if (token == null) {
			StringBuffer sb = new StringBuffer();
			try {
				URL url = new URL(
						"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc8c9e8d5b7cd7820&secret=b9140e159da0da66674d37653fcbb726");
				Scanner s = new Scanner(url.openStream());

				while (s.hasNextLine()) {
					sb.append(s.nextLine());
				}
				s.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JSONObject job = JSON.parseObject(sb.toString());
			token = (String) job.get("access_token");
			System.out.println("token:" + token);
		} else {
			return token;
		}
		return token;
	}
	
	
	
	
	public static void main(String[] args) {
		getTokenFromWeixin();
	}
}
