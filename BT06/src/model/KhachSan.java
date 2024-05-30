package model;

public class KhachSan extends Nguoi {

    private int soNgayThue;
    private String loaiPhong;
    private double giaPhong;

    public KhachSan(int soNgayThue, String loaiPhong, String ten, String soCMND, int tuoi) {
        super(ten, soCMND, tuoi);
        this.soNgayThue = soNgayThue;
        this.loaiPhong = loaiPhong;
        this.giaPhong = tienPhong();
    }

    private double tienPhong() {
        if (loaiPhong.equalsIgnoreCase("A")) {
            return 500 * soNgayThue;
        } else if (loaiPhong.equalsIgnoreCase("B")) {
            return 300 * soNgayThue;
        } else if (loaiPhong.equalsIgnoreCase("C")){
            return 100 * soNgayThue;
        } else {
            return -1;
        }
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    @Override
    public String toString() {
        return ten + " - Số CMND: " + soCMND + " - Tuổi: " + tuoi + " - Loại phòng thuê: " + loaiPhong + " - Số ngày thuê: " + soNgayThue;
    }

}
