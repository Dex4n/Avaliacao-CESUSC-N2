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
			//String[] listaVeiculos = new String[ControleCadastro.listaVeiculos.size()];
			String listaVeiculos = new String();
			
		    BufferedReader br = new BufferedReader(new FileReader("C:/TXT/Teste.txt"));
		    while(br.ready())
		    {
		    	String linha  = new String();
		    	linha = br.readLine();
		        listaVeiculos += linha + "\n";
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
			
			BufferedReader br = new BufferedReader(new FileReader(nome));
			while(br.ready()){
				String linha = br.readLine();
				JOptionPane.showMessageDialog(null, linha);
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		} 
		*/
		
	}

	/*
	public void salvarCadastroEntregas()
	{

		// Falta implementar um novo relat�rio de Entregas ordenado por PLACA
		// Quando na posi��o do i o n�mero da placa ser igual aos registros anteriores ou posteriores, 
		
        Entrega cadastroEntrega = new Entrega();
        
    	String relatorioEntregas = " ";
    	
    	if(listaEntregasPlaca.size() == 0) {
    		JOptionPane.showMessageDialog(null, "N�o h� entregas cadastradas para salvar em um arquivo!");
    	} else {
    		for (int i = 0; i < listaEntregasPlaca.size(); i++)
    		{
        		cadastroEntrega = listaEntregasPlaca.get(i);
        		relatorioEntregas += "C�digo da entrega: " + cadastroEntrega.getCodigoEntrega()
                + ", Descri��o do produto: " + cadastroEntrega.getDescricaoProduto()
                + ", Descri��o do destino: " + cadastroEntrega.getDescricaoDestino() 
                + ", Dist�ncia: " + cadastroEntrega.getDistanciaEntrega()
                + ", Placa do VE�CULO: " + cadastroEntrega.getPlacaVeiculo() 
                + ".";
            }
            try 
            {

                FileWriter arquivo = new FileWriter("C:/TXT/Teste.txt");
                BufferedWriter escritor = new BufferedWriter(arquivo);

                escritor.write(relatorioEntregas);
                escritor.close();
                arquivo.close();

                JOptionPane.showMessageDialog(null, "Listagem de hot�is salvo em arquivo com sucesso!");

            }catch(IOException erro)
            {
            	erro.printStackTrace();
            	JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar cadastrar!");
            }
    	}
    	

    }
    */
	
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
	
	/*
	public void deletaEntregasPlaca(Entrega e) 
	{
		listaEntregasPlaca.remove(e);
		quantidadeEntregas = 0;
	}
	
	public void deletaEntregas(Entrega e) 
	{
		listaEntregas.remove(e);
		quantidadeEntregas = 0;
	}
	
	public void deletaEntregas(Veiculo v) 
	{
		listaVeiculos.remove(v);
	}
	*/
}
