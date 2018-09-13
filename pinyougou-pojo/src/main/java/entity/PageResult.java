package entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {

	private long totalPage;
	private List pageMessage;
	
	public PageResult(long totalPage,List pageMessage) {
		this.totalPage=totalPage;
		this.pageMessage=pageMessage;
	}
	
	public List getPageMessage() {
		return pageMessage;
	}
	public void setPageMessage(List pageMessage) {
		this.pageMessage = pageMessage;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	
}
