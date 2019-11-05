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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControleCadastro controleCadastro;
	private JTable tableEntregas;
	private JTable tableVeiculos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {

		controleCadastro = new ControleCadastro();

		setTitle("Aladim Tapete Mágico - Transportes");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 365, 460);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 339, 420);
		contentPane.add(tabbedPane);

		JPanel panelCadastroVeiculo = new JPanel();
		tabbedPane.addTab("Cadastro de Ve\u00EDculo", null, panelCadastroVeiculo, null);
		panelCadastroVeiculo.setLayout(null);

		DefaultTableModel meuModelTableVeiculos = new DefaultTableModel(
				new String[][] { { "1", "QHV-6984", "CG Start 160" }, },
				new String[] { "Código Veículo", "Placa Veículo", "Nome Veículo" });

		DefaultTableModel meuModelTableEntregas = new DefaultTableModel(
				new String[][] { { "1", "Eletrônico", "QHV-6984" },

				}, new String[] { "Código Entrega", "Produto Entrega", "Placa Entrega" });


		JLabel lblTabelaVeiculos = new JLabel("Cadastro atual: Tabela de Ve\u00EDculos");
		lblTabelaVeiculos.setBounds(10, 11, 314, 23);
		panelCadastroVeiculo.add(lblTabelaVeiculos);
		lblTabelaVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaVeiculos.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableVeiculos = new JTable();
		JScrollPane scrollPaneVeiculos = new JScrollPane();
		scrollPaneVeiculos.setBounds(10, 39, 314, 80);
		panelCadastroVeiculo.add(scrollPaneVeiculos);
		
		tableVeiculos.setModel(meuModelTableVeiculos);		
		scrollPaneVeiculos.setViewportView(tableVeiculos);
		
				JLabel lblArquivoVeiculos = new JLabel("Cadastro salvo: Arquivo de Ve\u00EDculos");
				lblArquivoVeiculos.setBounds(10, 130, 314, 23);
				panelCadastroVeiculo.add(lblArquivoVeiculos);
				lblArquivoVeiculos.setHorizontalAlignment(SwingConstants.CENTER);
				lblArquivoVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
				JScrollPane scrollPaneArquivoDeVeiculos = new JScrollPane();
				scrollPaneArquivoDeVeiculos.setBounds(10, 164, 314, 80);
				panelCadastroVeiculo.add(scrollPaneArquivoDeVeiculos);
				
						JTextArea textAreaArquivoDeVeiculos = new JTextArea();
						scrollPaneArquivoDeVeiculos.setViewportView(textAreaArquivoDeVeiculos);
		
		
				JButton botaoCadastroVeiculo = new JButton("Cadastro de Veículo");
				botaoCadastroVeiculo.setBounds(10, 255, 314, 20);
				panelCadastroVeiculo.add(botaoCadastroVeiculo);
				botaoCadastroVeiculo.setFont(new Font("Tahoma", Font.BOLD, 11));
				
						botaoCadastroVeiculo.addMouseListener(new MouseAdapter() {
							public void mouseReleased(MouseEvent e) {
								try {
									CadastroVeiculo dialog = new CadastroVeiculo();
									dialog.setControleCadastro(controleCadastro);
				
									dialog.setModal(true);
				
									dialog.setVisible(true);
				
								} catch (Exception erroCadastroVeículo) {
									erroCadastroVeículo.printStackTrace();
									JOptionPane.showMessageDialog(null, "Houve um erro ao tentar cadastrar veículo!");
								}
							}
						});
				
						JLabel lblSQL = new JLabel("");
						lblSQL.setBounds(304, 298, 20, 20);
						panelCadastroVeiculo.add(lblSQL);
						lblSQL.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconSQL.png"));
						lblSQL.setHorizontalAlignment(SwingConstants.CENTER);
						lblSQL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
				JButton botaoCRUDSQL = new JButton("CRUD (Banco de Dados PostgreSQL)");
				botaoCRUDSQL.setBounds(10, 298, 285, 20);
				panelCadastroVeiculo.add(botaoCRUDSQL);
				botaoCRUDSQL.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblGitHub = new JLabel("");
		lblGitHub.setBounds(304, 329, 20, 20);
		panelCadastroVeiculo.add(lblGitHub);
		lblGitHub.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconGitHub16px.png"));
		lblGitHub.setHorizontalAlignment(SwingConstants.CENTER);
		lblGitHub.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton botaoGitHub = new JButton("GitHub @Dex4n Avalia\u00E7\u00E3o N2");
		botaoGitHub.setBounds(10, 329, 285, 20);
		panelCadastroVeiculo.add(botaoGitHub);
		botaoGitHub.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblSair = new JLabel("");
		lblSair.setBounds(304, 360, 20, 20);
		panelCadastroVeiculo.add(lblSair);
		lblSair.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconExitMenuPrincipal16px.png"));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(10, 360, 285, 20);
		panelCadastroVeiculo.add(botaoSair);
		botaoSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoSair.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
				controleCadastro.closeFileVeiculos();
				controleCadastro.closeFileEntregas();	
			}
		});

		botaoGitHub.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				try {
					java.awt.Desktop.getDesktop()
							.browse(new java.net.URI("https://github.com/Dex4n/Avaliacao-CESUSC-N2"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		JPanel panelCadastroEntrega = new JPanel();
		tabbedPane.addTab("Cadastro de Entrega", null, panelCadastroEntrega, null);
		panelCadastroEntrega.setLayout(null);

		JLabel lblTabelaEntregas = new JLabel("Cadastro atual: Tabela de Entregas");
		lblTabelaEntregas.setBounds(10, 11, 314, 23);
		panelCadastroEntrega.add(lblTabelaEntregas);
		lblTabelaEntregas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaEntregas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tableEntregas = new JTable();
		JScrollPane scrollPaneEntregas = new JScrollPane();
		scrollPaneEntregas.setBounds(10, 39, 314, 80);
		panelCadastroEntrega.add(scrollPaneEntregas);

		tableEntregas.setModel(meuModelTableEntregas);
		scrollPaneEntregas.setViewportView(tableEntregas);

		JLabel lblArquivoEntregas = new JLabel("Cadastro salvo: Arquivo de Entregas");
		lblArquivoEntregas.setBounds(10, 130, 314, 23);
		panelCadastroEntrega.add(lblArquivoEntregas);
		lblArquivoEntregas.setHorizontalAlignment(SwingConstants.CENTER);
		lblArquivoEntregas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JScrollPane scrollPaneArquivoDeEntregas = new JScrollPane();
		scrollPaneArquivoDeEntregas.setBounds(10, 164, 314, 80);
		panelCadastroEntrega.add(scrollPaneArquivoDeEntregas);
		
		JTextArea textAreaArquivoDeEntregas = new JTextArea();
		scrollPaneArquivoDeEntregas.setViewportView(textAreaArquivoDeEntregas);
		
				JButton botaoCadastroEntrega = new JButton("Cadastro de Entrega");
				botaoCadastroEntrega.setBounds(10, 255, 314, 20);
				panelCadastroEntrega.add(botaoCadastroEntrega);
				botaoCadastroEntrega.setFont(new Font("Tahoma", Font.BOLD, 11));
				botaoCadastroEntrega.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						try {
							CadastroEntrega dialog = new CadastroEntrega();
							dialog.setControleCadastro(controleCadastro);

							dialog.setModal(true);

							dialog.setVisible(true);

							tableEntregas.setModel(new DefaultTableModel(controleCadastro.getListaEntregas(),
									new String[] { "Código Entrega", "Produto Entrega", "Placa Entrega" }));

						} catch (Exception erroCadastroEntrega) {
							erroCadastroEntrega.printStackTrace();
							JOptionPane.showMessageDialog(null, "Houve um erro ao tentar cadastrar entrega!");
						}
					}
				});

		JLabel lblRelatorio = new JLabel("Relat\u00F3rio");
		lblRelatorio.setBounds(304, 365, 20, 16);
		panelCadastroEntrega.add(lblRelatorio);
		lblRelatorio.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconRelatorioEntregasPlaca16px.png"));
		lblRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton botaoRelatorioEntregasPlaca = new JButton("Relatório de entregas por placa");
		botaoRelatorioEntregasPlaca.setBounds(10, 361, 285, 20);
		panelCadastroEntrega.add(botaoRelatorioEntregasPlaca);
		botaoRelatorioEntregasPlaca.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (controleCadastro.getSizeListaEntregas() == 0) {
					JOptionPane.showMessageDialog(null,
							"Alerta: Você deve cadastrar uma entrega primeiro!\nMotivo: Não há cadastro de entrega salvo em arquivo.");
				} else {
					JOptionPane.showMessageDialog(null, controleCadastro.getListaEntregasPlaca());

				}
			}
		});
		botaoRelatorioEntregasPlaca.setFont(new Font("Tahoma", Font.BOLD, 11));

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				controleCadastro.openFileVeiculos(1);
				controleCadastro.openFileEntregas(1);
				controleCadastro.readRecordsVeiculos();
				controleCadastro.readRecordsEntregas();

				textAreaArquivoDeVeiculos.setText(controleCadastro.getListagemArquivoVeiculos());
				textAreaArquivoDeEntregas.setText(controleCadastro.getListagemArquivoEntregas());
			}
			public void windowClosed(WindowEvent e) {
				controleCadastro.closeFileVeiculos();
				controleCadastro.closeFileEntregas();	
			}
		});
	}
}