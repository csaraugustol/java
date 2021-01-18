/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.login;

/**
 *
 * @author cesar
 */
public class Usuario {
    private int id;
    private String nome;
    private String user;
    private String senha;

    public Usuario() {
    }

    public Usuario(int id, String nome, String user, String senha) {
        this.id = id;
        this.nome = nome;
        this.user = user;
        this.senha = senha;
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
