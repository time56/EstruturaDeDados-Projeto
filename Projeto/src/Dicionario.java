import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import Dicionario.*;


public class Dicionario {
	static HashTableMultiMap<Integer, String> D = new HashTableMultiMap<Integer, String>();
	static Scanner entrada = new Scanner(System.in);
	
	public static void initDicionario() {
		int aparece = 0;
		
		do {
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Aqui criamos um TAD-Dicion�rio com a chave do tipo Inteiro e o valor do tipo String.\r\n \r\n"
					+"Escolha a op��o desejada para o TAD-Dicion�rio:\r\n"
					+"1.Defini��o.\r\n"
					+"2.Verificar n�mero de elementos no Dicion�rio. \r\n"
					+"3.Verificar se o Dicion�rio est� vazio.\r\n"
					+"4.Obter uma entrada a partir de uma chave informada.\r\n"
					+"5.Obter uma cole��o de todas as entradas a partir de uma chave informada.\r\n"
					+"6.Inserir uma entrada no Dicion�rio.\r\n"
					+"7.Remover uma entrada a partir da chave e do valor informado.\r\n"
					+"8.Obter uma cole��o com todas as entradas do Dicion�rio.\r\n"
					+"9.Sair do TAD-Dicion�rio e retornar ao menu principal.");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 9 || aparece <=0) {
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
				tamanho();
				aparece = 0;
				break;
			case 3:
				vazio();
				aparece = 0;
				break;
			case 4:
				obterEntrada();
				aparece = 0;
				break;
			case 5:
				obterTodos();
				aparece = 0;
				break;
			case 6:
				inserir();
				aparece = 0;
				break;
			case 7:
				remover();
				aparece = 0;
				break;
			case 8:
				todasEntradas();
				aparece = 0;
				break;
			case 9:
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
		System.out.print("Dicion�rios armazenam pares do tipo chave-valor (k, v) que s�o chamadas de entradas "
				+"onde as chaves e valores podem ser de qualquer tipo.\r\n"
				+"Para nosso exemplo de demonstra��o do TAD-Dicion�rio foi utilizado uma chave do tipo inteiro e o valor do tipo String.\r\n"
				+"Os dicion�rios podem ter m�ltiplas entradas com a mesma chave, semelhante a um dicion�rio de idiomas tradicional"
				+ " que pode ter m�ltiplas \r\ndefini��es para a mesma palavra.\r\n \r\n");
		
		System.out.println("O TAD-Dicion�rio possui os seguintes m�todos:\r\n \r\n"
				+"*size(): Retorna o n�mero de elementos do Dicion�rio.\r\n"
				+"*isEmpty(): Testa se o Dicion�rio est� vazio.\r\n"
				+"*get(k): Se o Dicion�rio cont�m um elemento com chave igual a k, ent�o retorna o elemento, sen�o retorna null.\r\n"
				+"*getAll(k): Retorna uma cole��o iter�vel contendo todos os elementos com chave igual a k.\r\n"
				+"*put(k,v): Insere um elemento com chave k e valor v no Dicion�rio, retornando o elemento criado.\r\n"
				+"*remove(e): Remove do Dicion�rio um elemento e, retornando o elemento removido, sen�o retorna null.\r\n"
				+"*entrySet(): Retorna uma cole��o iter�vel dos elementos chave-valor do Dicion�rio.");
		initDicionario();
	}		
	
	public static void tamanho() {
		System.out.println("O tamanho do Dicion�rio �: " + D.size());
		initDicionario();
	}
	
	public static void vazio() {
		if (D.isEmpty()) {
			System.out.println("O Dicion�rio est� vazio!");
		} else {
			System.out.println("O Dicion�rio n�o est� vazio!");
		}
		initDicionario();
	}
	
	public static void obterEntrada() {
		System.out.println("Digite a chave que deseja buscar: ");
		int elemento = entrada.nextInt();
		if (D.get(elemento) == null) {
			System.out.println("N�o h� entradas com essa chave no Dicion�rio.");
		} else {
			System.out.println("A primeira entrada no Dicion�rio com a chave " + elemento + " � a " + D.get(elemento));
		}
		initDicionario();
	}
	
	public static void obterTodos() {
		System.out.println("Digite a chave que deseja buscar: ");
		int elemento = entrada.nextInt();
		if (D.getAll(elemento) == null) {
			System.out.println("N�o h� entradas com essa chave no Dicion�rio.");
		} else {
			System.out.println("As entradas que possuem essa chave s�o: " + D.getAll(elemento));
		}
		initDicionario();
	}
	
	public static void inserir() {
		System.out.println("Digite a chave(Inteiro) que deseja inserir: ");
		int chave = entrada.nextInt();
		
		System.out.println("Digite o valor(String) que deseja inserir: ");
		String valor = entrada.next();
		
		D.put(chave, valor);
		System.out.println("Entrada inserida com sucesso!");
		initDicionario();
	}
	
	public static void remover() {
		System.out.println("Digite a chave(Inteiro) que deseja remover: ");
		int chave = entrada.nextInt();
		
		System.out.println("Digite o valor(String) que deseja remover: ");
		String valor = entrada.next();
		
		Map.Entry<Integer, String> e = new AbstractMap.SimpleEntry<Integer, String>(chave, valor);
		
		D.remove(e);
		System.out.println("Entrada removida com sucesso!");
		initDicionario();
	}
	
	public static void todasEntradas() {
		if(D.isEmpty()) {
			System.out.println("N�o h� entradas no Dicion�rio.");
		} else {
			System.out.println("As entradas do Dicion�rio s�o: " + D.entrySet());
		}
		initDicionario();
	}
}
