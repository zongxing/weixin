package com.mashensoft.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import org.dom4j.CDATA;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.mashensoft.model.ImageMessage;
import com.mashensoft.model.LinkMessage;
import com.mashensoft.model.LocationMessage;
import com.mashensoft.model.TextMessage;
import com.mashensoft.model.VideoMessage;
import com.mashensoft.model.VoiceMessage;

public class XmlUtil {
	/**
	 * 从一个xml文本内容里获取一个对象TextMessage出来 内部使用dom4j
	 * 
	 * @param xmlContent
	 *            xml内容
	 * @return
	 */
	public static TextMessage getTextMessage(InputStream is) {
		TextMessage tm = new TextMessage();
		// 使用dom4j来读取内容

		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(is);
			Element root = doc.getRootElement();
			tm.setToUserName(root.element("ToUserName").getStringValue());
			tm.setFromUserName(root.element("FromUserName").getStringValue());
			tm.setCreateTime(root.element("CreateTime").getStringValue());
			tm.setMsgType(root.element("MsgType").getStringValue());
			tm.setContent(root.element("Content").getStringValue());
			tm.setMsgId(root.element("MsgId").getStringValue());
		} catch (DocumentException e) {

			e.printStackTrace();
		}
		return tm;
	}
	public static TextMessage getTextMessage(String content) {
		TextMessage tm = new TextMessage();
		// 使用dom4j来读取内容
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			tm.setToUserName(root.element("ToUserName").getStringValue());
			tm.setFromUserName(root.element("FromUserName").getStringValue());
			tm.setCreateTime(root.element("CreateTime").getStringValue());
			tm.setMsgType(root.element("MsgType").getStringValue());
			tm.setContent(root.element("Content").getStringValue());
			tm.setMsgId(root.element("MsgId").getStringValue());
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		return tm;
	}

	public static String createXmlTextMessage(TextMessage tm) {
		String xmlContent = "";
		Document doc = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("xml");
		Element toUserName = DocumentHelper.createElement("ToUserName");
		CDATA toUserNameCData = DocumentHelper.createCDATA(tm.getToUserName());
		toUserName.add(toUserNameCData);
		root.add(toUserName);
		doc.add(root);// 只需要执行一次
		// 依此类推，把其他的元素建好

		Element fromUserName = DocumentHelper.createElement("FromUserName");
		CDATA fromUserNameCData = DocumentHelper.createCDATA(tm.getFromUserName());
		fromUserName.add(fromUserNameCData);
		root.add(fromUserName);
		//
		root.add(DocumentHelper.createElement("CreateTime").addText(tm.getCreateTime()));
		//MsgType
		//root.add(DocumentHelper.createElement("MsgType").addText(tm.getMsgType()));
		
		Element msgType = DocumentHelper.createElement("MsgType");
		CDATA msgTypeCData = DocumentHelper.createCDATA(tm.getMsgType());
		msgType.add(msgTypeCData);
		root.add(msgType);
		
		
		//
		Element content = DocumentHelper.createElement("Content");
		CDATA contentCData = DocumentHelper.createCDATA(tm.getContent());
		content.add(contentCData);
		root.add(content);
		try {
			//把内容写到StringWriter中
			StringWriter sw = new StringWriter();
			XMLWriter writer = new XMLWriter(sw,OutputFormat.createPrettyPrint());
			writer.write(doc);
			System.out.println(sw.toString());
			xmlContent = sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xmlContent;
	}
	
	public static ImageMessage getImageMessage(String  content) {
		ImageMessage im = new ImageMessage();
		// 使用dom4j来读取内容

		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			im.setToUserName(root.element("ToUserName").getStringValue());
			im.setFromUserName(root.element("FromUserName").getStringValue());
			im.setCreateTime(root.element("CreateTime").getStringValue());
			im.setMsgType(root.element("MsgType").getStringValue());
			im.setPicUrl(root.element("PicUrl").getStringValue());
			im.setMediaId(root.element("MediaId").getStringValue());
			im.setMsgId(root.element("MsgId").getStringValue());
		} catch (DocumentException e) {

			e.printStackTrace();
		}
		
		return im;
	}
	public static String getMsgType(String content) {
		String msgType = "";
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			msgType = root.element("MsgType").getStringValue();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return msgType;
	}
	public static String getToUserName(String content) {
		String str = "";
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			str = root.element("ToUserName").getStringValue();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return str;
	}
	public static String getFromUserName(String content) {
		String str = "";
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			str = root.element("FromUserName").getStringValue();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return str;
	}
	public static String createImageMessage(ImageMessage im) {
		String xmlContent = "";
		
		Document doc = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("xml");
		Element toUserName = DocumentHelper.createElement("ToUserName");
		CDATA toUserNameCData = DocumentHelper.createCDATA(im.getToUserName());
		toUserName.add(toUserNameCData);
		root.add(toUserName);
		doc.add(root);// 只需要执行一次
		// 依此类推，把其他的元素建好

		Element fromUserName = DocumentHelper.createElement("FromUserName");
		CDATA fromUserNameCData = DocumentHelper.createCDATA(im.getFromUserName());
		fromUserName.add(fromUserNameCData);
		root.add(fromUserName);
		//
		root.add(DocumentHelper.createElement("CreateTime").addText(im.getCreateTime()));
		//MsgType
		//root.add(DocumentHelper.createElement("MsgType").addText(tm.getMsgType()));
		
		Element msgType = DocumentHelper.createElement("MsgType");
		CDATA msgTypeCData = DocumentHelper.createCDATA(im.getMsgType());
		msgType.add(msgTypeCData);
		root.add(msgType);
		
		//
		Element mediaId = DocumentHelper.createElement("MediaId");
		CDATA mediaIdCData = DocumentHelper.createCDATA(im.getMediaId());
		mediaId.add(mediaIdCData);
		root.add(mediaId);
		
		try {
			//把内容写到StringWriter中
			StringWriter sw = new StringWriter();
			XMLWriter writer = new XMLWriter(sw,OutputFormat.createPrettyPrint());
			writer.write(doc);
			xmlContent = sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return xmlContent;
	}

	public static VoiceMessage getVoiceMessage(String content) {
		VoiceMessage vm = new VoiceMessage();
		
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			vm.setToUserName(root.element("ToUserName").getStringValue());
			vm.setFromUserName(root.element("FromUserName").getStringValue());
			vm.setCreateTime(root.element("CreateTime").getStringValue());
			vm.setMsgType(root.element("MsgType").getStringValue());
			vm.setMsgId(root.element("MsgId").getStringValue());
			vm.setFormat(root.element("Format").getStringValue());
			vm.setMediaId(root.element("MediaId").getStringValue());
		} catch (DocumentException e) {

			e.printStackTrace();
		}
		
		return vm;
	}
	public static  VideoMessage getVideoMessage(String content) {
		VideoMessage vm = new VideoMessage();

		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			vm.setToUserName(root.element("ToUserName").getStringValue());
			vm.setFromUserName(root.element("FromUserName").getStringValue());
			vm.setCreateTime(root.element("CreateTime").getStringValue());
			vm.setMsgType(root.element("MsgType").getStringValue());
			vm.setMsgId(root.element("MsgId").getStringValue());
			vm.setThumbMediaId(root.element("ThumbMediaId").getStringValue());
			vm.setMediaId(root.element("MediaId").getStringValue());
		} catch (DocumentException e) {

			e.printStackTrace();
		}
		
		return vm;
	}
	public static  LocationMessage getLocationMessage(String content) {
		LocationMessage vm = new LocationMessage();
		
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			vm.setToUserName(root.element("ToUserName").getStringValue());
			vm.setFromUserName(root.element("FromUserName").getStringValue());
			vm.setCreateTime(root.element("CreateTime").getStringValue());
			vm.setMsgType(root.element("MsgType").getStringValue());
			vm.setMsgId(root.element("MsgId").getStringValue());
			vm.setLocation_X(root.element("Location_X").getStringValue());
			vm.setLocation_Y(root.element("Location_Y").getStringValue());
			vm.setLocation_Y(root.element("Location_Y").getStringValue());
			vm.setScale(root.element("Scale").getStringValue());
			vm.setLabel(root.element("Label").getStringValue());
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		return vm;
	}
	public static  LinkMessage getLinkMessage(String content) {
		LinkMessage vm = new LinkMessage();
		
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(content.getBytes()));
			Element root = doc.getRootElement();
			vm.setToUserName(root.element("ToUserName").getStringValue());
			vm.setFromUserName(root.element("FromUserName").getStringValue());
			vm.setCreateTime(root.element("CreateTime").getStringValue());
			vm.setMsgType(root.element("MsgType").getStringValue());
			vm.setMsgId(root.element("MsgId").getStringValue());
			vm.setTitle(root.element("Title").getStringValue());
			vm.setDescription(root.element("Description").getStringValue());
			vm.setUrl(root.element("Url").getStringValue());
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		return vm;
	}
	
}
