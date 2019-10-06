package graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorTest extends JFrame {

	public ColorTest() {

		setTitle("Ω≈»£µÓ");
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		MyPanel panel = new MyPanel();
		c.add(panel, BorderLayout.CENTER);

		setVisible(true);
	}

	class MyPanel extends JPanel {
		JButton btn;
		// 0=R,1=G,2=Y
		int mode = 0;

		public MyPanel() {
			btn = new JButton("turn on");
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mode = (mode + 1) % 3;
					repaint();

				}

			});
			setLayout(new BorderLayout());
			add(btn, BorderLayout.SOUTH);

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			switch (mode) {
			case 0:
				g.setColor(Color.RED);
				g.fillOval(95, 110, 100, 100);
				break;
			case 1:
				g.setColor(Color.GREEN);
				g.fillOval(95, 210, 100, 100);
				break;

			case 2:
				g.setColor(Color.YELLOW);
				g.fillOval(95, 310, 100, 100);

			}
			g.setColor(Color.BLACK);
			g.drawOval(95, 110, 100, 100);
			g.drawOval(95, 210, 100, 100);
			g.drawOval(95, 310, 100, 100);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ColorTest();
	}

}
