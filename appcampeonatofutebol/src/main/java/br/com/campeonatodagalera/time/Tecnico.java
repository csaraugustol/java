/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.time;

import br.com.campeonatodagalera.enumtipos.ESexo;
import br.com.campeonatodagalera.pessoa.Pessoa;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author cesar
 */
public class Tecnico extends Pessoa {

    private String numRegistro;
    private String time;

    public Tecnico() {
    }

    public Tecnico(String numRegistro, int id, String nome, LocalDate dataNascimento, double altura, String nacionalidade, ESexo sexo) {
        super(id, nome, dataNascimento, altura, nacionalidade, sexo);
        this.numRegistro = numRegistro;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
