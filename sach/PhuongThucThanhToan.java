package sach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhuongThucThanhToan implements DanhSach {
    public Scanner sc = new Scanner(System.in);
    private String loaiPhuongThuc;
    private Date ngayThanhToan;
    private String maDonHang;
    // Thuộc tính
    public PhuongThucThanhToan(String loaiPhuongThuc, Date ngaySuDung) {
        this.loaiPhuongThuc = loaiPhuongThuc;
        this.ngayThanhToan = ngaySuDung;
    }

    public PhuongThucThanhToan() {
        // Default constructor
    }

    // Getter and Setter methods

    public String getLoaiPhuongThuc() {
        return loaiPhuongThuc;
    }

    public void setLoaiPhuongThuc(String loaiPhuongThuc) {
        this.loaiPhuongThuc = loaiPhuongThuc;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngaySuDung) {
        this.ngayThanhToan = ngaySuDung;
    }
    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    // ... Các phần còn lại không thay đổi ...

    // Các phương thức nhập và xuất
    public void Nhap() {
        // Nhập loại phương thức
        while (true) {
            System.out.print("Nhap loai phuong thuc thanh toan (khuyen nghi tien mat/tra the): ");
            this.loaiPhuongThuc = sc.nextLine();
    
            if (kiemTraLoaiPhuongThuc()) {
                break; // Loai phuong thuc da duoc nhap, thoat khoi vong lap
            } else {
                System.out.println("Loai phuong thuc thanh toan khong hop le. Vui long nhap lai.");
            }
        }
    
        // Nhập ngày thanh toán
        while (true) {
            System.out.print("Nhap ngay thanh toan (dd/MM/yyyy): ");
            String strNgayThanhToan = sc.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // check ngay thang nam
                this.ngayThanhToan = dateFormat.parse(strNgayThanhToan);
                break; // Ngay dat hop le, thoat khoi vong lap
            } catch (ParseException e) {
                System.out.println("Ngay dat khong hop le. Vui long nhap theo dinh dang dd/MM/yyyy.");
            }
        }
    }
    
    private boolean kiemTraLoaiPhuongThuc() {
        // Kiểm tra xem loại phương thức chỉ chứa chữ cái và dấu cách không chứa số
        return this.loaiPhuongThuc.matches("[a-zA-Z\\s]+");
    }
    
    public void SuaThongTin() {
        while (true) {
            System.out.println("1. Sua loai phuong thuc thanh toan");
            System.out.println("2. Sua ngay thanh toan");
            System.out.println("3. Thoat");
    
            System.out.print("Nhap lua chon: ");
            int luaChon = Integer.parseInt(sc.nextLine());
    
            switch (luaChon) {
                case 1:
                    // Sua loai phuong thuc thanh toan
                    System.out.print("Nhap loai phuong thuc thanh toan moi: ");
                    this.loaiPhuongThuc = sc.nextLine();
                    break;
                case 2:
                    // Sua ngay thanh toan
                    while (true) {
                        System.out.print("Nhap ngay thanh toan moi (dd/MM/yyyy): ");
                        String strNgayThanhToan = sc.nextLine();
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            dateFormat.setLenient(false);
                            this.ngayThanhToan = dateFormat.parse(strNgayThanhToan);
                            break;
                        } catch (ParseException e) {
                            System.out.println("Ngay thanh toan khong hop le. Vui long nhap theo dinh dang dd/MM/yyyy.");
                        }
                    }
                    break;
                case 3:
                    // Thoat khỏi phuong thuc
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        }
    }

    public String Xuat() {
        return String.format("Phuong thuc thanh toan: %-15s | Ngay thanh toan: %tD |", loaiPhuongThuc, ngayThanhToan);
    }
}

