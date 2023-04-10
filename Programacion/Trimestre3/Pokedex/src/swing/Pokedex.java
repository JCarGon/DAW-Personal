package swing;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Pokedex extends javax.swing.JFrame {
    private AudioPlayer audioPlayer;
    
    public Pokedex() {
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/Pokeball.jpg"));
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(PkmImg.getWidth(), PkmImg.getHeight(), Image.SCALE_DEFAULT));
        PkmImg.setIcon(icon);
        audioPlayer = new AudioPlayer();
        audioPlayer.playAudio("/img/Kanto2.wav");
        JOptionPane.showMessageDialog(null, "Escribe el número de Pokédex del Pokémon para ver su información. Solo están las dos primeras generaciones (1-251)");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        PkmImg = new javax.swing.JLabel();
        SpinnerModel model = new SpinnerNumberModel(1, 1, 251, 1);
        NumPokedex = new javax.swing.JSpinner(model);
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoDatos = new javax.swing.JTextArea();
        ImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokédex");
        setBounds(new java.awt.Rectangle(0, 0, 809, 501));
        setMaximumSize(new java.awt.Dimension(575, 515));
        setMinimumSize(new java.awt.Dimension(575, 515));
        setPreferredSize(new java.awt.Dimension(575, 515));
        setResizable(false);
        setSize(new java.awt.Dimension(575, 515));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("Ver datos");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 430, 90, -1));

        PkmImg.setBackground(new java.awt.Color(255, 255, 255));
        PkmImg.setForeground(new java.awt.Color(255, 255, 255));
        PkmImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pokeball.jpg"))); // NOI18N
        PkmImg.setMaximumSize(new java.awt.Dimension(180, 150));
        PkmImg.setMinimumSize(new java.awt.Dimension(180, 150));
        PkmImg.setPreferredSize(new java.awt.Dimension(180, 150));
        jPanel1.add(PkmImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 180, 150));

        NumPokedex.setEditor(new javax.swing.JSpinner.NumberEditor(NumPokedex, ""));
        jPanel1.add(NumPokedex, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 90, 40));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CampoDatos.setEditable(false);
        CampoDatos.setBackground(new java.awt.Color(0, 0, 0));
        CampoDatos.setColumns(20);
        CampoDatos.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        CampoDatos.setForeground(new java.awt.Color(255, 255, 255));
        CampoDatos.setRows(5);
        jScrollPane1.setViewportView(CampoDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 220, 80));

        ImagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pokedex.png"))); // NOI18N
        jPanel1.add(ImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //botón de búsqueda para resultado de la select
        String nombrePkm = "\n     Nombre: Charizard";
        String region = "     Región: Kanto";
        String datos = nombrePkm+"\n"+region;
        CampoDatos.setText(datos);
        //Para reescalar una imagen a otras dimensiones:
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/charizard.png"));
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(PkmImg.getWidth(), PkmImg.getHeight(), Image.SCALE_DEFAULT));
        PkmImg.setIcon(icon);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CampoDatos;
    private javax.swing.JLabel ImagenFondo;
    private javax.swing.JSpinner NumPokedex;
    private javax.swing.JLabel PkmImg;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
