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
		
		p1=new JPanel();//이름,학번,연락처
		p1.setLayout(new GridLayout(0,1));
		
		p2=new JPanel();//확인 취소
		p2.setLayout(new FlowLayout());
		
		p3=new JPanel();//텍스트필드
		p3.setLayout(new GridLayout(0,1));
		
		name=new JLabel("이름");
		nametf=new JTextField(20);
		p1.add(name);
		p3.add(nametf);
		
		num=new JLabel("학번");
		numtf=new JTextField(20);
		p1.add(num);
		p3.add(numtf);
		
		tel=new JLabel("연락처");
		teltf=new JTextField("컴퓨터학과 전공");
		teltf.setEditable(false);
		p1.add(tel);
		p3.add(teltf);
		
		A=new JButton("확인");
		A.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.out.println(nametf.getText()+"\t"+numtf.getText());
				
			}
			
		});
		B=new JButton("취소");
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
