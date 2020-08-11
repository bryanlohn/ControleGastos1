package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public void cadastrarUsuario(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.existeRegistroPorCpf(usuarioVO.getCpf())) {
			System.out.println("\nUsuário já cadastrado.");
		}else {
			int resultado = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
			if(resultado == 1) {
				System.out.println("\nUsuario cadastrado com sucesso.");
				
			 }else {
				 System.out.println("\nNão foi possível cadastrar o usuário.");
			 }
		}
	}

	public void atualizarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(usuarioDAO.existeRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
			if (resultado == 0 ) {
				System.out.println("\nUsuario atualizado com sucesso.");
			}else {
				System.out.println("\nNão foi possível atualizar o usuário.");
			}
		}else {
			System.out.println("\nNão foi possível atualizar o usuário.");
		}
		
	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(usuarioDAO.existeRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = UsuarioDAO.excluirUsuarioDAO(usuarioVO);
			if(resultado ==1) {
				System.out.println("\nUsuario excluido como sucesso.");
				
			}else {
				System.out.println("\nNão foi possível excluir o usuario.");
			}
		}else {
			System.out.println("não existe na base de dados");
			
		}
		
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> listaUsuariosVO = usuarioDAO.consultarTodosUsuariosDAO();
		if(listaUsuariosVO.isEmpty()) {
			System.out.println("\nLista de usuarios está vazia");
		}
		return listaUsuariosVO;
	}

	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarUsuariosDAO(usuarioVO);
		  if (usuario == null){
			  System.out.println("\nUsuario não localizado.");
		  }
		return usuario;
	}
	/*consultarTodosUsuariosDAO*/
	

}
