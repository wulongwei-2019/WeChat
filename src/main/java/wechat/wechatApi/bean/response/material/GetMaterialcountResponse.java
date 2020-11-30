package wechat.wechatApi.bean.response.material;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import wechat.wechatApi.bean.response.BaseResponse;

/**
 * 获取素材总数：response
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:41:40     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class GetMaterialcountResponse extends BaseResponse{
	// 语音总数量
	private Integer voice_count;
	// 视频总数量
	private Integer video_count;
	// 图片总数量
	private Integer image_count;
	// 图文总数量
	private Integer news_count;
	
}
