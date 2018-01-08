package com.zhezhuo.model.enums;


public enum  OrderStatusEnum {

    ORDER_CREATED("ORDER_CREATED", Integer.valueOf(0), "待付款"),
    ORDER_CANCELLED("ORDER_CANCELLED", Integer.valueOf(1), "待发货"),
    ORDER_PAID("ORDER_PAID", Integer.valueOf(2), "待收货"),
    ORDER_SHIPPED("ORDER_SHIPPED", Integer.valueOf(3), "待评价"),
    ORDER_RECEIVED("ORDER_RECEIVED", Integer.valueOf(4), "交易成功"),
    ORDER_COMPLETED("ORDER_COMPLETED", Integer.valueOf(5), "交易关闭"),
    ORDER_CLOSED("ORDER_CLOSED", Integer.valueOf(6), "取消交易"),
    ORDER_DELED("ORDER_DELED", Integer.valueOf(7), "删除交易");

    private String code;
    private Integer value;
    private String description;

    private OrderStatusEnum(String code, Integer value, String description) {
        this.code = code;
        this.value = value;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }


    public static Boolean isCreated(String statusCode) {
        return Boolean.valueOf(ORDER_CREATED.getCode().equals(statusCode));
    }

    public static Boolean isCancelled(String statusCode) {
        return Boolean.valueOf(ORDER_CANCELLED.getCode().equals(statusCode));
    }

    public static Boolean isPaid(String statusCode) {
        return Boolean.valueOf(ORDER_PAID.getCode().equals(statusCode));
    }

    public static Boolean isShipped(String statusCode) {
        return Boolean.valueOf(ORDER_SHIPPED.getCode().equals(statusCode));
    }

    public static Boolean isReceived(String statusCode) {
        return Boolean.valueOf(ORDER_RECEIVED.getCode().equals(statusCode));
    }

    public static Boolean isCompleted(String statusCode) {
        return Boolean.valueOf(ORDER_COMPLETED.getCode().equals(statusCode));
    }

    public static Boolean isClosed(String statusCode) {
        return Boolean.valueOf(ORDER_CLOSED.getCode().equals(statusCode));
    }
    public static Boolean isDel(String statusCode) {
        return Boolean.valueOf(ORDER_DELED.getCode().equals(statusCode));
    }

    public static String getCodeByValue(Integer value) {
        OrderStatusEnum[] values = values();
        int length = values.length;

        for(int i = 0; i < length; ++i) {
            OrderStatusEnum orderStatusEnum = values[i];
            if(orderStatusEnum.getValue().equals(value)) {
                return orderStatusEnum.getCode();
            }
        }

        return null;
    }

    public static String getDescriptionByValue(Integer value) {
        OrderStatusEnum[] values = values();
        int length = values.length;

        for(int i = 0; i < length; ++i) {
            OrderStatusEnum orderStatusEnum = values[i];
            if(orderStatusEnum.getValue().equals(value)) {
                return orderStatusEnum.getDescription();
            }
        }

        return null;
    }

    public static OrderStatusEnum getEnumByValue(Integer value) {
        OrderStatusEnum[] values = values();
        int length = values.length;

        for(int i = 0; i < length; ++i) {
            OrderStatusEnum orderStatusEnum = values[i];
            if(orderStatusEnum.getValue().equals(value)) {
                return orderStatusEnum;
            }
        }

        return null;
    }

    public static Integer getValueByCode(String code) {
        OrderStatusEnum[] values = values();
        int length = values.length;

        for(int i = 0; i < length; ++i) {
            OrderStatusEnum orderStatusEnum = values[i];
            if(orderStatusEnum.getCode().equals(code)) {
                return orderStatusEnum.getValue();
            }
        }

        return null;
    }
}
