
package VIEW;

import javax.swing.JOptionPane;

import CONTROLLER.Funcionarios;

import CONTROLLER.Clientes;

public class Panel_CadastrarFuncionario extends javax.swing.JPanel {
    
    private Tela_Inicial tela;

    public Panel_CadastrarFuncionario() {
        initComponents();
    }
    
    public Panel_CadastrarFuncionario(Tela_Inicial tela) { 
    this.tela = tela;
    initComponents();
     tela.configurarBotaoEnter(this, botao_ConfirmarCadastrarFuncionario);
     tela.limitarCaracteres(campo_NomeCompletoFuncionario, 100);
     tela.limitarCaracteres(campo_NomedeUsuarioFuncionario, 30);
     tela.limitarCaracteres(campo_SenhaFuncionario, 30);
     tela.limitarCaracteres(campo_EmailFuncionario, 50);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotao_CadastrarFuncionario = new javax.swing.ButtonGroup();
        panel_CadastrarFuncionario = new javax.swing.JPanel();
        texto_CadastrarFuncionario = new javax.swing.JLabel();
        texto_NomeCompletoFuncionario = new javax.swing.JLabel();
        texto_CpfFuncionario = new javax.swing.JLabel();
        texto_CargoFuncionario = new javax.swing.JLabel();
        texto_NiveldeAcessoFuncionario = new javax.swing.JLabel();
        texto_NomedeUsuarioFuncionario = new javax.swing.JLabel();
        texto_SenhaFuncionario = new javax.swing.JLabel();
        texto_TelefoneFuncionario = new javax.swing.JLabel();
        texto_EmailFuncionario = new javax.swing.JLabel();
        texto_StatusdoFuncionario = new javax.swing.JLabel();
        campo_NomeCompletoFuncionario = new javax.swing.JTextField();
        campo_NomedeUsuarioFuncionario = new javax.swing.JTextField();
        campo_SenhaFuncionario = new javax.swing.JTextField();
        campo_EmailFuncionario = new javax.swing.JTextField();
        campoformatado_CpfFuncionario = new javax.swing.JFormattedTextField();
        campoformatado_TelefoneFuncionario = new javax.swing.JFormattedTextField();
        combobox_CargoFuncionario = new javax.swing.JComboBox<>();
        combobox_NiveldeAcessoFuncionario = new javax.swing.JComboBox<>();
        botaoradio_AtivoFuncionario = new javax.swing.JRadioButton();
        botaoradio_InativoFuncionario = new javax.swing.JRadioButton();
        linha_InferiorCadastrarFuncionario = new javax.swing.JSeparator();
        linha_DSuperiorCadastrarFuncionario = new javax.swing.JSeparator();
        linha_ESuperiorCadastrarFuncionario = new javax.swing.JSeparator();
        botao_VoltarCadastrarFuncionario = new javax.swing.JButton();
        botao_ConfirmarCadastrarFuncionario = new javax.swing.JButton();

        panel_CadastrarFuncionario.setBackground(new java.awt.Color(250, 250, 250));
        panel_CadastrarFuncionario.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_CadastrarFuncionario.setBackground(new java.awt.Color(250, 250, 250));
        texto_CadastrarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        texto_CadastrarFuncionario.setText("Cadastrar Funcionário");

        texto_NomeCompletoFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NomeCompletoFuncionario.setText("Nome completo:");

        texto_CpfFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_CpfFuncionario.setText("CPF:");

        texto_CargoFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_CargoFuncionario.setText("Cargo:");

        texto_NiveldeAcessoFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18));
        texto_NiveldeAcessoFuncionario.setText("Nível de acesso");

        texto_NomedeUsuarioFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NomedeUsuarioFuncionario.setText("Nome de usuário:");

        texto_SenhaFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_SenhaFuncionario.setText("Senha: ");

        texto_TelefoneFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_TelefoneFuncionario.setText("Telefone:");

        texto_EmailFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_EmailFuncionario.setText("E-mail:");

        texto_StatusdoFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_StatusdoFuncionario.setText("Status do funcionário:");

        campo_NomeCompletoFuncionario.setPreferredSize(new java.awt.Dimension(740, 24));
        campo_NomeCompletoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_NomeCompletoFuncionarioActionPerformed(evt);
            }
        });

        campo_NomedeUsuarioFuncionario.setPreferredSize(new java.awt.Dimension(360, 24));

        campo_SenhaFuncionario.setPreferredSize(new java.awt.Dimension(360, 24));

        campo_EmailFuncionario.setPreferredSize(new java.awt.Dimension(330, 24));
        campo_EmailFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_EmailFuncionarioActionPerformed(evt);
            }
        });

        try {
            campoformatado_CpfFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_CpfFuncionario.setPreferredSize(new java.awt.Dimension(240, 24));

        try {
            campoformatado_TelefoneFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_TelefoneFuncionario.setPreferredSize(new java.awt.Dimension(330, 24));
        campoformatado_TelefoneFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoformatado_TelefoneFuncionarioActionPerformed(evt);
            }
        });

        combobox_CargoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Atendente  ", "Caixa  ", "Cozinheiro  ", "Chapeiro  ", "Ajudante de Cozinha " }));
        combobox_CargoFuncionario.setPreferredSize(new java.awt.Dimension(240, 24));

        combobox_NiveldeAcessoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Administrador" }));
        combobox_NiveldeAcessoFuncionario.setPreferredSize(new java.awt.Dimension(240, 24));

        grupobotao_CadastrarFuncionario.add(botaoradio_AtivoFuncionario);
        botaoradio_AtivoFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_AtivoFuncionario.setSelected(true);
        botaoradio_AtivoFuncionario.setText("Ativo");
        botaoradio_AtivoFuncionario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_AtivoFuncionario.setIconTextGap(10);
        botaoradio_AtivoFuncionario.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        grupobotao_CadastrarFuncionario.add(botaoradio_InativoFuncionario);
        botaoradio_InativoFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_InativoFuncionario.setText("Inativo");
        botaoradio_InativoFuncionario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_InativoFuncionario.setIconTextGap(10);

        botao_VoltarCadastrarFuncionario.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarCadastrarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarCadastrarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarCadastrarFuncionario.setText("Voltar");
        botao_VoltarCadastrarFuncionario.setBorder(null);
        botao_VoltarCadastrarFuncionario.setBorderPainted(false);
        botao_VoltarCadastrarFuncionario.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_VoltarCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarCadastrarFuncionarioActionPerformed(evt);
            }
        });

        botao_ConfirmarCadastrarFuncionario.setBackground(new java.awt.Color(148, 189, 154));
        botao_ConfirmarCadastrarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_ConfirmarCadastrarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        botao_ConfirmarCadastrarFuncionario.setText("Confirmar");
        botao_ConfirmarCadastrarFuncionario.setBorder(null);
        botao_ConfirmarCadastrarFuncionario.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_ConfirmarCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarCadastrarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_CadastrarFuncionarioLayout = new javax.swing.GroupLayout(panel_CadastrarFuncionario);
        panel_CadastrarFuncionario.setLayout(panel_CadastrarFuncionarioLayout);
        panel_CadastrarFuncionarioLayout.setHorizontalGroup(
            panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(linha_ESuperiorCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(texto_CadastrarFuncionario)
                        .addGap(12, 12, 12)
                        .addComponent(linha_DSuperiorCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_NomeCompletoFuncionario))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(campo_NomeCompletoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_CpfFuncionario)
                        .addGap(216, 216, 216)
                        .addComponent(texto_CargoFuncionario)
                        .addGap(198, 198, 198)
                        .addComponent(texto_NiveldeAcessoFuncionario))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(campoformatado_CpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(combobox_CargoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(combobox_NiveldeAcessoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_NomedeUsuarioFuncionario)
                        .addGap(239, 239, 239)
                        .addComponent(texto_SenhaFuncionario))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(campo_NomedeUsuarioFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(campo_SenhaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_TelefoneFuncionario)
                        .addGap(269, 269, 269)
                        .addComponent(texto_EmailFuncionario))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(campoformatado_TelefoneFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(campo_EmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_StatusdoFuncionario)
                        .addGap(20, 20, 20)
                        .addComponent(botaoradio_AtivoFuncionario)
                        .addGap(20, 20, 20)
                        .addComponent(botaoradio_InativoFuncionario))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(linha_InferiorCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(botao_VoltarCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(480, 480, 480)
                        .addComponent(botao_ConfirmarCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panel_CadastrarFuncionarioLayout.setVerticalGroup(
            panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_CadastrarFuncionario)
                    .addGroup(panel_CadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linha_ESuperiorCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_DSuperiorCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(texto_NomeCompletoFuncionario)
                .addGap(5, 5, 5)
                .addComponent(campo_NomeCompletoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_CpfFuncionario)
                    .addComponent(texto_CargoFuncionario)
                    .addComponent(texto_NiveldeAcessoFuncionario))
                .addGap(5, 5, 5)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoformatado_CpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_CargoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_NiveldeAcessoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_NomedeUsuarioFuncionario)
                    .addComponent(texto_SenhaFuncionario))
                .addGap(10, 10, 10)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_NomedeUsuarioFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_SenhaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_TelefoneFuncionario)
                    .addComponent(texto_EmailFuncionario))
                .addGap(10, 10, 10)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoformatado_TelefoneFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_EmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_StatusdoFuncionario)
                    .addComponent(botaoradio_AtivoFuncionario)
                    .addComponent(botaoradio_InativoFuncionario))
                .addGap(40, 40, 40)
                .addComponent(linha_InferiorCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel_CadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_VoltarCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_ConfirmarCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_CadastrarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_CadastrarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_NomeCompletoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_NomeCompletoFuncionarioActionPerformed
    }//GEN-LAST:event_campo_NomeCompletoFuncionarioActionPerformed

    private void campo_EmailFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_EmailFuncionarioActionPerformed
    }//GEN-LAST:event_campo_EmailFuncionarioActionPerformed

    private void campoformatado_TelefoneFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoformatado_TelefoneFuncionarioActionPerformed
    }//GEN-LAST:event_campoformatado_TelefoneFuncionarioActionPerformed

    private void botao_VoltarCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarCadastrarFuncionarioActionPerformed

        Panel_GestaoFuncionarios panel = new Panel_GestaoFuncionarios(tela);
        tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_VoltarCadastrarFuncionarioActionPerformed

    private void botao_ConfirmarCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarCadastrarFuncionarioActionPerformed
         Clientes cliente = new Clientes();
        if (campo_NomeCompletoFuncionario.getText().trim().isEmpty() ||
            campoformatado_CpfFuncionario.getText().trim().isEmpty() ||
            combobox_CargoFuncionario.getSelectedIndex() == 0 ||
            campo_NomedeUsuarioFuncionario.getText().trim().isEmpty() ||
            campo_SenhaFuncionario.getText().trim().isEmpty() ||
            campoformatado_TelefoneFuncionario.getText().trim().isEmpty() ||
            campo_EmailFuncionario.getText().trim().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }

        else if (!cliente.isCpfValido(campoformatado_CpfFuncionario.getText())) {
        JOptionPane.showMessageDialog(null, "O CPF digitado é inválido! Verifique a digitação.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }

        else {   
            Funcionarios f = new Funcionarios();
        
            String nomeCompleto = campo_NomeCompletoFuncionario.getText().trim();
            String cpf = tela.limparNumeros(campoformatado_CpfFuncionario.getText().trim());
            String cargo = combobox_CargoFuncionario.getSelectedItem().toString();
            String nomeUsuario = campo_NomedeUsuarioFuncionario.getText().trim();
            String senha = campo_SenhaFuncionario.getText().trim();
            String telefone = tela.limparNumeros(campoformatado_TelefoneFuncionario.getText().trim());
            String email = campo_EmailFuncionario.getText().trim();

            int nivel_acesso = (combobox_NiveldeAcessoFuncionario.getSelectedIndex() == 0) ? 1 : 2;
            int status = botaoradio_AtivoFuncionario.isSelected() ? 1 : 2;

            f.addFuncionarioController(nomeCompleto, cpf, cargo, nivel_acesso, nomeUsuario, senha, telefone, email, status);
            Panel_GestaoFuncionarios panel = new Panel_GestaoFuncionarios(tela);
            tela.mudar_Panel(panel);
        }//GEN-LAST:event_botao_ConfirmarCadastrarFuncionarioActionPerformed
          
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_ConfirmarCadastrarFuncionario;
    private javax.swing.JButton botao_VoltarCadastrarFuncionario;
    private javax.swing.JRadioButton botaoradio_AtivoFuncionario;
    private javax.swing.JRadioButton botaoradio_InativoFuncionario;
    private javax.swing.JTextField campo_EmailFuncionario;
    private javax.swing.JTextField campo_NomeCompletoFuncionario;
    private javax.swing.JTextField campo_NomedeUsuarioFuncionario;
    private javax.swing.JTextField campo_SenhaFuncionario;
    private javax.swing.JFormattedTextField campoformatado_CpfFuncionario;
    private javax.swing.JFormattedTextField campoformatado_TelefoneFuncionario;
    private javax.swing.JComboBox<String> combobox_CargoFuncionario;
    private javax.swing.JComboBox<String> combobox_NiveldeAcessoFuncionario;
    private javax.swing.ButtonGroup grupobotao_CadastrarFuncionario;
    private javax.swing.JSeparator linha_DSuperiorCadastrarFuncionario;
    private javax.swing.JSeparator linha_ESuperiorCadastrarFuncionario;
    private javax.swing.JSeparator linha_InferiorCadastrarFuncionario;
    private javax.swing.JPanel panel_CadastrarFuncionario;
    private javax.swing.JLabel texto_CadastrarFuncionario;
    private javax.swing.JLabel texto_CargoFuncionario;
    private javax.swing.JLabel texto_CpfFuncionario;
    private javax.swing.JLabel texto_EmailFuncionario;
    private javax.swing.JLabel texto_NiveldeAcessoFuncionario;
    private javax.swing.JLabel texto_NomeCompletoFuncionario;
    private javax.swing.JLabel texto_NomedeUsuarioFuncionario;
    private javax.swing.JLabel texto_SenhaFuncionario;
    private javax.swing.JLabel texto_StatusdoFuncionario;
    private javax.swing.JLabel texto_TelefoneFuncionario;
    // End of variables declaration//GEN-END:variables
}
