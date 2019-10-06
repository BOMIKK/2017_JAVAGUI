package List;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame {

	JButton btn1, btn2;
	JTextField tf1, tf2;

	JPanel p1, p2, p3;
	JList<String> strList;
	DefaultListModel model = new DefaultListModel();
	JList list = new JList(model);

	public ListTest() {
		setTitle("리스트 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		// p1에 field,area
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		tf1 = new JTextField(23);// 입력창
		tf1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.addElement(tf1.getText());
				tf1.setText("");
			}
			
		});
		
		p1.add(tf1,BorderLayout.NORTH);
		p1.add(new JScrollPane(list),BorderLayout.CENTER);

		// p2에 결과창,수정,삭제
		p2 = new JPanel();
		tf2 = new JTextField(10);// 결과창
		p2.add(tf2);

		// 리스트 선택 나타내기
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {

				// 목록에서 선택된 값
				String name = (String) list.getSelectedValue();
				tf2.setText(name);

				/*
				 * //목록에서 선택된 인덱스 int index=list.getSelectedIndex();
				 * if(index!=-1){
				 * 
				 * }
				 */

			}

		});
		btn1 = new JButton("수정");
		btn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int n = list.getSelectedIndex();
				model.setElementAt(tf2.getText(), n);
				tf2.setText("");

			}

		});

		btn2 = new JButton("삭제");
		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int n = list.getSelectedIndex();
				model.remove(n);
				tf2.setText("");

			}

		});

		p2.add(btn1);
		p2.add(btn2);

		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ListTest();
	}

}
