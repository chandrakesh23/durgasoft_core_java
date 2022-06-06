package pack2;
import pack1.A;
public class B extends A{
	
}

class C extends B{
	public static void main(String[] args) {
//		A a = new A();
//		a.m();//error:The method m() from the type A is not visible
		
//		B b = new B();
//		b.m();//error:The method m() from the type A is not visible
		
		C c = new C();
		c.m();
		
//		A a1 = new B();
//		a1.m();//error:The method m() from the type A is not visible
		
//		B b1 = new C();
//		b1.m();//error:The method m() from the type A is not visible
		
//		A a2 = new C();
//		a2.m();//error:The method m() from the type A is not visible
		
	}
}