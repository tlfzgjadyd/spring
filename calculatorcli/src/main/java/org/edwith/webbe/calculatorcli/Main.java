package org.edwith.webbe.calculatorcli;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext  applicationContext= new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//이 한줄이 실행되며 ApplicationContext 공장만들기+컴포넌트 스캔이 진행된다
		//발견된 어노테이션들은 빈즈로 만들어지고 ApplicationContext공장이 관리하게된다
		
		CalculatorService calculatorService = (CalculatorService)applicationContext.getBean(CalculatorService.class);
		//객체 뽑아오기
		
		System.out.println(calculatorService.plus(10, 50));
	}
}
