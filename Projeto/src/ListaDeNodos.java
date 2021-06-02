import java.util.Scanner;

import ListaNodos.NodePositionList;
import ListaNodos.Position;

public class ListaDeNodos {
	
	static Scanner entrada = new Scanner(System.in);
	static NodePositionList<Integer> N = new NodePositionList<Integer>();
	
	public static void initListaNodos() {

			int aparece = 0;			
			
			do {
				System.out.println("Escolha a opção desejada para o TAD-Lista de Nodos, será possivel testar a fila com dados do tipo Inteiro: \r\n \r\n"
						+ "1.Definição \r\n"
						+ "2.Exemplo de código de como adicionar \r\n"
						+ "3.Exemplo de código de como remover \r\n"
						+ "4.Exemplo de código de como retornar\r\n"
						+ "5.Retornar quantidade de elementos na lista\r\n"
						+ "6.Retorna Quando a Lista etá Vazia \r\n"
						+ "7.Insere o elemento dado no início da lista \r\n"
						+ "8.Insere um elemento após um dado elemento da lista.\r\n"
						+ "9.Insere o elemento antes da posição fornecida\r\n"
						+ "10.Remove da lista a primeira posição\r\n"
						+ "11.Sair do TAD Lista de Nodos e retornar ao menu principal. \r\n");
				System.out.println("-------------------------------------------------------------------------------------------------------");
				try {
					aparece = entrada.nextInt();
					while(aparece > 11 || aparece <=0) {
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
					exemploComoAdicionar();
					aparece = 0;
					break;	
				case 3:
					exemploComoRemover();
					aparece = 0;
					break;
				case 4:
					exemploComoRetornar();
					aparece = 0;
					break;
				case 5:
					retornarQuantidadeElementosLista();
					aparece = 0;
					break;
				case 6:
					retornaQuandoAListaEstaVazia();
					aparece = 0;
					break;
				case 7:
					addFirst();
					aparece = 0;
					break;
				case 8:
					addAfter();
					aparece = 0;
					break;
				case 9:
					addBefore();
					aparece = 0;
					break;
				case 10:
					remove();
					aparece = 0;
					break;
				case 11:
					Principal.init();
					aparece = 0;
					break;
				
				default:
					aparece = 0;			
				}

			}while(aparece != 0);
			
			entrada.close();

		}
	
	public static void definicao() {
		
		System.out.println("É mais eficiente usar um nodo em vez de um índice como\r\n"
				+ "forma de identificar onde acessar ou atualizar uma lista. \r\n \r\n"
				+ "Usando o TAD Posição para encapsular a ideia de “nodo” em uma\r\n"
				+ "lista, pode-se definir o TAD Lista de Nodos. \r\n");
		
		
		System.out.println("Como um TAD, a Lista de Nodos tem os seguintes métodos: \r\n \r\n"
				+ "size()    	= Retorna o tamanho da lista.\r\n"
				+ "isEmpty() 	= Retorna se lista está ou não vazia.\r\n"
				+ "first() 		= Retorna a posição do primeiro elemento da lista. \r\n"
				+ "last()		= Retorna a posição do último elemento da lista.\r\n"
				+ "prev(p)		= Retorna a posição do elemento que precede o que se encontra na posição p.\r\n"
				+ "next(p)		= Retorna a posição do elemento que segue o que se encontra na posição p.\r\n"
				+ "set(p, e) 	= Substitui o elemento que se encontra na posição p por e retornando o elemento que se encontrava antes na posição p.\r\n"
				+ "addFirst(e) 	= Insere o novo elemento e como o primeiro elemento da lista.\r\n"
				+ "addLast(e) 	= Insere o novo elemento e como último elemento da lista.\r\n"
				+ "addBefore(e)	= Insere um novo elemento e antes da posição p.\r\n"
				+ "addAfter(e)	= Insere um novo elemento e depois da posição p.\r\n"
				+ "remove(p)	= Remove e retorna o elemento na posição p da lista, invalidando esta posição.\r\n");
		
		System.out.println("Ocorre um erro para os seguintes métodos: \r\n \r\n"
				+ "first() e last() = Ocorre um erro se a lista estiver vazia.\r\n"
				+ "prev(p),next(p), = Ocorre um erro se p for a primeira posição. \r\n \r\n"
				+ "Uma condição de erro ocorre se uma posição passada por parâmetro para uma das operações da lista for inválida. \r\n"
				+ "As razões que podem levar uma posição a ser inválida incluem:\r\n \r\n"
				+ "p = null\r\n"
				+ "p foi previamente eliminado da lista\r\n"
				+ "p é uma posição de uma lista diferente\r\n"
				+ "p é a primeira posição da lista e chama-se prev(p)\r\n"
				+ "p é a última posição da lista e chama-se next(p)\r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();
	}
	
	public static void exemploComoAdicionar() {
		
		System.out.println("Método adicionar \r\n");
		
		System.out.println("Exemplo de código em java: \r\n\r\n"
				+ "// Insere o elemento antes da posição fornecida, retornando a nova posição\r\n"
				+ "public void addBefore(Position<E> p, E element) throws InvalidPositionException {\r\n"
				+ "    DNode<E> v = checkPosition(p);\r\n"
				+ "    numElts++;\r\n"
				+ "    DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);\r\n"
				+ "    v.getPrev().setNext(newNode);\r\n"
				+ "    v.setPrev(newNode);\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Insere o elemento dado no início da lista, retornando a nova posição\r\n"
				+ "public void addFirst(E element) {\r\n"
				+ "    numElts++;\r\n"
				+ "    DNode<E> newNode = new DNode<E>(header, header.getNext(), element);\r\n"
				+ "    header.getNext().setPrev(newNode);\r\n"
				+ "    header.setNext(newNode);\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "//Insere um elemento na última posição, retornando uma posição nova.\r\n"
				+ "public void addLast(E e) {\r\n"
				+ "    numElts++;\r\n"
				+ "    DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, e);\r\n"
				+ "    trailer.getPrev().setNext(newNode);\r\n"
				+ "    trailer.setPrev(newNode);\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Insere um elemento após um dado elemento da lista.\r\n"
				+ "public void addAfter(Position<E> p, E e) throws InvalidPositionException {\r\n"
				+ "    DNode<E> v = checkPosition(p);\r\n"
				+ "    numElts++;\r\n"
				+ "    DNode<E> newNode = new DNode<E>(v, v.getNext(), e);\r\n"
				+ "    v.getNext().setPrev(newNode);\r\n"
				+ "    v.setNext(newNode);\r\n"
				+ "}\r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();
	}
	
	public static void exemploComoRemover() {
		
		System.out.println("Método Remover: \r\n");
		
		System.out.println("Exemplo de código em java: \r\n\r\n"
				+ "// Remove da lista a posição fornecida\r\n"
				+ "public E remove(Position<E> p) throws InvalidPositionException {\r\n"
				+ "    DNode<E> v = checkPosition(p);\r\n"
				+ "    numElts--;\r\n"
				+ "    DNode<E> vPrev = v.getPrev();\r\n"
				+ "    DNode<E> vNext = v.getNext();\r\n"
				+ "    vPrev.setNext(vNext);\r\n"
				+ "    vNext.setPrev(vPrev);\r\n"
				+ "    E vElem = v.element();\r\n"
				+ "    // Desconecta a posição da lista e marca-a como inválida\r\n"
				+ "    v.setNext(null);\r\n"
				+ "    v.setPrev(null);\r\n"
				+ "    return vElem;\r\n"
				+ "}\r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();
	}
	
	public static void exemploComoRetornar() {
		
		System.out.println("Método Retornar \r\n");
		
		System.out.println("Exemplo de códio em java: \r\n\r\n"
				+ "// Retorna a quantidade de elementos na lista\r\n"
				+ "public int size() {return numElts;}\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna quando a lista esta vazia\r\n"
				+ "public boolean isEmpty() { return (numElts == 0); }\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna a primeira posição da lista\r\n"
				+ "public Position<E> first() throws EmptyListException {\r\n"
				+ "    if (isEmpty()) throw new EmptyListException(\"List is empty\");\r\n"
				+ "    return header.getNext();\r\n\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna a posição que antecede a fornecida\r\n"
				+ "public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {\r\n"
				+ "    DNode<E> v = checkPosition(p);\r\n"
				+ "    DNode<E> prev = v.getPrev();\r\n"
				+ "    if (prev == header) throw new BoundaryViolationException(\"Cannot advance past the beginning of the list\");\r\n"
				+ "    return prev;\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna o último nodo da lista.\r\n"
				+ "public Position<E> last() {\r\n"
				+ "    if (isEmpty()) throw new EmptyListException(\"List is empty\");\r\n"
				+ "    return trailer.getPrev();\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna o nodo que segue um dado nodo da lista.\r\n"
				+ "public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {\r\n"
				+ "    DNode<E> v = checkPosition(p);\r\n"
				+ "    DNode<E> next = v.getNext();\r\n"
				+ "    if (next == trailer) throw new BoundaryViolationException(\"Cannot advance past the finaling of the list\");\r\n"
				+ "    return next;\r\n"
				+ "}\r\n");		

		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		
	}
	
	public static void retornarQuantidadeElementosLista() {
		
		System.out.println("Quantidade de elementos na lista: " + N.size());
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		
	}
	
	public static void retornaQuandoAListaEstaVazia() {
		
		if(N.isEmpty()) {
			System.out.println("A lista está vazia");
			System.out.println("Lista: " + N);
		}else {
			System.out.println("A lista não está vazia");
			System.out.println("Lista: " + N);
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		

	}
	
	public static void addFirst() {
		
		System.out.println("Digite o elemento desejado: ");
		int elemento = entrada.nextInt();
		
		N.addFirst(elemento);
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		

	}
	
	public static void addAfter() {
		
		System.out.println("Digite o elemento desejado: ");
		int elemento = entrada.nextInt();
		
		if(N.isEmpty()) {
			System.out.println("Lista está vazia, não será possivel adicionar elemento");
		}else {
			try{	
				Position<Integer> p1 = N.first();				
				N.addAfter(p1, elemento);				
			}catch (Exception e) {
				System.out.println("Não foi possivel adicionar o elemento");
			}			
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		
	}
	
	
	public static void addBefore() {
		
		System.out.println("Digite o elemento desejado: ");
		int elemento = entrada.nextInt();
		
		if(N.isEmpty()) {
			System.out.println("Lista está vazia, não será possivel adicionar elemento");
		}else {
			try{
				Position<Integer> p1 = N.first();
				Position<Integer> p2 = N.next(p1);
				
				N.addBefore(p2, elemento);
			}catch (Exception e) {
				System.out.println("Não foi possivel adicionar o elemento");
			}			
		}		
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		
		
	}
	
	public static void remove() {
		if(N.isEmpty()) {
			System.out.println("Lista está vazia, não será possivel remover elemento");
		}else {
			try{						
				Position<Integer> p1 = N.first();				
				N.remove(p1);
				
				System.out.println("Lista: " + N);
				
			}catch (Exception e) {
				System.out.println("Não foi possivel remover o elemento");
			}			
		}
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		
		
		
	}

}
