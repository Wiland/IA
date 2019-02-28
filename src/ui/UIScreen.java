package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class UIScreen {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtGate;
	private JTextField txtResult;
	private String trainingFileAnd;
	private String trainingFileOr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIScreen window = new UIScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSpinner spnIncome1 = new JSpinner();
		JPanel logicGates = new JPanel();
		JToggleButton btnAnd = new JToggleButton("AND");
		JToggleButton btnOr = new JToggleButton("OR");
		JPanel panel_1 = new JPanel();
		JLabel lblEntrada1 = new JLabel("Entrada 1");
		JLabel lblEntrada2 = new JLabel("Entrada 2");
		JSpinner spnIncome2 = new JSpinner();
		JLabel lblGate = new JLabel("Compuerta");
		JLabel lblResult = new JLabel("Resultado");

		logicGates.setBorder(
				new TitledBorder(null, "Seleccione compuerta", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		logicGates.setBounds(15, 16, 274, 241);
		frame.getContentPane().add(logicGates);
		GridBagLayout gbl_logicGates = new GridBagLayout();
		gbl_logicGates.columnWidths = new int[] { 131, 131, 0 };
		gbl_logicGates.rowHeights = new int[] { 212, 0 };
		gbl_logicGates.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_logicGates.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		logicGates.setLayout(gbl_logicGates);

		buttonGroup.add(btnAnd);
		GridBagConstraints gbc_btnAnd = new GridBagConstraints();
		gbc_btnAnd.fill = GridBagConstraints.BOTH;
		gbc_btnAnd.insets = new Insets(15, 10, 15, 5);
		gbc_btnAnd.gridx = 0;
		gbc_btnAnd.gridy = 0;
		logicGates.add(btnAnd, gbc_btnAnd);

		buttonGroup.add(btnOr);
		GridBagConstraints gbc_btnOr = new GridBagConstraints();
		gbc_btnOr.insets = new Insets(15, 5, 15, 10);
		gbc_btnOr.fill = GridBagConstraints.BOTH;
		gbc_btnOr.gridx = 1;
		gbc_btnOr.gridy = 0;
		logicGates.add(btnOr, gbc_btnOr);

		panel_1.setBorder(new TitledBorder(null, "Ingrese valores", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(304, 16, 275, 241);
		frame.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 130, 130 };
		gbl_panel_1.rowHeights = new int[] { 34, 34, 34, 34, 34 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		lblEntrada1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEntrada1.setLabelFor(spnIncome1);
		GridBagConstraints gbc_lblEntrada1 = new GridBagConstraints();
		gbc_lblEntrada1.fill = GridBagConstraints.BOTH;
		gbc_lblEntrada1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntrada1.gridx = 0;
		gbc_lblEntrada1.gridy = 0;
		panel_1.add(lblEntrada1, gbc_lblEntrada1);

		lblEntrada2.setLabelFor(spnIncome2);
		GridBagConstraints gbc_lblEntrada2 = new GridBagConstraints();
		gbc_lblEntrada2.fill = GridBagConstraints.BOTH;
		gbc_lblEntrada2.insets = new Insets(0, 5, 5, 0);
		gbc_lblEntrada2.gridx = 1;
		gbc_lblEntrada2.gridy = 0;
		panel_1.add(lblEntrada2, gbc_lblEntrada2);

		spnIncome1.setModel(new SpinnerNumberModel(0, 0, 1, 1));
		GridBagConstraints gbc_spnIncome1 = new GridBagConstraints();
		gbc_spnIncome1.fill = GridBagConstraints.BOTH;
		gbc_spnIncome1.insets = new Insets(0, 0, 5, 5);
		gbc_spnIncome1.gridx = 0;
		gbc_spnIncome1.gridy = 1;
		panel_1.add(spnIncome1, gbc_spnIncome1);

		spnIncome2.setModel(new SpinnerNumberModel(0, 0, 1, 1));
		GridBagConstraints gbc_spnIncome2 = new GridBagConstraints();
		gbc_spnIncome2.insets = new Insets(0, 5, 5, 0);
		gbc_spnIncome2.fill = GridBagConstraints.BOTH;
		gbc_spnIncome2.gridx = 1;
		gbc_spnIncome2.gridy = 1;
		panel_1.add(spnIncome2, gbc_spnIncome2);

		JButton btnCalcularSalida = new JButton("Calcular Salida");

		GridBagConstraints gbc_btnCalcularSalida = new GridBagConstraints();
		gbc_btnCalcularSalida.insets = new Insets(0, 0, 10, 0);
		gbc_btnCalcularSalida.gridwidth = 2;
		gbc_btnCalcularSalida.gridx = 0;
		gbc_btnCalcularSalida.gridy = 2;
		panel_1.add(btnCalcularSalida, gbc_btnCalcularSalida);

		GridBagConstraints gbc_lblGate = new GridBagConstraints();
		gbc_lblGate.anchor = GridBagConstraints.WEST;
		gbc_lblGate.insets = new Insets(0, 0, 5, 5);
		gbc_lblGate.gridx = 0;
		gbc_lblGate.gridy = 3;
		panel_1.add(lblGate, gbc_lblGate);

		txtGate = new JTextField();
		lblGate.setLabelFor(txtGate);
		txtGate.setEnabled(false);
		GridBagConstraints gbc_txtGate = new GridBagConstraints();
		gbc_txtGate.insets = new Insets(0, 0, 5, 0);
		gbc_txtGate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGate.gridx = 1;
		gbc_txtGate.gridy = 3;
		panel_1.add(txtGate, gbc_txtGate);
		txtGate.setColumns(10);

		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.WEST;
		gbc_lblResult.insets = new Insets(0, 0, 0, 5);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 4;
		panel_1.add(lblResult, gbc_lblResult);

		txtResult = new JTextField();
		lblResult.setLabelFor(txtResult);
		txtResult.setEnabled(false);
		txtResult.setColumns(10);
		GridBagConstraints gbc_txtResult = new GridBagConstraints();
		gbc_txtResult.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtResult.gridx = 1;
		gbc_txtResult.gridy = 4;
		panel_1.add(txtResult, gbc_txtResult);

		btnAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JToggleButton btn = (JToggleButton) e.getSource();
				
				txtGate.setText(btn.getText());
				trainingFileAnd = JOptionPane.showInputDialog(null, "Ingrese la ruta del archivo de entrenamiento (La estructura de línea debe ser de 3 dígitos separados por espacios)", 
						"C:\\Users\\wilmer.cordoba\\Desktop\\entrenamientoAND.txt");
			}
		});

		btnOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JToggleButton btn = (JToggleButton) e.getSource();
				txtGate.setText(btn.getText());
				trainingFileOr = JOptionPane.showInputDialog(null, "Ingrese la ruta del archivo de entrenamiento (La estructura de línea debe ser de 3 dígitos separados por espacios)", 
						"C:\\Users\\wilmer.cordoba\\Desktop\\entrenamientoOR.txt");
			}
		});

		btnCalcularSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtGate.getText());
				if (txtGate.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Seleccione una compuerta", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Neuron n = new Neuron();
				n.train(getTrainingData());
				
				int predictedValue = n.test((int)spnIncome1.getValue(), (int)spnIncome2.getValue());
				
				txtResult.setText(String.valueOf(predictedValue));
			}
		});
	}
	
	private int[][] getTrainingData() {
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		List<int[]> rows = new ArrayList<int[]>();
		int[][] trainingData;
		int counter = 0;
		String fileName = txtGate.getText().equals("AND") ? this.trainingFileAnd : this.trainingFileOr;

		try {
			file = new File(fileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) {
				int[] lineInt = new int[3];
				String[] data = line.split(" ");
				for (int i = 0; i < data.length; i++) {
					int income = Integer.parseInt(data[i]);
					lineInt[i] = income;
				}
				rows.add(lineInt);
			}
			
			trainingData =  new int[rows.size()][3];
			
			counter = 0;
			
			for (int[] row : rows) {
				trainingData[counter] = row;
				counter++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			trainingData = new int[1][1];
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return trainingData;
	}
}
