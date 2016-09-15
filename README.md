# os-api
操作系统-API文档编写组

全部api: http://man7.org/linux/man-pages/dir_section_2.html

重要api: http://www.ibm.com/developerworks/cn/linux/kernel/syscall/part1/appendix.html

#	os-api/xml2html
os-api的新分支，用于将描述OS-API的xml转化成html,并可任意添加js与css，变成需要的可视化界面

用法：

1、将需要转化的所有xml文件放到./xmlhome中

2、运行com.github.wzt3309.xml2html.html.Xml2Html中的main()

3、转化完成的html会出现在./htmlOut中，且路径和名称对应于原xml；同时Concole会输出相关过程

目前进度：

1、目前只测试完成群邮件中的举例api xml文档转化成html，还未做其他测试

->xmlhome/example.xml转为htmlOut/example.html

2、生成的html文档css与js等样式还没加上