
package VIEW;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import CONTROLLER.Configuracao;

import java.awt.Image;
import java.awt.event.MouseEvent;

public class Panel_Configuracoes extends javax.swing.JPanel {
    private String caminhoLogoMaior;
    private String caminhoLogoMenor;
    private Tela_Inicial tela;

    public Panel_Configuracoes() {
        initComponents();
    }
    public Panel_Configuracoes(Tela_Inicial tela) { 
    this.tela = tela;
    initComponents();
    tela.configurarBotaoEnter(this, botao_ConfirmarConfiguracoes);

    tela.limitarCaracteres(areatexto_DescricaoConfiguracoes, 250);
    tela.limitarCaracteres(campo_NomedaEmpresa, 150);
    
    Configuracao config = new Configuracao();

        String[] vetor = config.preencherConfigurarController();
        
        if (vetor != null && !vetor[0].isEmpty()) {
            preencherCamposConfiguracao(vetor);
        }
    }

    @SuppressWarnings("unchecked")

public void preencherCamposConfiguracao(String[] dados) {
    if (dados == null || dados.length < 4) return;   

    campo_NomedaEmpresa.setText(dados[0] != null ? dados[0] : "");

    
    areatexto_DescricaoConfiguracoes.setText(dados[1] != null ? dados[1] : "");

    caminhoLogoMaior = dados[3]; 
    if (caminhoLogoMaior != null && !caminhoLogoMaior.isEmpty()) {
        ImageIcon imagem = new ImageIcon(caminhoLogoMaior);
        int largura = texto_ImagemLogoMaior.getWidth() > 0 ? texto_ImagemLogoMaior.getWidth() : 300;
        int altura = texto_ImagemLogoMaior.getHeight() > 0 ? texto_ImagemLogoMaior.getHeight() : 300;
        Image imgRedimensionada = imagem.getImage().getScaledInstance(
                largura,
                altura,
                Image.SCALE_SMOOTH
        );
        texto_ImagemLogoMaior.setText("");
        texto_ImagemLogoMaior.setIcon(new ImageIcon(imgRedimensionada));
    } else {
        texto_ImagemLogoMaior.setText("Clique para adicionar logo");
        texto_ImagemLogoMaior.setIcon(null);
    }

    caminhoLogoMenor = dados[2]; 
    if (caminhoLogoMenor != null && !caminhoLogoMenor.isEmpty()) {
        ImageIcon imagem = new ImageIcon(caminhoLogoMenor);
        int largura = texto_ImagemLogoMenor.getWidth() > 0 ? texto_ImagemLogoMenor.getWidth() : 80;
        int altura = texto_ImagemLogoMenor.getHeight() > 0 ? texto_ImagemLogoMenor.getHeight() : 80;
        Image imgRedimensionada = imagem.getImage().getScaledInstance(
                largura,
                altura,
                Image.SCALE_SMOOTH
        );
        texto_ImagemLogoMenor.setText("");
        texto_ImagemLogoMenor.setIcon(new ImageIcon(imgRedimensionada));
    } else {
        texto_ImagemLogoMenor.setText("Clique para adicionar banner");
        texto_ImagemLogoMenor.setIcon(null);
    }
}



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Configuracoes = new javax.swing.JPanel();
        texto_Configuracoes = new javax.swing.JLabel();
        texto_NomedodaEmpresa = new javax.swing.JLabel();
        texto_DescricaoConfiguracoes = new javax.swing.JLabel();
        campo_NomedaEmpresa = new javax.swing.JTextField();
        linha_InferiorConfiguracoes = new javax.swing.JSeparator();
        linha_DSuperiorConfiguracoes = new javax.swing.JSeparator();
        linha_ESuperiorConfiguracoes = new javax.swing.JSeparator();
        botao_VerConfiguracoes = new javax.swing.JButton();
        botao_ConfirmarConfiguracoes = new javax.swing.JButton();
        ScrollPane_DescricaoConfiguracoes = new javax.swing.JScrollPane();
        areatexto_DescricaoConfiguracoes = new javax.swing.JTextArea();
        
        texto_ImagemLogoMaior = new javax.swing.JLabel();
        texto_ImagemLogoMenor = new javax.swing.JLabel();

        panel_Configuracoes.setBackground(new java.awt.Color(250, 250, 250));
        panel_Configuracoes.setPreferredSize(new java.awt.Dimension(920, 612));

        texto_Configuracoes.setBackground(new java.awt.Color(250, 250, 250));
        texto_Configuracoes.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        texto_Configuracoes.setText("Configurações");

        texto_NomedodaEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NomedodaEmpresa.setText("Nome da empresa");

        texto_DescricaoConfiguracoes.setFont(new java.awt.Font("Segoe UI", 0, 18));
        texto_DescricaoConfiguracoes.setText("Descrição:");

        campo_NomedaEmpresa.setPreferredSize(new java.awt.Dimension(490, 24));
        campo_NomedaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_NomedaEmpresaActionPerformed(evt);
            }
        });

        botao_VerConfiguracoes.setBackground(new java.awt.Color(255, 164, 114));
        botao_VerConfiguracoes.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VerConfiguracoes.setForeground(new java.awt.Color(255, 255, 255));
        botao_VerConfiguracoes.setText("Ver");
        botao_VerConfiguracoes.setBorder(null);
        botao_VerConfiguracoes.setBorderPainted(false);
        botao_VerConfiguracoes.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_VerConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VerConfiguracoesActionPerformed(evt);
            }
        });

        botao_ConfirmarConfiguracoes.setBackground(new java.awt.Color(148, 189, 154));
        botao_ConfirmarConfiguracoes.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_ConfirmarConfiguracoes.setForeground(new java.awt.Color(255, 255, 255));
        botao_ConfirmarConfiguracoes.setText("Confirmar");
        botao_ConfirmarConfiguracoes.setBorder(null);
        botao_ConfirmarConfiguracoes.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_ConfirmarConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarConfiguracoesActionPerformed(evt);
            }
        });

        areatexto_DescricaoConfiguracoes.setColumns(20);
        areatexto_DescricaoConfiguracoes.setRows(5);
        ScrollPane_DescricaoConfiguracoes.setViewportView(areatexto_DescricaoConfiguracoes);
        areatexto_DescricaoConfiguracoes.setLineWrap(true);
        areatexto_DescricaoConfiguracoes.setWrapStyleWord(true);

        texto_ImagemLogoMaior.setBackground(new java.awt.Color(230, 230, 230));
        texto_ImagemLogoMaior.setOpaque(true);
        texto_ImagemLogoMaior.setPreferredSize(new java.awt.Dimension(300, 300));
         texto_ImagemLogoMaior.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Selecione uma imagem para o Logo Maior");
                    fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "png", "jpeg", "gif"));

                    int resultado = fileChooser.showOpenDialog(Panel_Configuracoes.this);

                    if (resultado == JFileChooser.APPROVE_OPTION) {
                        caminhoLogoMaior = fileChooser.getSelectedFile().getAbsolutePath();

                        ImageIcon imagem = new ImageIcon(caminhoLogoMaior);
                        Image imgRedimensionada = imagem.getImage().getScaledInstance(
                                texto_ImagemLogoMaior.getWidth(),
                                texto_ImagemLogoMaior.getHeight(),
                                Image.SCALE_SMOOTH
                        );

                        texto_ImagemLogoMaior.setText("");
                        texto_ImagemLogoMaior.setIcon(new ImageIcon(imgRedimensionada));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Panel_Configuracoes.this,
                            "Erro ao carregar a imagem: " + ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        texto_ImagemLogoMenor.setBackground(new java.awt.Color(230, 230, 230));
        texto_ImagemLogoMenor.setOpaque(true);
        texto_ImagemLogoMenor.setPreferredSize(new java.awt.Dimension(80, 80));
        texto_ImagemLogoMenor.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Selecione uma imagem para o Logo Menor");
                    fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "png", "jpeg", "gif"));

                    int resultado = fileChooser.showOpenDialog(Panel_Configuracoes.this);

                    if (resultado == JFileChooser.APPROVE_OPTION) {
                        caminhoLogoMenor = fileChooser.getSelectedFile().getAbsolutePath();

                        ImageIcon imagem = new ImageIcon(caminhoLogoMenor);
                        Image imgRedimensionada = imagem.getImage().getScaledInstance(
                                texto_ImagemLogoMenor.getWidth(),
                                texto_ImagemLogoMenor.getHeight(),
                                Image.SCALE_SMOOTH
                        );

                        texto_ImagemLogoMenor.setText("");
                        texto_ImagemLogoMenor.setIcon(new ImageIcon(imgRedimensionada));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Panel_Configuracoes.this,
                            "Erro ao carregar a imagem: " + ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        javax.swing.GroupLayout panel_ConfiguracoesLayout = new javax.swing.GroupLayout(panel_Configuracoes);
        panel_Configuracoes.setLayout(panel_ConfiguracoesLayout);
        panel_ConfiguracoesLayout.setHorizontalGroup(
            panel_ConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ConfiguracoesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(linha_ESuperiorConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(texto_Configuracoes)
                .addGap(35, 35, 35)
                .addComponent(linha_DSuperiorConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_ConfiguracoesLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(texto_ImagemLogoMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panel_ConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_ImagemLogoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_NomedodaEmpresa)
                    .addComponent(campo_NomedaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_DescricaoConfiguracoes)
                    .addComponent(ScrollPane_DescricaoConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(panel_ConfiguracoesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(linha_InferiorConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_ConfiguracoesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(botao_VerConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(484, 484, 484)
                .addComponent(botao_ConfirmarConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_ConfiguracoesLayout.setVerticalGroup(
            panel_ConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ConfiguracoesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel_ConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Configuracoes)
                    .addGroup(panel_ConfiguracoesLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panel_ConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linha_ESuperiorConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_DSuperiorConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(90, 90, 90)
                .addGroup(panel_ConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_ImagemLogoMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ConfiguracoesLayout.createSequentialGroup()
                        .addComponent(texto_ImagemLogoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(texto_NomedodaEmpresa)
                        .addGap(5, 5, 5)
                        .addComponent(campo_NomedaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(texto_DescricaoConfiguracoes)
                        .addGap(5, 5, 5)
                        .addComponent(ScrollPane_DescricaoConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116)
                .addComponent(linha_InferiorConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panel_ConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_VerConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_ConfirmarConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_Configuracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_Configuracoes, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_NomedaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_NomedaEmpresaActionPerformed
    }//GEN-LAST:event_campo_NomedaEmpresaActionPerformed

    private void botao_VerConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VerConfiguracoesActionPerformed
        Panel_BaseTelaInicial panel = new Panel_BaseTelaInicial();
        tela.mudar_Panel(panel);

    }//GEN-LAST:event_botao_VerConfiguracoesActionPerformed

    private void botao_ConfirmarConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarConfiguracoesActionPerformed
        if (campo_NomedaEmpresa.getText().trim().isEmpty() ||
            areatexto_DescricaoConfiguracoes.getText().trim().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
        } else {
            String nome = campo_NomedaEmpresa.getText().trim();
            String descricao = areatexto_DescricaoConfiguracoes.getText().trim();

            
            String caminhoLogo = (caminhoLogoMenor != null) ? caminhoLogoMenor : "";
            String caminhoBanner = (caminhoLogoMaior != null) ? caminhoLogoMaior : "";

            Configuracao config = new Configuracao();
            config.updateConfiguracaoController(nome, descricao, caminhoLogo, caminhoBanner);
        }
            if (tela != null) {
        tela.preencherTelaInicial(); 
    }
    }//GEN-LAST:event_botao_ConfirmarConfiguracoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane_DescricaoConfiguracoes;
    private javax.swing.JTextArea areatexto_DescricaoConfiguracoes;
    private javax.swing.JButton botao_ConfirmarConfiguracoes;
    private javax.swing.JButton botao_VerConfiguracoes;
    private javax.swing.JTextField campo_NomedaEmpresa;
    private javax.swing.JSeparator linha_DSuperiorConfiguracoes;
    private javax.swing.JSeparator linha_ESuperiorConfiguracoes;
    private javax.swing.JSeparator linha_InferiorConfiguracoes;
    private javax.swing.JPanel panel_Configuracoes;
    private javax.swing.JLabel texto_Configuracoes;
    private javax.swing.JLabel texto_DescricaoConfiguracoes;
    private javax.swing.JLabel texto_ImagemLogoMaior;
    private javax.swing.JLabel texto_ImagemLogoMenor;
    private javax.swing.JLabel texto_NomedodaEmpresa;
    // End of variables declaration//GEN-END:variables
}
