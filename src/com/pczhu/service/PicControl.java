package com.pczhu.service;

import java.util.List;
import java.util.Map;

import com.pczhu.bean.ImageInfo;
import com.pczhu.dao.PicDaoInterface;
import com.pczhu.dao.impl.PicDaoImpl;

public class PicControl {
	PicDaoInterface picdao;
	public PicControl() {
		picdao = new PicDaoImpl();
	}
	public List<ImageInfo> getPicList(int i,int j){
		return picdao.getPicList(i, j);
	}
	public int addPic(ImageInfo imageinfo){
		return picdao.addpic(imageinfo);
		
	}
	public int delpic(String pid) {
		return picdao.delpic(pid);
		
	}
	public int update(String pid,Map<String,String> map){
		return picdao.updateImage(pid, map);
	}
	
}
