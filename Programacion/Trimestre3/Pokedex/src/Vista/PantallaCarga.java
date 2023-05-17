package Vista;

import Modelo.AudioPlayer;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class PantallaCarga extends javax.swing.JFrame {
    private AudioPlayer audioPlayer;

    public PantallaCarga() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImage(getIconImage()); //logo en la aplicación y en la barra de tareas
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/intro.gif"));
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(JPanel.getWidth(), JPanel.getHeight(), Image.SCALE_DEFAULT));
        introGIF.setIcon(icon);
        //canción de fondo
        audioPlayer = new AudioPlayer();
        audioPlayer.playAudio("/img/PeleaIntro.wav");
        
        // Configurar el temporizador para cerrar la ventana después de 5 segundos
        int delay = 10200; // 10.4 segundos en milisegundos
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana cuando se activa el temporizador
                audioPlayer.stopAudio();
                dispose();
                Inicio inicio = new Inicio();
            }
        });
        timer.setRepeats(false); // Configurar el temporizador para no repetirse
        // Iniciar el temporizador
        timer.start();
        
        // Cambiar el comportamiento de cierre de ventana
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Acciones personalizadas al cerrar la ventana
                // Para musica y cerrar la ventana
                timer.stop();
                audioPlayer.stopAudio();
                dispose();
                Inicio inicio = new Inicio();
            }
        });
    }

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/Pokeball.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel = new javax.swing.JPanel();
        introGIF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 300));
        setMinimumSize(new java.awt.Dimension(377, 251));
        setResizable(false);

        JPanel.setPreferredSize(new java.awt.Dimension(377, 251));
        JPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        introGIF.setPreferredSize(new java.awt.Dimension(377, 251));
        JPanel.add(introGIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JLabel introGIF;
    // End of variables declaration//GEN-END:variables
}
