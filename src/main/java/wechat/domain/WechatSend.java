package wechat.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatSend extends AbstractDomain<Integer>  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private  Integer id ;
    /**群发对象标签ID**/
    private Integer tagId;
    /** 所属公众号appId */
    private  String appId ;
    /** 素材ID */
    private  Integer materialId ;
    /** 发送日期 */
    private  Date sendDate ;
    /** 发送时间（0至23） */
    private  Integer sendHour ;    
    /** 发送状态  1-未发送  2-发送成功  3-发送失败 */
    private  Integer status ;
    /**素材**/
    private WechatMaterial wechatMaterial;
    
	public WechatSend (){}
	
	
	/**未发送**/
	public static Integer SEND_STATUS_WAIT = 1;
	/**发送成功**/
	public static Integer SEND_STATUS_SUCCESS = 2;
	/**发送失败**/
	public static Integer SEND_STATUS_FAIL = 3;
}