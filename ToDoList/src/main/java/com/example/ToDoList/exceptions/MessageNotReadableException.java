package com.example.ToDoList.exceptions;

public class MessageNotReadableException extends Exception{

    public MessageNotReadableException(){
        super("Data sent is not valid. Please check again.");
    }


}
