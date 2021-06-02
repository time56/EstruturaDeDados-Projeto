import java.util.Scanner;

import ListaArranjo.ArrayIndexList;

public class ListaArranjo {
	
	static ArrayIndexList<Integer> A = new ArrayIndexList<Integer>();
	static Scanner entrada = new Scanner(System.in);

	public static void initListaArranjo() {

		int aparece = 0;			
		
		do {
			System.out.println("Escolha a op��o desejada para o TAD-Lista Arranjo, ser� possivel testar a lista com dados do tipo Inteiro: \r\n \r\n"
					+ "1.Defini��o \r\n"
					+ "2.Exemplo de c�digo como adicionar \r\n"
					+ "3.Exemplo de c�digo como remover \r\n"
					+ "4.Exemplo de c�digo como retornar um elemento \r\n"
					+ "5.Obter o tamanho da lista \r\n"
					+ "6.Saber se a lista est� vazia \r\n"
					+ "7.Obter o elemento armazenado em um dado �ndice \r\n"
					+ "8.Adicionar um elemento num dado �ndice \r\n"
					+ "9.Remover um elemento num dado �ndice \r\n"			
					+ "10.Sair do TAD Lista Arranjo e retornar ao menu principal.");
			System.out.println("-------------------------------------------------------------------------------------------------------");
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
				comoAdicionar();
				aparece = 0;
				break;
			case 3:
				comoRemover();
				aparece = 0;
				break;
			case 4:
				retornarElemento();
				aparece = 0;
				break;		
			case 5:
				retornarTamanho();
				aparece = 0;
				break;
			case 6:
				retornarSeListaEstaVazia();
				aparece = 0;
				break;
			case 7: 
				getElemento();
				aparece = 0;
				break;
			case 8:
				add();
				aparece = 0;
				break;
			case 9:
				remove();
				aparece = 0;
				break;
			case 10:
				Principal.init();
			default:
				aparece = 0;			
			}

		}while(aparece != 0);
		
		entrada.close();

	}
	
	public static void definicao() {
		System.out.print("Defini��o: ");
		System.out.println("Lista arranjo � uma cole��o 'S' de 'N' elementos armazenados em ordem linear, \r\n" 
				+ "cada elemento 'e' de 'S' � acessado usando um inteiro no intervalo [0, n - 1], \r\n"
				+ "o 1� elemento de 'S' tem �ndice 0, e o �ltimo tem �ndice n - 1.");
		System.out.println();
		
		
		System.out.println("Como um TAD, uma lista arranjo tem os seguintes m�todos:\r\n"
				+ "* get(i)    = retorna o elemento de S com �ndice i; \r\n"
				+ "* set(i, e) = substitui por e e retorna o elemento de �ndice i \r\n"
				+ "* add(i, e) = insere um elemento novo e em S para que tenha o �ndice i \r\n"
				+ "* remove(i) = remove de S o elemento de �ndice i \r\n \r\n"
				+ "Para todos os m�todos acima, uma condi��o de erro ocorre se i < 0 ou i > size() - 1.\r\n \r\n"
				+ "Al�m dos m�todos acima, h� os met�dos padr�o que s�o: size() e isEmpty()");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	public static void comoAdicionar() {
		
		System.out.println("M�todo Adicionar: \r\n");
		
		System.out.println("Exemplo de algoritmo: \r\n"
			+ "		add(i,e): \r\n"
				+ "		para j = n-1, n-2, ... , i fa�a \r\n"
				+ "			A[j + 1] = A[j]  // abre espa�o para o novo elemento\r\n"
				+ "			A[i] = e\r\n"
				+ "		n = n + 1 \r\n \r\n");
				
		
		System.out.println("Exemplo c�digo em Java: \r\n"
				+ "//Insere um elemento num dado �ndice\r\n"
				+ "public void add(int r, E e) throws IndexOutOfBoundsException {\r\n"
				+ "		checkIndex(r, size() + 1);\r\n"
				+ "		if (size == capacity) { // an overflow\r\n"
				+ "			capacity *= 2;\r\n"
				+ "			@SuppressWarnings(\"unchecked\")\r\n"
				+ "			E[] B = (E[]) new Object[capacity];\r\n"
				+ "			for (int i = 0; i < size; i++) B[i] = A[i];\r\n"
				+ "			A = B;\r\n"
				+ "		}\r\n"
				+ "		for (int i = size - 1; i >= r; i--) // desloca os elementos para cima\r\n"
				+ "			A[i + 1] = A[i];\r\n"
				+ "			A[r] = e;\r\n"
				+ "		size++;\r\n"
				+ "}\r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	public static void comoRemover() {
		
		System.out.println("M�todo Remover: \r\n");
		
		System.out.println("Exemplo de algoritmo: \r\n"
				+ " remove(i): \r\n"
				+ "		e = A[i]  // e � uma vari�vel tempor�ria\r\n"
				+ "		para j = i, i+1, ... ,n-2 fa�a \r\n"
				+ "			A[j] = A[j + 1] // substitui pelo elemento removido\r\n"
				+ "			n = n - 1 \r\n"
				+ "		retorna e \r\n \r\n");

			
			System.out.println("Exemplo c�digo em Java: \r\n"
					+ "// Remove o elemento armazenado num dado �ndice\r\n"
					+ "public E remove(int r) throws IndexOutOfBoundsException {\r\n"
					+ "		checkIndex(r, size());\r\n"
					+ "		E temp = A[r];\r\n"
					+ "		for (int i = r; i < size - 1; i++) // desloca os elemento para baixo\r\n"
					+ "			A[i] = A[i + 1];\r\n"
					+ "			size--;\r\n"
					+ "		return temp;\r\n"
					+ "}\r\n");
			
			System.out.println("-------------------------------------------------------------------------------------------------------");
			
			initListaArranjo();		
	}
	
	public static void retornarElemento() {
		
		System.out.println("M�todo Retornar o elemento armazenado num dado �ndice: \r\n");
		
		System.out.println("Exemplo de c�digo em Java: \r\n"
				+ "public E get(int r) throws IndexOutOfBoundsException {\r\n"
				+ "		checkIndex(r, size());\r\n"
				+ "		return A[r];\r\n"
				+ "		}");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	// Retorna o n�mero de elementos da lista
	public static void retornarTamanho() {
		System.out.println("O n�mero de elementos da lista �: " + A.size() +"\r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	// Retorna se a lista est� vazia
	public static void retornarSeListaEstaVazia() {
		if (A.isEmpty()) {
			System.out.println("A lista est� vazia!");
			System.out.println("Lista:" + A);
		} else {
			System.out.println("A lista n�o est� vazia!");
			System.out.println("Lista:" + A);
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	// Retorna o elemento armazenado num dado �ndice
	public static void getElemento() {
		
		if(A.isEmpty()) {
			System.out.println("A lista est� vazia, n�o ser� possivel retornar o elemento");
		}else {
			try {
				System.out.println("Digite o �ndice dejado: ");
				int indice = entrada.nextInt();
				A.get(indice);	
				System.out.println("Lista:" + A);
			}catch (Exception e) {
				System.out.println("�ndice inexistente");
			}
		}		
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	// Insere um elemento num dado �ndice
	public static void add() {
		System.out.println("Digite o �ndice dejado: \r\n");
		int indice = entrada.nextInt();
		
		System.out.println("Digite o elemento dejado: \r\n");
		int elemento = entrada.nextInt();
		
		try {
			A.add(indice, elemento);		
			System.out.println("Lista:" + A);
		}catch (Exception e) {
			System.out.println("N�o foi poss�vel adicionar o elemento no �ndice desejado");
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	// Remove o elemento armazenado num dado �ndice
	public static void remove() {
		if(A.isEmpty()) {
			System.out.println("A lista est� vazia, n�o ser� possivel remover um elemento");
		}else {
			try {
				System.out.println("Digite o �ndice dejado: \r\n");
				int indice = entrada.nextInt();				
				A.remove(indice);
				System.out.println("Lista:" + A);
			}catch (Exception e) {
				System.out.println("N�o foi poss�vel remover o elemento");
			}
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	
}
