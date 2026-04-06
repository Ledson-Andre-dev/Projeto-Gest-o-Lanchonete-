package CONTROLLER;
import java.util.List;

import javax.swing.JOptionPane;

import  MODEL.FuncionariosDB;

public class Funcionarios {

private int id;
private String accesslevel;

public Funcionarios(){}

public Funcionarios (int id){}

public boolean checkLoginController(String login, String senha){
    boolean confirmar = false; 
    FuncionariosDB f = new FuncionariosDB();
    confirmar = f.checkLogin(login, senha);
    return confirmar;
}

public void searchIDController(String login){
    FuncionariosDB f = new FuncionariosDB();
    int id = f.searchID(login);
    if (id > 0){
        this.id = id;
    }
    else{
        JOptionPane.showMessageDialog(null, "ID nao encontrado!");
    }

}

public void searchAccessLevelController(){
        FuncionariosDB f = new FuncionariosDB();
    String accesslevel = f.searchAccessLevel(this.id);
    if (accesslevel != ""){
        this.accesslevel = accesslevel;
    }
    else{
        JOptionPane.showMessageDialog(null, "ID nao encontrado!");
    }
}

public List<Object[]> getAllFuncionariosController(){
FuncionariosDB f = new FuncionariosDB();
return f.getAllFuncionarios();
}

public void addFuncionarioController(String nome , String cpf , String cargo, int nivel_acesso, String login , String senha, String telefone , String email, int status ){
FuncionariosDB f = new FuncionariosDB();
f.addFuncionario(nome,cpf, cargo , nivel_acesso , login , senha , telefone ,email ,status);
}

public String[] preencherAtualizarFuncionariosController(int id){
FuncionariosDB f = new FuncionariosDB();
return f.prencherAtulizarFuncionario(id);
}

public void updateFuncionarioController(String nome , String cpf , String cargo, int nivel_acesso, String login , String senha, String telefone , String email, int status , int id){
FuncionariosDB f = new FuncionariosDB();
f.updateFuncionario(nome,cpf, cargo , nivel_acesso , login , senha , telefone ,email ,status,id);
}        

public boolean removeFuncionarioController(int id){
    FuncionariosDB f = new FuncionariosDB();
    return f.removeFuncionario(id);
   
}

public List<Object[]> searchFuncionariosController(String filtro, String valor){
FuncionariosDB f = new FuncionariosDB();
return f.searchFuncionarios(filtro , valor);
}







































//GETTERS E SETTERS

public String getAccesslevel() {
    return accesslevel;
}

public void setAccesslevel(String accesslevel) {
    this.accesslevel = accesslevel;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}
}