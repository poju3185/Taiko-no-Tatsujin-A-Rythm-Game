package edu.uchicago.gerber._03objects.P8_16;

public class EmailDriver {
    public static void main(String[] args){
        MailBox myMailBox = new MailBox();
        Message m = new Message("James", "Jason");
        m.append("hello");
        m.append("haha");
        myMailBox.addMessage(m);
        System.out.println(myMailBox.getMessage(0));
        myMailBox.removeMessage(0);
        myMailBox.addMessage(m);
        System.out.println(myMailBox.getMessage(0));
    }
}
