package co.hanul.mr.dev.web.listnums.tags;

import java.io.IOException;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;

/**
 * 첫 페이지 태그
 */
public class FirstPageTag extends AbstractListNumsTag {
	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		try {
			if (autoHide ? dto.getStartPage() > 1 : true) {
				BodyContent body = getBodyContent();
				if (open != null) {
					pageContext.getOut().write(open);
				}
				boolean showLink = autoLink ? dto.getNowPage() != dto.getStartPage() : true;
				if (showLink) {
					String innerHref = ListNumsTagUtil.replaceListNumber(
						href,
						1);
					Set<String> keySet = dynamicAttributes.keySet();
					String attributes = "";
					for (String key : keySet) {
						attributes += " " + key + "=\"" + ListNumsTagUtil.replaceListNumber(
							dynamicAttributes.get(key).toString(),
							1) + "\"";
					}
					pageContext.getOut().write(
						"<a href=\"" + innerHref + "\"" + attributes + ">");
				}
				pageContext.getOut().write(body.getString());
				if (showLink) {
					pageContext.getOut().write("</a>");
				}
				if (close != null) {
					pageContext.getOut().write(close);
				}
			}
		} catch (IOException e) {
			throw new JspTagException("Error" + e.toString());
		}
		return EVAL_PAGE;
	}

}
