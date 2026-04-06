
package VIEW;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import CONTROLLER.Clientes;



public class Panel_GestaoClientes extends javax.swing.JPanel {
    
    private Tela_Inicial tela;
 
    public Panel_GestaoClientes() {
        initComponents();
    }
    
    public Panel_GestaoClientes(Tela_Inicial tela) { 
        this.tela = tela;
        initComponents();
        tela.configurarBotaoEnter(this, botao_PesquisarCliente);  
        Clientes c = new Clientes();
        List<Object[]> lista = c.getAllClientesController();
        
        String[] dados = tela.searchDataDashboard(lista, "id","Ativo","Inativo",0 ,7 ,7 );
        texto_NumeroClientes.setText(dados[0]);
        texto_NumeroAtivos.setText(dados[1]);
        texto_NumeroInativos.setText(dados[2]);
        
        tela.updateTable(tabela_Clientes, lista);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_GestaoCliente = new javax.swing.JPanel();
        texto_Clientes = new javax.swing.JLabel();
        texto_Ativos = new javax.swing.JLabel();
        texto_Inativos = new javax.swing.JLabel();
        texto_NumeroClientes = new javax.swing.JLabel();
        texto_NumeroAtivos = new javax.swing.JLabel();
        texto_NumeroInativos = new javax.swing.JLabel();
        texto_BuscarCliente = new javax.swing.JLabel();
        campo_PesquisarCliente = new javax.swing.JTextField();
        combobox_FiltroCliente = new javax.swing.JComboBox<>();
        botao_PesquisarCliente = new javax.swing.JButton();
        botao_CadastrarCliente = new javax.swing.JButton();
        botao_AtualizarCliente = new javax.swing.JButton();
        botao_RemoverCliente = new javax.swing.JButton();
        linha_InferiorClientes = new javax.swing.JSeparator();
        jScrollPane1_Clientes = new javax.swing.JScrollPane();
        tabela_Clientes = new javax.swing.JTable();
        linha_SuperiorClientes = new javax.swing.JSeparator();

        panel_GestaoCliente.setBackground(new java.awt.Color(250, 250, 250));
        panel_GestaoCliente.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_Clientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Clientes.setText("Clientes:");

        texto_Ativos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Ativos.setText("Ativos: ");

        texto_Inativos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Inativos.setText("Inativos: ");

        texto_NumeroClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroClientes.setText("0");

        texto_NumeroAtivos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroAtivos.setText("0");

        texto_NumeroInativos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroInativos.setText("0");

        texto_BuscarCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_BuscarCliente.setText("Buscar");

        campo_PesquisarCliente.setMinimumSize(new java.awt.Dimension(64, 24));
        campo_PesquisarCliente.setPreferredSize(new java.awt.Dimension(64, 24));
        campo_PesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_PesquisarClienteActionPerformed(evt);
            }
        });

        combobox_FiltroCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem filtro", "Nome", "CPF", "ID" }));
        combobox_FiltroCliente.setMinimumSize(new java.awt.Dimension(72, 24));
        combobox_FiltroCliente.setPreferredSize(new java.awt.Dimension(72, 24));
        combobox_FiltroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_FiltroClienteActionPerformed(evt);
            }
        });

        botao_PesquisarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/lupa_azul_21x21_invertida.png"))); 
        botao_PesquisarCliente.setMaximumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarCliente.setMinimumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarCliente.setPreferredSize(new java.awt.Dimension(75, 24));
        botao_PesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarClienteActionPerformed(evt);
            }
        });

        botao_CadastrarCliente.setBackground(new java.awt.Color(148, 189, 154));
        botao_CadastrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_CadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botao_CadastrarCliente.setText("Cadastrar");
        botao_CadastrarCliente.setBorder(null);
        botao_CadastrarCliente.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_CadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_CadastrarClienteActionPerformed(evt);
            }
        });

        botao_AtualizarCliente.setBackground(new java.awt.Color(255, 238, 140));
        botao_AtualizarCliente.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_AtualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botao_AtualizarCliente.setText("Atualizar");
        botao_AtualizarCliente.setBorder(null);
        botao_AtualizarCliente.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_AtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AtualizarClienteActionPerformed(evt);
            }
        });

        botao_RemoverCliente.setBackground(new java.awt.Color(255, 164, 114));
        botao_RemoverCliente.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_RemoverCliente.setForeground(new java.awt.Color(255, 255, 255));
        botao_RemoverCliente.setText("Remover");
        botao_RemoverCliente.setBorder(null);
        botao_RemoverCliente.setBorderPainted(false);
        botao_RemoverCliente.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_RemoverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RemoverClienteActionPerformed(evt);
            }
        });

        tabela_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Data_Nascimento", "CEP", "Telefone", "E-mail", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabela_Clientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1_Clientes.setViewportView(tabela_Clientes);
        if (tabela_Clientes.getColumnModel().getColumnCount() > 0) {
            tabela_Clientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela_Clientes.getColumnModel().getColumn(1).setResizable(false);
            tabela_Clientes.getColumnModel().getColumn(1).setPreferredWidth(180);
            tabela_Clientes.getColumnModel().getColumn(2).setResizable(false);
            tabela_Clientes.getColumnModel().getColumn(2).setPreferredWidth(110);
            tabela_Clientes.getColumnModel().getColumn(3).setResizable(false);
            tabela_Clientes.getColumnModel().getColumn(3).setPreferredWidth(110);
            tabela_Clientes.getColumnModel().getColumn(4).setResizable(false);
            tabela_Clientes.getColumnModel().getColumn(4).setPreferredWidth(80);
            tabela_Clientes.getColumnModel().getColumn(5).setResizable(false);
            tabela_Clientes.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabela_Clientes.getColumnModel().getColumn(6).setResizable(false);
            tabela_Clientes.getColumnModel().getColumn(6).setPreferredWidth(160);
            tabela_Clientes.getColumnModel().getColumn(7).setPreferredWidth(54);
        }

        javax.swing.GroupLayout panel_GestaoClienteLayout = new javax.swing.GroupLayout(panel_GestaoCliente);
        panel_GestaoCliente.setLayout(panel_GestaoClienteLayout);
        panel_GestaoClienteLayout.setHorizontalGroup(
            panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_GestaoClienteLayout.createSequentialGroup()
                .addGroup(panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_GestaoClienteLayout.createSequentialGroup()
                        .addGap(0, 38, Short.MAX_VALUE)
                        .addGroup(panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(linha_InferiorClientes)
                            .addComponent(linha_SuperiorClientes)
                            .addComponent(jScrollPane1_Clientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_GestaoClienteLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(botao_CadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botao_AtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botao_RemoverCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_GestaoClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_BuscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_PesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(combobox_FiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(botao_PesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
            .addGroup(panel_GestaoClienteLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(texto_Clientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto_NumeroClientes)
                .addGap(168, 168, 168)
                .addComponent(texto_Ativos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto_NumeroAtivos)
                .addGap(168, 168, 168)
                .addComponent(texto_Inativos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto_NumeroInativos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_GestaoClienteLayout.setVerticalGroup(
            panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GestaoClienteLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Ativos)
                    .addComponent(texto_Inativos)
                    .addComponent(texto_Clientes)
                    .addComponent(texto_NumeroClientes)
                    .addComponent(texto_NumeroAtivos)
                    .addComponent(texto_NumeroInativos))
                .addGap(34, 34, 34)
                .addGroup(panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texto_BuscarCliente)
                        .addComponent(campo_PesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobox_FiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botao_PesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(linha_SuperiorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(linha_InferiorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_CadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_GestaoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botao_RemoverCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botao_AtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_GestaoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_GestaoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_PesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_PesquisarClienteActionPerformed
        
    }//GEN-LAST:event_campo_PesquisarClienteActionPerformed

    private void combobox_FiltroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_FiltroClienteActionPerformed
        
    }//GEN-LAST:event_combobox_FiltroClienteActionPerformed

    private void botao_PesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_PesquisarFuncionariosActionPerformed
      Clientes c = new Clientes(); 
      String filtro = combobox_FiltroCliente.getSelectedItem().toString();
      String valor = campo_PesquisarCliente.getText().trim();
      List<Object[]> lista = c.searchClientesController(filtro,valor);
        ((DefaultTableModel) tabela_Clientes.getModel()).setRowCount(0);
        for (Object[] row : lista) {
        ((DefaultTableModel) tabela_Clientes.getModel()).addRow(row);
    }
    }//GEN-LAST:event_campo_PesquisarFuncionariosActionPerformed

    private void botao_CadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_CadastrarClienteActionPerformed
        Panel_CadastrarCliente panel  = new Panel_CadastrarCliente(tela);
        tela.mudar_Panel(panel);
        
    }//GEN-LAST:event_botao_CadastrarClienteActionPerformed

    private void botao_AtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AtualizarClienteActionPerformed
         int id = tela.searchCollumn(tabela_Clientes);
        if (id>0) {
        Panel_AtualizarCliente panel  = new Panel_AtualizarCliente(tela, id);
        tela.mudar_Panel(panel);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_AtualizarClienteActionPerformed

    private void botao_RemoverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RemoverClienteActionPerformed
      int id = tela.searchCollumn(tabela_Clientes);
      if (id>0) {
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
        Clientes c = new Clientes();
        c.removeClienteController(id);
        JOptionPane.showMessageDialog(null, "Cliente foi removido com sucesso");
        List<Object[]> lista = c.getAllClientesController();

        String[] dados = tela.searchDataDashboard(lista, "id","Ativo","Inativo",0 ,7 ,7 );
        texto_NumeroClientes.setText(dados[0]);
        texto_NumeroAtivos.setText(dados[1]);
        texto_NumeroInativos.setText(dados[2]);
        
        tela.updateTable(tabela_Clientes, lista);
        }

        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_RemoverClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_AtualizarCliente;
    private javax.swing.JButton botao_CadastrarCliente;
    private javax.swing.JButton botao_PesquisarCliente;
    private javax.swing.JButton botao_RemoverCliente;
    private javax.swing.JTextField campo_PesquisarCliente;
    private javax.swing.JComboBox<String> combobox_FiltroCliente;
    private javax.swing.JScrollPane jScrollPane1_Clientes;
    private javax.swing.JSeparator linha_InferiorClientes;
    private javax.swing.JSeparator linha_SuperiorClientes;
    private javax.swing.JPanel panel_GestaoCliente;
    private javax.swing.JTable tabela_Clientes;
    private javax.swing.JLabel texto_Ativos;
    private javax.swing.JLabel texto_BuscarCliente;
    private javax.swing.JLabel texto_Clientes;
    private javax.swing.JLabel texto_Inativos;
    private javax.swing.JLabel texto_NumeroAtivos;
    private javax.swing.JLabel texto_NumeroClientes;
    private javax.swing.JLabel texto_NumeroInativos;
    // End of variables declaration//GEN-END:variables
}
