CREATE TABLE `product`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `created_date` datetime(0) NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改者',
  `updated_date` datetime(0) NOT NULL COMMENT '修改时间',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品的描述',
  `detail_img_urls` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '明细图url',
  `is_banner` tinyint(4) DEFAULT 0 COMMENT '商品的描述',
  `major_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主图url',
  `minor_img_urls` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '次图url',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `category`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `created_date` datetime(0) NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改者',
  `updated_date` datetime(0) NOT NULL COMMENT '修改时间',
  `major_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类主图',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `sort` smallint(6) DEFAULT NULL COMMENT '分类排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `theme`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `created_date` datetime(0) NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改者',
  `updated_date` datetime(0) NOT NULL COMMENT '修改时间',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主题名称',
  `sort` smallint(6) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `orders`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `created_date` datetime(0) NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改者',
  `updated_date` datetime(0) NOT NULL COMMENT '修改时间',
  `order_status` tinyint(4) NOT NULL COMMENT '订单状态',
  `total_price` decimal(10, 2) NOT NULL COMMENT '订单总价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `category_product`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `created_date` datetime(0) NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改者',
  `updated_date` datetime(0) NOT NULL COMMENT '修改时间',
  `category_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类ID',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `theme_product`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `created_date` datetime(0) NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改者',
  `updated_date` datetime(0) NOT NULL COMMENT '修改时间',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `theme_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主题ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `order_product` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `created_date` datetime(0) NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `updated_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改者',
  `updated_date` datetime(0) NOT NULL COMMENT '修改时间',
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单ID',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `count` int(8) NOT NULL DEFAULT 0 COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;