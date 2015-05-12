package javautil.collections.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javautil.collections.bean.Person;

public class CommonUtil {
	public static List<Person> createPersonsFromVisionTeam(){
		List<Person> result = new ArrayList<Person>();
		result.add(new Person("Trung", 26, "M", false));
		result.add(new Person("Khoa", 30, "M", false));
		result.add(new Person("Hang", 29, "F", false));
		result.add(new Person("Vuong", 29, "M", true));
		result.add(new Person("Huong", 24, "M", false));
		result.add(new Person("Cuong", 26, "M", true));
		result.add(new Person("Vinh", 25, "M", true));
		result.add(new Person("Bang", 26, "M", true));
		result.add(new Person("Orell", 36, "M", true));
		result.add(new Person("Mai", 36, "F", false));
		
		return result;
	}
	
	public static List<Person> createPersonsFromHR(){
		List<Person> result = new ArrayList<Person>();
		result.add(new Person("Hieu", 26, "F", false));
		result.add(new Person("Ha", 28, "F", false));
		
		return result;
	}
	
	public static Iterator<Person> createPersonsIterator(){
		List<Person> result = new ArrayList<Person>();
		result.add(new Person("Thomas", 26, "M", false));
		result.add(new Person("Sven", 30, "M", false));
		return result.iterator();
	}
	
	public static Person[] createPersonsArray(){
		Person[] result = new Person[2];
		result[0] = new Person("Thomas", 26, "M", false);
		result[1] = null;
		return result;
	}
}
