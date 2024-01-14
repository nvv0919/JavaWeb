/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSDL;

public class HoSoDat {
    String MaHS,MaKH,ToBanDo,Thua,DiaChiDat,NgayMua;
    float DienTich;

    public HoSoDat() {
    }

    public HoSoDat(String MaHS, String MaKH, String ToBanDo, String Thua, String DiaChiDat, String NgayMua, float DienTich) {
        this.MaHS = MaHS;
        this.MaKH = MaKH;
        this.ToBanDo = ToBanDo;
        this.Thua = Thua;
        this.DiaChiDat = DiaChiDat;
        this.NgayMua = NgayMua;
        this.DienTich = DienTich;
    }

    public String getMaHS() {
        return MaHS;
    }

    public void setMaHS(String MaHS) {
        this.MaHS = MaHS;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getToBanDo() {
        return ToBanDo;
    }

    public void setToBanDo(String ToBanDo) {
        this.ToBanDo = ToBanDo;
    }

    public String getThua() {
        return Thua;
    }

    public void setThua(String Thua) {
        this.Thua = Thua;
    }

    public String getDiaChiDat() {
        return DiaChiDat;
    }

    public void setDiaChiDat(String DiaChiDat) {
        this.DiaChiDat = DiaChiDat;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(String NgayMua) {
        this.NgayMua = NgayMua;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float DienTich) {
        this.DienTich = DienTich;
    }

    public void remove(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean contains(String MaHS) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
