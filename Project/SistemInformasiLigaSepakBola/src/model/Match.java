/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Faizal
 */
public class Match {
    private static int idmatch = 0;
    private int id;
    private FootballClub team1;
    private FootballClub team2;
    private int team1score;
    private int team2score;
    private Date date;
    private String date2;
    
    public Match(FootballClub team1, int team1score, FootballClub team2, int team2score, Date date , String date2){
        idmatch++;
        id=idmatch;
        setTeam1(team1);
        setTeam1score(team1score);
        setTeam2(team2);
        setTeam2score(team2score);
        setDate(date);
        this.date2 = date2;
    }

    public FootballClub getTeam1() {
        return team1;
    }

    public void setTeam1(FootballClub team1) {
        this.team1 = team1;
    }

    public FootballClub getTeam2() {
        return team2;
    }

    public void setTeam2(FootballClub team2) {
        this.team2 = team2;
    }

    public int getTeam1score() {
        return team1score;
    }

    public void setTeam1score(int team1score) {
        this.team1score = team1score;
    }

    public int getTeam2score() {
        return team2score;
    }

    public void setTeam2score(int team2score) {
        this.team2score = team2score;
    }

    public Date getDate() {
        return date;
    }
    public String getDate2() {
        return date2;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdMatch() {
        return id;
    }

    public void setIdMatch(int id) {
        this.id = idmatch;
    }    
}
