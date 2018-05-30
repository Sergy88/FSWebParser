import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class AsosParser {
    public static void main(String[] args) throws IOException {
        Document document = null;

           document = Jsoup.parse(new File("C:\\123\\asos.html"), "UTF-8");
            //Jsoup.connect("http://www.asos.com/men/shoes-boots-trainers/cat/?cid=4209&nlid=mw|shoes|shop+by+product").get();


        Elements products = document.select("article[id^=product]");

        for (Element product: products){
            System.out.println("SKU: ="+product.select("div").select("div[data-auto-id]").select("p").text());
        }

        System.out.println(document.select("a[data-auto-id=loadMoreProducts]").attr("href"));



    }
}
