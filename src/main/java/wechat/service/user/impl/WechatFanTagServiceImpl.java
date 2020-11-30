package wechat.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wechat.domain.WechatFanTag;
import wechat.domain.WechatFans;
import wechat.mapper.WechatFanTagMapper;
import wechat.service.user.WechatFanTagService;
import wechat.service.user.WechatFansService;
import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.request.user.TagsAddRequest;
import wechat.wechatApi.bean.request.user.TagsUpdateRequest;
import wechat.wechatApi.bean.request.user.UserInfoRequest;
import wechat.wechatApi.bean.request.user.UserInfoRequest.openidList;
import wechat.wechatApi.bean.response.user.TagsAddResponse;
import wechat.wechatApi.bean.response.user.TagsResponse;
import wechat.wechatApi.bean.response.user.TagsResponse.Tag;
import wechat.wechatApi.bean.response.user.UserInfoListResponse;
import wechat.wechatApi.bean.response.user.UserInfoResponse;
import wechat.wechatApi.bean.response.user.UserListResponse;
import wechat.wechatApi.service.user.WechatUserService;

@Service
@Transactional
public class WechatFanTagServiceImpl implements WechatFanTagService{

	@Override
	public TagsAddResponse addTag(String appId, String tagName) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		TagsAddRequest.Tag tag = new TagsAddRequest.Tag();
		tag.setName(tagName);
		TagsAddRequest addRequest = new TagsAddRequest();
		addRequest.setTag(tag);
		return userService.addTag(token, addRequest);
	}

	@Override
	public TagsResponse synchronizationTag(String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		TagsResponse response = userService.getTag(token);
		//同步入数据库
		List<Tag> tags = response.getTags();
		List<WechatFanTag> fanTags = new ArrayList<>();
		for (Tag tag : tags) {
			WechatFanTag fanTag = new WechatFanTag();
			fanTag.setAppId(appId);
			fanTag.setTagName(tag.getName());
			fanTag.setId(tag.getId());
			fanTag.setUserCount(tag.getCount());
			fanTag.setHasDeleted(false);
			fanTags.add(fanTag);
		}
		//删除数据库中的标签，再将微信返回的标签组保存
		fanTagMapper.deleteTagAll(appId);
		fanTagMapper.saveWechatFanTagList(fanTags);
		return response;
	}
	
	@Override
	public TagsResponse updateTag(String appId, TagsUpdateRequest updateRequest) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		TagsResponse response = userService.getTag(token);
		WechatFanTag fanTag = new WechatFanTag();
		fanTag.setAppId(appId);
		fanTag.setTagName(updateRequest.getTag().getName());
		fanTag.setId(updateRequest.getTag().getId());
		fanTagMapper.updateTag(fanTag);
		return response;
	}
	
	@Override
	public UserListResponse synchronizationUserInfo(String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		UserListResponse listResponse = userService.getFans(token);
		List<openidList> list = new ArrayList<>();
		//微信端返回的openid
		List<String> openidList =listResponse.getData().getOpenid();
		for (String openid : openidList) {
			UserInfoRequest.openidList data = new UserInfoRequest.openidList();
			data.setOpenid(openid);
			list.add(data);
		}
		UserInfoRequest infoRequest = new UserInfoRequest();
		infoRequest.setUser_list(list);
		UserInfoListResponse infoResponse = userService.getUserInfo(token, infoRequest);
		//将用户信息同步入数据库
		this.synchronizationUserInfo(infoResponse, appId);
		return listResponse;
	}
	
	public String synchronizationUserInfo(UserInfoListResponse infoListResponse, String appId){
		List<WechatFans> wechatFans = new ArrayList<>();
		List<UserInfoResponse> list = infoListResponse.getUser_info_list();
		for (UserInfoResponse userInfoResponse : list) {
			WechatFans fans = new WechatFans();
			fans.setAppId(appId);
			fans.setCity(userInfoResponse.getCity());
			fans.setCountry(userInfoResponse.getCountry());
			fans.setGroupid(userInfoResponse.getGroupid());
			fans.setHasDeleted(false);
			fans.setIsBlackList(false);
			fans.setLanguage(userInfoResponse.getLanguage());
			fans.setNickname(userInfoResponse.getNickname());
			fans.setOpenid(userInfoResponse.getOpenid());
			fans.setProvince(userInfoResponse.getProvince());
			fans.setQrScene(userInfoResponse.getQr_scene().toString());
			fans.setQrSceneStr(userInfoResponse.getQr_scene_str());
			fans.setRemark(userInfoResponse.getRemark());
			fans.setSex(userInfoResponse.getSex());
			fans.setSubscribe(userInfoResponse.getSubscribe());
			fans.setSubscribeScene(userInfoResponse.getSubscribe_scene());
			fans.setSubscribeTime(userInfoResponse.getSubscribe_time());
			fans.setTagidList(userInfoResponse.getTagid_list().toString());
			fans.setUnionid(userInfoResponse.getUnionid());
	        fans.setHeadimgurl(userInfoResponse.getHeadimgurl());
	        wechatFans.add(fans);
		}
		//同步入数据库
		fanService.synchronizationFans(wechatFans, appId);
		return "OK";
	}
	@Autowired
	private WechatUserService userService;
    @Autowired
    private WechatFanTagMapper fanTagMapper;
	@Autowired
	private WechatFansService fanService;
	
}
