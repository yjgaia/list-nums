package co.hanul.mr.dev.web.listnums;

/**
 * 리스트 넘버를 저장하는 DTO
 */
public class ListNumsDTO {

	private int blockCount; // 한 페이지의 게시물 수
	private int totalCount; // 전체 게시물 수

	private int blockPage; // 한 화면에 보여줄 페이지 수
	private int totalPage; // 전체 페이지 수

	private int startPage; // 시작 페이지
	private int nowPage = 1; // 현재 페이지
	private int endPage; // 마지막 페이지

	private int startRowNum;
	private int endRowNum;

	// Getters and Setters...

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

}
