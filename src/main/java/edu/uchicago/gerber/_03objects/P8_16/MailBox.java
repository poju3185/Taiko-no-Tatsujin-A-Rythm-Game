package edu.uchicago.gerber._03objects.P8_16;

import java.util.ArrayList;

public class MailBox {
    private final ArrayList<Message> mailList;
    public MailBox(){
        mailList = new ArrayList<>();
    }

    public void addMessage(Message m){
        mailList.add(m);
    }
    public Message getMessage(int i){
       return mailList.get(i);
    }
    public void removeMessage(int i){
        mailList.remove(i);
    }
}
