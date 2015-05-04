package com.pczhu.bean;

import java.io.Serializable;
import java.sql.Date;

public class NewsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String newsID;
	private String newstitle;
	private String newscontent;
	private String classTag;
	private String newsuserName;
	private String newsdesc;
	private String newswriter;
	private String newssource;
	private String newsdateTime;
	private int newscheckup;
	private int newsshow;
	private int newslight;
	private String newsimgurl;
	private String newscontentimgurl;
	private int newshints;
	public String getNewsID() {
		return newsID;
	}
	public void setNewsID(String newsID) {
		this.newsID = newsID;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewscontent() {
		return newscontent;
	}
	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}
	public String getClassTag() {
		return classTag;
	}
	public void setClassTag(String classTag) {
		this.classTag = classTag;
	}
	public String getNewsuserName() {
		return newsuserName;
	}
	public void setNewsuserName(String newsuserName) {
		this.newsuserName = newsuserName;
	}
	public String getNewsdesc() {
		return newsdesc;
	}
	public void setNewsdesc(String newsdesc) {
		this.newsdesc = newsdesc;
	}
	public String getNewswriter() {
		return newswriter;
	}
	public void setNewswriter(String newswriter) {
		this.newswriter = newswriter;
	}
	public String getNewssource() {
		return newssource;
	}
	public void setNewssource(String newssource) {
		this.newssource = newssource;
	}
	public String getNewsdateTime() {
		return newsdateTime;
	}
	public void setNewsdateTime(String newsdateTime) {
		this.newsdateTime = newsdateTime;
	}
	public int getNewscheckup() {
		return newscheckup;
	}
	public void setNewscheckup(int newscheckup) {
		this.newscheckup = newscheckup;
	}
	public int getNewsshow() {
		return newsshow;
	}
	public void setNewsshow(int newsshow) {
		this.newsshow = newsshow;
	}
	public int getNewslight() {
		return newslight;
	}
	public void setNewslight(int newslight) {
		this.newslight = newslight;
	}
	public String getNewsimgurl() {
		return newsimgurl;
	}
	public void setNewsimgurl(String newsimgurl) {
		this.newsimgurl = newsimgurl;
	}
	public String getNewscontentimgurl() {
		return newscontentimgurl;
	}
	public void setNewscontentimgurl(String newscontentimgurl) {
		this.newscontentimgurl = newscontentimgurl;
	}
	public int getNewshints() {
		return newshints;
	}
	public void setNewshints(int newshints) {
		this.newshints = newshints;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
}
