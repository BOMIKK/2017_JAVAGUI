package file;

import java.util.*;
import java.io.*;

class Movie implements Serializable {
	String title;
	String director;
	String genre;
	int year;

	public Movie(String t, String d, String g, int y) {
		title = t;
		director = d;
		genre = g;
		year = y;
	}

	public String toString() {
		return "[제목:" + title + ", 감독:" + director + ", 장르:" + genre + ", 개봉년도:" + year + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}

public class MovieTest {

	public static void main(String[] args) throws Exception {
		Vector<Movie> b = new Vector<Movie>();
		Scanner s = new Scanner(System.in);
		int menu = 0;
		while (true) {
			System.out.println("1.영화 입력/2.영화 출력/3.영화 검색/4.파일 저장/5.파일 열기/6.종료");
			System.out.print("메뉴입력>>");
			menu = s.nextInt();
			s.nextLine();
			if (menu == 6)
				break;
			switch (menu) {
			case 1:// 영화 입력
				System.out.print("제목:");
				String t = s.nextLine();
				System.out.print("감독:");
				String d = s.nextLine();
				System.out.print("장르:");
				String g = s.nextLine();
				System.out.print("년도:");
				int y = s.nextInt();

				b.add(new Movie(t, d, g, y));

				break;
			case 2:// 영화 출력
				for (int i = 0; i < b.size(); i++) {
					System.out.println(b.get(i));
				}
				break;
			case 3:// 영화 검색
				System.out.print("검색할 영화 제목 입력:");
				String search = s.nextLine();

				for (int i = 0; i < b.size(); i++) {
					if (search.equals(b.get(i).getTitle()))

						System.out.println(b.get(i));

				}
				break;
			case 4:// 파일 저장
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat"));
				System.out.println("movie.dat에 저장되었습니다.");
				oos.writeObject(b);

				oos.close();

				break;
			case 5:// 파일 열기
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movie.dat"));
				System.out.println("movie.dat로 부터 정보를 불러왔습니다.");
				b = (Vector<Movie>) ois.readObject();

				ois.close();
				break;

			}

		}

	}

}
