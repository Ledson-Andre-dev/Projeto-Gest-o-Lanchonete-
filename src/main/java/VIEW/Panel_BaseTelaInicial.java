
package VIEW;


import CONTROLLER.Configuracao;


public class Panel_BaseTelaInicial extends javax.swing.JPanel {

public Panel_BaseTelaInicial( ) { 
        initComponents();

        Configuracao config = new Configuracao();
        String[] vetor = config.preencherConfigurarController(); // obtém dados do banco

        if (vetor != null && vetor[0] != null && !vetor[0].isEmpty()) {
            preencherBaseTelaInicial(vetor); // preenche os campos do painel
        }
    }

public void preencherBaseTelaInicial(String[] dados) {
        if (dados == null || dados.length < 4) return; 

        
        if (dados[1] != null) {
            mensagemIndicativa.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
            
            mensagemIndicativa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            mensagemIndicativa.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            
        
            java.awt.Dimension tamanhoForcado = new java.awt.Dimension(900, 200);
            mensagemIndicativa.setMinimumSize(tamanhoForcado);
            mensagemIndicativa.setPreferredSize(tamanhoForcado);
            mensagemIndicativa.setMaximumSize(tamanhoForcado);
         
            mensagemIndicativa.setText("<html><p style='width: 450px; text-align: center;'>" + dados[1] + "</p></html>");
        } else {
            mensagemIndicativa.setText("");
        }
        
        
        String caminhoBanner = dados[3];
        if (caminhoBanner != null && !caminhoBanner.isEmpty()) {
            javax.swing.ImageIcon imagem = new javax.swing.ImageIcon(caminhoBanner);
            int largura = logoMaior.getWidth() > 0 ? logoMaior.getWidth() : 300;
            int altura = logoMaior.getHeight() > 0 ? logoMaior.getHeight() : 300;
            java.awt.Image imgRedimensionada = imagem.getImage().getScaledInstance(
                    largura,
                    altura,
                    java.awt.Image.SCALE_SMOOTH
            );
            logoMaior.setText("");
            logoMaior.setIcon(new javax.swing.ImageIcon(imgRedimensionada));
        } else {
            logoMaior.setText("Clique para adicionar banner");
            logoMaior.setIcon(null);
        }
    }   



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_BaseTelaInicial = new javax.swing.JPanel();
        logoMaior = new javax.swing.JLabel();
        mensagemBemvindo = new javax.swing.JLabel();
        mensagemIndicativa = new javax.swing.JLabel();

        panel_BaseTelaInicial.setBackground(new java.awt.Color(237, 246, 238));
        panel_BaseTelaInicial.setPreferredSize(new java.awt.Dimension(920, 640));

        logoMaior.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        logoMaior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoMaior.setText("Logo");
        logoMaior.setPreferredSize(new java.awt.Dimension(300, 300));

        mensagemBemvindo.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        mensagemBemvindo.setText("Seja bem-vindo! ");

        mensagemIndicativa.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        mensagemIndicativa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensagemIndicativa.setText("Use o menu lateral para selecionar as opcoes de gestao!");
        mensagemIndicativa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panel_BaseTelaInicialLayout = new javax.swing.GroupLayout(panel_BaseTelaInicial);
        panel_BaseTelaInicial.setLayout(panel_BaseTelaInicialLayout);
        panel_BaseTelaInicialLayout.setHorizontalGroup(
            panel_BaseTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BaseTelaInicialLayout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(mensagemBemvindo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel_BaseTelaInicialLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(logoMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_BaseTelaInicialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mensagemIndicativa)
                .addGap(217, 217, 217))
        );
        panel_BaseTelaInicialLayout.setVerticalGroup(
            panel_BaseTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BaseTelaInicialLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(logoMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mensagemBemvindo)
                .addGap(24, 24, 24)
                .addComponent(mensagemIndicativa)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 932, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel_BaseTelaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel_BaseTelaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logoMaior;
    private javax.swing.JLabel mensagemBemvindo;
    private javax.swing.JLabel mensagemIndicativa;
    private javax.swing.JPanel panel_BaseTelaInicial;
    // End of variables declaration//GEN-END:variables
}
