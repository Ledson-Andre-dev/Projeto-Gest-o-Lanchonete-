
package VIEW;

import javax.swing.JOptionPane;

import CONTROLLER.Funcionarios;
import CONTROLLER.Clientes;

public class Panel_AtualizarFuncionario extends javax.swing.JPanel {
    private int id;
    private Tela_Inicial tela;
    
    public Panel_AtualizarFuncionario() {
        initComponents();
    }
      
    public Panel_AtualizarFuncionario(Tela_Inicial tela, int id) {      
    this.tela = tela;
    this.id = id;
    initComponents();
    tela.configurarBotaoEnter(this, botao_ConfirmarAtualizarFuncionario);
    tela.limitarCaracteres(campo_NomeCompletoFuncionarioAtualizar, 100);
    tela.limitarCaracteres(campo_NomedeUsuarioFuncionarioAtualizar, 30);
    tela.limitarCaracteres(campo_SenhaFuncionarioAtualizar, 30);
    tela.limitarCaracteres(campo_EmailFuncionarioAtualizar, 50);

    Funcionarios f = new Funcionarios();
    String[] vetor = f.preencherAtualizarFuncionariosController(id);
    if (!vetor[0].isEmpty()) {
    String[] funcionario = vetor; 
    preencherCamposFuncionario(funcionario); 
    }
    }

    public void preencherCamposFuncionario(Object[] dados) {
    if (dados == null || dados.length < 9) return; 

    
    campo_NomeCompletoFuncionarioAtualizar.setText((String) dados[0]);
    campoformatado_CpfFuncionarioAtualizar.setText((String) dados[1]);
    campo_NomedeUsuarioFuncionarioAtualizar.setText((String) dados[4]);
    campo_SenhaFuncionarioAtualizar.setText((String) dados[5]);
    campoformatado_TelefoneFuncionarioAtualizar.setText((String) dados[6]);
    campo_EmailFuncionarioAtualizar.setText((String) dados[7]);

    
    combobox_CargoFuncionarioAtualizar.setSelectedItem((String) dados[2]);       
    combobox_NiveldeAcessoFuncionarioAtualizar.setSelectedItem((String  ) dados[3]); 

    
    String status = (String) dados[8]; 
    if ("Ativo".equalsIgnoreCase(status)) {
        botaoradio_AtivoFuncionarioAtualizar.setSelected(true);
    } else if ("Inativo".equalsIgnoreCase(status)) {
        botaoradio_InativoFuncionarioAtualizar.setSelected(true);
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotao_AtualizarFuncionario = new javax.swing.ButtonGroup();
        panel_AtualizarFuncionario = new javax.swing.JPanel();
        texto_AtualizarFuncionario = new javax.swing.JLabel();
        texto_NomeCompletoFuncionarioAtualizar = new javax.swing.JLabel();
        texto_CpfFuncionarioAtualizar = new javax.swing.JLabel();
        texto_CargoFuncionarioAtualizar = new javax.swing.JLabel();
        texto_NiveldeAcessoFuncionarioAtualizar = new javax.swing.JLabel();
        texto_NomedeUsuarioFuncionarioAtualizar = new javax.swing.JLabel();
        texto_SenhaFuncionarioAtualizar = new javax.swing.JLabel();
        texto_TelefoneFuncionarioAtualizar = new javax.swing.JLabel();
        texto_EmailFuncionarioAtualizar = new javax.swing.JLabel();
        texto_StatusdoFuncionarioAtualizar = new javax.swing.JLabel();
        campo_NomeCompletoFuncionarioAtualizar = new javax.swing.JTextField();
        campo_NomedeUsuarioFuncionarioAtualizar = new javax.swing.JTextField();
        campo_SenhaFuncionarioAtualizar = new javax.swing.JTextField();
        campo_EmailFuncionarioAtualizar = new javax.swing.JTextField();
        campoformatado_CpfFuncionarioAtualizar = new javax.swing.JFormattedTextField();
        campoformatado_TelefoneFuncionarioAtualizar = new javax.swing.JFormattedTextField();
        combobox_CargoFuncionarioAtualizar = new javax.swing.JComboBox<>();
        combobox_NiveldeAcessoFuncionarioAtualizar = new javax.swing.JComboBox<>();
        botaoradio_AtivoFuncionarioAtualizar = new javax.swing.JRadioButton();
        botaoradio_InativoFuncionarioAtualizar = new javax.swing.JRadioButton();
        linha_InferiorCadastrarFuncionarioAtualizar = new javax.swing.JSeparator();
        linha_DSuperiorCadastrarFuncionarioAtualizar = new javax.swing.JSeparator();
        linha_ESuperiorCadastrarFuncionarioAtualizar = new javax.swing.JSeparator();
        botao_VoltarAtualizarFuncionario = new javax.swing.JButton();
        botao_ConfirmarAtualizarFuncionario = new javax.swing.JButton();

        panel_AtualizarFuncionario.setBackground(new java.awt.Color(250, 250, 250));
        panel_AtualizarFuncionario.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_AtualizarFuncionario.setBackground(new java.awt.Color(250, 250, 250));
        texto_AtualizarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 20));
        texto_AtualizarFuncionario.setText("Atualizar Funcionário");

        texto_NomeCompletoFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NomeCompletoFuncionarioAtualizar.setText("Nome completo:");

        texto_CpfFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_CpfFuncionarioAtualizar.setText("CPF:");

        texto_CargoFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_CargoFuncionarioAtualizar.setText("Cargo:");

        texto_NiveldeAcessoFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NiveldeAcessoFuncionarioAtualizar.setText("Nível de acesso");

        texto_NomedeUsuarioFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NomedeUsuarioFuncionarioAtualizar.setText("Nome de usuário:");

        texto_SenhaFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_SenhaFuncionarioAtualizar.setText("Senha: ");

        texto_TelefoneFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_TelefoneFuncionarioAtualizar.setText("Telefone:");

        texto_EmailFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_EmailFuncionarioAtualizar.setText("E-mail:");

        texto_StatusdoFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_StatusdoFuncionarioAtualizar.setText("Status do funcionário:");

        campo_NomeCompletoFuncionarioAtualizar.setPreferredSize(new java.awt.Dimension(740, 24));
        campo_NomeCompletoFuncionarioAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_NomeCompletoFuncionarioAtualizarActionPerformed(evt);
            }
        });

        campo_NomedeUsuarioFuncionarioAtualizar.setPreferredSize(new java.awt.Dimension(360, 24));

        campo_SenhaFuncionarioAtualizar.setPreferredSize(new java.awt.Dimension(360, 24));

        campo_EmailFuncionarioAtualizar.setPreferredSize(new java.awt.Dimension(330, 24));
        campo_EmailFuncionarioAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_EmailFuncionarioAtualizarActionPerformed(evt);
            }
        });

        try {
            campoformatado_CpfFuncionarioAtualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_CpfFuncionarioAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));

        try {
            campoformatado_TelefoneFuncionarioAtualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_TelefoneFuncionarioAtualizar.setPreferredSize(new java.awt.Dimension(330, 24));
        campoformatado_TelefoneFuncionarioAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoformatado_TelefoneFuncionarioAtualizarActionPerformed(evt);
            }
        });

        combobox_CargoFuncionarioAtualizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Atendente  ", "Caixa  ", "Cozinheiro  ", "Chapeiro  ", "Ajudante de Cozinha " }));
        combobox_CargoFuncionarioAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));

        combobox_NiveldeAcessoFuncionarioAtualizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Administrador" }));
        combobox_NiveldeAcessoFuncionarioAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));

        grupobotao_AtualizarFuncionario.add(botaoradio_AtivoFuncionarioAtualizar);
        botaoradio_AtivoFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_AtivoFuncionarioAtualizar.setText("Ativo");
        botaoradio_AtivoFuncionarioAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_AtivoFuncionarioAtualizar.setIconTextGap(10);
        botaoradio_AtivoFuncionarioAtualizar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        grupobotao_AtualizarFuncionario.add(botaoradio_InativoFuncionarioAtualizar);
        botaoradio_InativoFuncionarioAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_InativoFuncionarioAtualizar.setText("Inativo");
        botaoradio_InativoFuncionarioAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_InativoFuncionarioAtualizar.setIconTextGap(10);

        botao_VoltarAtualizarFuncionario.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarAtualizarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarAtualizarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarAtualizarFuncionario.setText("Voltar");
        botao_VoltarAtualizarFuncionario.setBorder(null);
        botao_VoltarAtualizarFuncionario.setBorderPainted(false);
        botao_VoltarAtualizarFuncionario.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_VoltarAtualizarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarAtualizarFuncionarioActionPerformed(evt);
            }
        });

        botao_ConfirmarAtualizarFuncionario.setBackground(new java.awt.Color(148, 189, 154));
        botao_ConfirmarAtualizarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_ConfirmarAtualizarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        botao_ConfirmarAtualizarFuncionario.setText("Confirmar");
        botao_ConfirmarAtualizarFuncionario.setBorder(null);
        botao_ConfirmarAtualizarFuncionario.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_ConfirmarAtualizarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarAtualizarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_AtualizarFuncionarioLayout = new javax.swing.GroupLayout(panel_AtualizarFuncionario);
        panel_AtualizarFuncionario.setLayout(panel_AtualizarFuncionarioLayout);
        panel_AtualizarFuncionarioLayout.setHorizontalGroup(
            panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(linha_ESuperiorCadastrarFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(texto_AtualizarFuncionario)
                        .addGap(12, 12, 12)
                        .addComponent(linha_DSuperiorCadastrarFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_NomeCompletoFuncionarioAtualizar))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(campo_NomeCompletoFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_CpfFuncionarioAtualizar)
                        .addGap(216, 216, 216)
                        .addComponent(texto_CargoFuncionarioAtualizar)
                        .addGap(198, 198, 198)
                        .addComponent(texto_NiveldeAcessoFuncionarioAtualizar))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(campoformatado_CpfFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(combobox_CargoFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(combobox_NiveldeAcessoFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_NomedeUsuarioFuncionarioAtualizar)
                        .addGap(239, 239, 239)
                        .addComponent(texto_SenhaFuncionarioAtualizar))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(campo_NomedeUsuarioFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(campo_SenhaFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_TelefoneFuncionarioAtualizar)
                        .addGap(269, 269, 269)
                        .addComponent(texto_EmailFuncionarioAtualizar))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(campoformatado_TelefoneFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(campo_EmailFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(texto_StatusdoFuncionarioAtualizar)
                        .addGap(20, 20, 20)
                        .addComponent(botaoradio_AtivoFuncionarioAtualizar)
                        .addGap(20, 20, 20)
                        .addComponent(botaoradio_InativoFuncionarioAtualizar))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(linha_InferiorCadastrarFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(botao_VoltarAtualizarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(480, 480, 480)
                        .addComponent(botao_ConfirmarAtualizarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panel_AtualizarFuncionarioLayout.setVerticalGroup(
            panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_AtualizarFuncionario)
                    .addGroup(panel_AtualizarFuncionarioLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linha_ESuperiorCadastrarFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_DSuperiorCadastrarFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(texto_NomeCompletoFuncionarioAtualizar)
                .addGap(5, 5, 5)
                .addComponent(campo_NomeCompletoFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_CpfFuncionarioAtualizar)
                    .addComponent(texto_CargoFuncionarioAtualizar)
                    .addComponent(texto_NiveldeAcessoFuncionarioAtualizar))
                .addGap(5, 5, 5)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoformatado_CpfFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_CargoFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_NiveldeAcessoFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_NomedeUsuarioFuncionarioAtualizar)
                    .addComponent(texto_SenhaFuncionarioAtualizar))
                .addGap(10, 10, 10)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_NomedeUsuarioFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_SenhaFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_TelefoneFuncionarioAtualizar)
                    .addComponent(texto_EmailFuncionarioAtualizar))
                .addGap(10, 10, 10)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoformatado_TelefoneFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_EmailFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_StatusdoFuncionarioAtualizar)
                    .addComponent(botaoradio_AtivoFuncionarioAtualizar)
                    .addComponent(botaoradio_InativoFuncionarioAtualizar))
                .addGap(40, 40, 40)
                .addComponent(linha_InferiorCadastrarFuncionarioAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel_AtualizarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_VoltarAtualizarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_ConfirmarAtualizarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_AtualizarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_AtualizarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_NomeCompletoFuncionarioAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_NomeCompletoFuncionarioAtualizarActionPerformed
    }//GEN-LAST:event_campo_NomeCompletoFuncionarioAtualizarActionPerformed

    private void campo_EmailFuncionarioAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_EmailFuncionarioAtualizarActionPerformed
    }//GEN-LAST:event_campo_EmailFuncionarioAtualizarActionPerformed

    private void campoformatado_TelefoneFuncionarioAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoformatado_TelefoneFuncionarioAtualizarActionPerformed
    }//GEN-LAST:event_campoformatado_TelefoneFuncionarioAtualizarActionPerformed

    private void botao_VoltarAtualizarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarCadastrarFuncionarioAtualizarActionPerformed

        Panel_GestaoFuncionarios panel = new Panel_GestaoFuncionarios(tela);
        tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_VoltarCadastrarFuncionarioAtualizarActionPerformed

    private void botao_ConfirmarAtualizarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarCadastrarFuncionarioAtualizarActionPerformed
        Clientes cliente = new Clientes();
        if (campo_NomeCompletoFuncionarioAtualizar.getText().trim().isEmpty() || campoformatado_CpfFuncionarioAtualizar.getText().trim().isEmpty()|| combobox_CargoFuncionarioAtualizar.getSelectedIndex() == 0||campo_NomedeUsuarioFuncionarioAtualizar.getText().trim().isEmpty() ||campo_SenhaFuncionarioAtualizar.getText().trim().isEmpty() || campoformatado_TelefoneFuncionarioAtualizar.getText().trim().isEmpty()|| campo_EmailFuncionarioAtualizar.getText().trim().isEmpty() )  {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } 
           else if (!cliente.isCpfValido(campoformatado_CpfFuncionarioAtualizar.getText())) {
        JOptionPane.showMessageDialog(null, "O CPF digitado é inválido! Verifique a digitação.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }

        else {   
            Funcionarios f = new Funcionarios();
            String nomeCompleto = campo_NomeCompletoFuncionarioAtualizar.getText().trim();
            String cpf= tela.limparNumeros(campoformatado_CpfFuncionarioAtualizar.getText().trim());
            String cargo= combobox_CargoFuncionarioAtualizar.getSelectedItem().toString();
            String nomeUsuario= campo_NomedeUsuarioFuncionarioAtualizar.getText().trim();
            String senha= campo_SenhaFuncionarioAtualizar.getText().trim();
            String telefone= tela.limparNumeros(campoformatado_TelefoneFuncionarioAtualizar.getText().trim());
            String email = campo_EmailFuncionarioAtualizar.getText().trim();

            int nivel_acesso = (combobox_NiveldeAcessoFuncionarioAtualizar.getSelectedIndex() == 0) ? 1 : 2;
            int status = botaoradio_AtivoFuncionarioAtualizar.isSelected() ? 1 : 2;

            f.updateFuncionarioController(nomeCompleto, cpf, cargo, nivel_acesso, nomeUsuario, senha, telefone, email, status, this.id);
            Panel_GestaoFuncionarios panel = new Panel_GestaoFuncionarios(tela);
            tela.mudar_Panel(panel);
            }//GEN-LAST:event_botao_ConfirmarCadastrarFuncionarioAtualizarActionPerformed
            
        }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_ConfirmarAtualizarFuncionario;
    private javax.swing.JButton botao_VoltarAtualizarFuncionario;
    private javax.swing.JRadioButton botaoradio_AtivoFuncionarioAtualizar;
    private javax.swing.JRadioButton botaoradio_InativoFuncionarioAtualizar;
    private javax.swing.JTextField campo_EmailFuncionarioAtualizar;
    private javax.swing.JTextField campo_NomeCompletoFuncionarioAtualizar;
    private javax.swing.JTextField campo_NomedeUsuarioFuncionarioAtualizar;
    private javax.swing.JTextField campo_SenhaFuncionarioAtualizar;
    private javax.swing.JFormattedTextField campoformatado_CpfFuncionarioAtualizar;
    private javax.swing.JFormattedTextField campoformatado_TelefoneFuncionarioAtualizar;
    private javax.swing.JComboBox<String> combobox_CargoFuncionarioAtualizar;
    private javax.swing.JComboBox<String> combobox_NiveldeAcessoFuncionarioAtualizar;
    private javax.swing.ButtonGroup grupobotao_AtualizarFuncionario;
    private javax.swing.JSeparator linha_DSuperiorCadastrarFuncionarioAtualizar;
    private javax.swing.JSeparator linha_ESuperiorCadastrarFuncionarioAtualizar;
    private javax.swing.JSeparator linha_InferiorCadastrarFuncionarioAtualizar;
    private javax.swing.JPanel panel_AtualizarFuncionario;
    private javax.swing.JLabel texto_AtualizarFuncionario;
    private javax.swing.JLabel texto_CargoFuncionarioAtualizar;
    private javax.swing.JLabel texto_CpfFuncionarioAtualizar;
    private javax.swing.JLabel texto_EmailFuncionarioAtualizar;
    private javax.swing.JLabel texto_NiveldeAcessoFuncionarioAtualizar;
    private javax.swing.JLabel texto_NomeCompletoFuncionarioAtualizar;
    private javax.swing.JLabel texto_NomedeUsuarioFuncionarioAtualizar;
    private javax.swing.JLabel texto_SenhaFuncionarioAtualizar;
    private javax.swing.JLabel texto_StatusdoFuncionarioAtualizar;
    private javax.swing.JLabel texto_TelefoneFuncionarioAtualizar;
    // End of variables declaration//GEN-END:variables
}
