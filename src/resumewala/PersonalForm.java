package resumewala;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonalForm extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField emailfield;
	private JTextField phonefield;
	private JTextField linkedfield;
	private JTextField dobfield;
	JRadioButton maleRadioButton,femaleRadioButton,otherRadioButton;
	ButtonGroup bg;
	String Name,Email,Phone,linkedin,dob,gender;
	

	public PersonalForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		namefield = new JTextField();
		namefield.setBounds(165, 29, 188, 22);
		contentPane.add(namefield);
		namefield.setColumns(10);
		
		JLabel Name = new JLabel("NAME");
		Name.setBounds(44, 32, 56, 16);
		contentPane.add(Name);
		
		JButton edulink = new JButton("NEXT >>>");
		
		edulink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				personalnext(e);
				
			}
		});
		
		edulink.setBounds(234, 377, 97, 25);
		contentPane.add(edulink);
		
		emailfield = new JTextField();
		emailfield.setBounds(165, 83, 188, 22);
		contentPane.add(emailfield);
		emailfield.setColumns(10);
		
		phonefield = new JTextField();
		phonefield.setBounds(165, 131, 188, 22);
		contentPane.add(phonefield);
		phonefield.setColumns(10);
		
		linkedfield = new JTextField();
		linkedfield.setBounds(165, 187, 188, 22);
		contentPane.add(linkedfield);
		linkedfield.setColumns(10);
		
		dobfield = new JTextField();
		dobfield.setBounds(165, 250, 188, 22);
		contentPane.add(dobfield);
		dobfield.setColumns(10);
		
		JLabel Email = new JLabel("EMAIL");
		Email.setBounds(44, 86, 56, 16);
		contentPane.add(Email);
		
		JLabel Phone = new JLabel("PHONE NO");
		Phone.setBounds(44, 134, 85, 43);
		contentPane.add(Phone);
		
		JLabel Linkedin = new JLabel("LINKEDIN ID");
		Linkedin.setBounds(44, 190, 85, 44);
		contentPane.add(Linkedin);
		
		JLabel dob = new JLabel("DOB(DD/MM/YYYY)");
		dob.setBounds(44, 244, 116, 34);
		contentPane.add(dob);
		
		JLabel Gender = new JLabel("GENDER");
		Gender.setBounds(44, 308, 56, 16);
		contentPane.add(Gender);
		
		ButtonGroup bg=new ButtonGroup();
		
		JRadioButton maleRadioButton = new JRadioButton("Male");
		bg.add(maleRadioButton);
		maleRadioButton.setBounds(165, 297, 65, 25);
		contentPane.add(maleRadioButton);
		
		JRadioButton femaleRadioButton = new JRadioButton("female");
		bg.add(femaleRadioButton);
		femaleRadioButton.setBounds(229, 299, 74, 25);
		contentPane.add(femaleRadioButton);
		
		JRadioButton otherRadioButton = new JRadioButton("Other");
		bg.add(otherRadioButton);
		otherRadioButton.setBounds(309, 297, 127, 25);
		contentPane.add(otherRadioButton);
		
		
	}
	void personalnext(MouseEvent e){
		 Name =new String(namefield.getText());
		 Email =new String(emailfield.getText());
		 Phone = new String(phonefield.getText());
		 linkedin =new String(linkedfield.getText());
		 dob =new String(dobfield.getText());
		 
		 
		/*try{
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			 Connection myconn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","resumewala", "1996pathak");
			
			Statement stm = myconn.createStatement();
			//stm.executeUpdate("insert into personaldet "+"values ('"+Name+"','"+Email+"','"+Phone+"','"+linkedin+"','"+dob+"','"+gender+"','"+initiator.sesid+"')");
			//stm.executeUpdate(" delete from personaldet " );
			//while(rs.next()){
				//System.out.println(rs.getString("name"));
			//}
		}
		catch(Exception exc){
			System.out.println(exc);
		}*/
		System.out.println("insert into personaldet "+"values ('"+Name+"','"+Email+"','"+Phone+"','"+linkedin+"','"+dob+"','"+gender+"','"+initiator.sesid+"')");
		Eduform eduframe = new Eduform();
		eduframe.setVisible(true);
		dispose();
	}
	
}
