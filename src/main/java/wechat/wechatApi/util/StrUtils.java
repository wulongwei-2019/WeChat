package wechat.wechatApi.util;

import java.security.SecureRandom;
import java.util.Random;

public class StrUtils {

	/**
	 * 生成指定随机数
	 * 
	 * @Title: getCaptcha
	 * @Description:
	 * @param: @return
	 * @return: String
	 */
	public static String getRandStr(int num) {
		// 默认6位
		num = num != 0 ? num : 6;
		Random r = new SecureRandom();
		StringBuffer str = new StringBuffer();
		int i = 0;
		while (i < num) {
			str.append(r.nextInt(10));
			i++;
		}
		return str.toString();
	}
}
