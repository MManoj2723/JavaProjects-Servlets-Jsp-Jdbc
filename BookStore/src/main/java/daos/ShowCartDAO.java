package daos;
import java.sql.*;
import java.util.*;
import beans.ShowCartBean;
import connection.DBConnection;
public class ShowCartDAO {
	
	private LinkedList<ShowCartBean> showcart = new LinkedList<ShowCartBean>();
	private Connection con = DBConnection.getCon();
	
	

	public LinkedList<ShowCartBean> showCartItems(String cid){
		
		
		String query="select ca.bid,b.btitle,ca.qty,(ca.qty*b.bprice) as totalPrice from cart ca inner join bookstore b on ca.bid = b.bid inner join cregistration c on ca.cid = c.cid where ca.cid=?";
		
		
		
		try {
			PreparedStatement ps = 
					con.prepareStatement(query);
			ps.setString(1, cid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ShowCartBean cb = new ShowCartBean();
				cb.setbId(rs.getString(1));
				cb.setbTitle(rs.getString(2));
				cb.setQty(rs.getInt(3));
				cb.setTotalPrice(rs.getInt(4));
				showcart.add(cb);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return showcart;
	}
}
