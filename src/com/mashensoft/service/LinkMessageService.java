package com.mashensoft.service;

import com.mashensoft.model.LinkMessage;
import com.mashensoft.model.TextMessage;
import com.mashensoft.util.XmlUtil;

public class LinkMessageService implements IMessageService {

	@Override
	public String handleMsg(String content) {
		String xmlContent = "";
		LinkMessage lm = XmlUtil.getLinkMessage(content);
		System.out.println(lm.getTitle());
		System.out.println(lm.getDescription());
		System.out.println(lm.getUrl());
		
		
		//回复用户，已上传成功
		xmlContent = XmlUtil.createXmlTextMessage(content,"恭喜你：连接发送成功");
		return xmlContent;
	}

}
