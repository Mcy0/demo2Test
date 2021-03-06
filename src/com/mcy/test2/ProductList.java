package com.mcy.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
    private List<String> productList = null;//产品列表
    private static ProductList instance = null;
    private ProductList(){}
    public static ProductList getInstance()
    {
        if (instance == null)
        {
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }

    /**
     * 增加观测者
     * @param observable 观测者
     */
    public void addProductListObserver(Observer observable)
    {
        this.addObserver(observable);
    }

    /**
     * 新增产品
     * @param newProduct 新产品
     */
    public void addProduct(String newProduct)
    {
        productList.add(newProduct);
        System.out.println("产品列表新增了产品：" + newProduct);
        this.setChanged();//设置被观察者发生了变化
        this.notifyObservers(newProduct);//通知观察者并传递新产品
    }
}
