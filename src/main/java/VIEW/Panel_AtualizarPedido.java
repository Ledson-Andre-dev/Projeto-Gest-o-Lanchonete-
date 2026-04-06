
package VIEW;

import java.util.List;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import com.formdev.flatlaf.FlatClientProperties;

import CONTROLLER.Itens_Pedidos;
import CONTROLLER.Pedidos;
import CONTROLLER.Produtos;


public class Panel_AtualizarPedido extends javax.swing.JPanel {
    private int idcliente;
    private String nomecliente;
    private int idPedido = 0;
    private Tela_Inicial tela;
  
    public Panel_AtualizarPedido() {
        initComponents();
    }
    
     public Panel_AtualizarPedido(Tela_Inicial tela,int idPedido) {
        this.tela = tela;
        this.idPedido = idPedido;
        initComponents();
        this.placeHolder();
        campoformatado_QuantidadeAtualizar.setFormatterFactory(null);

        campoformatado_QuantidadeAtualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char tecla = evt.getKeyChar();
                
                if (tecla == java.awt.event.KeyEvent.VK_BACK_SPACE || tecla == java.awt.event.KeyEvent.VK_DELETE) {
                    return; 
                }
                
                if (!Character.isDigit(tecla) || campoformatado_QuantidadeAtualizar.getText().length() >= 3) {
                    evt.consume(); 
                }
            }
        });
        
        tela.configurarBotaoEnter(this, botao_ConfirmarAtualizarPedido);
        configurarComboBoxPesquisa(combobox_ProdutoAtualizar);
         tela.limitarCaracteres(campo_ClienteAtualizar, 100);
        Itens_Pedidos ip = new Itens_Pedidos();
        Pedidos p = new Pedidos();
        String[] vetor = p.preencherAtualizarPedidoController(idPedido);
        
        if (vetor != null && !vetor[0].isEmpty()) {
            preencherCamposPedido(vetor);
        }

    List<Object[]> lista = ip.getAllItensPedidoController(this.idPedido);
    tela.updateTable(tabela_ItensPedidosAtualizar, lista);
    }

    public void preencherCamposPedido(String[] dados) {
    if (dados == null || dados.length < 2) return; 

    
    String clienteOuCpf = dados[0] != null ? dados[0] : "";
    campo_ClienteAtualizar.setText(clienteOuCpf);

    
    if (clienteOuCpf.matches("\\d+")) { 
        botaoradio_ClienteCadastradoSimAtualizar.setSelected(true);
        botaoradio_ClienteCadastradoNaoAtualizar.setSelected(false);
    } else {
        botaoradio_ClienteCadastradoSimAtualizar.setSelected(false);
        botaoradio_ClienteCadastradoNaoAtualizar.setSelected(true);
    }

    
    String situacao = dados[1] != null ? dados[1] : "";
    if (!situacao.isEmpty()) {
        combobox_StatusdoPedidoAtualizar.setSelectedItem(situacao);
    } else {
        combobox_StatusdoPedidoAtualizar.setSelectedIndex(-1); 
    }
}

    public void configurarComboBoxPesquisa(JComboBox<String> comboBox) {
        Produtos p = new Produtos();
        
      
        List<Object[]> todosOsProdutos = p.getAllProdutosController();
        DefaultComboBoxModel<String> modeloInicial = new DefaultComboBoxModel<>();
        for (Object[] row : todosOsProdutos) {
            modeloInicial.addElement(row[1].toString()); 
        }
        comboBox.setModel(modeloInicial);
        
        comboBox.setEditable(true);
        
      
        JTextField textField = (JTextField) comboBox.getEditor().getEditorComponent();

      
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || 
                    keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_ESCAPE || 
                    keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
                    return;
                }

                
                SwingUtilities.invokeLater(() -> {
                    String textoDigitado = textField.getText();
                    List<Object[]> resultados;

                    
                    if (textoDigitado.trim().isEmpty()) {
                        resultados = p.getAllProdutosController(); 
                    } else {
                        resultados = p.searchProdutosController("Nome", textoDigitado); 
                    }

                  
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    for (Object[] row : resultados) {
                        model.addElement(row[1].toString()); 
                    }

                   
                    comboBox.setModel(model);
                    
                    
                    textField.setText(textoDigitado);
                    
                    textField.setCaretPosition(textoDigitado.length());

                    if (model.getSize() > 0) {
                        comboBox.showPopup();
                    } else {
                        comboBox.hidePopup();
                    }
                });
            }
        });
    }
  
        
    private void placeHolder() {

        if (campo_ClienteAtualizar != null) {
            campo_ClienteAtualizar.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Com Cadastro: CPF / Sem Cadastro: NOME");

        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotao_AtualizarPedido = new javax.swing.ButtonGroup();
        panel_AtualizarPedido = new javax.swing.JPanel();
        texto_AtualizarPedido = new javax.swing.JLabel();
        linha_ESuperiorAtualizarPedido = new javax.swing.JSeparator();
        linha_DSuperiorAtualizarPedido = new javax.swing.JSeparator();
        texto_ClienteAtualizar = new javax.swing.JLabel();
        texto_ProdutoAtualizar = new javax.swing.JLabel();
        texto_QuantidadeAtualizar = new javax.swing.JLabel();
        texto_StatusdoPedidoAtualizar = new javax.swing.JLabel();
        texto_ClienteCadastradoAtualizar = new javax.swing.JLabel();
        campo_ClienteAtualizar = new javax.swing.JTextField();
        campoformatado_QuantidadeAtualizar = new javax.swing.JFormattedTextField();
        combobox_StatusdoPedidoAtualizar = new javax.swing.JComboBox<>();
        botaoradio_ClienteCadastradoSimAtualizar = new javax.swing.JRadioButton();
        botaoradio_ClienteCadastradoNaoAtualizar = new javax.swing.JRadioButton();
        botao_AdicionarProdutonoPedidoAtualizar = new javax.swing.JButton();
        botao_RenoverProdutodoPedidoAtualizar = new javax.swing.JButton();
        botao_VoltarAtualizarPedido = new javax.swing.JButton();
        botao_ConfirmarAtualizarPedido = new javax.swing.JButton();
        jScrollPane1_ItensPedidosAtualizar = new javax.swing.JScrollPane();
        tabela_ItensPedidosAtualizar = new javax.swing.JTable();
        linha_InferiorAtualizarPedido = new javax.swing.JSeparator();
        combobox_ProdutoAtualizar = new javax.swing.JComboBox<>();

        panel_AtualizarPedido.setBackground(new java.awt.Color(250, 250, 250));
        panel_AtualizarPedido.setPreferredSize(new java.awt.Dimension(920, 640));
        panel_AtualizarPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        texto_AtualizarPedido.setBackground(new java.awt.Color(250, 250, 250));
        texto_AtualizarPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        texto_AtualizarPedido.setText("Atualizar Pedido");
        panel_AtualizarPedido.add(texto_AtualizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 18, -1, -1));
        panel_AtualizarPedido.add(linha_ESuperiorAtualizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 35, 320, 10));
        panel_AtualizarPedido.add(linha_DSuperiorAtualizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 35, 330, 10));

        texto_ClienteAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_ClienteAtualizar.setText("Cliente: ");
        panel_AtualizarPedido.add(texto_ClienteAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        texto_ProdutoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_ProdutoAtualizar.setText("Produto:");
        panel_AtualizarPedido.add(texto_ProdutoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        texto_QuantidadeAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_QuantidadeAtualizar.setText("Qtd.:");
        panel_AtualizarPedido.add(texto_QuantidadeAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, -1));

        texto_StatusdoPedidoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_StatusdoPedidoAtualizar.setText("Status do Pedido:");
        panel_AtualizarPedido.add(texto_StatusdoPedidoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        texto_ClienteCadastradoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_ClienteCadastradoAtualizar.setText("Cliente Cadastrado:");
        panel_AtualizarPedido.add(texto_ClienteCadastradoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        campo_ClienteAtualizar.setPreferredSize(new java.awt.Dimension(320, 24));
        panel_AtualizarPedido.add(campo_ClienteAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

       
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);
        format.setMaximumIntegerDigits(3); 

       
        NumberFormatter numberFormatter = new NumberFormatter(format);
        numberFormatter.setValueClass(Integer.class); 
        numberFormatter.setAllowsInvalid(false); 
        numberFormatter.setMinimum(0); 

        campoformatado_QuantidadeAtualizar.setFormatterFactory(new DefaultFormatterFactory(numberFormatter));
        
        campoformatado_QuantidadeAtualizar.setPreferredSize(new java.awt.Dimension(100, 24));
        panel_AtualizarPedido.add(campoformatado_QuantidadeAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, -1, -1));

        combobox_StatusdoPedidoAtualizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Concluído", "Cancelado" }));
        combobox_StatusdoPedidoAtualizar.setPreferredSize(new java.awt.Dimension(350, 24));
        panel_AtualizarPedido.add(combobox_StatusdoPedidoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, -1));

        grupobotao_AtualizarPedido.add(botaoradio_ClienteCadastradoSimAtualizar);
        botaoradio_ClienteCadastradoSimAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_ClienteCadastradoSimAtualizar.setText("Sim");
        botaoradio_ClienteCadastradoSimAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_ClienteCadastradoSimAtualizar.setIconTextGap(10);
        botaoradio_ClienteCadastradoSimAtualizar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        botaoradio_ClienteCadastradoSimAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoradio_ClienteCadastradoSimAtualizarActionPerformed(evt);
            }
        });
        panel_AtualizarPedido.add(botaoradio_ClienteCadastradoSimAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        grupobotao_AtualizarPedido.add(botaoradio_ClienteCadastradoNaoAtualizar);
        botaoradio_ClienteCadastradoNaoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_ClienteCadastradoNaoAtualizar.setText("Não");
        botaoradio_ClienteCadastradoNaoAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_ClienteCadastradoNaoAtualizar.setIconTextGap(10);
        botaoradio_ClienteCadastradoNaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoradio_ClienteCadastradoNaoAtualizarActionPerformed(evt);
            }
        });
        panel_AtualizarPedido.add(botaoradio_ClienteCadastradoNaoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        botao_AdicionarProdutonoPedidoAtualizar.setBackground(new java.awt.Color(148, 189, 154));
        botao_AdicionarProdutonoPedidoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_AdicionarProdutonoPedidoAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        botao_AdicionarProdutonoPedidoAtualizar.setText("Adicionar");
        botao_AdicionarProdutonoPedidoAtualizar.setBorder(null);
        botao_AdicionarProdutonoPedidoAtualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        botao_AdicionarProdutonoPedidoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AdicionarProdutonoPedidoAtualizarActionPerformed(evt);
            }
        });
        panel_AtualizarPedido.add(botao_AdicionarProdutonoPedidoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, -1, -1));

        botao_RenoverProdutodoPedidoAtualizar.setBackground(new java.awt.Color(255, 164, 114));
        botao_RenoverProdutodoPedidoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_RenoverProdutodoPedidoAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        botao_RenoverProdutodoPedidoAtualizar.setText("Remover");
        botao_RenoverProdutodoPedidoAtualizar.setBorder(null);
        botao_RenoverProdutodoPedidoAtualizar.setBorderPainted(false);
        botao_RenoverProdutodoPedidoAtualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        botao_RenoverProdutodoPedidoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RenoverProdutodoPedidoAtualizarActionPerformed(evt);
            }
        });
        panel_AtualizarPedido.add(botao_RenoverProdutodoPedidoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, -1, -1));

        botao_VoltarAtualizarPedido.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarAtualizarPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarAtualizarPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarAtualizarPedido.setText("Voltar");
        botao_VoltarAtualizarPedido.setBorder(null);
        botao_VoltarAtualizarPedido.setBorderPainted(false);
        botao_VoltarAtualizarPedido.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_VoltarAtualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarAtualizarPedidoActionPerformed(evt);
            }
        });
        panel_AtualizarPedido.add(botao_VoltarAtualizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 548, -1, -1));

        botao_ConfirmarAtualizarPedido.setBackground(new java.awt.Color(148, 189, 154));
        botao_ConfirmarAtualizarPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_ConfirmarAtualizarPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_ConfirmarAtualizarPedido.setText("Confirmar");
        botao_ConfirmarAtualizarPedido.setBorder(null);
        botao_ConfirmarAtualizarPedido.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_ConfirmarAtualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarAtualizarPedidoActionPerformed(evt);
            }
        });
        panel_AtualizarPedido.add(botao_ConfirmarAtualizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 548, -1, -1));

        tabela_ItensPedidosAtualizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Produto", "Nome", "Quantidade", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
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
        tabela_ItensPedidosAtualizar.getTableHeader().setReorderingAllowed(false);
        jScrollPane1_ItensPedidosAtualizar.setViewportView(tabela_ItensPedidosAtualizar);
        if (tabela_ItensPedidosAtualizar.getColumnModel().getColumnCount() > 0) {
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(0).setResizable(false);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(1).setResizable(false);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(2).setResizable(false);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(2).setPreferredWidth(390);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(3).setResizable(false);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(3).setPreferredWidth(160);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(4).setResizable(false);
            tabela_ItensPedidosAtualizar.getColumnModel().getColumn(4).setPreferredWidth(184);
        }

        panel_AtualizarPedido.add(jScrollPane1_ItensPedidosAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 65, 852, 200));
        panel_AtualizarPedido.add(linha_InferiorAtualizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 522, 852, 10));

        combobox_ProdutoAtualizar.setMinimumSize(new java.awt.Dimension(240, 24));
        combobox_ProdutoAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));
        combobox_ProdutoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_ProdutoAtualizarActionPerformed(evt);
            }
        });
        panel_AtualizarPedido.add(combobox_ProdutoAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_AtualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_AtualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoradio_ClienteCadastradoSimAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoradio_ClienteCadastradoSimAtualizarActionPerformed
    }//GEN-LAST:event_botaoradio_ClienteCadastradoSimAtualizarActionPerformed

    private void botaoradio_ClienteCadastradoNaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoradio_ClienteCadastradoNaoAtualizarActionPerformed
    }//GEN-LAST:event_botaoradio_ClienteCadastradoNaoAtualizarActionPerformed

    private void botao_ConfirmarAtualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarAtualizarPedidoActionPerformed
       
        double valorPedido = 0.0;
        for (int i = 0; i < tabela_ItensPedidosAtualizar.getRowCount(); i++) {
            Object subtotalObj = tabela_ItensPedidosAtualizar.getValueAt(i, 4); 
            if (subtotalObj != null) {
                valorPedido += (Double) subtotalObj;
            }
        }
        Pedidos p = new Pedidos();

        if (campo_ClienteAtualizar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o cliente!");
        } 
        else {
            String clienteTexto = campo_ClienteAtualizar.getText().trim();
            String situacao = combobox_StatusdoPedidoAtualizar.getSelectedItem().toString();
            String nomePedido = clienteTexto;
                    

            
                if (botaoradio_ClienteCadastradoNaoAtualizar.isSelected()) {
                
                p.atualizarPedidoController(idPedido, null, nomePedido, valorPedido, situacao);

            } else if (botaoradio_ClienteCadastradoSimAtualizar.isSelected()) {
                
                Object[] dados = p.buscarIDeNomeClienteController(clienteTexto);
                
              
                if (dados != null && dados.length >= 2) {
                    this.idcliente = (int) dados[0];
                    this.nomecliente = (String) dados[1];

                    p.atualizarPedidoController(idPedido, this.idcliente, this.nomecliente, valorPedido, situacao);
                }
                else{
                    return;
                }
            }
        JOptionPane.showMessageDialog(null, "Pedido Atulizado com sucesso!");
        
        Panel_GestaoPedidos panel = new Panel_GestaoPedidos(tela);
        tela.mudar_Panel(panel); 
        }

    }//GEN-LAST:event_botao_ConfirmarAtualizarPedidoActionPerformed

    private void botao_VoltarAtualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarAtualizarPedidoActionPerformed
     Panel_GestaoPedidos panel = new Panel_GestaoPedidos(tela);
     tela.mudar_Panel(panel);             
    }//GEN-LAST:event_botao_VoltarAtualizarPedidoActionPerformed

    private void botao_RenoverProdutodoPedidoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RenoverProdutodoPedidoAtualizarActionPerformed
                int id = tela.searchCollumn(tabela_ItensPedidosAtualizar);
        if (id > 0) {
            int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                Itens_Pedidos ip = new Itens_Pedidos();
                ip.removeItemPedidoController(id);
                JOptionPane.showMessageDialog(null, "Pedido foi removido com sucesso");
                List<Object[]> lista = ip.getAllItensPedidoController(this.idPedido);
                tela.updateTable(tabela_ItensPedidosAtualizar,lista);

            }
        }

    }//GEN-LAST:event_botao_RenoverProdutodoPedidoAtualizarActionPerformed

    private void botao_AdicionarProdutonoPedidoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AdicionarProdutonoPedidoAtualizarActionPerformed
                        Itens_Pedidos ip = new Itens_Pedidos();
        String textoSelecionado = (String) combobox_ProdutoAtualizar.getSelectedItem();
        boolean produtoValido = false;

       
        if (textoSelecionado != null && !textoSelecionado.trim().isEmpty()) {
            for (int i = 0; i < combobox_ProdutoAtualizar.getItemCount(); i++) {
                if (combobox_ProdutoAtualizar.getItemAt(i).toString().equalsIgnoreCase(textoSelecionado)) {
                    produtoValido = true;
                    break; 
                }
            }
        }

       
        if (!produtoValido) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um produto válido da lista.", "Produto Inválido", JOptionPane.WARNING_MESSAGE);
            combobox_ProdutoAtualizar.requestFocus();
            return; 
        }

        else if (campoformatado_QuantidadeAtualizar.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");

        } else {
            String produto = combobox_ProdutoAtualizar.getSelectedItem().toString();
            int quantidade = Integer.parseInt(campoformatado_QuantidadeAtualizar.getText().trim());

            ip.addItemPedidoController(idPedido, produto, quantidade);

            List<Object[]> lista = ip.getAllItensPedidoController(this.idPedido);
            tela.updateTable(tabela_ItensPedidosAtualizar, lista);
        }
    }//GEN-LAST:event_botao_AdicionarProdutonoPedidoAtualizarActionPerformed

    private void combobox_ProdutoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_ProdutoAtualizarActionPerformed
    }//GEN-LAST:event_combobox_ProdutoAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_AdicionarProdutonoPedidoAtualizar;
    private javax.swing.JButton botao_ConfirmarAtualizarPedido;
    private javax.swing.JButton botao_RenoverProdutodoPedidoAtualizar;
    private javax.swing.JButton botao_VoltarAtualizarPedido;
    private javax.swing.JRadioButton botaoradio_ClienteCadastradoNaoAtualizar;
    private javax.swing.JRadioButton botaoradio_ClienteCadastradoSimAtualizar;
    private javax.swing.JTextField campo_ClienteAtualizar;
    private javax.swing.JFormattedTextField campoformatado_QuantidadeAtualizar;
    private javax.swing.JComboBox<String> combobox_ProdutoAtualizar;
    private javax.swing.JComboBox<String> combobox_StatusdoPedidoAtualizar;
    private javax.swing.ButtonGroup grupobotao_AtualizarPedido;
    private javax.swing.JScrollPane jScrollPane1_ItensPedidosAtualizar;
    private javax.swing.JSeparator linha_DSuperiorAtualizarPedido;
    private javax.swing.JSeparator linha_ESuperiorAtualizarPedido;
    private javax.swing.JSeparator linha_InferiorAtualizarPedido;
    private javax.swing.JPanel panel_AtualizarPedido;
    private javax.swing.JTable tabela_ItensPedidosAtualizar;
    private javax.swing.JLabel texto_AtualizarPedido;
    private javax.swing.JLabel texto_ClienteAtualizar;
    private javax.swing.JLabel texto_ClienteCadastradoAtualizar;
    private javax.swing.JLabel texto_ProdutoAtualizar;
    private javax.swing.JLabel texto_QuantidadeAtualizar;
    private javax.swing.JLabel texto_StatusdoPedidoAtualizar;
    // End of variables declaration//GEN-END:variables
}
