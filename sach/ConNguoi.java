package sach;

import java.util.*;

public abstract class ConNguoi implements DanhSach {
	public Scanner sc = new Scanner(System.in);
	private String ten;
	private int tuoi = 0;
	private String gioitinh;

	public ConNguoi(String ten, int tuoi, String gioitinh) {
		this.ten = ten;
		this.tuoi = tuoi;
		this.gioitinh = gioitinh;
	}

	public ConNguoi() {
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public void Nhap() {
		
		while (this.ten == null || this.ten.isEmpty()) {
			
			System.out.print("Nhap Ho va Ten: ");
			String newten = sc.nextLine();
			
			if (!newten.matches(".*\\d.*"))
				this.ten = newten;
			
			else
				this.ten = null;
			
		}
		while (this.tuoi <= 0 || this.tuoi > 200) {
			
			System.out.print("Nhap Tuoi: ");
			String newtuoi = sc.nextLine();
			
			if (newtuoi.matches("\\d+"))
				this.tuoi = Integer.parseInt(newtuoi);
			
			else
				this.tuoi = 0;
			
		}
		
		while (this.gioitinh == null || this.gioitinh.isEmpty()) {
			System.out.print("Nhap Gioi tinh: ");
			this.gioitinh = sc.nextLine();
			
		}
	}

	public void SuaThongTin() {
		
		System.out.println("1.Sua Ho va Ten");
		System.out.println("2.Sua Tuoi");
		System.out.println("1.Sua Que quan");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		
		case 1:
			while (!exitLoop) {
				
				System.out.print("Nhap Ho va Ten moi: ");
				String newten = sc.nextLine();
				
				if (!newten.equals(this.ten)) {
					this.ten = newten;
					exitLoop = true;
				}
				
			}
			break;
		case 2:
			while (!exitLoop) {
				
				System.out.print("Nhap Tuoi moi: ");
				String newtuoi = sc.nextLine();
				
				if (newtuoi.matches("\\d+") && Integer.parseInt(newtuoi) != this.tuoi && Integer.parseInt(newtuoi) > 0
						&& Integer.parseInt(newtuoi) < 200) {
					this.tuoi = Integer.parseInt(newtuoi);
					exitLoop = true;
				}
				
			}
			break;
		case 3:
			while (!exitLoop) {
				
				System.out.print("Nhap Gioi tinh moi: ");
				String newgioitinh = sc.nextLine();
				
				if (!newgioitinh.equals(this.gioitinh)) {
					this.gioitinh = newgioitinh;
					exitLoop = true;
				}
				
			}
			break;
		}
	}

	public String Xuat() {
		
		return String.format("Ho va Ten: %-24s | Tuoi: %-3s | Gioi tinh: %-15s", ten, tuoi, gioitinh);
		
	}

}
