import java.util.Scanner;

public class ListaArranjo {

	public static void initListaArranjo() {
		
		Scanner entrada = new Scanner(System.in);
		
		int aparece = 0;			
		
		do {
			System.out.println("Escolha a op��o desejada para o TAD-Lista Arranjo: \r\n \r\n"
					+ "1.Defini��o \r\n"
					+ "2.Exemplo de como adicionar \r\n"
					+ "3.Exemplo de como remover \r\n"
					+ "4.Exemplo de como retornar um elemento");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 4 || aparece <=0) {
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
				+ "Algoritmo remove(i): \r\n"
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
}
