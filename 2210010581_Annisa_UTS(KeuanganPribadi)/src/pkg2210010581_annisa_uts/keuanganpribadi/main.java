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
import javax.swing.UIManager;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Jalankan aplikasi
        SwingUtilities.invokeLater(() -> {
            new FrameHalamanAwal().setVisible(true);
        });
    }
}