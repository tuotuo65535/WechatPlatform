package com.firs.wechat.handler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxUserList;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlHandler implements WxMessageHandler {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UrlHandler(HttpServletRequest request, HttpServletResponse response){
		super();
		this.request = request;
		this.response = response;
	}
	
    @Override
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
        String openid = wxMessage.getFromUserName();
        WxUserList.WxUser userInfo = iService.getUserInfoByOpenId(new WxUserList.WxUser.WxUserGet(openid, WxConsts.LANG_CHINA));
        try {
			this.request.getRequestDispatcher("index.html").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return WxXmlOutMessage.TEXT().content(userInfo.getNickname()).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
    }
}
