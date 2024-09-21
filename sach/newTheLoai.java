package sach;

public class newTheLoai extends TheLoai {

	public newTheLoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newTheLoai(String tenTheLoai, String mota, int trangthai) {
		super(tenTheLoai, mota, trangthai);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Nhap() {
		while (this.getTenTheLoai() == null || this.getTenTheLoai().isEmpty()) {
			System.out.print("Nhap The loai sach: ");
			String newtenTheLoai = sc.nextLine();
			
			TheLoai new_TheLoai = danhsachTheLoai.TrungLap(newtenTheLoai);
			
			if (new_TheLoai == null) {
				this.setTenTheLoai(newtenTheLoai);
				break;
			} else if (new_TheLoai != null && new_TheLoai.getTrangthai() == 1)
				System.out.println("Trung lap The loai - hay nhap lai:");
			else {
				System.out.println("The loai da bi xoa du lieu - hay lua chon:");
				System.out.println("1.Khoi phuc thong tin The loai ");
				System.out.println("2.Khoi phuc va Sua thong tin The loai");
				System.out.println("3.Tao The loai moi");
				
				int luachon_1 = Integer.parseInt(sc.nextLine());
				
				switch (luachon_1) {
				case 1:
					danhsachTheLoai.KhoiPhuc(newtenTheLoai);
					System.out.println("Da khoi phuc");
					return;
				case 2:
					danhsachTheLoai.KhoiPhuc(newtenTheLoai);
					danhsachTheLoai.Sua(newtenTheLoai);
					System.out.println("Dang Sua");
					return;
				default:
					danhsachTheLoai.Them();
					return;
					
				}
				
			}
			
		}
		
		while (this.getMota() == null || this.getMota().isEmpty()) {
			System.out.print("Nhap mo ta ve the loai " + getTenTheLoai() + ": ");
			this.setMota(sc.nextLine());
		}
		
		this.setTrangthai(1);
	}

	@Override
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
				
				TheLoai new_TheLoai = danhsachTheLoai.TrungLap(newtenTheLoai);
				
				if (new_TheLoai == null && !this.getTenTheLoai().equals(newtenTheLoai)) {
					this.setTenTheLoai(newtenTheLoai);
					exitLoop = true;
					break;
				} else if (new_TheLoai != null && new_TheLoai.getTrangthai() == 1) {
					System.out.println("Trung lap The loai moi nhap lai:");
					exitLoop = false;
				} else {
					System.out.println("The loai da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc The loai");
					System.out.println("2.Khoi phuc va Sua thong tin The loai");
					System.out.println("3.Thoat");
					
					int luachon_1 = Integer.parseInt(sc.nextLine());
					
					switch (luachon_1) {
					case 1:
						danhsachTheLoai.KhoiPhuc(newtenTheLoai);
						System.out.println("Da khoi phuc");
						return;
					case 2:
						danhsachTheLoai.KhoiPhuc(newtenTheLoai);
						danhsachTheLoai.Sua(newtenTheLoai);
						System.out.println("Dang Sua");
						return;
					default:
						return;
					}
					
				}
				
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.println("Nhap mo ta moi cua The loai");
				String newmota = sc.nextLine();
				
				if (!newmota.equals(this.getMota())) {
					this.setMota(newmota);
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}
	}

	public void SuaThongTin_ChoPhepTrungLap() {
		System.out.println("1.Sua Ten The loai");
		System.out.println("2.Sua Mo ta The loai");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		case 1:
			while (!exitLoop) {
				TheLoai new_tenTheLoai = new TheLoai();
				System.out.println("Nhap ten moi cua the loai");
				String newtenTheLoai = sc.nextLine();
				
				new_tenTheLoai = danhsachTheLoai.TrungLap(newtenTheLoai);
				
				if (!exitLoop && this.getTenTheLoai() != null && !newtenTheLoai.equals(this.getTenTheLoai())) {
					if (new_tenTheLoai == null) {
						this.setTenTheLoai(newtenTheLoai);
						exitLoop = true;
						break;
					} else {
						if (new_tenTheLoai.getTrangthai() == 1) {
							System.out.println("Trung lap du lieu - hay lua chon:");
							System.out.println("1.Nhan thong tin The loai ");
							System.out.println("2.Sua thong tin The loai");
							System.out.println("3.Thoat");
							
							int luachon_1 = Integer.parseInt(sc.nextLine());
							
							switch (luachon_1) {
							case 1:
								System.out.println("Da khoi phuc");
								break;
							case 2:
								new_tenTheLoai = danhsachTheLoai.Sua(newtenTheLoai);
								System.out.println("Dang Sua");
								break;
							default:
								return;
								
							}
							
						} else {
							System.out.println("The loai da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Khoi phuc va Nhan thong tin The loai ");
							System.out.println("2.khoi phuc va Sua thong tin The loai");
							System.out.println("3.Thoat");
							
							int luachon_1 = Integer.parseInt(sc.nextLine());
							
							switch (luachon_1) {
							case 1:
								new_tenTheLoai = danhsachTheLoai.KhoiPhuc(newtenTheLoai);
								System.out.println("Da khoi phuc");
								break;
							case 2:
								danhsachTheLoai.KhoiPhuc(newtenTheLoai);
								new_tenTheLoai = danhsachTheLoai.Sua(newtenTheLoai);
								System.out.println("Dang Sua");
								break;
							default:
								return;
							}
							
						}
						
					}
				}
				
				if (new_tenTheLoai != null) {
					CapNhat_TheLoai(new_tenTheLoai.getTenTheLoai(), new_tenTheLoai.getMota(), 1);
					exitLoop = true;
					return;
					
				}
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.println("Nhap mo ta moi cua the loai");
				String newmota = sc.nextLine();
				
				if (!newmota.equals(this.getMota())) {
					this.setMota(newmota);
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
