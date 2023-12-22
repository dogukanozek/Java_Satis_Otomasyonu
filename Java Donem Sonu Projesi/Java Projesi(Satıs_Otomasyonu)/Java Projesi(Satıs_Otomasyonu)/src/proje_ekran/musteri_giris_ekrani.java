package proje_ekran;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class musteri_giris_ekrani extends JFrame {
	Musteri_veritabani_kontrol veri_tabanı_kontrol=new Musteri_veritabani_kontrol();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteri_giris_ekrani frame = new musteri_giris_ekrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public musteri_giris_ekrani() {
		setTitle("Musteri_Giris_Ekrani\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1139, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(420, 89, 108, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(524, 91, 187, 35);
		contentPane.add(textField);
		
		JLabel lblSoyad = new JLabel("SoyAd:");
		lblSoyad.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSoyad.setBounds(420, 130, 108, 37);
		contentPane.add(lblSoyad);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(524, 136, 187, 35);
		contentPane.add(textField_1);
		
		JLabel lblGiris = new JLabel("Sifre:");
		lblGiris.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblGiris.setBounds(420, 177, 108, 37);
		contentPane.add(lblGiris);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(524, 179, 187, 35);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Giris Yap");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton.setBounds(478, 262, 180, 43);
		contentPane.add(btnNewButton);
		
		JButton btnKaytOl = new JButton("Kayıt Ol");
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad=textField.getText();
			    String soyad=textField_1.getText();
			    String sifre=textField_2.getText();
				try {
					veri_tabanı_kontrol.kayit(ad,soyad,sifre);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnKaytOl.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnKaytOl.setBounds(478, 315, 180, 43);
		contentPane.add(btnKaytOl);
		
		btnNewButton.addActionListener(new ActionListener() {
			private int musteri_id;

			public void actionPerformed(ActionEvent e) {
				
				String ad=textField.getText();
				String soyad=textField_1.getText();
				String sifre=textField_2.getText();
				if(veri_tabanı_kontrol.kontrol(ad, soyad, sifre)==true) {
					
			        try {
			            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanicilar", "root", "dogukan1907");
			            Statement mystat = myconn.createStatement();
			            ResultSet MyRs = mystat.executeQuery("select * from musteriler");
			            while (MyRs.next()) {
			                
			                if (ad.equals(MyRs.getString("Ad")) && soyad.equals(MyRs.getString("Soyad")) && sifre.equals(MyRs.getString("Sifre"))) {
			                	System.out.println("İd numaranız:");
			                	this.musteri_id=MyRs.getInt("idmusteriler");
			                	JOptionPane.showMessageDialog(null, "İd numaranız:"+this.musteri_id);
			                    
			                   
			                    
			                    break;
			                }
			            }
			            myconn.close();
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
					musteri_satis_paneli musteri_satis_paneli=new musteri_satis_paneli();
					
					musteri_satis_paneli.setVisible(true);
					dispose();
					System.out.println("Giris Yapıldı");
				}
			}
		});
	}
}
