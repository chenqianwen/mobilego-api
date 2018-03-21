package com.example.mobilego.init;


/**
 * @author： ygl
 * @date： 2018/3/21-15:10
 * @Description：
 * 数据初始化器:
 * 实现接口，来增加自定义的数据初始化行为.
 */
public interface DataInitializer {

    /**
     * 初始化器的执行顺序，数值越大的初始化器越靠后执行
     * @return
     */
    public Integer getIndex();

    /**
     * 初始化数据
     * @throws Exception
     */
    public void init() throws Exception;
}
