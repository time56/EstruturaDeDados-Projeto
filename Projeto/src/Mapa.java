import java.util.Scanner;

import Mapa.*;

public class Mapa {
	static HashTableMap<Integer, String> mapa = new HashTableMap<Integer, String>();
	static Scanner entrada = new Scanner(System.in);
	
	public static void initMapa() {
		int aparece = 0;
		
		do {
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Aqui criamos um TAD-Mapa com a chave do tipo Inteiro e o valor do tipo String.\r\n \r\n"
					+"Escolha a opção desejada para o TAD-Mapa:\r\n"
					+"1.Definição.\r\n"
					+"2.Verifica o tamanho do Mapa.\r\n"
					+"3.Verifica se o Mapa está vazio.\r\n"
					+"4.Busca uma entrada a partir da chave(Inteiro) informada.\r\n"
					+"5.Insere uma nova entrada no Mapa informando uma chave(Inteiro) e um valor(String).\r\n"
					+"6.Remove uma entrada através da chave(Inteiro).\r\n"
					+"7.Visualizar todas as chaves inseridas no Mapa.\r\n"
					+"8.Visualizar todos os valores inseridos no Mapa.\r\n"
					+"9.Visualizar todas as entradas do Mapa.\r\n"
					+"10.Sair do TAD-Mapa.");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 10 || aparece <=0) {
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
				inserir();
				aparece = 0;
				break;
			case 6:
				remover();
				aparece = 0;
				break;
			case 7:
				chaves();
				aparece = 0;
				break;
			case 8:
				valores();
				aparece = 0;
				break;
			case 9:
				todasEntradas();
				aparece = 0;
				break;
			case 10:
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
		System.out.println("Mapas permitem armazenar elementos que podem ser localizados rapidamente usando chaves.\r\n"
				+"Um mapa armazena um par chave-valor (k,v), chamado de entrada, onde k é a chave e v é o valor correspondente.\r\n"
				+"O TAD mapa requer que cada chave seja única. A chave pode ser vista como um “endereço” para um objeto.\r\n");
		
		System.out.println("O TAD-Mapa possui os seguintes métodos:\r\n \r\n"
				+"*size(): Retorna o número de entradas do Mapa.\r\n"
				+"*isEmpty(): Testa se o Mapa está vazio.\r\n"
				+"*get(k): Se o Mapa contém uma entrada (e) com chave igual a k, então retorna o valor de e, senão retorna null.\r\n"
				+"*put(k,v): Se o Mapa não tem uma entrada com chave igual a k, então adiciona a entrada (k,v) no Mapa"
				+ " e retorna null, senão,\r\n substitui o valor existente com v com chave k e retorna o valor antigo.\r\n"
				+"*remove(k): Remove a entrada do Mapa com chave igual a k, e retorna seu valor. Se o Mapa não possui a entrada com chave k,\r\n"
				+ " então retorna null.\r\n"
				+"*keySet(): retorna uma coleção iterável contendo todas as chaves armazenadas no Mapa.\r\n"
				+"*values(): retorna uma coleção contendo todos os valores associados com as chaves armazenadas no Mapa.\r\n"
				+"*entrySet(): retorna uma coleção contendo todas as entradas (chave-valor) do Mapa.");
		initMapa();
	}
	
	public static void tamanho() {
		System.out.println("O tamanho do Mapa é " + mapa.size() + ".");
		initMapa();
	}
	
	public static void vazio() {
		if (mapa.isEmpty()) {
			System.out.println("O mapa está vazio!");
		} else {
			System.out.println("O mapa não está vazio!");
		}
		initMapa();
	}
	
	public static void obterEntrada() {
		System.out.println("Digite a chave que deseja buscar: ");
		int chave = entrada.nextInt();
		if(mapa.get(chave) == null) {
			System.out.println("Não há entradas com essa chave no mapa.");
		} else {
			System.out.println("A entrada correspondente a essa chave é " + mapa.get(chave));
		}
		initMapa();
	}
	
	public static void inserir(){
		System.out.println("Digite a chave(Inteiro) que deseja inserir: ");
		int chave = entrada.nextInt();
		
		System.out.println("Digite o valor(String) que deseja inserir: ");
		String valor = entrada.next();
		
		String removido = mapa.put(chave, valor);
		
		if (removido == null) {
			System.out.println("Não existia valor anterior com a chave " + chave);
			System.out.println("A entrada foi inserida com sucesso!");
		} else {
			System.out.println("O valor anterior " + removido + " foi removido.");
			System.out.println("A entrada foi inserida com sucesso!");
		}
		initMapa();
	}
	
	public static void remover() {
		System.out.println("Digite a chave(Inteiro) que deseja remover: ");
		int chave = entrada.nextInt();
		
		if (mapa.remove(chave) == null) {
			System.out.println("Não há entrada com essa chave no mapa.");
		} else {
			mapa.remove(chave);
			System.out.println("A entrada com a chave " + chave + " foi removida com sucesso!");
		}
		initMapa();
	}
	
	public static void chaves() {
		if(mapa.isEmpty()) {
			System.out.println("Não há nenhuma chave inserida no mapa.");
		} else {
			System.out.println("As chaves inseridas no mapa são: " + mapa.keySet());
		}
		initMapa();
	}
	
	public static void valores() {
		if(mapa.isEmpty()) {
			System.out.println("Não há nenhum valor inserido no mapa.");
		} else {
			System.out.println("Os valores inseridos no mapa são: " + mapa.values());
		}
		initMapa();
	}
	
	public static void todasEntradas() {
		if(mapa.isEmpty()) {
			System.out.println("Não há nenhuma entrada no mapa.");
		} else {
			System.out.println("As entradas inseridas no mapa são: " + mapa.entrySet());
		}
		initMapa();
	}
}
