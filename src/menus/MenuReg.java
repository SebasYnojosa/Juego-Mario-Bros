package menus;

public class MenuReg extends javax.swing.JPanel {

    //Atributos
    Frame1 frame;
    ArchivoUsuario arch = new ArchivoUsuario();
    
    public MenuReg(Frame1 frame) {
        initComponents();
        this.frame = frame;
        errNombre.setVisible(false);
        errConf.setVisible(false);
        errRelleno.setVisible(false);
        
        radioLuigi.setActionCommand("Luigi");
        radioMario.setActionCommand("Mario");
        radioPeach.setActionCommand("Peach");
        radioToad.setActionCommand("Toad");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        txtNomb = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCorr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        radioMario = new javax.swing.JRadioButton();
        radioLuigi = new javax.swing.JRadioButton();
        radioPeach = new javax.swing.JRadioButton();
        radioToad = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        errNombre = new javax.swing.JLabel();
        errConf = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        txtConfContra = new javax.swing.JPasswordField();
        errRelleno = new javax.swing.JLabel();

        jLabel1.setText("Nombre");

        jLabel2.setText("Correo");

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Confirmar Contraseña");

        buttonGroup.add(radioMario);
        radioMario.setText("Mario");

        buttonGroup.add(radioLuigi);
        radioLuigi.setText("Luigi");

        buttonGroup.add(radioPeach);
        radioPeach.setText("Peach");

        buttonGroup.add(radioToad);
        radioToad.setText("Toad");

        jButton1.setText("Listo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        errNombre.setText("Nombre tomado ");

        errConf.setText("No coinciden");

        errRelleno.setText("Rellenar todo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addComponent(txtNomb)
                        .addComponent(jLabel1))
                    .addComponent(radioToad)
                    .addComponent(radioPeach)
                    .addComponent(radioMario)
                    .addComponent(radioLuigi)
                    .addComponent(errNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(txtCorr, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errConf)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtConfContra, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtContra, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(errRelleno))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(errNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioMario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioLuigi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioPeach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioToad))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtConfContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errConf)
                        .addGap(11, 11, 11)
                        .addComponent(errRelleno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frame.cambiarMenus(Frame1.MENUREG, Frame1.MENUINIC);
        errNombre.setVisible(false);
        errConf.setVisible(false);
        errRelleno.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Usuario user = new Usuario(txtNomb.getText(),txtUser.getText(),txtCorr.getText(),txtContra.getText(),0);
        if (buttonGroup.getSelection() == null){
            errNombre.setVisible(false);
            errConf.setVisible(false);
            errRelleno.setVisible(true);
            return;
        }else{
            switch (buttonGroup.getSelection().getActionCommand()) {
                case "Mario" -> user.setAvatar(0);
                case "Luigi" -> user.setAvatar(1);
                case "Peach" -> user.setAvatar(2);
                case "Toad" -> user.setAvatar(3);
            }
        }
        if("".equals(user.getNombre()) || "".equals(user.getCorreo()) || "".equals(user.getUsuario()) || "".equals(user.getContra()) || "".equals(txtConfContra.getText())){
            errNombre.setVisible(false);
            errConf.setVisible(false);
            errRelleno.setVisible(true);
        }else{
            arch.abrirArchivoLectura();
            if(arch.buscarRegistro(user.getUsuario()) != null){
                errNombre.setVisible(true);
                errConf.setVisible(false);
                errRelleno.setVisible(false);
                return;
            }else if(!user.getContra().equals(txtConfContra.getText())){
                errNombre.setVisible(false);
                errConf.setVisible(true);
                errRelleno.setVisible(false);
                return;
            }

            arch.appendRegitros(user);
            
            txtNomb.setText("");
            txtUser.setText("");
            txtCorr.setText("");
            txtContra.setText("");
            txtConfContra.setText("");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel errConf;
    private javax.swing.JLabel errNombre;
    private javax.swing.JLabel errRelleno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton radioLuigi;
    private javax.swing.JRadioButton radioMario;
    private javax.swing.JRadioButton radioPeach;
    private javax.swing.JRadioButton radioToad;
    private javax.swing.JPasswordField txtConfContra;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtCorr;
    private javax.swing.JTextField txtNomb;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
