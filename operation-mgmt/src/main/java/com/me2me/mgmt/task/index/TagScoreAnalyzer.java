package com.me2me.mgmt.task.index;

import java.util.HashMap;
import java.util.Map;

public class TagScoreAnalyzer {
	public Map<String,Integer> tagCountMap=new HashMap<>();
	
	public void addUserLog(String tag,int score){
		Integer count = tagCountMap.get(tag);
		if(count==null){
			count=0;
		}
		count+=score;
		this.tagCountMap.put(tag, count);
	}
}
