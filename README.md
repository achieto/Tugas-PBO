## :school_satchel: Sistem penambah data Toko Perlengkapan Sekolah :athletic_shoe:
> Sistem ini dapat melakukan perekaman data yang tersimpan dan menyimpan stock dari toko perlengkapan sekolah, di mana terdapat 2 perlengkapan yaitu sepatu dan tas.
> Setiap barang dapat di tambah stocknya.

:closed_book: Libraries dan Tools project:
- mysql-connector-java-5.1.49.jar
- sqlite-jdbc-3.340.jar
- Scene builder
- Sqlite studio
- MySQL server with xampp
- Netbeans editor
- VS code plugin
     - mermaid
     - GitHub Pull Requests and Issues

## :art: Design
### Class Diagram

```mermaid
classDiagram
      Perlengkapan <|-- Tas
      Perlengkapan <|-- Sepatu
      Perlengkapan "0"--o"*" Stock : mempunyai

      class Perlengkapan{
        <<abstract>>
        #int ID
        #String series
        #String model
        #String warna
        #int harga
        +int nextID()
      }
      
      class Tas{
          -int kapasitas
      }
      class Sepatu{
          -int ukuran
      }
      class Stock{
          -int nomor
          -String tanggal
          -int jumlah
          +restocks(int item)
          +sold(int item)
      }
```		

### ER Diagram

```mermaid
erDiagram
          PERLENGKAPAN ||--|| TAS : is
          PERLENGKAPAN ||--|| SEPATU : is
          PERLENGKAPAN ||--|{ STOCK : has
```

### Design Class Diagram for JavaFX and Database

```mermaid
classDiagram
      Perlengkapan <|-- Tas
      Perlengkapan <|-- Sepatu
      Perlengkapan "0"--o"*" Stock : mempunyai
      Perlengkapan o-- PerlengkapanDataModel : Data Modeling
      PerlengkapanDataModel <-- KontrolPerlengkapan : Data Control
      PerlengkapanDataModel --> DatabaseHelper : DB Connection
      KontrolPerlengkapan <.. FormPerlengkapan : Form Control

      class Perlengkapan{
        <<abstract>>
        #IntegerProperty ID
        #StringProperty series
        #StringProperty model
        #StringProperty warna
        #IntegerProperty harga
        +int nextID()
      }
      
      class Tas{
        -IntegerProperty kapasitas
      }
      class Sepatu{
        -IntegerProperty ukuran
      }
      class Stock{
        -IntegerProperty nomor
        -StringProperty tanggal
        -IntegerProperty jumlah
        +restocks(int item)
        +sold(int item)
      }
      class PerlengkapanDataModel{
        Connection conn
        tambahPerlengkapan()
        tambahTanggal()
        tambahJumlah()
        getTass()
        getSepatus()
        getStocks()
        nextIDPerlengkapan()
      }
      class KontrolPerlengkapan{
        inisialisasi()
        handleButtonTambahStock()
        handleButtonTambahPerlengkapan()
        loadDataTas()
        loadDataSepatu()
        handleClearForm()
      }
      class DatabaseHelper{
        getConnection()
        getConnection(String driver)
        createTable()
      }
      class FormPerlengkapan{
      }
```
