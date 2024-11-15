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
import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    private static final String DB_NAME = "keuangan.db";
   
    //Koneksi Database
    public Database() {
        try {
            // Connect to SQLite database
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS transaksi (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                tanggal TEXT NOT NULL,
                keterangan TEXT NOT NULL,
                jumlah REAL NOT NULL,
                jenis TEXT NOT NULL
            )
        """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void simpanTransaksi(Transaksi t) {
        String sql = "INSERT INTO transaksi (tanggal, keterangan, jumlah, jenis) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, t.getTanggal());
            pstmt.setString(2, t.getKeterangan());
            pstmt.setDouble(3, t.getJumlah());
            pstmt.setString(4, t.getJenis());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Transaksi> getAllTransaksi() {
        ArrayList<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi ORDER BY tanggal DESC";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Transaksi t = new Transaksi(
                    rs.getString("tanggal"),
                    rs.getString("keterangan"),
                    rs.getDouble("jumlah"),
                    rs.getString("jenis")
                );
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
     public void hapusSemuaTransaksi() {
        String query = "DELETE FROM transaksi";  
        try {
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);  // Eksekusi query untuk menghapus semua data transaksi
            System.out.println(rowsAffected + " baris data telah dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menghapus data transaksi di database!");
        }
     }
}