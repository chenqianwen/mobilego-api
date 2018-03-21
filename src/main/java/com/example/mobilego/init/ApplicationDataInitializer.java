package com.example.mobilego.init;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.Comparator;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/21-15:13
 * @Description： 应用的初始化器
 */
@Slf4j
public class ApplicationDataInitializer implements ApplicationRunner {

    @Autowired(required = false)
    private List<DataInitializer> dataInitializers;

    /**
     * 在容器启动完毕后（上下文刷新后）执行
     *
     * @param args 容器启动参数
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (CollectionUtils.isNotEmpty(dataInitializers)) {
            dataInitializers.sort(Comparator.comparing(DataInitializer::getIndex));
            dataInitializers.stream().forEach(dataInitializer -> {
                log.info(dataInitializer.getClass().getSimpleName()+"----"+dataInitializer.getIndex());
            });
        }
    }
}
