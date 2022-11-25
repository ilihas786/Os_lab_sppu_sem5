package assembler_pass1;
import java.util.*;
public class page_replacement_FIFO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// page Replacement FIFO
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the frame limit ");
		int n=sc.nextInt();
		HashSet<Integer> s=new HashSet<>(n);
		
		Queue<Integer> q=new LinkedList<>();
		
		
		int pages[]= {4,7,6,1,7,6,1,2,7,2};
		int len=pages.length;
		int page_fault=0;
		int hit=0;
		for(int i=0;i<len;i++) {
			if(s.size()<n) {
				
			if(!s.contains(pages[i])) {
				s.add(pages[i]);
				q.add(pages[i]);
				page_fault++;
			}
			else {
				hit++;
			}
				
			}
			else {
				
				if(!s.contains(pages[i])) {
					int val=q.peek();
					q.poll();
					s.remove(val);
					
					s.add(pages[i]);
					q.add(pages[i]);
					page_fault++;
				}
				else {
					hit++;
				}
				
			}
		}
		
System.out.println("The No of Hit is "+hit);
System.out.println("The No of pagefault is "+page_fault);

System.out.println("The Hit Ratio is "+((float)hit/(float)len));

System.out.println("The pagefault Ratio is "+((float)page_fault/(float)len));

		
		
		
		

	}

}
