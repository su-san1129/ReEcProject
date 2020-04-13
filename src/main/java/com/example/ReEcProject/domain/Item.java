package com.example.ReEcProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@AllArgsConstructor
@Table("ITEMS")
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

}
