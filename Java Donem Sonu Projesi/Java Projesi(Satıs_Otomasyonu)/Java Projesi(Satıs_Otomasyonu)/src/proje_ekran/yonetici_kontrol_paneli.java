package proje_ekran;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class yonetici_kontrol_paneli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	Yonetici_veritabani_kontrol veri_tabanı_kontrol=new Yonetici_veritabani_kontrol();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yonetici_kontrol_paneli frame = new yonetici_kontrol_paneli();
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
	public yonetici_kontrol_paneli() {
		setTitle("YoneticiKontrolPaneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 615);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Urunler");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mnıtmNewMenuItem = new JMenuItem("Urunleri Listele");
		
		
		mnıtmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mnıtmNewMenuItem);
		
		JMenuItem mnıtmNewMenuItem_1 = new JMenuItem("Urunleri Ekle");
		
		mnıtmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mnıtmNewMenuItem_1);
		
		JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("Urunleri Sil");
		
		mnıtmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mnıtmNewMenuItem_2);
		
		JMenuItem mnıtmNewMenuItem_3 = new JMenuItem("Urunleri Duzenle");
		
		mnıtmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mnıtmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(17, 10, 1114, 512);
		contentPane.add(tabbedPane);
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		tabbedPane.setVisible(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Urunler Listesi", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u0130d", "Urun_Stok", "Urun_Ad", "Urun_Kategori"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.setBounds(27, 40, 956, 421);
		panel.add(table);
		
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
		lblKategori.setBounds(808, 10, 64, 13);
		panel.add(lblKategori);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setBounds(1014, 10, 85, 74);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setRowCount(0);
		        // ürünleri gösteren jtablein içeriğini siliyoruz
		        tabbedPane.setVisible(false);
		        mnıtmNewMenuItem.setEnabled(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Urun_Adi:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(273, 100, 112, 47);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Stok:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_1.setBounds(273, 157, 101, 31);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Kategori\r\n:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_2.setBounds(273, 210, 112, 31);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setBounds(395, 100, 250, 39);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(395, 159, 250, 39);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(395, 212, 251, 39);
		panel_1.add(textField_2);
		
		JButton btnNewButton_2 = new JButton("Ekle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ad=textField.getText();
					int stok=Integer.parseInt(textField_1.getText());
					String kategori=textField_2.getText();
					veri_tabanı_kontrol.kayit2(ad, stok, kategori);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(400, 302, 257, 81);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("X");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(false);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(1014, 10, 85, 74);
		panel_1.add(btnNewButton_1_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UrunId:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(369, 154, 121, 50);
		panel_2.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setBounds(463, 154, 169, 50);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Sil");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField_3.getText());
				try {
					veri_tabanı_kontrol.sil(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_3.setBounds(492, 250, 121, 44);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_1_1_1 = new JButton("X");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(false);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(998, 10, 85, 74);
		panel_2.add(btnNewButton_1_1_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Ürünleri Düzenle", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("UrunId:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(326, 23, 121, 50);
		panel_3.add(lblNewLabel_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBounds(439, 24, 169, 50);
		panel_3.add(textField_4);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("UrunAd:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2_1.setBounds(326, 94, 121, 50);
		panel_3.add(lblNewLabel_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(439, 95, 169, 50);
		panel_3.add(textField_5);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("UrunStok:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2_2.setBounds(326, 162, 121, 50);
		panel_3.add(lblNewLabel_1_2_2);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_6.setColumns(10);
		textField_6.setBounds(439, 163, 169, 50);
		panel_3.add(textField_6);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("UrunKategori:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2_3.setBounds(278, 233, 169, 50);
		panel_3.add(lblNewLabel_1_2_3);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_7.setColumns(10);
		textField_7.setBounds(439, 234, 169, 50);
		panel_3.add(textField_7);
		
		JButton btnNewButton_4 = new JButton("Düzenle\r\n");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField_4.getText());
				String ad=textField_5.getText();
				int stok=Integer.parseInt(textField_6.getText());
				String kategori=textField_7.getText();
				
				try {
					veri_tabanı_kontrol.duzenle(id,ad,stok,kategori);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4.setBounds(439, 328, 169, 50);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_1_1_1_1 = new JButton("X");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(false);
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1_1.setBounds(995, 10, 85, 74);
		panel_3.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton = new JButton("X");
		mnıtmNewMenuItem.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    }
		});

		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    }
		});

		mnıtmNewMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.setRowCount(0);
		    		mnıtmNewMenuItem.setEnabled(false);
		    		tabbedPane.setVisible(true);
		    		tabbedPane.setSelectedIndex(0);
					veri_tabanı_kontrol.listele(table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        panel.setVisible(true);
		        
		    }
		    
		});

	
		//ürünleri ekle butonu
		mnıtmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(true);
				tabbedPane.setSelectedIndex(1);
				mnıtmNewMenuItem.setEnabled(true);
			}
		});
		mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(true);
				mnıtmNewMenuItem.setEnabled(true);
				tabbedPane.setSelectedIndex(2);
			}
		});
		mnıtmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setVisible(true);
				mnıtmNewMenuItem.setEnabled(true);
				tabbedPane.setSelectedIndex(3);
			}
		});

	}
}
