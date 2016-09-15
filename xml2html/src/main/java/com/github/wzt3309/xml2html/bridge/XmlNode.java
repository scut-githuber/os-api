package com.github.wzt3309.xml2html.bridge;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author wzt3309
 *
 */
public class XmlNode {
	
	private String nodeName;
	private String nodeText;
	private List<XmlNode> childNodes;
	private Map<String,String> attrs;
	private String prefix;	//节点位置序号前缀
	private int num;	//节点在同一父节点下的序号	
	
	public XmlNode(){
		
	}
	public XmlNode(String prefix,int num){
		this.prefix=prefix;
		this.num=num;
	}
	public XmlNode(String prefix,int num,String nodeName
			,String nodeText,Map<String,String>attrs,List<XmlNode> childNodes){
		this(prefix,num);
		this.nodeName=nodeName;
		this.nodeText=nodeText;
		this.attrs=attrs;
		this.childNodes=childNodes;
	}
	public XmlNode(String prefix,int num,String nodeName
			,String nodeText,Map<String,String>attrs){
		this(prefix,num,nodeName,nodeText,attrs,null);
	}
	public XmlNode(String prefix,int num,String nodeName,String nodeText){
		this(prefix,num,nodeName,nodeText,null);
	}
	public XmlNode(String prefix,int num,String nodeName){
		this(prefix,num,nodeName,null);
	}	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeText() {
		return nodeText.replaceAll("\\s", "");
	}
	public void setNodeText(String nodeText) {
		this.nodeText = nodeText;
	}
	public List<XmlNode> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<XmlNode> childNodes) {
		this.childNodes = childNodes;
	}
	public Map<String, String> getAttrs() {
		return attrs;
	}
	public void setAttrs(Map<String, String> attrs) {
		this.attrs = attrs;
	}
	public String getChildPrefix(){
		return prefix+num+"_";
	}	
	public int getNodeLevel(){
		int level=0;
		Pattern p=Pattern.compile("_");
		Matcher m=p.matcher(getNodeIdName());
		while(m.find()){
			level++;
		}
		return level;
	}
	public String getNodeClassName(){
		StringBuffer buf=new StringBuffer();
		buf.append("level_"+getNodeLevel());
		buf.append(" "+getNodeName());
		return buf.toString();
		
	}
	public String getNodeIdName(){
		return prefix+num;
	}
}
