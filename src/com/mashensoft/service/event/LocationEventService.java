package com.mashensoft.service.event;

import com.mashensoft.model.event.LocationEvent;
import com.mashensoft.model.event.ScanEvent;
import com.mashensoft.util.XmlUtil;

public class LocationEventService implements IEventService {

	@Override
	public String handleMsg(String content) {
		LocationEvent le  = this.getLocationEvent(content);
		
		System.out.println(le.getLatitude());
		System.out.println(le.getLongitude());
		String xmlContent  = XmlUtil.createXmlTextMessage(content, "您的地理位置纬度"+le.getLatitude()+"经度:"+le.getLongitude());
		return xmlContent;
	}
	public LocationEvent getLocationEvent(String content) {
		LocationEvent se = new LocationEvent();
		se.setToUserName(XmlUtil.getTagValue(content, "ToUserName"));
		se.setFromUserName(XmlUtil.getTagValue(content, "FromUserName"));
		se.setCreateTime(XmlUtil.getTagValue(content, "CreateTime"));
		se.setMsgType(XmlUtil.getTagValue(content, "MsgType"));
		se.setEvent(XmlUtil.getTagValue(content, "Event"));
		se.setLongitude((XmlUtil.getTagValue(content, "Longitude")));
		se.setLatitude((XmlUtil.getTagValue(content, "Latitude")));
		se.setPrecision(XmlUtil.getTagValue(content, "Precision"));
		return se;
		
	}
	
	

}
