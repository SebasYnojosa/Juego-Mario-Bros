package menus;

import javax.swing.JLabel;

public class Stats extends javax.swing.JPanel {

    Frame1 frame;

    public Stats(Frame1 frame) {
        initComponents();
        this.frame = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelPJ = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelPG = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelPP = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelPA = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 150, 102));

        labelNombre.setBackground(new java.awt.Color(255, 255, 255));
        labelNombre.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labelNombre.setText("Usuario 0");

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel1.setText("Partidas Jugadas:");

        labelPJ.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labelPJ.setText("00");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel2.setText("Partidas Ganadas:");

        labelPG.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labelPG.setText("00");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel3.setText("Partidas Perdidas:");

        labelPP.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labelPP.setText("00");

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setText("Partidas Abandonadas:");

        labelPA.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labelPA.setText("00");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(24, 24, 24))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(labelPA))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel1)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jLabel3))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(labelNombre)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelPJ)
                                                        .addComponent(labelPG, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(labelPP))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addComponent(labelNombre))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(labelPJ))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(labelPG)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(labelPP))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(labelPA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        frame.cambiarMenus(Frame1.STATS, Frame1.MENUIP);
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPA;
    private javax.swing.JLabel labelPG;
    private javax.swing.JLabel labelPJ;
    private javax.swing.JLabel labelPP;

    private javax.swing.JLabel jLabel5 = new javax.swing.JLabel() {
        java.awt.Image image;
        {
            image = new javax.swing.ImageIcon("res/graficos/icons/imglario.png").getImage();
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    private javax.swing.JLabel jLabel6 = new javax.swing.JLabel() {

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

    public JLabel getLabelPA() {
        return labelPA;
    }
    public JLabel getLabelPG() {
        return labelPG;
    }
    public JLabel getLabelPJ() {
        return labelPJ;
    }
    public JLabel getLabelPP() {
        return labelPP;
    }
    public JLabel getLabelNombre() {
        return labelNombre;
    }
    public JLabel getLabelicon(){return jLabel6;}
}