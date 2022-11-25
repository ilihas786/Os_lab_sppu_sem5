package assembler_pass1;
import java.io.*;
import java.util.Stack;
public class practical1 {

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
		  

			for(int i=0;i<token.length;i++)
				System.out.println(token[i]);
			
			System.out.println();
	  }
	  else {
			
			
			System.out.println();
			
			// symbol table entry 
			/*
			if(!token[0].equals("")) {
				symtab[symtabline][0]=token[0];
				symtab[symtabline][1]=Integer.toString(LC);
				symtab[symtabline][2]=Integer.toString(1);
				
				symtabline++;
				
				
			}
			 if((token[1].equalsIgnoreCase("DS")) ||( token[1].equalsIgnoreCase("DC")) ) {
				symtab[symtabline][0]=token[0];
				symtab[symtabline][1]=Integer.toString(LC);
				symtab[symtabline][2]=Integer.toString(1);
				
				symtabline++;
			}
			*/
			// literal table entry
			 
			
			for(int i=0;i<token.length;i++) {
				System.out.print(token[i]+);
				
			}
					
					
		while(!st.empty()) {
			System.out.println(st.peek());
			st.pop();
		}
			 
			 
		
			
			
		  
	  }
			
			
			
			
			
		LC++;
		linecount++;	
			
			
		}
		
		
		/// display of symtable and lieral tabel 
		System.out.println("SYMBOL TABLE");
		
		for(int i=0;i<symtabline;i++) {
		
				System.out.println(symtab[i][0]+"\t"+symtab[i][1]+"\t"+symtab[i][2]);
				System.out.println();
			
		}
		System.out.println("LITERAL TABLE");
		for(int i=0;i<littabline;i++) {
			
			System.out.println(littab[i][0]+"\t"+littab[i][1]+"\t"+littab[i][2]);
			System.out.println();
		
	}
		
		
		
		
		buff.close();
		
		
		
		
		
	}

}
