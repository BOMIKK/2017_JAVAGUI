package move;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyPlusMinusFrame extends JFrame {

	JPanel p1;
	JLabel l1;

	public KeyPlusMinusFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("+,-키로 폰트 크기 조정");

		setLayout(new FlowLayout());
		setSize(400, 200);

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

		new KeyPlusMinusFrame();
	}

	class MyKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			JLabel b = (JLabel) e.getSource();
			Font f = b.getFont();
			int size = f.getSize();

			if (e.getKeyChar() == '+') {
				b.setFont(new Font("TimesRoman", Font.PLAIN, size + 5));

			} else if (e.getKeyChar() == '-' && !(f.getSize() - 5 <= 5)) {

				b.setFont(new Font("TimesRoman", Font.PLAIN, size - 5));

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
