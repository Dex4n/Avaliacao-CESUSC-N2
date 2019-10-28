package transportadora.n2;

public class Veiculo {
	
	private int codigoVeiculo;
	private String placaVeiculo; //(Comparação através do .equals("QHV6984"))
	private String nomeVeiculo;
	private String marcaVeiculo;
	private int anoVeiculo;
	
	private ControleCadastro controleCadastro;
	
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
		return "CadastroVeiculo [codigoVeiculo=" + codigoVeiculo + ", placaVeiculo=" + placaVeiculo + ", nomeVeiculo="
				+ nomeVeiculo + ", marcaVeiculo=" + marcaVeiculo + ", anoVeiculo=" + anoVeiculo + "]";
	}
}