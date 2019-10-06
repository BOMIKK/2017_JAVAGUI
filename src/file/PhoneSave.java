package file;

import java.io.*;
import java.util.*;

public class PhoneSave {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("전화번호 입력 프로그램입니다.");

		FileWriter fw = new FileWriter(("c:\\Temp\\phone.txt"));
		while (true) {
			System.out.print("이름 전화번호>>: ");
			String name = s.nextLine();

			if (name.equals("그만"))

				break;

			fw.write(name);
			fw.write("\r\n");
		}
		System.out.println("c:\\Temp\\phone.txt에 저장하였습니다.");
		fw.close();

	}

}
