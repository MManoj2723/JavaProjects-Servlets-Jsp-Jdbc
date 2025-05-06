package servlets;

import java.io.IOException;
import java.util.ArrayList;

import daos.CustomerLoginDAO;
import daos.PlaceOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeorder")
public class PlaceOrderServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String bid[] = req.getParameterValues("bid[]");
			String bqty[] = req.getParameterValues("bqty[]");
			
			ArrayList<Integer> quantities = new PlaceOrderDAO().chkBqty(bid);
			
			boolean flag=false;
			String bookid=null;
			for(Integer q:quantities) {
				
				for(int i=0;i<bid.length;i++) {
					
					if(Integer.parseInt(bqty[i])>q) {
						bookid=bid[i];
						flag=false;
					}
					
				}
				
			}
			
			
		}
		
		
}

}
