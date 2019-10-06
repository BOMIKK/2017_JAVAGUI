package file;

import java.io.*;
import java.util.*;

public class PhoneOpen {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("c:\\Temp\\phone.txt를 출력합니다.");

		FileReader fr = new FileReader(("c:\\Temp\\phone.txt"));
		
		int c;
		while ((c=fr.read()) != -1) {
			System.out.print((char) c);
			
		}
		fr.close();
		
	
	}

}
