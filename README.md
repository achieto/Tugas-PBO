## Nama Anggota
> Anggie Tamara (1917051006)
> Faishal Hariz Makaarim Gandadipoera (1917051065)
> Program kami buat bersama-sama dengan berdiskusi online dan jika ada error dan kesalahan kami memperbaikinya bersama-sama (kami sama-sama mencari letak error dan jika salah satu dari kami berhasil, maka program diperbaiki). Untuk FormPerlengkapan.fxml dan KontrolPerlengkapan.java dibuat secara terpisah, kami sama-sama menambahkan jika ada yang kurang dan sebagainya.

# :school_satchel: Sistem Penambahan Data Toko Perlengkapan Sekolah :athletic_shoe:
> Sistem ini dapat melakukan perekaman data yang tersimpan dan menyimpan stock dari toko perlengkapan sekolah, di mana terdapat dua perlengkapan yaitu sepatu dan tas.
> Setiap barang dapat di tambah stocknya.

:books: Libraries dan Tools project:
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
> Untuk melihat diagram, install plugin mermaid-diagram di https://github.com/Redisrupt/mermaid-diagrams

### Class Diagram

```mermaid
classDiagram
      Perlengkapan <|-- Tas
      Perlengkapan <|-- Sepatu
      Perlengkapan "0"--o"*" Stock : mempunyai

      class Perlengkapan{
        <<abstract>>
        #int IDperlengkapan
        #String series
        #String model
        #String warna
        #int harga
        +int nextIDperlengkapan()
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
        #IntegerProperty IDperlengkapan
        #StringProperty series
        #StringProperty model
        #StringProperty warna
        #IntegerProperty harga
        +int nextIDperlengkapan()
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
        getTass()
        getSepatus()
        getStocks()
        nextIDPerlengkapan()
        nextNomor()
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
