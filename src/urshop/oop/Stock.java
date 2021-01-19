/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urshop.oop;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author achieto
 */
public class Stock {
    IntegerProperty nomor;
    StringProperty tanggal;
    IntegerProperty jumlah;

    public Stock(int nomor, String tanggal, int jumlah) {
        this.nomor = new SimpleIntegerProperty(nomor);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.jumlah = new SimpleIntegerProperty(jumlah);
    }

    public int getNomor() {
        return nomor.get();
    }

    public void setNomor(int nomor) {
        this.nomor.set(nomor);
    }

    public String getTanggal() {
        return tanggal.get();
    }

    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }

    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int jumlah) {
        this.jumlah.set(jumlah);
    }
    
    public void restocks(int item){
        this.jumlah.set(this.jumlah.get()+item);
    }
    
    public void sold(int item){
        this.jumlah.set(this.jumlah.get()-item);
    }
    
    public IntegerProperty nomorProperty(){
        return nomor;
    }
    
    public StringProperty tanggalProperty(){
        return tanggal;
    }
    
    public IntegerProperty jumlahProperty(){
        return jumlah;
    }
}
