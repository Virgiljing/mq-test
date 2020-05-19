package com.virgilin.mqtest.mymq;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {

    /**
     * 消息队列存储的最大数量
     */
    private final static int MAX_SIZE = 3;

    /**
     * 保存消息队列的容器
     */
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(MAX_SIZE);

    //生产消息
    public static void produce(String msg){
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息处理中心投递消息：" + msg + ",当前暂存的消息数量是：" + messageQueue.size());
        }else {
            System.out.println("消息处理中心暂存的消息达到最大负荷，不能继续放入消息");
        }

        System.out.println("====================================");
    }

    //消息消费
    public static String consume(){
        String msg = messageQueue.poll();
        if (msg != null) {
            System.out.println("已将消费消息：" + msg + ",当前暂存的消息数量是：" + messageQueue.size());
        }else {
            System.out.println("消息处理中心内没有消息可供消费");
        }
        System.out.println("====================================");
        return msg;
    }

}
