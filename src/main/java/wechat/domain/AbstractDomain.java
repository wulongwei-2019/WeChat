package wechat.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class AbstractDomain<ID extends Serializable>{

	/**删除标识*/
	private Boolean hasDeletd;
	
}
