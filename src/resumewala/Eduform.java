package resumewala;


import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Eduform extends JFrame {

	private JPanel contentPane;
	private JTextField DegreeField;
	private JTextField InstiField;
	private JTextField GradeField;
	private JTextField YearField;
	String degree,insti,cgpa,compl_year;

	public Eduform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("ADD MORE +");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eduentry(e);
				clearfields(e);
				
			}
		});
		btnAdd.setBounds(99, 273, 132, 25);
		contentPane.add(btnAdd);
		
		JButton btnNext = new JButton("NEXT>>>");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eduentry(e);
				Skillform skillframe = new Skillform();
				skillframe.setVisible(true);
				dispose();
			}
		});
		btnNext.setBounds(274, 273, 97, 25);
		contentPane.add(btnNext);
		
		DegreeField = new JTextField();
		DegreeField.setBounds(192, 27, 116, 22);
		contentPane.add(DegreeField);
		DegreeField.setColumns(10);
		
		InstiField = new JTextField();
		InstiField.setBounds(192, 91, 116, 22);
		contentPane.add(InstiField);
		InstiField.setColumns(10);
		
		GradeField = new JTextField();
		GradeField.setBounds(192, 151, 116, 22);
		contentPane.add(GradeField);
		GradeField.setColumns(10);
		
		YearField = new JTextField();
		YearField.setBounds(192, 210, 116, 22);
		contentPane.add(YearField);
		YearField.setColumns(10);
		
		JLabel lblDegree = new JLabel("DEGREE");
		lblDegree.setBounds(85, 27, 75, 22);
		contentPane.add(lblDegree);
		
		JLabel lblinsti = new JLabel("INSTITUTE");
		lblinsti.setBounds(63, 94, 97, 16);
		contentPane.add(lblinsti);
		
		JLabel lblgrade = new JLabel("GRADE/CGPA");
		lblgrade.setBounds(75, 154, 85, 16);
		contentPane.add(lblgrade);
		
		JLabel lblyear = new JLabel("YEAR OF COMPLETION");
		lblyear.setBounds(28, 213, 132, 16);
		contentPane.add(lblyear);
	}
	void eduentry(MouseEvent e){
		degree =new String(DegreeField.getText());
		insti =new String(InstiField.getText());
		cgpa =new String(GradeField.getText());
		compl_year=new String(YearField.getText());
		
		try{
			
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			 Connection myconn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","resumewala", "1996pathak");
			
			Statement stm = myconn.createStatement();
			//stm.executeUpdate("insert into edudet "+"values ('"+initiator.sesid+"','"+degree+"','"+insti+"','"+cgpa+"','"+compl_year+"')");
			//stm.executeUpdate(" delete from personaldet " );
			//while(rs.next()){
				//System.out.println(rs.getString("name"));
			//}
			System.out.println("insert into edudet "+"values ('"+initiator.sesid+"','"+degree+"','"+insti+"','"+cgpa+"','"+compl_year+"')");
		}
		catch(Exception exc){
			System.out.println(exc);
		}
	}
	void clearfields(MouseEvent e){
		DegreeField.setText(null);
		InstiField.setText(null);
		GradeField.setText(null);
		YearField.setText(null);
	}
}
