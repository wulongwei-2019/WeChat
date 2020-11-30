package wechat.wechatApi.bean.request.material;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 新增其它类型永久素材：request
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:26:42     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class AddMaterialRequest extends BaseMaterialRequest{
	/**
	 * 文件路径
	 */
	private  String fileName;

	public AddMaterialRequest(String type, String fileName) {
		super(type);
		this.fileName = fileName;
	}

	public AddMaterialRequest() {
		super();
	}

}
