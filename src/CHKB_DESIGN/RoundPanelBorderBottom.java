package CHKB_DESIGN;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
//import javaswingdev.system.SystemColor;
import javax.swing.JPanel;

public class RoundPanelBorderBottom extends JPanel {

    private Color MauBatDau = new Color(0, 227, 255);
    private Color MauKetThuc = new Color(0, 39, 255);

    public Color getMauBatDau() {
        return MauBatDau;
    }

    public void setMauBatDau(Color MauBatDau) {
        this.MauBatDau = MauBatDau;
    }

    public Color getMauKetThuc() {
        return MauKetThuc;
    }

    public void setMauKetThuc(Color MauKetThuc) {
        this.MauKetThuc = MauKetThuc;
    }
  
    
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    private int round;

    public RoundPanelBorderBottom() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), round, round));
        g2.setColor(getBackground());
        g2.fill(area);
        area.subtract(new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight() - 3)));
        g2.setPaint(new GradientPaint(0, 0, MauBatDau, getWidth(), 0, MauKetThuc));//SystemColor.MAIN_COLOR_1
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }
}
