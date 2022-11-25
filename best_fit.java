package assembler_pass1;

import java.util.Scanner;

public class best_fit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no of process");
		int n=sc.nextInt();
		
		int pid[]=new int[n];
		int psize[]=new int[n];
		int block[]= {100, 500, 200, 300, 600};
		int allocation[]=new int[n];
	
		for(int i=0;i<n;i++) {
			System.out.println("enter the size of process "+(i+1));
			psize[i]=sc.nextInt();
			
			allocation[i]=-1;
			pid[i]=i+1;
			
		}
		int m=block.length;
		
		// main algo
	
		for(int i=0;i<n;i++) {
			
		  int bestidx=-1;
		  
		  for(int j=0;j<m;j++) {
			  if(block[j]>=psize[i]) {
				  
				  if(bestidx==-1)
					  bestidx=j;
				  else if(block[bestidx]>block[j])
					  bestidx=j;
				  
				  
			  }
		  }
		  
		  
		  if(bestidx!=-1) {
			  allocation[i]=bestidx;
			  block[bestidx]-=psize[i];
		  }
			
			
			
			
			
		}
		
		System.out.println("pid"+"\t"+"PSize"+"\t"+"blockno");
		for(int i=0;i<n;i++) {
			if(allocation[i]!=-1) {
				
				System.out.println((i+1)+"\t"+psize[i]+"\t"+(allocation[i]+1));
			}
			else {
				
				System.out.println((i+1)+"\t"+psize[i]+"\t"+"Not allocated");
			}
		}

	}

}
