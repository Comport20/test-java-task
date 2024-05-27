package sitcomchat.service;

import sitcomchat.threadinstance.ChatMember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TextConverter {
    private final Deque<String> dequeMemberOrder;
    private final Map<String, ChatMember> chatMemberHashMap;
    private final Scanner scanner;
    public TextConverter(String fileURL) throws FileNotFoundException {
        scanner = new Scanner(new File(fileURL));
        chatMemberHashMap = new HashMap<>();
        dequeMemberOrder = new ArrayDeque<>();
        createOrder();
    }
    private void createOrder(){
        while(scanner.hasNextLine()){
            String lineReplica = scanner.nextLine();
            int breakpointCharPos = lineReplica.indexOf(":");
            String name = lineReplica.substring(0,breakpointCharPos);
            addNameAndLineReplica(name,lineReplica);
        }
    }
    private void addNameAndLineReplica(String name, String lineReplica){
        dequeMemberOrder.add(name);
        chatMemberHashMap.putIfAbsent(name, new ChatMember(name));
        chatMemberHashMap.get(name).pushDequeMessageFlow(lineReplica);
    }
    public List<ChatMember> getChatMembers(){
        return new ArrayList<>(chatMemberHashMap.values());
    }
    public Deque<String> getDequeMemberOrder(){
        return dequeMemberOrder;
    }
}
