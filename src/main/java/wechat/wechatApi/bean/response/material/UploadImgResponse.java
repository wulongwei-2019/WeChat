package wechat.wechatApi.bean.response.material;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import wechat.wechatApi.bean.response.BaseResponse;

/**
 * 上传图文消息内的图片获取URL：response
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:43:32     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class UploadImgResponse extends BaseResponse{
	// 图片url地址
	private String url;

}
