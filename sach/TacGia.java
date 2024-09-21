package sach;

public class TacGia extends ConNguoi {
	private String quequan;
	public int trangthai;
	private String masoTacGia;
	private String vaitro = "Tac gia";

	public TacGia(String masoTacGia, String ten, int tuoi, String gioitinh, String quequan, int trangthai) {
		super(ten, tuoi, gioitinh);
		this.quequan = quequan;
		this.trangthai = trangthai;
		this.masoTacGia = masoTacGia;
	}

	public TacGia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getMasoTacGia() {
		return masoTacGia;
	}

	public void setMasoTacGia(String masoTacGia) {
		this.masoTacGia = masoTacGia;
	}

	public String getVaitro() {
		return vaitro;
	}

	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}

	@Override
	public void Nhap() {
		while (this.masoTacGia == null || this.masoTacGia.isEmpty()) {
			System.out.print("Nhap Ma so Tac gia: ");
			String newmasoTacGia = sc.nextLine();
			
			if (newmasoTacGia.matches("\\d+")) {
				this.masoTacGia = newmasoTacGia;
			}
			
		}
		// TODO Auto-generated method stub
		super.Nhap();
		
		while (quequan == null || this.quequan.isEmpty()) {
			System.out.print("Nhap Que quan: ");
			this.quequan = sc.nextLine();
		}
		
		this.trangthai = 1;
	}

	@Override
	public void SuaThongTin() {
		System.out.println("1.Sua Ma so tac gia");
		System.out.println("2.Sua Ho va Ten tac gia");
		System.out.println("3.Sua Tuoi tac gia");
		System.out.println("4.Sua Gioi tinh tac gia");
		System.out.println("5.Sua Que quan tac gia");
		System.out.print("Nhap lua chon: ");
		
		int luachon = Integer.parseInt(sc.nextLine());
		boolean exitLoop = false;
		
		switch (luachon) {
		case 1:
			while (!exitLoop) {
				System.out.print("Nhap Ma so moi cua Tac gia: ");
				String newmasoTacGia = sc.nextLine();
				
				if (newmasoTacGia.matches("\\d+")) {
					if (!this.masoTacGia.equals(newmasoTacGia)) {
						this.masoTacGia = newmasoTacGia;
						exitLoop = true;
						break;
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
				System.out.print("Nhap que quan moi cua Tac gia: ");
				String newquequan = sc.nextLine();
				
				if (!newquequan.equals(quequan)) {
					this.quequan = newquequan;
					exitLoop = true;
				}
				
			}
			break;
		default:
			break;
		}

	}

	public void CapNhat_TacGia(String masoTacGia, String ten, int tuoi, String gioitinh, String quequan, int trangthai) {
		this.setTen(ten);
		this.setTuoi(tuoi);
		this.setGioitinh(gioitinh);
		this.quequan = quequan;
		this.trangthai = trangthai;
		this.masoTacGia = masoTacGia;
	}

	@Override
	public String Xuat() {
		// TODO Auto-generated method stub
		return String.format("Ma so tac gia: %-15s | %s | Quen quan: %-13s | Vai tro: %s", masoTacGia, super.Xuat(),
				quequan, vaitro);
	}
}
