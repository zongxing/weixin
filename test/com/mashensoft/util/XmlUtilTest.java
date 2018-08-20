package com.mashensoft.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mashensoft.model.TextMessage;

class XmlUtilTest {

	@Test
	void testCreateXmlTextMessage() {
		TextMessage tm = new TextMessage();
		tm.setContent("aaaaaaaaa");;
		tm.setCreateTime("aaaa");
		tm.setFromUserName("aaaa");
		tm.setMsgType("text");
		tm.setToUserName("aaaaaa");
		String content = XmlUtil.createXmlTextMessage(tm);
		
	}

}
