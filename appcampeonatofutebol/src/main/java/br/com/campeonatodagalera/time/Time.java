/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.time;

import br.com.campeonatodagalera.partida.Partida;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class Time {
    private int id;
    private String nome;
    private String cidade;
    private String categoria;
    private int anoFundacao;
    private ArrayList<Jogador> jogadores;
    private Tecnico tecnico;
    private Partida partida;
    

    public Time() {
 
    }

    public Time(int id, String nome, String cidade, String categoria, int anoFundacao) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.categoria = categoria;
        this.anoFundacao = anoFundacao;
        this.tecnico = tecnico;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

     public void addJogador(Jogador j) {
        this.jogadores.add(j);
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
     
     
    
    
    
}
