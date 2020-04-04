package com.example.ReEcProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class OrderTopping {
    /** 注文トッピングID */
    @Id
    private Integer id;
    /** トッピングID */
    private Integer toppingId;
    /** オーダーアイテムID */
    private Integer orderItemId;
    /** トッピングオブジェクト */
    private Topping topping;
}
