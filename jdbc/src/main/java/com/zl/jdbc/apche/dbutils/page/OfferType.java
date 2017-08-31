package com.zl.jdbc.apche.dbutils.page;

/**
 * Created by Administrator on 2017/8/8.
 */

/**
 * <Description> <br>
 *
 * @author <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016-10-12 <br>
 * @since<br>
 * @see com.zl.jdbc.apche.dbutils.page <br>
 */
public class OfferType {
    private int offer_Type;

    private String offer_Type_Name;

    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getOffer_Type() {
        return offer_Type;
    }

    public void setOffer_Type(int offer_Type) {
        this.offer_Type = offer_Type;
    }

    public String getOffer_Type_Name() {
        return offer_Type_Name;
    }

    public void setOffer_Type_Name(String offer_Type_Name) {
        this.offer_Type_Name = offer_Type_Name;
    }

    @Override
    public String toString() {
        return "OfferType [offer_Type=" + offer_Type + ", offer_Type_Name=" + offer_Type_Name + ", comments="
                + comments + "]";
    }
}