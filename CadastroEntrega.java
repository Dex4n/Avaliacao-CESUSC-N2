package transportadora.n2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroEntrega extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoEntrega;
	private JTextField txtDescricaoProdutoEntrega;
	private JTextField txtDescricaoDestinoEntrega;
	private JTextField txtDistanciaEntrega;
	private JTextField txtPlacaVeiculoEntrega;
	
	private ControleCadastro controleCadastro;
	private Entrega minhaEntrega;

	public static void main(String[] args) {
		try {
			CadastroEntrega dialog = new CadastroEntrega();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CadastroEntrega() {
		
		minhaEntrega = new Entrega();
		
		setTitle("Cadastro de Entrega");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		contentPanel.setLayout(null);
		{
			JLabel lblCodigoEntrega = new JLabel("C\u00F3digo Entrega");
			lblCodigoEntrega.setBounds(10, 11, 115, 14);
			contentPanel.add(lblCodigoEntrega);
		}
		
		txtCodigoEntrega = new JTextField();
		txtCodigoEntrega.setBounds(135, 8, 289, 20);
		contentPanel.add(txtCodigoEntrega);
		txtCodigoEntrega.setColumns(10);
		
		JLabel lblDescricaoProdutoEntrega = new JLabel("Descri\u00E7\u00E3o Produto");
		lblDescricaoProdutoEntrega.setBounds(10, 39, 115, 14);
		contentPanel.add(lblDescricaoProdutoEntrega);
		
		txtDescricaoProdutoEntrega = new JTextField();
		txtDescricaoProdutoEntrega.setColumns(10);
		txtDescricaoProdutoEntrega.setBounds(135, 36, 289, 20);
		contentPanel.add(txtDescricaoProdutoEntrega);
		
		JLabel lblDestinoEntrega = new JLabel("Destino da Entrega");
		lblDestinoEntrega.setBounds(10, 67, 115, 14);
		contentPanel.add(lblDestinoEntrega);
		
		txtDescricaoDestinoEntrega = new JTextField();
		txtDescricaoDestinoEntrega.setColumns(10);
		txtDescricaoDestinoEntrega.setBounds(135, 64, 289, 20);
		contentPanel.add(txtDescricaoDestinoEntrega);
		
		JLabel lblDistanciaEntrega = new JLabel("Dist\u00E2ncia da Entrega");
		lblDistanciaEntrega.setBounds(10, 95, 115, 14);
		contentPanel.add(lblDistanciaEntrega);
		
		txtDistanciaEntrega = new JTextField();
		txtDistanciaEntrega.setColumns(10);
		txtDistanciaEntrega.setBounds(135, 92, 289, 20);
		contentPanel.add(txtDistanciaEntrega);
		
		JLabel lblPlacaVeiculoEntrega = new JLabel("Placa Ve\u00EDculo");
		lblPlacaVeiculoEntrega.setBounds(10, 126, 115, 14);
		contentPanel.add(lblPlacaVeiculoEntrega);
		
		txtPlacaVeiculoEntrega = new JTextField();
		txtPlacaVeiculoEntrega.setColumns(10);
		txtPlacaVeiculoEntrega.setBounds(135, 123, 289, 20);
		contentPanel.add(txtPlacaVeiculoEntrega);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent arg0) {	
						
						if(!validaFormulario()) {
							JOptionPane.showMessageDialog(null, "Os campos de <Código, Produto, Destino, Distância e Placa> obrigatoriamente devem estar preenchidos!");
						} else {
							cadastroEntrega();		
							//controleCadastro.salvarCadastroEntregas();
							
							setVisible(false);
						}		
					}
				});
				okButton.setActionCommand("Salvar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Sair");
				cancelButton.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Sair");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public boolean validaFormulario() 
	{
		return (!txtCodigoEntrega.getText().equals("") && 
				!txtDescricaoProdutoEntrega.getText().equals("") &&
				!txtDescricaoDestinoEntrega.getText().equals("") &&
				!txtDistanciaEntrega.getText().equals("") &&
				!txtPlacaVeiculoEntrega.getText().equals(""));
	}

	public ControleCadastro getControleCadastro() {
		return controleCadastro;
	}

	public void setControleCadastro(ControleCadastro controleCadastro) {
		this.controleCadastro = controleCadastro;
	}
	
	public void cadastroEntrega() {
		
		try 
		{
			minhaEntrega.setCodigoEntrega(Integer.parseInt(this.txtCodigoEntrega.getText()));
			minhaEntrega.setDescricaoProduto(txtDescricaoProdutoEntrega.getText());
			minhaEntrega.setDescricaoDestino(txtDescricaoDestinoEntrega.getText());
			minhaEntrega.setDistanciaEntrega(Double.parseDouble(txtDistanciaEntrega.getText()));
			minhaEntrega.setPlacaVeiculo(txtPlacaVeiculoEntrega.getText());
			controleCadastro.adicionaEntrega(minhaEntrega);
			controleCadastro.openFileEntregas(0);
			controleCadastro.addRecordsEntregas(minhaEntrega);
			//controleCadastro.closeFileEntregas();	
			
			JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar uma entrega!");
		} catch (Exception e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar uma entrega!");
		}	
	}
}
