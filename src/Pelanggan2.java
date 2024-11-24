import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class User2 {
    static String jawaban, username, password;
    static List<String> produkList = new ArrayList<>();
    static List<Integer> hargaList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Membaca data menu dari file
        String namaFile = "C:\\Users\\User\\Project Based Learning\\dashbor\\src\\menu.txt";
        try {
            bacaMenuDariFile(namaFile);
        } catch (FileNotFoundException e) {
            System.out.println("File menu.txt tidak ditemukan!");
            return; // Hentikan program jika file tidak ditemukan
        }

        // Memulai aplikasi
        System.out.println("========== SELAMAT DATANG ==========");
        System.out.println("Apakah Anda ingin memulai pemesanan? Ketik 'I' untuk iya, atau lainnya untuk keluar.");
        jawaban = input.nextLine();
        if (jawaban.equalsIgnoreCase("I")) {
            pemesanan();
        } else {
            System.out.println("Terima kasih, sampai jumpa!");
        }
    }

    static void bacaMenuDariFile(String namaFile) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new FileReader(namaFile));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] kolom = line.split(";");
            if (kolom.length == 2) {
                produkList.add(kolom[0]);
                try {
                    hargaList.add(Integer.parseInt(kolom[1]));
                } catch (NumberFormatException e) {
                    System.out.println("Harga tidak valid di baris: " + line);
                }
            } else {
                System.out.println("Format tidak valid di baris: " + line);
            }
        }
        fileScanner.close();
    }

    static void pemesanan() {
        System.out.println("Apakah sudah memiliki akun? \"B\" atau \"S\"");
        jawaban = input.nextLine();
        if (jawaban.equalsIgnoreCase("B")) {
            Registrasi();
        } else {
            Login();
        }
    }

    static void Registrasi() {
        String namaDepan, namaBelakang, namaPanjang, gender, ttl, alamat;
        System.out.println("========== MASUKKAN DATA DIRI ==========");
        System.out.print("Nama Depan            : ");
        namaDepan = input.nextLine();
        System.out.print("Nama Belakang         : ");
        namaBelakang = input.nextLine();
        namaPanjang = namaDepan + " " + namaBelakang;
        System.out.println("\"Laki-laki\" atau \"Perempuan\"");
        System.out.print("Gender                : ");
        gender = input.nextLine();
        System.out.print("Tempat/Tanggal Lahir  : ");
        ttl = input.nextLine();
        System.out.print("Alamat                : ");
        alamat = input.nextLine();
        System.out.print("Username              : ");
        username = input.nextLine(); // Simpan ke variabel global
        System.out.print("Password              : ");
        password = input.nextLine(); // Simpan ke variabel global
        System.out.println("Username              : " + username);
        System.out.println("Konfirmasi Password   : " + password);
        System.out.println(
                "\n ---------------------------------"
                        + "\n             SELESAI             "
                        + "\n --------------------------------");

        Login(); // Panggil metode Login setelah registrasi
    }

    static void Login() {
        System.out.println("========== SILAHKAN LOGIN DAHULU ==========");
        for (int i = 4; i >= 1; i--) { // perulangan for untuk login dengan batas 3x
            System.out.print("Masukkan username : ");
            String inputUsername = input.nextLine(); // Gunakan variabel lokal
            System.out.print("Masukkan password : ");
            String inputPassword = input.nextLine(); // Gunakan variabel lokal
            if (inputUsername.equals(username) && inputPassword.equals(password)) { // Validasi dengan data registrasi
                System.out.println("\t\tSELAMAT DATANG," + inputUsername + "!");
                System.out.println("-------------------------------------------------");
                System.out.println("Silahkan lihat produk yang ada di bawah ini :");
                break; // Berhenti jika login berhasil
            } else if (i == 1) { // Jika kesempatan habis
                System.out.println("Maaf kesempatan anda telah habis, tunggu 5 menit untuk LOGIN kembali");
                System.exit(0);
            } else { // Jika login gagal
                System.out.println("Username dan password salah, kesempatan anda tinggal " + (i - 1) + " x lagi");
            }
        }
        MelihatProduk(); // Panggil metode berikutnya
    }

    static void MelihatProduk() {
        for (int i = 0; i < produkList.size(); i++) {
            System.out.printf("%d %s\tRp. %,d\n", i + 1, produkList.get(i), hargaList.get(i));
        }

        System.out.println("-------------------------------------------------");
        MelakukanPemesanan();
    }

    // Penanganan input lebih baik dan validasi pengguna
    static void MelakukanPemesanan() {
        int total = 0;
        String jwbn = ""; // Inisialisasi dengan string kosong agar bisa digunakan dalam do-while
        List<String> daftarPesanan = new ArrayList<>(); // Daftar untuk menyimpan produk yang dipesan
        List<String> jumlahPesanan = new ArrayList<>(); // Daftar untuk menyimpan jumlah yang dipesan
        List<Integer> hargaPesanan = new ArrayList<>(); // Daftar untuk menyimpan total harga per produk

        do {
            // Tampilkan daftar produk
            System.out.println("\nSilakan masukkan kode produk yang ingin dipesan:");

            // Ambil input kode produk
            System.out.print("Masukkan kode produk: ");
            int beli;
            try {
                beli = input.nextInt() - 1; // Kurangi 1 karena indeks array mulai dari 0
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.nextLine(); // Bersihkan buffer
                continue;
            }

            // Validasi kode produk
            if (beli < 0 || beli >= produkList.size()) {
                System.out.println("Kode produk tidak valid! Silakan coba lagi.");
                input.nextLine(); // Bersihkan buffer
                continue;
            }

            // Ambil input jumlah produk
            System.out.print("Berapa jumlah yang ingin dipesan? ");
            int jumlah;
            try {
                jumlah = input.nextInt();
                if (jumlah < 1) {
                    System.out.println("Jumlah produk harus lebih dari 0.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.nextLine(); // Bersihkan buffer
                continue;
            }
            input.nextLine(); // Bersihkan buffer setelah nextInt()

            // Hitung total harga untuk produk yang dipesan
            int harga = hargaList.get(beli) * jumlah;
            total += harga;

            // Simpan produk yang dipesan
            daftarPesanan.add(produkList.get(beli));
            jumlahPesanan.add(String.valueOf(jumlah));
            hargaPesanan.add(harga);

            // Tampilkan detail pesanan
            System.out.printf("Anda memesan %s sebanyak %d. Total harga untuk produk ini: Rp. %,d\n",
                    produkList.get(beli), jumlah, harga);

            // Tanya apakah ingin menambahkan produk lagi
            do {
                System.out.println("Apakah Anda ingin menambahkan produk lagi? (Iya/Tidak)");
                jwbn = input.nextLine(); // Pastikan jwbn diambil dari input pengguna
                if (!jwbn.equalsIgnoreCase("Iya") && !jwbn.equalsIgnoreCase("Tidak")) {
                    System.out.println("Jawaban tidak valid. Silakan jawab dengan 'Iya' atau 'Tidak'.");
                }
            } while (!jwbn.equalsIgnoreCase("Iya") && !jwbn.equalsIgnoreCase("Tidak"));

        } while (jwbn.equalsIgnoreCase("Iya"));

        // Tampilkan produk yang sudah dipesan
        System.out.println("\n=======================================");
        System.out.println("Produk yang telah Anda pesan:");
        for (int i = 0; i < daftarPesanan.size(); i++) {
            System.out.printf("%s sebanyak %s. Total harga: Rp. %,d\n", daftarPesanan.get(i), jumlahPesanan.get(i),
                    hargaPesanan.get(i));
        }

        // Tampilkan total pembayaran
        System.out.println("\n=======================================");
        System.out.printf("Total pembayaran Anda: Rp. %,d\n", total);
        System.out.println("=======================================");
    }

}
