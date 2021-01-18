/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.dao;

import br.com.campeonatodagalera.campeonato.Campeonato;
import br.com.campeonatodagalera.database.ConnectionCamp;
import br.com.campeonatodagalera.face.DaoGenerics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class CampeonatoDao implements DaoGenerics<Campeonato, Integer> {

    @Override
    public void inserir(Campeonato u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "INSERT INTO campeonato\n"
                + "(nomeCamp,\n"
                + "dataInicio,\n"
                + "dataFim)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?);";

        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setObject(2, u.getDataInicio());
        pst.setObject(3, u.getDataFim());

        //execução
        pst.executeUpdate();
    }

    @Override
    public void alterar(Campeonato u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "UPDATE campeonato\n"
                + "SET\n"
                + "nomeCamp = ?,\n"
                + "dataInicio = ?,\n"
                + "dataFim = ?\n"
                + "WHERE idCamp = ?;";

        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setObject(2, u.getDataInicio());
        pst.setObject(3, u.getDataFim());
        pst.setInt(4, u.getId());

        pst.executeUpdate();
    }

    @Override
    public void apagar(Campeonato u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionCamp.getConnection();

        //preparar a execução
        PreparedStatement pst = c.prepareStatement("DELETE FROM campeonato WHERE idCamp = ?;");

        //troca de valores
        pst.setInt(1, u.getId());

        pst.executeUpdate();
    }

    @Override
    public Campeonato buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from campeonato WHERE idCamp = ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, i);

        //execução
        ResultSet rst = pst.executeQuery();

        Campeonato camp = null;
        if (rst.next()) {
            //achou o objeto
            camp = new Campeonato();
            camp.setId(rst.getInt("idCamp"));
            camp.setNome(rst.getString("nomeCamp"));
            camp.setDataInicio(rst.getDate("dataInicio").toLocalDate());
            camp.setDataFim(rst.getDate("dataFim").toLocalDate());
        }
//        
        return camp;
    }

    @Override
    public ArrayList<Campeonato> buscarTodos() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from campeonato;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Campeonato> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Campeonato camp = new Campeonato();
            camp.setId(rst.getInt("idCamp"));
            camp.setNome(rst.getString("nomeCamp"));
            camp.setDataInicio(rst.getDate("dataInicio").toLocalDate());
            camp.setDataFim(rst.getDate("dataFim").toLocalDate());
            lista.add(camp);
        }
//        
        return lista;
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select count(*) from campeonato;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);
    }

    public ArrayList<Campeonato> buscaComFiltragem(String nome) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from campeonato where nomeCamp like ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nome + "%");
        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Campeonato> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Campeonato camp = new Campeonato();
            camp.setId(rst.getInt("idCamp"));
            camp.setNome(rst.getString("nomeCamp"));
            camp.setDataInicio(rst.getDate("dataInicio").toLocalDate());
            camp.setDataFim(rst.getDate("dataFim").toLocalDate());
            lista.add(camp);
        }
//        
        return lista;
    }

}
