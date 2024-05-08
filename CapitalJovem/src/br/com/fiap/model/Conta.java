package br.com.fiap.model;

public class Conta {
	
	private int idConta;
	private String tipoConta;
	private Double saldo;
	private Usuario idUsuario;
	
	public Conta() {
		
	}

	public Conta(int idConta, String tipoConta, Double saldo, Usuario idUsuario) {
		super();
		this.idConta = idConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
		this.idUsuario = idUsuario;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Conta [idConta=" + idConta + ", tipoConta=" + tipoConta + ", saldo=" + saldo + "]";
	}
	
	
	
	
	
}
