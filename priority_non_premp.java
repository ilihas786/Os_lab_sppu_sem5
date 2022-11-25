package assembler_pass1;

import java.io.*;
import java.util.*;

public class priority_non_premp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter the No of Processes ");
		n=sc.nextInt();
		
		// highest priority is given for lower priority entry
		
		int at[]=new int[n];
		int bt[]=new int[n];
		int ct[]=new int[n];
		int f[]=new int[n];
	    int pr[]=new int[n];
		int pid[]=new int[n];
		int tat[]=new int[n];
		int wt[]=new int[n];
		
		int tot=0;
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter the arrival time for processes "+(i+1));
			at[i]=sc.nextInt();
			
			System.out.println("Enter the burst time for processes "+(i+1));
			bt[i]=sc.nextInt();
			
			System.out.println("Enter the priority for the  processes "+(i+1));
			pr[i]=sc.nextInt();
			
			f[i]=0;
			
			
			pid[i]=i+1;
					
		}
		
		int st=0;
		
		while(true) {
			
			if(tot==n)
				break;
			
			int idx=-1,min=99;
			
			for(int i=0;i<n;i++) {
				if((at[i]<=st) && (f[i]==0) && (pr[i]<min)) {
					idx=i;
					min=pr[i];
				}
			}
			
			if(idx==-1) {
				st++;
			}
			else {
				
				st+=bt[idx];
				ct[idx]=st;
				
				
					
					f[idx]=1;
					tot++;
				
			}
			
			
			
		}
		
		float avg_wt=0;
		float avg_tat=0;
		
		for(int i=0;i<n;i++) {
			tat[i]=ct[i]-at[i];
			wt[i]=tat[i]-bt[i];
			
			avg_tat+=tat[i];
			avg_wt+=wt[i];
			
		}
		
		
		System.out.println("pid\tpri\tat\tbt\tct\ttat\twt");
		
		for(int i=0;i<n;i++) {
			System.out.println(pid[i]+"\t"+pr[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
		
		}

		
		System.out.println("The Average waiting time is "+(avg_wt/n));
		
		System.out.println("The Average turn arounnd  time is "+(avg_tat/n));
	
		

	}

}
