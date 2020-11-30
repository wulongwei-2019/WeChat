package wechat.collector;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import wechat.wechatApi.config.WechatConfigureInfo;
import wechat.wechatApi.constant.SystemConstant;
import wechat.wechatApi.util.HttpReqUtil;

/**
 * 用户授权Collector
 * 
 * @author: wulongwei
 * @date: 2019年1月18日 下午4:40:48
 * @Copyright: 江西金磊科技发展有限公司 All rights reserved. Notice
 *             仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Controller
public class AuthorizedLandCollector {

	/**
	 * 进入授权页面
	 * 
	 * @Title: toLogin
	 * @return
	 * @return: String
	 */
	@GetMapping(value = "/toLogin")
	public String toLogin() {
		return "authorization";
	}

	/**
	 * 获取回调地址
	 * 
	 * @Title: validate
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @return: void
	 */
	@GetMapping(value = "/wxLogin")
	@ResponseBody
	public void validate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 回调地址（必须在公网进行访问） 测试号管理-----> JS接口安全域名
		String backUrl = "http://wlw1996.ngrok.xiaomiqiu.cn/callback";
		@SuppressWarnings("deprecation")
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WechatConfigureInfo.APP_ID
				+ "&redirect_uri=" + URLEncoder.encode(backUrl) + "&response_type=code" + "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		// 重定向
		resp.sendRedirect(url);
	}

	/**
	 * 获取code、拉取授权用户信息
	 * 
	 * @Title: callBack
	 * @param req
	 * @param resp
	 * @param modelMap
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @return: String
	 */
	@GetMapping(value = "/callback")
	public String callBack(HttpServletRequest req, HttpServletResponse resp, ModelMap modelMap)
			throws ServletException, IOException {
		/**
		 * 3.获取code
		 */
		String code = req.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WechatConfigureInfo.APP_ID
				+ "&secret=" + WechatConfigureInfo.APP_SECRET + "&code=" + code + "&grant_type=authorization_code";
		JSONObject jsonObject;
		try {
			jsonObject = HttpReqUtil.HttpsDefaultExecute(SystemConstant.GET_METHOD, url, null, null, null, JSONObject.class);
			System.out.println(jsonObject);
			String openid = jsonObject.getString("openid");
			String token = jsonObject.getString("access_token");
			/**
			 * 4.拉取用户信息
			 */
			String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token + "&openid=" + openid
					+ "&lang=zh_CN";
			JSONObject userInfo = HttpReqUtil.HttpsDefaultExecute("GET", infoUrl, null, null, null, JSONObject.class);
			System.out.println(userInfo);
			modelMap.addAttribute("info", userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
