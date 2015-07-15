package company.team.vision.databaseJava.annotations;

@MyAnnotation(name = "someName", value = "Hello World")
public class TheClass extends BaseClass {

	@MyAnnotation(name = "demoField", value = "Field value")
	public String demo = null;

	public TheClass() {
		System.out.println("--------------child Class");
	}

	@MyAnnotation(name = "method annotation", value = "method value annotation")
	public void doSomething() {
	}

	public static void main(String[] args) {
		new TheClass();
	}
}
