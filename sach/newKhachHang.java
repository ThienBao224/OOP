package sach;

public class newKhachHang extends KhachHang {
    public newKhachHang(){
        super();
    }
    public newKhachHang(String id, String ten, int tuoi,String gioitinh, int trangThai){
        super(id,ten,tuoi,gioitinh,trangThai);
    }
@Override
    public void Nhap() {
		while(this.getId()==null||this.getId().isEmpty()){
			System.out.print("Nhap ID khach hang: ");
			String newId=sc.nextLine();
			if(newId.matches("^KH\\d+")) {
				KhachHang new_Id=danhsachKhachHang.TrungLap(newId);
				if (new_Id==null) {
		            this.setId(newId);
		            break;
				}else if(new_Id!=null&&new_Id.getTrangThai()==1)
					System.out.println("Trung lap khach hang - hay nhap lai");
				else {
					System.out.println("Khach hang da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc thong tin khach hang ");
					System.out.println("2.Khoi phuc va Sua thong tin khach hang");
					System.out.println("3.Tao khach hang moi");
					int chon_1=Integer.parseInt(sc.nextLine());
					switch(chon_1){
						case 1:danhsachKhachHang.KhoiPhuc(newId);
								System.out.println("Da khoi phuc");
								return;
						case 2:danhsachKhachHang.KhoiPhuc(newId);
								danhsachKhachHang.Sua(newId);
								System.out.println("Dang Sua");
								return;
						default:danhsachKhachHang.Them();
								return;
					}
				}
			}
		}
		super.Nhap();
    }
@Override
    public void SuaThongTin(){
	System.out.println("1.Sua Ma so khach hang");
	System.out.println("2.Sua Ho va Ten khach hang");
	System.out.println("3.Sua Tuoi khach hang");
	System.out.println("4.Sua Gioi tinh khach hang");
	System.out.print("Nhap lua chon: ");
	int chon=Integer.parseInt(sc.nextLine());
	boolean exitLoop=false;
		switch(chon) {
		case 1:
			while(!exitLoop) {
				System.out.println("Nhap Ma so moi cua khach hang( bat dau bang KH... VD: KH123): ");
				String newId=sc.nextLine();
				if(newId.matches("^KH\\d+")) {
					KhachHang new_Id=danhsachKhachHang.TrungLap(newId);
					if (new_Id==null&&!this.getId().equals(newId)) {
		                this.setId(newId);
		                exitLoop=true;
		                break; 
					}
					else if(new_Id!=null&&new_Id.getTrangThai()==1){
							System.out.println("Trung lap khach hang moi nhap lai:");
							exitLoop=false;
						} else {
							System.out.println("khach hang da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Khoi phuc khach hang");
							System.out.println("2.Khoi phuc va Sua thong tin khach hang");
							System.out.println("3.Thoat");
							int chon_1=Integer.parseInt(sc.nextLine());
							switch(chon_1){
								case 1:danhsachKhachHang.KhoiPhuc(newId);
										System.out.println("Da khoi phuc");
									return;
								case 2:danhsachKhachHang.KhoiPhuc(newId);
										danhsachKhachHang.Sua(newId);
										System.out.println("Dang Sua");
									return;
								default:
									return;
							}
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
/* 
	public void SuaThongTin_ChoPhepTrungLap() {
	System.out.println("1.Sua ID khach hang");
	System.out.println("2.Sua Ho va Ten khach hang");
	System.out.println("3.Sua Tuoi khach hang");
	System.out.println("4.Sua Gioi tinh khach hang");
	System.out.print("Nhap lua chon: ");
	int chon=Integer.parseInt(sc.nextLine());
	boolean exitLoop=false;
		switch(chon) {
		case 1:
			while(!exitLoop) {
				KhachHang new_Id=new KhachHang();
				System.out.print("Nhap Ma so cua khach hang: ");
				String newId=sc.nextLine();
				if(newId.matches("\\d+")) {
					new_Id=danhsachKhachHang.TrungLap(newId);
					if(!exitLoop&&this.getId()!=null&&!newId.equals(this.getId())) {
						if(new_Id==null) {
							this.setId(newId);
			                exitLoop=true;
			                break; 
						}else {
							if(new_Id.getTrangThai()==1) {
								System.out.println("Trung lap du lieu - hay lua chon:");
								System.out.println("1.Nhan thong tin khach hang ");
								System.out.println("2.Sua thong tin khach hang");
								System.out.println("3.Thoat");
								int chon_1=Integer.parseInt(sc.nextLine());
								switch(chon_1){
									case 1:System.out.println("Da khoi phuc");
										break;
									case 2:new_Id=danhsachKhachHang.Sua(newId);
											System.out.println("Dang Sua");
											break;
									default:
											return;
								}
							}
							else {
								System.out.println("khach hang da bi xoa du lieu - hay lua chon:");
								System.out.println("1.Khoi phuc va Nhan thong tin khach hang ");
								System.out.println("2.Khoi phuc - Nhan va Sua thong tin khach hang");
								System.out.println("3.Thoat");
								int chon_1=Integer.parseInt(sc.nextLine());
								switch(chon_1){
									case 1:new_Id=danhsachKhachHang.KhoiPhuc(newId);
											System.out.println("Da khoi phuc");
											break;
									case 2:danhsachKhachHang.KhoiPhuc(newId);
											new_Id=danhsachKhachHang.Sua(newId);
											System.out.println("Dang Sua");
											break;
									default:
											return;
								}
							}
						}
					}
					if(new_Id!=null) {
							CapNhatKhachHang(new_Id.getId(),new_Id.getTen(),new_Id.getTuoi(),new_Id.getGioitinh(),new_Id.getTrangThai());
							exitLoop=true;
							return;

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
			
	}*/
@Override
	public String Xuat() {
		return super.Xuat();
	}
}
