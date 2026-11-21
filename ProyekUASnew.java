package KelasB;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProyekUASnew {
    public static void main(String[] args) {
        try{
            BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
            boolean ulang = true;
            
            //daftar pelanggaran
            int jumlah = 4;
            String [] peraturan = new String [100];
            peraturan [0] = "Selesai";
            peraturan [1] = "hilang kunci";
            peraturan [2] = "merusak jendela";
            peraturan [3] = "merusak pintu";
            
            //daftar denda
            int [] denda = new int [100];
            denda [0] = 0;
            denda [1] = 50000;
            denda [2] = 200000;
            denda [3] = 150000;
            
            while (ulang) {
                
                System.out.println("     CintaKos Tempat Sewa Kos Online!      ");
                System.out.println("===========================================");
                System.out.println("| 1.     Sewa Kos                         |");
                System.out.println("| 2.     Aturan dan Denda                 |");
                System.out.println("| 3.     DompetKos (Atur Uang Anak Kos)   |");
                System.out.println("===========================================");
                
                int harga, bulan, pilihan, total;
                String no;

                System.out.print("Pilih Menu [ 1 s/d 3 ] : ");
                pilihan = Integer.parseInt(input.readLine());
                switch(pilihan)
                {
                    case 1 :
                        //sewa kos
                        System.out.println("=======================================================");
                        System.out.print("Input Nomor Kamar Kos               : ");
                        no = input.readLine();
                        System.out.print("Input Harga Kamar Kos Per Bulan     : Rp  ");
                        harga = Integer.parseInt(input.readLine());
                        System.out.print("Input Berupa Bulan Kamu Sewa        : ");
                        bulan = Integer.parseInt(input.readLine());
                        total = harga*bulan;
                        System.out.println("Total biaya yang harus anda bayar yaitu : Rp "+total);
                        System.out.println("=======================================================");
                        break;
                    case 2 :
                        //aturan dan denda
                            System.out.println("=================================");
                            System.out.println("| 1. Tambah pelanggaran & denda |");
                            System.out.println("| 2. Hitung denda               |");
                            System.out.println("=================================");
                            System.out.print("Pilih Menu [ 1 s/d 2 ] : ");
                            int jalur = Integer.parseInt(input.readLine());

                            switch(jalur) {
                                case 1:
                                    //Tambah pelanggaran & denda
                                    System.out.print("Tambah pelanggaran: ");
                                    String peraturan_b = input.readLine();
                                    System.out.print("Tambah denda: ");
                                    int denda_b = Integer.parseInt(input.readLine());

                                    peraturan [jumlah] = peraturan_b;
                                    denda [jumlah] = denda_b;
                                    jumlah++;

                                    System.out.println("   Pelanggaran dan denda telah di simpan   ");
                                    System.out.println("===========================================");
                                    break;

                                case 2:
                                    //Hitung denda
                                    for (int i = 0; i < jumlah; i++) {
                                        System.out.println((i + 1) + ". " + peraturan[i] + ": " + denda[i]);
                                    }
                                    boolean input_kslhn = true;
                                    total =  0;
                                    while (input_kslhn) {
                                        System.out.print("pelanggaran yang dilakukan: ");
                                        int kesalahan = Integer.parseInt(input.readLine());

                                        if ((kesalahan > 1) && (kesalahan <= jumlah)) {
                                            total += denda[kesalahan - 1];
                                            System.out.println("denda : RP" + denda[kesalahan - 1]);
                                        }
                                        else if ((kesalahan > jumlah)|| (kesalahan < 1 )) {
                                            System.out.println("tidak ada peraturan itu");
                                        }
                                        else {
                                            input_kslhn = false;
                                        }
                                    }
                                    System.out.println("   Total denda: RP" + total);
                                    System.out.println("========================================");
                                    break;
                            }
                        break;
                    case 3 : {
                        //DOMPET ANAK KOS - catat pengeluaran dan cek kondisi uang saku
                        System.out.println("=============================================");
                        System.out.println("       DOMPET ANAK KOS - CEK UANG SAKU       ");
                        System.out.println("=============================================");

                        //input uang saku (diulang sampai valid)
                        int uangSaku = 0;
                        while (uangSaku <= 0) {
                            System.out.print("Uang Saku Bulan Ini           : Rp ");
                            uangSaku = Integer.parseInt(input.readLine());
                            if (uangSaku <= 0) {
                                System.out.println("Uang saku harus lebih dari 0!");
                            }
                        }

                        //catat pengeluaran sampai input 0
                        int totalKeluar = 0;
                        int jumlahCatatan = 0;
                        int terbesar = 0;
                        boolean catat = true;
                        while (catat) {
                            System.out.print("Pengeluaran ke-" + (jumlahCatatan + 1) + " (0 = selesai) : Rp ");
                            int pengeluaran = Integer.parseInt(input.readLine());

                            if (pengeluaran == 0) {
                                catat = false;
                            }
                            else if (pengeluaran < 0) {
                                System.out.println("Pengeluaran tidak boleh negatif!");
                            }
                            else {
                                totalKeluar += pengeluaran;
                                jumlahCatatan++;
                                if (pengeluaran > terbesar) {
                                    terbesar = pengeluaran;
                                }
                            }
                        }

                        //perhitungan
                        int sisaUang = uangSaku - totalKeluar;
                        int persenTerpakai = totalKeluar * 100 / uangSaku;

                        System.out.println("\n=========== LAPORAN DOMPET KAMU ============");
                        System.out.println("Uang Saku           : Rp " + uangSaku);
                        System.out.println("Jumlah Pengeluaran  : " + jumlahCatatan + " kali");
                        System.out.println("Total Pengeluaran   : Rp " + totalKeluar);
                        if (jumlahCatatan > 0) {
                            System.out.println("Rata-rata / Catatan : Rp " + (totalKeluar / jumlahCatatan));
                            System.out.println("Pengeluaran Terbesar: Rp " + terbesar);
                        }
                        System.out.println("Uang Terpakai       : " + persenTerpakai + "%");

                        if (sisaUang >= 0) {
                            System.out.println("Sisa Uang           : Rp " + sisaUang);
                        }
                        else {
                            System.out.println("Kekurangan          : Rp " + (sisaUang * -1));
                        }

                        //status kondisi dompet
                        if (persenTerpakai < 50) {
                            System.out.println("Status              : HEMAT! Dompetmu aman.");
                        }
                        else if (persenTerpakai <= 80) {
                            System.out.println("Status              : WAJAR, tetap kontrol jajan ya.");
                        }
                        else if (persenTerpakai <= 100) {
                            System.out.println("Status              : HATI-HATI, uang hampir habis!");
                        }
                        else {
                            System.out.println("Status              : BOROS! Pengeluaran melebihi uang saku.");
                        }
                        System.out.println("=============================================");
                        break;
                    }
                    
                    default :
                        System.out.println("KODE OPERASI SALAH!!");
                        break;
                }
                
                System.out.print("Ulang? (y/n): ");
                String a = input.readLine();
                
                if ((a.equals("n")) && (ulang == true)) {
                    ulang = false;
                }
            }
            System.out.print("Selamat tinggal!!!");
        
        }
        catch (Exception ie) {
            System.out.print("Data yang diinput SALAH !!");
        }
    }
}
