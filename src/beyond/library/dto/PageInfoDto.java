package beyond.library.dto;

import org.springframework.stereotype.Component;

@Component
public class PageInfoDto {
    private String dimName;
    private int pageSize;
    private int pageNow;
    private String query_kinds;
    private int rowsCount;

    public String getDimName() {
	return dimName;
    }

    public void setDimName(String dimName) {
	this.dimName = dimName;
    }

    public int getPageSize() {
	return pageSize;
    }

    public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
    }

    public int getPageNow() {
	return pageNow;
    }

    public void setPageNow(int pageNow) {
	this.pageNow = pageNow;
    }

    public String getQuery_kinds() {
	return query_kinds;
    }

    public void setQuery_kinds(String queryKinds) {
	query_kinds = queryKinds;
    }

    public void setRowsCount(int rowsCount) {
	this.rowsCount = rowsCount;
    }

    public int getRowsCount() {
	return rowsCount;
    }
}
