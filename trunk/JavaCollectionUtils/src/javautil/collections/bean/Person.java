package javautil.collections.bean;

public class Person {
	private String name;
	private int age;
	private String salutation;
	private String gender;
	private boolean isSingle;
	public Person(String name, int age, String gender, boolean isSingle){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.isSingle = isSingle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isSingle() {
		return isSingle;
	}
	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
	
}
