package com.github.wzt3309.xml2html.html;

import com.github.wzt3309.xml2html.bridge.XmlNode;
import com.github.wzt3309.xml2html.bridge.XmlNodeTreePolicy;
/**
 * 
 * @author wzt3309
 *
 */
public class PrintXmlNodeTree implements XmlNodeTreePolicy {

	@Override
	public void doWhat(XmlNode xmlNode) {
		System.out.format("level %-5d\t", xmlNode.getNodeLevel());
		System.out.format("class %-20s\t", xmlNode.getNodeClassName());
		System.out.format("id %-10s\t", xmlNode.getNodeIdName());
		System.out.format("Name: %s,Text: %s,Attributes: [%s]\r\n"
				, xmlNode.getNodeName(),xmlNode.getNodeText(),xmlNode.getAttrs());

	}

}
