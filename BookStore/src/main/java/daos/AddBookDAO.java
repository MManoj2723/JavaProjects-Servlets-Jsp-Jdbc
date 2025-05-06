package daos;
import java.sql.*;
import beans.*;
import connection.*;

public class AddBookDAO {
	
	public int addBook(BookBean b) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
									("insert into bookstore values(?,?,?,?,?,?,?)");
			
			ps.setString(1, b.getbId());
			ps.setString(2, b.getbTitle());
			ps.setString(3, b.getbAuthor());
			ps.setString(4, b.getbPublisher());
			ps.setString(5, b.getbPubYear());
			ps.setInt(6, b.getbPrice());
			ps.setInt(7, b.getBqty());
			
			int k = ps.executeUpdate();
			
			if(k>0) {
				return 1;
			}
			
		}
		catch(Exception e) {
			
		}
		return 0;
	}
}
