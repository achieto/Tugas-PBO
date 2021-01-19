/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urshop.oop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author achieto
 */
public class DatabaseHelper {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB = "TokoPerlengkapanSekolah";
    private static final String MYCONN = "jdbc:mysql://localhost/" + DB;
    private static final String SQCONN = "jdbc:sqlite:D:\\sqlitedb\\"
            + "TokoPerlengkapanSekolah.sqlite";

    public static Connection getConnection(String driver) throws SQLException {
        Connection conn = null;
        switch (driver) {
            case "SQLITE": {
                try {
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(SQCONN);
//                    createTable(conn, driver);
//                    System.out.println("Library ditemukan");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library tidak ditemukan");
                    Logger.getLogger(DatabaseHelper.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
                break;
            }
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(MYCONN, USER, PASSWORD);
//                    createTable(conn, driver);
//                    System.out.println("Library ditemukan");
                } catch (ClassNotFoundException ex) {
//                    System.out.println("Library tidak ditemukan");
                    Logger.getLogger(DatabaseHelper.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
                break;
            }
        }
        return conn;
    }
//    private static void createTable(Connection conn, String driver) throws SQLException {
//        String sqlCreate = "";
//        switch (driver) {
//            case "MYSQL": {
//                sqlCreate = "CREATE TABLE IF NOT EXISTS `perlengkapan` "
//                        + "  `id_perlengkapan` int(10) NOT NULL"
//                        + "  `series` varchar(50) DEFAULT NULL"
//                        + "  `model` varchar(50) DEFAULT NULL"
//                        + "  `warna` varchar(30) DEFAULT NULL"
//                        + "  `harga` int(11) DEFAULT NULL"
//                        + "  PRIMARY KEY (`id_perlengkapan`"
//                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4"
//                        + "CREATE TABLE IF NOT EXISTS `stock` "
//                        + "  `tanggal` date DEFAULT NULL"
//                        + "  `jumlah` int(10) DEFAULT NULL"
//                        + "  `id_perlengkapan` int(10) NOT NULL"
//                        + "  PRIMARY KEY (`id_perlengkapan`)"
//                        + "  FOREIGN KEY (`id_perlengkapan`) REFERENCES `perlengkapan` (`id_perlengkapan`) ON UPDATE CASCAD"
//                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4"
//                        + "CREATE TABLE IF NOT EXISTS `sepatu` "
//                        + "  `id_perlengkapan` int(10) NOT NULL"
//                        + "  `ukuran` int(2) DEFAULT NULL"
//                        + "  PRIMARY KEY (`id_perlengkapan`)"
//                        + "  FOREIGN KEY (`id_perlengkapan`) REFERENCES `perlengkapan` (`id_perlengkapan`) ON UPDATE CASCAD"
//                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4"
//                        + "CREATE TABLE IF NOT EXISTS `tas` "
//                        + "  `id_perlengkapan` int(10) NOT NULL"
//                        + "  `kapasitas` int(10) DEFAULT NULL"
//                        + "  PRIMARY KEY (`id_perlengkapan`)"
//                        + "  FOREIGN KEY (`id_perlengkapan`) REFERENCES `perlengkapan` (`id_perlengkapan`) ON UPDATE CASCAD"
//                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
//                break;
//            }
//            case "SQLITE": {
//                sqlCreate = "CREATE TABLE IF NOT EXISTS perlengkapan ("
//                        + "id_perlengkapan INT (10) PRIMARY KEY,"
//                        + "series VARCHAR (50), "
//                        + "model VARCHAR (50), "
//                        + "warna VARCHAR (30), "
//                        + "harga INT (11)"
//                        + ");"
//                        + "CREATE TABLE IF NOT EXISTS stock ("
//                        + "nomor INT (100) PRIMARY KEY,"
//                        + " tanggal DATE, "
//                        + "jumlah INT (10), "
//                        + "id_perlengkapan INT (10) REFERENCES perlengkapan (id_perlengkapan) ON DELETE RESTRICT "
//                        + "                                                                   ON UPDATE CASCADE"
//                        + ");"
//                        + "CREATE TABLE IF NOT EXISTS sepatu ("
//                        + "id_perlengkapan INT (10) PRIMARY KEY "
//                        + "                         REFERENCES Perlengkapan (id_perlengkapan) ON DELETE RESTRICT "
//                        + "                                                                   ON UPDATE CASCADE,"
//                        + " ukuran INT (2)"
//                        + ");"
//                        + "CREATE TABLE IF NOT EXISTS tas ("
//                        + "id_perlengkapan INT (10) PRIMARY KEY "
//                        + "                         REFERENCES Perlengkapan (id_perlengkapan) ON DELETE RESTRICT "
//                        + "                                                                   ON UPDATE CASCADE, "
//                        + "kapasitas INT (10)"
//                        + ");";
//                break;
//            }
//        }
//        String sqls[] = sqlCreate.split(";");
//        for (String sql : sqls) {
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.execute();
//        }
//    }
}
