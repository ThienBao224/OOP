package sach;

import java.util.*;

public class Sach implements DanhSach{
	public Scanner sc = new Scanner(System.in);
	private String tenSach;
	private String maSach;
	private newTacGia TacGia;
	private newNXB NXB;
	private newTheLoai TheLoai;
	private double giaban;
	private int soluong;
	public int trangthai;

	public Sach(String tenSach, String maSach, newTacGia TacGia, newNXB NXB, newTheLoai TheLoai, double giaban,
			int soluong, int trangthai) {
		this.tenSach = tenSach;
		this.maSach = maSach;
		this.TacGia = TacGia;
		this.NXB = NXB;
		this.TheLoai = TheLoai;
		this.giaban = giaban;
		this.soluong = soluong;
		this.trangthai = trangthai;
	}

	public Sach() {
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public newTacGia getTacGia() {
		return TacGia;
	}

	public void setTacGia(newTacGia TacGia) {
		this.TacGia = TacGia;
	}

	public newNXB getNXB() {
		return NXB;
	}

	public void setNXB(newNXB nXB) {
		NXB = nXB;
	}

	public newTheLoai getTheLoai() {
		return TheLoai;
	}

	public void setTheLoai(newTheLoai TheLoai) {
		this.TheLoai = TheLoai;
	}

	public double getGiaban() {
		return giaban;
	}

	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public void Nhap() {
		while (tenSach == null || this.tenSach.isEmpty()) {
			System.out.print("Nhap Ten Sach: ");
			this.tenSach = sc.nextLine();
		}
		
		while (this.maSach == null || this.maSach.isEmpty()) {
			System.out.print("Nhap ma Sach: ");
			String newmaSach = sc.nextLine();
			this.maSach = newmaSach;
			break;
		}
		
		System.out.println();
		
		while (TacGia == null) {
			TacGia = new newTacGia();
			System.out.print("Nhap Ma so Tac gia: ");
			TacGia.Nhap();
		}
		
		System.out.println();
		
		while (NXB == null) {
			NXB = new newNXB();
			System.out.print("Nhap Ten NXB: ");
			NXB.Nhap();
		}
		
		System.out.println();
		
		while (TheLoai == null) {
			System.out.println("Nhap Thong tin Tac gia");
			TheLoai = new newTheLoai();
			TheLoai.Nhap();
			break;
		}
		
		System.out.println();
		
		while (this.giaban <= 0 || this.giaban > 100000000) {
			System.out.print("Nhap gia ban '" + tenSach + "': ");
			String newgiaban = sc.nextLine();
			
			if (newgiaban.matches("\\d+\\d*\\.?\\,?"))
				this.giaban = Double.parseDouble(newgiaban);
			else
				this.giaban = 0;
			
		}
		
		while (soluong <= 0) {
			System.out.print("Nhap so luong Sach '" + tenSach + "': ");
			String newsoluong = sc.nextLine();
			
			if (newsoluong.matches("\\d+"))
				this.soluong = Integer.parseInt(newsoluong);
			else
				this.soluong = 0;
			
		}
		
		this.trangthai = 1;
		
		System.out.println();
	}

	public void SuaThongTin() {
		System.out.println("1.Sua Ten Sach");
		System.out.println("2.Sua Ma Sach");
		System.out.println("3.Sua Tac gia cua Sach");
		System.out.println("4.Sua NXB cua Sach");
		System.out.println("5.Sua The loai Sach");
		System.out.println("6.Sua Gia ban Sach");
		System.out.println("7.Sua So luong Sach");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		case 1:
			while (!exitLoop) {
				System.out.print("Nhap Ten moi cua Sach: ");
				String newtenSach = sc.nextLine();
				
				if (!newtenSach.equals(tenSach)) {
					this.tenSach = newtenSach;
					exitLoop = true;
				}
				
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.println("Nhap ma Sach moi");
				String newmaSach = sc.nextLine();
				
				if (!this.maSach.equals(newmaSach)) {
					this.maSach = newmaSach;
					exitLoop = true;
					break;
				}
				
			}
			break;
		case 3:
			TacGia.SuaThongTin();
			break;
		case 4:
			NXB.SuaThongTin();
			break;
		case 5:
			TheLoai.SuaThongTin();
			break;
		case 6:
			while (!exitLoop) {
				System.out.print("Nhap Gia ban moi cua Sach: ");
				String newgiaban = sc.nextLine();
				
				if (newgiaban.matches("\\d+\\d*\\.?\\,?") && Double.parseDouble(newgiaban) != this.giaban
						&& Double.parseDouble(newgiaban) > 0 && Double.parseDouble(newgiaban) < 100000000) {
					this.giaban = Integer.parseInt(newgiaban);
					exitLoop = true;
					break;
				}
				
			}
			break;
		case 7:
			while (!exitLoop) {
				System.out.print("Nhap So luong moi cua Sach: ");
				String newsoluong = sc.nextLine();
				
				if (newsoluong.matches("\\d+") && Integer.parseInt(newsoluong) != soluong) {
					this.soluong = Integer.parseInt(newsoluong);
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}
	}

	public void CapNhat_Sach(String tenSach, String maSach, newTacGia TacGia, newNXB NXB, newTheLoai TheLoai,
			double giaban, int soluong, int trangthai) {
		this.tenSach = tenSach;
		this.maSach = maSach;
		this.TacGia = TacGia;
		this.NXB = NXB;
		this.TheLoai = TheLoai;
		this.giaban = giaban;
		this.soluong = soluong;
		this.trangthai = trangthai;
	}

	public String Xuat() {
		return String.format(
				"Ma Sach: %-20s  | Ten Sach: %-25s | Ten Tac gia: %-25s | Ten NXB: %-15s |The loai Sach: %-15s | Gia ban: %,-15.3f%-3s | So luong Sach: %,d",
				maSach, tenSach, TacGia.getTen(), NXB.getTenNXB(), TheLoai.getTenTheLoai(), giaban, "VND", soluong);
	}

}
