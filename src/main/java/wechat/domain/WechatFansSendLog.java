package wechat.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatFansSendLog extends AbstractDomain<Integer>  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id ;
    /** 粉丝所属公众号app_id */
    private  String appId ;
    /** openId */
    private  String openId ;
    /** 发送状态（1-发送成功  2-发送失败） */
    private  Integer sendStatus ;
    /** 消息类型（text-文本，mpnews-图文 ，image-图片，voice-音乐，video-视频，music-音乐） */
    private  String msgType ;
    /** 素材json */
    private  String mediaJson ;
    
	public WechatFansSendLog (){}
	
}