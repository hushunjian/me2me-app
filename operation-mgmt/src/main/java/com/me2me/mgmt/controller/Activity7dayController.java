package com.me2me.mgmt.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.me2me.activity.dto.ShowActivity7DayTasksDTO;
import com.me2me.activity.dto.ShowActivity7DayUserStatDTO;
import com.me2me.activity.dto.ShowActivity7DayUsersDTO;
import com.me2me.activity.dto.ShowMiliDatasDTO;
import com.me2me.activity.model.AactivityStage;
import com.me2me.activity.model.AmiliData;
import com.me2me.activity.model.AtaskWithBLOBs;
import com.me2me.activity.service.ActivityService;
import com.me2me.common.utils.DateUtil;
import com.me2me.common.web.Response;
import com.me2me.mgmt.request.ActivityInfoDTO;
import com.me2me.mgmt.request.MiliDataQueryDTO;
import com.me2me.mgmt.request.StageItem;
import com.me2me.mgmt.request.StatUserDTO;
import com.me2me.mgmt.request.TaskQueryDTO;
import com.me2me.mgmt.syslog.SystemControllerLog;

@Controller
@RequestMapping("/7day")
public class Activity7dayController {

	private static final Logger logger = LoggerFactory.getLogger(Activity7dayController.class);
	
	@Autowired
    private ActivityService activityService;
	
	@RequestMapping(value="/stat/user")
	public ModelAndView statUser(StatUserDTO dto){
		ModelAndView view = new ModelAndView("7day/statUser");
		//先查询出统计信息
		ShowActivity7DayUserStatDTO userStat = activityService.get7dayUserStat(dto.getChannel(), dto.getCode(), dto.getStartTime(), dto.getEndTime());
		dto.setUserStatDTO(userStat);
		
		if(userStat.getTotalUser()%10 == 0){
			dto.setTotalPage((int)userStat.getTotalUser()/10);
		}else{
			dto.setTotalPage((int)userStat.getTotalUser()/10 + 1);
		}
		
		//再查询分页用户信息
		ShowActivity7DayUsersDTO users = activityService.get7dayUsers(dto.getChannel(), dto.getCode(), dto.getStartTime(), dto.getEndTime(), 1, 10);
		dto.setUserDTO(users);
		
		view.addObject("dataObj",dto);
		
		return view;
	}
	
	@RequestMapping(value="/stat/user/query")
	@ResponseBody
	public String statUserQuery(StatUserDTO dto){
		ShowActivity7DayUsersDTO users = activityService.get7dayUsers(dto.getChannel(), dto.getCode(), dto.getStartTime(), dto.getEndTime(), dto.getPage(), dto.getPageSize());
		JSONObject obj = (JSONObject)JSON.toJSON(users);
		return obj.toJSONString();
	}
	
	@RequestMapping(value="/control/index")
	public ModelAndView controlIndex(){
		ModelAndView view = new ModelAndView("7day/control");
		return view;
	}
	
	@RequestMapping(value="/control/auditSuccess")
	@ResponseBody
	@SystemControllerLog(description = "七天活动一键审核通过")
	public String auditSuccess(){
		//一键审核通过
		activityService.oneKeyAudit();
		
		return "0";
	}
	
	@RequestMapping(value="/control/noticeBind")
	@ResponseBody
	@SystemControllerLog(description = "七天活动一键通知绑定")
	public String noticeBind(){
		//一键通知绑定
		activityService.bindNotice();
		return "0";
	}
	
	@RequestMapping(value="/control/activityStartNotice")
	@ResponseBody
	@SystemControllerLog(description = "七天活动一键通知活动开始")
	public String activityStartNotice(){
		//一键通知活动进行
		activityService.noticeActivityStart();
		
		return "0";
	}
	
	@RequestMapping(value="/control/pairingStartNotice")
	@ResponseBody
	@SystemControllerLog(description = "七天活动配对即将开始通知")
	public String pairingStartNotice(){
		//一键通知活动进行
		activityService.pairingNotice();
		
		return "0";
	}
	
	@RequestMapping(value="/control/sexSend/{sex}")
	@ResponseBody
	@SystemControllerLog(description = "七天活动男女推送")
	public String sexSend(@PathVariable int sex){
		
		activityService.send7DayKingdomMessage(sex);
		
		return "0";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/milidata/query")
	public ModelAndView miliDataQuery(MiliDataQueryDTO dto){
		ModelAndView view = new ModelAndView("7day/milidata");
		
		Response resp = activityService.searchMiliDatas(dto.getMkey(), 1, dto.getPage(), dto.getPageSize());
		if(null != resp && resp.getCode() == 200){
			dto.setData((ShowMiliDatasDTO)resp.getData());
			if(null != dto.getData() && null != dto.getData().getResult() && dto.getData().getResult().size() > 0){
				for(ShowMiliDatasDTO.MiliDataElement e : dto.getData().getResult()){
					e.setContent(e.getContent().replaceAll("&", "&amp;").replaceAll(">", "&gt;").replaceAll("<", "&lt;"));
				} 
			}
		}
		
		view.addObject("dataObj",dto);
		return view;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/milidata/queryJson")
	@ResponseBody
	public String miliDataQueryJson(MiliDataQueryDTO dto){
		Response resp = activityService.searchMiliDatas(dto.getMkey(), 1, dto.getPage(), dto.getPageSize());
		if(null != resp && resp.getCode() == 200){
			if(null != resp.getData()){
				ShowMiliDatasDTO sddto = (ShowMiliDatasDTO)resp.getData();
				if(null != sddto.getResult() && sddto.getResult().size() > 0){
					for(ShowMiliDatasDTO.MiliDataElement e : sddto.getResult()){
						e.setContent(e.getContent().replaceAll("&", "&amp;").replaceAll(">", "&gt;").replaceAll("<", "&lt;"));
					}
				}
			}
		}
		
		JSONObject obj = (JSONObject)JSON.toJSON(resp);
		return obj.toJSONString();
	}
	
	@RequestMapping(value="/milidata/f/{id}")
	public ModelAndView getMiliData(@PathVariable long id){
		ModelAndView view = new ModelAndView("7day/milidataEdit");
		
		AmiliData data = activityService.getAmiliDataById(id);
		view.addObject("dataObj",data);
		
		return view;
	}
	
	@RequestMapping(value="/milidata/update")
	@SystemControllerLog(description = "七天活动更新米粒块")
	public ModelAndView updateMiliData(AmiliData data){
		ModelAndView view = null;
		if(StringUtils.isEmpty(data.getMkey()) || StringUtils.isEmpty(data.getContent())){
			view = new ModelAndView("7day/milidataEdit");
			view.addObject("dataObj",data);
			view.addObject("errMsg","米粒内容不能为空");
			return view;
		}
		
		activityService.updateAmiliData(data);
		
		view = new ModelAndView("redirect:/7day/milidata/query");
		return view;
	}
	
	@RequestMapping(value="/milidata/save")
	@SystemControllerLog(description = "七天活动新增米粒块")
	public ModelAndView saveMiliData(AmiliData data){
		ModelAndView view = null;
		if(StringUtils.isEmpty(data.getMkey()) || StringUtils.isEmpty(data.getContent())){
			view = new ModelAndView("7day/milidataNew");
			view.addObject("dataObj",data);
			view.addObject("errMsg","米粒内容不能为空");
			return view;
		}
		
		activityService.saveAmiliData(data);
		view = new ModelAndView("redirect:/7day/milidata/query");
		return view;
	}
	
	@RequestMapping(value="/getActivityInfo")
	public ModelAndView getActivityInfo(){
		ActivityInfoDTO dto = new ActivityInfoDTO();
		dto.setActivityInfo(activityService.getAactivityById(1));
		List<AactivityStage> list = activityService.getAllStage(1);
		List<StageItem> stageList = new ArrayList<StageItem>();
		if(null != list && list.size() > 0){
			StageItem item = null;
			for(AactivityStage stage : list){
				item = new StageItem();
				item.setId(stage.getId());
				item.setName(getStageNameByStage(stage.getStage()));
				item.setStartTime(DateUtil.date2string(stage.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
				item.setEndTime(DateUtil.date2string(stage.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
				item.setStatus(stage.getType());
				stageList.add(item);
			}
		}
		
		dto.setStageList(stageList);
		
		ModelAndView view = new ModelAndView("7day/stage");
		view.addObject("dataObj",dto);
		
		return view;
	}
	
	private String getStageNameByStage(int stage){
		switch(stage){
		case 1:
			return "报名阶段";
		case 2:
			return "个人阶段";
		case 3:
			return "配对阶段";
		case 4:
			return "抢亲阶段";
		case 5:
			return "强配阶段";
		default:
			return "不支持的stage";
		}
	}
	
	@RequestMapping(value="/stage/f/{id}")
	public ModelAndView getStage(@PathVariable long id){
		ModelAndView view = new ModelAndView("7day/stageEdit");
		
		AactivityStage stage = activityService.getAactivityStageById(id);
		if(null != stage){
			StageItem item = new StageItem();
			item.setId(stage.getId());
			item.setName(getStageNameByStage(stage.getStage()));
			item.setStartTime(DateUtil.date2string(stage.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
			item.setEndTime(DateUtil.date2string(stage.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
			item.setStatus(stage.getType());
			view.addObject("dataObj",item);
		}
		
		return view;
	}
	
	@RequestMapping(value="/stage/update")
	@SystemControllerLog(description = "七天活动更新阶段")
	public ModelAndView updateStage(StageItem item) throws ParseException{
		AactivityStage stage = activityService.getAactivityStageById(item.getId());
		stage.setStartTime(DateUtil.string2date(item.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
		stage.setEndTime(DateUtil.string2date(item.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
		stage.setType(item.getStatus());
		
		activityService.updateAactivityStage(stage);
		
		ModelAndView view = new ModelAndView("redirect:/7day/getActivityInfo");
		return view;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/task/query")
	public ModelAndView taskQuery(TaskQueryDTO dto){
		ModelAndView view = new ModelAndView("7day/taskList");
		
		Response resp = activityService.getTaskPage(dto.getTitle(), 1, dto.getPage(), dto.getPageSize());
		if(null != resp && resp.getCode() == 200 && null != resp.getData()){
			dto.setData((ShowActivity7DayTasksDTO)resp.getData());
			if(null != dto.getData().getResult() && dto.getData().getResult().size() > 0){
				for(ShowActivity7DayTasksDTO.TaskElement e : dto.getData().getResult()){
					e.setContent(e.getContent().replaceAll("&", "&amp;").replaceAll(">", "&gt;").replaceAll("<", "&lt;"));
					e.setMiliContent(e.getMiliContent().replaceAll("&", "&amp;").replaceAll(">", "&gt;").replaceAll("<", "&lt;"));
				}
			}
		}
		
		view.addObject("dataObj",dto);
		
		return view;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/task/queryJson")
	@ResponseBody
	public String taskQueryJson(TaskQueryDTO dto){
		Response resp = activityService.getTaskPage(dto.getTitle(), 1, dto.getPage(), dto.getPageSize());
		if(null != resp && resp.getCode() == 200 && null != resp.getData()){
			ShowActivity7DayTasksDTO respDTO = (ShowActivity7DayTasksDTO)resp.getData();
			if(null != respDTO.getResult() && respDTO.getResult().size() > 0){
				for(ShowActivity7DayTasksDTO.TaskElement e : respDTO.getResult()){
					e.setContent(e.getContent().replaceAll("&", "&amp;").replaceAll(">", "&gt;").replaceAll("<", "&lt;"));
					e.setMiliContent(e.getMiliContent().replaceAll("&", "&amp;").replaceAll(">", "&gt;").replaceAll("<", "&lt;"));
				}
			}
		}
		
		JSONObject obj = (JSONObject)JSON.toJSON(resp);
		return obj.toJSONString();
	}
	
	@RequestMapping(value="/task/f/{id}")
	public ModelAndView getTask(@PathVariable long id){
		ModelAndView view = new ModelAndView("7day/taskEdit");
		
		AtaskWithBLOBs task = activityService.getAtaskWithBLOBsById(id);
		if(null != task){
			view.addObject("dataObj",task);
		}
		
		return view;
	}
	
	@RequestMapping(value="/task/update")
	@SystemControllerLog(description = "七天活动更新阶段")
	public ModelAndView updateTask(AtaskWithBLOBs task){
		activityService.updateAtaskWithBLOBs(task);
		ModelAndView view = new ModelAndView("redirect:/7day/task/query");
		return view;
	}
}
