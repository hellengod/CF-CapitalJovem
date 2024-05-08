package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	//dados para a conexão
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static final String USUARIO = "RM552644";
	private static final String SENHA = "291004";
	
	//Método que retorna uma conexão com o DB
	public static Connection abrirConexao() {
		
		//criar conexão - pode gerar exception
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//pegar conexão - pode gerar exception - add catch
			//URL, USUARIO, SENHA
			
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (ClassNotFoundException e) {

			System.err.println("Erro de Conexão");
			
		} catch (SQLException e) {

			System.err.println("Usuario, senha ou URL invalido");

		}
		return conexao;
		
	}
	
}
