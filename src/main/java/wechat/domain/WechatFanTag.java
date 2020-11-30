package wechat.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 * 微信粉丝标签实体类
 * @author: wulongwei
 * @date:   2019年2月16日 下午4:02:55     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatFanTag extends AbstractDomain<Integer>  implements Serializable {
   
	private static final long serialVersionUID = 1L;
    /** 微信分配的id */
    private  Integer id ;
    /** 用户所属公众号的appId */
	private String appId;
    /** 标签名 */
    private  String tagName ;
    /** 用户数 */
    private  Integer userCount ;
	public WechatFanTag (){}
	
	
}