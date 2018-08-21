package com.mashensoft.service;

import com.mashensoft.model.ImageMessage;
import com.mashensoft.util.ImageUtil;
import com.mashensoft.util.XmlUtil;

public class ImageMessageService implements IMessageService {

	@Override
	public String handleMsg(String content) {
		ImageMessage im = XmlUtil.getImageMessage(content);
		System.out.println(im.getMediaId());
		System.out.println(im.getPicUrl());
		ImageUtil.downloadPic(im.getPicUrl());
		//回复用户，已上传成功
		String xmlContent = XmlUtil.createXmlTextMessage(content,"恭喜你：图片上传成功");
		return xmlContent;
	}

}
