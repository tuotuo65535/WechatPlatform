package com.firs.wechat.matcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.StringUtils;

public class UrlMatcher implements WxMessageMatcher{

    @Override
    public boolean match(WxXmlMessage message) {
        if(StringUtils.isNotEmpty(message.getContent())){
            if(message.getContent().equals("跳转")){
                return true;
            }
        }
        return false;
    }

}
