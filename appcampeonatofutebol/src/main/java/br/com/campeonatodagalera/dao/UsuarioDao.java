/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.dao;

import br.com.campeonatodagalera.database.ConnectionCamp;
import br.com.campeonatodagalera.face.DaoGenerics;
import br.com.campeonatodagalera.login.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class UsuarioDao implements DaoGenerics<Usuario, Integer> {

    @Override
    public void inserir(Usuario u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "INSERT INTO usuario\n"
                + "(nome,\n"
                + "usuario,\n"
                + "senha)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?);";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setString(2, u.getUser());
        pst.setString(3, u.getSenha());

        //execução
        pst.executeUpdate();

    }

    @Override
    public void alterar(Usuario u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "UPDATE usuario\n"
                + "SET\n"
                + "nome = ?,\n"
                + "usuario = ?,\n"
                + "senha = ?\n"
                + "WHERE idUsuario = ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, u.getNome());
        pst.setString(2, u.getUser());
        pst.setString(3, u.getSenha());
        pst.setInt(4, u.getId());

        //execução
        pst.executeUpdate();
    }

    @Override
    public void apagar(Usuario u) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "DELETE FROM usuario WHERE idUsuario = ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, u.getId());

        //execução
        pst.executeUpdate();
    }

    @Override
    public Usuario buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from usuario WHERE idUsuario = ?";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setInt(1, i);

        //execução
        ResultSet rst = pst.executeQuery();

        Usuario u = null;
        if (rst.next()) {
            //achou o objeto
            u = new Usuario();
            u.setId(rst.getInt("idUsuario"));
            u.setNome(rst.getString("nome"));
            u.setUser(rst.getString("usuario"));
            u.setSenha(rst.getString("senha"));
        }
//        
        return u;
    }

    @Override
    public ArrayList<Usuario> buscarTodos() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from usuario;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Usuario> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Usuario u = new Usuario();

            u.setId(rst.getInt("idUsuario"));
            u.setNome(rst.getString("nome"));
            u.setUser(rst.getString("usuario"));
            u.setSenha(rst.getString("senha"));

            lista.add(u);
        }
//        
        return lista;
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select count(*) from usuario";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //execução
        ResultSet rst = pst.executeQuery();

        rst.next();

        return rst.getInt(1);
    }

    public Usuario buscaUsuarioSenha(String usuario, String senha) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from usuario WHERE usuario = ? and senha = ?";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);

        //troca de valores
        pst.setString(1, usuario);
        pst.setString(2, senha);

        //execução
        ResultSet rst = pst.executeQuery();

        Usuario j = null;
        if (rst.next()) {
            //achou o objeto
            j = new Usuario(0, rst.getString("nome"), rst.getString("usuario"), rst.getString("senha"));

        }
//        
        return j;
    }

    public ArrayList<Usuario> buscaComFiltragem(String nome) throws ClassNotFoundException, SQLException {
        //conectar
        Connection c = ConnectionCamp.getConnection();

        //montar sql
        String sql = "select * from usuario where nome like ?;";
        //preparar a execução
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%"+nome+"%");
       //execução
        ResultSet rst = pst.executeQuery();

        ArrayList<Usuario> lista = new ArrayList<>();
        while (rst.next()) {
            //achou o objeto
            Usuario u = new Usuario();

            u.setId(rst.getInt("idUsuario"));
            u.setNome(rst.getString("nome"));
            u.setUser(rst.getString("usuario"));
            u.setSenha(rst.getString("senha"));

            lista.add(u);
        }
//        
        return lista;
    }

}
