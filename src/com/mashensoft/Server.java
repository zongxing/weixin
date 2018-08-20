package com.mashensoft;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool.Location;

import com.mashensoft.model.AccessTokenModel;
import com.mashensoft.model.ImageMessage;
import com.mashensoft.model.LinkMessage;
import com.mashensoft.model.LocationMessage;
import com.mashensoft.model.TextMessage;
import com.mashensoft.model.VideoMessage;
import com.mashensoft.model.VoiceMessage;
import com.mashensoft.util.AccessTokenUtil;
import com.mashensoft.util.ImageUtil;
import com.mashensoft.util.StringUtil;
import com.mashensoft.util.VideoUtil;
import com.mashensoft.util.VoiceUtil;
import com.mashensoft.util.XmlUtil;


/**
 * Servlet implementation class Server
 */
@WebServlet("/Server")
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Server() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("");
		Enumeration<String>  enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = request.getParameter(name);
			System.out.println(name+"="+value);
		}
		
		String echostr = request.getParameter("echostr");
		response.getWriter().append(echostr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从用户的输入里获取一个内容对象
		//输出一个xml给微信公众号的服务器
		//把tousername和fromusename反转一下
		String content = StringUtil.getContentFromInputStream(request.getInputStream());
		System.out.println(content);
		String msgType = XmlUtil.getMsgType(content);

		String fromUseName = XmlUtil.getFromUserName(content);
		String toUseName = XmlUtil.getToUserName(content);
		String xmlContent = "";
		if(msgType.equals("text")) {
			TextMessage tm = XmlUtil.getTextMessage(content);
			System.out.println(System.currentTimeMillis());
			tm.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
			
			tm.setFromUserName(toUseName);
			tm.setToUserName(fromUseName);
			 xmlContent = XmlUtil.createXmlTextMessage(tm);
			//xmlContent = xmlContent.substring(39);
			System.out.println(xmlContent);
			
			
		}else if(msgType.equals("image")){
			//当用户上传的是一个图片时
			ImageMessage im = XmlUtil.getImageMessage(content);
			System.out.println(im.getMediaId());
			System.out.println(im.getPicUrl());
			ImageUtil.downloadPic(im.getPicUrl());
			//回复用户，已上传成功
			TextMessage tm = new TextMessage();
			tm.setContent("恭喜你：图片上传成功");
			tm.setFromUserName(toUseName);
			tm.setToUserName(fromUseName);
			tm.setMsgType("text");
			tm.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
			xmlContent = XmlUtil.createXmlTextMessage(tm);
			
//			im.setFromUserName(toUseName);
//			im.setToUserName(fromUseName);
//			xmlContent = XmlUtil.createImageMessage(im);
//			xmlContent = xmlContent.substring(39);
			
			
		}else if(msgType.equals("voice")) {
			//获取声音对象
			VoiceMessage vm = XmlUtil.getVoiceMessage(content);
			String mediaId = vm.getMediaId();
			System.out.println("mediaId:    ="+mediaId);
			String token = AccessTokenUtil.getTokenFromWeixin();
			VoiceUtil.downloadVoice(token, mediaId);
			
			
			//回复用户，已上传成功
			TextMessage tm = new TextMessage();
			tm.setContent("恭喜你：声音上传成功");
			tm.setFromUserName(toUseName);
			tm.setToUserName(fromUseName);
			tm.setMsgType("text");
			tm.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
			xmlContent = XmlUtil.createXmlTextMessage(tm);
			
		}else if(msgType.equals("video")) {
			VideoMessage vm = XmlUtil.getVideoMessage(content);
			String mediaId = vm.getMediaId();
			System.out.println("mediaId====="+mediaId);
			System.out.println("mediaId:    ="+mediaId);
			String token = AccessTokenUtil.getTokenFromWeixin();
			VideoUtil.downloadVoice(token, mediaId);
			
			
			//回复用户，已上传成功
			TextMessage tm = new TextMessage();
			tm.setContent("恭喜你：视频上传成功");
			tm.setFromUserName(toUseName);
			tm.setToUserName(fromUseName);
			tm.setMsgType("text");
			tm.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
			xmlContent = XmlUtil.createXmlTextMessage(tm);
		}else if(msgType.equals("shortvideo")) {
			VideoMessage vm = XmlUtil.getVideoMessage(content);
			String mediaId =vm.getMediaId();
			String token = AccessTokenUtil.getTokenFromWeixin();
			VideoUtil.downloadVoice(token, mediaId);
			
			
			//回复用户，已上传成功
			TextMessage tm = new TextMessage();
			tm.setContent("恭喜你：小视频上传成功");
			tm.setFromUserName(toUseName);
			tm.setToUserName(fromUseName);
			tm.setMsgType("text");
			tm.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
			xmlContent = XmlUtil.createXmlTextMessage(tm);
		}else if(msgType.equals("location")) {
			LocationMessage lm  = XmlUtil.getLocationMessage(content);
			System.out.println(lm.getLocation_X());
			System.out.println(lm.getLocation_Y());
			
		}else if(msgType.equals("link")) {
			LinkMessage lm = XmlUtil.getLinkMessage(content);
			System.out.println(lm.getTitle());
			System.out.println(lm.getDescription());
			System.out.println(lm.getUrl());
		}
		System.out.println("--------------------------------------------");
		System.out.println("xmlContent=========="+xmlContent);
		response.getWriter().append(new String(xmlContent.getBytes(),"ISO-8859-1"));
		response.getWriter().flush();
		
		
		
	}

}
