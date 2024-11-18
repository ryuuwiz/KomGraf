/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.ryuuwiz.komgra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ryuuw
 */
public class LatihanClipping extends JPanel {
    public LatihanClipping() {
        this.setPreferredSize(new Dimension(750, 500));
        this.setBackground(Color.WHITE);
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\ryuuw\\Pictures\\" + "69561.jpg"));
            
            // Clip
            Shape lingkaran = new Ellipse2D.Double(30, 30, 250, 250);
            g2.clip(lingkaran);
            
            Font fontArial = new Font("Arial", Font.BOLD, 16);
            g2.setFont(fontArial);
            
            g2.drawImage(img, 10, 10, 400, 300, null);
            g2.setClip(null);
            g2.drawString("Clipping: Wave", 90, 350);
            
            // Image asli
            g2.drawImage(img, 300, 10, 400, 300, null);
            g2.drawString("Gambar asli: Wave", 440, 350);
        } catch (IOException ex) {
            Logger.getLogger(LatihanClipping.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
