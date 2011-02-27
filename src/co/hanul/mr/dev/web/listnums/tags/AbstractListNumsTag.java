package co.hanul.mr.dev.web.listnums.tags;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;

import co.hanul.mr.dev.web.listnums.ListNumsDTO;

/**
 * 리스트 넘버 태그의 슈퍼클래스
 */
public abstract class AbstractListNumsTag extends BodyTagSupport implements DynamicAttributes {
	private static final long serialVersionUID = 1L;

	protected ListNumsDTO dto;
	protected String href;
	protected Map<String, Object> dynamicAttributes = new HashMap<String, Object>();

	protected String open;
	protected String close;

	protected boolean autoHide = true;
	protected boolean autoLink = true;

	public void setDto(ListNumsDTO dto) {
		this.dto = dto;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		dynamicAttributes.put(localName, value);
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public void setAutoHide(boolean autoHide) {
		this.autoHide = autoHide;
	}

	public void setAutoLink(boolean autoLink) {
		this.autoLink = autoLink;
	}

}
