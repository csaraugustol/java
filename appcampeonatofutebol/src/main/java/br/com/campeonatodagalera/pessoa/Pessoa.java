/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.pessoa;

import br.com.campeonatodagalera.enumtipos.ESexo;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author cesar
 */
public class Pessoa {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private double altura;
    private String nacionalidade;
    private ESexo sexo;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, LocalDate dataNascimento, double altura, String nacionalidade, ESexo sexo) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public ESexo getSexo() {
        return sexo;
    }

    public void setSexo(ESexo sexo) {
        this.sexo = sexo;
    }

    

  
    
}
