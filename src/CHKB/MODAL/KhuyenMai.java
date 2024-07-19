
package CHKB.MODAL;

/**
 *
 * @author caoho
 */
public class KhuyenMai {
    private String MaKhuyenMai;
    private String TenChuongTrinh;
    private String Giam;
    private String NgayBatDau;
    private String NgayKetThuc;
    private String TrangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String MaKhuyenMai, String TenChuongTrinh, String Giam, String NgayBatDau, String NgayKetThuc, String TrangThai) {
        this.MaKhuyenMai = MaKhuyenMai;
        this.TenChuongTrinh = TenChuongTrinh;
        this.Giam = Giam;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TrangThai = TrangThai;
    }

    public String getMaKhuyenMai() {
        return MaKhuyenMai;
    }

    public void setMaKhuyenMai(String MaKhuyenMai) {
        this.MaKhuyenMai = MaKhuyenMai;
    }

    public String getTenChuongTrinh() {
        return TenChuongTrinh;
    }

    public void setTenChuongTrinh(String TenChuongTrinh) {
        this.TenChuongTrinh = TenChuongTrinh;
    }

    public String getGiam() {
        return Giam;
    }

    public void setGiam(String Giam) {
        this.Giam = Giam;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
