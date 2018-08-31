package unlam.edu.pa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LetrasExtremas {
	public static void main(String args[]) throws IOException {
		String path = "archivos\\";
		int fPalabraDuplicada;
		int[] contLetras = new int[26];
		char[] letrasMax = new char[26];
		String palabraActual;
		ArrayList<String> palabras = new ArrayList<>();
		inicializaVectorEntero(contLetras);
		File entrada = new File(path + "extremas.in");
		Scanner sc = new Scanner(entrada);
		int cantPalabras = sc.nextInt();

		for (int i = 0; i < cantPalabras; i++) {
			palabraActual = sc.next();
			contLetras[palabraActual.charAt(0) - 97]++;
			contLetras[palabraActual.charAt(palabraActual.length() - 1) - 97]++;
			palabras.add(palabraActual);
		}

		letrasMax = devuelveLetrasMayores(contLetras);
		Set<String> palabrasSinRepetir = new HashSet<String>(palabras);
		palabras.clear();
		palabras.addAll(palabrasSinRepetir);
		PrintWriter salida = new PrintWriter(new FileWriter(path + "extremas.out"));
		for (int i = 0; i < letrasMax.length; i++) {
			if (letrasMax[i] != 0)
				salida.print(letrasMax[i] + " ");
		}
		salida.println();
		for (int i = 0; i < palabras.size(); i++) {
			fPalabraDuplicada = 0;
			for (int j = 0; j < letrasMax.length; j++) {
				if ((palabras.get(i).charAt(0) == letrasMax[j]
						|| palabras.get(i).charAt(palabras.get(i).length() - 1) == letrasMax[j])
						&& fPalabraDuplicada == 0) {
					salida.println(palabras.get(i));
					fPalabraDuplicada = 1;
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
