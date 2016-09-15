package com.github.wzt3309.xml2html.bridge;

import java.io.File;

import com.github.wzt3309.xml2html.html.ClassicParseHtml;
import com.github.wzt3309.xml2html.html.DefaultParseHtml;
import com.github.wzt3309.xml2html.html.SimpleParseHtml;
/**
 * 
 * @author wzt3309
 *
 */
public class XmlNode2HtmlPolicyFactory {

	public static XmlNode2HtmlPolicy getXmlNode2HtmlPolicy(XmlNode2HtmlType type,File outPutFile){		
		switch(type){
			case SIMPLE:return new SimpleParseHtml(outPutFile);
			case CLASSIC:return new ClassicParseHtml();
			default:return new DefaultParseHtml();
		}
	}
}
