ListNums
========
리스트 넘버를 제공하는 모듈

* *이 프로젝트는 Google Code로부터 이전되었습니다.*
* ListNums 소개 - http://blog.mr.hanul.co/2011/02/listnums.html

쿠키를 사용하여 리스트 넘버를 불러올 수도 있습니다.

쿠키에 리스트 넘버 저장 방법:
```java
response.addCookie(CookieBox.createCookie(
	ListNumsProvider.blockCountCookieName,
	"10"));
```
```java
response.addCookie(CookieBox.createCookie(
	ListNumsProvider.blockPageCookieName,
	"20"));  
```

## 필요 lib
* CookieBox (http://blog.mr.hanul.co/2011/02/cookie-box.html)

페이징 처리를 위해 List를 불러오는 DB에 다음과 같은 쿼리를 추가합니다.: (iBATIS SqlMap을 기준으로)
```sql
  select *
  from ( select a.*, rownum rnum
  from (
    [GET LIST QUERY HERE]
  <![CDATA[
  ) a
  where rownum <= #endRowNum:DECIMAL# )
  where rnum >= #startRowNum:DECIMAL#
  ]]>
```

뷰를 위한 태그를 제공합니다.: <%@ taglib prefix="l" uri="/listnums-tags"%>
* l:firstpage
* l:lastpage
* l:prevpage
* l:nextpage
* l:numbering
* l:prevblock
* l:nextblock

Commiter
----
*Mr. 하늘* (_mr@hanul.co_) - http://mr.hanul.co
