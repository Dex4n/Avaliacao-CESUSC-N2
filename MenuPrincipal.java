package transportadora.n2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
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
	private JTable Veiculos;
	private JTable tableArquivoEntregas;
	private JTable sVeiculos;
	private JTable tableArquivoVeiculos;
	
	
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

		controleCadastro = new ControleCadastro();
		
		setTitle("Aladim Tapete Mágico - Transportes");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 700, 550);
		
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
		
		JLabel lblTabelaVeiculos = new JLabel("Tabela de Ve\u00EDculos");
		lblTabelaVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaVeiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaVeiculos.setBounds(10, 60, 325, 20);
		contentPane.add(lblTabelaVeiculos);
		
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
		
		JLabel lblTabelaEntregas = new JLabel("Tabela de Entregas");
		lblTabelaEntregas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaEntregas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaEntregas.setBounds(345, 60, 329, 20);
		contentPane.add(lblTabelaEntregas);
		
		JButton botaoRelatorioEntregasPlaca = new JButton("Relatório de entregas por placa");
		botaoRelatorioEntregasPlaca.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				if (controleCadastro.getSizeListaEntregas() == 0) {
					JOptionPane.showMessageDialog(null, "Alerta: Você deve cadastrar uma entrega primeiro!\nMotivo: Não há cadastro de entrega salvo em arquivo.");
				} else {
					controleCadastro.abrirArquivoEntrega();	
				}
			}
		});
		botaoRelatorioEntregasPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botaoRelatorioEntregasPlaca.setBounds(10, 479, 305, 20);
		contentPane.add(botaoRelatorioEntregasPlaca);
		
		JLabel lblRelatorio = new JLabel("");
		lblRelatorio.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconRelatorioEntregasPlaca16px.png"));
		lblRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRelatorio.setBounds(315, 479, 20, 20);
		contentPane.add(lblRelatorio);
		
		JButton botaoFechar = new JButton("Sair");
		botaoFechar.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
			}
		});
		botaoFechar.setBounds(345, 480, 304, 20);
		contentPane.add(botaoFechar);

		tableVeiculos = new JTable();
		JScrollPane scrollPaneVeiculos = new JScrollPane();
		scrollPaneVeiculos.setBounds(10, 91, 325, 193);
		contentPane.add(scrollPaneVeiculos);
		
		DefaultTableModel meuModelTableVeiculos = new DefaultTableModel(
				new String[][] {
					{"1", "QHV-6984", "CG Start 160"},
					},
				new String[] {
					"Código Veículo", "Placa Veículo", "Nome Veículo"
				}); 
				
		tableVeiculos.setModel(meuModelTableVeiculos);		
		scrollPaneVeiculos.setViewportView(tableVeiculos);

		tableEntregas = new JTable();
		JScrollPane scrollPaneEntregas = new JScrollPane();
		scrollPaneEntregas.setBounds(346, 91, 328, 193);
		contentPane.add(scrollPaneEntregas);
		
		DefaultTableModel meuModelTableEntregas = new DefaultTableModel(
				new String[][] {
					{"1", "Eletrônico", "QHV-6984"},
					
					},
				new String[] {
					"Código Entrega", "Produto Entrega", "Placa Entrega"
				}); 
			
		tableEntregas.setModel(meuModelTableEntregas);
		scrollPaneEntregas.setViewportView(tableEntregas);

		tableArquivoEntregas = new JTable();
		JScrollPane scrollPaneArquivoEntregas = new JScrollPane();
		scrollPaneArquivoEntregas.setBounds(345, 295, 325, 140);
		contentPane.add(scrollPaneArquivoEntregas);
		
		DefaultTableModel meuModelArquivoEntregas = new DefaultTableModel(
				new String[][] {
					{"1", "Eletrônico", "QHV-6984"},
					},
				new String[] {
					"Código Entrega", "Produto Entrega", "Placa Entrega"
				}); 
		
		tableArquivoEntregas.setModel(meuModelArquivoEntregas);		
		scrollPaneArquivoEntregas.setViewportView(tableArquivoEntregas);

		tableArquivoVeiculos = new JTable();
		JScrollPane scrollPaneArquivoVeiculos = new JScrollPane();
		scrollPaneArquivoVeiculos.setBounds(10, 295, 325, 140);
		contentPane.add(scrollPaneArquivoVeiculos);
		
		DefaultTableModel meuModelArquivoVeiculos = new DefaultTableModel(
				new String[][] {
					{"1", "QHV-6984", "CG Start 160"},
					},
				new String[] {
					
					"Código Veículo", "Placa Veículo", "Nome Veículo"
				}); 
		
		tableArquivoVeiculos.setModel(meuModelArquivoVeiculos);		
		scrollPaneArquivoVeiculos.setViewportView(tableArquivoVeiculos);
		

		JButton botaoGitHub = new JButton("GitHub @Dex4n Avalia\u00E7\u00E3o N2");
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


		botaoGitHub.setBounds(10, 446, 305, 20);
		getContentPane().add(botaoGitHub);
		
		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconExitMenuPrincipal16px.png"));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSair.setBounds(654, 480, 20, 20);
		contentPane.add(lblSair);
		
		JLabel lblGitHub = new JLabel("");
		lblGitHub.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconGitHub16px.png"));
		lblGitHub.setHorizontalAlignment(SwingConstants.CENTER);
		lblGitHub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGitHub.setBounds(315, 446, 20, 20);
		contentPane.add(lblGitHub);
		
	}
}