public class Kamar {
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
}
