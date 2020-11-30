package wechat.domain;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**事件触发
* @author ASUS
* @version 1.0
*/
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatReplyClick extends AbstractDomain<Integer>  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private  Integer id ; 
    /** 所属公众号appId */
    private  String appId ;
    /** 回复类型(1-关注后自动回复  2-默认回复) */
    private  Integer replyType ;
    /** 回复消息的内部*/
    private Integer replyContentId;
    
    private  WechatReplyContent wechatReplyContent;
	public WechatReplyClick (){}
	
	
 
}