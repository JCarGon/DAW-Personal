package Vista;

import Controlador.Controlador;
import javax.swing.JOptionPane;

public class PanelUsuarios extends javax.swing.JFrame {

    public PanelUsuarios() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UDUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CrearUser = new javax.swing.JButton();
        DeleteUser = new javax.swing.JButton();
        ModificarUser = new javax.swing.JButton();
        NombreCrearUser = new javax.swing.JTextField();
        PassCrearUser = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel1.setText("Introduce el  usuario para eliminar o modificar: ");

        CrearUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/newUser.png"))); // NOI18N
        CrearUser.setBorder(null);
        CrearUser.setBorderPainted(false);
        CrearUser.setContentAreaFilled(false);
        CrearUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrearUser.setFocusPainted(false);
        CrearUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearUserActionPerformed(evt);
            }
        });

        DeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deleteUser.png"))); // NOI18N
        DeleteUser.setBorderPainted(false);
        DeleteUser.setContentAreaFilled(false);
        DeleteUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteUser.setFocusPainted(false);
        DeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUserActionPerformed(evt);
            }
        });

        ModificarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modifyUser.png"))); // NOI18N
        ModificarUser.setBorderPainted(false);
        ModificarUser.setContentAreaFilled(false);
        ModificarUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ModificarUser.setFocusPainted(false);
        ModificarUser.setMaximumSize(new java.awt.Dimension(54, 55));
        ModificarUser.setMinimumSize(new java.awt.Dimension(54, 55));
        ModificarUser.setPreferredSize(new java.awt.Dimension(54, 55));
        ModificarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarUserActionPerformed(evt);
            }
        });

        jLabel2.setText("Introduce los datos del usuario para agregarlo a la BBDD");

        jLabel3.setText("Nombre de usuario:");

        jLabel4.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(15, 15, 15)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PassCrearUser, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(NombreCrearUser))
                .addGap(18, 18, 18)
                .addComponent(CrearUser)
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(DeleteUser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(ModificarUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(UDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModificarUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreCrearUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PassCrearUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(CrearUser))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearUserActionPerformed
        String nombreNuevoUser = NombreCrearUser.getText();
        String passNuevoUser = String.valueOf(PassCrearUser.getPassword());
        if(!nombreNuevoUser.contains(" ") && nombreNuevoUser.length()>0 && passNuevoUser.length()>0){
            Controlador.crearUser(nombreNuevoUser, passNuevoUser);
            NombreCrearUser.setText("");
            PassCrearUser.setText("");
        }else if(nombreNuevoUser.length()==0){
            JOptionPane.showMessageDialog(null, "No se puede crear un usuario sin nombre. Inserta uno.");
        }else if(passNuevoUser.length()==0){
            JOptionPane.showMessageDialog(null, "No se puede crear un usuario sin contraseña. Inserta una.");
        }else{
            JOptionPane.showMessageDialog(null, "No se pueden usar espacios en el nombre de usuario.");
        }
    }//GEN-LAST:event_CrearUserActionPerformed

    private void DeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteUserActionPerformed
        String nombreUser = UDUser.getText();
        Controlador.deleteUser(nombreUser);
        UDUser.setText("");
    }//GEN-LAST:event_DeleteUserActionPerformed

    private void ModificarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarUserActionPerformed
        String nombreParaModificar = UDUser.getText();
        if(Controlador.comprobarExistenciaUser(nombreParaModificar)){
            ModificarUser modificar = new ModificarUser(nombreParaModificar);
        }
    }//GEN-LAST:event_ModificarUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearUser;
    private javax.swing.JButton DeleteUser;
    private javax.swing.JButton ModificarUser;
    private javax.swing.JTextField NombreCrearUser;
    private javax.swing.JPasswordField PassCrearUser;
    private javax.swing.JTextField UDUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}