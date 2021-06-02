import java.util.Scanner;
import ArvoreBusca.*;

public class MapaOrdernadoAbb {
	static BinarySearchTree<Integer, Integer> A = new BinarySearchTree<Integer, Integer>();
	static Scanner entrada = new Scanner(System.in);
	
	public static void initMapaOrdenado() {
		int aparece = 0;
		
		do {
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Aqui criamos um TAD-Mapa Ordenado ABB com a chave do tipo Inteiro e o valor do tipo Inteiro.\r\n \r\n"
					+"Escolha a op��o desejada para o TAD-Ordenado ABB:\r\n"
					+"1.Defini��o.\r\n"
					+"2.Inserir entrada no Mapa Ordenado.\r\n"
					+"3.Verificar o tamanho do Mapa Ordenado.\r\n"
					+"4.Verificar se o Mapa Ordenado est� vazio.\r\n"
					+"5.Obter o valor de uma entrada a partir da chave.\r\n"
					+"6.Remover uma entrada a partir da chave.\r\n"
					//+"7.Exibir todas as entradas do Mapa Ordenado.\r\n"
					//+"8.Exibir todas as chaves do Mapa Ordenado.\r\n"
					//+"9.Exibir todos os valores do Mapa Ordenado.\r\n"
					+"7.Sair do TAD-Mapa Ordenado ABB.");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 7 || aparece <=0) {
					System.out.println("Op��o inv�lida, digite uma op��o v�lida: ");
					aparece = entrada.nextInt();
				}
			}catch (Exception e) {
				System.out.println("Voc� deve digitar apenas os n�meros dispon�veis da lista!");
			}	
			
			switch(aparece) {	
			case 1:				
				definicao();	
				aparece = 0;
				break;
			case 2:
				insere();
				aparece = 0;
				break;
			case 3:
				tamanho();
				aparece = 0;
				break;
			case 4:
				vazio();
				aparece = 0;
				break;
			case 5:
				obterEntrada();
				aparece = 0;
				break;
			case 6:
				remover();
				aparece = 0;
				break;
			/*case 7:
				exibir();
				aparece = 0;
				break;
			case 7:
				todasEntradas();
				aparece = 0;
				break;
			case 8:
				chaves();
				aparece = 0;
				break;
			case 9:
				valores();
				aparece = 0;
				break;*/
			case 7:
				Principal.init();
				aparece = 0;
				break;
			default:
				aparece = 0;			
			}

		}while(aparece != 0);
	}
	
	public static void definicao() {
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("DEFINI��O:\r\n");
		System.out.println("As �rvores de pesquisa s�o �rvores que podem implementar mapas.\r\n"
				+"Uma �rvore bin�ria de pesquisa � uma �rvore bin�ria T, em que cada nodo interno v de T armazena um elemento (k, x) que:\r\n"
				+"As chaves nos nodos da sub�rvore esquerda de v s�o menores ou iguais a k.\r\n"
				+"As chaves nos nodos da sub�rvore direita de v s�o maiores ou iguais a k.\r\n");
		
		System.out.println("Dessa forma, as chaves de T permitem pesquisar uma chave k comparando cada nodo interno v, que pode parar em v ou continuar\r\n"
				+"nos filhos � esquerda ou � direita de v.\r\n"
				+"Uma �rvore bin�ria de pesquisa deve representar de forma hier�rquica a ordena��o de suas chaves, usando relacionamentos\r\n"
				+ "entre pais e filhos.\r\n");
		
		System.out.println("O TAD-Ordenado ABB possui alguns m�todos como:\r\n"
				+"*insertAtExternal(Position<Entry<K, V>> v, Entry<K, V> e): Insere um elemento em um nodo externo\r\n"
				+"*removeExternal(Position<Entry<K, V>> v): Remove um nodo externo e seu pai\r\n"
				+"*size(): Retorna o tamanho da �rvore\r\n"
				+"*isEmpty(): Retorna um booleano indicando se a �rvore est� ou n�o vazia.\r\n"
				+"*get(K key): Retorna o valor v da entrada (k,v), com chave igual a k, se existir.\r\n"
				+"*put(K k, V x): Insere a entrada (k,v) conforme o mapeamento de k para v.\r\n"
				+"*remove(k): Remove a entrada com chave igual a k e retorna seu valor.\r\n"
				+"*entrySet(): Retorna uma cole��o iter�vel com todas as entradas da �rvore\r\n"
				+"*values(): Retorna uma cole��o iterable contendo todos os valores da �rvore\r\n"
				+"*keySet(): Retorna uma cole��o iterable contendo todas as chaves da �rvore\r\n"
				+"*printExpression(Position<Entry<K, V>> v): Exibe a express�o parentizada da �rvore");
		initMapaOrdenado();
	}
	
	public static void insere() {
		System.out.println("Digite um n�mero inteiro para a chave: ");
		int chave = entrada.nextInt();
		
		System.out.println("Digite um n�mero inteiro para o valor: ");
		int valor = entrada.nextInt();
		
		A.put(chave, valor);
		System.out.println("Entrada Inserida com sucesso!");
		initMapaOrdenado();
	}
	
	public static void tamanho() {
		System.out.println("O tamanho do Mapa Ordenado �: " + A.size());
		initMapaOrdenado();
	}
	
	public static void vazio() {
		if(A.isEmpty()) {
			System.out.println("O Mapa Ordenado est� vazio!");
		} else {
			System.out.println("O Mapa Ordenado n�o est� vazio!");
		}
		initMapaOrdenado();
	}
	
	public static void obterEntrada() {
		System.out.println("Digite a chave que deseja buscar: ");
		int chave = entrada.nextInt();
	
		if(A.get(chave) == null) {
			System.out.println("N�o h� entradas com essa chave no Mapa Ordenado.");
		} else {
			System.out.println("O valor para essa chave �: " + A.get(chave));
		}
		initMapaOrdenado();
	}
	
	public static void remover() {
		System.out.println("Digite a chave que deseja remover: ");
		int chave = entrada.nextInt();
		
		if(A.remove(chave) == null) {
			System.out.println("N�o h� entradas com essa chave no Mapa Ordenado.");
		} else {
			A.remove(chave);
			System.out.println("Entrada removida com sucesso!");
			initMapaOrdenado();
		}
		initMapaOrdenado();
	}
	
	public static void todasEntradas() {
		if(A.isEmpty()) {
			System.out.println("N�o h� entradas no Mapa Ordenado.");
		} else {
			System.out.println("As entradas existentes no Mapa Ordenado s�o: " + A.entrySet());
		}
		initMapaOrdenado();
	}
	
	public static void chaves() {
		if(A.isEmpty()) {
			System.out.println("N�o h� entradas no Mapa Ordenado.");
		} else {
			System.out.println("As chaves existentes no Mapa Ordenado s�o: " + A.keySet());
		}
		initMapaOrdenado();
	}
	
	public static void valores() {
		if(A.isEmpty()) {
			System.out.println("N�o h� entradas no Mapa Ordenado.");
		} else {
			System.out.println("Os valores existentes no Mapa Ordenado s�o: " + A.values());
		}
		initMapaOrdenado();
	}
}
