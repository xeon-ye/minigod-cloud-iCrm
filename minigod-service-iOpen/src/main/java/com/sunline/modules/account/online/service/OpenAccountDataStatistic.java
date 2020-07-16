package com.sunline.modules.account.online.service;

/**
 * @author LiYangFeng
 * @createDate 2017/6/13
 * @description
 * @email justbelyf@gmail.com
 */
public class OpenAccountDataStatistic {
    private final String ACCOUNT_OPEN_CONTENT_ERROR_TYPE = "AO_CONTENT_ERROR_TYPE";


//    /**
//     * 开户资料审批拒绝错误类型统计
//     *
//     * @return
//     */
//    public Map<String, Integer> statisticsOpenAccountErrors(List<CustomerAccountOpenDetailInfoModel> accountsOpenInfo) {
//        Map<String, Integer> contentErrorsTypeStatistics = new LinkedHashMap<>();
//
//        for (CustomerAccountOpenDetailInfoModel accountOpenInfo : accountsOpenInfo) {
//            // 文本资料内容错误
//            if (StringUtils.isNoneBlank(accountOpenInfo.getCustomerAccountOpenApplicationModel().getErrorContentTypes())) {
//                List<String> errorsContentType = JSON.parseArray(accountOpenInfo.getCustomerAccountOpenApplicationModel().getErrorContentTypes(), String.class);
//                for (String errorContentType : errorsContentType) {
//                    if (!contentErrorsTypeStatistics.containsKey(errorsContentType)) {
//                        contentErrorsTypeStatistics.put(errorContentType, 0);
//                    }
//                    contentErrorsTypeStatistics.put(errorContentType, contentErrorsTypeStatistics.get(errorContentType) + 1);
//                }
//
//            }
//
//            // 图片内容错误
//            if (StringUtils.isNoneBlank(accountOpenInfo.getCustomerAccountOpenApplicationModel().getErrorImages())) {
//                List<OpenAccountImageInfo> openAccountImagesErrorInfo = JSON.parseArray(accountOpenInfo.getCustomerAccountOpenApplicationModel().getErrorImages(), OpenAccountImageInfo.class);
//                for (OpenAccountImageInfo openAccountImageInfo : openAccountImagesErrorInfo) {
//                    String imageLocationType = String.valueOf(openAccountImageInfo.getImageLocationType());
//                    if (!contentErrorsTypeStatistics.containsKey(imageLocationType)) {
//                        contentErrorsTypeStatistics.put(imageLocationType, 0);
//                    }
//
//                    contentErrorsTypeStatistics.put(imageLocationType, contentErrorsTypeStatistics.get(imageLocationType) + 1);
//                }
//
//            }
//        }
//
//        return contentErrorsTypeStatistics;
//    }
}
