<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="co.hanul.mr.dev.web.listnums.ListNumsProvider"%>
<%@ page import="co.hanul.mr.dev.web.listnums.ListNumsDTO"%>
<%@ taglib prefix="l" uri="/listnums-tags"%>
<%
	ListNumsDTO ln = ListNumsProvider.createListNums(
		1, // 현재 페이지
		162, // 총 글 개수
		10, // 한 페이지에 나타날 글 수
		5 // 목록에 표시될 글 목록 수
	);
	pageContext.setAttribute("ln", ln);
%>
<l:numbering href="list" dto="${ln}" />