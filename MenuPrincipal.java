package transportadora.n2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControleCadastro controleCadastro;
	private JTable tableVeiculos;
	private JTable tableEntregas;
	
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() 
	{
		
		/*
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				tableEntregas.setModel(new DefaultTableModel (
				controleCadastro.getListaEntregas(),
				new String[] {
					"Código Entrega" , "Produto Entrega", "Placa Entrega"
				}));	
				
				tableVeiculos.setModel(new DefaultTableModel (
				controleCadastro.getListaVeiculos(),
				new String[] {
					"Código Veículo" , "Placa Veículo", "Nome Veículo"
				}));
			}
		});
		*/

		controleCadastro = new ControleCadastro();
		
		setTitle("Aladim Tapete Mágico - Transportes");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 700, 500);
		
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JButton botaoCadastroVeiculo = new JButton("Cadastro de Veículo");
		botaoCadastroVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		botaoCadastroVeiculo.addMouseListener(new MouseAdapter() 
		{
			public void mouseReleased(MouseEvent e) 
			{
				try 
				{
					CadastroVeiculo dialog = new CadastroVeiculo();
					dialog.setControleCadastro(controleCadastro);

					dialog.setModal(true); 

					dialog.setVisible(true);	
					
					tableVeiculos.setModel(new DefaultTableModel (
					controleCadastro.getListaVeiculos(),
					new String[] {
						"Código Veículo" , "Placa Veículo", "Nome Veículo"
					}));
	
				} catch (Exception erroCadastroVeículo) 
				{
					erroCadastroVeículo.printStackTrace();
					JOptionPane.showMessageDialog(null, "Houve um erro ao tentar cadastrar veículo!");
				}
			}
		});
		botaoCadastroVeiculo.setBounds(10, 11, 325, 20);
		contentPane.add(botaoCadastroVeiculo);
		
		JLabel lblListaVeiculos = new JLabel("Lista de Veículos");
		lblListaVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListaVeiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaVeiculos.setBounds(10, 60, 325, 20);
		contentPane.add(lblListaVeiculos);
		
		JButton botaoCadastroEntrega = new JButton("Cadastro de Entrega");
		botaoCadastroEntrega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botaoCadastroEntrega.addMouseListener(new MouseAdapter() 
		{
			public void mouseReleased(MouseEvent e) 
			{
				try 
				{
					CadastroEntrega dialog = new CadastroEntrega();
					dialog.setControleCadastro(controleCadastro);

					dialog.setModal(true); 
					
					dialog.setVisible(true);	
					
					tableEntregas.setModel(new DefaultTableModel (
					controleCadastro.getListaEntregas(),
					new String[] {
						"Código Entrega" , "Produto Entrega", "Placa Entrega"
					}));

				} catch (Exception erroCadastroEntrega) 
				{
					erroCadastroEntrega.printStackTrace();
					JOptionPane.showMessageDialog(null, "Houve um erro ao tentar cadastrar entrega!");
				}
			}
		});
		botaoCadastroEntrega.setBounds(345, 11, 329, 20);
		contentPane.add(botaoCadastroEntrega);
		
		JLabel lblListaEntregas = new JLabel("Lista de Entregas");
		lblListaEntregas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaEntregas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListaEntregas.setBounds(345, 60, 329, 20);
		contentPane.add(lblListaEntregas);
		
		//Botão que abre o arquivo criado e lê as informações.
		JButton botaoRelatorioEntregasPlaca = new JButton("Relatório de entregas por placa");
		botaoRelatorioEntregasPlaca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				controleCadastro.abrirArquivoVeiculo();
			}
		});
		botaoRelatorioEntregasPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botaoRelatorioEntregasPlaca.setBounds(345, 295, 310, 20);
		contentPane.add(botaoRelatorioEntregasPlaca);
		
		JLabel lblRelatorio = new JLabel("");
		lblRelatorio.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\discount16px.png"));
		lblRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRelatorio.setBounds(654, 295, 20, 20);
		contentPane.add(lblRelatorio);
		
		JButton botaoFechar = new JButton("Sair");
		botaoFechar.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
			}
		});
		botaoFechar.setBounds(595, 430, 89, 20);
		contentPane.add(botaoFechar);
		
		JScrollPane scrollPaneVeiculos = new JScrollPane();
		scrollPaneVeiculos.setBounds(10, 91, 325, 193);
		contentPane.add(scrollPaneVeiculos);
		
		tableVeiculos = new JTable();
		
		DefaultTableModel meuModelTableVeiculos = new DefaultTableModel(
				new String[][] {
					{"1", "QHV-6984", "CG Start 160"},
					},
				new String[] {
					"Código Veículo", "Placa Veículo", "Nome Veículo"
				}); 
				
		tableVeiculos.setModel(meuModelTableVeiculos);		

		scrollPaneVeiculos.setViewportView(tableVeiculos);
		
		

		JScrollPane scrollPaneEntregas = new JScrollPane();
		scrollPaneEntregas.setBounds(346, 91, 328, 193);
		contentPane.add(scrollPaneEntregas);
		
		tableEntregas = new JTable();

		DefaultTableModel meuModelTableEntregas = new DefaultTableModel(
				new String[][] {
					{"1", "Móveis", "QHV-6984"},
					},
				new String[] {
					"Código Entrega", "Produto Entrega", "Placa Entrega"
				}); 
				
		tableEntregas.setModel(meuModelTableEntregas);
		
		scrollPaneEntregas.setViewportView(tableEntregas);	
		

		JButton botaoGitHub = new JButton("GitHub @Dex4n versão 1.0");
		botaoGitHub.addMouseListener(new MouseAdapter() 
		{
			public void mouseReleased(MouseEvent e) 
			{
				try 
				{
					java.awt.Desktop.getDesktop().browse(new java.net.URI("https://github.com/Dex4n/Avaliacao-CESUSC-N2"));
				} catch (IOException | URISyntaxException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		botaoGitHub.setBounds(374, 430, 211, 20);
		getContentPane().add(botaoGitHub);
		
	}
}