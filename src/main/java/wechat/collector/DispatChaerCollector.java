package wechat.collector;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wechat.service.Message.NewsReplyService;
import wechat.wechatApi.bean.request.news.ReqMessage;
import wechat.wechatApi.config.WechatConfigureInfo;
import wechat.wechatApi.util.CheckUtil;
import wechat.wechatApi.util.serialize.SerializeUtil;

/**
 * 消息、事件回复Collector
 * @author: wulongwei
 * @date:   2019年1月18日 下午4:43:22     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Controller
public class DispatChaerCollector {
	/**
	 * 服务器验证的接口地址
     * 处理微信服务器发来的get请求，进行签名的验证
     * <p>
     * signature 微信端发来的签名
     * timestamp 微信端发来的时间戳
     * nonce     微信端发来的随机字符串
     * echostr   微信端发来的验证字符串
     */
	 @GetMapping(value = "/wechat")
	 @ResponseBody
	    public String validate(String signature, String timestamp, String nonce, String echostr) {
		//1.验证参数
		 return CheckUtil.checkSignature(signature, timestamp, nonce)? echostr : null;
	    }
	 
	
	 
	 /**
	  * 消息回复，事件处理
	  * @Title: validate  
	  * @return      
	  * @return: String
	 * @throws IOException 
	  */
	 @PostMapping(value = "/wechat")
	 @ResponseBody
	    public String validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 //1.解析微信端发送来的消息
		 ReqMessage reqMessage = SerializeUtil.xmlInputStreamToBean(request.getInputStream(),
				 ReqMessage.class);
			return newsReplyService.getMessageReply(reqMessage, WechatConfigureInfo.APP_ID);
	    }
	 
	 @Autowired
	 private NewsReplyService newsReplyService;
}
