package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.UsuarioVO;

public class UsuarioDAO {

	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT cpf FROM usuario WHERE cpf = '" + cpf + "' ";
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Usuario por cpf");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "INSERT INTO usuario (nome, cpf, telefone, login, senha)"
				+ "VALUES('" + usuarioVO.getNome() + "', '"
				+ usuarioVO.getCpf() + "', '"
				+ usuarioVO.getTelefone() + "', '"
				+ usuarioVO.getLogin() + "', '"
				+ usuarioVO.getSenha() + "')";
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
            System.out.println("Erro ao executar a query de cadastro do Usuario");
            
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		return resultado;
	}

	public boolean existeRegistroPorIdUsuario(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idUsuario FROM usuario WHERE idUsuario = " + idUsuario;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro o executar a query que verifica a existencia do usuario por ID");
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		/*int resultado = 0;*/
		
		String query = "UPDATE usuario SET nome = '" + usuarioVO.getNome() 
        + "', cpf = '" + usuarioVO.getCpf()
        + "', telefone = '" + usuarioVO.getTelefone()
        + "', login = '" + usuarioVO.getLogin()
        + "', senha = '" + usuarioVO.getSenha()
        + "' WHERE idusuario = " + usuarioVO.getIdUsuario();
		
	try {
		int resultado = stmt.executeUpdate(query);
	} catch (SQLException e) {
		System.out.println("Erro ao executar a query de atualização do usuario");
		System.out.println("Erro: " + e.getMessage());
		e.printStackTrace();
	}finally {
		Banco.closeStatement(stmt);
	    Banco.closeConnection(conn);
	}
		return 0;
	}

	public static int excluirUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "DELETE FROM usuario WHERE idusuario = " + usuarioVO.getIdUsuario();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de exclusão do Usuario.");
			System.out.println("Erro: " + e.getMessage());
	
		} finally {
			Banco.closeStatement(stmt);
		    Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		ArrayList<UsuarioVO> listaUsuariosVO = new ArrayList<UsuarioVO>();
		
		String query = "SELECT idusuario, nome, cpf, telefone, login, senha FROM usuario";
		
		try {
			resultado = stmt.executeQuery(query);
		    while(resultado.next()) {
		    	UsuarioVO usuario = new UsuarioVO();
		    	usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
		    	usuario.setNome(resultado.getString(2));
		    	usuario.setCpf(resultado.getString(3));
		    	usuario.setTelefone(resultado.getString(4));
		    	usuario.setLogin(resultado.getString(5));
		    	usuario.setSenha(resultado.getString(6));
		    	listaUsuariosVO.add(usuario);
		    }
		
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de todos usuários.");
			System.out.println("Erro: " + e.getMessage());
			
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaUsuariosVO;
	}

	public UsuarioVO consultarUsuariosDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVO usuario = null;
		
		String query = "SELECT idusuario, nome, cpf, telefone, login, senha FROM usuario WHERE idusuario = " + usuarioVO.getIdUsuario();
		
		try {
			resultado = stmt.executeQuery(query);
		    while(resultado.next()) {
		    	usuario = new UsuarioVO();
		    	usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
		    	usuario.setNome(resultado.getString(2));
		    	usuario.setCpf(resultado.getString(3));
		    	usuario.setTelefone(resultado.getString(4));
		    	usuario.setLogin(resultado.getString(5));
		    	usuario.setSenha(resultado.getString(6));
		    	
		    }
		
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de um usuário específico.");
			System.out.println("Erro: " + e.getMessage());
			
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

}
