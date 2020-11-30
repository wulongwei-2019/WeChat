package wechat.wechatApi.bean.request;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * 消息基类
 * @author: wulongwei
 * @date:   2019年1月17日 下午1:50:29     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class BaseMsg implements Serializable{

	private static final long serialVersionUID = 1L;
	private String ToUserName; // 开发者微信号
	private String FromUserName; // 发送方帐号（一个OpenID）
	private int CreateTime; // 消息创建时间 （整型）
	private long MsgId; // 消息id，64位整型
	
	/**
	 * lombok 简化比较繁琐的代码 原理:底层使用字节码技术 ASM 修改字节码文件，生成get和set方法
	 * 最终编译的时候还是会生产get set方法
	 * javaasist
	 */	
}
