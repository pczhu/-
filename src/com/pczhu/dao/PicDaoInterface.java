package com.pczhu.dao;

import java.util.List;
import java.util.Map;

import com.pczhu.bean.ImageInfo;

public interface PicDaoInterface {
	public List<ImageInfo> getPicList(int i,int j);
	public List<ImageInfo> getPicList();
	public List<ImageInfo> getPicList(Map<String,String> map);
	public int delpic(String id);
	public int addpic(ImageInfo imageinfo);
	public int checkshow(String id);
	public int updateImage(String id,Map<String,String> map);
}
