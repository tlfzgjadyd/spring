package spring.di.entity;

public class GridTestPrinter implements TestPrinter {

	private Test test;
	public void setTest(Test test) {
		this.test=test;
	}
	@Override
	public void print() {
		System.out.println("------------------");
		System.out.printf("총점 : %d\n", test.tot());
		System.out.println("-------------------");
		System.out.printf("평균: %.2f",  test.avg());
		System.out.println("-------------------");
	}
}
