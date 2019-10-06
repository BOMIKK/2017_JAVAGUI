package graphic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PolygonTest extends JFrame {
	public PolygonTest() {

		setTitle("격자 그리기 ");
		setSize(360, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		MyPanel panel = new MyPanel();
		c.add(panel, BorderLayout.CENTER);

		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int pw = this.getWidth();
			int ph = this.getHeight();

			int x[] = { 0, pw / 2, pw, pw / 2 };
			int y[] = { ph / 2, 0, ph / 2, ph };

			for (int i = 0; i < 9; i++) {

				g.drawPolygon(x, y, 4);

				x[0] = x[0] + 13;
				x[2] = x[2] - 13;
				y[1] = y[1] + 13;
				y[3] = y[3] - 13;
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new PolygonTest();
	}

}
