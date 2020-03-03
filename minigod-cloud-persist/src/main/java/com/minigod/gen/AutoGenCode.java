package com.minigod.gen;

import com.minigod.db4j.generator.DBUtil;
import com.minigod.db4j.generator.Db4jGenerator;
import com.minigod.db4j.generator.MetaUtil;

/**
 * 持久化构建
 */
public class AutoGenCode {
    public static void main(String[] args) {

        //数据库配置
        DBUtil.DIREVER = "com.mysql.jdbc.Driver";
        DBUtil.URL = "jdbc:mysql://10.1.2.52:3306/minigod?characterEncoding=UTF-8&rewriteBatchedStatements=true";
        DBUtil.USERNAME = "root";
        DBUtil.PASSWORD = "9fstockdb";

        //表别名相关
        //MetaUtil.PREFIX = "core,C:dict,C";//前缀替换，将core_替换成C,dict_替换成C,多个替换间使用冒号分隔
        MetaUtil.DecimalToDouble =
                new String[]{"activity_user_index", "ad_gift_info", "ad_info", "ad_niu_info", "ad_user_act_info",
                        "ad_user_niu_reg", "adviser_note", "adviser_open_info", "adviser_open_statistics",
                        "adviser_org", "adviser_verify_info", "adviser_verify_req", "app_version", "app_download_count",
                        "broker_deposit_info", "broker_info", "broker_open_account", "broker_stkacc_info",
                        "div_allot_reservation", "friend_attrib_extend", "friend_group", "game_event_info",
                        "game_stk_info", "game_stk_like", "game_user_info", "im_chat_message", "im_group",
                        "im_group_member", "im_group_message", "invest_msg", "msg_read_record", "ptf_auth", "ptf_fav",
                        "ptf_idx_chg_his", "ptf_idx_dtl_curr", "ptf_idx_dtl_his", "ptf_idx_his",
                        "ptf_info:ptf_index,volatility", "ptf_like", "ptf_note", "ptf_note_interaction", "ptf_yld",
                        "real_fund_bal", "real_fund_bal_his", "real_ptf_bal", "real_ptf_trans", "real_ptf_trans_his",
                        "real_stk_bal", "real_stk_bal_his", "real_stk_cfm", "real_stk_cfm_his", "real_stk_ord",
                        "real_stk_ord_his", "simu_ptf_bal", "simu_ptf_trans", "simu_ptf_trans_his", "simu_stk_bal",
                        "simu_stk_cfm", "simu_stk_cfm_his", "simu_stk_ord", "simu_stk_ord_his", "sms_captcha",
                        "sms_push", "sms_send", "sms_template", "sms_template_ext", "stk_his_cfm", "stk_his_order",
                        "stk_position", "stk_today_cfm", "stk_today_order", "sys_city", "sys_config", "sys_dict",
                        "sys_job_log", "sys_msg", "sys_province", "sys_sensitive_word", "sys_sequence", "user_ad_reg",
                        "user_broker", "user_cert", "user_channel", "user_contact", "user_device", "user_feedback",
                        "user_friend", "user_friend_new", "user_info", "user_option_stock", "user_req", "user_session",
                        "user_uninvited"
                        , "hq_market_info", "hq_package_info", "hq_order_info", "sec_deposit_funds",
                        "sec_transferred_stock_m", "sec_poundage_free","user_double_verify"};
        //MetaUtil.DecimalToDouble = new String[]{"user_thirdparty_session"};
        //生成表的包名配置
        String domain = "com.minigod.broker.persist";
        //生成所有表，参数2为输出目录，填null则输出在本项目的src/main/java目录下
        Db4jGenerator.execute(domain, "F:\\src","lock_version");
    }
}
