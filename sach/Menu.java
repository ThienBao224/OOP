package sach;
// import com.example.otherpackage.*;


import java.util.*;

public class Menu {

    public static void main(String[] args) {
        Menu menu = new Menu();
//        menu.QLBanHang();
//        menu.QLThuNgan();
//        menu.QLBaoVe();
//        menu.adminCustomerMenu();
//        menu.QLNhanVien();
        menu.run();
//        menu.QLDonHang();
        menu.adminMenu();
    }
    Scanner sc = new Scanner(System.in);

    public Menu() {
    }

    public void run() {
        adminMenu();
    }

    public void QLThuNgan() {
        if (danhsachThuNgan.getThuNgan() == null) {
            System.out.println("Quản lý nhân viên thu ngân: ");
            System.out.println("1.Nhập nhân viên");
            System.out.println("2.Thoát");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1: {
                    System.out.println("1: Nhập từ bàn phím");
                    System.out.println("2. Nhập bằng file");
                    System.out.println("3.Thoát");
                    System.out.print("Nhập lựa chọn: ");

                    int a = Integer.parseInt(sc.nextLine());

                    switch (a) {
                        case 1:
                            danhsachThuNgan.NhapDanhSach();
                            break;	
                        case 2:
                            danhsachThuNgan.DocFile("D:\\OOP\\DOAN\\src\\sach\\ThuNgan_doc.txt");

                        default:
                            QLThuNgan();
                            break;
                    }
                }

            }
        } else {
            System.out.println("+ --------------------------------------+");
            System.out.println("|              Quản lý Thu Ngân         |");
            System.out.println("+ --------------------------------------+");
            System.out.println("| 1. Thêm nhân viên thu ngân            |");
            System.out.println("| 2. Sửa nhân viên thu ngân             |");
            System.out.println("| 3. Xoa nhân viên thu ngân             |");
            System.out.println("| 4. Sắp xếp nhân viên thu ngân theo mã |");
            System.out.println("| 5. Sắp xếp nhân viên thu ngân theo tên|");
            System.out.println("| 6. Tìm kiếm nhân viên thu ngân        |");
            System.out.println("| 7. Khôi phục nhân viên thu ngân đã xóa|");
            System.out.println("| 8. Ghi file nhân viên thu ngân        |");
            System.out.println("| 0. Thoát                              |");
            System.out.println("+-------------------------------------- +");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1:
                    danhsachThuNgan.Them_ThuNgan();
                    break;
                case 2:
                    danhsachThuNgan.Sua_ThuNgan();
                    break;
                case 3:
                    danhsachThuNgan.Xoa_ThuNgan();
                    break;

                case 4:
                    danhsachThuNgan.SapXep_TheoMa();
                    break;
                case 5:
                    danhsachThuNgan.SapXep_TheoTen();
                    break;
                case 6:
                    danhsachThuNgan.TimKiem_ThuNgan();
                    break;
                case 7:
                    danhsachThuNgan.KhoiPhuc_ThuNgan();
                    break;
                case 8:
                    danhsachThuNgan.GhiFile("All FilesThuNgan_ghi.txt");
                    break;
                case 0:
                    QLNhanVien();
                    break;

                default:
                    return;
            }
        }
    }

    public void QLBanHang() {
        if (danhsachBanHang.getBanHang() == null) {
            System.out.println("Nhập nhân viên bán hàng: ");
            System.out.println("1.Nhập nhân viên");
            System.out.println("2.Thoát");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1 -> {
                    System.out.println("1: Nhập từ bàn phím");
                    System.out.println("2. Nhập bằng file");
                    System.out.println("3.Thoát");
                    System.out.print("Nhập lựa chọn: ");

                    int a = Integer.parseInt(sc.nextLine());

                    switch (a) {
                        case 1:
                            danhsachBanHang.NhapDanhSach();
                            break;
                        case 2:
                            danhsachBanHang.DocFile("D:\\OOP\\DOAN\\src\\sach\\BanHang_doc.txt");

                        default:
                            QLBanHang();
                            break;
                    }
                }
                default -> {
                    adminMenu();
                    break;
                }

            }
        } else {
            System.out.println("+ --------------------------------------+");
            System.out.println("|              Quản lý Bán Hàng         |");
            System.out.println("+ --------------------------------------+");
            System.out.println("| 1. Thêm nhân viên bán hàng            |");
            System.out.println("| 2. Sửa nhân viên bán hàng             |");
            System.out.println("| 3. Xoa nhân viên bán hàng             |");
            System.out.println("| 4. Sắp xếp nhân viên bán hàng theo tên|");
            System.out.println("| 5. Sắp xếp nhân viên bán hàng theo mã |");
            System.out.println("| 6. Khôi phục nhân viên bán hàng       |");
            System.out.println("| 7. Tìm kiếm nhân viên bán hàng đã xóa |");
            System.out.println("| 8. Ghi file nhân viên bán hàng        |");
            System.out.println("| 0. Thoát                              |");
            System.out.println("+-------------------------------------- +");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1:
                    danhsachBanHang.Them_BanHang();
                    break;
                case 2:
                    danhsachBanHang.Sua_BanHang();
                    break;
                case 3:
                    danhsachBanHang.Xoa_BanHang();
                    break;

                case 4:
                    danhsachBanHang.Sapxep_TheoTen();
                    break;
                case 5:
                    danhsachBanHang.Sapxep_TheoMa();
                    break;
                case 6:
                    danhsachBanHang.KhoiPhuc_BanHang();
                    break;
                case 7:
                    danhsachBanHang.TimKiem_BanHang();
                    break;
                case 8:
                    danhsachBanHang.GhiFile("D:\\OOP\\DOAN\\src\\sach\\BanHang_ghi.txt");

                case 0:
                    QLBanHang();
                    break;
                default:
                    break;
            }
        }
    }

    public void QLBaoVe() {
        if (danhsachBaoVe.getBaoVe() == null) {
            System.out.println("Nhập nhân viên bảo vệ: ");
            System.out.println("1.Nhập nhân viên");
            System.out.println("2.Thoát");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1 -> {
                    System.out.println("1: Nhập từ bàn phím");
                    System.out.println("2. Nhập bằng file");
                    System.out.println("3.Thoát");
                    System.out.print("Nhập lựa chọn: ");

                    int a = Integer.parseInt(sc.nextLine());

                    switch (a) {
                        case 1:
                            danhsachBaoVe.NhapDanhSach();
                            break;
                        case 2:
                            danhsachBaoVe.DocFile("D:\\OOP\\DOAN\\src\\sach\\BaoVe_doc.txt");

                        default:
                            QLBaoVe();
                            break;
                    }
                }
                default -> {
                    adminMenu();
                    break;
                }

            }
        } else {
            System.out.println("+ --------------------------------------+");
            System.out.println("|              Quản lý Bảo Vệ           |");
            System.out.println("+ --------------------------------------+");
            System.out.println("| 1. Thêm nhân viên bảo vệ              |");
            System.out.println("| 2. Sửa nhân viên bảo vệ               |");
            System.out.println("| 3. Xoa nhân viên bảo vệ               |");
            System.out.println("| 4. Sắp xếp nhân viên bảo vệ theo tên  |");
            System.out.println("| 5. Sắp xếp nhân viên bảo vệ theo mã   |");
            System.out.println("| 6. Khôi phục nhân viên bảo vệ         |");
            System.out.println("| 7. Tìm kiếm nhân viên bảo vệ đã xóa   |");
            System.out.println("| 8. Ghi file nhân viên bảo vệ          |");
            System.out.println("| 0. Thoát                              |");
            System.out.println("+-------------------------------------- +");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1:
                    danhsachBaoVe.Them_BaoVe();
                    break;
                case 2:
                    danhsachBaoVe.Sua_BaoVe();
                    break;
                case 3:
                    danhsachBaoVe.Xoa_BaoVe();
                    break;

                case 4:
                    danhsachBaoVe.SapXep_TheoTen();
                    break;
                case 5:
                    danhsachBaoVe.Sapxep_TheoMa();
                    break;
                case 6:
                    danhsachBaoVe.KhoiPhuc_BaoVe();
                    break;
                case 7:
                    danhsachBaoVe.TimKiem_BaoVe();
                    break;
                case 8:
                    danhsachBaoVe.GhiFile("D:\\OOP\\DOAN\\src\\sach\\baove_ghi.txt");
                case 0:
                    QLBaoVe();
                    break;
                default:
                    break;
            }
        }
    }

    public void QLKho() {
        if (danhsachSach.getSach() == null) {
            System.out.println("Kho trong hay nhập sách vào kho: ");
            System.out.println("1.Nhập sách vào kho");
            System.out.println("2.Thoát");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1:
                    System.out.println("1: Nhập tư bàn phím");
                    System.out.println("2. Nhập bằng file");
                    System.out.println("3.Thoát");
                    System.out.print("Nhập lựa chọn: ");

                    int a = Integer.parseInt(sc.nextLine());

                    switch (a) {
                        case 1:
                            danhsachSach.NhapDanhSach();
                            break;
                        case 2:
                        	danhsachNXB.DocFile("D:\\OOP\\DOAN\\src\\sach\\NXB_doc.txt");
                        	danhsachTheLoai.DocFile("D:\\OOP\\DOAN\\src\\sach\\TheLoai_doc.txt");
                        	danhsachTacGia.DocFile("D:\\OOP\\DOAN\\src\\sach\\TacGia_doc.txt");
                        	danhsachSach.DocFile("D:\\OOP\\DOAN\\src\\sach\\sach_doc.txt");

                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

        } else {
            System.out.println("+ ------------------------------- +");
            System.out.println("|              Nhập Kho           |");
            System.out.println("+ ------------------------------- +");
            System.out.println("| 1. Thêm Sách vào Kho            |");
            System.out.println("| 2. Sửa Sách trong Kho           |");
            System.out.println("| 3. Xoá Sách trong Kho           |");
            System.out.println("| 0. Thoát                        |");
            System.out.println("+ ------------------------------- +");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1:
                    danhsachSach.Them_Sach();
                    break;
                case 2:
                    danhsachSach.Sua_Sach();
                    break;
                case 3:
                    danhsachSach.Xoa_Sach();
                    break;
                case 0:
                    adminMenu();
                    break;
                default:
                    return;
            }
        }

    }
    // đơn hàng 

    public void QLDonHang() {
        if (danhsachSach.getSach() == null) {
            System.out.println("Quản lý đơn hàng : ");
            System.out.println("1.Nhập vào");
            System.out.println("2.Thoat");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1:
                    System.out.println("1: Nhập tư bàn phím");
                    System.out.println("2. Nhập bằng file");
                    System.out.println("3.Thoát");
                    System.out.print("Nhập lựa chọn: ");

                    int a = Integer.parseInt(sc.nextLine());

                    switch (a) {
                        case 1:
                            danhsachSach.NhapDanhSach();
                            break;
                        case 2:
                        	danhsachNXB.DocFile("D:\\OOP\\DOAN\\src\\sach\\NXB_doc.txt");
                        	danhsachTheLoai.DocFile("D:\\OOP\\DOAN\\src\\sach\\TheLoai_doc.txt");
                        	danhsachTacGia.DocFile("D:\\OOP\\DOAN\\src\\sach\\TacGia_doc.txt");
                        	danhsachSach.DocFile("D:\\OOP\\DOAN\\src\\sach\\sach_doc.txt");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        if (danhsachKhachHang.getKhachHang() == null || danhsachDonHang.getDanhSachDonHang() == null) {
            System.out.println("Chưa có khách và đơn hàng. Vui lòng thông tin khách và đơn hàng trước khi quản lý đơn hàng.");
            System.out.println("1.Nhập thông tin khách và đơn hàng");
            System.out.println("2.Thoát");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1:
                    System.out.println("1: Nhập từ bàn phím");
                    System.out.println("2. Nhập bằng file");
                    System.out.println("3.Thoát");
                    System.out.print("Nhập lựa chọn: ");

                    int a = Integer.parseInt(sc.nextLine());

                    switch (a) {
                        case 1:
                            danhsachKhachHang.NhapDanhSach();
                            danhsachDonHang.NhapDanhSach();
                            danhsachChiTietDonHang.NhapDanhSach();
                            break;
                        case 2:
                        	danhsachKhachHang.DocFile("D:\\OOP\\DOAN\\src\\sach\\khachhang_doc.txt");
                            danhsachChiTietDonHang.DocFile("D:\\OOP\\DOAN\\src\\sach\\ChiTietDonHang_doc.txt");
                            danhsachDonHang.DocFile("D:\\OOP\\DOAN\\src\\sach\\donhang_doc.txt");
                            break;
                        default:
                            return;
                    }

                    break;
                default:
                    return;
            }

        } else {

            System.out.println("+ ------------------------------- +");
            System.out.println("|          Quản lý đơn hàng       |");
            System.out.println("+ ------------------------------- +");
            System.out.println("| 1. Thông tin đơn hàng           |");
            System.out.println("| 2. Thêm đơn hàng                |");
            System.out.println("| 3. Xóa đơn hàng                 |");
            System.out.println("| 4. Sửa đơn hàng                 |");
            System.out.println("| 5. Tìm kiếm đơn hàng            |");
            System.out.println("| 6. Khôi phục đơn hàng           |");
            System.out.println("| 0. Thoát                        |");
            System.out.println("+ ------------------------------- +");

            int luachon = -1;
            while (luachon < 0 || luachon > 8) {
                System.out.print("Nhập lựa chọn: ");
                try {
                    luachon = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 0 đến 8");
                }
            }
            switch (luachon) {
                case 1:
                    danhsachDonHang.XuatDanhSach();
                    break;
                case 2:
                    danhsachDonHang.Them_DonHang();
                    break;
                case 3:
                    danhsachDonHang.Xoa_DonHang();
                    break;
                case 4:
                    danhsachDonHang.Sua_DonHang();
                    break;
                case 5:
                    danhsachDonHang.TimKiem_DonHang();
                    break;
                case 6:
                    danhsachDonHang.KhoiPhuc_DonHang();
                    break;
                default:
                    break;
            }
        }
    }

    public void QLNhanVien() {
        System.out.println("+ ------------------------------- +");
        System.out.println("|          Quản lí nhân viên      |");
        System.out.println("+ ------------------------------- +");
        System.out.println("| 1. Quản lý Thu Ngân             |");
        System.out.println("| 2. Quản lý Bảo Vệ               |");
        System.out.println("| 3. Quản lý Bán Hàng             |");
        System.out.println("| 0. Thoát                        |");
        System.out.println("+ ------------------------------- +");

        int select;
        System.out.print("Lựa chọn của bạn: ");

        try {
            select = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số nguyên.");
            return;
        }

        switch (select) {
            case 1:
                QLThuNgan();
                break;
            case 2:
                QLBaoVe();
                break;
            case 3:
                QLBanHang();
                break;
            case 4:
                adminMenu();
                break;
            default:
                System.out.print("Lựa chọn không hợp lệ");
                break;
        }
    }

    public void adminMenu() {

        int select;
        String temp;

        do {
            System.out.println("+ ------------------------------- +");
            System.out.println("|          Quản trị viên          |");
            System.out.println("+ ------------------------------- +");
            System.out.println("| 1. Quản lý kho                  |");
            System.out.println("| 2. Quản lý nhân viên            |");
            System.out.println("| 3. Quản lý khách hàng           |");
            System.out.println("| 4. Quản lý đơn hàng             |");
            System.out.println("| 0. Thoát                        |");
            System.out.println("+ ------------------------------- +");

            System.out.print("Lựa chọn của bạn: ");
                    
            temp = sc.nextLine();

            try {
                select = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số nguyên.");
                continue;
            }

            switch (select) {
                case 1:
                    QLKho();
                    break;
                case 2:
                    QLNhanVien();
                    break;
                case 3:
                    adminCustomerMenu();
                    break;
                case 4:
                    QLDonHang();
                    break;
                case 0:
                    //thoát khỏi chương trình
                    System.exit(0);
                default:
                    System.out.print("Lựa chọn không hợp lệ");
                    break;
            }
        } while (true);
    }

    public void adminCustomerMenu() {
        if (danhsachKhachHang.getKhachHang() == null) {
            System.out.println("Quản lý Khách hàng: ");
            System.out.println("1.Nhập Khách hàng");
            System.out.println("2.Thoát");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1 -> {
                    System.out.println("1: Nhập từ bàn phím");
                    System.out.println("2. Nhập bằng file");
                    System.out.println("3.Thoát");
                    System.out.print("Nhập lựa chọn: ");

                    int a = Integer.parseInt(sc.nextLine());

                    switch (a) {
                        case 1:
                            danhsachKhachHang.NhapDanhSach();
                            break;
                        case 2:
                            danhsachKhachHang.DocFile("D:\\OOP\\DOAN\\src\\sach\\khachhang_doc.txt");

                        default:
                            adminMenu();
                            break;
                    }
                }
                default -> {
                    break;
                }
            }
        } else {
            System.out.println("+ ----------------------------------------- +");
            System.out.println("|                 QL Khách hàng             |");
            System.out.println("+ ----------------------------------------- +");
            System.out.println("| 1. Xem danh sách khách hàng               |");
            System.out.println("| 2. Thêm khách hàng                        |");
            System.out.println("| 3. Xóa khách hàng                         |");
            System.out.println("| 4. Tìm kiếm khách hàng                    |");
            System.out.println("| 5. Sửa thông tin khách hàng               |");
            System.out.println("| 6. Hiển thị thông tin khách hàng đã xóa   |");
            System.out.println("| 7. Khôi phục thông tin khách hàng         |");
            System.out.println("| 0. Quay lại                               |");
            System.out.println("+ ----------------------------------------- +");
            System.out.print("Nhập lựa chọn: ");

            int luachon = Integer.parseInt(sc.nextLine());

            switch (luachon) {
                case 1:
                    danhsachKhachHang.Xem_DanhSach_KhachHang_HienTai();
                    break;
                // Thêm khách hàng
                case 2:
                    danhsachKhachHang.Them_KhachHang();
                    break;
                // Xóa khách hàng
                case 3:
                    danhsachKhachHang.Xoa_KhachHang();
                    break;
                // Tìm kiếm khách hàng
                case 4:
                    danhsachKhachHang.TimKiem_KhachHang();
                    break;
                // Sửa thông tin khách hàng
                case 5:
                    danhsachKhachHang.Sua_KhachHang();
                    break;
                case 6:
                    danhsachKhachHang.HienThiKhachHangBiXoa();
                    break;
                case 7:
                    danhsachKhachHang.KhoiPhuc_KhachHang();
                    break;
                case 0:
                    adminMenu();

                default:
                    System.out.print("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }

}
