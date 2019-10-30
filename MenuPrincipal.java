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

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControleCadastro controleCadastro;
	private JTable tableVeiculos;
	private JTable tableEntregas;
	private JTable tableArquivoEntregas;
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
		
		setBounds(100, 100, 680, 780);
		
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
		botaoCadastroVeiculo.setBounds(10, 11, 306, 20);
		contentPane.add(botaoCadastroVeiculo);
		
		JLabel lblTabelaVeiculos = new JLabel("Tabela de Ve\u00EDculos");
		lblTabelaVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaVeiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaVeiculos.setBounds(10, 60, 306, 20);
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
		botaoCadastroEntrega.setBounds(342, 11, 306, 20);
		contentPane.add(botaoCadastroEntrega);
		
		JLabel lblTabelaEntregas = new JLabel("Tabela de Entregas");
		lblTabelaEntregas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaEntregas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaEntregas.setBounds(345, 60, 306, 20);
		contentPane.add(lblTabelaEntregas);
		
		JButton botaoRelatorioEntregasPlaca = new JButton("Relatório de entregas por placa");
		botaoRelatorioEntregasPlaca.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (controleCadastro.getSizeListaEntregas() == 0) {
					JOptionPane.showMessageDialog(null, "Alerta: Você deve cadastrar uma entrega primeiro!\nMotivo: Não há cadastro de entrega salvo em arquivo.");
				} else {
					JOptionPane.showMessageDialog(null, controleCadastro.getListaEntregasPlaca());
					//controleCadastro.abrirArquivoEntrega();	
				}
			}
		});
		botaoRelatorioEntregasPlaca.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoRelatorioEntregasPlaca.setBounds(10, 699, 285, 20);
		contentPane.add(botaoRelatorioEntregasPlaca);
		
		JLabel lblRelatorio = new JLabel("");
		lblRelatorio.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconRelatorioEntregasPlaca16px.png"));
		lblRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRelatorio.setBounds(296, 699, 20, 20);
		contentPane.add(lblRelatorio);
		
		JButton botaoFechar = new JButton("Sair");
		botaoFechar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoFechar.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
			}
		});
		botaoFechar.setBounds(345, 699, 285, 20);
		contentPane.add(botaoFechar);

		tableVeiculos = new JTable();
		JScrollPane scrollPaneVeiculos = new JScrollPane();
		scrollPaneVeiculos.setBounds(10, 91, 306, 130);
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
		scrollPaneEntregas.setBounds(345, 91, 306, 130);
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
		scrollPaneArquivoEntregas.setBounds(346, 507, 306, 150);
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
		scrollPaneArquivoVeiculos.setBounds(10, 507, 306, 150);
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
		botaoGitHub.setFont(new Font("Tahoma", Font.BOLD, 11));
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


		botaoGitHub.setBounds(10, 668, 285, 20);
		getContentPane().add(botaoGitHub);
		
		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconExitMenuPrincipal16px.png"));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSair.setBounds(631, 699, 20, 20);
		contentPane.add(lblSair);
		
		JLabel lblGitHub = new JLabel("");
		lblGitHub.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconGitHub16px.png"));
		lblGitHub.setHorizontalAlignment(SwingConstants.CENTER);
		lblGitHub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGitHub.setBounds(295, 668, 20, 20);
		contentPane.add(lblGitHub);
		
		JLabel lblArquivoVeiculos = new JLabel("Arquivo de Ve\u00EDculos");
		lblArquivoVeiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblArquivoVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArquivoVeiculos.setBounds(10, 476, 306, 20);
		contentPane.add(lblArquivoVeiculos);
		
		JLabel lblArquivoEntregas = new JLabel("Arquivo de Entregas");
		lblArquivoEntregas.setHorizontalAlignment(SwingConstants.CENTER);
		lblArquivoEntregas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArquivoEntregas.setBounds(345, 476, 306, 20);
		contentPane.add(lblArquivoEntregas);
		
		JButton botaoSQL = new JButton("Abrir op\u00E7\u00F5es de CRUD (Banco de Dados PostgreSQL)");
		botaoSQL.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoSQL.setBounds(345, 668, 285, 20);
		contentPane.add(botaoSQL);
		
		JLabel lblSQL = new JLabel("");
		lblSQL.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconSQL.png"));
		lblSQL.setHorizontalAlignment(SwingConstants.CENTER);
		lblSQL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSQL.setBounds(631, 668, 20, 20);
		
		contentPane.add(lblSQL);
		
		DefaultListModel defaultListModelArquivoVeiculos = new DefaultListModel();
		
		JList listaArquivoVeiculos = new JList();
		listaArquivoVeiculos.setBackground(Color.GRAY);
		listaArquivoVeiculos.setBounds(10, 263, 641, 80);
		listaArquivoVeiculos.setModel(defaultListModelArquivoVeiculos);
		contentPane.add(listaArquivoVeiculos);
		
		DefaultListModel defaultListModelArquivoEntregas = new DefaultListModel();
		
		JList listaArquivoEntregas = new JList();
		listaArquivoEntregas.setBackground(Color.GRAY);
		listaArquivoEntregas.setBounds(10, 385, 641, 80);
		listaArquivoEntregas.setModel(defaultListModelArquivoEntregas);
		contentPane.add(listaArquivoEntregas);
		
		JLabel lblListArquivoVeiculos = new JLabel("Arquivo de Ve\u00EDculos");
		lblListArquivoVeiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListArquivoVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListArquivoVeiculos.setBounds(10, 232, 641, 20);
		contentPane.add(lblListArquivoVeiculos);
		
		JLabel lblListArquivoEntregas = new JLabel("Arquivo de Entregas");
		lblListArquivoEntregas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListArquivoEntregas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListArquivoEntregas.setBounds(10, 354, 641, 20);
		contentPane.add(lblListArquivoEntregas);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				
				controleCadastro.salvarCadastroEntregas();
				controleCadastro.abrirArquivoEntrega();
				controleCadastro.salvarCadastroVeiculos();
				controleCadastro.abrirArquivoVeiculo();
				
				//https://www.guj.com.br/t/chamar-metodo-get-de-acordo-com-arquivo-txt/83038/7
				//https://pt.stackoverflow.com/questions/3905/como-comparar-strings-em-java
				
				listaArquivoVeiculos.setModel(defaultListModelArquivoVeiculos);
				defaultListModelArquivoVeiculos.addElement(controleCadastro.getListagemArquivoVeiculos());
				
				
				listaArquivoEntregas.setModel(defaultListModelArquivoEntregas);
				defaultListModelArquivoEntregas.addElement(controleCadastro.getListagemArquivoEntregas());
			}
		});
		
	}
}