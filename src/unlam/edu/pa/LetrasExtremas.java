package unlam.edu.pa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LetrasExtremas {
	public static void main(String args[]) throws IOException {
		int fPalabraDuplicada;
		int[] contLetras = new int[26];
		char[] letrasMax = new char[26];
		inicializaVectorEntero(contLetras);
		File entrada = new File("extremas.in");
		Scanner sc = new Scanner(entrada);
		String[] palabras = new String[sc.nextInt()];

		for (int i = 0; i < palabras.length; i++) {
			palabras[i] = sc.next();
			contLetras[palabras[i].charAt(0) - 97]++;
			contLetras[palabras[i].charAt(palabras[i].length() - 1) - 97]++;
		}
		letrasMax = devuelveLetrasMayores(contLetras);
		PrintWriter salida = new PrintWriter(new FileWriter("extremas.out"));
		for (int i = 0; i < letrasMax.length; i++) {
			if (letrasMax[i] != 0)
				salida.print(letrasMax[i] + " ");
		}
		salida.println();
		for (int i = 0; i < palabras.length; i++) {
			fPalabraDuplicada = 0;
			for (int j = 0; j < letrasMax.length; j++) {
				if ((palabras[i].charAt(0) == letrasMax[j]
						|| palabras[i].charAt(palabras[i].length()-1) == letrasMax[j]) && fPalabraDuplicada == 0) {
					{
						salida.println(palabras[i]);
						fPalabraDuplicada = 1;
					}
				}
			}
		}
		sc.close();
		salida.close();
	}

	public static char[] devuelveLetrasMayores(int[] vec) {
		int cantidadMayor = vec[0];
		int pos = 1;
		char[] letraMayor = new char[26];
		inicializaVectorChar(letraMayor);
		letraMayor[0] = 'a';

		for (int i = 1; i < vec.length; i++) {
			if (vec[i] > cantidadMayor) {
				cantidadMayor = vec[i];
				letraMayor[0] = Character.valueOf((char) (i + 97));
			}
		}

		for (int i = 0; i < vec.length; i++) {
			if (vec[i] == cantidadMayor && (Character.valueOf((char) (i + 97))) != letraMayor[0]) {
				letraMayor[pos] = Character.valueOf((char) (i + 97));
				pos++;
			}
		}

		return letraMayor;
	}

	public static void inicializaVectorEntero(int[] vec) {
		for (int i = 0; i < vec.length; i++) {
			vec[i] = 0;
		}
	}

	public static void inicializaVectorChar(char[] vec) {
		for (int i = 0; i < vec.length; i++) {
			vec[i] = 0;
		}
	}

}
