CREATE DATABASE quanlydatdai;

USE quanlydatdai;

CREATE TABLE hosodat(
    MaHS VARCHAR(10) PRIMARY KEY,
    MaKH varchar(10),
    ToBanDo varchar(10),
    Thua varchar(10),
    DienTich float,
    DiaChiDat varchar(100)
);

CREATE TABLE hosokh (
    MaKH varchar(10) PRIMARY KEY,
    TenKH VARCHAR(50),
    NgaySinh varchar(15),
    GioiTinh varchar(5),
    CCCD varchar(15),
    DanToc varchar(20),
    DiaChiTT VARCHAR(100)
);

CREATE TABLE taikhoan (
    MaTK varchar(10) PRIMARY KEY,
    TenTK varchar(50),
    MaKH varchar(10),
    MatKhau VARCHAR(50),
    DoiTuong VARCHAR(20)
);
SELECT *
FROM hosodat
INNER JOIN hosokh ON hosodat.MaKH = hosokh.MaKH
INNER JOIN taikhoan ON hosokh.MaKH = taikhoan.MaKH;
