package sach;
import java.io.*;
import java.util.*;


public class danhsachKhachHang {
    public static Scanner sc=new Scanner(System.in);
    private static int soLuong=0;
    private static newKhachHang khachHang[];
    public danhsachKhachHang(){

    }
    public static int getSoluong(){
        return soLuong;
    }
    public static void setSoluong(int sl){
        soLuong=sl;
    }
    public static newKhachHang[] getKhachHang() {
		return khachHang;
	}
	public static void setKhachHang(newKhachHang[] khachHang) {
		danhsachKhachHang.khachHang = khachHang;
	}
	//nhap thong tin cho danh sach khach hang
    public static void NhapDanhSach() {
		while (soLuong <= 0) {
			System.out.print("Nhap so luong khach hang: ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+"))
				soLuong = Integer.parseInt(sl);
			else
				soLuong = 0;
		}
		khachHang = new newKhachHang[soLuong];
		for (int i = 0; i < khachHang.length; i++) {
			khachHang[i] = new newKhachHang();
			System.out.println("----Nhap thong tin khach hang [" + (i + 1) + "]:----");
			khachHang[i].Nhap();
		}
	}
	/*doc ghi file */
	public static void DocFile(String filename) {
		try {
			FileReader readfile=new FileReader(filename);
			BufferedReader br = new BufferedReader(readfile);
			String line;
			int i;
			while((line=br.readLine())!=null) {
				String text[]=line.split("#");
				if(khachHang==null) 
					khachHang= new newKhachHang[1];
				else
					khachHang=Arrays.copyOf(khachHang, khachHang.length+1);
			
					i=khachHang.length-1;
					
				if(text.length==4&&TrungLap(text[0])==null&&text[2].matches("\\d+")&&text[0].matches("^KH\\d+")) {
					if(khachHang[i]==null)
						khachHang[i]= new newKhachHang(text[0],text[1], Integer.parseInt(text[2]), text[3],1);
					i++;
					}
					else khachHang=Arrays.copyOf(khachHang, khachHang.length-1);
				}
			soLuong=khachHang.length;
			br.close();
			readfile.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void GhiFile(String filename) {
		try {
			FileWriter writefile=new FileWriter(filename);
			FileWriter bin=new FileWriter("KhachHang_recyclebin.txt");
			int i=0;
			if(khachHang==null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}
			while(i<khachHang.length&&khachHang[i]!=null){
				if(khachHang[i].trangthai==1)
					writefile.write(khachHang[i].getId()+"#"+khachHang[i].getTen()+"#"+khachHang[i].getTuoi()+"#"+khachHang[i].getGioitinh()+"\n");
				else 
					bin.write(khachHang[i].getId()+"#"+khachHang[i].getTen()+"#"+khachHang[i].getTuoi()+"#"+khachHang[i].getGioitinh()+"\n");
				i++;
			}
			writefile.close();
			bin.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	//tim kiem thong tin bi trung lap
	//trung lap duoc cho phep
	public static newKhachHang TrungLap(String id){
		if(khachHang==null||khachHang[0]==null)
			return null;
		for(int i=0;i<khachHang.length;i++)
			if(khachHang[i]!=null)
				if(khachHang[i].getId()!=null&&khachHang[i].getId().equals(id))
					return khachHang[i];
			return null;	
	}
	//xuat thong tin
	public static void XuatDanhSach(){
		if(khachHang==null){
			System.out.println("Khong co khach hang nao.");
			return;
		}
		System.out.println("+-----------------------------------DANH SACH KHACH HANG----------------------------------+");
		for(int i=0;i<khachHang.length;i++){
			if(khachHang[i]!=null&&khachHang[i].trangthai==1){
				System.out.println(khachHang[i].Xuat());
			}
		}System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
	}
	public static newKhachHang Them(newKhachHang newKhachHang){
		if(TrungLap(newKhachHang.getId())!=null)
			return null;
		int i;
		if(khachHang==null)
			khachHang=new newKhachHang[1];
		else
			khachHang=Arrays.copyOf(khachHang, khachHang.length+1);
		i=khachHang.length-1;
		khachHang[i]=new newKhachHang();
		
		khachHang[i]=newKhachHang;
		soLuong=khachHang.length;
		return khachHang[i];
	}
	//them thong  tin khach hang
	public static newKhachHang Them(){
		int i;
		if(khachHang==null)
			khachHang=new newKhachHang[1];
		else
			khachHang=Arrays.copyOf(khachHang, khachHang.length+1);
		
		i=khachHang.length-1;
		
		khachHang[i]=new newKhachHang();
		System.out.println("Nhap thong tin khach hang ["+(i+1)+"]");
		khachHang[i].Nhap();
		soLuong++;
		return khachHang[i];
	}
	public static void Them_KhachHang(){
		int soLuongCanThem=-1;
		while(soLuongCanThem==-1){
			System.out.print("Nhap so luong khach hang muon them: ");
			String sl=sc.nextLine();
			if(sl.matches("\\d+")){
				soLuongCanThem=Integer.parseInt(sl);
				if(soLuongCanThem==0){
					if(soLuong==0)
						System.out.println("Danh sach rong");
						else
						System.out.println("Khong them khach hang");
						return ;
				}
				while(soLuongCanThem!=0){
					Them();
					soLuongCanThem--;
				}
			}
			else soLuongCanThem=-1;
		}
	}
	//tim kiem thong tin khach hang
	public static int TimKiem(String id) {
		for (int i = 0; i < khachHang.length; i++) {
			if (khachHang[i].trangthai == 1 && khachHang[i].getId() != null && khachHang[i].getId().equals(id))
				return i;
		}
		return -1;
	}
	
	public static void TimKiem_KhachHang() {
		while (true) {
			System.out.print("Nhap ma so khach hang can tim: ");
			String masokhachhang = sc.nextLine();
			int i = TimKiem(masokhachhang);
			
			if (i == -1) {
				System.out.println("Khong tim thay !");
				System.out.println("1.Tiep tuc tim kiem");
				System.out.println("2.Thoat tim kiem");
				int luachon = Integer.parseInt(sc.nextLine());
				
				if (luachon == 2) {
					return;
				}
			} else {
				System.out.println("Tim thay!\n"+khachHang[i].Xuat());
				System.out.println("1.Tiep tuc tim kiem");
				System.out.println("2.Thoat tim kiem");
				int luachon = Integer.parseInt(sc.nextLine());
				
				if (luachon == 2) {
					return;
				}
			}
		}
	}
	//xoa thong tin
	public static void Xoa(){
		System.out.print("Nhap ID khach hang can xoa: ");
		String id=sc.nextLine();
		int i=TimKiem(id);
		if(i==-1){
			System.out.println("Khong tim thay !");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int chon=Integer.parseInt(sc.nextLine());
			if(chon==1)
				Xoa();
		}
		else{
			khachHang[i].trangthai=0;
			return;
		}
	}
	public static void Xoa_KhachHang() {
		if (khachHang == null) {
			System.out.println("Danh sach rong");
			return;
		}
	
		int soLuongCanXoa = -1;
		while (soLuongCanXoa == -1) {
			System.out.print("Nhap so luong khach hang can xoa (Khong vuot qua " + khachHang.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soLuongCanXoa = Integer.parseInt(sl);
				if (soLuongCanXoa == 0) {
					System.out.println("Khong xoa khach hang");
					return;
				}
				if (soLuongCanXoa > khachHang.length) {
					return;
				}
	
				System.out.println("Chon lua truoc khi xoa:");
				System.out.println("1. Xem danh sach va xoa");
				System.out.println("2. Xoa ngay");
	
				int luaChon = Integer.parseInt(sc.nextLine());
	
				if (luaChon == 1) {
					for (int i = 0; i < soLuongCanXoa; i++) {
						Xem_DanhSach_KhachHang_HienTai();
						Xoa();
					}
				} else if (luaChon == 2) {
					while (soLuongCanXoa != 0) {
						Xoa();
						soLuongCanXoa--;
					}
				} else {
					System.out.println("Lua chon khong hop le. Quay tro lai menu.");
					return;
				}
			} else {
				soLuongCanXoa = -1;
			}
		}
	}
	public static void HienThiKhachHangBiXoa() {
		System.out.println("Danh sach khach hang da bi xoa:");
		for (int i = 0; i < soLuong; i++) {
			if (khachHang[i].trangthai == 0) {
				System.out.println("ID: " + khachHang[i].getId() + ", Ten: " + khachHang[i].getTen() + ", Tuoi: " + khachHang[i].getTuoi() +", Gioi tinh: "+ khachHang[i].getGioitinh()+ " (Da bi xoa)");
			}
		}
	}
	//khoi phuc thong tin da xoa
	public static newKhachHang KhoiPhuc(String idKhachHang_canKhoiPhuc){
		int i;
		for( i=0;i<khachHang.length;i++)
			if(khachHang[i].getId()!=null&&khachHang[i].getId().equals(idKhachHang_canKhoiPhuc)&&khachHang[i].trangthai==0) {
			khachHang[i].trangthai=1;
			return khachHang[i];
		}
		return null;
	}
	public static void KhoiPhuc_KhachHang() {
		if (khachHang == null) {
			System.out.println("Danh sach rong");
			return;
		}
	
		int soLuongCanKhoiPhuc = -1;
		int soKhachHangDaXoa = soKhachHangBiXoa();
	
		if (soKhachHangDaXoa == 0) {
			System.out.println("Khong co khach hang nao bi xoa. Khong can khoi phuc.");
			return;
		}
	
		while (soLuongCanKhoiPhuc == -1) {
			System.out.print("Nhap so luong khach hang can khoi phuc (Khong vuot qua " + soKhachHangDaXoa + "): ");
			String sl = sc.nextLine();
			danhsachKhachHang.HienThiKhachHangBiXoa();
			if (sl.matches("\\d+")) {
				soLuongCanKhoiPhuc = Integer.parseInt(sl);
				if (soLuongCanKhoiPhuc == 0) {
					System.out.println("Khong khoi phuc khach hang");
					return;
				}
				if (soLuongCanKhoiPhuc > soKhachHangDaXoa)
					return;
	
				for (int i = 0; i < soLuongCanKhoiPhuc; i++) {
					System.out.print("Nhap ID khach hang can khoi phuc: ");
					String idKhachHang_canKhoiPhuc = sc.nextLine();
					KhoiPhuc(idKhachHang_canKhoiPhuc);
				}
			} else
				soLuongCanKhoiPhuc = -1;
		}
	}
	
	// Hàm kiểm tra số lượng khách hàng bị xóa
	public static int soKhachHangBiXoa() {
		int count = 0;
		for (int i = 0; i < khachHang.length; i++) {
			if (khachHang[i] != null && khachHang[i].trangthai == 0) {
				count++;
			}
		}
		return count;
	}
	//Sua thong tin
	public static newKhachHang Sua(String idKhachHang_canSua){
		int i=TimKiem(idKhachHang_canSua);
		if(i==-1){
			System.out.println("Khong tim thay !");
			System.out.println("1.Tiep tuc tim kiem");
			System.out.println("2.Thoat tim kiem");
			int chon=Integer.parseInt(sc.nextLine());
			if(chon==1){
				System.out.print("Nhap ID khach hang can Sua: ");
				return Sua(sc.nextLine());
			}else 
				return null;
		}
		int soLuongCanSua=-1;
		while(soLuongCanSua==-1){
			System.out.print("Ban muon Sua bao nhieu thong tin cua khach hang (max=4)");
			String sl=sc.nextLine();
			if(sl.matches("\\d+")){
				soLuongCanSua=Integer.parseInt(sl);
				if(soLuongCanSua>4)
					return null;
				while(soLuongCanSua!=0){
					System.out.println("Sua thong tin cua khach hang\" "+khachHang[i].getTen()+"\"");
					khachHang[i].SuaThongTin();
					soLuongCanSua--;
				}
			}else soLuongCanSua=-1;
		}
		return khachHang[i];
	}
	public static void Sua_KhachHang() {
		if (soLuong == 0) {
			System.out.println("Danh sach rong");
			return;
		}
		int soLuongCanSua = -1;
		while (soLuongCanSua == -1) {
			System.out.print("Nhap so luong khach hang can Sua (Khong vuot qua " + khachHang.length + "): ");
			String sl = sc.nextLine();
			if (sl.matches("\\d+")) {
				soLuongCanSua = Integer.parseInt(sl);
				if (soLuongCanSua == 0) {
					System.out.println("Khong Sua khach hang");
					return;
				}
				if (soLuongCanSua > khachHang.length)
					return;
	
				System.out.println("Chon lua truoc khi Sua:");
				System.out.println("1. Xem danh sach va Sua");
				System.out.println("2. Sua ngay");
	
				int luaChon = Integer.parseInt(sc.nextLine());
	
				if (luaChon == 1) {
					for (int i = 0; i < soLuongCanSua; i++) {
						Xem_DanhSach_KhachHang_HienTai();
						System.out.print("Nhap ID khach hang can Sua: ");
						String idKhachHang_canSua = sc.nextLine();
						Sua(idKhachHang_canSua);
					}
				} else if (luaChon == 2) {
					while (soLuongCanSua != 0) {
						System.out.print("Nhap ID khach hang can Sua: ");
						String idKhachHang_canSua = sc.nextLine();
						Sua(idKhachHang_canSua);
						soLuongCanSua--;
					}
				} else {
					System.out.println("Lua chon khong hop le. Quay tro lai menu.");
					return;
				}
			} else
				soLuongCanSua = -1;
		}
	}
	//danh sach khach hang hien tai
	public static void Xem_DanhSach_KhachHang_HienTai() {
        if (khachHang.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("+------------------------------Danh sach khach hang hien tai------------------------------+");
        for (int i = 0; i < khachHang.length; i++) {
            if (khachHang[i] != null && khachHang[i].trangthai == 1) {
                System.out.println(khachHang[i].Xuat());
            }
        }
		System.out.println("+-----------------------------------------------------------------------------------------+");
    }
    public static KhachHang getKhachHang(int index) {
        if (index >= 0 && index < soLuong) {
            return khachHang[index];
        } else {
            System.out.println("Index is out of bounds.");
            return null; // or throw an exception
        }
    }
}
