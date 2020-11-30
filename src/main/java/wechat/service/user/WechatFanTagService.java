package wechat.service.user;
/**
 * 微信粉丝标签service
 * @author: wulongwei
 * @date:   2019年2月16日 下午4:03:11     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */

import wechat.wechatApi.bean.request.user.TagsUpdateRequest;
import wechat.wechatApi.bean.response.user.TagsAddResponse;
import wechat.wechatApi.bean.response.user.TagsResponse;
import wechat.wechatApi.bean.response.user.UserListResponse;

public interface WechatFanTagService {

	/**
	 * 添加标签
	 * @Title: addTag  
	 * @param appId
	 * @param tagName
	 * @return      
	 * @return: TagsAddResponse
	 */
	public TagsAddResponse addTag(String appId, String tagName);
	
	/**
	 * 同步公众号已创建的标签
	 * @Title: synchronizationTag  
	 * @param appId
	 * @return      
	 * @return: TagsResponse
	 */
	public TagsResponse synchronizationTag(String appId);
	
	/**
	 * 修改标签
	 * @Title: updateTag  
	 * @param appId
	 * @param updateRequest
	 * @return      
	 * @return: TagsResponse
	 */
	public TagsResponse updateTag(String appId, TagsUpdateRequest updateRequest);
	
	/**
	 * 同步粉丝信息
	 * @Title: getFans  
	 * @param appId
	 * @param userListRequest
	 * @return      
	 * @return: UserListResponse
	 */
	public UserListResponse synchronizationUserInfo(String appId);
	

}
