package wechat.wechatApi.bean.request.material;

import lombok.Data;
import lombok.ToString;
import wechat.wechatApi.bean.request.material.common.Articles;

/**
 * 修改永久图文素材：request
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:21:53     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class UpdateNewsRequest {
	/** 要修改的图文消息的id*/
	private Integer id;
	/** 要修改的图文消息的media_id*/
	private String media_id;
	/** 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0*/
	private Integer index;
	/** 图文素材对象*/
	private Articles articles;
	
}
