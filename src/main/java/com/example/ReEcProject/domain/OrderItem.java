package com.example.ReEcProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderItem {
    /** 注文商品ID */
    @Id
    private Integer id;
    /** 商品ID */
    private Integer itemId;
    /** 注文ID */
    private Integer orderId;
    /** 数量 */
    private Integer quantity;
    /** サイズ */
    private Character size;
    /** アイテム */
    private Item item;
}
