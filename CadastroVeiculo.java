package transportadora.n2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroVeiculo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoVeiculo;
	private JTextField txtPlacaVeiculo;
	private JTextField txtNomeVeiculo;
	private JTextField txtMarcaVeiculo;
	private JTextField txtAnoVeiculo;

	private Veiculo meuVeiculo;
	private ControleCadastro controleCadastro;

	public static void main(String[] args) {
		try {
			CadastroVeiculo dialog = new CadastroVeiculo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CadastroVeiculo() {

		meuVeiculo = new Veiculo();

		setTitle("Cadastro de Veículo");

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCodigoVeiculo = new JLabel("Código Veículo");
		lblCodigoVeiculo.setBounds(10, 11, 115, 14);
		contentPanel.add(lblCodigoVeiculo);

		txtCodigoVeiculo = new JTextField();
		txtCodigoVeiculo.setBounds(135, 8, 289, 20);
		contentPanel.add(txtCodigoVeiculo);
		txtCodigoVeiculo.setColumns(10);

		JLabel lblPlacaVeiculo = new JLabel("Placa Veículo");
		lblPlacaVeiculo.setBounds(10, 39, 115, 14);
		contentPanel.add(lblPlacaVeiculo);

		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.setColumns(10);
		txtPlacaVeiculo.setBounds(135, 36, 289, 20);
		contentPanel.add(txtPlacaVeiculo);

		JLabel lblNomeVeiculo = new JLabel("Nome Veículo");
		lblNomeVeiculo.setBounds(10, 67, 115, 14);
		contentPanel.add(lblNomeVeiculo);

		txtNomeVeiculo = new JTextField();
		txtNomeVeiculo.setColumns(10);
		txtNomeVeiculo.setBounds(135, 67, 289, 20);
		contentPanel.add(txtNomeVeiculo);

		JLabel lblMarcaVeiculo = new JLabel("Marca Veículo");
		lblMarcaVeiculo.setBounds(10, 95, 115, 14);
		contentPanel.add(lblMarcaVeiculo);

		txtMarcaVeiculo = new JTextField();
		txtMarcaVeiculo.setColumns(10);
		txtMarcaVeiculo.setBounds(135, 92, 289, 20);
		contentPanel.add(txtMarcaVeiculo);

		JLabel lblAnoVeiculo = new JLabel("Ano Veículo");
		lblAnoVeiculo.setBounds(10, 123, 115, 14);
		contentPanel.add(lblAnoVeiculo);

		txtAnoVeiculo = new JTextField();
		txtAnoVeiculo.setColumns(10);
		txtAnoVeiculo.setBounds(135, 120, 289, 20);
		contentPanel.add(txtAnoVeiculo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						if (!validaFormulario()) {
							JOptionPane.showMessageDialog(null,
									"Os campos de <Código, Produto, Destino, Distância e Placa> obrigatoriamente devem estar preenchidos!");
						} else {
							cadastroVeiculo();
							controleCadastro.closeFileVeiculos();
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
						controleCadastro.closeFileVeiculos();
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Sair");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean validaFormulario() {
		return (!txtCodigoVeiculo.getText().equals("") && !txtPlacaVeiculo.getText().equals("")
				&& !txtNomeVeiculo.getText().equals("") && !txtMarcaVeiculo.getText().equals("")
				&& !txtAnoVeiculo.getText().equals(""));
	}

	public ControleCadastro getControleCadastro() {
		return controleCadastro;
	}

	public void setControleCadastro(ControleCadastro controleCadastro) {
		this.controleCadastro = controleCadastro;
	}

	public void cadastroVeiculo() {

		try {
			meuVeiculo.setCodigoVeiculo(Integer.parseInt(this.txtCodigoVeiculo.getText()));
			meuVeiculo.setPlacaVeiculo(txtPlacaVeiculo.getText());
			meuVeiculo.setNomeVeiculo(txtNomeVeiculo.getText());
			meuVeiculo.setMarcaVeiculo(txtMarcaVeiculo.getText());
			meuVeiculo.setAnoVeiculo(Integer.parseInt(txtAnoVeiculo.getText()));
			controleCadastro.adicionaVeiculo(meuVeiculo);
			controleCadastro.openFileVeiculos(0);
			controleCadastro.addRecordsVeiculos(meuVeiculo);

			JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar um veículo!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar um veículo!");
		}
	}

}
