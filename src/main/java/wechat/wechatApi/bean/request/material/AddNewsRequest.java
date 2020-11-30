package wechat.wechatApi.bean.request.material;

import java.util.List;

import lombok.Data;
import lombok.ToString;
import wechat.wechatApi.bean.request.material.common.SaveArticles;
/**
 * 新增图文素材
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:26:11     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class AddNewsRequest {
	/** 图文消息集合 */
	private List<SaveArticles> articles;
	
	public AddNewsRequest(List<SaveArticles> articles) {
		super();
		this.articles = articles;
	}

	public AddNewsRequest() {
		super();
	}

}
