package menus;

public class MenuIP extends javax.swing.JPanel {

    //Atributos
    Frame1 frame;

    public MenuIP(Frame1 frame) {
        initComponents();
        this.frame = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 150, 102));

        jButton1.setText("Play");
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

        jButton3.setText("Stats");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("");

        jLabel2.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52))
        );
    }// </editor-fold>

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        frame.cambiarMenus(Frame1.MENUIP, Frame1.MENUINIC);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        frame.cambiarMenus(Frame1.MENUIP, Frame1.STATS);
        ((Stats)(frame.getMenus()[Frame1.STATS])).getLabelNombre().setText(frame.getUsuario().getNombre());
        ((Stats)(frame.getMenus()[Frame1.STATS])).getLabelPJ().setText(((Integer)frame.getUsuario().getpJugadas()).toString());
        ((Stats)(frame.getMenus()[Frame1.STATS])).getLabelPG().setText(((Integer)frame.getUsuario().getpGanadas()).toString());
        ((Stats)(frame.getMenus()[Frame1.STATS])).getLabelPP().setText(((Integer)frame.getUsuario().getpPerdidas()).toString());
        ((Stats)(frame.getMenus()[Frame1.STATS])).getLabelPA().setText(((Integer)frame.getUsuario().getpAbandonadas()).toString());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        frame.cambiarMenus(Frame1.MENUIP, Frame1.SELECPJ);
        ((SelecPJ)(frame.getMenus()[Frame1.SELECPJ])).getLabelUser1().setText(frame.getUsuario().getNombre());
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1 = new javax.swing.JLabel() {
        java.awt.Image image;
        {
            image = new javax.swing.ImageIcon("res/graficos/icons/imgcuigi.png").getImage();
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    private javax.swing.JLabel jLabel2 = new javax.swing.JLabel() {
        java.awt.Image image;
        {
            image = new javax.swing.ImageIcon("res/graficos/icons/imgcario.png").getImage();
        }

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    // End of variables declaration
}
