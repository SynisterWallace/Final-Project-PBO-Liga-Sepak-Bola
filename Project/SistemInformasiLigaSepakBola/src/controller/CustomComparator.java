/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Comparator;
import model.FootballClub;

/**
 *
 * @author Faizal
 */

//Kelas Untuk Membantu Mengurutkan Tim Berdasarkan Perolehan Point dan Defisit Gol
public class CustomComparator implements Comparator<FootballClub> {
 
    public int compare(FootballClub t, FootballClub t1) {
        
        if(t.getPoint() > t1.getPoint()) 
            return -1;
        else 
            if (t.getPoint() < t1.getPoint())
                return 1;
            else {
                int goalDif = t.getScoredGoals()-t.getConceded();
                int goalDif1 = t1.getScoredGoals()-t1.getConceded();
                if(goalDif > goalDif1)
                    return -1;
                else
                    if(goalDif < goalDif1)
                        return 1;
                    else return 0;
            }
    }
}
