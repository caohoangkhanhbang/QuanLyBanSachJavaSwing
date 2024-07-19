-- Đồ án Công nghệ Java
use DB_BanSach

select * from NhanVien
select * from ThanhVien

create procedure getInfoUser @tenDangNhap nvarchar(250), @matKhau nvarchar(250)
as
	select * from NhanVien where TenDangNhap = @tenDangNhap and MatKhau = @matKhau
go

exec getInfoUser N'Cao hoàng khánh băng', 'chkb'

-- lấy bảng sách
create procedure getAllSach
as
	select * from Sach
go

execute getAllSach
-- lấy tên sách dễ hiểu
create procedure getAllSachName
as
	select MaSach, TenSach, GiaBan, SoLuong, Tap, s.Hinh, ViTri, case when s.TrangThai = 1 then N'Có bán' else N'Không còn' end as N'Trạng thái', TacGia, s.MaKhuyenMai, tl.TenTheLoai, nxb.TenNhaXuatBan 
	from Sach s, TheLoai tl, NhaXuatBan nxb where s.MaTheLoai = tl.MaTheLoai and s.MaNhaXuatBan = nxb.MaNhaXuatBan and SoLuong > 0
go

exec getAllSachName


	select MaSach, TenSach, GiaBan, SoLuong, Tap, s.Hinh, ViTri, case when s.TrangThai = 1 then N'Có bán' else N'Không còn' end as N'Trạng thái', TacGia, case when s.MaKhuyenMai = km.MaKhuyenMai then km.TenChuongTrinh else null end,s.MaKhuyenMai, tl.TenTheLoai, nxb.TenNhaXuatBan 
	from Sach s, TheLoai tl, NhaXuatBan nxb, KhuyenMai km where s.MaTheLoai = tl.MaTheLoai and s.MaNhaXuatBan = nxb.MaNhaXuatBan

-- lấy nhà xuất bản
create procedure getAllNhaXB
as
	select * from NhaXuatBan
go

exec getAllNhaXB

-- lấy tất cả khuyến mãi

create proc getAllKhuyenMai
as
	select * from KhuyenMai

exec getAllKhuyenMai

-- lấy tất cả thể loại
create proc getAllTheLoai
as
	select * from TheLoai
go

-- --------------------- Thủ tục Thêm xóa sửa ---------------------
-- thêm sách
insert into Sach values(N'Con đường chuyển hóa', '125000', 1000, '1', NULL, NULL, 1, N'Thích Nhất Hạnh', Null, 1, 1)

create proc insertSach @tenSach nvarchar(550), @gia nvarchar(500), @soluong int, @tap nvarchar(50), @Hinh nvarchar(550), @viTri nvarchar(100), @trangThai int, @tacGia nvarchar(550), @km int, @tl int, @nxb int
as
	insert into Sach values(@tenSach, @gia, @soluong, @tap, @Hinh, @viTri, @trangThai, @tacGia, @km, @tl, @nxb)


exec insertSach 'Cao Hoàng', '1', 100, '1', '1', '1', 1, N'Băng', null, 1,1

-- cập nhật sách
update Sach set TenSach = N'Xóa', GiaBan = '1', SoLuong = 1, Tap = N'1', Hinh = N'abc', ViTri = N'1', TrangThai = 1, TacGia = N'b', MaKhuyenMai = null, MaTheLoai = 1, MaNhaXuatBan = 1 where MaSach = 1

create proc updateSach @tenSach nvarchar(550), @gia nvarchar(500), @soluong int, @tap nvarchar(50), @Hinh nvarchar(550), @viTri nvarchar(100), @trangThai int, @tacGia nvarchar(550), @km int, @tl int, @nxb int, @dieuKien int
as
	update Sach set TenSach = @tenSach, GiaBan = @gia, SoLuong = @soluong, Tap = @tap, Hinh = @Hinh, ViTri = @viTri, TrangThai = @trangThai, TacGia = @tacGia, MaKhuyenMai = @km, MaTheLoai = @tl, MaNhaXuatBan = @nxb where MaSach = @dieuKien

exec updateSach N'xoa dòng', '200', 20, '12', null, null, 0, N'Băng', null, 1, 1, 1 

-- xóa sách
create proc deleteSach @maSach int
as
	delete from Sach where MaSach = @maSach

exec deleteSach 24
----------------------------------------////////////////////
-- Thêm nhân viên
-- Set date format to day/month/year.  
SET DATEFORMAT dmy;
select * from NhanVien
-- năm tháng ngày
insert into NhanVien values(N'ten', '0987', '@gmail', 'cc08978', '2024/12/16', N'Nam', N'vai trò', N'tv ap', '123', N'null', '1', N'nhân viên');

create proc insertNhanVien @ten nvarchar(550), @sdt nvarchar(11), @email nvarchar(550), @cccd nvarchar(20), @nams date, @gt nvarchar(3), @quyen nvarchar(200), @dc nvarchar(550), @mk nvarchar(550), @hinh nvarchar(550), @tt nvarchar(2), @tenDN nvarchar(550)
as
	insert into NhanVien values(@ten, @sdt, @email, @cccd, @nams, @gt, @quyen, @dc, @mk, @hinh, @tt, @tenDN);

exec insertNhanVien N'Nguyễn B', '090797756', N'a@gmail.com', '0987987678', '1/12/1234', N'Nữ', N'nhân viên', N'Vĩnh Long', N'123', null, '', 'Nguyễn A'

-- Xóa nhân viên
delete from NhanVien where MaNhanVien = 4

create proc DeleteNhanVien @maNhanVien int
as
	delete from NhanVien where MaNhanVien = @maNhanVien

exec DeleteNhanVien 3
-- cập nhật nhân viên
update NhanVien set HoTen = N'Cao Hoàng', SoDienThoai = '123', Email = N'@gmail', CCCD = '123', NamSinh = '2087', GioTinh = N'nữ', VaiTro = N'quản lý', DiaChi = N'vl', MatKhau = N'123', Hinh = N'123', TrangThai = '1', TenDangNhap = N'nhân' where MaNhanVien = 5  --  @ten, @sdt, @email, @cccd, @nams, @gt, @quyen, @dc, @mk, @hinh, @tt, @tenDN);

create proc updateNhanVien @ten nvarchar(550), @sdt nvarchar(11), @email nvarchar(550), @cccd nvarchar(20), @nams date, @gt nvarchar(3), @quyen nvarchar(200), @dc nvarchar(550), @mk nvarchar(550), @hinh nvarchar(550), @tt nvarchar(2), @tenDN nvarchar(550), @DieuKien int
as
	update NhanVien set HoTen = @ten, SoDienThoai = @sdt, Email = @email, CCCD = @cccd, NamSinh = @nams, GioTinh = @gt, VaiTro = @quyen, DiaChi = @dc, MatKhau = @mk, Hinh = @hinh, TrangThai = @tt, TenDangNhap = @tenDN where MaNhanVien = @DieuKien

exec updateNhanVien N'Nguyễn A 2', '090797756', N'a@gmail.com', '0987987678', '2003/12/3', N'Nữ', N'nhân viên', N'Vĩnh Long', N'123', null, '', N'Nguyễn A', 5



-- HOÁ ĐƠN ==============================
select * from HoaDon
select * from KhuyenMai
select * from ChiTietHoaDonSach
select top 1 MaHoaDon from HoaDon order by MaHoaDon desc 


set dateformat dmy insert into HoaDon values('1/6/2024', 9, 1, 1, NULL)
-- Thêm hóa đơn
create proc taoHoaDon @ngayTao date, @tongTien float, @nguoiTao int, @trangThai int, @maThanhVien int
as
	insert into HoaDon values(@ngayTao, @tongTien, @nguoiTao, @trangThai, @maThanhVien)

exec taoHoaDon '12/12/2022', 2000, 1, 1, 1

-- thêm chi tiết hóa đơn
insert into ChiTietHoaDonSach values(20,(select top 1 MaHoaDon from HoaDon order by MaHoaDon desc),'a',999,'1','0','123')

create proc themChiTietHoaDon @maSach int, @tenSach nvarchar(550), @gia float, @soLuong nvarchar(50), @giam nvarchar(50), @thanhTien nvarchar(50)
as
	insert into ChiTietHoaDonSach values(@maSach, (select top 1 MaHoaDon from HoaDon order by MaHoaDon desc), @tenSach, @gia, @soLuong, @giam, @thanhTien)
	
exec themChiTietHoaDon 2, 'xoa', 9000, '1', '0', '9000'


--Cập nhật lại số lượng khi đã bán
select * from Sach
update Sach set SoLuong = SoLuong - 1 where MaSach = 41



select * from Sach
delete from KhuyenMai
delete from Sach where MaSach in (13,14)
delete from ChiTietHoaDonSach
delete from HoaDon



-- cập nhật trạng thái nhân viên khi bị xóa
select * from NhanVien where TrangThai <> '1'
update NhanVien set TrangThai = '0' where MaNhanVien = 19
-- Đặt lại mật khẩu
update NhanVien set MatKhau = N'chkb' where TenDangNhap = N'1x' and Email = N'a@gmail.com' and TrangThai != '0'



--thêm khuyến mãi
select * from KhuyenMai
set dateformat dmy insert into KhuyenMai values(N'Mừng khai trương',N'15', '31/5/2024', '2/6/2024', '1')
-- cập nhật chương trình
set dateformat dmy update KhuyenMai set TenChuongTrinh = N'a', NgayBatDau = '1/1/2024', NgayKetThuc = '2/2/2024', TrangThai = '0' where MaKhuyenMai = 3

-- thêm thành viên
select * from ThanhVien

set dateformat dmy insert into ThanhVien (HoTen, SoDienThoai, NgaySinh, GioiTinh, Email, DiaChi) values(N'Cao Thiên','05823','1/6/2003', N'Nam', N'@gmail.com', N'VL')
-- cập nhật thành viên
update ThanhVien set HoTen = N'', SoDienThoai = '', NgaySinh = '', GioiTinh = N'', Email = '', DiaChi = N'', Diem = '', GiamGia = '', Hinh = N'' where MaThanhVien = 1

set dateformat dmy update ThanhVien set HoTen = N'', SoDienThoai = '', NgaySinh = '', GioiTinh = N'', Email = '', DiaChi = N'', Hinh = N'' where MaThanhVien = 5

-- thêm thể loại
select * from TheLoai

insert into TheLoai values(N'Vi diệu pháp')
-- cập nhật thể loại
update TheLoai set TenTheLoai = N'' where MaTheLoai = 1

-- thêm mới nhà xuất bản
select * from NhaXuatBan
insert into NhaXuatBan(TenNhaXuatBan) values(N'Khánh Băng')
-- cập nhật nhà xuất bản
update NhaXuatBan set TenNhaXuatBan = N'', Hinh = N'' where MaNhaXuatBan = 1


-- Thống kê
select sum(TongTien) as  N'Tổng tiền' from HoaDon

-- lấy ra tất cả hóa đơn
select * from HoaDon hd, ChiTietHoaDonSach cthd where hd.MaHoaDon = cthd.MaHoaDon order by hd.MaHoaDon asc
-- xem chi tiết 1 hóa đơn
select * from HoaDon hd, ChiTietHoaDonSach cthd where hd.MaHoaDon = cthd.MaHoaDon and hd.MaHoaDon = 18 order by hd.MaHoaDon asc
-- lấy ra sách gần hết
select * from Sach where SoLuong < 1000
--tìm kiếm sách
select * from sach where TenSach like N'%kinhz%' or MaSach like N'%1%'

select * from HoaDon
-- lấy ra tổng tiền hóa đơn trong ngày
set dateformat dmy select sum(TongTien) from HoaDon where NgayTao like '%2026-05-05%'
set dateformat dmy select sum(TongTien) from HoaDon where NgayTao = '6/1/2024'
-- lấy ra tổng tiền hóa đơn trong tháng
set dateformat dmy select sum(TongTien) from HoaDon where month(NgayTao) = '6' and year(NgayTao) = '2024' 
-- Lấy số hóa đơn trong ngày
set dateformat dmy select count(*) from HoaDon where NgayTao = '1/6/2024'

-- cập nhật điểm thành viên
select * from ThanhVien
update ThanhVien set Diem += 25000/100 where MaThanhVien = 1

-- thêm mới thành viên
set dateformat dmy insert into ThanhVien (HoTen, SoDienThoai, NgaySinh, GioiTinh, Email, DiaChi, Diem) values(N'" + hoTen + "','" + sdt + "','" + ngaySinh + "', N'" + gioiTinh + "', N'" + email + "', N'" + diaChi + "', 0)

-- lấy ra điểm của thành viên (CHƯA LÀM)
select * from ThanhVien
select Diem from ThanhVien where MaThanhVien = 9
update ThanhVien set GiamGia = '0' where MaThanhVien = 9

select distinct MaHoaDon from HoaDon

