
package VIEW;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import CONTROLLER.Funcionarios;



public class Panel_GestaoFuncionarios extends javax.swing.JPanel {
    
    private Tela_Inicial tela;
   
    public Panel_GestaoFuncionarios() {
        initComponents();
    }
    
    public Panel_GestaoFuncionarios(Tela_Inicial tela) { 
    this.tela = tela;
    initComponents();
    tela.configurarBotaoEnter(this, botao_PesquisarFuncionarios);  
    Funcionarios f = new Funcionarios();
    List<Object[]> lista = f.getAllFuncionariosController();
    
    String[] dados = tela.searchDataDashboard(lista, "Funcionário","Administrador","Ativo",4 ,4 ,9 );
    texto_NumeroFuncionarios.setText(dados[0]);
    texto_NumeroAdministradoresFuncionarios.setText(dados[1]);
    texto_NumeroAtivosFuncionarios.setText(dados[2]);

    tela.updateTable(tabela_Funcionarios, lista);
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_GestaoFuncionarios = new javax.swing.JPanel();
        texto_Funcionarios = new javax.swing.JLabel();
        texto_AdminstradoresFuncionarios = new javax.swing.JLabel();
        texto_AtivosFuncionarios = new javax.swing.JLabel();
        texto_NumeroFuncionarios = new javax.swing.JLabel();
        texto_NumeroAdministradoresFuncionarios = new javax.swing.JLabel();
        texto_NumeroAtivosFuncionarios = new javax.swing.JLabel();
        texto_BuscarFuncionarios = new javax.swing.JLabel();
        campo_PesquisarFuncionarios = new javax.swing.JTextField();
        combobox_FiltroFuncionarios = new javax.swing.JComboBox<>();
        linha_SuperiorFuncionarios = new javax.swing.JSeparator();
        linha_InferiorFuncionarios = new javax.swing.JSeparator();
        botao_PesquisarFuncionarios = new javax.swing.JButton();
        botao_CadastrarFuncionarios = new javax.swing.JButton();
        botao_AtualizarFuncionarios = new javax.swing.JButton();
        botao_RemoverFuncionarios = new javax.swing.JButton();
        jScrollPane1_Funcionarios = new javax.swing.JScrollPane();
        tabela_Funcionarios = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(920, 640));

        panel_GestaoFuncionarios.setBackground(new java.awt.Color(250, 250, 250));
        panel_GestaoFuncionarios.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_Funcionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto_Funcionarios.setText("Funcionários: ");

        texto_AdminstradoresFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto_AdminstradoresFuncionarios.setText("Administradores:");

        texto_AtivosFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto_AtivosFuncionarios.setText("Ativos:");

        texto_NumeroFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto_NumeroFuncionarios.setText("0");

        texto_NumeroAdministradoresFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto_NumeroAdministradoresFuncionarios.setText("0");

        texto_NumeroAtivosFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto_NumeroAtivosFuncionarios.setText("0");

        texto_BuscarFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto_BuscarFuncionarios.setText("Buscar");

        campo_PesquisarFuncionarios.setMinimumSize(new java.awt.Dimension(64, 24));
        campo_PesquisarFuncionarios.setPreferredSize(new java.awt.Dimension(64, 24));
        campo_PesquisarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_PesquisarFuncionariosActionPerformed(evt);
            }
        });

        combobox_FiltroFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem filtro", "Nome", "Cargo", "CPF", "ID" }));
        combobox_FiltroFuncionarios.setMinimumSize(new java.awt.Dimension(72, 24));
        combobox_FiltroFuncionarios.setPreferredSize(new java.awt.Dimension(72, 24));
        combobox_FiltroFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_FiltroFuncionariosActionPerformed(evt);
            }
        });

        botao_PesquisarFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/lupa_azul_21x21_invertida.png"))); // NOI18N
        botao_PesquisarFuncionarios.setMaximumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarFuncionarios.setMinimumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarFuncionarios.setPreferredSize(new java.awt.Dimension(75, 24));
        botao_PesquisarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarFuncionariosActionPerformed(evt);
            }
        });

        botao_CadastrarFuncionarios.setBackground(new java.awt.Color(148, 189, 154));
        botao_CadastrarFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        botao_CadastrarFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        botao_CadastrarFuncionarios.setText("Cadastrar");
        botao_CadastrarFuncionarios.setBorder(null);
        botao_CadastrarFuncionarios.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_CadastrarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_CadastrarFuncionariosActionPerformed(evt);
            }
        });

        botao_AtualizarFuncionarios.setBackground(new java.awt.Color(255, 238, 140));
        botao_AtualizarFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        botao_AtualizarFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        botao_AtualizarFuncionarios.setText("Atualizar");
        botao_AtualizarFuncionarios.setBorder(null);
        botao_AtualizarFuncionarios.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_AtualizarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AtualizarFuncionariosActionPerformed(evt);
            }
        });

        botao_RemoverFuncionarios.setBackground(new java.awt.Color(255, 164, 114));
        botao_RemoverFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        botao_RemoverFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        botao_RemoverFuncionarios.setText("Remover");
        botao_RemoverFuncionarios.setBorder(null);
        botao_RemoverFuncionarios.setBorderPainted(false);
        botao_RemoverFuncionarios.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_RemoverFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RemoverFuncionariosActionPerformed(evt);
            }
        });

        tabela_Funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Cargo", "Nível_Acesso", "Login", "Senha", "Telefone", "E-mail", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_Funcionarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1_Funcionarios.setViewportView(tabela_Funcionarios);
        if (tabela_Funcionarios.getColumnModel().getColumnCount() > 0) {
            tabela_Funcionarios.getColumnModel().getColumn(0).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabela_Funcionarios.getColumnModel().getColumn(1).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabela_Funcionarios.getColumnModel().getColumn(2).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabela_Funcionarios.getColumnModel().getColumn(3).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabela_Funcionarios.getColumnModel().getColumn(4).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabela_Funcionarios.getColumnModel().getColumn(5).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(5).setPreferredWidth(80);
            tabela_Funcionarios.getColumnModel().getColumn(6).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(6).setPreferredWidth(80);
            tabela_Funcionarios.getColumnModel().getColumn(7).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(7).setPreferredWidth(100);
            tabela_Funcionarios.getColumnModel().getColumn(8).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(8).setPreferredWidth(150);
            tabela_Funcionarios.getColumnModel().getColumn(9).setResizable(false);
            tabela_Funcionarios.getColumnModel().getColumn(9).setPreferredWidth(44);
        }

        javax.swing.GroupLayout panel_GestaoFuncionariosLayout = new javax.swing.GroupLayout(panel_GestaoFuncionarios);
        panel_GestaoFuncionarios.setLayout(panel_GestaoFuncionariosLayout);
        panel_GestaoFuncionariosLayout.setHorizontalGroup(
            panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GestaoFuncionariosLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(linha_InferiorFuncionarios)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_GestaoFuncionariosLayout.createSequentialGroup()
                        .addComponent(botao_CadastrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botao_AtualizarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botao_RemoverFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(linha_SuperiorFuncionarios)
                    .addComponent(jScrollPane1_Funcionarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addGroup(panel_GestaoFuncionariosLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_GestaoFuncionariosLayout.createSequentialGroup()
                                .addComponent(texto_Funcionarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texto_NumeroFuncionarios)
                                .addGap(168, 168, 168)
                                .addComponent(texto_AdminstradoresFuncionarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texto_NumeroAdministradoresFuncionarios)
                                .addGap(168, 168, 168)
                                .addComponent(texto_AtivosFuncionarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texto_NumeroAtivosFuncionarios))
                            .addGroup(panel_GestaoFuncionariosLayout.createSequentialGroup()
                                .addComponent(texto_BuscarFuncionarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campo_PesquisarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(combobox_FiltroFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(botao_PesquisarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panel_GestaoFuncionariosLayout.setVerticalGroup(
            panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GestaoFuncionariosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_AdminstradoresFuncionarios)
                    .addComponent(texto_AtivosFuncionarios)
                    .addComponent(texto_Funcionarios)
                    .addComponent(texto_NumeroFuncionarios)
                    .addComponent(texto_NumeroAdministradoresFuncionarios)
                    .addComponent(texto_NumeroAtivosFuncionarios))
                .addGap(34, 34, 34)
                .addGroup(panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texto_BuscarFuncionarios)
                        .addComponent(campo_PesquisarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobox_FiltroFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botao_PesquisarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(linha_SuperiorFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1_Funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(linha_InferiorFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_CadastrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_GestaoFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botao_RemoverFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botao_AtualizarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_GestaoFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_GestaoFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_PesquisarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {                                                            
      
    }                                                           

    private void combobox_FiltroFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_FiltroFuncionariosActionPerformed
    }//GEN-LAST:event_combobox_FiltroFuncionariosActionPerformed

    private void botao_CadastrarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_CadastrarFuncionariosActionPerformed
        Panel_CadastrarFuncionario panel  = new Panel_CadastrarFuncionario(tela);
        tela.mudar_Panel(panel);

    }//GEN-LAST:event_botao_CadastrarFuncionariosActionPerformed

    private void botao_PesquisarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_PesquisarFuncionariosActionPerformed
      Funcionarios f = new Funcionarios(); 
      String filtro = combobox_FiltroFuncionarios.getSelectedItem().toString();
      String valor = campo_PesquisarFuncionarios.getText().trim();
      List<Object[]> lista = f.searchFuncionariosController(filtro,valor);
        ((DefaultTableModel) tabela_Funcionarios.getModel()).setRowCount(0);
        for (Object[] row : lista) {
        ((DefaultTableModel) tabela_Funcionarios.getModel()).addRow(row);
    }
    }//GEN-LAST:event_campo_PesquisarFuncionariosActionPerformed

    private void botao_AtualizarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AtualizarFuncionariosActionPerformed
        int id = tela.searchCollumn(tabela_Funcionarios);
        if (id>0) {
        Panel_AtualizarFuncionario panel  = new Panel_AtualizarFuncionario(tela, id);
        tela.mudar_Panel(panel);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um funcionário da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_AtualizarFuncionariosActionPerformed

    private void botao_RemoverFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RemoverFuncionariosActionPerformed
      int id = tela.searchCollumn(tabela_Funcionarios);
      if (id>0) {
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
        Funcionarios f = new Funcionarios();
        f.removeFuncionarioController(id);
        JOptionPane.showMessageDialog(null, "Funcionário foi removido com sucesso");
        List<Object[]> lista = f.getAllFuncionariosController();
        String[] dados = tela.searchDataDashboard(lista, "Funcionário","Administrador","Ativo",4 ,4 ,9 );
        texto_NumeroFuncionarios.setText(dados[0]);
        texto_NumeroAdministradoresFuncionarios.setText(dados[1]);
        texto_NumeroAtivosFuncionarios.setText(dados[2]);
        
        tela.updateTable(tabela_Funcionarios, lista);
        }

        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um funcionário da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_botao_RemoverFuncionariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_AtualizarFuncionarios;
    private javax.swing.JButton botao_CadastrarFuncionarios;
    private javax.swing.JButton botao_PesquisarFuncionarios;
    private javax.swing.JButton botao_RemoverFuncionarios;
    private javax.swing.JTextField campo_PesquisarFuncionarios;
    private javax.swing.JComboBox<String> combobox_FiltroFuncionarios;
    private javax.swing.JScrollPane jScrollPane1_Funcionarios;
    private javax.swing.JSeparator linha_InferiorFuncionarios;
    private javax.swing.JSeparator linha_SuperiorFuncionarios;
    private javax.swing.JPanel panel_GestaoFuncionarios;
    private javax.swing.JTable tabela_Funcionarios;
    private javax.swing.JLabel texto_AdminstradoresFuncionarios;
    private javax.swing.JLabel texto_AtivosFuncionarios;
    private javax.swing.JLabel texto_BuscarFuncionarios;
    private javax.swing.JLabel texto_Funcionarios;
    private javax.swing.JLabel texto_NumeroAdministradoresFuncionarios;
    private javax.swing.JLabel texto_NumeroAtivosFuncionarios;
    private javax.swing.JLabel texto_NumeroFuncionarios;
    // End of variables declaration//GEN-END:variables
}
