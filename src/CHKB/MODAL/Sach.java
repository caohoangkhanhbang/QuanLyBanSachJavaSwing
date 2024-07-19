
package CHKB.MODAL;

/**
 *
 * @author caoho
 */
public class Sach {
    private String MaSach;
    private String TenSach;
    private String GiaBan;
    private String SoLuong;
    private String Tap;
    private String Hinh;
//    private String NhanXuatBan;
    private String ViTri;
    private String TrangThai;
    private String TacGia;
    private String MaKhuyenMai;
    private String MaTheLoai;
    private String MaNhaXuatBan;
    private String TenChuongTrinh;

    

    public Sach(String MaSach, String TenSach, String GiaBan, String SoLuong, String Tap, String Hinh, String ViTri, String TrangThai, String TacGia, String MaKhuyenMai, String MaTheLoai, String MaNhaXuatBan) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.Tap = Tap;
        this.Hinh = Hinh;
        this.ViTri = ViTri;
        this.TrangThai = TrangThai;
        this.TacGia = TacGia;
        this.MaKhuyenMai = MaKhuyenMai;
        this.MaTheLoai = MaTheLoai;
        this.MaNhaXuatBan = MaNhaXuatBan;
    }

    public Sach(String MaSach, String TenSach, String GiaBan, String SoLuong, String Tap, String Hinh, String ViTri, String TrangThai, String TacGia, String MaKhuyenMai, String MaTheLoai, String MaNhaXuatBan, String TenChuongTrinh) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.Tap = Tap;
        this.Hinh = Hinh;
        this.ViTri = ViTri;
        this.TrangThai = TrangThai;
        this.TacGia = TacGia;
        this.MaKhuyenMai = MaKhuyenMai;
        this.MaTheLoai = MaTheLoai;
        this.MaNhaXuatBan = MaNhaXuatBan;
        this.TenChuongTrinh = TenChuongTrinh;
    }
    
    public Sach(String MaSach, String TenSach, String GiaBan, String SoLuong) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
    }
    
    
    public String getTenChuongTrinh() {
        return TenChuongTrinh;
    }

    public void setTenChuongTrinh(String TenChuongTrinh) {
        this.TenChuongTrinh = TenChuongTrinh;
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

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTap() {
        return Tap;
    }

    public void setTap(String Tap) {
        this.Tap = Tap;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public String getMaKhuyenMai() {
        return MaKhuyenMai;
    }

    public void setMaKhuyenMai(String MaKhuyenMai) {
        this.MaKhuyenMai = MaKhuyenMai;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getMaNhaXuatBan() {
        return MaNhaXuatBan;
    }

    public void setMaNhaXuatBan(String MaNhaXuatBan) {
        this.MaNhaXuatBan = MaNhaXuatBan;
    }

    
    

    public Sach() {
    }
}
