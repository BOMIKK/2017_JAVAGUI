package graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawFillTest extends JFrame {
	public DrawFillTest() {

		setTitle("Color,Font 사용 예제");
		setSize(560, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(0, 3));
		c.add(new MyPanel1());
		c.add(new MyPanel2());
		c.add(new MyPanel3());

		setVisible(true);
	}

	class MyPanel1 extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawRoundRect(10, 10, 130, 130, 20, 20);

			g.setColor(Color.RED);
			g.fillRect(20, 25, 20, 110);

			g.setColor(Color.BLUE);
			g.fillRect(50, 35, 20, 100);

			g.setColor(Color.YELLOW);
			g.fillRect(80, 55, 20, 80);

			g.setColor(Color.GREEN);
			g.fillRect(110, 35, 20, 100);

		}
	}

	class MyPanel2 extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.BLACK);
			g.drawRoundRect(10, 10, 130, 130, 20, 20);

			g.setColor(Color.RED);
			g.fillArc(25, 25, 100, 100, 75, 120);

			g.setColor(Color.BLUE);
			g.fillArc(25, 25, 100, 100, 190, 35);

			g.setColor(Color.YELLOW);
			g.fillArc(25, 25, 100, 100, 220, 90);

			g.setColor(Color.GREEN);
			g.fillArc(25, 25, 100, 100, 300, 135);

		}
	}

	class MyPanel3 extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawRoundRect(10, 10, 130, 130, 20, 20);
			
			g.setColor(Color.MAGENTA);
			int x[]={40,75,110,25,125};
		    int y[]={115,20,115,55,55};
		    g.fillPolygon(x, y, 5);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new DrawFillTest();
	}

}
