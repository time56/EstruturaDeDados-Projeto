import java.util.Scanner;

public class ListaArranjo {

	public static void initListaArranjo() {
		
		Scanner entrada = new Scanner(System.in);
		
		int aparece = 0;			
		
		do {
			System.out.println("Escolha a opção desejada para o TAD-Lista Arranjo: \r\n \r\n"
					+ "1.Definição \r\n"
					+ "2.Exemplo de como adicionar \r\n"
					+ "3.Exemplo de como remover \r\n"
					+ "4.Exemplo de como retornar um elemento");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			try {
				aparece = entrada.nextInt();
				while(aparece > 4 || aparece <=0) {
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
		System.out.print("Definição: ");
		System.out.println("Lista arranjo é uma coleção 'S' de 'N' elementos armazenados em ordem linear, \r\n" 
				+ "cada elemento 'e' de 'S' é acessado usando um inteiro no intervalo [0, n - 1], \r\n"
				+ "o 1º elemento de 'S' tem índice 0, e o último tem índice n - 1.");
		System.out.println();
		
		
		System.out.println("Como um TAD, uma lista arranjo tem os seguintes métodos:\r\n"
				+ "* get(i)    = retorna o elemento de S com índice i; \r\n"
				+ "* set(i, e) = substitui por e e retorna o elemento de índice i \r\n"
				+ "* add(i, e) = insere um elemento novo e em S para que tenha o índice i \r\n"
				+ "* remove(i) = remove de S o elemento de índice i \r\n \r\n"
				+ "Para todos os métodos acima, uma condição de erro ocorre se i < 0 ou i > size() - 1.\r\n \r\n"
				+ "Além dos métodos acima, há os metódos padrão que são: size() e isEmpty()");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
	
	public static void comoAdicionar() {
		
		System.out.println("Método Adicionar: \r\n");
		
		System.out.println("Exemplo de algoritmo: \r\n"
			+ "		add(i,e): \r\n"
				+ "		para j = n-1, n-2, ... , i faça \r\n"
				+ "			A[j + 1] = A[j]  // abre espaço para o novo elemento\r\n"
				+ "			A[i] = e\r\n"
				+ "		n = n + 1 \r\n \r\n");
				
		
		System.out.println("Exemplo código em Java: \r\n"
				+ "//Insere um elemento num dado índice\r\n"
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
		
		System.out.println("Método Remover: \r\n");
		
		System.out.println("Exemplo de algoritmo: \r\n"
				+ "Algoritmo remove(i): \r\n"
				+ "		e = A[i]  // e é uma variável temporária\r\n"
				+ "		para j = i, i+1, ... ,n-2 faça \r\n"
				+ "			A[j] = A[j + 1] // substitui pelo elemento removido\r\n"
				+ "			n = n - 1 \r\n"
				+ "		retorna e \r\n \r\n");

			
			System.out.println("Exemplo código em Java: \r\n"
					+ "// Remove o elemento armazenado num dado índice\r\n"
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
		
		System.out.println("Método Retornar o elemento armazenado num dado índice: \r\n");
		
		System.out.println("Exemplo de código em Java: \r\n"
				+ "public E get(int r) throws IndexOutOfBoundsException {\r\n"
				+ "		checkIndex(r, size());\r\n"
				+ "		return A[r];\r\n"
				+ "		}");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaArranjo();
	}
}
