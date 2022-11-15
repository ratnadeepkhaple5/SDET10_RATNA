package javapractice;

public class Array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] xarr={5,3,12,15,1,6,2};
		
		int first= 3;
		int second=12;
		
		int firstcount=0;
		int secondcount=0;
		
		int[] yarr=new int[3] ;
		
		for (int i = 0; i < xarr.length; i++) {
			
			if(first==xarr[i]) {
				firstcount++;
				
				yarr[i]=xarr[i];	
				
			//	System.out.println("number present  at index:- "+i);
			}
			if (second==xarr[i]) {
				secondcount++;
				yarr[i+1]=xarr[i];	
			}
		}	
		System.out.println("firstcount:- "+firstcount);
		System.out.println("secondcount:- "+secondcount);
		
		
		if(firstcount==1 && secondcount==1) {
			System.out.println(xarr.length);
		}
		else {
			System.out.println("-1");
		}
	}

}

