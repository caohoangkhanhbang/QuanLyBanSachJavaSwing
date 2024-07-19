
package CHKB.DAO;

import CHKB.MODAL.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ManipulationNhanVien {

    private final Connection con;
    ConnectionToDatabase connection = new ConnectionToDatabase();
    public ManipulationNhanVien() throws SQLException {
        this.con = connection.getConnection();
    }
    
    public List<NhanVien> getListNhanVien(String tenDangNhap, String matKhau) throws SQLException
    {
        List<NhanVien> lstNhanVien = new ArrayList<>();
        String sql = "{call getInfoUser(?,?)}";
        CallableStatement call = con.prepareCall(sql);
        call.setString(1, tenDangNhap);
        call.setString(2, matKhau);
        ResultSet rs = call.executeQuery();
        while(rs.next())
        {
            lstNhanVien.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
        }
        return lstNhanVien;
    }
    
    public List<NhanVien> getAllData() throws SQLException
    {
        List<NhanVien> lstNhanVien = new ArrayList<>();
        String sql = "{call getAllNhanVien}";
        CallableStatement call = con.prepareCall(sql);
        ResultSet rs = call.executeQuery();
        while(rs.next())
        {
            String trangThaiLamViec = "Còn làm";
            if(rs.getString(12).equals("0"))
            {
                trangThaiLamViec = "Đã nghĩ";
            }
            lstNhanVien.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), trangThaiLamViec, rs.getString(13)));
        }
        return lstNhanVien;
    }
    
    public int Insert(String sql, NhanVien nv) throws SQLException, ParseException
    {
//        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//        java.sql.Date datesql = new java.sql.Date(date.parse(nv.getNamSinh()));
//        java.util.Date myDate = new java.util.Date("10/10/2009");// chưa học xong 
        java.util.Date myDate = new java.util.Date(nv.getNamSinh());// chưa học xong 
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        int kq = 0;
        CallableStatement call = con.prepareCall(sql);
        call.setString(1, nv.getHoTen());
        call.setString(2, nv.getSoDienThoai());
        call.setString(3, nv.getEmail());
        call.setString(4, nv.getCCCD());
//        call.setDate(5, sqlDate);//nv.getNamSinh()
        call.setDate(5, sqlDate);//
        call.setString(6, nv.getGioiTinh());
        call.setString(7, nv.getVaiTro());
        call.setString(8, nv.getDiaChi());
        call.setString(9, nv.getMatKhau());
        call.setString(10, nv.getHinh());
        call.setString(11, nv.getTrangThai());
        call.setString(12, nv.getTenDangNhap());
        kq = call.executeUpdate();
        return kq;
    }
    
    public int Update(String sql, NhanVien nv) throws SQLException, ParseException
    {
//        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//        java.sql.Date datesql = new java.sql.Date(date.parse(nv.getNamSinh()));
//        java.util.Date myDate = new java.util.Date("10/10/2009");// chưa học xong 
        java.util.Date myDate = new java.util.Date(nv.getNamSinh());// chưa học xong 
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        int kq = 0;
        CallableStatement call = con.prepareCall(sql);
        call.setString(1, nv.getHoTen());
        call.setString(2, nv.getSoDienThoai());
        call.setString(3, nv.getEmail());
        call.setString(4, nv.getCCCD());
//        call.setDate(5, sqlDate);//nv.getNamSinh()
        call.setDate(5, sqlDate);//
        call.setString(6, nv.getGioiTinh());
//        call.setString(7, nv.getVaiTro());
        call.setString(7, nv.getDiaChi());
//        call.setString(9, nv.getMatKhau());
        call.setString(8, nv.getHinh());
        call.setString(9, nv.getTrangThai());
//        call.setString(12, nv.getTenDangNhap());
        call.setInt(10, Integer.parseInt(nv.getMaNhanVien()));
        kq = call.executeUpdate();
        return kq;
    }
    
       public int Delete(String sql) throws SQLException
    {
        int result = 0;
        CallableStatement call = con.prepareCall(sql);
        result = call.executeUpdate();
        return result;
    }
       
     public List<String> getRole(String sql) throws SQLException
    {
        List<String> lstData = new ArrayList<>();
        CallableStatement call = con.prepareCall(sql);
        ResultSet rs = call.executeQuery();
        while(rs.next())
        {
            lstData.add(rs.getString(1));
        }
        return lstData;
    }   
    
     public int KiemTraVaiTro(NhanVien nv)
    {
        int capDo = 0;
        if(nv.getVaiTro().equalsIgnoreCase("Owner"))
        {
            capDo = 100;
        }
        else if(nv.getVaiTro().equalsIgnoreCase("Quản lý"))
        {
            capDo = 10;
        }
        else if(nv.getVaiTro().equalsIgnoreCase("Nhân viên"))
        {
            capDo = 1;
        }
        if(nv.getTrangThai().equals("0"))
        {
            capDo = 0;
        }
        return capDo;
    }
     
}
