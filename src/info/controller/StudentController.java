package info.controller;

import java.util.*;

import info.VO.StudentDAO;
import info.VO.StudentVO;
import info.view.StudentView;

public class StudentController {
	//콘솔창에서 입력받은 학생정보를 사용하여 
	public static final int CONTINUE = 1;
	public static final int BREAK = 0;
	//여러 학생 정보(동적 인원수)를 입력받기 위해서 ArrayList 객체 생성
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<Integer> stuId= new ArrayList<Integer>();
	ArrayList<Integer> grade = new ArrayList<Integer>();
	ArrayList<String> major = new ArrayList<String>();
	ArrayList<String> mobile = new ArrayList<String>();
	
	//콘솔창에서 입력받은 학생정보를 사용하여 각각의 ArrayList에 저장해둔다
	public void ConsoleToList() {
		Scanner sc_s = new Scanner(System.in); //문자열 입력용
		Scanner sc_i = new Scanner(System.in); //숫자 입력용
		int flag = CONTINUE;
		
		
		while(true) {
			if(flag == CONTINUE) {
				System.out.print("이름을 입력해주세요 >>");
				name.add(sc_s.nextLine());
				System.out.print("학번을 입력해주세요 >>");
				stuId.add(sc_i.nextInt());
				System.out.print("학년을 입력해주세요 >>");
				grade.add(sc_i.nextInt());
				System.out.print("학과를 입력해주세요 >>");
				major.add(sc_s.nextLine());
				System.out.print("전화번호를 입력해주세요 >>");
				mobile.add(sc_s.nextLine());
				
			}else if(flag == BREAK) {
				break;
			}
			System.out.println("==============================");
			System.out.print("계속 입력하시겠습니까?(중지:0 계속:1)>>");
			flag = sc_i.nextInt();
			System.out.println("==============================");
		}
		//스캐너 클로즈
		sc_s.close();
		sc_i.close();
	}
	
	//StudentVO객체를 생성하고 생성된 StudentVO객체를 StudentDAO 객체의 insert 메서드를 이용해서 ArrayList에 저장한다.
	public void voToDAO(StudentDAO dao) {
		for(int i = 0; i<name.size(); i++) {
			StudentVO svo = new StudentVO(name.get(i),stuId.get(i),grade.get(i),major.get(i),mobile.get(i));
			dao.insert(svo);
		}
	}
	
	public static void main(String[] args) {
		StudentController controller = new StudentController();
		//콘솔창에서 입력 받은 값을 각각의 정보를 저장하는 ArrayList에 저장하는 메서드
		controller.ConsoleToList();
		//입력받은 값들을 사용하여 StudentVO 객체를 생성하여 DAO의 ArrayList에 저장하는 메서드
		StudentDAO dao = new StudentDAO();
		controller.voToDAO(dao);
		StudentView sView = new StudentView();
		sView.view(dao.select());
	}

}
