import java.util.Scanner;

import Fila.QueueArray;

public class Fila {
	
	static QueueArray<Integer> Q = new QueueArray<Integer>(10);
	static Scanner entrada = new Scanner(System.in);
	
	public static void initFila() {

		int aparece = 0;			
		
		do {
			System.out.println("Escolha a opção desejada para o TAD-Fila, será possivel testar a fila com dados do tipo Inteiro: \r\n \r\n"
					+ "1.Definição \r\n"
					+ "2.Exemplo de código de como adicionar \r\n"
					+ "3.Exemplo de código de como remover \r\n"
					+ "4.Exemplo de código de como retornar um elemento \r\n"
					+ "5.Adicionar elemento no fim da fila \r\n"
					+ "6.Retornar sem remover, o objeto na frente da fila \r\n"
					+ "7.Remover e retorna o objeto da frente da fila \r\n"
					+ "8.Tamanho da fila \r\n"
					+ "9.Verificar se a fila está vazia \r\n"
					+ "10.Sair do TAD Fila e retornar ao menu principal. \r\n");
			System.out.println("-------------------------------------------------------------------------------------------------------");
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
				add();
				aparece = 0;
				break;		
			case 6:
				retornar();
				aparece = 0;
				break;
			case 7:
				remover();
				aparece = 0;
				break;
			case 8:
				tamanho();
				aparece = 0;
				break;
			case 9:
				vazia();
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
		
		entrada.close();

	}
	
	public static void definicao() {
		
		System.out.println("A fila é uma coleção de objetos que são inseridos e removidos de\r\n"
				+ "acordo com o princípio: 'o primeiro que entra é o primeiro que sai (First-In-First-Out: FIFO)'. \r\n \r\n"
				+ "*O acesso aos elementos e sua remoção são restritos ao primeiro elemento da\r\n"
				+ "sequência, que é chamado de início da fila.\r\n \r\n"
				+ "*A inserção de elementos é restrita ao fim da sequência, que é chamada de fim da fila. \r\n \r\n");
		
		System.out.println("Como um TAD, uma fila tem os seguintes métodos:\r\n \r\n"
				+ "*enqueue(e) = Insere o elemento no fim da fila; \r\n"
				+ "*dequeue() = Retira e retorna o objeto da frente da fila; \r\n"
				+ "*size() = Retorna o número de objetos na fila; \r\n"
				+ "*isEmpty() = Retorna um booleano indicando se a fila está vazia \r\n"
				+ "*front() = Retorna, mas não remove, o objeto na frente da fila \r\n \r\n"
				+ "Para os métodos dequeue() e front(), ocorre um erro se a fila estiver vazia. \r\n \r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();
	}
	
	public static void comoAdicionar() {
		
		System.out.println("Método adicionar: \r\n");
				
		System.out.println("Exemplo de algoritmo usando array:  \r\n \r\n "
				+ "enqueue(e): \r\n"
				+ "    se size() = N - 1 então lançar uma FullQueueException \r\n"
				+ "    Q[r] = e\r\n"
				+ "    r = (r + 1) mod N \r\n \r\n");
		
		
		System.out.println("Exemplo de código em java usando LSE:  \r\n \r\n"
				+ "        public void enqueue(E elem) {\r\n"
				+ "                Node<E> node = new Node<E>();\r\n"
				+ "                node.setElement(elem);\r\n"
				+ "                node.setNext(null); // nodo será o novo nodo do final\r\n"
				+ "                if (size == 0)\r\n"
				+ "                     head = node; // caso especial de uma lista previamente\r\n"
				+ "                else\r\n"
				+ "                     tail.setNext(node); // adiciona nodo no final da lista\r\n"
				+ "                     tail = node; // atualiza referência ao nodo do final\r\n"
				+ "                     size++;\r\n"
				+ "         } \r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();
	}
	
	public static void comoRemover() {
		
		System.out.println("Método remover e retornar o objeto na frente da fila: \r\n");
		
		System.out.println("Exemplo de algoritmo usando array:  \r\n \r\n "
				+ "dequeue():\r\n"
				+ "    se isEmpty() então lançar uma EmptyQueueException \r\n"
				+ "    temp = Q[f]\r\n"
				+ "    Q[f] = null\r\n"
				+ "    f = (f + 1) mod N\r\n"
				+ "    retorna temp \r\n");
		
		
		System.out.println("Exemplo de código usando LSE: \r\n \r\n"
				+ "       public E dequeue() throws EmptyQueueException {\r\n"
				+ "              if (size == 0) \r\n"
				+ "                    throw new EmptyQueueException(\"Queue is empty.\");\r\n"
				+ "                    E tmp = head.getElement();\r\n"
				+ "                    head = head.getNext();\r\n"
				+ "                    size--;\r\n"
				+ "                    if (size == 0) \r\n"
				+ "                          tail = null;// a fila está vazia agora\r\n"
				+ "                          return tmp;\r\n"
				+ "} \r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();
	}
	
	public static void retornarElemento() {
		
		System.out.println("Método retornar sem remover: \r\n");
		
		System.out.println("Exemplo de algoritmo usando array:  \r\n \r\n "
				+ "front(): \r\n"
				+ "    se isEmpty() então lançar uma EmptyQueueException "
				+ "    retorna Q[f] \r\n");
		
		System.out.println("Exemplo de como retorna o elemento usando LSE com código em Java:\r\n \r\n"
				+ "public static front(){ \r\n"
				+ "     if(isEmpty()){ \r\n"
				+ "          throw new EmptyQueueException(\"Queue is empty.\");\r\n"
				+ "     }else{ \r\n"
				+ "         return q[f]"
				+ "      } \r\n");
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();	
	}
	
	public static void add() {
		
		System.out.println("Digite o elemento dejado: ");
		int elemento = entrada.nextInt();
			
		try {
			Q.enqueue(elemento);
			System.out.println("Fila: " + Q);
		}catch (Exception e) {
			System.out.println("Não foi possivel adicionar o elemento na fila");
		}
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();
	}
	
	public static void retornar() {
		if(Q.isEmpty()) {
			System.out.println("Fila está vazia, não será possível retornar o elemento");
		}else {
			Q.front();
			System.out.println("Fila: " + Q);
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();
	}
	
	public static void remover() {
		if(Q.isEmpty()) {
			System.out.println("Fila está vazia, não será possível remover o elemento");
		}else {
			Q.dequeue();
			System.out.println("Fila "+ Q);
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();
	}
	
	public static void tamanho() {
		
		System.out.println("Tamanho da fila: " + Q.size());
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();
	}
	
	public static void vazia() {
		if(Q.isEmpty()) {
			System.out.println("A fila está vazia");
		}else {
			System.out.println("Fila não está vazia: " + Q);
		}		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		initFila();
	}
	
	
	

}
