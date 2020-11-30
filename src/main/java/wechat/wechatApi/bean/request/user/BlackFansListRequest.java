package wechat.wechatApi.bean.request.user;

import lombok.Data;
import lombok.ToString;

/**
 * https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:公众号可通过该接口来获取帐号的黑名单列表，黑名单列表由一串 OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
    该接口每次调用最多可拉取 10000 个OpenID，当列表数较多时，可以通过多次拉取的方式来满足需求。
 * @author: wulongwei
 * @date:   2019年2月16日 下午3:46:39     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@ToString
@Data
public class BlackFansListRequest {

    /**调用接口凭证**/
    private String access_token;
    
    /**第一个拉取的OPENID，不填默认从头开始拉取**/
    private String begin_openid;        
}
