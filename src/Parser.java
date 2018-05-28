import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    public static void main(String args[]) throws IOException {
        //получаем ссылку на документ
        Document d = Jsoup.connect("https://ru.wikihow.com/wikiHowTo?search=бургеры").timeout(6000).get();

        //получаем список элементов extends ArrayList<Element> соответсвуюших запросу
        Elements ele = d.select("div#searchresults_list");

        //проходимся по каждому элементу из результатов
        for(Element element: ele.select("div.result")){
           String image_url = element.select("div.result_thumb img").attr("src");
           System.out.println(image_url);
        }
    }
}
