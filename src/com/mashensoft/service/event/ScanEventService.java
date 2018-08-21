package com.mashensoft.service.event;

import com.mashensoft.model.event.ScanEvent;
import com.mashensoft.util.XmlUtil;

public class ScanEventService implements IEventService {

	@Override
	public String handleMsg(String content) {
		//要把客户端传递过来的xml解析出来
		ScanEvent scanEvent = this.getScanEvent(content);
		System.out.println("扫码的msgtype："+scanEvent.getMsgType());
		String xmlContent  = XmlUtil.createXmlTextMessage(content, "扫码成功");
		
		return xmlContent;
	}
	public ScanEvent getScanEvent(String content) {
		ScanEvent se = new ScanEvent();
		se.setToUserName(XmlUtil.getTagValue(content, "ToUserName"));
		se.setFromUserName(XmlUtil.getTagValue(content, "FromUserName"));
		se.setCreateTime(XmlUtil.getTagValue(content, "CreateTime"));
		se.setMsgType(XmlUtil.getTagValue(content, "MsgType"));
		se.setEvent(XmlUtil.getTagValue(content, "Event"));
		se.setEventKey(XmlUtil.getTagValue(content, "EventKey"));
		se.setTicket(XmlUtil.getTagValue(content, "Ticket"));
		return se;
		
	}
}
