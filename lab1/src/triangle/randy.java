package triangle;

public class randy {
	public int judgetriangle(double a,double b,double c){
		
		int A = 0;
		if(istriangle(a,b,c)){
			
			if(a == b)
				A++;
			if(b == c)
				A++;
			if(a == c)
				A++;
		}else{
			A = 4;
		}
		
		switch(A)
		{
		case 0: 
			System.out.println("scalene");
			break;
		case 1:
			System.out.println("equilateral");
			break;
		case 3: 
			System.out.println("isosceles");
			break;
		case 4:
			System.out.println("not triangle");
			break;
		}
		return A;
		
	}
	public boolean istriangle(double x,double y, double z){
		
		if( x+y>z && x+z>y && y+z>x){
			return true;
		}else{
			return false;
		}
		
	}
	
}
