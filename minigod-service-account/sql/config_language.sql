
INSERT INTO `mg_main`.`config_language` (
  `config_key`,
  `lang_key`,
  `content`,
  `marks`,
  `create_time`,
  `update_time`
)
VALUES
('OK','zh_CN', '调用成功','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('OK','zh_HK', '調用成功', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('ERROR_UNKNOWN','zh_CN', '未知错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('ERROR_UNKNOWN','zh_HK', '未知錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('REMOTE_CONNECT_ERROR','zh_CN', '连接失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('REMOTE_CONNECT_ERROR','zh_HK', '連接失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('REMOTE_REQUEST_ERROR','zh_CN', '请求失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('REMOTE_REQUEST_ERROR','zh_HK', '請求失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_REQUEST','zh_CN', '错误的请求','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_REQUEST','zh_HK', '錯誤的請求', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_ARGS','zh_CN', '参数错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_ARGS','zh_HK', '參數錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_PARAMS','zh_CN', 'Params参数错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_PARAMS','zh_HK', 'Params參數錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_PARAMS_VALUE','zh_CN', 'Params参数值错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_PARAMS_VALUE','zh_HK', 'Params參數值錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_PARAM_SIGN','zh_CN', '签名参数SIGN错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_PARAM_SIGN','zh_HK', '簽名參數SIGN錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_SOCKET','zh_CN', '网络异常','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_SOCKET','zh_HK', '網絡異常', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_PARAM_KEY','zh_CN', '签名参数KEY错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_PARAM_KEY','zh_HK', '簽名參數KEY錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_PARAM_SESSION','zh_CN', '参数TOKEN错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_PARAM_SESSION','zh_HK', '參數TOKEN錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_PROXY_SECRET','zh_CN', '参数SECRET错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_PROXY_SECRET','zh_HK', '參數SECRET錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_PROXY_AUTH_CODE','zh_CN', '参数AUTH_CODE错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_PROXY_AUTH_CODE','zh_HK', '參數AUTH_CODE錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('ERROR_INTERNAL','zh_CN', '请求异常,请重试','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('ERROR_INTERNAL','zh_HK', '請求異常,請重試', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('NONE_DATA','zh_CN', '无满足条件的数据','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('NONE_DATA','zh_HK', '無滿足條件的數據', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('EXIST_DATA','zh_CN', '有重复值存在','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('EXIST_DATA','zh_HK', '有重複值存在', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('SERVICE_UN_SUPPORT','zh_CN', '业务不支持','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('SERVICE_UN_SUPPORT','zh_HK', '業務不支持', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('ERROR_SIGN','zh_CN', '签名错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('ERROR_SIGN','zh_HK', '簽名錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('SESSION_INVALID','zh_CN', '未登录或者TOKEN已失效','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('SESSION_INVALID','zh_HK', '未登錄或者TOKEN已失效', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_FORMAT_PHONE','zh_CN', '手机号格式错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_FORMAT_PHONE','zh_HK', '手機號格式錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_FORMAT_EMAIL','zh_CN', '邮箱格式错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_FORMAT_EMAIL','zh_HK', '郵箱格式錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_FORMAT_ID_CARD','zh_CN', '身份证格式错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_FORMAT_ID_CARD','zh_HK', '身份證格式錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_FORMAT_BANK_CARD','zh_CN', '银行卡格式错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_FORMAT_BANK_CARD','zh_HK', '銀行卡格式錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_FETCH_CAPTCHA','zh_CN', '获取验证码失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_FETCH_CAPTCHA','zh_HK', '獲取驗證碼失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FETCH_SMS_CAPTCHA_OFTEN','zh_CN', '获取验证码过于频繁','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FETCH_SMS_CAPTCHA_OFTEN','zh_HK', '獲取驗證碼過於頻繁', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FETCH_EMAIL_CAPTCHA_OFTEN','zh_CN', '获取验证码过于频繁','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FETCH_EMAIL_CAPTCHA_OFTEN','zh_HK', '獲取驗證碼過於頻繁', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('IS_USED_CAPTCHA','zh_CN', '验证码已使用','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('IS_USED_CAPTCHA','zh_HK', '驗證碼已使用', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('IS_OVET_TIMES_CAPTCHA','zh_CN', '验证码已使用','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('IS_OVET_TIMES_CAPTCHA','zh_HK', '驗證碼已使用', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_LOGIN','zh_CN', '登录失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_LOGIN','zh_HK', '登錄失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_LOGIN_BY_OTHER','zh_CN', '登录失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_LOGIN_BY_OTHER','zh_HK', '登錄失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('NO_USER','zh_CN', '用户不存在','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('NO_USER','zh_HK', '用戶不存在', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_ACCOUNT_OR_PWD','zh_CN', '账号或密码错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_ACCOUNT_OR_PWD','zh_HK', '賬號或密碼錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BAD_OR_EXPIRE_CAPTCHA','zh_CN', '验证码错误或已失效','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BAD_OR_EXPIRE_CAPTCHA','zh_HK', '驗證碼錯誤或已失效', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PHONE_IS_USED','zh_CN', '手机号已使用','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PHONE_IS_USED','zh_HK', '手機號已使用', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_VERIFY_PHONE','zh_CN', '邮箱校验失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_VERIFY_PHONE','zh_HK', '郵箱校驗失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('EMAIL_IS_USED','zh_CN', '邮箱已使用','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('EMAIL_IS_USED','zh_HK', '郵箱已使用', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_VERIFY_EMAIL','zh_CN', '邮箱校验失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_VERIFY_EMAIL','zh_HK', '郵箱校驗失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('ID_CARD_USED_OR_UNSUPPORT','zh_CN', '身份证已使用或不支持','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('ID_CARD_USED_OR_UNSUPPORT','zh_HK', '身份證已使用或不支持', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('ID_CARD_AGE_LESS_18','zh_CN', '未满18周岁不可开通股票账户','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('ID_CARD_AGE_LESS_18','zh_HK', '未满18周岁不可开通股票账户', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_VERIFY_ID_CARD','zh_CN', '身份证校验失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_VERIFY_ID_CARD','zh_HK', '身份證校驗失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_VERIFY_ID_CARD_COUNT','zh_CN', '身份证校验每日次数上限','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_VERIFY_ID_CARD_COUNT','zh_HK', '身份證校驗每日次數上限', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_OCR','zh_CN', '身份证/银行卡识别失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_OCR','zh_HK', '身份證/銀行卡識別失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_OPEN_PROGRESS','zh_CN', '开户进度','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_OPEN_PROGRESS','zh_HK', '開戶進度', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('BANK_CARD_USED_OR_UNSUPPORT','zh_CN', '银行卡已使用或不支持','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('BANK_CARD_USED_OR_UNSUPPORT','zh_HK', '銀行卡已使用或不支持', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_VERIFY_BANK_CARD','zh_CN', '银行卡校验失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_VERIFY_BANK_CARD','zh_HK', '銀行卡校驗失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_VERIFY_BANK_CARD_COUNT','zh_CN', '银行卡校验每日次数上限','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_VERIFY_BANK_CARD_COUNT','zh_HK', '銀行卡校驗每日次數上限', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_VERIFY_SZCA','zh_CN', 'SZCA校验失败','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_VERIFY_SZCA','zh_HK', 'SZCA校驗失敗', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_VERIFY_SZCA_COUNT','zh_CN', 'SZCA校验每日次数上限','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_VERIFY_SZCA_COUNT','zh_HK', 'SZCA校驗每日次數上限', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_SAVE_CACHE_INFO','zh_CN', '保存缓存信息异常','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_SAVE_CACHE_INFO','zh_HK', '保存緩存信息異常', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_SAVE_CACHE_IMG','zh_CN', '保存图片异常','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_SAVE_CACHE_IMG','zh_HK', '保存圖片異常', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_GET_CACHE_DATA','zh_CN', '获取缓存数据异常','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_GET_CACHE_DATA','zh_HK', '獲取緩存數據異常', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('FAIL_SUBMIT_OPEN_INFO','zh_CN', '提交开户数据异常','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('FAIL_SUBMIT_OPEN_INFO','zh_HK', '提交開戶數據異常', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('NO_SUBMIT_OPEN_INFO_REPEAT','zh_CN', '不可重复提交','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('NO_SUBMIT_OPEN_INFO_REPEAT','zh_HK', '不可重複提交', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('ABO_ACCOUNT','zh_CN', '账号异常','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('ABO_ACCOUNT','zh_HK', '賬號異常', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PROXY_ERROR_UN_KNOW_APPID','zh_CN', '对应AppKey不存在','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PROXY_ERROR_UN_KNOW_APPID','zh_HK', '對應AppKey不存在', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PROXY_ERROR_UN_SUPPORT_APPID','zh_CN', '对应AppKey被禁用','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PROXY_ERROR_UN_SUPPORT_APPID','zh_HK', '對應AppKey被禁用', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PROXY_ERROR_BAD_SECRET','zh_CN', 'Secret错误','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PROXY_ERROR_BAD_SECRET','zh_HK', 'Secret錯誤', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PROXY_ERROR_UN_SUPPORT_DEVICE','zh_CN', '设备类型不符合','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PROXY_ERROR_UN_SUPPORT_DEVICE','zh_HK', '設備類型不符合', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PROXY_ERROR_UN_SUPPORT_OS_TYPE','zh_CN', '终端类型不符合','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PROXY_ERROR_UN_SUPPORT_OS_TYPE','zh_HK', '終端類型不符合', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PROXY_ERROR_UN_SUPPORT_APP_VERSION','zh_CN', '产品版本不符合','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PROXY_ERROR_UN_SUPPORT_APP_VERSION','zh_HK', '產品版本不符合', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PROXY_ERROR_LOCKED_DEVICE','zh_CN', '设备终端被锁定','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PROXY_ERROR_LOCKED_DEVICE','zh_HK', '設備終端被鎖定', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ),
('PROXY_ERROR_SYS_ERROR','zh_CN', '系统异常','',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('PROXY_ERROR_SYS_ERROR','zh_HK', '系統異常', '', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );



insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_1','zh_CN', '证照信息与填写内容不符', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_1','zh_HK', '證照信息與填寫內容不符', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_2','zh_CN', '资金来源', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_2','zh_HK', '資金來源', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_3','zh_CN', '银行帐户有误', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_3','zh_HK', '銀行帳戶有誤', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_4','zh_CN', '衍生品金融机构经验', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_4','zh_HK', '衍生品金融機構經驗', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_5','zh_CN', '年龄', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_5','zh_HK', '年齡', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_6','zh_CN', '衍生品与股票经验不一致', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_6','zh_HK', '衍生品與股票經驗不一致', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_7','zh_CN', '就业信息', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_7','zh_HK', '就業信息', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_8','zh_CN', '年收入', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_8','zh_HK', '年收入', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_9','zh_CN', '公司名称', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_9','zh_HK', '公司名稱', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_10','zh_CN', '财产种类', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_10','zh_HK', '財產種類', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_11','zh_CN', '所属行业', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_11','zh_HK', '所屬行業', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_12','zh_CN', '受益人类型', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_12','zh_HK', '受益人類型', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_13','zh_CN', '身份证有效期限', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_13','zh_HK', '身份證有效期限', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_14','zh_CN', '与玖富集团关系', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_14','zh_HK', '與玖富集團關係', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_15','zh_CN', '身份证地址', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_15','zh_HK', '身份證地址', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_16','zh_CN', '证件会注册', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_16','zh_HK', '證件會註冊', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_17','zh_CN', '其他原因', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_17','zh_HK', '其他原因', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_18','zh_CN', '投资经验', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_18','zh_HK', '投資經驗', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_19','zh_CN', '住宅地址需精确至房号（门牌号）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_19','zh_HK', '住宅地址需精確至房號（門牌號）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_20','zh_CN', '通讯地址需精确至房号（门牌号）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_20','zh_HK', '通訊地址需精確至房號（門牌號）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_21','zh_CN', '公司地址需精确到XX路XX号', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_21','zh_HK', '公司地址需精確到XX路XX號', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_22','zh_CN', '身份证正面照模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_22','zh_HK', '身份證正面照模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_23','zh_CN', '身份证反面照模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_23','zh_HK', '身份證反面照模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_24','zh_CN', '银行卡照片模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_24','zh_HK', '銀行卡照片模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_25','zh_CN', '银行卡照片卡号模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_25','zh_HK', '銀行卡照片卡號模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_26','zh_CN', '银行卡无卡号，请更换银行卡', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_26','zh_HK', '銀行卡無卡號，請更換銀行卡', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_27','zh_CN', '手持身份证照片模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_27','zh_HK', '手持身份證照片模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_28','zh_CN', '手持身份证照片面部有遮挡', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_28','zh_HK', '手持身份證照片面部有遮擋', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_29','zh_CN', '手持身份证照片需摘掉眼镜', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_29','zh_HK', '手持身份證照片需摘掉眼鏡', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_30','zh_CN', '手持身份证照片需按图例要求拍摄（人脸和身份证都需入镜）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_30','zh_HK', '手持身份證照片需按圖例要求拍攝（人臉和身份證都需入鏡）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_31','zh_CN', '手指照片伸出手指数错误', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_31','zh_HK', '手指照片伸出手指數錯誤', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_32','zh_CN', '手指照片模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_32','zh_HK', '手指照片模糊不清晰', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_33','zh_CN', '请在光线充足的环境下重拍正面照', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_33','zh_HK', '請在光線充足的環境下重拍正面照', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_34','zh_CN', '电子签名不全', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_34','zh_HK', '電子簽名不全', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_35','zh_CN', '电子签名需按照图示要求签署', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_35','zh_HK', '電子簽名需按照圖示要求籤署', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_36','zh_CN', '公司名称不完整', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_36','zh_HK', '公司名稱不完整', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_37','zh_CN', '年收入请按真实情况填写', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_37','zh_HK', '年收入請按真實情況填寫', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_38','zh_CN', '人脸识别不通过，请重拍身份证正面照片和手持身份证照片', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_38','zh_HK', '人臉識別不通過，請重拍身份證正面照片和手持身份證照片', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_40','zh_CN', '人脸识别不通过，请重拍身份证正面照片和正面照片', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_40','zh_HK', '人臉識別不通過，請重拍身份證正面照片和正面照片', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_41','zh_CN', 'CA验证不通过，请更换银行卡再次提交', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_41','zh_HK', 'CA驗證不通過，請更換銀行卡再次提交', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_42','zh_CN', '电话回访，未联系上', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_42','zh_HK', '電話回訪，未聯繫上', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_43','zh_CN', '请填写真实的现时地址（现时地址要不同于公司地址），且地址需精确到房号/门牌号（如：XX栋XX楼XX号）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_43','zh_HK', '請填寫真實的現時地址（現時地址要不同於公司地址），且地址需精確到房號/門牌號（如：XX棟XX樓XX號）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_44','zh_CN', '请填写现阶段工作地点所属城市的现时地址，且地址需精确到房号/门牌号（如：XX栋XX楼XX号）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_44','zh_HK', '請填寫現階段工作地點所屬城市的現時地址，且地址需精確到房號/門牌號（如：XX棟XX樓XX號）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_45','zh_CN', '身份证正面照片不完整，需要露出四个边角', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_45','zh_HK', '身份證正面照片不完整，需要露出四個邊角', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_46','zh_CN', '身份证反面照片不完整，需要露出四个边', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_46','zh_HK', '身份證反面照片不完整，需要露出四個邊', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_47','zh_CN', '现时地址和通讯地址需精确到房号/门牌号（如：XX栋XX楼XX号）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_47','zh_HK', '現時地址和通訊地址需精確到房號/門牌號（如：XX棟XX樓XX號）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_48','zh_CN', '现时地址需精确到房号/门牌号（如：XX栋XX楼XX号）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_48','zh_HK', '現時地址需精確到房號/門牌號（如：XX棟XX樓XX號）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_49','zh_CN', '通讯地址需精确到房号/门牌号（如：XX栋XX楼XX号）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_49','zh_HK', '通訊地址需精確到房號/門牌號（如：XX棟XX樓XX號）', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_50','zh_CN', '银行卡照片错误，请上传香港银行卡照片或香港银行卡月结单截图，若没有香港银行卡，请选择大陆银行卡开户', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_50','zh_HK', '銀行卡照片錯誤，請上傳香港銀行卡照片或香港銀行卡月結單截圖，若沒有香港銀行卡，請選擇大陸銀行卡開戶', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_51','zh_CN', '身份证不符合要求，请上传永久性香港身份证或护照照片', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into `config_language` ( `config_key`, `lang_key`, `content`, `marks`, `create_time`, `update_time`) values('OPEN_FAIL_REASON_52','zh_CN', '年收入和职业信息及资金来源不匹配，请重新填写', '',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


調用成功
未知錯誤
連接失敗
請求失敗
錯誤的請求
參數錯誤
Params參數錯誤
Params參數值錯誤
簽名參數SIGN錯誤
網絡異常
簽名參數KEY錯誤
參數TOKEN錯誤
參數SECRET錯誤
參數AUTH_CODE錯誤
請求異常,請重試
無滿足條件的數據
有重複值存在
業務不支持
簽名錯誤
未登錄或者TOKEN已失效
手機號格式錯誤
郵箱格式錯誤
身份證格式錯誤
銀行卡格式錯誤
獲取驗證碼失敗
獲取驗證碼過於頻繁
獲取驗證碼過於頻繁
驗證碼已使用
驗證碼已使用
登錄失敗
登錄失敗
用戶不存在
賬號或密碼錯誤
驗證碼錯誤或已失效
手機號已使用
郵箱校驗失敗
郵箱已使用
郵箱校驗失敗
身份證已使用或不支持
未满18周岁不可开通股票账户
身份證校驗失敗
身份證校驗每日次數上限
身份證/銀行卡識別失敗
開戶進度
銀行卡已使用或不支持
銀行卡校驗失敗
銀行卡校驗每日次數上限
SZCA校驗失敗
SZCA校驗每日次數上限
保存緩存信息異常
保存圖片異常
獲取緩存數據異常
提交開戶數據異常
不可重複提交
賬號異常
對應AppKey不存在
對應AppKey被禁用
Secret錯誤
設備類型不符合
終端類型不符合
產品版本不符合
設備終端被鎖定
系統異常

OK=调用成功
ERROR_UNKNOWN=未知错误
REMOTE_CONNECT_ERROR=连接失败
REMOTE_REQUEST_ERROR=请求失败
BAD_REQUEST=错误的请求
BAD_ARGS=参数错误
BAD_PARAMS=Params参数错误
BAD_PARAMS_VALUE=Params参数值错误
BAD_PARAM_SIGN=签名参数SIGN错误
BAD_SOCKET=网络异常
BAD_PARAM_KEY=签名参数KEY错误
BAD_PARAM_SESSION=参数TOKEN错误
BAD_PROXY_SECRET=参数SECRET错误
BAD_PROXY_AUTH_CODE=参数AUTH_CODE错误
ERROR_INTERNAL=请求异常,请重试
NONE_DATA=无满足条件的数据
EXIST_DATA=有重复值存在
SERVICE_UN_SUPPORT=业务不支持
ERROR_SIGN=签名错误
SESSION_INVALID=未登录或者TOKEN已失效
BAD_FORMAT_PHONE=手机号格式错误
BAD_FORMAT_EMAIL=邮箱格式错误
BAD_FORMAT_ID_CARD=身份证格式错误
BAD_FORMAT_BANK_CARD=银行卡格式错误
FAIL_FETCH_CAPTCHA=获取验证码失败
FETCH_SMS_CAPTCHA_OFTEN=获取验证码过于频繁
FETCH_EMAIL_CAPTCHA_OFTEN=获取验证码过于频繁
IS_USED_CAPTCHA=验证码已使用
IS_OVET_TIMES_CAPTCHA=验证码已使用
FAIL_LOGIN=登录失败
FAIL_LOGIN_BY_OTHER=登录失败
NO_USER=用户不存在
BAD_ACCOUNT_OR_PWD=账号或密码错误
BAD_OR_EXPIRE_CAPTCHA=验证码错误或已失效
PHONE_IS_USED=手机号已使用
FAIL_VERIFY_PHONE=邮箱校验失败
EMAIL_IS_USED=邮箱已使用
FAIL_VERIFY_EMAIL=邮箱校验失败
ID_CARD_USED_OR_UNSUPPORT=身份证已使用或不支持
ID_CARD_AGE_LESS_18=未满18周岁不可开通股票账户
FAIL_VERIFY_ID_CARD=身份证校验失败
FAIL_VERIFY_ID_CARD_COUNT=身份证校验每日次数上限
FAIL_OCR=身份证/银行卡识别失败
FAIL_OPEN_PROGRESS=开户进度
BANK_CARD_USED_OR_UNSUPPORT=银行卡已使用或不支持
FAIL_VERIFY_BANK_CARD=银行卡校验失败
FAIL_VERIFY_BANK_CARD_COUNT=银行卡校验每日次数上限
FAIL_VERIFY_SZCA=SZCA校验失败
FAIL_VERIFY_SZCA_COUNT=SZCA校验每日次数上限
FAIL_SAVE_CACHE_INFO=保存缓存信息异常
FAIL_SAVE_CACHE_IMG=保存图片异常
FAIL_GET_CACHE_DATA=获取缓存数据异常
FAIL_SUBMIT_OPEN_INFO=提交开户数据异常
NO_SUBMIT_OPEN_INFO_REPEAT=不可重复提交
ABO_ACCOUNT=账号异常
PROXY_ERROR_UN_KNOW_APPID=对应AppKey不存在
PROXY_ERROR_UN_SUPPORT_APPID=对应AppKey被禁用
PROXY_ERROR_BAD_SECRET=Secret错误
PROXY_ERROR_UN_SUPPORT_DEVICE=设备类型不符合
PROXY_ERROR_UN_SUPPORT_OS_TYPE=终端类型不符合
PROXY_ERROR_UN_SUPPORT_APP_VERSION=产品版本不符合
PROXY_ERROR_LOCKED_DEVICE=设备终端被锁定
PROXY_ERROR_SYS_ERROR=系统异常