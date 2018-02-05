package com.me2me.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.me2me.common.web.Response;
import com.me2me.content.dto.TagKingdomDto;
import com.me2me.content.service.ContentService;
import com.me2me.live.service.LiveService;
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext.xml" })
public class HomeTest {
	@Autowired
	private ContentService liveService;

	@Autowired
	private LiveService ls;
	//@Test
	public void getTagKingdomList() {
		Response<TagKingdomDto> tagsKingdoms = liveService.tagKingdomList("AAA0","new", 1, 20, 318);
		System.out.println(JSON.toJSONString(tagsKingdoms, true));
		
	}
	@Test
	public void hotList() {
		Response tagsKingdoms = liveService.hotList(-1,1118, 0);
		System.out.println(JSON.toJSONString(tagsKingdoms, true));
	}
	//@Test
	public void dropAroundTest() {
		Response tagsKingdoms = ls.dropAround(318, 2765);
		System.out.println(JSON.toJSONString(tagsKingdoms, true));
	}

}
