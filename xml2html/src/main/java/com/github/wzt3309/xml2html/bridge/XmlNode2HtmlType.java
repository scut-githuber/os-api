package com.github.wzt3309.xml2html.bridge;
/**
 * 
 * @author wzt3309
 *
 */
public enum XmlNode2HtmlType {

	SIMPLE('0'),CLASSIC('1'),;
	private char typeNum;
	private XmlNode2HtmlType(char typeNum){
		this.typeNum=typeNum;
	}
	public char getTypeNum(){
		return typeNum;
	}
}
