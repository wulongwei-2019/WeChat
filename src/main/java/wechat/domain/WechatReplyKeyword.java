package wechat.domain;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



/**关键字
* @author ASUS
* @version 1.0
*/
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatReplyKeyword extends AbstractDomain<Integer>  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id ;
    /** 所属公众号appId */
    private  String appId ;
    /**回复内容ID  */
    private  Integer replyContentId ;
    /**关键词(精确匹配)  */
    private  String wordkeyEq ;
    /**关键词(模糊匹配)  */
    private  String wordkeyLike ;
 
    private String[] keyEq;
    private String[] keyLike;
    private WechatReplyContent wechatReplyContent;
    
	public WechatReplyKeyword (){}


}