package com.arthur.ms.usercredit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_CREDIT_CHG_LN")
public class CreditLine {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "CHANGE_TYPE")
    private String changeType;
    @Column(name = "CHANGE_CATEGORY")
    private String changeCategory;
    @Column(name = "CHANGE_CATEGORY_CD")
    private String changeCategoryCD;
    @Column(name = "CREDIT_POINT")
    private Long creditPoint;
    @Column(name = "CHANGE_ON_DTTM")
    private Long changeOnDttm;
    @Column(name = "CHANGE_ON_DT_STR")
    private String changeOnDtStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String chagneType) {
        this.changeType = chagneType;
    }

    public String getChangeCategory() {
        return changeCategory;
    }

    public void setChangeCategory(String changeCategory) {
        this.changeCategory = changeCategory;
    }

    public String getChangeCategoryCD() {
        return changeCategoryCD;
    }

    public void setChangeCategoryCD(String changeCategoryCD) {
        this.changeCategoryCD = changeCategoryCD;
    }

    public Long getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(Long credigPoint) {
        this.creditPoint = credigPoint;
    }

    public Long getChangeOnDttm() {
        return changeOnDttm;
    }

    public void setChangeOnDttm(Long changeOnDttm) {
        this.changeOnDttm = changeOnDttm;
    }

    public String getChangeOnDtStr() {
        return changeOnDtStr;
    }

    public void setChangeOnDtStr(String changeOnDtStr) {
        this.changeOnDtStr = changeOnDtStr;
    }


}
