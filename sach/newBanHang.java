package sach;

public class newBanHang extends BanHang  {
    public newBanHang() {
        super();
        // TODO Auto-generated constructor stub
    }

    public newBanHang( String maNV, String ten, int tuoi, String gioitinh, String chucVu, double luong,int SLBan, int trangthai) {
        super( maNV, ten, tuoi, gioitinh, chucVu, luong,SLBan, trangthai);

    }

    @Override
    public void Nhap() {

        while (this.getMaNV() == null || this.getMaNV().isEmpty()) {

            System.out.print("Nhap Ma so Nhan Vien Ban Hang( bat dau bang BH... VD: BH123): ");
            String newMaNV = sc.nextLine();

            if (newMaNV.matches("^BH\\d+")) {
                BanHang new_MaNV = danhsachBanHang.TrungLap(newMaNV);

                if (new_MaNV == null) {
                    this.setMaNV(newMaNV);
                    break;

                } else if (new_MaNV != null && new_MaNV.getTrangthai() == 1)
                    System.out.println("Trung lap Nhan Vien Ban Hang - hay nhap lai");

                else {
                    System.out.println("Nhan Vien Ban Hang da bi xoa du lieu - hay lua chon:");
                    System.out.println("1.Khoi phuc thong tin Nhan Vien Ban Hang ");
                    System.out.println("2.Khoi phuc va Sua thong tin Nhan Vien Ban Hang");
                    System.out.println("3.Tao Nhan Vien Ban Hang moi");

                    int luachon_1 = Integer.parseInt(sc.nextLine());

                    switch (luachon_1) {

                        case 1:
                            danhsachBanHang.KhoiPhuc(newMaNV);
                            System.out.println("Da khoi phuc");
                            return;

                        case 2:
                            danhsachBanHang.KhoiPhuc(newMaNV);
                            danhsachBanHang.Sua(newMaNV);
                            System.out.println("Dang Sua");
                            return;

                        default:
                            danhsachBanHang.Them();
                            return;

                    }
                }
            }
        }

        while (this.getTen() == null || this.getTen().isEmpty()) {

            System.out.print("Nhap Ho va Ten: ");
            String newten = sc.nextLine();

            if (!newten.matches(".*\\d.*"))
                this.setTen(newten);

            else
                this.setTen(null);

        }
        while (this.getTuoi() <= 0 || this.getTuoi() > 200) {

            System.out.print("Nhap Tuoi: ");
            String newtuoi = sc.nextLine();

            if (newtuoi.matches("\\d+"))
                this.setTuoi(Integer.parseInt(newtuoi));

            else
                this.setTuoi(0);

        }
        while (this.getGioitinh() == null || this.getGioitinh().isEmpty()) {

            System.out.print("Nhap Gioi tinh: ");
            this.setGioitinh(sc.nextLine());

        }
        while (this.getChucVu() == null || this.getChucVu().isEmpty()) {
			System.out.print("Nhap Chuc Vu: ");
			this.setChucVu(sc.nextLine());
        }
	    while (this.getLuong() <= 0 || this.getLuong() > 100000000) {
			System.out.print("Nhap Luong "+this.getChucVu()+": ");
			String newluong = sc.nextLine();
			
			if (newluong.matches("\\d+\\d*\\.?\\,?"))
				this.setLuong(Double.parseDouble(newluong))  ;
			else
				this.setLuong(0);
			
		}
		while (this.getSLBan() <= 0) {
					
			System.out.print("Nhap So Luong Ban: ");
			String newtuoi = sc.nextLine();
			
			if (newtuoi.matches("\\d+"))
				this.setSLBan(Integer.parseInt(newtuoi));
			
			else
				this.setSLBan(0);
			
		}
        this.trangthai=1;
    }

    @Override
    public void SuaThongTin() {

        System.out.println("1.Sua Ma so Nhan Vien Ban Hang");
        System.out.println("2.Sua Ho va Ten Nhan Vien Ban Hang");
        System.out.println("3.Sua Tuoi Nhan Vien Ban Hang");
        System.out.println("4.Sua Gioi tinh Nhan Vien Ban Hang");
        System.out.println("5.Sua Chuc vu Nhan Vien Ban Hang");
        System.out.println("6.Sua So luong ban duoc cua Nhan Vien Ban Hang");
        System.out.println("7.Sua Luong Nhan Vien Ban Hang");
        System.out.print("Nhap lua chon: ");

        int luachon = Integer.parseInt(sc.nextLine());
        boolean exitLoop = false;

        switch (luachon) {

            case 1:
                while (!exitLoop) {

                    System.out.print("Nhap Ma so moi cua Nhan Vien Ban Hang( bat dau bang BH... VD: BH123): ");
                    String newMaNV = sc.nextLine();

                    if (newMaNV.matches("^BH\\d+")) {
                        BanHang new_MaNV = danhsachBanHang.TrungLap(newMaNV);

                        if (new_MaNV == null && !this.getMaNV().equals(newMaNV)) {
                            this.setMaNV(newMaNV);
                            exitLoop = true;
                            break;

                        } else if (new_MaNV != null && new_MaNV.getTrangthai() == 1) {
                            System.out.println("Trung lap Nhan Vien Ban Hang moi nhap lai:");
                            exitLoop = false;

                        } else {
                            System.out.println("Nhan Vien Ban Hang da bi xoa du lieu - hay lua chon:");
                            System.out.println("1.Khoi phuc Nhan Vien Ban Hang");
                            System.out.println("2.Khoi phuc va Sua thong tin Nhan Vien Ban Hang");
                            System.out.println("3.Thoat");

                            int luachon_1 = Integer.parseInt(sc.nextLine());

                            switch (luachon_1) {

                                case 1:
                                    danhsachBanHang.KhoiPhuc(newMaNV);
                                    System.out.println("Da khoi phuc");
                                    return;

                                case 2:
                                    danhsachBanHang.KhoiPhuc(newMaNV);
                                    danhsachBanHang.Sua(newMaNV);
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

                    System.out.print("Nhap chuc vu moi cua Nhan Vien Ban Hang: ");
                    String newchucvu = sc.nextLine();

                    if (!newchucvu.equals(this.getChucVu())) {
                        this.setChucVu(newchucvu);
                        exitLoop = true;
                    }

                }
                break;
            case 6:
                while (!exitLoop) {

                    System.out.print("Nhap so luong ban moi cua Nhan Vien Ban Hang: ");
                    String newSLBan = sc.nextLine();

                    if (newSLBan.matches("\\d+")&&Integer.parseInt(newSLBan)!=this.getSLBan()) {
                        this.setSLBan(Integer.parseInt(newSLBan));
                        exitLoop = true;
                    }

                }
                break;
            case 7:
                while (!exitLoop) {

                    System.out.print("Nhap Luong moi cua Nhan Vien Ban Hang: ");
                    String newLuong = sc.nextLine();

                    if (newLuong.matches("\\d+\\d*\\.?\\,?") && Double.parseDouble(newLuong) != this.getLuong()) {
                        this.setLuong(Integer.parseInt(newLuong));
                        exitLoop = true;
                    }

                }
                break;
            default:
                break;
        }
    }
}
