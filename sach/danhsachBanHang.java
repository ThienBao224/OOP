package sach;

import java.util.*;
import java.io.*;

public class danhsachBanHang {
	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static newBanHang BanHang[];

	public danhsachBanHang() {
	}

	public static int getSoluong() {
		return soluong;
	}

	public static void setSoluong(int sl) {
		soluong = sl;
	}

	public static newBanHang getBanHang(int i) {
		return BanHang[i];
	}
	
	public static newBanHang[] getBanHang() {
		return BanHang;
	}

	public static void setBanHang(newBanHang[] banHang) {
		BanHang = banHang;
	}
	// nhập thông tin
	public static void NhapDanhSach() {
		while (soluong == 0) {

			System.out.print("Nhap so luong Ban Hang : ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;

		}

		BanHang = new newBanHang[soluong];

		for (int i = 0; i < BanHang.length; i++) {
			BanHang[i] = new newBanHang();
			System.out.println("Nhap thong tin Ban Hang:");
			BanHang[i].Nhap();
		}

	}

	public static void DocFile(String filename) {
		try {

			FileReader readfile = new FileReader(filename);
			BufferedReader br = new BufferedReader(readfile);
			String line;
			int i;

			while ((line = br.readLine()) != null) {

				String text[] = line.split("#");

				if (BanHang == null)
					BanHang = new newBanHang[1];
				else
					BanHang = Arrays.copyOf(BanHang, BanHang.length + 1);

				i = BanHang.length - 1;

				if (text.length == 7 && text[0].matches("^BH.*") && TrungLap(text[0]) == null
						&& text[5].matches("\\d+") && text[2].matches("\\d+")&& text[6].matches("\\d+")) {
					if (BanHang[i] == null)
						BanHang[i] = new newBanHang(text[0], text[1], Integer.parseInt(text[2]),text[3], text[4],Double.parseDouble(text[5]), Integer.parseInt(text[6]),1);
					i++;

				} else
					BanHang = Arrays.copyOf(BanHang, BanHang.length - 1);

			}

			soluong = BanHang.length;
			br.close();
			readfile.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static void GhiFile(String filename) {
		try {

			FileWriter writefile = new FileWriter(filename);
			FileWriter bin = new FileWriter("BanHang_recyclebin.txt");

			int i = 0;

			if (BanHang == null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}

			while (i < BanHang.length && BanHang[i] != null) {

				if (BanHang[i].trangthai == 1)
					writefile.write(BanHang[i].getMaNV() + "#" + BanHang[i].getTen() + "#" + BanHang[i].getTuoi()
							+ "#" + BanHang[i].getGioitinh()+ "#" + BanHang[i].getChucVu() + "#" + BanHang[i].getLuong()+ "#" + BanHang[i].getSLBan()
							+ "\n");

				else
					bin.write(BanHang[i].getMaNV() + "#" + BanHang[i].getTen() + "#" + BanHang[i].getTuoi()
							+ "#" + BanHang[i].getGioitinh()+ "#" + BanHang[i].getChucVu() + "#" + BanHang[i].getLuong()+ "#" + BanHang[i].getSLBan()
							+ "\n");

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
	public static newBanHang TrungLap(String masoBanHang) {
		if (BanHang == null || BanHang[0] == null)
			return null;

		for (int i = 0; i < BanHang.length; i++)
			if (BanHang[i] != null)
				if (BanHang[i].getMaNV() != null && BanHang[i].getMaNV().equals(masoBanHang))
					return BanHang[i];

		return null;
	}

	// xuất thông tin
	public static void XuatDanhSach() {
		if (BanHang == null) {
			System.out.println("Khong co Ban Hang nao");
			return;
		}

		for (int i = 0; i < BanHang.length; i++) {
			if (BanHang[i] != null && BanHang[i].trangthai == 1) {
				System.out.println("");
				System.out.println(BanHang[i].Xuat());
			}
		}
		System.out.println("+-----------------------------------------------------------------------------------------+");
	}

	public static newBanHang[] SapXep_Ma() {
		if (BanHang == null)
			return null;

		newBanHang BanHang_sapxep[] = Arrays.copyOf(BanHang, BanHang.length);
		newBanHang tmp;

		for (int i = 0; i < BanHang_sapxep.length; i++) {
			for (int j = i + 1; j < BanHang_sapxep.length; j++) {
				if (Integer.parseInt(BanHang_sapxep[i].getMaNV().substring(2)) > Integer
						.parseInt(BanHang_sapxep[j].getMaNV().substring(2))) {
					tmp = BanHang_sapxep[i];
					BanHang_sapxep[i] = BanHang_sapxep[j];
					BanHang_sapxep[j] = tmp;
				}

			}
		}
		return BanHang_sapxep;
	}

	public static void Sapxep_TheoMa() {
		if (BanHang == null)
			return;

		newBanHang BanHang_sapxep[] = Arrays.copyOf(SapXep_Ma(), SapXep_Ma().length);

		for (int i = 0; i < BanHang_sapxep.length; i++) {

			if (BanHang_sapxep[i] != null && BanHang_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(BanHang_sapxep[i].Xuat());
			}

		}
	}

	public static newBanHang[] SapXep_Ten() {
		if (BanHang == null)
			return null;

		newBanHang BanHang_sapxep[] = Arrays.copyOf(BanHang, BanHang.length);
		newBanHang tmp;

		for (int i = 0; i < BanHang_sapxep.length; i++) {
			for (int j = 0; j < BanHang_sapxep.length - i - 1; j++) {
				String kyTu1 = BanHang_sapxep[j].getTen().substring(0, 1).toLowerCase();
				String kyTu2 = BanHang_sapxep[j + 1].getTen().substring(0, 1).toLowerCase();

				if (kyTu1.compareTo(kyTu2) > 0) {
					tmp = BanHang_sapxep[j];
					BanHang_sapxep[j] = BanHang_sapxep[j + 1];
					BanHang_sapxep[j + 1] = tmp;
				}
			}
		}
		return BanHang_sapxep;
	}

	public static void Sapxep_TheoTen() {
		if (BanHang == null)
			return;

		newBanHang BanHang_sapxep[] = Arrays.copyOf(SapXep_Ten(), SapXep_Ten().length);

		for (int i = 0; i < BanHang_sapxep.length; i++) {

			if (BanHang_sapxep[i] != null && BanHang_sapxep[i].trangthai == 1) {
				System.out.println("");
				System.out.println(BanHang_sapxep[i].Xuat());
			}

		}
	}

	// thêm thông tin đối tượng
	public static newBanHang Them(newBanHang newBanHang) {
		if(TrungLap(newBanHang.getMaNV())!=null)
			return null;
		int i;

		if (BanHang == null)
			BanHang = new newBanHang[1];

		else
			BanHang = Arrays.copyOf(BanHang, BanHang.length + 1);

		i = BanHang.length - 1;
		BanHang[i] = new newBanHang();
		BanHang[i]=newBanHang;
		soluong = BanHang.length;

		return BanHang[i];
	}
	public static newBanHang Them() {
		int i;

		if (BanHang == null)
			BanHang = new newBanHang[1];

		else
			BanHang = Arrays.copyOf(BanHang, BanHang.length + 1);

		i = BanHang.length - 1;
		BanHang[i] = new newBanHang();

		System.out.println("nhap thong tin Ban Hang ");

		BanHang[i].Nhap();
		soluong = BanHang.length;

		return BanHang[i];
	}

	public static void Them_BanHang() {
		int so_luong_can_them = -1;

		while (so_luong_can_them == -1) {

			System.out.print("Nhap so luong Ban Hang can them: ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);

				if (so_luong_can_them == 0) {
					if (BanHang == null)
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
	public static int TimKiem(String masoBanHang) {
		for (int i = 0; i < BanHang.length; i++) {
			if (BanHang[i].trangthai == 1 && BanHang[i].getMaNV() != null && BanHang[i].getMaNV().equals(masoBanHang))
				return i;
		}

		return -1;

	}

	public static void TimKiem_BanHang() {
		System.out.print("Nhap ma so Ban Hang can tim: ");
		String masoBanHang = sc.nextLine();

		int i = TimKiem(masoBanHang);

		while (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());

			if (luachon == 1)
				TimKiem_BanHang();

			else
				return;

		}

		System.out.println(BanHang[i].Xuat());

	}

	// xóa thông tin(xóa giả => ẩn thông tin)
	public static void Xoa() {
		System.out.print("Nhap ma Ban Hang can xoa: ");
		String masoBanHang = sc.nextLine();

		int i = TimKiem(masoBanHang);

		if (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());

			if (luachon == 1)
				Xoa();

		} else {
			BanHang[i].trangthai = 0;
			return;
		}

	}

	public static void Xoa_BanHang() {
		if (BanHang == null) {
			System.out.println("Danh sach rong");
			return;
		}

		int so_luong_can_xoa = -1;

		while (so_luong_can_xoa == -1) {

			System.out.print("Nhap so luong Ban Hang can xoa (Khong vuot qua " + BanHang.length + "): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_xoa = Integer.parseInt(sl);

				if (so_luong_can_xoa == 0) {
					System.out.println("Khong xoa Ban Hang");
					return;
				}

				if (so_luong_can_xoa > BanHang.length)
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
	public static newBanHang KhoiPhuc(String maBanHang_cankhoiphuc) {
		int i;

		for (i = 0; i < BanHang.length; i++)
			if (BanHang[i].getMaNV() != null && BanHang[i].getMaNV().equals(maBanHang_cankhoiphuc)
					&& BanHang[i].trangthai == 0) {
				BanHang[i].trangthai = 1;
				return BanHang[i];
			}

		return null;
	}

	public static void KhoiPhuc_BanHang() {
		if (BanHang == null) {
			System.out.println("Danh sach rong");
			return;
		}

		int soluong_BanHang_cankhoiphuc = -1;

		while (soluong_BanHang_cankhoiphuc == -1) {

			System.out.print("Nhap so luong Ban Hang can khoi phuc (Khong vuot qua " + BanHang.length + "): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				soluong_BanHang_cankhoiphuc = Integer.parseInt(sl);

				if (soluong_BanHang_cankhoiphuc > BanHang.length)
					return;

				for (int i = 0; i < soluong_BanHang_cankhoiphuc; i++) {

					System.out.print("Nhap ma Ban Hang can khoi phuc: ");
					String maBanHang_cankhoiphuc = sc.nextLine();

					KhoiPhuc(maBanHang_cankhoiphuc);
				}

			} else
				soluong_BanHang_cankhoiphuc = -1;
		}

	}

	// sửa thông tin
	public static newBanHang Sua(String maso_BanHang_cansua) {
		int i = TimKiem(maso_BanHang_cansua);

		if (i == -1) {

			System.out.println("Khong tim thay");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");

			int luachon = Integer.parseInt(sc.nextLine());

			if (luachon == 1) {
				System.out.print("Nhap Ma so Ban Hang can sua thong tin: ");
				return Sua(sc.nextLine());

			} else
				return null;

		}

		int so_luong_thong_tin_can_sua = -1;

		while (so_luong_thong_tin_can_sua == -1) {

			System.out.print("Ban muon sua bao nhieu thong tin cua Ban Hang (toi da 5): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_thong_tin_can_sua = Integer.parseInt(sl);

				if (so_luong_thong_tin_can_sua > 5)
					return null;

				while (so_luong_thong_tin_can_sua != 0) {
					System.out.println("Sua thong tin cua Ban Hang '" + BanHang[i].getTen() + "'");
					BanHang[i].SuaThongTin();
					so_luong_thong_tin_can_sua--;
				}

			} else
				so_luong_thong_tin_can_sua = -1;
		}

		return BanHang[i];
	}

	public static void Sua_BanHang() {
		if (BanHang == null) {
			System.out.println("Danh sach rong");
			return;
		}

		int so_luong_can_sua = -1;

		while (so_luong_can_sua == -1) {
			System.out.print("Nhap so luong Ban Hang can sua (Khong vuot qua " + BanHang.length + "): ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_sua = Integer.parseInt(sl);

				if (so_luong_can_sua == 0) {
					System.out.println("Khong sua Ban Hang");
					return;
				}

				if (so_luong_can_sua > BanHang.length)
					return;

				while (so_luong_can_sua != 0) {
					System.out.print("Nhap ma so Ban Hang sua: ");
					String maso_BanHang_cansua = sc.nextLine();
					Sua(maso_BanHang_cansua);
					so_luong_can_sua--;
				}

			} else
				so_luong_can_sua = -1;
		}
	}

}
