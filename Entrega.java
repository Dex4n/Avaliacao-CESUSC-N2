package transportadora.n2;

public class Entrega {
	
	private int codigoEntrega;
	private String descricaoProduto;
	private String descricaoDestino;
	private Double distanciaEntrega;
	private String placaVeiculo;
	
	public Entrega() {
		
	}

	public int getCodigoEntrega() {
		return codigoEntrega;
	}
	public void setCodigoEntrega(int codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public String getDescricaoDestino() {
		return descricaoDestino;
	}
	public void setDescricaoDestino(String descricaoDestino) {
		this.descricaoDestino = descricaoDestino;
	}
	public Double getDistanciaEntrega() {
		return distanciaEntrega;
	}
	public void setDistanciaEntrega(Double distanciaEntrega) {
		this.distanciaEntrega = distanciaEntrega;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String toString() {
		return "CadastroEntrega [codigoEntrega=" + codigoEntrega + ", descricaoProduto=" + descricaoProduto
				+ ", descricaoDestino=" + descricaoDestino + ", distanciaEntrega=" + distanciaEntrega
				+ ", placaVeiculo=" + placaVeiculo + "]";
	}
}