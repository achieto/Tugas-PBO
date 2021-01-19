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
public class Tas extends Perlengkapan {
    IntegerProperty kapasitas;

    public Tas(int IDperlengkapan, String series, String model, String warna,
            int harga, int kapasitas, ArrayList<Stock> stocks) {
        super(IDperlengkapan, series, model, warna, harga, stocks);
        this.kapasitas = new SimpleIntegerProperty(kapasitas);
    }

    public Tas(int IDperlengkapan, String series, String model, String warna,
            int harga, int kapasitas, Stock stock) {
        super(IDperlengkapan, series, model, warna, harga, stock);
        this.kapasitas = new SimpleIntegerProperty(kapasitas);
    }

    public int getKapasitas() {
        return kapasitas.get();
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas.set(kapasitas);
    }

    public IntegerProperty KapasitasProperty() {
        return kapasitas;
    }
}
