
package CHKB.DAO;

import CHKB.MODAL.HoaDon;
import CHKB.MODAL.NhanVien;
import java.awt.Image;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ConnectionToDatabase {
    
    public Connection getConnection() throws SQLException
    {
        Connection con = null;
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DB_BanSach;user=sa;password=123;encrypt=true;trustServerCertificate=true;";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("Kết nối thành công!");
        } catch (Exception e) {
            System.out.println("Kết nối thất bại!");
        }
        return con;
    }
    
    public List<HoaDon> getAllData(String sql) throws SQLException, Exception
    {
        ConnectionToDatabase connect = new ConnectionToDatabase();
        List<HoaDon> lstData = new ArrayList<>();
        Statement st = connect.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            lstData.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
        }
        return lstData;
    }
    
    public ResultSet SelectAll(String sql) throws SQLException
    {
        ConnectionToDatabase connect = new ConnectionToDatabase();
        Statement st = connect.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
    public static void main(String args[]) throws SQLException
    {
        ConnectionToDatabase con = new ConnectionToDatabase();
        System.out.println("Xin chào!");
        Statement st = con.getConnection().createStatement();
        String sql = "Select * from NhanVien";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            System.out.println(rs.getString(1));
        }
    }

    public ConnectionToDatabase() {
    }
    
    
    //Các hàm dùng chung
    public int InsertDeleteUpdate(String sql) throws SQLException
    {
        ConnectionToDatabase con = new ConnectionToDatabase();
        int result = 0;
        CallableStatement call = con.getConnection().prepareCall(sql);
        result = call.executeUpdate();
        return result;
    }
    
    public String chonAnh(JFrame frm) //Chưa kiểm thử
    {
        String duongDanAnh = "";
        JFileChooser jfileChooser = new JFileChooser();
        jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(jfileChooser.showOpenDialog(frm) == JFileChooser.APPROVE_OPTION)
        {
            duongDanAnh = jfileChooser.getSelectedFile().getAbsolutePath();
        }
        return duongDanAnh;
    }
    
    public boolean kiemTraSo(String chuoi)
    {
        boolean kq = false;
        try
        {
            Long so = Long.parseLong((chuoi));
            if(so > 0) 
                kq = true;
        }
        catch(Exception e)
        {
            kq = false;
        }
        return kq;
    }
    
    public boolean kiemTraSoHoacBango(String chuoi)
    {
        boolean kq = false;
        try
        {
            Long so = Long.parseLong((chuoi));
            if(so >= 0) //Mới sủa =
                kq = true;
        }
        catch(Exception e)
        {
            kq = false;
        }
        return kq;
    }
    
    public boolean kiemTraSoKhuyenMai(String chuoi)
    {
        boolean kq = false;
        try
        {
            Long so = Long.parseLong((chuoi));
            if(so >= 0 && so <= 100)
                kq = true;
        }
        catch(Exception e)
        {
            kq = false;
        }
        return kq;
    }
    
    public boolean ktSo(String so)
    {
        return Pattern.compile("^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$")
      .matcher(so)
      .matches();
    }
    
    public boolean ktEmail(String email)
    {
       return Pattern.compile("^(.+)@(\\S+)$")
      .matcher(email)
      .matches();
    }
    
    public boolean ktNgay(String ngay)
    {
         return Pattern.compile("^(?:(?:(?:0?[13578]|1[02])(\\/|-|\\.)31)\\1|(?:(?:0?[1,3-9]|1[0-2])(\\/|-|\\.)(?:29|30)\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:0?2(\\/|-|\\.)29\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9])|(?:1[0-2]))(\\/|-|\\.)(?:0?[1-9]|1\\d|2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$").matcher(ngay).matches();
    }
    
    //format số theo kiểu tiền Việt nam
    public DecimalFormat kieuTienVietNam()
    {
        Locale locale = new Locale("vi", "VN");
        DecimalFormat decimalformat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols decimal = new DecimalFormatSymbols();
        decimal.setCurrencySymbol("VNĐ");
        decimalformat.setDecimalFormatSymbols(decimal);
        return decimalformat;
    }
    
    public boolean ktNgaySinhDu18Tuoi(String ngaySinh) throws ParseException {
        boolean result = false;
        //Lấy ra ngày hiện tại
        Date layNgayHienTai = new Date();
        //Chuyển ngày sinh từ chuỗi sang kiểu ngày
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinh);
        SimpleDateFormat chuyenKieuNgay = new SimpleDateFormat("dd/MM/yyyy");
        //Format ngày hiện tại
        Date ngayHienTai = chuyenKieuNgay.parse(chuyenKieuNgay.format(layNgayHienTai));

        SimpleDateFormat getDate = new SimpleDateFormat("dd");
        SimpleDateFormat getMonth = new SimpleDateFormat("MM");
        SimpleDateFormat getYear = new SimpleDateFormat("yyyy");
        String ngayS = getDate.format(date);
        String thangS = getMonth.format(date);
        String namS = getYear.format(date);
        String ngayHT = getDate.format(ngayHienTai);
        String thangHT = getMonth.format(ngayHienTai);
        String namHT = getYear.format(ngayHienTai);

        if ((Integer.parseInt(namHT) - Integer.parseInt(namS)) >= 18) {
            result = true;
        }
        return result;
    }
    
//      public boolean ktNgay(String ngay)
//    {
//         return Pattern.compile(
//      "^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$" 
//      + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
//      + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" 
//      + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$").matcher(ngay).matches();
//    }
    
    public int ThemXoaSua(String sql) throws SQLException
    {
        int result = 0;
        ConnectionToDatabase con = new ConnectionToDatabase();
        Statement st = (Statement) con.getConnection().createStatement();
        result = st.executeUpdate(sql);
        return result;
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
