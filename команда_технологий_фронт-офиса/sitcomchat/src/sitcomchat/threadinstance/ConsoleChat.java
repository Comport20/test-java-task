package sitcomchat.threadinstance;


import java.util.Deque;


public class ConsoleChat extends Thread {
    public Deque<String> dequeMemberOrder;
    private final ChatMember chatMember;

    @Override
    public void run() {
        while (!dequeMemberOrder.isEmpty()) {
            chatMember.sendMessage(dequeMemberOrder);
        }
    }

    public ConsoleChat(ChatMember chatMember, Deque<String> dequeMemberOrder) {
        this.chatMember = chatMember;
        this.dequeMemberOrder = dequeMemberOrder;
    }
}
