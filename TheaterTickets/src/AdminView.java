import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JList list;
	DefaultListModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
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
	public AdminView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u03A0\u0391\u03A1\u0391\u03A3\u03A4\u0391\u03A3\u0395\u0399\u03A3");
		label.setBounds(10, 11, 137, 27);
		contentPane.add(label);
		
		final DefaultListModel model = new DefaultListModel();
		final JList list = new JList(model);
		list.setBounds(10, 52, 450, 87);
		contentPane.add(list);
		String query = "select * from Tickets;";
		Connection con = Handler.connect();
		ResultSet rs = Handler.executeQuery(query, con);
		
		try{
			while (rs.next()){
				
				String str=rs.getString(2) + " "+rs.getString(4) + " "+rs.getString(5);
				
				model.addElement(str);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally
		{
			Handler.disconnect(con);
		}
		
		JButton button_1 = new JButton("\u0394\u0399\u0391\u0393\u03A1\u0391\u03A6\u0397");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list.getSelectedIndex();
				i++;
				String query = "delete from Tickets where ID="+i+";";
				Connection con = Handler.connect();
				Handler.executeQuery(query, con);
				query = "select * from Tickets;";
				ResultSet rs = Handler.executeQuery(query, con);
				model.clear();
				
				try{
					while (rs.next()){
						
						String str=rs.getString(2) + " "+rs.getString(4) + " "+rs.getString(5);
						
						model.addElement(str);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					Handler.disconnect(con);
				}
				
			}
		});
		button_1.setBounds(484, 83, 116, 27);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel("\u039D\u0395\u0391 \u03A0\u0391\u03A1\u0391\u03A3\u03A4\u0391\u03A3\u0397");
		label_1.setBounds(10, 163, 137, 27);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(111, 190, 349, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 221, 349, 66);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 298, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(374, 298, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(110, 342, 196, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(374, 342, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("\u0391\u03A0\u039F\u0398\u0397\u039A\u0395\u03A5\u03A3\u0397");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String query = "insert into Tickets values("+(model.size()+1);
					String str=textField.getText();
					query=query+",'"+str;
					str=textField_1.getText();
					query=query+"','"+str;
					str=textField_4.getText();
					query=query+"','"+str;
					str=textField_5.getText();
					query=query+"','"+str+"',30,30,30";
					str=textField_2.getText();
					query=query+","+str;
					str=textField_3.getText();
					query=query+","+str+");";
					Connection con = Handler.connect();
					Handler.executeQuery(query, con);
					query = "select * from Tickets;";
					ResultSet rs = Handler.executeQuery(query, con);
					model.clear();
					
					try{
						while (rs.next()){
							
							str=rs.getString(2) + " "+rs.getString(4) + " "+rs.getString(5);
							
							model.addElement(str);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					finally
					{
						Handler.disconnect(con);
					}
			}
			
		});
		btnNewButton.setBounds(484, 382, 116, 27);
		contentPane.add(btnNewButton);
		
		JLabel label_2 = new JLabel("\u03A4\u0399\u03A4\u039B\u039F\u03A3 ");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setBounds(52, 192, 48, 17);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u03A0\u0395\u03A1\u0399\u0393\u03A1\u0391\u03A6\u0397");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setBounds(10, 221, 90, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u03A4\u0399\u039C\u0397");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setBounds(64, 300, 36, 17);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u039C\u0395\u0399\u03A9\u039C\u0395\u039D\u0397 \u03A4\u0399\u039C\u0397");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setBounds(259, 298, 105, 20);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setBounds(10, 342, 90, 20);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u03A9\u03A1\u0391");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setBounds(316, 344, 48, 17);
		contentPane.add(label_7);
	}

}
