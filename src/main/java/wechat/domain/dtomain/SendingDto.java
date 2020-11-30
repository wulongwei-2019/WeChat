package wechat.domain.dtomain;
import java.util.List;

import lombok.Data;
import lombok.ToString;


/**
 * 群发消息扩展实体类
 * @author: wulongwei
 * @date:   2019年2月16日 上午11:05:41     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@ToString
@Data
public class SendingDto {
	/**通过openId群发*/
	public static final Integer REQ_TYPE_OPENID = 1;
	/**通过标签群发*/
	public static final Integer REQ_TYPE_FILTER = 2;
	
    /**填写消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个*/
	private List<String> touser;
	
	/**群发文本的内容*/
	private String text;
	
	/**群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard*/
	private String msgtype;
	
	/**图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。*/
	private Integer send_ignore_reprint;
	
	/**	消息的描述 */
	private String description;
	
	/**用于群发的消息的media_id */
	private String media_id;
	
	/**消息的标题 */
	private String title;
	
	/**视频缩略图的媒体ID */
	private String thumb_media_id;
	
	/**卡券的参数*/
	private String card_id;
	
	/**用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户*/
	private Boolean is_to_all;
	
	/**群发到的标签的tag_id，参见用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id*/
	private Integer tag_id;
}
