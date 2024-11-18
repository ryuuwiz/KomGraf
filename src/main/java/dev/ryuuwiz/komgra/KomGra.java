package dev.ryuuwiz.komgra;

import javax.swing.JFrame;

public class KomGra {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setTitle("Aplikasi Komputer Grafik - Ryu Kurnianto Putra");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        LatihanClipping panel = new LatihanClipping();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
