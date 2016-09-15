package com.github.wzt3309.xml2html.html;

import java.io.File;
import java.util.List;

import com.github.wzt3309.xml2html.bridge.XmlNode2HtmlPolicy;
import com.github.wzt3309.xml2html.bridge.XmlNode2HtmlPolicyFactory;
import com.github.wzt3309.xml2html.bridge.XmlNode2HtmlType;
import com.github.wzt3309.xml2html.bridge.XmlNodeTree;
import com.github.wzt3309.xml2html.xml.XMLFinder;
import com.github.wzt3309.xml2html.xml.XMLReader;
import com.github.wzt3309.xml2html.xml.XMLReaderConst;
/**
 * Main方法入口
 * @author wzt3309
 *
 */
public class Xml2Html {	
	
	public static void doXml2Html(String filePath,XmlNodeTree xmlNodeTree,XmlNode2HtmlType type){
		XmlNode2HtmlPolicy policy=XmlNode2HtmlPolicyFactory.getXmlNode2HtmlPolicy(type
				,new File(filePath));
		XmlNodeTree.policyXmlNodeTree(xmlNodeTree, policy);
		policy.writeHtml();
	}
	public static void main(String[] args){
		List<File> xmlFiles=XMLFinder.getAllXMLFile();
		for(File xmlFile:xmlFiles){
			XMLReader reader=new XMLReader(xmlFile);			
			doXml2Html(XMLFinder.newHtmlPath(xmlFile)
					,reader.getXmlNodeTree(reader.getRoot()),XmlNode2HtmlType.SIMPLE);
		}
		
	}
}
