package assembler_pass1;

import java.util.*;
public class Page_replacement_LRU {
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the frame buffer size");
		int n=sc.nextInt();
		
		int fault=0;
		int hit=0;
		
		int pages[]= {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
		int len=pages.length;
		
		
		HashSet<Integer> s=new HashSet<>(); // current  frames that are in use
		HashMap<Integer,Integer> curr_frame=new HashMap<>();  // position of the frames that are in use
		
		/*The Total  Hit occured is 4.0
The Total miss occurres is 4.0
The Hit Ratio is 0.30769232
The miss Ratio is 0.6923077
*/
		 
		
		
		for(int i=0;i<len;i++) {
			if(s.size()<n) {
				
				if(!s.contains(pages[i])) {
					
					s.add(pages[i]);
					
					
					
					fault++;
				}
				else {
					hit++;
				}
				
				curr_frame.put(pages[i],i);
			}
			else {
                    if(!s.contains(pages[i])) {
                    	  // main algo --->
                    	
                    	int lru=Integer.MAX_VALUE; // to get the  min position of active page and remove it from s 
                    	int val=0;; 
                    	
                    	
                    	Iterator<Integer> it=s.iterator();
                    	
                    	while(it.hasNext()) {
                    		int temp=it.next();
                    		if(curr_frame.get(temp)<lru) {
                    			lru=curr_frame.get(temp);
                    			val=temp;
                    			
                    		}
                    	}
                    	
                    	// removal of that min pos page
                    	s.remove(val);
                    	curr_frame.remove(val);
                    	
                    	s.add(pages[i]);
					
					  fault++;
					  
					  
				 	  // <----
					  
					  
				   }
				   else {
					   hit++;
				  }
				
                    curr_frame.put(pages[i],i);
			}
		}
		System.out.println("The page fault is "+fault);
		System.out.println("The page Hit is "+hit);
		System.out.println("The Hit Ratio is "+((float)hit/(float)len));
		System.out.println("The page fault Ratio is "+((float)fault/(float)len));
		

	}

}
