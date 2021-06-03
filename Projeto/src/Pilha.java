import ExemploPilha.TadPilha;

import java.util.Scanner;

public class Pilha {

	public static void initPilha() {

		Scanner entrada = new Scanner(System.in);

		int aparece = 0;
		int num;

		TadPilha p = new TadPilha();
		do {
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.println("Escolha a op��o desejada para o TAD-Pilha: \r\n \r\n"
					+ "1.Defini��o \r\n"
					+ "2.Exemplo de como adicionar um elemento \r\n"
					+ "3.Exemplo de como remover um elemento \r\n");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 5 || aparece <=0) {
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
					initPilha();
					break;
				case 2:
					System.out.println("Digite um n�mero para adicionar: ");
					num = entrada.nextInt();
					p.push(num);
					System.out.println(">> Elemento " + num + " adicionado!");
					aparece = 0;
					initPilha();
					break;
				case 3:
					System.out.println("O item do topo ser� exclu�do");
					p.pop();
					aparece = 0;
					initPilha();
					break;
				case 4:
					p.top();
					aparece = 0;
					initPilha();
					break;
				case 5:
					p.isFull();
					aparece = 0;
					initPilha();
					break;
				default:
					aparece = 0;
					initPilha();
			}

		}while(aparece != 0);

		entrada.close();

	}

	public static void definicao() {
		System.out.print("Defini��o: ");
		System.out.println("Pilhas s�o estruturas de dados que respeitam uma ordem de entrada e sa�da \r\n"
				+ "conhecido como LIFO, isso quer dizer que o ultimo elemento inserido ser� o primeiro a sair \r\n"
				+ "lembrando uma pilha de pratos, que s�o de onde seu nome metaforicamente deriva");
		System.out.println();


		System.out.println("Como um TAD, a pilha tem os seguintes m�todos:\r\n"
				+ "* push(e)   = Insere o objeto no topo da pilha; \r\n"
				+ "* pop()     = Remove o elemento do topo da pilha, retornando um erro caso a pilha esteja vazia \r\n"
				+ "Outros m�todos que podem ser definidos: top(), isFull() e isEmpty()");
		System.out.println("-------------------------------------------------------------------------------------------------------");
	}

}
