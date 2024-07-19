
package CHKB.DAO;

import CHKB.MODAL.HoaDon;
import CHKB.MODAL.KhuyenMai;
import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class CHKB_HoaDonManipulation {
    private final Connection con;
    ConnectionToDatabase connection = new ConnectionToDatabase();

    public CHKB_HoaDonManipulation() throws SQLException {
         this.con = connection.getConnection();
    }
    
//    public List<HoaDon> getAllData(String sql) throws SQLException, Exception
//    {
//        ConnectionToDatabase connect = new ConnectionToDatabase();
//        List<HoaDon> lstData = new ArrayList<>();
//        Statement st = (Statement) connect.getConnection().createStatement();
//        ResultSet rs = st.execute(sql);
//        while(rs.next())
//        {
//            
//        }
//        
//        return lstData;
//    }
    
    public int insertHoaDon(String sql, HoaDon hd, String tongTienHD) throws SQLException, ParseException
    {
        //Chuyển đổi kiểu ngày để thêm vào cơ sở dữ liệu
        java.util.Date myDate = new java.util.Date(hd.getNgayTao());
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        
        int result = 0;
        CallableStatement call = con.prepareCall(sql);
        call.setDate(1, new java.sql.Date(new java.util.Date(hd.getNgayTao()).getTime()));
//        call.setDate(1, sqlDate);
        call.setFloat(2, Float.parseFloat(tongTienHD));
        call.setInt(3, Integer.parseInt(hd.getNguoiTao()));
        call.setInt(4, Integer.parseInt(hd.getTrangThai()));
        if(hd.getMaThanhVien().equalsIgnoreCase("null")||hd.getMaThanhVien().isEmpty())
        {
            call.setString(5,null);
        }
        else
        {
            call.setInt(5, Integer.parseInt(hd.getMaThanhVien()));
        }
        result = call.executeUpdate();
        return result;
    }
    
    public int insertChiTietHD(String sql, HoaDon hd) throws SQLException
    {
        int result = 0;
        CallableStatement call = con.prepareCall(sql);
        call.setInt(1, Integer.parseInt(hd.getMaSach()));
        call.setString(2, hd.getTenSach());
        call.setFloat(3, Float.parseFloat(hd.getGia()));
        call.setString(4, hd.getSoLuong());
        call.setString(5, hd.getGiam());
        call.setString(6, hd.getThanhTien());
        result = call.executeUpdate();
        return result;
    }
    
//    public List<KhuyenMai> getAllData() throws SQLException
//    {
//        List<KhuyenMai> lstData = new ArrayList<>();
//        String sql = "{call getAllKhuyenMai}";
//        CallableStatement call = con.prepareCall(sql);
//        ResultSet rs = call.executeQuery();
//        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        while(rs.next())
//        {
//            lstData.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString("Giam"), dateFormat.format(rs.getDate(4)), dateFormat.format(rs.getDate(5)), rs.getString(6)));
//        }
//        return lstData;//+dateFormat.format(rs.getDate(5))+
//    }
    
    public String thongKe(String sql) throws SQLException
    {
        String giaTri = "0";
        ConnectionToDatabase connect = new ConnectionToDatabase();
        java.sql.Statement st = connect.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            giaTri = rs.getString(1);
        }
        return giaTri;
    }
    
    public String layTongTienHoaDon(String sql) throws SQLException
    {
        String tien = "0 VNĐ";
        ConnectionToDatabase connect = new ConnectionToDatabase();
        java.sql.Statement st = connect.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            tien = rs.getString(1);
        }
        return tien;
    }
}
