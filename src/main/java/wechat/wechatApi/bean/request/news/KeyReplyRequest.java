package wechat.wechatApi.bean.request.news;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN
 * @Description: 自动回复回调请求数据
 * @author: wulongwei
 * @date:   2019年1月17日 下午4:24:10     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@XStreamAlias("xml") 
public class KeyReplyRequest{

	/**接受方用户*/
	@XStreamAlias("ToUserName")  
	private String toUserName;
	
	/**Ticket内容加密内容*/
	@XStreamAlias("Encrypt")
	private String encrypt;

	
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}
	
}



 