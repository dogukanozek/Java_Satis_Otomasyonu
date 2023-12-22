package proje_ekran;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Musteri_veritabani_kontrol {
    public  int musteri_id;
	public boolean kontrol(String ad, String soyad, String sifre) {
        boolean kont = false;
        try {
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
            Statement mystat = myconn.createStatement();
            ResultSet MyRs = mystat.executeQuery("select * from musteriler");
            while (MyRs.next()) {
                
                if (ad.equals(MyRs.getString("Ad")) && soyad.equals(MyRs.getString("Soyad")) && sifre.equals(MyRs.getString("Sifre"))) {
                	System.out.println(MyRs.getString("Ad"));
                    kont = true;
                    musteri_id=MyRs.getInt("idmusteriler");
                    
                    break;
                }
            }
            myconn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return kont;
    }
	
	public void kayit(String ad,String soyad,String sifre) throws SQLException {
    	Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");

    	// Örnek değerler
    	 
    	

    	String insertQuery = "INSERT INTO musteriler (Ad, SoyAd, Sifre) VALUES (?, ?, ?)";

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
    public void satın_al(int id,int adet,int musteri_id) {
    	try {
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
            Statement mystat = myconn.createStatement();
            ResultSet MyRs = mystat.executeQuery("select * from urunler");
            String updateQuery="UPDATE urunler SET Urun_stok = ? WHERE İd = ?"; 
            while (MyRs.next()) {
              
              int id_1=MyRs.getInt("İd");
              int Urun_stok=MyRs.getInt("Urun_stok");
              int yenistok=Urun_stok;  
               if(id==id_1) {
            	   yenistok=Urun_stok-adet;
            	   siparis_gecmisi_ekle(musteri_id,id,adet);
            	   try (PreparedStatement preparedStatement = myconn.prepareStatement(updateQuery)) {
                       preparedStatement.setInt(1,yenistok);
                       
                       preparedStatement.setInt(2, id);
                    
            
                       
                       int rowsAffected = preparedStatement.executeUpdate();

                       
                       if (rowsAffected > 0) {
                           System.out.println(rowsAffected + " row(s) updated successfully.");
                       } else {
                           System.out.println("No rows updated.");
                       }
                   }
               }
               
               
               
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	public void siparis_gecmisi_ekle(int musteri_id,int urun_id,int urun_adet) {
		
		try {
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
            Statement mystat = myconn.createStatement();
            String query_musteri="select * from musteriler where idmusteriler=?";
            String query_urun="select * from urunler where İd=?";
            String query_ekle = "INSERT INTO siparis_gecmisi (MusterıId, UrunId, Urun_ad, Urun_adet, Musteri_ad, Musteri_soyad, Siparis_tarihi) VALUES (?, ?, ?, ?, ?, ?, ?)";


            String Urun_ad = "",Musteri_ad = "",Musteri_soyad="";	
            try(PreparedStatement preparedStatementMusteri = myconn.prepareStatement(query_musteri)){
            	preparedStatementMusteri.setInt(1,musteri_id);
            	 try (ResultSet musteridata = preparedStatementMusteri.executeQuery()) {
                     while (musteridata.next()) {
                        Musteri_ad=musteridata.getString("Ad");
                        Musteri_soyad=musteridata.getString("SoyAd");
                        
                     }
                 }
            }
            Date date=new Date();
            java.sql.Date sqldate =new java.sql.Date(date.getTime());
            try(PreparedStatement preparedStatementUrun = myconn.prepareStatement(query_urun)){
            	preparedStatementUrun.setInt(1,urun_id);
            	 try (ResultSet musteridata = preparedStatementUrun.executeQuery()) {
                     while (musteridata.next()) {
                    	 Urun_ad=musteridata.getString("Urun_ad");
                        
                     }
                 }
            }
            try (PreparedStatement preparedekle = myconn.prepareStatement(query_ekle)) {
        	    
            	preparedekle.setInt(1, musteri_id);
                preparedekle.setInt(2, urun_id);
                preparedekle.setString(3, Urun_ad);
                preparedekle.setInt(4, urun_adet);
                preparedekle.setString(5, Musteri_ad);
                preparedekle.setString(6, Musteri_soyad);
                preparedekle.setDate(7, sqldate);
                
        	    int affectedRows = preparedekle.executeUpdate();

        	    if (affectedRows > 0) {
        	        System.out.println("Veri başarıyla eklendi.");
        	    } else {
        	        System.out.println("Veri eklenirken bir hata oluştu.");
        	    }
        	} catch (Exception e) {
        	    e.printStackTrace();
        	}
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void siparis_gecmisi_goruntule(int musteri_id,JTable table) {
		try {
			
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
            Statement mystat = myconn.createStatement();
            String query="select * from siparis_gecmisi where MusterıId=?";
            try(PreparedStatement preparedgoruntule = myconn.prepareStatement(query)){
            	preparedgoruntule.setInt(1, musteri_id);
            	try (ResultSet musteridata = preparedgoruntule.executeQuery()) {
                    while (musteridata.next()) {
                    String MusterıId=String.valueOf(musteri_id);
                    String Urun_Id=String.valueOf(musteridata.getInt("UrunId"));
                    String Urun_ad=musteridata.getString("Urun_ad");
                    String Urun_adet=String.valueOf(musteridata.getInt("Urun_adet"));
                    String Musteri_ad=musteridata.getString("Musteri_ad");
                    String Musteri_soyad=musteridata.getString("Musteri_soyad");
                    String Siparis_tarihi=musteridata.getString("Siparis_tarihi");
                    String tbData[]= {MusterıId,Urun_Id,Urun_ad,Urun_adet,Musteri_ad,Musteri_soyad,Siparis_tarihi};
                    DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
                    
                    tblModel.addRow(tbData);
                   	
                       
                    }
                }
            }
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
	
	
	
	
}
