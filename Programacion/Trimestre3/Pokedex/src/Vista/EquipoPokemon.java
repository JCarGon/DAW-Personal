package Vista;

import Controlador.Controlador;
import Modelo.User;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.WindowConstants;

public class EquipoPokemon extends javax.swing.JFrame {
    private Pokedex pokedex;
    
    public EquipoPokemon(User user, Pokedex pokedex) throws IOException {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImage(getIconImage()); //logo en la aplicación y en la barra de tareas
        if(user.getEquipoPokemon().isEmpty()){ //equipo vacío
        }else if(user.getEquipoPokemon().size() == 1){ //equipo de 1 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            NumPkm1.setText(String.valueOf(user.getEquipoPokemon().get(0).getID()));
            NombrePkm1.setText(user.getEquipoPokemon().get(0).getNombre_Pokemon());
        }else if((user.getEquipoPokemon().size() >= 2) && (user.getEquipoPokemon().size() < 3)){ //equipo de 2 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            NumPkm1.setText(String.valueOf(user.getEquipoPokemon().get(0).getID()));
            NombrePkm1.setText(user.getEquipoPokemon().get(0).getNombre_Pokemon());
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            NumPkm2.setText(String.valueOf(user.getEquipoPokemon().get(1).getID()));
            NombrePkm2.setText(user.getEquipoPokemon().get(1).getNombre_Pokemon());
        }else if((user.getEquipoPokemon().size() >= 3) && (user.getEquipoPokemon().size() < 4)){ //equipo de 3 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            NumPkm1.setText(String.valueOf(user.getEquipoPokemon().get(0).getID()));
            NombrePkm1.setText(user.getEquipoPokemon().get(0).getNombre_Pokemon());
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            NumPkm2.setText(String.valueOf(user.getEquipoPokemon().get(1).getID()));
            NombrePkm2.setText(user.getEquipoPokemon().get(1).getNombre_Pokemon());
            Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
            Pokemon3.setIcon(icon3);
            NumPkm3.setText(String.valueOf(user.getEquipoPokemon().get(2).getID()));
            NombrePkm3.setText(user.getEquipoPokemon().get(2).getNombre_Pokemon());
        }else if((user.getEquipoPokemon().size() >= 4) && (user.getEquipoPokemon().size() < 5)){ //equipo de 4 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            NumPkm1.setText(String.valueOf(user.getEquipoPokemon().get(0).getID()));
            NombrePkm1.setText(user.getEquipoPokemon().get(0).getNombre_Pokemon());
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            NumPkm2.setText(String.valueOf(user.getEquipoPokemon().get(1).getID()));
            NombrePkm2.setText(user.getEquipoPokemon().get(1).getNombre_Pokemon());
            Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
            Pokemon3.setIcon(icon3);
            NumPkm3.setText(String.valueOf(user.getEquipoPokemon().get(2).getID()));
            NombrePkm3.setText(user.getEquipoPokemon().get(2).getNombre_Pokemon());
            Icon icon4 = Controlador.obtenerIcon(user.getEquipoPokemon().get(3), Pokemon4.getWidth(), Pokemon1.getHeight());
            Pokemon4.setIcon(icon4);
            NumPkm4.setText(String.valueOf(user.getEquipoPokemon().get(3).getID()));
            NombrePkm4.setText(user.getEquipoPokemon().get(3).getNombre_Pokemon());
        }else if((user.getEquipoPokemon().size() >= 5) && (user.getEquipoPokemon().size() < 6)){ //equipo de 5 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            NumPkm1.setText(String.valueOf(user.getEquipoPokemon().get(0).getID()));
            NombrePkm1.setText(user.getEquipoPokemon().get(0).getNombre_Pokemon());
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            NumPkm2.setText(String.valueOf(user.getEquipoPokemon().get(1).getID()));
            NombrePkm2.setText(user.getEquipoPokemon().get(1).getNombre_Pokemon());
            Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
            Pokemon3.setIcon(icon3);
            NumPkm3.setText(String.valueOf(user.getEquipoPokemon().get(2).getID()));
            NombrePkm3.setText(user.getEquipoPokemon().get(2).getNombre_Pokemon());
            Icon icon4 = Controlador.obtenerIcon(user.getEquipoPokemon().get(3), Pokemon4.getWidth(), Pokemon1.getHeight());
            Pokemon4.setIcon(icon4);
            NumPkm4.setText(String.valueOf(user.getEquipoPokemon().get(3).getID()));
            NombrePkm4.setText(user.getEquipoPokemon().get(3).getNombre_Pokemon());
            Icon icon5 = Controlador.obtenerIcon(user.getEquipoPokemon().get(4), Pokemon5.getWidth(), Pokemon1.getHeight());
            Pokemon5.setIcon(icon5);
            NumPkm5.setText(String.valueOf(user.getEquipoPokemon().get(4).getID()));
            NombrePkm5.setText(user.getEquipoPokemon().get(4).getNombre_Pokemon());
        }else{ //equipo de 6 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            NumPkm1.setText(String.valueOf(user.getEquipoPokemon().get(0).getID()));
            NombrePkm1.setText(user.getEquipoPokemon().get(0).getNombre_Pokemon());
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            NumPkm2.setText(String.valueOf(user.getEquipoPokemon().get(1).getID()));
            NombrePkm2.setText(user.getEquipoPokemon().get(1).getNombre_Pokemon());
            Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
            Pokemon3.setIcon(icon3);
            NumPkm3.setText(String.valueOf(user.getEquipoPokemon().get(2).getID()));
            NombrePkm3.setText(user.getEquipoPokemon().get(2).getNombre_Pokemon());
            Icon icon4 = Controlador.obtenerIcon(user.getEquipoPokemon().get(3), Pokemon4.getWidth(), Pokemon1.getHeight());
            Pokemon4.setIcon(icon4);
            NumPkm4.setText(String.valueOf(user.getEquipoPokemon().get(3).getID()));
            NombrePkm4.setText(user.getEquipoPokemon().get(3).getNombre_Pokemon());
            Icon icon5 = Controlador.obtenerIcon(user.getEquipoPokemon().get(4), Pokemon5.getWidth(), Pokemon1.getHeight());
            Pokemon5.setIcon(icon5);
            NumPkm5.setText(String.valueOf(user.getEquipoPokemon().get(4).getID()));
            NombrePkm5.setText(user.getEquipoPokemon().get(4).getNombre_Pokemon());
            Icon icon6 = Controlador.obtenerIcon(user.getEquipoPokemon().get(5), Pokemon6.getWidth(), Pokemon1.getHeight());
            Pokemon6.setIcon(icon6);
            NumPkm6.setText(String.valueOf(user.getEquipoPokemon().get(5).getID()));
            NombrePkm6.setText(user.getEquipoPokemon().get(5).getNombre_Pokemon());
        }
        // Cambiar el comportamiento de cierre de ventana
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Acciones personalizadas al cerrar la ventana
                // Cerrar la ventana y abrir la ventana pokedex
                dispose();
                pokedex.setVisible(true);
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
        Pokemon1 = new javax.swing.JLabel();
        NumPkm1 = new javax.swing.JLabel();
        NombrePkm1 = new javax.swing.JLabel();
        Pokemon2 = new javax.swing.JLabel();
        NumPkm2 = new javax.swing.JLabel();
        NombrePkm2 = new javax.swing.JLabel();
        Pokemon3 = new javax.swing.JLabel();
        NumPkm3 = new javax.swing.JLabel();
        NombrePkm3 = new javax.swing.JLabel();
        Pokemon4 = new javax.swing.JLabel();
        NumPkm4 = new javax.swing.JLabel();
        NombrePkm4 = new javax.swing.JLabel();
        Pokemon5 = new javax.swing.JLabel();
        NumPkm5 = new javax.swing.JLabel();
        NombrePkm5 = new javax.swing.JLabel();
        Pokemon6 = new javax.swing.JLabel();
        NumPkm6 = new javax.swing.JLabel();
        NombrePkm6 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equipo Pokémon");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pokemon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon1.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel1.add(Pokemon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        NumPkm1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(NumPkm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 30, 20));

        NombrePkm1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NombrePkm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(NombrePkm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 100, 20));

        Pokemon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon2.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel1.add(Pokemon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        NumPkm2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(NumPkm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 30, 20));

        NombrePkm2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NombrePkm2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(NombrePkm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 100, 20));

        Pokemon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon3.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel1.add(Pokemon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        NumPkm3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(NumPkm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 30, 20));

        NombrePkm3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NombrePkm3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(NombrePkm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 100, 20));

        Pokemon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon4.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel1.add(Pokemon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        NumPkm4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(NumPkm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 30, 20));

        NombrePkm4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NombrePkm4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(NombrePkm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 100, 20));

        Pokemon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon5.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel1.add(Pokemon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, -1));

        NumPkm5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(NumPkm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 30, 20));

        NombrePkm5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NombrePkm5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(NombrePkm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 100, 20));

        Pokemon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon6.setPreferredSize(new java.awt.Dimension(130, 130));
        jPanel1.add(Pokemon6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, -1, -1));

        NumPkm6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(NumPkm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, 30, 20));

        NombrePkm6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NombrePkm6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(NombrePkm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 100, 20));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo1.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NombrePkm1;
    private javax.swing.JLabel NombrePkm2;
    private javax.swing.JLabel NombrePkm3;
    private javax.swing.JLabel NombrePkm4;
    private javax.swing.JLabel NombrePkm5;
    private javax.swing.JLabel NombrePkm6;
    private javax.swing.JLabel NumPkm1;
    private javax.swing.JLabel NumPkm2;
    private javax.swing.JLabel NumPkm3;
    private javax.swing.JLabel NumPkm4;
    private javax.swing.JLabel NumPkm5;
    private javax.swing.JLabel NumPkm6;
    private javax.swing.JLabel Pokemon1;
    private javax.swing.JLabel Pokemon2;
    private javax.swing.JLabel Pokemon3;
    private javax.swing.JLabel Pokemon4;
    private javax.swing.JLabel Pokemon5;
    private javax.swing.JLabel Pokemon6;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
