package transportadora.n2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class RelatorioEntregaPlaca extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPlacaSolicitada;
	private ControleCadastro controleCadastro;
	private EntregasPlaca relatorioEntregasPlaca;
	private JTextField txtMediaDistancia;
	private JTextField txtQuantidadeEntregas;
	
	
	
	
	public static void main(String[] args) 
	{
		try 
		{
			RelatorioEntregaPlaca dialog = new RelatorioEntregaPlaca();

			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setVisible(true);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public RelatorioEntregaPlaca() 
	{


		setTitle("Relatório de Entregas por Placa");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtPlacaSolicitada = new JTextField();
		txtPlacaSolicitada.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlacaSolicitada.setBounds(10, 11, 70, 20);
		contentPanel.add(txtPlacaSolicitada);
		txtPlacaSolicitada.setColumns(10);

		JLabel lblPlacaRelatorio = new JLabel("Placa para relat\u00F3rio");
		lblPlacaRelatorio.setBounds(90, 11, 150, 20);
		contentPanel.add(lblPlacaRelatorio);
		
		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconSairMenuPrincipal16px.png"));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSair.setBounds(294, 230, 20, 20);
		contentPanel.add(lblSair);
		
		JLabel lblRelatorio = new JLabel("");
		lblRelatorio.setIcon(new ImageIcon("X:\\Usu\u00E1rios\\Alexandre Casagrande\\Desktop\\Java\\Prova N2 Programa\u00E7\u00E3o 1\\src\\transportadora\\n2\\iconRelatorioEntregasPorPlaca16px.png"));
		lblRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRelatorio.setBounds(294, 199, 20, 20);
		contentPanel.add(lblRelatorio);
		
		JButton botaoGerar = new JButton("Gerar");
		botaoGerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

					if(!validaFormulario()) {
						JOptionPane.showMessageDialog(null, "Você precisa informar uma placa para gerar o relatório!");
					}else {

						String placaSolicitadaAux = txtPlacaSolicitada.getText().toString();
						
						controleCadastro.gerarListaEntregasPlaca(placaSolicitadaAux);
						
						relatorioEntregasPlaca = controleCadastro.getRelatorioEntregasPlaca();

						atualizaFormulario(relatorioEntregasPlaca);
					}
					
			
		}});
		botaoGerar.setBounds(324, 199, 100, 20);
		contentPanel.add(botaoGerar);
		
		JButton botaoSair = new JButton("Retornar");
		botaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setVisible(false);	
			}
		});
		botaoSair.setBounds(324, 230, 100, 20);
		contentPanel.add(botaoSair);
		
		txtMediaDistancia = new JTextField();
		txtMediaDistancia.setEditable(false);
		txtMediaDistancia.setBounds(10, 111, 70, 20);
		contentPanel.add(txtMediaDistancia);
		txtMediaDistancia.setColumns(10);
		
		txtQuantidadeEntregas = new JTextField();
		txtQuantidadeEntregas.setEditable(false);
		txtQuantidadeEntregas.setBounds(10, 142, 70, 20);
		contentPanel.add(txtQuantidadeEntregas);
		txtQuantidadeEntregas.setColumns(10);
		
		JLabel lblMediaDistancia = new JLabel("M\u00E9dia de Dist\u00E2ncia");
		lblMediaDistancia.setBounds(90, 111, 125, 20);
		contentPanel.add(lblMediaDistancia);
		
		JLabel lblQuantidadeEntregas = new JLabel("Quantidade de Entregas");
		lblQuantidadeEntregas.setBounds(90, 142, 125, 20);
		contentPanel.add(lblQuantidadeEntregas);
		
		JLabel lblLblresultado = new JLabel("Resultado (M\u00E9dia, Quantidade)");
		lblLblresultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblLblresultado.setBounds(10, 86, 205, 14);
		contentPanel.add(lblLblresultado);

	} // Fim do construtor
	
	public boolean validaFormulario() 
	{
		return !txtPlacaSolicitada.getText().equals("");
	}
	
	public void atualizaFormulario(EntregasPlaca relatorioEntregasPlaca) {
		this.txtMediaDistancia.setText(relatorioEntregasPlaca.getMediaDistancia() + "");
		this.txtQuantidadeEntregas.setText(relatorioEntregasPlaca.getQuantidadeEntregas() + "");
	}
	
	public ControleCadastro getControleCadastroRelatorio() 
	{
		return controleCadastro;
	}

	public void setControleCadastroRelatorio(ControleCadastro controleCadastro) 
	{
		this.controleCadastro = controleCadastro;
	}

	public EntregasPlaca getRelatorioEntregasPlaca() {
		return relatorioEntregasPlaca;
	}

	public void setRelatorioEntregasPlaca(EntregasPlaca relatorioEntregasPlaca) {
		this.relatorioEntregasPlaca = relatorioEntregasPlaca;
	}
}