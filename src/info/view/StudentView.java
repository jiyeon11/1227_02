package info.view;

import java.util.ArrayList;
import info.VO.StudentVO;

//화면에 보여주기(출력)를 휘한 객체
public class StudentView {

	//view(ArrayList<StudentVO> svoList) : 화면에 출력을 위한 메서드
	public void view(ArrayList<StudentVO> svoList) {
		for(StudentVO svo : svoList) {
			System.out.print("이름 : " + svo.getName() + "\t");
			System.out.print("학번 : " + svo.getStuId() + "\t");
			System.out.print("학년 : " + svo.getGrade() + "\t");
			System.out.print("학과 : " + svo.getMajor() + "\t");
			System.out.println("전화번호 : " + svo.getMobile());
			System.out.println("==================================================================");
			
		}
	}
}
