
package VIEW;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import com.formdev.flatlaf.FlatClientProperties;

import java.awt.event.*;
import java.text.NumberFormat;

import CONTROLLER.Itens_Pedidos;
import CONTROLLER.Pedidos;
import CONTROLLER.Produtos;



public class Panel_CadastrarPedido extends javax.swing.JPanel {
    
    private Tela_Inicial tela;
    
    private List<Object[]> lista = new ArrayList<>();

    public Panel_CadastrarPedido() {
        initComponents();

    }
    
     public Panel_CadastrarPedido(Tela_Inicial tela) {
        this.tela = tela;
        initComponents();
        this.placeHolder();
        campoformatado_Quantidade.setFormatterFactory(null);

        campoformatado_Quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char tecla = evt.getKeyChar();
                
                if (tecla == java.awt.event.KeyEvent.VK_BACK_SPACE || tecla == java.awt.event.KeyEvent.VK_DELETE) {
                    return; 
                }
                
                if (!Character.isDigit(tecla) || campoformatado_Quantidade.getText().length() >= 3) {
                    evt.consume();
                }
            }
        });
        
        tela.configurarBotaoEnter(this, botao_ConfirmarCadastrarPedido);
        configurarComboBoxPesquisa(combobox_Produto);
        tela.limitarCaracteres(campo_Cliente, 100);
       
        
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

        if (campo_Cliente != null) {
            campo_Cliente.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Com Cadastro: CPF / Sem Cadastro: NOME");

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotao_CadastrarPedido = new javax.swing.ButtonGroup();
        panel_CadastrarPedido = new javax.swing.JPanel();
        linha_ESuperiorCadastrarPedido = new javax.swing.JSeparator();
        texto_CadastrarPedido = new javax.swing.JLabel();
        linha_DSuperiorCadastrarPedido = new javax.swing.JSeparator();
        linha_InferiorCadastrarPedido = new javax.swing.JSeparator();
        texto_Cliente = new javax.swing.JLabel();
        texto_Quantidade = new javax.swing.JLabel();
        texto_Produto = new javax.swing.JLabel();
        texto_StatusdoPedido = new javax.swing.JLabel();
        texto_ClienteCadastrado = new javax.swing.JLabel();
        campo_Cliente = new javax.swing.JTextField();
        campoformatado_Quantidade = new javax.swing.JFormattedTextField();
        combobox_StatusdoPedido = new javax.swing.JComboBox<>();
        botaoradio_ClienteCadastradoSim = new javax.swing.JRadioButton();
        botaoradio_ClienteCadastradoNao = new javax.swing.JRadioButton();
        botao_ConfirmarCadastrarPedido = new javax.swing.JButton();
        botao_VoltarCadastrarPedido = new javax.swing.JButton();
        botao_RenoverProdutodoPedido = new javax.swing.JButton();
        botao_AdicionarProdutonoPedido = new javax.swing.JButton();
        jScrollPane1_ItensPedidosCadastrar = new javax.swing.JScrollPane();
        tabela_ItensPedidosCadastrar = new javax.swing.JTable();
        combobox_Produto = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(920, 640));

        panel_CadastrarPedido.setBackground(new java.awt.Color(250, 250, 250));
        panel_CadastrarPedido.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_CadastrarPedido.setBackground(new java.awt.Color(250, 250, 250));
        texto_CadastrarPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        texto_CadastrarPedido.setText("Cadastrar Pedido");

        texto_Cliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Cliente.setText("Cliente: ");

        texto_Quantidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Quantidade.setText("Qtd.:");

        texto_Produto.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Produto.setText("Produto:");

        texto_StatusdoPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_StatusdoPedido.setText("Status do Pedido:");

        texto_ClienteCadastrado.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_ClienteCadastrado.setText("Cliente Cadastrado:");

        campo_Cliente.setPreferredSize(new java.awt.Dimension(320, 24));



        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false); 
        format.setMaximumIntegerDigits(3); 

        
        NumberFormatter numberFormatter = new NumberFormatter(format);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(true); 
        numberFormatter.setMinimum(0); 

        // 3. Aplica o formatador no seu campo 
        campoformatado_Quantidade.setFormatterFactory(new DefaultFormatterFactory(numberFormatter));

        campoformatado_Quantidade.setPreferredSize(new java.awt.Dimension(100, 24));

        combobox_StatusdoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Concluído", "Cancelado" }));
        combobox_StatusdoPedido.setPreferredSize(new java.awt.Dimension(350, 24));

        grupobotao_CadastrarPedido.add(botaoradio_ClienteCadastradoSim);
        botaoradio_ClienteCadastradoSim.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_ClienteCadastradoSim.setText("Sim");
        botaoradio_ClienteCadastradoSim.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_ClienteCadastradoSim.setIconTextGap(10);
        botaoradio_ClienteCadastradoSim.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        botaoradio_ClienteCadastradoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoradio_ClienteCadastradoSimActionPerformed(evt);
            }
        });

        grupobotao_CadastrarPedido.add(botaoradio_ClienteCadastradoNao);
        botaoradio_ClienteCadastradoNao.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_ClienteCadastradoNao.setText("Não");
        botaoradio_ClienteCadastradoNao.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_ClienteCadastradoNao.setIconTextGap(10);
        botaoradio_ClienteCadastradoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoradio_ClienteCadastradoNaoActionPerformed(evt);
            }
        });

        botao_ConfirmarCadastrarPedido.setBackground(new java.awt.Color(148, 189, 154));
        botao_ConfirmarCadastrarPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_ConfirmarCadastrarPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_ConfirmarCadastrarPedido.setText("Confirmar");
        botao_ConfirmarCadastrarPedido.setBorder(null);
        botao_ConfirmarCadastrarPedido.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_ConfirmarCadastrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarCadastrarPedidoActionPerformed(evt);
            }
        });

        botao_VoltarCadastrarPedido.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarCadastrarPedido.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarCadastrarPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarCadastrarPedido.setText("Voltar");
        botao_VoltarCadastrarPedido.setBorder(null);
        botao_VoltarCadastrarPedido.setBorderPainted(false);
        botao_VoltarCadastrarPedido.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_VoltarCadastrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarCadastrarPedidoActionPerformed(evt);
            }
        });

        botao_RenoverProdutodoPedido.setBackground(new java.awt.Color(255, 164, 114));
        botao_RenoverProdutodoPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_RenoverProdutodoPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_RenoverProdutodoPedido.setText("Remover");
        botao_RenoverProdutodoPedido.setBorder(null);
        botao_RenoverProdutodoPedido.setBorderPainted(false);
        botao_RenoverProdutodoPedido.setPreferredSize(new java.awt.Dimension(150, 30));
        botao_RenoverProdutodoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RenoverProdutodoPedidoActionPerformed(evt);
            }
        });

        botao_AdicionarProdutonoPedido.setBackground(new java.awt.Color(148, 189, 154));
        botao_AdicionarProdutonoPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_AdicionarProdutonoPedido.setForeground(new java.awt.Color(255, 255, 255));
        botao_AdicionarProdutonoPedido.setText("Adicionar");
        botao_AdicionarProdutonoPedido.setBorder(null);
        botao_AdicionarProdutonoPedido.setPreferredSize(new java.awt.Dimension(150, 30));
        botao_AdicionarProdutonoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AdicionarProdutonoPedidoActionPerformed(evt);
            }
        });

        tabela_ItensPedidosCadastrar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela_ItensPedidosCadastrar.getTableHeader().setReorderingAllowed(false);
        jScrollPane1_ItensPedidosCadastrar.setViewportView(tabela_ItensPedidosCadastrar);
        if (tabela_ItensPedidosCadastrar.getColumnModel().getColumnCount() > 0) {
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(0).setResizable(false);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(1).setResizable(false);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(2).setResizable(false);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(2).setPreferredWidth(390);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(3).setResizable(false);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(3).setPreferredWidth(160);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(4).setResizable(false);
            tabela_ItensPedidosCadastrar.getColumnModel().getColumn(4).setPreferredWidth(184);
        }

        combobox_Produto.setMinimumSize(new java.awt.Dimension(240, 24));
        combobox_Produto.setPreferredSize(new java.awt.Dimension(240, 24));
        combobox_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_ProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_CadastrarPedidoLayout = new javax.swing.GroupLayout(panel_CadastrarPedido);
        panel_CadastrarPedido.setLayout(panel_CadastrarPedidoLayout);
        panel_CadastrarPedidoLayout.setHorizontalGroup(
            panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(linha_ESuperiorCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(texto_CadastrarPedido)
                .addGap(26, 26, 26)
                .addComponent(linha_DSuperiorCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1_ItensPedidosCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(texto_Cliente)
                .addGap(378, 378, 378)
                .addComponent(texto_StatusdoPedido))
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(campo_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(combobox_StatusdoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(texto_ClienteCadastrado)
                .addGap(17, 17, 17)
                .addComponent(botaoradio_ClienteCadastradoSim)
                .addGap(31, 31, 31)
                .addComponent(botaoradio_ClienteCadastradoNao)
                .addGap(118, 118, 118)
                .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Produto)
                    .addComponent(combobox_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Quantidade)
                    .addComponent(campoformatado_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(botao_AdicionarProdutonoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(botao_RenoverProdutodoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(linha_InferiorCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(botao_VoltarCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(492, 492, 492)
                .addComponent(botao_ConfirmarCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_CadastrarPedidoLayout.setVerticalGroup(
            panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_CadastrarPedido)
                    .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linha_ESuperiorCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_DSuperiorCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1_ItensPedidosCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Cliente)
                    .addComponent(texto_StatusdoPedido))
                .addGap(5, 5, 5)
                .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_StatusdoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                        .addComponent(texto_Produto)
                        .addGap(5, 5, 5)
                        .addComponent(combobox_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                        .addComponent(texto_Quantidade)
                        .addGap(5, 5, 5)
                        .addComponent(campoformatado_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarPedidoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_ClienteCadastrado)
                            .addComponent(botaoradio_ClienteCadastradoSim)
                            .addComponent(botaoradio_ClienteCadastradoNao))))
                .addGap(16, 16, 16)
                .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_AdicionarProdutonoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_RenoverProdutodoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(linha_InferiorCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel_CadastrarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_VoltarCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_ConfirmarCadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_CadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_CadastrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botao_RenoverProdutodoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RenoverProdutodoPedidoActionPerformed

        int linhaSelecionada = tabela_ItensPedidosCadastrar.getSelectedRow(); 

        if (linhaSelecionada >= 0) {
            
            this.lista.remove(linhaSelecionada);
            
            DefaultTableModel model = (DefaultTableModel) tabela_ItensPedidosCadastrar.getModel();
            model.removeRow(linhaSelecionada);
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Por favor, selecione um item na tabela para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_botao_RenoverProdutodoPedidoActionPerformed

    private void botao_AdicionarProdutonoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AdicionarProdutonoPedidoActionPerformed
        Itens_Pedidos ip = new Itens_Pedidos();
        String textoSelecionado = (String) combobox_Produto.getSelectedItem();
        boolean produtoValido = false;

        if (textoSelecionado != null && !textoSelecionado.trim().isEmpty()) {
            for (int i = 0; i < combobox_Produto.getItemCount(); i++) {
                if (combobox_Produto.getItemAt(i).toString().equalsIgnoreCase(textoSelecionado)) {
                    produtoValido = true;
                    break; 
                }
            }
        }
        if (!produtoValido) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um produto válido da lista.", "Produto Inválido", JOptionPane.WARNING_MESSAGE);
            combobox_Produto.requestFocus(); 
            return; 
        }
        else if (campoformatado_Quantidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");

        } else {
            String produto = combobox_Produto.getSelectedItem().toString();
            int quantidade = Integer.parseInt(campoformatado_Quantidade.getText().trim());

            // Atualiza a tabela com os itens do pedido atual
            this.lista.add(ip.getDetalhesItemParaTabelaController(produto , quantidade));  
            tela.updateTable(tabela_ItensPedidosCadastrar, lista);
        }

    }//GEN-LAST:event_botao_AdicionarProdutonoPedidoActionPerformed

    private void botaoradio_ClienteCadastradoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoradio_ClienteCadastradoNaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoradio_ClienteCadastradoNaoActionPerformed

    private void botao_ConfirmarCadastrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarCadastrarPedidoActionPerformed
    
 
    if (this.lista == null || this.lista.isEmpty()) {
        JOptionPane.showMessageDialog(null, "O pedido está vazio! Adicione itens primeiro.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return; 
    }

    if (campo_Cliente.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Preencha o cliente!");
        return; 
    }

   
    double valorPedido = 0.0;
    for (Object[] item : this.lista) {
        valorPedido += (Double) item[4]; 
    }

    String clienteTexto = campo_Cliente.getText().trim();
    String situacao = combobox_StatusdoPedido.getSelectedItem().toString();
    
   
    Integer idClienteFinal = null; 
    String nomeClienteFinal = clienteTexto;

    Pedidos p = new Pedidos(); 

  
    if (botaoradio_ClienteCadastradoNao.isSelected()) {
        idClienteFinal = null;
        nomeClienteFinal = clienteTexto;

    } else if (botaoradio_ClienteCadastradoSim.isSelected()) {
      
        Object[] dados = p.buscarIDeNomeClienteController(clienteTexto);

        if (dados != null && dados.length >= 2) {
            idClienteFinal = (int) dados[0];
            nomeClienteFinal = (String) dados[1];
        } else {
            return; 
        }
    }

    
    int idNovoPedido = p.criarPedidoRetornandoIdController(idClienteFinal, nomeClienteFinal, valorPedido, situacao);

    
    if (idNovoPedido != -1) { 
        
       
        Itens_Pedidos ip = new Itens_Pedidos(); 

        for (Object[] item : this.lista) {
            int idProduto = (int) item[1];      
            int quantidade = (int) item[3];    
            double subtotal = (double) item[4]; 

            
            ip.inserirItemDiretoController(idNovoPedido, idProduto, quantidade, subtotal);
        }

      
        this.lista.clear(); 
        DefaultTableModel model = (DefaultTableModel) tabela_ItensPedidosCadastrar.getModel();
        model.setRowCount(0);
        campo_Cliente.setText(""); 
        
        JOptionPane.showMessageDialog(null, "Pedido Cadastrado com sucesso!");
        
        Panel_GestaoPedidos panel = new Panel_GestaoPedidos(tela);
        tela.mudar_Panel(panel); 

    } else {
        JOptionPane.showMessageDialog(null, "Erro ao registrar o pedido no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_botao_ConfirmarCadastrarPedidoActionPerformed

    private void botao_VoltarCadastrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarCadastrarPedidoActionPerformed
     Panel_GestaoPedidos panel = new Panel_GestaoPedidos(tela);
     tela.mudar_Panel(panel);       
    }//GEN-LAST:event_botao_VoltarCadastrarPedidoActionPerformed

    private void botaoradio_ClienteCadastradoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoradio_ClienteCadastradoSimActionPerformed
    }//GEN-LAST:event_botaoradio_ClienteCadastradoSimActionPerformed

    private void combobox_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_ProdutoActionPerformed
    }//GEN-LAST:event_combobox_ProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_AdicionarProdutonoPedido;
    private javax.swing.JButton botao_ConfirmarCadastrarPedido;
    private javax.swing.JButton botao_RenoverProdutodoPedido;
    private javax.swing.JButton botao_VoltarCadastrarPedido;
    private javax.swing.JRadioButton botaoradio_ClienteCadastradoNao;
    private javax.swing.JRadioButton botaoradio_ClienteCadastradoSim;
    private javax.swing.JTextField campo_Cliente;
    private javax.swing.JFormattedTextField campoformatado_Quantidade;
    private javax.swing.JComboBox<String> combobox_Produto;
    private javax.swing.JComboBox<String> combobox_StatusdoPedido;
    private javax.swing.ButtonGroup grupobotao_CadastrarPedido;
    private javax.swing.JScrollPane jScrollPane1_ItensPedidosCadastrar;
    private javax.swing.JSeparator linha_DSuperiorCadastrarPedido;
    private javax.swing.JSeparator linha_ESuperiorCadastrarPedido;
    private javax.swing.JSeparator linha_InferiorCadastrarPedido;
    private javax.swing.JPanel panel_CadastrarPedido;
    private javax.swing.JTable tabela_ItensPedidosCadastrar;
    private javax.swing.JLabel texto_CadastrarPedido;
    private javax.swing.JLabel texto_Cliente;
    private javax.swing.JLabel texto_ClienteCadastrado;
    private javax.swing.JLabel texto_Produto;
    private javax.swing.JLabel texto_Quantidade;
    private javax.swing.JLabel texto_StatusdoPedido;
    // End of variables declaration//GEN-END:variables
}
