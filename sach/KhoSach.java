package sach;

import java.util.*;

public class KhoSach  {
	public static Scanner sc = new Scanner(System.in);
	// public Menu_NhapKho(){}

	public static void Menu() {
		if (danhsachSach.getSach() == null) {
			System.out.println("Kho trong");
			return;
		}

		System.out.println("1.Tiem kiem sach trong kho");
		System.out.println("2.Sap xep sach trong kho");
		System.out.println("3.Xem Sach trong Kho");
		System.out.println("4.Thoat");
		System.out.print("Nhap lua chon: ");

		int luachon = Integer.parseInt(sc.nextLine());

		switch (luachon) {
		case 1:
			danhsachSach.TimKiem_Sach();
			break;
		case 2:
			System.out.println("1.Sap xep theo Ma So Sach");
			System.out.println("2.Sap xep theo Ten Sach");
			System.out.println("3.Khong sap xep");
			System.out.print("Nhap lua chon: ");

			int a = Integer.parseInt(sc.nextLine());

			switch (a) {
			case 1:
				danhsachSach.SapXep_Ma();
				break;
			case 2:
				danhsachSach.SapXep_Ten();
				break;
			default:
				break;
			}
			break;
		case 3:
			System.out.println("1.Xem sach tu man hinh");
			System.out.println("2.Xem sach trong file");
			System.out.println("3.Thoat");
			System.out.print("Nhap lua chon: ");

			int b = Integer.parseInt(sc.nextLine());

			switch (b) {
			case 1:
				danhsachSach.XuatDanhSach();
				;
				break;
			case 2:
				danhsachSach.GhiFile("D:\\java\\java_project\\src\\sach\\sach_ghi.txt");
				;
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}
}