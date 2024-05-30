package test;

import java.util.ArrayList;
import java.util.Scanner;
import model.KhachSan;

public class Main {

    public static void main(String[] args) {
        ArrayList<KhachSan> listKhach = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("____MENU____");
            System.out.println("1. Thêm thông tin khách.");
            System.out.println("2. Xóa thông tin khách.");
            System.out.println("3. In thông tin khách hàng.");
            System.out.println("4. Tính tiền thuê phòng.");
            System.out.println("0. Thoát!!!");
            System.out.println("Nhập vào lựa chọn của bạn!!!");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addKhach(listKhach, sc);
                    break;
                case 2:
                    removeKhach(listKhach, sc);
                    break;
                case 3:
                    printKhach(listKhach, sc);
                    break;
                case 4:
                    tienThue(listKhach, sc);
                    break;
                case 0:
                    System.out.println("Bạn đã thoát khỏi menu!!!");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ!!!");
                    break;
            }

        } while (choice != 0);
    }

    public static void addKhach(ArrayList<KhachSan> listKhach, Scanner sc) {
        System.out.println("NHẬP THÔNG TIN KHÁCH THUÊ");

        System.out.print("Họ và Tên: ");
        String ten = sc.nextLine();
        System.out.print("Số CMND: ");
        String soCMND = sc.nextLine();
        for (KhachSan i : listKhach){
            if(i.getSoCMND().equalsIgnoreCase(soCMND)){
                System.out.println("Số CMND đã tồn tại!!!");
                return;
            }
        }
        int tuoi;
        while (true) {
            System.out.print("Tuổi: ");
            if (sc.hasNextInt()) {
                tuoi = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Vui lòng nhập một số nguyên!!!");
                sc.nextLine();
            }
        }
        int soNgayThue;
        while (true) {
            System.out.print("Số ngày thuê: ");
            if (sc.hasNextInt()) {
                soNgayThue = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Vui lòng nhập một số nguyên!!!");
                sc.nextLine();
            }
        }
        System.out.print("Loại phòng thuê (A/B/C): ");
        String loaiPhong = sc.nextLine();

        listKhach.add(new KhachSan(soNgayThue, loaiPhong, ten, soCMND, tuoi));
        System.out.println("THÔNG TIN CỦA KHÁCH THUÊ ĐƯỢC THÊM VÀO THÀNH CÔNG!!!");
    }

    public static void removeKhach(ArrayList<KhachSan> listKhach, Scanner sc) {
        System.out.print("NHẬP SỐ CHỨNG MINH NHÂN DÂN CỦA KHÁCH CẦN XÓA: ");
        String soCMND = sc.nextLine();
        boolean find = false;
        for (KhachSan i : listKhach) {
            if (i.getSoCMND().equals(soCMND)) {
                listKhach.remove(i);
                find = true;
                System.out.println("KHÁCH HÀNG CÓ SỐ CMND " + soCMND + " ĐÃ ĐƯỢC XÓA KHỎI DANH SÁCH THÀNH CÔNG!!!");
                break;
            }
            if (find != true) {
                System.out.println("KHÔNG TÌM THẤY KHÁCH HÀNG CÓ SỐ CMND: " + soCMND);
                System.out.println("BẠN VUI LÒNG KIỂM TRA LẠI THÔNG TIN!!!");
                sc.nextLine();
            }
        }
    }

    public static void printKhach(ArrayList<KhachSan> listKhach, Scanner sc) {
        int choice;
        do {
            System.out.println("LỰA CHỌN THÔNG TIN KHÁCH CẦN IN");
            System.out.println("1. In toàn bộ thông tin của khách thuê phòng.");
            System.out.println("2. In thông tin khách thuê loại phòng A.");
            System.out.println("3. In thông tin khách thuê loại phòng B.");
            System.out.println("4. In thông tin khách thuê loại phòng C.");
            System.out.println("0. Thoát!!!");
            System.out.println("Nhập vào lựa chọn của bạn!!!");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Thông tin toàn bộ khách thuê phòng: ");
                    for (KhachSan i : listKhach) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    System.out.println("Thông tin khách thuê loại phòng A: ");
                    for (KhachSan i : listKhach) {
                        if (i.getLoaiPhong().equalsIgnoreCase("A")) {
                            System.out.println(i);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thông tin khách thuê loại phòng B: ");
                    for (KhachSan i : listKhach) {
                        if (i.getLoaiPhong().equalsIgnoreCase("B")) {
                            System.out.println(i);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thông tin khách thuê loại phòng C: ");
                    for (KhachSan i : listKhach) {
                        if (i.getLoaiPhong().equalsIgnoreCase("C")) {
                            System.out.println(i);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoát!!!");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ!!!");
                    break;
            }
        } while (choice != 0);
    }
    
    public static void tienThue(ArrayList<KhachSan> listKhach, Scanner sc){
        System.out.print("NHẬP SỐ CMND CỦA KHÁCH CẦN TÍNH TIỀN THUÊ PHÒNG: ");
        String soCMND = sc.nextLine();
        boolean find = false;
        
        for(KhachSan i : listKhach){
            if(i.getSoCMND().equals(soCMND)){
                find = true;
                System.out.println("Khách có số CMND: " + soCMND + " thuê loại phòng " + i.getLoaiPhong() + " với số ngày thuê là " + i.getSoNgayThue() + " ngày. Tổng tiền thuê phòng là: " + i.getGiaPhong() + "$");               
                break;
            } 
            if(find != true) {
                System.out.println("Không tìm thấy khách có số CMND là: " + soCMND);
                sc.nextLine();
            }
        }
    }

}
