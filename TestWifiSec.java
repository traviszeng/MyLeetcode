import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Travis Zeng on 2017/5/12.
 */
public class TestWifiSec {
    public static void main(String[] args) {
        String[] a = "11:22:44:56:ff:33".split(":");
        StringBuilder builder  = new StringBuilder();
        for (int i = 0;i<a.length;i++)
            builder.append(a[i]);
        System.out.println(builder.toString());
        Document document  = null;
        try{
            document = Jsoup.connect("https://www.wifi4.cn/wifi/"+"TP-LINK_894E/"+"50BD5F6C894E"+"/").timeout(50000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(document);

        Elements elements = document.select(".wifi-status img");
        Element element  = elements.get(0);
        if(element.attr("src").equals("https://o27o87w5k.qnssl.com/static/images/text_aq.png"))
            System.out.println("True");
        else
            System.out.println("False");

    }
}
