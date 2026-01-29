# TimãoDataBase 🦅

Este projeto é um sistema de gerenciamento de elenco para o Sport Club Corinthians Paulista (temporada 2026), desenvolvido para demonstrar competências técnicas em **Java**, **JDBC** e **SQL**.

---

## 🇧🇷 Português

### 📝 Descrição
O **TimãoDataBase** é uma aplicação CLI (Command Line Interface) que permite o gerenciamento completo (CRUD) dos atletas do Corinthians. O projeto foca em boas práticas de desenvolvimento, como o padrão **DAO (Data Access Object)** e a separação de responsabilidades.

### 🛠️ Tecnologias e Conceitos
* **Java 17+**: Uso de `LocalDate` e `Try-with-resources`.
* **MySQL**: Banco de dados relacional para persistência.
* **JDBC (Java Database Connectivity)**: Integração robusta sem frameworks de abstração.
* **Segurança**: Credenciais protegidas por arquivos de propriedades e `.gitignore`.
* **SQL Injection Prevention**: Uso estrito de `PreparedStatement`.

### 🚀 Como Executar
1.  **Prepare o Banco de Dados:**
    * Execute o script localizado em `src/main/resources/schema.sql` para criar o banco e as tabelas.
    * Execute o script em `src/main/resources/data.sql` para inserir o elenco inicial de 2026.
2.  **Configure as Credenciais:**
    * Localize o arquivo `database.properties.example` na raiz do projeto.
    * Renomeie-o para `database.properties`.
    * Insira seu usuário e senha do MySQL local.
3.  **Rode a Aplicação:**
    * Execute a classe `Main.java` através do terminal ou sua IDE favorita.

---

## 🇺🇸 English

### 📝 Description
**TimãoDataBase** is a CLI (Command Line Interface) application designed to manage the 2026 Corinthians squad. This project highlights proficiency in integrating Java with Relational Databases (MySQL) using pure JDBC and the **DAO (Data Access Object)** design pattern.

### 🛠️ Tech Stack & Concepts
* **Java 17+**: Implementation of `LocalDate` and `Try-with-resources`.
* **MySQL**: Relational database for data persistence.
* **JDBC (Java Database Connectivity)**: Direct database integration.
* **Security**: Sensitive credential management using `.properties` files and `.gitignore`.
* **SQL Injection Prevention**: Strict use of `PreparedStatement` for all queries.

### 🚀 How to Run
1.  **Setup the Database:**
    * Execute the script at `src/main/resources/schema.sql` to create the database and table structure.
    * Execute the script at `src/main/resources/data.sql` to populate the initial 2026 roster.
2.  **Configure Credentials:**
    * Locate the `database.properties.example` file in the project root.
    * Rename it to `database.properties`.
    * Fill in your local MySQL `user` and `password`.
3.  **Run the App:**
    * Execute the `Main.java` class via terminal or your preferred IDE.

---

## 🏗️ Project Structure / Estrutura do Projeto

```text
src/
 └── calistofernando/
     ├── model/          # Player entity
     ├── repository/     # ConnectionFactory & DAO (JDBC logic)
     ├── view/           # Main terminal interface
 └── main/resources/     # SQL scripts (schema & data)
