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
        labelUser2 = new javax.swing.JLabel();
        labelUser3 = new javax.swing.JLabel();
        labelUser4 = new javax.swing.JLabel();
        butMario = new javax.swing.JToggleButton();
        butLuigi = new javax.swing.JToggleButton();
        butPeach = new javax.swing.JToggleButton();
        butToad = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        labelUser1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser1.setText("User01");

        labelUser2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser2.setText("User02");

        labelUser3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser3.setText("User03");

        labelUser4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser4.setText("User04");

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
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labelUser1)
                                                                        .addComponent(labelUser2))
                                                                .addGap(176, 176, 176)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(butLuigi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(butMario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labelUser3)
                                                                        .addComponent(labelUser4))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(butToad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(butPeach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(59, 59, 59))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(223, 223, 223)
                                                .addComponent(jButton1)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelUser1)
                                        .addComponent(butMario))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelUser2)
                                        .addComponent(butLuigi))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelUser3)
                                        .addComponent(butPeach))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelUser4)
                                        .addComponent(butToad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(19, 19, 19))
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
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JToggleButton butLuigi;
    private javax.swing.JToggleButton butMario;
    private javax.swing.JToggleButton butPeach;
    private javax.swing.JToggleButton butToad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelUser1;
    private javax.swing.JLabel labelUser2;
    private javax.swing.JLabel labelUser3;
    private javax.swing.JLabel labelUser4;
    // End of variables declaration

    public javax.swing.JLabel  getLabelUser1(){
        return labelUser1;
    }

    public javax.swing.JLabel  getLabelUser2(){
        return labelUser2;
    }

    public javax.swing.JLabel  getLabelUser3(){
        return labelUser3;
    }

    public javax.swing.JLabel  getLabelUser4(){
        return labelUser3;
    }
}

