package graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageTest extends JFrame {
	public ImageTest() {

		setTitle("그래픽 이미지 연습");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		MyPanel panel = new MyPanel();
		c.add(panel, BorderLayout.CENTER);

		setVisible(true);
	}

	class MyPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("img/back.jpg");
			Image img = icon.getImage();
			
			int iw=img.getWidth(this);
			int ih=img.getHeight(this);
			int pw=this.getWidth();
			int ph=this.getHeight();
			//1
			g.drawImage(img, 0, 0,pw/2-5,ph/2-5,
					0,0,iw/2,ih/2, this);
			//4
			g.drawImage(img, pw/2+5,ph/2+5,pw,ph,
				  iw/2,ih/2,iw,ih, this);
			//2
			g.drawImage(img, pw/2+5,0 ,pw,ph/2-5,
					iw,0,iw/2,ih/2, this);
			//3
			g.drawImage(img, 0,ph/2+5 ,pw/2-5,ph,
					0,ih/2+5,iw/2-5,ih, this);
			
			

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ImageTest();
	}

}
