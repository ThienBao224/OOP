package sach;

import java.util.*;

public class NXB implements DanhSach{
	public Scanner sc = new Scanner(System.in);
	private String tenNXB;
	private String dcNXB;
	private String sdtNXB;
	public int trangthai;

	public NXB() {
	}

	public NXB(String tenNXB, String sdtNXB, String dcNXB, int trangthai) {
		this.tenNXB = tenNXB;
		this.dcNXB = dcNXB;
		this.sdtNXB = sdtNXB;
		this.trangthai = trangthai;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}

	public String getDcNXB() {
		return dcNXB;
	}

	public void setDcNXB(String dcNXB) {
		this.dcNXB = dcNXB;
	}

	public String getsdtNXB() {
		return sdtNXB;
	}

	public void setsdtNXB(String sdtNXB) {
		this.sdtNXB = sdtNXB;
	}

	public void Nhap() {
		while (this.tenNXB == null || this.tenNXB.isEmpty()) {
			System.out.print("Nhap Ten NXB sach: ");
			String newtenNXB = sc.nextLine();
			
			this.tenNXB = newtenNXB;
			break;
		}
		
		while (this.sdtNXB == null || this.sdtNXB.isEmpty()) {
			System.out.print("Nhap So dien thoai NXB: ");
			String newsdtNXB = sc.nextLine();
			
			if (newsdtNXB.matches("\\d+"))
				this.sdtNXB = newsdtNXB;
			else
				this.sdtNXB = null;
			
		}
		
		while (this.dcNXB == null || this.dcNXB.isEmpty()) {
			System.out.print("Nhap Dia chi NXB: ");
			this.dcNXB = sc.nextLine();
		}
		
		this.trangthai = 1;
	}

	public void SuaThongTin() {
		System.out.println("1.Sua ten NXB");
		System.out.println("2.Sua So dien thoai NBX");
		System.out.println("3.Sua Dia chi NXB");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		case 1:
			while (!exitLoop) {
				System.out.println("Nhap ten NXB moi");
				String newtenNXB = sc.nextLine();
				
				if (!this.tenNXB.equals(newtenNXB)) {
					this.tenNXB = newtenNXB;
					exitLoop = true;
				}
				
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.print("Nhap so dien thoai moi cua NXB: ");
				String newsdtNXB = sc.nextLine();
				
				if (newsdtNXB.matches("\\d+") && !newsdtNXB.equals(sdtNXB)) {
					this.sdtNXB = newsdtNXB;
					exitLoop = true;
				}
				
			}
			break;
		case 3:
			while (!exitLoop) {
				System.out.print("Nhap Dia chi moi cua NXB: ");
				String newdcNXB = sc.nextLine();
				
				if (!newdcNXB.equals(dcNXB)) {
					this.dcNXB = newdcNXB;
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}
	}

	public void CapNhat_NXB(String tenNXB, String sdtNXB, String dcNXB, int trangthai) {
		this.tenNXB = tenNXB;
		this.dcNXB = dcNXB;
		this.sdtNXB = sdtNXB;
		this.trangthai = trangthai;
	}

	public String Xuat() {
		return String.format("Ten NXB: %-21s | So dien thoai NXB: %-16s | Dia chia NXB: %s", tenNXB, sdtNXB, dcNXB);
	}
}
