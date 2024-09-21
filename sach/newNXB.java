package sach;

public class newNXB extends NXB {

	public newNXB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newNXB(String tenNXB, String dcNXB, String sdtNXB, int trangthai) {
		super(tenNXB, dcNXB, sdtNXB, trangthai);
		// TODO Auto-generated constructor stub
	}

	public void Nhap() {
		while (this.getTenNXB() == null || this.getTenNXB().isEmpty()) {
			
			System.out.print("Nhap Ten NXB sach: ");
			String newtenNXB = sc.nextLine();
			
			NXB new_NXB = danhsachNXB.TrungLap(newtenNXB);
			
			if (new_NXB == null) {
				this.setTenNXB(newtenNXB);
				break;
			} else if (new_NXB.getTrangthai() == 1)
				System.out.println("Trung lap NXB - hay nhap lai:");
			else {
				System.out.println("NXB da bi xoa du lieu - hay lua chon:");
				System.out.println("1.Khoi phuc thong tin NXB ");
				System.out.println("2.Khoi phuc va Sua thong tin NXB");
				System.out.println("3.Tao NXB moi");
				
				int luachon_1 = Integer.parseInt(sc.nextLine());
				
				switch (luachon_1) {
				case 1:
					danhsachNXB.KhoiPhuc(newtenNXB);
					System.out.println("Da khoi phuc");
					return;
				case 2:
					danhsachNXB.KhoiPhuc(newtenNXB);
					danhsachNXB.Sua(newtenNXB);
					System.out.println("Dang Sua");
					return;
				default:
					danhsachNXB.Them();
					return;
				}
			}
		}
		while (this.getsdtNXB() == null || this.getsdtNXB().isEmpty()) {
			System.out.print("Nhap So dien thoai NXB: ");
			String newsdtNXB = sc.nextLine();
			
			if (newsdtNXB.matches("\\d+"))
				this.setsdtNXB(newsdtNXB);
			else
				this.setsdtNXB(null);
			
		}
		
		while (this.getDcNXB() == null || this.getDcNXB().isEmpty()) {
			System.out.print("Nhap Dia chi NXB: ");
			this.setDcNXB(sc.nextLine());
		}
		
		this.trangthai = 1;
	}
@Override
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
				
				NXB new_NXB = danhsachNXB.TrungLap(newtenNXB);
				
				if (new_NXB == null && !this.getTenNXB().equals(newtenNXB)) {
					this.setTenNXB(newtenNXB);
					exitLoop = true;
					break;
				} else if (new_NXB != null && new_NXB.getTrangthai() == 1) {
					System.out.println("Trung lap NXB moi nhap lai:");
					exitLoop = false;
				} else {
					System.out.println("NXB da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc NXB");
					System.out.println("2.Sua va khoi phuc thong tin NXB");
					System.out.println("3.Thoat");
					
					int luachon_1 = Integer.parseInt(sc.nextLine());
					
					switch (luachon_1) {
					case 1:
						danhsachNXB.KhoiPhuc(newtenNXB);
						System.out.println("Da khoi phuc");
						return;
					case 2:
						danhsachNXB.KhoiPhuc(newtenNXB);
						danhsachNXB.Sua(newtenNXB);
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
				System.out.print("Nhap so dien thoai moi cua NXB: ");
				String newsdtNXB = sc.nextLine();
				
				if (newsdtNXB.matches("\\d+") && !newsdtNXB.equals(this.getsdtNXB())) {
					this.setsdtNXB(newsdtNXB);
					exitLoop = true;
				}
				
			}
			break;
		case 3:
			while (!exitLoop) {
				System.out.print("Nhap Dia chi moi cua NXB: ");
				String newdcNXB = sc.nextLine();
				
				if (!newdcNXB.equals(this.getDcNXB())) {
					this.setDcNXB(newdcNXB);
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}
	}

	public void SuaThongTin_ChoPhepTrungLap() {
		System.out.println("1.Sua ten NXB");
		System.out.println("2.Sua So dien thoai NBX");
		System.out.println("3.Sua Dia chi NXB");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		case 1:
			while (!exitLoop) {
				NXB new_tenNXB = new NXB();
				System.out.print("Nhap Ten moi cua NXB: ");
				String newtenNXB = sc.nextLine();
				
				new_tenNXB = danhsachNXB.TrungLap(newtenNXB);
				
				if (!exitLoop && this.getTenNXB() != null && !newtenNXB.equals(this.getTenNXB())) {
					if (new_tenNXB == null) {
						this.setTenNXB(newtenNXB);
						exitLoop = true;
						break;
					} else {
						if (new_tenNXB.getTrangthai() == 1) {
							System.out.println("Trung lap NXB - hay lua chon:");
							System.out.println("1.Nhan thon tin NXB ");
							System.out.println("2.Nhan va Sua thong tin NXB");
							System.out.println("3.Thoat");
							
							int luachon_1 = Integer.parseInt(sc.nextLine());
							
							switch (luachon_1) {
							case 1:
								System.out.println("Da khoi phuc");
								break;
							case 2:
								new_tenNXB = danhsachNXB.Sua(newtenNXB);
								System.out.println("Dang Sua");
								break;
							default:
								return;
							}
							
						} else {
							System.out.println("NXB da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Khoi phuc va Nhan thong tin NXB ");
							System.out.println("2.Khoi phuc va Sua thong tin NXB");
							System.out.println("3.Thoat");
							
							int luachon_1 = Integer.parseInt(sc.nextLine());
							
							switch (luachon_1) {
							case 1:
								new_tenNXB = danhsachNXB.KhoiPhuc(newtenNXB);
								System.out.println("Da khoi phuc");
								break;
							case 2:
								danhsachNXB.KhoiPhuc(newtenNXB);
								new_tenNXB = danhsachNXB.Sua(newtenNXB);
								System.out.println("Dang Sua");
								break;
							default:
								return;
							}
						}
					}
				}
				
				if (new_tenNXB != null) {
					CapNhat_NXB(new_tenNXB.getTenNXB(), new_tenNXB.getsdtNXB(), new_tenNXB.getDcNXB(), 1);
					exitLoop = true;
					return;
				}
				
			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.print("Nhap so dien thoai moi cua NXB: ");
				String newsdtNXB = sc.nextLine();
				
				if (newsdtNXB.matches("\\d+") && !newsdtNXB.equals(this.getsdtNXB())) {
					this.setsdtNXB(newsdtNXB);
					exitLoop = true;
				}
				
			}
			break;
		case 3:
			while (!exitLoop) {
				System.out.print("Nhap Dia chi moi cua NXB: ");
				String newdcNXB = sc.nextLine();
				
				if (!newdcNXB.equals(this.getDcNXB())) {
					this.setDcNXB(newdcNXB);
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}
	}
}
