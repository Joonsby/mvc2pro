package action;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class FileDownloadAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		FileOutputStream f = null;
		String downFile = request.getParameter("downFile");		
		try {
			f = new FileOutputStream("D:\\fileDown\\" + downFile, true);		
		} catch(Exception e) {
			
		} finally {
			try {
				f.close();
			} catch(Exception e) {
			}
		}
		ActionForward forward = new ActionForward();
		forward.setPath("/file_down.jsp");
		return forward;
	}
}
