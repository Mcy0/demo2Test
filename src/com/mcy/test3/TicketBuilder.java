package com.mcy.test3;

public class TicketBuilder {
    public static Object builder(TicketHelper helper)
    {
        System.out.println("通过TicketHelper构建套票信息");
        return null;
    }

    public static void main(String[] args) {
        TicketHelper helper = new TicketHelper();
        helper.buildAdult("成年人");
        helper.buildAdult("儿童");
        Object object = TicketBuilder.builder(helper);
    }
}
