package wechat.wechatApi.service.user;

import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.request.user.TagsAddRequest;
import wechat.wechatApi.bean.request.user.TagsUpdateRequest;
import wechat.wechatApi.bean.request.user.UserInfoRequest;
import wechat.wechatApi.bean.response.user.TagsAddResponse;
import wechat.wechatApi.bean.response.user.TagsResponse;
import wechat.wechatApi.bean.response.user.UserInfoListResponse;
import wechat.wechatApi.bean.response.user.UserListResponse;

/**
 * 用户管理service
 * @author: wulongwei
 * @date:   2019年2月16日 下午4:22:00     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface WechatUserService {

	/**
	 * 添加标签
	 * @Title: addTag  
	 * @param validateToken
	 * @param tagsAddRequest
	 * @return      
	 * @return: TagsAddResponse
	 */
	public TagsAddResponse addTag(ValidateToken validateToken, TagsAddRequest tagsAddRequest);
	
	/**
	 * 获取公众号已创建的标签
	 * @Title: getTag  
	 * @param validateToken
	 * @return      
	 * @return: TagsResponse
	 */
	public TagsResponse getTag(ValidateToken validateToken);
	
	/**
	 * 编辑标签
	 * @Title: updateTag  
	 * @param validateToken
	 * @param updateRequest
	 * @return      
	 * @return: TagsResponse
	 */
	public TagsResponse updateTag(ValidateToken validateToken, TagsUpdateRequest updateRequest);
	
	/**
	 * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID
	 * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
	 * @Title: getFans  
	 * @param validateToken
	 * @param userListRequest
	 * @return      
	 * @return: UserListResponse
	 */
	public UserListResponse getFans(ValidateToken validateToken);
	
	/**
	 * 批量获取用户基本信息
	 * @Title: getUserInfo  
	 * @param validateToken
	 * @param infoRequest
	 * @return      
	 * @return: UserInfoResponse
	 */
	public UserInfoListResponse getUserInfo(ValidateToken validateToken, UserInfoRequest infoRequest);
}
