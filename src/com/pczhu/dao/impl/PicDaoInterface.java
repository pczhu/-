package com.pczhu.dao.impl;

import java.util.List;
import java.util.Map;

import com.pczhu.bean.ImageInfo;

public interface PicDaoInterface {
	public List<ImageInfo> getPicList(int i,int j);
	public int delpic(int id);
	public int addpic(ImageInfo imageinfo);
	public int checkshow(int id);
	public int updateImage(int id,Map<String,String> map);
}
