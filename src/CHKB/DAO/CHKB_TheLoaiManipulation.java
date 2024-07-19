
package CHKB.DAO;

import CHKB.MODAL.NhaXuatBan;
import CHKB.MODAL.TheLoai;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CHKB_TheLoaiManipulation {
    ConnectionToDatabase con = new ConnectionToDatabase();
    
     public List<TheLoai> getAllData() throws SQLException
    {
        List<TheLoai> lstData = new ArrayList<>();
        String sql = "{call getAllTheLoai}";
        CallableStatement call = con.getConnection().prepareCall(sql);
        ResultSet rs = call.executeQuery();
        while(rs.next())
        {
            lstData.add(new TheLoai(rs.getString(1), rs.getString(2)));
        }
        return lstData;
    }

    public CHKB_TheLoaiManipulation() {
    }
    
    public int InsertDeleteUpdate(String sql) throws SQLException
    {
        int result = 0;
        ConnectionToDatabase con = new ConnectionToDatabase();
        con.InsertDeleteUpdate(sql);
        return result;
    }
}
