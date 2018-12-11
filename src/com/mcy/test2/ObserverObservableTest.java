package com.mcy.test2;

import org.junit.jupiter.api.Test;

public class ObserverObservableTest {
    @Test
    public void test()
    {
        ProductList productList = ProductList.getInstance();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        JingDongObserver jingDongObserver = new JingDongObserver();
        productList.addObserver(jingDongObserver);
        productList.addObserver(taoBaoObserver);
        productList.addProduct("产品");
    }
}
