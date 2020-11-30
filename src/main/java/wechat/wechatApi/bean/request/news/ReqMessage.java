package wechat.wechatApi.bean.request.news;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wechat.wechatApi.bean.media.BaseMessage;


@XStreamAlias("xml")
public class ReqMessage extends BaseMessage {
	/** 内容 */
	private String Content;
	private String MsgId;
	/** 事件类型，subscribe(订阅)、unsubscribe(取消订阅) */
	private String Event;
	/** 事件KEY值，qrscene_为前缀，后面为二维码的参数值 */
	private String EventKey;
	/** 地理位置纬度 */
	private String Latitude;
	/** 地理位置经度 */
	private String Longitude;
	/** 地理位置纬度 */
	private String Precision;
	/** 二维码的ticket，可用来换取二维码图片 */
	private String Ticket;
	/** 获取到的菜单MenuId */
	private String MenuId;

	private Long SuccTime;

	private String Reason;

	private Long FailTime;

	public Long getSuccTime() {
		return SuccTime;
	}

	public void setSuccTime(Long succTime) {
		SuccTime = succTime;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public Long getFailTime() {
		return FailTime;
	}

	public void setFailTime(Long failTime) {
		FailTime = failTime;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	public String getMenuId() {
		return MenuId;
	}

	public void setMenuId(String menuId) {
		MenuId = menuId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Content == null) ? 0 : Content.hashCode());
		result = prime * result + ((Event == null) ? 0 : Event.hashCode());
		result = prime * result + ((EventKey == null) ? 0 : EventKey.hashCode());
		result = prime * result + ((Latitude == null) ? 0 : Latitude.hashCode());
		result = prime * result + ((Longitude == null) ? 0 : Longitude.hashCode());
		result = prime * result + ((MenuId == null) ? 0 : MenuId.hashCode());
		result = prime * result + ((MsgId == null) ? 0 : MsgId.hashCode());
		result = prime * result + ((Precision == null) ? 0 : Precision.hashCode());
		result = prime * result + ((Ticket == null) ? 0 : Ticket.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		ReqMessage other = (ReqMessage) obj;
		if (Content == null) {
			if (other.Content != null) {
				return false;
			}
		} else if (!Content.equals(other.Content)) {
			return false;
		}
		if (Event == null) {
			if (other.Event != null) {
				return false;
			}
		} else if (!Event.equals(other.Event)) {
			return false;
		}
		if (EventKey == null) {
			if (other.EventKey != null) {
				return false;
			}
		} else if (!EventKey.equals(other.EventKey)) {
			return false;
		}
		if (Latitude == null) {
			if (other.Latitude != null) {
				return false;
			}

		} else if (!Latitude.equals(other.Latitude)) {
			return false;
		}

		if (Longitude == null) {
			if (other.Longitude != null) {
				return false;
			}
		} else if (!Longitude.equals(other.Longitude)) {
			return false;
		}
		if (MenuId == null) {
			if (other.MenuId != null) {
				return false;
			}
		} else if (!MenuId.equals(other.MenuId)) {
			return false;
		}
		if (MsgId == null) {
			if (other.MsgId != null) {
				return false;
			}
		} else if (!MsgId.equals(other.MsgId)) {
			return false;
		}
		if (Precision == null) {
			if (other.Precision != null) {
				return false;
			}

		} else if (!Precision.equals(other.Precision)) {
			return false;
		}
		if (Ticket == null) {
			if (other.Ticket != null) {
				return false;
			}
		} else if (!Ticket.equals(other.Ticket)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ReqMessage [Content=" + Content + ", MsgId=" + MsgId + ", Event=" + Event + ", EventKey=" + EventKey
				+ ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Precision=" + Precision + ", Ticket="
				+ Ticket + ", MenuId=" + MenuId + "]";
	}

}
