
package sach;

public class ThuNgan extends NhanVien {

    private String quayTT;
    private double DSBH;

    public ThuNgan( String maNV, String ten,int tuoi, String gioitinh, String chucVu, double luong,double DSBH, String quayTT, int trangthai) {
        super(maNV, ten,tuoi, gioitinh,chucVu,luong,trangthai);
        this.DSBH = DSBH;
        this.quayTT = quayTT;
    }

    public ThuNgan() {
    }

    public double getDSBH() {
        return DSBH;
    }

    public boolean setDSBH(double DSBH) {

        if (DSBH >= 0) {
            this.DSBH = DSBH;
            return true;
        } else {
            System.err.print("Nhap lai doanh so ban hang: ");
            return false;
        }
    }

    public String getQuayTT() {
        return quayTT;
    }

    public boolean setQuayTT(String quayTT) {
        if (quayTT != null && !quayTT.isEmpty()) {
            this.quayTT = quayTT;
            return true;
        } else {
            System.err.println("Moi nhap lai quay thanh toan: ");
            return false;
        }
    }

    @Override
    public double TinhLuong() {
        return getLuong() * 1.4 + DSBH * 2.5;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        while (true) {
            double newDSBH = Double.parseDouble(sc.nextLine());
            boolean check = setDSBH(newDSBH);
            if (check) {
                break;
            }
        }
        while (true) {
            String newquayTT = sc.nextLine();
            boolean check = setQuayTT(newquayTT);
            if (check) {
                break;
            }
        }
        this.trangthai = 1;
    }

    @Override
    public void SuaThongTin() {
        System.out.println("1.Sua Ma Nhan Vien Thu Ngan");
        System.out.println("2.Sua Ho va Ten Nhan Vien Thu Ngan");
        System.out.println("3.Sua Tuoi Nhan Vien Thu Ngan");
        System.out.println("4.Sua Gioi tinh Nhan Vien Thu Ngan");
        System.out.println("5.Sua Chuc vu Nhan Vien Thu Ngan");
        System.out.println("6.Sua Luong Nhan Vien Thu Ngan");
        System.out.println("7.Sua doanh so ban hang");
        System.out.println("8.Sua quay thanh toan");
        System.out.print("Nhap lua chon: ");
        int luachon = Integer.parseInt(sc.nextLine());
        boolean exitLoop = false;
        switch (luachon) {
            case 1:
                while (!exitLoop) {
                    System.out.print("Nhap Ma Nhan Vien Thu Ngan moi: ");
                    String newmaNV = sc.nextLine();
                    if (!newmaNV.equals(this.getMaNV())) {
                        this.setMaNV(newmaNV);
                        exitLoop = true;
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
                    System.out.println("Nhap Chuc vu moi: ");
                    String newchucVu = sc.nextLine();
                    if (!newchucVu.equals(this.getChucVu())) {
                        this.setChucVu(newchucVu);
                        exitLoop = true;
                    }
                }
                break;
            case 6:
                while (!exitLoop) {
                    System.out.print("Nhap Luong moi: ");
                    System.out.print("Nhap luong moi: ");
                    String newluong = sc.nextLine();
                    if (newluong.matches("\\d+\\d*\\.?\\,?") && Double.parseDouble(newluong) != this.getLuong()
                            && Double.parseDouble(newluong) > 0 && Double.parseDouble(newluong) < 1000000000) {
                        this.setLuong(Double.parseDouble(newluong)) ;
                        exitLoop = true;
                    }
                }
                break;
            case 7:
                while (!exitLoop) {
                    System.out.print("Nhap Doanh so ban hang moi: ");
                    String newDSBH = sc.nextLine();
                    if (newDSBH.matches("\\d+") && Double.parseDouble(newDSBH) != this.getDSBH()
                            && Double.parseDouble(newDSBH) >= 0) {
                        this.setDSBH(Integer.parseInt(newDSBH));
                        exitLoop = true;
                    }
                }
                break;
            case 8:
                while (!exitLoop) {
                    System.out.println("Nhap Quay thanh toan moi: ");
                    String newquayTT = sc.nextLine();
                    if (!newquayTT.equals(this.quayTT)) {
                        this.setQuayTT(newquayTT);
                        exitLoop = true;
                    }
                }
                break;
            default:
                break;
        }
    }

    public void CapNhat_ThuNgan(String ten, int tuoi, String gioitinh, String chucVu, double luong, int trangthai,
            String maNV, double DSBH, String quayTT) {
        this.setMaNV(maNV);
        this.setTen(ten);
        this.setTuoi(tuoi);
        this.setGioitinh(gioitinh);
        this.setChucVu(chucVu);
        this.setLuong(luong);
        this.DSBH = DSBH;
        this.quayTT = quayTT;
        this.trangthai = trangthai;

    }

    @Override
    public String Xuat() {
        return String.format("%s | Quay thanh toan: %-8s| Doanh so ban hang: %-15s ", super.Xuat(), quayTT, DSBH);
    }
}