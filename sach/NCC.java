package sach;

import java.util.*;

public class NCC implements DanhSach{
	public Scanner sc = new Scanner(System.in);
	private String tenNCC;
	private String dcNCC;
	private String sdtNCC;
	public int trangthai;

	public NCC() {
	}

	public NCC(String tenNCC, String sdtNCC, String dcNCC, int trangthai) {
		this.tenNCC = tenNCC;
		this.dcNCC = dcNCC;
		this.sdtNCC = sdtNCC;
		this.trangthai = trangthai;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDcNCC() {
		return dcNCC;
	}

	public void setDcNCC(String dcNCC) {
		this.dcNCC = dcNCC;
	}

	public String getsdtNCC() {
		return sdtNCC;
	}

	public void setsdtNCC(String sdtNCC) {
		this.sdtNCC = sdtNCC;
	}

	public void Nhap() {
		while (this.tenNCC == null || this.tenNCC.isEmpty()) {
			System.out.print("Nhap Ten NCC sach: ");
			String newtenNCC = sc.nextLine();

			this.tenNCC = newtenNCC;
			break;
		}

		while (this.sdtNCC == null || this.sdtNCC.isEmpty()) {
			System.out.print("Nhap So dien thoai NCC: ");
			String newsdtNCC = sc.nextLine();

			if (newsdtNCC.matches("\\d+"))
				this.sdtNCC = newsdtNCC;
			else
				this.sdtNCC = null;

		}

		while (this.dcNCC == null || this.dcNCC.isEmpty()) {
			System.out.print("Nhap Dia chi NCC: ");
			this.dcNCC = sc.nextLine();
		}

		this.trangthai = 1;
	}

	public void SuaThongTin() {
		System.out.println("1.Sua ten NCC");
		System.out.println("2.Sua So dien thoai NBX");
		System.out.println("3.Sua Dia chi NCC");
		System.out.print("Nhap lua chon: ");

		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;

		switch (luachon) {
		case 1:
			while (!exitLoop) {
				System.out.println("Nhap ten NCC moi");
				String newtenNCC = sc.nextLine();

				if (!this.tenNCC.equals(newtenNCC)) {
					this.tenNCC = newtenNCC;
					exitLoop = true;
				}

			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.print("Nhap so dien thoai moi cua NCC: ");
				String newsdtNCC = sc.nextLine();

				if (newsdtNCC.matches("\\d+") && !newsdtNCC.equals(sdtNCC)) {
					this.sdtNCC = newsdtNCC;
					exitLoop = true;
				}

			}
			break;
		case 3:
			while (!exitLoop) {
				System.out.print("Nhap Dia chi moi cua NCC: ");
				String newdcNCC = sc.nextLine();

				if (!newdcNCC.equals(dcNCC)) {
					this.dcNCC = newdcNCC;
					exitLoop = true;
				}

			}
			break;
		default:
			break;
		}
	}

	public void CapNhat_NCC(String tenNCC, String sdtNCC, String dcNCC, int trangthai) {
		this.tenNCC = tenNCC;
		this.dcNCC = dcNCC;
		this.sdtNCC = sdtNCC;
		this.trangthai = trangthai;
	}

	public String Xuat() {
		return String.format("Ten NCC: %-21s | So dien thoai NCC: %-16s | Dia chia NCC: %s", tenNCC, sdtNCC, dcNCC);
	}
}
