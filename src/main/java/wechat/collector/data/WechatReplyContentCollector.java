package wechat.collector.data;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wechat.domain.WechatReplyContent;
import wechat.service.Message.WechatReplyContentService;

/**
 * 回复内容Collector
 * @author: wulongwei
 * @date:   2019年1月25日 下午4:49:03     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Controller
@RequestMapping("/wechatReplyContent")
public class WechatReplyContentCollector {

	/**
	 * 查询关键词
	 */
	@Transactional
	@RequestMapping("/get")
	@ResponseBody
	public WechatReplyContent selectWechatKeyword(@RequestBody Map<String, Object> map) throws Exception {
		return contentService.getWechatReplyKeyword(map.get("appId").toString(), map.get("content").toString());
	}
	
	@Autowired
	private WechatReplyContentService contentService;
}
