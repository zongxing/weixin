package com.mashensoft.model;

/*
 *
 * <xml><br>
 * <ToUserName>< ![CDATA[toUser] ]></ToUserName><br>
 * <FromUserName>< ![CDATA[fromUser] ]></FromUserName><br>
 * <CreateTime>1351776360</CreateTime><br>
 * <MsgType>< ![CDATA[location] ]></MsgType><br>
 * <Location_X>23.134521</Location_X><br>
 * <Location_Y>113.358803</Location_Y><br>
 * <Scale>20</Scale><Label><br>
 * < ![CDATA[位置信息] ]></Label><br>
 * <MsgId>1234567890123456</MsgId><br>
 * </xml>
参数	描述
ToUserName	开发者微信号
FromUserName	发送方帐号（一个OpenID）
CreateTime	消息创建时间 （整型）
MsgType	location
Location_X	地理位置维度
Location_Y	地理位置经度
Scale	地图缩放大小
Label	地理位置信息
MsgId	消息id，64位整型
 */
public class LocationMessage extends Message {
	private String Location_X;
	private String Location_Y;
	private String scale;
	private String label;

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
