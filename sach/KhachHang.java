package sach;
import java.util.Scanner;
public class KhachHang  extends ConNguoi {
    public Scanner sc=new Scanner(System.in);
    //thuoc tinh
    private String id;
	public int trangthai;
    //constructor
    public KhachHang(String id,String ten,int tuoi,String gioitinh,int trangThai){
        super(ten,tuoi,gioitinh);
        this.id=id;
		this.trangthai=trangThai;
    }
    public KhachHang(){
        super();
    }
    //getter_setter
	public int getTrangThai(){
		return trangthai;
	}
	public void setTrangThai(int trangThai){
		this.trangthai=trangThai;
	}
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    //cac phuong thuc nhap_xuat
@Override
    public void Nhap(){
        while (this.id==null||this.id.isEmpty()) {
            System.out.print("Nhap ma so khach hang: ");
            String newId=sc.nextLine();
            if(newId.matches("^KH\\d+")){
                this.id=newId;
            }
        }
        super.Nhap();
		this.trangthai=1;
		System.out.println("-------------------");
    }
@Override
    public void SuaThongTin(){
        System.out.println("1.Sua ID khach hang");
        System.out.println("2.Sua Ho va Ten khach hang");
        System.out.println("3.Sua Tuoi khach hang");
        System.out.println("4.Sua Gioi tinh khach hang");
        System.out.println("Nhap lua chon: ");
        int chon=Integer.parseInt(sc.nextLine());
        boolean exitLoop=false;
		switch(chon) {
		case 1:
			while(!exitLoop) {
				System.out.println("Nhap Ma so moi cua khach hang");
				String newId=sc.nextLine();
				if(newId.matches("^KH\\d+")) {
					if (!this.id.equals(newId)) {
		                this.id = newId;
		                exitLoop=true;
		                break; 
	                }
				}
			}
			break;
		case 2:while(!exitLoop){
			System.out.print("Nhap Ho va Ten moi: ");
			String newTen=sc.nextLine();
			if(!newTen.equals(this.getTen())) {
				this.setTen(newTen);
				exitLoop=true;
			}
		}
			break;
		case 3:while(!exitLoop){
			System.out.print("Nhap Tuoi moi: ");
			String newTuoi=sc.nextLine();
				if(newTuoi.matches("\\d+")&&Integer.parseInt(newTuoi)!=this.getTuoi()&&Integer.parseInt(newTuoi)>0&&Integer.parseInt(newTuoi)<200) {
					this.setTuoi(Integer.parseInt(newTuoi));
					exitLoop=true;
				}
			}
				break;
		case 4:while(!exitLoop){
			System.out.print("Nhap Gioi tinh moi: ");
			String newGioiTinh=sc.nextLine();
			if(!newGioiTinh.equals(this.getGioitinh())) {
				this.setGioitinh(newGioiTinh);
				exitLoop=true;
			}
		}
			break;

		default:
			break;
	}
}
    public void CapNhatKhachHang(String id,String ten, int tuoi, String gioiTinh, int trangThai) {
		this.setTen(ten);
		this.setTuoi(tuoi);
		this.setGioitinh(gioiTinh);
		this.id=id;
		this.trangthai=trangThai;
	}
	
@Override
public String Xuat() {
	return String.format("|ID-KH: %-5s|%s|",id,super.Xuat());	
}
}

