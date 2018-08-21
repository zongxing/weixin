package com.mashensoft.service.event;

import com.mashensoft.model.event.SubscribeEvent;
import com.mashensoft.util.XmlUtil;

public class SubscribeEventService implements IEventService{

	@Override
	public String handleMsg(String content) {
		SubscribeEvent se  = this.geSubscribeEvent(content);
		System.out.println("关注事件："+se.getEvent());
		String xmlContent = "";
		if(se.getEvent().equals("subscribe")) {
			xmlContent  = XmlUtil.createXmlTextMessage(content, "新，您已关注成功，新尽快领取一个大礼包，礼包里有红枣，核桃！！！");
			
		}else {
			xmlContent  = XmlUtil.createXmlTextMessage(content, "取消关注成功");
		}
		return xmlContent;
	}
	
	public SubscribeEvent geSubscribeEvent(String content) {
		SubscribeEvent se = new SubscribeEvent();
		se.setCreateTime(XmlUtil.getTagValue(content, "CreateTime"));;
		se.setEvent(XmlUtil.getTagValue(content, "Event"));;
		se.setFromUserName((XmlUtil.getTagValue(content, "FromUserName")));
		se.setToUserName((XmlUtil.getTagValue(content, "ToUserName")));
		se.setMsgType(XmlUtil.getTagValue(content, "MsgType"));
		return se;
	}

}
