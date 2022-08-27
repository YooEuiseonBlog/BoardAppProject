package com.prototype.portfolio.vo;

public class PagingVo {

	// paging
	private int onePageRecord; // 한 페이지에 출력할 레코드 수
	private int pageNum; // 현재 페이지
	private int totalRecord; // 총 레코드 수
	private int totalPage; // 총 페이지 수
	private int offsetIndex; // 오프셋
	private int onePageCount; // 한 번에 표시할 페이지 수
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지

	// search
	private String searchKey; // select값
	private String SearchValue; // 검색어

	public PagingVo() {
		this.onePageRecord = 5;
		this.pageNum = 1;
		this.offsetIndex = 0;
		this.onePageCount = 5;
		this.startPage = 1;
		this.searchKey = "";
		this.SearchValue = "";
	}
	
	public PagingVo(int pageNum, int totalRecord) {
		this();
		setPageNum(pageNum);
		setTotalRecord(totalRecord);	
	}
	
	public PagingVo(int pageNum, int totalRecord, String searchKey, String searchvalue) {
		this(pageNum, totalRecord);
		this.searchKey = searchKey;
		this.SearchValue = searchvalue;
	}



	public PagingVo(int onePageRecord, int pageNum, int totalRecord, int totalPage, int offsetIndex, int onePageCount,
			int startPage, int endPage, String searchKey, String searchValue) {
		super();
		this.onePageRecord = onePageRecord;
		this.pageNum = pageNum;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.offsetIndex = offsetIndex;
		this.onePageCount = onePageCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.searchKey = searchKey;
		this.SearchValue = searchValue;
	}

	// getter and setter

	// paging
	public int getOnePageRecord() {
		return onePageRecord;
	}

	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		// offset 위치 계산
		this.offsetIndex = this.onePageRecord * (this.pageNum - 1);
		// 페이지 번호 시작값
		this.startPage = ((this.pageNum - 1) / this.onePageCount * this.onePageCount + 1);
		this.endPage = this.startPage + onePageCount - 1;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;

		// ex) 총 페이지 수(레코드 수가 26개면 페이지 수는 6개 / 페이지당 레코드 수 5개인 경우)
		if (this.totalRecord % this.onePageRecord == 0) {
			// 나머지 레코드가 없는 경우
			this.totalPage = this.totalRecord / this.onePageRecord;
		} else {
			// 나머지 레코드가 있는 경우
			this.totalPage = this.totalRecord / this.onePageRecord + 1;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOffsetIndex() {
		return offsetIndex;
	}

	public void setOffsetIndex(int offsetIndex) {
		this.offsetIndex = offsetIndex;
	}

	public int getOnePageCount() {
		return onePageCount;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return this.startPage + this.onePageCount - 1;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	// search
	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchValue() {
		return SearchValue;
	}

	public void setSearchValue(String searchValue) {
		SearchValue = searchValue;
	}

	@Override
	public String toString() {
		return "PagingVo [onePageRecord=" + onePageRecord + ", pageNum=" + pageNum + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", offsetIndex=" + offsetIndex + ", onePageCount=" + onePageCount
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", searchKey=" + searchKey + ", SearchValue="
				+ SearchValue + "]";
	}

}
