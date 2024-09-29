package testscripts.regression;

public class StringDemo1 {

	public static void main(String[] args) {

		String s1="LiveTech";
		String s2="Java";
		System.out.println(s1+s2);
		System.out.println(s1);
		
		StringBuffer sb1= new StringBuffer(s1);
		
		System.out.println(sb1);
		
		sb1.append("python");
		
		System.out.println(sb1);
		
		

	}

}
