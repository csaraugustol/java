/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.dao;

import br.com.campeonatodagalera.database.ConnectionCamp;
import br.com.campeonatodagalera.enumtipos.EEstadio;
import br.com.campeonatodagalera.face.DaoGenerics;
import br.com.campeonatodagalera.partida.Partida;
import br.com.campeonatodagalera.time.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 *
 * @author cesar
 */
public class PartidaDao implements DaoGenerics<Partida, Integer> {

    @Override
    public void inserir(Partida u) throws ClassNotFoundException, SQLException {

//        //conectar
//        Connection c = ConnectionCamp.getConnection();
//
//        //montar sql
//        String sql = "INSERT INTO `partida`\n"
//                + "(`data`,\n"
//                + "`horario`,\n"
//                + "`estadio`)\n"
//                + "VALUES\n"
//                + "(?,\n"
//                + "?,\n"
//                + "?);";
//
//        //preparar a execução
//        PreparedStatement pst = c.prepareStatement(sql);
//
//        //troca de valores
//        pst.setObject(1, u.getDataPartida());
//        pst.setString(2, u.getHorario());
//        pst.setString(3, u.getEstadio().toString());
//
//        //execução
//        pst.executeUpdate();
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "INSERT INTO `partida`\n"
                + "(`data`,\n"
                + "`horario`,\n"
                + "`time1`,\n"
                + "`time2`,\n"
                + "`estadio`,\n"
                + "`idArbitro`,\n"
                + "`idCamp`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";

        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setObject(1, u.getDataPartida());
        pst.setString(2, u.getHorario());
        pst.setString(3, u.getTime1());
        pst.setString(4, u.getTime2());
        pst.setString(5, u.getEstadio().toString());
        pst.setObject(6, retornaIdArb(u.getNomeArb()));
        pst.setObject(7, retornaIdCamp(u.getNomeCamp()));

        //execução
        pst.executeUpdate();
    }

    @Override
    public void alterar(Partida u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionCamp.getConnection();

        String sql = "UPDATE partida SET data = ?, horario = ?, time1 = ?, time2 = ?, estadio = ? WHERE idPartida = ?;";

        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setObject(1, u.getDataPartida());
        pst.setString(2, u.getHorario());
        pst.setString(3, u.getTime1());
        pst.setString(4, u.getTime2());
        pst.setString(5, u.getEstadio().toString());
        pst.setInt(6, u.getId());

        pst.executeUpdate();
    }

    @Override
    public void apagar(Partida u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionCamp.getConnection();

        //preparar a execução
        PreparedStatement pst = c.prepareStatement("DELETE FROM partida WHERE idPartida = ?; ");

        //troca de valores
        pst.setInt(1, u.getId());

        pst.executeUpdate();
    }

    @Override
    public Partida buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from partida WHERE idPartida = ?";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, i);

        //execução
        ResultSet rst = pst.executeQuery();

        Partida p = null;
        if (rst.next()) {
            //achou o objeto
            p = new Partida();
            p.setId(rst.getInt("idPartida"));
            p.setHorario(rst.getString("horario"));
            p.setEstadio(EEstadio.valueOf(rst.getString("estadio")));
        }
//        
        return p;
    }

    @Override
    public ArrayList<Partida> buscarTodos() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from partida;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Partida> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Partida p = new Partida();
            p.setId(rst.getInt("idPartida"));
            p.setTime1(rst.getString("time1"));
            p.setTime2(rst.getString("time2"));
            p.setHorario(rst.getString("horario"));
            p.setEstadio(EEstadio.valueOf(rst.getString("estadio")));
            p.setDataPartida(rst.getDate("data").toLocalDate());
            p.setNomeArb(rst.getString("idArbitro"));
            p.setNomeCamp(rst.getString("idCamp"));
     
            lista.add(p);
        }
//        
        return lista;
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select count(*) from partida;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);
    }

    public ArrayList<Partida> buscaComFiltragem(String nome) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from partida where horario like ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nome + "%");
        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Partida> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Partida p = new Partida();
            p.setId(rst.getInt("idPartida"));
            p.setTime1(rst.getString("time1"));
            p.setTime2(rst.getString("time2"));
            p.setHorario(rst.getString("horario"));
            p.setEstadio(EEstadio.valueOf(rst.getString("estadio")));
            p.setDataPartida(rst.getDate("data").toLocalDate());
            p.setNomeArb(rst.getString("idArbitro"));
            p.setNomeCamp(rst.getString("idCamp"));
            lista.add(p);
        }
//        
        return lista;
    }

    public int retornaIdArb(String t) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sqll = "select idpessoa from pessoa where tipo='Arbitro' and nomePessoa = '" + t + "';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sqll);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);

    }

    public int retornaIdCamp(String t) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select idCamp from campeonato where nomeCamp = '" + t + "';";
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);

    }

    public String retornaNomeArb(int t) throws ClassNotFoundException, SQLException {

        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sqll = "select nomePessoa from pessoa where tipo='Arbitro' and idpessoa = " + t + ";";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sqll);

        //execução
        ResultSet rst = pst.executeQuery();

        return rst.getString(1);

    }

}
