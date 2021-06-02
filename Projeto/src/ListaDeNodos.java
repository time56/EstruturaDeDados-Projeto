import java.util.Scanner;

import ListaNodos.NodePositionList;
import ListaNodos.Position;

public class ListaDeNodos {
	
	static Scanner entrada = new Scanner(System.in);
	static NodePositionList<Integer> N = new NodePositionList<Integer>();
	
	public static void initListaNodos() {

			int aparece = 0;			
			
			do {
				System.out.println("Escolha a op��o desejada para o TAD-Lista de Nodos, ser� possivel testar a fila com dados do tipo Inteiro: \r\n \r\n"
						+ "1.Defini��o \r\n"
						+ "2.Exemplo de c�digo de como adicionar \r\n"
						+ "3.Exemplo de c�digo de como remover \r\n"
						+ "4.Exemplo de c�digo de como retornar\r\n"
						+ "5.Retornar quantidade de elementos na lista\r\n"
						+ "6.Retorna Quando a Lista et� Vazia \r\n"
						+ "7.Insere o elemento dado no in�cio da lista \r\n"
						+ "8.Insere um elemento ap�s um dado elemento da lista.\r\n"
						+ "9.Insere o elemento antes da posi��o fornecida\r\n"
						+ "10.Remove da lista a primeira posi��o\r\n"
						+ "11.Sair do TAD Lista de Nodos e retornar ao menu principal. \r\n");
				System.out.println("-------------------------------------------------------------------------------------------------------");
				try {
					aparece = entrada.nextInt();
					while(aparece > 11 || aparece <=0) {
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
		
		System.out.println("� mais eficiente usar um nodo em vez de um �ndice como\r\n"
				+ "forma de identificar onde acessar ou atualizar uma lista. \r\n \r\n"
				+ "Usando o TAD Posi��o para encapsular a ideia de �nodo� em uma\r\n"
				+ "lista, pode-se definir o TAD Lista de Nodos. \r\n");
		
		
		System.out.println("Como um TAD, a Lista de Nodos tem os seguintes m�todos: \r\n \r\n"
				+ "size()    	= Retorna o tamanho da lista.\r\n"
				+ "isEmpty() 	= Retorna se lista est� ou n�o vazia.\r\n"
				+ "first() 		= Retorna a posi��o do primeiro elemento da lista. \r\n"
				+ "last()		= Retorna a posi��o do �ltimo elemento da lista.\r\n"
				+ "prev(p)		= Retorna a posi��o do elemento que precede o que se encontra na posi��o p.\r\n"
				+ "next(p)		= Retorna a posi��o do elemento que segue o que se encontra na posi��o p.\r\n"
				+ "set(p, e) 	= Substitui o elemento que se encontra na posi��o p por e retornando o elemento que se encontrava antes na posi��o p.\r\n"
				+ "addFirst(e) 	= Insere o novo elemento e como o primeiro elemento da lista.\r\n"
				+ "addLast(e) 	= Insere o novo elemento e como �ltimo elemento da lista.\r\n"
				+ "addBefore(e)	= Insere um novo elemento e antes da posi��o p.\r\n"
				+ "addAfter(e)	= Insere um novo elemento e depois da posi��o p.\r\n"
				+ "remove(p)	= Remove e retorna o elemento na posi��o p da lista, invalidando esta posi��o.\r\n");
		
		System.out.println("Ocorre um erro para os seguintes m�todos: \r\n \r\n"
				+ "first() e last() = Ocorre um erro se a lista estiver vazia.\r\n"
				+ "prev(p),next(p), = Ocorre um erro se p for a primeira posi��o. \r\n \r\n"
				+ "Uma condi��o de erro ocorre se uma posi��o passada por par�metro para uma das opera��es da lista for inv�lida. \r\n"
				+ "As raz�es que podem levar uma posi��o a ser inv�lida incluem:\r\n \r\n"
				+ "p = null\r\n"
				+ "p foi previamente eliminado da lista\r\n"
				+ "p � uma posi��o de uma lista diferente\r\n"
				+ "p � a primeira posi��o da lista e chama-se prev(p)\r\n"
				+ "p � a �ltima posi��o da lista e chama-se next(p)\r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();
	}
	
	public static void exemploComoAdicionar() {
		
		System.out.println("M�todo adicionar \r\n");
		
		System.out.println("Exemplo de c�digo em java: \r\n\r\n"
				+ "// Insere o elemento antes da posi��o fornecida, retornando a nova posi��o\r\n"
				+ "public void addBefore(Position<E> p, E element) throws InvalidPositionException {\r\n"
				+ "    DNode<E> v = checkPosition(p);\r\n"
				+ "    numElts++;\r\n"
				+ "    DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);\r\n"
				+ "    v.getPrev().setNext(newNode);\r\n"
				+ "    v.setPrev(newNode);\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Insere o elemento dado no in�cio da lista, retornando a nova posi��o\r\n"
				+ "public void addFirst(E element) {\r\n"
				+ "    numElts++;\r\n"
				+ "    DNode<E> newNode = new DNode<E>(header, header.getNext(), element);\r\n"
				+ "    header.getNext().setPrev(newNode);\r\n"
				+ "    header.setNext(newNode);\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "//Insere um elemento na �ltima posi��o, retornando uma posi��o nova.\r\n"
				+ "public void addLast(E e) {\r\n"
				+ "    numElts++;\r\n"
				+ "    DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, e);\r\n"
				+ "    trailer.getPrev().setNext(newNode);\r\n"
				+ "    trailer.setPrev(newNode);\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Insere um elemento ap�s um dado elemento da lista.\r\n"
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
		
		System.out.println("M�todo Remover: \r\n");
		
		System.out.println("Exemplo de c�digo em java: \r\n\r\n"
				+ "// Remove da lista a posi��o fornecida\r\n"
				+ "public E remove(Position<E> p) throws InvalidPositionException {\r\n"
				+ "    DNode<E> v = checkPosition(p);\r\n"
				+ "    numElts--;\r\n"
				+ "    DNode<E> vPrev = v.getPrev();\r\n"
				+ "    DNode<E> vNext = v.getNext();\r\n"
				+ "    vPrev.setNext(vNext);\r\n"
				+ "    vNext.setPrev(vPrev);\r\n"
				+ "    E vElem = v.element();\r\n"
				+ "    // Desconecta a posi��o da lista e marca-a como inv�lida\r\n"
				+ "    v.setNext(null);\r\n"
				+ "    v.setPrev(null);\r\n"
				+ "    return vElem;\r\n"
				+ "}\r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();
	}
	
	public static void exemploComoRetornar() {
		
		System.out.println("M�todo Retornar \r\n");
		
		System.out.println("Exemplo de c�dio em java: \r\n\r\n"
				+ "// Retorna a quantidade de elementos na lista\r\n"
				+ "public int size() {return numElts;}\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna quando a lista esta vazia\r\n"
				+ "public boolean isEmpty() { return (numElts == 0); }\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna a primeira posi��o da lista\r\n"
				+ "public Position<E> first() throws EmptyListException {\r\n"
				+ "    if (isEmpty()) throw new EmptyListException(\"List is empty\");\r\n"
				+ "    return header.getNext();\r\n\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna a posi��o que antecede a fornecida\r\n"
				+ "public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {\r\n"
				+ "    DNode<E> v = checkPosition(p);\r\n"
				+ "    DNode<E> prev = v.getPrev();\r\n"
				+ "    if (prev == header) throw new BoundaryViolationException(\"Cannot advance past the beginning of the list\");\r\n"
				+ "    return prev;\r\n"
				+ "}\r\n\r\n"
				+ ""
				+ ""
				+ "// Retorna o �ltimo nodo da lista.\r\n"
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
			System.out.println("A lista est� vazia");
			System.out.println("Lista: " + N);
		}else {
			System.out.println("A lista n�o est� vazia");
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
			System.out.println("Lista est� vazia, n�o ser� possivel adicionar elemento");
		}else {
			try{	
				Position<Integer> p1 = N.first();				
				N.addAfter(p1, elemento);				
			}catch (Exception e) {
				System.out.println("N�o foi possivel adicionar o elemento");
			}			
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		
	}
	
	
	public static void addBefore() {
		
		System.out.println("Digite o elemento desejado: ");
		int elemento = entrada.nextInt();
		
		if(N.isEmpty()) {
			System.out.println("Lista est� vazia, n�o ser� possivel adicionar elemento");
		}else {
			try{
				Position<Integer> p1 = N.first();
				Position<Integer> p2 = N.next(p1);
				
				N.addBefore(p2, elemento);
			}catch (Exception e) {
				System.out.println("N�o foi possivel adicionar o elemento");
			}			
		}		
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		
		
	}
	
	public static void remove() {
		if(N.isEmpty()) {
			System.out.println("Lista est� vazia, n�o ser� possivel remover elemento");
		}else {
			try{						
				Position<Integer> p1 = N.first();				
				N.remove(p1);
				
				System.out.println("Lista: " + N);
				
			}catch (Exception e) {
				System.out.println("N�o foi possivel remover o elemento");
			}			
		}
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initListaNodos();		
		
		
	}

}
