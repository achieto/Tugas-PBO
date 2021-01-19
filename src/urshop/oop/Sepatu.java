/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urshop.oop;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author achieto
 */
public class Sepatu extends Perlengkapan{
    IntegerProperty ukuran;

    public Sepatu(int IDperlengkapan, String series, String model, String warna,
            int harga, int ukuran, ArrayList<Stock> stock) {
        super(IDperlengkapan, series, model, warna, harga, stock);
        this.ukuran = new SimpleIntegerProperty(ukuran);
    }

    public Sepatu(int IDperlengkapan, String series, String model, String warna,
            int harga, int ukuran, Stock stocks) {
        super(IDperlengkapan, series, model, warna, harga, stocks);
        this.ukuran = new SimpleIntegerProperty(ukuran);
    }

    public int getUkuran() {
        return ukuran.get();
    }

    public void setUkuran(int ukuran) {
        this.ukuran.set(ukuran);
    }
    
    public IntegerProperty UkuranProperty() {
        return ukuran;
    }
}
