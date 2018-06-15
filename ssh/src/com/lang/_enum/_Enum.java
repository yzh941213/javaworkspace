package com.lang._enum;

public class _Enum {

    public static void main(String[] args) {

       //获取枚举的序号
       System.out.println(TestEnum._BYTE.ordinal());
       //获取两个枚举类的序号
       System.out.println(TestEnum._BYTE.compareTo(TestEnum._SHORT));
       //获取enum的枚举
       System.out.println(TestEnum.valueOf("_INT").getStr());
    }


    private enum TestEnum{
        _STR("str"),
        _INT("int"),
        _BYTE("byte"),
        _SHORT("short");


        private String str;

        TestEnum(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    private enum TestEnum2{
        _STR("str"),
        _INT("int"),
        _BYTE("byte"),
        _SHORT("short");


        private String str;

        TestEnum2(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }
}
