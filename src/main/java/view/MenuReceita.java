package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraReceita;
import model.vo.ReceitaVO;

public class MenuReceita {
	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA = 4;
	private static final int OPCAO_MENU_USUARIO_VOLTAR = 5;	
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_RECEITAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_RECEITA = 2;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR = 3;

    
	public void apresetarMenuReceita() {
		int opcao = this.apresentarOpcoesMenu();
	    while (opcao != OPCAO_MENU_USUARIO_VOLTAR) {
	    	switch(opcao) {
	    	case OPCAO_MENU_CADASTRAR_RECEITA:{
				this.cadastrarReceita();
				break;
		   }
			case OPCAO_MENU_CONSULTAR_RECEITA: {
				this.consultarReceita();
				  break;
			}
			case OPCAO_MENU_ATUALIZAR_RECEITA:{
				this.atualizarReceita();
				break;
			}
			case OPCAO_MENU_EXCLUIR_RECEITA:{
				this.excluirReceita();
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
				System.out.println("\nControle de Gastos \n----------Menu Controle de Receitas----------");
				System.out.println("\nOpções: ");
				System.out.println(OPCAO_MENU_CADASTRAR_RECEITA + " - Cadastrar Receita");
				System.out.println(OPCAO_MENU_CONSULTAR_RECEITA+ " - Consultar Receita");
				System.out.println(OPCAO_MENU_ATUALIZAR_RECEITA + " - Atualizar Receita");
				System.out.println(OPCAO_MENU_EXCLUIR_RECEITA + " - Excluir Receita");
				System.out.println(OPCAO_MENU_USUARIO_VOLTAR + " - Voltar ");
				System.out.println("\nDigite a opção: ");
				return Integer.parseInt(teclado.nextLine());
				
			}
		
	
	       private void consultarReceita() {
	    	  int opcao = this.apresentarOpcoesConsulta();
	    	  ControladoraReceita controladoraReceita = new ControladoraReceita();
	    	  while(opcao != OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR) {
	    		  switch(opcao) {
	    		       case OPCAO_MENU_CONSULTAR_TODAS_RECEITAS: {
	    		    	   opcao = OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR;
	    		    	   ReceitaVO receitaVO = new ReceitaVO();
	    		    	   System.out.print("\nDigite o código do Usuário: ");
	    		    	   receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
	    		    	   
	    		    	   ArrayList<ReceitaVO> listaReceitasVO = controladoraReceita.consultarTodasReceitasController(receitaVO);
	    		    	   System.out.print("\n----------RESULTADO DA CONSULTA----------");
	    		    	   System.out.printf("\n%3s  %10s  %-30s %-10s %-12s\n", "ID", "IDUSUARIO","DESCRIÇÃO","VALOR","DATA RECEITA");
	    		    	   for (int i =0; i < listaReceitasVO.size(); i ++) {
	    		    		   listaReceitasVO.get(i).imprimir();
	    		    		  
	    		    	   }
	    		    	   break;
	    		       }
	    		       case OPCAO_MENU_CONSULTAR_UMA_RECEITA: {
	    		    	   opcao =  OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR;
	    		    	   ReceitaVO receitaVO = new ReceitaVO();
	    		    	   System.out.print("\nInforme o código da Receita: ");
	    		    	   receitaVO.setId(Integer.parseInt(teclado.nextLine()));
	    		    	   
	    		    	   ReceitaVO receita = controladoraReceita.consultarReceitaController(receitaVO);
	    		    	   System.out.print("\n----------RESULTADO DA CONSULTA----------");
	    		    	   System.out.printf("\n%3s  %10s  %-30s %-10s %-12s\n", "ID", "IDUSUARIO","DESCRIÇÃO","VALOR","DATA RECEITA");
	    		    	   receita.imprimir();
	    		    	   break;
	    		       }
	    		       default: {
	    		    	   System.out.println("\nOpção Inválida");
	    		    	   opcao = this.apresentarOpcoesConsulta();
	    		       }
	    		  }
	    	  }
	    		  }
	    		  private int apresentarOpcoesConsulta() {
	    				System.out.println("\nInforme o tipo de consulta: ");
	    				System.out.println(OPCAO_MENU_CONSULTAR_TODAS_RECEITAS + " - Consultar todas as receitas do usuário");
	    				System.out.println(OPCAO_MENU_CONSULTAR_UMA_RECEITA + " - Consultar uma receita específica");
	    				System.out.println(OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR + " - Voltar");
	    				System.out.println("\nDigite a opção: ");		
	    				return Integer.parseInt(teclado.nextLine());
	    		
	    	  }
	    	  
	    	  private void excluirReceita() {
					ReceitaVO receitaVO = new ReceitaVO();
					System.out.println("\nDigite o código da receita: ");
					receitaVO.setId(Integer.parseInt(teclado.nextLine()));
					
					ControladoraReceita controladorReceita = new ControladoraReceita();
					controladorReceita.excluirReceitaController(receitaVO);
			}
			
			
			private void atualizarReceita() {
				ReceitaVO receitaVO = new ReceitaVO();
				System.out.println("\nDigite o código da receita: ");
				receitaVO.setId(Integer.parseInt(teclado.nextLine()));
				System.out.println("\nDigite o código do usuário: ");
				receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				System.out.println("\nDigite a descriçãoo da receita: ");
				receitaVO.setDescricao(teclado.nextLine());
				System.out.println("\nDigite o valor da receita: ");
				receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
				System.out.println("\nDigite a data da receita: ");
				receitaVO.setDataReceita(LocalDate.parse(teclado.nextLine(), dataFormatter));			
				
				ControladoraReceita controladorReceita = new ControladoraReceita();
				controladorReceita.atualizarReceitaController(receitaVO);
			
			}
			
			
			private void cadastrarReceita() {
				ReceitaVO receitaVO = new ReceitaVO();
				System.out.print("\nDigite o código do usuário da Receita: ");
				receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				System.out.println("\nDigite a descrição da Receita: ");
				receitaVO.setDescricao(teclado.nextLine());
				System.out.println("\nDigite o valor da Receita: ");
				receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
				System.out.println("\nDigite a data da Receita: ");
				receitaVO.setDataReceita(LocalDate.parse(teclado.nextLine(), dataFormatter ));
				
				ControladoraReceita controladorReceita = new ControladoraReceita();
				controladorReceita.cadastrarReceitaController(receitaVO);
			}
			
			}


