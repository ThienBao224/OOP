package sach;
import java.util.*;
class ChiTietDonHang implements DanhSach {
    private String mahoadon;
    private newSach[] sach;
    private int so_luong_moi_loai[];
    private int so_luong_loai_sach;
    private double tongtien;
    Scanner sc=new Scanner(System.in);
    public ChiTietDonHang(){

    }
    public ChiTietDonHang(/*String mahoadon,*/newSach[] sach,int so_luong_loai_sach,int so_luong_moi_loai[],double tongtien){
        this.sach=sach;
        this.so_luong_loai_sach=so_luong_loai_sach;
        this.so_luong_moi_loai=so_luong_moi_loai;
        //this.mahoadon=mahoadon;
        this.tongtien=tongtien;
    }
    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
    
    public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public double getTongtien() {
        return tongtien;
    }
    /*public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }
    public String getMahoadon() {
        return mahoadon;
    }*/
    public void setSach(newSach []sach) {
        this.sach = sach;
    }
    public void setSo_luong_loai_sach(int so_luong_loai_sach) {
        this.so_luong_loai_sach = so_luong_loai_sach;
    }
    public void setSo_luong_moi_loai(int[] so_luong_moi_loai) {
        this.so_luong_moi_loai = so_luong_moi_loai;
    }
    public newSach[] getSach() {
        return sach;
    }
    public newSach getSach(int i) {
        return sach[i];
    }
    public int getSo_luong_loai_sach() {
        return so_luong_loai_sach;
    }
    public int[] getSo_luong_moi_loai() {
        return so_luong_moi_loai;
    }
    public int getSo_luong_moi_loai(int i) {
        return so_luong_moi_loai[i];
    }
    public void themMasach(String maSach,int soluong) {
    	if (sach == null) {
			this.sach = new newSach[1];
			this.so_luong_moi_loai=new int[1];
        }
		else {
			this.sach = Arrays.copyOf(sach, sach.length + 1);
        	this.so_luong_moi_loai = Arrays.copyOf(so_luong_moi_loai, so_luong_moi_loai.length + 1);
		}
			int i = sach.length - 1;
			if(danhsachSach.TrungLap(maSach)!=null) {
				this.sach[i]=danhsachSach.TrungLap(maSach);
				this.so_luong_moi_loai[i]=soluong;
			}
			this.so_luong_loai_sach=sach.length;
    }
    
    public void Nhap() {
        //Boolean exitLoop = false;
    	while (this.mahoadon==null||this.mahoadon.isEmpty()) {
            System.out.print("Nhập Mã số Đơn Hàng(trùng với mã Đơn Hàng): ");
            String newId=sc.nextLine();
            if(danhsachDonHang.getDanhSachDonHang()==null) {
            	System.out.print("Chưa có Đơn Hàng nào: ");
            	return;
            }
            int i=danhsachDonHang.TimKiem(newId);
            if(i!=-1){
            	if(danhsachChiTietDonHang.TrungLap(newId)==null)
            		this.mahoadon=newId;
            	else 
            		this.mahoadon=null;
            }else this.mahoadon=newId;
        }
        while (true) {
            if (danhsachSach.getSach() == null) {
                System.out.println("Chưa có danh sách sách. Vui lòng tạo danh sách sách trước.");
                System.exit(so_luong_loai_sach);
            }
            System.out.print("Nhập số lượng loại sách cần mua: ");
            String soluong = sc.nextLine();
    
            if (soluong.matches("\\d+")) {
                so_luong_loai_sach = Integer.parseInt(soluong);
                int i = 0;
                sach = new newSach[so_luong_loai_sach];
                so_luong_moi_loai = new int[so_luong_loai_sach];
    
                while (i < so_luong_loai_sach) {
                    System.out.print("Nhập Mã sách: ");
                    String newmasach = sc.nextLine();
                    int location = danhsachSach.TimKiem(newmasach);
    
                    if (location != -1) {
                        newSach new_masach = danhsachSach.getSach(location);
    
                        // Check if the quantity in danhSachSach is zero
                        if (new_masach.getSoluong() == 0) {
                            System.out.println("Sách \"" + new_masach.getTenSach() + "\" đã hết. Vui lòng chọn sách khác.");
                            continue;
                        }
    
                        // Reduce the quantity in danhSachSach
                        int soLuongTrongDanhSach = new_masach.getSoluong();
                        int soLuongCanMua = 0;
    
                        while (true) {
                            System.out.print("Nhập số lượng sách \"" + new_masach.getTenSach() + "\" cần mua (không vượt quá số lượng có sẵn " + soLuongTrongDanhSach + "): ");
                            String sl = sc.nextLine();
    
                            if (sl.matches("\\d+")) {
                                soLuongCanMua = Integer.parseInt(sl);
    
                                if (soLuongCanMua <= soLuongTrongDanhSach) {
                                    break;
                                } else {
                                    System.out.println("Số lượng mua vượt quá số lượng có sẵn. Vui lòng Nhập lại.");
                                }
                            } else {
                                System.out.println("Nhập không hợp lệ. Vui lòng Nhập lại.");
                            }
                        }
    
                        // Update danhSachSach
                        new_masach.setSoluong(soLuongTrongDanhSach - soLuongCanMua);
    
                        // Update ChiTietDonHang
                        sach[i] = new newSach(new_masach.getTenSach(), new_masach.getMaSach(), new_masach.getTacGia(), new_masach.getNXB(), new_masach.getTheLoai(), new_masach.getGiaban(), new_masach.getSoluong(), 1);
                        so_luong_moi_loai[i] = soLuongCanMua;
    
                        i++;
                    } else {
                        System.out.println("Không tìm thấy sách.");
                        System.out.println("1. Xem lại sách đã nhập");
                        System.out.println("2. Nhập mã sách khác");
                        System.out.println("3. Tạo thêm sách ");
                        System.out.print("Nhập lựa chọn: ");
                        int luaChon = Integer.parseInt(sc.nextLine());
    
                        switch (luaChon) {
                            case 1:
                                // Xem lai sach da nhap
                                danhsachSach.XuatDanhSach();
                                break;
                            case 2:
                                // Nhập lại Ma sach
                                break;
                            case 3:
                                // Nhập thêm sách
                                danhsachSach.NhapDanhSach();
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ.");
                                break;
                        }
                    }
                }
                break;
            }
        }
        //this.trangthai=1;
    }
    
    public void SuaThongTin() {
    	
    }
    
    public double TongHoaDon(){
        double tong=0.0;
        for(int i=0;i<sach.length;i++){
            tong=tong+so_luong_moi_loai[i]*sach[i].getGiaban();
        }
        return tong;
    }
    public String Xuat() {

        StringBuilder result = new StringBuilder();
    
        if (this.sach != null&&danhsachDonHang.getDanhSachDonHang()!=null) {
            for (int i = 0; i < sach.length; i++) {
                result.append(String.format("Tên sách: %s, giá: %.2f, Số lượng:x%d\n", sach[i].getTenSach(), sach[i].getGiaban(), so_luong_moi_loai[i]));
            }
        }
    
        result.append(String.format("Thành tiền: %.2f", TongHoaDon()));
        return result.toString();
    }
}
