package transportadora.n2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RelatorioEntregaPlaca extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ControleCadastro controleCadastro;

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
		setTitle("Relat\u00F3rio de Entregas por Placa");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Gerar");
				okButton.addMouseListener(new MouseAdapter() 
				{
					public void mouseReleased(MouseEvent arg0) 
					{
						JOptionPane.showMessageDialog(null, controleCadastro.getListaEntregasPlaca());
						//setVisible(false);
						//System.exit(0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Sair");
				cancelButton.addMouseListener(new MouseAdapter() 
				{
					public void mouseReleased(MouseEvent arg0) 
					{
						setVisible(false);
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Sair");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	public ControleCadastro getControleCadastro() 
	{
		return controleCadastro;
	}

	public void setControleCadastro(ControleCadastro controleCadastro) 
	{
		this.controleCadastro = controleCadastro;
	}
}
