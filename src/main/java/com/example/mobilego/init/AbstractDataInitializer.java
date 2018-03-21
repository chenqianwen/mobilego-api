package com.example.mobilego.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author： ygl
 * @date： 2018/3/21-15:54
 * @Description：
 * 抽象基类，所有的数据初始化器应该继承此类
 */
@Slf4j
public abstract class AbstractDataInitializer implements DataInitializer{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void init() throws Exception {
        if(isNeedInit()) {
            log.info("使用"+getClass().getSimpleName()+"初始化数据");
            doInit();
            log.info("使用"+getClass().getSimpleName()+"初始化数据完毕");
        }
    }

    /**
     * 子类需实现：是否需要初始化数据
     * @return
     */
    public abstract boolean isNeedInit();

    /**
     * 子类需实现：具体的初始化逻辑
     */
    public abstract void doInit();
}
