package wechat.wechatApi.util;

import java.security.MessageDigest;
import java.util.Arrays;

import wechat.wechatApi.config.WechatConfigureInfo;
import wechat.wechatApi.constant.SystemConstant;




public class CheckUtil {


	  
	   public static boolean checkSignature(String signature,String timestamp,String nonce){
			String[] arr = new String[]{ WechatConfigureInfo.WECHAT_TOKEN,timestamp,nonce };
			//排序
			Arrays.sort(arr);	
			//生成字符串
			StringBuffer content = new StringBuffer();
			for(int i=0;i<arr.length;i++){
				content.append(arr[i]);
			}
			
			//sha1加密
			String temp = getSha1(content.toString());
			
			return temp.equals(signature);
		}
		
		/**
		 * Sha1加密方法
		 * @param str
		 * @return
		 */
		public static String getSha1(String str) {
			if (str == null || str.length() == 0) {
				return null;
			}
			char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };

			try {
				MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
				mdTemp.update(str.getBytes(SystemConstant.DEFAULT_CHARACTER_ENCODING));

				byte[] md = mdTemp.digest();
				int j = md.length;
				char buf[] = new char[j * 2];
				int k = 0;
				for (int i = 0; i < j; i++) {
					byte byte0 = md[i];
					buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
					buf[k++] = hexDigits[byte0 & 0xf];
				}
				return new String(buf);
			} catch (Exception e) {
				return null;
			}
		}

}

