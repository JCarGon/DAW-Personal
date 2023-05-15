package Vista;

import Modelo.AudioPlayer;
import java.awt.Image;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;
import Modelo.Pokemon;
import Controlador.Controlador;
import Modelo.User;
import javax.swing.WindowConstants;

public class Pokedex extends javax.swing.JFrame {
    private AudioPlayer audioPlayer;
    private Inicio ventanaInicio;
    private User user;
    
    public Pokedex(Inicio ventanaInicio, User user) {
        this.ventanaInicio = ventanaInicio;
        this.user = user;
        this.ventanaInicio.audioPlayer.stopAudio();
        initComponents();
        setIconImage(getIconImage()); //logo en la aplicación y en la barra de tareas
        this.setLocationRelativeTo(null);
        setVisible(true);
        audioPlayer = new AudioPlayer();
        audioPlayer.playAudio("/img/Kanto2.wav");
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/Pokeball.png"));
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(PkmImg.getWidth(), PkmImg.getHeight(), Image.SCALE_DEFAULT));
        PkmImg.setIcon(icon);
        JOptionPane.showMessageDialog(null, "Escribe el número de Pokédex del Pokémon para ver su información. Solo están las dos primeras generaciones (1-251)");
        
        // Cambiar el comportamiento de cierre de ventana
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Acciones personalizadas al cerrar la ventana
                // mostrar un mensaje de confirmación antes de cerrar
                int option = javax.swing.JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de que deseas salir del programa?",
                        "Confirmar cierre", javax.swing.JOptionPane.YES_NO_OPTION);

                if (option == javax.swing.JOptionPane.YES_OPTION) {
                    // Para musica y cerrar la ventana inicio y pokedex
                    ventanaInicio.dispose();
                    audioPlayer.stopAudio();
                    dispose();
                    Creditos c = new Creditos();
                }
            }
        });
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
        verDatos = new javax.swing.JButton();
        PkmImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SpinnerModel model = new SpinnerNumberModel(1, 1, 251, 1);
        NumPokedex = new javax.swing.JSpinner(model);
        printDatos = new javax.swing.JButton();
        BotonCerrarSesion = new javax.swing.JButton();
        VerEquipo = new javax.swing.JButton();
        BotonCapturarPokemon = new javax.swing.JButton();
        BotonBorrarPokemon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoDatos = new javax.swing.JTextArea();
        ImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokédex");
        setBounds(new java.awt.Rectangle(0, 0, 809, 501));
        setMinimumSize(new java.awt.Dimension(575, 515));
        setResizable(false);
        setSize(new java.awt.Dimension(575, 515));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verDatos.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        verDatos.setText("Ver datos");
        verDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        verDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDatosActionPerformed(evt);
            }
        });
        jPanel1.add(verDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 90, -1));

        PkmImg.setBackground(new java.awt.Color(255, 255, 255));
        PkmImg.setForeground(new java.awt.Color(255, 255, 255));
        PkmImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pokeball.jpg"))); // NOI18N
        PkmImg.setMaximumSize(new java.awt.Dimension(180, 150));
        PkmImg.setMinimumSize(new java.awt.Dimension(180, 150));
        PkmImg.setPreferredSize(new java.awt.Dimension(180, 150));
        jPanel1.add(PkmImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 180, 150));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 180, 150));

        NumPokedex.setModel(new javax.swing.SpinnerNumberModel(1, 1, 251, 1));
        NumPokedex.setEditor(new javax.swing.JSpinner.NumberEditor(NumPokedex, ""));
        jPanel1.add(NumPokedex, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 90, 40));

        printDatos.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        printDatos.setText("Imprimir datos");
        printDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printDatosActionPerformed(evt);
            }
        });
        jPanel1.add(printDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 110, 40));

        BotonCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarSesion.png"))); // NOI18N
        BotonCerrarSesion.setBorderPainted(false);
        BotonCerrarSesion.setContentAreaFilled(false);
        BotonCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCerrarSesion.setFocusPainted(false);
        BotonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(BotonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        VerEquipo.setText("Ver Equipo");
        VerEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerEquipoActionPerformed(evt);
            }
        });
        jPanel1.add(VerEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 110, -1));

        BotonCapturarPokemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPokemon.png"))); // NOI18N
        BotonCapturarPokemon.setBorderPainted(false);
        BotonCapturarPokemon.setContentAreaFilled(false);
        BotonCapturarPokemon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCapturarPokemon.setFocusPainted(false);
        BotonCapturarPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCapturarPokemonActionPerformed(evt);
            }
        });
        jPanel1.add(BotonCapturarPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        BotonBorrarPokemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deletePokemon.png"))); // NOI18N
        BotonBorrarPokemon.setBorderPainted(false);
        BotonBorrarPokemon.setContentAreaFilled(false);
        BotonBorrarPokemon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonBorrarPokemon.setFocusPainted(false);
        BotonBorrarPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarPokemonActionPerformed(evt);
            }
        });
        jPanel1.add(BotonBorrarPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

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

    private void verDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDatosActionPerformed
        //botón de búsqueda para resultado de la select
        String valorConsulta = NumPokedex.getValue().toString();
        Pokemon pokemon = Controlador.obtenerPkmDeBBDD(valorConsulta);
        try {
            Icon icon = Controlador.obtenerIcon(pokemon, PkmImg.getWidth(), PkmImg.getHeight());
            PkmImg.setIcon(icon);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        String DatosPokemon = Controlador.devolverDatosPokemon(pokemon);
        CampoDatos.setText(DatosPokemon);
    }//GEN-LAST:event_verDatosActionPerformed

    private void printDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDatosActionPerformed
        String ruta = "DatosPokemon.md";
        String valorConsulta = NumPokedex.getValue().toString();
        Pokemon pokemon = Controlador.obtenerPkmDeBBDD(valorConsulta);
        try {
                Icon icon = Controlador.obtenerIcon(pokemon, PkmImg.getWidth(), PkmImg.getHeight());
                PkmImg.setIcon(icon);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        String DatosPokemon = Controlador.devolverDatosPokemon(pokemon);
        try {
            Controlador.escribirDatosPokemon(pokemon, ruta);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar escribir en el archivo.");
        }
    }//GEN-LAST:event_printDatosActionPerformed

    private void BotonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarSesionActionPerformed
        audioPlayer.stopAudio();
        this.dispose();
        ventanaInicio.setVisible(true);
        ventanaInicio.audioPlayer.playAudio("/img/Kanto1.wav");
        
    }//GEN-LAST:event_BotonCerrarSesionActionPerformed

    private void BotonCapturarPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCapturarPokemonActionPerformed
        String valorConsulta = NumPokedex.getValue().toString();
        Pokemon pokemon = Controlador.obtenerPkmDeBBDD(valorConsulta);
        try {
                Icon icon = Controlador.obtenerIcon(pokemon, PkmImg.getWidth(), PkmImg.getHeight());
                PkmImg.setIcon(icon);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        String DatosPokemon = Controlador.devolverDatosPokemon(pokemon);
        CampoDatos.setText(DatosPokemon);
        if(Controlador.capturarPokemon(user, pokemon)){
            JOptionPane.showMessageDialog(null, "Pokemon añadido al equipo.");
        }
    }//GEN-LAST:event_BotonCapturarPokemonActionPerformed

    private void BotonBorrarPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarPokemonActionPerformed
        String valorConsulta = NumPokedex.getValue().toString();
        Pokemon pokemon = Controlador.obtenerPkmDeBBDD(valorConsulta);
        try {
                Icon icon = Controlador.obtenerIcon(pokemon, PkmImg.getWidth(), PkmImg.getHeight());
                PkmImg.setIcon(icon);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        String DatosPokemon = Controlador.devolverDatosPokemon(pokemon);
        if(Controlador.liberarPokemon(user, pokemon)){
            JOptionPane.showMessageDialog(null, "Pokemon liberado. Vuela alto compañero.");
        }
    }//GEN-LAST:event_BotonBorrarPokemonActionPerformed

    private void VerEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerEquipoActionPerformed
        try {
            this.setVisible(false);
            EquipoPokemon equipo = new EquipoPokemon(user, this);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_VerEquipoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBorrarPokemon;
    private javax.swing.JButton BotonCapturarPokemon;
    private javax.swing.JButton BotonCerrarSesion;
    private javax.swing.JTextArea CampoDatos;
    private javax.swing.JLabel ImagenFondo;
    private javax.swing.JSpinner NumPokedex;
    private javax.swing.JLabel PkmImg;
    private javax.swing.JButton VerEquipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printDatos;
    private javax.swing.JButton verDatos;
    // End of variables declaration//GEN-END:variables
}