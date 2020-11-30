package wechat.collector;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wechat.domain.dtomain.SendingDto;
import wechat.service.Send.GroupSendingService;
import wechat.wechatApi.config.WechatConfigureInfo;

/**
 * 群发控制层(因未认证，只能调用群发文本接口)
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:13:54     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Controller
@RequestMapping(value = "/wroupSending")
public class GroupSendingCollector {

	/**
	 * 根据OpenID列表群发(因未认证，只能调用群发文本接口)
	 */
	@PostMapping(value = "/byOpenIDSend")
	@ResponseBody
	public String byOpenIDSend(@RequestBody @Validated SendingDto sendingDto, HttpServletRequest request) {
		String appId=WechatConfigureInfo.APP_ID;
		sendingService.byOpenIDSend(sendingDto, appId);
		return "OK";
	}
	
	/**
	 * 预览接口(开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。)
	 */
	@PostMapping(value = "/preview")
	@ResponseBody
	public String preview(@RequestBody @Validated SendingDto sendingDto, HttpServletRequest request) {
		String appId=WechatConfigureInfo.APP_ID;
		sendingService.preview(sendingDto, appId);
		return "OK";
	}
	
	/**
	 * 根据标签进行群发
	 */
	@PostMapping(value = "/sendall")
	@ResponseBody
	public String sendall(@RequestBody @Validated SendingDto sendingDto, HttpServletRequest request) {
		String appId=WechatConfigureInfo.APP_ID;
		sendingService.preview(sendingDto, appId);
		return "OK";
	}
	
	
	@Autowired
	private GroupSendingService sendingService;
}
