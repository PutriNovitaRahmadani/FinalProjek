import java.util.*;

public class PenjualanTiketKonser {
    static class Konser {
        String namaKonser;
        String tanggal;
        String waktu;
        String tempat;
        double hargatiketVip;
        double hargatiketReguler;

        public Konser(String namaKonser, String tanggal, String waktu, String tempat, double hargatiketVip, double hargatiketReguler) {
            this.namaKonser = namaKonser;
            this.tanggal = tanggal;
            this.waktu = waktu;
            this.tempat = tempat;
            this.hargatiketVip = hargatiketVip;
            this.hargatiketReguler = hargatiketReguler;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Konser> daftarKonser = new ArrayList<>();
        daftarKonser.add(new Konser("Senandung Romansa", "30 September 2023", "19:00", "The Kasablanka Hall", 1000000, 400000));
        daftarKonser.add(new Konser("Niki World Tour", "26 September 2023", "20:00", "JIExpo Hall D2", 2000000, 500000));
        daftarKonser.add(new Konser("ASS Vol 2", "26-27 Agustus 2023", "15:00", "West parking JIExpo Kemayoran", 2500000, 1500000));

        Queue<String> antrian = new LinkedList<>();
        Stack<String> stackPembayaran = new Stack<>();

        int pilihan;
        do {
            System.out.println("=== Penjualan Tiket Konser ===");
            System.out.println("Menu:");
            System.out.println("1. Tampilkan Daftar Konser");
            System.out.println("2. Cari Konser");
            System.out.println("3. Pilih Konser");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tampilkanDaftarKonser(daftarKonser);
                case 2 -> cariKonser(daftarKonser, scanner);
                case 3 -> pilihKonser(daftarKonser, scanner, antrian, stackPembayaran);
                case 4 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            System.out.println();
        } while (pilihan != 4);
    }

    static void tampilkanDaftarKonser(ArrayList<Konser> daftarKonser) {
        System.out.println("Daftar Konser:");
        for (Konser konser : daftarKonser) {
            System.out.println("Nama Konser: " + konser.namaKonser);
            System.out.println("Tanggal: " + konser.tanggal);
            System.out.println("Waktu: " + konser.waktu);
            System.out.println("Tempat: " + konser.tempat);
            System.out.println("Harga Tiket VIP: " + konser.hargatiketVip);
            System.out.println("Harga Tiket Reguler: " + konser.hargatiketReguler);
            System.out.println();
        }
    }

    static void cariKonser(ArrayList<Konser> daftarKonser, Scanner scanner) {
        System.out.print("Masukkan nama konser yang ingin dicari: ");
        String namaKonser = scanner.nextLine();
        boolean konserDitemukan = false;
        for (Konser konser : daftarKonser) {
            if (konser.namaKonser.equalsIgnoreCase(namaKonser)) {
                konserDitemukan = true;
                System.out.println("Nama Konser: " + konser.namaKonser);
                System.out.println("Tanggal: " + konser.tanggal);
                System.out.println("Waktu: " + konser.waktu);
                System.out.println("Tempat: " + konser.tempat);
                System.out.println("Harga Tiket VIP: " + konser.hargatiketVip);
                System.out.println("Harga Tiket Reguler: " + konser.hargatiketReguler);
                System.out.println();
                break;
            }
        }

        if (!konserDitemukan) {
            System.out.println("Konser tidak ditemukan.");
        }
    }

    static void pilihKonser(ArrayList<Konser> daftarKonser, Scanner scanner, Queue<String> antrian, Stack<String> stackPembayaran) {
        System.out.print("Masukkan nama pembeli tiket: ");
        String namaPembeli = scanner.nextLine();

        System.out.println("Daftar Konser:");
        for (int i = 0; i < daftarKonser.size(); i++) {
            System.out.println((i + 1) + ". " + daftarKonser.get(i).namaKonser);
        }

        System.out.print("Pilih konser (masukkan nomor): ");
        int nomorKonser = scanner.nextInt();
        scanner.nextLine();
        if (nomorKonser >= 1 && nomorKonser <= daftarKonser.size()) {
            Konser konserTerpilih = daftarKonser.get(nomorKonser - 1);

            System.out.println("Pilihan Konser: " + konserTerpilih.namaKonser);
            System.out.println("Pembeli: " + namaPembeli);

            System.out.println("Jenis Tiket:");
            System.out.println("1. VIP");
            System.out.println("2. Reguler");
            System.out.print("Pilih jenis tiket (masukkan nomor): ");
            int nomorJenisTiket = scanner.nextInt();
            scanner.nextLine();

            double hargaTiket;
            String jenisTiket;

            if (nomorJenisTiket == 1) {
                hargaTiket = konserTerpilih.hargatiketVip;
                jenisTiket = "VIP";
            } else if (nomorJenisTiket == 2) {
                hargaTiket = konserTerpilih.hargatiketReguler;
                jenisTiket = "Reguler";
            } else {
                System.out.println("Pilihan tidak valid. Pembelian dibatalkan.");
                return;
            }

            System.out.println("Harga Tiket " + jenisTiket + ": " + hargaTiket);

            System.out.println("Metode Pembayaran:");
            System.out.println("1. Transfer Bank");
            System.out.println("2. Tunai");
            System.out.print("Pilih jenis pembayaran (masukkan nomor): ");
            int nomorJenisPembayaran = scanner.nextInt();
            scanner.nextLine();

            String jenisPembayaran;

            if (nomorJenisPembayaran == 1) {
                jenisPembayaran = "Transfer Bank";
            } else if (nomorJenisPembayaran == 2) {
                jenisPembayaran = "Tunai";
            } else {
                System.out.println("Pilihan tidak valid. Pembelian dibatalkan.");
                return;
            }

            System.out.println("Jadwal Pembelian:");
            System.out.println("Antrian: " + (antrian.size() + 1));
            System.out.println("Konser: " + konserTerpilih.namaKonser);
            System.out.println("Jenis Tiket: " + jenisTiket);
            System.out.println("Jenis Pembayaran: " + jenisPembayaran);

            antrian.offer(namaPembeli);
            stackPembayaran.push(jenisPembayaran);
        } else {
            System.out.println("Konser tidak ditemukan.");
        }
    }
}