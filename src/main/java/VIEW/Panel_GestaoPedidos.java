
package VIEW;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import CONTROLLER.Pedidos;


public class Panel_GestaoPedidos extends javax.swing.JPanel {
    
    private Tela_Inicial tela;

    public Panel_GestaoPedidos() {
        initComponents();
    }
    
    public Panel_GestaoPedidos(Tela_Inicial tela) {
        this.tela = tela;
        initComponents();
        tela.configurarBotaoEnter(this, botao_PesquisarPedido);  

        Pedidos p = new Pedidos();
        List<Object[]> lista = p.getAllPedidosController();

        String[] dados = tela.searchDataDashboard(lista, "Concluído", "Pendente", "Cancelado", 4, 4, 4);
        texto_NumeroConcluido.setText(dados[0]);
        texto_NumeroPendente.setText(dados[1]);
        texto_NumeroCancelado.setText(dados[2]);

        tela.updateTable(tabela_Pedidos, lista);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_GestaoPedidos = new javax.swing.JPanel();
        texto_Concluidos = new javax.swing.JLabel();
        texto_Pendentes = new javax.swing.JLabel();
        texto_Cancelados = new javax.swing.JLabel();
        texto_NumeroConcluido = new javax.swing.JLabel();
        texto_NumeroPendente = new javax.swing.JLabel();
        texto_NumeroCancelado = new javax.swing.JLabel();
        texto_BuscarPedido = new javax.swing.JLabel();
        campo_PesquisarPedido = new javax.swing.JTextField();
        combobox_FiltroPedido = new javax.swing.JComboBox<>();
        botao_PesquisarPedido = new javax.swing.JButton();
        botao_CadastrarPedido = new javax.swing.JButton();
        botao_AtualizarPedido = new javax.swing.JButton();
        botao_RemoverPedido = new javax.swing.JButton();
        jScrollPane1_Pedidos = new javax.swing.JScrollPane();
        tabela_Pedidos = new javax.swing.JTable();
        linha_SuperiorPedidos = new javax.swing.JSeparator();
        linha_InferiorPedidos = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(920, 640));

        panel_GestaoPedidos.setBackground(new java.awt.Color(250, 250, 250));
        panel_GestaoPedidos.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_Concluidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Concluidos.setText("Concluído:");

        texto_Pendentes.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Pendentes.setText("Pendente:");

        texto_Cancelados.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Cancelados.setText("Cancelado:");

        texto_NumeroConcluido.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroConcluido.setText("0");

        texto_NumeroPendente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroPendente.setText("0");

        texto_NumeroCancelado.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroCancelado.setText("0");

        texto_BuscarPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_BuscarPedido.setText("Buscar");

        campo_PesquisarPedido.setMinimumSize(new java.awt.Dimension(64, 24));
        campo_PesquisarPedido.setPreferredSize(new java.awt.Dimension(64, 24));
        campo_PesquisarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_PesquisarPedidoActionPerformed(evt);
            }
        });

        combobox_FiltroPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem filtro", "Nome do cliente", "CPF", "ID do Cliente", "ID do Pedido" }));
        combobox_FiltroPedido.setMinimumSize(new java.awt.Dimension(72, 24));
        combobox_FiltroPedido.setPreferredSize(new java.awt.Dimension(72, 24));
        combobox_FiltroPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_FiltroPedidoActionPerformed(evt);
            }
        });

        botao_PesquisarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/lupa_azul_21x21_invertida.png"))); 
        botao_PesquisarPedido.setMaximumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarPedido.setMinimumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarPedido.setPreferredSize(new java.awt.Dimension(75, 24));
        botao_PesquisarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarPedidoActionPerformed(evt);
            }
        });

        botao_CadastrarPedido.setBackground(new java.awt.Color(148, 189, 154));
        botao_CadastrarPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_CadastrarPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_CadastrarPedido.setText("Cadastrar");
        botao_CadastrarPedido.setBorder(null);
        botao_CadastrarPedido.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_CadastrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_CadastrarPedidoActionPerformed(evt);
            }
        });

        botao_AtualizarPedido.setBackground(new java.awt.Color(255, 238, 140));
        botao_AtualizarPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_AtualizarPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_AtualizarPedido.setText("Atualizar");
        botao_AtualizarPedido.setBorder(null);
        botao_AtualizarPedido.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_AtualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AtualizarPedidoActionPerformed(evt);
            }
        });

        botao_RemoverPedido.setBackground(new java.awt.Color(255, 164, 114));
        botao_RemoverPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_RemoverPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_RemoverPedido.setText("Remover");
        botao_RemoverPedido.setBorder(null);
        botao_RemoverPedido.setBorderPainted(false);
        botao_RemoverPedido.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_RemoverPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RemoverPedidoActionPerformed(evt);
            }
        });

        tabela_Pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Cliente", "Nome", "Valor_Pedido", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_Pedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1_Pedidos.setViewportView(tabela_Pedidos);
        if (tabela_Pedidos.getColumnModel().getColumnCount() > 0) {
            tabela_Pedidos.getColumnModel().getColumn(0).setResizable(false);
            tabela_Pedidos.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabela_Pedidos.getColumnModel().getColumn(1).setResizable(false);
            tabela_Pedidos.getColumnModel().getColumn(1).setPreferredWidth(110);
            tabela_Pedidos.getColumnModel().getColumn(2).setResizable(false);
            tabela_Pedidos.getColumnModel().getColumn(2).setPreferredWidth(370);
            tabela_Pedidos.getColumnModel().getColumn(3).setResizable(false);
            tabela_Pedidos.getColumnModel().getColumn(3).setPreferredWidth(150);
            tabela_Pedidos.getColumnModel().getColumn(4).setResizable(false);
            tabela_Pedidos.getColumnModel().getColumn(4).setPreferredWidth(154);
        }

        javax.swing.GroupLayout panel_GestaoPedidosLayout = new javax.swing.GroupLayout(panel_GestaoPedidos);
        panel_GestaoPedidos.setLayout(panel_GestaoPedidosLayout);
        panel_GestaoPedidosLayout.setHorizontalGroup(
            panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_GestaoPedidosLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(texto_BuscarPedido)
                .addGap(6, 6, 6)
                .addGroup(panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_GestaoPedidosLayout.createSequentialGroup()
                        .addComponent(texto_Concluidos)
                        .addGap(6, 6, 6)
                        .addComponent(texto_NumeroConcluido)
                        .addGap(168, 168, 168)
                        .addComponent(texto_Pendentes)
                        .addGap(6, 6, 6)
                        .addComponent(texto_NumeroPendente)
                        .addGap(168, 168, 168)
                        .addComponent(texto_Cancelados)
                        .addGap(6, 6, 6)
                        .addComponent(texto_NumeroCancelado))
                    .addGroup(panel_GestaoPedidosLayout.createSequentialGroup()
                        .addComponent(campo_PesquisarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(combobox_FiltroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(botao_PesquisarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_GestaoPedidosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1_Pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(linha_InferiorPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                        .addComponent(linha_SuperiorPedidos))
                    .addGroup(panel_GestaoPedidosLayout.createSequentialGroup()
                        .addComponent(botao_CadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botao_AtualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botao_RemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        panel_GestaoPedidosLayout.setVerticalGroup(
            panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GestaoPedidosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Concluidos)
                    .addComponent(texto_NumeroConcluido)
                    .addComponent(texto_Pendentes)
                    .addComponent(texto_NumeroPendente)
                    .addComponent(texto_Cancelados)
                    .addComponent(texto_NumeroCancelado))
                .addGap(34, 34, 34)
                .addGroup(panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_BuscarPedido)
                    .addGroup(panel_GestaoPedidosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_PesquisarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_FiltroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_PesquisarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addComponent(linha_SuperiorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1_Pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(linha_InferiorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel_GestaoPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_CadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_AtualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_RemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_GestaoPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_GestaoPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_PesquisarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_PesquisarPedidoActionPerformed
    }//GEN-LAST:event_campo_PesquisarPedidoActionPerformed

    private void combobox_FiltroPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_FiltroPedidoActionPerformed
    }//GEN-LAST:event_combobox_FiltroPedidoActionPerformed

    private void botao_PesquisarPedidoActionPerformed(java.awt.event.ActionEvent evt) {
        Pedidos p = new Pedidos(); 
        String filtro = combobox_FiltroPedido.getSelectedItem().toString();
        String valor = campo_PesquisarPedido.getText().trim();
        List<Object[]> lista = p.searchPedidosController(filtro, valor);

        ((DefaultTableModel) tabela_Pedidos.getModel()).setRowCount(0);
        for (Object[] row : lista) {
            ((DefaultTableModel) tabela_Pedidos.getModel()).addRow(row);
        }
    }

    private void botao_CadastrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_CadastrarPedidoActionPerformed
        Panel_CadastrarPedido panel  = new Panel_CadastrarPedido(tela);
        tela.mudar_Panel(panel);        
    }//GEN-LAST:event_botao_CadastrarPedidoActionPerformed

    private void botao_AtualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AtualizarPedidoActionPerformed
         int id = tela.searchCollumn(tabela_Pedidos);
        if (id>0) {
        Panel_AtualizarPedido panel  = new Panel_AtualizarPedido(tela, id);
        tela.mudar_Panel(panel);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_AtualizarPedidoActionPerformed

    private void botao_RemoverPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RemoverPedidoActionPerformed
        int id = tela.searchCollumn(tabela_Pedidos);
        if (id > 0) {
            int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                Pedidos p = new Pedidos();
                p.removePedidoController(id);
                JOptionPane.showMessageDialog(null, "Pedido foi removido com sucesso");
                List<Object[]> lista = p.getAllPedidosController();

                String[] dados = tela.searchDataDashboard(lista, "Concluído", "Pendente", "Cancelado", 4, 4, 4);
                texto_NumeroConcluido.setText(dados[0]);
                texto_NumeroPendente.setText(dados[1]);
                texto_NumeroCancelado.setText(dados[2]);


                tela.updateTable(tabela_Pedidos, lista);
            }
        }

    }//GEN-LAST:event_botao_RemoverPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_AtualizarPedido;
    private javax.swing.JButton botao_CadastrarPedido;
    private javax.swing.JButton botao_PesquisarPedido;
    private javax.swing.JButton botao_RemoverPedido;
    private javax.swing.JTextField campo_PesquisarPedido;
    private javax.swing.JComboBox<String> combobox_FiltroPedido;
    private javax.swing.JScrollPane jScrollPane1_Pedidos;
    private javax.swing.JSeparator linha_InferiorPedidos;
    private javax.swing.JSeparator linha_SuperiorPedidos;
    private javax.swing.JPanel panel_GestaoPedidos;
    private javax.swing.JTable tabela_Pedidos;
    private javax.swing.JLabel texto_BuscarPedido;
    private javax.swing.JLabel texto_Cancelados;
    private javax.swing.JLabel texto_Concluidos;
    private javax.swing.JLabel texto_NumeroCancelado;
    private javax.swing.JLabel texto_NumeroConcluido;
    private javax.swing.JLabel texto_NumeroPendente;
    private javax.swing.JLabel texto_Pendentes;
    // End of variables declaration//GEN-END:variables
}
