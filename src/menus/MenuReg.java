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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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

        setBackground(new java.awt.Color(255, 150, 102));

        jLabel1.setText("Nombre");

        jLabel2.setText("Correo");

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Confirmar Contraseña");

        buttonGroup.add(radioMario);

        buttonGroup.add(radioLuigi);

        buttonGroup.add(radioPeach);

        buttonGroup.add(radioToad);

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

        labelMario.setToolTipText("");

        labelLuigi.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(errNombre)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel3)
                                                .addComponent(txtUser)
                                                .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(radioMario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(radioPeach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelMario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelPeach, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(radioToad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(radioLuigi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelLuigi, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                                        .addComponent(labelToad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(txtCorr, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(txtConfContra, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtContra, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)))
                                                                .addGap(65, 65, 65))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(errConf)
                                                                        .addComponent(errRelleno))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton2)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCorr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addGap(4, 4, 4)
                                                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtConfContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(errConf)
                                                                .addGap(11, 11, 11)
                                                                .addComponent(errRelleno)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton2)
                                                                        .addComponent(jButton1)))
                                                        .addComponent(radioToad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelToad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addGap(4, 4, 4)
                                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(errNombre)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(labelLuigi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(radioLuigi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labelMario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(radioMario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(radioPeach, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                                        .addComponent(labelPeach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(29, 29, 29))
        );
    }// </editor-fold>

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

    private javax.swing.JLabel labelLuigi = new javax.swing.JLabel() {
        java.awt.Image image;
        {
            image = new javax.swing.ImageIcon("res/graficos/icons/iconluigi.jpg").getImage();
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    private javax.swing.JLabel labelMario = new javax.swing.JLabel() {
        java.awt.Image image;
        {
            image = new javax.swing.ImageIcon("res/graficos/icons/iconmario.png").getImage();
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    private javax.swing.JLabel labelPeach = new javax.swing.JLabel() {
        java.awt.Image image;
        {
            image = new javax.swing.ImageIcon("res/graficos/icons/iconpeach.jpg").getImage();
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    private javax.swing.JLabel labelToad = new javax.swing.JLabel() {
        java.awt.Image image;
        {
            image = new javax.swing.ImageIcon("res/graficos/icons/icontoad.jpg").getImage();
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    // End of variables declaration//GEN-END:variables
}
