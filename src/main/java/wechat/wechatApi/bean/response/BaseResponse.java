package wechat.wechatApi.bean.response;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信公众平台请求返回基本状态数据.
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:30:50     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class BaseResponse {



	@JSONField(serialize=false)
    public final String SUCCESS_CODE = "200";
    private String errcode;
    private String errmsg;

    public String getErrcode() {
        return (errcode == null  || "0".equals(errcode))? SUCCESS_CODE : Integer.parseInt(errcode) > 0 ? String.valueOf(0-(Integer.parseInt(errcode))) : errcode;
    }

    public void setErrcode(String errcode) {
       this.errcode = errcode;
    }

    public void setErrmsg(String errmsg) {
    	this.errmsg = errmsg;
    }


    public String getErrmsg() {
    	Integer codeKey = Integer.parseInt(getErrcode());
    	if(codeKey != 200 && codeKey < -1 ){
    		codeKey = Math.abs(codeKey);
    	}
        String msg = ReturnCode.get(codeKey);
        return StringUtils.isEmpty(msg) ? errmsg : msg;
	}


	@Override
    public String toString() {
        return "BaseResponse{" +
                "errcode=" + getErrcode() +
                ", errmsg='" + getErrmsg() + '\'' +
                '}';
    }


}
