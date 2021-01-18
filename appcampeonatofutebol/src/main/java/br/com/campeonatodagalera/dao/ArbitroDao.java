/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.dao;

import br.com.campeonatodagalera.comissaoarbitragem.Arbitro;
import br.com.campeonatodagalera.database.ConnectionCamp;
import br.com.campeonatodagalera.enumtipos.ESexo;
import br.com.campeonatodagalera.face.DaoGenerics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class ArbitroDao implements DaoGenerics<Arbitro, Integer> {

    @Override
    public void inserir(Arbitro u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "INSERT INTO pessoa\n"
                + "(nomePessoa,\n"
                + "tipo,\n"
                + "dataNasc,\n"
                + "sexo,\n"
                + "altura,\n"
                + "nacionalidade)\n"
                + "VALUES\n"
                + "(?,\n"
                + "'ARBITRO',\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setObject(2, u.getDataNascimento());
        pst.setString(3, u.getSexo().toString());
        pst.setDouble(4, u.getAltura());
        pst.setString(5, u.getNacionalidade());

        //execução
        pst.executeUpdate();
    }

    @Override
    public void alterar(Arbitro u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "UPDATE pessoa\n"
                + "SET\n"
                + "nomePessoa = ?,\n"
                //    + "dataNasc = ?,\n"
                + "sexo =?,\n"
                + "altura = ?,\n"
                + "nacionalidade = ?\n"
                + "WHERE idpessoa = ? and tipo = 'ARBITRO';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        //   pst.setString(2, u.getDataNascimento().toString());
        pst.setString(2, u.getSexo().toString());
        pst.setDouble(3, u.getAltura());
        pst.setString(4, u.getNacionalidade());
        pst.setInt(5, u.getId());

        //execução
        pst.executeUpdate();
    }

    @Override
    public void apagar(Arbitro u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "DELETE FROM pessoa WHERE idpessoa = ? and tipo = 'Arbitro';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, u.getId());

        //execução
        pst.executeUpdate();
    }

    @Override
    public Arbitro buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa WHERE idpessoa = ? and tipo = 'ARBITRO';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, i);

        //execução
        ResultSet rst = pst.executeQuery();

        Arbitro a = null;
        if (rst.next()) {

            a = new Arbitro();
            a.setId(rst.getInt("idpessoa"));
            a.setNome(rst.getString("nomePessoa"));
            a.setAltura(rst.getDouble("altura"));
            a.setSexo(ESexo.valueOf(rst.getString("sexo")));
            a.setNacionalidade(rst.getString("nacionalidade"));
            a.setDataNascimento(rst.getDate("dataNasc").toLocalDate());

        }

        return a;
    }

    @Override
    public ArrayList<Arbitro> buscarTodos() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa WHERE tipo = 'ARBITRO';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Arbitro> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Arbitro a = new Arbitro();
            a.setId(rst.getInt("idpessoa"));
            a.setNome(rst.getString("nomePessoa"));
            a.setAltura(rst.getDouble("altura"));
            a.setSexo(ESexo.valueOf(rst.getString("sexo")));
            a.setNacionalidade(rst.getString("nacionalidade"));
            a.setDataNascimento(rst.getDate("dataNasc").toLocalDate());
            lista.add(a);
        }
//        
        return lista;
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select count(*) from pessoa WHERE tipo = 'ARBITRO';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);
    }

    public ArrayList<Arbitro> buscaComFiltragem(String nome) throws ClassNotFoundException, SQLException {

        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa WHERE tipo = 'ARBITRO' and nomePessoa like ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nome + "%");
        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Arbitro> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Arbitro a = new Arbitro();
            a.setId(rst.getInt("idpessoa"));
            a.setNome(rst.getString("nomePessoa"));
            a.setAltura(rst.getDouble("altura"));
            a.setSexo(ESexo.valueOf(rst.getString("sexo")));
            a.setNacionalidade(rst.getString("nacionalidade"));
            a.setDataNascimento(rst.getDate("dataNasc").toLocalDate());
            lista.add(a);
        }
//        
        return lista;
    }
}
