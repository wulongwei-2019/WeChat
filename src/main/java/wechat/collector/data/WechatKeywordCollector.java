package wechat.collector.data;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wechat.domain.WechatReplyKeyword;
import wechat.service.Message.WechatReplyContentService;
import wechat.service.Message.Impl.WechatKeywordServiceImpl;
/**
 * 关键词操作collector
 * @author: wulongwei
 * @date:   2019年1月28日 下午5:49:59     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Controller
@RequestMapping("/wechatKeyword")
public class WechatKeywordCollector {
	
	/**
	 * 添加关键词
	 * 先添加回复内容对象，获取ID，再添加关键词对象
	 * @throws Exception 
	 */
	@Transactional
	@RequestMapping("/save")
	@ResponseBody
	public String insertWechatKeyword(@RequestBody WechatReplyKeyword keyword) throws Exception {
		Integer contentId = contentService.save(keyword.getWechatReplyContent());
		keyword.setReplyContentId(contentId);
		keywordService.insertWechatKeyword(keyword);
		return "ok";
	}
	
	/**
	 * 查询关键词
	 */
	@Transactional
	@RequestMapping("/get")
	@ResponseBody
	public WechatReplyKeyword selectWechatKeyword(@RequestBody Map<String, Object> map) throws Exception {
		return keywordService.getWechatReplyKeyword(map.get("appId").toString(), map.get("content").toString());
	}
	
	@Autowired
	private WechatReplyContentService contentService;
	@Autowired
	private WechatKeywordServiceImpl keywordService;
	
}
