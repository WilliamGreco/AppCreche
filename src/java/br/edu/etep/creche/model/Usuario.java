package br.edu.etep.creche.model;

public class Usuario {

    private String email;
    private String senha;
    private String login;
    private String perfil;

    public Usuario() {
    }

    public Usuario(String email, String senha, String login, String perfil) {
        this.email = email;
        this.senha = senha;
        this.login = login;
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

   
}
