package javautil.collections.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javautil.collections.bean.Person;
import javautil.collections.util.CommonUtil;
import javautil.collections.util.PrintIt;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public class SimplePredicate {
	public static void main(String[] args) {
		
		//filterWithCondition();
		//countByCondition();
		//isExist("Vinhq");
		//findByCondition("Khoa");
		//selectByPredicateCollection();
		//selectByPredicate();
		//selectRejectedByPredicate();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void selectByPredicateCollection() {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		  Collection maleOnly = CollectionUtils.predicatedCollection(new ArrayList<Person>(),
		      new Predicate() {
		          public boolean evaluate(Object o) {
		              Person p = (Person)o;
		              return p.getGender().equalsIgnoreCase("M");
		          }
		      });
		  for (Person person : persons) {
		      try {
		    	  maleOnly.add(person);
		      } catch (IllegalArgumentException e) {
		    	  System.out.println("[" + person + "] is not male");
		      }
		  }
		  System.out.println("\nResults of the male List:");
		  CollectionUtils.forAllDo(maleOnly, PrintIt.getInstance() );
	}
	
	private static void selectByPredicate() {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		  Collection femaleOnly = CollectionUtils.select(persons,
		      new Predicate() {
		          public boolean evaluate(Object o) {
		              Person p = (Person)o;
		              return p.getGender().equalsIgnoreCase("M");
		          }
		      });
	
		  System.out.println("\nResults of the male List:");
		  CollectionUtils.forAllDo(femaleOnly, PrintIt.getInstance() );
	}
	
	private static void selectRejectedByPredicate() {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		  Collection male = CollectionUtils.selectRejected(persons,
		      new Predicate() {
		          public boolean evaluate(Object o) {
		              Person p = (Person)o;
		              return p.getGender().equalsIgnoreCase("M");
		          }
		      });
		  System.out.println("\nResults of the female List:");
		  CollectionUtils.forAllDo(male, PrintIt.getInstance() );
	}
	
	private static void countByCondition(){
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		int numberOfFA = CollectionUtils.countMatches(persons, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Person p = (Person) object;
				return (p.isSingle());
			}
		});
		System.out.println("FA of Vision Team:" + numberOfFA);
		
	}
	
	private static void findByCondition(final String name){
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		Person p = (Person)CollectionUtils.find(persons, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Person p = (Person) object;
				return p.getName().contains(name);
			}
		});
		
		if(p != null) {
			System.out.println("Found " + p.getName() + ":" + p.getAge() + " years old and is " + (p.getGender().equalsIgnoreCase("M")?"Male":"Female"));
		} else {
			System.out.println("Can not find person " + name);
		}
		
	}
	
	private static void isExist(final String name) {
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		boolean isFound = CollectionUtils.exists(persons, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Person p = (Person) object;
				return p.getName().contains(name);
			}
		});
		
		if(isFound) {
			System.out.println("Found person " + name);
		} else {
			System.out.println("Can not find person " + name);
		}
	}
	private static void filterWithCondition() {
		System.out.println("\n Girls of Vision Team :");
		List<Person> persons = CommonUtil.createPersonsFromVisionTeam();
		CollectionUtils.filter(persons, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Person p = (Person) object;
				return (p.getGender().equalsIgnoreCase("F"));
			}
		});
		
		CollectionUtils.forAllDo(persons, PrintIt.getInstance() );
	}
	
}
