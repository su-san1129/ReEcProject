package com.example.ReEcProject.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
public class Order {

    /** 注文ID */
    @Id
    private Integer id;
    /** ユーザーID */
    private Integer userId;
    /** 状態 */
    private Integer status;
    /** 合計金額 */
    private Integer totalPrice;
    /** 注文日 */
    private Date orderDate;
    /** 宛名氏名 */
    private String destinationName;
    /** 宛名Eメール */
    private String destinationEmail;
    /** 宛名郵便番号 */
    private String destinationZipcode;
    /** 宛名住所 */
    private String destinationAddress;
    /** 宛名TEL */
    private String destinationTel;
    /** 配達時間 */
    private Timestamp deliveryTime;
    /** 支払方法 */
    private Integer paymentMethod;
    /** ユーザー */
    private User user;
    /** 注文商品リスト */
    private List<OrderItem> orderItemList;
}
