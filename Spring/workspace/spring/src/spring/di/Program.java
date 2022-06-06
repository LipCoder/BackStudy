package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		Exam exam = new NewlecExam();
		//ExamConsole console = new InlineExamConsole(exam);	// DI를 직접했음(이러면 코드를 수정해야함)
		//ExamConsole console = new GridExamConsole(exam);		// 이제 이러한 작업을 스프링이 대신 해줄것이다.
		
		// 이것을 설정으로 빼자!
		// 스프링에게 지시하는 방법으로 코드를 변경
		/* 
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		*/
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		//ExamConsole console = (ExamConsole)context.getBean("console");
		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		
	}

}
