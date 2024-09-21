package sach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DonHang implements DanhSach {

    public Scanner sc = new Scanner(System.in);

    // Thuộc tính
    private KhachHang khachHang;  // Giả sử DonHang liên quan đến một KhachHang
    private String maDonHang;
    private String maKhachHang;
    private int trangThaiDonHang;
    private Date ngayDat;
    private Date ngayGiao;
    private double tongChiPhi;
    private PhuongThucThanhToan phuongThucThanhToan;
    private ChiTietDonHang chiTietDonHang;

    ChiTietDonHang dh = new ChiTietDonHang();

    public PhuongThucThanhToan[] danhsachPhuongThucThanhToan;

    // Getter và setter cho maKhachHang
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    // Constructor
    public DonHang(String maDonHang, int trangThaiDonHang, KhachHang khachHang) {
        this.maDonHang = maDonHang;
        this.trangThaiDonHang = trangThaiDonHang;
        this.khachHang = khachHang;
    }

    // Getter và Setter methods
    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public DonHang() {
        // Khởi tạo giá trị mặc định cho trạng thái đơn hàng
        this.trangThaiDonHang = 1; // 1 có thể là giá trị mặc định cho đơn hàng chưa bị xóa
    }

    public DonHang(String string, int parseInt, Date parseDate, Date parseDate2, String string2) {
        // TODO Auto-generated constructor stub
    }

    // Thêm getter và setter cho trạng thái đơn hàng
    public int getTrangThaiDonHang() {
        return trangThaiDonHang;
    }

    public void setTrangThaiDonHang(int trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }

    public ChiTietDonHang getChiTietDonHang() {
        return chiTietDonHang;
    }

    public void setChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        this.chiTietDonHang = chiTietDonHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public PhuongThucThanhToan getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(PhuongThucThanhToan phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public double getTongChiPhi() {
        return tongChiPhi;
    }

    public void setTongChiPhi(double tongChiPhi) {
        this.tongChiPhi = tongChiPhi;
    }

    // Các phương thức nhập và xuất
    public void Nhap() {
    	boolean exitloop = true;
        // Nhap ID don hang
        while (this.maDonHang == null || this.maDonHang.isEmpty()) {
            System.out.print("Nhập ID đơn hàng( bắt đầu bằng DH... VD: DH123): ");
            String newMaDonHang = sc.nextLine();
            if (newMaDonHang.matches("^DH\\d+")) {
                this.maDonHang = newMaDonHang;
            }
        }

        // Nhap ngay dat
        while (true) {
            System.out.print("Nhập ngày đặt (dd/MM/yyyy): ");
            String strNgayDat = sc.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // check ngay thang nam
                this.ngayDat = dateFormat.parse(strNgayDat);
                break; // Ngay dat hop le, thoat khoi vong lap
            } catch (ParseException e) {
                System.out.println("Ngày đặt không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
            }
        }

        // Nhap ngay giao
        while (true) {
            System.out.print("Nhập ngày giao (dd/MM/yyyy): ");
            String strNgayGiao = sc.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // check ngay
                this.ngayGiao = dateFormat.parse(strNgayGiao);

                // check ngay giao PHAI SAU lon hon ngay dat
                if (this.ngayGiao.after(this.ngayDat)) {
                    break; // Ngay giao hop le, thoat khoi vong lap
                } else {
                    System.out.println("Ngày giao phải lớn hơn ngày đặt. Vui lòng nhập lại.");
                }
            } catch (ParseException e) {
                System.out.println("Ngày giao không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
            }
        }

        // Nhap tong chi phi
        while (true) {
            System.out.print("Nhập chi phí giao: ");
            try {
                this.tongChiPhi = Double.parseDouble(sc.nextLine());
                break; // Tong chi phi hop le, thoat khoi vong lap
            } catch (NumberFormatException e) {
                System.out.println("Phí giao không hợp lệ. Vui lòng nhập lại.");
            }
        }

        // Nhap trang thai don hang
        while (true) {
            System.out.print("Nhập trạng thái đơn hàng (1 - Đã đặt, 2 - Đang giao, 3 - Đã giao): ");
            try {
                int trangThai = Integer.parseInt(sc.nextLine());
                if (trangThai >= 1 && trangThai <= 3) {
                    this.trangThaiDonHang = trangThai;
                    break; // Trang thai hop le, thoat khoi vong lap
                } else {
                    System.out.println("Trạng thái không hợp lệ. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Trạng thái không hợp lệ. Vui lòng nhập lại.");
            }
        }
        //nhap khach hang
        
        while (exitloop) {
            System.out.print("Nhap ID khach hang(bat dau bang KH vd: KH123): ");
            String newMaKhachHang = sc.nextLine();
            this.khachHang = new KhachHang();
            
            if (newMaKhachHang.matches("^KH\\d+")) {
                if (danhsachKhachHang.getKhachHang()!=null) {
                	int i=danhsachKhachHang.TimKiem(newMaKhachHang);
                    if(i!=-1) {
                    	this.khachHang = danhsachKhachHang.getKhachHang(i);
                    	exitloop=false;
                    	break;
                    }
                 else {
                    System.out.println("Khach hang khong ton tai.");
                    System.out.println("1. Tao moi khach hang");
                    System.out.println("2. Nhap lai");
        
                    System.out.print("Nhap lua chon: ");
                    int luaChon = Integer.parseInt(sc.nextLine());
        
                    switch (luaChon) {
                        case 1:
                            // Create a new customer
                            danhsachKhachHang.Them();
                            exitloop=false;
                            break;
                        case 2:
                            // Continue to the next iteration of the loop to retry input
                            break;
                        default:
                            System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                    }
                 }
               }
            }
        }
        //nhap phuong thuc thanh toan
        Nhap_PhuongThucThanhToan();
        //nhap gia san pham
        dh.Nhap(); 
    }

    public void Nhap_PhuongThucThanhToan() {
        // Tạo một đối tượng PhuongThucThanhToan mới
        PhuongThucThanhToan phuongThuc = new PhuongThucThanhToan();

        // Nhập thông tin cho phương thức thanh toán
        System.out.println("----Nhập thông tin cho phương thức thanh toán----");
        phuongThuc.Nhap();

        // Kiểm tra ngày thanh toán
        while (true) {
            Date ngayThanhToan = phuongThuc.getNgayThanhToan();
            if (ngayThanhToan.compareTo(this.ngayDat) >= 0) {
                // Ngày thanh toán hợp lệ, gán cho đơn hàng và thoát khỏi vòng lặp
                this.setPhuongThucThanhToan(phuongThuc);
                break;
            } else {
                System.out.println("Ngày thanh toán không hợp lệ. Phải thanh toán trước hoặc trong ngày giao.");
                // Nếu không hợp lệ, yêu cầu nhập lại
                System.out.println("Nhập lại thông tin cho phương thức thanh toán.");
                phuongThuc.Nhap();
            }
        }
    }

    public void SuaThongTin() {
        System.out.println("1. Sửa ID đơn hàng");
        System.out.println("2. Sửa trạng thái đơn hàng");
        System.out.println("3. Sửa thông tin khách hàng");
        System.out.println("4. Sửa ngày đặt");
        System.out.println("5. Sửa ngày giao");
        System.out.println("6. Sửa phí giao");
        System.out.println("7. Sửa thông tin phương thức thanh toán");
        System.out.println("8. Sửa thông tin giá");

        System.out.print("Nhập lựa chọn: ");
        int luaChon = Integer.parseInt(sc.nextLine());

        switch (luaChon) {
            case 1:
                while (true) {
                    System.out.print("Nhập ID đơn hàng mới (bắt đầu bằng DH ... VD: DH123): ");
                    String newMaDonHang = sc.nextLine();

                    // Check if the new ID is not the same as the current ID
                    if (!this.maDonHang.equals(newMaDonHang) && newMaDonHang.matches("^DH\\d+")) {
                        // Check if the new ID is not duplicated with other order IDs
                        if (!danhsachDonHang.TrungLap(newMaDonHang)) {
                            this.maDonHang = newMaDonHang;
                            break;
                        } else {
                            System.out.println("ID đã tồn tại cho một đơn hàng khác. Vui lòng nhập lại.");
                        }
                    } else {
                        System.out.println("ID trùng với mã đơn hàng hiện tại, vui lòng nhập lại.");
                    }
                }
                break;

            case 2:
                System.out.print("Nhập mã trạng thái mới (1: Đã đặt, 2: Đang giao, 3: Đã nhận): ");
                this.trangThaiDonHang = Integer.parseInt(sc.nextLine());
                break;
            case 3:
                // Giả sử có một phương thức trong KhachHang để chỉnh sửa thông tin
                this.khachHang.SuaThongTin();
                break;
            case 4:
                System.out.print("Nhập ngày đặt mới (dd/MM/yyyy): ");
                String strNgayDat = sc.nextLine();
                try {
                    this.ngayDat = new SimpleDateFormat("dd/MM/yyyy").parse(strNgayDat);
                } catch (Exception e) {
                    System.out.println("Ngày đặt không hợp lệ.");
                }
                break;
            case 5:
                while (true) {
                    System.out.print("Nhập ngày giao mới (dd/MM/yyyy): ");
                    String strNgayGiao = sc.nextLine();
                    try {
                        Date ngayGiaoMoi = new SimpleDateFormat("dd/MM/yyyy").parse(strNgayGiao);

                        // Check if the delivery date is not earlier than the order date
                        if (ngayGiaoMoi.after(this.ngayDat)) {
                            this.ngayGiao = ngayGiaoMoi;
                            break;
                        } else {
                            System.out.println("Ngày giao phải sau ngày đặt. Vui lòng nhập lại.");
                        }
                    } catch (ParseException e) {
                        System.out.println("Ngày giao không hợp lệ. Vui lòng nhập lại.");
                    }
                }
                break;
            case 6:
                System.out.print("Nhập phí giao mới: ");
                this.tongChiPhi = Double.parseDouble(sc.nextLine());
                break;
            case 7:
                if (this.phuongThucThanhToan != null) {
                    System.out.println("Thông tin phương thức thanh toán trước khi sửa: " + this.phuongThucThanhToan.Xuat());
                    this.phuongThucThanhToan.SuaThongTin();
                    System.out.println("Thông tin phương thức thanh toán sau khi sửa: " + this.phuongThucThanhToan.Xuat());
                } else {
                    System.out.println("Đơn hàng chưa có phương thức thanh toán.");
                }
                break;
            case 8:
                dh.Nhap();
            default:
                break;
        }
    }

    public String Xuat() {
        String trangThaiString;
        switch (trangThaiDonHang) {
            case 1:
                trangThaiString = "Đã đặt";
                break;
            case 2:
                trangThaiString = "Đang giao";
                break;
            case 3:
                trangThaiString = "Đã giao";
                break;
            default:
                trangThaiString = "Trạng thái không xác định";
                break;
        }
        return String.format("ID-DH: %-5s|Trạng thái: %-10s|Ngay dat: %tD|Ngày giao: %tD|Phí giao: %.2f %s %s\n%s\n",
                maDonHang, trangThaiString, ngayDat, ngayGiao, tongChiPhi, khachHang.Xuat(), phuongThucThanhToan.Xuat(), dh.Xuat());
    }

    public boolean daXoa() {
        return false;
    }

    public boolean isDeleted() {
        return trangThaiDonHang == -1; // Check if the order is marked as deleted
    }

    public void CapNhat_DonHang(String maDonHang, int trangThaiDonHang, Date ngayDat, Date ngayGiao, String tongChiPhi, KhachHang khachHang, PhuongThucThanhToan phuongThucThanhToan, ChiTietDonHang dh) {
        if (kiemTraDinhDangSo(tongChiPhi)) {
            this.khachHang = khachHang;
            this.dh = dh;
            this.phuongThucThanhToan = phuongThucThanhToan;
            this.maDonHang = maDonHang;
            this.trangThaiDonHang = trangThaiDonHang;
            this.ngayDat = ngayDat;
            this.ngayGiao = ngayGiao;
            this.tongChiPhi = Double.parseDouble(tongChiPhi);
        } else {
            return;
        }

    }

    private boolean kiemTraDinhDangSo(String so) {
        if (so.matches("\\d+")) {
            return true;
        }
        return false;
    }

}
