public class Reservasi {
    public static void reservasi(String namaTamu, String identitas, String nomorKamar, String tanggalReservasi, int lamaMenginap) {
        Kamar kamar = new Kamar(nomorKamar, "", 0); 
        Tamu tamu = new Tamu(namaTamu, identitas);

        double harga = 0;
        String tipeKamar = "";

        if (nomorKamar.equals("101")) {
            harga = 500000;
            tipeKamar = "Standar";
        } else if (nomorKamar.equals("201")) {
            harga = 1000000;
            tipeKamar = "Suite";
        }

        kamar = new Kamar(nomorKamar, tipeKamar, harga);

        double totalBiaya = kamar.getHarga() * lamaMenginap;

        
        System.out.println("Reservasi:");
        System.out.println("Nama Tamu: " + tamu.getNama());
        System.out.println("Nomor Kamar: " + kamar.getNomorKamar());
        System.out.println("Tipe Kamar: " + kamar.getTipeKamar());
        System.out.println("Tanggal Reservasi: " + tanggalReservasi);
        System.out.println("Lama Menginap: " + lamaMenginap + " malam");
        System.out.println("Total Biaya Reservasi: " + totalBiaya);
        System.out.println();
    }
}
