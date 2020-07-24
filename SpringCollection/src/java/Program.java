package java;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/AppConfig.xml");
		List<?> list = ctx.getBean("list", List.class);
		for(Object str : list) {
			System.out.println(str);
		}
	}
}
