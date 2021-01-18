/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar
 */
public class ConnectionCamp {

    private static Connection connection;

    private ConnectionCamp() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {

            //try {
            Class.forName("com.mysql.jdbc.Driver");
            // } catch (ClassNotFoundException ex) {
            ///      System.out.println("Não foi possível localizar o driver.");
            // }
            // /try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/appcampeonato", "", "");
            // } catch (SQLException ex) {
            //    System.out.println("Não foi possível conectar ao banco.");
            // }
        }

        return connection;
    }

    public static void main(String[] args) {

        try {

           
        } catch (ClassNotFoundException ex) {
            System.out.println("Falta o driver.");
        } catch (SQLException ex) {
            System.out.println("Erro ao executar comando.");
        }
      
    }
}
