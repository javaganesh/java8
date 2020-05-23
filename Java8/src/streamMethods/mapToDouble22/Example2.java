package streamMethods.mapToDouble22;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import streamMethods.Student;

public class Example2 {

	public static void main(String[] args) {
		
		List<Student> list = Student.getListOfStudents();

		DoubleStream newList = list.stream().mapToDouble(x -> Double.valueOf(x.getAge()));
		
		//System.out.println(newList.boxed().collect(Collectors.toList()));

		Map<Double, Long> newData = newList.boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		newData.forEach((k,v) -> System.out.println(k+" "+v));

	}
	

	public static List<Student> getListOfStudents() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Test1", 40));
		list.add(new Student("Test5", 50));
		list.add(new Student("Test3", 30));
		list.add(new Student("Test2", 20));
		list.add(new Student("Test4", 10));
		list.add(new Student("Test4", 10));
		list.add(new Student("Test4", 10));
		return list;
	}


}
