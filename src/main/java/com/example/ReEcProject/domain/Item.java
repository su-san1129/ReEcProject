package com.example.ReEcProject.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Item {
    /** ID */
    @Id
    private Integer id;
    /** 名前 */
    private String name;
    /** 説明 */
    private String description;
    /** Mの価格 */
    private Integer priceM;
    /** Lの価格 */
    private Integer priceL;
    /** 画像パス */
    private String imagePath;
    /** 削除フラグ */
    private Boolean deleted;
    /** トッピングリスト */
    List<Topping> toppingList;
}
