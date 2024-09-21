package sach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NhapKho {
	public static Scanner sc = new Scanner(System.in);
	// public Menu_NhapKho(){}
	private static Date ngayNhap;
	
	public NhapKho() {
		// TODO Auto-generated constructor stub
	}

	public static Date getNgayNhap() {
		return ngayNhap;
	}

	public static void setNgayNhap(Date ngayNhap) {
		NhapKho.ngayNhap = ngayNhap;
	}
	
	private static String FormatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
	public static void Menu() {
		while (true) {
            System.out.print("Nhap ngay Nhap (dd/MM/yyyy): ");
            String strngayNhap = sc.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // check ngay thang nam
                ngayNhap = dateFormat.parse(strngayNhap);
                break; // Ngay dat hop le, thoat khoi vong lap
            } catch (ParseException e) {
                System.out.println("Ngay Nhap khong hop le. Vui long nhap theo dinh dang dd/MM/yyyy.");
            }
        }
		if (danhsachSach.getSach() == null) {
			System.out.println("Kho trong hay nhap sach vao kho: ");
			System.out.println("1.Nhap sach vao kho");
			System.out.println("2.Thoat");
			System.out.print("Nhap lua chon: ");

			int luachon = Integer.parseInt(sc.nextLine());

			switch (luachon) {
			case 1:
				System.out.println("1: Nhap tu ban phim");
				System.out.println("2. Nhap bang file");
				System.out.println("3.Thoat");
				System.out.print("Nhap lua chon: ");

				int a = Integer.parseInt(sc.nextLine());

				switch (a) {
				case 1:
					danhsachSach.NhapDanhSach();
					break;
				case 2:
					danhsachNXB.DocFile("D:\\java\\java_project\\src\\sach\\NXB_doc.txt");
					danhsachTheLoai.DocFile("D:\\java\\java_project\\src\\sach\\TheLoai_doc.txt");
					danhsachTacGia.DocFile("D:\\java\\java_project\\src\\sach\\TacGia_doc.txt");
					danhsachSach.DocFile("D:\\java\\java_project\\src\\sach\\sach_doc.txt");
				default:
					break;
				}
				break;
			default:
				break;
			}
		} else {
			System.out.println("1.Them Sach vao Kho");
			System.out.println("2.Sua Sach trong Kho");
			System.out.println("3.Xoa Sach trong Kho");
			System.out.println("4.Thoat");
			System.out.print("Nhap lua chon: ");

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
			default:
				break;
			}
		}
		System.out.println("Cap nhat kho thanh cong vao ngay("+FormatDate(ngayNhap)+")");
	}
}
