
package CHKB.MODAL;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class HoaDon {
    private String MaHoaDon;
    private String NgayTao;
    private String TongTien;
    private String NguoiTao;
    private String TrangThai;
    private String MaThanhVien;
    private String MaSach;
    private String TenSach;
    private String Gia;
    private String SoLuong;
    private String Giam = "0.0";
    private String ThanhTien;
    
    public Double thanhTien()
    {
        Double gia = Double.parseDouble(Gia);
        Double giam = Double.parseDouble(Giam);
        return (gia - (gia*(giam/100)))*Double.parseDouble(SoLuong);
    }
    
    public Double tongTien(List<HoaDon> lst)
    {
        Double tong = 0.0;
        for(HoaDon hd : lst)
        {
            tong += hd.thanhTien();
        }
        return tong;
    }

    public HoaDon() {
    }

    public HoaDon(String NgayTao, String NguoiTao, String TrangThai, String MaThanhVien, String MaSach, String TenSach, String Gia, String SoLuong, String Giam) {
        this.MaHoaDon = MaHoaDon;
        this.NgayTao = NgayTao;
        this.NguoiTao = NguoiTao;
        this.TrangThai = TrangThai;
        this.MaThanhVien = MaThanhVien;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.Giam = Giam;
    }
    
     public HoaDon(String NgayTao, String NguoiTao, String TrangThai, String MaThanhVien, String MaSach, String TenSach, String Gia, String SoLuong, String Giam, String thanhTien) {
        this.MaHoaDon = MaHoaDon;
        this.NgayTao = NgayTao;
        this.NguoiTao = NguoiTao;
        this.TrangThai = TrangThai;
        this.MaThanhVien = MaThanhVien;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.Giam = Giam;
        this.ThanhTien = thanhTien;
    }
    

    public HoaDon(String MaHoaDon, String NgayTao, String TongTien, String NguoiTao, String TrangThai, String MaThanhVien, String MaSach, String maHoaDon, String TenSach, String Gia, String SoLuong, String Giam, String ThanhTien) {
        this.MaHoaDon = MaHoaDon;
        this.NgayTao = NgayTao;
        this.TongTien = TongTien;
        this.NguoiTao = NguoiTao;
        this.TrangThai = TrangThai;
        this.MaThanhVien = MaThanhVien;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.Giam = Giam;
        this.ThanhTien = ThanhTien;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

    public String getNguoiTao() {
        return NguoiTao;
    }

    public void setNguoiTao(String NguoiTao) {
        this.NguoiTao = NguoiTao;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaThanhVien() {
        return MaThanhVien;
    }

    public void setMaThanhVien(String MaThanhVien) {
        this.MaThanhVien = MaThanhVien;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getGiam() {
        return Giam;
    }

    public void setGiam(String Giam) {
        this.Giam = Giam;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
//    public static void main(String args[])
//    {
//        HoaDon hd = new HoaDon();
//        hd.setGia("15000");
//        hd.setGiam("0.25");
//        hd.setSoLuong("2");
//        //format số
//        Locale l = new Locale("vi", "VN");
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(l);
//        System.out.println("tiền " + numberFormat.format(hd.thanhTien()));        
//    }
}
