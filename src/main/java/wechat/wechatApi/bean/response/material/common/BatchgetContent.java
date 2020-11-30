package wechat.wechatApi.bean.response.material.common;

import java.util.List;

import lombok.Data;
import lombok.ToString;
import wechat.wechatApi.bean.request.material.common.GetArticles;

@Data
@ToString
public class BatchgetContent {
	private List<GetArticles> news_item;

}
