import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Clock2 extends JFrame {

	JLabel lblClock;
	JPanel panel;

	public Clock2() {

		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		lblClock = new JLabel();
		panel.add(lblClock);

		setContentPane(panel);

		Timer timer = new Timer(1000, new ClockListener());
		timer.start();
	}

	public static void main(String[] args) {
		Clock2 c = new Clock2();
		c.setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.setSize(50, 50);
		c.setVisible(true);
	}

	class ClockListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Calendar now = Calendar.getInstance();
			lblClock.setText(String.format("%1$tH:%1$tM:%1$tS", now));
		}
	}
}