package company.team.vision.databaseJava.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class BaseClass {

	public BaseClass (){
		System.out.println("--------------parent class");
		Class aClass = TheClass.class;
		Annotation[] annotations = aClass.getAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}
		
		Method method = null;
		try {
			method = aClass.getMethod("doSomething", null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		annotations = method.getDeclaredAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}
		
		Field field =null;
		try {
			field = aClass.getField("demo");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		annotations = field.getDeclaredAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}
		
		Annotation annotation = field.getAnnotation(MyAnnotation.class);

		if(annotation instanceof MyAnnotation){
		    MyAnnotation myAnnotation = (MyAnnotation) annotation;
		    System.out.println("name 22: " + myAnnotation.name());
		    System.out.println("value 22: " + myAnnotation.value());
		}
	}
	
}
