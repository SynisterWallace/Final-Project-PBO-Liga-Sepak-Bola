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
public class Pemain {
    private static int idpemain=0000;
    private int id;
    private String nama;
    private int usia;
    private int idclub;

    public Pemain( String nama, int usia) {
        idpemain++;
        id=idpemain;
        this.nama = nama;
        this.usia = usia;
    }

    public int getIdpemain() {
        return id;
    }

    public void setIdpemain(int idpemain) {
        this.id = idpemain;
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

    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }
    
    
    
}
