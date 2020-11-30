package wechat.wechatApi.bean.response.material.common;

import java.util.List;

import lombok.Data;
import lombok.ToString;
import wechat.wechatApi.bean.request.material.common.Articles;

@Data
@ToString
public class Content {
	private List<Articles> news_item;
}
