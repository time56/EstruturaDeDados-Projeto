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
					+"Escolha a op��o desejada para o TAD-Mapa:\r\n"
					+"1.Defini��o.\r\n"
					+"2.Verifica o tamanho do Mapa.\r\n"
					+"3.Verifica se o Mapa est� vazio.\r\n"
					+"4.Busca uma entrada a partir da chave(Inteiro) informada.\r\n"
					+"5.Insere uma nova entrada no Mapa informando uma chave(Inteiro) e um valor(String).\r\n"
					+"6.Remove uma entrada atrav�s da chave(Inteiro).\r\n"
					+"7.Visualizar todas as chaves inseridas no Mapa.\r\n"
					+"8.Visualizar todos os valores inseridos no Mapa.\r\n"
					+"9.Visualizar todas as entradas do Mapa.\r\n"
					+"10.Sair do TAD-Mapa.");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 10 || aparece <=0) {
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
		System.out.println("DEFINI��O:\r\n");
		System.out.println("Mapas permitem armazenar elementos que podem ser localizados rapidamente usando chaves.\r\n"
				+"Um mapa armazena um par chave-valor (k,v), chamado de entrada, onde k � a chave e v � o valor correspondente.\r\n"
				+"O TAD mapa requer que cada chave seja �nica. A chave pode ser vista como um �endere�o� para um objeto.\r\n");
		
		System.out.println("O TAD-Mapa possui os seguintes m�todos:\r\n \r\n"
				+"*size(): Retorna o n�mero de entradas do Mapa.\r\n"
				+"*isEmpty(): Testa se o Mapa est� vazio.\r\n"
				+"*get(k): Se o Mapa cont�m uma entrada (e) com chave igual a k, ent�o retorna o valor de e, sen�o retorna null.\r\n"
				+"*put(k,v): Se o Mapa n�o tem uma entrada com chave igual a k, ent�o adiciona a entrada (k,v) no Mapa"
				+ " e retorna null, sen�o,\r\n substitui o valor existente com v com chave k e retorna o valor antigo.\r\n"
				+"*remove(k): Remove a entrada do Mapa com chave igual a k, e retorna seu valor. Se o Mapa n�o possui a entrada com chave k,\r\n"
				+ " ent�o retorna null.\r\n"
				+"*keySet(): retorna uma cole��o iter�vel contendo todas as chaves armazenadas no Mapa.\r\n"
				+"*values(): retorna uma cole��o contendo todos os valores associados com as chaves armazenadas no Mapa.\r\n"
				+"*entrySet(): retorna uma cole��o contendo todas as entradas (chave-valor) do Mapa.");
		initMapa();
	}
	
	public static void tamanho() {
		System.out.println("O tamanho do Mapa � " + mapa.size() + ".");
		initMapa();
	}
	
	public static void vazio() {
		if (mapa.isEmpty()) {
			System.out.println("O mapa est� vazio!");
		} else {
			System.out.println("O mapa n�o est� vazio!");
		}
		initMapa();
	}
	
	public static void obterEntrada() {
		System.out.println("Digite a chave que deseja buscar: ");
		int chave = entrada.nextInt();
		if(mapa.get(chave) == null) {
			System.out.println("N�o h� entradas com essa chave no mapa.");
		} else {
			System.out.println("A entrada correspondente a essa chave � " + mapa.get(chave));
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
			System.out.println("N�o existia valor anterior com a chave " + chave);
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
			System.out.println("N�o h� entrada com essa chave no mapa.");
		} else {
			mapa.remove(chave);
			System.out.println("A entrada com a chave " + chave + " foi removida com sucesso!");
		}
		initMapa();
	}
	
	public static void chaves() {
		if(mapa.isEmpty()) {
			System.out.println("N�o h� nenhuma chave inserida no mapa.");
		} else {
			System.out.println("As chaves inseridas no mapa s�o: " + mapa.keySet());
		}
		initMapa();
	}
	
	public static void valores() {
		if(mapa.isEmpty()) {
			System.out.println("N�o h� nenhum valor inserido no mapa.");
		} else {
			System.out.println("Os valores inseridos no mapa s�o: " + mapa.values());
		}
		initMapa();
	}
	
	public static void todasEntradas() {
		if(mapa.isEmpty()) {
			System.out.println("N�o h� nenhuma entrada no mapa.");
		} else {
			System.out.println("As entradas inseridas no mapa s�o: " + mapa.entrySet());
		}
		initMapa();
	}
}
