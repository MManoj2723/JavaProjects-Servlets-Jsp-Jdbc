package daos;
import java.sql.*;
import java.util.ArrayList;

import beans.BookBean;
import connection.DBConnection;

public class ShowBooksServletDAO {
	public ArrayList<BookBean> al = new  ArrayList<BookBean>();
	
	public ArrayList<BookBean> showBooks(){
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from bookstore order by bid asc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookBean b = new BookBean();
				b.setbId(rs.getString(1));
				b.setbTitle(rs.getString(2));
				b.setbAuthor(rs.getString(3));
				b.setbPublisher(rs.getString(4));
				b.setbPubYear(rs.getString(5));
				b.setbPrice(rs.getInt(6));
				b.setBqty(rs.getInt(7));
				al.add(b);
			}
		
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return al;
	}
	
	
}
