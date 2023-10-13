package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

public class BoardListAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		// parameter로 페이지 요청값이 들어오지 않으면 기본 페이지를 1로 설정

		BoardListService boardListService = new BoardListService();
		int listCount = boardListService.getListCount();
		articleList = boardListService.getArticleList(page, limit);
		int maxPage = (int) ((double) listCount / limit + 0.95); // 페이지 수를 넉넉넉하게 보여주기 위한 연산
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1; // 시작페이지 연산
		int endPage = startPage + 10 - 1; // 마지막 페이지 연산

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/qna_board_list.jsp");
		return forward;

	}

}