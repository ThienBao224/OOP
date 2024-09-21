package sach;

import java.io.*;
import java.util.*;

public class danhsachNCC {
	
	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static newNCC NCC[];

	public static int getSoluong() {
		return soluong;
	}

	public static void setSoluong(int sl) {
		soluong = sl;
	}

	// nhập thông tin
	public static void NhapDanhSach() {
		while (soluong == 0) {
			
			System.out.print("Nhap so luong NCC ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;
			
		}
		
		NCC = new newNCC[soluong];
		
		for (int i = 0; i < NCC.length; i++) {
			NCC[i] = new newNCC();
			
			System.out.println("Nhap thong tin NCC");
			
			NCC[i].Nhap();
			
		}
	}
	//đọc file
	public static void DocFile(String filename) {
		try {
			
			FileReader readfile = new FileReader(filename);
			BufferedReader br = new BufferedReader(readfile);
			String line;
			int i;
			
			while ((line = br.readLine()) != null) {
				
				String text[] = line.split("#");
				
				if (NCC == null)
					NCC = new newNCC[1];
				else
					NCC = Arrays.copyOf(NCC, NCC.length + 1);
				
				i = NCC.length - 1;
				
				if (text.length == 3 && TrungLap(text[0]) == null && text[1].matches("\\d+")) {
					if (NCC[i] == null)
						NCC[i] = new newNCC(text[0], text[1], text[2], 1);
					// NCC[i].capnhatNCC(text[0], text[1], text[2], 1);
					i++;
					
				} else
					NCC = Arrays.copyOf(NCC, NCC.length - 1);
				
			}
			
			soluong = NCC.length;
			br.close();
			readfile.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	//ghi file
	public static void GhiFile(String filename) {
		try {
			
			FileWriter writefile = new FileWriter(filename);
			FileWriter bin = new FileWriter("NCC_recyclebin.txt");
			int i = 0;
			
			if (NCC == null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}
			
			while (i < NCC.length && NCC[i] != null) {
				if (NCC[i].trangthai == 1)
					writefile.write(NCC[i].getTenNCC() + "#" + NCC[i].getsdtNCC() + "#" + NCC[i].getDcNCC() + "\n");
				else
					bin.write(NCC[i].getTenNCC() + "#" + NCC[i].getsdtNCC() + "#" + NCC[i].getDcNCC() + "\n");
				i++;
			}
			
			writefile.close();
			bin.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// tìm kiếm thông tin bị trùng lặp
	// trùng lặp được cho phép
	public static newNCC TrungLap(String tenNCC) {
		if (NCC == null || NCC[0] == null)
			return null;
		
		for (int i = 0; i < NCC.length; i++)
			if (NCC[i] != null)
				if (NCC[i].getTenNCC() != null && NCC[i].getTenNCC().equals(tenNCC))
					return NCC[i];
		
		return null;
		
	}

	// xuất thông tin
	public static void XuatDanhSach() {
		if (NCC.length == 0) {
			System.out.println("Khong co NCC nao");
			return;
		}
		
		for (int i = 0; i < NCC.length; i++) {
			if (NCC[i] != null && NCC[i].trangthai == 1) {
				System.out.println("");
				System.out.println(NCC[i].Xuat());
			}
		}System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
	}
	//sắp xếp theo tên
	public static newNCC[] SapXep_Ten() {
		if (NCC == null || NCC.length <= 1)
			return NCC;

		newNCC NCC_sapxep[] = Arrays.copyOf(NCC, NCC.length);
		newNCC tmp;

		for (int i = 0; i < NCC_sapxep.length; i++) {
			for (int j = 0; j < NCC_sapxep.length - i - 1; j++) {
				String tenNCC1 = NCC_sapxep[j].getTenNCC().substring(0,1).toLowerCase();
				String tenNCC2 = NCC_sapxep[j + 1].getTenNCC().substring(0,1).toLowerCase();

				if (tenNCC1.compareTo(tenNCC2) > 0) {
					tmp = NCC_sapxep[j];
					NCC_sapxep[j] = NCC_sapxep[j + 1];
					NCC_sapxep[j + 1] = tmp;
				}
			}
		}
		return NCC_sapxep;
	}

	public static void SapXep_TheoTen() {
		if (NCC == null)
			return;
		
		newNCC NCC_sapxep[] = Arrays.copyOf(SapXep_Ten(), SapXep_Ten().length);
		
		for (int i = 0; i < NCC_sapxep.length; i++) {
			if (NCC_sapxep[i] != null && NCC_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(NCC_sapxep[i].Xuat());
			}

		}
	}
	public static newNCC Them(newNCC newNCC) {
		if(TrungLap(newNCC.getTenNCC())!=null)
			return null;
		int i;
		
		if (NCC == null)
			NCC = new newNCC[1];
		else
			NCC = Arrays.copyOf(NCC, NCC.length + 1);
		
		i = NCC.length - 1;
		NCC[i] = new newNCC();
		
		NCC[i]=newNCC;
		soluong = NCC.length;
		
		return NCC[i];
		
	}
	// thêm thông tin đối tượng
	public static newNCC Them() {
		int i;
		
		if (NCC == null)
			NCC = new newNCC[1];
		else
			NCC = Arrays.copyOf(NCC, NCC.length + 1);
		
		i = NCC.length - 1;
		NCC[i] = new newNCC();
		
		System.out.println("nhap thong tin NCC");
		
		NCC[i].Nhap();
		soluong = NCC.length;
		
		return NCC[i];
		
	}

	public static void Them_NCC() {
		int so_luong_can_them = -1;
		
		while (so_luong_can_them == -1) {
			
			System.out.print("So Luong NCC can them: ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);
				
				if (so_luong_can_them == 0) {
					if (soluong == 0)
						System.out.println("Danh sach rong");
					else
						System.out.println("Khong them sach");
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

	// tìm kiếm thông tin
	public static int TimKiem(String tenNCC) {
		for (int i = 0; i < NCC.length; i++) {
			if (NCC[i].trangthai == 1 && NCC[i].getTenNCC().equals(tenNCC))
				return i;
		}
		
		return -1;
		
	}

	public static void TimKiem_NCC() {
		if (NCC == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		System.out.print("Nhap ten NCC can tim: ");
		String tenNCC = sc.nextLine();
		
		int i = TimKiem(tenNCC);
		
		while (i == -1) {
			
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			
			int luachon = Integer.parseInt(sc.nextLine());
			
			if (luachon == 1)
				TimKiem_NCC();
			else
				return;
			
		}
		
		System.out.println(NCC[i].Xuat());
	}

	// xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ten NCC can xoa: ");
		String tenNCC = sc.nextLine();
		
		int i = TimKiem(tenNCC);
		
		if (i == -1) {
			
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			
			int luachon = Integer.parseInt(sc.nextLine());
			
			if (luachon == 1)
				Xoa();
			
		} else {
			NCC[i].trangthai = 0;
			return;
		}
		
	}

	public static void Xoa_NCC() {
		if (NCC == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int so_luong_can_xoa = -1;
		
		while (so_luong_can_xoa == -1) {
			
			System.out.print("Nhap so luong NCC can xoa thong tin (Khong vuot qua " + NCC.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_can_xoa = Integer.parseInt(sl);
				
				if (so_luong_can_xoa == 0) {
					System.out.println("Khong xoa NCC");
					return;
				}
				
				if (so_luong_can_xoa > NCC.length)
					return;
				
				while (so_luong_can_xoa != 0) {
					Xoa();
					so_luong_can_xoa--;
				}
				
			} else
				so_luong_can_xoa = -1;
		}
	}

	// khôi phục thông tin đã xóa
	public static newNCC KhoiPhuc(String tenNCC_cankhoiphuc) {
		int i;
		
		for (i = 0; i < NCC.length; i++)
			if (NCC[i].getTenNCC() != null && NCC[i].getTenNCC().equals(tenNCC_cankhoiphuc) && NCC[i].trangthai == 0) {
				NCC[i].trangthai = 1;
				return NCC[i];
			}
		
		return null;
		
	}

	public static void KhoiPhuc_NCC() {
		if (NCC == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int soluong_NCC_cankhoiphuc = -1;
		
		while (soluong_NCC_cankhoiphuc == -1) {
			
			System.out.print("Nhap so luong NCC can khoi phuc thong tin (Khong vuot qua " + NCC.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				soluong_NCC_cankhoiphuc = Integer.parseInt(sl);
				
				if (soluong_NCC_cankhoiphuc > NCC.length)
					return;
				
				for (int i = 0; i < soluong_NCC_cankhoiphuc; i++) {
					System.out.println("Nhap Ten NCC can khoi phuc: ");
					String tenNCC_cankhoiphuc = sc.nextLine();
					KhoiPhuc(tenNCC_cankhoiphuc);
					
				}
			} else
				soluong_NCC_cankhoiphuc = -1;
		}
	}

	// sửa thông tin
	public static newNCC Sua(String tenNCC) {
		int i = TimKiem(tenNCC);
		
		if (i == -1) {
			
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			
			int luachon = Integer.parseInt(sc.nextLine());
			
			switch (luachon) {

			case 1:
				System.out.print("Nhap Ten NCC can sua thong tin: ");
				return Sua(sc.nextLine());
			default:
				return null;
				
			}
			
		}
		
		int so_luong_thong_tin_can_sua = -1;
		
		while (so_luong_thong_tin_can_sua == -1) {
			
			System.out.println("Ban muon sua bao nhieu thong tin cua NCC (toi da 3): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua = Integer.parseInt(sl);
				
				if (so_luong_thong_tin_can_sua > 3)
					return null;
				
				while (so_luong_thong_tin_can_sua != 0) {
					System.out.println("Sua thong tin cua NCC '" + NCC[i].getTenNCC() + "'");
					NCC[i].SuaThongTin();
					so_luong_thong_tin_can_sua--;
				}
				
			} else
				so_luong_thong_tin_can_sua = -1;
		}
		
		return NCC[i];
		
	}

	public static void Sua_NCC() {
		if (NCC == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int so_luong_can_sua = -1;
		
		while (so_luong_can_sua == -1) {
			
			System.out.print("Nhap so luong NCC can sua thong tin (Khong vuot qua " + NCC.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_can_sua = Integer.parseInt(sl);
				
				if (so_luong_can_sua == 0) {
					System.out.println("Khong sua NCC");
					return;
				}
				
				if (so_luong_can_sua > NCC.length)
					return;
				
				while (so_luong_can_sua != 0) {
					System.out.print("Nhap ten NCC can sua thong tin: ");
					String tenNCC = sc.nextLine();
					Sua(tenNCC);
					so_luong_can_sua--;
					
				}
			} else
				so_luong_can_sua = -1;
		}
	}
}
