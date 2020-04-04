package com.example.ReEcProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Topping {
    /** トッピングID */
    @Id
    private Integer id;
    /** トッピング名 */
    private String name;
    /** Mサイズのトッピング価格 */
    private Integer priceM;
    /** Lサイズのトッピング価格 */
    private Integer priceL;
}
