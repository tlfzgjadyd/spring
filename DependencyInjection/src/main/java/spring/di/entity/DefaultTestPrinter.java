package spring.di.entity;

public class DefaultTestPrinter implements TestPrinter {
	private Test test;

	public DefaultTestPrinter(Test test) {
		this.test = test;
	}

	@Override
	public void print() {
		System.out.printf("총점 : %d, 평균 : %.2f\n",  test.tot(),test.avg());
	}
}
