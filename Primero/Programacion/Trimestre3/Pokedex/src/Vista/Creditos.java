package Vista;

import Modelo.AudioPlayer;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Creditos extends javax.swing.JFrame {
    private AudioPlayer audioPlayer;
    
    public Creditos() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImage(getIconImage()); //logo en la aplicación y en la barra de tareas
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/img/trainer.png"));
        Icon icon1 = new ImageIcon(imageIcon1.getImage().getScaledInstance(fotoTrainer.getWidth(), fotoTrainer.getHeight(), Image.SCALE_DEFAULT));
        fotoTrainer.setIcon(icon1);
        //canción de fondo
        audioPlayer = new AudioPlayer();
        audioPlayer.playAudio("/img/Celestial.wav");
        
        // Configurar el temporizador para cerrar la ventana después de 5 segundos
        int delay = 112500; // 152.5 segundos en milisegundos
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana cuando se activa el temporizador
                audioPlayer.stopAudio();
                dispose();
            }
        });
        timer.setRepeats(false); // Configurar el temporizador para no repetirse
        // Iniciar el temporizador
        timer.start();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fotoTrainer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jesús Carrillo González");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 320, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PD: Nintendo no me demandes");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 440, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hecho por:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 170, 30));

        fotoTrainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trainer.png"))); // NOI18N
        fotoTrainer.setPreferredSize(new java.awt.Dimension(350, 520));
        jPanel1.add(fotoTrainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fotoTrainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
