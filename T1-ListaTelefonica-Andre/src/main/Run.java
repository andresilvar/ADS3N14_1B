package main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import models.Agenda;
import models.Pessoa;


public class Run {

	private static Scanner scan;
	
	public static String caminhoArquivo = "C:\\Users\\631210008\\Desktop\\Workspace\\T1-ListaTelefonica-Andre\\src\\numeros.txt";
	
	public static void main(String[] args){

		Agenda agenda = new Agenda();
		int op;
		
		Run.readFile(agenda);
		Run.scan = new Scanner(System.in);
		Run.printComandos();
		op = Run.getOp();
		
		while(op != 7){
			
			switch(op){
				case 1:
					Pessoa p2 = Run.inserirPessoa();
					agenda.insertPessoa(p2);
					Run.writeFile(p2);
					break;
				case 2:
					agenda.printList();
					break;
				case 3:
					agenda.listByChar(Run.getTermoBusca());
					break;
				case 4:
					agenda.next();
					Pessoa p = agenda.getContatoAtual();
					if(p != null){
						System.out.println(p);
					} else {
						System.out.println("Nenhum contato na lista");
					}
					break;
				case 5:
					agenda.prev();
					Pessoa p1 = agenda.getContatoAtual();
					if(p1 != null){
						System.out.println(p1);
					} else {
						System.out.println("Nenhum contato na lista");
					}
					break;
				//TENTATIVA DE CRIAR O CASE EXCLUSÃO	
				case 6:
					Pessoa p3 = Run.excluirPessoa();
					agenda.excluir();
					Run.writeFile(p3);
					
										
					break;
				default:
					System.out.println("Comando invalido.");
					break;
			}
			
			Run.printComandos();
			op = Run.getOp();
		}
		
		scan.close();
	}
	
	public static void printComandos(){
		System.out.println("DIGITE A OPÇÃO DESEJADA\n" +
				"1 - INSERIR CONTATO.\n" +
				"2 - LISTAR CONTATOS.\n" +
				"3 - PROCURAR CONTATO PELA LETRA INICIAL.\n" +
				"4 - PROXIMO CONTATO.\n" +
				"5 - ANTERIOR CONTATO.\n" +
				"6 - EXCLUIR CONTATO.\n" +
				"7 - FECHAR PROGRAMA.\n");
	}
	
	public static int getOp(){
		
		int retorno = 0;
		
		String op = Run.scan.next();
		
		if(op.equalsIgnoreCase("1")){
			retorno = 1;
		} else if (op.equalsIgnoreCase("2")){
			retorno = 2;
		} else if (op.equalsIgnoreCase("3")){
			retorno = 3;
		} else if (op.equalsIgnoreCase("4")){
			retorno = 4;
		} else if (op.equalsIgnoreCase("5")){
			retorno = 5;
		} else if (op.equalsIgnoreCase("6")){
			retorno = 6;
		} else if (op.equalsIgnoreCase("7")){
			retorno = 7;
		}
				
		return retorno;
	}
	
	
	public static Pessoa inserirPessoa(){
		Pessoa p = new Pessoa();
		System.out.print("Digite o nome: ");
		String nome = Run.scan.next();
		p.setNome(nome);
		
		System.out.print("Digite o telefone: ");
		String telefone = Run.scan.next();
		p.setTelefone(telefone);
		
		
		return p;
	}
	
	//TENTATIVA DE CRIAÇÃO DA CLASSE EXCLUIR PESSOA
	public static Pessoa excluirPessoa(){
		Pessoa p3 = new Pessoa();
		System.out.print("Digite o nome: ");
		p3.getNome().replace(null, null);
		return p3;
	}
	
	public static String getTermoBusca(){
		System.out.print("Insira a letra por qual deseja procurar: ");
		String termo = Run.scan.next();
		return termo;
	}
	
	
	
	
	
	
	
	public static void readFile(Agenda agenda){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Run.caminhoArquivo));
			
			String nome;
			String telefone;
			
			while (reader.ready()) {
				nome = reader.readLine();
				telefone = reader.readLine();
				Pessoa p = new Pessoa(nome,telefone);
				agenda.insertPessoa(p);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void writeFile(Pessoa p){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Run.caminhoArquivo,true));
			writer.newLine();
			writer.write(p.getNome());
			writer.newLine();
			writer.write(p.getTelefone());
			writer.flush();
			writer.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
