
package VIEW;



import CONTROLLER.Configuracao;
import CONTROLLER.Funcionarios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;
import javax.swing.text.AttributeSet;

public class Tela_Inicial extends javax.swing.JFrame {

    public int idf;
    private boolean modoEscuro = false;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Tela_Inicial.class.getName());

    
    public Tela_Inicial() {
        initComponents();
        preencherTelaInicial();
    }

    public void preencherTelaInicial() {
        Configuracao config = new Configuracao();
        String[] vetor = config.preencherConfigurarController(); 

     
        String titulo = (vetor != null && vetor[0] != null && !vetor[0].isEmpty()) ? vetor[0] : "Lanchonete";
        this.setTitle(titulo);

        
        String caminhoLogoMenor = (vetor != null && vetor[2] != null && !vetor[2].isEmpty()) ? vetor[2] : null;
        if (caminhoLogoMenor != null) {
            ImageIcon imagem = new ImageIcon(caminhoLogoMenor);
            int largura = logoMenor.getWidth() > 0 ? logoMenor.getWidth() : 80;
            int altura = logoMenor.getHeight() > 0 ? logoMenor.getHeight() : 80;
            Image imgRedimensionada = imagem.getImage().getScaledInstance(
                    largura,
                    altura,
                    Image.SCALE_SMOOTH
            );
            logoMenor.setText("");
            logoMenor.setIcon(new ImageIcon(imgRedimensionada));
        } else {
            logoMenor.setText("Logo");
            logoMenor.setIcon(null);
        }
    }

    public Tela_Inicial(int id) {
        this.idf = id;
        Funcionarios f = new Funcionarios();
        f.setId(id);
        f.searchAccessLevelController();
        String accesslevel = f.getAccesslevel();
        initComponents();
        preencherTelaInicial();
         if (accesslevel.equals("Funcionário") ) {
            botao_Gestaodefuncionarios.setVisible(false);
        }
    }

    public void mudar_Panel(JPanel p){
        p.setSize(920,640);
        p.setLocation(0,0);
        panel_Base.removeAll();
        panel_Base.add(p,BorderLayout.CENTER);
        panel_Base.revalidate();
        panel_Base.repaint();
        
    }
    
    private void aplicarTemaClaro() {
    panelFundo.setBackground(new Color(237, 246, 238));
    panelLateral.setBackground(new Color(150, 215, 235));
    botao_Gestaodefuncionarios.setBackground(new Color(150, 215, 235));  
    botao_Gestaodeclientes.setBackground(new Color(150, 215, 235)); 
    botao_Gestaodeprodutos.setBackground(new Color(150, 215, 235)); 
    botao_Gestaodepedidos.setBackground(new Color(150, 215, 235)); 
    botao_Registros.setBackground(new Color(150, 215, 235)); 
    botao_Configuracoes.setBackground(new Color(150, 215, 235)); 
    botao_Sobre.setBackground(new Color(150, 215, 235)); 
    botao_Mudarmodo.setBackground(new Color(150, 215, 235)); 
    botao_Sair.setBackground(new Color(150, 215, 235));
    }

    private void aplicarTemaEscuro() {
    panelFundo.setBackground(new Color(27, 43, 52));
    panelLateral.setBackground(new Color(34, 56, 67));
    botao_Gestaodefuncionarios.setBackground(new Color(34, 56, 67));
    botao_Gestaodeclientes.setBackground(new Color(34, 56, 67)); 
    botao_Gestaodeprodutos.setBackground(new Color(34, 56, 67)); 
    botao_Gestaodepedidos.setBackground(new Color(34, 56, 67)); 
    botao_Registros.setBackground(new Color(34, 56, 67)); 
    botao_Configuracoes.setBackground(new Color(34, 56, 67)); 
    botao_Sobre.setBackground(new Color(34, 56, 67)); 
    botao_Mudarmodo.setBackground(new Color(34, 56, 67)); 
    botao_Sair.setBackground(new Color(34, 56, 67));
    }

    public void limitarCaracteres(JTextComponent campo, int limite) {
    AbstractDocument doc = (AbstractDocument) campo.getDocument();
    doc.setDocumentFilter(new DocumentFilter() {
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
                throws BadLocationException {
            
            int atual = fb.getDocument().getLength();
            int novo = text != null ? text.length() : 0;
            
            if ((atual - length + novo) <= limite) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    });
    }

    public int searchCollumn (JTable table) {
    int rowSelected = table.getSelectedRow();
    if (rowSelected != -1) {
        Object value = table.getValueAt(rowSelected,0);
        if (value != null) {
            return (int) value;
        }
    }
    return 0;
    }
    
    public String[] searchDataDashboard(List<Object[]> lista, String data1, String data2, String data3, int collumn1, int collumn2, int collumn3) {
    int info1 = 0;
    int info2 = 0;
    int info3 = 0;
   
    for (int i = 0; i < lista.size(); i++) {
        Object[] linha = lista.get(i);
        if(data1 == "id"){
            info1++;
        } else{
         if (linha[collumn1] != null && linha[collumn1].toString().equals(data1)) {
            info1++;
        }

        }
        if (linha[collumn2] != null && linha[collumn2].toString().equals(data2)) {
            info2++;
        }
        if (linha[collumn3] != null && linha[collumn3].toString().equals(data3)) {
            info3++;
        }
    }

    return new String[]{info1 + "", info2+ "", info3+ ""};
    }   

    public void updateTable(JTable tabela, List<Object[]> lista) {
    DefaultTableModel model = (DefaultTableModel) tabela.getModel();

    
    model.setRowCount(0);

   
    for (Object[] row : lista) {
        model.addRow(row);
    }

    }

    public String limparNumeros(String valor) {
        if (valor == null) return "";
        return valor.replaceAll("\\D", "");
    }

    public String formatarDataParaMySQL(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] partes = data.split("/");
        if (partes.length != 3) return null; // formato inválido
        return partes[2] + "-" + partes[1] + "-" + partes[0];
    }

    public String formatarDataParaXXMMYYYY(String data) {
    if (data == null || data.isEmpty()) return "";
    String[] partes = data.split("-");
    if (partes.length != 3) return data; 
    return partes[2] + "/" + partes[1] + "/" + partes[0];
    }

    public void configurarBotaoEnter(javax.swing.JPanel painel, javax.swing.JButton botao) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (painel.getRootPane() != null) {
                    painel.getRootPane().setDefaultButton(botao);
                }
            }
        });

        java.util.Stack<java.awt.Component> componentes = new java.util.Stack<>();
        componentes.push(painel);

        while (!componentes.isEmpty()) {
            java.awt.Component atual = componentes.pop();

            if (atual instanceof javax.swing.JTextField) {
                javax.swing.JTextField campoTexto = (javax.swing.JTextField) atual;
                campoTexto.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (botao.isEnabled() && botao.isVisible()) {
                            botao.requestFocus(); 
                            botao.doClick();
                        }
                    }
                });
            } 

            else if (atual instanceof java.awt.Container) {
                for (java.awt.Component filho : ((java.awt.Container) atual).getComponents()) {
                    componentes.push(filho);
                }
            }
        }
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelFundo = new javax.swing.JPanel();
        panelLateral = new javax.swing.JPanel();
        logoMenor = new javax.swing.JLabel();
        botao_Gestaodefuncionarios = new javax.swing.JToggleButton();
        botao_Gestaodeclientes = new javax.swing.JToggleButton();
        botao_Gestaodeprodutos = new javax.swing.JToggleButton();
        botao_Gestaodepedidos = new javax.swing.JToggleButton();
        botao_Registros = new javax.swing.JToggleButton();
        botao_Configuracoes = new javax.swing.JToggleButton();
        botao_Sobre = new javax.swing.JToggleButton();
        botao_Mudarmodo = new javax.swing.JToggleButton();
        botao_Sair = new javax.swing.JButton();
        linha_MenuLateral = new javax.swing.JSeparator();
        panel_Base = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelFundo.setBackground(new java.awt.Color(237, 246, 238));

        panelLateral.setBackground(new java.awt.Color(150, 215, 235));
        panelLateral.setPreferredSize(new java.awt.Dimension(250, 100));

        logoMenor.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        logoMenor.setForeground(new java.awt.Color(255, 255, 255));
        logoMenor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoMenor.setText("Logo");
        logoMenor.setPreferredSize(new java.awt.Dimension(80, 80));

        botao_Gestaodefuncionarios.setBackground(new java.awt.Color(150, 215, 235));
        buttonGroup1.add(botao_Gestaodefuncionarios);
        botao_Gestaodefuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18));
        botao_Gestaodefuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        botao_Gestaodefuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/Cliente_icon_34x24.png"))); // NOI18N
        botao_Gestaodefuncionarios.setText("Gestão de funcionários");
        botao_Gestaodefuncionarios.setBorderPainted(false);
        botao_Gestaodefuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Gestaodefuncionarios.setMargin(new java.awt.Insets(2, 18, 3, 14));
        botao_Gestaodefuncionarios.setPreferredSize(new java.awt.Dimension(260, 50));
        botao_Gestaodefuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_GestaodefuncionariosActionPerformed(evt);
            }
        });

        botao_Gestaodeclientes.setBackground(new java.awt.Color(150, 215, 235));
        buttonGroup1.add(botao_Gestaodeclientes);
        botao_Gestaodeclientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_Gestaodeclientes.setForeground(new java.awt.Color(255, 255, 255));
        botao_Gestaodeclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/Cliente_icon_34x24.png"))); // NOI18N
        botao_Gestaodeclientes.setText("Gestão de clientes");
        botao_Gestaodeclientes.setBorderPainted(false);
        botao_Gestaodeclientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Gestaodeclientes.setMargin(new java.awt.Insets(2, 18, 3, 14));
        botao_Gestaodeclientes.setPreferredSize(new java.awt.Dimension(260, 50));
        botao_Gestaodeclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_GestaodeclientesActionPerformed(evt);
            }
        });

        botao_Gestaodeprodutos.setBackground(new java.awt.Color(150, 215, 235));
        buttonGroup1.add(botao_Gestaodeprodutos);
        botao_Gestaodeprodutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_Gestaodeprodutos.setForeground(new java.awt.Color(255, 255, 255));
        botao_Gestaodeprodutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/estoque_oficial_25x25.png"))); // NOI18N
        botao_Gestaodeprodutos.setText("Gestão de produtos");
        botao_Gestaodeprodutos.setBorderPainted(false);
        botao_Gestaodeprodutos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Gestaodeprodutos.setIconTextGap(10);
        botao_Gestaodeprodutos.setMargin(new java.awt.Insets(2, 21, 3, 14));
        botao_Gestaodeprodutos.setPreferredSize(new java.awt.Dimension(260, 50));
        botao_Gestaodeprodutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_GestaodeprodutosActionPerformed(evt);
            }
        });

        botao_Gestaodepedidos.setBackground(new java.awt.Color(150, 215, 235));
        buttonGroup1.add(botao_Gestaodepedidos);
        botao_Gestaodepedidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_Gestaodepedidos.setForeground(new java.awt.Color(255, 255, 255));
        botao_Gestaodepedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/Icon_pedidos_30x30 (1).png"))); // NOI18N
        botao_Gestaodepedidos.setText("Gestão de pedidos");
        botao_Gestaodepedidos.setBorderPainted(false);
        botao_Gestaodepedidos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Gestaodepedidos.setIconTextGap(8);
        botao_Gestaodepedidos.setMargin(new java.awt.Insets(2, 18, 3, 14));
        botao_Gestaodepedidos.setPreferredSize(new java.awt.Dimension(260, 50));
        botao_Gestaodepedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_GestaodepedidosActionPerformed(evt);
            }
        });

        botao_Registros.setBackground(new java.awt.Color(150, 215, 235));
        buttonGroup1.add(botao_Registros);
        botao_Registros.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_Registros.setForeground(new java.awt.Color(255, 255, 255));
        botao_Registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/icon_relatorios_22x22.png"))); // NOI18N
        botao_Registros.setText("Registros");
        botao_Registros.setBorderPainted(false);
        botao_Registros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Registros.setIconTextGap(12);
        botao_Registros.setMargin(new java.awt.Insets(2, 23, 3, 14));
        botao_Registros.setPreferredSize(new java.awt.Dimension(260, 50));
        botao_Registros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_RegistrosActionPerformed(evt);
            }
        });

        botao_Configuracoes.setBackground(new java.awt.Color(150, 215, 235));
        buttonGroup1.add(botao_Configuracoes);
        botao_Configuracoes.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_Configuracoes.setForeground(new java.awt.Color(255, 255, 255));
        botao_Configuracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/gear_icon_20px.png"))); // NOI18N
        botao_Configuracoes.setText("Configurações");
        botao_Configuracoes.setBorderPainted(false);
        botao_Configuracoes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Configuracoes.setIconTextGap(12);
        botao_Configuracoes.setMargin(new java.awt.Insets(2, 23, 3, 14));
        botao_Configuracoes.setPreferredSize(new java.awt.Dimension(260, 50));
        botao_Configuracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ConfiguracoesActionPerformed(evt);
            }
        });

        botao_Sobre.setBackground(new java.awt.Color(150, 215, 235));
        buttonGroup1.add(botao_Sobre);
        botao_Sobre.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_Sobre.setForeground(new java.awt.Color(255, 255, 255));
        botao_Sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/icon_sobre_23x23.png"))); // NOI18N
        botao_Sobre.setText("Sobre");
        botao_Sobre.setBorderPainted(false);
        botao_Sobre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Sobre.setIconTextGap(12);
        botao_Sobre.setMargin(new java.awt.Insets(2, 23, 3, 14));
        botao_Sobre.setPreferredSize(new java.awt.Dimension(260, 50));
        botao_Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_SobreActionPerformed(evt);
            }
        });

        
        botao_Mudarmodo.setBackground(new java.awt.Color(150, 215, 235));
        botao_Mudarmodo.setFont(new java.awt.Font("Segoe UI", 0, 18));
        botao_Mudarmodo.setForeground(new java.awt.Color(255, 255, 255));
        botao_Mudarmodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/Modo claro.png"))); 
        botao_Mudarmodo.setBorderPainted(false);
        botao_Mudarmodo.setContentAreaFilled(false);
        botao_Mudarmodo.setDisabledIcon(null);
        botao_Mudarmodo.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/Modo escuro.png"))); 
        botao_Mudarmodo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Mudarmodo.setIconTextGap(12);
        botao_Mudarmodo.setMargin(new java.awt.Insets(2, 23, 3, 14));
        botao_Mudarmodo.setPreferredSize(new java.awt.Dimension(250, 50));
        botao_Mudarmodo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/Modo escuro.png")));
        botao_Mudarmodo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_MudarmodoActionPerformed(evt);
            }
        }); 
        
        botao_Sair.setBackground(new java.awt.Color(150, 215, 235));
        botao_Sair.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        botao_Sair.setForeground(new java.awt.Color(255, 255, 255));
        botao_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Image/Sair_icon_25x25.png"))); // NOI18N
        botao_Sair.setText("Sair");
        botao_Sair.setBorderPainted(false);
        botao_Sair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botao_Sair.setIconTextGap(12);
        botao_Sair.setMargin(new java.awt.Insets(2, 20, 3, 14));
        botao_Sair.setPreferredSize(new java.awt.Dimension(260, 50));
        botao_Sair.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_SairActionPerformed(evt);
            }
        });    
        linha_MenuLateral.setForeground(new java.awt.Color(255, 255, 255));
        linha_MenuLateral.setMinimumSize(new java.awt.Dimension(200, 10));

        javax.swing.GroupLayout panelLateralLayout = new javax.swing.GroupLayout(panelLateral);
        panelLateral.setLayout(panelLateralLayout);
        panelLateralLayout.setHorizontalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_Mudarmodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Configuracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Sobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Gestaodeclientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Gestaodeprodutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Gestaodepedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Registros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_Gestaodefuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(linha_MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLateralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        panelLateralLayout.setVerticalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botao_Gestaodefuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_Gestaodeclientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_Gestaodeprodutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_Gestaodepedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_Registros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linha_MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_Configuracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_Sobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(botao_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_Mudarmodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        panel_Base.setBackground(new java.awt.Color(237, 246, 238));
        panel_Base.setPreferredSize(new java.awt.Dimension(920, 640));
     


        panel_Base.setLayout(new BorderLayout());
        panel_Base.add(new Panel_BaseTelaInicial(), BorderLayout.CENTER);
  
        
        
        javax.swing.GroupLayout panelFundoLayout = new javax.swing.GroupLayout(panelFundo);
        panelFundo.setLayout(panelFundoLayout);
        panelFundoLayout.setHorizontalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addComponent(panelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(panel_Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        panelFundoLayout.setVerticalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLateral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(panel_Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_SobreActionPerformed
    Panel_Sobre panel  = new Panel_Sobre(this);
    mudar_Panel(panel);
    }//GEN-LAST:event_botao_SobreActionPerformed

    private void botao_GestaodeclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_GestaodeclientesActionPerformed
        Panel_GestaoClientes panel  = new Panel_GestaoClientes(this);
        mudar_Panel(panel);
    }//GEN-LAST:event_botao_GestaodeclientesActionPerformed

    private void botao_GestaodeprodutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_GestaodeprodutosActionPerformed
        Panel_GestaoProdutos panel  = new Panel_GestaoProdutos(this);
        mudar_Panel(panel);
    }//GEN-LAST:event_botao_GestaodeprodutosActionPerformed

    private void botao_GestaodepedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_GestaodepedidosActionPerformed
       Panel_GestaoPedidos panel  = new Panel_GestaoPedidos(this);
       mudar_Panel(panel);
    }//GEN-LAST:event_botao_GestaodepedidosActionPerformed

    private void botao_RegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_RegistrosActionPerformed
       Panel_Registros panel  = new Panel_Registros(this);
       mudar_Panel(panel);
    }//GEN-LAST:event_botao_RegistrosActionPerformed

    private void botao_GestaodefuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_GestaodefuncionariosActionPerformed
       Panel_GestaoFuncionarios panel  = new Panel_GestaoFuncionarios(this);
       mudar_Panel(panel);
    }//GEN-LAST:event_botao_GestaodefuncionariosActionPerformed

    private void botao_ConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    Panel_Configuracoes panel  = new Panel_Configuracoes(this);
    mudar_Panel(panel);
    }                                                   

    private void botao_MudarmodoActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    if (modoEscuro == false) {
        aplicarTemaEscuro();
        modoEscuro = true;
    }
    else{
        aplicarTemaClaro();
        modoEscuro = false;
    }
    }     
    
    private void botao_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ConfiguracoesActionPerformed
     int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do programa?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            Tela_Logon Tela_Logon = new Tela_Logon();
            Tela_Logon.setVisible(true); 
            this.dispose(); 
        }


        
    }//GEN-LAST:event_botao_ConfiguracoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botao_Configuracoes;
    private javax.swing.JToggleButton botao_Gestaodeclientes;
    private javax.swing.JToggleButton botao_Gestaodefuncionarios;
    private javax.swing.JToggleButton botao_Gestaodepedidos;
    private javax.swing.JToggleButton botao_Gestaodeprodutos;
    private javax.swing.JToggleButton botao_Mudarmodo;
    private javax.swing.JToggleButton botao_Registros;
    private javax.swing.JButton botao_Sair;
    private javax.swing.JToggleButton botao_Sobre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSeparator linha_MenuLateral;
    private javax.swing.JLabel logoMenor;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panel_Base;
    // End of variables declaration//GEN-END:variables
}
