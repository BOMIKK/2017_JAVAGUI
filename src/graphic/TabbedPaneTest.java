package graphic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TabbedPaneTest extends JFrame {
	public TabbedPaneTest() {

		setTitle("Color,Font 사용 예제");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		JTabbedPane pane = createTabbedPane();
		c.add(pane);

		setVisible(true);
	}

	JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.NORTH);
		pane.addTab("chart1", new MyPanel1());
		pane.addTab("chart2", new MyPanel2());
		pane.addTab("star", new MyPanel3());
		return pane;
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
			int x[] = { 40, 75, 110, 25, 125 };
			int y[] = { 115, 20, 115, 55, 55 };
			g.fillPolygon(x, y, 5);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TabbedPaneTest();
	}

}
