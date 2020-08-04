package com.sunline.modules.ccass.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.google.common.collect.Lists;
import com.sunline.modules.ccass.entity.CcassParticipantsEntity;
import com.sunline.modules.ccass.service.CcassParticipantsService;
import com.sunline.modules.common.utils.CharUtil;
import com.sunline.modules.common.utils.SpringBeanLoader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @description: 爬取CCASS参与者列表信息
 * @author: Larry Lai
 * @date: 2018/5/17 16:18
 * @version: v1.0
 */

public class CcassParticipantsCrawler extends BreadthCrawler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplicationContext applicationContext = SpringBeanLoader.getApplicationContext();

    private CcassParticipantsService ccassParticipantsService = applicationContext.getBean(CcassParticipantsService.class);

    /**
     * 种子页面地址
     */
    public static String PARTICIPANTS_URL = "https://webb-site.com/ccass/cparticipants.asp";

    public CcassParticipantsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        // 页面url
        this.addSeed(PARTICIPANTS_URL);

        // 正则规则设置
        this.addRegex("https://webb-site.com/ccass/cparticipants.asp");
        // 不获取这样的格式 jpg|png|gif
        this.addRegex("-.*\\.(jpg|png|gif).*");
        this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums next) {

        try {

            String url = page.url();
            // 校验url地址
            if (page.matchUrl(url)) {
                // 用jsoup去解析这个页面
                Document doc = page.getDoc();

                Elements tables = doc.getElementsByClass("txtable");

                if (tables.size() > 0) {
                    Element table = tables.get(0);
                    Elements trs = table.getElementsByTag("tr");
                    if (trs.size() > 0) {
                        Elements tds;
                        Element participantUrl = null;
                        String partUrl = null;
                        String ccassId = null;
                        String ccassNameEn;
                        String ccassNameTc;

                        CcassParticipantsEntity ccassParticipantEntity = null;
                        CcassParticipantsEntity dbCcassParticipantEntity = null;
                        List<CcassParticipantsEntity> ccassParticipantEntityList = Lists.newArrayList();

                        for (Element tr : trs) {
                            tds = tr.getElementsByTag("td");
                            if (tds.size() == 3) {
                                if (!tds.get(1).text().isEmpty()) {

                                    ccassParticipantEntity = new CcassParticipantsEntity();

                                    // 解析数据
                                    ccassId = tds.get(1).text();
                                    ccassParticipantEntity.setCcassId(ccassId);

                                    participantUrl = tds.get(2).getElementsByTag("a").get(0);
                                    ccassNameEn = participantUrl.text().trim();
                                    ccassParticipantEntity.setCcassNameEn(ccassNameEn);

                                    partUrl = participantUrl.attr("href");
                                    ccassParticipantEntity.setPartId(Integer.parseInt(partUrl.substring(partUrl.indexOf("=") + 1)));

                                    ccassParticipantEntityList.add(ccassParticipantEntity);

                                    CcassParticipantsEntity ccassParticipantsEntity = new CcassParticipantsEntity();
                                    ccassParticipantsEntity.setCcassId(ccassId);
                                    dbCcassParticipantEntity = ccassParticipantsService.queryObject(ccassParticipantsEntity);

                                    // 判断CCASS ID是否已存在,存在则更新,否则新增
                                    if (dbCcassParticipantEntity == null) {
//                                    ccassParticipantEntity.setCcassNameTc(getCNname(participantUrl));
                                        ccassParticipantsService.save(ccassParticipantEntity);
                                    } else if (dbCcassParticipantEntity.getCcassNameEn().equals(ccassNameEn)) {
//                                    ccassParticipantEntity.setCcassNameTc(getCNname(participantUrl));
                                        ccassParticipantsService.update(ccassParticipantEntity);
                                    }

                                }
                            }
                        }

//                    ccassParticipantsService.saveBatch(ccassParticipantEntityList);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("爬取CCASS参与者列表信息异常", e);
        }
    }

    /**
     * 获取CCASS参与者中文名
     *
     * @param url
     * @return
     */
    private String getCNname(Element url) {
        Document participantPage = null;
        Elements nameElements;
        try {
            participantPage = Jsoup.connect(url.absUrl("href")).timeout(60000).get();
            nameElements = participantPage.getElementsByTag("h2");
            if (nameElements == null || nameElements.size() == 0) {
                nameElements = participantPage.getElementsByTag("h3");
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
                    return name.substring(chineseCharBegin);
                }

            }
        } catch (IOException e) {
            logger.error("获取CCASS参与者中文名异常", e);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        CcassParticipantsCrawler crawler = new CcassParticipantsCrawler("crawl", true);
        crawler.setThreads(5);
        crawler.setTopN(10);
        //crawler.setResumable(true);
        // 网页爬取深度为4
        crawler.start(4);
    }
}
