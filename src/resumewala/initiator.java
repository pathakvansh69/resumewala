package resumewala;

import java.awt.EventQueue;

public class initiator {
	static String sesid =SessionIdGenerator.getSessionId();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalForm frame = new PersonalForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
