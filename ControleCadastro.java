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
	private ArrayList<Entrega> listaEntregasPlaca;
	private String listagemArquivoVeiculos;
	private String listagemArquivoEntregas;
	private Formatter outputVeiculos;
	private Formatter outputEntregas;
	private Scanner inputVeiculos;
	private Scanner inputEntregas;

	public ControleCadastro() {
		super();
		listaEntregas = new ArrayList<Entrega>();
		listaEntregasPlaca = new ArrayList<Entrega>();
		listaVeiculos = new ArrayList<Veiculo>();
	}

	public void adicionaEntrega(Entrega newEntrega) {
		listaEntregas.add(newEntrega);
	}

	public void adicionaVeiculo(Veiculo newVeiculo) {
		listaVeiculos.add(newVeiculo);
	}

	public ArrayList<Entrega> getListaEntregasPlaca() {
		Entrega auxEntrega[] = {};

		for (int i = 0; i < listaEntregas.size(); i++) {
			auxEntrega[i] = listaEntregas.get(i);
			// auxEntrega = listaEntregas.get(i).getPlacaVeiculo() +
			// listaEntregas.get(i).getDistanciaEntrega();
			// listaEntregasPlaca.add(aux);
		}
		return listaEntregasPlaca;
	}

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

	// Indica que o arquivo de veículos vai ser aberto
	public void openFileVeiculos(int modo) {
		try {
			switch (modo) {
			case 0: {
				FileWriter f;
				f = new FileWriter("ListaDeVeículos.txt", false);
				outputVeiculos = new Formatter(f);
			}
			case 1:
				inputVeiculos = new Scanner(new File("ListaDeVeículos.txt"));
			}
		} catch (SecurityException securityException) {
			System.err.println("O usuário não pode acessar o arquivo de veículos.");
			System.exit(1);
		} catch (FileNotFoundException filesNotFoundException) {
			System.err.println("Não foi possível criar o arquivo de veículos.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // Final do método openFileVeiculos

	public void openFileEntregas(int modo) {
		try {
			switch (modo) {
			case 0: {
				FileWriter f;
				f = new FileWriter("ListaDeEntregas.txt", false);
				outputEntregas = new Formatter(f);
			}
			case 1:
				inputEntregas = new Scanner(new File("ListaDeEntregas.txt"));
			}
		} catch (SecurityException securityException) {
			System.err.println("O usuário não pode acessar o arquivo de entregas.");
			System.exit(1);
		} catch (FileNotFoundException filesNotFoundException) {
			System.err.println("Não foi possível criar o arquivo de entregas.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // Final do método openFileEntregas

	// Adiciona os registros para o arquivo de veículos
	public void addRecordsVeiculos(Veiculo registroVeiculo) {
		try {
			outputVeiculos.format("%d %s %s %s %d \n", registroVeiculo.getCodigoVeiculo(),
					registroVeiculo.getPlacaVeiculo(), registroVeiculo.getNomeVeiculo(),
					registroVeiculo.getMarcaVeiculo(), registroVeiculo.getAnoVeiculo());
			JOptionPane.showMessageDialog(null, "Listagem de veículos salvo em arquivo com sucesso!");
			
		} catch (FormatterClosedException formatterClosedException) {
			System.err.println("Erro ao escrever no arquivo de veículos.");
			return;
		}
	} // Fim do método addRecordsVeiculo

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
	} // Fim do método addRecordsEntregas

	public ArrayList<Veiculo> readRecordsVeiculos() {
		// Cria o objeto que vai retornar a lista de Veículos armazenada no arquivo

		ArrayList<Veiculo> retornoVeiculo = new ArrayList<Veiculo>();
		String listaVeiculos = new String();

		try // Lê os registros do arquivo usando Scanner object
		{	
			while (inputVeiculos.hasNext()) {
				Veiculo registroVeiculo = new Veiculo();

				registroVeiculo.setCodigoVeiculo(inputVeiculos.nextInt()); // Lê o código do veículo
				registroVeiculo.setPlacaVeiculo(inputVeiculos.next()); // Lê a placa do veículo
				registroVeiculo.setNomeVeiculo(inputVeiculos.next()); // Lê o nome do veículo
				registroVeiculo.setMarcaVeiculo(inputVeiculos.next()); // Lê a marca do veículo
				registroVeiculo.setAnoVeiculo(inputVeiculos.nextInt()); // Lê o ano do veículo

				retornoVeiculo.add(registroVeiculo);
				listaVeiculos += retornoVeiculo + "";
			}
			setListagemArquivoVeiculos(listaVeiculos);
			return retornoVeiculo;
		} catch (NoSuchElementException elementException) {
			System.err.println("Arquivo de veículos inválido.");
			inputVeiculos.close();
			System.exit(1);
			return null;
		} catch (IllegalStateException stateException) {
			System.err.println("Erro ao ler do arquivo.");
			System.exit(1);
			return null;
		}
	} // Final do método readRecordsVeiculos

	public ArrayList<Entrega> readRecordsEntregas() {
		// Cria o objeto que vai retornar a lista de Entregas armazenada no arquivo

		ArrayList<Entrega> retornoEntrega = new ArrayList<Entrega>();
		String listaEntregas = new String();
		
		try // Lê os registros do arquivo usando Scanner object
		{
			while (inputEntregas.hasNext()) {
				Entrega registroEntrega = new Entrega();

				registroEntrega.setCodigoEntrega(inputEntregas.nextInt()); // Lê o código da entrega
				registroEntrega.setDescricaoProduto(inputEntregas.next()); // Lê a descrição do produto da entrega
				registroEntrega.setDescricaoDestino(inputEntregas.next()); // Lê a descrição do destino da entrega
				registroEntrega.setDistanciaEntrega(inputEntregas.nextDouble()); // Lê a distância de entrega da entrega
				registroEntrega.setPlacaVeiculo(inputEntregas.next()); // Lê a placa do veículo da entrega

				retornoEntrega.add(registroEntrega);
				listaEntregas += retornoEntrega + "";
				
			}
			setListagemArquivoEntregas(listaEntregas);
			return retornoEntrega;
		} catch (NoSuchElementException elementException) {
			System.err.println("Arquivo de entregas inválido.");
			inputEntregas.close();
			System.exit(1);
			return null;
		} catch (IllegalStateException stateException) {
			System.err.println("Erro ao ler do arquivo.");
			System.exit(1);
			return null;
		}
	} // Final do método readRecordsEntregas

	// Método closeFile é responsável por fechar os arquivos tanto para escrita quanto para leitura.
	
	public void closeFileVeiculos() {
		if (outputVeiculos != null)
			outputVeiculos.close();
		if (inputVeiculos != null)
			inputVeiculos.close();
	} // Final do método closeFileVeiculos

	public void closeFileEntregas() {
		if (outputEntregas != null)
			outputEntregas.close();
		if (inputEntregas != null)
			inputEntregas.close();
	} // Final do método closeFileEntregas


	public int getSizeListaEntregas() {
		return listaEntregas.size();
	}


	public void apagarListaEntregas() {
		listaEntregas.clear();
		JOptionPane.showMessageDialog(null, "Lista de cadastro de entregas apagado com sucesso!");
	}

	public void apagarListaVeiculos() {
		listaVeiculos.clear();
		JOptionPane.showMessageDialog(null, "Lista de cadastro de veículos apagado com sucesso!");
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

}
