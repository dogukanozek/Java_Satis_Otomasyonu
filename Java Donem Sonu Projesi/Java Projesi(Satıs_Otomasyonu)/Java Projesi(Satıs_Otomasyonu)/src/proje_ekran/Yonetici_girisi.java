package proje_ekran;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Yonetici_girisi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Yonetici_veritabani_kontrol kontrol = new Yonetici_veritabani_kontrol();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yonetici_girisi frame = new Yonetici_girisi();
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
	public Yonetici_girisi() {
		
		setTitle("Yonetici_Girisi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(403, 180, 108, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblSoyad = new JLabel("SoyAd:");
		lblSoyad.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSoyad.setBounds(403, 221, 108, 37);
		contentPane.add(lblSoyad);
		
		JLabel lblGiris = new JLabel("Sifre:");
		lblGiris.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblGiris.setBounds(403, 268, 108, 37);
		contentPane.add(lblGiris);
		
		textField = new JTextField();
		textField.setBounds(507, 182, 187, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(507, 227, 187, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(507, 270, 187, 35);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Giris Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad = textField.getText();
				String soyad=textField_1.getText();
				String sifre=textField_2.getText();
				
				if(kontrol.kontrol(ad, soyad, sifre)==true) {
					
					yonetici_kontrol_paneli yonetici_kontrol_paneli=new yonetici_kontrol_paneli();
					yonetici_kontrol_paneli.setVisible(true);
					dispose();
					System.out.println("Giris Yapıldı");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton.setBounds(461, 353, 180, 43);
		contentPane.add(btnNewButton);
		
		JButton btnKaytOl = new JButton("Kayıt Ol");
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad = textField.getText();
				String soyad=textField_1.getText();
				String sifre=textField_2.getText();
				try {
					kontrol.kayit(ad, soyad, sifre);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("kayıt");
			}
			
		});
		btnKaytOl.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnKaytOl.setBounds(461, 406, 180, 43);
		contentPane.add(btnKaytOl);
	}
}
