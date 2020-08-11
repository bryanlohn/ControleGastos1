package controller;

import java.util.ArrayList;

import model.bo.UsuarioBO;
import model.vo.UsuarioVO;

public class ControladorUsuario {
    //o usuarioVO tem todos os dados da classe crada no MenuUsuario
	public void cadastrarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.cadastrarUsuario(usuarioVO);
		
	}

	public void atualizarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.atualizarUsuarioBO(usuarioVO);
		
	}

	public void excluirUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.excluirUsuarioBO(usuarioVO);		
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosController() {
		UsuarioBO usuarioBO = new UsuarioBO();	
		return usuarioBO.consultarTodosUsuariosBO();
	}

	public UsuarioVO consultarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();	
		return usuarioBO.consultarUsuarioBO(usuarioVO);
	}
	
	

}
