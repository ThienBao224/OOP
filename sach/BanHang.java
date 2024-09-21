
package sach;

public class BanHang extends NhanVien {
    
    private int SLBan;

    public BanHang(String maNV, String ten, int tuoi,String gioitinh, String chucVu, double luong,int SLBan, int trangthai) {
        super(maNV, ten, tuoi, gioitinh, chucVu, luong, trangthai);
        this.SLBan = SLBan;
    }

    public BanHang() {
    }

    public int getSLBan() {
        return SLBan;
    }

    public boolean setSLBan(int i) {
        if (i >= 0) {
            this.SLBan = i;
            return true;
        } else {
            System.err.print("Nhap lai so luong ban: ");
            return false;
        }
    }

    @Override
    public double TinhLuong() {
        return getLuong() * 1.4 + SLBan * 2.5;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        while (true) {
            int newSLBan = Integer.parseInt(sc.nextLine());
            boolean check = setSLBan(newSLBan);
            if (check) {
                break;
            }
        }

        this.trangthai = 1;
    }

    @Override
    public void SuaThongTin() {
        System.out.println("1.Sửa Mã Nhân Viên Bán Hàng");
        System.out.println("2.Sửa Họ và Tên Nhân Viên Bán Hàng");
        System.out.println("3.Sửa Tuổi Nhân Viên Bán Hàng");
        System.out.println("4.Sửa Giới tính Nhân Viên Bán Hàng");
        System.out.println("5.Sửa Chức vụ Nhân Viên Bán Hàng");
        System.out.println("6.Sửa Luong Nhan Vien Ban Hang");
        System.out.println("7.Sửa số lượng sách bán");
        System.out.print("Nhập lựa chọn: ");
        int luachon = Integer.parseInt(sc.nextLine());
        boolean exitLoop = false;
        switch (luachon) {
            case 1:
                while (!exitLoop) {
                    System.out.print("Nhập Mã Nhân Viên Bán Hàng mới: ");
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
                    System.out.print("Nhập Số lượng sách được bán mới: ");
                    String newSLBan = sc.nextLine();
                    if (newSLBan.matches("\\d+") && Integer.parseInt(newSLBan) != this.getSLBan()
                            && Integer.parseInt(newSLBan) >= 0) {
                        this.setSLBan(Integer.parseInt(newSLBan));
                        exitLoop = true;
                    }
                }
                break;
            default:
                break;
        }
    }

    public void CapNhat_BanHang(String ten, int tuoi, String gioitinh, String chucVu, double luong, int trangthai,
        String maNV, int SLBan) {
        this.setMaNV(maNV);
        this.setTen(ten);
        this.setTuoi(tuoi);
        this.setGioitinh(gioitinh);
        this.setChucVu(chucVu);
        this.setLuong(luong);
        this.SLBan = SLBan;
        this.trangthai = trangthai;

    }

    @Override
    public String Xuat() {
        return String.format("%s |Số lượng sách đã bán: %-10s ", super.Xuat(), SLBan);
    }

}
