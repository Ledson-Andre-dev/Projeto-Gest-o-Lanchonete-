package CONTROLLER;
import MODEL.ConfiguracaoDB;

public class Configuracao {
        public Configuracao(){}

        public void updateConfiguracaoController(String nome, String descricao, String logo, String banner) {
        ConfiguracaoDB config = new ConfiguracaoDB();
        config.updateConfiguracao(nome, descricao, logo, banner);
    }

    public String[] preencherConfigurarController() {
    ConfiguracaoDB config = new ConfiguracaoDB();
    return config.preencherConfigurar();
}


}
