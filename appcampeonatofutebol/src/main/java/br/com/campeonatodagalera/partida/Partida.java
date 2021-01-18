/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.partida;

import br.com.campeonatodagalera.campeonato.Campeonato;
import br.com.campeonatodagalera.comissaoarbitragem.Arbitro;
import br.com.campeonatodagalera.enumtipos.EEstadio;
import br.com.campeonatodagalera.time.Time;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author cesar
 */
public class Partida {

    private int id;
    private EEstadio estadio;
    private LocalDate dataPartida;
    private String horario;
    private ArrayList<Time> times;
    private Arbitro arbitro;
    private String time1, time2;
    private String nomeArb, nomeCamp;
    private Campeonato camp;

    public Partida() {
        times = new ArrayList<>();
    }

    public Partida(EEstadio estadio, LocalDate dataPartida, String horario) {
        this.estadio = estadio;
        this.dataPartida = dataPartida;
        this.horario = horario;
    }

    public Partida(int id, EEstadio estadio, LocalDate dataPartida, String horario) {
        this.id = id;
        this.estadio = estadio;
        this.dataPartida = dataPartida;
        this.horario = horario;
    }

    public Partida(int id, EEstadio estadio, LocalDate dataPartida, String horario, ArrayList<Time> times, Arbitro arbitro, String time1, String time2, Campeonato camp) {
        this.id = id;
        this.estadio = estadio;
        this.dataPartida = dataPartida;
        this.horario = horario;
        this.times = times;
        this.arbitro = arbitro;
        this.time1 = time1;
        this.time2 = time2;
        this.camp = camp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EEstadio getEstadio() {
        return estadio;
    }

    public void setEstadio(EEstadio estadio) {
        this.estadio = estadio;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }

    public void addTime(Time t) {
        this.times.add(t);
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public Campeonato getCamp() {
        return camp;
    }

    public void setCamp(Campeonato camp) {
        this.camp = camp;
    }

    public String getNomeArb() {
        return nomeArb;
    }

    public void setNomeArb(String nomeArb) {
        this.nomeArb = nomeArb;
    }

    public String getNomeCamp() {
        return nomeCamp;
    }

    public void setNomeCamp(String nomeCamp) {
        this.nomeCamp = nomeCamp;
    }

}
