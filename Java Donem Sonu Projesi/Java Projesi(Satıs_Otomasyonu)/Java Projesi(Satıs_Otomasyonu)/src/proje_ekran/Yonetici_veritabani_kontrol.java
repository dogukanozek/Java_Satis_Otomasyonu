package proje_ekran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Yonetici_veritabani_kontrol {
	
	
    public boolean kontrol(String ad, String soyad, String sifre) {
        boolean kont = false;
        try {
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
            Statement mystat = myconn.createStatement();
            ResultSet MyRs = mystat.executeQuery("select * from yonetici_hesaplari");
            while (MyRs.next()) {
                
                if (ad.equals(MyRs.getString("Ad")) && soyad.equals(MyRs.getString("Soyad")) && sifre.equals(MyRs.getString("Sifre"))) {
                	System.out.println(MyRs.getString("Ad"));
                    kont = true;
                    break;
                }
            }
            myconn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return kont;
    }
    
    //YoneticiKayit
    
    public void kayit(String ad,String soyad,String sifre) throws SQLException {
    	Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");

    	// Örnek değerler
    	 
    	

    	String insertQuery = "INSERT INTO yonetici_hesaplari (Ad, SoyAd, Sifre) VALUES (?, ?, ?)";

    	try (PreparedStatement preparedStatement = myconn.prepareStatement(insertQuery)) {
    	    
    	    preparedStatement.setString(1, ad);
    	    preparedStatement.setString(2, soyad);
    	    preparedStatement.setString(3, sifre);

    	    int affectedRows = preparedStatement.executeUpdate();

    	    if (affectedRows > 0) {
    	        System.out.println("Veri başarıyla eklendi.");
    	    } else {
    	        System.out.println("Veri eklenirken bir hata oluştu.");
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
    
    //Urunler için kayı
    
    public void kayit2(String ad,int stok,String kategori) throws SQLException {
    	Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");

    	// Örnek değerler
    	 
    	

    	String insertQuery = "INSERT INTO urunler (Urun_ad, Urun_stok, Urun_kategori) VALUES (?, ?, ?)";

    	try (PreparedStatement preparedStatement = myconn.prepareStatement(insertQuery)) {
    	    
    	    preparedStatement.setString(1, ad);
    	    preparedStatement.setLong(2, stok);
    	    preparedStatement.setString(3, kategori);

    	    int affectedRows = preparedStatement.executeUpdate();

    	    if (affectedRows > 0) {
    	        System.out.println("Veri başarıyla eklendi.");
    	    } else {
    	        System.out.println("Veri eklenirken bir hata oluştu.");
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
    public void listele(JTable table) throws SQLException {
    	
        try {
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
            Statement mystat = myconn.createStatement();
            ResultSet MyRs = mystat.executeQuery("select * from urunler");
            while (MyRs.next()) {
                
               String id=String.valueOf(MyRs.getInt("İd"));
               String Urun_ad=MyRs.getString("Urun_ad");
               String Urun_stok=String.valueOf(MyRs.getInt("Urun_stok"));
               String Urun_kategori=MyRs.getString("Urun_kategori");
               String tbData[]= {id,Urun_ad,Urun_stok,Urun_kategori};
               DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
               tblModel.addRow(tbData);
               
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public void sil(int id) throws SQLException{
    	Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
    	String deleteQuery = "DELETE FROM urunler WHERE İd = ?"; // 
        
        try (PreparedStatement preparedStatement = myconn.prepareStatement(deleteQuery)) {
           
            preparedStatement.setInt(1, id);

            
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Silinen satır sayısı: " + rowsAffected);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void duzenle(int id,String ad,int stok,String kategori) throws SQLException {
    	
    	Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
    	String updateQuery = "UPDATE urunler SET Urun_ad = ?, Urun_stok = ?,Urun_kategori=? WHERE İd=? ";
    	try (PreparedStatement preparedStatement = myconn.prepareStatement(updateQuery)) {
            
            preparedStatement.setString(1,ad);
            preparedStatement.setInt(2, stok);
            preparedStatement.setString(3,kategori);
            preparedStatement.setInt(4,id);
           
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Güncellenen satır sayısı: " + rowsAffected);
        }
    	catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	
    }
    
    
}
