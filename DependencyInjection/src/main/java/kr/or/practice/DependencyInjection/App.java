package kr.or.practice.DependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import spring.di.entity.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=new FileSystemXmlApplicationContext("AppContext.xml");
        Test test1=(Test)ctx.getBean("Test");
        Test test2=(Test)ctx.getBean("Test");
        System.out.println(test1);
        System.out.println(test2);
        //System.out.println(test1==test2);
       // Test test=ctx.getBean("test", Test.class);
       // System.out.println(test);
    }
}
