
package VIEW;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import CONTROLLER.Produtos;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Panel_AtualizarProduto extends javax.swing.JPanel {    
    private String caminho;     
    private Tela_Inicial tela;
    private int id;

    public Panel_AtualizarProduto() {
        initComponents();
    }
    
     public Panel_AtualizarProduto(Tela_Inicial tela,int id) {
        this.id = id;
        this.tela = tela;
        initComponents();
        
        campo_PrecoAtualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                
                String numeros = campo_PrecoAtualizar.getText().replaceAll("\\D", "");

                if (numeros.isEmpty()) {
                    campo_PrecoAtualizar.setText("");
                    return;
                }

               
                if (numeros.length() > 5) {
                    numeros = numeros.substring(0, 5);
                }

                double valor = Double.parseDouble(numeros) / 100.0;
                java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
                String textoFormatado = df.format(valor).replace(".", ",");
                campo_PrecoAtualizar.setText(textoFormatado);
                campo_PrecoAtualizar.setCaretPosition(textoFormatado.length());
            }
        });
        tela.configurarBotaoEnter(this, botao_ConfirmarCadastrarProdutoAtualizar);
        tela.limitarCaracteres(campo_NomedoProdutoAtualizar, 100);
        tela.limitarCaracteres(areatexto_DescricaoAtualizar, 255);

        Produtos p = new Produtos();

        String[] vetor = p.preencherAtualizarProduto(id);
        
        if (vetor != null && !vetor[0].isEmpty()) {
            preencherCamposProduto(vetor);;
        }
    }

    public void preencherCamposProduto(String[] dados) {
        if (dados == null || dados.length < 6) return; 

       
        campo_NomedoProdutoAtualizar.setText(dados[0] != null ? dados[0] : "");
        campo_PrecoAtualizar.setText(dados[1] != null ? dados[1] : "");

      
        if (dados[2] != null) {
            combobox_CategoriaProdutoAtualizar.setSelectedItem(dados[2]);
        } else {
            combobox_CategoriaProdutoAtualizar.setSelectedIndex(-1);
        }

        
        areatexto_DescricaoAtualizar.setText(dados[3] != null ? dados[3] : "");

        
        String status = dados[4] != null ? dados[4] : "";
        if ("Ativo".equalsIgnoreCase(status)) {
            botaoradio_AtivoProdutoAtualizar.setSelected(true);
        } else if ("Inativo".equalsIgnoreCase(status)) {
            botaoradio_InativoProdutoAtualizar.setSelected(true);
        } else {
            botaoradio_AtivoProdutoAtualizar.setSelected(false);
            botaoradio_InativoProdutoAtualizar.setSelected(false);
        }

     
        String caminhoImagem = dados[5];
        if (caminhoImagem != null && !caminhoImagem.isEmpty()) {
            ImageIcon imagem = new ImageIcon(caminhoImagem);
            Image imgRedimensionada = imagem.getImage().getScaledInstance(
                    200,
                    200, 
                    Image.SCALE_SMOOTH
            );
            texto_ImagemProdutoAtualizar.setText("");
            texto_ImagemProdutoAtualizar.setIcon(new ImageIcon(imgRedimensionada));
            caminho = caminhoImagem;
        } else {
            texto_ImagemProdutoAtualizar.setText("Clique para adicionar imagem");
            texto_ImagemProdutoAtualizar.setIcon(null);
            caminho = null;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotao_AtualizarProduto = new javax.swing.ButtonGroup();
        panel_AtualizarProduto = new javax.swing.JPanel();
        texto_AtualizarProduto = new javax.swing.JLabel();
        texto_NomedoProdutoAtualizar = new javax.swing.JLabel();
        texto_PrecoAtualizar = new javax.swing.JLabel();
        texto_CategoriaAtualizar = new javax.swing.JLabel();
        texto_DescricaoAtualizar = new javax.swing.JLabel();
        texto_StatusdoProdutoAtualizar = new javax.swing.JLabel();
        campo_NomedoProdutoAtualizar = new javax.swing.JTextField();
        campo_PrecoAtualizar = new javax.swing.JTextField();
        botaoradio_AtivoProdutoAtualizar = new javax.swing.JRadioButton();
        botaoradio_InativoProdutoAtualizar = new javax.swing.JRadioButton();
        linha_InferiorCadastrarProdutoAtualizar = new javax.swing.JSeparator();
        linha_DSuperiorCadastrarProdutoAtualizar = new javax.swing.JSeparator();
        linha_ESuperiorCadastrarProdutoAtualizar = new javax.swing.JSeparator();
        botao_VoltarCadastrarProdutoAtualizar = new javax.swing.JButton();
        botao_ConfirmarCadastrarProdutoAtualizar = new javax.swing.JButton();
        combobox_CategoriaProdutoAtualizar = new javax.swing.JComboBox<>();
        ScrollPane_DescricaoAtualizar = new javax.swing.JScrollPane();
        areatexto_DescricaoAtualizar = new javax.swing.JTextArea();
        texto_ImagemProdutoAtualizar = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(920, 640));

        panel_AtualizarProduto.setBackground(new java.awt.Color(250, 250, 250));
        panel_AtualizarProduto.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_AtualizarProduto.setBackground(new java.awt.Color(250, 250, 250));
        texto_AtualizarProduto.setFont(new java.awt.Font("Segoe UI", 0, 20));  
        texto_AtualizarProduto.setText("Atualizar Produto");

        texto_NomedoProdutoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NomedoProdutoAtualizar.setText("Nome do Produto");

        texto_PrecoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_PrecoAtualizar.setText("Preço:");

        texto_CategoriaAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_CategoriaAtualizar.setText("Categoria:");

        texto_DescricaoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_DescricaoAtualizar.setText("Descrição:");

        texto_StatusdoProdutoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_StatusdoProdutoAtualizar.setText("Status do Produto:");

        campo_NomedoProdutoAtualizar.setPreferredSize(new java.awt.Dimension(490, 24));
        campo_NomedoProdutoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_NomedoProdutoAtualizarActionPerformed(evt);
            }
        });

        campo_PrecoAtualizar.setText(" ");
        campo_PrecoAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));

        grupobotao_AtualizarProduto.add(botaoradio_AtivoProdutoAtualizar);
        botaoradio_AtivoProdutoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_AtivoProdutoAtualizar.setText("Ativo");
        botaoradio_AtivoProdutoAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_AtivoProdutoAtualizar.setIconTextGap(10);
        botaoradio_AtivoProdutoAtualizar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        grupobotao_AtualizarProduto.add(botaoradio_InativoProdutoAtualizar);
        botaoradio_InativoProdutoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_InativoProdutoAtualizar.setText("Inativo");
        botaoradio_InativoProdutoAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_InativoProdutoAtualizar.setIconTextGap(10);

        botao_VoltarCadastrarProdutoAtualizar.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarCadastrarProdutoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarCadastrarProdutoAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarCadastrarProdutoAtualizar.setText("Voltar");
        botao_VoltarCadastrarProdutoAtualizar.setBorder(null);
        botao_VoltarCadastrarProdutoAtualizar.setBorderPainted(false);
        botao_VoltarCadastrarProdutoAtualizar.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_VoltarCadastrarProdutoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarCadastrarProdutoAtualizarActionPerformed(evt);
            }
        });

        botao_ConfirmarCadastrarProdutoAtualizar.setBackground(new java.awt.Color(148, 189, 154));
        botao_ConfirmarCadastrarProdutoAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_ConfirmarCadastrarProdutoAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        botao_ConfirmarCadastrarProdutoAtualizar.setText("Confirmar");
        botao_ConfirmarCadastrarProdutoAtualizar.setBorder(null);
        botao_ConfirmarCadastrarProdutoAtualizar.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_ConfirmarCadastrarProdutoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarCadastrarProdutoAtualizarActionPerformed(evt);
            }
        });

        combobox_CategoriaProdutoAtualizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Lanches", "Porções", "Bebidas", "Sobremesas", "Acompanhamentos", "Outro" }));
        combobox_CategoriaProdutoAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));
        combobox_CategoriaProdutoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_CategoriaProdutoAtualizarActionPerformed(evt);
            }
        });

        areatexto_DescricaoAtualizar.setColumns(20);
        areatexto_DescricaoAtualizar.setRows(5);
        ScrollPane_DescricaoAtualizar.setViewportView(areatexto_DescricaoAtualizar);
        areatexto_DescricaoAtualizar.setLineWrap(true);
        areatexto_DescricaoAtualizar.setWrapStyleWord(true);

        texto_ImagemProdutoAtualizar.setBackground(new java.awt.Color(230, 230, 230));
        texto_ImagemProdutoAtualizar.setOpaque(true);
        texto_ImagemProdutoAtualizar.setPreferredSize(new java.awt.Dimension(200, 200));
        texto_ImagemProdutoAtualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Selecione uma imagem");
                    fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "png", "jpeg", "gif"));

                    int resultado = fileChooser.showOpenDialog(Panel_AtualizarProduto.this);

                    if (resultado == JFileChooser.APPROVE_OPTION) {
                        caminho = fileChooser.getSelectedFile().getAbsolutePath();

                        ImageIcon imagem = new ImageIcon(caminho);
                        Image imgRedimensionada = imagem.getImage().getScaledInstance(
                                texto_ImagemProdutoAtualizar.getWidth(),
                                texto_ImagemProdutoAtualizar.getHeight(),
                                Image.SCALE_SMOOTH
                        );

                        texto_ImagemProdutoAtualizar.setText("");
                        texto_ImagemProdutoAtualizar.setIcon(new ImageIcon(imgRedimensionada));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Panel_AtualizarProduto.this,
                            "Erro ao carregar a imagem: " + ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        javax.swing.GroupLayout panel_AtualizarProdutoLayout = new javax.swing.GroupLayout(panel_AtualizarProduto);
        panel_AtualizarProduto.setLayout(panel_AtualizarProdutoLayout);
        panel_AtualizarProdutoLayout.setHorizontalGroup(
            panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(linha_ESuperiorCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(texto_AtualizarProduto)
                .addGap(28, 28, 28)
                .addComponent(linha_DSuperiorCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(texto_ImagemProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_NomedoProdutoAtualizar)
                    .addComponent(campo_NomedoProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                        .addComponent(texto_PrecoAtualizar)
                        .addGap(202, 202, 202)
                        .addComponent(texto_CategoriaAtualizar))
                    .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                        .addComponent(campo_PrecoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(combobox_CategoriaProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(texto_DescricaoAtualizar)
                    .addComponent(ScrollPane_DescricaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(texto_StatusdoProdutoAtualizar)
                .addGap(10, 10, 10)
                .addComponent(botaoradio_AtivoProdutoAtualizar)
                .addGap(19, 19, 19)
                .addComponent(botaoradio_InativoProdutoAtualizar))
            .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(linha_InferiorCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(botao_VoltarCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(480, 480, 480)
                .addComponent(botao_ConfirmarCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_AtualizarProdutoLayout.setVerticalGroup(
            panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_AtualizarProduto)
                    .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linha_ESuperiorCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_DSuperiorCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58)
                .addGroup(panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(texto_ImagemProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_AtualizarProdutoLayout.createSequentialGroup()
                        .addComponent(texto_NomedoProdutoAtualizar)
                        .addGap(15, 15, 15)
                        .addComponent(campo_NomedoProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_PrecoAtualizar)
                            .addComponent(texto_CategoriaAtualizar))
                        .addGap(15, 15, 15)
                        .addGroup(panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_PrecoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_CategoriaProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(texto_DescricaoAtualizar)
                        .addGap(15, 15, 15)
                        .addComponent(ScrollPane_DescricaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_StatusdoProdutoAtualizar)
                    .addComponent(botaoradio_AtivoProdutoAtualizar)
                    .addComponent(botaoradio_InativoProdutoAtualizar))
                .addGap(70, 70, 70)
                .addComponent(linha_InferiorCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel_AtualizarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_VoltarCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_ConfirmarCadastrarProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_AtualizarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_AtualizarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_NomedoProdutoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_NomedoProdutoAtualizarActionPerformed
    }//GEN-LAST:event_campo_NomedoProdutoAtualizarActionPerformed

    private void botao_VoltarCadastrarProdutoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarCadastrarProdutoAtualizarActionPerformed
    Panel_GestaoProdutos panel = new Panel_GestaoProdutos(tela);
     tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_VoltarCadastrarProdutoAtualizarActionPerformed

    private void botao_ConfirmarCadastrarProdutoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarCadastrarProdutoAtualizarActionPerformed
        if (campo_NomedoProdutoAtualizar.getText().trim().isEmpty() ||
            campo_PrecoAtualizar.getText().trim().isEmpty() ||
            combobox_CategoriaProdutoAtualizar.getSelectedIndex() == 0 ||
            areatexto_DescricaoAtualizar.getText().trim().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
        } else {
            String nome = campo_NomedoProdutoAtualizar.getText().trim();
            double preco = Double.parseDouble(campo_PrecoAtualizar.getText().trim().replace(",", "."));
            String categoria = combobox_CategoriaProdutoAtualizar.getSelectedItem().toString();
            String descricao = areatexto_DescricaoAtualizar.getText().trim();
            String status = botaoradio_AtivoProdutoAtualizar.isSelected() ? "Ativo" : "Inativo";
            
            Produtos p = new Produtos();
            p.updateProduto(nome, preco, categoria, descricao, status, caminho, this.id,tela.idf);
            
            Panel_GestaoProdutos panel = new Panel_GestaoProdutos(tela);
            tela.mudar_Panel(panel);
        }

    }//GEN-LAST:event_botao_ConfirmarCadastrarProdutoAtualizarActionPerformed

    private void combobox_CategoriaProdutoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_CategoriaProdutoAtualizarActionPerformed
        
    }//GEN-LAST:event_combobox_CategoriaProdutoAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane_DescricaoAtualizar;
    private javax.swing.JTextArea areatexto_DescricaoAtualizar;
    private javax.swing.JButton botao_ConfirmarCadastrarProdutoAtualizar;
    private javax.swing.JButton botao_VoltarCadastrarProdutoAtualizar;
    private javax.swing.JRadioButton botaoradio_AtivoProdutoAtualizar;
    private javax.swing.JRadioButton botaoradio_InativoProdutoAtualizar;
    private javax.swing.JTextField campo_NomedoProdutoAtualizar;
    private javax.swing.JTextField campo_PrecoAtualizar;
    private javax.swing.JComboBox<String> combobox_CategoriaProdutoAtualizar;
    private javax.swing.ButtonGroup grupobotao_AtualizarProduto;
    private javax.swing.JSeparator linha_DSuperiorCadastrarProdutoAtualizar;
    private javax.swing.JSeparator linha_ESuperiorCadastrarProdutoAtualizar;
    private javax.swing.JSeparator linha_InferiorCadastrarProdutoAtualizar;
    private javax.swing.JPanel panel_AtualizarProduto;
    private javax.swing.JLabel texto_AtualizarProduto;
    private javax.swing.JLabel texto_CategoriaAtualizar;
    private javax.swing.JLabel texto_DescricaoAtualizar;
    private javax.swing.JLabel texto_ImagemProdutoAtualizar;
    private javax.swing.JLabel texto_NomedoProdutoAtualizar;
    private javax.swing.JLabel texto_PrecoAtualizar;
    private javax.swing.JLabel texto_StatusdoProdutoAtualizar;
    // End of variables declaration//GEN-END:variables
}
