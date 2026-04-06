
package VIEW;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import CONTROLLER.Produtos;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Panel_CadastrarProduto extends javax.swing.JPanel {
    private String caminho;     
    private Tela_Inicial tela;
 
    public Panel_CadastrarProduto() {
        initComponents();
    }
    public Panel_CadastrarProduto(Tela_Inicial tela) {
        this.tela = tela;
        initComponents();
        
        campo_Preco.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
              
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String numeros = campo_Preco.getText().replaceAll("\\D", "");

                if (numeros.isEmpty()) {
                    campo_Preco.setText("");
                    return;
                }

                if (numeros.length() > 5) {
                    numeros = numeros.substring(0, 5);
                }

                double valor = Double.parseDouble(numeros) / 100.0;

                java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
                String textoFormatado = df.format(valor).replace(".", ",");

                campo_Preco.setText(textoFormatado);
                
                campo_Preco.setCaretPosition(textoFormatado.length());
            }
        });
        tela.configurarBotaoEnter(this, botao_ConfirmarCadastrarProduto);
        tela.limitarCaracteres(campo_NomedoProduto, 100);
        tela.limitarCaracteres(areatexto_Descricao, 255);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotao_CadastrarProduto = new javax.swing.ButtonGroup();
        panel_CadastrarProduto = new javax.swing.JPanel();
        texto_CadastrarProduto = new javax.swing.JLabel();
        texto_NomedoProduto = new javax.swing.JLabel();
        texto_Preco = new javax.swing.JLabel();
        texto_Categoria = new javax.swing.JLabel();
        texto_Descricao = new javax.swing.JLabel();
        texto_StatusdoProduto = new javax.swing.JLabel();
        campo_NomedoProduto = new javax.swing.JTextField();
        campo_Preco = new javax.swing.JTextField();
        botaoradio_AtivoProduto = new javax.swing.JRadioButton();
        botaoradio_InativoProduto = new javax.swing.JRadioButton();
        linha_InferiorCadastrarProduto = new javax.swing.JSeparator();
        linha_DSuperiorCadastrarProduto = new javax.swing.JSeparator();
        linha_ESuperiorCadastrarProduto = new javax.swing.JSeparator();
        botao_VoltarCadastrarProduto = new javax.swing.JButton();
        botao_ConfirmarCadastrarProduto = new javax.swing.JButton();
        combobox_CategoriaProduto = new javax.swing.JComboBox<>();
        ScrollPane_Descricao = new javax.swing.JScrollPane();
        areatexto_Descricao = new javax.swing.JTextArea();
        texto_ImagemProdutoCadastrar = new javax.swing.JLabel();

        panel_CadastrarProduto.setBackground(new java.awt.Color(250, 250, 250));

        texto_CadastrarProduto.setBackground(new java.awt.Color(250, 250, 250));
        texto_CadastrarProduto.setFont(new java.awt.Font("Segoe UI", 0, 20));
        texto_CadastrarProduto.setText("Cadastrar Produto");

        texto_NomedoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NomedoProduto.setText("Nome do Produto");

        texto_Preco.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Preco.setText("Preço:");

        texto_Categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Categoria.setText("Categoria:");

        texto_Descricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Descricao.setText("Descrição:");

        texto_StatusdoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_StatusdoProduto.setText("Status do Produto:");

        campo_NomedoProduto.setPreferredSize(new java.awt.Dimension(490, 24));
        campo_NomedoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_NomedoProdutoActionPerformed(evt);
            }
        });

        campo_Preco.setText(" ");
        campo_Preco.setPreferredSize(new java.awt.Dimension(240, 24));

        grupobotao_CadastrarProduto.add(botaoradio_AtivoProduto);
        botaoradio_AtivoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_AtivoProduto.setSelected(true);
        botaoradio_AtivoProduto.setText("Ativo");
        botaoradio_AtivoProduto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_AtivoProduto.setIconTextGap(10);
        botaoradio_AtivoProduto.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        grupobotao_CadastrarProduto.add(botaoradio_InativoProduto);
        botaoradio_InativoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_InativoProduto.setText("Inativo");
        botaoradio_InativoProduto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_InativoProduto.setIconTextGap(10);

        botao_VoltarCadastrarProduto.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarCadastrarProduto.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarCadastrarProduto.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarCadastrarProduto.setText("Voltar");
        botao_VoltarCadastrarProduto.setBorder(null);
        botao_VoltarCadastrarProduto.setBorderPainted(false);
        botao_VoltarCadastrarProduto.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_VoltarCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarCadastrarProdutoActionPerformed(evt);
            }
        });

        botao_ConfirmarCadastrarProduto.setBackground(new java.awt.Color(148, 189, 154));
        botao_ConfirmarCadastrarProduto.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_ConfirmarCadastrarProduto.setForeground(new java.awt.Color(255, 255, 255));
        botao_ConfirmarCadastrarProduto.setText("Confirmar");
        botao_ConfirmarCadastrarProduto.setBorder(null);
        botao_ConfirmarCadastrarProduto.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_ConfirmarCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarCadastrarProdutoActionPerformed(evt);
            }
        });

        combobox_CategoriaProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Lanches", "Porções", "Bebidas", "Sobremesas", "Acompanhamentos", "Outros" }));
        combobox_CategoriaProduto.setPreferredSize(new java.awt.Dimension(240, 24));
        combobox_CategoriaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_CategoriaProdutoActionPerformed(evt);
            }
        });

        areatexto_Descricao.setColumns(20);
        areatexto_Descricao.setRows(5);
        ScrollPane_Descricao.setViewportView(areatexto_Descricao);
        areatexto_Descricao.setLineWrap(true);
        areatexto_Descricao.setWrapStyleWord(true);

        texto_ImagemProdutoCadastrar.setBackground(new java.awt.Color(230, 230, 230));
        texto_ImagemProdutoCadastrar.setOpaque(true);
        texto_ImagemProdutoCadastrar.setPreferredSize(new java.awt.Dimension(200, 200));
        texto_ImagemProdutoCadastrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Selecione uma imagem");
                    fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "png", "jpeg", "gif"));

                    int resultado = fileChooser.showOpenDialog(Panel_CadastrarProduto.this);

                    if (resultado == JFileChooser.APPROVE_OPTION) {
                        caminho = fileChooser.getSelectedFile().getAbsolutePath();

                        ImageIcon imagem = new ImageIcon(caminho);
                        Image imgRedimensionada = imagem.getImage().getScaledInstance(
                                texto_ImagemProdutoCadastrar.getWidth(),
                                texto_ImagemProdutoCadastrar.getHeight(),
                                Image.SCALE_SMOOTH
                        );

                        texto_ImagemProdutoCadastrar.setText("");
                        texto_ImagemProdutoCadastrar.setIcon(new ImageIcon(imgRedimensionada));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Panel_CadastrarProduto.this,
                            "Erro ao carregar a imagem: " + ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        javax.swing.GroupLayout panel_CadastrarProdutoLayout = new javax.swing.GroupLayout(panel_CadastrarProduto);
        panel_CadastrarProduto.setLayout(panel_CadastrarProdutoLayout);
        panel_CadastrarProdutoLayout.setHorizontalGroup(
            panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(linha_ESuperiorCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(texto_CadastrarProduto)
                .addGap(22, 22, 22)
                .addComponent(linha_DSuperiorCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(texto_ImagemProdutoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_NomedoProduto)
                    .addComponent(campo_NomedoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                        .addComponent(texto_Preco)
                        .addGap(202, 202, 202)
                        .addComponent(texto_Categoria))
                    .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                        .addComponent(campo_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(combobox_CategoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(texto_Descricao)
                    .addComponent(ScrollPane_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(texto_StatusdoProduto)
                .addGap(10, 10, 10)
                .addComponent(botaoradio_AtivoProduto)
                .addGap(19, 19, 19)
                .addComponent(botaoradio_InativoProduto))
            .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(linha_InferiorCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(botao_VoltarCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(480, 480, 480)
                .addComponent(botao_ConfirmarCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_CadastrarProdutoLayout.setVerticalGroup(
            panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_CadastrarProduto)
                    .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linha_ESuperiorCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_DSuperiorCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58)
                .addGroup(panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(texto_ImagemProdutoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarProdutoLayout.createSequentialGroup()
                        .addComponent(texto_NomedoProduto)
                        .addGap(15, 15, 15)
                        .addComponent(campo_NomedoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_Preco)
                            .addComponent(texto_Categoria))
                        .addGap(15, 15, 15)
                        .addGroup(panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_CategoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(texto_Descricao)
                        .addGap(15, 15, 15)
                        .addComponent(ScrollPane_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_StatusdoProduto)
                    .addComponent(botaoradio_AtivoProduto)
                    .addComponent(botaoradio_InativoProduto))
                .addGap(70, 70, 70)
                .addComponent(linha_InferiorCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel_CadastrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_VoltarCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_ConfirmarCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_CadastrarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_CadastrarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_NomedoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_NomedoProdutoActionPerformed
    }//GEN-LAST:event_campo_NomedoProdutoActionPerformed

    private void botao_VoltarCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarCadastrarProdutoActionPerformed
     Panel_GestaoProdutos panel = new Panel_GestaoProdutos(tela);
     tela.mudar_Panel(panel);
      
    }//GEN-LAST:event_botao_VoltarCadastrarProdutoActionPerformed

    private void botao_ConfirmarCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarCadastrarProdutoActionPerformed
        if (campo_NomedoProduto.getText().trim().isEmpty() ||
            campo_Preco.getText().trim().isEmpty() ||
            combobox_CategoriaProduto.getSelectedIndex() == 0 ||
            areatexto_Descricao.getText().trim().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
        } else {
            String nome = campo_NomedoProduto.getText().trim();
            double preco = Double.parseDouble(campo_Preco.getText().trim().replace(",", "."));
            String categoria = combobox_CategoriaProduto.getSelectedItem().toString();
            String descricao = areatexto_Descricao.getText().trim();
            String status = botaoradio_AtivoProduto.isSelected() ? "Ativo" : "Inativo";

            Produtos p = new Produtos();
            p.addProdutoController(nome, preco, categoria, descricao, status, caminho,tela.idf);
            
            Panel_GestaoProdutos panel = new Panel_GestaoProdutos(tela);
            tela.mudar_Panel(panel);
        }

    }//GEN-LAST:event_botao_ConfirmarCadastrarProdutoActionPerformed

    private void combobox_CategoriaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_CategoriaProdutoActionPerformed
    }//GEN-LAST:event_combobox_CategoriaProdutoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane_Descricao;
    private javax.swing.JTextArea areatexto_Descricao;
    private javax.swing.JButton botao_ConfirmarCadastrarProduto;
    private javax.swing.JButton botao_VoltarCadastrarProduto;
    private javax.swing.JRadioButton botaoradio_AtivoProduto;
    private javax.swing.JRadioButton botaoradio_InativoProduto;
    private javax.swing.JTextField campo_NomedoProduto;
    private javax.swing.JTextField campo_Preco;
    private javax.swing.JComboBox<String> combobox_CategoriaProduto;
    private javax.swing.ButtonGroup grupobotao_CadastrarProduto;
    private javax.swing.JSeparator linha_DSuperiorCadastrarProduto;
    private javax.swing.JSeparator linha_ESuperiorCadastrarProduto;
    private javax.swing.JSeparator linha_InferiorCadastrarProduto;
    private javax.swing.JPanel panel_CadastrarProduto;
    private javax.swing.JLabel texto_CadastrarProduto;
    private javax.swing.JLabel texto_Categoria;
    private javax.swing.JLabel texto_Descricao;
    private javax.swing.JLabel texto_ImagemProdutoCadastrar;
    private javax.swing.JLabel texto_NomedoProduto;
    private javax.swing.JLabel texto_Preco;
    private javax.swing.JLabel texto_StatusdoProduto;
    // End of variables declaration//GEN-END:variables
}
