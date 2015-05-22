package com.pczhu.service;

import java.util.List;

import com.pczhu.bean.ImageInfo;
import com.pczhu.dao.impl.PicDaoImpl;
import com.pczhu.dao.impl.PicDaoInterface;

public class ImageControl {
	PicDaoInterface picdao;
	public ImageControl() {
		picdao = new PicDaoImpl();
	}
	public List<ImageInfo> getPicList(int i,int j){
		return picdao.getPicList(i, j);
	}
	
}
