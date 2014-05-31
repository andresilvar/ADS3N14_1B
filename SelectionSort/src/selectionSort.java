import java.util.Scanner;


public class selectionSort {

	public static int comparacao = 0;
	public static int swap = 0;
	
	public static void main(String[] args) {
		Scanner ObjLer = new Scanner(System.in);
		String resposta;
		do{
		
		int[] vetor = new int[100];
		
		
		gerarRandomNum(vetor);	
		
		
		printVetor(vetor);
		
		
		System.out.println("---------");
		
		
		sortVetor(vetor);
		
		
		printVetor(vetor);
		
		System.out.println("Foram efetuadas " + comparacao + " comparações.");
		System.out.println("E " + swap + " trocas.\n");
		
		System.out.println("Digite 'sim' para repetir...");
	    resposta = ObjLer.next();
	    
		}while (resposta.equalsIgnoreCase("sim"));
 
	}

	private static void sortVetor(int[] vetor) {
		int min;
	    for (int i = 0; i < vetor.length; i++) {	    	
	      
	        min = i;
	        for (int j = i + 1; j < vetor.length; j++) {
	      
	            if (vetor[j] < vetor[min]) {
	      
	                min = j;
	                swap++;
	            }
	            comparacao ++;
	        }
	       
	        if (min != i) {
	       
	            final int temp = vetor[i];
	       
	            vetor[i] = vetor[min];
	       
	            vetor[min] = temp;
	            
	        }	        
	    }
	}

	private static void printVetor(int[] vetor) {
		for(int i=0;i<vetor.length;i++){  
            System.out.println(vetor[i]);  
        }		 
	}

	private static void gerarRandomNum(int[] vetor) {		
		for(int i=0;i<vetor.length;i++){  
            vetor[i] = (int) (1+ (Math.random()*vetor.length));  
        }
	}
}
