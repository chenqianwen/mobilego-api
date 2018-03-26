//package com.example.mobilego.init;
//
//import com.example.mobilego.constant.DataInitializerOrder;
//import com.example.mobilego.dao.CategoryDao;
//import com.example.mobilego.dao.CategoryProductDao;
//import com.example.mobilego.dao.OrderProductDao;
//import com.example.mobilego.dao.ProductDao;
//import com.example.mobilego.dao.ThemeDao;
//import com.example.mobilego.dao.ThemeProductDao;
//import com.example.mobilego.entity.jap.Category;
//import com.example.mobilego.entity.jap.CategoryProduct;
//import com.example.mobilego.entity.jap.Product;
//import com.example.mobilego.entity.jap.Theme;
//import com.example.mobilego.entity.jap.ThemeProduct;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author： ygl
// * @date： 2018/3/21-15:58
// * @Description：
// * 微信测试数据
// */
//@Component
//public class WechatTestDataInitializer extends AbstractDataInitializer {
//
//    String imgUrl1 = "http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg";
//    String imgUrl2 = "http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg";
//    String imgUrl3 = "http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg";
//
//    List<Product> productList = new ArrayList<>();
//
//    @Autowired
//    private ProductDao productDao;
//
//    @Autowired
//    private CategoryDao categoryDao;
//
//    @Autowired
//    private ThemeDao themeDao;
//
//    @Autowired
//    private CategoryProductDao categoryProductDao;
//
//    @Autowired
//    private OrderProductDao orderProductDao;
//
//    @Autowired
//    private ThemeProductDao themeProductDao;
//
//    /**
//     * 没有商品的时候，做初始化的操作
//     * @return
//     */
//    @Override
//    public boolean isNeedInit() {
//        return productDao.count() == 0;
//    }
//
//    /**
//     * 初始化的操作。。
//     */
//    @Override
//    public void doInit() {
//        initProduct();
//        initCategory();
//        initTheme();
//    }
//
//    @Override
//    public Integer getIndex() {
//        return DataInitializerOrder.weixintest;
//    }
//
//    void initProduct(){
//        int countData = 100;
//        String[] imgArray = new String[]{imgUrl1,imgUrl2,imgUrl3};
//        for (int i = 0; i < countData; i++) {
//            Product product = new Product();
//            product.setName("测试商品"+i);
//            product.setPrice(new BigDecimal(i));
//            product.setMajorImgUrl(imgUrl1);
//            product.setMinorImgUrls(StringUtils.join(imgArray,","));
//            product.setDetailImgUrls(StringUtils.join(imgArray,","));
//            product.setDescription(product.getName()+"------2018全新上市，给你不一样的体验！！！！！");
//            productList.add(product);
//        }
//        productDao.saveAll(productList);
//    }
//    void initCategory(){
//        int countData = 10;
//        List<CategoryProduct> categoryProductList = new ArrayList<>();
//        for (int i = 0; i < countData; i++) {
//            Category category = new Category();
//            category.setName("测试分类"+i);
//            category.setMajorImgUrl(imgUrl3);
//            category.setSort(i);
//            Category savedModel = categoryDao.save(category);
//            for (int j = 0; j < countData; j++) {
//                CategoryProduct categoryProduct = new CategoryProduct();
//                categoryProduct.setCategoryId(savedModel.getId());
//                categoryProduct.setProductId(productList.get(i * 10 + j).getId());
//                categoryProductList.add(categoryProduct);
//            }
//
//        }
//        categoryProductDao.saveAll(categoryProductList);
//    }
//    void initTheme(){
//        int countData = 3;
//        List<ThemeProduct> themeProducts = new ArrayList<>();
//        for (int i = 0; i < countData; i++) {
//            Theme theme = new Theme();
//            theme.setSort(i);
//            theme.setName("测试主题"+i);
//            Theme savedModel = themeDao.save(theme);
//            for (int j = 0; j < 10; j++) {
//                ThemeProduct themeProduct = new ThemeProduct();
//                themeProduct.setThemeId(savedModel.getId());
//                themeProduct.setProductId(productList.get(i * 10 + j).getId());
//                themeProducts.add(themeProduct);
//            }
//        }
//        themeProductDao.saveAll(themeProducts);
//
//    }
//}
