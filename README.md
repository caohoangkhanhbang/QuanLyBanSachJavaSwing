<h2 align="center">🛠 Chương trình quản lý cửa hàng bán sách 🛠</h2>
<h6 align="center">⚔  Công nghệ sử dụng: Java, SqlServer Database ⚔ </h6>

<h3 align="left">I. Mục tiêu và lý do tại sao lại chọn đề tài này</h3>
<h4  align="left"> 🖋 Kinh doanh sách, văn phòng phẩm có khả năng đem lại nguồn lợi nhuận khá ổn định,
    không bao giờ lỗi
    thời. Nhưng không phải ai kinh doanh mặt hàng này cũng thành công, do thiếu kinh nghiệm quản lý.
    Khi quản lý cửa hàng bán sách, văn phòng phẩm, bạn có thể gặp phải một số khó khăn như sau:
    Số lượng hàng lớn: Đặc trưng của lĩnh vực này là số lượng hàng hóa lớn, độ đa dạng cao rất khó quản lý. Ngoài ra,
    một số mặt hàng có kích thước và giá trị rất nhỏ, nếu không biết cách kiểm soát sẽ rất dễ thất thoát.
    Phân loại hàng hóa: Bạn cần chú ý cách phân loại các đầu sách để tư vấn dễ dàng quản lý và tư vấn khách hàng. Một
    cuốn sách có thể thuộc nhiều thể loại khác nhau, dễ gây ra sự nhầm lẫn khi nhân viên kiểm tra và sắp xếp hàng hóa.
    Marketing nhà sách: Nhiều nhà sách nhỏ chưa biết cách Marketing cửa hàng của mình, do thiếu các dữ liệu liên quan
    đến khách hàng. Ví dụ, để lên kế hoạch nhập kho, bạn cần biết nhóm khách hàng của mình ở độ tuổi bao nhiêu, thích
    những thể loại sách nào,….
</h4>

<h3 align="left">II. Phạm vi của đồ án</h3>
<h4 align="left">🖋 Quản lý sản phẩm: chương trình này sẽ giúp bạn lưu trữ mọi thông tin về hàng hóa và phân chia theo danh
    mục hợp lý. Ngoài ra chương trình này còn giúp bạn có thể quản lý nhân viên, quản lý tài khoản nhân viên, quản lý
    hóa đơn, tạo mới hóa đơn, quản lý nhà xuất bản, quản lý thể loại.
    Theo dõi doanh số bán hàng: Tất cả thông tin hóa đơn sẽ được ghi nhận trên hệ thống, từ đó có thể tổng kết doanh thu
    theo tuần, ngày, hoặc tháng.
    Quản lý khách hàng, Marketing: chương trình sẽ giúp bạn có thể lưu trữ mọi thông tin liên quan đến khách hàng như họ
    tên, số điện thoại, Email, lịch sử mua hàng,… Từ đó, cửa hàng có thể thực hiện các chương trình chăm sóc, Marketing
    như tặng Voucher, giảm giá, tích điểm, …
    Phân quyền truy cập nhân viên.
</h4>

<h3 align="left">III. Giao diện chức năng của phần mềm quản lý bán sách</h3>
<h4 align="left">1. Giao diện đăng nhập</h4>

<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/ManHinhDangNhap.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvTWFuSGluaERhbmdOaGFwLnBuZyIsImlhdCI6MTcyNDc2OTkyMCwiZXhwIjozMzI2MDc2OTkyMH0.8HRBCuV8LWG02Ya2GEjTINFsU796bdJb_rxSFaI0eJw&t=2024-08-27T14%3A45%3A20.165Z"
        alt="đăng nhập"></h1>
<h4 align="left">🖋 Form đăng nhập giúp xác thực danh tính trước khi thao tác với phần mềm. Form này có hai trường với tên
    đăng nhập hoặc mật khẩu, một check box giúp hiển thị mật khẩu và một nút đăng nhập giúp điều hướng đến form giao
    diện chính khi xác thực thành công.
    Ngoài ra khi quên mật khẩu nhân viên có thể chọn chức năng Quên mật khẩu để đặt lại mật khẩu.
</h4>

<h4 align="left">2. Giao diện trang chủ</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/TrangChuChuongTrinhHeThongBanSach.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvVHJhbmdDaHVDaHVvbmdUcmluaEhlVGhvbmdCYW5TYWNoLnBuZyIsImlhdCI6MTcyNDc2ODk1MiwiZXhwIjozMzI2MDc2ODk1Mn0.junriGp8hTs42fOpO5wZSdFaua3b1f6XQ61ptkTTIAs&t=2024-08-27T14%3A29%3A11.972Z"
        alt="Giao diện trang chủ"></h1>
<h4 align="left">🖋 Giao diện trang chủ chứa đầy đủ các nút điều hướng đến các chức năng quản lý chương trình như: tạo đơn
    hàng, sản phẩm, khuyến mãi, … Tại giao diện này nhân viên có thể lập hóa đơn và bán hàng một cách tiện lợi và dễ
    dàng.
    Ngoài ra còn có các nút hỗ trợ lập hóa đơn như thêm để thêm một sản phẩm mới vào hóa đơn. Nút xóa giúp xóa một sản
    phẩm được chọn ra khỏi hóa đơn hiện thời, nút hủy hóa đơn giúp hủy toàn bộ hóa đơn hiện tại, nút giảm giúp áp giá
    trị giảm với phần trăm giảm cho một sản phẩm hay nhiều sản phẩm trên hóa đơn, cuối cùng là nút lưu hóa đơn giúp lưu
    vào cơ sở dữ liệu để tiện cho việc quản lý và trích xuất sau này.
    Nút tải lại cho phép làm mới lại tải lại các sản phẩm khi có cập nhật từ cơ sở dữ liệu.
</h4>
<h4 align="left"> Tại form này cho phép nhân viên thấy đầy đủ các chương trình khuyến mãi cũng như có thể tạo mới hay cập
    nhật một chương trình khuyến mãi hiện có.</h4>



<h4 align="left">3. Giao diện trang sản phẩm</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/GiaoDienTrangSanPhamHeThongBanSach.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvR2lhb0RpZW5UcmFuZ1NhblBoYW1IZVRob25nQmFuU2FjaC5wbmciLCJpYXQiOjE3MjQ3NjkwNTgsImV4cCI6MzMyNjA3NjkwNTh9.SFxz4pHsGq2KV_ZuWmt_DTT4lWsjL-pMfrCgtK0SwMg&t=2024-08-27T14%3A30%3A58.059Z"
        alt="3. Giao diện trang sản phẩm"></h1>
<h4 align="left">🖋 Tại giao diện sản phẩm cho phép nhân viên xem toàn bộ sản phẩm hiện có trong cửa hàng đã được lưu vào
    cơ sở dữ liệu. Bên cạnh đó form này còn cho phép nhân viên thêm, cập nhật, xóa và xem chi tiết một sản phẩm sách
    trong cửa hàng.</h4>

<h4 align="left">4. Giao diện trang chi tiết sản phẩm</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/ChiTietSanPham.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvQ2hpVGlldFNhblBoYW0ucG5nIiwiaWF0IjoxNzI0NzcxMzQ1LCJleHAiOjMxNzA4NDc3MTM0NX0.a5r97kOg_BqcsAAAGctp5Jh50PYkoBRf9AF5CWwE39Q&t=2024-08-27T15%3A09%3A04.958Z"
        alt="Giao diện trang chi tiết sản phẩm"></h1>
<h4 align="left">🖋 Giao diện form này cho phép nhân viên xem thông tin chi tiết và đầy đủ nhất của sản phẩm.</h4>

<h4 align="left">5. Giao diện trang thêm sản phẩm</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/ThemSanPham.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvVGhlbVNhblBoYW0ucG5nIiwiaWF0IjoxNzI0NzcxNTc1LCJleHAiOjMxNzA4NDc3MTU3NX0.sGg1uzHi6TYgUxwyotm6It2SavU9f49j2ta_82CG0F4&t=2024-08-27T15%3A12%3A54.849Z"
        alt="3. Giao diện trang thêm sản phẩm"></h1>
<h4 align="left">🖋 Khi chọn chức năng thêm sản phẩm thì form thêm sản phẩm hiện ra. Form này cho phép thêm mới một sản
    phẩm với các trường cần thiết như hình môt tả trên và cho phép chọn một hình môt tả cho sản phẩm.</h4>


<h4 align="left">6. Giao diện trang khuyến mãi</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/GiaoDienTrangChuongTrinhKhuyenMai.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvR2lhb0RpZW5UcmFuZ0NodW9uZ1RyaW5oS2h1eWVuTWFpLnBuZyIsImlhdCI6MTcyNDc2OTA3OCwiZXhwIjozMzI2MDc2OTA3OH0.PnnD2DXJiOwKFiuMA_aavDrNY6Cc41FUcN5krq_JkmE&t=2024-08-27T14%3A31%3A18.194Z"
        alt="4. Giao diện trang khuyến mãi"></h1>
<h4 align="left">🖋 Tại form này cho phép nhân viên thấy đầy đủ các chương trình khuyến mãi cũng như có thể tạo mới hay cập
    nhật một chương trình khuyến mãi hiện có. Tại giao diện này cho phép nhân viên tạo mới một chương trình khuyến mãi.
</h4>


<h4 align="left">7. Giao diện trang nhân viên</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/GiaoDienQuanLyNhanVien.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvR2lhb0RpZW5RdWFuTHlOaGFuVmllbi5wbmciLCJpYXQiOjE3MjQ3NjkxMzQsImV4cCI6MzMyNjA3NjkxMzR9.HT8HLnXVvXRxJJcWrZgW_acKrNgyJhVioxhhjd35gGA&t=2024-08-27T14%3A32%3A14.651Z"
        alt="5. Giao diện trang nhân viên"></h1>
<h4 align="left">🖋 Tại giao diện này cho phép nhân viên thấy toàn bộ các tài khoản hiện có trong hệ thống. Bên cạnh đó
    form này cong cho phép nhân viên có thể thêm mới, cập nhật, xóa hay xem cho tiết nhân viên.</h4>

<h4 align="left">8. Giao diện trang thêm nhân viên</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/ThemNhanVien.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvVGhlbU5oYW5WaWVuLnBuZyIsImlhdCI6MTcyNDc3MTY0NCwiZXhwIjozMTcwODQ3NzE2NDR9.gEj8OCv39Umz_ixvPYVr2ahjwiL2Sfs1dPKn2j6Bv5Y&t=2024-08-27T15%3A14%3A03.964Z"
        alt="5. Giao diện trang thêm nhân viên"></h1>
<h4 align="left">🖋 Tại giao diện này cho phép thêm mới một nhân viên.</h4>


<h4 align="left">9. Giao diện trang thành viên</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/GiaoDienTrangThanhVien.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvR2lhb0RpZW5UcmFuZ1RoYW5oVmllbi5wbmciLCJpYXQiOjE3MjQ3NjkxNTQsImV4cCI6MzMyNjA3NjkxNTR9.qDUP7T6BT3zgDadj-dmz8IEmOwAsOzqabyvAmggKERE&t=2024-08-27T14%3A32%3A34.212Z"
        alt="6. Giao diện trang thành viên"></h1>
<h4 align="left">🖋 Tại giao diện này cho phép nhân viên quản lý tất cả các khách hàng thân thiết đã có trong hệ thống, ngoài ra còn cho phép nhân viên tạo mới một thành viên hay cập nhật một thành viên hiện có.</h4>  

<h4 align="left">10. Giao diện trang thống kê</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/GiaoDienTrangThongKeHeThongBanSach.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvR2lhb0RpZW5UcmFuZ1Rob25nS2VIZVRob25nQmFuU2FjaC5wbmciLCJpYXQiOjE3MjQ3NjkxNjYsImV4cCI6MzMyNjA3NjkxNjZ9.RTdlBInwKKlVSg5_UQeGfFRUe_vcEso5VXVp-fl80m0&t=2024-08-27T14%3A32%3A45.678Z"
        alt="7. Giao diện trang thống kê"></h1>
<h4 align="left">🖋 Tại giao diện thống kê cho phép chủ cửa hàng hoặc quản lý và nhân viên có thể xem tổng quan tiến độ
    kinh doanh của của hàng. Thống kê bao gồm hiển thị tất cả hóa đơn đã lập, các sản phẩm gần hết hàng. Ngoài ra còn
    cho phép xem số hóa đơn đã được lập trong ngày, doanh thu trong ngày, doanh thu trong một tháng vừa qua, và tổng
    doanh thu đã thu được khi lập hóa đơn.</h4>


<h4 align="left">11. Giao diện trang tài khoản</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/GiaoDienTrangQuanLyTaiKhoan.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvR2lhb0RpZW5UcmFuZ1F1YW5MeVRhaUtob2FuLnBuZyIsImlhdCI6MTcyNDc2OTIyNywiZXhwIjozMzI2MDc2OTIyN30.5YZRz8EXfqsO5qN46K2pDp1oonKqTNkmt2iMszWwwaA&t=2024-08-27T14%3A33%3A47.527Z"
        alt="8. Giao diện trang tài khoản"></h1>
<h4 align="left">🖋 Tại giao diện này cho phép nhân viên thấy toàn bộ các tài khoản hiện có trong hệ thống. Bên cạnh đó
    form này cong cho phép nhân viên có thể thêm mới, cập nhật, xóa hay xem cho tiết nhân viên.</h4>

<h4 align="left">12. Giao diện trang phân quyền tài khoản</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/PhanQuyenTaiKhoan.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvUGhhblF1eWVuVGFpS2hvYW4ucG5nIiwiaWF0IjoxNzI0NzcxNzQzLCJleHAiOjMxNzA4NDc3MTc0M30.3WsBrHr1psGpr0mPLqCb__6W9HqCOLSCC39Pan6GAaU&t=2024-08-27T15%3A15%3A43.394Z"
        alt="8. Giao diện trang phân quyền tài khoản"></h1>
<h4 align="left">🖋 Tại giao diện này cho phép nhân viên quản lý cấp cao có thể phân lại quyền cũng như chức vụ cho nhân
    viên.</h4>


<h4 align="left">13. Giao diện quên mật khẩu</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/ChucNangQuenMatKhau.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvQ2h1Y05hbmdRdWVuTWF0S2hhdS5wbmciLCJpYXQiOjE3MjQ3NjkyNDcsImV4cCI6MzMyNjA3NjkyNDd9.Bd9x07h1Gsbd2RhvSYtJcvZq0OY6vlycPep6pAKZ_V4&t=2024-08-27T14%3A34%3A06.870Z"
        alt="9. Giao diện quên mật khẩu"></h1>
<h4 align="left">🖋 Trong lúc đăng nhập nếu nhân viên quên mật khẩu có thể chọn chức năng này giúp đặt lại mật khẩu khi đã
    quên.</h4>


<h4 align="left">14. Giao diện đặt lại mật khẩu</h4>
<h1 border-radius="10px" align="center"><img width="800px"
        src="https://mqgrsexgtwjbimsoemks.supabase.co/storage/v1/object/sign/image_JavaProjectBanSach/DatLaiMatKhau.png?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJpbWFnZV9KYXZhUHJvamVjdEJhblNhY2gvRGF0TGFpTWF0S2hhdS5wbmciLCJpYXQiOjE3MjQ3NjkyNTgsImV4cCI6MzMyNjA3NjkyNTh9.eIj50NuebA97VcIRu23_uzG5bSEeGzPO4ecufPk19TQ&t=2024-08-27T14%3A34%3A17.839Z"
        alt="9. Giao diện đặt lại mật khẩu"></h1>
<h4 align="left">🖋 Giao diện đặt lại mật khẩu khi quên cho phép nhân viên đặt lại khi đã quên mật khẩu.</h4>


<h3 align="center">VI. Kết luận</h3>
<h4 align="left">🖋 Sau khi xây dựng xong chương trình quản lý cửa hàng bán sách, chương trình được hiện thực các chức năng
    sau:</h4>
<h4 align="left">🖋 Quản lý sản phẩm: chương trình này sẽ giúp bạn lưu trữ mọi thông tin về hàng hóa và phân chia theo danh
    mục hợp lý. Ngoài ra chương trình này còn giúp bạn có thể quản lý nhân viên, quản lý tài khoản nhân viên, quản lý
    hóa đơn, tạo mới hóa đơn, quản lý nhà xuất bản, quản lý thể loại.</h4>
<h4 align="left">Theo dõi doanh số bán hàng: Tất cả thông tin hóa đơn sẽ được ghi nhận trên hệ thống, từ đó có thể tổng
    kết doanh thu theo tuần, ngày, hoặc tháng.</h4>
<h4 align="left"> 🖋 Quản lý khách hàng, Marketing: chương trình sẽ giúp bạn có thể lưu trữ mọi thông tin liên quan đến
    khách hàng như họ tên, số điện thoại, Email, lịch sử mua hàng,… Từ đó, cửa hàng có thể thực hiện các chương trình
    chăm sóc, Marketing như tặng Voucher, giảm giá, tích điểm, …</h4>
<h4 align="left">Phân quyền truy cập nhân viên.</h4>


<h3 align="center">V. Định hướng phát triển</h3>
<h4 align="left">🖋 Phần mềm sẽ cập nhật thêm các chức năng:</h4>
<h4 align="left">🖋 Theo dõi quá trình xuất nhập kho, kiểm kho cuối ca, cuối ngày hoặc theo thời gian nhất định.</h4>
<h4 align="left">
    🖋 Thanh toán thông minh, hệ thống thanh toán đa dạng, như ví điện tử MoMo, ZaloPay, SmartPay, VNPAY. Ngoài ra, kết nối
    với nhiều thiết bị khác như máy đọc mã vạch, in hóa đơn….
    Bán hàng đa kênh, tính năng đặt hàng trực tuyến, tích hợp trực tuyến và cửa hàng truyền thống, giúp chủ cửa hàng
    triển khai kinh doanh đa kênh.</h4>
<h4 align="left">🖋 Phân loại sản phẩm, phân loại nhóm sách theo ngôn ngữ, lứa tuổi, tác giả, nhà xuất bản,…. Ngoài ra, bạn
    cũng rất dễ dàng nắm bắt các thông tin thực tế như số lượng sách trong kho, những mặt hàng bán chạy, hoặc bị tồn
    nhiều.
</h4>
<h6 align="left">Ngoài ra còn các chức năng khác xoay quanh việc thêm xóa sửa dữ liệu, ...</h6>


<h6 align="center">📜 Toàn bộ ứng dụng được xây dựng bởi Cao Hoàng Khánh Băng (Project cá nhân)📜 </h6>
<h6 align="left">Cảm ơn bạn đã theo dõi!</h6>
