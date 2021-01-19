/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urshop.oop;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author achieto
 */
public abstract class Perlengkapan {
    private IntegerProperty IDperlengkapan;
    private StringProperty series;
    private StringProperty model;
    private StringProperty warna;
    private IntegerProperty harga;
    private ArrayList<Stock> stocks;

    public Perlengkapan(int IDperlengkapan, String series, String model, 
            String warna, int harga, ArrayList<Stock> stocks) {
        this.IDperlengkapan = new SimpleIntegerProperty(IDperlengkapan);
        this.series = new SimpleStringProperty(series);
        this.model = new SimpleStringProperty(model);
        this.warna = new SimpleStringProperty(warna);
        this.harga = new SimpleIntegerProperty(harga);
        this.stocks = stocks;
    }
    
    public Perlengkapan(int IDperlengkapan, String series, String model, 
            String warna, int harga, Stock stock) {
        stocks = new ArrayList<>();
        this.IDperlengkapan = new SimpleIntegerProperty(IDperlengkapan);
        this.series = new SimpleStringProperty(series);
        this.model = new SimpleStringProperty(model);
        this.warna = new SimpleStringProperty(warna);
        this.harga = new SimpleIntegerProperty(harga);
        this.stocks.add(stock);
    }

    public int getIDperlengkapan() {
        return IDperlengkapan.get();
    }

    public void setIDperlengkapan(int IDperlengkapan) {
        this.IDperlengkapan.set(IDperlengkapan);
    }

    public String getSeries() {
        return series.get();
    }

    public void setSeries(String series) {
        this.series.set(series);
    }

    public String getModel() {
        return model.get();
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getWarna() {
        return warna.get();
    }

    public void setWarna(String warna) {
        this.warna.set(warna);
    }

    public int getHarga() {
        return harga.get();
    }

    public void setHarga(int harga) {
        this.harga.set(harga);
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }
    
    public IntegerProperty IDperlengkapanProperty(){
        return IDperlengkapan;
    }
    
    public StringProperty seriesProperty(){
        return series;
    }
    
    public StringProperty modelProperty(){
        return model;
    }
    
    public StringProperty warnaProperty(){
        return warna;
    }
    
    public IntegerProperty hargaProperty(){
        return harga;
    }
}
