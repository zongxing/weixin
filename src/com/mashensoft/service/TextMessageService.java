package com.mashensoft.service;

import com.mashensoft.model.TextMessage;
import com.mashensoft.util.XmlUtil;

public class TextMessageService implements IMessageService{

	@Override
	public String handleMsg(String content) {
		TextMessage tm = XmlUtil.getTextMessage(content);
		String textContent = tm.getContent();
		String xmlContent = XmlUtil.createXmlTextMessage(content,"您说的是："+textContent);
		return xmlContent;
	}
}
