package assembler_pass1;
import java.io.*;
import java.util.Stack;
public class newpass1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		FileReader FP = new FileReader("E:\\pass1.txt");
		BufferedReader buff = new BufferedReader(FP);
	int linecount=0;
		int symtabline=0;
		int littabline=0;
		int pooltabline=0;
		int LC=0;
		int op=0;
		Stack < String > st= new Stack();
		String line=null;
		
		
		String[][] symtab=new String[100][3];
			String[] pooltab=new String[100];
			String[][] littab=new String[100][2];
			String[][] optable=new String[100][3];
			int littabaddress=0;
		
		
			while((line=buff.readLine())!=null) {
				String [] token = line.split("\t");
				
				  if(linecount==0) {
					  LC=Integer.parseInt(token[1]);
					  

						
						
						System.out.println();
				  }
				  else {
					  
					  // symbol table entry
					  
						 if(!token[0].equals("")) {
							 symtab[symtabline][0]=token[0];
							 symtab[symtabline][1]=Integer.toString(LC);
							 symtab[symtabline][2]=Integer.toString(1);
							 symtabline++;
						
							 
						 }
						 else if(token[1].equalsIgnoreCase("DS") || token[1].equalsIgnoreCase("DC")) {
							 symtab[symtabline][0]=token[0];
							 symtab[symtabline][1]=Integer.toString(LC);
							 symtab[symtabline][2]=Integer.toString(1);
							 symtabline++;
						
							
						 }
					
							 
							 //literal table entry
								
							  for(int i=0;i<token.length;i++) {
								  
								  if(!token[i].equals("")) {
									  int idx=token[i].indexOf('=');
									 if(idx!=-1) {
										st.push(token[i].substring(idx));
									 }

									  
								  }
								
							  
							  }
							  
						
								  for(int i=0;i<token.length;i++) {
									  
									int idx=token[i].indexOf('L');
									
									if(idx!=-1) {
										while(!st.empty()) {
											 littab[littabline][0]=st.peek();
											 littab[littabline][1]=Integer.toString(LC);
											
											 littabline++;
											 st.pop();
											 LC++;
										}
									}
										 
										  
												
									  
								  }
								  System.out.println() ;
								 
							  
						 
					  
					  
					  
					 
					
					 
						 
					
					  
					  
					  
					  
					  
				  }
				  
				  LC++;
					linecount++;	
						
			}
			
			System.out.println("SYMBOL\tADDRESS\tLENGTH");
			System.out.println("______\t_______\t______");
			for(int i=0;i<symtabline;i++) {
				System.out.println(symtab[i][0]+"\t"+symtab[i][1]+"\t"+symtab[i][2]);
				System.out.println();
			}
			
			// literal table display
			
			System.out.println();
			System.out.println("LITERAL\tADDRESS");
			System.out.println("_______\t_______");
			for(int i=0;i<littabline;i++) {
				System.out.println(littab[i][0]+"\t"+littab[i][1]);
				System.out.println();
			}
			buff.close();
		
		
	}

}
