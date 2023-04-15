package swing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import ConnectionBBDD.Conexion;
import java.awt.Toolkit;
import java.sql.*;

public class Pokedex extends javax.swing.JFrame {
    private AudioPlayer audioPlayer;
    
    public Pokedex() {
        initComponents();
        setIconImage(getIconImage()); //logo en la aplicación y en la barra de tareas
        this.setLocationRelativeTo(null);
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/Pokeball.jpg"));
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(PkmImg.getWidth(), PkmImg.getHeight(), Image.SCALE_DEFAULT));
        PkmImg.setIcon(icon);
        audioPlayer = new AudioPlayer();
        audioPlayer.playAudio("/img/Kanto2.wav");
        JOptionPane.showMessageDialog(null, "Escribe el número de Pokédex del Pokémon para ver su información. Solo están las dos primeras generaciones (1-251)");
    }

    //icono de la ventana y barra de tareas
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/Pokeball.png"));
        return retValue;
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
        CampoDatos.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        CampoDatos.setForeground(new java.awt.Color(255, 255, 255));
        CampoDatos.setRows(5);
        jScrollPane1.setViewportView(CampoDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 220, 90));

        ImagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pokedex.png"))); // NOI18N
        jPanel1.add(ImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //botón de búsqueda para resultado de la select
        Conexion.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String valorConsulta = NumPokedex.getValue().toString();
        String consulta = "SELECT * FROM pokemon WHERE ID = "+valorConsulta;
        System.out.println(consulta);
        try {
            rs = Conexion.ejecutarSentencia(consulta);
            while(rs.next()){
                String nombre_Pokemon = rs.getString("nombre_Pokemon");
                String tipo_Pokemon = rs.getString("tipo_Pokemon");
                String habilidad_Pokemon = rs.getString("habilidad_Pokemon");
                String habilidad_Oculta = rs.getString("habilidad_Oculta");
                String fase_Evolutiva = "";
                if(rs.getString("fase_Evolutiva")== null){
                    fase_Evolutiva = "No tiene evolución.";
                }else{
                    fase_Evolutiva = rs.getString("fase_Evolutiva");
                }
                String foto = rs.getString("imagen_Pokemon");
                // Read the image file into a BufferedImage object
                BufferedImage img;
                try {
                img = ImageIO.read(new File("src/img/pokemons/"+foto));
                // Create a ByteArrayOutputStream to write the image bytes to
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // Write the image bytes to the ByteArrayOutputStream
                ImageIO.write(img, "jpg", baos);
                // Get the byte array from the ByteArrayOutputStream
                byte[] imageBytes = baos.toByteArray();
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                //Para reescalar una imagen a otras dimensiones:
                Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(PkmImg.getWidth(), PkmImg.getHeight(), Image.SCALE_DEFAULT));
                PkmImg.setIcon(icon);
            } catch (IOException exc) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la imagen.");
            }
                String mostrarPantalla = "\n   Nombre: "+nombre_Pokemon+"\n"
                        +"   Tipo: "+tipo_Pokemon+"\n"
                        +"   Habilidad: "+habilidad_Pokemon+"\n"
                        +"   Habilidad Oculta: "+habilidad_Oculta+"\n"
                        +"   Fase evolutiva: "+fase_Evolutiva;
                CampoDatos.setText(mostrarPantalla);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta");
        }
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