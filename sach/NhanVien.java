package sach;
    public abstract class NhanVien extends ConNguoi{
      	private String maNV;
        private String chucVu;
        private double luong=0;
        public int trangthai;     
        
    public NhanVien(String maNV, String ten, int tuoi, String gioitinh,String chucVu, double luong,int trangthai) {
        super(ten, tuoi, gioitinh);
        this.maNV= maNV;
        this.chucVu = chucVu;
        this.luong = luong;
        this.trangthai=trangthai;
    }

    public NhanVien() {
       super();
    }

    public String getMaNV() {
        return maNV;
    }

    public boolean setMaNV(String maNV) {
        if(maNV!=null && !maNV.isEmpty()){
            this.maNV = maNV;
            return true;
        } else {
            System.err.println("Moi nnhap lai ma nhan vien: ");
            return false;
        }
    }
  
    public String getChucVu() {
        return chucVu;
    }

    public boolean setChucVu(String chucVu) {
        if(chucVu!=null && !chucVu.isEmpty()){
            this.chucVu = chucVu;
            return true;
        } else{
            System.err.print("Moi nhap lai chuc vu: ");
            return false;
        }                     
    }


    public double getLuong() {
        return luong;
    }

    public boolean setLuong(double luong) {
        if(luong>0&&luong<1000000000){         
            this.luong = luong;
            return true;
        } else{
            System.err.print("Nhap lai luong: ");
            return false;
        }           
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public abstract double TinhLuong();

    @Override
    public void Nhap() {
    	while (this.maNV == null || this.maNV.isEmpty()) {
			System.out.print("Nhap Ma So Nhan Vien: ");
			String newmaNV = sc.nextLine();
			
			if (newmaNV.matches("\\d+")) {
				this.maNV = newmaNV;
			}
			
		}
        
        super.Nhap();
        
        while (chucVu == null || this.chucVu.isEmpty()) {
			System.out.print("Nhap Chuc Vu: ");
			this.chucVu = sc.nextLine();
		}
        while (this.luong <= 0 || this.luong > 100000000) {
			System.out.print("Nhap Luong "+this.chucVu+": ");
			String newluong = sc.nextLine();
			
			if (newluong.matches("\\d+\\d*\\.?\\,?"))
				this.luong = Double.parseDouble(newluong);
			else
				this.luong = 0;
			
		}
        this.trangthai=1;
    }
 @Override
	public void SuaThongTin() {
        System.out.println("1.Sua Ma nhan vien");
		System.out.println("2.Sua Ho va Ten nhan vien");
		System.out.println("3.Sua Tuoi nhan vien");
		System.out.println("4.Sua Gioi tinh nhan vien");
        System.out.println("5.Sua Chuc vu nhan vien");
        System.out.println("6.Sua Luong nhan vien");
        System.out.print("Nhap lua chon: ");
        
		int luachon=Integer.parseInt(sc.nextLine());
		boolean exitLoop=false;
		
			switch(luachon){
			case 1:while(!exitLoop) {
	                            System.out.print("Nhap Ma nhan vien moi: ");
	                            String newmaNV=sc.nextLine();
	                            if(!newmaNV.equals(this.getMaNV())){
	                                    this.setMaNV(newmaNV);
	                                    exitLoop=true;
	                            }
				}                       
	                        break;
			case 2:while(!exitLoop) {
	                            System.out.print("Nhap Ho va Ten moi: ");
	                            String newten=sc.nextLine();
	                            if(!newten.equals(this.getTen())){
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
			case 5:while(!exitLoop){
	                            System.out.println("Nhap Chuc vu moi: ");
					String newchucVu=sc.nextLine();
					if(!newchucVu.equals(this.chucVu)) {
						this.chucVu=newchucVu;
						exitLoop=true;
					}                                   
	                        }
				break;
			case 6:while(!exitLoop){
	                            System.out.print("Nhap Luong moi: ");
	                            String newluong=sc.nextLine();
					if(newluong.matches("\\d+\\d*\\.?\\,?")&&Double.parseDouble(newluong)!=this.luong&&Double.parseDouble(newluong)>0&&Double.parseDouble(newluong)<1000000000) {
							this.luong=Double.parseDouble(newluong);
							exitLoop=true;
						}
	                        }
				break;
			default:
				break;
		}
		
}
	public void CapNhat_NhanVien(String maNV,String ten, int tuoi, String gioitinh,String chucVu,double luong,int trangthai) {
		this.setMaNV(maNV);
        this.setTen(ten);
		this.setTuoi(tuoi);
		this.setGioitinh(gioitinh);
		this.chucVu = chucVu;		
        this.luong=luong;
		this.trangthai=trangthai;

	}
    @Override
    public String Xuat() {
        return String.format("MANV: %-15s | %s |Chuc vu: %-15s | Luong: %-13s ",maNV,super.Xuat(),chucVu,luong, "VND");	
    }
    
}
    
