package sach;

import java.io.*;
import java.util.*;

public class danhsachNXB {
	
	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static newNXB NXB[];

	public static int getSoluong() {
		return soluong;
	}

	public static void setSoluong(int sl) {
		soluong = sl;
	}
	public static newNXB getNXB(int i) {
		return NXB[i];
	}
	public static newNXB[] getNXB() {
		return NXB;
	}

	public static void setNXB(newNXB[] nXB) {
		NXB = nXB;
	}

	// nhập thông tin
	public static void NhapDanhSach() {
		while (soluong == 0) {
			
			System.out.print("Nhap so luong NXB ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;
			
		}
		
		NXB = new newNXB[soluong];
		
		for (int i = 0; i < NXB.length; i++) {
			NXB[i] = new newNXB();
			
			System.out.println("Nhap thong tin NXB");
			
			NXB[i].Nhap();
			
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
				
				if (NXB == null)
					NXB = new newNXB[1];
				else
					NXB = Arrays.copyOf(NXB, NXB.length + 1);
				
				i = NXB.length - 1;
				
				if (text.length == 3 && TrungLap(text[0]) == null && text[1].matches("\\d+")) {
					if (NXB[i] == null)
						NXB[i] = new newNXB(text[0], text[1], text[2], 1);
					// NXB[i].capnhatNXB(text[0], text[1], text[2], 1);
					i++;
					
				} else
					NXB = Arrays.copyOf(NXB, NXB.length - 1);
				
			}
			
			soluong = NXB.length;
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
			FileWriter bin = new FileWriter("NXB_recyclebin.txt");
			int i = 0;
			
			if (NXB == null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}
			
			while (i < NXB.length && NXB[i] != null) {
				if (NXB[i].trangthai == 1)
					writefile.write(NXB[i].getTenNXB() + "#" + NXB[i].getsdtNXB() + "#" + NXB[i].getDcNXB() + "\n");
				else
					bin.write(NXB[i].getTenNXB() + "#" + NXB[i].getsdtNXB() + "#" + NXB[i].getDcNXB() + "\n");
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
	public static newNXB TrungLap(String tenNXB) {
		if (NXB == null || NXB[0] == null)
			return null;
		
		for (int i = 0; i < NXB.length; i++)
			if (NXB[i] != null)
				if (NXB[i].getTenNXB() != null && NXB[i].getTenNXB().equals(tenNXB))
					return NXB[i];
		
		return null;
		
	}

	// xuất thông tin
	public static void XuatDanhSach() {
		if (NXB.length == 0) {
			System.out.println("Khong co NXB nao");
			return;
		}
		
		for (int i = 0; i < NXB.length; i++) {
			if (NXB[i] != null && NXB[i].trangthai == 1) {
				System.out.println("");
				System.out.println(NXB[i].Xuat());
			}
		}System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
	}
	//sắp xếp theo tên
	public static newNXB[] SapXep_Ten() {
		if (NXB == null || NXB.length <= 1)
			return NXB;

		newNXB NXB_sapxep[] = Arrays.copyOf(NXB, NXB.length);
		newNXB tmp;

		for (int i = 0; i < NXB_sapxep.length; i++) {
			for (int j = 0; j < NXB_sapxep.length - i - 1; j++) {
				String tenNXB1 = NXB_sapxep[j].getTenNXB().substring(0,1).toLowerCase();
				String tenNXB2 = NXB_sapxep[j + 1].getTenNXB().substring(0,1).toLowerCase();

				if (tenNXB1.compareTo(tenNXB2) > 0) {
					tmp = NXB_sapxep[j];
					NXB_sapxep[j] = NXB_sapxep[j + 1];
					NXB_sapxep[j + 1] = tmp;
				}
			}
		}
		return NXB_sapxep;
	}

	public static void SapXep_TheoTen() {
		if (NXB == null)
			return;
		
		newNXB NXB_sapxep[] = Arrays.copyOf(SapXep_Ten(), SapXep_Ten().length);
		
		for (int i = 0; i < NXB_sapxep.length; i++) {
			if (NXB_sapxep[i] != null && NXB_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(NXB_sapxep[i].Xuat());
			}

		}
	}
	public static newNXB Them(newNXB newNXB) {
		if(TrungLap(newNXB.getTenNXB())!=null)
			return null;
		int i;
		
		if (NXB == null)
			NXB = new newNXB[1];
		else
			NXB = Arrays.copyOf(NXB, NXB.length + 1);
		
		i = NXB.length - 1;
		NXB[i] = new newNXB();
		
		NXB[i]=newNXB;
		soluong = NXB.length;
		
		return NXB[i];
		
	}
	// thêm thông tin đối tượng
	public static newNXB Them() {
		int i;
		
		if (NXB == null)
			NXB = new newNXB[1];
		else
			NXB = Arrays.copyOf(NXB, NXB.length + 1);
		
		i = NXB.length - 1;
		NXB[i] = new newNXB();
		
		System.out.println("nhap thong tin NXB");
		
		NXB[i].Nhap();
		soluong = NXB.length;
		
		return NXB[i];
		
	}

	public static void Them_NXB() {
		int so_luong_can_them = -1;
		
		while (so_luong_can_them == -1) {
			
			System.out.print("So Luong NXB can them: ");
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
	public static int TimKiem(String tenNXB) {
		for (int i = 0; i < NXB.length; i++) {
			if (NXB[i].trangthai == 1 && NXB[i].getTenNXB().equals(tenNXB))
				return i;
		}
		
		return -1;
		
	}

	public static void TimKiem_NXB() {
		if (NXB == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		System.out.print("Nhap ten NXB can tim: ");
		String tenNXB = sc.nextLine();
		
		int i = TimKiem(tenNXB);
		
		while (i == -1) {
			
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			
			int luachon = Integer.parseInt(sc.nextLine());
			
			if (luachon == 1)
				TimKiem_NXB();
			else
				return;
			
		}
		
		System.out.println(NXB[i].Xuat());
	}

	// xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ten NXB can xoa: ");
		String tenNXB = sc.nextLine();
		
		int i = TimKiem(tenNXB);
		
		if (i == -1) {
			
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			
			int luachon = Integer.parseInt(sc.nextLine());
			
			if (luachon == 1)
				Xoa();
			
		} else {
			NXB[i].trangthai = 0;
			return;
		}
		
	}

	public static void Xoa_NXB() {
		if (NXB == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int so_luong_can_xoa = -1;
		
		while (so_luong_can_xoa == -1) {
			
			System.out.print("Nhap so luong NXB can xoa thong tin (Khong vuot qua " + NXB.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_can_xoa = Integer.parseInt(sl);
				
				if (so_luong_can_xoa == 0) {
					System.out.println("Khong xoa NXB");
					return;
				}
				
				if (so_luong_can_xoa > NXB.length)
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
	public static newNXB KhoiPhuc(String tenNXB_cankhoiphuc) {
		int i;
		
		for (i = 0; i < NXB.length; i++)
			if (NXB[i].getTenNXB() != null && NXB[i].getTenNXB().equals(tenNXB_cankhoiphuc) && NXB[i].trangthai == 0) {
				NXB[i].trangthai = 1;
				return NXB[i];
			}
		
		return null;
		
	}

	public static void KhoiPhuc_NXB() {
		if (NXB == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int soluong_NXB_cankhoiphuc = -1;
		
		while (soluong_NXB_cankhoiphuc == -1) {
			
			System.out.print("Nhap so luong NXB can khoi phuc thong tin (Khong vuot qua " + NXB.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				soluong_NXB_cankhoiphuc = Integer.parseInt(sl);
				
				if (soluong_NXB_cankhoiphuc > NXB.length)
					return;
				
				for (int i = 0; i < soluong_NXB_cankhoiphuc; i++) {
					System.out.println("Nhap Ten NXB can khoi phuc: ");
					String tenNXB_cankhoiphuc = sc.nextLine();
					KhoiPhuc(tenNXB_cankhoiphuc);
					
				}
			} else
				soluong_NXB_cankhoiphuc = -1;
		}
	}

	// sửa thông tin
	public static newNXB Sua(String tenNXB) {
		int i = TimKiem(tenNXB);
		
		if (i == -1) {
			
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			
			int luachon = Integer.parseInt(sc.nextLine());
			
			switch (luachon) {

			case 1:
				System.out.print("Nhap Ten NXB can sua thong tin: ");
				return Sua(sc.nextLine());
			default:
				return null;
				
			}
			
		}
		
		int so_luong_thong_tin_can_sua = -1;
		
		while (so_luong_thong_tin_can_sua == -1) {
			
			System.out.println("Ban muon sua bao nhieu thong tin cua NXB (toi da 3): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua = Integer.parseInt(sl);
				
				if (so_luong_thong_tin_can_sua > 3)
					return null;
				
				while (so_luong_thong_tin_can_sua != 0) {
					System.out.println("Sua thong tin cua NXB '" + NXB[i].getTenNXB() + "'");
					NXB[i].SuaThongTin();
					so_luong_thong_tin_can_sua--;
				}
				
			} else
				so_luong_thong_tin_can_sua = -1;
		}
		
		return NXB[i];
		
	}

	public static void Sua_NXB() {
		if (NXB == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int so_luong_can_sua = -1;
		
		while (so_luong_can_sua == -1) {
			
			System.out.print("Nhap so luong NXB can sua thong tin (Khong vuot qua " + NXB.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_can_sua = Integer.parseInt(sl);
				
				if (so_luong_can_sua == 0) {
					System.out.println("Khong sua NXB");
					return;
				}
				
				if (so_luong_can_sua > NXB.length)
					return;
				
				while (so_luong_can_sua != 0) {
					System.out.print("Nhap ten NXB can sua thong tin: ");
					String tenNXB = sc.nextLine();
					Sua(tenNXB);
					so_luong_can_sua--;
					
				}
			} else
				so_luong_can_sua = -1;
		}
	}
}
