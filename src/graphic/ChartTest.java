package graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ChartTest extends JFrame {
	int data[] = new int[4];
	int arc[] = new int[4];
	String fruit[] = { "apple", "cherry", "strawberry", "prune" };
	JTextField tf[] = new JTextField[5];
	JLabel lb[] = new JLabel[5];
	MyPanel2 panel2 = new MyPanel2();

	public ChartTest() {

		setTitle("ÆÄÀÌ Â÷Æ® ±×¸®±â");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		MyPanel panel = new MyPanel();

		c.add(panel, BorderLayout.NORTH);
		c.add(panel2, BorderLayout.CENTER);
		setVisible(true);
	}

	class MyPanel extends JPanel {

		MyActionListener ml = new MyActionListener();
		

		public MyPanel() {
			setBackground(Color.LIGHT_GRAY);

			for (int i = 0; i < 5; i++) {
				tf[i] = new JTextField(5);
				tf[i].addActionListener(ml);
			}
			for (int i = 0; i < 4; i++) {
				lb[i] = new JLabel(fruit[i]);
			}

			for (int i = 0; i < 4; i++) {
				add(lb[i]);
				add(tf[i]);

			}

		}

	}

	class MyActionListener implements ActionListener {
		int a = 0;

		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < 4; i++) {
				a += Integer.parseInt(tf[i].getText());
				

			}
			for (int i = 0; i < 4; i++) {

				data[i] = (int) Math.round((Float.parseFloat(tf[i].getText()) / (float) a * 100));
				arc[i] = (int) Math.round((Float.parseFloat(tf[i].getText()) / (float) a * 360));
				panel2.repaint();
			}
			a=0;

		}

	}

	class MyPanel2 extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// »ç°ú
			g.setColor(Color.RED);
			g.setFont(new Font("", Font.BOLD, 12));
			g.drawString(fruit[0] + " " + data[0] + "%", 60, 15);
			g.fillArc(150, 50, 200, 200, 0, arc[0]);

			// Ã¼¸®
			g.setColor(Color.BLUE);
			g.setFont(new Font("", Font.BOLD, 12));
			g.drawString(fruit[1] + " " + data[1] + "%", 150, 15);
			g.fillArc(150, 50, 200, 200, 0 + arc[0], arc[1]);

			// µþ±â
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("", Font.BOLD, 12));
			g.drawString(fruit[2] + " " + data[2] + "%", 240, 15);
			g.fillArc(150, 50, 200, 200, 0 + arc[0] + arc[1], arc[2]);

			// Çª·é
			g.setColor(Color.YELLOW);
			g.setFont(new Font("", Font.BOLD, 12));
			g.drawString(fruit[3] + " " + data[3] + "%", 360, 15);
			g.fillArc(150, 50, 200, 200, 0 + arc[0] + arc[1] + arc[2], arc[3]);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ChartTest();
	}

}
