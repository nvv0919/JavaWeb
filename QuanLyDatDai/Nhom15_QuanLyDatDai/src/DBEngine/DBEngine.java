package DBEngine;

import CSDL.HoSoDat;
import CSDL.HoSoKH;
import CSDL.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBEngine {
    static Connection con;
    
    public static void getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydatdai?useSSL=false","root","123456");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }  
    public static ArrayList<HoSoKH> getHoSoKH() throws SQLException{
        getConnection();
        ArrayList<HoSoKH> HoSoKHList = new ArrayList<HoSoKH>();
        
        Statement stm = con.createStatement();
        String sql = "select * from hosokh";
        ResultSet res = stm.executeQuery(sql);
        
        while(res.next()){
            String MaKH = res.getString("MaKH");
            String TenKH = res.getString("TenKH");
            String NgaySinh = res.getString("NgaySinh");
            String GioiTinh = res.getString("GioiTinh");
            String CCCD = res.getString("CCCD");
            String DanToc = res.getString("DanToc");
            String DiaChiTT = res.getString("DiaChiTT");

            HoSoKH hoSoKH = new HoSoKH(MaKH, TenKH, NgaySinh, GioiTinh, CCCD, DanToc, DiaChiTT);
            HoSoKHList.add(hoSoKH);
        }
        return  HoSoKHList;
    }
    public static ArrayList<HoSoDat> getHoSoDat(){
        ArrayList<HoSoDat> HoSoDatList = new ArrayList<>();
        String sql = "SELECT * FROM hosodat";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                HoSoDat hs = new HoSoDat();
                hs.setMaHS(rs.getString("MaHS"));
                hs.setMaKH(rs.getString("MaKH"));
                hs.setToBanDo(rs.getString("ToBanDo"));
                hs.setThua(rs.getString("Thua"));
                hs.setDienTich(rs.getFloat("DienTich"));
                hs.setDiaChiDat(rs.getString("DiaChiDat"));
                hs.setNgayMua(rs.getString("NgayMua"));
                HoSoDatList.add(hs);
            }
        } catch (SQLException e) {
        }
        return HoSoDatList;
    }
    public static ArrayList<HoSoDat> getHoSoDat(String makhString) throws SQLException {
        getConnection();
        ArrayList<HoSoDat> HoSoDatList = new ArrayList<>();

        String sql = "SELECT * FROM hosodat WHERE MaKH = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, makhString);
        ResultSet res = stm.executeQuery();

        while (res.next()) {
            String MaHS = res.getString("MaHS");
            String MaKH = res.getString(makhString);
            String ToBanDo = res.getString("ToBanDo");
            String Thua = res.getString("Thua");
            float DienTich = res.getFloat("DienTich");
            String DiaChiDat = res.getString("DiaChiDat");
            String NgayMua = res.getString("NgayMua");

            HoSoDat hosodat = new HoSoDat(MaHS, MaKH, ToBanDo, Thua, DiaChiDat, NgayMua, DienTich);
            HoSoDatList.add(hosodat);
        }
        return HoSoDatList;
    } 
    
    public static ArrayList<HoSoKH> getHoSoKH(String makhString) throws SQLException {
        getConnection();
        ArrayList<HoSoKH> HoSoKHList = new ArrayList<HoSoKH>();

        String sql = "SELECT * FROM hosokh WHERE MaKH = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, makhString);
        ResultSet res = stm.executeQuery();

        while (res.next()) {
            String MaKH = res.getString("MaKH");
            String TenKH = res.getString("TenKH");
            String NgaySinh = res.getString("NgaySinh");
            String GioiTinh = res.getString("GioiTinh");
            String CCCD = res.getString("CCCD");
            String DanToc = res.getString("DanToc");
            String DiaChiTT = res.getString("DiaChiTT");

            HoSoKH hoSoKH = new HoSoKH(MaKH, TenKH, NgaySinh, GioiTinh, CCCD, DanToc, DiaChiTT);
            HoSoKHList.add(hoSoKH);
        }
        return HoSoKHList;
    }
    public static ArrayList<TaiKhoan> getCustomer() throws SQLException{
        getConnection();
        ArrayList<TaiKhoan> TaiKhoanList = new ArrayList<>();
        
        Statement stm = con.createStatement();
        String sql = "select * from Customer";
        ResultSet res = stm.executeQuery(sql);
        
        while(res.next()){
            String MaTK = res.getString("MaTK");
            String TenTK = res.getString("TenTK");
            String MaKH = res.getString("MaKH");
            String MaKhau = res.getString("MatKhau");
            String DoiTuong = res.getString("DoiTuong");
            
            TaiKhoan cus = new TaiKhoan(MaTK, TenTK, MaKH, MaKhau, DoiTuong);
            TaiKhoanList.add(cus);
        }
        
        return TaiKhoanList;
    }
    
    public static boolean login(String name,String pass) throws SQLException{
        getConnection();
        
        PreparedStatement pst = con.prepareStatement("select * from taikhoan where TenTK=? and MatKhau=?");
        
        pst.setString(1, name);
        pst.setString(2, pass);
        ResultSet res = pst.executeQuery();
        
        return res.next();
    }
    public static boolean ScreenView(String makh) throws SQLException{
        getConnection();
        
        PreparedStatement pst = con.prepareStatement("select * from hosokh where MaKH=?");
        
        pst.setString(1, makh);
        ResultSet res = pst.executeQuery();
        
        return res.next();
    }

    public static ResultSet ThucThiCauLenhSelect(String CauLenhSQL) {
        try {
            Statement stm = con.prepareStatement(CauLenhSQL);
            return stm.executeQuery(CauLenhSQL);
        } catch (SQLException e) {
            System.out.println("----Loi Thuc Hien Truy Van SQL----");
            System.out.println("Loi Chi Tiet : " + e.getMessage());
        }
        return null;
    }

    public static boolean hienthibang(String makh) throws SQLException {
        getConnection();

        PreparedStatement pst = con.prepareStatement("select * from hosodat where MaKH=?");

        pst.setString(1, makh);

        ResultSet res = pst.executeQuery();

        return res.next();
    } 
    public static boolean checkExit(String tblName, String code) throws SQLException{
        getConnection();
        
        PreparedStatement pst = con.prepareStatement("select * from "+tblName+ " where "+tblName+"Code"+"=?");
        
        pst.setString(1,code);

        
        ResultSet res = pst.executeQuery();
        
        return res.next();
    }
    public boolean addHosodat(HoSoDat x,String MaKH){
        
        String sql = "insert into hosodat(MaHS, MaKH, ToBanDo, Thua, DienTich, DiaChiDat, NgayMua) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, x.getMaHS());
            ps.setString(2, MaKH);            
            ps.setString(3,x.getToBanDo());
            ps.setString(4, x.getThua());
            ps.setFloat(5, x.getDienTich());
            ps.setString(6, x.getDiaChiDat());
            ps.setString(7, x.getNgayMua());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
    
}
