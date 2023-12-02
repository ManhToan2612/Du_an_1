package com.example.du_an_1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "QLG";
    private static final int DbVersion = 3;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME,null, DbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tao bang Admin
        String  tb_Admin = ("CREATE TABLE Admin (" +
                "maAD TEXT PRIMARY KEY, " +
                "hoTen TEXT NOT NULL, " +
                "matKhau TEXT NOT NULL," +
                "loaiTK TEXT NOT NULL," +
                "anh TEXT)");
        db.execSQL(tb_Admin);

        // Bang loai giay
        String tb_LoaiGiay= "CREATE TABLE LoaiGiay(" +
                "maLoai INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenLoai TEXT NOT NULL)";
        db.execSQL(tb_LoaiGiay);

        // Bang don hang
        String tb_donHang= "CREATE TABLE DonHang(" +
                "maDonHang INTEGER PRIMARY KEY AUTOINCREMENT," +
                "maAD TEXT REFERENCES Admin(maAD)," +
                "ngayDatHang TEXT NOT NULL," +
                "tongTien INTEGER NOT NULL)";
        db.execSQL(tb_donHang);

        // Bang giay
        String tb_Giay= "CREATE TABLE Giay(" +
                "maGiay INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenGiay TEXT NOT NULL," +
                "giaTien INTEGER NOT NULL," +
                "maLoai INTEGER REFERENCES LoaiGiay(maLoai))";
        db.execSQL(tb_Giay);

        // Bảng giỏ hàng
        String tb_gioHang = "CREATE TABLE GioHang(" +
                "maGioHang integer primary key autoincrement, " +
                "maAD integer REFERENCES Admin(maAD)," +
                "maGiay integer REFERENCES Giay(maGiay)," +
                "soLuong integer not null)";
        db.execSQL(tb_gioHang);

        // Bang hoa don
        String tb_HoaDon= "CREATE TABLE HoaDon(" +
                "maHD INTEGER PRIMARY KEY AUTOINCREMENT," +
                "maGiay INTEGER REFERENCES Giay(maGiay)," +
                "tenGiay TEXT REFERENCES Giay(tenGiay)," +
                "soLuong INTEGER NOT NULL," +
                "giaTien INTEGER NOT NULL," +
                "ngay TEXT NOT NULL)";
        db.execSQL(tb_HoaDon);

        //. Bảng chi tiết đơn hàng
        String chiTietDonHang = "CREATE TABLE ChiTietDonHang(" +
                "maChiTietDonHang INTEGER PRIMARY KEY AUTOINCREMENT," +
                "maDonHang INTEGER REFERENCES DonHang(maDonHang)," +
                "maGiay INTEGER REFERENCES Giay(maGiay)," +
                "soLuong INTEGER NOT NULL," +
                "donGia INTEGER NOT NULL," +
                "thanhTien INTEGER NOT NULL)";
        db.execSQL(chiTietDonHang);

        db.execSQL("INSERT INTO ChiTietDonHang VALUES(1,2,1,5,20,20)");

        //insert date
        db.execSQL("INSERT INTO Admin VALUES ('admin1','Nguyễn Văn Admin','admin', 'admin','https://www.google.com/imgres?imgurl=https%3A%2F%2Fps.w.org%2Fuser-avatar-reloaded%2Fassets%2Ficon-256x256.png%3Frev%3D2540745&tbnid=4tCxPvBodOnWbM&vet=12ahUKEwin0prGtPCCAxUvavUHHQnwDoIQMygAegQIARBT..i&imgrefurl=https%3A%2F%2Ffa.wordpress.org%2Fplugins%2Fuser-avatar-reloaded%2F&docid=7XY1G-DhNW4M4M&w=257&h=257&q=avt%20user&ved=2ahUKEwin0prGtPCCAxUvavUHHQnwDoIQMygAegQIARBT')," +
                "('admin12','Nguyễn Văn Admin','admin12', 'khachhang','https://www.google.com/imgres?imgurl=https%3A%2F%2Fps.w.org%2Fuser-avatar-reloaded%2Fassets%2Ficon-256x256.png%3Frev%3D2540745&tbnid=4tCxPvBodOnWbM&vet=12ahUKEwin0prGtPCCAxUvavUHHQnwDoIQMygAegQIARBT..i&imgrefurl=https%3A%2F%2Ffa.wordpress.org%2Fplugins%2Fuser-avatar-reloaded%2F&docid=7XY1G-DhNW4M4M&w=257&h=257&q=avt%20user&ved=2ahUKEwin0prGtPCCAxUvavUHHQnwDoIQMygAegQIARBT'), " +
                "('khachhang1','Nguyen Văn A ','123456', 'admin','https://www.google.com/imgres?imgurl=https%3A%2F%2Fps.w.org%2Fuser-avatar-reloaded%2Fassets%2Ficon-256x256.png%3Frev%3D2540745&tbnid=4tCxPvBodOnWbM&vet=12ahUKEwin0prGtPCCAxUvavUHHQnwDoIQMygAegQIARBT..i&imgrefurl=https%3A%2F%2Ffa.wordpress.org%2Fplugins%2Fuser-avatar-reloaded%2F&docid=7XY1G-DhNW4M4M&w=257&h=257&q=avt%20user&ved=2ahUKEwin0prGtPCCAxUvavUHHQnwDoIQMygAegQIARBT')");

        db.execSQL("INSERT INTO LoaiGiay VALUES ('1', 'xxx')," +
                "('2', 'lll')," +
                "('3', 'dfa')");

        db.execSQL("INSERT INTO DonHang VALUES(1, 'khachhang1', '11/01/2023', 2000)," +
                "(2, 'khachhang1', '11/02/2023', 2000)," +
                "(3, 'khachhang1', '11/03/2023', 2000)");

        db.execSQL("INSERT INTO Giay VALUES (1, 'Giay bong da', '30000', '1')," +
                "(2, 'Giay', '40000', '2')," +
                "(3, 'Giay thoi trang', '54444', '3')");

        db.execSQL("INSERT INTO HoaDon VALUES(1, 1, 'Giay bong da',  2, 1231413, '23')," +
                "(2, 2, 'Giay',  1, 231221, '12')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("drop table if exists Admin");
            db.execSQL("drop table if exists HoaDon");
            db.execSQL("drop table if exists GioHang");
            db.execSQL("drop table if exists ChiTietDonHang");
            db.execSQL("drop table if exists DonHang");
            db.execSQL("drop table if exists Giay");
            db.execSQL("drop table if exists LoaiGiay");

            onCreate(db);
        }

    }
}
