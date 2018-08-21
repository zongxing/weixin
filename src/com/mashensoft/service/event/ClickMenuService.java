package com.mashensoft.service.event;

import com.mashensoft.model.event.ClickMenuEvent;
import com.mashensoft.model.event.LocationEvent;
import com.mashensoft.util.XmlUtil;

public class ClickMenuService implements IEventService {

	@Override
	public String handleMsg(String content) {
		ClickMenuEvent cm = this.getClickMenuEvent(content);
		System.out.println(cm.getEventKey());
		String xmlContent  = "";
		if(cm.getMsgType().equals("CLICK")) {
			 xmlContent  = XmlUtil.createXmlTextMessage(content, "您的点击了菜单:eventkey:"+cm.getEventKey());
			
		}else {
			 xmlContent  = XmlUtil.createXmlTextMessage(content, "您的点击了链接:eventkey:"+cm.getEventKey());
		}
		
		return xmlContent;
	}
	
	public ClickMenuEvent getClickMenuEvent(String content) {
		ClickMenuEvent se = new ClickMenuEvent();
		se.setToUserName(XmlUtil.getTagValue(content, "ToUserName"));
		se.setFromUserName(XmlUtil.getTagValue(content, "FromUserName"));
		se.setCreateTime(XmlUtil.getTagValue(content, "CreateTime"));
		se.setMsgType(XmlUtil.getTagValue(content, "MsgType"));
		se.setEvent(XmlUtil.getTagValue(content, "Event"));
		se.setEventKey(XmlUtil.getTagValue(content, "EventKey"));
		return se;
		
	}

}
