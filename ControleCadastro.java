package transportadora.n2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ControleCadastro {

	private ArrayList<Veiculo> listaVeiculos;
	private ArrayList<Entrega> listaEntregas;
	private String listaEntregasPlaca;
	private String listagemArquivoVeiculos;
	private String listagemArquivoEntregas;
	private Formatter outputVeiculos;
	private Formatter outputEntregas;
	private Scanner inputVeiculos;
	private Scanner inputEntregas;
	private double totalDistanciaAux;
	private double mediaDistanciaAux;
	private int quantidadeEntregasAux;
	private EntregasPlaca relatorioEntregasPlaca;

	private boolean saoIguais = false;

	public ControleCadastro() {
		super();
		listaEntregas = new ArrayList<Entrega>();
		listaVeiculos = new ArrayList<Veiculo>();
	}

	public void adicionaEntrega(Entrega newEntrega) {
		listaEntregas.add(newEntrega);
	}

	public void adicionaVeiculo(Veiculo newVeiculo) {
		listaVeiculos.add(newVeiculo);
	}

	// Gera o relat�rio de entregas (por placa), junto com a m�dia de dist�ncia das
	// entregas (por placa) e quantidade de entregas (por placa)
	public void gerarListaEntregasPlaca(String placaSolicitada) {

		EntregasPlaca newRelatorioEntregasPlaca = new EntregasPlaca();

		
		this.totalDistanciaAux = 0.0;
		this.quantidadeEntregasAux = 0;
		
		
		for (int i = 0; i < listaEntregas.size(); i++) {
			if (listaEntregas.get(i).getPlacaVeiculo().equals(placaSolicitada)) {
				
				
				

				this.totalDistanciaAux += listaEntregas.get(i).getDistanciaEntrega();
				
				if (this.totalDistanciaAux > 0) {
					this.quantidadeEntregasAux += 1;
				}
				
				
		// Observa��o: 
		// Bug: Como os atributos auxiliarem foram declarados globalmente, o sistema continua incrementando a quantidade de entregas,
		// entretanto, para corre��o do mesmo seria necess�rio declarar os mesmo de forma local, para que o valor atribu�do seja limpo.

				saoIguais = true;
			} else
				saoIguais = false;
		}

		// Procedimento para c�lculo da m�dia de dist�ncia por placa, tendo como base a
		// soma total de dist�ncia das entregas dividido pela quantidade de entregas

		mediaDistanciaAux = totalDistanciaAux / quantidadeEntregasAux;

		newRelatorioEntregasPlaca.setTotalDistancia(totalDistanciaAux);
		newRelatorioEntregasPlaca.setQuantidadeEntregas(quantidadeEntregasAux);
		newRelatorioEntregasPlaca.setMediaDistancia(mediaDistanciaAux);

		if (saoIguais == false) {

			this.listaEntregasPlaca = "Aviso: N�o h� mais que uma entrega cadastrada com esse n�mero de placa: "
					+ placaSolicitada + ".";
		} else {
			this.listaEntregasPlaca = "Placa " + placaSolicitada + ",\n" + "M�dia: "
					+ newRelatorioEntregasPlaca.getMediaDistancia() + " KM de dist�ncia,\n" + "Total de "
					+ newRelatorioEntregasPlaca.getQuantidadeEntregas() + " entregas.";
		}

		setRelatorioEntregasPlaca(newRelatorioEntregasPlaca);
	}

	// Mostra as informa��es da lista de ve�culos (conforme instanciado) no
	// componente de JTABLE da aba de Cadastro de Ve�culos
	public String[][] getListaVeiculos() {
		String[][] matAux = new String[listaVeiculos.size()][3];
		for (int j = 0; j < listaVeiculos.size(); j++) {
			String[] aux = new String[3];
			aux[0] = listaVeiculos.get(j).getCodigoVeiculo() + "";
			aux[1] = listaVeiculos.get(j).getPlacaVeiculo();
			aux[2] = listaVeiculos.get(j).getNomeVeiculo();
			matAux[j] = aux;
		}
		return matAux;
	}

	// Mostra as informa��es da lista de entregas (conforme instanciado) no
	// componente de JTABLE da aba de Cadastro de Entregas
	public String[][] getListaEntregas() {
		String[][] matAux = new String[listaEntregas.size()][3];
		for (int j = 0; j < listaEntregas.size(); j++) {
			String[] aux = new String[3];
			aux[0] = listaEntregas.get(j).getCodigoEntrega() + "";
			aux[1] = listaEntregas.get(j).getDescricaoProduto();
			aux[2] = listaEntregas.get(j).getPlacaVeiculo();
			matAux[j] = aux;
		}
		return matAux;
	}

	// Indica que o arquivo de ve�culos vai ser aberto
	public void openFileVeiculos(int modo) {
		try {
			switch (modo) {
			case 0: {
				FileWriter f;
				f = new FileWriter("ListaDeVe�culos.txt", true);
				outputVeiculos = new Formatter(f);
			}
			case 1:
				inputVeiculos = new Scanner(new File("ListaDeVe�culos.txt"));
			}
		} catch (SecurityException securityException) {
			System.err.println("O usu�rio n�o pode acessar o arquivo de ve�culos.");
			System.exit(1);
		} catch (FileNotFoundException filesNotFoundException) {
			System.err.println("N�o foi poss�vel criar o arquivo de ve�culos.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // Final do m�todo openFileVeiculos

	public void openFileEntregas(int modo) {
		try {
			switch (modo) {
			case 0: {
				FileWriter f;
				f = new FileWriter("ListaDeEntregas.txt", true);
				outputEntregas = new Formatter(f);
			}
			case 1:
				inputEntregas = new Scanner(new File("ListaDeEntregas.txt"));
			}
		} catch (SecurityException securityException) {
			System.err.println("O usu�rio n�o pode acessar o arquivo de entregas.");
			System.exit(1);
		} catch (FileNotFoundException filesNotFoundException) {
			System.err.println("N�o foi poss�vel criar o arquivo de entregas.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // Final do m�todo openFileEntregas

	// Adiciona os registros para o arquivo de ve�culos
	public void addRecordsVeiculos(Veiculo registroVeiculo) {
		try {
			outputVeiculos.format("%d %s %s %s %d \n", registroVeiculo.getCodigoVeiculo(),
					registroVeiculo.getPlacaVeiculo(), registroVeiculo.getNomeVeiculo(),
					registroVeiculo.getMarcaVeiculo(), registroVeiculo.getAnoVeiculo());
			JOptionPane.showMessageDialog(null, "Listagem de ve�culos salvo em arquivo com sucesso!");

		} catch (FormatterClosedException formatterClosedException) {
			System.err.println("Erro ao escrever no arquivo de ve�culos.");
			return;
		}
	} // Fim do m�todo addRecordsVeiculo

	// Adiciona os registros para o arquivo de entregas
	public void addRecordsEntregas(Entrega registroEntrega) {
		try {
			outputEntregas.format("%d %s %s %.2f %s \n", registroEntrega.getCodigoEntrega(),
					registroEntrega.getDescricaoProduto(), registroEntrega.getDescricaoDestino(),
					registroEntrega.getDistanciaEntrega(), registroEntrega.getPlacaVeiculo());
			JOptionPane.showMessageDialog(null, "Listagem de entregas salvo em arquivo com sucesso!");

		} catch (FormatterClosedException formatterClosedException) {
			System.err.println("Erro ao escrever no arquivo de entregas.");
			return;
		}
	} // Fim do m�todo addRecordsEntregas

	public ArrayList<Veiculo> readRecordsVeiculos() {
		// Cria o objeto que vai retornar a lista de Ve�culos armazenada no arquivo

		ArrayList<Veiculo> retornoVeiculo = new ArrayList<Veiculo>();
		String listaVeiculos = new String();

		try // L� os registros do arquivo usando Scanner object
		{
			while (inputVeiculos.hasNext()) {
				Veiculo registroVeiculo = new Veiculo();

				registroVeiculo.setCodigoVeiculo(inputVeiculos.nextInt()); // L� o c�digo do ve�culo
				registroVeiculo.setPlacaVeiculo(inputVeiculos.next()); // L� a placa do ve�culo
				registroVeiculo.setNomeVeiculo(inputVeiculos.next()); // L� o nome do ve�culo
				registroVeiculo.setMarcaVeiculo(inputVeiculos.next()); // L� a marca do ve�culo
				registroVeiculo.setAnoVeiculo(inputVeiculos.nextInt()); // L� o ano do ve�culo

				this.listaVeiculos.add(registroVeiculo);
				
				retornoVeiculo.add(registroVeiculo);
				listaVeiculos += retornoVeiculo + "";
			}
			setListagemArquivoVeiculos(listaVeiculos);
			return retornoVeiculo;
		} catch (NoSuchElementException elementException) {
			System.err.println("Arquivo de ve�culos inv�lido.");
			inputVeiculos.close();
			System.exit(1);
			return null;
		} catch (IllegalStateException stateException) {
			System.err.println("Erro ao ler do arquivo.");
			System.exit(1);
			return null;
		}
	} // Final do m�todo readRecordsVeiculos

	public ArrayList<Entrega> readRecordsEntregas() {
		// Cria o objeto que vai retornar a lista de Entregas armazenada no arquivo

		ArrayList<Entrega> retornoEntrega = new ArrayList<Entrega>();
		String listaEntregas = new String();

		try // L� os registros do arquivo usando Scanner object
		{
			while (inputEntregas.hasNext()) {
				Entrega registroEntrega = new Entrega();

				registroEntrega.setCodigoEntrega(inputEntregas.nextInt()); // L� o c�digo da entrega
				registroEntrega.setDescricaoProduto(inputEntregas.next()); // L� a descri��o do produto da entrega
				registroEntrega.setDescricaoDestino(inputEntregas.next()); // L� a descri��o do destino da entrega
				registroEntrega.setDistanciaEntrega(inputEntregas.nextDouble()); // L� a dist�ncia de entrega da entrega
				registroEntrega.setPlacaVeiculo(inputEntregas.next()); // L� a placa do ve�culo da entrega

				this.listaEntregas.add(registroEntrega);
				
				retornoEntrega.add(registroEntrega);
				listaEntregas += retornoEntrega + "";

			}
			setListagemArquivoEntregas(listaEntregas);
			return retornoEntrega;
		} catch (NoSuchElementException elementException) {
			System.err.println("Arquivo de entregas inv�lido.");
			inputEntregas.close();
			System.exit(1);
			return null;
		} catch (IllegalStateException stateException) {
			System.err.println("Erro ao ler do arquivo.");
			System.exit(1);
			return null;
		}
	} // Final do m�todo readRecordsEntregas

	// M�todo closeFile � respons�vel por fechar os arquivos tanto para escrita
	// quanto para leitura.
	public void closeFileVeiculos() {
		if (outputVeiculos != null)
			outputVeiculos.close();
		if (inputVeiculos != null)
			inputVeiculos.close();
	} // Final do m�todo closeFileVeiculos

	public void closeFileEntregas() {
		if (outputEntregas != null)
			outputEntregas.close();
		if (inputEntregas != null)
			inputEntregas.close();
	} // Final do m�todo closeFileEntregas

	// M�todo para obter o tamanho da lista de entregas
	public int getSizeListaEntregas() {
		return listaEntregas.size();
	}

	public String getListagemArquivoVeiculos() {
		return listagemArquivoVeiculos;
	}

	public void setListagemArquivoVeiculos(String listagemArquivoVeiculos) {
		this.listagemArquivoVeiculos = listagemArquivoVeiculos;
	}

	public String getListagemArquivoEntregas() {
		return listagemArquivoEntregas;
	}

	public void setListagemArquivoEntregas(String listagemArquivoEntregas) {
		this.listagemArquivoEntregas = listagemArquivoEntregas;
	}

	public EntregasPlaca getRelatorioEntregasPlaca() {
		return relatorioEntregasPlaca;
	}

	public void setRelatorioEntregasPlaca(EntregasPlaca relatorioEntregasPlaca) {
		this.relatorioEntregasPlaca = relatorioEntregasPlaca;
	}
}
