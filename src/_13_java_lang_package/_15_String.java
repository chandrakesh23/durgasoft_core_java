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
		
	last lec 45:32	
 */
public class _15_String {
	public static void main(String[] args) {
		
	}
}
