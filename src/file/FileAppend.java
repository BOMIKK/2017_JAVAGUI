package file;

import java.io.*;
import java.util.*;

public class FileAppend {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		String a, b, c;
		int m, n, i;

		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");

		// 1
		System.out.print("ù��° ���� �̸��� �Է��ϼ���>>");
		a = s.nextLine();
		FileReader fr = new FileReader(a);

		// 2
		System.out.print("�ι�° ���� �̸��� �Է��ϼ���>>");
		b = s.nextLine();
		FileReader fr2 = new FileReader(b);

		System.out.print("��ġ�� ���� �̸��� �Է��ϼ���>>");
		c = s.nextLine();

		FileWriter fw = new FileWriter(c);

		while ((m = fr.read()) != -1) {
			fw.write(((char) m));
			
		}
		fw.write("\n");
		while ((n = fr2.read()) != -1) 
		{
			fw.write(((char) n));
			
		}
		fr.close();
		fr2.close();
		fw.close();
		System.out.println("������Ʈ ���� �ؿ� c.txt ���Ͽ� �����Ͽ����ϴ�.");

	}

}
