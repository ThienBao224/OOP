package sach;

import java.util.*;

public class TheLoai implements DanhSach{
	public Scanner sc = new Scanner(System.in);
	private String tenTheLoai;
	private String mota;
	public int trangthai;

	public TheLoai() {
	}

	public TheLoai(String tenTheLoai, String mota, int trangthai) {
		this.tenTheLoai = tenTheLoai;
		this.mota = mota;
		this.trangthai = trangthai;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public void Nhap() {
		while (this.tenTheLoai == null || this.tenTheLoai.isEmpty()) {
			System.out.print("Nhap The loai sach: ");
			String newtenTheLoai = sc.nextLine();
			
			this.tenTheLoai = newtenTheLoai;
		}
		
		while (this.mota == null || this.mota.isEmpty()) {
			System.out.print("Nhap mo ta ve the loai " + getTenTheLoai() + ": ");
			this.mota = sc.nextLine();
		}
		
		this.trangthai = 1;
	}

	public void SuaThongTin() {
		System.out.println("1.Sua Ten The loai");
		System.out.println("2.Sua Mo ta The loai");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		case 1:
			while (!exitLoop) {
				System.out.println("Nhap The loai sach moi");
				String newtenTheLoai = sc.nextLine();
				
				if (!this.tenTheLoai.equals(newtenTheLoai)) {
					this.tenTheLoai = newtenTheLoai;
					exitLoop = true;
				}
				
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.println("Nhap mo ta moi cua The loai");
				String newmota = sc.nextLine();
				
				if (!newmota.equals(mota)) {
					this.mota = newmota;
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}
	}

	public void CapNhat_TheLoai(String tenTheLoai, String mota, int trangthai) {
		this.tenTheLoai = tenTheLoai;
		this.mota = mota;
		this.trangthai = trangthai;
	}

	public String Xuat() {
		return String.format("The loai sach: %-15s | Mo ta ve the loai: %s", tenTheLoai, mota);

	}

}
