package proje_ekran;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
public class musteri_satis_paneli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;
	Musteri_veritabani_kontrol veri_tabanı_kontrol=new Musteri_veritabani_kontrol();
	private JTextField textField;
	private JTextField textField_1;
	public int musteri_id;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteri_satis_paneli frame = new musteri_satis_paneli();
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
	public musteri_satis_paneli() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1465, 615);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Urunler");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mnıtmNewMenuItem = new JMenuItem("Urunleri Listele");
		
		mnıtmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnıtmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mnıtmNewMenuItem);
		
		JMenuItem mnıtmNewMenuItem_1 = new JMenuItem("Urun Satın Al");
		
		mnıtmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mnıtmNewMenuItem_1);
		
		JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("Sipariş Geçmişi");
		
		mnıtmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mnıtmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(35, 0, 1406, 515);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Urunler Listesi", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane.addTab("New tab", null, panel, null);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u0130d", "Urun_ad", "Urun_stok", "Urun_kategori"
			}
		));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setBounds(27, 47, 956, 421);
		panel.add(table_1);
		
		JLabel lblNewLabel = new JLabel("İd");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(110, 10, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblUrunadi = new JLabel("UrunAdi");
		lblUrunadi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUrunadi.setBounds(363, 10, 85, 13);
		panel.add(lblUrunadi);
		
		JLabel lblStok = new JLabel("Stok");
		lblStok.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStok.setBounds(616, 10, 45, 13);
		panel.add(lblStok);
		
		JLabel lblKategori = new JLabel("Kategori");
		lblKategori.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKategori.setBounds(808, 10, 85, 13);
		panel.add(lblKategori);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(1253, 17, 85, 74);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Satın Al");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		btnNewButton.setBounds(402, 231, 187, 97);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("İd:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(306, 67, 133, 50);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adet:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(306, 142, 133, 31);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(443, 78, 114, 41);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(442, 143, 115, 41);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Müşteriİd");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(306, 7, 133, 50);
		panel_1.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(443, 18, 114, 41);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBounds(45, 32, 1032, 426);
		panel_2.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		JLabel lblNewLabel_3 = new JLabel("MusterıId");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(59, 10, 66, 13);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("UrunId");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(169, 10, 66, 13);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Urun_ad");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(266, 9, 66, 13);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Urun_adet");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(401, 9, 79, 13);
		panel_2.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Musteri_ad");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(595, 10, 79, 13);
		panel_2.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Musteri_soyad");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_5.setBounds(757, 10, 109, 13);
		panel_2.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("Siparis_tarihi");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_6.setBounds(932, 9, 109, 13);
		panel_2.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_4 = new JLabel("MüşteriId:\r\n");
		lblNewLabel_4.setBounds(1087, 42, 153, 46);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		textField_3 = new JTextField();
		textField_3.setBounds(1209, 56, 153, 27);
		panel_2.add(textField_3);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Sipariş Geçmişini Görüntüle");
		btnNewButton_2.setBounds(1101, 156, 278, 84);
		panel_2.add(btnNewButton_2);
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		mnıtmNewMenuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
		    		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
			        model.setRowCount(0);
		    		mnıtmNewMenuItem.setEnabled(false);
		    		tabbedPane.setVisible(true);
		    		tabbedPane.setSelectedIndex(0);
					veri_tabanı_kontrol.listele(table_1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        panel.setVisible(true);
			}
		});
		mnıtmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				mnıtmNewMenuItem.setEnabled(true);
			}
		});
		mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
				mnıtmNewMenuItem.setEnabled(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				int adet=Integer.parseInt(textField_1.getText());
				int musteri_id=Integer.parseInt(textField_2.getText());
				veri_tabanı_kontrol.satın_al(id,adet,musteri_id);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int musteri_id=Integer.parseInt(textField_3.getText());
				DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
				tblModel.setRowCount(0);
				veri_tabanı_kontrol.siparis_gecmisi_goruntule(musteri_id,table);
			}
		});
	}
}
