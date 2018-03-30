1。spring data jpa的审计功能：
@CreatedDate、@CreatedBy、@LastModifiedDate、@LastModifiedBy
需要在类上加上注解@EntityListeners(AuditingEntityListener.class)，
其次在application启动类中加上注解EnableJpaAuditing
在jpa.save方法被调用的时候，时间字段会自动设置并插入数据库，
但是CreatedBy和LastModifiedBy并没有赋值，因为需要实现AuditorAware接口来返回你需要插入的值。



localhost:8010/api/druid/login.html

主题 + 商品 ／ 分类 + 商品 重构==》

只获取第一个的主题的名称 + 和对应的商品。商品分页。
再次获取时，根据是否变动的标志 （可用redis），再去查询数据