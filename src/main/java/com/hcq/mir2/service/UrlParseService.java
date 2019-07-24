package com.hcq.mir2.service;

import com.hcq.mir2.entries.Model;
import com.hcq.mir2.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UrlParseService {

    public List<Model> getCurrent() throws IOException {
        String s = HttpUtils.httpGet("https://www.hgkqp.com","gb2312");
        Document doc = Jsoup.parse(s);
        List<Model> result = new ArrayList<>();
        Elements select = doc.select("table[class=tableBorder1]");
        for (Element element : select) {
            Element script = element.select("script").get(0);
            List<String> tds = parse(script.html());
            result.addAll(parse(tds));
            Elements tr = element.select("tr");
            for (Element element1 : tr) {
                Model model = parseOne(element1);
                if (model != null) {
                    result.add(model);
                }
            }
        }
        return result;
    }

    private List<String> parse(String txt) {
        List<String> result = new ArrayList<String>();
        String reg = "(?<=\\=\\')(.+?)(?=';)";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(txt);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    private List<Model> parse(List<String> tds) {
        List<Model> models = new ArrayList<Model>();
        for (String td : tds) {
            Model model = parseOne("<table>" + td + "</table>");
            if (model != null) {
                models.add(model);
            }
        }
        return models;
    }

    private Model parseOne(String td1)  {
        Document tr = Jsoup.parse(td1);
        Elements td = tr.select("TD");
        return parseOne(td);
    }

    private Model parseOne(Element tr) {
        Elements td = tr.select("TD");
        return parseOne(td);
    }

    private Model parseOne(Elements td) {
        Model model = new Model();
        for (int i = 0; i < td.size(); i++) {
            Element element = td.get(i);
            String val = element.html();
            tryParseVal(model, val, i);
        }
        if (model.getContent() == null && model.getType() == null) {
            return null;
        }
        return model;
    }

    private void tryParseVal(Model model, String val, int index) {
        switch (index) {
            case 0:
                model.setName(val);
                return;
            case 1:
                model.setIp(val);
                return;
            case 2:
                model.setTime(val);
                return;
            case 3:
                model.setType(val);
                return;
            case 4:
                model.setContent(val);
                return;
            case 5:
                model.setQq(val);
                return;
            case 6:
                model.setSrc(val);
                return;

        }
    }

}
