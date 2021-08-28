package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadCorridaSapos extends Thread {
	
	private String nomeSapo;
	private List<String> colocacao = new ArrayList<String>();
	private int tamMaxSalto, distMaxCorrida, saltoSapo;
	private int distPercorrida = 0;
	
	public ThreadCorridaSapos(String nomeSapo, List<String> colocacao, int tamMaxSalto, int distMaxCorrida) {
		this.nomeSapo = nomeSapo;
		this.colocacao = colocacao;
		this.tamMaxSalto = tamMaxSalto;
		this.distMaxCorrida = distMaxCorrida;
	}
	
	@Override
	public void run() {
		eventoCorrida();
	}

	private void eventoCorrida() {
		Random salto = new Random();
				
		corrida(salto);
		colocacao.add(nomeSapo);
		
		if (colocacao.size() == 5) {
			posicaoSapos();
		}		
	}

	private int corrida(Random saltar) {	
		if (distPercorrida == distMaxCorrida) {
			System.out.println("-------- " + nomeSapo + " chegou ---------");		
			return 0;
		} else {
			saltoSapo = saltar.nextInt(tamMaxSalto);
			distPercorrida += saltoSapo;
			System.out.println("O "+ nomeSapo + " saltou " + saltoSapo + "m e percorreu " + distPercorrida + "m.");
			if (distPercorrida > distMaxCorrida) {
				distPercorrida = distMaxCorrida;
				return corrida(saltar);
			} else {
				return corrida(saltar);
			}
		}
	}

	private void posicaoSapos() {
		for (int i = 0; i < colocacao.size(); i++) { 
			System.out.println((i+1) + "º colocado: "+ colocacao.get(i));
		}
	}
}
