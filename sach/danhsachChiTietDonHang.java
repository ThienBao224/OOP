package sach;

import java.util.*;
import java.io.*;

public class danhsachChiTietDonHang {

	public static Scanner sc = new Scanner(System.in);
	private static int soluong = 0;
	private static ChiTietDonHang ChiTietDonHang[];
	public danhsachChiTietDonHang() {
	}

	public static int getSoluong() {
		return soluong;
	}

	public static void setSoluong(int sl) {
		soluong = sl;
	}
	public static ChiTietDonHang getChiTietDonHang(int i) {
		return ChiTietDonHang[i];
	}
	public static ChiTietDonHang[] getChiTietDonHang() {
		return ChiTietDonHang;
	}

	// nhập thông tin
	public static void NhapDanhSach() {
		while (soluong == 0) {

			System.out.print("Nhap so luong Don Hang: ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+"))
				soluong = Integer.parseInt(sl);
			else
				soluong = 0;

		}

		ChiTietDonHang = new ChiTietDonHang[soluong];

		for (int i = 0; i < ChiTietDonHang.length; i++) {
			ChiTietDonHang[i] = new ChiTietDonHang();
			System.out.println("Nhap thong tin Don Hang:");
			ChiTietDonHang[i].Nhap();
		}

	}
	private static int demSoHoaDon(String filename) throws IOException {
        FileReader readfile = new FileReader(filename);
        BufferedReader br = new BufferedReader(readfile);

        int soHoaDon = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("//")) {
                soHoaDon++;
            }
        }

        br.close();
        readfile.close();

        return soHoaDon;
    }
	// đọc file
	public static void DocFile(String filename) {
        try {
            FileReader readfile = new FileReader(filename);
            BufferedReader br = new BufferedReader(readfile);
            String line;

            int soHoaDon = demSoHoaDon(filename);
            ChiTietDonHang = new ChiTietDonHang[soHoaDon];
            int currentIndex = 0;

            while ((line = br.readLine()) != null) {
                if (line.equals("//")) {
                    currentIndex++;
                    if (currentIndex >= ChiTietDonHang.length) {
                    	ChiTietDonHang = Arrays.copyOf(ChiTietDonHang, ChiTietDonHang.length * 2);
                    }
                } else {
                    String[] text = line.split("#");
                    if (text.length == 3) {
                        String maHoaDon = text[0];
                        String maSach = text[1];
                        int soLuong = Integer.parseInt(text[2]);

                        if (ChiTietDonHang[currentIndex] == null&&TrungLap(maHoaDon)==null) {
                        	ChiTietDonHang[currentIndex] = new ChiTietDonHang();
                        	ChiTietDonHang[currentIndex].setMahoadon(maHoaDon);
                        }
                        ChiTietDonHang[currentIndex].themMasach(maSach, soLuong);
	
                    }
                    
                }
            }

            br.close();
            readfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	// ghi file
	public static void GhiFile(String filename) {
		try {

			FileWriter writefile = new FileWriter(filename);
			FileWriter bin = new FileWriter("ChiTietDonHang_recyclebin.txt");

			int i = 0;

			if (ChiTietDonHang == null) {
				System.out.println("Danh sach rong");
				writefile.close();
				bin.close();
				return;
			}

			while (i < ChiTietDonHang.length && ChiTietDonHang[i] != null) {
				
				if (ChiTietDonHang[i]!=null&&ChiTietDonHang[i].getSach().length>0) {
					for(int j=0;j<ChiTietDonHang[i].getSach().length;j++)
						
						writefile.write(ChiTietDonHang[i].getMahoadon() + "#" + ChiTietDonHang[i].getSach(j).getMaSach()
										+ "#" + ChiTietDonHang[i].getSo_luong_moi_loai(j)+"\n");
						writefile.write("//\n");
					}
				else {
					for(int j=0;j<ChiTietDonHang[i].getSach().length;j++)
						bin.write(ChiTietDonHang[i].getMahoadon() + "#" + ChiTietDonHang[i].getSach(j).getMaSach()
									+ "#" + ChiTietDonHang[i].getSo_luong_moi_loai(j)+"\n");
						bin.write("//\n");
					}

				i++;

			}

			writefile.close();
			bin.close();

		} catch (IOException e) {
			e.printStackTrace();
		  }

	}
	public static int TimKiem(String masoChiTietDonHang) {
		for (int i = 0; i < ChiTietDonHang.length; i++) {
			if ( ChiTietDonHang[i].getMahoadon() != null&& ChiTietDonHang[i].getMahoadon().equals(masoChiTietDonHang))
				return i;
		}

		return -1;
	}
	// tìm kiếm thông tin bị trùng lặp
	// trùng lặp được cho phép
	public static ChiTietDonHang TrungLap(String masoChiTietDonHang) {
		if (ChiTietDonHang == null || ChiTietDonHang[0] == null)
			return null;

		for (int i = 0; i < ChiTietDonHang.length; i++)
			if (ChiTietDonHang[i] != null)
				if (ChiTietDonHang[i].getMahoadon() != null && ChiTietDonHang[i].getMahoadon().equals(masoChiTietDonHang))
					return ChiTietDonHang[i];

		return null;

	}

	// xuất thông tin
	public static void XuatDanhSach() {

		if (ChiTietDonHang == null||danhsachDonHang.getDanhSachDonHang()==null||danhsachKhachHang.getKhachHang()==null) {
			System.out.println("Khong co Don Hang nao");
			return;
		}

		for (int i = 0; i < ChiTietDonHang.length; i++) {
			if (ChiTietDonHang[i] != null) {
				System.out.println("");
				System.out.println(ChiTietDonHang[i].Xuat());
			}
		}System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
	}

	// sắp xếp theo mã tác giả
	
	public static ChiTietDonHang Them(ChiTietDonHang newChiTietDonHang) {
		if(TrungLap(newChiTietDonHang.getMahoadon())!=null)
			return null;
		int i;

		if (ChiTietDonHang == null)
			ChiTietDonHang = new ChiTietDonHang[1];
		else
			ChiTietDonHang = Arrays.copyOf(ChiTietDonHang, ChiTietDonHang.length + 1);

		i = ChiTietDonHang.length - 1;
		ChiTietDonHang[i] = new ChiTietDonHang();

		ChiTietDonHang[i]=newChiTietDonHang;
		soluong = ChiTietDonHang.length;

		return ChiTietDonHang[i];

	}
	// thêm thông tin đối tượng
	public static ChiTietDonHang Them() {
		int i;

		if (ChiTietDonHang == null)
			ChiTietDonHang = new ChiTietDonHang[1];
		else
			ChiTietDonHang = Arrays.copyOf(ChiTietDonHang, ChiTietDonHang.length + 1);

		i = ChiTietDonHang.length - 1;
		ChiTietDonHang[i] = new ChiTietDonHang();

		System.out.println("nhap thong tin Don Hang");

		ChiTietDonHang[i].Nhap();
		soluong = ChiTietDonHang.length;

		return ChiTietDonHang[i];

	}

	public static void Them_ChiTietDonHang() {
		int so_luong_can_them = -1;

		while (so_luong_can_them == -1) {

			System.out.print("Nhap so luong Don Hang can them: ");
			String sl = sc.nextLine();

			if (sl.matches("\\d+")) {
				so_luong_can_them = Integer.parseInt(sl);

				if (so_luong_can_them == 0) {
					if (ChiTietDonHang == null)
						System.out.println("Danh sach rong");
					else
						System.out.println("Khong them sach");
					return;
				}

				while (so_luong_can_them != 0) {
					Them();
					so_luong_can_them--;
				}

			} else
				so_luong_can_them = -1;

		}
	}

	// tìm kiếm thông tin
}
