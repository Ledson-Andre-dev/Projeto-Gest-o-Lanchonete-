# Gestão de lanchonete 

# Tecnologias Utilizadas
* Java
* Maven
* MySQL

# Pré-requisitos
Antes de rodar o projeto, você vai precisar ter instalado em sua máquina:
* Java Development Kit (JDK)
* MySQL Server
* Uma IDE de sua preferência (ex: VS Code, IntelliJ IDEA, Eclipse)

# Configuração do Banco de Dados
Este projeto utiliza o MySQL. Para rodar a aplicação na sua máquina, siga os passos abaixo para configurar o banco de dados:

1. Abra a sua ferramenta de gerenciamento do MySQL (ex: MySQL Workbench).

2. Abra e execute o script SQL que está na pasta do projeto:
database/banco.sql .
> **Nota:**  O script criará automaticamente o banco de dados, todas as tabelas e triggers necessários.

3. No código do projeto, localize o arquivo de conexão com o banco de dados (ConexaoMySQL.java).

4. Altere as credenciais para o usuário e senha do seu MySQL local:
   Usuário: SEU_USUARIO_LOCAL
   Senha: SUA_SENHA_LOCAL