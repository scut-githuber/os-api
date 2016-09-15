package com.github.wzt3309.xml2html.bridge;

/**
 * 策略模式，遍历XmlNodeTree,执行相关工作
 * @author wzt3309
 *
 */
public interface XmlNodeTreePolicy {
	public void doWhat(XmlNode xmlNode);
}
