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
			System.out.println("Aqui criamos um TAD-Dicionário com a chave do tipo Inteiro e o valor do tipo String.\r\n \r\n"
					+"Escolha a opção desejada para o TAD-Dicionário:\r\n"
					+"1.Definição.\r\n"
					+"2.Verificar número de elementos no Dicionário. \r\n"
					+"3.Verificar se o Dicionário está vazio.\r\n"
					+"4.Obter uma entrada a partir de uma chave informada.\r\n"
					+"5.Obter uma coleção de todas as entradas a partir de uma chave informada.\r\n"
					+"6.Inserir uma entrada no Dicionário.\r\n"
					+"7.Remover uma entrada a partir da chave e do valor informado.\r\n"
					+"8.Obter uma coleção com todas as entradas do Dicionário.\r\n"
					+"9.Sair do TAD-Dicionário e retornar ao menu principal.");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 9 || aparece <=0) {
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
		System.out.println("DEFINIÇÃO:\r\n");
		System.out.print("Dicionários armazenam pares do tipo chave-valor (k, v) que são chamadas de entradas "
				+"onde as chaves e valores podem ser de qualquer tipo.\r\n"
				+"Para nosso exemplo de demonstração do TAD-Dicionário foi utilizado uma chave do tipo inteiro e o valor do tipo String.\r\n"
				+"Os dicionários podem ter múltiplas entradas com a mesma chave, semelhante a um dicionário de idiomas tradicional"
				+ " que pode ter múltiplas \r\ndefinições para a mesma palavra.\r\n \r\n");
		
		System.out.println("O TAD-Dicionário possui os seguintes métodos:\r\n \r\n"
				+"*size(): Retorna o número de elementos do Dicionário.\r\n"
				+"*isEmpty(): Testa se o Dicionário está vazio.\r\n"
				+"*get(k): Se o Dicionário contém um elemento com chave igual a k, então retorna o elemento, senão retorna null.\r\n"
				+"*getAll(k): Retorna uma coleção iterável contendo todos os elementos com chave igual a k.\r\n"
				+"*put(k,v): Insere um elemento com chave k e valor v no Dicionário, retornando o elemento criado.\r\n"
				+"*remove(e): Remove do Dicionário um elemento e, retornando o elemento removido, senão retorna null.\r\n"
				+"*entrySet(): Retorna uma coleção iterável dos elementos chave-valor do Dicionário.");
		initDicionario();
	}		
	
	public static void tamanho() {
		System.out.println("O tamanho do Dicionário é: " + D.size());
		initDicionario();
	}
	
	public static void vazio() {
		if (D.isEmpty()) {
			System.out.println("O Dicionário está vazio!");
		} else {
			System.out.println("O Dicionário não está vazio!");
		}
		initDicionario();
	}
	
	public static void obterEntrada() {
		System.out.println("Digite a chave que deseja buscar: ");
		int elemento = entrada.nextInt();
		if (D.get(elemento) == null) {
			System.out.println("Não há entradas com essa chave no Dicionário.");
		} else {
			System.out.println("A primeira entrada no Dicionário com a chave " + elemento + " é a " + D.get(elemento));
		}
		initDicionario();
	}
	
	public static void obterTodos() {
		System.out.println("Digite a chave que deseja buscar: ");
		int elemento = entrada.nextInt();
		if (D.getAll(elemento) == null) {
			System.out.println("Não há entradas com essa chave no Dicionário.");
		} else {
			System.out.println("As entradas que possuem essa chave são: " + D.getAll(elemento));
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
			System.out.println("Não há entradas no Dicionário.");
		} else {
			System.out.println("As entradas do Dicionário são: " + D.entrySet());
		}
		initDicionario();
	}
}
