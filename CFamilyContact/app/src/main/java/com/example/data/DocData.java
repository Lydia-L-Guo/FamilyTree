package com.example.data;

public class DocData {
	int did ;
	String title  ;   //--标题
	String author  ;  //--作者
	String type  ;   //--类型（源流、祠堂等）
	String format  ; // --格式，此处是带格式还是无格式文本
	String path  ;   // --路径，用于存放图片或非结构化文档的路径
	String description  ;   //--相关描述
	String 	content  ;  //--内容，如果是文本
	int gid  ;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
}
