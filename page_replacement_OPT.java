package assembler_pass1;
import java.util.*;
public class page_replacement_OPT {
	
	
	
	// to find the optimal value
	static int optimal(int[] pages,int [] frames , int st) {
		
		int fn=frames.length;
		int pn=pages.length;
		
		int res=-1;
		int far=st;
		
		
		for(int i=0;i<fn;i++) {
			int j;
			for(j=st;j<pn;j++) {
				if(frames[i]==pages[j]) {
					
					if(j>far) {
						
						far=j;
						res=i;
						
					}
				break;
				
				}
				
			}
			
			
			// the given pages is not demanded in future
			if(j==pn) {
				return i;
			}
			
		}
		
		// none of the pages demanded in future so replace any i choose first page
		if(res==-1) {
			return 0;
		}
		
		
		return res;  // return the farthest page found till now
		
		/* farthest page means the page which is found in pages[i] in seaching from st and you found it for the first time and it is at longest distance from 
		 the pages which is to be replaced */
	
		
	}
	
	
	
	
	// to search the given page in frame buffer
static boolean  search(int key,int[] arr) {
		
		int sz=arr.length;
		
		for(int i=0;i<sz;i++) {
			if(arr[i]==key)
				return true;
		}
		
		return false;
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the frame buffer size ");
		int n=sc.nextInt();
		
		int pages[]= {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
         int len=pages.length;
		
		int hit=0;
		int miss=0;
		
		int idx=0;
		
		int[] frame=new int[n]; // frame buffer
		
		
		for(int i=0;i<len;i++) {
		
				if(search(pages[i],frame)) {
					hit++;
					continue;
				}
				else {
					if(idx<n) { // space avalaible  in frame buffer
						
						frame[idx++]=pages[i];
						miss++;
					}
					else {
						
						int j=optimal(pages,frame,i+1);
						frame[j]=pages[i];
						miss++;
						
					}
					
				}
				
			
			
		}


		System.out.println("The page fault is "+miss);
		System.out.println("The page Hit is "+hit);
		System.out.println("The Hit Ratio is "+((float)hit/(float)len));
		System.out.println("The page fault Ratio is "+((float)miss/(float)len));
		
		

	}

}
