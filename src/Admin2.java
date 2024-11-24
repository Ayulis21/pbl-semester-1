import java.util.ArrayList;
import java.util.Scanner;

public class Admin2 {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String username, password;

    System.out.println("========== SILAHKAN LOGIN DAHULU ==========");
    for (int i = 3; i >= 1; i--) { // Batasi login hingga 3 kali
      System.out.print("Masukkan username : ");
      username = scanner.nextLine();
      System.out.print("Masukkan password : ");
      password = scanner.nextLine();

      if (username.equals("admin") && password.equals("12345")) {
        System.out.println("Selamat datang " + username + "!");
        System.out.println();
        break; // Keluar dari loop jika login berhasil
      } else if (i == 1) {
        System.out.println("Maaf, kesempatan login Anda telah habis. Silakan coba lagi nanti.");
        System.exit(0);
      } else {
        System.out.println("Username atau password salah, sisa kesempatan Anda: " + (i - 1));
      }
    }

    dashboard();
  }

  static void dashboard() {
    ArrayList<String> produkList = new ArrayList<>(); // Untuk menyimpan produk
    Scanner input = new Scanner(System.in);
    int pilihan;

    do {
      System.out.println("====== MENU DASHBOARD ======");
      System.out.println("1. Tambahkan Produk");
      System.out.println("2. Lihat Produk");
      System.out.println("3. Lihat Pesanan");
      System.out.println("4. Keluar");
      System.out.println("============================");
      System.out.print("Pilihan: ");
      while (!input.hasNextInt()) { // Validasi input harus angka
        System.out.print("Harap masukkan angka yang valid: ");
        input.next();
      }
      pilihan = input.nextInt();
      input.nextLine(); // Bersihkan buffer Scanner

      switch (pilihan) {
        case 1:
          System.out.print("Nama Produk: ");
          String namaProduk = input.nextLine();
          System.out.print("Jumlah Produk: ");
          int jumlahProduk = input.nextInt();
          System.out.print("Harga Produk (Rp): ");
          int hargaProduk = input.nextInt();
          input.nextLine(); // Bersihkan buffer
          produkList.add(namaProduk + " | " + jumlahProduk + " | Rp. " + hargaProduk);
          System.out.println("Produk berhasil ditambahkan!");
          break;

        case 2:
          if (produkList.isEmpty()) {
            System.out.println("Belum ada produk yang ditambahkan.");
          } else {
            System.out.println("====== DAFTAR PRODUK ======");
            for (int i = 0; i < produkList.size(); i++) {
              System.out.println((i + 1) + ". " + produkList.get(i));
            }
          }
          break;

        case 3:
          System.out.println("====== DAFTAR PESANAN ======");
          System.out.println("Nama    | Produk           | Jumlah Produk | Harga");
          System.out.println("===============================================");
          System.out.println("Ayu     | Animate Serum    | 4             | 100.000");
          System.out.println("Alif    | Animate Cream    | 2             |  50.000");
          System.out.println("Ajeng   | Animate Face Wash| 3             |  63.000");
          System.out.println("Afifah  | Animate Essence  | 2             |  74.000");
          System.out.println("Ardian  | Animate Toner    | 1             |  24.000");
          break;

        case 4:
          System.out.println("Terima kasih telah menggunakan aplikasi.");
          break;

        default:
          System.out.println("Pilihan tidak valid. Harap pilih antara 1-4.");
      }
      System.out.println();
    } while (pilihan != 4);

    System.exit(0);
  }
}
