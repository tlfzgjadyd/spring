package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class})//db관련 설정은 다른 config파일에 빼서 할 수있도록 설정
						//누군가 ApplicationConfig한테서 정보를 읽으려고 접근할때 ApplicationConfig에서
						//db관련 부분은 import를 통해 알아내서 사용자에게 알려준다
						//db관련부분과 사용자 사이의 다리 역할을 하기에 사용자는 DBConfig클래스에 직접 접근하지 않아도됨
@ComponentScan(basePackages= {"kr.or.connect.daoexam.dao"})
		//패키지 끝은 dao인걸로, basePackages={}해서 쓰면 지난시간과 달리 여러개 패키지 쓸 수 있다
public class ApplicationConfig {

}
