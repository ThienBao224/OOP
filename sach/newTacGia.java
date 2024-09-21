package sach;

public class newTacGia extends TacGia {

	public newTacGia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newTacGia(String masoTacGia, String ten, int tuoi, String gioitinh, String quequan, int trangthai) {
		super(masoTacGia, ten, tuoi, gioitinh, quequan, trangthai);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Nhap() {
		while (this.getMasoTacGia() == null || this.getMasoTacGia().isEmpty()) {
			
			System.out.print("Nhap Ma so Tac gia: ");
			String newmasoTacGia = sc.nextLine();
			
			if (newmasoTacGia.matches("\\d+")) {
				TacGia new_masoTacGia = danhsachTacGia.TrungLap(newmasoTacGia);
				
				if (new_masoTacGia == null) {
					this.setMasoTacGia(newmasoTacGia);
					break;
				} else if (new_masoTacGia != null && new_masoTacGia.getTrangthai() == 1)
					System.out.println("Trung lap tac gia - hay nhap lai");
				else {
					System.out.println("Tac gia da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc thong tin Tac gia ");
					System.out.println("2.Khoi phuc va Sua thong tin Tac gia");
					System.out.println("3.Tao Tac gia moi");
					
					int luachon_1 = Integer.parseInt(sc.nextLine());
					
					switch (luachon_1) {
					case 1:
						danhsachTacGia.KhoiPhuc(newmasoTacGia);
						System.out.println("Da khoi phuc");
						return;
					case 2:
						danhsachTacGia.KhoiPhuc(newmasoTacGia);
						danhsachTacGia.Sua(newmasoTacGia);
						System.out.println("Dang Sua");
						return;
					default:
						danhsachTacGia.Them();
						return;
					}
				
				}
				
			}
		}
		// TODO Auto-generated method stub
		super.Nhap();
		
		while (this.getQuequan() == null || this.getQuequan().isEmpty()) {
			System.out.print("Nhap Que quan: ");
			this.setQuequan(sc.nextLine());
		}
		
			this.setTrangthai(1);
	}

	@Override
	public void SuaThongTin() {
		System.out.println("1.Sua Ma so tac gia");
		System.out.println("2.Sua Ho va Ten tac gia");
		System.out.println("3.Sua Tuoi tac gia");
		System.out.println("4.Sua Gioi tinh tac gia");
		System.out.println("5.Sua Que quan tac gia");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		case 1:
			while (!exitLoop) {
				System.out.println("Nhap Ma so moi cua Tac gia");
				String newmasoTacGia = sc.nextLine();
				
				if (newmasoTacGia.matches("\\d+")) {
					TacGia new_masoTacGia = danhsachTacGia.TrungLap(newmasoTacGia);
					
					if (new_masoTacGia == null && !this.getMasoTacGia().equals(newmasoTacGia)) {
						this.setMasoTacGia(newmasoTacGia);
						exitLoop = true;
						break;
					} else if (new_masoTacGia != null && new_masoTacGia.getTrangthai() == 1) {
						System.out.println("Trung lap Tac gia moi nhap lai:");
						exitLoop = false;
					} else {
						System.out.println("Tac gia da bi xoa du lieu - hay lua chon:");
						System.out.println("1.Khoi phuc Tac gia");
						System.out.println("2.Khoi phuc va Sua thong tin Tac gia");
						System.out.println("3.Thoat");
						
						int luachon_1 = Integer.parseInt(sc.nextLine());
						
						switch (luachon_1) {
						case 1:
							danhsachTacGia.KhoiPhuc(newmasoTacGia);
							System.out.println("Da khoi phuc");
							return;
						case 2:
							danhsachTacGia.KhoiPhuc(newmasoTacGia);
							danhsachTacGia.Sua(newmasoTacGia);
							System.out.println("Dang Sua");
							return;
						default:
							return;
						}
						
					}
					
				}
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.print("Nhap Ho va Ten moi: ");
				String newten = sc.nextLine();
				
				if (!newten.equals(this.getTen())) {
					this.setTen(newten);
					exitLoop = true;
				}
				
			}
			break;
		case 3:
			while (!exitLoop) {
				System.out.print("Nhap Tuoi moi: ");
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
				System.out.print("Nhap Gioi tinh moi: ");
				String newgioitinh = sc.nextLine();
				
				if (!newgioitinh.equals(this.getGioitinh())) {
					this.setGioitinh(newgioitinh);
					exitLoop = true;
				}
				
			}
			break;
		case 5:
			while (!exitLoop) {
				System.out.print("Nhap que quan moi cua Tac gia: ");
				String newquequan = sc.nextLine();
				
				if (!newquequan.equals(this.getQuequan())) {
					this.setQuequan(newquequan);
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}

	}

	public void SuaThongTin_ChoPhepTrungLap() {
		System.out.println("1.Sua Ma so tac gia");
		System.out.println("2.Sua Ho va Ten tac gia");
		System.out.println("3.Sua Tuoi tac gia");
		System.out.println("4.Sua Gioi tinh tac gia");
		System.out.println("5.Sua Que quan tac gia");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		case 1:
			while (!exitLoop) {
				TacGia new_masoTacGia = new TacGia();
				
				System.out.print("Nhap Ma so cua tac gia: ");
				String newmasoTacGia = sc.nextLine();
				
				if (newmasoTacGia.matches("\\d+")) {
					new_masoTacGia = danhsachTacGia.TrungLap(newmasoTacGia);
					
					if (!exitLoop && this.getMasoTacGia() != null && !newmasoTacGia.equals(this.getMasoTacGia())) {
						if (new_masoTacGia == null) {
							this.setMasoTacGia(newmasoTacGia);
							exitLoop = true;
							break;
						} else {
							if (new_masoTacGia.getTrangthai() == 1) {
								System.out.println("Trung lap du lieu - hay lua chon:");
								System.out.println("1.Nhan thong tin Tac gia ");
								System.out.println("2.Sua thong tin Tac gia");
								System.out.println("3.Thoat");
								
								int luachon_1 = Integer.parseInt(sc.nextLine());
								
								switch (luachon_1) {
								case 1:
									System.out.println("Da khoi phuc");
									break;
								case 2:
									new_masoTacGia = danhsachTacGia.Sua(newmasoTacGia);
									System.out.println("Dang Sua");
									break;
								default:
									return;
								}
								
							} else {
								System.out.println("Tac gia da bi xoa du lieu - hay lua chon:");
								System.out.println("1.Khoi phuc va Nhan thong tin Tac gia ");
								System.out.println("2.Khoi phuc - Nhan va Sua thong tin Tac gia");
								System.out.println("3.Thoat");
								
								int luachon_1 = Integer.parseInt(sc.nextLine());
								
								switch (luachon_1) {
								case 1:
									new_masoTacGia = danhsachTacGia.KhoiPhuc(newmasoTacGia);
									System.out.println("Da khoi phuc");
									break;
								case 2:
									danhsachTacGia.KhoiPhuc(newmasoTacGia);
									new_masoTacGia = danhsachTacGia.Sua(newmasoTacGia);
									System.out.println("Dang Sua");
									break;
								default:
									return;
								}
								
							}
							
						}
					}
					
					if (new_masoTacGia != null) {
						CapNhat_TacGia(new_masoTacGia.getMasoTacGia(), new_masoTacGia.getTen(), new_masoTacGia.getTuoi(),
								new_masoTacGia.getGioitinh(), new_masoTacGia.getQuequan(), 1);
						exitLoop = true;
						return;
					}
					
				}
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.print("Nhap Ho va Ten moi: ");
				String newten = sc.nextLine();
				
				if (!newten.equals(this.getTen())) {
					this.setTen(newten);
					exitLoop = true;
				}
				
			}
			break;
		case 3:
			while (!exitLoop) {
				System.out.print("Nhap Tuoi moi: ");
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
				System.out.print("Nhap Gioi tinh moi: ");
				String newgioitinh = sc.nextLine();
				
				if (!newgioitinh.equals(this.getGioitinh())) {
					this.setGioitinh(newgioitinh);
					exitLoop = true;
				}
				
			}
			break;
		case 5:
			while (!exitLoop) {
				System.out.print("Nhap que quan moi cua Tac gia: ");
				String newquequan = sc.nextLine();
				
				if (!newquequan.equals(this.getQuequan())) {
					this.setQuequan(newquequan);
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
		// TODO Auto-generated method stub
		return super.Xuat();
	}
}
