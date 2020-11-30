package wechat.wechatApi.bean.request.material;

import java.io.File;

import lombok.Data;
import lombok.ToString;

/**
 * 上传图文消息内的图片获取URL：request
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:22:33     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class UploadImgRequest {
	// 文件项目名称
	private  File file;

}