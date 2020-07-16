package com.sunline.modules.ccass.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.google.common.collect.Maps;
import com.sunline.modules.ccass.entity.CcassHoldingsEntity;
import com.sunline.modules.ccass.entity.CcassParticipantsEntity;
import com.sunline.modules.ccass.service.CcassHoldingsService;
import com.sunline.modules.ccass.service.CcassParticipantsService;
import com.sunline.modules.common.utils.CharUtil;
import com.sunline.modules.common.utils.SpringBeanLoader;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: 爬取CCASS持仓数据
 * @author: Larry Lai
 * @date: 2018/5/17 16:18
 * @version: v1.0
 */

public class CcassHoldingsCrawler extends BreadthCrawler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplicationContext applicationContext = SpringBeanLoader.getApplicationContext();

    private CcassParticipantsService ccassParticipantsService = applicationContext.getBean(CcassParticipantsService.class);
    private CcassHoldingsService ccassHoldingsService = applicationContext.getBean(CcassHoldingsService.class);

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat US_DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);

    /**
     * 种子页面
     */
    private static String HOLDINGS_URL = "https://webb-site.com/ccass/cholder.asp?part=${}&d=${}";

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static DecimalFormat decimalFormat = new DecimalFormat("00.00");

    public CcassHoldingsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        // 页面url
//        this.addSeed(HOLDINGS_URL);

        // 正则规则设置
        this.addRegex("https://webb-site.com/ccass/*");
        // 不获取这样的格式 jpg|png|gif
        this.addRegex("-.*\\.(jpg|png|gif).*");
        this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums next) {

        try {
            Elements tables;
            Elements trs;
            Elements tds;
            String stockCode;
            String stockNameEn;
            BigDecimal stockHolding;
            BigDecimal stockValue;
            String stockPercentage;
            String holdDate;
            Set<String> newHoldingsSet;

            String url = page.url();
            // 用jsoup去解析这个页面
            Document doc = page.getDoc();

            // 更新CCASS参与者中文名称
            Integer partId = Integer.parseInt(url.substring(url.indexOf("=") + 1, url.indexOf("&")));
            Elements nameElements = doc.getElementsByTag("h2");
            // 更新时间串
            String updateInfoStr = doc.getElementsByTag("h3").get(0).text();

            String updateDate = updateInfoStr.substring(updateInfoStr.indexOf("on") + 3);

            if (nameElements == null || nameElements.size() == 0) {
                nameElements = doc.getElementsByTag("h3");
            }

            if (nameElements != null && nameElements.size() > 0) {
                String name = nameElements.get(0).text().trim();
                int chineseCharBegin = -1;
                for (int i = 0; i < name.length(); i++) {
                    if (CharUtil.isChineseCharacter(name.charAt(i))) {
                        chineseCharBegin = i;
                        break;
                    }
                }
                if (chineseCharBegin > 0) {
                    CcassParticipantsEntity ccassParticipantsEntity = new CcassParticipantsEntity();
                    ccassParticipantsEntity.setPartId(partId);
                    ccassParticipantsEntity.setCcassNameTc(name.substring(chineseCharBegin));

                    ccassParticipantsService.update(ccassParticipantsEntity);
                }

            }

            // 爬取CCASS持仓数据
            tables = doc.select("table[class=optable]");

            if (null != tables && tables.size() > 0) {
                newHoldingsSet = new HashSet<>();
                trs = tables.get(0).select("tr");
                if (null != trs && trs.size() > 1) {

                    // 关联participants名单
                    CcassParticipantsEntity ccassParticipantsEntity = new CcassParticipantsEntity();
                    ccassParticipantsEntity.setPartId(partId);
                    CcassParticipantsEntity ccassParticipants = ccassParticipantsService.queryObject(ccassParticipantsEntity);

                    for (int i = 1; i < trs.size(); i++) {
                        tds = trs.get(i).getElementsByTag("td");
                        if (tds.size() != 8) {
                            logger.error("part_id=" + partId + ",trs.size=" + trs.size());
                            logger.error(trs.get(i).outerHtml());
                        }
                        if (tds.size() == 8) {
                            stockCode = tds.get(1).text();
                            if (stockCode.length() < 5) {
                                stockCode = '0' + stockCode;
                            }
                            stockNameEn = tds.get(2).select("a").get(0).text();
                            stockHolding = new BigDecimal(tds.get(3).text().replace(",", ""));
                            stockValue = new BigDecimal(tds.get(4).text().replace(",", ""));
                            stockPercentage = decimalFormat.format(Double.valueOf(tds.get(6).select("a").get(0).text()));
                            holdDate = tds.get(7).select("a").get(0).text();

                            newHoldingsSet.add(stockCode);

                            // 保存到数据库
                            CcassHoldingsEntity queryParams = new CcassHoldingsEntity();
                            queryParams.setParticipantId(ccassParticipants.getId());
                            queryParams.setStockCode(stockCode);
                            queryParams.setHoldDate(holdDate);
                            queryParams.setUpdateDate(DATE_FORMAT.format(US_DATE_FORMAT.parse(updateDate)));
                            List<CcassHoldingsEntity> ccassHoldingsEntityList = ccassHoldingsService.queryListByBean(queryParams);

                            // 已存在则不写入数据库
                            if (null == ccassHoldingsEntityList || ccassHoldingsEntityList.size() <= 0) {

                                CcassHoldingsEntity ccassHoldingsParam = new CcassHoldingsEntity();
                                ccassHoldingsParam.setParticipantId(ccassParticipants.getId());
                                ccassHoldingsParam.setStockCode(stockCode);
                                ccassHoldingsParam.setStockNameEn(stockNameEn);
                                ccassHoldingsParam.setStockHolding(stockHolding);
                                ccassHoldingsParam.setStockValue(stockValue);
                                ccassHoldingsParam.setStakePercentage(stockPercentage);
                                ccassHoldingsParam.setHoldDate(holdDate);
                                ccassHoldingsParam.setUpdateDate(DATE_FORMAT.format(US_DATE_FORMAT.parse(updateDate)));

                                ccassHoldingsService.save(ccassHoldingsParam);


                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("爬取CCASS持仓数据异常", e);
        }
    }

    public static void main(String[] args) throws Exception {

        // 从DB获取参与者信息列表

        CcassParticipantsEntity ccassParticipants = new CcassParticipantsEntity();
        ccassParticipants.setCcassId("B01915");

        List<CcassParticipantsEntity> ccassParticipantsEntityList = new CcassHoldingsCrawler("crawl", true).
                ccassParticipantsService.queryListByBean(ccassParticipants);

        if (null != ccassParticipantsEntityList) {
            int partId;
            int partcipantId;
            String url;

            List<CcassHoldingsEntity> dbCcassHoldingsList;
            Map<String, CcassHoldingsEntity> holdingsMap;

            for (CcassParticipantsEntity ccassParticipantsEntity : ccassParticipantsEntityList) {
                partcipantId = ccassParticipantsEntity.getId();
                partId = ccassParticipantsEntity.getPartId();

                CcassHoldingsEntity ccassHoldingsEntity = new CcassHoldingsEntity();
                ccassHoldingsEntity.setParticipantId(partcipantId);

                dbCcassHoldingsList = new CcassHoldingsCrawler("crawl", true).ccassHoldingsService.queryListByBean(ccassHoldingsEntity);
                holdingsMap = Maps.newHashMap();

                if (null != dbCcassHoldingsList) {
                    for (CcassHoldingsEntity holdings : dbCcassHoldingsList) {
                        holdingsMap.put(holdings.getStockCode(), holdings);
                    }
                }

                // 拼接URL
                url = HOLDINGS_URL.replaceFirst("\\$\\{\\}", String.valueOf(partId)).replaceFirst("\\$\\{\\}", sdf.format(new Date()));

                CcassHoldingsCrawler crawler = new CcassHoldingsCrawler("crawl", true);
                crawler.addSeed(url);
                crawler.setThreads(5);
                crawler.setTopN(10);
                //crawler.setResumable(true);
                // 网页爬取深度为4
                crawler.start(4);
            }

        }
    }
}
