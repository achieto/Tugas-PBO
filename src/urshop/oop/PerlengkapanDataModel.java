/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urshop.oop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import urshop.oop.db.DatabaseHelper;

/**
 *
 * @author achieto
 */
public class PerlengkapanDataModel {

    public final Connection conn;

    public PerlengkapanDataModel(String driver) throws SQLException {
        this.conn = DatabaseHelper.getConnection(driver);
    }

    public void tambahPerlengkapan(Tas perlengkapan) throws SQLException {
        String insertPerlengkapan = "INSERT INTO perlengkapan (id_perlengkapan, "
                + "series, model, warna, harga)" + " VALUES (?, ?, ?, ?, ?)";
        String insertTas = "INSERT INTO tas (id_perlengkapan, kapasitas)"
                + " VALUES (?, ?)";
        String insertStock = "INSERT INTO stock (nomor, tanggal, jumlah, id_perlengkapan)"
                + " VALUES (?, ?, ?, ?)";

        PreparedStatement stmtPerlengkapan = conn.prepareStatement(insertPerlengkapan);
        stmtPerlengkapan.setInt(1, perlengkapan.getIDperlengkapan());
        stmtPerlengkapan.setString(2, perlengkapan.getSeries());
        stmtPerlengkapan.setString(3, perlengkapan.getModel());
        stmtPerlengkapan.setString(4, perlengkapan.getWarna());
        stmtPerlengkapan.setInt(5, perlengkapan.getHarga());
        stmtPerlengkapan.execute();

        PreparedStatement stmtTas = conn.prepareStatement(insertTas);
        stmtTas.setInt(1, perlengkapan.getIDperlengkapan());
        stmtTas.setInt(2, perlengkapan.getKapasitas());
        stmtTas.execute();

        PreparedStatement stmtStock = conn.prepareStatement(insertStock);
        stmtStock.setInt(1, perlengkapan.getStocks().get(0).getNomor());
        stmtStock.setString(2, perlengkapan.getStocks().get(0).getTanggal());
        stmtStock.setInt(3, perlengkapan.getStocks().get(0).getJumlah());
        stmtStock.setInt(4, perlengkapan.getIDperlengkapan());
        stmtStock.execute();
    }

    public void tambahPerlengkapan(Sepatu perlengkapan) throws SQLException {
        String insertPerlengkapan = "INSERT INTO perlengkapan (id_perlengkapan, "
                + "series, model, warna, harga)" + " VALUES (?, ?, ?, ?, ?)";
        String insertSepatu = "INSERT INTO sepatu (id_perlengkapan, ukuran)"
                + " VALUES (?, ?)";
        String insertStock = "INSERT INTO stock (nomor, tanggal, jumlah, id_perlengkapan)"
                + " VALUES (?, ?, ?, ?)";

        PreparedStatement stmtPerlengkapan = conn.prepareStatement(insertPerlengkapan);
        stmtPerlengkapan.setInt(1, perlengkapan.getIDperlengkapan());
        stmtPerlengkapan.setString(2, perlengkapan.getSeries());
        stmtPerlengkapan.setString(3, perlengkapan.getModel());
        stmtPerlengkapan.setString(4, perlengkapan.getWarna());
        stmtPerlengkapan.setInt(5, perlengkapan.getHarga());
        stmtPerlengkapan.execute();

        PreparedStatement stmtSepatu = conn.prepareStatement(insertSepatu);
        stmtSepatu.setInt(1, perlengkapan.getIDperlengkapan());
        stmtSepatu.setInt(2, perlengkapan.getUkuran());
        stmtSepatu.execute();

        PreparedStatement stmtStock = conn.prepareStatement(insertStock);
        stmtStock.setInt(1, perlengkapan.getStocks().get(0).getNomor());
        stmtStock.setString(2, perlengkapan.getStocks().get(0).getTanggal());
        stmtStock.setInt(3, perlengkapan.getStocks().get(0).getJumlah());
        stmtStock.setInt(4, perlengkapan.getIDperlengkapan());
        stmtStock.execute();
    }

    public ObservableList<Tas> getTass() {
        ObservableList<Tas> data = FXCollections.observableArrayList();
        String sql = "SELECT `id_perlengkapan`, `series`, `model`, `warna`, "
                + "`harga`, `kapasitas` FROM `perlengkapan` NATURAL JOIN `tas` "
                + "ORDER BY `harga`";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                String sqlStock = "SELECT nomor, tanggal, jumlah FROM stock "
                        + "WHERE id_perlengkapan=" + rs.getInt(1);
                ResultSet rsStock = conn.createStatement().executeQuery(sqlStock);
                ArrayList<Stock> dataStock = new ArrayList<>();
                while (rsStock.next()) {
                    dataStock.add(new Stock(rsStock.getInt(1), rsStock.getString(2), rsStock.getInt(3)));
                }
                data.add(new Tas(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), dataStock));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerlengkapanDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    public ObservableList<Sepatu> getSepatus() {
        ObservableList<Sepatu> data = FXCollections.observableArrayList();
        String sql = "SELECT `id_perlengkapan`, `series`, `model`, `warna`, "
                + "`harga`, `ukuran` FROM `perlengkapan` NATURAL JOIN `sepatu` "
                + "ORDER BY `harga`";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                String sqlStock = "SELECT nomor, tanggal, jumlah FROM stock "
                        + "WHERE id_perlengkapan=" + rs.getInt(1);
                ResultSet rsStock = conn.createStatement().executeQuery(sqlStock);
                ArrayList<Stock> dataStock = new ArrayList<>();
                while (rsStock.next()) {
                    dataStock.add(new Stock(rsStock.getInt(1), rsStock.getString(2), rsStock.getInt(3)));
                }
                data.add(new Sepatu(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), dataStock));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerlengkapanDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    public ObservableList<Stock> getStocks(int IDperlengkapan){
        ObservableList<Stock> data = FXCollections.observableArrayList();
        String sqlStock = "SELECT nomor, tanggal, jumlah FROM stock "
                        + "WHERE id_perlengkapan=" + IDperlengkapan;
        try {
            ResultSet rs = conn.createStatement().executeQuery(sqlStock);
            while(rs.next()){
                data.add(new Stock(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerlengkapanDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    public int nextIDPerlengkapan() throws SQLException{
        String sql = "SELECT MAX(id_perlengkapan) from perlengkapan";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
                return rs.getInt(1)==0?100001:rs.getInt(1)+1;
            }
        return 100001;
    }
    public int nextNomor(int id_perlengkapan) throws SQLException{
        String sql = "SELECT MAX(nomor) from stock WHERE id_perlengkapan="+id_perlengkapan;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
                return rs.getInt(1)+1;
            }
        return 0;
    }
    public void tambahStock(int IDperlengkapan, Stock stock) throws SQLException {
        String insertPerlengkapan = "INSERT INTO stock (id_perlengkapan, nomor, "
                + "tanggal, jumlah)" 
                + " VALUES (?, ?, ?, ?)";

        PreparedStatement stmtPerlengkapan = conn.prepareStatement(insertPerlengkapan);
        stmtPerlengkapan.setInt(1, IDperlengkapan);
        stmtPerlengkapan.setInt(2, stock.getNomor());
        stmtPerlengkapan.setString(3, stock.getTanggal());
        stmtPerlengkapan.setInt(4, stock.getJumlah());
        stmtPerlengkapan.execute();
    }
}
