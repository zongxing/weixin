package com.mashensoft.service.nenu;

public interface IMenuService {
	/**
	 * 处理消息
	 * @param content 客户端传递过来的xml文件
	 * @return 响应用户的xml
	 */
	public String handleMsg(String content);
}
