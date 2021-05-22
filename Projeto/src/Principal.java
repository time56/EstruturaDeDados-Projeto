import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int aparece = 0;			
		
		do {
			System.out.println("Escolha a op��o desejada: \r\n \r\n"
					+ "1.TAD-Lista Arranjo \r\n \r\n"
					+ "2.TAD-Pilha \r\n \r\n"
					+ "3.TAD-Fila \r\n \r\n"
					+ "4.TAD-Lista de Nodos \r\n \r\n"
					+ "5.TAD-�rvore Gen�rica \r\n \r\n"
					+ "6.TAD-�rvore Bin�ria \r\n \r\n"
					+ "7.TAD-Fila de Prioridade \r\n \r\n"
					+ "8.TAD-Mapa \r\n \r\n"
					+ "9.TAD-Dicion�rio \r\n \r\n"
					+ "10.TAD-Mapa Ordernado - ABB \r\n \r\n"
					+ "11.TAD-Mapa Ordernado - AVL \r\n \r\n"
					+ "12.TAD-Grafos \r\n \r\n");
			try {
				aparece = entrada.nextInt();
				while(aparece > 12 || aparece <=0) {
					System.out.println("Op��o inv�lida, digite uma op��o v�lida: ");
					aparece = entrada.nextInt();
				}
			}catch (Exception e) {
				System.out.println("Voc� deve digitar apenas os n�meros dispon�veis da lista!");
			}	
			
			switch(aparece) {	
			case 1:
				ListaArranjo.initListaArranjo();
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
