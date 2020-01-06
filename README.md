# exportdatabase
将数据库结构出为表

### 导出.md文件如下所示

#### 1.购物车表(pc_omc_cart)

| Name             | Type         | Description                | PrimaryKey |
| ---------------- | ------------ | -------------------------- | ---------- |
| id               | bigint(19)   | ID                         | no         |
| version          | int(10)      | 版本号                     | no         |
| user_id          | bigint(19)   | 用户ID                     | no         |
| product_id       | bigint(19)   | 商品ID                     | no         |
| quantity         | int(10)      | 数量                       | no         |
| checked          | int(10)      | 是否选择,1=已勾选,0=未勾选 | no         |
| creator          | varchar(20)  | 创建人                     | no         |
| creator_id       | bigint(19)   | 创建人ID                   | no         |
| created_time     | datetime(19) | 创建时间                   | no         |
| last_operator    | varchar(20)  | 最近操作人                 | no         |
| last_operator_id | bigint(19)   | 最后操作人ID               | no         |
| update_time      | datetime(19) | 更新时间                   | no         |

#### 2.订单表(pc_omc_order)

| Name             | Type         | Description                                                  | PrimaryKey |
| ---------------- | ------------ | ------------------------------------------------------------ | ---------- |
| id               | bigint(19)   | ID                                                           | no         |
| version          | int(10)      | 版本号                                                       | no         |
| order_no         | varchar(20)  | 订单号                                                       | no         |
| user_id          | bigint(19)   | 用户ID                                                       | no         |
| shipping_id      | bigint(19)   | 收货人ID                                                     | no         |
| payment          | decimal(20)  | 实际付款金额,单位是元,保留两位小数                           | no         |
| payment_type     | int(10)      | 支付类型,1-在线支付                                          | no         |
| postage          | int(10)      | 运费,单位是元                                                | no         |
| status           | int(10)      | 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭 | no         |
| payment_time     | datetime(19) | 支付时间                                                     | no         |
| send_time        | datetime(19) | 发货时间                                                     | no         |
| end_time         | datetime(19) | 交易完成时间                                                 | no         |
| close_time       | datetime(19) | 交易关闭时间                                                 | no         |
| creator          | varchar(20)  | 创建人                                                       | no         |
| creator_id       | bigint(19)   | 创建人ID                                                     | no         |
| created_time     | datetime(19) | 创建时间                                                     | no         |
| last_operator    | varchar(20)  | 最近操作人                                                   | no         |
| last_operator_id | bigint(19)   | 最后操作人ID                                                 | no         |
| update_time      | datetime(19) | 更新时间                                                     | no         |

#### 



