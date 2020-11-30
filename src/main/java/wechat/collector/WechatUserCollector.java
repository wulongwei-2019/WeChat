package wechat.collector;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import wechat.domain.dtomain.WechatTagDto;
import wechat.service.user.WechatFanTagService;
import wechat.wechatApi.bean.request.user.TagsUpdateRequest;
import wechat.wechatApi.bean.response.user.TagsAddResponse;
import wechat.wechatApi.bean.response.user.TagsResponse;
import wechat.wechatApi.bean.response.user.UserListResponse;
import wechat.wechatApi.config.WechatConfigureInfo;

/**
 * 用户管理
 * @author: wulongwei
 * @date:   2019年2月16日 下午3:42:49     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Controller
@RequestMapping(value = "/wechatUser")
public class WechatUserCollector {

	/**
	 * 添加标签
	 * @Title: addTag  
	 * @param wechatTagDto
	 * @param request
	 * @return      
	 * @return: String
	 */
	@PostMapping(value = "/addTag")
	@ResponseBody
	public String addTag(@RequestBody @Validated WechatTagDto wechatTagDto, HttpServletRequest request) {
		String appId=WechatConfigureInfo.APP_ID; //以后扩充AppId从数据库中获取
		TagsAddResponse tagsAddResponse = fanTagService.addTag(appId, wechatTagDto.getName());
		return JSONObject.toJSONString(tagsAddResponse);
	}
	
	/**
	 * 同步标签
	 * @Title: getTag  
	 * @param request
	 * @return      
	 * @return: String
	 */
	@GetMapping(value = "/getTag")
	@ResponseBody
	public String getTag(HttpServletRequest request) {
		String appId=WechatConfigureInfo.APP_ID; //以后扩充AppId从数据库中获取
		TagsResponse tagsAddResponse = fanTagService.synchronizationTag(appId);
		return JSONObject.toJSONString(tagsAddResponse.getTags());
	}
	
	/**
	 * 编辑标签
	 * @Title: updateTag  
	 * @param updateRequest
	 * @param request
	 * @return      
	 * @return: String
	 */
	@PostMapping(value = "/updateTag")
	@ResponseBody
	public String updateTag(TagsUpdateRequest updateRequest, HttpServletRequest request) {
		String appId=WechatConfigureInfo.APP_ID; //以后扩充AppId从数据库中获取
		TagsResponse tagsAddResponse = fanTagService.synchronizationTag(appId);
		return JSONObject.toJSONString(tagsAddResponse.getErrcode());
	}
	
	/**
	 * 同步粉丝信息
	 * @Title: updateTag  
	 * @param updateRequest
	 * @param request
	 * @return      
	 * @return: String
	 */
	@PostMapping(value = "/synchronizationUserInfo")
	@ResponseBody
	public String synchronizationUserInfo(HttpServletRequest request) {
		String appId = WechatConfigureInfo.APP_ID; //以后扩充AppId从数据库中获取
		UserListResponse tagsAddResponse = fanTagService.synchronizationUserInfo(appId);
		return JSONObject.toJSONString(tagsAddResponse);
	}
	
	@Autowired
	private WechatFanTagService fanTagService;
}
