package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO{

	public Connection connection;

	public UsuarioDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}	
	public void adiciona(Usuario cad){
		System.out.println("entrou adiciona");
		String sql = "insert into cadusuario (nome,email,cpf) values(?,?,?)";
		try {
			// Preparando o Statement para inserção de dados
			PreparedStatement stmt = connection.prepareStatement(sql);
			// Seta os Valores
			stmt.setString(1, cad.getNome());
			stmt.setString(2, cad.getEmail());
			stmt.setString(3, cad.getCpf());
			stmt.execute();
			stmt.close();			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void altera(Usuario cad) {
		String sql = "update cadusuario set nome=?, email=?,"+
				"cpf=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cad.getNome());
			stmt.setString(2, cad.getEmail());
			stmt.setString(3, cad.getCpf());
			stmt.setInt(4, cad.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao Alterar");
		}
	}
	

	public void remove(Usuario cad) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cadusuario where id=?");
			stmt.setInt(1, cad.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void remove(String id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cadusuario where id=?");
			stmt.setInt(1, Integer.parseInt(id));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getLista() {
		try {
			List<Usuario> cad = new ArrayList<Usuario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from cadusuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Usuario cadastro = new Usuario();
				cadastro.setId(rs.getInt("id"));
				cadastro.setNome(rs.getString("nome"));
				cadastro.setEmail(rs.getString("email"));
				cadastro.setCpf(rs.getString("cpf"));
				// adicionando o objeto à lista
				cad.add(cadastro);
			}
			rs.close();
			stmt.close();
			return cad;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario retreave(int id) {
		try {
			Usuario cad = new Usuario();
			PreparedStatement stmt = this.connection.prepareStatement("select * from cadusuario where id = "+ id);
			ResultSet rs = stmt.executeQuery();

			rs.next();
			cad.setId(rs.getInt("id"));
			cad.setNome(rs.getString("nome"));
			cad.setEmail(rs.getString("email"));
			cad.setCpf(rs.getString("cpf"));
			rs.close();
			stmt.close();
			return cad;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Usuario user){		
		String sql = "update marcel.cadusuario SET " + "id=?, nome=?, cpf=?, email=? " + "WHERE id=?";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, user.getId());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getCpf());
			stmt.setString(4, user.getEmail());
			stmt.setLong(5, user.getId());
			
			stmt.execute();
			stmt.close();
			System.out.println("Usuário Atualizado");
		}catch(SQLException e){
			System.out.println(e);
		}		
	}
	
	
	public int getLastId() throws SQLException{
		String sql = "SELECT MAX(ID) as id FROM cadusuario";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		int lastId = rs.getInt("id");

			rs.close();
			stmt.close();

			return lastId;
		}
	

}
