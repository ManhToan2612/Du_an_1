package com.example.du_an_1.model;

public class DonHang {
    private int maDonHang;
    private String maAD;
    private String hoTen;
    private String ngayDatHang;
    private int tongTien;
    private String trangthai;

    public DonHang() {
    }

    public DonHang(String maAD, String hoTen, String ngayDatHang, int tongTien, String trangthai) {
        this.maAD = maAD;
        this.hoTen = hoTen;
        this.ngayDatHang = ngayDatHang;
        this.tongTien = tongTien;
        this.trangthai = trangthai;
    }

    public DonHang(int maDonHang, String maAD, String hoTen, String ngayDatHang, int tongTien, String trangthai) {
        this.maDonHang = maDonHang;
        this.maAD = maAD;
        this.hoTen = hoTen;
        this.ngayDatHang = ngayDatHang;
        this.tongTien = tongTien;
        this.trangthai = trangthai;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaAD() {
        return maAD;
    }

    public void setMaAD(String maAD) {
        this.maAD = maAD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
