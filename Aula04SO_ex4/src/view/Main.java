package view;

import java.util.ArrayList;
import java.util.List;

import controller.ThreadCorridaSapos;

public class Main {
	
	public static void main(String[] args) {
		String sapos[] = {"Hevert", "Principe", "NaLagoa", "Sapotouille", "Sapopemba"};
		List<String> colocacao = new ArrayList<String>();
		
		for (int i = 0; i < 5; i++) {
			Thread tCorrida = new ThreadCorridaSapos(sapos[i], colocacao, 2, 10);
			tCorrida.start();
		}
	}
}
