package VIEW;


import java.awt.Desktop;
import java.net.URI;




public class Panel_Sobre extends javax.swing.JPanel {

    private Tela_Inicial tela;
     
    public Panel_Sobre() {
        initComponents();
       
    }
    
    public Panel_Sobre(Tela_Inicial tela){
    this.tela = tela;
    initComponents();
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Sobre = new javax.swing.JPanel();
        linha_SuperiorSobre = new javax.swing.JSeparator();
        linha_InferiorSobre = new javax.swing.JSeparator();
        texto_ProjetoAcadêmico = new javax.swing.JLabel();
        jScrollPane1_Sobre = new javax.swing.JScrollPane();
        jTextArea1_DescricaoSobreSistema = new javax.swing.JTextArea();
        texto_SistemadeGestãodeLanchonete = new javax.swing.JLabel();
        texto_Iconsby = new javax.swing.JLabel();
        texto_Icons8 = new javax.swing.JLabel();
        texto_Autores = new javax.swing.JLabel();
        texto_SobreoSistema = new javax.swing.JLabel();
        texto_IconsFornecidos = new javax.swing.JLabel();

        panel_Sobre.setBackground(new java.awt.Color(250, 250, 250));
        panel_Sobre.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_ProjetoAcadêmico.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_ProjetoAcadêmico.setText("Projeto acadêmico – 2026");

        jTextArea1_DescricaoSobreSistema.setEditable(false);
        jTextArea1_DescricaoSobreSistema.setColumns(20);
        jTextArea1_DescricaoSobreSistema.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        jTextArea1_DescricaoSobreSistema.setLineWrap(true);
        jTextArea1_DescricaoSobreSistema.setRows(5);
        jTextArea1_DescricaoSobreSistema.setText("O Sistema de Gestão de Lanchonete foi desenvolvido para auxiliar no controle e organização das operações internas do estabelecimento. Permite o cadastro e gerenciamento de clientes, produtos e pedidos, registrando automaticamente cada operação realizada. O sistema mantém um histórico detalhado com data, status e condição de cada registro, garantindo maior controle e rastreabilidade das informações. Na área administrativa, apenas o administrador possui permissão para remover registros, assegurando maior segurança e integridade dos dados. \n\nO sistema foi desenvolvido em Java com integração ao banco de dados MySQL, utilizando relacionamentos entre tabelas para garantir integridade referencial e consistência das informações registradas.");
        jTextArea1_DescricaoSobreSistema.setWrapStyleWord(true);
        jScrollPane1_Sobre.setViewportView(jTextArea1_DescricaoSobreSistema);

        texto_SistemadeGestãodeLanchonete.setFont(new java.awt.Font("Segoe UI", 0, 28)); 
        texto_SistemadeGestãodeLanchonete.setText("Sistema de Gestão de Lanchonete");

        texto_Iconsby.setFont(new java.awt.Font("Segoe UI", 0, 18));
        texto_Iconsby.setText("Icons by");

        texto_Icons8.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Icons8.setForeground(new java.awt.Color(11, 87, 208));
        texto_Icons8.setText("Icons8");
        texto_Icons8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        texto_Icons8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                texto_Icons8MouseClicked(evt);
            }
        });

        texto_Autores.setFont(new java.awt.Font("Segoe UI", 0, 18));
        texto_Autores.setText("Desenvolvido por Allan Bruno e Ledson André");

        texto_SobreoSistema.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        texto_SobreoSistema.setText("Sobre o sistema");

        texto_IconsFornecidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        texto_IconsFornecidos.setText("Todos os icons foram fornecidos por:");

        javax.swing.GroupLayout panel_SobreLayout = new javax.swing.GroupLayout(panel_Sobre);
        panel_Sobre.setLayout(panel_SobreLayout);
        panel_SobreLayout.setHorizontalGroup(
            panel_SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SobreLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_SobreLayout.createSequentialGroup()
                        .addComponent(texto_Iconsby)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_Icons8))
                    .addComponent(texto_SobreoSistema)
                    .addComponent(texto_ProjetoAcadêmico)
                    .addComponent(texto_SistemadeGestãodeLanchonete)
                    .addGroup(panel_SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(linha_InferiorSobre)
                        .addComponent(linha_SuperiorSobre)
                        .addComponent(jScrollPane1_Sobre, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(texto_Autores)
                    .addComponent(texto_IconsFornecidos))
                .addGap(38, 38, 38))
        );
        panel_SobreLayout.setVerticalGroup(
            panel_SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SobreLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(texto_SistemadeGestãodeLanchonete)
                .addGap(16, 16, 16)
                .addComponent(linha_SuperiorSobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto_SobreoSistema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1_Sobre, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(texto_IconsFornecidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_Iconsby)
                    .addComponent(texto_Icons8))
                .addGap(24, 24, 24)
                .addComponent(texto_Autores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto_ProjetoAcadêmico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(linha_InferiorSobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_Sobre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_Sobre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void texto_Icons8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_texto_Icons8MouseClicked
     try {
            Desktop.getDesktop().browse(new URI("https://icons8.com.br"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_texto_Icons8MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1_Sobre;
    private javax.swing.JTextArea jTextArea1_DescricaoSobreSistema;
    private javax.swing.JSeparator linha_InferiorSobre;
    private javax.swing.JSeparator linha_SuperiorSobre;
    private javax.swing.JPanel panel_Sobre;
    private javax.swing.JLabel texto_Autores;
    private javax.swing.JLabel texto_Icons8;
    private javax.swing.JLabel texto_IconsFornecidos;
    private javax.swing.JLabel texto_Iconsby;
    private javax.swing.JLabel texto_ProjetoAcadêmico;
    private javax.swing.JLabel texto_SistemadeGestãodeLanchonete;
    private javax.swing.JLabel texto_SobreoSistema;
    // End of variables declaration//GEN-END:variables
}
