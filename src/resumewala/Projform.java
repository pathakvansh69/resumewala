package resumewala;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Projform extends JFrame {

	private JPanel contentPane;
	private JTextField TitleField;
	private JTextField DescrField;
	String proj_ttl,proj_des;

	
	public Projform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TitleField = new JTextField();
		TitleField.setBounds(221, 43, 116, 22);
		contentPane.add(TitleField);
		TitleField.setColumns(10);
		
		JLabel lblProj = new JLabel("PROJECT TITLE");
		lblProj.setBounds(71, 46, 100, 16);
		contentPane.add(lblProj);
		
		JLabel lblDescr = new JLabel("PROJECT DESCRIPTION");
		lblDescr.setBounds(44, 117, 150, 16);
		contentPane.add(lblDescr);
		
		JButton btnAdd = new JButton("ADD MORE +");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pfentry();
				clearfields();
			}
		});
		btnAdd.setBounds(71, 185, 123, 25);
		contentPane.add(btnAdd);
		
		JButton btnNext = new JButton("NEXT>>>");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pfentry();
				dispose();
			}
		});
		btnNext.setBounds(240, 185, 97, 25);
		contentPane.add(btnNext);
		
		DescrField = new JTextField();
		DescrField.setBounds(221, 114, 116, 44);
		contentPane.add(DescrField);
		DescrField.setColumns(10);
	}
	void pfentry(){
		proj_ttl=new String(TitleField.getText());
		proj_des=new String(DescrField.getText());
		
		try{
			
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			 Connection myconn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","resumewala", "1996pathak");
			
			Statement stm = myconn.createStatement();
			//stm.executeUpdate(""insert into projset "+"values ('"+initiator.sesid+"','"+proj_ttl+"','"+proj_des+"')");
			//stm.executeUpdate(" delete from personaldet " );
			//while(rs.next()){
				//System.out.println(rs.getString("name"));
			//}
			System.out.println("insert into projset "+"values ('"+initiator.sesid+"','"+proj_ttl+"','"+proj_des+"')");
		}
		catch(Exception exc){
			System.out.println(exc);
		}
		
	}
	void clearfields(){
		TitleField.setText(null);
		DescrField.setText(null);
	}
}
