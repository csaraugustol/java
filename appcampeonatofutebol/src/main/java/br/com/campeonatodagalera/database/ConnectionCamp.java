/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.database;

import br.com.campeonatodagalera.campeonato.Campeonato;
import br.com.campeonatodagalera.comissaoarbitragem.Arbitro;
import br.com.campeonatodagalera.dao.ArbitroDao;
import br.com.campeonatodagalera.dao.CampeonatoDao;
import br.com.campeonatodagalera.dao.JogadorDao;
import br.com.campeonatodagalera.dao.PartidaDao;
import br.com.campeonatodagalera.dao.TecnicoDao;
import br.com.campeonatodagalera.dao.TimeDao;
import br.com.campeonatodagalera.dao.UsuarioDao;
import br.com.campeonatodagalera.enumtipos.EEstadio;
import br.com.campeonatodagalera.enumtipos.EPosicao;
import br.com.campeonatodagalera.enumtipos.ESexo;
import br.com.campeonatodagalera.login.Usuario;
import br.com.campeonatodagalera.partida.Partida;
import br.com.campeonatodagalera.time.Jogador;
import br.com.campeonatodagalera.time.Tecnico;
import br.com.campeonatodagalera.time.Time;
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/appcampeonato", "root", "123");
            // } catch (SQLException ex) {
            //    System.out.println("Não foi possível conectar ao banco.");
            // }
        }

        return connection;
    }

    public static void main(String[] args) {

//        Usuario user = new Usuario("Zezim", "zezimgasolina", "7654321");
//        Campeonato camp = new Campeonato("Campeonato JF", LocalDate.of(2020, 10, 19), LocalDate.of(2020, 10, 23));
//        ComissaoArbitragem ca = new ComissaoArbitragem("Mineira");
//        Partida p = new Partida(0, EEstadio.MINEIRAO, LocalDate.of(2020, 11, 19), "16:00");
//        Arbitro a = new Arbitro(0, "Zezim", LocalDate.of(2020, 11, 19), 1.72, "Brasil", ESexo.MASCULINO);
//        Jogador j = new Jogador(EPosicao.ATACANTE, 9, 0, "Fernando Torres", LocalDate.of(1978, 11, 25), 1.80, "Espanha", ESexo.MASCULINO);
//        Time t = new Time(0, "América-MG", "Belo Horizonte", "Profissional", 1914);
//        Tecnico t = new Tecnico("777", 0, "Fernando Diniz", LocalDate.of(1985, 11, 19), 1.68, "Brasil", ESexo.MASCULINO);
//        teste
        Partida a = new Partida();
       // Arbitro a = new Arbitro();
//        a.setNome("MBappe");
//        Time a = new Time();
        a.setHorario("16:00");
        a.setTime1(a.getTime1());
         a.setTime2(a.getTime2());
        a.setEstadio(EEstadio.MINEIRAO);
        a.setDataPartida(LocalDate.of(2020, 11, 25));
      //  a.setCamp();
//        a.setAltura(1.79);
//        a.setSexo(ESexo.MASCULINO);
//        a.setNacionalidade("França");
        //a.setDataNascimento(LocalDate.of(2020, 11, 17));
        try {
            // final ArbitroDao a1 = new ArbitroDao();
            // final CampeonatoDao pd = new CampeonatoDao();
            //final ArbitroDao pd = new ArbitroDao();
//            final JogadorDao pd = new JogadorDao();
            //   final PartidaDao pd = new PartidaDao();
//            final TecnicoDao pd = new TecnicoDao();
//            final UsuarioDao pd = new UsuarioDao();
            final PartidaDao pd = new PartidaDao();
            pd.inserir(a);
            //  Partida a = pd.buscarPorId(1);
//            pd.count();
            //System.out.println("Quantidade: " + a.getNome());
            //   a.setHorario("16:00");
            //  pd.alterar(a);
//            new UsuarioDAO().inserir(user);
//            new ProfessorDAO().inserir(p);
//            Arbitro p1 = pd.buscarPorId(3);
//            Jogador p1 = pd.buscarPorId(1);
//            Campeonato p1 = pd.buscarPorId(1);
//            Partida p1 = pd.buscarPorId(1);
//            Usuario p1 = pd.buscarPorId(1);
//            Time p1 = pd.buscarPorId(1);
            //  ArrayList<Partida> p1 = pd.buscarTodos();
//            ArrayList<Partida> p1 = pd.buscarTodos();
//            ArrayList<Tecnico> p1 = pd.buscarTodos();
//            ArrayList<Time> p1 = pd.buscarTodos();
//            Tecnico p1 = pd.buscarPorId(1);
//            ArrayList<Usuario> p1 = pd.buscarTodos();

//            System.out.println("Nome Atual " + p1.getId());
//            pd.apagar(p1);
//////            
//            p1.setNome("Wilton Pereira Sampaio");
//
//            pd.alterar(p1);
//
//            System.out.println("Nome Atual " + p1.getNome());
//            Arbitro p2 = pd.buscarPorId(8);
//            System.out.println("Nome Atual " + p2.getNome());
//            Arbitro d = new Arbitro();
//            d.setNome("Márcio");
//
//            new ArbitroDao().alterar(d);
//            new TimeDao().inserir(t);
//            final TimeDao am = new TimeDao();
//            Time a = am.buscarPorId(2);
//            System.out.println("Nome: " + a.getNome());
//
//            a.setNome("São aa");
//            am.alterar(a);
        } catch (ClassNotFoundException ex) {
            System.out.println("Falta o driver.");
        } catch (SQLException ex) {
            System.out.println("Erro ao executar comando.");
        }

//                Connection c = null;
//        try {
//            c = getConnection();
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Driver não encontrado");
//        } catch (SQLException ex) {
//            System.out.println("Não foi possível realizar a conexão");
//        }
//        try {
//            System.out.println(" "+c.getCatalog());
//        } catch (SQLException ex) {
//            System.out.println("Erro na main");
//        }catch (Exception ex) {
//            System.out.println("Erro Geral!");
//        }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConnectionCamp.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionCamp.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
