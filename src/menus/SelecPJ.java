package menus;


public class SelecPJ extends javax.swing.JPanel {

    Frame1 frame;
    String localPJ = "";

    public SelecPJ(Frame1 frame) {
        initComponents();
        this.frame = frame;

        butMario.setActionCommand("Mario");
        butLuigi.setActionCommand("Luigi");
        butPeach.setActionCommand("Peach");
        butToad.setActionCommand("Toad");
    }

    public String getLocalPJ() {
        return localPJ;
    }
    public void setLocalPJ(String localPJ) {
        this.localPJ = localPJ;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        labelUser1 = new javax.swing.JLabel();
        butMario = new javax.swing.JToggleButton();
        butLuigi = new javax.swing.JToggleButton();
        butPeach = new javax.swing.JToggleButton();
        butToad = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 150, 102));

        labelUser1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser1.setText("User01");

        butMario.setText("Mario\n");
        butMario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMarioActionPerformed(evt);
            }
        });

        butLuigi.setText("Luigi");
        butLuigi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLuigiActionPerformed(evt);
            }
        });

        butPeach.setText("Peach");
        butPeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPeachActionPerformed(evt);
            }
        });

        butToad.setText("Toad");
        butToad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butToadActionPerformed(evt);
            }
        });

        jButton1.setText("Listo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(butLuigi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(butMario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(labelUser1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(butToad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(butPeach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(77, 77, 77))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(butMario)
                                .addGap(34, 34, 34)
                                .addComponent(butLuigi)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(butPeach))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(labelUser1)))
                                .addGap(34, 34, 34)
                                .addComponent(butToad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(19, 19, 19))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void butMarioActionPerformed(java.awt.event.ActionEvent evt) {
        if(!butMario.isSelected()){
            localPJ = "";
        }else{
            if(!localPJ.equals("")){
                switch(localPJ){
                    case "Luigi":
                        butLuigi.setSelected(false);
                        break;
                    case "Peach":
                        butPeach.setSelected(false);
                        break;
                    case "Toad":
                        butToad.setSelected(false);
                        break;
                }
            }
            localPJ = butMario.getActionCommand();
        }
    }

    private void butLuigiActionPerformed(java.awt.event.ActionEvent evt) {
        if(!butLuigi.isSelected()){
            localPJ = "";
        }else{
            if(!localPJ.equals("")){
                switch(localPJ){
                    case "Mario":
                        butMario.setSelected(false);
                        break;
                    case "Peach":
                        butPeach.setSelected(false);
                        break;
                    case "Toad":
                        butToad.setSelected(false);
                        break;
                }
            }
            localPJ = butLuigi.getActionCommand();
        }
    }

    private void butPeachActionPerformed(java.awt.event.ActionEvent evt) {
        if(!butPeach.isSelected()){
            localPJ = "";
        }else{
            if(!localPJ.equals("")){
                switch(localPJ){
                    case "Mario":
                        butMario.setSelected(false);
                        break;
                    case "Luigi":
                        butLuigi.setSelected(false);
                        break;
                    case "Toad":
                        butToad.setSelected(false);
                        break;
                }
            }
            localPJ = butPeach.getActionCommand();
        }
    }

    private void butToadActionPerformed(java.awt.event.ActionEvent evt) {
        if(!butToad.isSelected()){
            localPJ = "";
        }else{
            if(!localPJ.equals("")){
                switch(localPJ){
                    case "Mario":
                        butMario.setSelected(false);
                        break;
                    case "Luigi":
                        butLuigi.setSelected(false);
                        break;
                    case "Peach":
                        butPeach.setSelected(false);
                        break;
                }
            }
            localPJ = butToad.getActionCommand();
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(!localPJ.equals("")){
            frame.cambiarMenuNivel(Frame1.SELECPJ);
            ArchivoUsuario arch = new ArchivoUsuario();
            frame.getUsuario().setpJugadas(frame.getUsuario().getpJugadas() + 1);
            arch.modificarRegistro(frame.getUsuario());
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JToggleButton butLuigi;
    private javax.swing.JToggleButton butMario;
    private javax.swing.JToggleButton butPeach;
    private javax.swing.JToggleButton butToad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelUser1;
    private javax.swing.JLabel jLabel1 = new javax.swing.JLabel() {

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            java.awt.Image image;
            switch(frame.getUsuario().getAvatar()){
                case 0: image = new javax.swing.ImageIcon("res/graficos/icons/iconmario.png").getImage(); break;
                case 1: image = new javax.swing.ImageIcon("res/graficos/icons/iconluigi.jpg").getImage(); break;
                case 2: image = new javax.swing.ImageIcon("res/graficos/icons/iconpeach.jpg").getImage(); break;
                case 3: image = new javax.swing.ImageIcon("res/graficos/icons/icontoad.jpg").getImage(); break;
                default: image = new javax.swing.ImageIcon("res/graficos/icons/imgmario.png").getImage(); break;
            }
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    // End of variables declaration

    public javax.swing.JLabel  getLabelUser1(){
        return labelUser1;
    }
}

