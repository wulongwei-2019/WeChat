package wechat.wechatApi.service.pay;

import com.alibaba.fastjson.JSONObject;

import wechat.wechatApi.bean.request.ValidateToken;

public interface testService {

	 /**
     * 创建 开放平台帐号并绑定公众号/小程序
     * @Title: openCreate  
     * @param jsonObject
     * @return      
     * @return: String
     */
    String openCreate(JSONObject jsonObject, ValidateToken validToken);
    
    /**
     * 将公众号/小程序绑定到开放平台帐号下
     * @Title: openBind  
     * @param jsonObject
     * @param validToken
     * @return      
     * @return: BaseOpenResponse
     */
    JSONObject openBind(JSONObject jsonObject, ValidateToken validToken);
}
