package com.example.SecureLoginPUC.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class SecureLoginPUCController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmarSenha") String confirmarSenha,
            Model model) { 

        model.addAttribute("usernameDigitado", username);
        model.addAttribute("emailDigitado", email);

        // 1. Validar campos vazios
        if (username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty() || confirmarSenha.trim().isEmpty()) {
            model.addAttribute("erro", "❌ Todos os campos são obrigatórios.");
            return "register"; 
        }

        // 2. Validar e-mail (verificação básica)
        if (!email.contains("@") || !email.contains(".")) {
            model.addAttribute("erro", "❌ Por favor, insira um e-mail válido.");
            return "register";
        }

        // 3. Validar se as senhas são iguais
        if (!password.equals(confirmarSenha)) {
            model.addAttribute("erro", "❌ As senhas não coincidem.");
            return "register";
        }

        // 4. Validar requisitos da senha (ex: mínimo de 6 caracteres)
        if (password.length() < 6) {
            model.addAttribute("erro", "❌ A senha deve ter pelo menos 6 caracteres.");
            return "register";
        }

        // 5. Validar duplicidade (Simulação: impedindo de criar com o usuário padrão)
        if (username.equalsIgnoreCase("usuario") || username.equalsIgnoreCase("admin")) {
            model.addAttribute("erro", "❌ Este nome de usuário já está em uso.");
            return "register";
        }

        // Se passar por todas as validações, simula o sucesso!
        System.out.println("Simulando o registro do utilizador com sucesso: " + username);
        return "redirect:/login"; 
    }

    @GetMapping("/recoverpassword")
    public String recoverpassword() {
        return "recoverpassword";
    }

    @PostMapping("/recoverpassword")
    public String handleRecoverPassword(@RequestParam("email") String email) {
        System.out.println("Simulando envio de e-mail de recuperação para: " + email);
        System.out.println("Recuperação de E-mail: Redirecionado para a página de login.");
        
        return "redirect:/login"; 
    }
}