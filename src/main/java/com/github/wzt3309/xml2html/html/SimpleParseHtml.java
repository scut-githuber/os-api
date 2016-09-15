package com.github.wzt3309.xml2html.html;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import com.github.wzt3309.xml2html.bridge.XmlNode;
import com.github.wzt3309.xml2html.bridge.XmlNode2HtmlPolicy;
import com.github.wzt3309.xml2html.xml.XMLReaderConst;
/**
 * 
 * @author wzt3309
 *
 */
public class SimpleParseHtml implements XmlNode2HtmlPolicy {
	private StringBuffer content=new StringBuffer();
	private File outPutFile;
	public SimpleParseHtml(File outPutFile){
		this.outPutFile=outPutFile;
		if(!this.outPutFile.exists())
			try {
				this.outPutFile.createNewFile();
			} catch (IOException e) {				
				e.printStackTrace();
			}
	}
	@Override
	public void doWhat(XmlNode xmlNode) {
		int level=xmlNode.getNodeLevel();
		String name =xmlNode.getNodeName();
		String id=xmlNode.getNodeIdName();
		String className=xmlNode.getNodeClassName();
		String text=xmlNode.getNodeText();
		Map<String,String> attrs=xmlNode.getAttrs();
		
		StringBuffer buf=null,buf1,buf2;				
		buf=new StringBuffer();
		buf1=new StringBuffer();
		buf2=new StringBuffer();			
		buf1.append("<a id='text_"+id+"' class='text "+className+"'>"+text+"</a>");
		if(attrs!=null&&attrs.size()>0){
			buf2.append("<a id='attr_"+id+"' class='attr "+className+"'>"+attrs+"</a>");
		}
		switch(level){
			case 2:buf.append("<h1 id='"+id+"' class='"+className+"'>@"+name+":"+buf1+buf2+"</h1>");break;
			case 3:buf.append("<h2 id='"+id+"' class='"+className+"'>@"+name+":"+buf1+buf2+"</h2>");break;
			case 4:buf.append("<h3 id='"+id+"' class='"+className+"'>@"+name+":"+buf1+buf2+"</h3>");break;
			case 5:buf.append("<h4 id='"+id+"' class='"+className+"'>@"+name+":"+buf1+buf2+"</h4>");break;
			case 6:buf.append("<h5 id='"+id+"' class='"+className+"'>@"+name+":"+buf1+buf2+"</h5>");break;
			default:;
		}
	
		if(buf!=null&&buf.length()>0){	
			content.append("\t\t"+buf+"\n");
			System.out.println(buf);
		}
			
	}

	@Override
	public void writeHtml() {
		StringBuffer html=new StringBuffer(XMLReaderConst.DEFAULT_HTML_HEAD);
		html=html.append(content);
		html=html.append(XMLReaderConst.DEFAULT_HTML_END);
		FileOutputStream out=null;
		try {			
			out=new FileOutputStream(outPutFile);
			out.write(html.toString().getBytes(XMLReaderConst.DEFAULT_OUPUT_CHARSET));
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}catch (IOException e) {			
			e.printStackTrace();
		}finally{
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
		}
		
		
	}

}
