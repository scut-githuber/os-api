package com.github.wzt3309.xml2html.bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.github.wzt3309.xml2html.xml.XMLReaderConst;
/**
 * 
 * @author wzt3309
 *
 */
public class XmlNodeTree {	
	private XmlNode root;
	public XmlNodeTree(Element root){
		this.root=Ele2Node(root);
		this.root.setPrefix(XMLReaderConst
				.DEFAULT_XML_NODE_ROOT_PREFIX);
		this.root.setNum(1);
		createTree(this.root);
	}
	public XmlNodeTree(XmlNode root){
		this.root=root;
	}
	public void createTree(XmlNode parent){
		String prefix=parent.getChildPrefix();
		Iterator<XmlNode> it=parent.getChildNodes().iterator();
		int i=1;
		while(it.hasNext()){
			XmlNode child=it.next();
			child.setPrefix(prefix);
			child.setNum(i++);
			createTree(child);
		}
	}
	/**
	 * 传入策略，对XmlNodeTree所有XmlNode执行策略
	 * @param tree
	 * @param policy
	 */
	public static void policyXmlNodeTree(XmlNodeTree tree
			,XmlNodeTreePolicy policy){
		XmlNode root=tree.getRoot();
		policy.doWhat(root);
		Iterator<XmlNode> it=root.getChildNodes().iterator();
		while(it.hasNext()){
			XmlNode child=it.next();
			policyXmlNodeTree(new XmlNodeTree(child),policy);
		}
	}
	private XmlNode Ele2Node(Element element){
		XmlNode xmlNode=new XmlNode();
		List<XmlNode> childNodes=new ArrayList<XmlNode>();
		List<Attribute> itemAttrs= element.attributes();
		Map<String,String> itemAttrsMap=new HashMap<String,String>();
		for(Attribute attr:itemAttrs){
			itemAttrsMap.put(attr.getName(), attr.getValue());
		}
		xmlNode.setNodeName(element.getName());
		xmlNode.setNodeText(element.getText());
		xmlNode.setAttrs(itemAttrsMap);	
		Iterator<Element> it=element.elementIterator();
		while(it.hasNext()){
			Element ele=it.next();
			childNodes.add(Ele2Node(ele));
		}
		xmlNode.setChildNodes(childNodes);
		return xmlNode;
	}
	public XmlNode getRoot() {
		return root;
	}
	public void setRoot(XmlNode root) {
		this.root = root;
	}
	
	
}
