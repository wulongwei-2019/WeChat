package wechat.domain;
import java.io.Serializable;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**关键词回复内容
* @author ASUS
*/
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatReplyContent extends AbstractDomain<Integer>  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 所属公众号appId */
    private  String appId ;
    /** 主键 */
    private  Integer id ;
    /** 消息类型（text-文本，news-图文 ，image-图片，voice-音乐，video-视频，music-音乐） */
    private  String msgType ;
    /** 规则名称 */
    private  String ruleName ;
    /** 排序 */
    private  Integer sortNum ;
    /** 素材ID */
    private  Integer mediaId ;
    /** 回复的消息内容 */
    private  String content ;
    /** 音乐标题 */
    private  String title ;
    /** 音乐描述 */
    private  String description ;
    /** 音乐链接 */ 
    private  String musicUrl ; 
    /** 高质量音乐链接 */
    private  String hqMusicUrl ;
 
    /**关键字*/
    private List<WechatReplyKeyword> wechatReplyKeywordList;
   /**事件促发*/
    private List<WechatReplyClick> wechatReplyClick;
    /**素材*/
    private WechatMaterial wechatMaterial;
	public WechatReplyContent (){}
	

   
}   
