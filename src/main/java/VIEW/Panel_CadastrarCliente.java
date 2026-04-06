
package VIEW;

import javax.swing.JOptionPane;

import CONTROLLER.Clientes;

public class Panel_CadastrarCliente extends javax.swing.JPanel{
    
    private Tela_Inicial tela;
  
    public Panel_CadastrarCliente() {
        initComponents();
    }
    
    public Panel_CadastrarCliente(Tela_Inicial tela) {
        this.tela = tela;
        initComponents();
        tela.configurarBotaoEnter(this, botao_ConfirmarCadastrarCliente);
        tela.limitarCaracteres(campo_NomeCompleto, 100);
        tela.limitarCaracteres(campo_Estado, 30);
        tela.limitarCaracteres(campo_Cidade, 100);
        tela.limitarCaracteres(campo_Bairro, 100);
        tela.limitarCaracteres(campo_Rua, 150);
        tela.limitarCaracteres(campo_NumeroDaRua, 15);
        tela.limitarCaracteres(campo_Complemento, 100);
        tela.limitarCaracteres(campo_Email, 50);
    }

    private void buscarEPreencherCep() {
    
    String cepDigitado = campoformatado_Cep.getText().trim();

    
    String cepLimpo = cepDigitado.replaceAll("\\D", "");

    if (cepLimpo.length() != 8) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, informe um CEP válido com 8 números.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

  
    SERVICES.ViaCepService apiCep = new SERVICES.ViaCepService();
    java.util.List<String> endereco = apiCep.buscarCep(cepLimpo);

    
    if (endereco != null) {
        campo_Rua.setText(endereco.get(0));    
        campo_Bairro.setText(endereco.get(1)); 
        campo_Cidade.setText(endereco.get(2)); 
        campo_Estado.setText(endereco.get(3)); 

        
        campo_NumeroDaRua.setText("");
        campo_Complemento.setText("");

        campo_NumeroDaRua.requestFocus();
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "CEP não encontrado ou inexistente!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        
        campo_Rua.setText("");
        campo_Bairro.setText("");
        campo_Cidade.setText("");
        campo_Estado.setText("");
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        grupobotao_CadastrarCliente = new javax.swing.ButtonGroup();
        panel_CadastrarCliente = new javax.swing.JPanel();
        texto_CadastrarCliente = new javax.swing.JLabel();
        texto_NomeCompleto = new javax.swing.JLabel();
        texto_Cpf = new javax.swing.JLabel();
        texto_DatadeNascimento = new javax.swing.JLabel();
        texto_Cep = new javax.swing.JLabel();
        texto_Estado = new javax.swing.JLabel();
        texto_Cidade = new javax.swing.JLabel();
        texto_Bairro = new javax.swing.JLabel();
        texto_Rua = new javax.swing.JLabel();
        texto_NumeroDaRua = new javax.swing.JLabel();
        texto_Complemento = new javax.swing.JLabel();
        texto_Telefone = new javax.swing.JLabel();
        texto_Email = new javax.swing.JLabel();
        texto_StatusdoCliente = new javax.swing.JLabel();
        campo_NomeCompleto = new javax.swing.JTextField();
        campo_Estado = new javax.swing.JTextField();
        campo_Cidade = new javax.swing.JTextField();
        campo_Bairro = new javax.swing.JTextField();
        campo_Rua = new javax.swing.JTextField();
        campo_NumeroDaRua = new javax.swing.JTextField();
        campo_Complemento = new javax.swing.JTextField();
        campo_Email = new javax.swing.JTextField();
        campoformatado_Cpf = new javax.swing.JFormattedTextField();
        campoformatado_DatadeNascimento = new javax.swing.JFormattedTextField();
        campoformatado_Cep = new javax.swing.JFormattedTextField();
        campoformatado_Telefone = new javax.swing.JFormattedTextField();
        campo_Rua.setEditable(false);
        campo_Rua.setFocusable(false);
        campo_Bairro.setEditable(false);
        campo_Bairro.setFocusable(false);
        campo_Cidade.setEditable(false);
        campo_Cidade.setFocusable(false);
        campo_Estado.setEditable(false);
        campo_Estado.setFocusable(false);

        botaoradio_AtivoCliente = new javax.swing.JRadioButton();
        botaoradio_InativoCliente = new javax.swing.JRadioButton();
        linha_InferiorCadastrarCliente = new javax.swing.JSeparator();
        linha_DSuperiorCadastrarCliente = new javax.swing.JSeparator();
        linha_ESuperiorCadastrarCliente = new javax.swing.JSeparator();
        botao_VoltarCadastrarCliente = new javax.swing.JButton();
        botao_ConfirmarCadastrarCliente = new javax.swing.JButton();
        
        setBackground(new java.awt.Color(250, 250, 250));
        setPreferredSize(new java.awt.Dimension(920, 637));

        
        panel_CadastrarCliente.setBackground(new java.awt.Color(250, 250, 250));
        panel_CadastrarCliente.setPreferredSize(new java.awt.Dimension(920, 640));

        texto_CadastrarCliente.setBackground(new java.awt.Color(250, 250, 250));
        texto_CadastrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 20));
        texto_CadastrarCliente.setText("Cadastrar Cliente");

        texto_NomeCompleto.setFont(new java.awt.Font("Segoe UI", 0, 18));
        texto_NomeCompleto.setText("Nome completo:");

        texto_Cpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Cpf.setText("CPF:");

        texto_DatadeNascimento.setFont(new java.awt.Font("Segoe UI", 0, 18));
        texto_DatadeNascimento.setText("Data de nascimento:");

        texto_Cep.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Cep.setText("CEP:");

        texto_Estado.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Estado.setText("Estado:");

        texto_Cidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Cidade.setText("Cidade: ");

        texto_Bairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Bairro.setText("Bairro:");

        texto_Rua.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Rua.setText("Rua:");

        texto_NumeroDaRua.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_NumeroDaRua.setText("N.º:");

        texto_Complemento.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Complemento.setText("Complemento:");

        texto_Telefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Telefone.setText("Telefone:");

        texto_Email.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_Email.setText("E-mail:");

        texto_StatusdoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_StatusdoCliente.setText("Status do cliente:");

        campo_NomeCompleto.setPreferredSize(new java.awt.Dimension(740, 24));
        campo_NomeCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_NomeCompletoActionPerformed(evt);
            }
        });

        campoformatado_Cep.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            campoformatado_CepFocusLost(evt);
        }
    });

        campo_Estado.setPreferredSize(new java.awt.Dimension(360, 24));

        campo_Cidade.setPreferredSize(new java.awt.Dimension(360, 24));

        campo_Bairro.setPreferredSize(new java.awt.Dimension(320, 24));

        campo_Rua.setPreferredSize(new java.awt.Dimension(320, 24));

        campo_NumeroDaRua.setPreferredSize(new java.awt.Dimension(320, 24));

        campo_Complemento.setPreferredSize(new java.awt.Dimension(740, 24));
        campo_Complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_ComplementoActionPerformed(evt);
            }
        });

        campo_Email.setPreferredSize(new java.awt.Dimension(330, 24));
        campo_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_EmailActionPerformed(evt);
            }
        });

        try {
            campoformatado_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_Cpf.setPreferredSize(new java.awt.Dimension(240, 24));

        try {
            campoformatado_DatadeNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_DatadeNascimento.setPreferredSize(new java.awt.Dimension(240, 24));

        try {
            campoformatado_Cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_Cep.setPreferredSize(new java.awt.Dimension(240, 24));

        try {
            campoformatado_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_Telefone.setPreferredSize(new java.awt.Dimension(330, 24));
        campoformatado_Telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoformatado_TelefoneActionPerformed(evt);
            }
        });

        grupobotao_CadastrarCliente.add(botaoradio_AtivoCliente);
        botaoradio_AtivoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_AtivoCliente.setSelected(true);
        botaoradio_AtivoCliente.setText("Ativo");
        botaoradio_AtivoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_AtivoCliente.setIconTextGap(10);
        botaoradio_AtivoCliente.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        grupobotao_CadastrarCliente.add(botaoradio_InativoCliente);
        botaoradio_InativoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_InativoCliente.setText("Inativo");
        botaoradio_InativoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_InativoCliente.setIconTextGap(10);

        botao_VoltarCadastrarCliente.setBackground(new java.awt.Color(255, 164, 114));
        botao_VoltarCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_VoltarCadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botao_VoltarCadastrarCliente.setText("Voltar");
        botao_VoltarCadastrarCliente.setBorder(null);
        botao_VoltarCadastrarCliente.setBorderPainted(false);
        botao_VoltarCadastrarCliente.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_VoltarCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_VoltarCadastrarClienteActionPerformed(evt);
            }
        });

        botao_ConfirmarCadastrarCliente.setBackground(new java.awt.Color(148, 189, 154));
        botao_ConfirmarCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_ConfirmarCadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botao_ConfirmarCadastrarCliente.setText("Confirmar");
        botao_ConfirmarCadastrarCliente.setBorder(null);
        botao_ConfirmarCadastrarCliente.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_ConfirmarCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfirmarCadastrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_CadastrarClienteLayout = new javax.swing.GroupLayout(panel_CadastrarCliente);
        panel_CadastrarCliente.setLayout(panel_CadastrarClienteLayout);
        panel_CadastrarClienteLayout.setHorizontalGroup(
            panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(linha_ESuperiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(texto_CadastrarCliente)
                        .addGap(22, 22, 22)
                        .addComponent(linha_DSuperiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_NomeCompleto))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(campo_NomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_Cpf)
                        .addGap(216, 216, 216)
                        .addComponent(texto_DatadeNascimento)
                        .addGap(88, 88, 88)
                        .addComponent(texto_Cep))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(campoformatado_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(campoformatado_DatadeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(campoformatado_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_Estado)
                        .addGap(322, 322, 322)
                        .addComponent(texto_Cidade))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(campo_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(campo_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_Bairro)
                        .addGap(280, 280, 280)
                        .addComponent(texto_Rua)
                        .addGap(296, 296, 296)
                        .addComponent(texto_NumeroDaRua))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(campo_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(campo_Rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(campo_NumeroDaRua, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_Complemento))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(campo_Complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_Telefone)
                        .addGap(269, 269, 269)
                        .addComponent(texto_Email))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(campoformatado_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(campo_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(texto_StatusdoCliente)
                        .addGap(25, 25, 25)
                        .addComponent(botaoradio_AtivoCliente)
                        .addGap(19, 19, 19)
                        .addComponent(botaoradio_InativoCliente))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(linha_InferiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(botao_VoltarCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(480, 480, 480)
                        .addComponent(botao_ConfirmarCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panel_CadastrarClienteLayout.setVerticalGroup(
            panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_CadastrarCliente)
                    .addGroup(panel_CadastrarClienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linha_ESuperiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_DSuperiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addComponent(texto_NomeCompleto)
                .addGap(5, 5, 5)
                .addComponent(campo_NomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Cpf)
                    .addComponent(texto_DatadeNascimento)
                    .addComponent(texto_Cep))
                .addGap(5, 5, 5)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoformatado_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoformatado_DatadeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoformatado_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Estado)
                    .addComponent(texto_Cidade))
                .addGap(10, 10, 10)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Bairro)
                    .addComponent(texto_Rua)
                    .addComponent(texto_NumeroDaRua))
                .addGap(5, 5, 5)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_Rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_NumeroDaRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(texto_Complemento)
                .addGap(5, 5, 5)
                .addComponent(campo_Complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_Telefone)
                    .addComponent(texto_Email))
                .addGap(10, 10, 10)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoformatado_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_StatusdoCliente)
                    .addComponent(botaoradio_AtivoCliente)
                    .addComponent(botaoradio_InativoCliente))
                .addGap(30, 30, 30)
                .addComponent(linha_InferiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel_CadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_VoltarCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_ConfirmarCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_CadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_CadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_EmailActionPerformed
    }//GEN-LAST:event_campo_EmailActionPerformed

    private void campo_NomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_NomeCompletoActionPerformed
    }//GEN-LAST:event_campo_NomeCompletoActionPerformed

    private void campo_ComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_ComplementoActionPerformed
    }//GEN-LAST:event_campo_ComplementoActionPerformed

    private void botao_VoltarCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_VoltarCadastrarClienteActionPerformed
     
     Panel_GestaoClientes panel = new Panel_GestaoClientes(tela);
     tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_VoltarCadastrarClienteActionPerformed

    private void botao_ConfirmarCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfirmarCadastrarClienteActionPerformed
        Clientes cliente = new Clientes();

       
        if (campo_NomeCompleto.getText().trim().isEmpty() ||
            campoformatado_Cpf.getText().trim().isEmpty() ||
            campoformatado_DatadeNascimento.getText().trim().isEmpty() ||
            campoformatado_Cep.getText().trim().isEmpty() ||
            campo_Estado.getText().trim().isEmpty() ||
            campo_Cidade.getText().trim().isEmpty() ||
            campo_Bairro.getText().trim().isEmpty() ||
            campo_Rua.getText().trim().isEmpty() ||
            campo_NumeroDaRua.getText().trim().isEmpty() ||
            campoformatado_Telefone.getText().trim().isEmpty() ||
            campo_Email.getText().trim().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } 
        
        else if (!cliente.isCpfValido(campoformatado_Cpf.getText())) {
            JOptionPane.showMessageDialog(null, "O CPF digitado é inválido! Verifique a digitação.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } 
       
        else if (!cliente.isDataValida(campoformatado_DatadeNascimento.getText())) {
            JOptionPane.showMessageDialog(null, "A data de nascimento é inválida! Insira uma data real.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } 
        
        else {
            String nome = campo_NomeCompleto.getText().trim();
            String cpf = tela.limparNumeros(campoformatado_Cpf.getText().trim());
            String dataNascimento = tela.formatarDataParaMySQL(campoformatado_DatadeNascimento.getText().trim());
            String cep = tela.limparNumeros(campoformatado_Cep.getText().trim());

            String estado = campo_Estado.getText().trim();
            String cidade = campo_Cidade.getText().trim();
            String bairro = campo_Bairro.getText().trim();
            String rua = campo_Rua.getText().trim();
            String numRua = campo_NumeroDaRua.getText().trim();

            String complemento = campo_Complemento.getText().trim();
            if (complemento.isEmpty()) {
                complemento = ""; 
            }

            String telefone = tela.limparNumeros(campoformatado_Telefone.getText().trim());
            String email = campo_Email.getText().trim();

            int status = botaoradio_AtivoCliente.isSelected() ? 1 : 2;

            cliente.addClienteController(nome, cpf, dataNascimento, cep, estado, cidade, bairro, rua, numRua, complemento, telefone, email, String.valueOf(status));
            
            Panel_GestaoClientes panel = new Panel_GestaoClientes(tela);
            tela.mudar_Panel(panel);
        }
    }//GEN-LAST:event_botao_ConfirmarCadastrarClienteActionPerformed

    private void campoformatado_TelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoformatado_TelefoneActionPerformed
    }//GEN-LAST:event_campoformatado_TelefoneActionPerformed

    private void campoformatado_CepFocusLost(java.awt.event.FocusEvent evt) {                                             
    buscarEPreencherCep();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_ConfirmarCadastrarCliente;
    private javax.swing.JButton botao_VoltarCadastrarCliente;
    private javax.swing.JRadioButton botaoradio_AtivoCliente;
    private javax.swing.JRadioButton botaoradio_InativoCliente;
    private javax.swing.JTextField campo_Bairro;
    private javax.swing.JTextField campo_Cidade;
    private javax.swing.JTextField campo_Complemento;
    private javax.swing.JTextField campo_Email;
    private javax.swing.JTextField campo_Estado;
    private javax.swing.JTextField campo_NomeCompleto;
    private javax.swing.JTextField campo_NumeroDaRua;
    private javax.swing.JTextField campo_Rua;
    private javax.swing.JFormattedTextField campoformatado_Cep;
    private javax.swing.JFormattedTextField campoformatado_Cpf;
    private javax.swing.JFormattedTextField campoformatado_DatadeNascimento;
    private javax.swing.JFormattedTextField campoformatado_Telefone;
    private javax.swing.ButtonGroup grupobotao_CadastrarCliente;
    private javax.swing.JSeparator linha_DSuperiorCadastrarCliente;
    private javax.swing.JSeparator linha_ESuperiorCadastrarCliente;
    private javax.swing.JSeparator linha_InferiorCadastrarCliente;
    private javax.swing.JPanel panel_CadastrarCliente;
    private javax.swing.JLabel texto_Bairro;
    private javax.swing.JLabel texto_CadastrarCliente;
    private javax.swing.JLabel texto_Cep;
    private javax.swing.JLabel texto_Cidade;
    private javax.swing.JLabel texto_Complemento;
    private javax.swing.JLabel texto_Cpf;
    private javax.swing.JLabel texto_DatadeNascimento;
    private javax.swing.JLabel texto_Email;
    private javax.swing.JLabel texto_Estado;
    private javax.swing.JLabel texto_NomeCompleto;
    private javax.swing.JLabel texto_NumeroDaRua;
    private javax.swing.JLabel texto_Rua;
    private javax.swing.JLabel texto_StatusdoCliente;
    private javax.swing.JLabel texto_Telefone;
    // End of variables declaration//GEN-END:variables
}
