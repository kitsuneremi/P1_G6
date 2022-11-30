create database DA1_PTPM_IT17327_Nhom6
use DA1_PTPM_IT17327_Nhom6
drop database DA1_PTPM_IT17327_Nhom6

create table loaiXe(
	maLx nvarchar(50)primary key,
	ten nvarchar(50),
	giaNhap float,
	dongxe nvarchar(50),
	theloaixe nvarchar(50)
)

create table phieuBaoDuong(
	id nvarchar(50) primary key,
	bienSo nvarchar(50) foreign key references chiTietXe(bienSo),
	ngayBaoDuong date,
	ngayHoanThanh date,
	chiPhi float,
	mota nvarchar(50)
)

create table chiTietXe(
	bienSo nvarchar(50) primary key,
	maLx nvarchar(50) foreign key references loaiXe(maLx),
	tinhTrangXe int, -- 0 Co The Cho Thue, 1 Dang Cho Thue,2 Dang Hong Hoc,3 Dang Bao Duong
	giathuetrenngay money,
	mota nvarchar(50)
)

create table nhanVien(
	idnv nvarchar(50) primary key,
	ten nvarchar(50),
	ngaySinh date,
	sdt nvarchar(50),
	gioiTinh bit,
	taikhoan nvarchar(50) foreign key references dangnhap(taikhoan)
)
create table dangnhap(
	taikhoan nvarchar(50) primary key,
	matkhau nvarchar(50),
	chucvu nvarchar(50)
) 

create table khachHang(
	maKH nvarchar(50) primary key,
	ten nvarchar(50),
	sdt nvarchar(50),
	gioiTinh bit,
	cCCD nvarchar(50),
	email nvarchar(50)
)

create table hopDong(
	mahopdong nvarchar(50) primary key,
	idNv nvarchar(50) foreign key references nhanVien(idnv),
	makh nvarchar(50) foreign key references khachHang(makh),
	ngayTao date,
	ngayHetHan date,
	tinhTrang int,
	sourceAnh nvarchar(50),
	
)

create table ViPham(
	mavipham int primary key,
	ten nvarchar(50),
	
)
create table hoaDonTraXe(
	mahoadon nvarchar(50) primary key,
	mahopdong nvarchar(50) foreign key references hopDong(mahopdong),
	ngayTra date,
	mavipham int foreign key references Vipham(mavipham),
	phiPhatSinh float,
	thanhTien float,
	sourceAnh nvarchar(50),
	Mota nvarchar(50)

)

create table chiTietHopDong(
	mahopdong nvarchar(50) foreign key references hopDong(mahopdong),
	bienSo nvarchar(50) foreign key references chiTietXe(bienSo),
	tienCoc float,
	primary key (mahopdong,bienSo) 
)
select * from nhanVien
select * from khachHang
select * from loaixe
select * from ViPham
insert into dangnhap values('nguyenmanha123','12345678','Nhân Viên')
insert into dangnhap values('nguyenhuubinh123','12345678','Nhân Viên')
insert into dangnhap values('nguyentrunganh123','12345678','Nhân Viên')
insert into dangnhap values('nguyenngocminh123','12345678','Quản Lý')
insert into dangnhap values('nguyenvietanh123','12345678','Nhân Viên')
insert into dangnhap values('hoangvietdung123','12345678','Nhân Viên')
insert into dangnhap values('tranngochuy123','12345678','Nhân Viên')

insert into nhanVien values('NV1',N'Nguyễn Mạnh Hà','2003-11-04','0857595060',0,N'nguyenmanha123')
insert into nhanVien values('NV2',N'Nguyễn Hữu Bình','2003-11-28','01234567733',0,N'nguyenhuubinh123')
insert into nhanVien values('NV3',N'Nguyễn Ngọc Minh','2003-11-04','09789238455',0,N'nguyenngocminh123')
insert into nhanVien values('NV4',N'Nguyễn Việt Anh','2003-11-04','09723847572',0,N'nguyenvietanh123')
insert into nhanVien values('NV5',N'Hoàng Việt Dũng','2003-11-04','06823847923',0,N'hoangvietdung123')
insert into nhanVien values('NV6',N'Nguyễn Trung Anh','2003-11-04','02837692352',0,N'nguyentrunganh123')
insert into nhanVien values('NV7',N'Trần Ngọc Huy','2003-11-04','06236365313',0,N'tranngochuy123')



insert into khachHang values('KH1',N'Nguyễn Mạnh Hà','0323423534',0,'01245672','hanmph27977@fpt.edu.vn')
insert into khachHang values('KH2',N'Nguyễn Văn An','0125121451',0,'01153472','mailtest@gmail.com')
insert into khachHang values('KH3',N'Trần Hữu Nam','0125156123',0,'04325642','mailtest@gmail.com')
insert into khachHang values('KH4',N'Nguyễn Hữu Bình','0678967845',0,'01346372','mailtest@gmail.com')
insert into khachHang values('KH5',N'Hoàng Việt Dũng','0456783452',0,'01256312','otosakayuu203@gmail.com')
insert into khachHang values('KH6',N'Hoàng Thùy Chi','0345728956',1,'04574435','dunghvph28012@fpt.edu.vn')
insert into khachHang values('KH7',N'Nguyễn Long Nam','0351674588',0,'04568456','mailtest@gmail.com')
insert into khachHang values('KH8',N'Bùi Thị Kim Anh','0567846756',1,'02367245','mailtest@gmail.com')
insert into khachHang values('KH9',N'Phan Công Văn','0679456312',0,'03467234','mailtest@gmail.com')
insert into khachHang values('KH10',N'Nam Thái Sơn','0456867934',0,'01234624','mailtest@gmail.com')
insert into khachHang values('KH11',N'Hoàng Thùy Linh','0457834535',1,'01234624','mailtest@gmail.com')
insert into khachHang values('KH12',N'Nguyễn Quỳnh Chi','097684254',1,'01234624','mailtest@gmail.com')
insert into khachHang values('KH13',N'Nguyễn Văn An','064567456',0,'03647345','mailtest@gmail.com')
insert into khachHang values('KH14',N'Nguyễn Văn Thái','0345572341',0,'02356234','mailtest@gmail.com')
insert into khachHang values('KH15',N'Nguyễn Nam Kim','0125612452',0,'09678576','mailtest@gmail.com')
insert into khachHang values('KH16',N'Trần Kim Sắc','0123456789',0,'04568256','anhntph28042@fpt.edu.vn')
insert into khachHang values('KH17',N'Lục Văn Dũng','0987654321',0,'05683455','mailtest@gmail.com')
insert into khachHang values('KH18',N'Lê Tuấn Phong','0112233445',0,'02362347','huytnph27916@fpt.edu.vn')
insert into khachHang values('KH19',N'Kiều Hoàng Mai','0556677889',1,'03456734','mailtest@gmail.com')
insert into khachHang values('KH20',N'Phan Quốc Huy','0125756781',0,'03451364','mailtest@gmail.com')
insert into khachHang values('KH21',N'Nguyễn Kim An','0345734513',0,'01235624','mailtest@gmail.com')
insert into khachHang values('KH22',N'Trần Quốc Bảo','0457456524',0,'03467345','mailtest@gmail.com')
insert into khachHang values('KH23',N'Hoàng Mạnh Cường','0346716878',0,'06578567','mailtest@gmail.com')
insert into khachHang values('KH24',N'Nguyễn Thái Bình','01234564832',0,'02367345','mailtest@gmail.com')
insert into khachHang values('KH25',N'Trần Văn Nam','09847894586',0,'04563452','mailtest@gmail.com')
insert into khachHang values('KH26',N'Lê Thị Nga','045674568322',1,'06458865','mailtest@gmail.com')
insert into khachHang values('KH27',N'Nguyễn Việt Anh','0333675875',0,'04567345','mailtest@gmail.com')
insert into khachHang values('KH28',N'Trần Ngọc Huy','0856668563',0,'03456234','huytranisdabest@gmail.com')
insert into khachHang values('KH29',N'Đỗ Thành Cường','04567345734',1,'03457234','mailtest@gmail.com')
insert into khachHang values('KH30',N'Nguyễn Trung Anh','08746584588',0,'01561235','nguyentrunganhnta43@gmail.com')


insert into loaixe values ('LX1', 'Wave Alpha', 12000000, N'Wave', N'Xe số')
insert into loaixe values ('LX2', 'Wave SRX', 15000000,N'Wave', N'Xe số')
insert into loaixe values ('LX3', 'Honda Winner X', 25000000,N'Honda',N'Xe côn')
insert into loaixe values ('LX4', 'Yamaha Exciter 155', 40000000,N'Yamaha',N'Xe côn')
insert into loaixe values ('LX5', 'Suzuki Raider R150', 43000000,N'Suzuki',N'Xe côn')
insert into loaixe values ('LX6', 'Yamaha Exciter 150', 41000000,N'Yamaha',N'Xe côn')
insert into loaixe values ('LX7', 'Yamaha Sirius RC', 40000000,N'Yamaha',N'Xe số')
insert into loaixe values ('LX8', 'Cub mini', 15000000,N'Cub',N'Xe số')
insert into loaixe values ('LX9', 'Dream 50cc', 8000000,N'Honda',N'Xe số')
insert into loaixe values ('LX24', 'Dream', 11000000,N'Honda',N'Xe số')
insert into loaixe values ('LX10', 'CBR 150', 41000000,N'Honda',N'Xe côn')
insert into loaixe values ('LX11', 'Angela', 12000000,N'SYM',N'Xe số')
insert into loaixe values ('LX12', 'Grande', 35000000,N'Yamaha',N'Xe ga')
insert into loaixe values ('LX13', 'Janus', 25000000,N'Yamaha',N'Xe ga')
insert into loaixe values ('LX14', 'Lead', 25000000,N'Honda',N'Xe ga')
insert into loaixe values ('LX15', 'Vision', 25000000,N'Honda',N'Xe ga')
insert into loaixe values ('LX16', 'Airblade', 33000000,N'Honda',N'Xe ga')
insert into loaixe values ('LX17', 'Vario', 38000000,N'Honda',N'Xe ga')
insert into loaixe values ('LX18', 'SH Mode', 45000000,N'Honda',N'Xe ga')
insert into loaixe values ('LX19', 'Win', 8000000,N'Honda',N'Xe côn')
insert into loaixe values ('LX20', 'Kawasaki H2R', 1500000000,N'Kawasaki',N'Xe côn')
insert into loaixe values ('LX20', 'Kawasaki Z1000', 350000000,N'Kawasaki',N'Xe côn')
insert into loaixe values ('LX21', 'Moto Guzzi V85 TT Travel', 400000000,N'Guzzi',N'Xe côn')
insert into loaixe values ('LX22', 'Honda CBR1000RR-R Fireblade SP', 850000000,N'Honda',N'Xe côn')
insert into loaixe values ('LX23', 'rebel', 1000000000,N'Honda',N'Xe côn')

insert into ViPham Values (0 ,N'Không Vi Phạm')
insert into ViPham Values (1 ,N'Trả Xe Trước Hạn')
insert into ViPham Values (2 ,N'Trả Xe Quá Hạn')
insert into ViPham Values (3 ,N'Xe hỏng')
insert into ViPham Values (4 ,N'Xe Thiếu Phụ Kiện')
insert into ViPham Values (5 ,N'Mất Xe')
insert into ViPham Values(6, N'Khác')



insert into chiTietXe Values('29H-78.46537','LX1',3,180000,'')
insert into chiTietXe Values('29N-65.75673','LX10',0,500000,'')
insert into chiTietXe Values('27B-82.36783','LX11',1,180000,'')
insert into chiTietXe Values('29O-88.26345','LX12',0,400000,'')
insert into chiTietXe Values('29B-62.38751','LX13',0,300000,'')
insert into chiTietXe Values('30B-87.98745','LX14',1,300000,'')
insert into chiTietXe Values('30B-16.23564','LX15',3,300000,'')
insert into chiTietXe Values('30B-16.23541','LX16',0,350000,'')
insert into chiTietXe Values('22B-98.71237','LX17',0,400000,'')
insert into chiTietXe Values('22H-78.12365','LX18',1,500000,'')
insert into chiTietXe Values('26B-17.28367','LX19',0,150000,'')
insert into chiTietXe Values('29B-56.41562','LX2',0,180000,'')
insert into chiTietXe Values('29N-89.97661','LX20',0,10000000,'')
insert into chiTietXe Values('29N-15.76431','LX21',1,5000000,'')
insert into chiTietXe Values('29B-43.73334','LX22',0,8000000,'')
insert into chiTietXe Values('25F-72.83752','LX23',0,9200000,'')
insert into chiTietXe Values('25B-72.83752','LX24',1,150000,'')
insert into chiTietXe Values('29H-98.76871','LX3',0,250000,'')
insert into chiTietXe Values('31B-72.83752','LX4',0,400000,'')
insert into chiTietXe Values('31H-72.13752','LX5',0,400000,'')
insert into chiTietXe Values('31B-72.84652','LX6',1,400000,'')
insert into chiTietXe Values('31N-72.81252','LX7',0,400000,'')
insert into chiTietXe Values('29C-12.43752','LX8',0,150000,'')
insert into chiTietXe Values('99B-71.24752','LX9',1,120000,'')
insert into chiTietXe Values('83B-14.13752','LX11',0,150000,'')
insert into chiTietXe Values('41F-12.33752','LX1',0,150000,'')
insert into chiTietXe Values('30G-14.25713','LX1',0,150000,'')
insert into chiTietXe Values('29B-91.82737','LX13',1,150000,'')
insert into chiTietXe Values('30K-12.54345','LX14',0,150000,'')
insert into chiTietXe Values('18B-12.34123','LX5',0,400000,'')
insert into chiTietXe Values('19B-11.24155','LX6',0,400000,'')
insert into chiTietXe Values('20C-12.51235','LX6',1,400000,'')
insert into chiTietXe Values('26B-12.56123','LX7',0,400000,'')
insert into chiTietXe Values('29F-75.34612','LX7',0,400000,'')
insert into chiTietXe Values('30B-12.35123','LX15',0,150000,'')
insert into chiTietXe Values('30B-12.34123','LX18',0,500000,'')
insert into chiTietXe Values('31H-11.23413','LX6',2,400000,'')
insert into chiTietXe Values('31C-57.68435','LX1',0,150000,'')
insert into chiTietXe Values('23B-23.57456','LX3',1,280000,'')
insert into chiTietXe Values('23B-12.55679','LX18',0,500000,'')
insert into chiTietXe Values('22F-67.89446','LX14',0,250000,'')
insert into chiTietXe Values('30J-78.95663','LX1',0,150000,'')
insert into chiTietXe Values('33B-78.94352','LX12',1,300000,'')
insert into chiTietXe Values('44B-56.46345','LX2',0,150000,'')
insert into chiTietXe Values('22B-67.52235','LX18',0,500000,'')
insert into chiTietXe Values('29H-12.12123','LX10',0,400000,'')
insert into chiTietXe Values('30B-34.62412','LX10',2,400000,'')
insert into chiTietXe Values('37B-24.35123','LX16',0,300000,'')
insert into chiTietXe Values('30B-66.35123','LX16',0,300000,'')
insert into chiTietXe Values('30B-45.35123','LX15',3,300000,'')
insert into chiTietXe Values('22B-67.34245','LX18',0,500000,'')
insert into chiTietXe Values('29H-12.16823','LX10',0,150000,'')
insert into chiTietXe Values('30B-34.56734','LX18',0,500000,'')
insert into chiTietXe Values('37B-24.88567','LX16',0,150000,'')
insert into chiTietXe Values('30B-66.23151','LX16',0,150000,'')

select * from chiTietXe where tinhTrangXe = 3
insert into phieuBaoDuong values('PBD1','29H-78.46537','2022-12-06','2022-12-13',200000,N'Thay dầu và Thay Máy Phát Điện')
insert into phieuBaoDuong values('PBD2','30B-16.23564','2022-11-30','2022-12-14',300000,N'Động cơ bị bỏ máy')
insert into phieuBaoDuong values('PBD3','30B-45.35123','2022-12-01','2022-12-13',200000,N'Hao hụt nhiên liệu, Thay Lại Bộ Nối')

insert into hopDong Values('HD1','NV1','KH21','2022-11-30','2022-12-15',1,'')
insert into hopDong Values('HD2','NV2','KH11','2022-11-20','2022-12-15',1,'')
insert into hopDong Values('HD3','NV1','KH6','2022-11-10','2022-12-15',1,'')
insert into hopDong Values('HD4','NV3','KH2','2022-11-12','2022-12-15',1,'')
insert into hopDong Values('HD5','NV2','KH30','2022-11-11','2022-12-15',1,'')
insert into hopDong Values('HD6','NV1','KH10','2022-11-13','2022-12-15',1,'')
insert into hopDong Values('HD7','NV7','KH17','2022-11-11','2022-11-15',1,'')
insert into hopDong Values('HD8','NV4','KH29','2022-11-30','2022-12-15',1,'')
insert into hopDong Values('HD9','NV5','KH22','2022-11-27','2022-12-15',1,'')
insert into hopDong Values('HD10','NV1','KH13','2022-11-23','2022-12-15',1,'')
insert into hopDong Values('HD11','NV6','KH4','2022-11-25','2022-11-26',1,'')
insert into hopDong Values('HD12','NV5','KH5','2022-11-27','2022-11-29',1,'')
insert into hopDong Values('HD13','NV2','KH16','2022-11-23','2022-11-25',1,'')
insert into hopDong Values('HD14','NV7','KH9','2022-11-25','2022-11-27',1,'')
select * from chiTietXe where tinhTrangXe = 0;
select * from hopDong
select * from chiTietHopDong
delete hopDong
delete chiTietHopDong




insert into chiTietHopDong values('HD1','20C-12.51235',4000000)
insert into chiTietHopDong values('HD2','22H-78.12365',5000000)
insert into chiTietHopDong values('HD3','23B-23.57456',2800000)
insert into chiTietHopDong values('HD4','25B-72.83752',1500000)
insert into chiTietHopDong values('HD5','27B-82.36783',1800000)
insert into chiTietHopDong values('HD6','29B-91.82737',1500000)
insert into chiTietHopDong values('HD7','29N-15.76431',5000000)
insert into chiTietHopDong values('HD8','30B-87.98745',3000000)
insert into chiTietHopDong values('HD9','31B-72.84652',4000000)
insert into chiTietHopDong values('HD10','33B-78.94352',3000000)
insert into chiTietHopDong values('HD11','99B-71.24752',1200000)

insert into chiTietHopDong values('HD12','18B-12.34123',4000000)
insert into chiTietHopDong values('HD13','22B-67.34245',5000000)
insert into chiTietHopDong values('HD14','26B-12.56123',4000000)

insert into hoaDonTraXe values('HDT1','HD12','2022-11-29',0,0,800000,'','')
insert into hoaDonTraXe values('HDT2','HD13','2022-11-25',0,0,1000000,'','')
insert into hoaDonTraXe values('HDT3','HD14','2022-11-27',0,0,800000,'','')
