package sitcomchat;

import sitcomchat.service.TextConverter;
import sitcomchat.threadinstance.ChatMember;
import sitcomchat.threadinstance.ConsoleChat;

import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.List;


public class SitcomChatApp {
    public static void main(String[] args) throws FileNotFoundException {
        TextConverter textConverter = new TextConverter("src/sitcomStage.txt");
        List<ChatMember> chatMemberList = textConverter.getChatMembers();
        Deque<String> dequeMemberOrder = textConverter.getDequeMemberOrder();
        for(ChatMember chatMember: chatMemberList){
            new ConsoleChat(chatMember,dequeMemberOrder).start();
        }
    }
}
