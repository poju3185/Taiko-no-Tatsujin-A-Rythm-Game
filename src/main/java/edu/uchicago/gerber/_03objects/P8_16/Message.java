package edu.uchicago.gerber._03objects.P8_16;

public class Message {
    private String sender;
    private String recipient;
    private String text;

    public Message(String sender, String recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = "";
    }

    public void append(String newText) {
        text += newText + "%n";
    }

    public String toString() {
        return "From: " + sender + "%n" + "To: " + recipient + "%n" + text;
    }

}
