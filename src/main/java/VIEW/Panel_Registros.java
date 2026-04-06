
package VIEW;

public class Panel_Registros extends javax.swing.JPanel {
    
    private Tela_Inicial tela;


    public Panel_Registros() {
        initComponents();
    }
    
    public Panel_Registros(Tela_Inicial tela) { 
        this.tela = tela;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_fundoRegistros = new javax.swing.JPanel();
        botao_RegistrosdeProdutos = new javax.swing.JButton();
        botao_RegistrosdePedidos = new javax.swing.JButton();
        linha_SuperiorRegistros = new javax.swing.JSeparator();
        linha_InferiorRegistros = new javax.swing.JSeparator();

        panel_fundoRegistros.setBackground(new java.awt.Color(250, 250, 250));
        panel_fundoRegistros.setPreferredSize(new java.awt.Dimension(920, 640));

        botao_RegistrosdeProdutos.setBackground(new java.awt.Color(150, 215, 235));
        botao_RegistrosdeProdutos.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        botao_RegistrosdeProdutos.setForeground(new java.awt.Color(255, 255, 255));
        botao_RegistrosdeProdutos.setText("Registros de Produtos");
        botao_RegistrosdeProdutos.setActionCommand("Registro de Produtos\n");
        botao_RegistrosdeProdutos.setPreferredSize(new java.awt.Dimension(600, 100));
        botao_RegistrosdeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RegistrosdeProdutosActionPerformed(evt);
            }
        });

        botao_RegistrosdePedidos.setBackground(new java.awt.Color(150, 215, 235));
        botao_RegistrosdePedidos.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        botao_RegistrosdePedidos.setForeground(new java.awt.Color(255, 255, 255));
        botao_RegistrosdePedidos.setText("Registros de Pedidos");
        botao_RegistrosdePedidos.setPreferredSize(new java.awt.Dimension(600, 100));
        botao_RegistrosdePedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RegistrosdePedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_fundoRegistrosLayout = new javax.swing.GroupLayout(panel_fundoRegistros);
        panel_fundoRegistros.setLayout(panel_fundoRegistrosLayout);
        panel_fundoRegistrosLayout.setHorizontalGroup(
            panel_fundoRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fundoRegistrosLayout.createSequentialGroup()
                .addGroup(panel_fundoRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(linha_InferiorRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_fundoRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panel_fundoRegistrosLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(linha_SuperiorRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_fundoRegistrosLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addGroup(panel_fundoRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(botao_RegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botao_RegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        panel_fundoRegistrosLayout.setVerticalGroup(
            panel_fundoRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fundoRegistrosLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(linha_SuperiorRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botao_RegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botao_RegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(linha_InferiorRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_fundoRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_fundoRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botao_RegistrosdeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RegistrosdeProdutosActionPerformed
       Panel_RegistrosdeProdutos panel  = new Panel_RegistrosdeProdutos(tela);
       tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_RegistrosdeProdutosActionPerformed

    private void botao_RegistrosdePedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RegistrosdePedidosActionPerformed
       Panel_RegistrosdePedidos panel  = new Panel_RegistrosdePedidos(tela);
       tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_RegistrosdePedidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_RegistrosdePedidos;
    private javax.swing.JButton botao_RegistrosdeProdutos;
    private javax.swing.JSeparator linha_InferiorRegistros;
    private javax.swing.JSeparator linha_SuperiorRegistros;
    private javax.swing.JPanel panel_fundoRegistros;
    // End of variables declaration//GEN-END:variables
}
