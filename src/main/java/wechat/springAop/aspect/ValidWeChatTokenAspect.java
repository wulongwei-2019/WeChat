package wechat.springAop.aspect;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wechat.ValidWeChatToken;
import wechat.domain.AbstractWeChatOpen;
import wechat.domain.AbstractWeChatToken;
import wechat.mapper.AbstractWeChatOpenMapper;
import wechat.mapper.AbstractWeChatTokenMapper;
import wechat.service.WeChatInfo.AbstractWeChatTokenService;
import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.response.token.AuthorizerAccessTokenResponse;
import wechat.wechatApi.constant.wechatConstant;
import wechat.wechatApi.service.accessToKen.AccessToKenService;

/**
 * 处理添加@ValidWeChatToken注解的方法拦截业务，会判断是否存在或者过期，然后自动调用相关接口刷新（处理比较简便以后再扩充）
 * 
 * @author: wulongwei
 * @date: 2019年1月30日 下午5:45:23
 * @Copyright: 江西金磊科技发展有限公司 All rights reserved. Notice
 *             仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Component
@Aspect
public class ValidWeChatTokenAspect {

	/*
	 * // 定义一个Pointcut(切入点)。使用切点表达式函数 来描述对哪些 join point(连接点)使用通知
	 * 
	 * @Pointcut("@annotation(ValidWeChatToken)") public void
	 * pointcut(ValidWeChatToken validWeChatToken) {
	 * 
	 * }
	 */

	// 定义advise(通知)
	@Before(value = "@annotation(validWeChatToken)")
	public Object checkAuth(JoinPoint joinPoint, ValidWeChatToken validWeChatToken) throws Throwable {
		// 获取注解函数上的所有参数
		Object[] params = joinPoint.getArgs();
		//String annonationParam = validWeChatToken.value();//authorizerAccessToken
		ValidateToken validaToken = null;
		AbstractWeChatToken token = null;
		if (params != null && params.length > 0) {
			for (Object object : params) {
				if (ValidateToken.class.isAssignableFrom(object.getClass())) {
					validaToken = (ValidateToken) object;
					break;
				}
			}
			if (validaToken != null) {
				// 验证token是否存在过期
				// 验证authorizerAccessToken
				token = this.validateAuthorizerAccessToken(validaToken);
				validaToken.setAccessToken(token.getAuthorizerAccessToken());
				return token;
			}else {
				return null;//返回自定义异常，缺少token参数
			}
		}else {
			return null;//返回自定义异常，缺少token参数
		}
	}

	/**
	 * 通过appId找到token，验证token是否有效，如果无效，重新获取一个token，保存数据库，并返回
	 * @Title: validateAuthorizerAccessToken        
	 * @return: void
	 */
	AbstractWeChatToken validateAuthorizerAccessToken(ValidateToken token){
		//1.通过appId获取对应公众号的信息
		AbstractWeChatOpen chatOpen = chatOpenMapper.getAbstractWeChatOpen(token.getAppId());
		if(chatOpen != null && chatOpen.getAppId() != null) {
			//2.获取当前appId对应的token
			AbstractWeChatToken chatToken =chatTokenMapper.getAbstractWeChatToken(token.getAppId());
			if(chatToken != null && chatToken.getComponentAccessToken() != null) {
				//3. 获取当前毫秒数
				Long currentMillisecond = System.currentTimeMillis();
				//4. 获取token 生成时的毫秒数
				Long createMillisecond = chatToken.getAcceccTokenCreateTime() == null ? 0L :chatToken.getAcceccTokenCreateTime().getTime();
				//5. 比较如果时间相差一个半小时，重新获取新的token
				if (currentMillisecond - createMillisecond > wechatConstant.Expire.VALUE) {
					//6.重新调用微信端接口获取新的token
					AuthorizerAccessTokenResponse  authTokenRsp = getAccessToKen(chatOpen.getAppId(), chatOpen.getAppSecret());
					token.setAccessToken(authTokenRsp.getAccess_token());
				}
			}
			return chatToken;
		}else {
			return null;//返回自定义异常
		}
	}
 
	AuthorizerAccessTokenResponse getAccessToKen(String appId, String secret) {
		//获取到新的token信息
		AuthorizerAccessTokenResponse tokenResponse = accessToKenService.getAccessToKen(appId, secret);
		//保存入数据库
		AbstractWeChatToken chatToken = chatTokenService.getAbstractWeChatToken(appId);
		chatToken.setComponentAccessToken(tokenResponse.getAccess_token());
		chatToken.setAuthorizerAccessToken(tokenResponse.getAccess_token());
		chatToken.setAcceccTokenCreateTime(new Date());
		chatTokenService.updateWeChatToken(chatToken);
		return tokenResponse;
	}

	@Autowired
	private AbstractWeChatTokenMapper chatTokenMapper;
	@Autowired
	private AbstractWeChatOpenMapper chatOpenMapper;
	@Autowired
	private AccessToKenService accessToKenService;
	@Autowired
	private AbstractWeChatTokenService chatTokenService;
}
