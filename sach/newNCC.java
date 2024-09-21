package sach;

import java.util.Arrays;

public class newNCC extends NCC {
	
	private newSach sach[] ;
	public newNCC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newNCC(String tenNCC, String dcNCC, String sdtNCC, int trangthai) {
		super(tenNCC, dcNCC, sdtNCC, trangthai);
		// TODO Auto-generated constructor stub
	}

	public newSach[] getSach() {
		return sach;
	}

	public void setSach(newSach[] sach) {
		this.sach = sach;
	}
	public void danhsachSach() {
		if(danhsachSach.getSach()!=null)
			sach= Arrays.copyOf(danhsachSach.getSach(), danhsachSach.getSach().length);
	}
	public void Nhap() {
		while (this.getTenNCC() == null || this.getTenNCC().isEmpty()) {

			System.out.print("Nhap Ten NCC sach: ");
			String newtenNCC = sc.nextLine();

			NCC new_NCC = danhsachNCC.TrungLap(newtenNCC);

			if (new_NCC == null) {
				this.setTenNCC(newtenNCC);
				break;
			} else if (new_NCC.getTrangthai() == 1)
				System.out.println("Trung lap NCC - hay nhap lai:");
			else {
				System.out.println("NCC da bi xoa du lieu - hay lua chon:");
				System.out.println("1.Khoi phuc thong tin NCC ");
				System.out.println("2.Khoi phuc va Sua thong tin NCC");
				System.out.println("3.Tao NCC moi");

				int luachon_1 = Integer.parseInt(sc.nextLine());

				switch (luachon_1) {
				case 1:
					danhsachNCC.KhoiPhuc(newtenNCC);
					System.out.println("Da khoi phuc");
					return;
				case 2:
					danhsachNCC.KhoiPhuc(newtenNCC);
					danhsachNCC.Sua(newtenNCC);
					System.out.println("Dang Sua");
					return;
				default:
					danhsachNCC.Them();
					return;
				}
			}
		}
		while (this.getsdtNCC() == null || this.getsdtNCC().isEmpty()) {
			System.out.print("Nhap So dien thoai NCC: ");
			String newsdtNCC = sc.nextLine();

			if (newsdtNCC.matches("\\d+"))
				this.setsdtNCC(newsdtNCC);
			else
				this.setsdtNCC(null);

		}

		while (this.getDcNCC() == null || this.getDcNCC().isEmpty()) {
			System.out.print("Nhap Dia chi NCC: ");
			this.setDcNCC(sc.nextLine());
		}

		this.trangthai = 1;
	}

	@Override
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

				NCC new_NCC = danhsachNCC.TrungLap(newtenNCC);

				if (new_NCC == null && !this.getTenNCC().equals(newtenNCC)) {
					this.setTenNCC(newtenNCC);
					exitLoop = true;
					break;
				} else if (new_NCC != null && new_NCC.getTrangthai() == 1) {
					System.out.println("Trung lap NCC moi nhap lai:");
					exitLoop = false;
				} else {
					System.out.println("NCC da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc NCC");
					System.out.println("2.Sua va khoi phuc thong tin NCC");
					System.out.println("3.Thoat");

					int luachon_1 = Integer.parseInt(sc.nextLine());

					switch (luachon_1) {
					case 1:
						danhsachNCC.KhoiPhuc(newtenNCC);
						System.out.println("Da khoi phuc");
						return;
					case 2:
						danhsachNCC.KhoiPhuc(newtenNCC);
						danhsachNCC.Sua(newtenNCC);
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
				System.out.print("Nhap so dien thoai moi cua NCC: ");
				String newsdtNCC = sc.nextLine();

				if (newsdtNCC.matches("\\d+") && !newsdtNCC.equals(this.getsdtNCC())) {
					this.setsdtNCC(newsdtNCC);
					exitLoop = true;
				}

			}
			break;
		case 3:
			while (!exitLoop) {
				System.out.print("Nhap Dia chi moi cua NCC: ");
				String newdcNCC = sc.nextLine();

				if (!newdcNCC.equals(this.getDcNCC())) {
					this.setDcNCC(newdcNCC);
					exitLoop = true;
				}

			}
			break;
		default:
			break;
		}
	}

	public void SuaThongTin_ChoPhepTrungLap() {
		System.out.println("1.Sua ten NCC");
		System.out.println("2.Sua So dien thoai NCC");
		System.out.println("3.Sua Dia chi NCC");
		System.out.print("Nhap lua chon: ");

		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;

		switch (luachon) {
		case 1:
			while (!exitLoop) {
				NCC new_tenNCC = new NCC();
				System.out.print("Nhap Ten moi cua NCC: ");
				String newtenNCC = sc.nextLine();

				new_tenNCC = danhsachNCC.TrungLap(newtenNCC);

				if (!exitLoop && this.getTenNCC() != null && !newtenNCC.equals(this.getTenNCC())) {
					if (new_tenNCC == null) {
						this.setTenNCC(newtenNCC);
						exitLoop = true;
						break;
					} else {
						if (new_tenNCC.getTrangthai() == 1) {
							System.out.println("Trung lap NCC - hay lua chon:");
							System.out.println("1.Nhan thon tin NCC ");
							System.out.println("2.Nhan va Sua thong tin NCC");
							System.out.println("3.Thoat");

							int luachon_1 = Integer.parseInt(sc.nextLine());

							switch (luachon_1) {
							case 1:
								System.out.println("Da khoi phuc");
								break;
							case 2:
								new_tenNCC = danhsachNCC.Sua(newtenNCC);
								System.out.println("Dang Sua");
								break;
							default:
								return;
							}

						} else {
							System.out.println("NCC da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Khoi phuc va Nhan thong tin NCC ");
							System.out.println("2.Khoi phuc va Sua thong tin NCC");
							System.out.println("3.Thoat");

							int luachon_1 = Integer.parseInt(sc.nextLine());

							switch (luachon_1) {
							case 1:
								new_tenNCC = danhsachNCC.KhoiPhuc(newtenNCC);
								System.out.println("Da khoi phuc");
								break;
							case 2:
								danhsachNCC.KhoiPhuc(newtenNCC);
								new_tenNCC = danhsachNCC.Sua(newtenNCC);
								System.out.println("Dang Sua");
								break;
							default:
								return;
							}
						}
					}
				}

				if (new_tenNCC != null) {
					CapNhat_NCC(new_tenNCC.getTenNCC(), new_tenNCC.getsdtNCC(), new_tenNCC.getDcNCC(), 1);
					exitLoop = true;
					return;
				}

			}
			break;
		case 2:
			while (!exitLoop) {
				System.out.print("Nhap so dien thoai moi cua NCC: ");
				String newsdtNCC = sc.nextLine();

				if (newsdtNCC.matches("\\d+") && !newsdtNCC.equals(this.getsdtNCC())) {
					this.setsdtNCC(newsdtNCC);
					exitLoop = true;
				}

			}
			break;
		case 3:
			while (!exitLoop) {
				System.out.print("Nhap Dia chi moi cua NCC: ");
				String newdcNCC = sc.nextLine();

				if (!newdcNCC.equals(this.getDcNCC())) {
					this.setDcNCC(newdcNCC);
					exitLoop = true;
				}

			}
			break;
		default:
			break;
		}
	}
}
