package jdbc.basic;

import java.util.Scanner;

import jdbc.quiz.dao.BookDAO;

public class JDBC요구사항 {

	public static void main(String[] args) {

		/*
		 * 회원관리 프로그램, 도서관리, 음악관리, 데이터관리 등등 아무 주제를 선택해서 JDBC프로그램을 작성합니다.
		 * 
		 * 단, 테이블은 5개 이상 관계형 데이터베이스 설계 인터페이스를 반드시 사용합니다.
		 * ArrayList, Map중에 하나이상 반드시 사용합니다.
		 * 메서드는 8개 이상, 짝궁과 협업
		 * 
		 * --주제자유--
		 * 
		 */
		
		BookDAO dao = new BookDAO();
		int result = dao.LateFee();
		System.out.println(result);
		
//		Scanner scan = new Scanner(System.in);
//		while(true) {
//			System.out.println("[1. 로그인, 2. 전체 도서 정보 확인, 3. 개별 도서 확인, 4.랜트 정보 확인, 5.회원 정보 확인, 6. 종료]");
//			System.out.print("메뉴를 선택하세요>");
//			int menu = scan.nextInt();
//			switch (menu) {
//			case 1:
//				dao.ELogin();
//				break;
//			case 2:
//				dao.Tsearch();
//				break;
//			case 3:	
//				dao.Bsearch();
//				break;
//			case 4:
//				dao.RendInfo();
//				break;
//			case 5:
//				dao.Csearch();
//				break;
//			case 6:
//				System.out.println("종료되었습니다.");
//				break;
//			default:
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
//				continue;
//			}
//		}
	}
}
