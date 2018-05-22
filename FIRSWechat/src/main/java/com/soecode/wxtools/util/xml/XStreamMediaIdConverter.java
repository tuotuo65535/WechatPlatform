package com.soecode.wxtools.util.xml;

/**
 * MediaId 转换器
 */
public class XStreamMediaIdConverter extends XStreamCDataConverter {
	@Override
	public String toString(Object obj) {
		return "<MediaId>" + super.toString(obj) + "</MediaId>";
	}
}
