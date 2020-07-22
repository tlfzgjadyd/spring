package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ApplicationConfig.class})
@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {
	/*@Autowired
	MyService myService;*/
	@InjectMocks
	MyService myService;
	
	@Mock
	CalculatorService calculatorService;
	
	@Test
	public void execute() throws Exception{
		//given
		int value1=5;
		int value2=10;
		given(calculatorService.plus(anyInt(), anyInt())).willReturn(15);
							//예제와 다르게 given측에도 anyInt를 통해 호출해야만
							//의도한대로 뭔수를 넣든 15란 결과가 나와서 +2해서 리턴되어 17이 나온다
		//when	
		int result= myService.execute(value1, value2);
		
		//then
		verify(calculatorService).plus(anyInt(), anyInt());
		Assert.assertEquals(17, result);
	}

}
