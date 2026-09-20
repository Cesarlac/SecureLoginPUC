# Projeto SecureLoginPUC

## Descrição
O SecureLoginPUC é um projeto de aplicação web que implementa um sistema de login seguro utilizando Spring Boot e Spring Security. O objetivo é permitir a autenticação de usuários, garantindo o acesso apropriado às rotas protegidas da aplicação e simulando o registro e a recuperação de senhas. Esta versão conta com uma interface gráfica moderna utilizando o efeito *Glassmorphism* integrada à identidade visual da PUC Minas.

## Estrutura do Projeto

    SecureLoginPUC
    │
    ├── src
    │   └── main
    │       ├── java
    │       │   └── com.example.SecureLoginPUC
    │       │       ├── application
    │       │       │   └── SecureLoginPucApplication.java
    │       │       ├── config
    │       │       │   └── SecurityConfig.java
    │       │       └── controller
    │       │           └── SecureLoginPUCController.java
    │       └── resources
    │           ├── application.properties
    │           ├── static
    │           │   ├── css
    │           │   │   ├── login.css
    │           │   │   ├── register.css
    │           │   │   └── style.css
    │           │   └── images
    │           │       ├── fundo.jpg
    │           │       └── logopuc.png
    │           └── templates
    │               ├── login.html
    │               ├── recoverpassword.html
    │               └── register.html

## Dependências

    <!-- Dependência do Spring Boot Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- Dependência do Spring Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- Dependência do Thymeleaf para o Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

## Thymeleaf

Thymeleaf é um motor de templates para Java que permite a criação de páginas HTML dinâmicas de forma simples e eficiente. Ele é frequentemente utilizado em aplicações Spring, proporcionando uma maneira intuitiva de gerar conteúdo HTML e manipular dados diretamente nas páginas.

### Principais Características

- **Natural Templating**: Os templates Thymeleaf são válidos como documentos HTML, permitindo que sejam visualizados em navegadores sem processamento.
- **Integração com Spring**: Thymeleaf se integra perfeitamente com o Spring Framework, facilitando a injeção de dependências e o acesso a beans do Spring.
- **Expressões de Template**: Utiliza uma sintaxe simples e expressiva para manipular dados, permitindo a criação de lógicas condicionais e loops diretamente nas páginas.

## Interface Gráfica

A interface gráfica foi desenvolvida com foco em usabilidade (UX) e design moderno, apresentando validações em tempo real no backend.

- **Login**: A página de login possui campos para inserir o nome de usuário e a senha. Ela exibe o logo da PUC Minas sobre uma caixa translúcida, proporcionando uma identificação visual clara. Abaixo do formulário, existem links direcionando para a página de registro e para a recuperação de senha.
- **Register**: A página de registro permite que novos usuários criem uma conta. Ela inclui validações rigorosas de campos vazios, formato de e-mail e requisitos mínimos de senha (confirmação e tamanho). 
- **Recover Password**: Tela dedicada para a simulação do envio de instruções de recuperação de credenciais para o e-mail do usuário.

### Capturas de Tela

| <img src="src/main/resources/static/images/SecureLoginPUC%20-%20Login%20Page.png" alt="Login" width="1000"/> |
|:----------------------------------------------------:|
|                        Login                         |

| <img src="src/main/resources/static/images/SecureLoginPUC%20-%20Registro.png" alt="Registro" width="1000"/> |
|:-------------------------------------------------------:|
|                        Registro                         |

| <img src="src/main/resources/static/images/SecureLoginPUC%20-%20Recuperar%20Senha.png" alt="Recuperar Senha" width="1000"/> |
|:-------------------------------------------------------:|
|                     Recuperar Senha                     |

## Métodos da Classe SecurityConfig

### @Configuration
Indica que a classe contém métodos de configuração que geram beans para o contexto da aplicação.

### @EnableWebSecurity
Ativa a segurança da web, permitindo a configuração de regras de segurança para as URLs da aplicação.

### public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
Configura as regras de segurança das requisições HTTP, permitindo o acesso público às páginas de login, registro, recuperação e arquivos estáticos (CSS/Imagens), restringindo o acesso às demais rotas.

### public UserDetailsService userDetailsService()
Configura o gerenciamento de usuários em memória, criando um usuário comum e um administrador, codificando as senhas.

### public PasswordEncoder passwordEncoder()
Define o codificador de senhas a ser utilizado na aplicação, utilizando o BCryptPasswordEncoder.

## URLs do projeto
- http://localhost:8080/login
- http://localhost:8080/login?logout=true
- http://localhost:8080/register
- http://localhost:8080/recoverpassword
- http://localhost:8080/ 

## Licença
Este projeto está licenciado sob a MIT License.
