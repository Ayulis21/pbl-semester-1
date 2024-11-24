import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
public class abc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        int jmlh,totalAkhir,ttlHrg,total=0,beli;//jumlah pesanan,total keseluruhan,kode produk,total harga keseluruhan.
        String nmAwal,nmAkhir,ttl,username,password,ktSnd,alamat,jwbn,jawaban,registrasi,gender,nmPnjng;//nama akhir awal, nama pelanggan,password, alamat, (regis)
        
        String Produk = "\t\tSELAMAT DATANG!\n"
                + "-------------------------------------------------"
                + "\nSilahkan lihat produk yang ada di bawah ini :"
                + "\n1 Animate Body Scrub\tRp. 10.000"
                + "\n2 Animate Cream\t\tRp. 11.000"
                + "\n3 Animate Face Wash\tRp. 12.000"
                + "\n4 Animate Essence\tRp. 13.000"
                + "\n5 Animate Toner\t\tRp. 14.000"
                + "\n-------------------------------------------------";

                System.out.println(Produk);

                System.out.println("\n =============================================="
                + "\n            MELIHAT PESANAN PEMBELI            "
                + "\n ==============================================");

                System.out.println("Apakah anda ingin membeli produk? \"Iya\" atau \"Tidak\"");
                jawaban = input.nextLine();

                if (jawaban.equalsIgnoreCase("Iya")) {
                    System.out.println("========== SILAHKAN REGISTRASI DAHULU ==========");
                    System.out.println("Apakah sudah memiliki akun? \"Belum\" atau \"Sudah\"");
                    jawaban = input.nextLine();
                    if (jawaban.equalsIgnoreCase("Belum")) {
                        System.out.println("========== Data Diri User ==========");
                        System.out.print("Nama Depan    : ");
                        nmAwal = input.nextLine();
                        System.out.print("Nama Belakang : ");
                        nmAkhir = input.nextLine();
                        nmPnjng = nmAwal + nmAkhir;
                        System.out.println("\"Laki-laki\" atau \"Perempuan\"");
                        System.out.print("Gender        : ");
                        gender = input.nextLine();
                        System.out.print("TTL           : ");
                        ttl = input.nextLine();
                        System.out.print("Alamat        : ");
                        alamat = input.nextLine();
                        System.out.print("Username      : ");
                        username = input.nextLine();
                        System.out.print("Password      : ");
                        ktSnd = input.nextLine();
                        System.out.print("username : " + username);
                        System.out.println("Konfirmasi Password : " + ktSnd);
                        System.out.println(
                            "\n ---------------------------------"
                            +"\n             SELESAI             "
                            +"\n --------------------------------");
                            System.out.println("KEMBALI KE REGISTRASI");
                            System.out.println("SILAHKAN UNTUK LOGIN");
                        
                        
                    } else { 
                        System.out.println("========== SILAHKAN LOGIN DAHULU ==========");
                        do {
                            System.out.println("Masukkan username : ");
                            username = input.nextLine();
                            System.out.println("Masukkan password : ");
                            ktSnd = input.nextLine();
                        } while (!(username.equals("ayulis") && ktSnd.equals("12345")));
                        System.out.println("===== LOGIN BERHASIL =====");

                        //perulangan do while untuk memasukkan jumlah beli sesuai stok yang tersedia 
                        do {totalAkhir = total;
                            System.out.println("Masukkan kode produk : ");
                            beli = input.nextInt();
                            
                            while (beli>5 || beli<1) {
                                System.out.println("Mohon masukkan angka sesuai dengan kode produk");
                                System.out.println("Masukkan kode produk : ");
                                beli = input.nextInt();
                                
                                
                            }
                                System.out.println("Berapa jumlah yang ingin di pesan?");
                                jmlh = input.nextInt();

                            
                                String[] produk = {"Animate Body Scrub", "Animate Cream", "Animate Face Wash", "Animate Essence", "Animate Toner"};
                                int[] harga = {20000,21000,22000,23000,24000};
                                       
                                switch (beli) {
                                    case 1:
                                        System.out.println("Anda memesan "+produk[0]+" sebanyak "+jmlh);
                                        System.out.println("Harga satuan = Rp. "+harga[0]+",-");
                                        total=totalAkhir+(harga[0]*jmlh);
                                        System.out.println("Total = Rp. "+(int)total+",-");
                                        break;
                                    case 2:
                                        System.out.println("Anda memesan "+produk[1]+" sebanyak "+jmlh);
                                        System.out.println("Harga satuan = Rp. "+harga[1]+",-");
                                        total=totalAkhir+(harga[1]*jmlh);
                                        System.out.println("Total = Rp. "+(int)total+",-");
                                        break;
                                    case 3:
                                        System.out.println("Anda memesan "+produk[2]+" sebanyak "+jmlh);
                                        System.out.println("Harga satuan = Rp. "+harga[2]+",-");
                                        total=totalAkhir+(harga[2]*jmlh);
                                        
                                        System.out.println("Total = Rp. "+(int)total+",-");
                                        break;
                                    case 4:
                                        System.out.println("Anda memesan "+produk[3]+" sebanyak "+jmlh);
                                        System.out.println("Harga satuan = Rp. "+harga[3]+",-");
                                        total=totalAkhir+(harga[3]*jmlh);
                                        System.out.println("Total = Rp. "+(int)total+",-");
                                        break;
                                    case 5:
                                        System.out.println("Anda memesan "+produk[4]+" sebanyak "+jmlh);
                                        System.out.println("Harga satuan = Rp."+harga[4]+",-");
                                        total=totalAkhir+(harga[4]*jmlh);
                                        System.out.println("Total = Rp."+(int)total+",-");
                                        break;
                                }
                                jwbn= "Tidak";
                                System.out.println("\n Apakah anda ingin menambahkan produk lagi? \"Tidak\" atau \"Iya\"");
                                jwbn =input.nextLine();
                                System.out.println("setelah input jawaban");
                        }while (jwbn.equalsIgnoreCase("Iya"));                     
                            //System.out.println("\n Apakah anda ingin menambahkan produk lagi? \"Tidak\" atau \"Iya\"");
                            //jwbn =input.nextLine();
                            if(jwbn.equalsIgnoreCase("Tidak")){
                                System.out.println("\n =======================================");
                                ttlHrg = total + total;
                                System.out.println("Total pembayaran anda menjadi = Rp. "+(int)ttlHrg+",-");
                                System.out.println("=======================================");
                            }else{
                                System.out.println("\n=======================================");
                                System.out.println("Total pembayaran anda menjadi = Rp. "+(int)total+",-");
                                System.out.println("=======================================");
                            }
                        
                            
                    }
                                  
                } else {
                    System.out.println("SELAMAT BERKUNJUNG DI BEAUTY SHOP");
                    System.out.println(Produk);
                }
    }
}
