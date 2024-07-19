
package CHKB.DAO;

import CHKB.MODAL.Sach;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class CHKB_SachManipulation {
    private final Connection con;
    ConnectionToDatabase connection = new ConnectionToDatabase();

    public CHKB_SachManipulation() throws SQLException {
         this.con = connection.getConnection();
    }
    
    public List<Sach> getSachData() throws SQLException
    {
        List<Sach> lstSach = new ArrayList<>();
        String sql = "{call getAllSachName}";
        CallableStatement call = con.prepareCall(sql);
        ResultSet rs = call.executeQuery();
        while(rs.next())
        {
            lstSach.add(new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
        }
        return lstSach;
    }
    
    public int InsertDeleteUpdate(String sql) throws SQLException
    {
        int result = 0;
        CallableStatement call = con.prepareCall(sql);
        result = call.executeUpdate();
        return result;
    }
    
    public int Delete(String sql) throws SQLException
    {
        int result = 0;
        CallableStatement call = con.prepareCall(sql);
        result = call.executeUpdate();
        return result;
    }
    
    public int Insert(String sql, String tenSach, String giaBan, String soLuong, String tap, String hinh, String viTri, String trangThai, String tacGia, String maKhuyenMai, String maTheLoai, String maNhaXuatBan) throws SQLException
    {
        int result = 0;
        CallableStatement call = con.prepareCall(sql);
        call.setString(1, tenSach);
        call.setString(2, giaBan);
        call.setInt(3, Integer.parseInt(soLuong));
        call.setString(4, tap);
        call.setString(5, hinh);
        call.setString(6, viTri);
        call.setInt(7, Integer.parseInt(trangThai));
        call.setString(8, tacGia);
        if(maKhuyenMai.equalsIgnoreCase("null"))
        {
            call.setString(9, null);
        }
        else
        {
            call.setInt(9, Integer.parseInt(maKhuyenMai));
        }
        call.setInt(10, Integer.parseInt(maTheLoai));
        call.setInt(11, Integer.parseInt(maNhaXuatBan));
        result = call.executeUpdate();
        return result;
    }
    
    public int Update(String sql, String tenSach, String giaBan, String soLuong, String tap, String hinh, String viTri, String trangThai, String tacGia, String maKhuyenMai, String maTheLoai, String maNhaXuatBan, String dieuKien) throws SQLException
    {
        int result = 0;
        CallableStatement call = con.prepareCall(sql);
        call.setString(1, tenSach);
        call.setString(2, giaBan);
        call.setInt(3, Integer.parseInt(soLuong));
        call.setString(4, tap);
        call.setString(5, hinh);
        call.setString(6, viTri);
        call.setInt(7, Integer.parseInt(trangThai));
        call.setString(8, tacGia);
        if(maKhuyenMai.equalsIgnoreCase("null"))
        {
            call.setString(9, null);
        }
        else
        {
            call.setInt(9, Integer.parseInt(maKhuyenMai));
        }
        call.setInt(10, Integer.parseInt(maTheLoai));
        call.setInt(11, Integer.parseInt(maNhaXuatBan));
        call.setInt(12, Integer.parseInt(dieuKien));
        result = call.executeUpdate();
        return result;
    }
    
}
