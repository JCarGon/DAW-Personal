package swing;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {
    private AudioPlayer audioPlayer;
    
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/PokedexCerrada.png"));
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(PokedexFondo.getWidth(), PokedexFondo.getHeight(), Image.SCALE_DEFAULT));
        PokedexFondo.setIcon(icon);
        audioPlayer = new AudioPlayer();
        audioPlayer.playAudio("/img/Kanto1.wav");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CampoPass = new javax.swing.JPasswordField();
        CampoUser = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        PokedexFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setMaximumSize(new java.awt.Dimension(420, 540));
        setMinimumSize(new java.awt.Dimension(420, 540));
        setPreferredSize(new java.awt.Dimension(420, 540));
        setResizable(false);
        setSize(new java.awt.Dimension(420, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CampoPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(CampoPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 130, 30));

        CampoUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(CampoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 130, 30));

        Login.setText("Entrar");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 90, 30));

        PokedexFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pokedexCerrada.png"))); // NOI18N
        PokedexFondo.setMaximumSize(new java.awt.Dimension(400, 500));
        PokedexFondo.setMinimumSize(new java.awt.Dimension(400, 500));
        PokedexFondo.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.add(PokedexFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        String userTrainer = CampoUser.getText();
        String passTrainer = CampoPass.getText();
        
        if(userTrainer.equals("Jesus") && passTrainer.equals("1234")){
            JOptionPane.showMessageDialog(null, "Bienvenido a la Pokédex, entrenador "+userTrainer+".");
            this.dispose();
            audioPlayer.stopAudio();
            Pokedex ventanaPokedex = new Pokedex();
        }else{
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
        }
    }//GEN-LAST:event_LoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CampoPass;
    private javax.swing.JTextField CampoUser;
    private javax.swing.JButton Login;
    private javax.swing.JLabel PokedexFondo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}