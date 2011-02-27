package co.hanul.mr.dev.web.listnums;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import co.hanul.mr.dev.web.CookieBox;;

/**
 * 리스트 넘버 제공자
 * 
 * @author Mr. 하늘
 */
public class ListNumsProvider {

	public static final String blockCountCookieName = "listInfo.blockCount";
	public static final String blockPageCookieName = "listInfo.blockPage";

	/**
	 * 쿠키를 사용하여 리스트 넘버 구하기 (CookieBox 사용)
	 */
	public static ListNumsDTO createListNumsUsingCookie(
			HttpServletRequest request,
			int nowPage,
			int totalCount,
			int blockCount,
			int minBlockCount,
			int maxBlockCount,
			int blockPage,
			int minBlockPage,
			int maxBlockPage) throws IOException {
		ListNumsDTO listNums = new ListNumsDTO();
		serveListNumsUsingCookie(
			listNums,
			request,
			nowPage,
			totalCount,
			blockCount,
			minBlockCount,
			maxBlockCount,
			blockPage,
			minBlockPage,
			maxBlockPage);
		return listNums;
	}

	/**
	 * 쿠키를 사용하여 리스트 넘버 채우기 (CookieBox 사용)
	 */
	public static void serveListNumsUsingCookie(
			ListNumsDTO listNums,
			HttpServletRequest request,
			int nowPage,
			int totalCount,
			int blockCount,
			int minBlockCount,
			int maxBlockCount,
			int blockPage,
			int minBlockPage,
			int maxBlockPage) throws IOException {

		CookieBox cookies = new CookieBox(request);

		if (cookies.exists(blockCountCookieName) && cookies.exists(blockPageCookieName)) {

			String blockCountStr = cookies.getValue(blockCountCookieName);
			String blockPageStr = cookies.getValue(blockPageCookieName);

			blockCount = Integer.parseInt(blockCountStr);
			blockPage = Integer.parseInt(blockPageStr);
		}

		serveListNums(
			listNums,
			nowPage,
			totalCount,
			blockCount,
			minBlockCount,
			maxBlockCount,
			blockPage,
			minBlockPage,
			maxBlockPage);
	}

	/**
	 * 동적으로 리스트 넘버 구하기
	 */
	public static ListNumsDTO createListNums(
			int nowPage,
			int totalCount,
			int blockCount,
			int minBlockCount,
			int maxBlockCount,
			int blockPage,
			int minBlockPage,
			int maxBlockPage) {
		ListNumsDTO listNums = new ListNumsDTO();
		serveListNums(
			listNums,
			nowPage,
			totalCount,
			blockCount,
			minBlockCount,
			maxBlockCount,
			blockPage,
			minBlockPage,
			maxBlockPage);
		return listNums;
	}

	/**
	 * 동적으로 리스트 넘버 채우기
	 */
	public static void serveListNums(
			ListNumsDTO listNums,
			int nowPage,
			int totalCount,
			int blockCount,
			int minBlockCount,
			int maxBlockCount,
			int blockPage,
			int minBlockPage,
			int maxBlockPage) {

		// 값이 너무 작거나 클 경우
		if (blockCount < minBlockCount) {
			blockCount = minBlockCount;
		}
		if (blockCount > maxBlockCount) {
			blockCount = maxBlockCount;
		}
		if (blockPage < minBlockPage) {
			blockPage = minBlockPage;
		}
		if (blockPage > maxBlockPage) {
			blockPage = maxBlockPage;
		}

		serveListNums(listNums, nowPage, totalCount, blockCount, blockPage);
	}

	/**
	 * 정적으로 리스트 넘버 구하기
	 */
	public static ListNumsDTO createListNums(
			int nowPage,
			int totalCount,
			int blockCount,
			int blockPage) {
		ListNumsDTO listNums = new ListNumsDTO();
		serveListNums(listNums, nowPage, totalCount, blockCount, blockPage);
		return listNums;
	}

	/**
	 * 정적으로 리스트 넘버 채우기
	 */
	public static void serveListNums(
			ListNumsDTO listNums,
			int nowPage,
			int totalCount,
			int blockCount,
			int blockPage) {

		if (nowPage < 1) {
			nowPage = 1;
		}
		if (blockCount < 1) {
			blockCount = 1;
		}
		if (blockPage < 1) {
			blockPage = 1;
		}

		// 전체페이지 계산
		listNums.setTotalPage((int) Math.ceil((double) totalCount / blockCount));

		if (listNums.getTotalPage() == 0) {
			listNums.setTotalPage(1);
		}
		if (nowPage > listNums.getTotalPage()) {
			nowPage = listNums.getTotalPage();
		}

		// 시작페이지, 끝페이지 계산
		listNums.setStartPage(nowPage - (blockPage - 1) / 2);
		listNums.setEndPage(listNums.getStartPage() + blockPage - 1);

		if (listNums.getEndPage() > listNums.getTotalPage()) {
			listNums.setStartPage(listNums.getStartPage() + listNums.getTotalPage() - listNums.getEndPage());
			listNums.setEndPage(listNums.getTotalPage());
		}

		if (listNums.getStartPage() < 1) {
			listNums.setStartPage(1);
			listNums.setEndPage(blockPage);
			if (listNums.getEndPage() > listNums.getTotalPage()) {
				listNums.setEndPage(listNums.getTotalPage());
			}
		}

		// 시작 Row, 끝 Row 계산
		listNums.setStartRowNum((nowPage - 1) * blockCount + 1);
		listNums.setEndRowNum(listNums.getStartRowNum() + blockCount - 1);

		if (listNums.getEndRowNum() > totalCount) {
			listNums.setEndRowNum(totalCount);
		}

		listNums.setNowPage(nowPage);
		listNums.setTotalCount(totalCount);
		listNums.setBlockCount(blockCount);
		listNums.setBlockPage(blockPage);
	}

}
