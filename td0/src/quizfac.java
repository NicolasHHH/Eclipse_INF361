
public class quizfac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a=false;
		boolean b=false;
		System.out.println(!a&&a);
		a=true;
		System.out.println(!a&&a);
		
		a=true;
		b=true;
		System.out.println( !(a||b)!=!a&&!b );
		
		a=true;
		b=false;
		System.out.println( !(a||b)!=!a&&!b );
		
		a=false;
		b=false;
		System.out.println( !(a||b)!=!a&&!b );
		
		a=false;
		b=true;
		System.out.println( !(a||b)!=!a&&!b );
		
		System.out.println(1.0/0);
		
		
		
		
		
		a=true;
		b=true;
		System.out.println(( !(a&&b)==!a||!b ) );
		
		a=true;
		b=false;
		System.out.println(( !(a&&b)==!a||!b ));
		
		a=false;
		b=false;
		System.out.println( ( !(a&&b)==!a||!b ) );
		
		a=false;
		b=true;
		System.out.println( ( !(a&&b)==!a||!b ) );
		 int x = 1, y = 1;                                                             
		 x = ++x;                                                                      
		 y = y++;                                                                      
		 System.out.println(x+" "+y);  
		 a=false;
		 b=false;
		 boolean c=false;
		 System.out.println( a||b&&c);
	}

}
