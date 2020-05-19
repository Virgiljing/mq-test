package com.virgilin.mqtest.mymq;

import java.io.IOException;

public class ProduceClient {
    public static void main(String[] args) throws IOException {
        MqClient.produce("Hello world");
    }
}
