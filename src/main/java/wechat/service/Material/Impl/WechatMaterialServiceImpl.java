package wechat.service.Material.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import wechat.domain.WechatMaterial;
import wechat.mapper.WechatMaterialMapper;
import wechat.service.Material.WechatMaterialService;
import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.request.material.AddMaterialRequest;
import wechat.wechatApi.bean.request.material.AddNewsRequest;
import wechat.wechatApi.bean.request.material.BatchgetMaterialRequest;
import wechat.wechatApi.bean.request.material.GetMaterialRequest;
import wechat.wechatApi.bean.request.material.UploadImgRequest;
import wechat.wechatApi.bean.response.material.AddMeterialResponse;
import wechat.wechatApi.bean.response.material.AddNewsResponse;
import wechat.wechatApi.bean.response.material.BatchgetMaterialResponse;
import wechat.wechatApi.bean.response.material.GetMaterialcountResponse;
import wechat.wechatApi.bean.response.material.GetNewsResponse;
import wechat.wechatApi.bean.response.material.UploadImgResponse;
import wechat.wechatApi.bean.response.material.common.MaterialItems;
import wechat.wechatApi.constant.MaterialConstant;
/**
 * 微信素材管理service实现
 * @author: wulongwei
 * @date:   2019年1月29日 下午1:55:49     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
import wechat.wechatApi.service.material.MaterialApiService;
@Service
public class WechatMaterialServiceImpl implements WechatMaterialService{

	static final String str = "\"errcode\":\"200\",";
	
	@Override
	public WechatMaterial getWechatMaterial(Integer id, String appId) {
		return materialMapper.getWechatMaterial(id, appId);
	}

	@Override
	public WechatMaterial getMaterialByMaterialId(String appId, String materialId) {
		return materialMapper.getMaterialByMaterialId(appId, materialId);
	}

	@Override
	public WechatMaterial saveMaterial(AddMaterialRequest addMaterialRequest, String appId, File file) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		AddMeterialResponse addMeterialResponse = apiService.addMaterial(addMaterialRequest, token, file);
		WechatMaterial wechatMaterial = new WechatMaterial();
		wechatMaterial.setAppId(appId);
		wechatMaterial.setMaterialJson(JSONObject.toJSONString(addMeterialResponse).replace(str, ""));
		wechatMaterial.setWechatUpdateTime(new Date().getTime()+"");
		wechatMaterial.setMediaId(addMeterialResponse.getMedia_id());
		wechatMaterial.setMediaType(addMaterialRequest.getType());
		Integer wechatMaterialId = materialMapper.saveWechatMaterial(wechatMaterial);
		return materialMapper.getWechatMaterial(wechatMaterialId, appId);
	}
	
	@Override
	public WechatMaterial saveNews(AddNewsRequest addNewsRequest, String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		AddNewsResponse addNewsResponse = apiService.addNews(addNewsRequest, token);
		//通过微信端返回的素材ID找到图文素材信息
		GetMaterialRequest getMaterialRequest = new GetMaterialRequest();
		getMaterialRequest.setMedia_id(addNewsResponse.getMedia_id());
		GetNewsResponse getNewsResponse = apiService.getNews(getMaterialRequest, token);
		
		WechatMaterial wechatMaterial = new WechatMaterial();
		wechatMaterial.setAppId(appId);
		wechatMaterial.setMaterialJson(JSONObject.toJSONString(getNewsResponse.getNews_item()).replace(str, ""));
		wechatMaterial.setWechatUpdateTime(new Date().getTime()+"");
		wechatMaterial.setMediaId(addNewsResponse.getMedia_id());
		wechatMaterial.setMediaType(MaterialConstant.MaterialType.REQ_MATERIAL_TYPE_NEWS);
		materialMapper.saveWechatMaterial(wechatMaterial);
		return wechatMaterial;
	}
	
	@Override
	public String uploadImg(UploadImgRequest imgRequest, String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		UploadImgResponse imgResponse = apiService.uploadImg(imgRequest, token);
		//保存入数据库(不需要保存入数据库中，交互原理是，前台使用异步提交的方式，在添加图文素材时直接返回图片的URL给前台就行。。但这里方便我们的后续测试，保存入数据库)
		WechatMaterial wechatMaterial = new WechatMaterial();
		wechatMaterial.setAppId(appId);
		wechatMaterial.setMaterialJson(JSONObject.toJSONString(imgResponse).replace(str, ""));
		wechatMaterial.setWechatUpdateTime(new Date().getTime()+"");
		wechatMaterial.setMediaId("NewsImg");
		wechatMaterial.setMediaType(MaterialConstant.MaterialType.REQ_MATERIAL_TYPE_IMAGE);
		materialMapper.saveWechatMaterial(wechatMaterial);
		return imgResponse.getUrl();
	}
	
	@Override
	public GetMaterialcountResponse getCount(String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		return apiService.getCount(token);
	}
	
	@Override
	public List<MaterialItems> getMaterialList(BatchgetMaterialRequest request, String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		List<MaterialItems> items = new ArrayList<>();
		//获取第一次素材列表(20条)
		BatchgetMaterialResponse materialResponse = apiService.getMaterialList(request, token);
		items.addAll(materialResponse.getItem());
		//比较一共要获取多少次(因为已经获取了一次，不需要再次加1)
		int count = (materialResponse.getTotal_count() / request.getCount());
		for(int i = 1 ; i <= count ; i++) {
			request.setOffset(request.getCount()* i);
			request.setCount(materialResponse.getTotal_count() - (i*20) > 20 ? 20 : materialResponse.getTotal_count() - (i*20));
			BatchgetMaterialResponse material = apiService.getMaterialList(request, token);
			if(material != null) {
				items.addAll(material.getItem());
			}
		}
		//遍历微信端返回的数据，转换成素材实体类
		List<WechatMaterial> list = new ArrayList<>();
        for (MaterialItems materialItems : items) {
			WechatMaterial wechatMaterial = new WechatMaterial();
			wechatMaterial.setAppId(appId);
			JSONObject object = new JSONObject();
			object.put("media_id", materialItems.getMedia_id());
			object.put("url", materialItems.getUrl());
			wechatMaterial.setMaterialJson(JSONObject.toJSONString(object));
			wechatMaterial.setWechatUpdateTime(materialItems.getUpdate_time());
			wechatMaterial.setMediaId(materialItems.getMedia_id());
			wechatMaterial.setMediaType(request.getType());
			list.add(wechatMaterial);
		}
		//删除数据库中的数据
		materialMapper.deleteWechatMaterial(appId, request.getType());
		//把微信端的素材信息同步入数据库
		materialMapper.saveWechatMaterialList(list);
		return items;
	}
	
	@Autowired
	private WechatMaterialMapper materialMapper;
	@Autowired
	private MaterialApiService apiService;


}