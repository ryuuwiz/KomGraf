package dev.ryuuwiz.komgra;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author ryuuw
 */
public class Logo extends JPanel {
    public Logo () {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.translate(300, -50);
        g2.rotate(-90, 100, 200);
        
        GeneralPath pohon = new GeneralPath();
        pohon.moveTo(150, 50);
        
        pohon.lineTo(180, 90);
        pohon.lineTo(170, 90);
        pohon.lineTo(200, 130);
        pohon.lineTo(190, 130);
        pohon.lineTo(220, 170);
        pohon.lineTo(165, 170);
        
        pohon.lineTo(165, 220);
        
        pohon.lineTo(135, 220);
        pohon.lineTo(135, 170);
        
        pohon.lineTo(80, 170);
        pohon.lineTo(110, 130);
        pohon.lineTo(100, 130);
        pohon.lineTo(130, 90);
        pohon.lineTo(120, 90);
        
        pohon.closePath();
        
        GradientPaint gpohon = new GradientPaint(
            150, 50,  new Color(0, 100, 0),   
            150, 220, new Color(62, 139, 34)
        );
        
        GradientPaint gbatang = new GradientPaint(
            135, 170, new Color(139, 69, 19),  
            165, 220, new Color(101, 67, 33)   
        );
        
        Polygon batang = new Polygon(
            new int[] {135, 165, 165, 135},
            new int[] {170, 170, 220, 220},
            4
        );
        
        g2.setPaint(gpohon);
        g2.fill(pohon);
        
        g2.setPaint(gbatang);
        g2.fill(batang);
        
        g2.setColor(new Color(0, 51, 0));
        g2.setStroke(new BasicStroke(1.5f));
        g2.draw(pohon);       
    }
}
