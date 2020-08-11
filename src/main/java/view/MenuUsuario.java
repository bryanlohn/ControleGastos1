	package view;
	
	import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladorUsuario;
import model.vo.UsuarioVO;
	
	public class MenuUsuario {
		Scanner teclado = new Scanner(System.in);
		
		private static final int OPCAO_MENU_CADASTRAR_USUARIO = 1;
		private static final int OPCAO_MENU_CONSULTAR_USUARIO = 2;
		private static final int OPCAO_MENU_ATUALIZAR_USUARIO = 3;
		private static final int OPCAO_MENU_EXCLUIR_USUARIO = 4;
		private static final int OPCAO_MENU_USUARIO_VOLTAR = 5;
	    
		private static final int OPCAO_MENU_CONSULTAR_TODOS_USUARIOS = 1;
		private static final int OPCAO_MENU_CONSULTAR_UM_USUARIO = 2;
		private static final int OPCAO_MENU_CONSULTAR_USUARIOS_VOLTAR = 3;
		
		public void apresentarMenuUsuario() {
	    int opcao = this.apresentarOpcoesMenu();
	    while(opcao != OPCAO_MENU_USUARIO_VOLTAR) {
			switch(opcao) {
			
				case OPCAO_MENU_CADASTRAR_USUARIO:{
					this.cadastrarUsuario();
					break;
			   }
				case OPCAO_MENU_CONSULTAR_USUARIO: {
					this.consultarUsuario();
					  break;
				}
				case OPCAO_MENU_ATUALIZAR_USUARIO:{
					this.atualizarUsuario();
					break;
				}
				case OPCAO_MENU_EXCLUIR_USUARIO:{
					this.excluirUsuario();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
				}
			opcao = this.apresentarOpcoesMenu();

			/*opcao = this.apresentarOpcoesMenu();*/
		}
			}
			
	
		     
		  private void consultarUsuario() {
			int opcao = this.apresentarOpcoesConsulta();
			ControladorUsuario controladorUsuario = new ControladorUsuario();
			while (opcao != OPCAO_MENU_CONSULTAR_USUARIOS_VOLTAR) {
				switch(opcao) {
					case OPCAO_MENU_CONSULTAR_TODOS_USUARIOS:{
						opcao = OPCAO_MENU_CONSULTAR_USUARIOS_VOLTAR;
						ArrayList<UsuarioVO> listaUsuariosVO = controladorUsuario.consultarTodosUsuariosController();
						System.out.print("\n---------- RESULTADO DA CONSULTA ----------");
						System.out.printf("\n%3s  %-40s  %-15s %-15s \n", "ID", "MOME","CPF","TELEFONE");
						for(int i = 0; i < listaUsuariosVO.size(); i++) {
							System.out.println(listaUsuariosVO.get(i));
							
						}
						break;
					}
					case OPCAO_MENU_CONSULTAR_UM_USUARIO:{
						opcao = OPCAO_MENU_CONSULTAR_USUARIOS_VOLTAR;
						UsuarioVO usuarioVO = new UsuarioVO();
						System.out.println("\nDigite o codigo do Usuário: ");
						usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
						UsuarioVO usuario = controladorUsuario.consultarUsuarioController(usuarioVO);
						System.out.print("\n---------- RESULTADO DA CONSULTA ----------");
						System.out.printf("\n%3s  %-40s  %-15s %-15s %-15s\n", "NOME", "TELEFONE", "CPF", "LOGIN", "SENHA");
						usuario.imprimir();
						break;
					}
                     default:{
                    	 System.out.println("\nOpcão inválida");
                    	 opcao = this.apresentarOpcoesConsulta();
                    	 
					}
				}
			}
			
		}



		private int apresentarOpcoesConsulta() {
			System.out.println("\nInforme o tipo de consulta a ser realizada: ");
			System.out.println(OPCAO_MENU_CONSULTAR_TODOS_USUARIOS + "- Consultar todos os usuarios:");
			System.out.println(OPCAO_MENU_CONSULTAR_UM_USUARIO + "- Consultar um usuario específico:");
			System.out.println(OPCAO_MENU_CONSULTAR_USUARIOS_VOLTAR + " - Voltar");
			System.out.println("Digite opção");
			return Integer.parseInt(teclado.nextLine());
		}



		private void excluirUsuario() {
			  UsuarioVO usuarioVO = new UsuarioVO();
			    
			    System.out.println("\nDigite o codigo do Usuário: ");
				usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
			    
				ControladorUsuario controladorUsuario = new ControladorUsuario();
			    controladorUsuario.excluirUsuarioController(usuarioVO);
		}



		private void atualizarUsuario() {
			    UsuarioVO usuarioVO = new UsuarioVO();
			    
			    System.out.println("\nDigite o codigo do Usuário: ");
				usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				
				System.out.println("\nDigite o nome do Usuário: ");
				usuarioVO.setNome(teclado.nextLine());
				System.out.println("\nDigite o cpf do Usuário: ");
				usuarioVO.setCpf(teclado.nextLine());
				System.out.println("\nDigite o telefone do Usuário: ");
				usuarioVO.setTelefone(teclado.nextLine());
				System.out.println("\nDigite o Login do Usuário: ");
				usuarioVO.setLogin(teclado.nextLine());
				System.out.println("\nDigite a senha do Usuário: ");
				usuarioVO.setSenha(teclado.nextLine());
				
				ControladorUsuario controladorUsuario = new ControladorUsuario();
			    controladorUsuario.atualizarUsuarioController(usuarioVO);
			
		}



		private void cadastrarUsuario() {
			UsuarioVO usuarioVO = new UsuarioVO();
			System.out.println("\nDigite o nome do Usuário: ");
			usuarioVO.setNome(teclado.nextLine());
			System.out.println("\nDigite o cpf do Usuário: ");
			usuarioVO.setCpf(teclado.nextLine());
			System.out.println("\nDigite o telefone do Usuário: ");
			usuarioVO.setTelefone(teclado.nextLine());
			System.out.println("\nDigite o Login do Usuário: ");
			usuarioVO.setLogin(teclado.nextLine());
			System.out.println("\nDigite a senha do Usuário: ");
			usuarioVO.setSenha(teclado.nextLine());
			
			ControladorUsuario controladorUsuario = new ControladorUsuario();
		    controladorUsuario.cadastrarUsuarioController(usuarioVO);
		  }



		private int apresentarOpcoesMenu() {
			  System.out.println("\nControle de Gastos \n------Menu Cadastro de Usuários ------");
			  System.out.println("\nOpções:");
			  System.out.println(OPCAO_MENU_CADASTRAR_USUARIO + " - Cadastrar usuário");
			  System.out.println(OPCAO_MENU_CONSULTAR_USUARIO + " - Consultar usuário");
			  System.out.println(OPCAO_MENU_ATUALIZAR_USUARIO + " - Atualizar Usuário");
			  System.out.println(OPCAO_MENU_EXCLUIR_USUARIO + " - Excluir Usuário");
			  System.out.println(OPCAO_MENU_USUARIO_VOLTAR + " - Voltar");
			  System.out.println("\nDigite a opção:");
				return Integer.parseInt(teclado.nextLine());
			}
	
	       }
			
			
			
		
	
		
