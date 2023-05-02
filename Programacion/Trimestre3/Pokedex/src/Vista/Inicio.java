package Vista;

import Modelo.AudioPlayer;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Controlador.Controlador;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {
    private AudioPlayer audioPlayer;
    
    public Inicio() {
        initComponents();
        setIconImage(getIconImage()); //logo en la aplicación y en la barra de tareas
        this.setLocationRelativeTo(null);
        setVisible(true);
        //reescalado de imagen del logo
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/pokemon_logo.png"));
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(logoInicio.getWidth(), logoInicio.getHeight(), Image.SCALE_DEFAULT));
        logoInicio.setIcon(icon);
        //reescalado de la pokedex cerrada para el fondo
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/img/PokedexCerrada.png"));
        Icon icon1 = new ImageIcon(imageIcon1.getImage().getScaledInstance(PokedexFondo.getWidth(), PokedexFondo.getHeight(), Image.SCALE_DEFAULT));
        PokedexFondo.setIcon(icon1);
        //canción de fondo
        audioPlayer = new AudioPlayer();
        audioPlayer.playAudio("/img/Kanto1.wav");
    }
    
    //icono de la ventana y barra de tareas
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/pokeball.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CampoPass = new javax.swing.JPasswordField();
        CampoUser = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        logoInicio = new javax.swing.JLabel();
        Gestor = new javax.swing.JButton();
        PokedexFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setMinimumSize(new java.awt.Dimension(420, 540));
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
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 90, 30));

        logoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pokemon_logo.png"))); // NOI18N
        logoInicio.setMaximumSize(new java.awt.Dimension(310, 110));
        logoInicio.setMinimumSize(new java.awt.Dimension(310, 110));
        logoInicio.setPreferredSize(new java.awt.Dimension(310, 110));
        jPanel1.add(logoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 310, 100));

        Gestor.setText("Gestor");
        Gestor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestorActionPerformed(evt);
            }
        });
        jPanel1.add(Gestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

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
        String passTrainer = String.valueOf(CampoPass.getPassword());
        if(!userTrainer.contains(" ") && userTrainer.length()>0 && passTrainer.length()>0){
            if(Controlador.login(userTrainer, passTrainer)){
                this.dispose();
                audioPlayer.stopAudio();
                Pokedex ventanaPokedex = new Pokedex();
            }
        }else if(userTrainer.length()==0){
            JOptionPane.showMessageDialog(null, "Inserta un nombre de usuario.");
        }else if(passTrainer.length()==0){
            JOptionPane.showMessageDialog(null, "Es necesaria una contraseña para identificarse.");
        }else{
            JOptionPane.showMessageDialog(null, "No se pueden usar espacios en el nombre de usuario.");
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void GestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestorActionPerformed
        ConfirmacionRoot confirmacion = new ConfirmacionRoot();
    }//GEN-LAST:event_GestorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CampoPass;
    private javax.swing.JTextField CampoUser;
    private javax.swing.JButton Gestor;
    private javax.swing.JButton Login;
    private javax.swing.JLabel PokedexFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoInicio;
    // End of variables declaration//GEN-END:variables
}