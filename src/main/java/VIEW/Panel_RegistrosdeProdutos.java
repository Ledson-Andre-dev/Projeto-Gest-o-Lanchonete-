
package VIEW;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import CONTROLLER.Registros;


public class Panel_RegistrosdeProdutos extends javax.swing.JPanel {
    private Tela_Inicial tela;

    public Panel_RegistrosdeProdutos() {
        initComponents();
    }
    
    public Panel_RegistrosdeProdutos(Tela_Inicial tela) { 
        this.tela = tela;
        initComponents();
        tela.configurarBotaoEnter(this, botao_PesquisarRegistrosdeProdutos);  
        Registros r = new Registros();
        List<Object[]> lista = r.getAllRegistrosProdutosController();

        tela.updateTable(tabela_RegistrosdeProdutos, lista);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_RegistrosdeProdutos = new javax.swing.JPanel();
        linha_SuperiorRegistrosdeProdutos = new javax.swing.JSeparator();
        texto_BuscarRegistrosdeProdutos = new javax.swing.JLabel();
        campo_PesquisarRegistrosdeProdutos = new javax.swing.JTextField();
        combobox_FiltroRegistrosdeProdutos = new javax.swing.JComboBox<>();
        botao_PesquisarRegistrosdeProdutos = new javax.swing.JButton();
        linha_InferiorRegistrosdeProdutos = new javax.swing.JSeparator();
        botao_RemoverRegistrosdeProdutos = new javax.swing.JButton();
        texto_RegistrosdeProdutos = new javax.swing.JLabel();
        botao_VoltarRegistrosdeProdutos = new javax.swing.JButton();
        jScrollPane1_RegistrosdeProdutos = new javax.swing.JScrollPane();
        tabela_RegistrosdeProdutos = new javax.swing.JTable();

        panel_RegistrosdeProdutos.setBackground(new java.awt.Color(250, 250, 250));
        panel_RegistrosdeProdutos.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_BuscarRegistrosdeProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_BuscarRegistrosdeProdutos.setText("Buscar");

        campo_PesquisarRegistrosdeProdutos.setMinimumSize(new java.awt.Dimension(64, 24));
        campo_PesquisarRegistrosdeProdutos.setPreferredSize(new java.awt.Dimension(64, 24));
        campo_PesquisarRegistrosdeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_PesquisarRegistrosdeProdutosActionPerformed(evt);
            }
        });

        combobox_FiltroRegistrosdeProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem filtro", "Nome do produto", "Categoria", "ID" }));
        combobox_FiltroRegistrosdeProdutos.setMinimumSize(new java.awt.Dimension(72, 24));
        combobox_FiltroRegistrosdeProdutos.setPreferredSize(new java.awt.Dimension(72, 24));
        combobox_FiltroRegistrosdeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_FiltroRegistrosdeProdutosActionPerformed(evt);
            }
        });

        botao_PesquisarRegistrosdeProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/lupa_azul_21x21_invertida.png"))); 
        botao_PesquisarRegistrosdeProdutos.setMaximumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarRegistrosdeProdutos.setMinimumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarRegistrosdeProdutos.setPreferredSize(new java.awt.Dimension(75, 24));
        botao_PesquisarRegistrosdeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarRegistrosProdutosActionPerformed(evt);
            }
        });


        botao_RemoverRegistrosdeProdutos.setBackground(new java.awt.Color(255, 164, 114));
        botao_RemoverRegistrosdeProdutos.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_RemoverRegistrosdeProdutos.setForeground(new java.awt.Color(255, 255, 255));
        botao_RemoverRegistrosdeProdutos.setText("Remover");
        botao_RemoverRegistrosdeProdutos.setBorder(null);
        botao_RemoverRegistrosdeProdutos.setBorderPainted(false);
        botao_RemoverRegistrosdeProdutos.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_RemoverRegistrosdeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RemoverRegistrosdeProdutosActionPerformed(evt);
            }
        });

        texto_RegistrosdeProdutos.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        texto_RegistrosdeProdutos.setText("Registros de Produtos");

        botao_VoltarRegistrosdeProdutos.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarRegistrosdeProdutos.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarRegistrosdeProdutos.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarRegistrosdeProdutos.setText("Voltar");
        botao_VoltarRegistrosdeProdutos.setBorder(null);
        botao_VoltarRegistrosdeProdutos.setBorderPainted(false);
        botao_VoltarRegistrosdeProdutos.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_VoltarRegistrosdeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarRegistrosdeProdutosActionPerformed(evt);
            }
        });

        tabela_RegistrosdeProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Funcionário", "ID_Produto", "Nome", "Preço", "Categoria", "Ativo", "Data_Hora", "Condição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_RegistrosdeProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1_RegistrosdeProdutos.setViewportView(tabela_RegistrosdeProdutos);
        if (tabela_RegistrosdeProdutos.getColumnModel().getColumnCount() > 0) {
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(0).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(1).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(1).setPreferredWidth(70);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(2).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(2).setPreferredWidth(70);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(3).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(3).setPreferredWidth(180);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(4).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(5).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(6).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(6).setPreferredWidth(60);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(7).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(7).setPreferredWidth(130);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(8).setResizable(false);
            tabela_RegistrosdeProdutos.getColumnModel().getColumn(8).setPreferredWidth(104);
        }

        javax.swing.GroupLayout panel_RegistrosdeProdutosLayout = new javax.swing.GroupLayout(panel_RegistrosdeProdutos);
        panel_RegistrosdeProdutos.setLayout(panel_RegistrosdeProdutosLayout);
        panel_RegistrosdeProdutosLayout.setHorizontalGroup(
            panel_RegistrosdeProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistrosdeProdutosLayout.createSequentialGroup()
                .addGroup(panel_RegistrosdeProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_RegistrosdeProdutosLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(panel_RegistrosdeProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_RegistrosdeProdutosLayout.createSequentialGroup()
                                .addComponent(texto_BuscarRegistrosdeProdutos)
                                .addGap(6, 6, 6)
                                .addComponent(campo_PesquisarRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(combobox_FiltroRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(botao_PesquisarRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RegistrosdeProdutosLayout.createSequentialGroup()
                                .addComponent(texto_RegistrosdeProdutos)
                                .addGap(276, 276, 276))))
                    .addGroup(panel_RegistrosdeProdutosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panel_RegistrosdeProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(linha_InferiorRegistrosdeProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                            .addComponent(linha_SuperiorRegistrosdeProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                            .addGroup(panel_RegistrosdeProdutosLayout.createSequentialGroup()
                                .addComponent(botao_VoltarRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botao_RemoverRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1_RegistrosdeProdutos))))
                .addGap(38, 38, 38))
        );
        panel_RegistrosdeProdutosLayout.setVerticalGroup(
            panel_RegistrosdeProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_RegistrosdeProdutosLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(texto_RegistrosdeProdutos)
                .addGap(18, 18, 18)
                .addGroup(panel_RegistrosdeProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_BuscarRegistrosdeProdutos)
                    .addGroup(panel_RegistrosdeProdutosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panel_RegistrosdeProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_PesquisarRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_FiltroRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_PesquisarRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linha_SuperiorRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1_RegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linha_InferiorRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(panel_RegistrosdeProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_RemoverRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_VoltarRegistrosdeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_RegistrosdeProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_RegistrosdeProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_PesquisarRegistrosdeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_PesquisarRegistrosdeProdutosActionPerformed
        
    }//GEN-LAST:event_campo_PesquisarRegistrosdeProdutosActionPerformed

    private void combobox_FiltroRegistrosdeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_FiltroRegistrosdeProdutosActionPerformed
       
    }//GEN-LAST:event_combobox_FiltroRegistrosdeProdutosActionPerformed

    private void botao_PesquisarRegistrosProdutosActionPerformed(java.awt.event.ActionEvent evt) {                                                            
      Registros r = new Registros(); 
      String filtro = combobox_FiltroRegistrosdeProdutos.getSelectedItem().toString();
      String valor = campo_PesquisarRegistrosdeProdutos.getText().trim();
      List<Object[]> lista = r.searchRegistrosProdutosController(filtro,valor);
        ((DefaultTableModel) tabela_RegistrosdeProdutos.getModel()).setRowCount(0);
        for (Object[] row : lista) {
        ((DefaultTableModel) tabela_RegistrosdeProdutos.getModel()).addRow(row);
    }
    }

    private void botao_RemoverRegistrosdeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RemoverRegistrosdeProdutosActionPerformed
      int id = tela.searchCollumn(tabela_RegistrosdeProdutos);
      if (id>0) {
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
        Registros r = new Registros();
        r.removeRegistroProdutoController(id);
        List<Object[]> lista = r.getAllRegistrosProdutosController();
        
        tela.updateTable(tabela_RegistrosdeProdutos, lista);
        }

        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um registro da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_RemoverRegistrosdeProdutosActionPerformed

    private void botao_VoltarRegistrosdeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarRegistrosdeProdutosActionPerformed
       Panel_Registros panel  = new Panel_Registros(tela);
       tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_VoltarRegistrosdeProdutosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_PesquisarRegistrosdeProdutos;
    private javax.swing.JButton botao_RemoverRegistrosdeProdutos;
    private javax.swing.JButton botao_VoltarRegistrosdeProdutos;
    private javax.swing.JTextField campo_PesquisarRegistrosdeProdutos;
    private javax.swing.JComboBox<String> combobox_FiltroRegistrosdeProdutos;
    private javax.swing.JScrollPane jScrollPane1_RegistrosdeProdutos;
    private javax.swing.JSeparator linha_InferiorRegistrosdeProdutos;
    private javax.swing.JSeparator linha_SuperiorRegistrosdeProdutos;
    private javax.swing.JPanel panel_RegistrosdeProdutos;
    private javax.swing.JTable tabela_RegistrosdeProdutos;
    private javax.swing.JLabel texto_BuscarRegistrosdeProdutos;
    private javax.swing.JLabel texto_RegistrosdeProdutos;
    // End of variables declaration//GEN-END:variables
}
