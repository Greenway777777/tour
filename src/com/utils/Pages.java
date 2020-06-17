package com.utils;

import java.util.ArrayList;
import java.util.List;

public class Pages {

	private int totalCount;//总记录数
    private int currentPage = 1;//当前页
    private int pageSize = 3;//页面容量
    
    
    private int totalPage;//总页数
    private int prePage;//上一页
    private int nextPage;//下一页
    
    
    private List<Integer> pageList;

    public Pages() {
    }

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		if (this.getTotalCount() % this.getPageSize() == 0)
		{
            this.totalPage = this.getTotalCount() / this.getPageSize();//能整除
        } 
		else 
		{
            this.totalPage = this.getTotalCount() / this.getPageSize() + 1;//不能整除
        }
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPrePage() {
		if (this.getCurrentPage() > 1) 
		{
            this.prePage = this.getCurrentPage() - 1;
        } 
		else 
		{
            this.prePage = 1;
        }
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		if 
		(this.getCurrentPage() < this.getTotalPage()) {
            this.nextPage = this.getCurrentPage() + 1;
        } 
		else
		{
            this.nextPage = this.getTotalPage();
        }
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	//保存页码
	public List<Integer> getPageList() {
		this.pageList = new ArrayList<Integer>();

        for(int i = 0; i < getTotalPage(); ++i) {
            pageList.add(i + 1);
        }
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}
    
    
}
