/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import controller.ConsultaPorEstados;
import controller.EquipoData;
import controller.EquipoMiembroData;
import controller.MiembroData;
import controller.ProyectoData;
import controller.TareaData;
import javax.swing.JFrame;

/**
 *
 * @author juany
 */
public class Principal extends javax.swing.JFrame {

    ProyectoData pd = new ProyectoData();
    EquipoData ed = new EquipoData();
    EquipoMiembroData emd = new EquipoMiembroData();
    TareaData td = new TareaData();
    MiembroData md = new MiembroData();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        toggleButtons();
        
    }
    
    public void toggleButtons(){
        if (pd.listarProyectos().isEmpty()) {
            this.btnProyectos2.setEnabled(false);
        }else{
            this.btnProyectos2.setEnabled(true);
        }

        if (pd.listarProyectos().isEmpty() || emd.listarEquipoMiembro().isEmpty()) {
            this.btnProyectos4.setEnabled(false);
        }else{
            this.btnProyectos4.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        btnProyectos = new javax.swing.JButton();
        btnProyectos1 = new javax.swing.JButton();
        btnProyectos2 = new javax.swing.JButton();
        btnProyectos3 = new javax.swing.JButton();
        btnProyectos4 = new javax.swing.JButton();
        btnProyectos5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        btnProyectos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/189-tree.png"))); // NOI18N
        btnProyectos.setText("Proyectos");
        btnProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectosActionPerformed(evt);
            }
        });

        btnProyectos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/118-user-check.png"))); // NOI18N
        btnProyectos1.setText("Miembros");
        btnProyectos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos1ActionPerformed(evt);
            }
        });

        btnProyectos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/115-users.png"))); // NOI18N
        btnProyectos2.setText("Equipos");
        btnProyectos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos2ActionPerformed(evt);
            }
        });

        btnProyectos3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/157-stats-bars.png"))); // NOI18N
        btnProyectos3.setText("General");
        btnProyectos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos3ActionPerformed(evt);
            }
        });

        btnProyectos4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/186-list-numbered.png"))); // NOI18N
        btnProyectos4.setText("Tareas");
        btnProyectos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos4ActionPerformed(evt);
            }
        });

        btnProyectos5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/exit.png"))); // NOI18N
        btnProyectos5.setText("Salir");
        btnProyectos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProyectos5ActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProyectos3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProyectos1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProyectos2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProyectos4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProyectos5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(escritorio))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProyectos3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProyectos2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProyectos4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProyectos1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProyectos5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProyectos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos3ActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        ViewGeneral vg = new ViewGeneral();
        vg.setVisible(true);
        escritorio.add(vg);
        escritorio.moveToFront(vg);
    }//GEN-LAST:event_btnProyectos3ActionPerformed

    private void btnProyectos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos4ActionPerformed
        // TODO add your handling code here:
        ViewTarea vt = new ViewTarea();
        vt.setVisible(true);

        escritorio.removeAll();
        escritorio.repaint();

        escritorio.add(vt);
        escritorio.moveToFront(vt);
    }//GEN-LAST:event_btnProyectos4ActionPerformed

    private void btnProyectos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnProyectos5ActionPerformed

    private void btnProyectos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos2ActionPerformed
        // TODO add your handling code here:
        ViewEquipo ve = new ViewEquipo(this);
        ve.setVisible(true);
        escritorio.removeAll();
        escritorio.repaint();
        escritorio.add(ve);
        escritorio.moveToFront(ve);
    }//GEN-LAST:event_btnProyectos2ActionPerformed

    private void btnProyectos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectos1ActionPerformed
        // TODO add your handling code here:
        ViewMiembro vm = new ViewMiembro();
        vm.setVisible(true);
        escritorio.removeAll();
        escritorio.repaint();

        escritorio.add(vm);
        escritorio.moveToFront(vm);
    }//GEN-LAST:event_btnProyectos1ActionPerformed

    private void btnProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProyectosActionPerformed
        ViewProyecto vp = new ViewProyecto(this);
        vp.setVisible(true);
        escritorio.removeAll();
        escritorio.repaint();
        escritorio.add(vp);
        escritorio.moveToFront(vp);
    }//GEN-LAST:event_btnProyectosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProyectos;
    private javax.swing.JButton btnProyectos1;
    private javax.swing.JButton btnProyectos2;
    private javax.swing.JButton btnProyectos3;
    private javax.swing.JButton btnProyectos4;
    private javax.swing.JButton btnProyectos5;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
