package com.mashensoft.model;

/**
 * <xml><ToUserName>< ![CDATA[toUser] ]></ToUserName> <br>
 * <FromUserName>< ![CDATA[fromUser] ]></FromUserName> <br>
 * <CreateTime>1357290913</CreateTime> <br>
 * <MsgType>< ![CDATA[video] ]></MsgType> <br>
 * <MediaId>< ![CDATA[media_id] ]></MediaId> <br>
 * <ThumbMediaId>< ![CDATA[thumb_media_id] ]></ThumbMediaId> <br>
 * <MsgId>1234567890123456</MsgId></xml> <br>
 * 
 * @author zongx
 *
 */
public class VideoMessage extends Message {
	private String mediaId;
	private String thumbMediaId;
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	

}
