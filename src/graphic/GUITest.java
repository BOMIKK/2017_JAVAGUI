package graphic;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class GUITest extends JFrame {
	MyPanel2 panel2 = new MyPanel2();

	int mode = 10;

	int mode2;
	Color c;
	JButton btn[] = new JButton[4];
	String gp[] = { "＼ ", "□", "○", "△" };
	JLabel lb;
	ImageIcon icon = new ImageIcon("img/color.jpg");
	Image img = icon.getImage();

	public GUITest() {

		setTitle("그래픽 그리기");
		setSize(550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		MyPanel panel = new MyPanel();
		c.add(panel, BorderLayout.NORTH);

		c.add(panel2, BorderLayout.CENTER);
		setVisible(true);
	}

	class MyPanel extends JPanel {

		MyButton b = new MyButton(icon);

		public MyPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new GridLayout(0, 8));

			JPanel p = new JPanel();
			p.setLayout(new GridLayout(0, 2));
			p.setBackground(Color.LIGHT_GRAY);

			// 케이스 쓰기
			add(new JLabel("도형", SwingConstants.RIGHT));

			for (int i = 0; i < 4; i++) {
				btn[i] = new JButton(gp[i]);
				add(btn[i]);

				btn[i].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton) e.getSource();

						if (b.getText() == gp[0]) {
							mode = 0;

						}
						if (b.getText() == gp[1]) {
							mode = 1;

						}
						if (b.getText() == gp[2]) {
							mode = 2;

						}
						if (b.getText() == gp[3]) {
							mode = 3;

						}

					}
				});

			}

			add(new JLabel("색 선택", SwingConstants.RIGHT));
			p.add(b);
			b.addActionListener(new ActionListener() {

				JColorChooser s = new JColorChooser();

				public void actionPerformed(ActionEvent e) {
					mode2 = 0;
					Color selectedColor = s.showDialog(null, "Color", Color.MAGENTA);
					if (selectedColor != null) {

						c = selectedColor;

					}

				}

			});

			add(p);
		}
	}

	class MyPanel2 extends JPanel {

		Point ovalP = null;
		Point startP = new Point(0, 0);
		Point endP = new Point(0, 0);

		public MyPanel2() {
			MyListener ml = new MyListener();

			addMouseMotionListener(ml);
			addMouseListener(ml);

		}

		class MyListener extends MouseAdapter {

			public void mousePressed(MouseEvent e) {
				startP = e.getPoint();

			}

			public void mouseReleased(MouseEvent e) {
				endP = e.getPoint();
				repaint();
			}

			public void mouseDragged(MouseEvent e) {
				endP = e.getPoint();
				repaint();

			}

		}

		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			switch (mode) {

			case 0:

				g.setColor(Color.RED);
				if (mode2 == 0) {
					g.setColor(c);
				}
				g.drawLine(startP.x, startP.y, endP.x, endP.y);

				break;
			case 1:

				g.setColor(Color.BLUE);
				if (mode2 == 0) {
					g.setColor(c);
				}

				g.drawRect(startP.x, startP.y, Math.abs(startP.x - endP.x), Math.abs(startP.y - endP.y));

				break;

			case 2:

				g.setColor(Color.MAGENTA);
				if (mode2 == 0) {
					g.setColor(c);
				}

				g.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y), Math.abs(startP.x - endP.x),
						Math.abs(startP.y - endP.y));

				break;
			case 3:

				g.setColor(Color.GREEN);
				if (mode2 == 0) {

					g.setColor(c);
				}

				int x1[] = { startP.x, startP.x + (endP.x - startP.x), startP.x - (endP.x - startP.x) };
				int y1[] = { startP.y, endP.y, endP.y };
				g.drawPolygon(x1, y1, 3);

				break;
			}

		}
	}

	class MyButton extends JButton {

		MyButton(Icon img) {
			super(img);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new GUITest();
	}
}
