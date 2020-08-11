package model.dto;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LancamentoUsuarioDTO {
	
	DecimalFormat df = new DecimalFormat ("0.00");
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private int IdUsuario;
	private String nome;
	private double valor;
	private LocalDate dataInicioPesquisa;
	private LocalDate dataFimPesquisa;
	
	public LancamentoUsuarioDTO(int idUsuario, String nome, double valor, LocalDate dataInicioPesquisa,
			LocalDate dataFimPesquisa) {
		super();
		IdUsuario = idUsuario;
		this.nome = nome;
		this.valor = valor;
		this.dataInicioPesquisa = dataInicioPesquisa;
		this.dataFimPesquisa = dataFimPesquisa;
	}

	public LancamentoUsuarioDTO() {
		super();
	}




	public DecimalFormat getDf() {
		return df;
	}

	public void setDf(DecimalFormat df) {
		this.df = df;
	}

	public DateTimeFormatter getDataFormatter() {
		return dataFormatter;
	}

	public void setDataFormatter(DateTimeFormatter dataFormatter) {
		this.dataFormatter = dataFormatter;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}

	public void setDataInicioPesquisa(LocalDate dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}

	public LocalDate getDataFimPesquisa() {
		return dataFimPesquisa;
	}

	public void setDataFimPesquisa(LocalDate dataFimPesquisa) {
		this.dataFimPesquisa = dataFimPesquisa;
	}

	public void imprimir() {
		System.out.printf("%3d    %-40s    %10s    \n",
				this.getIdUsuario(),
				this.getNome(),
				df.format(this.getValor()));
		
	}

}
