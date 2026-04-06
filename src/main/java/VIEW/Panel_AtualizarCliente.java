
package VIEW;

import javax.swing.JOptionPane;

import CONTROLLER.Clientes;


public class Panel_AtualizarCliente extends javax.swing.JPanel {
    private int id = 0;
    private Tela_Inicial tela;
   
    public Panel_AtualizarCliente() {
        initComponents();
    }
    
    public Panel_AtualizarCliente(Tela_Inicial tela, int id) {      
    this.tela = tela;
    this.id = id;
    initComponents();
    tela.configurarBotaoEnter(this, botao_AtualizarConfirmarCadastrarCliente);
      tela.limitarCaracteres(campo_AtualizarNomeCompleto, 100);
        tela.limitarCaracteres(campo_AtualizarEstado, 30);
        tela.limitarCaracteres(campo_AtualizarCidade, 100);
        tela.limitarCaracteres(campo_AtualizarBairro, 100);
        tela.limitarCaracteres(campo_AtualizarRua, 150);
        tela.limitarCaracteres(campo_AtualizarNumeroDaRua, 15);
        tela.limitarCaracteres(campo_AtualizarComplemento, 100);
        tela.limitarCaracteres(campo_AtualizarEmail, 50);

    
    Clientes c = new Clientes();
    String[] vetor = c.preencherAtualizarClientesController(id);
    
    if (vetor != null && !vetor[0].isEmpty()) {
        preencherCamposCliente(vetor);
    }
}

public void preencherCamposCliente(String[] dados) {
    if (dados == null || dados.length < 13) return;

    
    campo_AtualizarNomeCompleto.setText(dados[0] != null ? dados[0] : "");
    campoformatado_CpfAtualizar.setText(dados[1] != null ? limparNumeros(dados[1]) : "");
    campoformatado_DatadeNascimentoAtualizar.setText(dados[2] != null ? tela.formatarDataParaXXMMYYYY(dados[2]) : "");    campoformatado_CepAtualizar.setText(dados[3] != null ? limparNumeros(dados[3]) : "");
    campo_AtualizarEstado.setText(dados[4] != null ? dados[4] : "");
    campo_AtualizarCidade.setText(dados[5] != null ? dados[5] : "");
    campo_AtualizarBairro.setText(dados[6] != null ? dados[6] : "");
    campo_AtualizarRua.setText(dados[7] != null ? dados[7] : "");
    campo_AtualizarNumeroDaRua.setText(dados[8] != null ? dados[8] : "");

    
    campo_AtualizarComplemento.setText(dados[9] != null ? dados[9] : "");

    campoformatado_TelefoneAtualizar.setText(dados[10] != null ? limparNumeros(dados[10]) : "");
    campo_AtualizarEmail.setText(dados[11] != null ? dados[11] : "");

    
    String status = dados[12] != null ? dados[12] : "";
    if ("Ativo".equalsIgnoreCase(status)) {
        botaoradio_AtualizarAtivoCliente.setSelected(true);
    } else if ("Inativo".equalsIgnoreCase(status)) {
        botaoradio_AtualizarInativoCliente.setSelected(true);
    } else {
        botaoradio_AtualizarAtivoCliente.setSelected(false);
        botaoradio_AtualizarInativoCliente.setSelected(false);
    }
}

private String limparNumeros(String valor) {
    if (valor == null) return "";
    return valor.replaceAll("\\D", "");
}

private void buscarEPreencherCep() {
    
    String cepDigitado = campoformatado_CepAtualizar.getText().trim();

    
    String cepLimpo = cepDigitado.replaceAll("\\D", "");

    if (cepLimpo.length() != 8) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, informe um CEP válido com 8 números.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    SERVICES.ViaCepService apiCep = new SERVICES.ViaCepService();
    java.util.List<String> endereco = apiCep.buscarCep(cepLimpo);

    
    if (endereco != null) {
        campo_AtualizarRua.setText(endereco.get(0));    
        campo_AtualizarBairro.setText(endereco.get(1)); 
        campo_AtualizarCidade.setText(endereco.get(2));
        campo_AtualizarEstado.setText(endereco.get(3)); 

       
        campo_AtualizarNumeroDaRua.setText("");
        campo_AtualizarComplemento.setText("");

        campo_AtualizarNumeroDaRua.requestFocus();
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "CEP não encontrado ou inexistente!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        
        
        campo_AtualizarRua.setText("");
        campo_AtualizarBairro.setText("");
        campo_AtualizarCidade.setText("");
        campo_AtualizarEstado.setText("");
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotao_AtualizarCliente = new javax.swing.ButtonGroup();
        panel_AtualizarCliente = new javax.swing.JPanel();
        texto_AtualizarCliente = new javax.swing.JLabel();
        texto_AtualizarNomeCompleto = new javax.swing.JLabel();
        texto_AtualizarCpf = new javax.swing.JLabel();
        texto_AtualizarDatadeNascimento = new javax.swing.JLabel();
        texto_AtualizarCep = new javax.swing.JLabel();
        texto_AtualizarEstado = new javax.swing.JLabel();
        texto_AtualizarCidade = new javax.swing.JLabel();
        texto_AtualizarBairro = new javax.swing.JLabel();
        texto_AtualizarRua = new javax.swing.JLabel();
        texto_AtualizarNumeroDaRua = new javax.swing.JLabel();
        texto_AtualizarComplemento = new javax.swing.JLabel();
        texto_AtualizarTelefone = new javax.swing.JLabel();
        texto_AtualizarEmail = new javax.swing.JLabel();
        texto_AtualizarStatusdoCliente = new javax.swing.JLabel();
        campo_AtualizarNomeCompleto = new javax.swing.JTextField();
        campo_AtualizarEstado = new javax.swing.JTextField();
        campo_AtualizarCidade = new javax.swing.JTextField();
        campo_AtualizarBairro = new javax.swing.JTextField();
        campo_AtualizarRua = new javax.swing.JTextField();
        campo_AtualizarNumeroDaRua = new javax.swing.JTextField();
        campo_AtualizarComplemento = new javax.swing.JTextField();
        campo_AtualizarEmail = new javax.swing.JTextField();
        campoformatado_CpfAtualizar = new javax.swing.JFormattedTextField();
        campoformatado_DatadeNascimentoAtualizar = new javax.swing.JFormattedTextField();
        campoformatado_CepAtualizar = new javax.swing.JFormattedTextField();
        campoformatado_TelefoneAtualizar = new javax.swing.JFormattedTextField();
        campo_AtualizarRua.setEditable(false);
        campo_AtualizarRua.setFocusable(false);
        campo_AtualizarBairro.setEditable(false);
        campo_AtualizarBairro.setFocusable(false);
        campo_AtualizarCidade.setEditable(false);
        campo_AtualizarCidade.setFocusable(false);
        campo_AtualizarEstado.setEditable(false);
        campo_AtualizarEstado.setFocusable(false);
        botaoradio_AtualizarAtivoCliente = new javax.swing.JRadioButton();
        botaoradio_AtualizarInativoCliente = new javax.swing.JRadioButton();
        linha_AtualizarInferiorCadastrarCliente = new javax.swing.JSeparator();
        linha_AtualizarDSuperiorCadastrarCliente = new javax.swing.JSeparator();
        linha_AtualizarESuperiorCadastrarCliente = new javax.swing.JSeparator();
        botao_AtualizarVoltarCadastrarCliente = new javax.swing.JButton();
        botao_AtualizarConfirmarCadastrarCliente = new javax.swing.JButton();

        panel_AtualizarCliente.setBackground(new java.awt.Color(250, 250, 250));

        texto_AtualizarCliente.setBackground(new java.awt.Color(250, 250, 250));
        texto_AtualizarCliente.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        texto_AtualizarCliente.setText("Atualizar Cliente");

        texto_AtualizarNomeCompleto.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarNomeCompleto.setText("Nome completo:");

        texto_AtualizarCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarCpf.setText("CPF:");

        texto_AtualizarDatadeNascimento.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarDatadeNascimento.setText("Data de nascimento:");

        texto_AtualizarCep.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarCep.setText("CEP:");

        texto_AtualizarEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarEstado.setText("Estado:");

        texto_AtualizarCidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarCidade.setText("Cidade: ");

        texto_AtualizarBairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarBairro.setText("Bairro:");

        texto_AtualizarRua.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarRua.setText("Rua:");

        texto_AtualizarNumeroDaRua.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarNumeroDaRua.setText("N.º:");

        texto_AtualizarComplemento.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarComplemento.setText("Complemento:");

        texto_AtualizarTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarTelefone.setText("Telefone:");

        texto_AtualizarEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarEmail.setText("E-mail:");

        texto_AtualizarStatusdoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        texto_AtualizarStatusdoCliente.setText("Status do cliente:");

        campo_AtualizarNomeCompleto.setPreferredSize(new java.awt.Dimension(740, 24));
        campo_AtualizarNomeCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_AtualizarNomeCompletoActionPerformed(evt);
            }
        });
        campoformatado_CepAtualizar.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            campoformatado_CepAtualizarFocusLost(evt);
        }
        });

        campo_AtualizarEstado.setPreferredSize(new java.awt.Dimension(360, 24));

        campo_AtualizarCidade.setPreferredSize(new java.awt.Dimension(360, 24));

        campo_AtualizarBairro.setPreferredSize(new java.awt.Dimension(320, 24));

        campo_AtualizarRua.setPreferredSize(new java.awt.Dimension(320, 24));

        campo_AtualizarNumeroDaRua.setPreferredSize(new java.awt.Dimension(320, 24));

        campo_AtualizarComplemento.setPreferredSize(new java.awt.Dimension(740, 24));
        campo_AtualizarComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_AtualizarComplementoActionPerformed(evt);
            }
        });

        campo_AtualizarEmail.setPreferredSize(new java.awt.Dimension(330, 24));
        campo_AtualizarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_AtualizarEmailActionPerformed(evt);
            }
        });

        try {
            campoformatado_CpfAtualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_CpfAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));

        try {
            campoformatado_DatadeNascimentoAtualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_DatadeNascimentoAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));

        try {
            campoformatado_CepAtualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_CepAtualizar.setPreferredSize(new java.awt.Dimension(240, 24));

        try {
            campoformatado_TelefoneAtualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoformatado_TelefoneAtualizar.setPreferredSize(new java.awt.Dimension(330, 24));
        campoformatado_TelefoneAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoformatado_TelefoneAtualizarActionPerformed(evt);
            }
        });

        grupobotao_AtualizarCliente.add(botaoradio_AtualizarAtivoCliente);
        botaoradio_AtualizarAtivoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_AtualizarAtivoCliente.setText("Ativo");
        botaoradio_AtualizarAtivoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_AtualizarAtivoCliente.setIconTextGap(10);
        botaoradio_AtualizarAtivoCliente.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        grupobotao_AtualizarCliente.add(botaoradio_AtualizarInativoCliente);
        botaoradio_AtualizarInativoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botaoradio_AtualizarInativoCliente.setText("Inativo");
        botaoradio_AtualizarInativoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoradio_AtualizarInativoCliente.setIconTextGap(10);

        botao_AtualizarVoltarCadastrarCliente.setBackground(new java.awt.Color(255, 164, 114));
        botao_AtualizarVoltarCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_AtualizarVoltarCadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botao_AtualizarVoltarCadastrarCliente.setText("Voltar");
        botao_AtualizarVoltarCadastrarCliente.setBorder(null);
        botao_AtualizarVoltarCadastrarCliente.setBorderPainted(false);
        botao_AtualizarVoltarCadastrarCliente.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_AtualizarVoltarCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AtualizarVoltarCadastrarClienteActionPerformed(evt);
            }
        });

        botao_AtualizarConfirmarCadastrarCliente.setBackground(new java.awt.Color(148, 189, 154));
        botao_AtualizarConfirmarCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        botao_AtualizarConfirmarCadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botao_AtualizarConfirmarCadastrarCliente.setText("Confirmar");
        botao_AtualizarConfirmarCadastrarCliente.setBorder(null);
        botao_AtualizarConfirmarCadastrarCliente.setPreferredSize(new java.awt.Dimension(180, 40));
        botao_AtualizarConfirmarCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_AtualizarConfirmarCadastrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_AtualizarClienteLayout = new javax.swing.GroupLayout(panel_AtualizarCliente);
        panel_AtualizarCliente.setLayout(panel_AtualizarClienteLayout);
        panel_AtualizarClienteLayout.setHorizontalGroup(
            panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(linha_AtualizarESuperiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(texto_AtualizarCliente)
                .addGap(22, 22, 22)
                .addComponent(linha_AtualizarDSuperiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(texto_AtualizarNomeCompleto))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(campo_AtualizarNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(texto_AtualizarCpf)
                .addGap(216, 216, 216)
                .addComponent(texto_AtualizarDatadeNascimento)
                .addGap(88, 88, 88)
                .addComponent(texto_AtualizarCep))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(campoformatado_CpfAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(campoformatado_DatadeNascimentoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(campoformatado_CepAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(texto_AtualizarEstado)
                .addGap(322, 322, 322)
                .addComponent(texto_AtualizarCidade))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(campo_AtualizarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(campo_AtualizarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(texto_AtualizarBairro)
                .addGap(280, 280, 280)
                .addComponent(texto_AtualizarRua)
                .addGap(296, 296, 296)
                .addComponent(texto_AtualizarNumeroDaRua))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(campo_AtualizarBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(campo_AtualizarRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(campo_AtualizarNumeroDaRua, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(texto_AtualizarComplemento))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(campo_AtualizarComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(texto_AtualizarTelefone)
                .addGap(269, 269, 269)
                .addComponent(texto_AtualizarEmail))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(campoformatado_TelefoneAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(campo_AtualizarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(texto_AtualizarStatusdoCliente)
                .addGap(25, 25, 25)
                .addComponent(botaoradio_AtualizarAtivoCliente)
                .addGap(19, 19, 19)
                .addComponent(botaoradio_AtualizarInativoCliente))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(linha_AtualizarInferiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(botao_AtualizarVoltarCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(480, 480, 480)
                .addComponent(botao_AtualizarConfirmarCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_AtualizarClienteLayout.setVerticalGroup(
            panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_AtualizarCliente)
                    .addGroup(panel_AtualizarClienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linha_AtualizarESuperiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linha_AtualizarDSuperiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addComponent(texto_AtualizarNomeCompleto)
                .addGap(5, 5, 5)
                .addComponent(campo_AtualizarNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_AtualizarCpf)
                    .addComponent(texto_AtualizarDatadeNascimento)
                    .addComponent(texto_AtualizarCep))
                .addGap(5, 5, 5)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoformatado_CpfAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoformatado_DatadeNascimentoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoformatado_CepAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_AtualizarEstado)
                    .addComponent(texto_AtualizarCidade))
                .addGap(10, 10, 10)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_AtualizarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_AtualizarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_AtualizarBairro)
                    .addComponent(texto_AtualizarRua)
                    .addComponent(texto_AtualizarNumeroDaRua))
                .addGap(5, 5, 5)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_AtualizarBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_AtualizarRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_AtualizarNumeroDaRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(texto_AtualizarComplemento)
                .addGap(5, 5, 5)
                .addComponent(campo_AtualizarComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_AtualizarTelefone)
                    .addComponent(texto_AtualizarEmail))
                .addGap(10, 10, 10)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoformatado_TelefoneAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_AtualizarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_AtualizarStatusdoCliente)
                    .addComponent(botaoradio_AtualizarAtivoCliente)
                    .addComponent(botaoradio_AtualizarInativoCliente))
                .addGap(30, 30, 30)
                .addComponent(linha_AtualizarInferiorCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel_AtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_AtualizarVoltarCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_AtualizarConfirmarCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_AtualizarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_AtualizarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campo_AtualizarNomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_AtualizarNomeCompletoActionPerformed
       
    }//GEN-LAST:event_campo_AtualizarNomeCompletoActionPerformed

    private void campo_AtualizarComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_AtualizarComplementoActionPerformed
        
    }//GEN-LAST:event_campo_AtualizarComplementoActionPerformed

    private void campo_AtualizarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_AtualizarEmailActionPerformed
        
    }//GEN-LAST:event_campo_AtualizarEmailActionPerformed

    private void botao_AtualizarVoltarCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AtualizarVoltarCadastrarClienteActionPerformed
          Panel_GestaoClientes panel = new Panel_GestaoClientes(tela);
          tela.mudar_Panel(panel);
    }//GEN-LAST:event_botao_AtualizarVoltarCadastrarClienteActionPerformed

    private void botao_AtualizarConfirmarCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_AtualizarConfirmarCadastrarClienteActionPerformed
        Clientes c = new Clientes();

      
        if (campo_AtualizarNomeCompleto.getText().trim().isEmpty() ||
            campoformatado_CpfAtualizar.getText().trim().isEmpty() ||
            campoformatado_DatadeNascimentoAtualizar.getText().trim().isEmpty() ||
            campoformatado_CepAtualizar.getText().trim().isEmpty() ||
            campo_AtualizarEstado.getText().trim().isEmpty() ||
            campo_AtualizarCidade.getText().trim().isEmpty() ||
            campo_AtualizarBairro.getText().trim().isEmpty() ||
            campo_AtualizarRua.getText().trim().isEmpty() ||
            campo_AtualizarNumeroDaRua.getText().trim().isEmpty() ||
            campoformatado_TelefoneAtualizar.getText().trim().isEmpty() ||
            campo_AtualizarEmail.getText().trim().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } 
    
        else if (!c.isCpfValido(campoformatado_CpfAtualizar.getText())) {
            JOptionPane.showMessageDialog(null, "O CPF digitado é inválido! Verifique a digitação.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } 
       
        else if (!c.isDataValida(campoformatado_DatadeNascimentoAtualizar.getText())) {
            JOptionPane.showMessageDialog(null, "A data de nascimento é inválida! Insira uma data real.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } 
        
        else {
            String nome = campo_AtualizarNomeCompleto.getText().trim();
            String cpf = tela.limparNumeros(campoformatado_CpfAtualizar.getText().trim());
            String dataNascimento = tela.formatarDataParaMySQL(campoformatado_DatadeNascimentoAtualizar.getText().trim());
            String cep = tela.limparNumeros(campoformatado_CepAtualizar.getText().trim());

            String estado = campo_AtualizarEstado.getText().trim();
            String cidade = campo_AtualizarCidade.getText().trim();
            String bairro = campo_AtualizarBairro.getText().trim();
            String rua = campo_AtualizarRua.getText().trim();
            String numRua = campo_AtualizarNumeroDaRua.getText().trim();

           
            String complemento = campo_AtualizarComplemento.getText().trim();
            if (complemento.isEmpty()) {
                complemento = ""; 
            }

            String telefone = tela.limparNumeros(campoformatado_TelefoneAtualizar.getText().trim());
            String email = campo_AtualizarEmail.getText().trim();

            int status = botaoradio_AtualizarAtivoCliente.isSelected() ? 1 : 2;

           
            c.updateClienteController(nome, cpf, dataNascimento, cep, estado, cidade, bairro, rua, numRua, complemento, telefone, email, String.valueOf(status), this.id);
            
            Panel_GestaoClientes panel = new Panel_GestaoClientes(tela);
            tela.mudar_Panel(panel);
        }   
    }//GEN-LAST:event_botao_AtualizarConfirmarCadastrarClienteActionPerformed

    private void campoformatado_TelefoneAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoformatado_TelefoneAtualizarActionPerformed
    }//GEN-LAST:event_campoformatado_TelefoneAtualizarActionPerformed

    
    private void campoformatado_CepAtualizarFocusLost(java.awt.event.FocusEvent evt) {                                             
    buscarEPreencherCep();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_AtualizarConfirmarCadastrarCliente;
    private javax.swing.JButton botao_AtualizarVoltarCadastrarCliente;
    private javax.swing.JRadioButton botaoradio_AtualizarAtivoCliente;
    private javax.swing.JRadioButton botaoradio_AtualizarInativoCliente;
    private javax.swing.JTextField campo_AtualizarBairro;
    private javax.swing.JTextField campo_AtualizarCidade;
    private javax.swing.JTextField campo_AtualizarComplemento;
    private javax.swing.JTextField campo_AtualizarEmail;
    private javax.swing.JTextField campo_AtualizarEstado;
    private javax.swing.JTextField campo_AtualizarNomeCompleto;
    private javax.swing.JTextField campo_AtualizarNumeroDaRua;
    private javax.swing.JTextField campo_AtualizarRua;
    private javax.swing.JFormattedTextField campoformatado_CepAtualizar;
    private javax.swing.JFormattedTextField campoformatado_CpfAtualizar;
    private javax.swing.JFormattedTextField campoformatado_DatadeNascimentoAtualizar;
    private javax.swing.JFormattedTextField campoformatado_TelefoneAtualizar;
    private javax.swing.ButtonGroup grupobotao_AtualizarCliente;
    private javax.swing.JSeparator linha_AtualizarDSuperiorCadastrarCliente;
    private javax.swing.JSeparator linha_AtualizarESuperiorCadastrarCliente;
    private javax.swing.JSeparator linha_AtualizarInferiorCadastrarCliente;
    private javax.swing.JPanel panel_AtualizarCliente;
    private javax.swing.JLabel texto_AtualizarBairro;
    private javax.swing.JLabel texto_AtualizarCep;
    private javax.swing.JLabel texto_AtualizarCidade;
    private javax.swing.JLabel texto_AtualizarCliente;
    private javax.swing.JLabel texto_AtualizarComplemento;
    private javax.swing.JLabel texto_AtualizarCpf;
    private javax.swing.JLabel texto_AtualizarDatadeNascimento;
    private javax.swing.JLabel texto_AtualizarEmail;
    private javax.swing.JLabel texto_AtualizarEstado;
    private javax.swing.JLabel texto_AtualizarNomeCompleto;
    private javax.swing.JLabel texto_AtualizarNumeroDaRua;
    private javax.swing.JLabel texto_AtualizarRua;
    private javax.swing.JLabel texto_AtualizarStatusdoCliente;
    private javax.swing.JLabel texto_AtualizarTelefone;
    // End of variables declaration//GEN-END:variables
}
