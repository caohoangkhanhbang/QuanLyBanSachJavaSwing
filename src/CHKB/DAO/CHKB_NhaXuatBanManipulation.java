
package CHKB.DAO;

import CHKB.MODAL.NhaXuatBan;
import CHKB.MODAL.Sach;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caoho
 */
public class CHKB_NhaXuatBanManipulation {
    private final Connection con;
    ConnectionToDatabase connection = new ConnectionToDatabase();

    public CHKB_NhaXuatBanManipulation() throws SQLException {
         this.con = connection.getConnection();
    }
    
    public List<NhaXuatBan> getAllData() throws SQLException
    {
        List<NhaXuatBan> lstNhaXuatBan = new ArrayList<>();
        String sql = "{call getAllNhaXB}";
        CallableStatement call = con.prepareCall(sql);
        ResultSet rs = call.executeQuery();
        while(rs.next())
        {
            lstNhaXuatBan.add(new NhaXuatBan(rs.getString(1), rs.getString(2), rs.getString(3)));
        }
        return lstNhaXuatBan;
    }
    
    public int InsertDeleteUpdate(String sql) throws SQLException
    {
        int result = 0;
        ConnectionToDatabase con = new ConnectionToDatabase();
        con.InsertDeleteUpdate(sql);
//        CallableStatement call = con.prepareCall(sql);
//        result = call.executeUpdate();
        return result;
    }
}
