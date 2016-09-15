package com.github.wzt3309.xml2html.xml;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/**
 * 
 * @author wzt3309
 *
 */
public class XMLFinder {

	/**
	 * 返回当前File下名字符合条件的目录或文件
	 * @param dir
	 * @param regex
	 * @return
	 */
	public static File[] local(File dir,final String... regex){
		if(regex.length==0){
			return dir.listFiles();
		}else{
			return dir.listFiles(new FilenameFilter(){
				private Pattern p=Pattern.compile(regex[0]);
				public boolean accept(File dir,String name){
					return p.matcher(name).matches();
				}
			});
		}		
	}
	/**
	 * Overload local
	 * 返回当前路径Path下名字符合条件的目录或文件
	 * @param path
	 * @param regex
	 * @return
	 */
	public static File[] local(String path,final String...regex){
		return local(new File(path),regex);
	}
	/**
	 * 文件树
	 * @author Administrator
	 *
	 */
	public static class TreeInfo implements Iterable<File>{
		public List<File> files=new ArrayList<File>();
		public List<File> dirs=new ArrayList<File>();
		/**
		 * 返回文件遍历器
		 */
		@Override
		public Iterator<File> iterator() {			
			return files.iterator();
		}
		void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		public String toString(){
			return "files:"+files+"\n"+
						"dirs:"+dirs+"\n";
		}
	}
	/**
	 * 获得符合过滤条件的文件
	 * @param start
	 * @param regex
	 * @return
	 */
	public static TreeInfo walk(String start,String regex){
		return recurseDirs(new File(start),regex);
	}
	/**
	 * 获得符合过滤条件的文件
	 * @param start
	 * @param regex
	 * @return
	 */
	public static TreeInfo walk(File start,String regex){
		return recurseDirs(start,regex);
	}
	/**
	 * 获得所有文件
	 * @param start
	 * @return
	 */
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start),".*");
	}
	/**
	 * 获得所有文件
	 * @param start
	 * @return
	 */
	public static TreeInfo walk(File start){
		return recurseDirs(start,".*");
	}
	static TreeInfo recurseDirs(File start,String regex){
		TreeInfo result=new TreeInfo();
		for(File item:start.listFiles()){
			if(item.isDirectory()){
				result.dirs.add(item);
				result.addAll(recurseDirs(item,regex));
			}else{
				if(item.getName().matches(regex))
					result.files.add(item);
			}
		}
		return result;			
	}
	/**
	 * 获得所有xml文件
	 * @param path
	 * @return
	 */
	public static List<File> getAllXMLFile(String path){
		return walk(path,".*\\.xml").files;
	}
	/**
	 * 获得所有xml文件
	 * @param path
	 * @return
	 */
	public static List<File> getAllXMLFile(File file){
		return walk(file,".*\\.xml").files;
	}
	/**
	 * 获得默认路径下的xml文件
	 * @return
	 */
	public static List<File> getAllXMLFile(){
		return walk(XMLReaderConst.DEFAULT_XML_ROOT_PATH,".*\\.xml").files;
	}	
	/**
	 * 产生对应xml的html路径
	 * @param xmlFile
	 * @param path_prefix
	 * @return
	 */
	public static String newHtmlPath(File xmlFile, String path_prefix){
		String filePath=xmlFile.getName().replace(".xml", ".html");
		filePath=path_prefix+"/"+filePath;
		return filePath;
	}
	/**
	 * 产生对应xml的html路径,放在默认目录htmlOut下
	 * @param xmlFile
	 * @return
	 */
	public static String newHtmlPath(File xmlFile){
		return newHtmlPath(xmlFile,XMLReaderConst.DEFAULT_HTML_ROOT_PATH);
	}
//	public static void main(String[] args){
//		System.out.println(XMLFinder.getAllXMLFile("src"));
//	}
}
