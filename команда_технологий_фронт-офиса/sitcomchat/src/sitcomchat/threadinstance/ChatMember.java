package sitcomchat.threadinstance;

import java.util.ArrayDeque;
import java.util.Deque;

public class ChatMember {
    private final String name;
    private final Deque<String> dequeMessage;

    public ChatMember(String name){
        this.name = name;
        this.dequeMessage = new ArrayDeque<>();
    }
    public void pushDequeMessageFlow(String memberMessage){
            dequeMessage.offerLast(memberMessage);
    }
    public synchronized void sendMessage(Deque<String> dequeMemberOrder) {
        String member = dequeMemberOrder.peekFirst();
        if (member != null && member.equals(getName())) {
            System.out.println(dequeMessage.pollFirst());
            dequeMemberOrder.pollFirst();
        }
    }
    public String getName(){
        return name;
    }
}
