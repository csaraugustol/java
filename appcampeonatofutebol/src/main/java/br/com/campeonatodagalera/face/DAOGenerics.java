/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.face;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author cesar
 */
public interface DaoGenerics<A, K>{
    
    public void inserir(A u) throws ClassNotFoundException, SQLException;
    public void alterar(A u) throws ClassNotFoundException, SQLException;
    public void apagar(A u) throws ClassNotFoundException, SQLException;
    public A buscarPorId(K i) throws ClassNotFoundException, SQLException;
    public ArrayList<A> buscarTodos() throws ClassNotFoundException, SQLException;
    public int count() throws ClassNotFoundException, SQLException;
    
}
