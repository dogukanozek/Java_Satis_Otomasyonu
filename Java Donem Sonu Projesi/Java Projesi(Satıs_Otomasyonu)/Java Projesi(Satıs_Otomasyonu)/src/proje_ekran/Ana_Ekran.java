package proje_ekran;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;




public class Ana_Ekran extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Ana_Ekran() {
		setTitle("Giriş Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Müşteri Girişi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteri_giris_ekrani musteri_ekrani=new musteri_giris_ekrani();
				musteri_ekrani.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(206, 81, 678, 85);
		contentPane.add(btnNewButton);
		
		JButton btnYneticiGirii = new JButton("Yönetici Girişi");
		btnYneticiGirii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yonetici_girisi yonetici_girisi=new Yonetici_girisi();
				yonetici_girisi.setVisible(true);
				dispose();
			}
		});
		btnYneticiGirii.setBackground(new Color(0, 255, 255));
		btnYneticiGirii.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnYneticiGirii.setBounds(206, 307, 678, 85);
		contentPane.add(btnYneticiGirii);
	}
}
