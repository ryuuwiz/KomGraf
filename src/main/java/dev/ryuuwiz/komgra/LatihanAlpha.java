package dev.ryuuwiz.komgra; // package untuk class ini

import java.awt.AlphaComposite; // import class untuk transparansi
import java.awt.Color; // import class untuk warna
import java.awt.Dimension; // import class untuk ukuran komponen
import java.awt.Graphics; // import class untuk menggambar
import java.awt.Graphics2D; // import class untuk menggambar 2D
import java.awt.image.BufferedImage; // import class untuk manipulasi data berupa gambar
import javax.swing.JPanel; // import class untuk panel UI

/**
 *
 * @nama RyuKurniantoPutra
 * @nim 211011450106
 */
public class LatihanAlpha extends JPanel { // membuat class LatihanAlpha yang mewarisi atribut dan method dari JPanel
    public LatihanAlpha() { // membuat constructor class yang dijalankan ketika class dijalankan
        this.setPreferredSize(new Dimension(700, 500)); // mengatur ukuran panel
        this.setBackground(Color.WHITE); // mengatur background panel menjadi putih
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) { // implementasi method dari class JPanel
        super.paintComponent(g); // memanggil method dari class JPanel untuk membersihkan area gambar
        Graphics2D g2 = (Graphics2D) g; // konversi Graphics ke Graphics2D untuk menggambar 2D
        
        g2.setColor(Color.blue); // mengatur warna menjadi biru untuk string destination
        g2.drawString("DESTINATION (Reactangle)", 40, 20); // menggambar teks destination
        g2.setColor(Color.red); // mengatur warna menjadi merah untuk string source
        g2.drawString("SOURCE (Circle)", 300, 20); // menggambar teks source
        g2.setColor(Color.black); // mengatur warna menjadi hitam 
        
        drawComposite(g2, 0.8f); // memanggil method untuk menggambar (parameter pertama) dengan alpha composite (parameter kedua)
    }
    
    /**
     *
     * @param g2
     * @param alpha
     */
    public void drawComposite(Graphics2D g2, float alpha) { // method untuk menggambar dengan alpha composite
        // Jenis-jenis alpha composite
        int[] alphaComp = {
            AlphaComposite.SRC, AlphaComposite.DST_IN,
            AlphaComposite.DST_OUT, AlphaComposite.DST_OVER,
            AlphaComposite.SRC_IN, AlphaComposite.SRC_OVER,
            AlphaComposite.SRC_OUT, AlphaComposite.CLEAR
        };
        
        // caption dari jenis alpha composite        
        String[] caption = {
            "SRC", "DST_IN", 
            "DST_OUT", "DST_OVER", 
            "SRC_IN", "SRC_OVER", 
            "SRC_OUT", "CLEAR"
        };
        
        // Ambil objek alpha composite
        int x, y; // variabel untuk posisi x dan y dalam bentuk Integer
        x = y = 40; // inisiasi x dan y menjadi 40
        
        AlphaComposite ac; // variabel untuk alpha composite
        AlphaComposite tac = 
                AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f); // membuat alpha composite dengan tipe SRC dan alpha 1.0
        
        for (int j = 0; j < alphaComp.length; j++) { // Loop untuk setiap jenis alpha composite
            ac = AlphaComposite.getInstance(alphaComp[j], alpha); // mendapatkan alpha dengan jenis dan alpha yang ditentukan
            
            // begin: composite demo
            BufferedImage buffImg = 
                    new BufferedImage(75, 80, BufferedImage.TYPE_INT_ARGB); // membuat buffered image untuk menggambar
            Graphics2D gbi = buffImg.createGraphics(); // mendapatkan objek graphics2D untuk buffered image
            
            gbi.setColor(Color.blue); // mengatur warna menjadi biru untuk objek kiri
            gbi.fillRoundRect(0, 0, 50, 50, 25, 25); // membuat objek berupa persegi dengan sudut bulat
            
            gbi.setColor(Color.red); // mengatur warna menjadi merah untuk objek kanan
            gbi.setComposite(ac); // mengatur composite untuk menggambar objek
            gbi.fillOval(25, 0, 70, 50); // membuat objek berupa oval dengan composite
            // end: composite demo
            
            // Display Image
            g2.drawImage(buffImg, null, x, y); // menggambar buffered image pada posisi x dan y
            g2.drawString(caption[j], x, y+70); // menggambar caption dibawah dua objek
            
            x+=80; // geser posisi x untuk gambar selanjutnya
        }
    }
}
