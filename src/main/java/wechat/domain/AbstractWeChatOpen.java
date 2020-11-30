package wechat.domain;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



/** 
 * 
 * @Description:开放平台应用配置信息(第三方服务配置)
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class AbstractWeChatOpen extends AbstractDomain<Integer>  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	/** 名称  */
	private String name;
	/** api地址(服务开发方的appid) */
	private String appId;
	/** AppSecret */
	private String appSecret;
	/** 消息加解密Key */
	private String messageDecryptKey;
	/**消息校验Token */
	private String messageValidateToken;
	/**微信公众号头像*/
	private String logo;
	
    
	public AbstractWeChatOpen() {
	}
	
	


}