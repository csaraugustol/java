/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.dao;

import br.com.campeonatodagalera.database.ConnectionCamp;
import br.com.campeonatodagalera.enumtipos.ESexo;
import br.com.campeonatodagalera.face.DaoGenerics;
import br.com.campeonatodagalera.time.Tecnico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class TecnicoDao implements DaoGenerics<Tecnico, Integer> {

    @Override
    public void inserir(Tecnico u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "INSERT INTO pessoa\n"
                + "(nomePessoa,\n"
                + "tipo,\n"
                + "dataNasc,\n"
                + "sexo,\n"
                + "altura,\n"
                + "nacionalidade,\n"
                + "numRegTecnico,\n"
                + "idTime)\n"
                + "VALUES\n"
                + "(?,\n"
                + "'TECNICO',\n"
                + "?,\n"
                + "?,\n"
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
        pst.setString(6, u.getNumRegistro());
        pst.setObject(7, retornaId(u.getTime()));

        //execução
        pst.executeUpdate();
    }

    @Override
    public void alterar(Tecnico u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "UPDATE pessoa\n"
                + " SET\n"
                + "nomePessoa = ?,\n"
                + "dataNasc = ?,\n"
                + "sexo =?,\n"
                + "altura = ?,\n"
                + "nacionalidade = ?,\n"
                + "numRegTecnico = ?\n"
                + " WHERE idpessoa = ? and tipo='TECNICO';";

        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setObject(2, u.getDataNascimento());
        pst.setString(3, u.getSexo().toString());
        pst.setDouble(4, u.getAltura());
        pst.setString(5, u.getNacionalidade());
        pst.setString(6, u.getNumRegistro());
        pst.setInt(7, u.getId());

        //execução
        pst.executeUpdate();
    }

    @Override
    public void apagar(Tecnico u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "DELETE from pessoa WHERE idPessoa = ? and tipo = 'TECNICO';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, u.getId());

        //execução
        pst.executeUpdate();
    }

    @Override
    public Tecnico buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa WHERE idPessoa = ? and tipo = 'TECNICO';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, i);

        //execução
        ResultSet rst = pst.executeQuery();

        Tecnico t = null;
        if (rst.next()) {
            //achou o objeto
            t = new Tecnico();
            t.setId(rst.getInt("idpessoa"));
            t.setNome(rst.getString("nomePessoa"));
            t.setAltura(rst.getDouble("altura"));
            t.setSexo(ESexo.valueOf(rst.getString("sexo")));
            t.setNacionalidade(rst.getString("nacionalidade"));
            t.setDataNascimento(rst.getDate("dataNasc").toLocalDate());
            t.setNumRegistro(rst.getString("numRegTecnico"));
        }

        return t;
    }

    @Override
    public ArrayList<Tecnico> buscarTodos() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa WHERE tipo = 'TECNICO';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Tecnico> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Tecnico t = new Tecnico();
            t.setId(rst.getInt("idpessoa"));
            t.setNome(rst.getString("nomePessoa"));
            t.setAltura(rst.getDouble("altura"));
            t.setSexo(ESexo.valueOf(rst.getString("sexo")));
            t.setNacionalidade(rst.getString("nacionalidade"));
            t.setDataNascimento(rst.getDate("dataNasc").toLocalDate());
            t.setNumRegistro(rst.getString("numRegTecnico"));

            lista.add(t);
        }

        return lista;
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select count(*) from pessoa WHERE tipo = 'TECNICO';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);
    }

    Tecnico getIdTecnico(int aInt) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa\n"
                + "natural join time\n"
                + "where tipo= 'TECNICO'; ";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, aInt);

        //execução
        ResultSet rst = pst.executeQuery();

        Tecnico t = null;
        if (rst.next()) {
            //achou o objeto
            t = new Tecnico(rst.getString("numRegTecnico"), 0, rst.getString("nomePessoa"), null, 0, rst.getString("nacionalidade"), ESexo.valueOf(rst.getString("sexo")));
        }

        return t;
    }

    public ArrayList<Tecnico> buscaComFiltragem(String nome) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa WHERE tipo = 'TECNICO' and nomePessoa like ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nome + "%");
        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Tecnico> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Tecnico t = new Tecnico();
            t.setId(rst.getInt("idpessoa"));
            t.setNome(rst.getString("nomePessoa"));
            t.setAltura(rst.getDouble("altura"));
            t.setSexo(ESexo.valueOf(rst.getString("sexo")));
            t.setNacionalidade(rst.getString("nacionalidade"));
            t.setDataNascimento(rst.getDate("dataNasc").toLocalDate());
            t.setNumRegistro(rst.getString("numRegTecnico"));

            lista.add(t);
        }

        return lista;
    }

    public int retornaId(String t) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sqll = "select idTime from time where nomeTime = '" + t + "';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sqll);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);

    }

}
