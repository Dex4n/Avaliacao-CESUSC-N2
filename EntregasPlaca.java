package transportadora.n2;

public class EntregasPlaca {

	private double mediaDistancia;
	private double totalDistancia;
	private int quantidadeEntregas;

	public EntregasPlaca() {
		super();
	}

	public double getMediaDistancia() {
		return mediaDistancia;
	}

	public void setMediaDistancia(double mediaDistancia) {
		this.mediaDistancia = mediaDistancia;
	}

	public double getTotalDistancia() {
		return totalDistancia;
	}

	public void setTotalDistancia(double totalDistancia) {
		this.totalDistancia = totalDistancia;
	}

	public int getQuantidadeEntregas() {
		return quantidadeEntregas;
	}

	public void setQuantidadeEntregas(Integer quantidadeEntregas) {
		this.quantidadeEntregas = quantidadeEntregas;
	}
}