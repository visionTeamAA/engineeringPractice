package javautil.collections.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.*;

import javautil.collections.util.PrintIt;

import org.apache.commons.collections.CollectionUtils;
public class SimpleTransformer {
	
	public static void main(String[] args)
	{
	  //basicTransformer();
	  chainedTranformer();
	}
	
	@SuppressWarnings("unchecked")
	private static void basicTransformer(){
		Collection<String> stringOfNumbers = Arrays.asList("001", "002", "003", "004");
		  Collection<Integer> intNums = CollectionUtils.collect(stringOfNumbers, new Transformer() {
		      public Object transform(Object o) {
		          return Integer.valueOf((String) o);
		      }
		  });
		  System.out.println("\nList of number:");
		  CollectionUtils.forAllDo(intNums, PrintIt.getInstance() );
		  
	}
	
	@SuppressWarnings("unchecked")
	private static void chainedTranformer(){
		 Collection<String> stringOfNumbers2 = Arrays.asList("A01", "Z02", "V03", "R04");
		  Transformer[] chainedTransformer = new Transformer[]{
		          new Transformer() {
		              public Object transform(Object o) {
		            	  String s = (String)o;
		            	  s = s.substring(1, s.length());
		                  return s;
		              }
		          },
		          new Transformer() {
		              public Object transform(Object o) {
		            	  return Integer.valueOf((String) o) + 100;
		              }
		          }
		  };
		  
		  List<Integer> intNum2 = (List<Integer>) CollectionUtils.collect(stringOfNumbers2, TransformerUtils.chainedTransformer(chainedTransformer));
		  System.out.println("\nAfter processing:");
		  CollectionUtils.forAllDo(intNum2, PrintIt.getInstance());
	}
}
