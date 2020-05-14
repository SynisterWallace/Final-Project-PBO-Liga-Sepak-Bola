/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author Faizal
 */
public class FootballClub extends Club {
    private static int id = 0000;
    private int idClub;
    private int win =0;
    private int draw=0;
    private int lose=0;
    private int scoredgoals=0;
    private int conceded=0;
    private int point=0;
    private int matchplayed=0;
    
    
    
    
    public FootballClub( String nama, String lokasi){
        id++;
        idClub = id;
        setNama(nama);
        setLokasi(lokasi);
    }
   

    public int getId() {
        return idClub;
    }

    public void setId(int id) {
        
        this.idClub = id;
    }
    
    public int getWin(){
        return win;
    }
    
    public int getDraw() {
        return draw;
    }
    
    public int getLose(){
        return lose;
    }
    
    public int getScoredGoals() {
        return scoredgoals;
    }
    
    public int getConceded() {
        return conceded;
    }
    
    public int getPoint() {
        return point;
    }
    
    public int getMatchPlayed() {
        return matchplayed;
    }
    
    public void setWin(int i) {
        win=i;
    }
    
    public void setDraw(int i){
        draw = i;
    }
    
    public void setLose(int i) {
        lose=i;
    }
    
    public void setScoredGoals(int i){
        scoredgoals = i;
    }
    
     public void setConceded(int i){
        conceded = i;
    }
     
     public void setPoint(int i){
        point = i;
    }
    
     public void setMatchPlayed(int i){
        matchplayed = i;
    } 
    
    public String toString(){
         return getNama();
    }
}
