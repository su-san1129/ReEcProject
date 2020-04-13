package com.example.ReEcProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@Table("users")
public class User {
    /** ID */
    @Id
    private Integer id;
    /** 名前 */
    private String name;
    /** Eメール */
    private String email;
    /** パスワード */
    private String password;
    /** 郵便番号 */
    private String zipcode;
    /** 住所 */
    private String address;
    /** 電話番号 */
    private String telephone;
    /** 管理者 */
    private boolean isadmin;
}
