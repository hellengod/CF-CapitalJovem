package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import br.com.fiap.model.Usuario;

public class UsuarioDao {

	//classe para manipular Usuario, CRUD, persistir no DB
	//tem os metodos para realizar as operações
	//gravar um Usuario
	//classe - responsabilidade unica Usuario só sabe persistir usuario
	
	private Connection conexao;
	
	public UsuarioDao(Connection conexao) {
		super();
		this.conexao = conexao;
	}

	public void gravarUsuario(Usuario usuario) {
		//preparando o SQL
	    String sql = "INSERT INTO tb_usuario (nome, email, senha, data_nascimento) "
	    		+ "VALUES (?, ?, ?, ?)";
		//classe para enviar as instruções ao banco de dados
		
		try {

		    PreparedStatement ps = conexao.prepareStatement(sql);
		    ps.setString(1, usuario.getNome());
		    ps.setString(2, usuario.getEmail());
		    ps.setString(3, usuario.getSenha());
		    Date data = Date.valueOf(usuario.getDataNascimento());
		    ps.setDate(4, data);

		    ps.execute();
	    ps.close();
		    System.out.println("Registro inserido com sucesso!");
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		
	}
	

	
	public List<Usuario> getAll() {
		String sql = "SELECT * FROM tb_usuario ORDER BY id_usuario";
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			//resultado -> ResultSet
			//mada executar no DB
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario1 = new Usuario();
				usuario1.setIdUsuario(rs.getInt("id_usuario"));
				usuario1.setNome(rs.getString("nome"));
				usuario1.setEmail(rs.getString("email"));
				usuario1.setSenha(rs.getString("senha"));
				Date data = rs.getDate("data_nascimento");
				usuario1.setDataNascimento(data.toLocalDate());
				list.add(usuario1);
				
			}
			ps.close();
		conexao.close();
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
			
		
		
	}
	

	
}
