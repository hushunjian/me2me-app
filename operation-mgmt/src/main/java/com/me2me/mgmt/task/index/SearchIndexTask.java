package com.me2me.mgmt.task.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.me2me.search.service.SearchService;
/**
 * 索引用户
 * @author zhangjiwei
 * @date Apr 7, 2017
 */
@Component
public class SearchIndexTask{
	private static final Logger logger = LoggerFactory.getLogger(SearchIndexTask.class);
	public boolean userIndexRunning = false;
	public boolean ugcIndexRunning = false;
	public boolean kingdomIndexRunning = false;
	public boolean searchHistoryIndexRunning = false;
	@Autowired
	private SearchService searchService;
	
	
	@Scheduled(cron="0 0/5 * * * ?")
	public void userIndexJob() {
		if(userIndexRunning){
			return ;
		}
		try{
			userIndexRunning = true;
			int indexCount = searchService.indexUserData(false);
            logger.info("任务完成,索引数量"+indexCount);
		}catch(Exception e){
        	logger.error("任务执行失败", e);
        }
		userIndexRunning=false;
	}
	
	@Scheduled(cron="0 3/5 * * * ?")
	public void ugcIndexJob() {
		if(ugcIndexRunning){
			return ;
		}
		try{
			ugcIndexRunning = true;
			int indexCount = searchService.indexUgcData(false);
            logger.info("任务完成,索引数量"+indexCount);
		}catch(Exception e){
        	logger.error("任务执行失败", e);
        }
		ugcIndexRunning=false;
	}
	
	@Scheduled(cron="0 6/5 * * * ?")
	public void kingdomIndexJob() {
		if(kingdomIndexRunning){
			return ;
		}
		try{
			kingdomIndexRunning = true;
			int indexCount = searchService.indexKingdomData(false);
            logger.info("任务完成,索引数量"+indexCount);
		}catch(Exception e){
        	logger.error("任务执行失败", e);
        }
		kingdomIndexRunning=false;
	}
	@Scheduled(cron="0 9/5 * * * ?")
	public void searchHistoryJob(){
		
		if(searchHistoryIndexRunning){
			return ;
		}
		try{
			searchHistoryIndexRunning = true;
			int indexCount = searchService.indexSearchHistory(false);
            logger.info("任务完成,索引数量"+indexCount);
		}catch(Exception e){
        	logger.error("任务执行失败", e);
        }
		searchHistoryIndexRunning=false;
	}
}
