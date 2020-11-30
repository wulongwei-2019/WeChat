package wechat.wechatApi.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.thoughtworks.xstream.XStream;

import wechat.wechatApi.bean.request.news.ImageMessageRequest;
import wechat.wechatApi.bean.request.news.MusicMessageRequest;
import wechat.wechatApi.bean.request.news.TextMessageRequest;

/**
 * 对象结构转换
 * 
 * @author: wulongwei
 * @date: 2019年1月30日 下午5:22:59
 * @Copyright: 江西金磊科技发展有限公司 All rights reserved. Notice
 *             仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class MessageUtil {

	// XML数据转成Map集合的方法
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();

		// 从request中获取输入流
		InputStream inputStream = request.getInputStream();
		Document document = reader.read(inputStream);
		// 获取XML的根元素
		Element root = document.getRootElement();
		// 得到根元素的所有节点，放在list集合中
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		// 遍历集合
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		System.out.println(map);
		inputStream.close();
		return map;
	}

	/**
	 * 将文本消息对象转为XML
	 * 
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXML(TextMessageRequest textMessage) {
		String result = "";
		if (textMessage != null) {
			XStream xstream = new XStream();
			xstream.alias("xml", textMessage.getClass());
			result = xstream.toXML(textMessage);
		}
		return result;
	}
 
	/**
	 * 图片消息转为xml
	 * 
	 * @param imageMessage
	 * @return
	 */
	public static String imageMessageToXml(ImageMessageRequest imageMessage) {
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * 音乐消息转为xml
	 * 
	 * @param musicMessage
	 * @return
	 */
	public static String musicMessageToXml(MusicMessageRequest musicMessage) {
		XStream xstream = new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

}
