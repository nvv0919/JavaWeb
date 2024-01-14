/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSDL;

/**
 *
 * @author ngvie
 */
public class TaiKhoan {
    String MaTK,TenTK,MaKH,MatKhau,DoiTuong;

    public TaiKhoan() {
    }

    public TaiKhoan(String MaTK, String TenTK, String MaKH, String MatKhau, String DoiTuong) {
        this.MaTK = MaTK;
        this.TenTK = TenTK;
        this.MaKH = MaKH;
        this.MatKhau = MatKhau;
        this.DoiTuong = DoiTuong;
    }


    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhauString) {
        this.MatKhau = MatKhauString;
    }

    public String getDoiTuong() {
        return DoiTuong;
    }

    public void setDoiTuong(String DoiTuong) {
        this.DoiTuong = DoiTuong;
    }
    
}
