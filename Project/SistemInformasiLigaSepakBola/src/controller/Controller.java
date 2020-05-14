/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import database.Database;
import View.*;
import static java.awt.Color.GREEN;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import model.FootballClub;
import model.Match;
import model.Pelatih;
import model.Pemain;
import view.GUI;


/**
 *
 * @author Kriesna Bayu Pratama
 */
public class Controller extends MouseAdapter implements ActionListener {
    public Database db;
    public GUI gui;
    public ArrayList<FootballClub> clubList= new ArrayList<>();
    public ArrayList<Pelatih> pelatihList = new ArrayList<>();
    public ArrayList<Pemain> pemainList = new ArrayList<>();
    public ArrayList<Match> matchList = new ArrayList<>();
    
    public Controller (){
        db = new Database();
        gui = new GUI();
        gui.addActionListener(this);
        gui.setVisible(true);
        
        //Mengambil Objek Tim Pada List Tim Menggunakan Mouse
        gui.getListTeam().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                Object o = me.getSource();
                if(o.equals(gui.getListTeam())){
                    FootballClub fc = getSelectedListTeam();
                    System.out.println(fc.toString());
                    pelatihList.clear();
                    pemainList.clear();  
                    System.out.println(fc.getId());
                    pelatihList = db.loadAllPelatih(fc.getId());
                    pemainList = db.loadAllPemain(fc.getId());   
                    updateListMember(pelatihList, pemainList);
                }
            }
        });
        
        clubList = db.loadAllClub();    
        Collections.sort(clubList, new CustomComparator()); //Mengurutkan Tim Berdasarkan Perolehan Point dan Defisit Gol Menggunakan Kelas CustomComparator
        updateListKlasemen(clubList);
        updateListTeam(clubList);
        setComboBoxValue(gui.getCbHomeTeam(), clubList);
        setComboBoxValue(gui.getCbAwayTeam(), clubList);
        matchList = db.loadAllMatch();
        updateListMatch(matchList);
        
    }
    
    //Mengatur Nilai ComboBox Berdasarkan Tim yang Sudah Didaftarkan
    public void setComboBoxValue( JComboBox<FootballClub> cb , List<FootballClub> list ){
        cb.removeAllItems();
        for(FootballClub f: list){
            cb.addItem(f);
        } 
    }
    
    //Menampilkan List Team
    public void updateListTeam(List<FootballClub> teams){
        DefaultListModel list = new DefaultListModel();
        for (int i = 0; i < teams.size(); i++) {
            list.addElement(teams.get(i));
        }
        gui.getListTeam().setModel(list);  
    }
    
    //Menampilkan List Member Berupa Pelatih dan Pemain
    public void updateListMember(List<Pelatih> pel , List<Pemain> pem){
        DefaultTableModel list = new DefaultTableModel(new String[]{"ID","Nama", "Usia","Tipe","Lisensi"}, 0);
        for (int i = 0; i < pel.size(); i++) {
            list.addRow(new Object[]{pel.get(i).getIdpelatih(),pel.get(i).getNama(),pel.get(i).getUsia(),"Pelatih",pel.get(i).getLisensi()});
        }
        for (int i = 0; i < pem.size(); i++) {
            list.addRow(new Object[]{pem.get(i).getIdpemain(),pem.get(i).getNama(),pem.get(i).getUsia(),"Pemain",""});
        }
        gui.getTableMember().setModel(list);
    }
    
    //Menampilkan List Match
    public void updateListMatch(List<Match> match){
        DefaultTableModel list = new DefaultTableModel(new String[]{"ID","HomeTeam","HomeScore", "AwayTeam","AwayScore","Date"}, 0);
        for (int i = 0; i < match.size(); i++) {
            list.addRow(new Object[]{match.get(i).getIdMatch(),match.get(i).getTeam1().getNama() ,match.get(i).getTeam1score(),match.get(i).getTeam2().getNama(),match.get(i).getTeam2score(),match.get(i).getDate()});
        }
        gui.getTableMatch().setModel(list);  
    }
    
    //Menampilkan List Klasemen
    public void updateListKlasemen(List<FootballClub> teams){
        
        System.out.println("Showing");
        DefaultTableModel list = new DefaultTableModel(new String[]{"No","Club","MatchPlayed","Win", "Draw","Lose","GD","Point"}, 0);
        int j = 1;
        for (int i = 0; i < teams.size(); i++) {
            list.addRow(new Object[]{j,teams.get(i).getNama(),teams.get(i).getMatchPlayed() ,teams.get(i).getWin(),teams.get(i).getDraw(),teams.get(i).getLose() ,teams.get(i).getScoredGoals()-teams.get(i).getConceded(),teams.get(i).getPoint()});
            j++;
        }
        gui.getTableKlasemen().setModel(list);
    }
    
    //Memilih Objek Tim pada List Tim
    public FootballClub getSelectedListTeam(){
        return gui.getListTeam().getSelectedValue() instanceof FootballClub ? (FootballClub)gui.getListTeam().getSelectedValue() : null;
    }
    
    //Memilih Objek Pemain atau Pelatih pada Tabel Member
    public int getSelectedTableMember(){
        int i = gui.getTableMember().getSelectedRow();
        return (int)gui.getTableMember().getValueAt(i, 0);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(gui.getBtnAddTeam())){
            String nama = gui.getNama();
            String lokasi = gui.getLokasi();
            FootballClub F = new FootballClub(nama,lokasi);
            clubList.add(F);
            updateListTeam(clubList);
            db.addClub(F);   
            setComboBoxValue(gui.getCbHomeTeam(), clubList);
            setComboBoxValue(gui.getCbAwayTeam(), clubList);
            Collections.sort(clubList, new CustomComparator());
            updateListKlasemen(clubList);
        }
        
        if(source.equals(gui.getBtnRemoveTeam())){
            FootballClub F = getSelectedListTeam();
            try {
               clubList.remove(F);
               db.deleteClub(F);
               updateListTeam(clubList);
               Collections.sort(clubList, new CustomComparator());
               updateListKlasemen(clubList);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        if(source.equals(gui.getBtnAddMember())){
            FootballClub F = getSelectedListTeam();
            String nama = gui.getNamaMember();
            int usia = gui.getUsiaMember();
            String lisensi = gui.getLisensi();
            if(gui.getSelectedTipe()=="Pelatih"){
                Pelatih pl = new Pelatih(nama,usia,lisensi);
                pl.setIdclub(F.getId());
                pelatihList.add(pl);
                db.addPelatih(pl);
            }
            if(gui.getSelectedTipe()=="Pemain"){
                Pemain p = new Pemain(nama,usia);
                p.setIdclub(F.getId());
                pemainList.add(p);
                db.addPemain(p);   
            }
            gui.showStatusMessage("Success",GREEN);
            updateListMember(pelatihList, pemainList);
            
        }
        
        if(source.equals(gui.getBtnRemoveMember())){
            
            int select = getSelectedTableMember();
            int row = gui.getTableMember().getSelectedRow();
            
            if(gui.getTableMember().getValueAt(row, 3)=="Pemain"){
                System.out.println("deleting Pemain");
                try {
                    db.deletePemain(select);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(gui.getTableMember().getValueAt(row, 3)=="Pelatih"){
                System.out.println("deleting pelatih");
                try {
                    db.deletePelatih(select);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(source.equals(gui.getBtnAddMatch())){
            try {
                
                FootballClub f1 = gui.getSelectedHomeTeam();
                FootballClub f2 = gui.getSelectedAwayTeam();
                int homescore = gui.getHomeScore();
                int awayscore = gui.getAwayScore();
                String datetemp = gui.getDate();
                SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                Date date =format.parse(datetemp);
                
                if(f1==f2){
                    System.out.println("Tim Tidak Boleh Sama");
                }
                else{
                    System.out.println(datetemp);
                    Match m = new Match(f1,homescore,f2,awayscore,date , datetemp);
                    m.setDate(date);
                    matchList.add(m);
                    db.addMatch(m);
                    f1.setMatchPlayed(f1.getMatchPlayed()+1);
                    f2.setMatchPlayed(f2.getMatchPlayed()+1);
                    f1.setScoredGoals(homescore);
                    f2.setScoredGoals(awayscore);
                    f1.setConceded(awayscore);
                    f2.setConceded(homescore);
                    
                    if (homescore > awayscore) {
                        f1.setPoint(f1.getPoint()+3);
                        f1.setWin(f1.getWin()+1);
                        f2.setLose(f2.getLose()+1);
                    }
                    else if (homescore < awayscore) {
                        f2.setPoint(f2.getPoint()+3);
                        f2.setWin(f2.getWin()+1);
                        f1.setLose(f1.getLose()+1);
                    }
                    else {
                        f1.setPoint(f1.getPoint()+1);
                        f2.setPoint(f2.getPoint()+1);
                        f1.setDraw(f1.getDraw()+1);
                        f2.setDraw(f2.getDraw()+1);
                    }
                    
                    db.updateClub(f1);
                    db.updateClub(f2); 
                    updateListMatch(matchList);
                    
                    clubList = db.loadAllClub();
                    
                    Collections.sort(clubList, new CustomComparator());
                    updateListKlasemen(clubList);
                    
                }
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }   
        }
    }    
}
