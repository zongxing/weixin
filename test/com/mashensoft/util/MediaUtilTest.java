package com.mashensoft.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MediaUtilTest {

	@Test
	void testUpdateFile() {
		MediaUtil.updateFile("C:/Users/zongx/Desktop/a.jpg");
	}

	@Test
	void testUpdateFile3() {
		VoiceUtil.downloadPic(AccessTokenUtil.getTokenFromWeixin(), "H-d92fL1YEdSJnP1sASY-X9US9tmlVwmQF-5fa8249omnzgRsL1ddLuVS0YYkQma");
		//		VoiceUtil.downloadPic(AccessTokenUtil.getTokenFromWeixin(), "5iYwvH5jEHRMAyBqdZmr1fNryJNZlxmlpVcieQsBzHe1L_EqvQMgJVDLlUE7CLkh");
	}

}
