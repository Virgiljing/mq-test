package com.virgilin.mqtest.mymq;

import java.io.IOException;

public class ConsumeClient {
    public static void main(String[] args) throws IOException {
        String consume = MqClient.consume();
        System.out.println(consume);
    }
}
