package beyond.library.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import beyond.library.dto.PageInfoDto;

/**
 * 分页标签
 * 
 * @author Administrator
 * 
 */
public class PagingTag extends BodyTagSupport {

    private PageInfoDto pageInfoDto;
    private String href;

    @Override
    public int doStartTag() throws JspException {
	pageInfoDto = (PageInfoDto) pageContext.getRequest().getAttribute(
		"pageInfoDto");
	return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {

	int pageSize = pageInfoDto.getPageSize();
	int pageNow = pageInfoDto.getPageNow();
	int rowsCount = pageInfoDto.getRowsCount();
	int pageCount = (rowsCount - 1) / pageSize + 1;
	
	if (pageCount != 1)
	    for (int i = 1; i <= pageCount; i++) {
		try {
		    if (i == pageNow)
			pageContext.getOut().write(" " + i + " ");
		    else
			pageContext.getOut().write(
				"<a href='" + href + "?pageNow=" + i + "'>"
					+ "<" + i + ">" + "</a>");
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	return EVAL_PAGE;
    }

    public void setHref(String href) {
	this.href = href;
    }

    public String getHref() {
	return href;
    }

}
