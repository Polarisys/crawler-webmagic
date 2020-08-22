package com.web.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @anthor Tolaris
 * @date 2020/3/9 - 21:50
 */
public class JobProcessor implements PageProcessor {

    private Site site = new Site();

    //解析页面
    public void process(Page page) {
        //解析返回的数据page,并且把解析的结果放到ResultItems中
        //page.putField("div", page.getHtml().css("div.dt a").all());

        //获取链接
        page.addTargetRequests(page.getHtml().css("ul.list-646 a").links().all());
        page.putField("link", page.getHtml().css("ul.list-646"));
        page.putField("url", page.getHtml().css("div#_2CD7_2MZBYElpXw5FMiwuK h3").all());
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new JobProcessor())
                .addUrl("https://kuaibao.jd.com/?ids=231125862,230322313,231125040,230088804")
                .run();
    }
}
