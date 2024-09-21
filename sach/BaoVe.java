
package sach;

public class BaoVe extends NhanVien {
	private String kynang;

	public BaoVe(String maNV,String ten, int tuoi,String gioitinh, String chucVu,String kynang, double luong, int trangthai) {
		super(maNV, ten, tuoi, gioitinh,chucVu, luong,trangthai );
		this.kynang = kynang;
	}

	public BaoVe() {
	}

	public String getKynang() {
		return kynang;
	}

	public boolean setKynang(String kynang) {
		
		if (kynang != null && !kynang.isEmpty()) {
			this.kynang = kynang;
			return true;
		} else {
			System.err.println("Moi nhap lai ky nang: ");
			return false;
		}
	}

	@Override
	public double TinhLuong() {
		return getLuong() * 1.3;
	}

	@Override
	public void Nhap() {
		super.Nhap();
		while (true) {
			
			String newkynang = sc.nextLine();
			boolean check = setKynang(newkynang);
			
			if (check) {
				break;
			}
			
		}

		this.trangthai = 1;
	}

	@Override
	public void SuaThongTin() {
		
		System.out.println("1.Sửa Mã Bảo Vệ");
		System.out.println("2.Sửa Họ và Tên Bảo Vệ");
		System.out.println("3.Sửa Tuổi Bảo Vệ");
		System.out.println("4.Sửa Giới tính Bảo Vệ");
		System.out.println("5.Sửa Chức vụ Bảo Vệ");
		System.out.println("6.Sửa Lương Bảo Vệ");
		System.out.println("7.Sửa Kỹ năng Bảo Vệ");
		System.out.print("Nhập lựa chọn: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		
		case 1:
			while (!exitLoop) {
				
				System.out.print("Nhập Mã Bảo Vệ mới: ");
				String newmaNV = sc.nextLine();
				
				if (!newmaNV.equals(this.getMaNV())) {
					this.setMaNV(newmaNV);
					exitLoop = true;
				}
				
			}
			break;
		case 2:
			while (!exitLoop) {
				
				System.out.print("Nhập Họ và Tên mới: ");
				String newten = sc.nextLine();
				
				if (!newten.equals(this.getTen())) {
					this.setTen(newten);
					exitLoop = true;
				}
				
			}
			break;
		case 3:	
			while (!exitLoop) {
				
				System.out.print("Nhập Tuổi mới: ");
				String newtuoi = sc.nextLine();
				
				if (newtuoi.matches("\\d+") && Integer.parseInt(newtuoi) != this.getTuoi()
						&& Integer.parseInt(newtuoi) > 0 && Integer.parseInt(newtuoi) < 200) {
					this.setTuoi(Integer.parseInt(newtuoi));
					exitLoop = true;
				}
				
			}
			break;
		case 4:	
			while (!exitLoop) {
				
				System.out.print("Nhập Giới tính mới: ");
				String newgioitinh = sc.nextLine();
				
				if (!newgioitinh.equals(this.getGioitinh())) {
					this.setGioitinh(newgioitinh);
					exitLoop = true;
				}
				
			}
			break;
		case 5:
			while (!exitLoop) {
				
				System.out.println("Nhập Chức vụ mới: ");
				String newchucVu = sc.nextLine();
				
				if (!newchucVu.equals(this.getChucVu())) {
					this.setChucVu(newchucVu);
					exitLoop = true;
				}
				
			}
			break;
		case 6:
			while (!exitLoop) {
				
				System.out.print("Nhập Lương mới: ");
				String newluong = sc.nextLine();
				
				if (newluong.matches("\\d+\\d*\\.?\\,?") && Double.parseDouble(newluong) != this.getLuong()
						&& Double.parseDouble(newluong) > 0 && Double.parseDouble(newluong) < 1000000000) {
					this.setLuong(Double.parseDouble(newluong));
					exitLoop = true;
				}
				
			}
			break;
		case 7:
			while (!exitLoop) {
				
				System.out.print("Nhập Kỹ năng mới: ");
				String newkynang = sc.nextLine();
				
				if (!newkynang.equals(this.getKynang())) {
					this.setKynang(newkynang);
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}
		
	}

	public void CapNhat_BaoVe(String ten, int tuoi, String gioitinh, String chucVu, double luong, int trangthai,
			String maNV, String kynang) {
		
		this.setMaNV(maNV);
		this.setTen(ten);
		this.setTuoi(tuoi);
		this.setGioitinh(gioitinh);
		this.setChucVu(chucVu);
		this.setLuong(luong);
		this.kynang = kynang;
		this.trangthai = trangthai;

	}

	@Override
	public String Xuat() {
		
		return String.format("%s |Kỹ năng: %-13s ", super.Xuat(), kynang);
		
	}

}