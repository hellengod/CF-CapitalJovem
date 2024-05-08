package br.com.fiap;
import br.com.fiap.dao.Conexao;
import br.com.fiap.dao.ContaDao;
import java.time.LocalDate;
import java.util.List;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Conta;
import br.com.fiap.model.Usuario;

public class CapitalJovem {
	
	public static void main (String[] args) {
	
		//USUARIO
		
	Usuario usuario = new Usuario();
	
	usuario.setNome("Hellen");
	usuario.setEmail("hellen@Gmail.com");
	usuario.setSenha("senha528");
	usuario.setDataNascimento(LocalDate.of(2001, 12, 01));
	
	
	
	UsuarioDao usuarioDao = new UsuarioDao(Conexao.abrirConexao());
	System.out.println("Insert Usuario");
		usuarioDao.gravarUsuario(usuario);
		
		System.out.println("Lista usuario");
		List<Usuario> usuario1 = usuarioDao.getAll();
	
		for (Usuario u : usuario1) {
			System.out.println(u);
		}
	
	//CONTA
	
		Conta conta= new Conta();
		conta.setSaldo(10000.0);
		conta.setTipoConta("Poupança");
		ContaDao contaDao = new ContaDao(Conexao.abrirConexao());
		
		System.out.println("Inserir Conta");
		
		contaDao.gravarConta(conta);
	
		System.out.println("Lista Contas");
		
		List<Conta> conta1= contaDao.getAll();
	
		for (Conta c : conta1){
			System.out.println(c);
		}
	
	}
}
