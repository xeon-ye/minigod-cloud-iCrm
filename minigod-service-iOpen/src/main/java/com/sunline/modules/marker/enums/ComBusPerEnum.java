package com.sunline.modules.marker.enums;

/**
 * 渠道信息表
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
public final class ComBusPerEnum {
    private ComBusPerEnum() {
    }

    /**
     * 客户状态
     */
    public enum PersonnelStatus {
        PERSONNEL_STATUS_DEL("0", "删除"),
        PERSONNEL_STATUS_NOL("1", "正常"),
        PERSONNEL_STATUS_FOR("2", "禁用"),
        PERSONNEL_STATUS_MIS("3", "离职"),
        PERSONNEL_STATUS_CEK("4", "待审核"),
        PERSONNEL_STATUS_NCK("5", "审核不通过");

        PersonnelStatus(String index, String name) {
            this.index = index;
            this.name = name;
        }

        private final String index;
        private final String name;

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (PersonnelStatus p : PersonnelStatus.values()) {
                if (p.getIndex().equals(index)) {
                    return p.getName();
                }
            }
            return null;
        }
    }

    /**
     * 客户角色
     */
    public enum PersonnelRole {
        PERSONNEL_ROLE_SYN("0", "经理人"),
        PERSONNEL_ROLE_EYE("1", "见证人");

        private final String index;
        private final String name;

        PersonnelRole(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (PersonnelRole p : PersonnelRole.values()) {
                if (p.getIndex().equals(index)) {
                    return p.getName();
                }
            }
            return null;
        }
    }

    /**
     * 学历
     */
    public enum EducationType{
        EDUCATION_TYPE_OTH("0","其他"),
        EDUCATION_TYPE_DOC("1","博士"),
        EDUCATION_TYPE_MOS("2","硕士"),
        EDUCATION_TYPE_BOS("3","学士"),
        EDUCATION_TYPE_JUC("4","大专"),
        EDUCATION_TYPE_POS("5","中专"),
        EDUCATION_TYPE_HIS("6","高中"),
        EDUCATION_TYPE_MDS("7","初中及其以下");

        private final String index;
        private final String name;

        EducationType(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (EducationType e : EducationType.values()) {
                if (e.getIndex().equals(index)) {
                    return e.getName();
                }
            }
            return null;
        }
    }

    /**
     * 证件类型
     */
    public enum IdType{
        ID_TYPE_OTH("0","其他有效证件"),
        ID_TYPE_IDC("1","身份证"),
        ID_TYPE_NAP("2","本国护照"),
        ID_TYPE_FOP("3","国外护照"),
        ID_TYPE_ENP("4","台湾通行证及其他有效旅行证"),
        ID_TYPE_CIP("5","武警文职干部证"),
        ID_TYPE_APS("6","武警士兵证"),
        ID_TYPE_SOG("7","社会团体"),
        ID_TYPE_IID("8","临时身份证"),
        ID_TYPE_ORC("9","全国组织机构代码"),
        ID_TYPE_OCN("10","海外客户编号"),
        ID_TYPE_OID("11","境外身份证"),
        ID_TYPE_RID("12","港澳台居民身份证"),
        ID_TYPE_BUL("13","营业执照");

        private final String index;
        private final String name;

        IdType(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (IdType i : IdType.values()) {
                if (i.getIndex().equals(index)) {
                    return i.getName();
                }
            }
            return null;
        }
    }

}
