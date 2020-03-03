# 表机构

### custom_open_info
- id 主键（自增）


### custom_basic 用户基本信息
- id 用户id（自增主键）
- mobile 手机号码
- email 邮箱
- password 密码（可空）
- name 姓名（可空）
- id_card 身份证件号码（可空）
- channel_id 渠道id（默认 1）
- status 用户状态 0-停用,1-正常,2-锁定
- create_time 创建时间
- update_time 最后修改时间

### custom_session 用户会话session
- id 主键（自增）
- user_id 用户id
- device_id 设备ID
- session
- expire_time session过期时间
- is_status 是否有效(1有效,0无效)
- msg
- create_time 创建时间
- update_time 最后修改时间


### verify_id_card 身份证校验
- id 自增ID
- user_name 用户姓名
- id_card 证件号码
- state 状态(0:不通过 1:通过)
- remark 备注
- create_time 创建时间
- update_time 最后修改时间

### verify_bank_card 银行卡四要素校验
- id 主键(自增)
- user_name 用户姓名
- mobile 手机号
- id_card  身份证
- bank_card 银行卡号
- state  状态(0:不通过 1:通过)
- remark 备注
- check_date 验证时间
- create_time 创建时间
- update_time 最后修改时间

### custom_verify_szca 深圳CA认证
// TODO
