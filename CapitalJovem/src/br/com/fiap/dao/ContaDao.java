package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Conta;


public class ContaDao {
		//classe para manipular Usuario, CRUD, persistir no DB
		//tem os metodos para realizar as operações
		//gravar um Usuario
		//classe - responsabilidade unica Usuario só sabe persistir usuario
		
		private Connection conexao;
		
		public ContaDao(Connection conexao) {
			super();
			this.conexao = conexao;
		}

		public void gravarConta(Conta conta) {
			//preparando o SQL
		    String sql = "INSERT INTO tb_conta (tipo_conta, saldo) "
		    		+ "VALUES (?, ?)";
			//classe para enviar as instruções ao banco de dados
			
		      try {
		            PreparedStatement ps = conexao.prepareStatement(sql);
		            ps.setString(1, conta.getTipoConta());
		            ps.setDouble(2, conta.getSaldo());

		            ps.executeUpdate();
		            ps.close();
				    System.out.println("Registro inserido com sucesso!");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		

		
		public List<Conta> getAll() {
			String sql = "SELECT * FROM tb_conta ORDER BY id_conta";
			
			List<Conta> list = new ArrayList<Conta>();
			
			try {
				PreparedStatement ps = conexao.prepareStatement(sql);
				//resultado -> ResultSet
				//mada executar no DB
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Conta conta1 = new Conta();
					conta1.setIdConta(rs.getInt("id_conta"));
					conta1.setTipoConta(rs.getString("tipo_conta"));
					conta1.setSaldo(rs.getDouble("saldo"));
					
					list.add(conta1);
					
				}
				ps.close();
				conexao.close();
				
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return list;
			
				
			
			
		}
		

		
	}
