package com.mashensoft.util;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VoiceUtil {
	public static void downloadVoice(String accessToken,String mediaId) {
		String voiceUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="+accessToken+"+&media_id="+mediaId;
		System.out.println("voiceUrl========="+voiceUrl);
		URL url;
		try {
			url = new URL(voiceUrl);
			URLConnection  conn = url.openConnection();
//			conn.setRequestProperty("Method","GET");
//			
//			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//			 conn.setDoInput(true);  
//		     conn.setDoOutput(true); 
			BufferedInputStream is = new BufferedInputStream(conn.getInputStream());
			
			byte cache[] = new byte[1024*1024];
			int len = 0;
			
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			String fileName = sd.format(new Date());
			FileOutputStream os = new FileOutputStream("D:\\pics2\\"+fileName+".amr");
			while((len=is.read(cache))!=-1) {
				os.write(cache,0,len);
				os.flush();
			}
			os.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
