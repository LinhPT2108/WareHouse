
package ComponentOther;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;

/**
 *
 * @author: Phan Tuấn Linh (LinhPTPC04737)
 */
public class LoadingLogin extends javax.swing.JPanel {

    public LoadingLogin() {
        initComponents();
        this.setOpaque(false);
        this.setFocusCycleRoot(true);
        this.setVisible(false);
        this.setFocusable(true);
        addMouseListener(new MouseAdapter() {
        });
    }

    /**
     * Hàm paintComponent hiệu chỉnh lại giao diện Swing 
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(255, 255, 255));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponents(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loadingForgetPassword.gif"))); // NOI18N
        add(jLabel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
