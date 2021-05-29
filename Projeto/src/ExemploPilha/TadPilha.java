package ExemploPilha;

public class TadPilha {
    int elementos[];
    int topo;

    public TadPilha(){
        elementos = new int[10];
        topo = -1;
    }

    public void push(int e){
        if (isFull()){
            throw new RuntimeException(">> Pilha cheia, imposs�vel inserir elementos");
        }
        topo++;
        elementos[topo] = e;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException(">> Pilha vazia, imposs�vel remover elementos");
        }
        int e;
        e = elementos[topo];
        topo--;
        System.out.println(">> Elemento " + e + " exclu�do!");
        return e;
    }

    public boolean isEmpty(){
        if (topo == -1){
            System.out.println(">> A pilha est� vazia");
            return true;
        }
        System.out.println(">> A pilha n�o est� vazia");
        return false;
    }

    public boolean isFull(){
        if (topo == 9){
            System.out.println(">> A pilha est� cheia");
            return true;
        }
        System.out.println(">> A pilha n�o est� cheia");
        return false;
    }

    public int top(){
        if(isEmpty()){
            throw new RuntimeException(">> Pilha vazia");
        }
        System.out.println(">> Elemento " + elementos[topo] + " � o primeiro da pilha");
        return elementos[topo];
    }
}