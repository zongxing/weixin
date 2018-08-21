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
import com.mashensoft.model.event.ClickMenuEvent;
import com.mashensoft.service.IMessageService;
import com.mashensoft.service.ImageMessageService;
import com.mashensoft.service.LinkMessageService;
import com.mashensoft.service.LocationService;
import com.mashensoft.service.ShortVideoService;
import com.mashensoft.service.TextMessageService;
import com.mashensoft.service.VideoMessageService;
import com.mashensoft.service.VoiceMessageService;
import com.mashensoft.service.event.ClickMenuService;
import com.mashensoft.service.event.IEventService;
import com.mashensoft.service.event.LocationEventService;
import com.mashensoft.service.event.ScanEventService;
import com.mashensoft.service.event.SubscribeEventService;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getParameter("");
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "=" + value);
		}

		String echostr = request.getParameter("echostr");
		response.getWriter().append(echostr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从用户的输入里获取一个内容对象
		// 输出一个xml给微信公众号的服务器
		// 把tousername和fromusename反转一下
		String content = StringUtil.getContentFromInputStream(request.getInputStream());
		System.out.println(content);
		String event = XmlUtil.getEvent(content);

		String msgType = XmlUtil.getMsgType(content);

		String xmlContent = "";

		if (msgType.equals("event")) {
			IEventService eventService = null;
			if(event.equals("subscribe")||event.equals("unsubscribe")) {
				eventService = new SubscribeEventService();
				
			}else if(event.equals("SCAN")) {
				eventService = new ScanEventService();
			}else if(event.equals("LOCATION")) {
				eventService = new LocationEventService();
			}else if(event.equals("CLICK")||event.equals("VIEW")) {
				eventService = new ClickMenuService();
			}
			xmlContent  = eventService.handleMsg(content);
			
		} else {

			IMessageService messageService = null;
			if (msgType.equals("text")) {
				messageService = new TextMessageService();
			} else if (msgType.equals("image")) {
				// 当用户上传的是一个图片时
				messageService = new ImageMessageService();
			} else if (msgType.equals("voice")) {
				// 获取声音对象
				messageService = new VoiceMessageService();

			} else if (msgType.equals("video")) {
				messageService = new VideoMessageService();
			} else if (msgType.equals("shortvideo")) {
				messageService = new ShortVideoService();
			} else if (msgType.equals("location")) {
				messageService = new LocationService();
			} else if (msgType.equals("link")) {
				messageService = new LinkMessageService();
			}
			xmlContent = messageService.handleMsg(content);

		}
		System.out.println("--------------------------------------------");
		System.out.println("xmlContent==========" + xmlContent);
		response.getWriter().append(new String(xmlContent.getBytes(), "ISO-8859-1"));
		response.getWriter().flush();

	}

}
