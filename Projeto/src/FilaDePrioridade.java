import java.util.Scanner;

import FilaPrioridades.*;

public class FilaDePrioridade {
	static SortedListPriorityQueue<Integer, String> P = new SortedListPriorityQueue<Integer, String>();
	static Scanner entrada = new Scanner(System.in);
	
	public static void initFilaPrioridade() {
			
		int aparece = 0;
		
		do {
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.println("Aqui criamos um TAD-Fila de Prioridades com a chave sendo um inteiro e o valor sendo uma string \r\n"
					+ "Escolha a opção desejada para o TAD-Fila de Prioridades: \r\n \r\n"
					+ "1.Definição \r\n"
					+ "2.Verificar tamanho da Fila de Prioridades. \r\n"
					+ "3.Testar se a Fila de Prioridades está vazia. \r\n"
					+ "4.Verificar qual entrada com a menor chave da Fila de Prioridades. \r\n"
					+ "5.Inserir uma entrada passando uma chave e um valor. \r\n"
					+ "6.Remover a entrada com a menor chave da Fila de Prioridades. \r\n"
					+ "7.Exibir a Fila de Prioridades completa.\r\n"
					+ "8.Sair do TAD Fila de Prioridades e retornar ao menu principal.");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 8 || aparece <=0) {
					System.out.println("Opção inválida, digite uma opção válida: ");
					aparece = entrada.nextInt();
				}
			}catch (Exception e) {
				System.out.println("Você deve digitar apenas os números disponíveis da lista!");
			}	
			
			switch(aparece) {	
			case 1:				
				definicao();	
				aparece = 0;
				break;
			case 2:
				tamanho();
				aparece = 0;
				break;
			case 3:
				vazio();
				aparece = 0;
				break;
			case 4:
				menor();
				aparece = 0;
				break;
			case 5:
				inserir();
				aparece = 0;
				break;
			case 6:
				removerMinimo();
				aparece = 0;
				break;
			case 7:
				exibir();
				aparece = 0;
				break;
			case 8:
				Principal.init();
				aparece = 0;
				break;
			default:
				aparece = 0;			
			}

		}while(aparece != 0);
		
	}
	
	public static void definicao() {
		System.out.print("Definição: ");
		System.out.println("A Fila de Prioridades armazena uma coleção de elementos priorizados\r\n"
				+ "que suporta a inserção de elementos arbitrários, mas a remoção de\r\n"
				+ "elementos ocorre em ordem de prioridade. \r\n");
				
		System.out.println("A fila de prioridade armazena elementos de acordo com suas\r\n"
				+ "prioridades e não tem noção de “posição”.\r\n"
				+ "Uma fila de prioridade é um contêiner de elementos, cada um tendo\r\n"
				+ "uma chave associada atribuída no instante em que o elemento é\r\n"
				+ "inserido.\r\n");
		
		System.out.println("Um par chave-valor inserido em uma fila com prioridade é chamado\r\n"
				+ "de uma entrada da fila com prioridade.\r\n");
		
		System.out.println("Como um TAD, uma Fila de Prioridades tem os seguintes métodos:\r\n"
				+ "* size()       = retorna o número de entradas na Fila de Prioridades. \r\n"
				+ "* isEmpty()    = Testa se a Fila de Prioridades está vazia. \r\n"
				+ "* min()        = Retorna uma entrada da Fila de Prioridades com a menor chave. \r\n"
				+ "* insert(k, x) = Insere na Fila de Prioridades a chave k com valor x e retorna a entrada armazenada. \r\n"
				+ "* removeMin()  = remove da Fila de Prioridades a entrada com a menor chave. \r\n");
		initFilaPrioridade();
	}
	
	public static void tamanho() {
		System.out.print("O tamanho da Fila de Prioridades é : " + P.size() + "\r\n \r\n");
		initFilaPrioridade();
	}
	
	public static void vazio() {
		if (P.isEmpty()) {
			System.out.println("A Fila de Prioridades está vazia!\r\n");
		} else {
			System.out.println("A Fila de Prioridades não está vazia!\r\n");
		}
		initFilaPrioridade();
	}

	public static void menor() {
		System.out.println("A entrada com a menor chave da Fila de Prioridades é " + P.min());
		initFilaPrioridade();
	}
	
	public static void inserir() {
		System.out.println("Digite um valor inteiro para a chave: ");
		Integer chave = entrada.nextInt();
		
		System.out.println("Digite uma string para o valor: ");
		String valor = entrada.next();
		
		P.insert(chave, valor);
		System.out.println("A entrada foi inserida com sucesso!");
		initFilaPrioridade();
	}
	
	public static void removerMinimo() {
		Entry<Integer, String> removido = P.removeMin();
		System.out.println("A entrada removida foi " + removido);
		initFilaPrioridade();
	}
	
	public static void exibir() {
		System.out.println(P.toString());
		initFilaPrioridade();
	}
}
