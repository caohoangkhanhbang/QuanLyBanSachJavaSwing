/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CHKB.UI;

import CHKB.DAO.CHKB_HoaDonManipulation;
import CHKB.DAO.CHKB_KhuyenMaiManipulation;
import CHKB.DAO.CHKB_NhaXuatBanManipulation;
import CHKB.DAO.CHKB_SachManipulation;
import CHKB.DAO.CHKB_ThanhVienManipulation;
import CHKB.DAO.CHKB_TheLoaiManipulation;
import CHKB.DAO.ConnectionToDatabase;
import CHKB.DAO.ManipulationNhanVien;
import CHKB.MODAL.HoaDon;
import CHKB.MODAL.KhuyenMai;
import CHKB.MODAL.NhaXuatBan;
import CHKB.MODAL.NhanVien;
import CHKB.MODAL.Sach;
import CHKB.MODAL.ThanhVien;
import CHKB.MODAL.TheLoai;
import CHKB_DESIGN.MessageDialog;
import CHKB_DESIGN.TableCustom;
import CHKB_DESIGN.ThongBao;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author caoho
 */
public class frmMain extends javax.swing.JFrame {
    //Ngày hiện tại
    LocalDateTime curDate = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String ngayHienTai = curDate.format(format);
    
    //Chuyển kiểu ngày Việt Nam
        SimpleDateFormat formatnn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatVN = new SimpleDateFormat("dd/MM/yyyy");

        //Phân quyền
    private NhanVien doiTuongNhanVien;
    ConnectionToDatabase mahaFunction;
    
    DefaultTableModel modelSach;
    DefaultTableModel modelKhuyenMai;
    DefaultTableModel modelTheLoai;
    DefaultTableModel modelNhanVien;
    DefaultTableModel modelTaiKhoan;
    DefaultTableModel modelThanhVien;
    DefaultTableModel modelNhaXuatBan;
    DefaultTableModel modelSachHD;
    DefaultTableModel modelHoaDon;
    DefaultTableModel modelAllHoaDon;
    DefaultTableModel modelSachHH;
    
    
    
    
    List<Sach> lstSach;
    List<KhuyenMai> lstKhuyenMai;
    List<TheLoai> lstTheLoai;
    List<NhanVien> lstNhanVien;
    List<NhanVien> lstTaiKhoan;
    List<ThanhVien> lstThanhVien;
    List<NhaXuatBan> lstNhaXuatBan;
    List<Sach> lstHoaDon;
    List<HoaDon> lstTaoHoaDon;
    List<HoaDon> lstAllHoaDon;
    List<Sach> lstSachHH;
    
    
    private String tenDangNhap;
    private String maNhanVien;
    private String matKhau;
    /**
     * Creates new form frmMain
     */
    public frmMain(NhanVien nv) throws SQLException {//String tenDangNhap, String matKhau, String maNhanVien
//        this.tenDangNhap = nv.getTenDangNhap();
        this.tenDangNhap = nv.getHoTen();
        this.matKhau = nv.getMatKhau();
        this.maNhanVien = nv.getMaNhanVien();
        //Khởi tạo phân quyền
        this.doiTuongNhanVien = nv;
        mahaFunction = new ConnectionToDatabase();
        
        initComponents();
        this.setLocationRelativeTo(null);
        txt_userName.setText(tenDangNhap);
        txt_chucVu.setText(nv.getVaiTro());
//        hinhNhanVien.setIcon(new ImageIcon(new ImageIcon(nv.getHinh()).getImage().getScaledInstance(hinhNhanVien.getWidth(), hinhNhanVien.getHeight(), Image.SCALE_SMOOTH)));
        if(nv.getHinh() != null) {
            hinhNhanVien.setIcon(new ImageIcon(nv.getHinh()));
        } else
        {
            hinhNhanVien.setIcon(new ImageIcon(getClass().getResource("/CHKB_IMAGE/iconUser.png")));
        }
//        TableCustom.apply(scrolPanelInfo, TableCustom.TableType.MULTI_LINE);
        
        //Khởi tạo model để tải lên bảng
        modelSach = (DefaultTableModel) tbl_info.getModel();
        lstSach = new ArrayList<>();
//          taoModel(modelSach, tbl_info, lstSach); không sài được
        modelKhuyenMai = (DefaultTableModel) tbl_infokm.getModel();
        lstKhuyenMai = new ArrayList<>();
        
        modelTheLoai = (DefaultTableModel) tbl_infotl.getModel();
        lstTheLoai = new ArrayList<>();
        
        modelNhanVien = (DefaultTableModel) tbl_infonv.getModel();
        lstNhanVien = new ArrayList<>();
        
        modelTaiKhoan = (DefaultTableModel) tbl_infotv.getModel();
        lstTaiKhoan = new ArrayList<>();
        
        modelThanhVien = (DefaultTableModel) tbl_infotk.getModel();
        lstThanhVien = new ArrayList<>();
        
        modelNhaXuatBan = (DefaultTableModel) tbl_infonxb.getModel();
        lstNhaXuatBan = new ArrayList<>();
        
        
        modelSachHD = (DefaultTableModel) tbl_infoSach.getModel();
        lstHoaDon = new ArrayList<>();
        lstTaoHoaDon = new ArrayList<>();
        
        modelHoaDon = (DefaultTableModel) tbl_infoHoaDon.getModel();
        
        modelAllHoaDon = (DefaultTableModel) tbl_tcHD.getModel();
        lstAllHoaDon = new ArrayList<>();
        
        modelSachHH = (DefaultTableModel) tbl_shh.getModel();
        lstSachHH = new ArrayList<>();
        
        //Custom table
        customTable();
        khoiTaoThongTinHoaDon();
    }
    
    public void khoiTaoThongTinHoaDon() throws SQLException
    {
        loadSachHoaDon();
        loadComboboxThanhVien();
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
    
     public DecimalFormat formatSoVietNam()
    {
        Locale locale = new Locale("vi", "VN");
        DecimalFormat decimalformat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
//        DecimalFormatSymbols decimal = new DecimalFormatSymbols();
//        decimal.setCurrencySymbol("VNĐ");
//        decimalformat.setDecimalFormatSymbols(decimal);
        return decimalformat;
    }
    
    //Không sài hàm này được
    public void taoModel(DefaultTableModel tenModel, JTable tenBang, List tenList)
    {
        tenModel = (DefaultTableModel) tenBang.getModel();
        tenList = new ArrayList<>();
    }
    //Lấy từ cơ sở dữ liệu
    public void loadSachHoaDon() throws SQLException
    {
        loadTableSach();
        modelSachHD.setRowCount(0);
        modelSachHD.setColumnIdentifiers(new Object[]{"Mã sách", "Tên Sách", "Giá bán", "Vị trí", "Tác giả", "Khuyến mãi"});
        for(Sach sach : lstSach)
        {
            modelSachHD.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getGiaBan(), sach.getViTri(), sach.getTacGia(), sach.getTenChuongTrinh()});
        }
    }
    //làm mới
    public void lamTuoiSach()
    {
        modelSachHD.setRowCount(0);
        modelSachHD.setColumnIdentifiers(new Object[]{"Mã sách", "Tên Sách", "Giá bán", "Vị trí", "Tác giả", "Khuyến mãi"});
        for(Sach sach : lstSach)
        {
            modelSachHD.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getGiaBan(), sach.getViTri(), sach.getTacGia(), sach.getTenChuongTrinh()});
        }
    }
    
    //Thêm tìm kiếm
    public void BangTimTheoTen(List<Sach> lstSach)
    {
        modelSachHD.setRowCount(0);
        modelSachHD.setColumnIdentifiers(new Object[]{"Mã sách", "Tên Sách", "Giá bán", "Vị trí", "Tác giả", "Khhuyến mãi"});
        for(Sach sach : lstSach)
        {
            modelSachHD.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getGiaBan(), sach.getViTri(), sach.getTacGia(), sach.getTenChuongTrinh()});
        }
    }
    
    //Hàm lấy dữ liệu đổ vào bảng
    public void loadTableSach() throws SQLException
    {
        loadTableKhuyenMai();
        CHKB_SachManipulation data = new CHKB_SachManipulation();
        lstHoaDon = lstSach = data.getSachData();
        modelSach.setRowCount(0);
        modelSach.setColumnIdentifiers(new Object[]{"Mã sách", "Tên Sách", "Giá bán", "Số lượng", "Tập", "Vị trí", "Trạng thái", "Tác giả", "Khuyến mãi", "Mã thể loại","Nhà xuát bản"});
        for(Sach sach : lstSach)
        {
            sach.setTenChuongTrinh("Không có");
            for(KhuyenMai km : lstKhuyenMai)
            {
                if(km.getMaKhuyenMai().equalsIgnoreCase(sach.getMaKhuyenMai()))
                {
                    sach.setTenChuongTrinh(km.getTenChuongTrinh());
                    break;
                }
            }
            modelSach.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getGiaBan(), sach.getSoLuong(), sach.getTap(), sach.getViTri(), sach.getTrangThai(), sach.getTacGia(), sach.getTenChuongTrinh(), sach.getMaTheLoai(), sach.getMaNhaXuatBan()});
        }
    }
    
    public void lamTuoiSach(List<Sach> lstSach)
    {
        modelSach.setColumnIdentifiers(new Object[]{"Mã sách", "Tên Sách", "Giá bán", "Số lượng", "Tập", "Vị trí", "Trạng thái", "Tác giả", "Khuyến mãi", "Mã thể loại","Nhà xuát bản"});
        modelSach.setRowCount(0);
         for(Sach sach : lstSach)
        {
            sach.setTenChuongTrinh("Không có");
            for(KhuyenMai km : lstKhuyenMai)
            {
                if(km.getMaKhuyenMai().equalsIgnoreCase(sach.getMaKhuyenMai()))
                {
                    sach.setTenChuongTrinh(km.getTenChuongTrinh());
                    break;
                }
            }
            modelSach.addRow(new Object[]{sach.getMaSach(), sach.getTenSach(), sach.getGiaBan(), sach.getSoLuong(), sach.getTap(), sach.getViTri(), sach.getTrangThai(), sach.getTacGia(), sach.getTenChuongTrinh(), sach.getMaTheLoai(), sach.getMaNhaXuatBan()});
        }
    }
    
    public void loadTableNhaXuatBan() throws SQLException
    {
        CHKB_NhaXuatBanManipulation getData = new CHKB_NhaXuatBanManipulation();
        lstNhaXuatBan = getData.getAllData();
        modelNhaXuatBan.setRowCount(0);
        modelNhaXuatBan.setColumnIdentifiers(new Object[]{"Mã Nhà xuất bản", "Tên Nhà xuất bản"});
        for(NhaXuatBan data : lstNhaXuatBan)
        {
            modelNhaXuatBan.addRow(new Object[]{data.getMaNhaXuatBan(), data.getTenNhaXuatBan()});
        }
    }
    
    public void loadTableTheLoai() throws SQLException
    {
        CHKB_TheLoaiManipulation getData = new CHKB_TheLoaiManipulation();
        lstTheLoai = getData.getAllData();
        modelTheLoai.setRowCount(0);
        modelTheLoai.setColumnIdentifiers(new Object[]{"Mã thể loại", "Tên thể loại"});
        for(TheLoai data : lstTheLoai)
        {
            modelTheLoai.addRow(new Object[]{data.getMaTheLoai(), data.getTenTheLoai()});
        }
    }
    
    public void loadTableNhanVien() throws SQLException, ParseException
    {
        ManipulationNhanVien getData = new ManipulationNhanVien();
        lstNhanVien = getData.getAllData();
        
        //Chuyển kiểu ngày Việt Nam
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatVN = new SimpleDateFormat("dd/MM/yyyy");
         for(NhanVien data : lstNhanVien)
        {
            Date namSinh = format.parse(data.getNamSinh());
            data.setNamSinh(formatVN.format(namSinh));
        }
        modelNhanVien.setRowCount(0);
        modelNhanVien.setColumnIdentifiers(new Object[]{"Mã NV", "Họ tên", "Số điện thoại", "Email", "Số CCCD", "Năm sinh", "Giới tính", "Vai trò", "Địa chỉ", "Hình", "Trạng thái"});
        for(NhanVien data : lstNhanVien)
        {
            modelNhanVien.addRow(new Object[]{data.getMaNhanVien(), data.getHoTen(), data.getSoDienThoai(), data.getEmail(), data.getCCCD(), data.getNamSinh(), data.getGioiTinh(), data.getVaiTro(), data.getDiaChi(), data.getHinh(), data.getTrangThai()});
        }
    }
    
    public void loadTableThanhVien() throws SQLException
    {
        CHKB_ThanhVienManipulation getData = new CHKB_ThanhVienManipulation();
        lstThanhVien = getData.getAllData();
        modelThanhVien.setRowCount(0);
        modelThanhVien.setColumnIdentifiers(new Object[]{"Mã TV", "Tên thành viên", "Số điện thoại", "Ngày sinh", "Giới tính", "Email", "Địa chỉ", "Điểm", "Giảm giá"});
        for (ThanhVien data : lstThanhVien) {
                Date namSinh;
                try {
                    if(data.getNgaySinh()!= null){
                    namSinh = formatnn.parse(data.getNgaySinh());
                    data.setNgaySinh(formatVN.format(namSinh));}
                } catch (ParseException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        for(ThanhVien data : lstThanhVien)
        {
            String diem = data.getDiem();
            if (diem != null) {
                diem = formatSoVietNam().format(Double.parseDouble(diem));
            } else {
                diem = data.getDiem();
            }
            modelThanhVien.addRow(new Object[]{data.getMaThanhVien(), data.getHoTen(), data.getSoDienThoai(), data.getNgaySinh(), data.getGioiTinh(), data.getEmail(), data.getDiaChi(), diem, data.getGiamGia()});// data.getDiem()
        }
    }
    
        public void loadTableTaiKhoan() throws SQLException
    {
        ManipulationNhanVien getData = new ManipulationNhanVien();
        lstTaiKhoan = getData.getAllData();
        modelTaiKhoan.setRowCount(0);
        modelTaiKhoan.setColumnIdentifiers(new Object[]{"Mã NV", "Họ tên", "Tên đăng nhập", "Mật khẩu", "Năm sinh", "Giới tính", "Vai trò", "Hình", "Trạng thái"});
        for (NhanVien data : lstTaiKhoan) {
                Date namSinh;
                try {
                    if(data.getNamSinh().isEmpty() == false){
                    namSinh = formatnn.parse(data.getNamSinh());
                    data.setNamSinh(formatVN.format(namSinh));}
                } catch (ParseException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        for(NhanVien data : lstTaiKhoan)
        {
            modelTaiKhoan.addRow(new Object[]{data.getMaNhanVien(), data.getHoTen(), data.getTenDangNhap(), data.getMatKhau(), data.getNamSinh(), data.getGioiTinh(), data.getVaiTro(), data.getHinh(), data.getTrangThai()});
        }
    }
        
        public void loadTableKhuyenMai() throws SQLException
    {
        CHKB_KhuyenMaiManipulation getData = new CHKB_KhuyenMaiManipulation();
        lstKhuyenMai = getData.getAllData();
        modelKhuyenMai.setRowCount(0);
        modelKhuyenMai.setColumnIdentifiers(new Object[]{"Mã Khuyến Mãi", "Tên chương trình", "Giảm", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"});
        for(KhuyenMai data : lstKhuyenMai)
        {
            modelKhuyenMai.addRow(new Object[]{data.getMaKhuyenMai(), data.getTenChuongTrinh(), data.getGiam(), data.getNgayBatDau(), data.getNgayKetThuc(), data.getTrangThai()});
        }
    }    
        

    public void customTable()
    {
        TableCustom.apply(jScrollPane, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPanekm, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPanetl, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPanenv, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPanetk, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPanetv, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPanenxb, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPaneSachHD, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPaneHD, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPanelTCHD1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPanelHH1, TableCustom.TableType.DEFAULT);
//        TableCustom.apply(jScrollPanelHDTN1, TableCustom.TableType.DEFAULT);
//JOptionPane.showConfirmDialog(null, ngayHienTai);
    }
    
    private frmMain() throws SQLException, SQLException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRoundGradient1 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient13 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient14 = new CHKB_DESIGN.PanelRoundGradient();
        txt_userName = new javax.swing.JLabel();
        hinhNhanVien = new CHKB_DESIGN.ImageAvatar();
        txt_chucVu = new javax.swing.JLabel();
        btn_sanPhan = new CHKB_DESIGN.ButtonGradientRound();
        btn_khuyenMai = new CHKB_DESIGN.ButtonGradientRound();
        btn_theLoai = new CHKB_DESIGN.ButtonGradientRound();
        btn_nhanVien = new CHKB_DESIGN.ButtonGradientRound();
        btn_thanhVien = new CHKB_DESIGN.ButtonGradientRound();
        btn_taiKhoan = new CHKB_DESIGN.ButtonGradientRound();
        btn_nhaXuatBan = new CHKB_DESIGN.ButtonGradientRound();
        btn_dangXuat = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang = new CHKB_DESIGN.ButtonGradientRound();
        btn_thongKe = new CHKB_DESIGN.ButtonGradientRound();
        panelRoundGradient2 = new CHKB_DESIGN.PanelRoundGradient();
        tabbed_main = new CHKB_DESIGN.MaterialTabbed();
        panelRoundGradient6 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient19 = new CHKB_DESIGN.PanelRoundGradient();
        txt_timSP = new CHKB_DESIGN.TextField();
        btn_taiLaisp1 = new CHKB_DESIGN.ButtonGradientRound();
        btn_themVaoHoaDon = new CHKB_DESIGN.ButtonGradientRound();
        btn_xoaKhoiHoaDon = new CHKB_DESIGN.ButtonGradientRound();
        btn_huyHoaDon = new CHKB_DESIGN.ButtonGradientRound();
        roundPanelBorderBottom10 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPaneSachHD = new javax.swing.JScrollPane();
        tbl_infoSach = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        roundPanelBorderBottom11 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPaneHD = new javax.swing.JScrollPane();
        tbl_infoHoaDon = new javax.swing.JTable();
        txt_giam = new CHKB_DESIGN.TextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tongTien = new CHKB_DESIGN.TextField();
        jLabel12 = new javax.swing.JLabel();
        cbb_khachHang = new CHKB_DESIGN.ComboBoxSuggestion();
        btn_luuHD = new CHKB_DESIGN.ButtonGradientRound();
        btn_giamGia = new CHKB_DESIGN.ButtonGradientRound();
        jLabel14 = new javax.swing.JLabel();
        hienThi = new CHKB_DESIGN.PanelRoundGradient();
        roundPanelBorderBottom3 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPane = new javax.swing.JScrollPane();
        tbl_info = new javax.swing.JTable();
        panelRoundGradient3 = new CHKB_DESIGN.PanelRoundGradient();
        txt_timSach = new CHKB_DESIGN.TextField();
        btn_taoDonHang2 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang3 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang4 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang5 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taiLaisp = new CHKB_DESIGN.ButtonGradientRound();
        txt_userName1 = new javax.swing.JLabel();
        panelRoundGradient8 = new CHKB_DESIGN.PanelRoundGradient();
        roundPanelBorderBottom8 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPanekm = new javax.swing.JScrollPane();
        tbl_infokm = new javax.swing.JTable();
        panelRoundGradient17 = new CHKB_DESIGN.PanelRoundGradient();
        textField6 = new CHKB_DESIGN.TextField();
        btn_taoDonHang27 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang28 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taiLaikm = new CHKB_DESIGN.ButtonGradientRound();
        panelRoundGradient9 = new CHKB_DESIGN.PanelRoundGradient();
        roundPanelBorderBottom4 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPanetl = new javax.swing.JScrollPane();
        tbl_infotl = new javax.swing.JTable();
        panelRoundGradient4 = new CHKB_DESIGN.PanelRoundGradient();
        textField2 = new CHKB_DESIGN.TextField();
        btn_taoDonHang7 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang8 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taiLaitl = new CHKB_DESIGN.ButtonGradientRound();
        panelRoundGradient10 = new CHKB_DESIGN.PanelRoundGradient();
        roundPanelBorderBottom5 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPanenv = new javax.swing.JScrollPane();
        tbl_infonv = new javax.swing.JTable();
        panelRoundGradient5 = new CHKB_DESIGN.PanelRoundGradient();
        textField3 = new CHKB_DESIGN.TextField();
        btn_taoDonHang12 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang13 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang14 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang15 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taiLainv = new CHKB_DESIGN.ButtonGradientRound();
        panelRoundGradient11 = new CHKB_DESIGN.PanelRoundGradient();
        roundPanelBorderBottom7 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPanetk = new javax.swing.JScrollPane();
        tbl_infotk = new javax.swing.JTable();
        panelRoundGradient16 = new CHKB_DESIGN.PanelRoundGradient();
        textField5 = new CHKB_DESIGN.TextField();
        btn_taoDonHang22 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang23 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taiLaitk = new CHKB_DESIGN.ButtonGradientRound();
        panelRoundGradient12 = new CHKB_DESIGN.PanelRoundGradient();
        cardDonHangTrongNgay = new CHKB_DESIGN.Card();
        cardDoanhThuHomNay = new CHKB_DESIGN.Card();
        cardDoanhThuTrongThang = new CHKB_DESIGN.Card();
        cardTongTien = new CHKB_DESIGN.Card();
        roundPanelBorderBottom13 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jLabel15 = new javax.swing.JLabel();
        jScrollPanelTCHD1 = new javax.swing.JScrollPane();
        tbl_tcHD = new javax.swing.JTable();
        ccb_timHoaDon = new CHKB_DESIGN.ComboBoxSuggestion();
        jLabel16 = new javax.swing.JLabel();
        btn_timHD = new CHKB_DESIGN.ButtonGradientRound();
        roundPanelBorderBottom15 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPanelHH1 = new javax.swing.JScrollPane();
        tbl_shh = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        panelRoundGradient20 = new CHKB_DESIGN.PanelRoundGradient();
        btn_taiLaitk1 = new CHKB_DESIGN.ButtonGradientRound();
        panelRoundGradient15 = new CHKB_DESIGN.PanelRoundGradient();
        roundPanelBorderBottom6 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPanetv = new javax.swing.JScrollPane();
        tbl_infotv = new javax.swing.JTable();
        panelRoundGradient7 = new CHKB_DESIGN.PanelRoundGradient();
        textField4 = new CHKB_DESIGN.TextField();
        btn_taoDonHang18 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang20 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taiLaitv = new CHKB_DESIGN.ButtonGradientRound();
        btn_doiMatKhau = new CHKB_DESIGN.ButtonGradientRound();
        hienThi1 = new CHKB_DESIGN.PanelRoundGradient();
        roundPanelBorderBottom9 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPanenxb = new javax.swing.JScrollPane();
        tbl_infonxb = new javax.swing.JTable();
        panelRoundGradient18 = new CHKB_DESIGN.PanelRoundGradient();
        textField7 = new CHKB_DESIGN.TextField();
        btn_taoDonHang6 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taoDonHang11 = new CHKB_DESIGN.ButtonGradientRound();
        btn_taiLainxb = new CHKB_DESIGN.ButtonGradientRound();
        txt_userName2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hệ thống bán sách CHKB");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelRoundGradient1.setBackground(new java.awt.Color(204, 204, 204));
        panelRoundGradient1.setColorEnd(new java.awt.Color(255, 255, 255));
        panelRoundGradient1.setColorStart(new java.awt.Color(255, 255, 255));
        panelRoundGradient1.setRoundBottomLeft(0);
        panelRoundGradient1.setRoundBottomRight(0);
        panelRoundGradient1.setRoundTopLeft(0);
        panelRoundGradient1.setRoundTopRight(0);

        panelRoundGradient13.setColorEnd(new java.awt.Color(102, 0, 204));
        panelRoundGradient13.setColorStart(new java.awt.Color(255, 102, 153));

        panelRoundGradient14.setColorEnd(new java.awt.Color(0, 102, 102));
        panelRoundGradient14.setColorStart(new java.awt.Color(102, 0, 102));

        txt_userName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_userName.setForeground(new java.awt.Color(255, 255, 255));
        txt_userName.setText("Sys as sysdba");
        txt_userName.setFocusable(false);
        txt_userName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_userName.setIconTextGap(10);

        hinhNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/iconUser.png"))); // NOI18N

        txt_chucVu.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txt_chucVu.setForeground(new java.awt.Color(255, 255, 255));
        txt_chucVu.setText("Quản trị viên");
        txt_chucVu.setFocusable(false);
        txt_chucVu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_chucVu.setIconTextGap(10);

        javax.swing.GroupLayout panelRoundGradient14Layout = new javax.swing.GroupLayout(panelRoundGradient14);
        panelRoundGradient14.setLayout(panelRoundGradient14Layout);
        panelRoundGradient14Layout.setHorizontalGroup(
            panelRoundGradient14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient14Layout.createSequentialGroup()
                .addGroup(panelRoundGradient14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient14Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(hinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundGradient14Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelRoundGradient14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_chucVu)
                            .addComponent(txt_userName))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRoundGradient14Layout.setVerticalGroup(
            panelRoundGradient14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_chucVu)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_sanPhan.setForeground(new java.awt.Color(51, 51, 51));
        btn_sanPhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/the_loai.png"))); // NOI18N
        btn_sanPhan.setText("Sản phẩm");
        btn_sanPhan.setColor1(new java.awt.Color(255, 255, 255));
        btn_sanPhan.setColor2(new java.awt.Color(255, 255, 255));
        btn_sanPhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sanPhan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sanPhan.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_sanPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanPhanActionPerformed(evt);
            }
        });

        btn_khuyenMai.setForeground(new java.awt.Color(51, 51, 51));
        btn_khuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/sale.png"))); // NOI18N
        btn_khuyenMai.setText("Khuyến mãi");
        btn_khuyenMai.setColor1(new java.awt.Color(255, 255, 255));
        btn_khuyenMai.setColor2(new java.awt.Color(255, 255, 255));
        btn_khuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_khuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_khuyenMai.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_khuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khuyenMaiActionPerformed(evt);
            }
        });

        btn_theLoai.setForeground(new java.awt.Color(51, 51, 51));
        btn_theLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/book.png"))); // NOI18N
        btn_theLoai.setText("Thể loại");
        btn_theLoai.setColor1(new java.awt.Color(255, 255, 255));
        btn_theLoai.setColor2(new java.awt.Color(255, 255, 255));
        btn_theLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_theLoai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_theLoai.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_theLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_theLoaiActionPerformed(evt);
            }
        });

        btn_nhanVien.setForeground(new java.awt.Color(51, 51, 51));
        btn_nhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/management.png"))); // NOI18N
        btn_nhanVien.setText("Nhân viên");
        btn_nhanVien.setColor1(new java.awt.Color(255, 255, 255));
        btn_nhanVien.setColor2(new java.awt.Color(255, 255, 255));
        btn_nhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_nhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_nhanVien.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_nhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhanVienActionPerformed(evt);
            }
        });

        btn_thanhVien.setForeground(new java.awt.Color(51, 51, 51));
        btn_thanhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/khach_hang.png"))); // NOI18N
        btn_thanhVien.setText("Thành viên");
        btn_thanhVien.setColor1(new java.awt.Color(255, 255, 255));
        btn_thanhVien.setColor2(new java.awt.Color(255, 255, 255));
        btn_thanhVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_thanhVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_thanhVien.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_thanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhVienActionPerformed(evt);
            }
        });

        btn_taiKhoan.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/tai_khoan.png"))); // NOI18N
        btn_taiKhoan.setText("Tài khoản");
        btn_taiKhoan.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiKhoan.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiKhoan.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiKhoanActionPerformed(evt);
            }
        });

        btn_nhaXuatBan.setForeground(new java.awt.Color(51, 51, 51));
        btn_nhaXuatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/nha_xuat_ban.png"))); // NOI18N
        btn_nhaXuatBan.setText("Nhà xuất bản");
        btn_nhaXuatBan.setColor1(new java.awt.Color(255, 255, 255));
        btn_nhaXuatBan.setColor2(new java.awt.Color(255, 255, 255));
        btn_nhaXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_nhaXuatBan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_nhaXuatBan.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_nhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhaXuatBanActionPerformed(evt);
            }
        });

        btn_dangXuat.setForeground(new java.awt.Color(51, 51, 51));
        btn_dangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/logout_ic.png"))); // NOI18N
        btn_dangXuat.setText("Đăng xuất");
        btn_dangXuat.setColor1(new java.awt.Color(255, 255, 255));
        btn_dangXuat.setColor2(new java.awt.Color(255, 255, 255));
        btn_dangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_dangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_dangXuat.setMauDiemCham(new java.awt.Color(255, 0, 0));
        btn_dangXuat.setVerifyInputWhenFocusTarget(false);
        btn_dangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangXuatActionPerformed(evt);
            }
        });

        btn_taoDonHang.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/tao_don_hang.png"))); // NOI18N
        btn_taoDonHang.setText("Tạo đơn hàng");
        btn_taoDonHang.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHangActionPerformed(evt);
            }
        });

        btn_thongKe.setForeground(new java.awt.Color(51, 51, 51));
        btn_thongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/barchart.png"))); // NOI18N
        btn_thongKe.setText("Thống kê");
        btn_thongKe.setColor1(new java.awt.Color(255, 255, 255));
        btn_thongKe.setColor2(new java.awt.Color(255, 255, 255));
        btn_thongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_thongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_thongKe.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_thongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient13Layout = new javax.swing.GroupLayout(panelRoundGradient13);
        panelRoundGradient13.setLayout(panelRoundGradient13Layout);
        panelRoundGradient13Layout.setHorizontalGroup(
            panelRoundGradient13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient13Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_dangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRoundGradient13Layout.createSequentialGroup()
                                .addGroup(panelRoundGradient13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn_nhaXuatBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btn_thanhVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_nhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_theLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_khuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(btn_sanPhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelRoundGradient14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_taiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btn_taoDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5))
                    .addGroup(panelRoundGradient13Layout.createSequentialGroup()
                        .addComponent(btn_thongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelRoundGradient13Layout.setVerticalGroup(
            panelRoundGradient13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sanPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_theLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_dangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelRoundGradient2.setColorEnd(new java.awt.Color(153, 153, 153));
        panelRoundGradient2.setColorStart(new java.awt.Color(51, 51, 51));

        tabbed_main.setForeground(new java.awt.Color(255, 255, 255));
        tabbed_main.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        panelRoundGradient6.setColorEnd(new java.awt.Color(255, 255, 255));
        panelRoundGradient6.setColorStart(new java.awt.Color(255, 255, 255));

        panelRoundGradient19.setColorEnd(new java.awt.Color(255, 51, 255));
        panelRoundGradient19.setColorStart(new java.awt.Color(0, 255, 255));
        panelRoundGradient19.setPreferredSize(new java.awt.Dimension(603, 54));

        txt_timSP.setForeground(new java.awt.Color(51, 51, 51));
        txt_timSP.setText("Tìm...");
        txt_timSP.setCaretColor(new java.awt.Color(0, 255, 255));
        txt_timSP.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txt_timSP.setRound(30);
        txt_timSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timSPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_timSPMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_timSPMouseReleased(evt);
            }
        });
        txt_timSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_timSPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timSPKeyReleased(evt);
            }
        });

        btn_taiLaisp1.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLaisp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLaisp1.setText("Tải lại");
        btn_taiLaisp1.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLaisp1.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLaisp1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLaisp1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLaisp1.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLaisp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaisp1ActionPerformed(evt);
            }
        });

        btn_themVaoHoaDon.setForeground(new java.awt.Color(0, 204, 51));
        btn_themVaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/add.png"))); // NOI18N
        btn_themVaoHoaDon.setText("Thêm");
        btn_themVaoHoaDon.setColor1(new java.awt.Color(255, 255, 255));
        btn_themVaoHoaDon.setColor2(new java.awt.Color(255, 255, 255));
        btn_themVaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_themVaoHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_themVaoHoaDon.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_themVaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themVaoHoaDonActionPerformed(evt);
            }
        });

        btn_xoaKhoiHoaDon.setForeground(new java.awt.Color(255, 0, 0));
        btn_xoaKhoiHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/remove.png"))); // NOI18N
        btn_xoaKhoiHoaDon.setText("Xóa");
        btn_xoaKhoiHoaDon.setColor1(new java.awt.Color(255, 255, 255));
        btn_xoaKhoiHoaDon.setColor2(new java.awt.Color(255, 255, 255));
        btn_xoaKhoiHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoaKhoiHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_xoaKhoiHoaDon.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_xoaKhoiHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaKhoiHoaDonActionPerformed(evt);
            }
        });

        btn_huyHoaDon.setForeground(new java.awt.Color(255, 0, 0));
        btn_huyHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/remove.png"))); // NOI18N
        btn_huyHoaDon.setText("Hủy hóa đơn");
        btn_huyHoaDon.setColor1(new java.awt.Color(255, 255, 255));
        btn_huyHoaDon.setColor2(new java.awt.Color(255, 255, 255));
        btn_huyHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huyHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_huyHoaDon.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_huyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient19Layout = new javax.swing.GroupLayout(panelRoundGradient19);
        panelRoundGradient19.setLayout(panelRoundGradient19Layout);
        panelRoundGradient19Layout.setHorizontalGroup(
            panelRoundGradient19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_timSP, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_themVaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xoaKhoiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_huyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiLaisp1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient19Layout.setVerticalGroup(
            panelRoundGradient19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_taiLaisp1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themVaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoaKhoiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        roundPanelBorderBottom10.setBackground(new java.awt.Color(255, 255, 255));
        roundPanelBorderBottom10.setRound(10);

        jScrollPaneSachHD.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infoSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_infoSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_infoSachKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_infoSachKeyReleased(evt);
            }
        });
        jScrollPaneSachHD.setViewportView(tbl_infoSach);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Thông tin các sản phẩm");

        javax.swing.GroupLayout roundPanelBorderBottom10Layout = new javax.swing.GroupLayout(roundPanelBorderBottom10);
        roundPanelBorderBottom10.setLayout(roundPanelBorderBottom10Layout);
        roundPanelBorderBottom10Layout.setHorizontalGroup(
            roundPanelBorderBottom10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneSachHD)
            .addGroup(roundPanelBorderBottom10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(462, Short.MAX_VALUE))
        );
        roundPanelBorderBottom10Layout.setVerticalGroup(
            roundPanelBorderBottom10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanelBorderBottom10Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSachHD, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanelBorderBottom11.setBackground(new java.awt.Color(255, 255, 255));
        roundPanelBorderBottom11.setRound(10);

        jScrollPaneHD.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infoHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneHD.setViewportView(tbl_infoHoaDon);

        txt_giam.setForeground(new java.awt.Color(51, 51, 51));
        txt_giam.setText("0");
        txt_giam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_giam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_giamMouseClicked(evt);
            }
        });
        txt_giam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giamActionPerformed(evt);
            }
        });

        jLabel10.setText("% Giảm");

        jLabel11.setText("Tổng tiền:");

        txt_tongTien.setEditable(false);
        txt_tongTien.setForeground(new java.awt.Color(255, 0, 0));
        txt_tongTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tongTienActionPerformed(evt);
            }
        });

        jLabel12.setText("Khách hàng:");

        cbb_khachHang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Khách mới" }));
        cbb_khachHang.setToolTipText("");

        btn_luuHD.setForeground(new java.awt.Color(51, 51, 51));
        btn_luuHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/save.png"))); // NOI18N
        btn_luuHD.setText("Lưu hóa đơn");
        btn_luuHD.setColor1(new java.awt.Color(255, 255, 255));
        btn_luuHD.setColor2(new java.awt.Color(255, 255, 255));
        btn_luuHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_luuHD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_luuHD.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_luuHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuHDActionPerformed(evt);
            }
        });

        btn_giamGia.setForeground(new java.awt.Color(51, 51, 51));
        btn_giamGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/sale.png"))); // NOI18N
        btn_giamGia.setText("Giảm");
        btn_giamGia.setColor1(new java.awt.Color(255, 255, 255));
        btn_giamGia.setColor2(new java.awt.Color(255, 255, 255));
        btn_giamGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_giamGia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_giamGia.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_giamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_giamGiaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Thông tin sản phẩm trong hóa đơn");

        javax.swing.GroupLayout roundPanelBorderBottom11Layout = new javax.swing.GroupLayout(roundPanelBorderBottom11);
        roundPanelBorderBottom11.setLayout(roundPanelBorderBottom11Layout);
        roundPanelBorderBottom11Layout.setHorizontalGroup(
            roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanelBorderBottom11Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundPanelBorderBottom11Layout.createSequentialGroup()
                        .addGroup(roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanelBorderBottom11Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cbb_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanelBorderBottom11Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(roundPanelBorderBottom11Layout.createSequentialGroup()
                                        .addComponent(txt_giam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(btn_luuHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jScrollPaneHD, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        roundPanelBorderBottom11Layout.setVerticalGroup(
            roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom11Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneHD, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_giam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_luuHD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanelBorderBottom11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRoundGradient6Layout = new javax.swing.GroupLayout(panelRoundGradient6);
        panelRoundGradient6.setLayout(panelRoundGradient6Layout);
        panelRoundGradient6Layout.setHorizontalGroup(
            panelRoundGradient6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient19, javax.swing.GroupLayout.DEFAULT_SIZE, 1215, Short.MAX_VALUE)
                    .addGroup(panelRoundGradient6Layout.createSequentialGroup()
                        .addComponent(roundPanelBorderBottom10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanelBorderBottom11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelRoundGradient6Layout.setVerticalGroup(
            panelRoundGradient6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundGradient6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanelBorderBottom10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbed_main.addTab("Tạo đơn hàng", panelRoundGradient6);

        hienThi.setColorEnd(new java.awt.Color(255, 255, 255));
        hienThi.setColorStart(new java.awt.Color(255, 255, 255));

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));

        tbl_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(tbl_info);

        javax.swing.GroupLayout roundPanelBorderBottom3Layout = new javax.swing.GroupLayout(roundPanelBorderBottom3);
        roundPanelBorderBottom3.setLayout(roundPanelBorderBottom3Layout);
        roundPanelBorderBottom3Layout.setHorizontalGroup(
            roundPanelBorderBottom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane)
        );
        roundPanelBorderBottom3Layout.setVerticalGroup(
            roundPanelBorderBottom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom3Layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRoundGradient3.setColorEnd(new java.awt.Color(255, 51, 255));
        panelRoundGradient3.setColorStart(new java.awt.Color(0, 255, 255));

        txt_timSach.setForeground(new java.awt.Color(51, 51, 51));
        txt_timSach.setText("Tìm...");
        txt_timSach.setCaretColor(new java.awt.Color(0, 255, 255));
        txt_timSach.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txt_timSach.setRound(30);
        txt_timSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timSachMouseClicked(evt);
            }
        });
        txt_timSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timSachKeyReleased(evt);
            }
        });

        btn_taoDonHang2.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/add.png"))); // NOI18N
        btn_taoDonHang2.setText("Thêm");
        btn_taoDonHang2.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang2.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang2.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_taoDonHang2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_taoDonHang2MouseExited(evt);
            }
        });
        btn_taoDonHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang2ActionPerformed(evt);
            }
        });

        btn_taoDonHang3.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/cap_nhat.png"))); // NOI18N
        btn_taoDonHang3.setText("Cập nhật");
        btn_taoDonHang3.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang3.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang3.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang3ActionPerformed(evt);
            }
        });

        btn_taoDonHang4.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/remove.png"))); // NOI18N
        btn_taoDonHang4.setText("Xóa");
        btn_taoDonHang4.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang4.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang4.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang4ActionPerformed(evt);
            }
        });

        btn_taoDonHang5.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/thong_tin.png"))); // NOI18N
        btn_taoDonHang5.setText("Chi tiết");
        btn_taoDonHang5.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang5.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang5.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang5ActionPerformed(evt);
            }
        });

        btn_taiLaisp.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLaisp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLaisp.setText("Tải lại");
        btn_taiLaisp.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLaisp.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLaisp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLaisp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLaisp.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLaisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaispActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient3Layout = new javax.swing.GroupLayout(panelRoundGradient3);
        panelRoundGradient3.setLayout(panelRoundGradient3Layout);
        panelRoundGradient3Layout.setHorizontalGroup(
            panelRoundGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taoDonHang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(txt_timSach, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiLaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient3Layout.setVerticalGroup(
            panelRoundGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRoundGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_taoDonHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelRoundGradient3Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_taiLaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_timSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        txt_userName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_userName1.setForeground(new java.awt.Color(51, 51, 51));
        txt_userName1.setText("Thông tin sách");
        txt_userName1.setFocusable(false);
        txt_userName1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_userName1.setIconTextGap(10);

        javax.swing.GroupLayout hienThiLayout = new javax.swing.GroupLayout(hienThi);
        hienThi.setLayout(hienThiLayout);
        hienThiLayout.setHorizontalGroup(
            hienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hienThiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(hienThiLayout.createSequentialGroup()
                        .addComponent(txt_userName1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        hienThiLayout.setVerticalGroup(
            hienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hienThiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_userName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanelBorderBottom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbed_main.addTab("Sản phẩm", hienThi);

        panelRoundGradient8.setColorEnd(new java.awt.Color(255, 255, 255));
        panelRoundGradient8.setColorStart(new java.awt.Color(255, 255, 255));

        jScrollPanekm.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infokm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPanekm.setViewportView(tbl_infokm);

        javax.swing.GroupLayout roundPanelBorderBottom8Layout = new javax.swing.GroupLayout(roundPanelBorderBottom8);
        roundPanelBorderBottom8.setLayout(roundPanelBorderBottom8Layout);
        roundPanelBorderBottom8Layout.setHorizontalGroup(
            roundPanelBorderBottom8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanekm)
        );
        roundPanelBorderBottom8Layout.setVerticalGroup(
            roundPanelBorderBottom8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom8Layout.createSequentialGroup()
                .addComponent(jScrollPanekm, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRoundGradient17.setColorEnd(new java.awt.Color(255, 51, 255));
        panelRoundGradient17.setColorStart(new java.awt.Color(0, 255, 255));

        textField6.setForeground(new java.awt.Color(51, 51, 51));
        textField6.setText("Tìm...");
        textField6.setCaretColor(new java.awt.Color(0, 255, 255));
        textField6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        textField6.setRound(30);

        btn_taoDonHang27.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/add.png"))); // NOI18N
        btn_taoDonHang27.setText("Thêm");
        btn_taoDonHang27.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang27.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang27.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_taoDonHang27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_taoDonHang27MouseExited(evt);
            }
        });
        btn_taoDonHang27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang27ActionPerformed(evt);
            }
        });

        btn_taoDonHang28.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/cap_nhat.png"))); // NOI18N
        btn_taoDonHang28.setText("Cập nhật");
        btn_taoDonHang28.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang28.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang28.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang28ActionPerformed(evt);
            }
        });

        btn_taiLaikm.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLaikm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLaikm.setText("Tải lại");
        btn_taiLaikm.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLaikm.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLaikm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLaikm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLaikm.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLaikm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaikmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient17Layout = new javax.swing.GroupLayout(panelRoundGradient17);
        panelRoundGradient17.setLayout(panelRoundGradient17Layout);
        panelRoundGradient17Layout.setHorizontalGroup(
            panelRoundGradient17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taoDonHang27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiLaikm, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient17Layout.setVerticalGroup(
            panelRoundGradient17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRoundGradient17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_taoDonHang27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang28, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelRoundGradient17Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_taiLaikm, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelRoundGradient8Layout = new javax.swing.GroupLayout(panelRoundGradient8);
        panelRoundGradient8.setLayout(panelRoundGradient8Layout);
        panelRoundGradient8Layout.setHorizontalGroup(
            panelRoundGradient8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRoundGradient8Layout.setVerticalGroup(
            panelRoundGradient8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanelBorderBottom8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbed_main.addTab("Khuyến mãi", panelRoundGradient8);

        panelRoundGradient9.setColorEnd(new java.awt.Color(255, 255, 255));
        panelRoundGradient9.setColorStart(new java.awt.Color(255, 255, 255));

        jScrollPanetl.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infotl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPanetl.setViewportView(tbl_infotl);

        javax.swing.GroupLayout roundPanelBorderBottom4Layout = new javax.swing.GroupLayout(roundPanelBorderBottom4);
        roundPanelBorderBottom4.setLayout(roundPanelBorderBottom4Layout);
        roundPanelBorderBottom4Layout.setHorizontalGroup(
            roundPanelBorderBottom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanetl)
        );
        roundPanelBorderBottom4Layout.setVerticalGroup(
            roundPanelBorderBottom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom4Layout.createSequentialGroup()
                .addComponent(jScrollPanetl, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRoundGradient4.setColorEnd(new java.awt.Color(255, 51, 255));
        panelRoundGradient4.setColorStart(new java.awt.Color(0, 255, 255));

        textField2.setForeground(new java.awt.Color(51, 51, 51));
        textField2.setText("Tìm...");
        textField2.setCaretColor(new java.awt.Color(0, 255, 255));
        textField2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        textField2.setRound(30);

        btn_taoDonHang7.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/add.png"))); // NOI18N
        btn_taoDonHang7.setText("Thêm");
        btn_taoDonHang7.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang7.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang7.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_taoDonHang7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_taoDonHang7MouseExited(evt);
            }
        });
        btn_taoDonHang7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang7ActionPerformed(evt);
            }
        });

        btn_taoDonHang8.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/cap_nhat.png"))); // NOI18N
        btn_taoDonHang8.setText("Cập nhật");
        btn_taoDonHang8.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang8.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang8.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang8ActionPerformed(evt);
            }
        });

        btn_taiLaitl.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLaitl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLaitl.setText("Tải lại");
        btn_taiLaitl.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLaitl.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLaitl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLaitl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLaitl.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLaitl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaitlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient4Layout = new javax.swing.GroupLayout(panelRoundGradient4);
        panelRoundGradient4.setLayout(panelRoundGradient4Layout);
        panelRoundGradient4Layout.setHorizontalGroup(
            panelRoundGradient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taoDonHang7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiLaitl, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient4Layout.setVerticalGroup(
            panelRoundGradient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRoundGradient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_taoDonHang7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelRoundGradient4Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_taiLaitl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelRoundGradient9Layout = new javax.swing.GroupLayout(panelRoundGradient9);
        panelRoundGradient9.setLayout(panelRoundGradient9Layout);
        panelRoundGradient9Layout.setHorizontalGroup(
            panelRoundGradient9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRoundGradient9Layout.setVerticalGroup(
            panelRoundGradient9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanelBorderBottom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbed_main.addTab("Thể loại", panelRoundGradient9);

        panelRoundGradient10.setColorEnd(new java.awt.Color(255, 255, 255));
        panelRoundGradient10.setColorStart(new java.awt.Color(255, 255, 255));

        jScrollPanenv.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infonv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPanenv.setViewportView(tbl_infonv);

        javax.swing.GroupLayout roundPanelBorderBottom5Layout = new javax.swing.GroupLayout(roundPanelBorderBottom5);
        roundPanelBorderBottom5.setLayout(roundPanelBorderBottom5Layout);
        roundPanelBorderBottom5Layout.setHorizontalGroup(
            roundPanelBorderBottom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanenv)
        );
        roundPanelBorderBottom5Layout.setVerticalGroup(
            roundPanelBorderBottom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom5Layout.createSequentialGroup()
                .addComponent(jScrollPanenv, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRoundGradient5.setColorEnd(new java.awt.Color(255, 51, 255));
        panelRoundGradient5.setColorStart(new java.awt.Color(0, 255, 255));

        textField3.setForeground(new java.awt.Color(51, 51, 51));
        textField3.setText("Tìm...");
        textField3.setCaretColor(new java.awt.Color(0, 255, 255));
        textField3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        textField3.setRound(30);

        btn_taoDonHang12.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/add.png"))); // NOI18N
        btn_taoDonHang12.setText("Thêm");
        btn_taoDonHang12.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang12.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang12.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_taoDonHang12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_taoDonHang12MouseExited(evt);
            }
        });
        btn_taoDonHang12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang12ActionPerformed(evt);
            }
        });

        btn_taoDonHang13.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/cap_nhat.png"))); // NOI18N
        btn_taoDonHang13.setText("Cập nhật");
        btn_taoDonHang13.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang13.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang13.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang13ActionPerformed(evt);
            }
        });

        btn_taoDonHang14.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/remove.png"))); // NOI18N
        btn_taoDonHang14.setText("Xóa");
        btn_taoDonHang14.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang14.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang14.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang14ActionPerformed(evt);
            }
        });

        btn_taoDonHang15.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/thong_tin.png"))); // NOI18N
        btn_taoDonHang15.setText("Chi tiết");
        btn_taoDonHang15.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang15.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang15.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang15ActionPerformed(evt);
            }
        });

        btn_taiLainv.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLainv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLainv.setText("Tải lại");
        btn_taiLainv.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLainv.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLainv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLainv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLainv.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLainv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLainvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient5Layout = new javax.swing.GroupLayout(panelRoundGradient5);
        panelRoundGradient5.setLayout(panelRoundGradient5Layout);
        panelRoundGradient5Layout.setHorizontalGroup(
            panelRoundGradient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taoDonHang12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiLainv, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient5Layout.setVerticalGroup(
            panelRoundGradient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRoundGradient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_taoDonHang12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelRoundGradient5Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_taiLainv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelRoundGradient10Layout = new javax.swing.GroupLayout(panelRoundGradient10);
        panelRoundGradient10.setLayout(panelRoundGradient10Layout);
        panelRoundGradient10Layout.setHorizontalGroup(
            panelRoundGradient10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRoundGradient10Layout.setVerticalGroup(
            panelRoundGradient10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanelBorderBottom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbed_main.addTab("Nhân viên", panelRoundGradient10);

        panelRoundGradient11.setColorEnd(new java.awt.Color(255, 255, 255));
        panelRoundGradient11.setColorStart(new java.awt.Color(255, 255, 255));

        jScrollPanetk.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infotk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPanetk.setViewportView(tbl_infotk);

        javax.swing.GroupLayout roundPanelBorderBottom7Layout = new javax.swing.GroupLayout(roundPanelBorderBottom7);
        roundPanelBorderBottom7.setLayout(roundPanelBorderBottom7Layout);
        roundPanelBorderBottom7Layout.setHorizontalGroup(
            roundPanelBorderBottom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanetk)
        );
        roundPanelBorderBottom7Layout.setVerticalGroup(
            roundPanelBorderBottom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom7Layout.createSequentialGroup()
                .addComponent(jScrollPanetk, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRoundGradient16.setColorEnd(new java.awt.Color(255, 51, 255));
        panelRoundGradient16.setColorStart(new java.awt.Color(0, 255, 255));

        textField5.setForeground(new java.awt.Color(51, 51, 51));
        textField5.setText("Tìm...");
        textField5.setCaretColor(new java.awt.Color(0, 255, 255));
        textField5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        textField5.setRound(30);

        btn_taoDonHang22.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/add.png"))); // NOI18N
        btn_taoDonHang22.setText("Thêm");
        btn_taoDonHang22.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang22.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang22.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_taoDonHang22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_taoDonHang22MouseExited(evt);
            }
        });
        btn_taoDonHang22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang22ActionPerformed(evt);
            }
        });

        btn_taoDonHang23.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/cap_nhat.png"))); // NOI18N
        btn_taoDonHang23.setText("Cập nhật");
        btn_taoDonHang23.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang23.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang23.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang23ActionPerformed(evt);
            }
        });

        btn_taiLaitk.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLaitk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLaitk.setText("Tải lại");
        btn_taiLaitk.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLaitk.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLaitk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLaitk.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLaitk.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLaitk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaitkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient16Layout = new javax.swing.GroupLayout(panelRoundGradient16);
        panelRoundGradient16.setLayout(panelRoundGradient16Layout);
        panelRoundGradient16Layout.setHorizontalGroup(
            panelRoundGradient16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taoDonHang22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiLaitk, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient16Layout.setVerticalGroup(
            panelRoundGradient16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRoundGradient16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_taoDonHang22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang23, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelRoundGradient16Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_taiLaitk, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelRoundGradient11Layout = new javax.swing.GroupLayout(panelRoundGradient11);
        panelRoundGradient11.setLayout(panelRoundGradient11Layout);
        panelRoundGradient11Layout.setHorizontalGroup(
            panelRoundGradient11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRoundGradient11Layout.setVerticalGroup(
            panelRoundGradient11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanelBorderBottom7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbed_main.addTab("Thành viên", panelRoundGradient11);

        panelRoundGradient12.setBackground(new java.awt.Color(153, 255, 255));
        panelRoundGradient12.setColorEnd(new java.awt.Color(173, 172, 172));
        panelRoundGradient12.setColorStart(new java.awt.Color(35, 31, 31));

        cardDonHangTrongNgay.setDescription("Đơn hàng trong ngày");

        cardDoanhThuHomNay.setColor1(new java.awt.Color(153, 0, 153));
        cardDoanhThuHomNay.setColor2(new java.awt.Color(255, 102, 255));
        cardDoanhThuHomNay.setDescription("Doanh thu hôm nay");

        cardDoanhThuTrongThang.setColor1(new java.awt.Color(0, 255, 51));
        cardDoanhThuTrongThang.setColor2(new java.awt.Color(0, 255, 204));
        cardDoanhThuTrongThang.setDescription("Doanh thu trong tháng");

        cardTongTien.setColor1(new java.awt.Color(255, 0, 0));
        cardTongTien.setColor2(new java.awt.Color(255, 0, 255));
        cardTongTien.setDescription("Tổng doanh thu");

        roundPanelBorderBottom13.setBackground(new java.awt.Color(255, 255, 255));
        roundPanelBorderBottom13.setMauKetThuc(new java.awt.Color(0, 255, 51));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Tất cả hóa đơn");

        jScrollPanelTCHD1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_tcHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPanelTCHD1.setViewportView(tbl_tcHD);

        ccb_timHoaDon.setToolTipText("");
        ccb_timHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ccb_timHoaDonMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Tìm theo mã hóa đơn");

        btn_timHD.setForeground(new java.awt.Color(51, 51, 51));
        btn_timHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/search.png"))); // NOI18N
        btn_timHD.setText("Tìm");
        btn_timHD.setColor1(new java.awt.Color(255, 255, 255));
        btn_timHD.setColor2(new java.awt.Color(255, 255, 255));
        btn_timHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timHD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_timHD.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_timHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanelBorderBottom13Layout = new javax.swing.GroupLayout(roundPanelBorderBottom13);
        roundPanelBorderBottom13.setLayout(roundPanelBorderBottom13Layout);
        roundPanelBorderBottom13Layout.setHorizontalGroup(
            roundPanelBorderBottom13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanelTCHD1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
            .addGroup(roundPanelBorderBottom13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ccb_timHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_timHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanelBorderBottom13Layout.setVerticalGroup(
            roundPanelBorderBottom13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanelBorderBottom13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanelBorderBottom13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanelBorderBottom13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ccb_timHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_timHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPanelTCHD1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanelBorderBottom15.setBackground(new java.awt.Color(255, 255, 255));
        roundPanelBorderBottom15.setMauBatDau(new java.awt.Color(255, 0, 51));
        roundPanelBorderBottom15.setMauKetThuc(new java.awt.Color(255, 102, 51));

        jScrollPanelHH1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_shh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPanelHH1.setViewportView(tbl_shh);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Sản phẩm gần hết hàng");

        javax.swing.GroupLayout roundPanelBorderBottom15Layout = new javax.swing.GroupLayout(roundPanelBorderBottom15);
        roundPanelBorderBottom15.setLayout(roundPanelBorderBottom15Layout);
        roundPanelBorderBottom15Layout.setHorizontalGroup(
            roundPanelBorderBottom15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanelHH1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(roundPanelBorderBottom15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanelBorderBottom15Layout.setVerticalGroup(
            roundPanelBorderBottom15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom15Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanelHH1)
                .addContainerGap())
        );

        btn_taiLaitk1.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLaitk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLaitk1.setText("Tải lại");
        btn_taiLaitk1.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLaitk1.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLaitk1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLaitk1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLaitk1.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLaitk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaitk1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient20Layout = new javax.swing.GroupLayout(panelRoundGradient20);
        panelRoundGradient20.setLayout(panelRoundGradient20Layout);
        panelRoundGradient20Layout.setHorizontalGroup(
            panelRoundGradient20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient20Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(btn_taiLaitk1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient20Layout.setVerticalGroup(
            panelRoundGradient20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taiLaitk1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRoundGradient12Layout = new javax.swing.GroupLayout(panelRoundGradient12);
        panelRoundGradient12.setLayout(panelRoundGradient12Layout);
        panelRoundGradient12Layout.setHorizontalGroup(
            panelRoundGradient12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                .addGroup(panelRoundGradient12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cardDonHangTrongNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cardDoanhThuHomNay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cardDoanhThuTrongThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cardTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRoundGradient20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                        .addComponent(roundPanelBorderBottom13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanelBorderBottom15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRoundGradient12Layout.setVerticalGroup(
            panelRoundGradient12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                .addGroup(panelRoundGradient12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRoundGradient12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardDoanhThuTrongThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardDoanhThuHomNay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardDonHangTrongNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(panelRoundGradient20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundGradient12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanelBorderBottom13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbed_main.addTab("Thống kê", panelRoundGradient12);

        panelRoundGradient15.setColorEnd(new java.awt.Color(255, 255, 255));
        panelRoundGradient15.setColorStart(new java.awt.Color(255, 255, 255));

        jScrollPanetv.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infotv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPanetv.setViewportView(tbl_infotv);

        javax.swing.GroupLayout roundPanelBorderBottom6Layout = new javax.swing.GroupLayout(roundPanelBorderBottom6);
        roundPanelBorderBottom6.setLayout(roundPanelBorderBottom6Layout);
        roundPanelBorderBottom6Layout.setHorizontalGroup(
            roundPanelBorderBottom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanetv)
        );
        roundPanelBorderBottom6Layout.setVerticalGroup(
            roundPanelBorderBottom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom6Layout.createSequentialGroup()
                .addComponent(jScrollPanetv, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRoundGradient7.setColorEnd(new java.awt.Color(255, 51, 255));
        panelRoundGradient7.setColorStart(new java.awt.Color(0, 255, 255));

        textField4.setForeground(new java.awt.Color(51, 51, 51));
        textField4.setText("Tìm...");
        textField4.setCaretColor(new java.awt.Color(0, 255, 255));
        textField4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        textField4.setRound(30);

        btn_taoDonHang18.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/cap_nhat.png"))); // NOI18N
        btn_taoDonHang18.setText("Phân quyền");
        btn_taoDonHang18.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang18.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang18.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang18ActionPerformed(evt);
            }
        });

        btn_taoDonHang20.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/thong_tin.png"))); // NOI18N
        btn_taoDonHang20.setText("Chi tiết");
        btn_taoDonHang20.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang20.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang20.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang20ActionPerformed(evt);
            }
        });

        btn_taiLaitv.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLaitv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLaitv.setText("Tải lại");
        btn_taiLaitv.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLaitv.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLaitv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLaitv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLaitv.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLaitv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaitvActionPerformed(evt);
            }
        });

        btn_doiMatKhau.setForeground(new java.awt.Color(51, 51, 51));
        btn_doiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/password.png"))); // NOI18N
        btn_doiMatKhau.setText("Đổi mật khẩu");
        btn_doiMatKhau.setColor1(new java.awt.Color(255, 255, 255));
        btn_doiMatKhau.setColor2(new java.awt.Color(255, 255, 255));
        btn_doiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_doiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_doiMatKhau.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_doiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient7Layout = new javax.swing.GroupLayout(panelRoundGradient7);
        panelRoundGradient7.setLayout(panelRoundGradient7Layout);
        panelRoundGradient7Layout.setHorizontalGroup(
            panelRoundGradient7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taoDonHang18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_doiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiLaitv, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient7Layout.setVerticalGroup(
            panelRoundGradient7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_taoDonHang18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_taoDonHang20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_doiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundGradient7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_taiLaitv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRoundGradient15Layout = new javax.swing.GroupLayout(panelRoundGradient15);
        panelRoundGradient15.setLayout(panelRoundGradient15Layout);
        panelRoundGradient15Layout.setHorizontalGroup(
            panelRoundGradient15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRoundGradient15Layout.setVerticalGroup(
            panelRoundGradient15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(roundPanelBorderBottom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbed_main.addTab("Tài khoản", panelRoundGradient15);

        hienThi1.setColorEnd(new java.awt.Color(255, 255, 255));
        hienThi1.setColorStart(new java.awt.Color(255, 255, 255));

        jScrollPanenxb.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infonxb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPanenxb.setViewportView(tbl_infonxb);

        javax.swing.GroupLayout roundPanelBorderBottom9Layout = new javax.swing.GroupLayout(roundPanelBorderBottom9);
        roundPanelBorderBottom9.setLayout(roundPanelBorderBottom9Layout);
        roundPanelBorderBottom9Layout.setHorizontalGroup(
            roundPanelBorderBottom9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanenxb)
        );
        roundPanelBorderBottom9Layout.setVerticalGroup(
            roundPanelBorderBottom9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom9Layout.createSequentialGroup()
                .addComponent(jScrollPanenxb, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRoundGradient18.setColorEnd(new java.awt.Color(255, 51, 255));
        panelRoundGradient18.setColorStart(new java.awt.Color(0, 255, 255));

        textField7.setForeground(new java.awt.Color(51, 51, 51));
        textField7.setText("Tìm...");
        textField7.setCaretColor(new java.awt.Color(0, 255, 255));
        textField7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        textField7.setRound(30);

        btn_taoDonHang6.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/add.png"))); // NOI18N
        btn_taoDonHang6.setText("Thêm");
        btn_taoDonHang6.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang6.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang6.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_taoDonHang6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_taoDonHang6MouseExited(evt);
            }
        });
        btn_taoDonHang6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang6ActionPerformed(evt);
            }
        });

        btn_taoDonHang11.setForeground(new java.awt.Color(51, 51, 51));
        btn_taoDonHang11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/cap_nhat.png"))); // NOI18N
        btn_taoDonHang11.setText("Cập nhật");
        btn_taoDonHang11.setColor1(new java.awt.Color(255, 255, 255));
        btn_taoDonHang11.setColor2(new java.awt.Color(255, 255, 255));
        btn_taoDonHang11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taoDonHang11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taoDonHang11.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taoDonHang11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoDonHang11ActionPerformed(evt);
            }
        });

        btn_taiLainxb.setForeground(new java.awt.Color(51, 51, 51));
        btn_taiLainxb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/update.png"))); // NOI18N
        btn_taiLainxb.setText("Tải lại");
        btn_taiLainxb.setColor1(new java.awt.Color(255, 255, 255));
        btn_taiLainxb.setColor2(new java.awt.Color(255, 255, 255));
        btn_taiLainxb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_taiLainxb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_taiLainxb.setMauDiemCham(new java.awt.Color(0, 255, 255));
        btn_taiLainxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLainxbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient18Layout = new javax.swing.GroupLayout(panelRoundGradient18);
        panelRoundGradient18.setLayout(panelRoundGradient18Layout);
        panelRoundGradient18Layout.setHorizontalGroup(
            panelRoundGradient18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taoDonHang6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taoDonHang11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taiLainxb, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRoundGradient18Layout.setVerticalGroup(
            panelRoundGradient18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRoundGradient18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_taoDonHang6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_taoDonHang11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelRoundGradient18Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_taiLainxb, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        txt_userName2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_userName2.setForeground(new java.awt.Color(51, 51, 51));
        txt_userName2.setText("Thông tin nhà xuất bản");
        txt_userName2.setFocusable(false);
        txt_userName2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_userName2.setIconTextGap(10);

        javax.swing.GroupLayout hienThi1Layout = new javax.swing.GroupLayout(hienThi1);
        hienThi1.setLayout(hienThi1Layout);
        hienThi1Layout.setHorizontalGroup(
            hienThi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hienThi1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hienThi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanelBorderBottom9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(hienThi1Layout.createSequentialGroup()
                        .addComponent(txt_userName2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        hienThi1Layout.setVerticalGroup(
            hienThi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hienThi1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_userName2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanelBorderBottom9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbed_main.addTab("Nhà xuất bản", hienThi1);

        javax.swing.GroupLayout panelRoundGradient2Layout = new javax.swing.GroupLayout(panelRoundGradient2);
        panelRoundGradient2.setLayout(panelRoundGradient2Layout);
        panelRoundGradient2Layout.setHorizontalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbed_main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRoundGradient2Layout.setVerticalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbed_main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRoundGradient1Layout = new javax.swing.GroupLayout(panelRoundGradient1);
        panelRoundGradient1.setLayout(panelRoundGradient1Layout);
        panelRoundGradient1Layout.setHorizontalGroup(
            panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRoundGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRoundGradient1Layout.setVerticalGroup(
            panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRoundGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRoundGradient13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangXuatActionPerformed
        MessageDialog luaChon = new MessageDialog(this);
        luaChon.showMessage("Thông báo", "Bạn có chắc chắn muốn đăng xuất khỏi ứng dụng!");
        if(luaChon.getMessageType()== MessageDialog.MessageType.OK)
        {
            frmLogin f = new frmLogin();
            this.dispose();
            f.setVisible(true);
        }
    }//GEN-LAST:event_btn_dangXuatActionPerformed

    private void btn_taoDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHangActionPerformed
        tabbed_main.setSelectedIndex(0);
        tabbed_main.setName("Tạo hóa đơn");
        try {
//            loadSachHoaDon();
            khoiTaoThongTinHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taoDonHangActionPerformed

    public void loadComboboxThanhVien()
    {
         if(cbb_khachHang.getSelectedItem() != null)
        {
            cbb_khachHang.removeAllItems();
            cbb_khachHang.addItem("Khách mới");
        }
         try {
            loadTableThanhVien();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(ThanhVien data : lstThanhVien)
        {
            cbb_khachHang.addItem(data.getHoTen());
        }
    }
    
    private void btn_sanPhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanPhanActionPerformed
        tabbed_main.setSelectedIndex(1);
        try {
            loadTableSach();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_sanPhanActionPerformed

    private void btn_khuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khuyenMaiActionPerformed
        tabbed_main.setSelectedIndex(2);
        try {
            loadTableKhuyenMai();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_khuyenMaiActionPerformed

    private void btn_theLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_theLoaiActionPerformed
        tabbed_main.setSelectedIndex(3);
        try {
            loadTableTheLoai();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_theLoaiActionPerformed

    private void btn_nhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhanVienActionPerformed
        tabbed_main.setSelectedIndex(4);
        try {
            loadTableNhanVien();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_nhanVienActionPerformed

    private void btn_thanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhVienActionPerformed
        tabbed_main.setSelectedIndex(5);
        try {
            loadTableThanhVien();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_thanhVienActionPerformed

    private void btn_taiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiKhoanActionPerformed
        tabbed_main.setSelectedIndex(7);
        try {
            loadTableTaiKhoan();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiKhoanActionPerformed

    private void btn_thongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeActionPerformed
        tabbed_main.setSelectedIndex(6);
        try {
            thongKe();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_thongKeActionPerformed

    public void tongTienHoaDon() throws SQLException
    {
        ConnectionToDatabase connect = new ConnectionToDatabase();
        CHKB_HoaDonManipulation tt = new CHKB_HoaDonManipulation();
        String sql = "select sum(TongTien) as  N'Tổng tiền' from HoaDon";
        String tongTien = String.valueOf(connect.kieuTienVietNam().format(Double.parseDouble(tt.layTongTienHoaDon(sql))));
        cardTongTien.setValues(tongTien);
    }
    
    public void loadTatCaHoaDon()
    {
        ConnectionToDatabase connect = new ConnectionToDatabase();
        String sql = "select * from HoaDon hd, ChiTietHoaDonSach cthd where hd.MaHoaDon = cthd.MaHoaDon order by hd.MaHoaDon asc";
        modelAllHoaDon.setRowCount(0);
        modelAllHoaDon.setColumnIdentifiers(new Object[]{"Mã HD", "Ngày tạo", "Tổng tiền", "Người tạo", "Thành viên", "Tên sách", "Giá", "Số lượng", "Giảm", "Thành tiền"});//, "Trạng thái"
//        //Chuyển kiểu ngày Việt Nam
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat formatVN = new SimpleDateFormat("dd/MM/yyyy");

        try {
            lstAllHoaDon = connect.getAllData(sql);
            LamTuoiTatCaHoaDon(lstAllHoaDon);
//            for (HoaDon data : lstAllHoaDon) {
//                Date namSinh;
//                try {
//                    namSinh = formatnn.parse(data.getNgayTao());
//                    data.setNgayTao(formatVN.format(namSinh));
//                } catch (ParseException ex) {
//                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            loadTableNhanVien();
//            loadTableThanhVien();
//
//            for (HoaDon hd : lstAllHoaDon) {
//                for (NhanVien nv : lstNhanVien) {
//                    if (nv.getMaNhanVien().equals(hd.getNguoiTao())) {
//                        hd.setNguoiTao(nv.getHoTen());
//                        break;
//                    }
//                }
//                for (ThanhVien tv : lstThanhVien) {
//                    if (tv.getMaThanhVien().equals(hd.getMaThanhVien()) && hd.getMaThanhVien() != null) {
//                        hd.setMaThanhVien(tv.getHoTen());
//                        break;
//                    }
//                }
//                String tongTien = connect.kieuTienVietNam().format((long) Double.parseDouble(hd.getTongTien()));
//                String giaBan = connect.kieuTienVietNam().format((long) Double.parseDouble(hd.getGia()));
//                modelAllHoaDon.addRow(new Object[]{hd.getMaHoaDon(), hd.getNgayTao(), tongTien, hd.getNguoiTao(), hd.getMaThanhVien(), hd.getTenSach(), giaBan, hd.getSoLuong(), hd.getGiam(), hd.getThanhTien()});
//            }
        } catch (Exception ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LamTuoiTatCaHoaDon(List<HoaDon> lstAllHoaDon) throws SQLException, ParseException
    {
        ConnectionToDatabase connect = new ConnectionToDatabase();
        for (HoaDon data : lstAllHoaDon) {
                Date namSinh;
                try {
                    namSinh = formatnn.parse(data.getNgayTao());
                    data.setNgayTao(formatVN.format(namSinh));
                } catch (ParseException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            loadTableNhanVien();
            loadTableThanhVien();

            for (HoaDon hd : lstAllHoaDon) {
                for (NhanVien nv : lstNhanVien) {
                    if (nv.getMaNhanVien().equals(hd.getNguoiTao())) {
                        hd.setNguoiTao(nv.getHoTen());
                        break;
                    }
                }
                for (ThanhVien tv : lstThanhVien) {
                    if (tv.getMaThanhVien().equals(hd.getMaThanhVien()) && hd.getMaThanhVien() != null) {
                        hd.setMaThanhVien(tv.getHoTen());
                        break;
                    }
                }
                String tongTien = connect.kieuTienVietNam().format((long) Double.parseDouble(hd.getTongTien()));
                String giaBan = connect.kieuTienVietNam().format((long) Double.parseDouble(hd.getGia()));
                modelAllHoaDon.addRow(new Object[]{hd.getMaHoaDon(), hd.getNgayTao(), tongTien, hd.getNguoiTao(), hd.getMaThanhVien(), hd.getTenSach(), giaBan, hd.getSoLuong(), hd.getGiam(), hd.getThanhTien()});
            }
    }
    
    public void loadSanPhamHetHang() throws SQLException
    {
        ConnectionToDatabase connect = new ConnectionToDatabase();
        String sqlHetHang = "select * from Sach where SoLuong < 1000";
        modelSachHH.setRowCount(0);
        lstSachHH.clear();
        modelSachHH.setColumnIdentifiers(new Object[]{"Tên sách", "Giá bán", "Số lượng"});
        ResultSet rs = connect.SelectAll(sqlHetHang);
        while(rs.next())
        {
            lstSachHH.add(new Sach(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        for(Sach s : lstSachHH)
        {
            String giaBan = String.valueOf(connect.kieuTienVietNam().format(Double.parseDouble(s.getGiaBan())));
            modelSachHH.addRow(new Object[]{s.getTenSach(), giaBan, s.getSoLuong()});
        }
    }
    
    private void btn_nhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhaXuatBanActionPerformed
        tabbed_main.setSelectedIndex(8);
        try {
            loadTableNhaXuatBan();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_nhaXuatBanActionPerformed

    private void btn_taoDonHang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang2ActionPerformed
        try {
            frmThemSanPham f = new frmThemSanPham();
            f.setVisible(true);
            loadTableSach();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taoDonHang2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MessageDialog xacNhan = new MessageDialog(this);
        xacNhan.showMessage("Xác nhận", "Chọn đồng ý để đóng chương trình");
        if(xacNhan.getMessageType()==MessageDialog.MessageType.OK)
        {
//            this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btn_taoDonHang2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang2MouseEntered
        btn_taoDonHang2.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_taoDonHang2MouseEntered

    private void btn_taoDonHang2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang2MouseExited
        btn_taoDonHang2.setBackground(new Color(0,0,0));
    }//GEN-LAST:event_btn_taoDonHang2MouseExited

    private void btn_taoDonHang7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang7MouseEntered

    private void btn_taoDonHang7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang7MouseExited

    private void btn_taoDonHang7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang7ActionPerformed
        frmThemTheLoai f;
        try {
            f = new frmThemTheLoai();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taoDonHang7ActionPerformed

    private void btn_taoDonHang12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang12MouseEntered

    private void btn_taoDonHang12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang12MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang12MouseExited

    private void btn_taoDonHang12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang12ActionPerformed
        frmThemNhanVien f = new frmThemNhanVien();
        f.setVisible(true);
    }//GEN-LAST:event_btn_taoDonHang12ActionPerformed

    private void btn_taoDonHang22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang22MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang22MouseEntered

    private void btn_taoDonHang22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang22MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang22MouseExited

    private void btn_taoDonHang22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang22ActionPerformed
        frmThemThanhVien f;
        try {
            f = new frmThemThanhVien();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taoDonHang22ActionPerformed

    private void btn_taoDonHang27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang27MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang27MouseEntered

    private void btn_taoDonHang27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang27MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang27MouseExited

    private void btn_taoDonHang27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang27ActionPerformed
        frmThemKhuyemMai f;
        try {
            f = new frmThemKhuyemMai();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taoDonHang27ActionPerformed

    private void btn_taiLaispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaispActionPerformed
        try {
            loadTableSach();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLaispActionPerformed

    private void btn_taoDonHang6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang6MouseEntered

    private void btn_taoDonHang6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taoDonHang6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoDonHang6MouseExited

    private void btn_taoDonHang6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang6ActionPerformed
        try {
            frmThemNhaXuatBan f = new frmThemNhaXuatBan();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_taoDonHang6ActionPerformed

    private void btn_taiLainxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLainxbActionPerformed
        try {
            loadTableNhaXuatBan();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLainxbActionPerformed

    private void btn_taiLaitlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaitlActionPerformed
        try {
            loadTableTheLoai();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLaitlActionPerformed

    private void btn_taiLainvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLainvActionPerformed
        try {
            loadTableNhanVien();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLainvActionPerformed

    private void btn_taiLaitkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaitkActionPerformed
        try {
            loadTableThanhVien();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLaitkActionPerformed

    private void btn_taiLaitvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaitvActionPerformed
        try {
            loadTableTaiKhoan();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLaitvActionPerformed

    private void btn_taiLaikmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaikmActionPerformed
        try {
            loadTableKhuyenMai();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLaikmActionPerformed

    private void btn_taoDonHang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang3ActionPerformed
        int viTri = tbl_info.getSelectedRow();
        if (viTri < 0) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng chọn dòng trên bảng để cập nhật!");
        } else {
            Sach sach = lstSach.get(viTri);
            frmCapNhatSanPham f;
            try {
                f = new frmCapNhatSanPham(sach);
                f.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_taoDonHang3ActionPerformed

    private void btn_taoDonHang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang4ActionPerformed
        ThongBao tb = new ThongBao(this);
        if(mahaFunction.KiemTraVaiTro(doiTuongNhanVien) >= 10)
        {
        int viTri = tbl_info.getSelectedRow();
        if (viTri < 0) {
            tb.showMessage("Thông báo!", "Vui lòng chọn dòng trên bảng để xóa!");
        } else {
            Sach sach = lstSach.get(viTri);
            MessageDialog hoi = new MessageDialog(this);
            hoi.showMessage("Xác nhận", "Bạn có chắc muốn xóa sách " + sach.getTenSach());
            if (hoi.getMessageType() == MessageDialog.MessageType.OK) {
                CHKB_SachManipulation tt;
                try {
                    tt = new CHKB_SachManipulation();
                    String sql = "{call deleteSach(" + sach.getMaSach() + ")}";
//                JOptionPane.showConfirmDialog(null, "mã là "+ sql);
                    int kq = 0;
                    kq = tt.Delete(sql);
                    if (kq >= 1) {
                        tb.showMessage("Thông báo!", "Xóa thành công!");
                        loadTableSach();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }
        else
        {
             tb.showMessage("Thông báo!", "Bạn không có quyền này\nChỉ có Quản lý hoặc chủ cửa hàng mới có quyền này!");
        }
    }//GEN-LAST:event_btn_taoDonHang4ActionPerformed

    private void btn_taoDonHang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang5ActionPerformed
        int viTri = tbl_info.getSelectedRow();
        if (viTri < 0) {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Vui lòng chọn sản phẩm để xem chi tiết!");
        } else {
            Sach s = lstSach.get(viTri);
            frmChiTietSach f = new frmChiTietSach(s.getTenSach(), s.getGiaBan(), s.getSoLuong(), s.getTap(), s.getHinh(), s.getViTri(), s.getTrangThai(), s.getTacGia(), s.getTenChuongTrinh(), s.getMaTheLoai(), s.getMaNhaXuatBan());
            f.setVisible(true);
        }
    }//GEN-LAST:event_btn_taoDonHang5ActionPerformed


    
    private void btn_taiLaisp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaisp1ActionPerformed
        try {
//            loadSachHoaDon();
            khoiTaoThongTinHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLaisp1ActionPerformed

    private void txt_giamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giamActionPerformed

    private void txt_tongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tongTienActionPerformed

    private void txt_timSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_timSPMouseClicked
        txt_timSP.setText("");
    }//GEN-LAST:event_txt_timSPMouseClicked

    private void txt_timSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_timSPMouseExited
//        txt_timSP.setText("Nhập nội dung cần tìm?");
    }//GEN-LAST:event_txt_timSPMouseExited

    private void txt_timSPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_timSPMouseReleased

    }//GEN-LAST:event_txt_timSPMouseReleased

    private void tbl_infoSachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_infoSachKeyPressed

    }//GEN-LAST:event_tbl_infoSachKeyPressed

//    public void layThongTinHoaDon() {
//        txt_giam.getText().trim();
//        cbb_khachHang.getSelectedItem();
//    }


    private void btn_themVaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themVaoHoaDonActionPerformed
        int viTri = tbl_infoSach.getSelectedRow();
        if (viTri < 0) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng chọn sản phẩm để thêm vào hóa đơn!");
        } else {
            String tenThanhVien = (String) cbb_khachHang.getSelectedItem();
            String maThanhVien = "null";
            try {
                loadTableThanhVien();
                for (ThanhVien tv : lstThanhVien) {
                    if(tv.getHoTen().equalsIgnoreCase(tenThanhVien))
                    {
                        maThanhVien = tv.getMaThanhVien();
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
//            Sach s = lstSach.get(viTri);
            Sach s = lstHoaDon.get(viTri);
            //Kiểm tra xem có khuyến mãi không để trừ tiền
            String giamGia = "0";
            try {
                loadTableKhuyenMai();
                for(KhuyenMai km : lstKhuyenMai)
                {
//                    JOptionPane.showConfirmDialog(null, km.getTenChuongTrinh() + " " + s.getMaKhuyenMai()+ " "+ km.getTrangThai());
                    if(km.getMaKhuyenMai().equals(s.getMaKhuyenMai()) && km.getTrangThai().equals("1"))
                    {
                        giamGia = km.getGiam();
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            modelHoaDon.setColumnIdentifiers(new Object[]{"Sản phẩm", "Số lượng", "Đơn giá", "Giảm", "Thành tiền"});
//            HoaDon hd = null;
            if (lstTaoHoaDon.size() > 0) {
                int dem = 0;
                for (HoaDon hdf : lstTaoHoaDon) {
                    if (hdf.getTenSach().equalsIgnoreCase(s.getTenSach())) {
                        int soLuongMoi = Integer.parseInt(hdf.getSoLuong()) + 1;
                        hdf.setSoLuong(String.valueOf(soLuongMoi));
                        Double tongTien = hdf.tongTien(lstTaoHoaDon);
                        txt_tongTien.setText("" + kieuTienVietNam().format(tongTien));
                        //Cập nhật lại thay đổi giao diện
                        lamTuoiTaoHD();
                        dem++;
                        break;
                    }
                }
                if (dem == 0) {
                    themSanPhamVaoList(ngayHienTai, maNhanVien, "1", maThanhVien, s.getMaSach(), s.getTenSach(), s.getGiaBan(), "1", giamGia);
                }
            } else {
                themSanPhamVaoList(ngayHienTai, maNhanVien, "1", maThanhVien, s.getMaSach(), s.getTenSach(), s.getGiaBan(), "1", giamGia);
            }
        }
    }//GEN-LAST:event_btn_themVaoHoaDonActionPerformed

    public void themSanPhamVaoList(String NgayTao, String NguoiTao, String TrangThai, String MaThanhVien, String MaSach, String TenSach, String Gia, String SoLuong, String Giam)
    {
        HoaDon hd = new HoaDon(NgayTao, NguoiTao, TrangThai, MaThanhVien, MaSach, TenSach, Gia, SoLuong, Giam);
        String thanhTien = String.valueOf(kieuTienVietNam().format(hd.thanhTien()));
        HoaDon hdc = new HoaDon(NgayTao, NguoiTao, TrangThai, MaThanhVien, MaSach, TenSach, Gia, SoLuong, Giam, thanhTien);
        lstTaoHoaDon.add(hdc);
        modelHoaDon.addRow(new Object[]{hd.getTenSach(), hd.getSoLuong(), hd.getGia(), hd.getGiam()+ "%", hdc.getThanhTien()});//thanhTien
        Double tongTien = hdc.tongTien(lstTaoHoaDon);
        txt_tongTien.setText("" + kieuTienVietNam().format(tongTien));
    }
    
    public void lamTuoiTaoHD()
    {
        modelHoaDon.setRowCount(0);
        modelHoaDon.setColumnIdentifiers(new Object[]{"Sản phẩm", "Số lượng", "Đơn giá", "Giảm", "Thành tiền"});
        for(HoaDon hd: lstTaoHoaDon)
        {
            String thanhTien = String.valueOf(kieuTienVietNam().format(hd.thanhTien()));
            modelHoaDon.addRow(new Object[]{hd.getTenSach(), hd.getSoLuong(), hd.getGia(), hd.getGiam()+"%", thanhTien});
        }
    }
    
    private void btn_luuHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuHDActionPerformed
        int kichThuocList = lstTaoHoaDon.size();
        if (kichThuocList > 0) {
            try {
                CHKB_HoaDonManipulation thd = new CHKB_HoaDonManipulation();
                String sql = "{call taoHoaDon(?,?,?,?,?)}";
                
                HoaDon hdkb = lstTaoHoaDon.get(0);
//HoaDon hdkb = lstTaoHoaDon.get(kichThuocList-1);
                String tongTienHD = String.valueOf(hdkb.tongTien(lstTaoHoaDon));
                
                  String tenThanhVien = (String) cbb_khachHang.getSelectedItem();
            String maThanhVien = "null";
            try {
                loadTableThanhVien();
                for (ThanhVien tv : lstThanhVien) {
                    if(tv.getHoTen().equalsIgnoreCase(tenThanhVien))
                    {
                        maThanhVien = tv.getMaThanhVien();
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
                
//                String maThanhVien = "NULL";
                if (maThanhVien.equalsIgnoreCase("null") || maThanhVien.isEmpty()) {
                    maThanhVien = "NULL";
                } 
//                else {
//                    maThanhVien = hdkb.getMaThanhVien();
//                }
                String taoHoaDonSQL = "set dateformat dmy insert into HoaDon values('"+hdkb.getNgayTao()+"', "+tongTienHD+", "+hdkb.getNguoiTao()+", "+hdkb.getTrangThai()+", "+maThanhVien+")";
//                JOptionPane.showConfirmDialog(null, "Ngày tạo"+ hdkb.getNgayTao());
//                HoaDon hoaDon = new HoaDon(hdkb.getNgayTao(), hdkb.getNguoiTao(), hdkb.getTrangThai(), hdkb.getMaThanhVien(), hdkb.getMaSach(), hdkb.getTenSach(), hdkb.getGia(), hdkb.getSoLuong(), hdkb.getGiam());
//                String tongTienHD = String.valueOf(hdkb.tongTien(lstTaoHoaDon));
                int rs = 0;
//                        = thd.insertHoaDon(sql, hoaDon, tongTienHD);
                ConnectionToDatabase con = new ConnectionToDatabase();
                rs = con.ThemXoaSua(taoHoaDonSQL);
                //Lưu chi tiết hóa đơn
                //String NgayTao, String NguoiTao, String TrangThai, String MaThanhVien, String MaSach, String TenSach, String Gia, String SoLuong, String Giam
                String sqlct = "{call themChiTietHoaDon(?,?,?,?,?,?)}";
                for(HoaDon hd : lstTaoHoaDon)
                {
                    HoaDon CThoaDon = new HoaDon(hd.getNgayTao(), hd.getNguoiTao(), hd.getTrangThai(), hd.getMaThanhVien(), hd.getMaSach(), hd.getTenSach(), hd.getGia(), hd.getSoLuong(), hd.getGiam()+"%", String.valueOf(kieuTienVietNam().format(hd.thanhTien())));
                    rs += thd.insertChiTietHD(sqlct, CThoaDon);
                    //cập nhật lại số lượng sách đã bán
                    String capNhatLaiSoLuongSach = "update Sach set SoLuong = SoLuong - "+hd.getSoLuong()+" where MaSach = "+ hd.getMaSach();
                    rs += con.ThemXoaSua(capNhatLaiSoLuongSach);
                    //Cập nhật điểm cho thành viên
                    if(con.kiemTraSo(maThanhVien)){
                    String sqlCapNhatDiem = "update ThanhVien set Diem += "+tongTienHD+"/100 where MaThanhVien = "+ maThanhVien;
                    con.ThemXoaSua(sqlCapNhatDiem);
                    }
                }
                if(rs>0)
                {
                    ThongBao t = new ThongBao(this);
                    t.showMessage("Thông báo", "Lưu hóa đơn thành công!!!");
                    lstTaoHoaDon.clear();
                    lamTuoiTaoHD();
                    txt_tongTien.setText("");
                    txt_giam.setText("0");
                    cbb_khachHang.setSelectedIndex(0);
                    loadSachHoaDon();
                }
                else
                {
                    ThongBao t = new ThongBao(this);
                    t.showMessage("Thông báo", "Trời ơi lỗi rồi!!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                 ThongBao t = new ThongBao(this);
                    t.showMessage("Thông báo", "Trời ơi lỗi rồi!!!");
            }
        } else {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Chưa có sản phẩm nào trong hóa đơn vui lòng thêm sản phẩm vào hóa đơn để lưu!!!");
        }
    }//GEN-LAST:event_btn_luuHDActionPerformed

    private void txt_timSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timSPKeyPressed
        
    }//GEN-LAST:event_txt_timSPKeyPressed

    private void tbl_infoSachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_infoSachKeyReleased
       
    }//GEN-LAST:event_tbl_infoSachKeyReleased

    private void txt_timSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timSPKeyReleased
        // TODO add your handling code here:
         String tuKhoa = txt_timSP.getText().trim();
        if(tuKhoa.isEmpty())
        {
             try {
//                 lamTuoiSach();
                 loadSachHoaDon();
             } catch (SQLException ex) {
                 Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else
        {
            String sql = "select * from sach where TenSach like N'%"+tuKhoa+"%' or MaSach like N'%"+tuKhoa+"%'";
            ConnectionToDatabase con = new ConnectionToDatabase();
            lstHoaDon.clear();
             try {
                 ResultSet rs = con.SelectAll(sql);
                 while(rs.next())
                 {
                     lstHoaDon.add(new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
             }
            BangTimTheoTen(lstHoaDon);
        }
    }//GEN-LAST:event_txt_timSPKeyReleased

    
    
    private void btn_giamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_giamGiaActionPerformed
        int viTri = tbl_infoHoaDon.getSelectedRow();
        String phanTramGiam = txt_giam.getText().trim();
        int kichThuocList = lstTaoHoaDon.size();
        if (kichThuocList > 0) {
            if (phanTramGiam.isEmpty() == false) {
                ConnectionToDatabase con = new ConnectionToDatabase();
                if (con.kiemTraSoHoacBango(phanTramGiam)) {
                    if (con.kiemTraSoKhuyenMai(phanTramGiam) == true) {
                        HoaDon hd = lstTaoHoaDon.get(kichThuocList - 1);
                        if (viTri >= 0) {
                            HoaDon sanPham = lstTaoHoaDon.get(viTri);
                            sanPham.setGiam(phanTramGiam);
                            lamTuoiTaoHD();
                            //Tính lại tổng tiền
                            Double tongTien = hd.tongTien(lstTaoHoaDon);
                            txt_tongTien.setText("" + kieuTienVietNam().format(tongTien));
                        } else {
                            hd.setGiam(phanTramGiam);
                            lamTuoiTaoHD();
                            //Tính lại tổng tiền
                            Double tongTien = hd.tongTien(lstTaoHoaDon);
                            txt_tongTien.setText("" + kieuTienVietNam().format(tongTien));
                        }
                    } else {
                        ThongBao t = new ThongBao(this);
                        t.showMessage("Thông báo", "Phần trăm khuyến mãi không được vượt quá 100%!!!");
                    }
                } else {
                    ThongBao t = new ThongBao(this);
                    t.showMessage("Thông báo", "Phần trăm khuyến mãi là một số nguyên!!!");
                }
            } else {
                ThongBao t = new ThongBao(this);
                t.showMessage("Thông báo", "Vui lòng nhập vào phần trăm giảm giá!!!");
            }
        } else {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Hóa đơn chưa có sản phẩm vui lòng thêm sản phẩm để tiến hành giảm giá!!!");
        }
    }//GEN-LAST:event_btn_giamGiaActionPerformed

    private void btn_xoaKhoiHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaKhoiHoaDonActionPerformed
        int viTri = tbl_infoHoaDon.getSelectedRow();
        if (viTri >= 0) {
            HoaDon hd = lstTaoHoaDon.get(viTri);
            MessageDialog tb = new MessageDialog(this);
            tb.showMessage("Cảnh báo", "Bạn có chắc muốn xóa "+ hd.getTenSach() + " ra khỏi hóa đơn", "Xóa sản phẩm", "Không xóa", "/CHKB_IMAGE/warning_55.png");
            if (tb.getMessageType() == MessageDialog.MessageType.OK) {
                lstTaoHoaDon.remove(viTri);
                Double tongTien = hd.tongTien(lstTaoHoaDon);
                txt_tongTien.setText("" + kieuTienVietNam().format(tongTien));
                lamTuoiTaoHD();
            }
        } else {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Vui lòng chọn sản phẩm tại hóa đơn để xóa khỏi!!!");
        }
    }//GEN-LAST:event_btn_xoaKhoiHoaDonActionPerformed

    private void btn_huyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyHoaDonActionPerformed
        int kichThuocList = lstTaoHoaDon.size();
        if (kichThuocList > 0) {
        MessageDialog tb = new MessageDialog(this);
        tb.showMessage("Cảnh báo", "Hóa đơn này sẽ bị hủy bạn có chắc chắn", "Xóa hóa đơn", "Không xóa", "/CHKB_IMAGE/warning_55.png");
        if (tb.getMessageType() == MessageDialog.MessageType.OK) {
            lstTaoHoaDon.clear();
            lamTuoiTaoHD();
            txt_tongTien.setText("");
            txt_giam.setText("0");
        }
        } else {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Không có hóa đơn nào để xóa!!!");
        }
    }//GEN-LAST:event_btn_huyHoaDonActionPerformed

    private void txt_giamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_giamMouseClicked
        txt_giam.setText("");
    }//GEN-LAST:event_txt_giamMouseClicked

    private void btn_taoDonHang13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang13ActionPerformed
        int viTri = tbl_infonv.getSelectedRow();
        if (viTri >= 0) {
            NhanVien nv = lstNhanVien.get(viTri);
            try {
                frmCapNhatNhanVien fnv = new frmCapNhatNhanVien(nv);
                fnv.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Vui lòng chọn nhân viên trên bảng để cập nhật!!!");
        }
    }//GEN-LAST:event_btn_taoDonHang13ActionPerformed

    private void btn_taoDonHang14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang14ActionPerformed
        ThongBao tb = new ThongBao(this);
        if(mahaFunction.KiemTraVaiTro(doiTuongNhanVien) >= 10)
        {
        int viTri = tbl_infonv.getSelectedRow();
        if (viTri < 0) {
            tb.showMessage("Thông báo!", "Vui lòng chọn dòng trên bảng để xóa!");
        } else {
            NhanVien sach = lstNhanVien.get(viTri);
            MessageDialog hoi = new MessageDialog(this);
            hoi.showMessage("Xác nhận", "Bạn có chắc muốn xóa nhân viên: " + sach.getHoTen());
            if (hoi.getMessageType() == MessageDialog.MessageType.OK) {
//                ManipulationNhanVien tt;
                try {
//                    tt = new ManipulationNhanVien();
//                    String sql = "{call DeleteNhanVien(" + sach.getMaNhanVien()+ ")}";
                    String sql = "update NhanVien set TrangThai = '0' where MaNhanVien = " + sach.getMaNhanVien();
                    ConnectionToDatabase con = new ConnectionToDatabase();
//                    int kq = 0;
//                    kq = tt.Delete(sql);
//                    if (kq >= 1) {
                    if (con.ThemXoaSua(sql) >= 1) {
                        tb.showMessage("Thông báo!", "Nhân viên"+sach.getHoTen()+" đã đưa vào trạng thái nghĩ!");
                        loadTableNhanVien();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }
        else
        {
             tb.showMessage("Thông báo!", "Bạn không có quyền này\nChỉ có Quản lý hoặc chủ cửa hàng mới có quyền này!");
        }
    }//GEN-LAST:event_btn_taoDonHang14ActionPerformed

    private void btn_taoDonHang15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang15ActionPerformed
        int viTri = tbl_infonv.getSelectedRow();
        if (viTri < 0) {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Vui lòng chọn nhân viên trên bảng để xem chi tiết!");
        } else {
            NhanVien nv = lstNhanVien.get(viTri);
            frmChiTietThonTinNhanVien f = new frmChiTietThonTinNhanVien(nv);
            f.setVisible(true);
        }
    }//GEN-LAST:event_btn_taoDonHang15ActionPerformed

    private void btn_taoDonHang18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang18ActionPerformed
        int viTri = tbl_infotv.getSelectedRow();
        if(mahaFunction.KiemTraVaiTro(doiTuongNhanVien) >= 10)
        {
        if (viTri >= 0) {
            NhanVien nv = lstTaiKhoan.get(viTri);
            frmCapNhatQuyenTaiKhoan fnv;
            try {
                fnv = new frmCapNhatQuyenTaiKhoan(nv);
                fnv.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Vui lòng chọn tài khoản trên bảng để Phân quyền!!!");
        }
        }
        else
        {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Bạn không có quyền này\nChỉ có Quản lý hoặc chủ cửa hàng mới có quyền này!");
        }
    }//GEN-LAST:event_btn_taoDonHang18ActionPerformed

    private void btn_doiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doiMatKhauActionPerformed
        NhanVien nhanVien = null;
        for(int i = 0; i < lstTaiKhoan.size(); i++) {
            if (lstTaiKhoan.get(i).getHoTen().equals(txt_userName.getText())) {
                nhanVien = lstTaiKhoan.get(i);
                break;
            }
        }
        if (nhanVien != null) {
            frmCapNhatTaiKhoan f = new frmCapNhatTaiKhoan(nhanVien);
            f.setVisible(true);
        } else {
            System.out.println("Chó!");
        }
    }//GEN-LAST:event_btn_doiMatKhauActionPerformed

    private void btn_taoDonHang20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang20ActionPerformed
        int viTri = tbl_infotv.getSelectedRow();
        if(mahaFunction.KiemTraVaiTro(doiTuongNhanVien) >= 10)
        {
        if (viTri < 0) {
            ThongBao t = new ThongBao(this);
            t.showMessage("Thông báo", "Vui lòng chọn nhân viên trên bảng để xem chi tiết!");
        } else {
            try {
                loadTableNhanVien();
                NhanVien nv = lstNhanVien.get(viTri);
                frmChiTietThonTinNhanVien f = new frmChiTietThonTinNhanVien(nv);
                f.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else
        {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Bạn không có quyền này\nChỉ có Quản lý hoặc chủ cửa hàng mới có quyền này!");
        }
    }//GEN-LAST:event_btn_taoDonHang20ActionPerformed

    private void btn_taoDonHang28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang28ActionPerformed
        int viTri = tbl_infokm.getSelectedRow();
        if (viTri < 0) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng chọn dòng trên bảng để cập nhật!");
        } else {
            KhuyenMai km = lstKhuyenMai.get(viTri);
            frmCapNhatKhuyenMai f;
            try {
                f = new frmCapNhatKhuyenMai(km);
                f.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_taoDonHang28ActionPerformed

    private void btn_taoDonHang23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang23ActionPerformed
        int viTri = tbl_infotk.getSelectedRow();
        if (viTri < 0) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng chọn dòng trên bảng để cập nhật!");
        } else {
            ThanhVien sach = lstThanhVien.get(viTri);
            frmCapNhatThanhVien f;
            try {
                f = new frmCapNhatThanhVien(sach);
                f.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_taoDonHang23ActionPerformed

    private void btn_taoDonHang8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang8ActionPerformed
        int viTri = tbl_infotl.getSelectedRow();
        if (viTri < 0) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng chọn dòng trên bảng để cập nhật!");
        } else {
            TheLoai sach = lstTheLoai.get(viTri);
            frmCapNhatTheLoai f;
            try {
                f = new frmCapNhatTheLoai(sach);
                f.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_taoDonHang8ActionPerformed

    private void btn_taoDonHang11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonHang11ActionPerformed
        int viTri = tbl_infonxb.getSelectedRow();
        if (viTri < 0) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng chọn dòng trên bảng để cập nhật!");
        } else {
            NhaXuatBan sach = lstNhaXuatBan.get(viTri);
            frmCapNhaXuatBan f;
            try {
                f = new frmCapNhaXuatBan(sach);
                f.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_taoDonHang11ActionPerformed

    private void btn_taiLaitk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaitk1ActionPerformed
        try {
            thongKe();
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taiLaitk1ActionPerformed

    private void ccb_timHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ccb_timHoaDonMouseClicked
        
    }//GEN-LAST:event_ccb_timHoaDonMouseClicked

    public void loadMaHoaDon()
    {
        if(ccb_timHoaDon.getSelectedItem() != null)
        {
            ccb_timHoaDon.removeAllItems();
        }
//        List<String> lstMaHoaDon = new ArrayList<>();
        String sql = "select distinct MaHoaDon from HoaDon";
        ConnectionToDatabase con = new ConnectionToDatabase();
//        lstMaHoaDon.clear();
        ResultSet rs;
        try {
//            ccb_timHoaDon.removeAll();
            rs = con.SelectAll(sql);
            while (rs.next()) {
//                lstMaHoaDon.add();
                ccb_timHoaDon.addItem(rs.getString(1));
            }
//            for(String ma : lstMaHoaDon)
//            {
//                ccb_timHoaDon.addItem(ma);
//            }
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btn_timHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timHDActionPerformed
        try {
            ConnectionToDatabase con = new ConnectionToDatabase();
            String tuKhoa = (String) ccb_timHoaDon.getSelectedItem();
//            JOptionPane.showConfirmDialog(null, tuKhoa);
            String sql = "select * from HoaDon hd, ChiTietHoaDonSach cthd where hd.MaHoaDon = cthd.MaHoaDon and hd.MaHoaDon = "+tuKhoa+" order by hd.MaHoaDon asc";
            ResultSet rs = con.SelectAll(sql);
            lstAllHoaDon.clear();
            modelAllHoaDon.setRowCount(0);
            while (rs.next()) {
                lstAllHoaDon.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
            }
            
            LamTuoiTatCaHoaDon(lstAllHoaDon);
//            for (HoaDon hd : lstAllHoaDon) {
//                //Load combobox
////                ccb_timHoaDon.addItem(hd.getMaHoaDon());
//                String giaBan = String.valueOf(con.kieuTienVietNam().format((long) Double.parseDouble(hd.getGia())));
//                modelAllHoaDon.addRow(new Object[]{hd.getMaHoaDon(), hd.getNgayTao(), hd.getTongTien(), hd.getNguoiTao(), hd.getTrangThai(), hd.getMaThanhVien(), hd.getMaSach(), hd.getTenSach(), giaBan, hd.getSoLuong(), hd.getGiam(), hd.getThanhTien()});
//            }
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_timHDActionPerformed

    private void txt_timSachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timSachKeyReleased
        String tuKhoa = txt_timSach.getText().trim();
        if(tuKhoa.isEmpty())
        {
             try {
                 loadTableSach();
             } catch (SQLException ex) {
                 Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else
        {
            String sql = "select * from sach where TenSach like N'%"+tuKhoa+"%' or MaSach like N'%"+tuKhoa+"%'";
            ConnectionToDatabase con = new ConnectionToDatabase();
            lstSach.clear();
             try {
                 ResultSet rs = con.SelectAll(sql);
                 while(rs.next())
                 {
                     lstSach.add(new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
             }
            lamTuoiSach(lstSach);
        }
    }//GEN-LAST:event_txt_timSachKeyReleased

    private void txt_timSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_timSachMouseClicked
        txt_timSach.setText("");
    }//GEN-LAST:event_txt_timSachMouseClicked

    public void thongKe() throws SQLException, ParseException
    {
        loadTatCaHoaDon();
        loadSanPhamHetHang();
        tongTienHoaDon();
        thongKeSoHoaDonTrongNgay();
        thongKeDoanhThuTrongThang();
        thongKeDoanhThuTrongNgay();
        loadMaHoaDon();
    }
    
    public void thongKeSoHoaDonTrongNgay() throws SQLException
    {
        ConnectionToDatabase connect = new ConnectionToDatabase();
        CHKB_HoaDonManipulation tt = new CHKB_HoaDonManipulation();
        String sql = "set dateformat dmy select count(*) from HoaDon where NgayTao = '"+ngayHienTai+"'";
        String soHoaDonTrongNgay = tt.thongKe(sql);
        cardDonHangTrongNgay.setValues(soHoaDonTrongNgay);
    }
    
    public void thongKeDoanhThuTrongThang() throws SQLException, ParseException
    {
        //Chuyển ngày
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngayHienTai);
        SimpleDateFormat getDate = new SimpleDateFormat("dd");
        SimpleDateFormat getMonth = new SimpleDateFormat("MM");
        SimpleDateFormat getYear = new SimpleDateFormat("yyyy");
        
        String ngayHienTai = getDate.format(date);
        String thangHienTai = getMonth.format(date);
        String namHienTai = getYear.format(date);
        
        ConnectionToDatabase connect = new ConnectionToDatabase();
        CHKB_HoaDonManipulation tt = new CHKB_HoaDonManipulation();
        String sql = "set dateformat dmy select sum(TongTien) from HoaDon where month(NgayTao) = '"+thangHienTai+"' and year(NgayTao) = '"+namHienTai+"'";
        String doanhThuTrongThang = String.valueOf(connect.kieuTienVietNam().format(Double.parseDouble(tt.thongKe(sql))));
        cardDoanhThuTrongThang.setValues(doanhThuTrongThang);
    }
    
        public void thongKeDoanhThuTrongNgay() throws SQLException
    {
        ConnectionToDatabase connect = new ConnectionToDatabase();
        CHKB_HoaDonManipulation tt = new CHKB_HoaDonManipulation();
        String sql = "set dateformat dmy select sum(TongTien) from HoaDon where NgayTao = '"+ngayHienTai+"'";
        String doanhThuHomNay = String.valueOf(connect.kieuTienVietNam().format(Double.parseDouble(tt.thongKe(sql))));
        cardDoanhThuHomNay.setValues(doanhThuHomNay);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmMain().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CHKB_DESIGN.ButtonGradientRound btn_dangXuat;
    private CHKB_DESIGN.ButtonGradientRound btn_doiMatKhau;
    private CHKB_DESIGN.ButtonGradientRound btn_giamGia;
    private CHKB_DESIGN.ButtonGradientRound btn_huyHoaDon;
    private CHKB_DESIGN.ButtonGradientRound btn_khuyenMai;
    private CHKB_DESIGN.ButtonGradientRound btn_luuHD;
    private CHKB_DESIGN.ButtonGradientRound btn_nhaXuatBan;
    private CHKB_DESIGN.ButtonGradientRound btn_nhanVien;
    private CHKB_DESIGN.ButtonGradientRound btn_sanPhan;
    private CHKB_DESIGN.ButtonGradientRound btn_taiKhoan;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLaikm;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLainv;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLainxb;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLaisp;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLaisp1;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLaitk;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLaitk1;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLaitl;
    private CHKB_DESIGN.ButtonGradientRound btn_taiLaitv;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang11;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang12;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang13;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang14;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang15;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang18;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang2;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang20;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang22;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang23;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang27;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang28;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang3;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang4;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang5;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang6;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang7;
    private CHKB_DESIGN.ButtonGradientRound btn_taoDonHang8;
    private CHKB_DESIGN.ButtonGradientRound btn_thanhVien;
    private CHKB_DESIGN.ButtonGradientRound btn_theLoai;
    private CHKB_DESIGN.ButtonGradientRound btn_themVaoHoaDon;
    private CHKB_DESIGN.ButtonGradientRound btn_thongKe;
    private CHKB_DESIGN.ButtonGradientRound btn_timHD;
    private CHKB_DESIGN.ButtonGradientRound btn_xoaKhoiHoaDon;
    private CHKB_DESIGN.Card cardDoanhThuHomNay;
    private CHKB_DESIGN.Card cardDoanhThuTrongThang;
    private CHKB_DESIGN.Card cardDonHangTrongNgay;
    private CHKB_DESIGN.Card cardTongTien;
    private CHKB_DESIGN.ComboBoxSuggestion cbb_khachHang;
    private CHKB_DESIGN.ComboBoxSuggestion ccb_timHoaDon;
    private CHKB_DESIGN.PanelRoundGradient hienThi;
    private CHKB_DESIGN.PanelRoundGradient hienThi1;
    private CHKB_DESIGN.ImageAvatar hinhNhanVien;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPaneHD;
    private javax.swing.JScrollPane jScrollPaneSachHD;
    private javax.swing.JScrollPane jScrollPanekm;
    private javax.swing.JScrollPane jScrollPanelHH1;
    private javax.swing.JScrollPane jScrollPanelTCHD1;
    private javax.swing.JScrollPane jScrollPanenv;
    private javax.swing.JScrollPane jScrollPanenxb;
    private javax.swing.JScrollPane jScrollPanetk;
    private javax.swing.JScrollPane jScrollPanetl;
    private javax.swing.JScrollPane jScrollPanetv;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient1;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient10;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient11;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient12;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient13;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient14;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient15;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient16;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient17;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient18;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient19;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient2;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient20;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient3;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient4;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient5;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient6;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient7;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient8;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient9;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom10;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom11;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom13;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom15;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom3;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom4;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom5;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom6;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom7;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom8;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom9;
    private CHKB_DESIGN.MaterialTabbed tabbed_main;
    private javax.swing.JTable tbl_info;
    private javax.swing.JTable tbl_infoHoaDon;
    private javax.swing.JTable tbl_infoSach;
    private javax.swing.JTable tbl_infokm;
    private javax.swing.JTable tbl_infonv;
    private javax.swing.JTable tbl_infonxb;
    private javax.swing.JTable tbl_infotk;
    private javax.swing.JTable tbl_infotl;
    private javax.swing.JTable tbl_infotv;
    private javax.swing.JTable tbl_shh;
    private javax.swing.JTable tbl_tcHD;
    private CHKB_DESIGN.TextField textField2;
    private CHKB_DESIGN.TextField textField3;
    private CHKB_DESIGN.TextField textField4;
    private CHKB_DESIGN.TextField textField5;
    private CHKB_DESIGN.TextField textField6;
    private CHKB_DESIGN.TextField textField7;
    private javax.swing.JLabel txt_chucVu;
    private CHKB_DESIGN.TextField txt_giam;
    private CHKB_DESIGN.TextField txt_timSP;
    private CHKB_DESIGN.TextField txt_timSach;
    private CHKB_DESIGN.TextField txt_tongTien;
    private javax.swing.JLabel txt_userName;
    private javax.swing.JLabel txt_userName1;
    private javax.swing.JLabel txt_userName2;
    // End of variables declaration//GEN-END:variables
}
