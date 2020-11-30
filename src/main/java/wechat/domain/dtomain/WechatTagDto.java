package wechat.domain.dtomain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WechatTagDto {

	/**标签名（30个字符以内）*/
	private String name;
	/**标签id，由微信分配*/
	private Integer id;
}
