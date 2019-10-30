package transportadora.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControleCadastro
{
	
	private ArrayList<Veiculo> listaVeiculos;
	private ArrayList<Entrega> listaEntregas;
	private String listagemArquivoVeiculos;
	private String listagemArquivoEntregas;
	
	/*
	private Double mediaDistanciaEntregas;
	private int quantidadeEntregas;
	private String placaVeiculoEntrega;
	*/

	public ControleCadastro() 
	{
		super();
		listaEntregas = new ArrayList<Entrega>();
		listaVeiculos = new ArrayList<Veiculo>();
	}
	
	/*
	public void geraRelatorioEntregaPlaca(Entrega e) 
	{
		listaEntregasPlaca.add(e);
		for (int i=0; i < listaEntregasPlaca.size(); i++) 
		{
			if (listaEntregasPlaca.get(i).getPlacaVeiculo().equals("QHV6984")) 	
			{
				getDistancia[0] = 10
				contador[0] = 1
				getDistancia[1] = 10
				contador[1] = 1
				
				getPlaca[0] == getPlaca[1]
				
				totalEntregas = contador[0] + contador[1]
				
				soma[i] += getDistancia[i] + getDistancia[i+1]
				
				soma = 20
				totalEntregas = 2
				valorMediaDistancia = 20 / 2;

			}
		}
		//quantidadeEntregas += 1; Esta soma deve ser realizada quando o sistema encontrar todos os cadastros de entrega realizados através de um veículo, ou seja, pela placa.
	}
	*/
	
	public void adicionaEntrega(Entrega e) {
		listaEntregas.add(e);		
	}
	
	public void adicionaVeiculo(Veiculo v) {
		listaVeiculos.add(v);
	}
	
	public String[] getEntregas()
	{
		String[] aux = new String[listaEntregas.size()];
		for (int i=0; i<listaEntregas.size(); i++) 
		{
			aux[i] = listaEntregas.get(i).getCodigoEntrega() 
			+ ",\n" + listaEntregas.get(i).getDescricaoDestino() 
			+ ",\n" + listaEntregas.get(i).getDescricaoDestino() 
			+ ",\n" + listaEntregas.get(i).getDistanciaEntrega() 
			+ ",\n" + listaEntregas.get(i).getPlacaVeiculo() + ".";
		}
		return aux;
	}
	
	public String[] getVeiculos()
	{
		String[] aux = new String[listaVeiculos.size()];
		for (int i=0; i<listaVeiculos.size(); i++) 
		{
			aux[i] = listaVeiculos.get(i).getCodigoVeiculo()
			+ ",\n" + listaVeiculos.get(i).getPlacaVeiculo() 
			+ ",\n " + listaVeiculos.get(i).getNomeVeiculo()
			+ ",\n" + listaVeiculos.get(i).getMarcaVeiculo()
			+ ",\n" + listaVeiculos.get(i).getAnoVeiculo() + ".";
		}
		return aux;
	}
		
	public String[][] getListaEntregas()
	{
		String [][] matAux = new String[listaEntregas.size()][3];
		for (int j=0; j<listaEntregas.size(); j++) 
		{ 		
		    String[] aux = new String[3];
			aux[0] = listaEntregas.get(j).getCodigoEntrega()+"";
			aux[1] = listaEntregas.get(j).getDescricaoProduto();
			aux[2] = listaEntregas.get(j).getPlacaVeiculo();
			matAux[j] = aux;
		}
		return matAux;
	}
	
	public String[] getListaEntregasPlaca()
	{
		String [] matAux = new String[getSizeListaEntregas()];
		for (int j=0; j<listaEntregas.size(); j++) 
		{ 		
		    String aux;
			aux = listaEntregas.get(j).getPlacaVeiculo() + "\n" + listaEntregas.get(j).getDistanciaEntrega();
			//aux[1] = listaEntregas.get(j).getDistanciaEntrega() + "";
			matAux[j] = aux;
		}
		return matAux;
	}
	
	
	
	
	
	public String[][] getListaVeiculos()
	{
		String [][] matAux = new String[listaVeiculos.size()][3];
		for (int j=0; j<listaVeiculos.size(); j++) 
		{ 		
		    String[] aux = new String[3];
			aux[0] = listaVeiculos.get(j).getCodigoVeiculo()+"";
			aux[1] = listaVeiculos.get(j).getPlacaVeiculo();
			aux[2] = listaVeiculos.get(j).getNomeVeiculo();
			matAux[j] = aux;
		}
		return matAux;
	}
		
	public void abrirArquivoVeiculo()
	{
		
		try
		{
			String listaVeiculos = new String();
			
		    BufferedReader br = new BufferedReader(new FileReader("C:/TXT/ListaDeVeículos.txt"));
		    while(br.ready())
		    {
		    	String linha  = new String();
		    	
		    	linha = br.readLine();
		    	if (linha.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Não há veículos cadastrados em um arquivo para abrir!");
		    	}

		    	listaVeiculos += linha + "\n";
		    	setListagemArquivoVeiculos(listaVeiculos);
			    //JOptionPane.showMessageDialog(null, listaVeiculos);
		    }
		    br.close();
		}catch(IOException erroAbrir)
		{
			erroAbrir.printStackTrace(); 
		}
		
		/*
		try{
			
			String nome;
			nome = JOptionPane.showInputDialog(null,"Entre com o nome do arquivo");
			
			String listaVeiculos = new String();
			
			BufferedReader br = new BufferedReader(new FileReader(nome));
			while(br.ready()){
		    	String linha  = new String();
		    	linha = br.readLine();
		        listaVeiculos += linha + "\n";
		        JOptionPane.showMessageDialog(null, listaVeiculos);
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		} 
		*/
	}
	
	public void abrirArquivoEntrega()
	{
		
		try
		{
			String listaEntregas = new String();
			
		    BufferedReader br = new BufferedReader(new FileReader("C:/TXT/ListaDeEntregas.txt"));
		    while(br.ready())
		    {
		    	String linha  = new String();
		    	linha = br.readLine();
		    	listaEntregas += linha + "\n";
		    	setListagemArquivoEntregas(listaEntregas);
		        //JOptionPane.showMessageDialog(null, listaEntregas);
		    }
		    br.close();
		}catch(IOException erroAbrir)
		{
			JOptionPane.showMessageDialog(null, "Não foi possível abrir/ gerar o relatório de entregas por placa\n 1) Não há cadastro no arquivo.\n 2) Erro ao gerar o relatório.");
			erroAbrir.printStackTrace();
		}
		
		/*
		try{
			
			String nome;
			nome = JOptionPane.showInputDialog(null,"Entre com o nome do arquivo");
			
			String listaEntregas = new String();
			
			BufferedReader br = new BufferedReader(new FileReader(nome));
			while(br.ready()){
		    	String linha  = new String();
		    	linha = br.readLine();
		    	listaEntregas += linha + "\n";
		        JOptionPane.showMessageDialog(null, listaEntregas);
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		} 
		*/
	}
	
	public int getSizeListaEntregas() {
		return listaEntregas.size();
	}

	public void salvarCadastroEntregas()
	{
        Entrega cadastroEntrega = new Entrega();
        
    	String relatorioEntregas = "";
    	
    	if(listaEntregas.size() == 0) {
    		//JOptionPane.showMessageDialog(null, "Não há entregas cadastradas para salvar em um arquivo!");		
    	} else {
    		for (int i = 0; i < listaEntregas.size(); i++)
    		{
        		cadastroEntrega = listaEntregas.get(i);
        		relatorioEntregas += "Código entrega: " + cadastroEntrega.getCodigoEntrega()
                + ", \n" + "Produto: " + cadastroEntrega.getDescricaoProduto()
                + ", \n" + "Destino: " + cadastroEntrega.getDescricaoDestino() 
                + ", \n" + "Distância: " + cadastroEntrega.getDistanciaEntrega()
                + ", \n" + "Placa Veículo: " + cadastroEntrega.getPlacaVeiculo() 
                + ".";
            }
            try 
            {
                FileWriter arquivo = new FileWriter("C:/TXT/ListaDeEntregas.txt");
                BufferedWriter escritor = new BufferedWriter(arquivo);

                escritor.write(relatorioEntregas);
                escritor.close();
                arquivo.close();

                JOptionPane.showMessageDialog(null, "Listagem de entregas salvo em arquivo com sucesso!");

            }catch(IOException erroSalvar)
            {
            	erroSalvar.printStackTrace();
            	JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar salvar o cadastro de entregas em arquivo!");
            }
    	}
    }
	
	public void salvarCadastroVeiculos()
	{

		// Falta implementar um novo relatório de Entregas ordenado por PLACA
		// Quando na posição do i o número da placa ser igual aos registros anteriores ou posteriores, 
		
        Veiculo cadastroVeiculo = new Veiculo();
        
    	String relatorioVeiculos = "";
    	
    	if(listaVeiculos.size() == 0) {
    		//JOptionPane.showMessageDialog(null, "Não há veículos cadastrados para salvar em um arquivo!");
    	} else {
    		for (int i = 0; i < listaVeiculos.size(); i++)
    		{
        		cadastroVeiculo = listaVeiculos.get(i);
        		relatorioVeiculos += "Código veículo: " + cadastroVeiculo.getCodigoVeiculo()
        		+ ", \n" + "Placa Veículo: " + cadastroVeiculo.getPlacaVeiculo()
        		+ ", \n" + "Nome : " + cadastroVeiculo.getNomeVeiculo()
        		+ ", \n" + "Marca : " + cadastroVeiculo.getMarcaVeiculo()
        		+ ", \n" + "Ano : " + cadastroVeiculo.getAnoVeiculo()
                + ".";
            }
            try 
            {
                FileWriter arquivo = new FileWriter("C:/TXT/ListaDeVeículos.txt");
                BufferedWriter escritor = new BufferedWriter(arquivo);

                escritor.write(relatorioVeiculos);
                escritor.close();
                arquivo.close();

                JOptionPane.showMessageDialog(null, "Listagem de veículos salvo em arquivo com sucesso!");

            }catch(IOException erroSalvar)
            {
            	erroSalvar.printStackTrace();
            	JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar salvar o cadastro de veículos em arquivo!");
            }
    	}
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
		this.listagemArquivoVeiculos = listagemArquivoVeiculos + " |\n";
	}

	public String getListagemArquivoEntregas() {
		return listagemArquivoEntregas;
	}

	public void setListagemArquivoEntregas(String listagemArquivoEntregas) {
		this.listagemArquivoEntregas = listagemArquivoEntregas + " |\n";
	}
	
	
}
