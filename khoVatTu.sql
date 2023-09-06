--Sử dụng cơ sở dữ liệu master
USE master;
GO

-- Tạo cơ sở dữ liệu Kho vật tư
CREATE DATABASE khoVatTu;
GO

--Sử dụng cơ sở dữ liệu kho vật tư
USE khoVatTu;
GO	
--Tạo bảng nhà cung cấp
CREATE TABLE NhaCungCap(
	MaNCC VARCHAR(15) NOT NULL PRIMARY KEY,
	TenNCC NVARCHAR(255) NOT NULL,
	DiaChi NVARCHAR(255) NOT NULL,
	SoDienThoai VARCHAR(13) NOT NULL,
	ChiTiet NVARCHAR(MAX) NULL,
	UNIQUE(SoDienThoai),
	NgayTao DATETIME NULL DEFAULT GETDATE(),
	NguoiTao NVARCHAR(100) NULL,
	TrangThaiXoa BIT DEFAULT 0,

);
GO
--Tạo bảng lưu thông tin cập nhật của nhà cung cấp
CREATE TABLE CapNhatThongTinNCC(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaNCC VARCHAR(15) NOT NULL,
	NgaySua DATETIME DEFAULT GETDATE(),
	NguoiSua NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL,
);
GO
--Tạo bảng lưu thông tin xóa của nhà cung cấp
CREATE TABLE XoaThongTinNCC(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaNCC VARCHAR(15) NOT NULL,
	NgayXoa DATETIME NULL,
	NguoiXoa NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
--Tạo bảng lưu thông tin được khôi phục của nhà cung cấp
CREATE TABLE KhoiPhucThongTinNCC(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaNCC VARCHAR(15) NOT NULL,
	NgayKhoiPhuc DATETIME NULL,
	NguoiKhoiPhuc NVARCHAR(100) NULL, 
	GhiChu NVARCHAR(MAX) NULL ,
);
GO

--Tạo bảng phân loại sản phẩm
CREATE TABLE PhanLoaiSP(
	LoaiSP INT IDENTITY PRIMARY KEY NOT NULL,
	TenLoaiSP NVARCHAR(50),
	NgayTao DATETIME NULL DEFAULT GETDATE(),
	NguoiTao NVARCHAR(100) NULL,
	TrangThaiXoa BIT DEFAULT 0,
);
GO
--Tạo bảng lưu thông tin cập nhật phân loại sản phẩm
CREATE TABLE CapNhatThongTinPhanLoaiSP(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaPhanLoaiSP VARCHAR(15) NOT NULL,
	NgaySua DATETIME DEFAULT GETDATE(),
	NguoiSua NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL,
);
GO
--Tạo bảng lưu thông tin xóa phân loại sản phẩm
CREATE TABLE XoaThongTinPhanLoaiSP(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaPhanLoaiSP VARCHAR(15) NOT NULL,
	NgayXoa DATETIME NULL,
	NguoiXoa NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
--Tạo bảng lưu thông tin được khôi phục phân loại sản phẩm
CREATE TABLE KhoiPhucThongTinPhanLoaiSP(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaPhanLoaiSP VARCHAR(15) NOT NULL,
	NgayKhoiPhuc DATETIME NULL,
	NguoiKhoiPhuc NVARCHAR(100) NULL, 
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
--Tạo bảng sản phẩm
CREATE TABLE SanPham(
	MaSP VARCHAR(15) NOT NULL PRIMARY KEY,
	MaNCC VARCHAR(15) NOT NULL,
	TenSP NVARCHAR(255) NOT NULL,
	HinhAnh NVARCHAR(255) NULL,
	LoaiSP INT NOT NULL,
	DonGiaBan DOUBLE PRECISION DEFAULT 0,
	DonViTinh INT NOT NULL,
	GhiChu NVARCHAR(max) NULL,
	CHECK (DonGiaBan>0),
	NgayTao DATETIME NULL DEFAULT GETDATE(),
	NguoiTao NVARCHAR(100) NULL,
	TrangThaiXoa BIT DEFAULT 0,

);
GO
--Tạo bảng lưu thông tin cập nhật của sản phẩm
CREATE TABLE CapNhatThongTinSP(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaSP VARCHAR(15) NOT NULL,
	NgaySua DATETIME DEFAULT GETDATE(),
	NguoiSua NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL,
);
GO
--Tạo bảng lưu thông tin xóa của sản phẩm
CREATE TABLE XoaThongTinSP(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaSP VARCHAR(15) NOT NULL,
	NgayXoa DATETIME NULL,
	NguoiXoa NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
--Tạo bảng lưu thông tin được khôi phục của sản phẩm
CREATE TABLE KhoiPhucThongTinSP(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaSP VARCHAR(15) NOT NULL,
	NgayKhoiPhuc DATETIME NULL,
	NguoiKhoiPhuc NVARCHAR(100) NULL, 
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
-- Tạo bảng vai trò cho nhân viên
CREATE TABLE VaiTro(
	MaVaiTro INT IDENTITY NOT NULL PRIMARY KEY,
	TenVaiTro NVARCHAR(20) NOT NULL

);
GO

-- Tạo bảng vai trò cho nhân viên
CREATE TABLE LoaiNhanVien(
	MaLoaiNV INT IDENTITY NOT NULL PRIMARY KEY,
	TenLoaiNV NVARCHAR(50) NOT NULL,
	NgayTao DATETIME NULL DEFAULT GETDATE(),
	NguoiTao NVARCHAR(100) NULL

);
GO

-- Tạo bảng nhân viên
CREATE TABLE NhanVien(
	MaNV VARCHAR(8) NOT NULL PRIMARY KEY,
	MatKhau NVARCHAR(255) NULL,
	HoTen NVARCHAR(100) NOT NULL,
	GioiTinh BIT NOT NULL,
	Hinh NVARCHAR(50) NULL,
	SoDienThoai VARCHAR(13) NOT NULL,
	NgaySinh DATE DEFAULT '19600101',
	DiaChi NVARCHAR(255) NOT NULL,
	Email VARCHAR(50) NOT NULL,
	MaLoaiNV INT NOT NULL,
	MaVaiTro INT NOT NULL,
	UNIQUE(SoDienThoai, Email),
	NgayTao DATETIME NULL DEFAULT GETDATE(),
	NguoiTao NVARCHAR(100) NULL,
	TrangThaiXoa BIT DEFAULT 0,
	TaiKhoan VARCHAR(255) NULL,

);
GO
--Tạo bảng lưu thông tin cập nhật của Nhân viên
CREATE TABLE CapNhatThongTinNV(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaNV VARCHAR(8) NOT NULL,
	NgaySua DATETIME DEFAULT GETDATE(),
	NguoiSua NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL,
);
GO
--Tạo bảng lưu thông tin xóa của Nhân viên
CREATE TABLE XoaThongTinNV(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaNV VARCHAR(8) NOT NULL,
	NgayXoa DATETIME NULL,
	NguoiXoa NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
--Tạo bảng lưu thông tin được khôi phục của Nhân viên
CREATE TABLE KhoiPhucThongTinNV(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaNV VARCHAR(8) NOT NULL,
	NgayKhoiPhuc DATETIME NULL,
	NguoiKhoiPhuc NVARCHAR(100) NULL, 
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
-- Tạo bảng Kho hàng
CREATE TABLE KhoHang(
	MaKhoHang INT IDENTITY PRIMARY KEY NOT NULL,
	TenKhoHang NVARCHAR(50) NOT NULL
);
GO

-- Tạo bảng Kệ hàng sản phẩm
CREATE TABLE KhoHangSP(
	MaKHSP INT IDENTITY NOT NULL PRIMARY KEY,
	MaKho INT NOT NULL,
	MaSP VARCHAR(15) NOT NULL,
	SoLuongSPTrongKho INT NOT NULL,
	DonGiaNhap DOUBLE PRECISION NULL,
	NgaySanXuat DATE NULL,
	HanSuDung DATE NULL,
	TrangThaiXoa BIT DEFAULT 0,
);
GO
-- Tạo bảng Đơn nhập hàng
CREATE TABLE DonNhapHang(
	MaDonNhap VARCHAR(20) NOT NULL PRIMARY KEY,
	MaNV VARCHAR(8) NOT NULL,
	MaKhoHang INT NOT NULL,
	TongTienNhap DOUBLE PRECISION NOT NULL DEFAULT 0,
	TrangThaiThanhToan INT NOT NULL,
	SoTienDaThanhToan DOUBLE PRECISION NOT NULL,
	GhiChu NVARCHAR(MAX),
	CHECK(TongTienNhap>=0 AND SoTienDaThanhToan >=0),
	NgayTao DATETIME NULL DEFAULT GETDATE(),
	NguoiTao NVARCHAR(100) NULL,
	TrangThaiXoa BIT DEFAULT 0,

);
GO
--Tạo bảng lưu thông tin cập nhật của Hóa Đơn Nhập
CREATE TABLE CapNhatThongTinDHN(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaDonNhap VARCHAR(20) NOT NULL,
	NgaySua DATETIME DEFAULT GETDATE(),
	NguoiSua NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL,
);
GO
--Tạo bảng lưu thông tin xóa của Hóa Đơn Nhập
CREATE TABLE XoaThongTinDHN(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaDonNhap VARCHAR(20) NOT NULL,
	NgayXoa DATETIME NULL,
	NguoiXoa NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
--Tạo bảng lưu thông tin được khôi phục của Hóa Đơn Nhập
CREATE TABLE KhoiPhucThongTinDHN(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaDonNhap VARCHAR(20) NOT NULL,
	NgayKhoiPhuc DATETIME NULL,
	NguoiKhoiPhuc NVARCHAR(100) NULL, 
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
-- Tạo bảng Trạng thái thanh toán
CREATE TABLE TrangThaiThanhToan(
	MaTrangThai INT IDENTITY PRIMARY KEY NOT NULL,
	TenTrangThai NVARCHAR(50) NOT NULL 
);
GO

--Tạo bảng Đơn vị tính cho sản phẩm
CREATE TABLE DonViTinh(
	MaDVT int IDENTITY NOT NULL PRIMARY KEY,
	TenDonViTinh NVARCHAR(20) NOT NULL,

);
GO

-- Tạo bảng Chi Tiết Nhập
CREATE TABLE ChiTietNhap(
	MaCTNhap INT NOT NULL,
	MaDonNhap VARCHAR(20) NOT NULL,
	MaSP VARCHAR(15) NOT NULL,
	SoLuongTrongThung int NOT NULL,
	SoLuongThung INT NOT NULL,
	DonGiaNhap DOUBLE PRECISION NOT NULL,
	SoLuong INT NOT NULL,
	ThanhTien DOUBLE PRECISION NOT NULL,
	NgaySanXuat DATE NOT NULL,
	HanSuDung DATE NOT NULL,
	ChiTiet NVARCHAR(MAX),
	PRIMARY KEY(MaCTNhap,MaDonNhap)
);
GO

-- Tạo bảng Đơn xuất hàng
CREATE TABLE DonXuatHang(
	MaDonXuat VARCHAR(20) PRIMARY KEY,
	MaNV VARCHAR(8) NOT NULL,
	MaKhoHang INT NOT NULL,
	TongTienXuat DOUBLE PRECISION NOT NULL DEFAULT 0,
	TrangThaiDonXuat INT NOT NULL,
	GhiChu NVARCHAR(MAX) NULL,
	CHECK(TongTienXuat>=0),
	NgayTao DATETIME NULL DEFAULT GETDATE(),
	NguoiTao NVARCHAR(100) NULL,
	TrangThaiXoa BIT DEFAULT 0,

);
GO
--Tạo bảng lưu thông tin cập nhật của Hóa Đơn Xuất
CREATE TABLE CapNhatThongTinDHX(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaDonXuat VARCHAR(20) NOT NULL,
	NgaySua DATETIME DEFAULT GETDATE(),
	NguoiSua NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL,
);
GO
--Tạo bảng lưu thông tin xóa của Hóa Đơn Xuất
CREATE TABLE XoaThongTinDHX(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaDonXuat VARCHAR(20) NOT NULL,
	NgayXoa DATETIME NULL,
	NguoiXoa NVARCHAR(100) NULL,
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
--Tạo bảng lưu thông tin được khôi phục của Hóa Đơn Xuất
CREATE TABLE KhoiPhucThongTinDHX(
	ID INT IDENTITY NOT NULL PRIMARY KEY,
	MaDonXuat VARCHAR(20) NOT NULL,
	NgayKhoiPhuc DATETIME NULL,
	NguoiKhoiPhuc NVARCHAR(100) NULL, 
	GhiChu NVARCHAR(MAX) NULL ,
);
GO
-- Tạo bảng Trạng thái hóa đơn xuất
CREATE TABLE TrangThaiHoaDonXuat(
	MaTrangThaiHDX INT IDENTITY PRIMARY KEY NOT NULL,
	TenTrangThai NVARCHAR(50) NOT NULL 

);
GO

-- Tạo bảng Chi tiết xuất
CREATE TABLE ChiTietXuat(
	MaCTXuat INT NOT NULL,
	MaDonXuat VARCHAR(20) NOT NULL,
	MaSP VARCHAR(15) NOT NULL,
	GiaNiemYet DOUBLE PRECISION NOT NULL,
	SoLuong INT NOT NULL,
	ThanhTien DOUBLE PRECISION NOT NULL,
	ChiTiet NVARCHAR(MAX) NULL,
	CHECK(SoLuong>=0 AND GiaNiemYet>=0),
	PRIMARY KEY(MaCTXuat, MaDonXuat)
);
GO


--Tạo khóa ngoại
---Tạo khóa ngoại của bảng Sản phẩm
ALTER TABLE dbo.SanPham
ADD CONSTRAINT fk_sp_ncc FOREIGN KEY (MaNCC) REFERENCES dbo.NhaCungCap(MaNCC),
CONSTRAINT fk_sp_LoaiSP FOREIGN KEY (LoaiSP) REFERENCES dbo.PhanLoaiSP(LoaiSP),
CONSTRAINT fk_sp_dvt FOREIGN KEY (DonViTinh) REFERENCES dbo.DonViTinh(MaDVT);
GO

---Tạo khóa ngoại của bảng Kho hàng - Sản phẩm
ALTER TABLE dbo.KhoHangSP
ADD CONSTRAINT fk_khsp_kh FOREIGN KEY (MaKho) REFERENCES dbo.KhoHang(MaKhoHang),
CONSTRAINT fk_khsp_sp FOREIGN KEY (MaSP) REFERENCES dbo.SanPham(MaSP);
GO

---Tạo khóa ngoại của bảng Chi Tiết Nhập
ALTER TABLE dbo.ChiTietNhap
ADD CONSTRAINT fk_ctn_sp FOREIGN KEY (MaSP) REFERENCES dbo.SanPham(MaSP),
CONSTRAINT fk_ctn_dnh FOREIGN KEY (MaDonNhap) REFERENCES dbo.DonNhapHang(MaDonNhap);
GO

---Tạo khóa ngoại của bảng Đơn Nhập Hàng
ALTER TABLE dbo.DonNhapHang
ADD CONSTRAINT fk_dnh_khoHang FOREIGN KEY (MaKhoHang) REFERENCES dbo.KhoHang(MaKhoHang),
CONSTRAINT fk_dnh_nv FOREIGN KEY (MaNV) REFERENCES dbo.NhanVien(MaNV),
CONSTRAINT fk_dhn_tttt FOREIGN KEY (TrangThaiThanhToan) REFERENCES dbo.TrangThaiThanhToan(MaTrangThai);
GO

---Tạo khóa ngoại của bảng Chi Tiết Xuất
ALTER TABLE dbo.ChiTietXuat
ADD CONSTRAINT fk_ctx_sp FOREIGN KEY (MaSP) REFERENCES dbo.SanPham(MaSP),
CONSTRAINT fk_ctx_dxh FOREIGN KEY (MaDonXuat) REFERENCES dbo.DonXuatHang(MaDonXuat);
GO

---Tạo khóa ngoại của bảng Đơn Xuất Hàng
ALTER TABLE dbo.DonXuatHang
ADD CONSTRAINT fk_dxh_khoHang FOREIGN KEY (MaKhoHang) REFERENCES dbo.KhoHang(MaKhoHang),
CONSTRAINT fk_dxh_nv FOREIGN KEY (MaNV) REFERENCES dbo.NhanVien(MaNV),
CONSTRAINT fk_dxh_ttdxh FOREIGN KEY(TrangThaiDonXuat) REFERENCES dbo.TrangThaiHoaDonXuat(MaTrangThaiHDX);
GO 

---Tạo khóa ngoại của bảng Nhân Viên
ALTER TABLE dbo.NhanVien
ADD CONSTRAINT fk_nv_loainv FOREIGN KEY (maLoaiNV) REFERENCES dbo.LoaiNhanVien(MaLoaiNV),
CONSTRAINT fk_nv_vaitro FOREIGN KEY (MaVaiTro) REFERENCES dbo.VaiTro(MaVaiTro);
GO

---Tạo khóa ngoại của bảng Cập Nhật Thông Tin Nhà Cung Cấp
ALTER TABLE CapNhatThongTinNCC
ADD CONSTRAINT fk_capnhat_ncc FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC);
GO
---Tạo khóa ngoại của bảng Xóa Thông Tin Nhà Cung Cấp
ALTER TABLE XoaThongTinNCC
ADD CONSTRAINT fk_xoa_ncc FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC);
GO
---Tạo khóa ngoại của bảng Khôi Phục Thông Tin Nhà Cung Cấp
ALTER TABLE KhoiPhucThongTinNCC
ADD CONSTRAINT fk_khoiphuc_ncc FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC);
GO

---Tạo khóa ngoại của bảng Cập Nhật Thông Tin Sản Phẩm
ALTER TABLE CapNhatThongTinSP
ADD CONSTRAINT fk_capnhat_sp FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);
GO
---Tạo khóa ngoại của bảng Xóa Thông Tin Sản Phẩm
ALTER TABLE XoaThongTinSP
ADD CONSTRAINT fk_xoa_sp FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);
GO
---Tạo khóa ngoại của bảng Khôi Phục Thông Tin Sản Phẩm
ALTER TABLE KhoiPhucThongTinSP
ADD CONSTRAINT fk_khoiphuc_sp FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);
GO

---Tạo khóa ngoại của bảng Cập Nhật Thông Tin Nhân Viên
ALTER TABLE CapNhatThongTinNV
ADD CONSTRAINT fk_capnhat_nv FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);
GO
---Tạo khóa ngoại của bảng Xóa Thông Tin Nhân Viên
ALTER TABLE XoaThongTinNV
ADD CONSTRAINT fk_xoa_nv FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);
GO
---Tạo khóa ngoại của bảng Khôi Phục Thông Tin Nhân Viên
ALTER TABLE KhoiPhucThongTinNV
ADD CONSTRAINT fk_khoiphuc_nv FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);
GO

---Tạo khóa ngoại của bảng Cập Nhật Thông Tin Hóa Đơn Nhập
ALTER TABLE CapNhatThongTinDHN
ADD CONSTRAINT fk_capnhat_dhn FOREIGN KEY (MaDonNhap) REFERENCES DonNhapHang(MaDonNhap);
GO
---Tạo khóa ngoại của bảng Xóa Thông Tin Hóa Đơn Nhập
ALTER TABLE XoaThongTinDHN
ADD CONSTRAINT fk_xoa_dhn FOREIGN KEY (MaDonNhap) REFERENCES DonNhapHang(MaDonNhap);
GO
---Tạo khóa ngoại của bảng Khôi Phục Thông Tin Hóa Đơn Nhập
ALTER TABLE KhoiPhucThongTinDHN
ADD CONSTRAINT fk_khoiphuc_dhn FOREIGN KEY (MaDonNhap) REFERENCES DonNhapHang(MaDonNhap);
GO

---Tạo khóa ngoại của bảng Cập Nhật Thông Tin Hóa Đơn Xuất
ALTER TABLE CapNhatThongTinDHX
ADD CONSTRAINT fk_capnhat_dhx FOREIGN KEY (MaDonXuat) REFERENCES DonXuatHang(MaDonXuat);
GO
---Tạo khóa ngoại của bảng Xóa Thông Tin Hóa Đơn Xuất
ALTER TABLE XoaThongTinDHX
ADD CONSTRAINT fk_xoa_dhx FOREIGN KEY (MaDonXuat) REFERENCES DonXuatHang(MaDonXuat);
GO
---Tạo khóa ngoại của bảng Khôi Phục Thông Tin Hóa Đơn Xuất
ALTER TABLE KhoiPhucThongTinDHX
ADD CONSTRAINT fk_khoiphuc_dhx FOREIGN KEY (MaDonXuat) REFERENCES DonXuatHang(MaDonXuat);
GO

--Tạo Trigger Thêm sản phẩm vào kho hàng khi sản phẩm được thêm
CREATE TRIGGER ThemSanPhamVaoKhoHang ON dbo.SanPham
    AFTER INSERT
AS
    BEGIN
        DECLARE @maSP VARCHAR(15) ,
            @loaiSP INT;
        SELECT  @maSP = Inserted.MaSP ,
                @loaiSP = Inserted.LoaiSP
        FROM    Inserted;
            
        INSERT  INTO dbo.KhoHangSP
                ( MaKho, MaSP, SoLuongSPTrongKho, DonGiaNhap )
        VALUES  ( 1, @maSP, 0, 0 );  
    END;
GO

--Tạo Trigger Xóa Sản phẩm ra khỏi kho hàng khi sản phẩm đã bị xóa
CREATE TRIGGER XoaSanPhamTrongKhoHang ON dbo.SanPham
    AFTER UPDATE
AS
    BEGIN
        DECLARE @maSP VARCHAR(15) ,
				@TrangThaiXoa bit;
        SELECT  @maSP = Inserted.MaSP ,
                @TrangThaiXoa = Inserted.TrangThaiXoa
        FROM    Inserted;
		UPDATE dbo.KhoHangSP SET TrangThaiXoa = @TrangThaiXoa WHERE MaSP = @maSP
    END;
GO

--Tạo Trigger Cập nhật giá tiền của hóa đơn nhập và số lượng trong kho của sản phẩm khi thêm chi tiết nhập
CREATE TRIGGER CapNhatTongTienHDN_SLKho ON dbo.ChiTietNhap
    AFTER INSERT
AS
    BEGIN
        DECLARE @MaSP VARCHAR(10) ,
				@SoLuongSP INT ,
				@NSX DATE ,
				@HSD DATE ,
				@Kho INT ,
				@LoaiSP INT,
				@DonGiaNhap DOUBLE PRECISION,
				@ThanhTien DOUBLE PRECISION,
				@MaDonNhap VARCHAR(20);
        BEGIN
            SELECT  @MaSP = Inserted.MaSP ,
                    @SoLuongSP = Inserted.SoLuong ,
                    @NSX = Inserted.NgaySanXuat ,
                    @HSD = Inserted.HanSuDung ,
                    @loaiSP = dbo.SanPham.LoaiSP,
					@DonGiaNhap = Inserted.DonGiaNhap,
					@ThanhTien = Inserted.ThanhTien,
					@MaDonNhap = Inserted.MaDonNhap
            FROM    KhoHangSP
                    INNER JOIN Inserted ON Inserted.MaSP = KhoHangSP.MaSP
                    INNER JOIN dbo.SanPham ON SanPham.MaSP = Inserted.MaSP;
			
			UPDATE dbo.DonNhapHang SET TongTienNhap = TongTienNhap + @ThanhTien WHERE MaDonNhap = @MaDonNhap

			IF((SELECT TOP(1) NgaySanXuat FROM dbo.KhoHangSP WHERE MaSP = @MaSP) IS NULL)
				BEGIN
				    UPDATE dbo.KhoHangSP SET SoLuongSPTrongKho = @SoLuongSP, NgaySanXuat = @NSX, HanSuDung = @HSD, DonGiaNhap = @DonGiaNhap WHERE MaSP = @MaSP
				END
			ELSE
				BEGIN
					SET @Kho = 1
				    INSERT  INTO dbo.KhoHangSP
							( MaKho, MaSP, SoLuongSPTrongKho, NgaySanXuat, HanSuDung, DonGiaNhap )
					VALUES  ( @Kho, @MaSP, @SoLuongSP, @NSX, @HSD, @DonGiaNhap );
				END		
        END
    END
GO

--Tạo Trigger Cập nhật giá tiền của hóa đơn xuất và số lượng trong kho của sản phẩm khi thêm chi tiết xuất
CREATE TRIGGER ThemChiTietXuat ON dbo.ChiTietXuat
    AFTER INSERT
AS
    BEGIN
        DECLARE @MaSP VARCHAR(10) ,
				@SoLuongXuat INT ,
				@DonGiaNhap DOUBLE PRECISION,
				@ThanhTien DOUBLE PRECISION,
				@MaDonXuat VARCHAR(20),
				@SoLuongTrongKho INT,
				@SoLuongConLaiCuaSP INT,
				@LuongSP_NSX INT,
				@BienDem INT = 1;
        BEGIN
            SELECT  @MaSP = Inserted.MaSP ,
                    @SoLuongXuat = Inserted.SoLuong ,
					@DonGiaNhap = Inserted.GiaNiemYet,
					@ThanhTien = Inserted.ThanhTien,
					@MaDonXuat = Inserted.MaDonXuat
            FROM    KhoHangSP
                    INNER JOIN Inserted ON Inserted.MaSP = KhoHangSP.MaSP
                    INNER JOIN dbo.SanPham ON SanPham.MaSP = Inserted.MaSP;
			
			UPDATE dbo.DonXuatHang SET TongTienXuat = TongTienXuat + @ThanhTien WHERE MaDonXuat = @MaDonXuat
			
			SELECT  @SoLuongTrongKho=SUM(SoLuongSPTrongKho), @LuongSP_NSX = COUNT(HanSuDung)
			FROM    dbo.KhoHangSP
					INNER JOIN dbo.SanPham ON SanPham.MaSP = KhoHangSP.MaSP
			WHERE KhoHangSP.TrangThaiXoa = 0 AND HanSuDung > GETDATE() AND KhoHangSP.MaSP = @MaSP
			GROUP BY KhoHangSP.MaSP , TenSP
			
			DROP TABLE IF EXISTS #SP
			CREATE TABLE #SP (
					  TT INT IDENTITY NOT NULL PRIMARY KEY,
					  MaKho INT NOT NULL,
			          MaSP VARCHAR(10) NOT NULL,
			          SoLuongSPTrongKho INT NOT NULL,
			          NgaySanXuat DATE NOT NULL,
			          HanSuDung DATE NOT NULL,
			          TrangThaiXoa BIT NOT NULL
			)
			INSERT INTO #SP ( MaKho , MaSP , SoLuongSPTrongKho , NgaySanXuat , HanSuDung , TrangThaiXoa )
			SELECT MaKho, MaSP, SoLuongSPTrongKho, NgaySanXuat,HanSuDung,TrangThaiXoa FROM dbo.KhoHangSP WHERE MaSP = @MaSP AND TrangThaiXoa = 0 AND HanSuDung > GETDATE() ORDER BY HanSuDung ASC
			--Lấy dữ liệu từ bảng tạm cho chạy vòng lập for truy vấn theo id tự tạo của bảng tạm và set dữ liệu lại sao đó cập nhật lại cho bảng kho hàng sản phẩm
            WHILE @BienDem <= @LuongSP_NSX
                BEGIN
                    IF ( @SoLuongXuat <= (SELECT SoLuongSPTrongKho FROM #SP WHERE TT = @BienDem) )
                        BEGIN
                            UPDATE  dbo.KhoHangSP
                            SET     SoLuongSPTrongKho = SoLuongSPTrongKho - @SoLuongXuat
                            WHERE   MaSP = @MaSP AND HanSuDung = ( SELECT HanSuDung FROM #SP WHERE TT = @BienDem );
							BREAK;
                        END;
                    ELSE
                        BEGIN
							SELECT @SoLuongConLaiCuaSP = SoLuongSPTrongKho FROM #SP WHERE TT = @BienDem 
                            UPDATE  dbo.KhoHangSP
                            SET     SoLuongSPTrongKho = 0 , TrangThaiXoa = 1
                            WHERE   MaSP = @MaSP AND HanSuDung = ( SELECT HanSuDung FROM #SP WHERE TT = @BienDem );
							SET @SoLuongXuat = @SoLuongXuat - @SoLuongConLaiCuaSP
                        END	
					SET @BienDem = @BienDem + 1
                END
		END
     
	END;
GO



-- Thêm dữ liệu vào bảng Nhà Cung Cấp
INSERT INTO dbo.NhaCungCap 
        ( MaNCC, TenNCC, DiaChi, SoDienThoai, ChiTiet, NgayTao, NguoiTao )
VALUES  ( 'NCC001', N'Tân - Mùa Vàng', N'Cần Thơ', '0998773333', N'', GETDATE() , N'NV3' ),
		( 'NCC002', N'Giót - Bayer', N'Cần Thơ', '0998773334', N'', GETDATE() , N'NV3' ),
		( 'NCC003', N'Minh - ADC', N'Cần Thơ', '0998773335', N'', GETDATE() , N'NV3' ),
		( 'NCC004', N'Đạt - Sygenta', N'Cần Thơ', '0998776333', N'', GETDATE() , N'NV3' );
GO

-- Thêm dữ liệu vào bảng Kho Hàng
INSERT  INTO dbo.KhoHang
        ( TenKhoHang)
VALUES  ( N'Kho' );
GO

-- Thêm dữ liệu vào bảng Phân Loại Sản Phẩm
INSERT INTO dbo.PhanLoaiSP 
        ( TenLoaiSP , NgayTao, NguoiTao)
VALUES  ( N'Thuốc Trừ Sâu' , GETDATE(), N'NV00001' ),
		( N'Thuốc Diệt Cỏ' , GETDATE(), N'NV00001' ),
		( N'Thuốc Kích Thích Sinh Trưởng' , GETDATE(), N'NV00001' ),
		( N'Thuốc Trừ Bệnh' , GETDATE(), N'NV00001' ),
		( N'Phân bón' , GETDATE(), N'NV00001' );
GO

-- Thêm dữ liệu vào bảng Loại Nhân Viên
INSERT INTO dbo.LoaiNhanVien
        ( TenLoaiNV, NgayTao, NguoiTao )
VALUES  ( N'Nhân Viên Kho', GETDATE(), N'NV00001' );
GO

-- Thêm dữ liệu vào bảng Vai Trò
INSERT INTO dbo.VaiTro
        ( TenVaiTro)
VALUES  ( N'Quản lý'),
		( N'Nhân Viên');
GO

-- Thêm dữ liệu vào bảng Đơn Vị Tính
INSERT INTO dbo.DonViTinh
        ( TenDonViTinh )
VALUES  ( N'Gói' ),
		( N'Chai' ),
		( N'Viên' );
GO

-- Thêm dữ liệu vào bảng Trạng Thái Thanh Toán
INSERT INTO dbo.TrangThaiThanhToan
        ( TenTrangThai )
VALUES  ( N'Đã thanh toán'),
		( N'Đang thanh toán'),
		( N'Chưa thanh toán');
GO

-- Thêm dữ liệu vào bảng Trạng Thái Hóa Đơn Xuất
INSERT INTO dbo.TrangThaiHoaDonXuat
        ( TenTrangThai )
VALUES  ( N'Đã xuât hàng' ),
		( N'Chưa xuât hàng' );
GO

-- Thêm dữ liệu vào bảng Nhân Viên
INSERT INTO dbo.NhanVien 
        ( MaNV, MatKhau, HoTen, GioiTinh, SoDienThoai, NgaySinh, DiaChi, Email, MaLoaiNV, MaVaiTro, NgayTao, NguoiTao, TaiKhoan )
VALUES  ( 'NV00001', N'1A2a3@', N'Phan Tuấn Linh', 0, '0948922927','19970821', N'Cần Thơ','tuanlinh0291@gmail.com', 1, 1, GETDATE(), N'NV00001', 'LinhptNV00001' ),
( 'NV00002', N'1A2a3@', N'Trần Chí Nguyễn', 0, '0948922927','20030102', N'Sóc Trăng','nguyentcpc04750@fpt.edu.vn', 1, 1, GETDATE(), N'NV00001', 'NguyentcNV00002' ),
( 'NV00003', N'1A2a3@', N'Trần Phúc Vinh', 0, '0948922927','19990102', N'An Giang','Vinhtppc04838@fpt.edu.vn', 1, 1, GETDATE(), N'NV00001', 'VinhtpNV00003' ),
( 'NV00004', N'1A2a3@', N'Phan Thị Phương Đài', 1, '0948922927','20030102', N'Cần Thơ','daiptppc04228@fpt.edu.vn', 1, 1, GETDATE(), N'NV00001', 'DaiptpNV00004' ),
( 'NV00005', N'1A2a3@', N'Nguyễn Thọ An', 0, '0948922927','20030102', N'Cần Thơ','anntpc04830@fpt.edu.vn', 1, 1, GETDATE(), N'NV00001', 'AnntNV00005' );

GO

-- Thêm dữ liệu vào bảng Sản Phẩm
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )
VALUES  ( 'SP000001', 'NCC001', N'Humic 1kg',1, N'Humic 1kg.png', 3, 42000, N'', GETDATE(), N'NV00001');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000002', 'NCC001', N'Root',2, N'root.png', 3, 5500, N'', GETDATE(), N'NV00001');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000003', 'NCC001', N'LongPhaBa 3.6EC',2, N'LongPhaBa 3.6EC.png', 1, 65000, N'', GETDATE(), N'NV00001');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000004', 'NCC001', N'Cặp MiTaFarm',2, N'MiTaFarm.png', 4, 160000, N'', GETDATE(), N'NV00001');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000005', 'NCC001', N'Aha 500SC',2, N'Aha 500SC.png', 1, 249000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000006', 'NCC001', N'Aha Thụy Sĩ 800',1, N'Aha Thụy Sĩ 800.png', 1, 34000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000007', 'NCC001', N'Fukuda 3SL(Khuẩn đệ)',1, N'Fukuda 3SL.png', 4, 7800, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000008', 'NCC001', N'Bo chai 500ml-Nga',2, N'Bo.png', 3, 75000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000009', 'NCC001', N'Caxi Bo Sữa 1000ml',2, N'Caxi Bo Sữa 1000ml.png', 3, 79000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000010', 'NCC001', N'Lorcy 265SC(Sâu 24h)',2, N'Lorcy 265SC.png', 1, 125000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000011', 'NCC001', N'BinhFos 50EC (Muỗi Hành)',2, N'BinhFos 50EC.png', 1, 145000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000012', 'NCC001', N'Lem Lép',2, N'lemlep.png', 1, 105000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000013', 'NCC001', N'Kali Vô Gạo',1, N'vogao.png', 3, 5000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000015', 'NCC001', N'Cặp Gói Japan',1, N'GoiJP.png', 4, 20900, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000016', 'NCC001', N'Fowavin MC',2, N'fowin.png', 4, 87900, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000017', 'NCC001', N'NP Snailicide 700WP (Ốc cò)',1, N'NP Snailicide 700WP.png', 1, 36000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000018', 'NCC001', N'Humic Miễng Mita',2, N'HumicMieng.png', 3, 20900, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000019', 'NCC001', N'Mita Gold',2, N'MitaGold.png', 4, 130000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000020', 'NCC001', N'Cặp Mitafarm',2, N'MitaF.png', 4, 160000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000021', 'NCC001', N'Gribb Tím',3, N'Gribb.png', 4, 4000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000022', 'NCC001', N'Ốc xịt 70gr',1, N'Ocxit.png', 1, 19500, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000023', 'NCC001', N'Xông Hơi',2, N'Xonghoi.png', 1, 85000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000024', 'NCC001', N'Alex 20SC (Sâu lá)',2, N'Alex 20SC.png', 1, 96000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000025', 'NCC001', N'Forwavil 5SC',2, N'Forwavil 5SC.png', 3, 50000, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.SanPham
        ( MaSP, MaNCC, TenSP, DonViTinh, HinhAnh, LoaiSP, DonGiaBan, GhiChu, NgayTao, NguoiTao )		
VALUES	( 'SP000026', 'NCC001', N'LongPhaBa 3.6EC (Bọ)',2, N'LongPhaBa 3.6EC.png', 3, 85000, N'', GETDATE(), N'NV00003');
GO

-- Thêm dữ liệu vào bảng Đơn Nhập Hàng
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000001', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00001');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000002', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00001');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000003', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000004', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000005', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000006', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000007', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000008', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000009', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000010', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000011', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000012', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000013', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000014', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000015', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000016', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000017', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000018', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000019', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000020', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000021', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO
INSERT INTO dbo.DonNhapHang
        ( MaDonNhap, MaNV, MaKhoHang, TongTienNhap, TrangThaiThanhToan, SoTienDaThanhToan, GhiChu, NgayTao, NguoiTao)
VALUES  ( 'HDN00000022', 'NV00001', 1, 0, 3, 0, N'', GETDATE(), N'NV00003');
GO

-- Thêm dữ liệu vào bảng Chi Tiết Đơn Nhập Hàng
INSERT INTO dbo.ChiTietNhap
        (MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1 ,'HDN00000001', 'SP000001',  25, 2, 50, 42000, 2100000, '20200101', '20240101', N'Gởi xe' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000001', 'SP000002',  800, 8, 6400, 5500, 35200000, '20200101', '20240101', N'Gởi xe' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  (1, 'HDN00000002', 'SP000003',  30, 2, 60, 65000, 3900000, '20211118', '20241118', N'Gởi xe' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000003', 'SP000004',  20, 2, 40, 160000, 6400000, '20210105', '20250105', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000003', 'SP000005',  24, 1, 17, 249000, 4233000, '20210105', '20250105', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 3, 'HDN00000003', 'SP000006',  200, 1, 200, 34000, 6800000, '20210105', '20250105', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000004', 'SP000007',  500, 1, 200, 7800, 1560000, '20210104', '20240104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000004', 'SP000008',  24, 1, 24, 75000, 1800000, '20210104', '20240104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 3, 'HDN00000004', 'SP000009',  20, 1, 20, 79000, 1580000, '20210104', '20240104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000005', 'SP000010',  100, 1, 100, 125000, 12500000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000006', 'SP000011',  30, 2, 60, 145000, 8700000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000006', 'SP000012',  40, 1, 40, 105000, 4200000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000007', 'SP000013',  750, 1, 750,5000, 3750000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000008', 'SP000015',  20, 2, 40,87000, 3480000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000008', 'SP000011',  30, 2, 60,1450000, 8700000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000009', 'SP000006',  200, 1, 200,34000, 6800000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000010', 'SP000001',  25, 4, 100,42000, 4200000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000011', 'SP000017',  100, 3, 300,36000, 10800000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000012', 'SP000007',  500, 1, 500,7800, 3900000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000013', 'SP000016',  20, 3, 60,84700, 5082000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000013', 'SP000010',  49, 1, 49,125000, 8625000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 3, 'HDN00000013', 'SP000024',  100, 1, 100,96000, 9600000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000014', 'SP000018',  25, 2, 50,45000, 2250000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000015', 'SP000019',  40, 1, 40,130000, 5200000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000016', 'SP000020',  20, 2, 40,160000, 6400000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000016', 'SP000025',  40, 1, 40,50000, 2000000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000017', 'SP000021',  600, 1, 600,4000, 2400000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000017', 'SP000015',  200, 1, 200,20900, 4180000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000018', 'SP000009',  20, 2, 40,79000, 3160000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000018', 'SP000022',  40, 1, 40,19500, 3900000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000019', 'SP000007',  500, 1, 500,7800, 3900000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 2, 'HDN00000019', 'SP000020',  20, 2, 40,160000, 6400000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 3, 'HDN00000019', 'SP000011',  30, 1, 30,148000, 6440000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 4, 'HDN00000019', 'SP000023',  40, 1, 40,85000, 3400000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000020', 'SP000011',  30, 2, 60,148000, 8880000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000021', 'SP000011',  30, 3, 90,148000, 13320000, '20210104', '20220104', N'' );
GO
INSERT INTO dbo.ChiTietNhap
        ( MaCTNhap, MaDonNhap, MaSP, SoLuongTrongThung, SoLuongThung, SoLuong, DonGiaNhap, ThanhTien, NgaySanXuat, HanSuDung, ChiTiet )
VALUES  ( 1, 'HDN00000022', 'SP000026',  40, 1, 40,85000, 3400000, '20210104', '20220104', N'' );
GO


-- Thêm dữ liệu vào bảng Đơn Xuất Hàng
INSERT INTO  dbo.DonXuatHang
        ( MaDonXuat, MaNV, MaKhoHang, TongTienXuat, TrangThaiDonXuat, GhiChu, NgayTao, NguoiTao )
VALUES  ( 'HDX00000001', 'NV00001', 1, 0 , 2, N'', GETDATE(), N'NV00001' )
GO
INSERT INTO  dbo.DonXuatHang
        ( MaDonXuat, MaNV, MaKhoHang, TongTienXuat, TrangThaiDonXuat, GhiChu, NgayTao, NguoiTao )
VALUES  ( 'HDX00000002', 'NV00001', 1, 0 , 2, N'', GETDATE(), N'NV00001' )
GO
INSERT INTO  dbo.DonXuatHang
        ( MaDonXuat, MaNV, MaKhoHang, TongTienXuat, TrangThaiDonXuat, GhiChu, NgayTao, NguoiTao )
VALUES  ( 'HDX00000003', 'NV00001', 1, 0 , 2, N'', GETDATE(), N'NV00001' )
GO
INSERT INTO  dbo.DonXuatHang
        ( MaDonXuat, MaNV, MaKhoHang, TongTienXuat, TrangThaiDonXuat, GhiChu, NgayTao, NguoiTao )
VALUES  ( 'HDX00000004', 'NV00001', 1, 0 , 2, N'', '2023-03-09 16:47:05.267', N'NV00001' )
GO
INSERT INTO  dbo.DonXuatHang
        ( MaDonXuat, MaNV, MaKhoHang, TongTienXuat, TrangThaiDonXuat, GhiChu, NgayTao, NguoiTao )
VALUES  ( 'HDX00000005', 'NV00001', 1, 0 , 2, N'', GETDATE(), N'NV00001' )
GO

INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (1, 'HDX00000001', 'SP000002', 10000, 75, 750000,N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES 	(2, 'HDX00000001', 'SP000003', 80000, 10, 800000, N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES 	(3, 'HDX00000001', 'SP000001', 50000, 15, 750000, N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (1, 'HDX00000002', 'SP000002', 10000, 100, 1000000,N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (2, 'HDX00000002', 'SP000003', 80000, 5, 400000, N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (3, 'HDX00000002', 'SP000001', 50000, 6, 300000, N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (1, 'HDX00000003', 'SP000002', 10000, 300, 3000000,N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (2, 'HDX00000003', 'SP000003', 80000, 10, 800000, N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (3, 'HDX00000003', 'SP000001', 50000, 10, 500000, N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (1, 'HDX00000004', 'SP000002', 10000, 350, 350000,N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (2, 'HDX00000004', 'SP000002', 10000, 4500, 45000000,N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (3, 'HDX00000004', 'SP000003', 80000, 15, 1200000, N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (4, 'HDX00000004', 'SP000001', 50000, 3, 150000, N'' );
GO
INSERT INTO dbo.ChiTietXuat
        (MaCTXuat, MaDonXuat, MaSP, GiaNiemYet, SoLuong, ThanhTien,  ChiTiet )
VALUES  (5, 'HDX00000004', 'SP000003', 50000, 40, 150000, N'' );
GO

-- Tạo các store Proceduce để thống kê
-- Tạo sp Thống kê hàng tồn kho
CREATE PROC sp_TKHangTon
AS
    BEGIN
        SELECT  KhoHangSP.MaSP ,
                TenSP ,
				TenDonViTinh,
                SUM(SoLuongSPTrongKho) AS SoLuongTrongKho ,
                DonGiaNhap ,
                SUM( SoLuongSPTrongKho * DonGiaNhap ) AS ThanhTien,
				NgaySanXuat,
				HanSuDung
        FROM    dbo.KhoHangSP
                INNER JOIN dbo.SanPham ON SanPham.MaSP = KhoHangSP.MaSP
				INNER JOIN dbo.DonViTinh ON MaDVT = dbo.SanPham.DonViTinh
		WHERE KhoHangSP.TrangThaiXoa = 0 AND HanSuDung > GETDATE()
		GROUP BY KhoHangSP.MaSP ,
                TenSP ,
                DonGiaNhap ,
				NgaySanXuat,
				HanSuDung,
				TenDonViTinh
		ORDER BY HanSuDung ASC
        
    END;
GO

--EXEC sp_TKHangTon 
--GO
DROP TABLE IF EXISTS ThongKeSoLuong
CREATE TABLE ThongKeSoLuong(
	MaSP VARCHAR(15) NOT NULL,
	TenSP NVARCHAR(255) NOT NULL,
	SoLuong INT DEFAULT 0,
);
GO

-- Tạo sp thống kê số lượng sản phẩm
CREATE PROC sp_TKSoLuongSP
AS
    BEGIN
		TRUNCATE TABLE dbo.ThongKeSoLuong
		INSERT INTO dbo.ThongKeSoLuong ( MaSP, TenSP, SoLuong )
        SELECT  KhoHangSP.MaSP ,
                TenSP ,
				 SUM(SoLuongSPTrongKho) AS SoLuongTrongKho
        FROM    dbo.SanPham
                INNER JOIN dbo.KhoHangSP ON KhoHangSP.MaSP = SanPham.MaSP
        WHERE   KhoHangSP.TrangThaiXoa = 0 AND HanSuDung> GETDATE()
        GROUP BY KhoHangSP.MaSP ,
                TenSP
        ORDER BY SoLuongTrongKho DESC;

		INSERT INTO dbo.ThongKeSoLuong ( MaSP, TenSP )
		SELECT MaSP, TenSP FROM dbo.SanPham WHERE MaSP NOT IN (SELECT MaSP FROM dbo.ThongKeSoLuong)
    END;
GO
--SELECT * FROM dbo.KhoHangSP

--EXEC sp_TKSoLuongSP
--GO

-- Tạo sp sản phẩm hết hạn sử dụng
CREATE PROC sp_TKSPHetHSD
AS
    BEGIN
        SELECT  ChiTietNhap.MaSP ,
                TenSP ,
                ( SUM(ChiTietNhap.SoLuong) ) AS SoLuong ,
                NgaySanXuat ,
                HanSuDung
        FROM    dbo.ChiTietNhap
                INNER JOIN dbo.SanPham ON SanPham.MaSP = ChiTietNhap.MaSP
		WHERE TrangThaiXoa = 0 AND HanSuDung < GETDATE()
        GROUP BY ChiTietNhap.MaSP ,
                TenSP ,
                NgaySanXuat ,
                HanSuDung
        ORDER BY NgaySanXuat ASC;
    END;
GO

-- Tạo sp thống kê hóa đơn nhập
CREATE PROC sp_TKHoaDonNhap
AS
    BEGIN
        SELECT  MaDonNhap ,
                TongTienNhap ,
                TrangThaiThanhToan.TenTrangThai ,
                SoTienDaThanhToan,
				MaNV,
				NgayTao
        FROM    dbo.DonNhapHang
		INNER JOIN dbo.TrangThaiThanhToan ON TrangThaiThanhToan.MaTrangThai = DonNhapHang.TrangThaiThanhToan
		WHERE TrangThaiXoa = 0
		ORDER BY TongTienNhap ASC
    END;
GO

--EXEC sp_TKHoaDonNhap
--GO
--SELECT  MaDonNhap ,
--        TongTienNhap ,
--        TrangThaiThanhToan.TenTrangThai ,
--        SoTienDaThanhToan ,
--        MaNV ,
--        NgayTao
--FROM    dbo.DonNhapHang
--        INNER JOIN dbo.TrangThaiThanhToan ON TrangThaiThanhToan.MaTrangThai = DonNhapHang.TrangThaiThanhToan
--WHERE   TrangThaiXoa = 0
--        AND CONVERT(DATE, GETDATE(), 105) = CONVERT(DATE, NgayTao, 105)
--ORDER BY TongTienNhap ASC

-- Tạo sp thống kê hóa đơn xuất
CREATE PROC sp_TKHoaDonXuat
AS
    BEGIN
        SELECT  MaDonXuat ,
                TongTienXuat ,
                TenTrangThai,
				MaNV,
				NgayTao
        FROM    dbo.DonXuatHang
                INNER JOIN dbo.TrangThaiHoaDonXuat ON TrangThaiHoaDonXuat.MaTrangThaiHDX = DonXuatHang.TrangThaiDonXuat
		WHERE TrangThaiXoa = 0
		ORDER BY TongTienXuat ASC
    END;
GO
     
	    
--SELECT  MaDonXuat ,
--        TongTienXuat ,
--        TenTrangThai ,
--        MaNV ,
--        NgayTao
--FROM    dbo.DonXuatHang
--        INNER JOIN dbo.TrangThaiHoaDonXuat ON TrangThaiHoaDonXuat.MaTrangThaiHDX = DonXuatHang.TrangThaiDonXuat
--WHERE   TrangThaiXoa = 0 AND CONVERT(DATE, GETDATE(), 105) = CONVERT(DATE, NgayTao, 105)
--ORDER BY TongTienXuat ASC


-- Tạo sp thống kê doanh thu ngày hiện tại
CREATE PROC sp_TKNgayHienTai
AS
    BEGIN
		DROP TABLE IF EXISTS #ThongKeNhapXuat
		CREATE TABLE #ThongKeNhapXuat(
			STT INT IDENTITY NOT NULL PRIMARY KEY,
			TongHDN INT NOT NULL,
			ChuaThanhToan INT NOT NULL,
			DangThanhToan INT NOT NULL,
			DaThanhToan INT NOT NULL,
			TongTienNhap DOUBLE PRECISION  NULL,
			SoTienDaThanhToan DOUBLE PRECISION NULL,
			SoTienConNo DOUBLE PRECISION NULL,
			TongHDX INT NOT NULL,
			TongTienXuat DOUBLE PRECISION NULL,
			DoanhThu DOUBLE PRECISION NULL,
			NgayTao DATETIME DEFAULT GETDATE()
		);
		DECLARE @SoHDN INT, @TongTienNhap DOUBLE PRECISION,@SoHDX INT, @TongTienXuat DOUBLE PRECISION, @HDNChuaThanhToan INT, @HDNDangThanhToan INT, @HDNDaThanhToan INT, @SoTienDaThanhToan DOUBLE PRECISION;

		SELECT @HDNDaThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 1 AND TrangThaiXoa = 0 AND CONVERT( DATE, NgayTao, 105 ) = CONVERT(DATE,GETDATE(),105) 
		SELECT @HDNDangThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 2 AND TrangThaiXoa = 0 AND CONVERT( DATE, NgayTao, 105 ) = CONVERT(DATE,GETDATE(),105) 
		SELECT @HDNChuaThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 3 AND TrangThaiXoa = 0 AND CONVERT( DATE, NgayTao, 105 ) = CONVERT(DATE,GETDATE(),105) 
		SELECT @SoTienDaThanhToan=SUM(SoTienDaThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiXoa = 0 AND CONVERT( DATE, NgayTao, 105 ) = CONVERT(DATE,GETDATE(),105) 
		SELECT @SoHDN=COUNT(MaDonNhap), @TongTienNhap=SUM(TongTienNhap) FROM dbo.DonNhapHang WHERE TrangThaiXoa = 0 AND CONVERT(DATE,NgayTao,105) = CONVERT(DATE,GETDATE(),105) 

		SELECT  @SoHDX=COUNT(MaDonXuat), @TongTienXuat=SUM(TongTienXuat) FROM dbo.DonXuatHang
		WHERE TrangThaiXoa = 0 AND CONVERT(DATE,NgayTao,105) = CONVERT(DATE,GETDATE(),105) 
		
		INSERT INTO #ThongKeNhapXuat
		        ( TongHDN, TongTienNhap, ChuaThanhToan, DangThanhToan, DaThanhToan, TongHDX, TongTienXuat, DoanhThu , SoTienDaThanhToan, SoTienConNo)
		VALUES  ( @SoHDN, @TongTienNhap, @HDNChuaThanhToan, @HDNDangThanhToan, @HDNDaThanhToan, @SoHDX, @TongTienXuat, @TongTienXuat - @SoTienDaThanhToan ,@SoTienDaThanhToan, @TongTienNhap-@SoTienDaThanhToan)

		SELECT TOP(1) * FROM #ThongKeNhapXuat ORDER BY NgayTao DESC
    END;
GO

--EXEC dbo.sp_TKNgayHienTai
DROP TABLE IF EXISTS ThongKeTheoNgay
CREATE TABLE ThongKeTheoNgay(
	Ngay DATE NOT NULL PRIMARY KEY,
	TongHDN INT NULL DEFAULT 0,
	ChuaThanhToan INT NULL DEFAULT 0,
	DangThanhToan INT NULL DEFAULT 0,
	DaThanhToan INT NULL DEFAULT 0,
	TongTienNhap DOUBLE PRECISION NULL DEFAULT 0,
	SoTienDaThanhToan DOUBLE PRECISION NULL DEFAULT 0,
	SoTienConNo DOUBLE PRECISION NULL DEFAULT 0,
	TongHDX INT NULL DEFAULT 0,
	TongTienXuat DOUBLE PRECISION NULL DEFAULT 0,
	DoanhThu DOUBLE PRECISION NULL DEFAULT 0
);
GO

-- Tạo sp thống kê thông tin hóa đơn theo ngày
CREATE PROC sp_TKTheoNgay (@NgayThangNam VARCHAR(15))
AS
    BEGIN
		TRUNCATE TABLE dbo.ThongKeTheoNgay
		DECLARE @NgayBatDau DATE = DATEFROMPARTS(YEAR(CONVERT(DATE,@NgayThangNam)),MONTH(CONVERT(DATE,@NgayThangNam)),1),@SoHDN INT, @TongTienNhap DOUBLE PRECISION,@SoHDX INT, @TongTienXuat DOUBLE PRECISION, @HDNChuaThanhToan INT, @HDNDangThanhToan INT, @HDNDaThanhToan INT, @SoTienDaThanhToan DOUBLE PRECISION, @ngayTaoHDN DATE, @ngayTaoHDX DATE;
		
		WHILE @NgayBatDau <= CONVERT(DATE, CONVERT(DATE,@NgayThangNam), 105)
			BEGIN
				SELECT @HDNDaThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 1 AND TrangThaiXoa = 0 AND CONVERT( DATE, NgayTao, 105 ) = CONVERT(DATE,@NgayBatDau,105) 
				SELECT @HDNDangThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 2 AND TrangThaiXoa = 0 AND CONVERT( DATE, NgayTao, 105 ) = CONVERT(DATE,@NgayBatDau,105) 
				SELECT @HDNChuaThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 3 AND TrangThaiXoa = 0 AND CONVERT( DATE, NgayTao, 105 ) = CONVERT(DATE,@NgayBatDau,105) 
				SELECT @SoTienDaThanhToan=SUM(SoTienDaThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiXoa = 0 AND CONVERT( DATE, NgayTao, 105 ) = CONVERT(DATE,@NgayBatDau,105) 
				SELECT @SoHDN=COUNT(MaDonNhap), @TongTienNhap=SUM(TongTienNhap) FROM dbo.DonNhapHang WHERE TrangThaiXoa = 0 AND CONVERT(DATE,NgayTao,105) = CONVERT(DATE,@NgayBatDau,105) 

				SELECT  @SoHDX=COUNT(MaDonXuat), @TongTienXuat=SUM(TongTienXuat) FROM dbo.DonXuatHang WHERE TrangThaiXoa = 0 AND CONVERT(DATE,NgayTao,105) = CONVERT(DATE,@NgayBatDau,105) 
				
				INSERT INTO ThongKeTheoNgay(Ngay, TongHDN, TongTienNhap, ChuaThanhToan, DangThanhToan, DaThanhToan, TongHDX, TongTienXuat, DoanhThu , SoTienDaThanhToan, SoTienConNo)
				VALUES  (@NgayBatDau, @SoHDN, @TongTienNhap, @HDNChuaThanhToan, @HDNDangThanhToan, @HDNDaThanhToan, @SoHDX, @TongTienXuat, @TongTienXuat - @SoTienDaThanhToan ,@SoTienDaThanhToan, @TongTienNhap-@SoTienDaThanhToan)

				SET @NgayBatDau = DATEADD(DAY, 1, @NgayBatDau)
			END
		SELECT * FROM ThongKeTheoNgay
    END;
GO

--EXEC dbo.sp_TKTheoNgay @NgayThangNam = '20230330' -- date
--GO
--SELECT * FROM dbo.ThongKeTheoNgay

DROP TABLE IF EXISTS ThongKeTheoThang
CREATE TABLE ThongKeTheoThang(
	Thang INT NOT NULL PRIMARY KEY,
	TongHDN INT NULL DEFAULT 0,
	ChuaThanhToan INT NULL DEFAULT 0,
	DangThanhToan INT NULL DEFAULT 0,
	DaThanhToan INT NULL DEFAULT 0,
	TongTienNhap DOUBLE PRECISION NULL DEFAULT 0,
	SoTienDaThanhToan DOUBLE PRECISION NULL DEFAULT 0,
	SoTienConNo DOUBLE PRECISION NULL DEFAULT 0,
	TongHDX INT NULL DEFAULT 0,
	TongTienXuat DOUBLE PRECISION NULL DEFAULT 0,
	DoanhThu DOUBLE PRECISION NULL DEFAULT 0
);
GO

-- Tạo sp thống kê thông tin hóa đơn theo tháng
CREATE PROC sp_TKTheoThang (@NgayThangNam VARCHAR(15))
AS
    BEGIN
		TRUNCATE TABLE dbo.ThongKeTheoThang
		DECLARE @ThangBatDau DATE = DATEFROMPARTS(YEAR(CONVERT(DATE,@NgayThangNam)),MONTH(1),1),@SoHDN INT, @TongTienNhap DOUBLE PRECISION,@SoHDX INT, @TongTienXuat DOUBLE PRECISION, @HDNChuaThanhToan INT, @HDNDangThanhToan INT, @HDNDaThanhToan INT, @SoTienDaThanhToan DOUBLE PRECISION, @ngayTaoHDN DATE, @ngayTaoHDX DATE;
		
		WHILE @ThangBatDau <= CONVERT(DATE, @NgayThangNam, 105)
			BEGIN
				SELECT @HDNDaThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 1 AND TrangThaiXoa = 0 AND DATEFROMPARTS(YEAR(NgayTao),MONTH(NgayTao),1) = DATEFROMPARTS(YEAR(@ThangBatDau),MONTH(@ThangBatDau),1)
				SELECT @HDNDangThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 2 AND TrangThaiXoa = 0 AND DATEFROMPARTS(YEAR(NgayTao),MONTH(NgayTao),1) = DATEFROMPARTS(YEAR(@ThangBatDau),MONTH(@ThangBatDau),1)
				SELECT @HDNChuaThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 3 AND TrangThaiXoa = 0 AND DATEFROMPARTS(YEAR(NgayTao),MONTH(NgayTao),1) = DATEFROMPARTS(YEAR(@ThangBatDau),MONTH(@ThangBatDau),1)
				SELECT @SoTienDaThanhToan=SUM(SoTienDaThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiXoa = 0 AND DATEFROMPARTS(YEAR(NgayTao),MONTH(NgayTao),1) = DATEFROMPARTS(YEAR(@ThangBatDau),MONTH(@ThangBatDau),1) 
				SELECT @SoHDN=COUNT(MaDonNhap), @TongTienNhap=SUM(TongTienNhap) FROM dbo.DonNhapHang WHERE TrangThaiXoa = 0 AND DATEFROMPARTS(YEAR(NgayTao),MONTH(NgayTao),1) = DATEFROMPARTS(YEAR(@ThangBatDau),MONTH(@ThangBatDau),1)

				SELECT  @SoHDX=COUNT(MaDonXuat), @TongTienXuat=SUM(TongTienXuat) FROM dbo.DonXuatHang WHERE TrangThaiXoa = 0 AND DATEFROMPARTS(YEAR(NgayTao),MONTH(NgayTao),1) = DATEFROMPARTS(YEAR(@ThangBatDau),MONTH(@ThangBatDau),1) 
				
				INSERT INTO ThongKeTheoThang(Thang, TongHDN, TongTienNhap, ChuaThanhToan, DangThanhToan, DaThanhToan, TongHDX, TongTienXuat, DoanhThu , SoTienDaThanhToan, SoTienConNo)
				VALUES  (MONTH(@ThangBatDau), @SoHDN, @TongTienNhap, @HDNChuaThanhToan, @HDNDangThanhToan, @HDNDaThanhToan, @SoHDX, @TongTienXuat, @TongTienXuat - @SoTienDaThanhToan ,@SoTienDaThanhToan, @TongTienNhap-@SoTienDaThanhToan)

				SET @ThangBatDau = DATEADD(MONTH, 1, @ThangBatDau)
			END
		SELECT * FROM ThongKeTheoThang
    END;
GO

--EXEC dbo.sp_TKTheoThang @NgayThangNam = '20230410' -- date
--GO

DROP TABLE IF EXISTS ThongKeTheoNam
CREATE TABLE ThongKeTheoNam(
	Nam INT NOT NULL PRIMARY KEY,
	TongHDN INT NULL DEFAULT 0,
	ChuaThanhToan INT NULL DEFAULT 0,
	DangThanhToan INT NULL DEFAULT 0,
	DaThanhToan INT NULL DEFAULT 0,
	TongTienNhap DOUBLE PRECISION NULL DEFAULT 0,
	SoTienDaThanhToan DOUBLE PRECISION NULL DEFAULT 0,
	SoTienConNo DOUBLE PRECISION NULL DEFAULT 0,
	TongHDX INT NULL DEFAULT 0,
	TongTienXuat DOUBLE PRECISION NULL DEFAULT 0,
	DoanhThu DOUBLE PRECISION NULL DEFAULT 0
);
GO

-- Tạo sp thống kê thông tin hóa đơn theo năm
CREATE PROC sp_TKTheoNam (@NgayThangNam VARCHAR(15))
AS
    BEGIN
		TRUNCATE TABLE dbo.ThongKeTheoNam
		DECLARE @NamBatDau DATE = DATEFROMPARTS(YEAR('20200101'),MONTH(1),1),@SoHDN INT, @TongTienNhap DOUBLE PRECISION,@SoHDX INT, @TongTienXuat DOUBLE PRECISION, @HDNChuaThanhToan INT, @HDNDangThanhToan INT, @HDNDaThanhToan INT, @SoTienDaThanhToan DOUBLE PRECISION, @ngayTaoHDN DATE, @ngayTaoHDX DATE;
		
		WHILE @NamBatDau <= CONVERT(DATE, @NgayThangNam, 105)
			BEGIN
				SELECT @HDNDaThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 1 AND TrangThaiXoa = 0 AND YEAR(NgayTao) = YEAR(@NamBatDau)
				SELECT @HDNDangThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 2 AND TrangThaiXoa = 0 AND YEAR(NgayTao) = YEAR(@NamBatDau)
				SELECT @HDNChuaThanhToan=COUNT(TrangThaiThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiThanhToan = 3 AND TrangThaiXoa = 0 AND YEAR(NgayTao) = YEAR(@NamBatDau)
				SELECT @SoTienDaThanhToan=SUM(SoTienDaThanhToan) FROM dbo.DonNhapHang WHERE TrangThaiXoa = 0 AND YEAR(NgayTao) = YEAR(@NamBatDau)
				SELECT @SoHDN=COUNT(MaDonNhap), @TongTienNhap=SUM(TongTienNhap) FROM dbo.DonNhapHang WHERE TrangThaiXoa = 0 AND YEAR(NgayTao) = YEAR(@NamBatDau)

				SELECT  @SoHDX=COUNT(MaDonXuat), @TongTienXuat=SUM(TongTienXuat) FROM dbo.DonXuatHang WHERE TrangThaiXoa = 0 AND YEAR(NgayTao) = YEAR(@NamBatDau)
				
				INSERT INTO ThongKeTheoNam(Nam, TongHDN, TongTienNhap, ChuaThanhToan, DangThanhToan, DaThanhToan, TongHDX, TongTienXuat, DoanhThu , SoTienDaThanhToan, SoTienConNo)
				VALUES  (YEAR(@NamBatDau), @SoHDN, @TongTienNhap, @HDNChuaThanhToan, @HDNDangThanhToan, @HDNDaThanhToan, @SoHDX, @TongTienXuat, @TongTienXuat - @SoTienDaThanhToan ,@SoTienDaThanhToan, @TongTienNhap-@SoTienDaThanhToan)

				SET @NamBatDau = DATEADD(YEAR, 1, @NamBatDau)
			END
		SELECT * FROM ThongKeTheoNam
    END;
GO

--EXEC dbo.sp_TKTheoNam @NgayThangNam = '20230310' -- date

--TEST

 --SELECT * FROM ChiTietNhap ORDER BY MaSP,HanSuDung ASC
 --SELECT MaSP, SUM(SoLuong) SL FROM ChiTietXuat GROUP BY MaSP
 --SELECT * FROM KhoHangSP ORDER BY MaSP,HanSuDung ASC
 --SELECT * FROM dbo.DonNhapHang
 --SELECT * FROM dbo.DonXuatHang

--DECLARE @start_dt AS DATE='20190101';
--DECLARE @end_dt AS DATE='20191231';
--DECLARE @dates AS TABLE(date_id DATE PRIMARY KEY,
--date_year SMALLINT,
--date_month TINYINT,
--date_day TINYINT,
--weekday_id TINYINT,
--weekday_nm VARCHAR(10),
--month_nm VARCHAR(10),
--day_of_year SMALLINT,
--quarter_id TINYINT,
--first_day_of_month DATE,
--last_day_of_month DATE,
--start_dts DATETIME,
--end_dts DATETIME);
--WHILE @start_dt<=@end_dt BEGIN
--    INSERT INTO @dates(date_id, date_year, date_month, date_day, weekday_id, weekday_nm, month_nm, day_of_year, quarter_id, first_day_of_month, last_day_of_month, start_dts, end_dts)
--    VALUES(@start_dt, YEAR(@start_dt), MONTH(@start_dt), DAY(@start_dt), DATEPART(WEEKDAY, @start_dt), DATENAME(WEEKDAY, @start_dt), DATENAME(MONTH, @start_dt), DATEPART(DAYOFYEAR, @start_dt), DATEPART(QUARTER, @start_dt), DATEADD(DAY, -(DAY(@start_dt)-1), @start_dt), DATEADD(DAY, -(DAY(DATEADD(MONTH, 1, @start_dt))), DATEADD(MONTH, 1, @start_dt)), CAST(@start_dt AS DATETIME), DATEADD(SECOND, -1, CAST(DATEADD(DAY, 1, @start_dt) AS DATETIME)));
--    SET @start_dt=DATEADD(DAY, 1, @start_dt);
--END;
--SELECT date_id AS [Ngày], date_year AS [Năm], date_month AS [Tháng], date_day AS [Ngày trong tháng], weekday_id AS [ID thứ], weekday_nm AS [Thứ], month_nm AS [Tháng], day_of_year AS [Ngày trong năm], quarter_id AS [Quý], first_day_of_month AS [Ngày đầu tiên của tháng], last_day_of_month AS [Ngày cuối cùng của tháng], start_dts, end_dts
--FROM @dates;

--SELECT * FROM dbo.TrangThaiHoaDonXuat