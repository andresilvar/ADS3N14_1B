import java.util.Scanner;


public class MergeSort {

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
	
	private static int[] sortVetor(int[] vetor) {
		if (vetor.length == 1) {
		    return vetor;
		}
		else {
		
		    int[] esquerda = new int[vetor.length/2];
		    System.arraycopy(vetor, 0, esquerda, 0, esquerda.length);

		
		    int[] direita = new int[vetor.length-esquerda.length];
		    System.arraycopy(vetor, esquerda.length, direita, 0, direita.length);
		    
		
		    esquerda = sortVetor(esquerda);
		    direita = sortVetor(direita);

		
		    merge(esquerda, direita, vetor);

		    return vetor;
		    
		}
		
	
		
	}

	private static void merge(int[] esquerda, int[] direita, int[] vetor) {
		int indiceEsquerdo = 0;
		int indiceDireito = 0;
		int vetorIndice = 0;
		
		while (indiceEsquerdo < esquerda.length &&
				indiceDireito < direita.length) {
		    if (esquerda[indiceEsquerdo] < direita[indiceDireito]) {
		    	vetor[vetorIndice] = esquerda[indiceEsquerdo];
		    	indiceEsquerdo++;
		    	swap++;
		    }
		    else {
		    	vetor[vetorIndice] = direita[indiceDireito];
		    	indiceDireito++;
		    }		    
		    vetorIndice++;
		}
		
		int[] resto;
		int indiceResto;
		if (indiceEsquerdo >= esquerda.length) {		    
			resto = direita;
			indiceResto = indiceDireito;
		}
		else {
			resto = esquerda;
			indiceResto = indiceEsquerdo;
		}

		for (int i=indiceResto; i<resto.length; i++) {
			vetor[vetorIndice] = resto[i];
			vetorIndice++;
			comparacao++;
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
	
