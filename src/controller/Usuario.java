package controller;

import java.util.List;

public class Usuario {

	private int id;
	private String nome;
	private String email;
	private String cpf;

	public Usuario(){

	}


	public Usuario(String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}


	public Usuario(int id, String nome, String email, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public List<Usuario> recuperarAll() {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.getLista();
	}
	
	public Usuario retornaUsuario(String id){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.retreave(Integer.parseInt(id));
	}
	
	
	public void cadastrar(){
		UsuarioDAO dao = new UsuarioDAO();
		dao.adiciona(this);
	}
	
	public void excluir(String id){
		UsuarioDAO userdao = new UsuarioDAO();
		userdao.remove(id);
	}
	
	public void atualizar(){
		UsuarioDAO dao = new UsuarioDAO();
		dao.atualizar(this);
	}

	@Override
	public String toString() {
		return "CadastroUsuario [id = "+ id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + "]";
	}

	

}
