package _13_java_lang_package;
/*

		String s1=new String("you cannot change me!");
		String s2=new String("you cannot change me!");
		System.out.println(s1==s2);//false
		String s3="you cannot change me!";
		System.out.println(s1==s3);//false
		String s4=new String("you cannot change me!");
		System.out.println(s3==s4);//false
		String s5= "you cannot"+" change me!";// ***important (this operation will be performed at 
											 //  compile time only, because both arguments are compile time constants)
		System.out.println(s3==s5);//true
		String s6= "you cannot";
		String s7= s6+" change me!";// ***important (this operation will be performed at runtime only because atleast one
		                           //  argument is normal variable)
		System.out.println(s3==s7);//false
		final String s8= "you cannot";
		String s9= s8+ " change me!";// ***important (this operation will be performed at compile time only because both
		                            //  arguments are compile time constants)
		System.out.println(s3==s9);//true
		System.out.println(s6== s8);//true


---> Interning Of String Objects
we can use intern() method to get corresponding scp object reference by using heap object
reference.
		or
By using heap object reference if we want to get corresponding scp object reference then 
we should go for intern() method.
example:
		String s1= new String("durga");
		String s2=s1.intern();
		System.out.println(s1==s2);//false
		String s3="durga";
		System.out.println(s2==s3);//true
		
--> If the corresponding scp object is not available then intern() method itself will
create the coreesponding scp object.		

example:
		String s1=new String("durga");
		String s2=s1.concat("soft");
		String s3=s2.intern();
		System.out.println(s2==s3);//true doubt hai isska in video false aaya hai, but abhi true aaya hai
		String s4="durgasoft";
		System.out.println(s3==s4);//true
		
--> Importance of String constant pool

In our program if a string object is repeatedly required , then it is not recommended
to create a separate object for every requirement because it creates peformance and memory
problems.
 Instead of creating a sepaate object for every requirement we have to create only one
object and we can reuse the same object for every requirement so that performance and 
memory utilization will be improved, this thing is possible because of scp. Hence the 
main advantages of scp are memory utilization and performance will be improved.
   But the main problem with scp is, as several references pointing to the same object,
by using one reference if we are trying to change the content then remaining references will
be affected to overcome this problem sun people implemented String objects as immutable
ie, once we create String object we cannot perform any changes in the existing object, if
we are trying to changes then with those changes a new object will be created. Hence scp
is the only reason for immutability of String objects.

FAQ's
1. what is the difference b/w String and StringBuffer?
2. Explain about immutabiliy and mutability with an example?
3. what is the difference b/w 
      String s1= new String("durga"); and
      String s2= "durga";
4. Other than immutability and mutability is any other difference
   b/w String and StringBuffer?
5. what is SCP?
6. what is advantage of SCP?   
7. what is disadvantage of SCP?
8. why SCP like concept is available only for String but not for StringBuffer?
Ans: String is the most commonly used object and hence sun pepole provided special
	memory management for String objects, but StringBuffer is not commonly used
	object and hence special memory management not required for StringBuffer.
9. why String objects are immutable where as StringBuffer objects are mutable?
Ans: In the case of String because of scp a single object can be referenced by multiple
	references, by using one reference if we are allowed to change the content in existing
	object then remaining references will be affected to overcome this problem sun
	pepole implemented String objects as immutable. According to this once we create a
	String object we cannot perform any changes in existing object, if we are trying to
	perform any changes with those changes a new object will be created.
	But in StringBuffer there is no concept like scp hence for every requirement a
	separate object will be created. By using one reference if we are trying to change
	content, then there is no effect on remaining references hence immutability concepts
	not required for StringBuffer.
10. In addition to String objects any other objects are immutable in java?
Ans: In addition to String objects all wrapper class objects immutable in java.
11. Is it possible to create our own immutable class?
12. How to create our own immutable class? Explian with an example.
13. Immutable means non-changable where as final means also non-changable.Then what
 	is the difference between final and immutable?
   
   
 */
public class _15_String {
	public static void main(String[] args) {
		
	}
}
