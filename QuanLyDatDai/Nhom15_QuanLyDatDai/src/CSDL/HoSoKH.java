package CSDL;

public class HoSoKH {
    String MaKH,TenKH,NgaySinh,GioiTinh,CCCD,DanToc,DiaChiTT;

    public HoSoKH() {
    }

    public HoSoKH(String MaKH, String TenKH, String NgaySinh, String GioiTinh, String CCCD, String DanToc, String DiaChiTT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.CCCD = CCCD;
        this.DanToc = DanToc;
        this.DiaChiTT = DiaChiTT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDanToc() {
        return DanToc;
    }

    public void setDanToc(String DanToc) {
        this.DanToc = DanToc;
    }

    public String getDiaChiTT() {
        return DiaChiTT;
    }

    public void setDiaChiTT(String DiaChiTT) {
        this.DiaChiTT = DiaChiTT;
    }
    
}
