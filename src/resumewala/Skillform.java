package resumewala;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Skillform extends JFrame {

	private JPanel contentPane;
	private JTextField SkillField;
	String skill;

	
	public Skillform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SkillField = new JTextField();
		SkillField.setBounds(217, 40, 161, 22);
		contentPane.add(SkillField);
		SkillField.setColumns(10);
		
		JButton btnAdd = new JButton("ADD MORE +");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				skillentry();
				clearfields();
			}
		});
		btnAdd.setBounds(83, 117, 125, 25);
		contentPane.add(btnAdd);
		
		JButton btnNext = new JButton("NEXT>>>");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				skillentry();
				
				Projform projframe = new Projform();
				projframe.setVisible(true);
				dispose();
			}
		});
		btnNext.setBounds(303, 117, 97, 25);
		contentPane.add(btnNext);
		
		JLabel lblSkill = new JLabel("SKILL");
		lblSkill.setBounds(95, 43, 56, 19);
		contentPane.add(lblSkill);
	}
	void skillentry(){
		skill=new String(SkillField.getText());		
		try{
			
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			 Connection myconn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","resumewala", "1996pathak");
			
			Statement stm = myconn.createStatement();
			//stm.executeUpdate("insert into skillset "+"values ('"+initiator.sesid+"','"+skill+"')");
			//stm.executeUpdate(" delete from personaldet " );
			//while(rs.next()){
				//System.out.println(rs.getString("name"));
			//}
			System.out.println("insert into skillset "+"values ('"+initiator.sesid+"','"+skill+"')");
		}
		catch(Exception exc){
			System.out.println(exc);
		}
		
	}
	void clearfields(){
		SkillField.setText(null);
	}

}
