package com.example.demo.common.cons;

/**
 * GO: 自定义常量和枚举
 *
 * @author jiwei.chen
 * @create 2018-12-12
 */
public class Constants {

    public static final String UTF8 = "utf-8";

    public enum PlatformStatus {
        OPERATING(1, "运营中"),
        SHUTDOWN(2, "停业"),
        TRANSFORMATIONS(3, "转型");

        private int code;
        private String desc;

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static String getDescByCode(int code) {
            PlatformStatus[] values = PlatformStatus.values();
            for (PlatformStatus value : values) {
                if (value.getCode() == code){
                    return value.getDesc();
                }
            }
            return null;
        }

        PlatformStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public enum AreaLevel{
        PROVINCE(1,"省"),
        CITY(2,"市"),
        DISTRICT(3,"区");

        private int code;
        private String desc;

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        AreaLevel(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

}
