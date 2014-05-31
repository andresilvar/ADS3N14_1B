import java.util.Scanner;


public class Programa {
	AVL avl;
	RBT rbt;
	No noAtual;
	
	public Programa()
	{
		avl = Arquivo.carregarAVL();
		rbt = Arquivo.carregarRBT();
		noAtual = avl.raiz;
	}
	
	public void inicio()
	{
		principal();
	}
	
	public void principal()
	{		
		lnMsg("O que deseja fazer?");
		lnMsg("1 - Adicionar contato");
		lnMsg("2 - Remover contato");
		lnMsg("3 - Mostrar �rvore");
		lnMsg("4 - Sair");
		
		int num = (new Scanner(System.in)).nextInt();
		
		switch(num)
		{
		case 1:
			adicionar();
			break;
		case 2:
			remover();
			break;
		case 3:
			mostraArvore();
			break;
		case 4:
			sair();
			break;
		default:
			lnMsg("Digite uma op��o v�lida");
			principal();
			break;
		}
	}
	
	private void mostraArvore()
	{
		avl.mostraArvore();
		rbt.mostraArvore();
		principal();
	}
	
	private void adicionar()
	{
		No novoAVL = new No();
		No novoRBT = new No();
		
		lnMsg("Digite o nome: ");
		String nome = (new Scanner(System.in).nextLine());
		novoAVL.valor.setNome(nome);
		novoRBT.valor.setNome(nome);
		
		lnMsg("Digite o telefone: ");
		String fone = (new Scanner(System.in).nextLine());
		novoAVL.valor.setFone(fone);
		novoRBT.valor.setFone(fone);
		novoRBT.isPreto = false;
		
		novoAVL.codigo = nome;
		novoRBT.codigo = nome;
		
		lnMsg("===============");
		lnMsg("Inserindo AVL...");
		avl.insereAVL(novoAVL);
		lnMsg("AVL inserido!");
		lnMsg("Compara��es: " + avl.comparacoes);
		lnMsg("Rota��es: " + avl.rotacoes);
		lnMsg("===============");
		
		lnMsg("Inserindo RBT...");
		rbt.insereRBT(novoRBT);
		lnMsg("Compara��es: " + rbt.comparacoes);
		lnMsg("Rota��es: " + rbt.rotacoes);
		lnMsg("RBT inserido!");
		lnMsg("===============");
		principal();
	}
	
	private void remover()
	{
		lnMsg("Digite o nome: ");
		String nome = (new Scanner(System.in)).nextLine();
		
		lnMsg("===============");
		lnMsg("Removendo AVL...");
		avl.removeAVL(nome);
		if (avl.removido){
			lnMsg("AVL Removido.");
		}
		else
		{
			lnMsg("Nenhum N� encontrado.");
		}
		lnMsg("Compara��es: " + avl.comparacoes);
		lnMsg("Rota��es: " + avl.rotacoes);
		lnMsg("===============");
		
		lnMsg("===============");
		lnMsg("Removendo RBT...");
		rbt.removeRBT(nome);
		if (avl.removido){
			lnMsg("RBT Removido.");
		}
		else
		{
			lnMsg("Nenhum N� encontrado.");
		}
		lnMsg("Compara��es: " + rbt.comparacoes);
		lnMsg("Rota��es: " + rbt.rotacoes);
		lnMsg("===============");
		
		principal();
	}
	
	private void lnMsg(String msg)
	{
		System.out.println(msg);
	}
	
	private void msg(String msg)
	{
		System.out.print(msg);
	}
	
	private void sair()
	{
		System.exit(0);
	}
}
