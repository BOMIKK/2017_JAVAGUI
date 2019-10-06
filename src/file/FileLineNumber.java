package file;

import java.io.*;
import java.util.*;

public class FileLineNumber {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);

		System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");

		FileReader fr = new FileReader(("c:\\windows\\system.ini"));
		Scanner s2 = new Scanner(fr);

		int i = 0;

		while (s2.hasNext()) {

			String a = s2.nextLine();

			System.out.printf("%4d", ++i);
			System.out.print(": " + a + "\n");

		}
		s2.close();
		fr.close();

	}

}
