package sach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class danhsachSach {
	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static newSach Sach[];

	public danhsachSach() {
	}

	public static int getSoluong() {
		return soluong;
	}

	public static void setSoluong(int soluong) {
		danhsachSach.soluong = soluong;
	}
	//dùng cho hàm tìm kiếm
	public static newSach getSach(int i) {
		return Sach[i];
	}
	public static newSach[] getSach() {
		return Sach;
	}

	public static void setSach(newSach[] sach) {
		Sach = sach;
	}

	// nhập thông tin
	public static void NhapDanhSach() {
		while (soluong == 0) {
			System.out.print("Nhap so luong Sach: ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;
		}
		Sach = new newSach[soluong];
		for (int i = 0; i < Sach.length; i++) {
			Sach[i] = new newSach();
			System.out.println("Nhap thong tin Sach");
			Sach[i].Nhap();
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
				if (Sach == null)
					Sach = new newSach[1];
				else
					Sach = Arrays.copyOf(Sach, Sach.length + 1);
				i = Sach.length - 1;
				if (text.length == 8 && TrungLap(text[0]) == null && !text[3].matches(".\\d.*")
						&& text[6].matches("\\d+\\d*\\.?\\,?") && text[7].matches("\\d+")
						&& danhsachTacGia.TrungLap(text[3]) != null && danhsachNXB.TrungLap(text[4]) != null
						&& danhsachTheLoai.TrungLap(text[5]) != null) {
					if (Sach[i] == null)
						Sach[i] = new newSach(text[0], text[1], danhsachTacGia.TrungLap(text[3]),
								danhsachNXB.TrungLap(text[4]), danhsachTheLoai.TrungLap(text[5]),
								Double.parseDouble(text[6]), Integer.parseInt(text[7]), 1);
					// Sach[i].capnhatSach(text[0], text[1], danhsachTacGia.Trunglap(text[3]),
					// danhsachNXB.Trunglap(text[4]), danhsachTheLoai.Trunglap(text[5]),
					// Double.parseDouble(text[6]), Integer.parseInt(text[7]), 1);
					i++;
				} else
					Sach = Arrays.copyOf(Sach, Sach.length - 1);
			}
			soluong = Sach.length;
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
			FileWriter bin = new FileWriter("Sach_recyclebin.txt");
			int i = 0;
			if (Sach == null) {
				System.out.println("Danh Sach rong");
				writefile.close();
				bin.close();
				return;
			}
			while (i < Sach.length && Sach[i] != null) {
				if (Sach[i].trangthai == 1)
					writefile
							.write(Sach[i].getTenSach() + "#" + Sach[i].getMaSach() + "#" + Sach[i].getTacGia().getTen()
									+ "#" + Sach[i].getNXB().getTenNXB() + "#" + Sach[i].getTheLoai().getTenTheLoai()
									+ "#" + Sach[i].getGiaban() + "#" + Sach[i].getSoluong() + "\n");
				else
					bin.write(Sach[i].getTenSach() + "#" + Sach[i].getMaSach() + "#" + Sach[i].getTacGia().getTen()
							+ "#" + Sach[i].getNXB().getTenNXB() + "#" + Sach[i].getTheLoai().getTenTheLoai() + "#"
							+ Sach[i].getGiaban() + "#" + Sach[i].getSoluong() + "\n");
				i++;
			}
			writefile.close();
			bin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// tìm kiếm thông tin bị trùng lặp
	public static newSach TrungLap(String maSach) {
		if (Sach == null || Sach[0] == null)
			return null;
		for (int i = 0; i < Sach.length; i++)
			if (Sach[i] != null)
				if (Sach[i].getMaSach() != null && Sach[i].getMaSach().equals(maSach))
					return Sach[i];
		return null;
	}

	// xuất thông tin
	public static void XuatDanhSach() {
		if (Sach == null) {
			System.out.println("Khong co Sach nao");
			return;
		}
		for (int i = 0; i < Sach.length; i++) {
			if (Sach[i] != null && Sach[i].trangthai == 1) {
				System.out.println("");
				System.out.println(Sach[i].Xuat());
			}
		}System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
	}
	//sắp xếp theo mã sách
	public static newSach[] SapXep_Ma() {
		if (Sach == null || Sach.length <= 1)
			return Sach;

		newSach Sach_sapxep[] = Arrays.copyOf(Sach, Sach.length);
		newSach tmp;

		for (int i = 0; i < Sach_sapxep.length; i++) {
			for (int j = 0; j < Sach_sapxep.length - i - 1; j++) {
				String maSach1 = Sach_sapxep[j].getMaSach().toLowerCase();
				String maSach2 = Sach_sapxep[j + 1].getMaSach().toLowerCase();

				if (maSach1.compareTo(maSach2) > 0) {
					tmp = Sach_sapxep[j];
					Sach_sapxep[j] = Sach_sapxep[j + 1];
					Sach_sapxep[j + 1] = tmp;
				}
			}
		}
		return Sach_sapxep;
	}

	public static void SapXep_TheoMa() {
		if (Sach == null)
			return;

		newSach Sach_sapxep[] = Arrays.copyOf(SapXep_Ma(), SapXep_Ma().length);

		for (int i = 0; i < Sach_sapxep.length; i++) {

			if (Sach_sapxep[i] != null && Sach_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(Sach_sapxep[i].Xuat());
			}

		}
	}
	//sắp xếp theo tên sách
	public static newSach[] SapXep_Ten() {
		if (Sach == null)
			return null;

		newSach Sach_sapxep[] = Arrays.copyOf(Sach, Sach.length);
		newSach tmp;

		for (int i = 0; i < Sach_sapxep.length; i++) {
			for (int j = 0; j < Sach_sapxep.length - i - 1; j++) {
				String kyTu1 = Sach_sapxep[j].getTenSach().substring(0, 1).toLowerCase();
				String kyTu2 = Sach_sapxep[j + 1].getTenSach().substring(0, 1).toLowerCase();

				if (kyTu1.compareTo(kyTu2) > 0) {
					tmp = Sach_sapxep[j];
					Sach_sapxep[j] = Sach_sapxep[j + 1];
					Sach_sapxep[j + 1] = tmp;
				}
			}
		}
		return Sach_sapxep;
	}

	public static void SapXep_TheoTen() {
		if (Sach == null)
			return;
		newSach Sach_sapxep[] = Arrays.copyOf(SapXep_Ten(), SapXep_Ten().length);

		for (int i = 0; i < Sach_sapxep.length; i++) {

			if (Sach_sapxep[i] != null && Sach_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(Sach_sapxep[i].Xuat());
			}

		}
	}
	public static newSach Them(newSach newSach) {
		if(TrungLap(newSach.getMaSach())!=null)
			return null;
		int i;
		if (Sach == null || Sach[0] == null)
			Sach = new newSach[1];
		else
			Sach = Arrays.copyOf(Sach, Sach.length + 1);
		i = Sach.length - 1;
		Sach[i] = new newSach();
		Sach[i]=newSach;
		soluong = Sach.length;
		return Sach[i];
	}
	// thêm thông tin đối tượng
	public static newSach Them() {
		int i;
		if (Sach == null || Sach[0] == null)
			Sach = new newSach[1];
		else
			Sach = Arrays.copyOf(Sach, Sach.length + 1);
		i = Sach.length - 1;
		Sach[i] = new newSach();
		System.out.println("nhap thong tin Sach");
		Sach[i].Nhap();
		soluong = Sach.length;
		return Sach[i];
	}

	public static void Them_Sach() {
		int so_luong_can_them = -1;
		while (so_luong_can_them == -1) {
			System.out.print("So Luong Sach can them: ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);
				if (so_luong_can_them == 0) {
					if (Sach == null)
						System.out.println("Danh Sach rong");
					else
						System.out.println("Khong them Sach");
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
	public static int TimKiem(String maSach) {
		for (int i = 0; i < Sach.length; i++) {
			if (Sach[i] != null && Sach[i].trangthai == 1 && Sach[i].getMaSach() != null
					&& Sach[i].getMaSach().equals(maSach))
				return i;
		}
		return -1;
	}

	public static void TimKiem_Sach() {
		if (Sach == null) {
			System.out.println("Danh Sach rong");
			return;
		}
		System.out.print("Nhap ma Sach can tim: ");
		String maSach = sc.nextLine();
		int i = TimKiem(maSach);
		while (i == -1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon = Integer.parseInt(sc.nextLine());
			if (luachon == 1)
				TimKiem_Sach();
			else
				return;
		}
		System.out.println(Sach[i].Xuat());
	}

	// xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ma Sach can xoa: ");
		String maSach = sc.nextLine();
		int i = TimKiem(maSach);
		if (i == -1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon = Integer.parseInt(sc.nextLine());
			if (luachon == 1)
				Xoa();
		} else {
			Sach[i].trangthai = 0;
			return;
		}
	}

	public static void Xoa_Sach() {
		if (Sach == null) {
			System.out.println("Danh Sach rong");
			return;
		}
		int so_luong_can_xoa = -1;
		while (so_luong_can_xoa == -1) {
			System.out.print("Nhap so luong Sach can xoa thong tin(khong vuot qua " + Sach.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_can_xoa = Integer.parseInt(sl);
				if (so_luong_can_xoa == 0) {
					System.out.println("Khong xoa Sach");
					return;
				}
				if (so_luong_can_xoa > Sach.length)
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
	public static newSach KhoiPhuc(String maSach_cankhoiphuc) {
		for (int i = 0; i < Sach.length; i++)
			if (Sach[i].getMaSach() != null && Sach[i].getMaSach().equals(maSach_cankhoiphuc)
					&& Sach[i].trangthai == 0) {
				Sach[i].trangthai = 1;
				return Sach[i];
			}
		return null;
	}

	public static void KhoiPhuc_Sach() {
		if (Sach == null) {
			System.out.println("Danh Sach rong");
			return;
		}
		int soluong_Sach_cankhoiphuc = -1;
		while (soluong_Sach_cankhoiphuc == -1) {
			System.out.print("Nhap so luong Sach can khoi phuc thong tin(khong vuot qua " + Sach.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soluong_Sach_cankhoiphuc = Integer.parseInt(sl);
				if (soluong_Sach_cankhoiphuc > Sach.length)
					return;
				for (int i = 0; i < soluong_Sach_cankhoiphuc; i++) {
					System.out.print("Nhap ma Sach can khoi phuc: ");
					String tenSach_cankhoiphuc = sc.nextLine();
					KhoiPhuc(tenSach_cankhoiphuc);
				}
			} else
				soluong_Sach_cankhoiphuc = -1;
		}
	}

	// sửa thông tin
	public static newSach Sua(String ten_Sach_cansua) {
		int i = TimKiem(ten_Sach_cansua);
		if (i == -1) {
			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int luachon = Integer.parseInt(sc.nextLine());
			System.out.print("Nhap Ma Sach can sua thong tin: ");
			switch (luachon) {
			case 1:
				System.out.print("Nhap Ma Sach can sua thong tin: ");
				return Sua(sc.nextLine());
			default:
				return null;
			}
		}
		int so_luong_thong_tin_can_sua = -1;
		while (so_luong_thong_tin_can_sua == -1) {
			System.out.println("Ban muon sua bao nhieu thong tin cua Sach(toi da 7): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua = Integer.parseInt(sl);
				if (so_luong_thong_tin_can_sua > 7)
					return null;
				while (so_luong_thong_tin_can_sua != 0) {
					System.out.println("Sua thong tin cua Sach '" + Sach[i].getTenSach() + "'");
					Sach[i].SuaThongTin();
					so_luong_thong_tin_can_sua--;
				}
			} else
				so_luong_thong_tin_can_sua = -1;
		}
		return Sach[i];
	}

	public static void Sua_Sach() {
		if (Sach == null) {
			System.out.println("Danh Sach rong");
			return;
		}
		int so_luong_can_sua = -1;
		while (so_luong_can_sua == -1) {
			System.out.print("Nhap so luong Sach can sua thong tin(khong vuot qua " + Sach.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				so_luong_can_sua = Integer.parseInt(sl);
				if (so_luong_can_sua == 0) {
					System.out.println("Khong sua Sach");
					return;
				}
				if (so_luong_can_sua > Sach.length)
					return;
				while (so_luong_can_sua != 0) {
					System.out.print("Nhap Ma Sach can sua thong tin: ");
					String maso_Sach_cansua = sc.nextLine();
					Sua(maso_Sach_cansua);
					so_luong_can_sua--;
				}
			} else
				so_luong_can_sua = -1;
		}
	}
}
