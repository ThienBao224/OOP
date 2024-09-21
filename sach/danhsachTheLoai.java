package sach;

import java.io.*;
import java.util.*;

public class danhsachTheLoai {
	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static newTheLoai TheLoai[];

	public danhsachTheLoai() {
	}

	public static int getSoluong() {
		return soluong;
	}

	public static void setSoluong(int sl) {
		soluong = sl;
	}
	
	public static newTheLoai getTheLoai(int i) {
		return TheLoai[i];
	}
	
	public static newTheLoai[] getTheLoai() {
		return TheLoai;
	}

	public static void setTheLoai(newTheLoai[] theLoai) {
		TheLoai = theLoai;
	}

	// nhập thông tin
	public static void NhapDanhSach() {
		while (soluong == 0) {
			
			System.out.print("Nhap so luong The loai: ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;
			
		}
		
		TheLoai = new newTheLoai[soluong];
		
		for (int i = 0; i < TheLoai.length; i++) {
			TheLoai[i] = new newTheLoai();
			System.out.println("Nhap thong tin The loai");
			TheLoai[i].Nhap();
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
				
				if (TheLoai == null)
					TheLoai = new newTheLoai[1];
				else
					TheLoai = Arrays.copyOf(TheLoai, TheLoai.length + 1);
				
				i = TheLoai.length - 1;
				
				if (text.length == 2 && TrungLap(text[0]) == null && !text[0].isEmpty()) {
					if (TheLoai[i] == null)
						TheLoai[i] = new newTheLoai(text[0], text[1], 1);
					// TheLoai[i].capnhatTheLoai(text[0],text[1], 1);
					i++;
					
				} else
					TheLoai = Arrays.copyOf(TheLoai, TheLoai.length - 1);
				
			}
			
			soluong = TheLoai.length;
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
			FileWriter bin = new FileWriter("TheLoai_recyclebin.txt");
			int i = 0;
			
			if (TheLoai == null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}
			while (i < TheLoai.length && TheLoai[i] != null) {
				if (TheLoai[i].trangthai == 1)
					writefile.write(TheLoai[i].getTenTheLoai() + "#" + TheLoai[i].getMota() + "\n");
				else
					bin.write(TheLoai[i].getTenTheLoai() + "#" + TheLoai[i].getMota() + "\n");
				i++;
			}
			
			writefile.close();
			bin.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// trùng lặp được cho phép
	public static newTheLoai TrungLap(String tenTheLoai) {
		if (TheLoai == null || TheLoai[0] == null)
			return null;
		
		for (int i = 0; i < TheLoai.length; i++)
			if (TheLoai[i] != null)
				if (TheLoai[i].getTenTheLoai() != null && TheLoai[i].getTenTheLoai().equals(tenTheLoai))
					return TheLoai[i];
		
		return null;
	}

	// xuất thông tin
	public static void XuatDanhSach() {
		if (TheLoai.length == 0) {
			System.out.println("Khong co The loai nao");
			return;
		}
		
		for (int i = 0; i < TheLoai.length; i++) {
			if (TheLoai[i] != null && TheLoai[i].trangthai == 1) {
				System.out.println("");
				System.out.println(TheLoai[i].Xuat());
			}
		}System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
	}
	//sắp xếp theo tên
	public static newTheLoai[] SapXep_Ten() {
		if (TheLoai == null)
			return null;

		newTheLoai TheLoai_sapxep[] = Arrays.copyOf(TheLoai, TheLoai.length);
		newTheLoai tmp;

		for (int i = 0; i < TheLoai_sapxep.length; i++) {
			for (int j = 0; j < TheLoai_sapxep.length - i - 1; j++) {
				String kyTu1 = TheLoai_sapxep[j].getTenTheLoai().substring(0, 1).toLowerCase();
				String kyTu2 = TheLoai_sapxep[j + 1].getTenTheLoai().substring(0, 1).toLowerCase();

				if (kyTu1.compareTo(kyTu2) > 0) {
					tmp = TheLoai_sapxep[j];
					TheLoai_sapxep[j] = TheLoai_sapxep[j + 1];
					TheLoai_sapxep[j + 1] = tmp;
				}
			}
		}
		return TheLoai_sapxep;
	}

	public static void SapXep_TheoTen() {
		if (TheLoai == null)
			return;

		newTheLoai TheLoai_sapxep[] = Arrays.copyOf(SapXep_Ten(), SapXep_Ten().length);

		for (int i = 0; i < TheLoai_sapxep.length; i++) {

			if (TheLoai_sapxep[i] != null && TheLoai_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(TheLoai_sapxep[i].Xuat());
			}

		}
	}
	public static newTheLoai Them(newTheLoai newTheLoai) {
		if(TrungLap(newTheLoai.getTenTheLoai())!=null)
			return null;
		int i;
		
		if (TheLoai == null)
			TheLoai = new newTheLoai[1];
		else
			TheLoai = Arrays.copyOf(TheLoai, TheLoai.length + 1);
		
		i = TheLoai.length - 1;
		TheLoai[i] = new newTheLoai();
		
		TheLoai[i]=newTheLoai;
		soluong = TheLoai.length;
		
		return TheLoai[i];
		
	}
	// thêm thông tin đối tượng
	public static newTheLoai Them() {
		int i;
		
		if (TheLoai == null)
			TheLoai = new newTheLoai[1];
		else
			TheLoai = Arrays.copyOf(TheLoai, TheLoai.length + 1);
		
		i = TheLoai.length - 1;
		TheLoai[i] = new newTheLoai();
		
		System.out.println("nhap thong tin the loai");
		
		TheLoai[i].Nhap();
		soluong = TheLoai.length;
		
		return TheLoai[i];
		
	}

	public static void Them_TheLoai() {
		int so_luong_can_them = -1;
		
		while (so_luong_can_them == -1) {
			
			System.out.print("So Luong the loai can them: ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);
				
				if (so_luong_can_them == 0) {
					if (TheLoai == null)
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
	public static int TimKiem(String tenTheLoai) {
		for (int i = 0; i < TheLoai.length; i++) {
			if (TheLoai[i].trangthai == 1 && TheLoai[i].getTenTheLoai().equals(tenTheLoai))
				return i;
		}
		
		return -1;
	}

	public static void TimKiem_TheLoai() {
		if (TheLoai == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		System.out.print("Nhap ten the loai can tim: ");
		String tenTheLoai = sc.nextLine();
		
		int i = TimKiem(tenTheLoai);
		
		while (i == -1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon = Integer.parseInt(sc.nextLine());
			if (luachon == 1)
				TimKiem_TheLoai();
			else
				return;
		}
		
		System.out.println(TheLoai[i].Xuat());
	}

	// xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ten the loai can xoa: ");
		String tenTheLoai = sc.nextLine();
		
		int i = TimKiem(tenTheLoai);
		
		if (i == -1) {
			
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			
			int luachon = Integer.parseInt(sc.nextLine());
			if (luachon == 1)
				Xoa();
			
		} else {
			TheLoai[i].trangthai = 0;
			return;
		}
		
	}

	public static void Xoa_TheLoai() {
		if (TheLoai == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int so_luong_can_xoa = -1;
		
		while (so_luong_can_xoa == -1) {
			System.out.print("Nhap so luong the loai can xoa thong tin(khong vuot qua " + TheLoai.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_can_xoa = Integer.parseInt(sl);

				if (so_luong_can_xoa == 0) {
					System.out.println("Khong xoa The loai");
					return;
				}
				if (so_luong_can_xoa > TheLoai.length)
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
	public static newTheLoai KhoiPhuc(String tenTheLoai_cankhoiphuc) {
		int i;
		for (i = 0; i < TheLoai.length; i++)
			if (TheLoai[i].getTenTheLoai() != null && TheLoai[i].getTenTheLoai().equals(tenTheLoai_cankhoiphuc)
					&& TheLoai[i].trangthai == 0) {
				TheLoai[i].trangthai = 1;
				return TheLoai[i];
			}
		return null;
	}

	public static void KhoiPhuc_TheLoai() {
		if (TheLoai == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int soluong_TheLoai_cankhoiphuc = -1;
		
		while (soluong_TheLoai_cankhoiphuc == -1) {
			System.out.print("Nhap so luong the loai can khoi phuc thong tin(khong vuot qua " + TheLoai.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				soluong_TheLoai_cankhoiphuc = Integer.parseInt(sl);
				if (soluong_TheLoai_cankhoiphuc > TheLoai.length)
					return;
				
				for (int i = 0; i < soluong_TheLoai_cankhoiphuc; i++) {
					System.out.print("Nhap ten the loai can khoi phuc: ");
					String tenTheLoai_cankhoiphuc = sc.nextLine();
					KhoiPhuc(tenTheLoai_cankhoiphuc);
				}
				
			} else
				soluong_TheLoai_cankhoiphuc = -1;
		}
	}

	// sửa thông tin
	public static newTheLoai Sua(String ten_TheLoai_cansua) {
		int i = TimKiem(ten_TheLoai_cansua);
		
		if (i == -1) {
			
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			
			int luachon = Integer.parseInt(sc.nextLine());
			
			if (luachon == 1) {
				System.out.print("Nhap Ten the loai can sua thong tin: ");
				return Sua(sc.nextLine());
			} else
				return null;
			
		}
		int so_luong_thong_tin_can_sua = -1;
		
		while (so_luong_thong_tin_can_sua == -1) {
			
			System.out.print("Ban muon sua bao nhieu thong tin cua the loai (toi da 2): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua = Integer.parseInt(sl);
				
				if (so_luong_thong_tin_can_sua > 2)
					return null;
				
				while (so_luong_thong_tin_can_sua != 0) {
					System.out.println("Sua thong tin cua The loai '" + TheLoai[i].getTenTheLoai() + "'");
					TheLoai[i].SuaThongTin();
					so_luong_thong_tin_can_sua--;
				}
				
			} else
				so_luong_thong_tin_can_sua = -1;
		}
		return TheLoai[i];
	}

	public static void Sua_TheLoai() {
		if (TheLoai == null) {
			System.out.println("Danh sach rong");
			return;
		}
		
		int so_luong_can_sua = -1;
		
		while (so_luong_can_sua == -1) {
			
			System.out.print("Nhap so luong the loai can sua thong tin(khong vuot qua " + TheLoai.length + "): ");
			String sl = sc.nextLine();
			
			if (sl.matches("\\d+")) {
				so_luong_can_sua = Integer.parseInt(sl);
				
				if (so_luong_can_sua == 0) {
					System.out.println("Khong sua the loai");
					return;
				}
				
				if (so_luong_can_sua > TheLoai.length)
					return;
				
				while (so_luong_can_sua != 0) {
					System.out.print("Nhap ten the loai can sua thong tin: ");
					String ten_TheLoai_cansua = sc.nextLine();
					Sua(ten_TheLoai_cansua);
					so_luong_can_sua--;
				}
				
			} else
				so_luong_can_sua = -1;
		}
	}
}
