package com.mashensoft.service;

import com.mashensoft.model.TextMessage;
import com.mashensoft.model.VideoMessage;
import com.mashensoft.util.AccessTokenUtil;
import com.mashensoft.util.VideoUtil;
import com.mashensoft.util.XmlUtil;

public class VideoMessageService implements IMessageService {

	@Override
	public String handleMsg(String content) {
		VideoMessage vm = XmlUtil.getVideoMessage(content);
		String mediaId = vm.getMediaId();
		System.out.println("mediaId====="+mediaId);
		System.out.println("mediaId:    ="+mediaId);
		String token = AccessTokenUtil.getTokenFromWeixin();
		VideoUtil.downloadVoice(token, mediaId);
		
		
		//回复用户，已上传成功
		String xmlContent = XmlUtil.createXmlTextMessage(content,"恭喜你：视频上传成功");
		return xmlContent;
	}

}
