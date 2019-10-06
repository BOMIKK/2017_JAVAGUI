package move;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class LeftKeyFrame extends JFrame {

	JPanel p1;
	JLabel l1;

	public LeftKeyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LEFT 키로 문자열 이동");

		setLayout(new FlowLayout());
		setSize(300, 100);

		p1 = new JPanel();
		setContentPane(p1);

		l1 = new JLabel("Love Java");
		l1.addKeyListener(new MyKeyListener());

		p1.add(l1);
		setVisible(true);

		l1.setFocusable(true);
		l1.requestFocus();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new LeftKeyFrame();
	}

	class MyKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			JLabel b = (JLabel) e.getSource();

			StringBuffer a = new StringBuffer(b.getText());
			String c;

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {

				a = a.reverse();
				c = a.toString();
				b.setText(c);

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
