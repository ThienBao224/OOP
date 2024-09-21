package sach;
public class newBaoVe extends BaoVe {
	public newBaoVe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public newBaoVe( String maNV, String ten, int tuoi, String gioitinh, String chucVu,String kynang, double luong, int trangthai) {
		super( maNV, ten, tuoi, gioitinh, chucVu,kynang, luong,trangthai);

	}
	@Override
    public void Nhap() {
		
		while(this.getMaNV()==null||this.getMaNV().isEmpty()){
			
			System.out.print("Nhap Ma so Bao Ve( bat dau bang BV... VD: BV123): ");
			String newMaNV=sc.nextLine();
			
			if(newMaNV.matches("^BV\\d+")) {
				BaoVe new_MaNV=danhsachBaoVe.TrungLap(newMaNV);
				
				if (new_MaNV==null) {
		            this.setMaNV(newMaNV);
		            break;
		            
				}else if(new_MaNV!=null&&new_MaNV.getTrangthai()==1)
					System.out.println("Trung lap Bao Ve - hay nhap lai");
				
				else {
					System.out.println("Bao Ve da bi xoa du lieu - hay lua chon:");
					System.out.println("1.Khoi phuc thong tin Bao Ve ");
					System.out.println("2.Khoi phuc va Sua thong tin Bao Ve");
					System.out.println("3.Tao Bao Ve moi");
					
					int luachon_1=Integer.parseInt(sc.nextLine());
					
					switch(luachon_1){
					
						case 1:danhsachBaoVe.KhoiPhuc(newMaNV);
								System.out.println("Da khoi phuc");
								return;
								
						case 2:danhsachBaoVe.KhoiPhuc(newMaNV);
								danhsachBaoVe.Sua(newMaNV);
								System.out.println("Dang Sua");
								return;
								
						default:danhsachBaoVe.Them();
								return;
								
					}
				}
			}
		}
        
        while(this.getTen()==null||this.getTen().isEmpty()){
        	
			System.out.print("Nhap Ho va Ten: ");
			String newten=sc.nextLine();
			
			if(!newten.matches(".*\\d.*"))
				this.setTen(newten);
			
			else
				this.setTen(null);
			
		}
		while(this.getTuoi()<=0||this.getTuoi()>200){
			
			System.out.print("Nhap Tuoi: ");
			String newtuoi=sc.nextLine();
			
			if(newtuoi.matches("\\d+"))
				this.setTuoi(Integer.parseInt(newtuoi));
			
			else
				this.setTuoi(0);
			
		}
		while(this.getGioitinh()==null||this.getGioitinh().isEmpty()){
			
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
        while (this.getKynang() == null || this.getKynang().isEmpty()) {
			System.out.print("Nhap ky Nang: ");
			this.setKynang(sc.nextLine());
	}
	        this.trangthai=1;
    }
	@Override
	public void SuaThongTin() {
		
	System.out.println("1.Sua Ma so Bao Ve");
	System.out.println("2.Sua Ho va Ten Bao Ve");
	System.out.println("3.Sua Tuoi Bao Ve");
	System.out.println("4.Sua Gioi tinh Bao Ve");
	System.out.println("5.Sua Chuc vu Bao Ve");
	System.out.println("6.Sua Ky Nang Bao Ve");
	System.out.println("7.Sua Luong Bao Ve");
	System.out.print("Nhap lua chon: ");
	
	int luachon=Integer.parseInt(sc.nextLine());
	boolean exitLoop=false;
	
		switch(luachon) {
		
		case 1:
			while(!exitLoop) {
				
				System.out.print("Nhap Ma so moi cua Bao Ve( bat dau bang BV... VD: BV123): ");
				String newMaNV=sc.nextLine();
				
				if(newMaNV.matches("^BV\\d+")) {
					BaoVe new_MaNV=danhsachBaoVe.TrungLap(newMaNV);
					
					if (new_MaNV==null&&!this.getMaNV().equals(newMaNV)) {
		                this.setMaNV(newMaNV);
		                exitLoop=true;
		                break; 
		                
					}
					else if(new_MaNV!=null&&new_MaNV.getTrangthai()==1){
							System.out.println("Trung lap Bao Ve moi nhap lai:");
							exitLoop=false;
							
						} else {
							System.out.println("Bao Ve da bi xoa du lieu - hay lua chon:");
							System.out.println("1.Khoi phuc Bao Ve");
							System.out.println("2.Khoi phuc va Sua thong tin Bao Ve");
							System.out.println("3.Thoat");
							
							int luachon_1=Integer.parseInt(sc.nextLine());
							
							switch(luachon_1){
							
								case 1:danhsachBaoVe.KhoiPhuc(newMaNV);
										System.out.println("Da khoi phuc");
									return;
									
								case 2:danhsachBaoVe.KhoiPhuc(newMaNV);
										danhsachBaoVe.Sua(newMaNV);
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
			String newten=sc.nextLine();
			
			if(!newten.equals(this.getTen())) {
				this.setTen(newten);
				exitLoop=true;
			}
			
		}
			break;
		case 3:while(!exitLoop){
			
			System.out.print("Nhap Tuoi moi: ");
			String newtuoi=sc.nextLine();
			
				if(newtuoi.matches("\\d+")&&Integer.parseInt(newtuoi)!=this.getTuoi()&&Integer.parseInt(newtuoi)>0&&Integer.parseInt(newtuoi)<200) {
					this.setTuoi(Integer.parseInt(newtuoi));
					exitLoop=true;
				}
				
			}
				break;
		case 4:while(!exitLoop){
			
			System.out.print("Nhap Gioi tinh moi: ");
			String newgioitinh=sc.nextLine();
			
			if(!newgioitinh.equals(this.getGioitinh())) {
				this.setGioitinh(newgioitinh);
				exitLoop=true;
			}
			
		}
			break;
		case 5:
			while(!exitLoop) {
				
				System.out.print("Nhap chuc vu moi cua Bao Ve: ");
				String newchucvu=sc.nextLine();
				
				if(!newchucvu.equals(this.getChucVu())) {
					this.setChucVu(newchucvu);
					exitLoop=true;
				}
				
			}	
			break;
		case 6:
			while(!exitLoop) {
				
				System.out.print("Nhap Ky nang moi cua Bao Ve: ");
				String newKynang=sc.nextLine();
				
				if(!newKynang.equals(this.getKynang())) {
					this.setKynang(newKynang);
					exitLoop=true;
				}
				
			}	
			break;
		case 7:	while(!exitLoop){
			
			System.out.print("Nhap Luong moi cua Bao Ve: ");
			String newLuong=sc.nextLine();
			
				if(newLuong.matches("\\d+\\d*\\.?\\,?")&&Double.parseDouble(newLuong)!=this.getLuong()) {
					this.setLuong(Integer.parseInt(newLuong));
					exitLoop=true;
				}
				
			}
			break;
		default:
			break;
		}	
	}
	
}
