package assembler_pass1;
import java.util.*;
import java.util.Queue;


public class roundRobin_prem {

	
    //Driver Code
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no of processes");
		int n=sc.nextInt();
		
		int pid[]=new int[n];
		int at[]=new int[n];
		int bt[]=new int[n];
		int wt[]=new int[n];
		int ct[]=new int[n];
		int tat[]=new int[n];
		int k[]=new int[n];
		int f[]=new int[n];
		int pre[]=new int[n];
		
		Queue<Integer> q = new ArrayDeque<>();
		int tq;
		System.out.println("Enter the Time quauntum");
		tq=sc.nextInt();
		int st=0;
		float avgwt=0,avgta=0;
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter the arrival time for process"+(i+1));
			at[i]=sc.nextInt();
			System.out.println("Enter the bursttime for process "+(i+1));
			bt[i]=sc.nextInt();
			pid[i]=i+1;
			k[i]=bt[i];
			f[i]=0;
			pre[i]=0;
		}
		
		int min=100;
		int idx=0;
		for(int i=0;i<n;i++) {
			if(at[i]<min) {
				min=at[i];
				idx=i;
			}
		}
		st=at[idx];
		q.add(idx);
		pre[idx]=1;
		
		while(true) {
			int i;
			if(q.isEmpty())
				break;
			else {
				i=q.element();
				q.remove();
				
				if(bt[i]>=tq) {
					bt[i]-=tq;
					st+=tq;
				}
				else {
					
					st+=bt[i];
					bt[i]=0;
					
					
				}
				
				if(bt[i]==0) {
					f[i]=1;
					ct[i]=st;
				}
				
			}
			
			// getting the process that arrived till now present time
			
		for(int j=0;j<n;j++) {
			if(at[j]<=st && f[j]==0 && pre[j]==0) {
				
				q.add(j);
				pre[j]=1;
			}
		}
		
		if(bt[i]!=0)
		{
			q.add(i);
		}

		}
		
		
		for(int i=0;i<n;i++) {
			
			tat[i]=ct[i]-at[i];
			wt[i]=tat[i]-k[i];
			avgwt+=wt[i];
			avgta+=tat[i];
			
		}
		
		
		System.out.println("pid\tat\tbt\tct\ttat\twt\t");
		
		for(int i=0;i<n;i++) {
			System.out.println(pid[i]+"\t"+at[i]+"\t"+k[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
			
		
		}
		
		
		System.out.println("average waiting time : "+(avgwt/n));
		
		System.out.println("average turn around time :"+(
				avgta/n));
		
	}

}
