/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Faizal
 */
public class Pelatih {
    private static int idpelatih = 0;
    private int id;
    private String nama;
    private int usia;
    private String lisensi;
    private int idclub;

    
    
    public Pelatih(String nama, int usia, String lisensi) {
        idpelatih++;
        id = idpelatih;
        this.nama = nama;
        this.usia = usia;
        this.lisensi = lisensi;
    }

    public int getIdpelatih() {
        return id;
    }

    public void setIdpelatih(int idpelatih) {
        this.id = idpelatih;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getLisensi() {
        return lisensi;
    }

    public void setLisensi(String lisensi) {
        this.lisensi = lisensi;
    }
    
    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }
    
}
