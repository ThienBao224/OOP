package sach;

public class newSach extends Sach {

	public newSach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newSach(String tenSach, String maSach, newTacGia TacGia, newNXB NXB, newTheLoai TheLoai, double giaban,
			int soluong, int trangthai) {
		super(tenSach, maSach, TacGia, NXB, TheLoai, giaban, soluong, trangthai);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Nhap() {
		while (this.getTenSach() == null || this.getTenSach().isEmpty()) {
			System.out.print("Nhap Ten Sach: ");
			this.setTenSach(sc.nextLine());
		}
		
		while (this.getMaSach() == null || this.getMaSach().isEmpty()) {
			System.out.print("Nhap ma Sach: ");
			String newmaSach = sc.nextLine();
			
			Sach new_maSach = danhsachSach.TrungLap(newmaSach);
			
			if (new_maSach == null) {
				this.setMaSach(newmaSach);
				break;
			} else if (new_maSach != null && new_maSach.getTrangthai() == 1)
				System.out.println("Trung lap ma Sach - hay nhap lai");
			
		}
		
		System.out.println();
		
		while (this.getTacGia() == null) {
			this.setTacGia(new newTacGia());
			
			if (danhsachTacGia.getSoluong() == 0) {
				this.setTacGia(danhsachTacGia.Them());
				break;
			}
			
			System.out.print("Nhap Ma so Tac gia: ");
			String newtenTacGia = sc.nextLine();
			
			this.setTacGia(danhsachTacGia.TrungLap(newtenTacGia));
			
			if (this.getTacGia() == null) {
				System.out.println("Tac gia chua co trong danh Sach - hay tao Tac gia");
				this.setTacGia(danhsachTacGia.Them());
				break;
			} else if (this.getTacGia().getTrangthai() == 1) {
				System.out.println("Trung lap Tac gia- hay lua chon:");
				System.out.println("1.Nhan thong tin Tac gia");
				System.out.println("2.Sua thong tin Tac gia");
				System.out.println("3.Tao Tac gia moi");
				
				int luachon = Integer.parseInt(sc.nextLine());
				
				switch (luachon) {
				case 1:
					System.out.println("Da nhan thong tin");
					break;
				case 2:
					System.out.println("Dang Sua");
					this.setTacGia(danhsachTacGia.Sua(newtenTacGia));
					break;
				default:
					this.setTacGia(danhsachTacGia.Them());
					break;
				}
				
			} else {
				System.out.println("Tac gia da bi xoa du lieu - hay lua chon:");
				System.out.println("1.Nhan thong tin Tac gia ");
				System.out.println("2.Sua thong tin Tac gia");
				System.out.println("3.Tao Tac gia moi");
				
				int luachon_1 = Integer.parseInt(sc.nextLine());
				
				switch (luachon_1) {
				case 1:
					this.setTacGia(danhsachTacGia.KhoiPhuc(newtenTacGia));
					System.out.println("Da khoi phuc");
					break;
				case 2:
					danhsachTacGia.KhoiPhuc(newtenTacGia);
					this.setTacGia(danhsachTacGia.Sua(newtenTacGia));
					System.out.println("Dang Sua");
					break;
				default:
					this.setTacGia(danhsachTacGia.Them());
					break;
				}
				
			}
			
		}
		System.out.println();
		
		while (this.getNXB() == null) {
			this.setNXB(new newNXB());
			
			if (danhsachNXB.getSoluong() == 0) {
				setNXB(danhsachNXB.Them());
				break;
			}
			
			System.out.print("Nhap Ten NXB: ");
			String newtenNXB = sc.nextLine();
			
			this.setNXB(danhsachNXB.TrungLap(newtenNXB));
			
			if (this.getNXB() == null) {
				System.out.println("NXB chua co trong danh Sach - hay tao NXB");
				this.setNXB(danhsachNXB.Them());
				break;
			} else if (this.getNXB().getTrangthai() == 1) {
				System.out.println("Trung lap NXB- hay lua chon:");
				System.out.println("1.Nhan thong tin NXB");
				System.out.println("2.Sua thong tin NXB");
				System.out.println("3.Tao NXB moi");
				
				int luachon = Integer.parseInt(sc.nextLine());
				
				switch (luachon) {
				case 1:
					System.out.println("Da nhan thong tin");
					break;
				case 2:
					System.out.println("Dang Sua");
					this.setNXB(danhsachNXB.Sua(newtenNXB));
					break;
				default:
					this.setNXB(danhsachNXB.Them());
					break;
				}
				
			} else {
				System.out.println("NXB da bi xoa du lieu - hay lua chon:");
				System.out.println("1.Nhan thong tin NXB ");
				System.out.println("2.Sua thong tin NXB");
				System.out.println("3.Tao NXB moi");
				
				int luachon_1 = Integer.parseInt(sc.nextLine());
				
				switch (luachon_1) {
				case 1:
					this.setNXB(danhsachNXB.KhoiPhuc(newtenNXB));
					System.out.println("Da khoi phuc");
					break;
				case 2:
					danhsachNXB.KhoiPhuc(newtenNXB);
					this.setNXB(danhsachNXB.Sua(newtenNXB));
					System.out.println("Dang Sua");
					break;
				default:
					this.setNXB(danhsachNXB.Them());
					break;
				}
				
			}
		}
		
		System.out.println();
		
		while (this.getTheLoai() == null) {
			this.setTheLoai(new newTheLoai());
			
			if (danhsachTheLoai.getSoluong() == 0) {
				this.setTheLoai(danhsachTheLoai.Them());
				break;
			}
			
			System.out.print("Nhap Ten the loai Sach: ");
			String newtenTheLoai = sc.nextLine();
			
			this.setTheLoai(danhsachTheLoai.TrungLap(newtenTheLoai));
			
			if (this.getTheLoai() == null) {
				System.out.println("The loai chua co trong danh Sach - hay tao The loai");
				this.setTheLoai(danhsachTheLoai.Them());
				break;
			} else if (this.getTheLoai().getTrangthai() == 1) {
				System.out.println();
				System.out.println("1.Nhan thong tin The loai");
				System.out.println("2.Sua thong tin The loai");
				System.out.println("3.Tao The loai moi");
				
				int luachon = Integer.parseInt(sc.nextLine());
				
				switch (luachon) {
				case 1:
					System.out.println("Da nhan thong tin");
					break;
				case 2:
					System.out.println("Dang Sua");
					this.setTheLoai(danhsachTheLoai.Sua(newtenTheLoai));
					break;
				default:
					this.setTheLoai(danhsachTheLoai.Them());
					break;
				}
				
			} else {
				System.out.println("The loai da bi xoa du lieu - hay lua chon:");
				System.out.println("1.Nhan thong tin The loai ");
				System.out.println("2.Sua thong tin The loai");
				System.out.println("3.Tao The loai moi");
				
				int luachon_1 = Integer.parseInt(sc.nextLine());
				
				switch (luachon_1) {
				case 1:
					this.setTheLoai(danhsachTheLoai.KhoiPhuc(newtenTheLoai));
					System.out.println("Da khoi phuc");
					break;
				case 2:
					danhsachTheLoai.KhoiPhuc(newtenTheLoai);
					this.setTheLoai(danhsachTheLoai.Sua(newtenTheLoai));
					System.out.println("Dang Sua");
					break;
				default:
					this.setTheLoai(danhsachTheLoai.Them());
					break;
				}
				
			}
			
		}
		System.out.println();
		
		while (this.getGiaban() <= 0 || this.getGiaban() > 100000000) {
			System.out.print("Nhap gia ban '" + getTenSach() + "': ");
			String newgiaban = sc.nextLine();
			
			if (newgiaban.matches("\\d+\\d*\\.?\\,?"))
				this.setGiaban(Double.parseDouble(newgiaban));
			else
				this.setGiaban(0);
			
		}
		while (this.getSoluong() <= 0) {
			System.out.print("Nhap so luong Sach '" + getTenSach() + "': ");
			String newsoluong = sc.nextLine();
			
			if (newsoluong.matches("\\d+"))
				this.setSoluong(Integer.parseInt(newsoluong));
			else
				this.setSoluong(0);
			
		}
		
		this.trangthai = 1;
		
		System.out.println();
	}

	@Override
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
				
				if (!newtenSach.equals(this.getTenSach())) {
					this.setTenSach(newtenSach);
					exitLoop = true;
				}
				
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.println("Nhap ma Sach moi");
				String newmaSach = sc.nextLine();
				
				Sach new_maSach = danhsachSach.TrungLap(newmaSach);
				
				if (new_maSach == null && !this.getMaSach().equals(newmaSach)) {
					this.setMaSach(newmaSach);
					exitLoop = true;
					break;
				} else if (new_maSach != null && new_maSach.getTrangthai() == 1) {
					System.out.println("Trung lap Sach moi nhap lai:");
					exitLoop = false;
				} else {
					System.out.println("Sach da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc Sach");
					System.out.println("2.Khoi phuc Va Sua thong tin Sach");
					System.out.println("3.Thoat");
					
					int luachon_1 = Integer.parseInt(sc.nextLine());
					
					switch (luachon_1) {
					case 1:
						danhsachSach.KhoiPhuc(newmaSach);
						System.out.println("Da khoi phuc");
						return;
					case 2:
						danhsachSach.KhoiPhuc(newmaSach);
						danhsachSach.Sua(newmaSach);
						System.out.println("Dang Sua");
						return;
					default:
						return;
					}
					
				}
				
			}
			break;
		case 3:
			this.getTacGia().SuaThongTin_ChoPhepTrungLap();
			break;
		case 4:
			this.getNXB().SuaThongTin_ChoPhepTrungLap();
			break;
		case 5:
			this.getTheLoai().SuaThongTin_ChoPhepTrungLap();
			break;
		case 6:
			while (!exitLoop) {
				System.out.print("Nhap Gia ban moi cua Sach: ");
				String newgiaban = sc.nextLine();
				
				if (newgiaban.matches("\\d+\\d*\\.?\\,?") && Double.parseDouble(newgiaban) != this.getGiaban()
						&& Double.parseDouble(newgiaban) > 0 && Double.parseDouble(newgiaban) < 100000000) {
					this.setGiaban(Integer.parseInt(newgiaban));
					exitLoop = true;
					break;
				}
				
			}
			break;
		case 7:
			while (!exitLoop) {
				System.out.print("Nhap So luong moi cua Sach: ");
				String newsoluong = sc.nextLine();
				
				if (newsoluong.matches("\\d+\\d*\\.?\\,?") && Integer.parseInt(newsoluong) != getSoluong()) {
					this.setSoluong(Integer.parseInt(newsoluong));
					exitLoop = true;
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}
	}

	@Override
	public String Xuat() {
		return super.Xuat();
	}
}
