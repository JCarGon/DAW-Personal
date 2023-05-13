package Vista;

import Controlador.Controlador;
import Modelo.User;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.Icon;

public class EquipoPokemon extends javax.swing.JFrame {

    public EquipoPokemon(User user) throws IOException {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImage(getIconImage()); //logo en la aplicación y en la barra de tareas
        if(user.getEquipoPokemon().size() == 1){ //equipo de 1 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
        }else if((user.getEquipoPokemon().size() >= 2) && (user.getEquipoPokemon().size() < 3)){ //equipo de 2 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
        }else if((user.getEquipoPokemon().size() >= 3) && (user.getEquipoPokemon().size() < 4)){ //equipo de 3 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
            Pokemon3.setIcon(icon3);
        }else if((user.getEquipoPokemon().size() >= 4) && (user.getEquipoPokemon().size() < 5)){ //equipo de 4 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
            Pokemon3.setIcon(icon3);
            Icon icon4 = Controlador.obtenerIcon(user.getEquipoPokemon().get(3), Pokemon4.getWidth(), Pokemon1.getHeight());
            Pokemon4.setIcon(icon4);
        }else if((user.getEquipoPokemon().size() >= 5) && (user.getEquipoPokemon().size() < 6)){ //equipo de 5 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
            Pokemon3.setIcon(icon3);
            Icon icon4 = Controlador.obtenerIcon(user.getEquipoPokemon().get(3), Pokemon4.getWidth(), Pokemon1.getHeight());
            Pokemon4.setIcon(icon4);
            Icon icon5 = Controlador.obtenerIcon(user.getEquipoPokemon().get(4), Pokemon5.getWidth(), Pokemon1.getHeight());
            Pokemon5.setIcon(icon5);
        }else{ //equipo de 6 pokemon
            Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
            Pokemon1.setIcon(icon1);
            Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
            Pokemon2.setIcon(icon2);
            Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
            Pokemon3.setIcon(icon3);
            Icon icon4 = Controlador.obtenerIcon(user.getEquipoPokemon().get(3), Pokemon4.getWidth(), Pokemon1.getHeight());
            Pokemon4.setIcon(icon4);
            Icon icon5 = Controlador.obtenerIcon(user.getEquipoPokemon().get(4), Pokemon5.getWidth(), Pokemon1.getHeight());
            Pokemon5.setIcon(icon5);
            Icon icon6 = Controlador.obtenerIcon(user.getEquipoPokemon().get(5), Pokemon6.getWidth(), Pokemon1.getHeight());
            Pokemon6.setIcon(icon6);
        }
        /*Icon icon1 = Controlador.obtenerIcon(user.getEquipoPokemon().get(0), Pokemon1.getWidth(), Pokemon1.getHeight());
        Pokemon1.setIcon(icon1);
        Icon icon2 = Controlador.obtenerIcon(user.getEquipoPokemon().get(1), Pokemon2.getWidth(), Pokemon1.getHeight());
        Pokemon2.setIcon(icon2);
        Icon icon3 = Controlador.obtenerIcon(user.getEquipoPokemon().get(2), Pokemon3.getWidth(), Pokemon1.getHeight());
        Pokemon3.setIcon(icon3);
        Icon icon4 = Controlador.obtenerIcon(user.getEquipoPokemon().get(3), Pokemon4.getWidth(), Pokemon1.getHeight());
        Pokemon4.setIcon(icon4);
        Icon icon5 = Controlador.obtenerIcon(user.getEquipoPokemon().get(4), Pokemon5.getWidth(), Pokemon1.getHeight());
        Pokemon5.setIcon(icon5);
        Icon icon6 = Controlador.obtenerIcon(user.getEquipoPokemon().get(5), Pokemon6.getWidth(), Pokemon1.getHeight());
        Pokemon6.setIcon(icon6);*/
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
        Pokemon2 = new javax.swing.JLabel();
        Pokemon3 = new javax.swing.JLabel();
        Pokemon4 = new javax.swing.JLabel();
        Pokemon5 = new javax.swing.JLabel();
        Pokemon6 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equipo Pokémon");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pokemon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon1.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel1.add(Pokemon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        Pokemon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon2.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel1.add(Pokemon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, -1));

        Pokemon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon3.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel1.add(Pokemon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        Pokemon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon4.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel1.add(Pokemon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        Pokemon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon5.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel1.add(Pokemon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        Pokemon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoPokeball.png"))); // NOI18N
        Pokemon6.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel1.add(Pokemon6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo1.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
