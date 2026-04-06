
package VIEW;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import CONTROLLER.Registros;

public class Panel_RegistrosdePedidos extends javax.swing.JPanel {
    
    private Tela_Inicial tela;

    public Panel_RegistrosdePedidos() {
        initComponents();
    }

    public Panel_RegistrosdePedidos(Tela_Inicial tela) { 
        this.tela = tela;
        initComponents();
        tela.configurarBotaoEnter(this, botao_PesquisarRegistrosdePedidos);  
        Registros r = new Registros();
        List<Object[]> lista = r.getAllRegistrosPedidosController();

        tela.updateTable(tabela_RegistrosdePedidos, lista);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_RegistrosdePedidos = new javax.swing.JPanel();
        linha_SuperiorRegistrosdePedidos = new javax.swing.JSeparator();
        texto_BuscarRegistrosdePedidos = new javax.swing.JLabel();
        campo_PesquisarRegistrosdePedidos = new javax.swing.JTextField();
        combobox_FiltroRegistrosdePedidos = new javax.swing.JComboBox<>();
        botao_PesquisarRegistrosdePedidos = new javax.swing.JButton();
        linha_InferiorRegistrosdePedidos = new javax.swing.JSeparator();
        botao_RemoverRegistrosdePedidos = new javax.swing.JButton();
        texto_RegistrosdePedidos = new javax.swing.JLabel();
        botao_VoltarRegistrosdePedidos = new javax.swing.JButton();
        jScrollPane1_RegistrosdePedidos = new javax.swing.JScrollPane();
        tabela_RegistrosdePedidos = new javax.swing.JTable();

        panel_RegistrosdePedidos.setBackground(new java.awt.Color(250, 250, 250));
        panel_RegistrosdePedidos.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_BuscarRegistrosdePedidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_BuscarRegistrosdePedidos.setText("Buscar");

        campo_PesquisarRegistrosdePedidos.setMinimumSize(new java.awt.Dimension(64, 24));
        campo_PesquisarRegistrosdePedidos.setPreferredSize(new java.awt.Dimension(64, 24));
        campo_PesquisarRegistrosdePedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_PesquisarRegistrosdePedidosActionPerformed(evt);
            }
        });

        combobox_FiltroRegistrosdePedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem filtro", "Nome do cliente", "CPF", "ID do Cliente", "ID do Pedido" }));
        combobox_FiltroRegistrosdePedidos.setMinimumSize(new java.awt.Dimension(72, 24));
        combobox_FiltroRegistrosdePedidos.setPreferredSize(new java.awt.Dimension(72, 24));
        combobox_FiltroRegistrosdePedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_FiltroRegistrosdePedidosActionPerformed(evt);
            }
        });

        botao_PesquisarRegistrosdePedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/lupa_azul_21x21_invertida.png"))); 
        botao_PesquisarRegistrosdePedidos.setMaximumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarRegistrosdePedidos.setMinimumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarRegistrosdePedidos.setPreferredSize(new java.awt.Dimension(75, 24));
        botao_PesquisarRegistrosdePedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarRegistrosPedidosActionPerformed(evt);
            }
        });

        botao_RemoverRegistrosdePedidos.setBackground(new java.awt.Color(255, 164, 114));
        botao_RemoverRegistrosdePedidos.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_RemoverRegistrosdePedidos.setForeground(new java.awt.Color(255, 255, 255));
        botao_RemoverRegistrosdePedidos.setText("Remover");
        botao_RemoverRegistrosdePedidos.setBorder(null);
        botao_RemoverRegistrosdePedidos.setBorderPainted(false);
        botao_RemoverRegistrosdePedidos.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_RemoverRegistrosdePedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RemoverRegistrosdePedidosActionPerformed(evt);
            }
        });

        texto_RegistrosdePedidos.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        texto_RegistrosdePedidos.setText("Registros de Pedidos");

        botao_VoltarRegistrosdePedidos.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarRegistrosdePedidos.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarRegistrosdePedidos.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarRegistrosdePedidos.setText("Voltar");
        botao_VoltarRegistrosdePedidos.setBorder(null);
        botao_VoltarRegistrosdePedidos.setBorderPainted(false);
        botao_VoltarRegistrosdePedidos.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_VoltarRegistrosdePedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarRegistrosdePedidosActionPerformed(evt);
            }
        });

        tabela_RegistrosdePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Cliente", "ID_Pedido", "Nome", "Valor_Pedido", "Situação", "Data_Hora", "Condição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_RegistrosdePedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1_RegistrosdePedidos.setViewportView(tabela_RegistrosdePedidos);
        if (tabela_RegistrosdePedidos.getColumnModel().getColumnCount() > 0) {
            tabela_RegistrosdePedidos.getColumnModel().getColumn(0).setResizable(false);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(1).setResizable(false);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(2).setResizable(false);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(2).setPreferredWidth(80);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(3).setResizable(false);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(4).setResizable(false);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(5).setResizable(false);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(6).setResizable(false);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(6).setPreferredWidth(150);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(7).setResizable(false);
            tabela_RegistrosdePedidos.getColumnModel().getColumn(7).setPreferredWidth(84);
        }

        javax.swing.GroupLayout panel_RegistrosdePedidosLayout = new javax.swing.GroupLayout(panel_RegistrosdePedidos);
        panel_RegistrosdePedidos.setLayout(panel_RegistrosdePedidosLayout);
        panel_RegistrosdePedidosLayout.setHorizontalGroup(
            panel_RegistrosdePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistrosdePedidosLayout.createSequentialGroup()
                .addGroup(panel_RegistrosdePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_RegistrosdePedidosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panel_RegistrosdePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(linha_InferiorRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_SuperiorRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_RegistrosdePedidosLayout.createSequentialGroup()
                                .addComponent(botao_VoltarRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botao_RemoverRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1_RegistrosdePedidos)))
                    .addGroup(panel_RegistrosdePedidosLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(panel_RegistrosdePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_RegistrosdePedidosLayout.createSequentialGroup()
                                .addComponent(texto_BuscarRegistrosdePedidos)
                                .addGap(6, 6, 6)
                                .addComponent(campo_PesquisarRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(combobox_FiltroRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(botao_PesquisarRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RegistrosdePedidosLayout.createSequentialGroup()
                                .addComponent(texto_RegistrosdePedidos)
                                .addGap(276, 276, 276)))))
                .addGap(38, 38, 38))
        );
        panel_RegistrosdePedidosLayout.setVerticalGroup(
            panel_RegistrosdePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistrosdePedidosLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(texto_RegistrosdePedidos)
                .addGap(18, 18, 18)
                .addGroup(panel_RegistrosdePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_BuscarRegistrosdePedidos)
                    .addGroup(panel_RegistrosdePedidosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panel_RegistrosdePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_PesquisarRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_FiltroRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_PesquisarRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linha_SuperiorRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1_RegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linha_InferiorRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(panel_RegistrosdePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_RemoverRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_VoltarRegistrosdePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_RegistrosdePedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_RegistrosdePedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_PesquisarRegistrosdePedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_PesquisarRegistrosdePedidosActionPerformed
    }//GEN-LAST:event_campo_PesquisarRegistrosdePedidosActionPerformed

    private void combobox_FiltroRegistrosdePedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_FiltroRegistrosdePedidosActionPerformed
    }//GEN-LAST:event_combobox_FiltroRegistrosdePedidosActionPerformed

    private void botao_PesquisarRegistrosPedidosActionPerformed(java.awt.event.ActionEvent evt) {                                                            
      Registros r = new Registros(); 
      String filtro = combobox_FiltroRegistrosdePedidos.getSelectedItem().toString();
      String valor = campo_PesquisarRegistrosdePedidos.getText().trim();
      List<Object[]> lista = r.searchRegistrosPedidosController(filtro,valor);
        ((DefaultTableModel) tabela_RegistrosdePedidos.getModel()).setRowCount(0);
        for (Object[] row : lista) {
        ((DefaultTableModel) tabela_RegistrosdePedidos.getModel()).addRow(row);
    }
    }

    private void botao_RemoverRegistrosdePedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RemoverRegistrosdePedidosActionPerformed
              int id = tela.searchCollumn(tabela_RegistrosdePedidos);
      if (id>0) {
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
        Registros r = new Registros();
        r.removeRegistroPedidoController(id);
        List<Object[]> lista = r.getAllRegistrosPedidosController();
        
        tela.updateTable(tabela_RegistrosdePedidos, lista);
        }

        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um registro da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_RemoverRegistrosdePedidosActionPerformed

    private void botao_VoltarRegistrosdePedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarRegistrosdePedidosActionPerformed
       Panel_Registros panel  = new Panel_Registros(tela);
       tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_VoltarRegistrosdePedidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_PesquisarRegistrosdePedidos;
    private javax.swing.JButton botao_RemoverRegistrosdePedidos;
    private javax.swing.JButton botao_VoltarRegistrosdePedidos;
    private javax.swing.JTextField campo_PesquisarRegistrosdePedidos;
    private javax.swing.JComboBox<String> combobox_FiltroRegistrosdePedidos;
    private javax.swing.JScrollPane jScrollPane1_RegistrosdePedidos;
    private javax.swing.JSeparator linha_InferiorRegistrosdePedidos;
    private javax.swing.JSeparator linha_SuperiorRegistrosdePedidos;
    private javax.swing.JPanel panel_RegistrosdePedidos;
    private javax.swing.JTable tabela_RegistrosdePedidos;
    private javax.swing.JLabel texto_BuscarRegistrosdePedidos;
    private javax.swing.JLabel texto_RegistrosdePedidos;
    // End of variables declaration//GEN-END:variables
}
