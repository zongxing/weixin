package com.mashensoft.service;

import com.mashensoft.model.TextMessage;
import com.mashensoft.model.VoiceMessage;
import com.mashensoft.util.AccessTokenUtil;
import com.mashensoft.util.VoiceUtil;
import com.mashensoft.util.XmlUtil;

public class VoiceMessageService implements IMessageService {

	@Override
	public String handleMsg(String content) {
		//获取声音对象
		VoiceMessage vm = XmlUtil.getVoiceMessage(content);
		String mediaId = vm.getMediaId();
		System.out.println("mediaId:    ="+mediaId);
		String token = AccessTokenUtil.getTokenFromWeixin();
		VoiceUtil.downloadVoice(token, mediaId);
		
		
		//回复用户，已上传成功
		String xmlContent = XmlUtil.createXmlTextMessage(content,"恭喜你：声音上传成功");
		return xmlContent;
	}

}
