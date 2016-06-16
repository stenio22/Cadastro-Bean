package controller;

public class Teste {

	public static void main(String[] args) {
		
		Usuario cad = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		
		cad.setNome("nnnn Henrique");
		cad.setEmail("matheus@matheus");
		cad.setCpf("12345678901");
		dao.adiciona(cad);
		System.out.println(dao.getLista());
		
//		System.out.println(" \n");
//		CadastroUsuario user = dao.retreave(3);
//		user.setEmail("asdasd@asdsad");
//		
//		
//		dao.altera(user);
//		System.out.println(dao.getLista());
//
//		
//		dao.remove(user);
//		System.out.println(" \n ");
//		System.out.println(dao.getLista());
		
	}

}
