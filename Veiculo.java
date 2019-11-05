package transportadora.n2;

public class Veiculo {
	
	private int codigoVeiculo;
	private String placaVeiculo;
	private String nomeVeiculo;
	private String marcaVeiculo;
	private int anoVeiculo;
	
	public Veiculo() {
		
	}

	public int getCodigoVeiculo() {
		return codigoVeiculo;
	}
	public void setCodigoVeiculo(int codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getNomeVeiculo() {
		return nomeVeiculo;
	}
	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}
	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}
	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}
	public int getAnoVeiculo() {
		return anoVeiculo;
	}
	public void setAnoVeiculo(int anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}
	public String toString() {
		return "Ve�culo:\nC�digo do Veiculo = " + codigoVeiculo 
				+ ",\nPlaca do Ve�culo = " + placaVeiculo 
				+ ",\nNome do Ve�culo = " + nomeVeiculo
				+ ",\nMarca do Ve�culo = " + marcaVeiculo
				+ ",\nAno do Ve�culo = " + anoVeiculo + "";
	}
}