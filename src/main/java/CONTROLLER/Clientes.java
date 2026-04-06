package CONTROLLER;

import java.util.List;

import MODEL.ClientesDB;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Clientes {

public List<Object[]> getAllClientesController(){
ClientesDB c = new ClientesDB();
return c.getAllClientes();
}

public void addClienteController(String nome, String cpf, String dataNascimento, String cep, String estado, String cidade, String bairro, String rua, String numRua, String complemento, String telefone, String email, String status) {
ClientesDB c =new ClientesDB();
c.addCliente(nome, cpf, dataNascimento, cep, estado, cidade, bairro, rua, numRua, complemento, telefone, email, status);
}

public String[] preencherAtualizarClientesController(int id){
ClientesDB c = new ClientesDB();
return c.preencherAtualizarCliente(id);
}

public void updateClienteController(String nome, String cpf, String dataNascimento, String cep,String estado, String cidade, String bairro, String rua,String numRua, String complemento, String telefone, String email,String status, int id) {
ClientesDB c = new ClientesDB();
c.updateCliente(nome, cpf, dataNascimento, cep, estado, cidade, bairro, rua, numRua, complemento, telefone, email, status, id);
}

public boolean removeClienteController(int id){
        ClientesDB c = new ClientesDB();
        return c.removeCliente(id);
    
    }

public List<Object[]> searchClientesController(String filtro, String valor){
    ClientesDB c = new ClientesDB();
    return c.searchClientes(filtro , valor);
    }

public boolean isCpfValido(String cpf) {
    
    if (cpf == null) return false;

    
    cpf = cpf.replaceAll("\\D", "");


    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

    try {
   
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) digito1 = 0;

   
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) digito2 = 0;

       
        return (cpf.charAt(9) - '0' == digito1) && (cpf.charAt(10) - '0' == digito2);
        
    } catch (Exception e) {
        return false;
    }
}    

public boolean isDataValida(String data) {
    if (data == null || data.trim().isEmpty()) return false;

    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                                                   .withResolverStyle(ResolverStyle.STRICT);

    try {
       
        LocalDate dataNascimento = LocalDate.parse(data, formatter);
        LocalDate hoje = LocalDate.now(); 

     
        if (dataNascimento.isAfter(hoje)) {
            return false; 
        }

       
        int idade = Period.between(dataNascimento, hoje).getYears();
        if (idade < 14) {
            return false;
        }

        
        return true;
        
    } catch (DateTimeParseException e) {
        return false; 
    }
}
}
