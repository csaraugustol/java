/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.dao;

import br.com.campeonatodagalera.database.ConnectionCamp;
import br.com.campeonatodagalera.enumtipos.ESexo;
import br.com.campeonatodagalera.face.DaoGenerics;
import br.com.campeonatodagalera.time.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class TimeDao implements DaoGenerics<Time, Integer> {

    @Override
    public void inserir(Time u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "INSERT INTO time\n"
                + "(nomeTime,\n"
                + "AnoFundacao,\n"
                + "cidade,\n"
                + "Categoria)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setInt(2, u.getAnoFundacao());
        pst.setString(3, u.getCidade());
        pst.setString(4, u.getCategoria());

        //execução
        pst.executeUpdate();
    }

    @Override
    public void alterar(Time u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionCamp.getConnection();

        //preparar a execução
        String sql = "UPDATE time SET nomeTime = ?, anoFundacao = ?, cidade = ?, categoria = ? WHERE idTime = ?;";
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setObject(2, u.getAnoFundacao());
        pst.setString(3, u.getCidade());
        pst.setString(4, u.getCategoria());
        pst.setInt(5, u.getId());

        pst.executeUpdate();
    }

    @Override
    public void apagar(Time u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionCamp.getConnection();

        //preparar a execução
        PreparedStatement pst = c.prepareStatement("DELETE FROM time WHERE idTime = ?;");

        //troca de valores
        pst.setInt(1, u.getId());

        pst.executeUpdate();
    }

    @Override
    public Time buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from time WHERE idTime = ?";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, i);

        //execução
        ResultSet rst = pst.executeQuery();

        Time t = null;
        if (rst.next()) {
            //achou o objeto
            t = new Time();
            t.setId(rst.getInt("idTime"));
            t.setNome(rst.getString("nomeTime"));
            t.setAnoFundacao(rst.getInt("anoFundacao"));
            t.setCidade(rst.getString("cidade"));
            t.setCategoria(rst.getString("categoria"));

        }

        return t;
    }

    @Override
    public ArrayList<Time> buscarTodos() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from time;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Time> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Time t = new Time();
            t.setId(rst.getInt("idTime"));
            t.setNome(rst.getString("nomeTime"));
            t.setAnoFundacao(rst.getInt("anoFundacao"));
            t.setCidade(rst.getString("cidade"));
            t.setCategoria(rst.getString("categoria"));

            lista.add(t);
        }
//        
        return lista;
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select count(*) from time";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);
    }

    ArrayList<Time> getListaTimes(int aInt) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select nomeTime from time;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, aInt);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Time> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Time t = new Time(0, rst.getString("nomeTime"), rst.getString("cidade"), rst.getString("categoria"), 0);
            lista.add(t);
        }
//        
        return lista;
    }

    public ArrayList<Time> buscaComFiltragem(String nome) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from time where nomeTime like ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nome + "%");
        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Time> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Time t = new Time();
            t.setId(rst.getInt("idTime"));
            t.setNome(rst.getString("nomeTime"));
            t.setAnoFundacao(rst.getInt("anoFundacao"));
            t.setCidade(rst.getString("cidade"));
            t.setCategoria(rst.getString("categoria"));

            lista.add(t);
        }
//        
        return lista;
    }
    
    public ArrayList<Time> ListaTimes() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select nomeTime from time;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, sql);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Time> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Time t = new Time();
            t.setNome(rst.getString("nomeTime"));
            lista.add(t);
        }
//        
        return lista;
    }
}
