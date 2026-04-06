
package VIEW;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ImageIcon;
import java.awt.Image;

import CONTROLLER.Produtos;


public class Panel_GestaoProdutos extends javax.swing.JPanel {
    
    private Tela_Inicial tela;
    
    public Panel_GestaoProdutos() {
        initComponents();
    }
    
    public Panel_GestaoProdutos(Tela_Inicial tela) {
        this.tela = tela;
        initComponents();
        tela.configurarBotaoEnter(this, botao_PesquisarProduto);  
        Produtos p = new Produtos();
        List<Object[]> lista = p.getAllProdutosController();

        tela.updateTable(tabela_Produtos, lista);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_GestaoProdutos = new javax.swing.JPanel();
        texto_Cadastrados = new javax.swing.JLabel();
        texto_Inativos = new javax.swing.JLabel();
        texto_Recentes = new javax.swing.JLabel();
        texto_NumeroCadastrados = new javax.swing.JLabel();
        texto_NumeroInativos = new javax.swing.JLabel();
        texto_NumeroRecentes = new javax.swing.JLabel();
        texto_BuscarProduto = new javax.swing.JLabel();
        campo_PesquisarProduto = new javax.swing.JTextField();
        combobox_FiltroProduto = new javax.swing.JComboBox<>();
        botao_PesquisarProduto = new javax.swing.JButton();
        butao_CadastrarProduto = new javax.swing.JButton();
        botao_AtualizarProduto = new javax.swing.JButton();
        botao_RemoverProduto = new javax.swing.JButton();
        linha_SuperiorProdutos = new javax.swing.JSeparator();
        jScrollPane1_Produtos = new javax.swing.JScrollPane();
        tabela_Produtos = new javax.swing.JTable();
        linha_InferiorProdutos = new javax.swing.JSeparator();
        texto_ImagemProduto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areadetexto_DescricaoProduto = new javax.swing.JTextArea();

        panel_GestaoProdutos.setBackground(new java.awt.Color(250, 250, 250));
        panel_GestaoProdutos.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_Cadastrados.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Cadastrados.setText("Cadastrados:");

        texto_Inativos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 

        texto_Recentes.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Recentes.setText("Recentes");

        texto_NumeroCadastrados.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroCadastrados.setText("0");

        texto_NumeroInativos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroInativos.setText("0");

        texto_NumeroRecentes.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroRecentes.setText("0");

        texto_BuscarProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_BuscarProduto.setText("Buscar");

        campo_PesquisarProduto.setMinimumSize(new java.awt.Dimension(64, 24));
        campo_PesquisarProduto.setPreferredSize(new java.awt.Dimension(64, 24));
        campo_PesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_PesquisarProdutoActionPerformed(evt);
            }
        });

        combobox_FiltroProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem filtro", "Nome", "Lanches", "Porções", "Bebidas", "Sobremesas", "Acompanhamentos", "ID" }));
        combobox_FiltroProduto.setMinimumSize(new java.awt.Dimension(72, 24));
        combobox_FiltroProduto.setPreferredSize(new java.awt.Dimension(72, 24));
        combobox_FiltroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_FiltroProdutoActionPerformed(evt);
            }
        });

        botao_PesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/lupa_azul_21x21_invertida.png"))); 
        botao_PesquisarProduto.setMaximumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarProduto.setMinimumSize(new java.awt.Dimension(72, 24));
        botao_PesquisarProduto.setPreferredSize(new java.awt.Dimension(75, 24));
        botao_PesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_PesquisarProdutoActionPerformed(evt);
            }
        });
        butao_CadastrarProduto.setBackground(new java.awt.Color(148, 189, 154));
        butao_CadastrarProduto.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        butao_CadastrarProduto.setForeground(new java.awt.Color(255, 255, 255));
        butao_CadastrarProduto.setText("Cadastrar");
        butao_CadastrarProduto.setBorder(null);
        butao_CadastrarProduto.setPreferredSize(new java.awt.Dimension(186, 40));
        butao_CadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butao_CadastrarProdutoActionPerformed(evt);
            }
        });

        botao_AtualizarProduto.setBackground(new java.awt.Color(255, 238, 140));
        botao_AtualizarProduto.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_AtualizarProduto.setForeground(new java.awt.Color(255, 255, 255));
        botao_AtualizarProduto.setText("Atualizar");
        botao_AtualizarProduto.setBorder(null);
        botao_AtualizarProduto.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_AtualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AtualizarProdutoActionPerformed(evt);
            }
        });

        botao_RemoverProduto.setBackground(new java.awt.Color(255, 164, 114));
        botao_RemoverProduto.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_RemoverProduto.setForeground(new java.awt.Color(255, 255, 255));
        botao_RemoverProduto.setText("Remover");
        botao_RemoverProduto.setBorder(null);
        botao_RemoverProduto.setBorderPainted(false);
        botao_RemoverProduto.setPreferredSize(new java.awt.Dimension(186, 40));
        botao_RemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RemoverProdutoActionPerformed(evt);
            }
        });

        tabela_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Categoria", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
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
        tabela_Produtos.getTableHeader().setReorderingAllowed(false);
        
        jScrollPane1_Produtos.setViewportView(tabela_Produtos);
        if (tabela_Produtos.getColumnModel().getColumnCount() > 0) {
            tabela_Produtos.getColumnModel().getColumn(0).setResizable(false);
            tabela_Produtos.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabela_Produtos.getColumnModel().getColumn(1).setResizable(false);
            tabela_Produtos.getColumnModel().getColumn(1).setPreferredWidth(260);
            tabela_Produtos.getColumnModel().getColumn(2).setResizable(false);
            tabela_Produtos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabela_Produtos.getColumnModel().getColumn(3).setResizable(false);
            tabela_Produtos.getColumnModel().getColumn(3).setPreferredWidth(122);
            tabela_Produtos.getColumnModel().getColumn(4).setResizable(false);
            tabela_Produtos.getColumnModel().getColumn(4).setPreferredWidth(70);
        }
        
        tabela_Produtos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting() && tabela_Produtos.getSelectedRow() != -1) {
                int linha = tabela_Produtos.getSelectedRow();

                int idProduto = Integer.parseInt(tabela_Produtos.getValueAt(linha, 0).toString());

                Produtos p = new Produtos();
                String[] dados = p.getDescricaoECaminhoImagemController(idProduto);

                String descricao = dados[0];
                if (descricao != null && !descricao.isEmpty()) {
                    areadetexto_DescricaoProduto.setText(descricao);
                } else {
                    areadetexto_DescricaoProduto.setText(""); 
                }

                String caminhoImagem = dados[1];
                if (caminhoImagem != null && !caminhoImagem.isEmpty()) {
                    ImageIcon imagem = new ImageIcon(caminhoImagem);
                    Image imgRedimensionada = imagem.getImage().getScaledInstance(
                            texto_ImagemProduto.getPreferredSize().width,
                            texto_ImagemProduto.getPreferredSize().height,
                            Image.SCALE_SMOOTH
                    );
                    texto_ImagemProduto.setText("");
                    texto_ImagemProduto.setIcon(new ImageIcon(imgRedimensionada));
                } else {
                    texto_ImagemProduto.setText("Sem imagem");
                    texto_ImagemProduto.setIcon(null);
                }
            }
        }
    });


        texto_ImagemProduto.setBackground(new java.awt.Color(230, 230, 230));
        texto_ImagemProduto.setOpaque(true);
        texto_ImagemProduto.setPreferredSize(new java.awt.Dimension(200, 200));

        areadetexto_DescricaoProduto.setEditable(false);
        areadetexto_DescricaoProduto.setBackground(new java.awt.Color(250, 250, 250));
        areadetexto_DescricaoProduto.setColumns(20);
        areadetexto_DescricaoProduto.setLineWrap(true);
        areadetexto_DescricaoProduto.setRows(5);
        areadetexto_DescricaoProduto.setWrapStyleWord(true);
        areadetexto_DescricaoProduto.setDisabledTextColor(new java.awt.Color(242, 242, 242));
        areadetexto_DescricaoProduto.setDragEnabled(true);
        areadetexto_DescricaoProduto.setHighlighter(null);
        areadetexto_DescricaoProduto.setPreferredSize(new java.awt.Dimension(200, 84));
        areadetexto_DescricaoProduto.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(areadetexto_DescricaoProduto);

        javax.swing.GroupLayout panel_GestaoProdutosLayout = new javax.swing.GroupLayout(panel_GestaoProdutos);
        panel_GestaoProdutos.setLayout(panel_GestaoProdutosLayout);
        panel_GestaoProdutosLayout.setHorizontalGroup(
            panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                .addGroup(panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(texto_Cadastrados)
                        .addGap(6, 6, 6)
                        .addComponent(texto_NumeroCadastrados)
                        .addGap(168, 168, 168)
                        .addComponent(texto_Inativos)
                        .addGap(6, 6, 6)
                        .addComponent(texto_NumeroInativos)
                        .addGap(168, 168, 168)
                        .addComponent(texto_Recentes)
                        .addGap(6, 6, 6)
                        .addComponent(texto_NumeroRecentes))
                    .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_BuscarProduto)
                        .addGap(6, 6, 6)
                        .addComponent(campo_PesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(combobox_FiltroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(botao_PesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(linha_InferiorProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(butao_CadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botao_AtualizarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botao_RemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                                .addGroup(panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto_ImagemProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(linha_SuperiorProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );
        panel_GestaoProdutosLayout.setVerticalGroup(
            panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Cadastrados)
                    .addComponent(texto_NumeroCadastrados)
                    .addComponent(texto_Inativos)
                    .addComponent(texto_NumeroInativos)
                    .addComponent(texto_Recentes)
                    .addComponent(texto_NumeroRecentes))
                .addGap(34, 34, 34)
                .addGroup(panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_BuscarProduto)
                    .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_PesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_FiltroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_PesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addComponent(linha_SuperiorProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_GestaoProdutosLayout.createSequentialGroup()
                        .addComponent(texto_ImagemProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(linha_InferiorProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel_GestaoProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butao_CadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_AtualizarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_RemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_GestaoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_GestaoProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    

    private void campo_PesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_PesquisarProdutoActionPerformed
    }//GEN-LAST:event_campo_PesquisarProdutoActionPerformed

    private void combobox_FiltroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_FiltroProdutoActionPerformed
    }//GEN-LAST:event_combobox_FiltroProdutoActionPerformed


    private void botao_PesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                                            
      Produtos p = new Produtos(); 
      String filtro = combobox_FiltroProduto.getSelectedItem().toString();
      String valor = campo_PesquisarProduto.getText().trim();
      List<Object[]> lista = p.searchProdutosController(filtro,valor);
        ((DefaultTableModel) tabela_Produtos.getModel()).setRowCount(0);
        for (Object[] row : lista) {
        ((DefaultTableModel) tabela_Produtos.getModel()).addRow(row);
    }
    }
    private void butao_CadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butao_CadastrarProdutoActionPerformed
        Panel_CadastrarProduto panel  = new Panel_CadastrarProduto(tela);
        tela.mudar_Panel(panel);
                
    }//GEN-LAST:event_butao_CadastrarProdutoActionPerformed

    private void botao_AtualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AtualizarProdutoActionPerformed
        int id = tela.searchCollumn(tabela_Produtos);
        if (id>0) {
        Panel_AtualizarProduto panel  = new Panel_AtualizarProduto(tela, id);
        tela.mudar_Panel(panel);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um funcionário da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_AtualizarProdutoActionPerformed

    private void botao_RemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RemoverProdutoActionPerformed
        int id = tela.searchCollumn(tabela_Produtos);
      if (id>0) {
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
        Produtos p = new Produtos();
        p.removeProdutoController(id);
        JOptionPane.showMessageDialog(null, "Produto foi removido com sucesso");
        List<Object[]> lista = p.getAllProdutosController();
        
        tela.updateTable(tabela_Produtos, lista);
        }

        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botao_RemoverProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areadetexto_DescricaoProduto;
    private javax.swing.JButton botao_AtualizarProduto;
    private javax.swing.JButton botao_PesquisarProduto;
    private javax.swing.JButton botao_RemoverProduto;
    private javax.swing.JButton butao_CadastrarProduto;
    private javax.swing.JTextField campo_PesquisarProduto;
    private javax.swing.JComboBox<String> combobox_FiltroProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane1_Produtos;
    private javax.swing.JSeparator linha_InferiorProdutos;
    private javax.swing.JSeparator linha_SuperiorProdutos;
    private javax.swing.JPanel panel_GestaoProdutos;
    private javax.swing.JTable tabela_Produtos;
    private javax.swing.JLabel texto_BuscarProduto;
    private javax.swing.JLabel texto_Cadastrados;
    private javax.swing.JLabel texto_ImagemProduto;
    private javax.swing.JLabel texto_Inativos;
    private javax.swing.JLabel texto_NumeroCadastrados;
    private javax.swing.JLabel texto_NumeroInativos;
    private javax.swing.JLabel texto_NumeroRecentes;
    private javax.swing.JLabel texto_Recentes;
    // End of variables declaration//GEN-END:variables
}
