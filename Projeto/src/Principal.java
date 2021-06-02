import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args) {
		
		init();
		
	}		

	public static void init() {
		
		Scanner entrada = new Scanner(System.in);
		
		int aparece = 0;			
		
		do {
			System.out.println("Escolha a opção desejada: \r\n \r\n"
					+ "1.TAD-Lista Arranjo \r\n \r\n"
					+ "2.TAD-Pilha \r\n \r\n"
					+ "3.TAD-Fila \r\n \r\n"
					+ "4.TAD-Lista de Nodos \r\n \r\n"
					+ "5.TAD-Árvore Genérica \r\n \r\n"
					+ "6.TAD-Árvore Binária \r\n \r\n"
					+ "7.TAD-Fila de Prioridade \r\n \r\n"
					+ "8.TAD-Mapa \r\n \r\n"
					+ "9.TAD-Dicionário \r\n \r\n"
					+ "10.TAD-Mapa Ordernado - ABB \r\n \r\n"
					+ "11.TAD-Mapa Ordernado - AVL \r\n \r\n"
					+ "12.TAD-Grafos \r\n \r\n"
					+ "13. Sair \r\n \r\n");
			try {
				aparece = entrada.nextInt();
				while(aparece > 13 || aparece <=0) {
					System.out.println("Opção inválida, digite uma opção válida: ");
					aparece = entrada.nextInt();
				}
			}catch (Exception e) {
				System.out.println("Você deve digitar apenas os números disponíveis da lista!");
			}	
			
			switch(aparece) {	
			case 1:
				ListaArranjo.initListaArranjo();
				aparece = 0;
				break;
			case 2:
				Pilha.initPilha();
				aparece = 0;
				break;
			case 3:
				Fila.initFila();
				aparece = 0;
				break;
			case 4:
				ListaDeNodos.initListaNodos();
				aparece = 0;
				break;
			case 5:
				ArvoreGenerica.teste();
				aparece = 0;
				break;
			case 6:
				ArvoreBinaria.teste();
				aparece = 0;
				break;
			case 7:
				FilaDePrioridade.initFilaPrioridade();
				aparece = 0;
				break;
			case 8:
				Mapa.initMapa();
				aparece = 0;
				break;
			case 9:
				Dicionario.initDicionario();
				aparece = 0;
				break;
			case 10:
				MapaOrdernadoAbb.teste();
				aparece = 0;
				break;
			case 11:
				MapaOrdenadoAvl.teste();
				aparece = 0;
				break;
			case 12:
				Grafos.teste();
				aparece = 0;
				break;
			case 13:
				aparece = 0;
				break;
			default:
				aparece = 0;				
			}

		}while(aparece != 0);
		
		entrada.close();

		
	}


}
