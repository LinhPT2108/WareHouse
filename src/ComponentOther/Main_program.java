package ComponentOther;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author LinhptPC04737
 */
@SuppressWarnings("serial")
public class Main_program extends javax.swing.JPanel {

    private Animator animator;
    private Home home;
    private MenuProgram menu;
    private HeaderComponent header;
    private MigLayout layout;

    public Main_program(ActionListener acResize, ActionListener acCancel, ActionListener acMiniSize,
            MouseListener mlLogout, MouseListener mlGuide, MouseListener mlStatistical,
            MouseListener mlChangePassword, MouseListener mlEmployee, MouseListener mlSupplier,
            MouseListener mlImportBill, MouseListener mlProduct, MouseListener mlProductType,
            MouseListener mlExportBill, MouseListener mlHome, MouseListener mlContact) {
        initComponents();
        this.setSize(1510, 720);
        this.setVisible(false);
        init();
        header.getBtnFullScreen().addActionListener(acResize);
        header.getBtnExit().addActionListener(acCancel);
        header.getBtnMiniSize().addActionListener(acMiniSize);
        menu.getPnlLogout().addMouseListener(mlLogout);
        menu.getPnlGuide().addMouseListener(mlGuide);
        menu.getPnlStatistical().addMouseListener(mlStatistical);
        menu.getPnlChangePassword().addMouseListener(mlChangePassword);
        menu.getPnlEmployee().addMouseListener(mlEmployee);
        menu.getPnlSupplier().addMouseListener(mlSupplier);
        menu.getPnlImportBill().addMouseListener(mlImportBill);
        menu.getPnlProduct().addMouseListener(mlProduct);
        menu.getPnlProductType().addMouseListener(mlProductType);
        menu.getPnlExportBill().addMouseListener(mlExportBill);
        menu.getPnlhome().addMouseListener(mlHome);
        menu.getPnlContact().addMouseListener(mlContact);

    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public MenuProgram getMenu() {
        return menu;
    }

    public void setMenu(MenuProgram menu) {
        this.menu = menu;
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public void setHeader(HeaderComponent header) {
        this.header = header;
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        pnlContainer.setLayout(layout);
        menu = new MenuProgram();
        header = new HeaderComponent();
        home = new Home(this.getWidth() - 300, this.getHeight() - 60);
        pnlContainer.add(menu, "w 300!, spany 2");    // Span Y 2cell
        pnlContainer.add(header, "h 60!, wrap");
        pnlContainer.add(home, "w 100%, h 100%");
        initLabel(980, 660);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 70 + (230 * (1f - fraction));
                    initLabel((int) (getWidth() - 70 - 230 * (1f - fraction)), getHeight() - 60);
                } else {
                    width = 70 + (230 * fraction);
                    initLabel((int) (getWidth() - 70 - 230 * (fraction)), getHeight() - 60);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent((ActionEvent ae) -> {
            if (!animator.isRunning()) {
                animator.start();
            }
            menu.setEnableMenu(false);
        });
        home.setVisible(true);
    }

    public void initLabel(int width, int height) {
        ImageIcon icon = new ImageIcon("src/Image/backgroundMain.jpg");
        Image image = icon.getImage();
        ImageIcon imageScaled = new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        home.getLblBackground().setIcon(imageScaled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        pnlContainer.setBackground(new java.awt.Color(255, 255, 0));
        pnlContainer.setOpaque(false);

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1301, Short.MAX_VALUE)
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        add(pnlContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlContainer;
    // End of variables declaration//GEN-END:variables
}
