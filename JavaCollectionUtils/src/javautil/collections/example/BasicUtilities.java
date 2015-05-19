package javautil.collections.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import javautil.collections.bean.Person;
import javautil.collections.util.CommonUtil;

public class BasicUtilities {
	public static void main(String[] args) {
		//addAll();
		//addIgnoreNull();
		//getByIndex(0);
		//checkCollection();
		//retainAll();
		//disjunction();
		//cardinality();
		///containAny();
		//intersection();
		//substract();123
		union();
	}

	private static void checkCollection() {
		List<Person> persons = null;
		size(persons);
		isEmpty(persons);
		sizeIsEmpty(persons);
	}
	private static void getByIndex(int index) {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		Person p = (Person) CollectionUtils.get(persons, index);
		if(p != null) {
			System.out.println("Person " + p.getName() + ":" + p.getAge() + " years old and is " + (p.getGender().equalsIgnoreCase("M")?"Male":"Female"));
		} 
	}

	private static void sizeIsEmpty(List<Person> persons) {
		try{
			boolean isSizeEmpty = CollectionUtils.sizeIsEmpty(persons);
		System.out.println("This size of list is empty : " + isSizeEmpty);
		} catch (IllegalArgumentException ila) {
			System.out.println("This size of list is empty : " + ila.getClass().getName());
		}
	}

	private static void isEmpty(List<Person> persons) {
		boolean isEmpty = CollectionUtils.isEmpty(persons);
		System.out.println("This list is empty : " + isEmpty);
	}

	private static void size(List<Person> persons) {
		try{
			int size = CollectionUtils.size(persons);
			System.out.println("Size of list is : " + size);
		} catch (IllegalArgumentException ila) {
			System.out.println("Size of list is : " + ila.getClass().getName());
		}
	}

	private static void addAll() {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		printPersons("Old persons", persons);
		Iterator<Person> additonalPersons = CommonUtil.createPersonsIterator();
		CollectionUtils.addAll(persons, additonalPersons);
		printPersons("New person", persons);
	}
	
	private static void retainAll() {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		persons.add(persons.get(7));
		printPersons("Vision Team", persons);
		List<Person> additionalPersons = CommonUtil.createPersonsFromHR();
		additionalPersons.add(persons.get(7));
		//additionalPersons.add(persons.get(7));
		additionalPersons.add(new Person("fff", 22, "F", true));
		printPersons("HR Team", additionalPersons);
		
		Collection newPersons = CollectionUtils.retainAll(persons, additionalPersons);
		printPersons("Same person", new ArrayList<Person>(newPersons));
	}
	
	private static void disjunction() {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		printPersons("Vision Team", persons);
		List<Person> additionalPersons = CommonUtil.createPersonsFromHR();
		additionalPersons.add(persons.get(7));
		printPersons("HR Team", additionalPersons);
		
		Collection newPersons = CollectionUtils.disjunction(persons, additionalPersons);
		printPersons("Different persons", new ArrayList<Person>(newPersons));
	}
	private static void containAny(){
		List<String> carsA = Arrays.asList(new String[] { "Audi", "BMW", "Porsche"});
		List<String> carsB = Arrays.asList(new String[] { "Porsche"});
		printStringList(carsA);
		printStringList(carsB);
		
		boolean containsAny = CollectionUtils.containsAny(carsA, carsB);
		System.out.println("\n\ncontainsAny is "+containsAny+" because there is Porsche in carsA and also carsB list");
	}
	@SuppressWarnings("unchecked")
	private static void intersection(){
		List<String> carsA = Arrays.asList(new String[] { "Audi", "BMW", "Porsche"});
		List<String> carsB = Arrays.asList(new String[] { "Porsche", "111"});
		printStringList(carsA);
		printStringList(carsB);
		Collection<String> res = CollectionUtils.intersection(carsA, carsB);
		System.out.println("\nFind same cars in two list");
		printStringList(new ArrayList<String>(res));
	}
	@SuppressWarnings("unchecked")
	private static void substract(){
		List<String> carsA = Arrays.asList(new String[] { "Audi", "BMW", "Porsche"});
		List<String> carsB = Arrays.asList(new String[] { "Porsche"});
		printStringList(carsA);
		printStringList(carsB);
		//Collection<String> res = CollectionUtils.subtract(carsA, carsB);
		Collection<String> res = CollectionUtils.subtract(carsB, carsA);
		System.out.println("\n Subtract two lists");
		printStringList(new ArrayList<String>(res));
	}
	private static void union(){
		List<String> carsA = Arrays.asList(new String[] { "Audi", "BMW", "Porsche"});
		List<String> carsB = Arrays.asList(new String[] { "Porsche", "Ford"});
		printStringList(carsA);
		printStringList(carsB);
		Collection<String> res = CollectionUtils.union(carsA, carsB);
		System.out.println("\n\nUnion cars in two list");
		printStringList(new ArrayList<String>(res));
	}
	private static void cardinality(){
		List<String> cars = Arrays.asList(new String[] { "Audi", "BMW", "BMW", "Porches", "Aston Martin"});
		printStringList(cars);
		int countOfAudi = CollectionUtils.cardinality("Audi", cars);
		// there is one Audi in carr
		System.out.println("\n\nThere is " + countOfAudi + " Audi in cars");
		 
		int countOfBMW = CollectionUtils.cardinality("BMW", cars);
		System.out.println("There is " + countOfBMW + " BMW in cars");
	}

	private static void printStringList(List<String> cars) {
		System.out.println("\nList of cars:"); 
		for(String s : cars) {
			 System.out.print(s.toString() + ", ");
		 }
	}
	private static void addIgnoreNull() {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		printPersons("Old persons", persons);
		CollectionUtils.addIgnoreNull(persons, new Person("Truc", 22, "M", false));
		CollectionUtils.addIgnoreNull(persons, null);
		printPersons("New person", persons);
	}

	private static void printPersons(String header, List<Person> persons) {
		System.out.println("\n" +header + "(" +persons.size() + ")");
		for(Person p : persons){
			System.out.println(p.toString());
		}
	}
}
