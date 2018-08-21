package com.mashensoft.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class NetworkUtil {
	public static String getContentFromUrlByPost(String weburl,String params) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(weburl);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			PrintWriter  pw    = new PrintWriter(conn.getOutputStream());
			pw.write(params);
			pw.flush();
			Scanner s = new Scanner(conn.getInputStream());
			
			while(s.hasNextLine()) {
				sb.append(s.nextLine());
			}
			s.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	public static String getContentFromUrlByGet(String weburl) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(weburl);
			URLConnection conn = url.openConnection();
			Scanner s = new Scanner(conn.getInputStream());
			while(s.hasNextLine()) {
				sb.append(s.nextLine());
			}
			s.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
