package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		Exam exam = new NewlecExam();
		//ExamConsole console = new InlineExamConsole(exam);	// DI를 직접했음(이러면 코드를 수정해야함)
		ExamConsole console = new GridExamConsole(exam);		// 이제 이러한 작업을 스프링이 해줄것이다.
		console.print();
		
	}

}
