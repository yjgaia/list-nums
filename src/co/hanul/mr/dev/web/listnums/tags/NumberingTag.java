package co.hanul.mr.dev.web.listnums.tags;

import java.io.IOException;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

/**
 * 넘버링 태그
 */
public class NumberingTag extends AbstractListNumsTag {
	private static final long serialVersionUID = 1L;

	private String gap;

	@Override
	public int doEndTag() throws JspException {
		try {
			if (gap == null) {
				gap = " ";
			}
			for (int i = dto.getStartPage(); i <= dto.getEndPage(); i++) {
				if (open != null) {
					pageContext.getOut().write(open);
				}
				boolean showLink = autoLink ? i != dto.getNowPage() : true;
				if (showLink) {
					Set<String> keySet = dynamicAttributes.keySet();
					String attributes = "";
					for (String key : keySet) {
						attributes += " " + key + "=\"" + ListNumsTagUtil.replaceListNumber(
							dynamicAttributes.get(key).toString(),
							i) + "\"";
					}
					pageContext.getOut().write(
						"<a href=\"" + ListNumsTagUtil.replaceListNumber(
							href,
							i) + "\"" + attributes + ">");
				}
				pageContext.getOut().write(Integer.toString(i));
				if (showLink) {
					pageContext.getOut().write("</a>");
				}
				if (close != null) {
					pageContext.getOut().write(close);
				}
				if (i != dto.getEndPage()) {
					pageContext.getOut().write(
						ListNumsTagUtil.replaceListNumber(gap, i));
				}
			}
		} catch (IOException e) {
			throw new JspTagException("Error" + e.toString());
		}
		return EVAL_PAGE;
	}

	public void setGap(String gap) {
		this.gap = gap;
	}

}
