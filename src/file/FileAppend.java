package file;

import java.io.*;
import java.util.*;

public class FileAppend {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		String a, b, c;
		int m, n, i;

		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");

		// 1
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		a = s.nextLine();
		FileReader fr = new FileReader(a);

		// 2
		System.out.print("두번째 파일 이름을 입력하세요>>");
		b = s.nextLine();
		FileReader fr2 = new FileReader(b);

		System.out.print("합치는 파일 이름을 입력하세요>>");
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
		System.out.println("프로젝트 폴더 밑에 c.txt 파일에 저장하였습니다.");

	}

}
