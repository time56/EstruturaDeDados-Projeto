import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int aparece = 0;			
		
		do {
			System.out.println("Escolha a opção desejada: ");
			System.out.println();
			System.out.println("1.TAD-Lista Arranjo");
			System.out.println();
			System.out.println("2.TAD-Pilha");
			System.out.println();
			System.out.println("3.TAD-Fila");
			System.out.println();
			System.out.println("4.TAD-Lista de Nodos");
			System.out.println();
			System.out.println("5.TAD-Árvore Genérica");
			System.out.println();
			System.out.println("6.TAD-Árvore Binária");
			System.out.println();
			System.out.println("7.TAD-Fila de Prioridade");
			System.out.println();
			System.out.println("8.TAD-Mapa");
			System.out.println();
			System.out.println("9.TAD-Dicionário");
			System.out.println();
			System.out.println("10.TAD-Mapa Ordernado - ABB");
			System.out.println();
			System.out.println("11.TAD-Mapa Ordernado - AVL");
			System.out.println();
			System.out.println("12.TAD-Grafos");
			System.out.println();
				
			try {
				aparece = entrada.nextInt();
				while(aparece > 12 || aparece <=0) {
					System.out.println("Opção inválida, digite uma opção válida: ");
					aparece = entrada.nextInt();
				}
			}catch (Exception e) {
				System.out.println("Você deve digitar apenas os números disponíveis da lista!");
			}
	
			
			switch(aparece) {	
			case 1:
				ListaArranjo.teste();
				aparece = 0;
				break;
			case 2:
				Pilha.teste();
				aparece = 0;
				break;
			case 3:
				Fila.teste();
				aparece = 0;
				break;
			case 4:
				ListaDeNodos.teste();
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
				FilaDePrioridade.teste();
				aparece = 0;
				break;
			case 8:
				Mapa.teste();
				aparece = 0;
				break;
			case 9:
				Dicionario.teste();
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
			default:
				aparece = 0;				
			}

		}while(aparece != 0);
		
		entrada.close();

	}		
}
