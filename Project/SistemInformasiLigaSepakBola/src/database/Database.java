/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Pemain;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FootballClub;
import model.Match;
import model.Pelatih;

/**
 *
 * @author Faizal
 */
public class Database {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    public void connect(){
        try{
            String url = "jdbc:mysql://localhost:3306/db_liga";
            String username = "root";
            String pass = "";
            con = DriverManager.getConnection(url,username,pass);
            System.out.println("connected");
        }catch (SQLException ex){
            System.out.println("connection error");
            ex.printStackTrace();
        }
    }
    
    public void disconnect(){
        try {
            con.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addClub(FootballClub FC) {
        connect();
       try{
           String query = "insert into t_FootballClub values ("+FC.getId()+ ",'" +FC.getNama()+"',"+FC.getMatchPlayed()+","+FC.getWin()+","+FC.getDraw()+","+FC.getLose()+","+FC.getScoredGoals()+","+FC.getConceded()+","+FC.getPoint()+",'"+FC.getLokasi()+"');";
           stmt = (Statement) con.createStatement();
           stmt.execute(query);
       } catch (SQLException  ex){
           System.out.println(ex.getMessage());
       }
       System.out.println("Sukses");
       disconnect();
   } 
    public void deleteClub(FootballClub FC) throws SQLException{
        connect();
        String query = "delete from t_FootballClub where ID ="+FC.getId()+";";
        stmt = (Statement) con.createStatement();
        stmt.execute(query);
        disconnect();
    }
    
    public void updateClub(FootballClub FC){
        try {
            connect();
            String query ="update t_footballclub set match_played = "+FC.getMatchPlayed()+", win = "+FC.getWin()+", draw = "+FC.getDraw()+", lose = "+FC.getLose()+", goal = "+FC.getScoredGoals()+", conceded = "+FC.getConceded()+", point = "+FC.getPoint()+" where id = "+FC.getId()+";";
            stmt = (Statement) con.createStatement();
            stmt.execute(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Sukses");
        disconnect();
    }
    
    public ArrayList<FootballClub> loadAllClub(){
        ArrayList<FootballClub> listClub = new ArrayList<>();
        connect();
        String query = "select * from t_FootballClub;";
        try{
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                FootballClub fc = new FootballClub(rs.getString("name"), rs.getString("location") );
                fc.setId(Integer.parseInt(rs.getString("id")));
                fc.setMatchPlayed(Integer.parseInt(rs.getString("match_played")));
                fc.setWin(Integer.parseInt(rs.getString("win")));
                fc.setDraw(Integer.parseInt(rs.getString("draw")));
                fc.setLose(Integer.parseInt(rs.getString("lose")));
                fc.setScoredGoals(Integer.parseInt(rs.getString("goal")));
                fc.setConceded(Integer.parseInt(rs.getString("conceded")));
                fc.setPoint(Integer.parseInt(rs.getString("point")));
                listClub.add(fc);
            }
        } catch (SQLException  ex){
           System.out.println(ex.getMessage());
       }
        disconnect();
        return listClub;
    }
    
    public void addPemain(Pemain p){
        connect();
        try {
            String query ="insert into t_pemain values(" +p.getIdpemain()+",'" +p.getNama()+"',"+p.getUsia()+","+p.getIdclub()+");";
            stmt = (Statement) con.createStatement();
            stmt.execute(query);
        } catch (SQLException ex) {
            System.out.println("Error"+ex.getMessage());
        }
        System.out.println("Sukses");
        disconnect();
    }
    
   public void deletePemain(int p) throws SQLException{
       connect();
        String query = "delete from t_pemain where idPemain ="+p+";";
        stmt = (Statement) con.createStatement();
        stmt.execute(query);
        disconnect();
    }
   
   public ArrayList<Pemain> loadAllPemain(int idclub){
        ArrayList<Pemain> listPemain = new ArrayList<>();
        connect();
        String query = "select * from t_pemain where idclub="+String.valueOf(idclub)+";";
        try{
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Pemain p = new Pemain(rs.getString("name"), rs.getInt("age"));
                p.setIdpemain(Integer.parseInt(rs.getString("idpemain")));
                listPemain.add(p);
            }
        } catch (SQLException  ex){
           System.out.println(ex.getMessage());
       }
        disconnect();
        return listPemain;
    }
    
    public void addPelatih(Pelatih PL) {
        connect();
        try{
           System.out.println(PL.getLisensi());
           String query = "insert into t_pelatih values ("+PL.getIdpelatih()+",'" +PL.getNama()+"',"+PL.getUsia()+",'"+PL.getLisensi()+"',"+PL.getIdclub()+");";
           stmt = (Statement) con.createStatement();
           stmt.execute(query);
        } catch (SQLException  ex){
           System.out.println("Error : "+ex.getMessage());
        }
        System.out.println("Sukses");
        disconnect();
   } 
    public void deletePelatih(int PL) throws SQLException{
        connect();
        String query = "delete from t_pelatih where idpelatih ="+PL+";";
        stmt = (Statement) con.createStatement();
        stmt.execute(query);
        disconnect();
    }
   
   public ArrayList<Pelatih> loadAllPelatih(int idclub){
        ArrayList<Pelatih> listPelatih = new ArrayList<>();
        connect();
        String query = "select * from t_pelatih where idclub="+String.valueOf(idclub)+";";
        try{
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Pelatih pl = new Pelatih(rs.getString("name"), rs.getInt("age"), rs.getString("license"));
                pl.setIdpelatih(Integer.parseInt(rs.getString("idpelatih")));
                listPelatih.add(pl);
            }
        } catch (SQLException  ex){
           System.out.println(ex.getMessage());
        }
        disconnect();
        return listPelatih;
    }
   
    public void addMatch(Match m) {
        connect();
        String[] d = m.getDate2().split("/");
        
        String date = d[0];
        d[0] = d[2];
        d[2] = date;
        date = String.join("-",d);
        try{
           String query = "insert into t_Match values ('"+m.getIdMatch()+ "','" +m.getTeam1().getId()+"','"+m.getTeam1score()+"','"+m.getTeam2().getId()+"','"+m.getTeam2score()+"',date '"+date+"');";
           stmt = (Statement) con.createStatement();
           stmt.execute(query);
        } catch (SQLException  ex){
           System.out.println("Error : "+ex.getMessage());
        }
        System.out.println("Sukses");
        disconnect();
    }
    
    public ArrayList<Match> loadAllMatch(){
        ArrayList<Match> listMatch = new ArrayList<>();
        ArrayList<FootballClub> listClub = loadAllClub();
        connect();
        String query = "select * from t_match;";
        try{
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                FootballClub home = null;
                FootballClub away = null;
                for(FootballClub f : listClub ){
                    if(f.getId() == Integer.parseInt( rs.getString("team_1"))){
                        home = f;
                    }
                    if(f.getId() == Integer.parseInt( rs.getString("team_2"))){
                        away=f;
                    }
                }
                Match m = new Match( home, rs.getInt("team1_score"), away, rs.getInt("team2_score"), rs.getDate("date") , rs.getString("date"));
                m.setIdMatch(Integer.parseInt(rs.getString("id")));
                listMatch.add(m);
            }
        } catch (SQLException  ex){
           System.out.println(ex.getMessage());
       }
        disconnect();
        return listMatch;
    }
     
}


   
    
    

