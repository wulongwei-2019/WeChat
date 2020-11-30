package wechat.collector;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import wechat.wechatApi.util.HttpReqUtil;
import wechat.wechatApi.util.ShareUtil;


/**
 * 微信分享朋友圈(最简版本)
 * @author: wulongwei
 * @date:   2019年2月16日 下午3:42:49     
 */

@Controller
public class WeixinShareController {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
    //appid 
	public static final String APP_ID = "wx775ca6325a3255ef";
	//appsecret
	public static final String SECRET = "2675d7e74ae6813a5fdded38c3ae9120";
	
	/**
	 * 获取微信签名
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getSignature", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> WeixinController(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        Map<String, String> ret = new HashMap<>();
		
		//获取前台传来的三个参数
		String timestamp = request.getParameter("timestamp");
		String nonce_str = request.getParameter("nonce_str");
		String url = request.getParameter("url");
		logger.info("url"+url+"==============="+nonce_str+"============"+timestamp);
	   
		//从缓存中读取token信息，如果没有则获取一个新的token，通过token获取ticket信息
		String access_token = (String)request.getSession().getAttribute("access_token"); 
		if(access_token == null) {
			
			 /** 获取AccessToKen*/
			 String getAccessToKen = "https://api.weixin.qq.com/cgi-bin/token?"
			 		+ "grant_type=client_credential&appid="+APP_ID+"&secret="+ SECRET;
			 JSONObject	 jsonObject = HttpReqUtil.HttpsDefaultExecute("GET", getAccessToKen, null, null, null, JSONObject.class);
			
			 /**获取jsapi_ticket*/
			String getTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+jsonObject.get("access_token").toString()+"&type=jsapi";
			JSONObject rest = HttpReqUtil.HttpsDefaultExecute("GET", getTicket, null, null, null, JSONObject.class);
			
			/**将信息保存入缓存中*/
			request.getSession().setAttribute("token", jsonObject.get("access_token").toString());
			request.getSession().setAttribute("ticket", rest.get("ticket").toString());
		}        
			/**生成签名*/
			String ticket = (String)request.getSession().getAttribute("ticket"); //微信返回的ticket			
			String signature = ShareUtil.getSignature(ticket,url,nonce_str,timestamp); //获取签名
	 
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        return ret;
	}
	
	/**
	 * 进入主页
	 * @return
	 */
	@RequestMapping(value="doIndex")
	public String index(){
		return "index";
	}
	
	/**
	 * 进入分享成功后跳转页面
	 * @return
	 */
	@RequestMapping(value="doResult")
	public String doResult(){
		return "share_result";
	}
	
}
