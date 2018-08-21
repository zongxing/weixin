package com.mashensoft.service;

import com.mashensoft.model.LocationMessage;
import com.mashensoft.util.XmlUtil;

public class LocationService implements IMessageService {

	@Override
	public String handleMsg(String content) {
		LocationMessage lm  = XmlUtil.getLocationMessage(content);
		System.out.println(lm.getLocation_X());
		System.out.println(lm.getLocation_Y());
		String xmlContent = XmlUtil.createXmlTextMessage(content,"连接发送成功");
		return xmlContent;
	}

}
