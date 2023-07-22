package menus;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import main.*;

public class Frame1 extends JFrame {
    //Atributos
    public static int MENUP = 0, MENUINIC = 1, MENUREG = 2, MENUIP = 3, SELECPJ = 4, STATS = 5, RANKING = 6, AYUDA = 7;
    //static int LV1 = 0, LV2 = 1, LV3 = 2, LV4 = 4;
    private JPanel[] menus;
    //private JPanel nivelAct;
    private Usuario usuario;
    private Juego juego;

    public Frame1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menus = new JPanel[8];
        //nivelAct = null;

        //Localizar paneles de menus
        menus[MENUP] = new MenuP(this);
        menus[MENUINIC] = new MenuIic(this);
        menus[MENUREG] = new MenuReg(this);
        menus[MENUIP] = new MenuIP(this);
        menus[SELECPJ] = new SelecPJ(this);
        menus[STATS] = new Stats(this);
        //menus[RANKING] = new Ranking(this);
        menus[AYUDA] = new Ayuda(this);

        //Empieza en MENUP menu principal
        
        this.add(menus[MENUP],BorderLayout.CENTER);
        menus[MENUP].setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //Metodos
    public void cambiarMenus(int act, int sig){
        menus[act].setVisible(false);
        this.remove(menus[act]);
        this.add(menus[sig],BorderLayout.CENTER);
        menus[sig].setVisible(true);
    }
    
    public void cambiarNiveles(int sig){
        //nivelAct.setVisible(false);
        //this.remove(nivelAct);

        switch (sig){
            case 1:
                //nivelAct = new lvl1();
                break;
            case 2:
                //nivelAct = new lvl2();
                break;
            case 3:
                //nivelAct = new lvl3();
                break;
            case 4:
                //nivelAct = new lvl4();
                break;
        }
        //this.add(nivelAct,BorderLayout.CENTER);
        //nivelAct.setVisible(true);
    }
    
    public void cambiarMenuNivel(int act){
        menus[act].setVisible(false);
        //this.remove(menus[act]);
        this.setVisible(false);
        if (juego == null)
            juego = new Juego(((SelecPJ)(menus[act])).getLocalPJ(), this);
        else
            juego.reset(((SelecPJ)(menus[act])).getLocalPJ());
        //this.add(nivelAct,BorderLayout.CENTER);
        //nivelAct.setVisible(true);
    }
    
    //Sets y Gets
    public JPanel[] getMenus() {
        return menus;
    }
    public void setMenus(JPanel[] menus) {
        this.menus = menus;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public Juego getJuego(){return juego;}
    public void setJuego(Juego juego){this.juego = juego;}
}
