package assembler_pass1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Reader_writer_problem {
	
	static Semaphore mutex=new Semaphore(1);
	static Semaphore wrt=new Semaphore(1);
	static String message="hello";
	static int readcount=0;
	static Scanner sc=new Scanner(System.in);
	static boolean flag=true;
	
	
	static public class Writer implements Runnable{
		
		
		public void run() {
			try {
				
				wrt.acquire();
				if(flag==true)
				{
					 message="bye";
					 flag=false;
				}
				else {
					message="Hello";
					 flag=true;
				}
				
				
				 
				System.out.println("WRITER "+Thread.currentThread().getName()+" IS WRITTING "+message);
				Thread.sleep(1500);
				
				System.out.println("WRITER "+Thread.currentThread().getName()+" HAS FINISHED WRITTING ");
				
				wrt.release();
				
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		
			
		}
		
	
	
	
	
	}
	
     
	
	 static public class Reader implements Runnable{
		 
		 
		 
		 public void run() {
				
				
				try {
					
					mutex.acquire();
					readcount++;
					
					if(readcount==1)
						wrt.acquire();
					System.out.println("READER "+Thread.currentThread().getName()+" IS READING "+message);
					Thread.sleep(1500);
					
					mutex.release();
					System.out.println("READER "+Thread.currentThread().getName()+" HAS FINISHED READING "+message);
					mutex.acquire();
					
					readcount--;
					
					if(readcount==0) {
						wrt.release();
					}
					
					
					mutex.release();
					
					
					
					
					
					
				}
				catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			
				
				
				
			}
	  
	 
	 
	 
	 }
	
	
	

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		
		Reader read=new Reader();
		Writer write=new Writer();
		
		Thread r1=new Thread(read);
		r1.setName("READER 1");
		
		Thread r2=new Thread(read);
		r2.setName("READER 2");
		
		Thread r3=new Thread(read);
		r3.setName("READER 3");
		
		
		Thread w1=new Thread(write);
		w1.setName("WRITER 1");
		
		
		Thread w2=new Thread(write);
		w2.setName("WRITER 2");
		
		Thread w3 = new Thread (write);
	      w3.setName ("WRITER 3");
		
		    w1.start();
		   r1.start();
		
		  w2.start();
		  r2.start();
		
		  w3.start();
	         r3.start();
	    
	 		
		
		

	}

}
