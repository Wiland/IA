package ui;

import java.util.Random;

public class Neuron {
	private double w1 = 0d;
	private double w2 = 0d;
	private double tetha = 0d;

	public void train(int[][] incomeData) {
		System.out.println("\nGenerar pesos aleatorios iniciales\n");
		double weight1 = new Random().nextDouble() / 2.5; // Se divide para generar valores próximos a 0
		double weight2 = new Random().nextDouble() / 2.5; // Se divide para generar valores próximos a 0
		double tetha = -0.4;
		final double E = 0.5; // Factor de aprendizaje

		double y = 0;

		System.out.println("Peso 1: " + weight1);
		System.out.println("Peso 2: " + weight2);
		System.out.println("Tetha: " + tetha);

		System.out.println("\nIniciar fase de aprendizaje (función de activación tanh(y))\n");
		int i = 0;
		int cont = 1;

		while (i < incomeData.length && cont < 1000) {
			y = Math.tanh((transformInput(incomeData[i][0]) * weight1) + (transformInput(incomeData[i][1]) * weight2) + (-1 * tetha));
			y = (y >= tetha) ? 1 : -1;

			System.out.println("Entrada[" + transformOutput(incomeData[i][0]) + "," + transformOutput(incomeData[i][1])
					+ "]) Salida esperada[" + transformOutput(incomeData[i][2]) + "] Salida obtenida[" + transformOutput((int) y)
					+ "]");

			if (y == transformInput(incomeData[i][2])) {
				i++;
			} else {
				System.out.println("No se obtuvo el valor esperado. Se reajustan pesos");
				// Ajuste de pesos
				weight1 = weight1 + E * (transformInput(incomeData[i][2]) - y) * transformInput(incomeData[i][0]);
				weight2 = weight2 + E * (transformInput(incomeData[i][2]) - y) * transformInput(incomeData[i][1]);
				tetha = tetha + 2 * E * transformInput(incomeData[i][2]) * (-1);

				System.out.println("\nAjuste de pesos (" + cont + "):");
				System.out.println("Peso 1: " + weight1);
				System.out.println("Peso 2: " + weight2);
				System.out.println("Tetha: " + tetha + "\n");
				cont++;
				i = 0;
			}
		}
		
		this.w1 = weight1;
		this.w2 = weight1;
		this.tetha = tetha;

		System.out.println("\nFase de aprendizaje terminada");
		System.out.println("\nResultados:");
		System.out.println("Peso 1: " + weight1);
		System.out.println("Peso 2: " + weight2);
		System.out.println("Tetha: " + tetha);
	}

	private int transformOutput(int output) {
		return output < 0 ? 0 : 1;
	}
	
	private int transformInput(int input) {
		return input > 0 ? 1 : -1;
	}
	
	public int test(int income1, int income2) {
		double y = 0;
		System.out.println("\nIniciando fase de testeo...");
        System.out.println("Entrada 1 (X1): " + income1);

        System.out.println("Introduce Entrada 2 (X2): " + income2);
        
        int v1 = income1 > 0 ? 1 : -1;
        int v2 = income2 > 0 ? 1 : -1;

        y = Math.tanh((v1 * this.w1) + (v2 * this.w2) + (-1 * this.tetha));
        y = (y >= this.tetha) ? 1 : -1;

        System.out.println("\nSalida: " + (int)y);
        
        return transformOutput((int)y);
	}
}
