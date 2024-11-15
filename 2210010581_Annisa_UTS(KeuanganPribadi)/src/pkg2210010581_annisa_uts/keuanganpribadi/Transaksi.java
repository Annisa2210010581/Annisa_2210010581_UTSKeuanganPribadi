/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2210010581_annisa_uts.keuanganpribadi;

/**
 *
 * @author Annisa
 * 2210010581
 */

public class Transaksi {
    private int id; // ID transaksi di database
    
    private String tanggal;
    private String keterangan;
    private double jumlah;
    private String jenis; // "Pemasukan" atau "Pengeluaran"

    /**
     * Constructor utama untuk transaksi baru 
     */
    public Transaksi(String tanggal, String keterangan, double jumlah, String jenis) {
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.jumlah = jumlah;
        this.jenis = jenis;
    }

    public Transaksi(int id, String tanggal, String keterangan, double jumlah, String jenis) {
        this(tanggal, keterangan, jumlah, jenis);
        this.id = id;
    }

    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    
    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
    
    public double getJumlah() { return jumlah; }
    public void setJumlah(double jumlah) { this.jumlah = jumlah; }
    
    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    //Mengecek apakah transaksi adalah masukkan
    public boolean isPemasukan() {
        return "Pemasukan".equals(jenis);
    }

    //Mengecek apakah transaksi adalah pengeluaran
    public boolean isPengeluaran() {
        return "Pengeluaran".equals(jenis);
    }

    public String getFormattedJumlah() {
        return String.format("%,.2f", jumlah);
    }

    // Override toString untuk tampilan di JList
    @Override
    public String toString() {
        String simbol = isPemasukan() ? "+" : "-";
        return String.format("%s - %s - Rp %s%s (%s)", 
            tanggal, 
            keterangan, 
            simbol,
            getFormattedJumlah(),
            jenis);
    }

    // Override equals untuk membandingkan transaksi
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Transaksi other = (Transaksi) obj;
        return id == other.id &&
               Double.compare(other.jumlah, jumlah) == 0 &&
               tanggal.equals(other.tanggal) &&
               keterangan.equals(other.keterangan) &&
               jenis.equals(other.jenis);
    }

    // Override hashCode untuk mendukung equals
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + tanggal.hashCode();
        result = 31 * result + keterangan.hashCode();
        result = 31 * result + Double.hashCode(jumlah);
        result = 31 * result + jenis.hashCode();
        return result;
    }
}
