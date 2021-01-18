/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.dao;

import br.com.campeonatodagalera.database.ConnectionCamp;
import br.com.campeonatodagalera.enumtipos.EPosicao;
import br.com.campeonatodagalera.enumtipos.ESexo;
import br.com.campeonatodagalera.face.DaoGenerics;
import br.com.campeonatodagalera.time.Jogador;
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
public class JogadorDao implements DaoGenerics<Jogador, Integer> {

    @Override
    public void inserir(Jogador u) throws ClassNotFoundException, SQLException {
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
                + "posicaoJogador,\n"
                + "numeroCamisa,\n"
                + "idTime)\n"
                + "VALUES\n"
                + "(?,\n"
                + "'JOGADOR',\n"
                + "?,\n"
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
        pst.setString(6, u.getPosicao().toString());
        pst.setInt(7, u.getNumero());
        pst.setObject(8, retornaId(u.getT()));

        //execução
        pst.executeUpdate();
    }

    @Override
    public void alterar(Jogador u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "UPDATE pessoa\n"
                + "SET\n"
                + "nomePessoa = ?,\n"
                + "dataNasc = ?,\n"
                + "sexo =?,\n"
                + "altura = ?,\n"
                + "nacionalidade = ?,\n"
                + "posicaoJogador = ?,\n"
                + "numeroCamisa = ?\n"
                + "WHERE idpessoa = ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setObject(2, u.getDataNascimento());
        pst.setString(3, u.getSexo().toString());
        pst.setDouble(4, u.getAltura());
        pst.setString(5, u.getNacionalidade());
        pst.setString(6, u.getPosicao().toString());
        pst.setInt(7, u.getNumero());
        pst.setInt(8, u.getId());

        pst.executeUpdate();
    }

    @Override
    public void apagar(Jogador u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "DELETE from pessoa WHERE idpessoa = ? and tipo = 'JOGADOR';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, u.getId());

        //execução
        pst.executeUpdate();
    }

    @Override
    public Jogador buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa where idpessoa = ? and tipo = 'JOGADOR';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, i);

        //execução
        ResultSet rst = pst.executeQuery();

        Jogador j = null;
        if (rst.next()) {
            //achou o objeto
            j = new Jogador();
            j.setId(rst.getInt("idpessoa"));
            j.setNome(rst.getString("nomePessoa"));
            j.setAltura(rst.getDouble("altura"));
            j.setSexo(ESexo.valueOf(rst.getString("sexo")));
            j.setNacionalidade(rst.getString("nacionalidade"));
            j.setDataNascimento(rst.getDate("dataNasc").toLocalDate());
            j.setNumero(rst.getInt("numeroCamisa"));
            j.setPosicao(EPosicao.valueOf(rst.getString("posicaoJogador")));

        }

        return j;
    }

    @Override
    public ArrayList<Jogador> buscarTodos() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa WHERE tipo = 'JOGADOR';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Jogador> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Jogador j = new Jogador();

            j.setId(rst.getInt("idpessoa"));
            j.setNome(rst.getString("nomePessoa"));
            j.setAltura(rst.getDouble("altura"));
            j.setSexo(ESexo.valueOf(rst.getString("sexo")));
            j.setNacionalidade(rst.getString("nacionalidade"));
            j.setDataNascimento(rst.getDate("dataNasc").toLocalDate());
            j.setNumero(rst.getInt("numeroCamisa"));
            j.setPosicao(EPosicao.valueOf(rst.getString("posicaoJogador")));
            lista.add(j);
        }
//        
        return lista;
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select count(*) from pessoa WHERE tipo = 'JOGADOR';";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);
    }

    ArrayList<Jogador> getListaJogadores(int aInt) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa\n"
                + "natural join time\n"
                + "where idPessoa=?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, aInt);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Jogador> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Jogador j = new Jogador();

            j.setNome(rst.getString("nomePessoa"));
            j.setNacionalidade(rst.getString("nacionalidade"));
            j.setId(rst.getInt("idpessoa"));
            j.setAltura(rst.getDouble("altura"));
            j.setNumero(rst.getInt("numeroCamisa"));
            lista.add(j);
        }

        return lista;
    }

    public ArrayList<Jogador> buscaComFiltragem(String nome) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from pessoa WHERE tipo = 'JOGADOR' and nomePessoa like ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nome + "%");
        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Jogador> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Jogador j = new Jogador();

            j.setId(rst.getInt("idpessoa"));
            j.setNome(rst.getString("nomePessoa"));
            j.setAltura(rst.getDouble("altura"));
            j.setSexo(ESexo.valueOf(rst.getString("sexo")));
            j.setNacionalidade(rst.getString("nacionalidade"));
            j.setDataNascimento(rst.getDate("dataNasc").toLocalDate());
            j.setNumero(rst.getInt("numeroCamisa"));
            j.setPosicao(EPosicao.valueOf(rst.getString("posicaoJogador")));
            lista.add(j);
        }
//        
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
