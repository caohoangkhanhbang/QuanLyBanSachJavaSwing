
package CHKB.DAO;

import CHKB.MODAL.KhuyenMai;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author caoho
 */
public class CHKB_KhuyenMaiManipulation {
     private final Connection con;
    ConnectionToDatabase connection = new ConnectionToDatabase();

    public CHKB_KhuyenMaiManipulation() throws SQLException {
         this.con = connection.getConnection();
    }
    
    public List<KhuyenMai> getAllData() throws SQLException
    {
        List<KhuyenMai> lstData = new ArrayList<>();
        String sql = "{call getAllKhuyenMai}";
        CallableStatement call = con.prepareCall(sql);
        ResultSet rs = call.executeQuery();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while(rs.next())
        {
            lstData.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString("Giam"), dateFormat.format(rs.getDate(4)), dateFormat.format(rs.getDate(5)), rs.getString(6)));
        }
        return lstData;//+dateFormat.format(rs.getDate(5))+
    }
}
