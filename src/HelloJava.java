import java.util.NoSuchElementException;
class Queue<T> { //객체를 만들 때 데이터 타입을 명시
    class Node<T> {
        //같은 타입을 받는 노드를 선언
        private T data; //데이터를 선언하고.
        private Node<T> next; // 다음 노드도 선언

        public Node(T data) {
            this.data = data; //생성자에서 해당 타입의 데이터를 받아서 내부 변수에 저장
        }
    }

    private Node<T> first; //큐는 앞뒤로 주소를 알고 있어야 하니까 first,last 변수를 선언
    private Node<T> last;

    public void add(T item) { // 추가하는 함수
        Node<T> t = new Node<T>(item); //추가할 T 타입의 아이템을 한개 받음
        // 아이템을 갖고 노드를 한개 생성함
        if (last != null) { //마지막 노드가 있다면.
            last.next = t; // 뒤에 새로 생성한 노드를 붙이고
        }
        last = t;//t 가 마지막 노드
        if (first == null) { // first 에 데이터가 없을때
            first = last; // 같은 값을 할당.
        }
    }

    public T remove() {
        if (first == null) { // 큐가 비어있으면
            throw new NoSuchElementException(); // Exception
        }
        T data = first.data; // 이 다음주소에 있는 애를 first 로 만들어줘야하니까 백업
        first = first.next; // 다음 친구를 first 로 만들었음

        if(first == null) { // first 가 null 일때  last 도 null
            last = null;
        }
        return data; // 데이터를 반환
    }
    public T peek(){ // peek T 타입의 데이터를 반환
        if(first==null){ //first 가 널이면  exception
             throw new NoSuchElementException();
        }
        return first.data; // null 이아니면 현재 first 가 가리키고 있는 데이터를 반환하면 된다.
    }
    public boolean isEmpty(){
        return first == null; // first 가 널인지 만 보면 된다.
    }
}


public class HelloJava {
    public static void main(String[] args){
        //Queue 는 먼저 들어간 데이터를 먼저 꺼내는 구조
        //FIFO first  in first out
        // add() 맨 끝에 데이터를 한개 넣는것
        // remove() 맨 앞에서 데이터를 한개 꺼내는 것
        // peek() 맨 앞에 있는 데이터를 보는 것
        // isEmpty() 큐가 비어있나 확인하는 것
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove()); // 꺼내고
        System.out.println(q.remove()); // 꺼내고
        System.out.println(q.peek());//보기
        System.out.println(q.remove()); // 꺼내고
        System.out.println(q.isEmpty()); // 비어있나 보고
        System.out.println(q.remove()); // 꺼내고
        System.out.println(q.isEmpty()); // 비어있나 보고
        System.out.println(q.remove()); // 꺼내고
        System.out.println(q.isEmpty()); // 비어있나 보고
    }
}
