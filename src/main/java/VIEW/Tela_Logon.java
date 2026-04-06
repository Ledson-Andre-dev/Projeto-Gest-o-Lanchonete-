
package VIEW;

import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatLightLaf;

import CONTROLLER.Configuracao;
import CONTROLLER.Funcionarios;


public class Tela_Logon extends javax.swing.JFrame {
    
    public Tela_Logon() {
        initComponents();
        
        Configuracao config = new Configuracao();
        String[] vetor = config.preencherConfigurarController();       
        String titulo = (vetor != null && vetor[0] != null && !vetor[0].isEmpty()) ? vetor[0] : "Lanchonete";
        this.setTitle(titulo);

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cor_De_Fundo = new javax.swing.JPanel();
        botao_Entrar = new javax.swing.JButton();
        campo_Senha = new javax.swing.JPasswordField();
        campo_Login = new javax.swing.JTextField();
        texto_Login = new javax.swing.JLabel();
        texto_Senha = new javax.swing.JLabel();
        imagem = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(218, 243, 234));
        setResizable(false);

        cor_De_Fundo.setBackground(new java.awt.Color(150, 215, 235));
        cor_De_Fundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botao_Entrar.setText("Entrar");
        botao_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_EntrarActionPerformed(evt);
            }
        });
        cor_De_Fundo.add(botao_Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 140, -1));

        campo_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_SenhaActionPerformed(evt);
            }
        });
        cor_De_Fundo.add(campo_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 280, -1));

        campo_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_LoginActionPerformed(evt);
            }
        });
        cor_De_Fundo.add(campo_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 280, -1));

        texto_Login.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        texto_Login.setText("Login:");
        cor_De_Fundo.add(texto_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, -1));

        texto_Senha.setFont(new java.awt.Font("SansSerif", 0, 12)); 
        texto_Senha.setText("Senha:");
        cor_De_Fundo.add(texto_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, -1));

        imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/login_image.jpg"))); 
        cor_De_Fundo.add(imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cor_De_Fundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cor_De_Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campo_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_LoginActionPerformed
        
    }//GEN-LAST:event_campo_LoginActionPerformed

    private void botao_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_EntrarActionPerformed
    if (campo_Login.getText().trim().isEmpty() || new String(campo_Senha.getPassword()).trim().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
    } else {   
        Funcionarios f = new Funcionarios();
        String login = campo_Login.getText().trim();
        String senha = new String(campo_Senha.getPassword()).trim();        
        boolean confirmar = f.checkLoginController(login,senha);
        if (confirmar==true) {
        f.searchIDController(login);
        Tela_Inicial telaInicial = new Tela_Inicial(f.getId());
        telaInicial.setVisible(true); 
        this.dispose(); 
        }
        else{
            JOptionPane.showMessageDialog(null, "Login ou senha incorreto");
        }
    }

    }//GEN-LAST:event_botao_EntrarActionPerformed

    private void campo_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_SenhaActionPerformed
        
    }//GEN-LAST:event_campo_SenhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
           try {
            FlatLightLaf.setup(); // ou FlatDarkLaf.setup()
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new Tela_Logon().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Entrar;
    private javax.swing.JTextField campo_Login;
    private javax.swing.JPasswordField campo_Senha;
    private javax.swing.JPanel cor_De_Fundo;
    private javax.swing.JLabel imagem;
    private javax.swing.JLabel texto_Login;
    private javax.swing.JLabel texto_Senha;
    // End of variables declaration//GEN-END:variables
}
