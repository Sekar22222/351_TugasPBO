import java.util.Scanner;

class HotelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Kamar.kamarStandar("101", 100000);
        Kamar.kamarSuite("201", 500000);

        System.out.print("Masukkan nama tamu: ");
        String namaTamu = scanner.nextLine();

        System.out.print("Masukkan nomor identitas: ");
        String identitas = scanner.nextLine();

        
        System.out.println("Tipe kamar:");
        System.out.println("1. Standar");
        System.out.println("2. Suite");
        System.out.print("Pilih tipe kamar:");
        int pilihanKamar = scanner.nextInt();
        String tipeKamar = (pilihanKamar == 1) ? "Standar" : "Suite";

        System.out.print("Masukkan tanggal reservasi (tahun-bulan-hari): ");
        String tanggalReservasi = scanner.next();

        System.out.print("Masukkan lama menginap (per-malam): ");
        int lamaMenginap = scanner.nextInt();

     
        Reservasi.reservasi(namaTamu, identitas, tipeKamar, tanggalReservasi, lamaMenginap);
        scanner.close();
    }
}

class Kamar {
    private static Kamar kamarStandar;
    private static Kamar kamarSuite;
    private String nomorKamar;
    private String tipeKamar;
    private double harga;

    public Kamar(String nomorKamar, String tipeKamar, double harga) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.harga = harga;
    }

    public static void kamarStandar(String nomorKamar, double harga) {
        kamarStandar = new Kamar(nomorKamar, "Standar", harga);
    }

    public static void kamarSuite(String nomorKamar, double harga) {
        kamarSuite = new Kamar(nomorKamar, "Suite", harga);
    }

    public String getNomorKamar() { return nomorKamar; }
    public String getTipeKamar() { return tipeKamar; }
    public double getHarga() { return harga; }

    public static Kamar getKamar(String tipeKamar) {
        if (tipeKamar.equals("Standar")) {
            return kamarStandar;
        } else if (tipeKamar.equals("Suite")) {
            return kamarSuite;
        }
        return null;
    }
}

class Tamu {
    private String nama;
    private String identitas;

    public Tamu(String nama, String identitas) {
        this.nama = nama;
        this.identitas = identitas;
    }

    public String getNama() { return nama; }
    public String getIdentitas() { return identitas; }
}

class Reservasi {
    public static void reservasi(String namaTamu, String identitas, String tipeKamar, String tanggalReservasi, int lamaMenginap) {
        Kamar kamar = Kamar.getKamar(tipeKamar);
        if (kamar == null) {
            System.out.println("Tipe kamar tidak tersedia.");
            return;
        }

        Tamu tamu = new Tamu(namaTamu, identitas);
        double totalBiaya = kamar.getHarga() * lamaMenginap;

        System.out.println("Reservasi:");
        System.out.println("Nama Tamu: " + tamu.getNama());
        System.out.println("Tipe Kamar: " + kamar.getTipeKamar());
        System.out.println("Nomor Kamar: " + kamar.getNomorKamar());
        System.out.println("Tanggal Reservasi: " + tanggalReservasi);
        System.out.println("Lama Menginap: " + lamaMenginap + " malam");
        System.out.printf("Total Biaya Reservasi: %.0f\n", totalBiaya); 
        System.out.println();
    }
}
