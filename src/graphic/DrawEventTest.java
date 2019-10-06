package graphic;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class DrawEventTest extends JFrame {
	public DrawEventTest() {

		setTitle("원 그리기 이벤트");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		MyPanel panel = new MyPanel();
		c.add(panel, BorderLayout.CENTER);

		setVisible(true);
	}

	class MyPanel extends JPanel {

		Vector<Point> vs = new Vector<Point>();
		Vector<Point> ve = new Vector<Point>();
		Point startP = new Point(0,0);
		Point endP =  new Point(0,0);
		Point ovalP=null;

		public MyPanel() {
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
				
				vs.add(startP);
				ve.add(endP);
				repaint();
			}

			public void mouseDragged(MouseEvent e) {
				endP = e.getPoint();
				repaint();

			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			
			
			for (int i = 0; i < vs.size(); i++) {
				Point s = vs.get(i);
				Point e = ve.get(i);
				int x=Math.min(s.x, e.x);
				int y=Math.min(s.y, e.y);
				int w=Math.abs(s.x-e.x);
				int h=Math.abs(s.y-e.y);
			
				 g.drawOval(x,y, w, h);
			}
		
			
			g.drawOval(Math.min(startP.x,endP.x), Math.min(startP.y,endP.y),
					Math.abs(startP.x-endP.x),Math.abs(startP.y-endP.y));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new DrawEventTest();
	}

}
