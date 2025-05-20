package dev.gl.snake.views;

import dev.gl.snake.listeners.OkDisposingAction;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.Properties;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

/**
 *
 * @author gl
 */
public class AboutDialog extends javax.swing.JDialog {
    
    private AbstractAction okButtonAction;

    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        okButtonAction = new OkDisposingAction(this);
        initComponents();
        this.setLocationRelativeTo(null);
        attachListenerToOkButton();
        bindKeyListenersToOkButton();
        loadLogo();
        getVersion();
        setHomeLink();
        setImageSourceLink();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        upperSubpanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        programNameLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        linksPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        homeLinkLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        imageLinkLabel = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setMinimumSize(new java.awt.Dimension(300, 220));
        setResizable(false);

        mainPanel.setLayout(new java.awt.BorderLayout());

        upperSubpanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        upperSubpanel.add(logoPanel);

        infoPanel.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        programNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        programNameLabel.setText("Snake");
        jPanel4.add(programNameLabel);

        infoPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Version: ");
        jPanel3.add(jLabel3);

        versionLabel.setText("jLabel4");
        jPanel3.add(versionLabel);

        infoPanel.add(jPanel3, java.awt.BorderLayout.SOUTH);

        upperSubpanel.add(infoPanel);

        mainPanel.add(upperSubpanel, java.awt.BorderLayout.CENTER);

        linksPanel.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setText("Home:");
        jPanel1.add(jLabel4);

        homeLinkLabel.setText("jLabel5");
        homeLinkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(homeLinkLabel);

        linksPanel.add(jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel6.setText("Image source:");
        jPanel2.add(jLabel6);

        imageLinkLabel.setText("jLabel7");
        imageLinkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(imageLinkLabel);

        linksPanel.add(jPanel2);

        mainPanel.add(linksPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel homeLinkLabel;
    private javax.swing.JLabel imageLinkLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel linksPanel;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel programNameLabel;
    private javax.swing.JPanel upperSubpanel;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables

    private void loadLogo() {
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/icons8-snake-80.png"));
        JLabel logoLabel = new JLabel(icon);
        logoPanel.add(logoLabel);
    }

    private void getVersion() {
        Properties props = new Properties();
        try {
            props.load(this.getClass().getClassLoader().getResourceAsStream(".properties"));
            versionLabel.setText(props.getProperty("version", "undefined"));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private void setHomeLink() {
        final String homeLink = "https://github.com/Ggg93";
        homeLinkLabel.setText("<html><a href=\"\">" + homeLink + "</a></html>");
        homeLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        homeLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(homeLink));
                } catch (Exception urlException) {
                    urlException.printStackTrace(System.err);
                }
            }
        });
    }

    private void setImageSourceLink() {
        final String imageLink = "https://icons8.com/icon/107949/snake";
        final String icons8Link = """
                                <html>
                                <a href="https://icons8.com/icon/107949/snake">Snake</a>
                                icon by 
                                <a href="https://icons8.com">Icons8</a>
                                </html>
                                """;
        imageLinkLabel.setText(icons8Link);
        imageLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(imageLink));
                } catch (Exception urlException) {
                    urlException.printStackTrace(System.err);
                }
            }
        });
    }

    private void attachListenerToOkButton() {
        okButton.addActionListener(okButtonAction);
    }

    private void bindKeyListenersToOkButton() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = this.getRootPane().getActionMap();
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ok");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "ok");
        
        actionMap.put("ok", okButtonAction);
    }
}
