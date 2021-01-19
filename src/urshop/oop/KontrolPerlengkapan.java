/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urshop.oop;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author achieto
 */
public class KontrolPerlengkapan implements Initializable {
    
    @FXML
    private TextField tfIDPerlengkapan;

    @FXML
    private TextField tfSeries;

    @FXML
    private TextField tfWarna;

    @FXML
    private TextField tfHarga;

    @FXML
    private TextField tfKapasitas;

    @FXML
    private ComboBox<String> cbModel;

    @FXML
    private DatePicker dpTanggal;

    @FXML
    private TextField tfJumlah;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnReload;

    @FXML
    private Button btnClear;
    
    @FXML
    private TextField tfNomor;

    @FXML
    private TableView<Tas> tblPerlengkapan;

    @FXML
    private TableColumn<Tas, Integer> coIDPerlengkapan;

    @FXML
    private TableColumn<Tas, String> ColSeries;

    @FXML
    private TableColumn<Tas, String> ColModel;

    @FXML
    private TableColumn<Tas, String> ColWarna;

    @FXML
    private TableColumn<Tas, Integer> ColHarga;

    @FXML
    private TableColumn<Tas, Integer> ColKapasitas;

    @FXML
    private TableView<Stock> tblStock;
    
    @FXML
    private TableColumn<Stock, Integer> ColNo;
    
    @FXML
    private TableColumn<Stock, String> ColTanggal;

    @FXML
    private TableColumn<Stock, Integer> ColJumlah;
    
    @FXML
    private TextField tfnewID;
    
    @FXML
    private TextField tfNewNomor;

    @FXML
    private DatePicker dpNewTanggal;

    @FXML
    private TextField tfNewJumlah;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnReloadStock;
    
    @FXML
    private TextField tfidperlengkapan;

    @FXML
    private TextField tfseries;

    @FXML
    private TextField tfwarna;

    @FXML
    private TextField tfharga;

    @FXML
    private TextField tfukuran;

    @FXML
    private ComboBox<String> cbmodel;

    @FXML
    private DatePicker dptanggal;

    @FXML
    private TextField tfjumlah;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnreload;

    @FXML
    private Button btnclear;

    @FXML
    private Label lbsavestatus;

    @FXML
    private TextField tfnomor;

    @FXML
    private TableView<Sepatu> tblperlengkapan;

    @FXML
    private TableColumn<Sepatu, Integer> colidperlengkapan;

    @FXML
    private TableColumn<Sepatu, String> colseries;

    @FXML
    private TableColumn<Sepatu, String> colmodel;

    @FXML
    private TableColumn<Sepatu, String> colwarna;

    @FXML
    private TableColumn<Sepatu, Integer> colharga;

    @FXML
    private TableColumn<Sepatu, Integer> colukuran;

    @FXML
    private TableView<Stock> tblstock;

    @FXML
    private TableColumn<Stock, Integer> colno;

    @FXML
    private TableColumn<Stock, String> coltanggal;

    @FXML
    private TableColumn<Stock, Integer> coljumlah;

    @FXML
    private TextField tfnewid;

    @FXML
    private TextField tfnewnomor;

    @FXML
    private DatePicker dpnewtanggal;

    @FXML
    private TextField tfnewjumlah;

    @FXML
    private Button btntambah;

    @FXML
    private Label lbDBStatus;
    
    @FXML
    private Label lbSaveStatus;
    
    private PerlengkapanDataModel pdm;
    public void viewDataStock(int IDperlengkapan){
        ObservableList<Stock> data = pdm.getStocks(IDperlengkapan);
        ColNo.setCellValueFactory(new PropertyValueFactory<>("nomor"));
        ColTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        ColJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        tblStock.setItems(null);
        tblStock.setItems(data);
    }
    
    public void viewdatastock(int IDperlengkapan){
        ObservableList<Stock> dtt = pdm.getStocks(IDperlengkapan);
        colno.setCellValueFactory(new PropertyValueFactory<>("nomor"));
        coltanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        coljumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        tblstock.setItems(null);
        tblstock.setItems(dtt);
    }
    
    @FXML
    void handleButtonTambahPerlengkapan(ActionEvent event) {
        LocalDate ld = dpTanggal.getValue();
        String tanggal = String.format("%d-%02d-%02d", ld.getYear(), 
                ld.getMonthValue(), ld.getDayOfMonth());
        Tas tas = new Tas(Integer.parseInt(tfIDPerlengkapan.getText()), 
                tfSeries.getText(), 
                cbModel.getSelectionModel().getSelectedItem(), 
                tfWarna.getText(), 
                Integer.parseInt(tfHarga.getText()), 
                Integer.parseInt(tfKapasitas.getText()), 
                new Stock(Integer.parseInt(tfNomor.getText()), tanggal, Integer.parseInt(tfJumlah.getText())));
        try {
            pdm.tambahPerlengkapan(tas);
            lbSaveStatus.setText("Data Berhasil Disimpan");
            btnReload.fire();
            btnClear.fire();
        } catch (SQLException ex) {
            lbSaveStatus.setText("Data Gagal Disimpan");
            Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonTambahStock(ActionEvent event) {
        LocalDate ldl = dpNewTanggal.getValue();
        String newtanggal = String.format("%d-%02d-%02d", ldl.getYear(), 
                ldl.getMonthValue(), ldl.getDayOfMonth());
        Stock stock = new Stock(Integer.parseInt(tfNewNomor.getText()), 
                newtanggal, Integer.parseInt(tfNewJumlah.getText()));
        try {
            pdm.tambahStock(Integer.parseInt(tfnewID.getText()), stock);
            viewDataStock(Integer.parseInt(tfnewID.getText()));
            btnReload.fire();
            btnClear.fire();
        } catch (SQLException ex) {
            Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleClearForm(ActionEvent event) {
        try {
            tfIDPerlengkapan.setText(""+pdm.nextIDPerlengkapan());
            tfNomor.setText(""+1);
            tfSeries.setText("");
            cbModel.getSelectionModel().clearSelection();
            tfWarna.setText("");
            tfHarga.setText("");
            tfKapasitas.setText("");
            tfJumlah.setText("");
            tfNewJumlah.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void loadDataTas(ActionEvent event) {
        ObservableList<Tas> data = pdm.getTass();
        coIDPerlengkapan.setCellValueFactory(new PropertyValueFactory<>("IDperlengkapan"));
        ColSeries.setCellValueFactory(new PropertyValueFactory<>("series"));
        ColModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        ColWarna.setCellValueFactory(new PropertyValueFactory<>("warna"));
        ColHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        ColKapasitas.setCellValueFactory(new PropertyValueFactory<>("kapasitas"));
        ColNo.setCellValueFactory(new PropertyValueFactory<>("nomor"));
        tblPerlengkapan.setItems(null);
        tblPerlengkapan.setItems(data);
        btnTambah.setDisable(true);
    }
    
    @FXML
    void handleClearform(ActionEvent event) {
        try {
            tfidperlengkapan.setText(""+pdm.nextIDPerlengkapan());
            tfnomor.setText(""+1);
            tfseries.setText("");
            cbmodel.getSelectionModel().clearSelection();
            tfwarna.setText("");
            tfharga.setText("");
            tfukuran.setText("");
            tfjumlah.setText("");
            tfnewjumlah.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handlebuttonTambahPerlengkapan(ActionEvent event) {
        LocalDate ldd = dptanggal.getValue();
        String tanggal = String.format("%d-%02d-%02d", ldd.getYear(), 
                ldd.getMonthValue(), ldd.getDayOfMonth());
        Sepatu sepatu = new Sepatu(Integer.parseInt(tfidperlengkapan.getText()), 
                tfseries.getText(), 
                (String) cbmodel.getSelectionModel().getSelectedItem(), 
                tfwarna.getText(), 
                Integer.parseInt(tfharga.getText()), 
                Integer.parseInt(tfukuran.getText()), 
                new Stock(Integer.parseInt(tfnomor.getText()), tanggal, Integer.parseInt(tfjumlah.getText())));
        try {
            pdm.tambahPerlengkapan(sepatu);
            lbsavestatus.setText("Data Berhasil Disimpan");
            btnreload.fire();
            btnclear.fire();
        } catch (SQLException ex) {
            lbsavestatus.setText("Data Gagal Disimpan");
            Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handlebuttonTambahStock(ActionEvent event) {
        LocalDate ld1 = dpnewtanggal.getValue();
        String newtanggal = String.format("%d-%02d-%02d", ld1.getYear(), 
                ld1.getMonthValue(), ld1.getDayOfMonth());
        Stock stock = new Stock(Integer.parseInt(tfnewnomor.getText()), 
                newtanggal, Integer.parseInt(tfnewjumlah.getText()));
        try {
            pdm.tambahStock(Integer.parseInt(tfnewid.getText()), stock);
            viewdatastock(Integer.parseInt(tfnewid.getText()));
            btnreload.fire();
            btnclear.fire();
        } catch (SQLException ex) {
            Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void loadDataSepatu(ActionEvent event) {
        ObservableList<Sepatu> data = pdm.getSepatus();
        colidperlengkapan.setCellValueFactory(new PropertyValueFactory<>("IDperlengkapan"));
        colseries.setCellValueFactory(new PropertyValueFactory<>("series"));
        colmodel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colwarna.setCellValueFactory(new PropertyValueFactory<>("warna"));
        colharga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colukuran.setCellValueFactory(new PropertyValueFactory<>("ukuran"));
        colno.setCellValueFactory(new PropertyValueFactory<>("nomor"));
        tblperlengkapan.setItems(null);
        tblperlengkapan.setItems(data);
        btnTambah.setDisable(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> model = FXCollections.observableArrayList("Backpack", "Shoulder Bag");
        cbModel.setItems(model);
        try {
            pdm = new PerlengkapanDataModel("MYSQL");
            lbDBStatus.setText(pdm.conn==null?"Tidak terkoneksi":"Terkoneksi");
            btnClear.fire();
            btnReload.fire();
        } catch (SQLException ex) {
            Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tblPerlengkapan.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if(tblPerlengkapan.getSelectionModel().getSelectedItem()!=null){
                Tas tas = tblPerlengkapan.getSelectionModel().getSelectedItem();
                viewDataStock(tas.getIDperlengkapan());
                btnTambah.setDisable(false);
                tfnewID.setText(""+tas.getIDperlengkapan());
                try {
                    tfNewNomor.setText(""+pdm.nextNomor(tas.getIDperlengkapan()));
                } catch (SQLException ex) {
                    Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        ObservableList<String> Model = FXCollections.observableArrayList("Kets", "Warrior");
        cbmodel.setItems(Model);
        try {
            pdm = new PerlengkapanDataModel("MYSQL");
            lbDBStatus.setText(pdm.conn==null?"Tidak terkoneksi":"Terkoneksi");
            btnclear.fire();
            btnreload.fire();
        } catch (SQLException ex) {
            Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tblperlengkapan.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if(tblperlengkapan.getSelectionModel().getSelectedItem()!=null){
                Sepatu sepatu = tblperlengkapan.getSelectionModel().getSelectedItem();
                viewdatastock(sepatu.getIDperlengkapan());
                btntambah.setDisable(false);
                tfnewid.setText(""+sepatu.getIDperlengkapan());
                try {
                    tfnewnomor.setText(""+pdm.nextNomor(sepatu.getIDperlengkapan()));
                } catch (SQLException ex) {
                    Logger.getLogger(KontrolPerlengkapan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }    
}
