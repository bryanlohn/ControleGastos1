package view;

import java.util.Scanner;

public class Menu {
	
	Scanner teclado = new Scanner(System.in);
	
	
	private static final int OPCAO_MENU_CADASTRO = 1;
	private static final int OPCAO_MENU_RELATORIO = 2;
	private static final int OPCAO_MENU_SAIR = 3;

	public void apresentarMenu() {
		
		int opcao = this.apresentarOpcoesMenu();
		while(opcao != OPCAO_MENU_SAIR) {
			switch(opcao) {
			case OPCAO_MENU_CADASTRO:{
				//System.out.println("Menu cadastro");
				MenuCadastro menuCadastro = new MenuCadastro();
				menuCadastro.apresentarMenuCadastro();
				break;
			}
			case OPCAO_MENU_RELATORIO: {
				//System.out.println("Menu Relatorio");
				MenuRelatorio menuRelatorio = new MenuRelatorio();
				menuRelatorio.apresentarMenuRelatrorio();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
			}
		}
			opcao = this.apresentarOpcoesMenu();
		}
		
	}

	private int apresentarOpcoesMenu() {
		System.out.println("Controle de Gastos");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRO +" - Cadastros");
		System.out.println(OPCAO_MENU_RELATORIO +" - Relatórios");
		System.out.println(OPCAO_MENU_SAIR +" - Sair");
		System.out.print("\nDigite a opção: ");
		//retorna opção que digitar para o metodo, assim atribuindo a opcao
		return Integer.parseInt(teclado.nextLine());
	}

}
