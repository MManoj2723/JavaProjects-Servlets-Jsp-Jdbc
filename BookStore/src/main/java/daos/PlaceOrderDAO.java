package daos;
import java.sql.*;
import java.util.*;

import connection.DBConnection;

public class PlaceOrderDAO {
	
	private ArrayList<Integer> quantities = new ArrayList<Integer>();
	
	public ArrayList<Integer> chkBqty(String[] bid) {
		
		Connection con = DBConnection.getCon();
		
		StringBuilder query = new StringBuilder("select CPAVAILABLE  from bookstore where bid in(");
		
		for(int i=0;i<bid.length;i++) {
			query.append("?");
			
			if(i<bid.length-1) {
				query.append(",");
			}
		}
		query.append(")");
		
		
		try {
			PreparedStatement ps = 
					con.prepareStatement(query.toString());
			for(int i=0;i<bid.length;i++) {
				ps.setString(i+1, bid[i]);
			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				quantities.add(rs.getInt("CPAVAILABLE"));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return quantities;
	}
	
}
