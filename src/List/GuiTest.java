package List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiTest extends JFrame {
	JLabel name,num,tel;
	JTextField nametf,numtf,teltf;
	JPanel p1,p2,p3;
	JButton A,B;
	public GuiTest(){
		setTitle("GUI Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		p1=new JPanel();//�̸�,�й�,����ó
		p1.setLayout(new GridLayout(0,1));
		
		p2=new JPanel();//Ȯ�� ���
		p2.setLayout(new FlowLayout());
		
		p3=new JPanel();//�ؽ�Ʈ�ʵ�
		p3.setLayout(new GridLayout(0,1));
		
		name=new JLabel("�̸�");
		nametf=new JTextField(20);
		p1.add(name);
		p3.add(nametf);
		
		num=new JLabel("�й�");
		numtf=new JTextField(20);
		p1.add(num);
		p3.add(numtf);
		
		tel=new JLabel("����ó");
		teltf=new JTextField("��ǻ���а� ����");
		teltf.setEditable(false);
		p1.add(tel);
		p3.add(teltf);
		
		A=new JButton("Ȯ��");
		A.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.out.println(nametf.getText()+"\t"+numtf.getText());
				
			}
			
		});
		B=new JButton("���");
		B.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				nametf.setText("");
				numtf.setText("");
				
			}
			
		});
		p2.add(A);
		p2.add(B);
		
		
		c.add(p1,BorderLayout.WEST);
		c.add(p2,BorderLayout.SOUTH);
		c.add(p3,BorderLayout.EAST);
		
		
		setSize(300,150);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new GuiTest ();
	}

}
