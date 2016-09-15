package com.github.wzt3309.xml2html.xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.github.wzt3309.xml2html.bridge.XmlNode;
import com.github.wzt3309.xml2html.bridge.XmlNodeTree;
import com.github.wzt3309.xml2html.html.PrintXmlNodeTree;
/**
 * 
 * @author wzt3309
 *
 */
public class XMLReader {	
	private File xmlFile;	
	private StringBuffer xmlContent;	
	
	public XMLReader(File xmlFile){		
		this.xmlFile=xmlFile;		
	}
	public XMLReader(String xmlPath){		
		this.xmlFile=new File(xmlPath);
	}
	public XMLReader(StringBuffer xmlContent){		
		this.xmlContent=xmlContent;
	}
	
	private Document getDocument(){
		SAXReader reader = new SAXReader();
		Document doc=null;
		try{
			if(xmlFile!=null){
				doc=reader.read(xmlFile);
			}else if(xmlContent!=null&&xmlContent.length()>0){
				doc=DocumentHelper.parseText(xmlContent.toString());
			}
		}catch(DocumentException e){
			e.printStackTrace();
		}
		return doc;
	}
	
	public Element getRoot(){
		Element root=null;
		Document doc=getDocument();
		if(doc!=null){
			root=doc.getRootElement();
		}		
		return root;
	}
	public XmlNodeTree getXmlNodeTree(Element ele){
		return new XmlNodeTree(ele);
	}
	public void printXmlNodeTree(){
		XmlNodeTree tree=getXmlNodeTree(getRoot());
		XmlNodeTree.policyXmlNodeTree(tree, new PrintXmlNodeTree());
	}	
//	public static void main(String[] args){
//		XMLReader reader=new XMLReader("xmlhome/example.xml");
//		reader.printXmlNodeTree();
//	}
}
