/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.time;

import br.com.campeonatodagalera.enumtipos.EPosicao;
import br.com.campeonatodagalera.enumtipos.ESexo;
import br.com.campeonatodagalera.pessoa.Pessoa;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author cesar
 */
public class Jogador extends Pessoa {
    private EPosicao posicao;
    private int numero;
    private Time time;
    private String t;

    public Jogador() {
    }

    public Jogador(EPosicao posicao, int numero, int id, String nome, LocalDate dataNascimento, double altura, String nacionalidade, ESexo sexo) {
        super(id, nome, dataNascimento, altura, nacionalidade, sexo);
        this.posicao = posicao;
        this.numero = numero;
    }
    
    public Jogador(EPosicao posicao, int numero, int id, String nome, Time time, LocalDate dataNascimento, double altura, String nacionalidade, ESexo sexo) {
        super(id, nome, dataNascimento, altura, nacionalidade, sexo);
        this.posicao = posicao;
        this.numero = numero;
        this.time = time;
    }

    

    public EPosicao getPosicao() {
        return posicao;
    }

    public void setPosicao(EPosicao posicao) {
        this.posicao = posicao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    
    
    
    
   
    
    
    
}
