package com.mashensoft.model;
/**
 * ToUserName	开发者微信号
FromUserName	发送方帐号（一个OpenID）
CreateTime	消息创建时间 （整型）
MsgType	语音为voice
MediaId	语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
Format	语音格式，如amr，speex等
MsgID	消息id，64位整型
 * @author zongx
 *
 */
public class VoiceMessage {
	private String toUserName;
	private String fromUserName;
	private String createTime;
	private String msgType;
	private String mediaId;
	private String format;
	private String msgId;
	public String getToUserName() {
		return toUserName;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}


	
}
