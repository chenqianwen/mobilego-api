package com.example.mobilego;


import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author： ygl
 * @date： 2018/3/26-10:34
 * @Description：
 */
@Slf4j
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("新增的时候干点不可描述的事情");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新的时候干点不可描述的事情");
    }
}
