package javautil.collections.example;

import java.util.List;

import javautil.collections.bean.Person;
import javautil.collections.util.CommonUtil;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;

public class SimpleClosure {
	public static void main(String[] args) {
		System.out.println("\n Member of Vision Team :");
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		/*CollectionUtils.forAllDo(persons, new Closure() {
			public void execute(Object o) {
				System.out.println(((Person)o).toString());
			}
		});*/
		
		
		buildSalutation(persons);
		
	}

	private static void buildSalutation(List<Person> persons) {
		System.out.println("\n Set Salutation:");
		CollectionUtils.forAllDo(persons, new Closure() {
			public void execute(Object o) {
				Person p = (Person)o;
				if(p.getGender().equalsIgnoreCase("M")) {
					p.setSalutation("Mr");
				} else {
					p.setSalutation("Ms");
				}
			}
		});
		
		CollectionUtils.forAllDo(persons, new Closure() {
			public void execute(Object o) {
				Person p = (Person)o;
				System.out.println(p.getSalutation() + " " + p.toString());
			}
		});
	}
}
