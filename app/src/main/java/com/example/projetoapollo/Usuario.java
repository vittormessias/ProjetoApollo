package com.example.projetoapollo;

public class Usuario {

    int id_usuario;
    String nomeUsuario, nomeLogin, nomeEmail, nomeSenha, nomeConfigSenha;


    public Usuario() {
    }

    public Usuario(int id_usuario, String nomeUsuario, String nomeLogin, String nomeEmail, String nomeSenha, String nomeConfigSenha) {
        this.id_usuario = id_usuario;
        this.nomeUsuario = nomeUsuario;
        this.nomeLogin = nomeLogin;
        this.nomeEmail = nomeEmail;
        this.nomeSenha = nomeSenha;
        this.nomeConfigSenha = nomeConfigSenha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getNomeEmail() {
        return nomeEmail;
    }

    public void setNomeEmail(String nomeEmail) {
        this.nomeEmail = nomeEmail;
    }

    public String getNomeSenha() {
        return nomeSenha;
    }

    public void setNomeSenha(String nomeSenha) {
        this.nomeSenha = nomeSenha;
    }

    public String getNomeConfigSenha() {
        return nomeConfigSenha;
    }

    public void setNomeConfigSenha(String nomeConfigSenha) {
        this.nomeConfigSenha = nomeConfigSenha;
    }
}
