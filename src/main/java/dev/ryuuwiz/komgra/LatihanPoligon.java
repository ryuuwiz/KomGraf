/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.ryuuwiz.komgra;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;

/**
 *
 * @author ryuuwr
 * */
class LatihanPoligon extends JPanel {
    public LatihanPoligon () {
        this.setPreferredSize(new Dimension(500, 500));
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

//        g2.setColor(new Color(120, 67, 21));
//        GeneralPath gp = new GeneralPath();
//        gp.moveTo(160, 120);
//        gp.lineTo(180, 120);
//        gp.quadTo(190, 140, 200, 120);
//        gp.lineTo(260, 120);
//        gp.quadTo(270, 140, 280, 120);
//        gp.lineTo(300, 120);
//        gp.curveTo(295, 100, 300, 80, 260, 80);
//        gp.lineTo(210, 80);
//        gp.lineTo(190, 100);
//        gp.lineTo(160, 100);
//        gp.lineTo(160, 120);
//        g2.fill(gp);
       
       GradientPaint CoklatKuning = new GradientPaint(5, 10, new Color(120, 67, 21),
       10, 5, Color.YELLOW, true);
       g2.setPaint(CoklatKuning);
       
       g2.translate(300, -50);
       g2.rotate(-90, 100, 200);

       Polygon panah = new Polygon();
       panah.addPoint(50, 100);
       panah.addPoint(100, 100);
       panah.addPoint(100, 75);
       panah.addPoint(150, 125);
       panah.addPoint(100, 175);
       panah.addPoint(100, 150);
       panah.addPoint(50, 150);
       g2.fill(panah);
    }
}
