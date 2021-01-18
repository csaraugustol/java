/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.comissaoarbitragem;

import br.com.campeonatodagalera.enumtipos.ESexo;
import br.com.campeonatodagalera.pessoa.Pessoa;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author cesar
 */
public class Arbitro extends Pessoa{

    public Arbitro() {
    }

    public Arbitro(int id, String nome, LocalDate dataNascimento, double altura, String nacionalidade, ESexo sexo) {
        super(id, nome, dataNascimento, altura, nacionalidade, sexo);
    }

    
   
}
