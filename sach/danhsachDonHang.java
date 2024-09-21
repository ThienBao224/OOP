package sach;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class danhsachDonHang {
    private static Scanner sc = new Scanner(System.in);
    private static int soLuong = 0;
    private static DonHang danhSachDonHang[];
    private static PhuongThucThanhToan pt;

    //private static String[] danhSachIdKhachHang;

    public danhsachDonHang() {
        // Constructor mặc định
    }
    
    public static DonHang[] getDanhSachDonHang() {
		return danhSachDonHang;
	}

	public static void setDanhSachDonHang(DonHang[] danhSachDonHang) {
		danhsachDonHang.danhSachDonHang = danhSachDonHang;
	}

	public static int getSoLuong() {
        return soLuong;
    }

    public static void setSoLuong(int sl) {
        soLuong = sl;
    }
    //*PHAN DOC - GHI FILE *//

    private static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Parse the string to Date object
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void DocFile(String filename) {
		try {
			FileReader readfile=new FileReader(filename);
			BufferedReader br = new BufferedReader(readfile);
			String line;
			int i;
			while((line=br.readLine())!=null) {
				String text[]=line.split("#");
				if(danhSachDonHang==null)
					danhSachDonHang= new DonHang[1];
				else 
					danhSachDonHang=Arrays.copyOf(danhSachDonHang, danhSachDonHang.length+1);
					i =danhSachDonHang.length-1;
                // Chuyển đổi ngày từ chuỗi sang đối tượng Date
                    Date ngayDat = parseDate(text[2]);
                    Date ngayGiao = parseDate(text[3]);
    
				if(text.length==7&&text[1].matches("\\d+")&&ngayDat!=null&&ngayGiao!=null&&danhsachChiTietDonHang.TrungLap(text[0])!=null&&text[0].matches("^DH\\d+") ) {
					if(danhSachDonHang[i]==null)
						danhSachDonHang[i]= new DonHang();
						pt=new PhuongThucThanhToan(text[6],ngayDat);
						danhSachDonHang[i].CapNhat_DonHang(text[0], Integer.parseInt(text[1]), ngayDat,ngayGiao,text[4],danhsachKhachHang.TrungLap(text[5]),pt,danhsachChiTietDonHang.TrungLap(text[0]));
					i++;
					}
					else danhSachDonHang=Arrays.copyOf(danhSachDonHang, danhSachDonHang.length-1);
				}
			
			soLuong=danhSachDonHang.length;
			readfile.close();
			br.close();
			readfile.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void GhiFile(String filename) {
        try {
            FileWriter writefile = new FileWriter(filename);
            FileWriter bin=new FileWriter("DonHang_recyclebin.txt");
            int i = 0;
            if (danhSachDonHang == null) {
                System.out.println("Danh sach rong");
                writefile.close();
                bin.close();
                return;
            }

            while (i < danhSachDonHang.length && danhSachDonHang[i] != null) {
                if(danhSachDonHang[i].getTrangThaiDonHang()!=-1)
                	writefile.write(danhSachDonHang[i].Xuat() + "\n");
                else
                	bin.write(danhSachDonHang[i].Xuat() + "\n");
                i++;
            }
            bin.close();
            writefile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //*PHAN DOC - GHI FILE *//
    // Nhập thông tin cho danh sách đơn hàng
    public static void NhapDanhSach() {
        System.out.print("Nhap so luong don hang: ");
        soLuong = Integer.parseInt(sc.nextLine());
        danhSachDonHang = new DonHang[soLuong];
    
        for (int i = 0; i < soLuong; i++) {
            danhSachDonHang[i] = new DonHang();
            System.out.println("----Nhap thong tin cho don hang thu [" + (i + 1)+"]----");
    
            // Input and check for duplicate order ID
//            String newMaDonHang;
//            do {
//                System.out.print("Nhap ID don hang ( bat dau bang DH... VD: DH123): : ");
//                newMaDonHang = sc.nextLine();
//            } while (hasDuplicateOrderId(newMaDonHang, i));
//    
//            danhSachDonHang[i].setMaDonHang(newMaDonHang);
            danhSachDonHang[i].Nhap();
        }
    }
    
    // Check for duplicate order ID
    public static boolean hasDuplicateOrderId(String id, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (danhSachDonHang[i] != null && danhSachDonHang[i].getMaDonHang() != null &&
                danhSachDonHang[i].getMaDonHang().equals(id)) {
                System.out.println("ID don hang da ton tai. Vui long nhap lai.");
                return true; // Found a duplicate
            }
        }
        return false; // No duplicate found
    }

    // Hiển thị thông tin cho danh sách đơn hàng
    public static void XuatDanhSach() {
        if (danhSachDonHang == null||danhsachKhachHang.getKhachHang()==null) {
            System.out.println("Khong co don hang nao.");
            return;
        }
        System.out.println("--------Thong tin don hang--------");
        for (DonHang donHang : danhSachDonHang) {
            if (donHang != null && !donHang.isDeleted()) {
                System.out.println(donHang.Xuat());
            }
        }System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }
    // Tìm kiếm thông tin đơn hàng
    public static int TimKiem(String orderId) {
        for (int i = 0; i < danhSachDonHang.length; i++) {
            if (danhSachDonHang[i].getMaDonHang() != null
                && danhSachDonHang[i].getMaDonHang().equals(orderId)) {
                return i;
            }
        }
        return -1;
    }

    public static void TimKiem_DonHang() {
        System.out.println("----Tim kiem don hang----");
        while (true) {
            System.out.print("Nhap ID don hang can tim: ");
            String maSoDonHang = sc.nextLine();
            int i = TimKiem(maSoDonHang);
    
            if (i == -1 || danhSachDonHang[i].isDeleted()) {
                System.out.println("Khong tim thay");
                System.out.println("1.Tiep tuc tim kiem");
                System.out.println("2.Thoat tim kiem");
                int luaChon = Integer.parseInt(sc.nextLine());
    
                if (luaChon == 2) {
                    return;
                }
            } else {
                System.out.println(danhSachDonHang[i].Xuat());
                System.out.println("1.Tiep tuc tim kiem");
                System.out.println("2.Thoat tim kiem");
                int luaChon = Integer.parseInt(sc.nextLine());
    
                if (luaChon == 2) {
                    return;
                }
            }
        }
    }

    // Xóa thông tin đơn hàng
    public static boolean Xoa(String maSoDonHang) {
        int i = TimKiem(maSoDonHang);
        if (i == -1) {
            System.out.println("Khong tim thay don hang.");
            return false;
        } else {
            danhSachDonHang[i].setTrangThaiDonHang(-1); // Set trangThaiDonHang to -1 to indicate deletion
            System.out.println("Da Xoa don hang.");
            return true;
        }
    }
    
    public static void Xoa_DonHang() {
        if (danhSachDonHang == null) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("----Xoa don hang----");
        int soLuongCanXoa = -1;
        while (soLuongCanXoa == -1) {
            System.out.print("Nhap so luong don hang can Xoa (Khong vuot qua " + danhSachDonHang.length + "): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongCanXoa = Integer.parseInt(sl);
                if (soLuongCanXoa == 0) {
                    System.out.println("Khong Xoa don hang");
                    return;
                }
                if (soLuongCanXoa > danhSachDonHang.length) {
                    System.out.println("So luong can Xoa vuot qua so luong don hang hien co.");
                    return;
                }
                while (soLuongCanXoa != 0) {
                    System.out.print("Nhap ID don hang can Xoa: ");
                    String maSoDonHang = sc.nextLine();
                    if (!Xoa(maSoDonHang)) {
                        System.out.println("Xoa don hang khong thanh cong. Khong tim thay don hang.");
                    }
                    soLuongCanXoa--;
                }
            } else {
                soLuongCanXoa = -1;
            }
        }
    }
    public static void hienThiDonHangBiXoa() {
        System.out.println("Danh sach don hang da bi Xoa:");
        for (int i = 0; i < soLuong; i++) {
            if (danhSachDonHang[i].getTrangThaiDonHang() == -1) {
                System.out.println("Ma so don hang: " + danhSachDonHang[i].getMaDonHang()+" (Da bi Xoa)");
            }
        }
    }
    
    // Khôi phục thông tin đã xóa
    public static DonHang KhoiPhuc(String maSoDonHang_canKhoiPhuc) {
        for (int i = 0; i < danhSachDonHang.length; i++) {
            if (danhSachDonHang[i].getMaDonHang() != null &&
                danhSachDonHang[i].getMaDonHang().equals(maSoDonHang_canKhoiPhuc) &&
                danhSachDonHang[i].getTrangThaiDonHang() == -1) { // Corrected condition
                danhSachDonHang[i].setTrangThaiDonHang(1);
                return danhSachDonHang[i];
            }
        }
        return null;
    }

    public static void KhoiPhuc_DonHang() {
        if (danhSachDonHang == null) {
            System.out.println("Danh sach rong");
            return;
        }
    
        // Check if there are any deleted orders
        boolean coDonHangBiXoa = false;
        for (int i = 0; i < soLuong; i++) {
            if (danhSachDonHang[i].getTrangThaiDonHang() == -1) {
                coDonHangBiXoa = true;
                break;
            }
        }
    
        if (!coDonHangBiXoa) {
            System.out.println("Khong co don hang nao bi Xoa. Khong can khoi phuc.");
            return;
        }
    
        System.out.println("----Khoi phuc don hang----");
        int soLuongCanKhoiPhuc = -1;
        while (soLuongCanKhoiPhuc == -1) {
            System.out.print("Nhap so luong don hang can khoi phuc (Khong vuot qua " + soLuong + "): ");
            String sl = sc.nextLine();
            danhsachDonHang.hienThiDonHangBiXoa();
            if (sl.matches("\\d+")) {
                soLuongCanKhoiPhuc = Integer.parseInt(sl);
                if (soLuongCanKhoiPhuc == 0) {
                    System.out.println("Khong khoi phuc don hang");
                    return;
                }
                if (soLuongCanKhoiPhuc > soLuong)
                    return;
    
                for (int i = 0; i < soLuongCanKhoiPhuc; i++) {
                    System.out.print("Nhap ID don hang can khoi phuc: ");
                    String maSoDonHang_canKhoiPhuc = sc.nextLine();
                    KhoiPhuc(maSoDonHang_canKhoiPhuc);
                }
            } else
                soLuongCanKhoiPhuc = -1;
        }
    }
    

    // Chỉnh sửa thông tin
    public static DonHang Sua(String maSoDonHang_canSua) {
        int i = TimKiem(maSoDonHang_canSua);
        if (i == -1) {
            System.out.println("Khong tim thay");
            System.out.println("1. Tiep tuc tim kiem");
            System.out.println("2. Thoat tim kiem");
            int chon = Integer.parseInt(sc.nextLine());
            if (chon == 1) {
                System.out.print("Nhap ID don hang can Sua: ");
                return Sua(sc.nextLine());
            } else {
                System.out.println("Thoat tim kiem");
                return null;
            }
        }
    
        // If a match is found, print the information and exit
        System.out.println("Thong tin cua don hang \"" + danhSachDonHang[i].getMaDonHang() + "\":");
        System.out.println(danhSachDonHang[i].Xuat());
        
        int soLuongCanSua = -1;
        while (soLuongCanSua == -1) {
            System.out.print("Ban muon Sua bao nhieu thong tin cua don hang (Khong vuot qua 8): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongCanSua = Integer.parseInt(sl);
                if (soLuongCanSua > 8)
                    return null;
                while (soLuongCanSua != 0) {
                    System.out.println("Sua thong tin cua don hang \"" + danhSachDonHang[i].getMaDonHang() + "\"");
                    danhSachDonHang[i].SuaThongTin();
                    soLuongCanSua--;
                }
            } else
                soLuongCanSua = -1;
        }
        return danhSachDonHang[i];
    }

    public static void Sua_DonHang() {
        if (danhSachDonHang == null) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("----Sua don hang----");
        int soLuongCanSua = -1;
        while (soLuongCanSua == -1) {
            System.out.print("Nhap so luong don hang can Sua (Khong vuot qua " + danhSachDonHang.length + " - hoac nhap 0 de khong Sua): ");
            String sl = sc.nextLine();
            if (sl.matches("\\d+")) {
                soLuongCanSua = Integer.parseInt(sl);
                if (soLuongCanSua == 0) {
                    System.out.println("Khong Sua don hang");
                    return;
                }
                if (soLuongCanSua > danhSachDonHang.length) {
                    System.out.println("So luong can Sua lon hon so luong don hang. Khong Sua don hang");
                    return;
                }
                    
                while (soLuongCanSua != 0) {
                    System.out.print("Nhap ID don hang can Sua: ");
                    String maSoDonHang_canSua = sc.nextLine();
                    Sua(maSoDonHang_canSua);
                    soLuongCanSua--;
                }
            } else
                soLuongCanSua = -1;
        }
    }
    public static DonHang Them() {
		int i;
		if (danhSachDonHang == null || danhSachDonHang[0] == null)
			danhSachDonHang = new DonHang[1];
		else
			danhSachDonHang = Arrays.copyOf(danhSachDonHang, danhSachDonHang.length + 1);
		i = danhSachDonHang.length - 1;
		danhSachDonHang[i] = new DonHang();
		System.out.println("nhap thong tin Don Hang");
		danhSachDonHang[i].Nhap();
		soLuong = danhSachDonHang.length;
		return danhSachDonHang[i];
	}

	public static void Them_DonHang() {
		int so_luong_can_them = -1;
		while (so_luong_can_them == -1) {
			System.out.print("So Luong Sach can them: ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);
				if (so_luong_can_them == 0) {
					if (danhSachDonHang == null)
						System.out.println("Danh Sach rong");
					else
						System.out.println("Khong them Don Hang");
					return;
				}
				while (so_luong_can_them != 0) {
					Them();
					so_luong_can_them--;
				}
			} else
				so_luong_can_them = -1;
		}
	}
    public static boolean TrungLap(String maDonHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSachDonHang[i] != null && danhSachDonHang[i].getMaDonHang() != null &&
                danhSachDonHang[i].getMaDonHang().equals(maDonHang)) {
                return true; // Duplicate order ID found
            }
        }
        return false; // No duplicate order ID found
    }
}