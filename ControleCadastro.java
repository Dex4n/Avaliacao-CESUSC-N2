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
	
	//private static ArrayList<Entrega> listaEntregasPlaca;
	private static ArrayList<Veiculo> listaVeiculos;
	private static ArrayList<Entrega> listaEntregas;
	private String listagemArquivoVeiculos;
	//= new String[listaVeiculos.size()];
	private String listagemArquivoEntregas;
	//= new String[listaEntregas.size()];
	
	private Double mediaDistanciaEntregas;
	private int quantidadeEntregas;
	private String placaVeiculoEntrega;
	

	public ControleCadastro() 
	{
		super();
		//listaEntregasPlaca = new ArrayList<Entrega>();
		listaEntregas = new ArrayList<Entrega>();
		listaVeiculos = new ArrayList<Veiculo>();
	}
	
	/*
	public void adicionaEntregaPlaca(Entrega e) 
	{
		listaEntregasPlaca.add(e);
		for (int i=0; i < listaEntregasPlaca.size(); i++) 
		{
			if (listaEntregasPlaca.get(i).getPlacaVeiculo().equals("QHV6984")) 	
			{
				
				getDistancia[0] = 10
				getDistancia[1] = 5
				contador = 2;
				
				Total = 15
				Total / Contador = M�dia;
				
				
				
			}
		}
		//quantidadeEntregas += 1; Esta soma deve ser realizada quando o sistema encontrar todos os cadastros de entrega realizados atrav�s de um ve�culo, ou seja, pela placa.
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
			
		    BufferedReader br = new BufferedReader(new FileReader("C:/TXT/ListaDeVe�culos.txt"));
		    while(br.ready())
		    {
		    	String linha  = new String();
		    	
		    	linha = br.readLine();
		    	if (linha.equals("")) {
		    		JOptionPane.showMessageDialog(null, "N�o h� ve�culos cadastrados em um arquivo para abrir!");
		    	}

		    	listaVeiculos += linha + "\n";
		    	setListagemArquivoVeiculos(listaVeiculos+" |\n".toString());
			    JOptionPane.showMessageDialog(null, listaVeiculos);
		    }
		    br.close();
		}catch(IOException ioe)
		{
		     ioe.printStackTrace(); 
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
		    	setListagemArquivoEntregas(listaEntregas+" |\n");
		        JOptionPane.showMessageDialog(null, listaEntregas);
		    }
		    br.close();
		}catch(IOException ioe)
		{
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel abrir/ gerar o relat�rio de entregas por placa\n 1) N�o h� cadastro no arquivo.\n 2) Erro ao gerar o relat�rio.");
		    ioe.printStackTrace();
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
	
	/*
	public boolean erroCadastroArquivoEntregas() {
		if (listaEntregas.size() == 0){
			
		}
		return true;
	}
	*/
	
	public int getSizeListaEntregas() {
		return listaEntregas.size();
	}

	public void salvarCadastroEntregas()
	{

		// Falta implementar um novo relat�rio de Entregas ordenado por PLACA
		// Quando na posi��o do i o n�mero da placa ser igual aos registros anteriores ou posteriores, 
		
        Entrega cadastroEntrega = new Entrega();
        
    	String relatorioEntregas = "";
    	
    	/*
    	if (erroCadastroArquivoEntregas() == true){
    		JOptionPane.showMessageDialog(null, "N�o h� entregas cadastradas para salvar em um arquivo!");	
    	} else {
    		
    	}
    	*/
    	
    	if(listaEntregas.size() == 0) {
    		JOptionPane.showMessageDialog(null, "N�o h� entregas cadastradas para salvar em um arquivo!");		
    	} else {
    		for (int i = 0; i < listaEntregas.size(); i++)
    		{
        		cadastroEntrega = listaEntregas.get(i);
        		relatorioEntregas += "C�digo da entrega: " + cadastroEntrega.getCodigoEntrega()
                + ", \n" + "Descri��o do produto: " + cadastroEntrega.getDescricaoProduto()
                + ", \n" + "Descri��o do destino: " + cadastroEntrega.getDescricaoDestino() 
                + ", \n" + "Dist�ncia: " + cadastroEntrega.getDistanciaEntrega()
                + ", \n" + "Placa do ve�culo: " + cadastroEntrega.getPlacaVeiculo() 
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

            }catch(IOException erro)
            {
            	erro.printStackTrace();
            	JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar salvar o cadastro de entregas em arquivo!");
            }
    	}
    }
	
	public void salvarCadastroVeiculos()
	{

		// Falta implementar um novo relat�rio de Entregas ordenado por PLACA
		// Quando na posi��o do i o n�mero da placa ser igual aos registros anteriores ou posteriores, 
		
        Veiculo cadastroVeiculo = new Veiculo();
        
    	String relatorioVeiculos = "";
    	
    	if(listaVeiculos.size() == 0) {
    		JOptionPane.showMessageDialog(null, "N�o h� ve�culos cadastrados para salvar em um arquivo!");
    	} else {
    		for (int i = 0; i < listaVeiculos.size(); i++)
    		{
        		cadastroVeiculo = listaVeiculos.get(i);
        		relatorioVeiculos += "C�digo do ve�culo: " + cadastroVeiculo.getCodigoVeiculo()
        		+ ", \n" + "Placa do ve�culo: " + cadastroVeiculo.getPlacaVeiculo()
        		+ ", \n" + "Nome do ve�culo: " + cadastroVeiculo.getNomeVeiculo()
        		+ ", \n" + "Marca do ve�culo: " + cadastroVeiculo.getMarcaVeiculo()
        		+ ", \n" + "Ano do ve�culo: " + cadastroVeiculo.getAnoVeiculo()
                + ".";
            }
            try 
            {
                FileWriter arquivo = new FileWriter("C:/TXT/ListaDeVe�culos.txt");
                BufferedWriter escritor = new BufferedWriter(arquivo);

                escritor.write(relatorioVeiculos);
                escritor.close();
                arquivo.close();

                JOptionPane.showMessageDialog(null, "Listagem de ve�culos salvo em arquivo com sucesso!");

            }catch(IOException erro)
            {
            	erro.printStackTrace();
            	JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar salvar o cadastro de ve�culos em arquivo!");
            }
    	}
    }
    
	/*
	public void listarCadastrosHoteis() {

        Hotel cadastroHotel = new Hotel();
        
    	String relatorioEntregasPlaca = " ";

    	if (listaHoteis.size() == 0) {
    		JOptionPane.showMessageDialog(null, "N�o h� hot�is cadastrados para listar!");	
    	} else 
    	{
            for (int i = 0; i < listaEntregasPlaca.size(); i++) 
            {

                cadastroHotel = listaEntregasPlaca.get(i);

                relatorioEntregasPlaca += "Nome do hotel: " + cadastroHotel.getNome() 
                + ", Cidade do hotel: " + cadastroHotel.getCidade() 
                + ", Avalia��o do Hotel: " + cadastroHotel.getAvaliacao() 
                + ".";

            }
            JOptionPane.showMessageDialog(null, relatorioEntregasPlaca, "Hot�is cadastrados com sucesso!", 1);
    	}
	}	
	*/

	public void apagarListaEntregas() {
		listaEntregas.clear();
        JOptionPane.showMessageDialog(null, "Lista de cadastro de entregas apagado com sucesso!");
	}
	
	public void apagarListaVeiculos() {
		listaVeiculos.clear();
        JOptionPane.showMessageDialog(null, "Lista de cadastro de ve�culos apagado com sucesso!");
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
