package com.sunline.modules.notice.enums;

/**
 * 通知类枚举
 * @author lcs
 * @email
 * @date 2018-08-29 15:39
 */
public final class NoticeEnums {
    private NoticeEnums() {
    }
    /**
     * 通知来源
     */
    public enum NoticeSource {
        SOURCE_USER("1", "人工通知"),
        SOURCE_SYS("2", "系统通知"),
        SOURCE_FLOW("3", "流程通知");

        private final String index;
        private final String name;

        NoticeSource(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (NoticeSource c : NoticeSource.values()) {
                if (c.getIndex().equals(index)) {
                    return c.getName();
                }
            }
            return null;
        }
    }

    /**
     * 通知状态
     */
    public enum NoticeStatus {
        STATUS_PLC("0", "已发布"),
        STATUS_DRA("1", "草稿");

        private final String index;
        private final String name;

        NoticeStatus(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (NoticeStatus c : NoticeStatus.values()) {
                if (c.getIndex().equals(index)) {
                    return c.getName();
                }
            }
            return null;
        }
    }

    /**
     * 是否紧急
     */
    public enum NoticeUrgent {
        URGENT_YES("0", "是"),
        URGENT_NO("1", "否");

        private final String index;
        private final String name;

        NoticeUrgent(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (NoticeUrgent c : NoticeUrgent.values()) {
                if (c.getIndex().equals(index)) {
                    return c.getName();
                }
            }
            return null;
        }
    }
}
