package com.github.wzt3309.xml2html.xml;
/**
 * 常数类
 * @author wzt3309
 *
 */
public class XMLReaderConst {

	public static final String DEFAULT_XML_ROOT_PATH="xmlhome";
	public static final String DEFAULT_HTML_ROOT_PATH="htmlOut";
	public static final String DEFAULT_XML_NODE_ROOT_PREFIX="node_";
	/**
	 * 这个文件头以后可以直接用IO读入的方式
	 * 为测试方便先这样写死
	 */
	public static final String DEFAULT_HTML_HEAD="<html>\n"
										+"\t<head>\n\t\t<title>\n\t\t</title>\n"
										+ "\t\t<link src=''></link>\n\t\t<script href=''></script>"
										+ " \n\t</head>\n\t<body>\n";										
	public static final String DEFAULT_HTML_END="\t</body>\n</html>";
	public static final String DEFAULT_OUPUT_CHARSET="GBK";


													
}
