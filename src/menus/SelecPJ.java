package menus;


public class SelecPJ extends javax.swing.JPanel {


    public SelecPJ() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUser1 = new javax.swing.JLabel();
        labelUser2 = new javax.swing.JLabel();
        labelUser3 = new javax.swing.JLabel();
        labelUser4 = new javax.swing.JLabel();
        butMario = new javax.swing.JToggleButton();
        butLuigi = new javax.swing.JToggleButton();
        butPeach = new javax.swing.JToggleButton();
        butToad = new javax.swing.JToggleButton();

        labelUser1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser1.setText("User01");

        labelUser2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser2.setText("User02");

        labelUser3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser3.setText("User03");

        labelUser4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        labelUser4.setText("User04");

        butMario.setText("Mario\n");

        butLuigi.setText("Luigi");

        butPeach.setText("Peach");

        butToad.setText("Toad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
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
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton butLuigi;
    private javax.swing.JToggleButton butMario;
    private javax.swing.JToggleButton butPeach;
    private javax.swing.JToggleButton butToad;
    private javax.swing.JLabel labelUser1;
    private javax.swing.JLabel labelUser2;
    private javax.swing.JLabel labelUser3;
    private javax.swing.JLabel labelUser4;
    // End of variables declaration//GEN-END:variables
}
