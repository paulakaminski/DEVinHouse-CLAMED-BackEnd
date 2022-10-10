import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class aula05deQueue {
    public static void main(String[] args) {
//        Deque<String> stringArrayDeque
//                = new ArrayDeque<String>();
//
//        stringArrayDeque.add("AA");
//        stringArrayDeque.addFirst("BB");
//        stringArrayDeque.addFirst("BA");
//        stringArrayDeque.addFirst("BC");
//        stringArrayDeque.addFirst("BD");
//        stringArrayDeque.addLast("CC");
//
//        System.out.println(stringArrayDeque);
//        System.out.println(stringArrayDeque.pop()); // retorna e remove o primeiro elemento da Deque
//        System.out.println(stringArrayDeque.pop()); // retorna e remove o primeiro elemento da Deque
//        System.out.println(stringArrayDeque.poll());// retorna e remove o primeiro elemento da Deque
//        System.out.println(stringArrayDeque.pollFirst()); // retorna e remove o primeiro elemento da Deque
//        System.out.println(stringArrayDeque.pollLast());

        Deque<String> servidorMensagens = new LinkedList<>();

        servidorMensagens.addFirst("Mensagem 1");
        servidorMensagens.addFirst("Mensagem 2");
        servidorMensagens.addFirst("Mensagem 3");
        servidorMensagens.addFirst("Mensagem 4");

        System.out.println("Ultima mensagem recebida:" + servidorMensagens.peekFirst());
        System.out.println(servidorMensagens);

        String primeiroItem = servidorMensagens.poll();

        System.out.println("Ultima mensagem recebida (não remove a mensagem):"
                + primeiroItem);

        System.out.println(servidorMensagens);
        System.out.println("Mensagem anterior:" + servidorMensagens.poll());
        System.out.println(servidorMensagens);
        System.out.println("Mensagem anterior:" + servidorMensagens.poll());
        System.out.println(servidorMensagens);
        System.out.println("Mensagem anterior:" + servidorMensagens.poll());
        System.out.println(servidorMensagens);
        System.out.println("Mensagem anterior:" + servidorMensagens.poll());
        System.out.println(servidorMensagens);
    }
}
