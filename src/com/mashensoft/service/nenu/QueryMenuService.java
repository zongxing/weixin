package com.mashensoft.service.nenu;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.mashensoft.model.menu.Button;
import com.mashensoft.model.menu.Menu;
import com.mashensoft.model.menu.MenuResponse;
import com.mashensoft.model.menu.SubButton;
import com.mashensoft.util.AccessTokenUtil;
import com.mashensoft.util.NetworkUtil;

public class QueryMenuService implements IMenuService{

	@Override
	public String handleMsg(String content) {
		
		return null;
	}
	public String getMenuContent() {
		String token = AccessTokenUtil.getTokenFromWeixin();
		
		String weburl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token="+token;
		String content = NetworkUtil.getContentFromUrlByGet(weburl);
		return content;
	}
	public Menu getMenu() {
		String content = this.getMenuContent();
		
		MenuResponse mr = JSON.parseObject(content, MenuResponse.class);
		
		return mr.getMenu();
	}
	public  void createMenu() {
		String token = AccessTokenUtil.getTokenFromWeixin();
		String weburl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token;
		//MenuResponse mr = new MenuResponse();
		Menu menu = new Menu();
		Button button = new Button();
		button.setName("按钮1");
		button.setType("click");
		button.setKey("test_click_1");
		button.setSub_button(null);
		
		List<SubButton> subList1 = new ArrayList();
		SubButton sb1 = new SubButton();
		sb1.setName("微信相册发图");
		sb1.setType("pic_weixin");
		sb1.setKey("sub_button_1");
		//sb1.setSub_button(null);
		subList1.add(sb1);
		button.setSub_button(subList1);
		
		Button button2 = new Button();
		button2.setName("baidu");
		button2.setType("view");
		button2.setUrl("https://www.baidu.com");;
		button2.setSub_button(null);
		
		
//		Button button3 = new Button();
//		button3.setName("扫码");
//		button3.setType("scancode_push");
//		button3.setSub_button(null);
//		button3.setKey("button_key3");
		
		Button button4 = new Button();
		button4.setName("拍照");
		button4.setType("pic_sysphoto");
		button4.setSub_button(null);
		button4.setKey("button_key4");
		
		
		List<Button> list = new ArrayList<>();
		list.add(button);
		list.add(button2);
		//list.add(button3);
		list.add(button4);
		menu.setButton(list);
		//mr.setMenu(menu);
		
		String jsonString = JSON.toJSONString(menu);
		System.out.println(jsonString);
		String content = NetworkUtil.getContentFromUrlByPost(weburl,jsonString);
		System.out.println(content);
	}
	public static void main(String[] args) {
		QueryMenuService qs = new QueryMenuService();
//		String content = qs.getMenuContent();
//		System.out.println(content);
//		Menu menu = qs.getMenu();
//		System.out.println(menu.getButton().size());
		qs.createMenu();
	}

}
