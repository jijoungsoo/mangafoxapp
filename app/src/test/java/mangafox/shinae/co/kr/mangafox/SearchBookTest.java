package mangafox.shinae.co.kr.mangafox;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;


import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.SimpleHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.junit.Test;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import mangafox.shinae.co.kr.mangafox.api.MangaFoxHttpApiInterface;
import mangafox.shinae.co.kr.mangafox.data.BookInfo;
import mangafox.shinae.co.kr.mangafox.data.BooksInfo;
import mangafox.shinae.co.kr.mangafox.data.Chapter;
import mangafox.shinae.co.kr.mangafox.data.PageClass;
import mangafox.shinae.co.kr.mangafox.data.Volume;
import retrofit.Call;
import retrofit.Converter;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Query;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class SearchBookTest {

    @Test
    public void ddd() throws Exception {
        System.out.println("ddd");
        OkHttpClient okClient = new OkHttpClient();
        okClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response;
            }
        });

        Retrofit client = new Retrofit.Builder()
                .baseUrl("http://mangafox.me")
                .client(okClient)
                .addConverterFactory(new ToStringConverterFactory())
                .build();

        System.out.println("ddd1111");

        MangaFoxHttpApiInterface service = client.create(MangaFoxHttpApiInterface.class);

        client.client().interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

                System.out.println("jijs111");
                Headers dd = response.headers();
                for (int i = 0; i < dd.size(); i++) {
                    System.out.println("dddd = " + dd.name(i) + "==" + dd.value(i));

                }
                System.out.println("dddd = " + response.request().url());
                // Do anything with response here

                return response;
            }
        });
        ;

        System.out.println("ddd1222");

        String name_method = "cw";
        String name = "";
        String type = "";
        String author_method = "cw";
        String author = "";
        String artist_method = "cw";
        String artist = "";
        String genresAction = "0";
        String genresAdult = "0";
        String genresAdventure = "0";
        String genresComedy = "0";
        String genresDoujinshi = "0";
        String genresDrama = "0";
        String genresEcchi = "0";
        String genresFantasy = "0";
        String genresGenderBender = "0";
        String genresHarem = "0";
        String genresHistorical = "0";
        String genresHorror = "0";
        String genresJosei = "0";
        String genresMartialArts = "0";
        String genresMature = "0";
        String genresMecha = "0";
        String genresMystery = "0";
        String genresOneShot = "0";
        String genresPsychological = "0";
        String genresRomance = "0";
        String genresSchoolLife = "0";
        String genresSciFi = "0";
        String genresSeinen = "0";
        String genresShoujo = "0";
        String genresShoujoAi = "0";
        String genresShounen = "0";
        String genresShounenAi = "0";
        String genresSliceOfLife = "0";
        String genresSmut = "0";
        String genresSports = "0";
        String genresSupernatural = "0";
        String genresTragedy = "0";
        String genresWebtoons = "0";
        String genresYaoi = "0";
        String genresYuri = "0";
        String released_method = "eq";
        String released = "";
        String rating_method = "eq";
        String rating = "";
        String is_completed = "";
        String advopts = "1";
        String page ="1";
        Call<BooksInfo> call = service.searchBook(
                name_method
                , name
                , type
                , author_method
                , author
                , artist_method
                , artist
                , genresAction
                , genresAdult
                , genresAdventure
                , genresComedy
                , genresDoujinshi
                , genresDrama
                , genresEcchi
                , genresFantasy
                , genresGenderBender
                , genresHarem
                , genresHistorical
                , genresHorror
                , genresJosei
                , genresMartialArts
                , genresMature
                , genresMecha
                , genresMystery
                , genresOneShot
                , genresPsychological
                , genresRomance
                , genresSchoolLife
                , genresSciFi
                , genresSeinen
                , genresShoujo
                , genresShoujoAi
                , genresShounen
                , genresShounenAi
                , genresSliceOfLife
                , genresSmut
                , genresSports
                , genresSupernatural
                , genresTragedy
                , genresWebtoons
                , genresYaoi
                , genresYuri
                , released_method
                , released
                , rating_method
                , rating
                , is_completed
                , advopts
                , page
        );


        System.out.println("ddd14sdfsdf" + call.toString());

        retrofit.Response<BooksInfo> response = call.execute();
        System.out.println("dfdfdf1333334" + response.isSuccess());
        System.out.println("ddd1333334" + response.code());
        BooksInfo booksInfo =response.body();
        ArrayList<BookInfo> knouNoticeInfoList=booksInfo.bookInfoList;
        int i=0;
        for(BookInfo tt:knouNoticeInfoList){

            System.out.println("tr[" + i + "]seriesName=" + tt.seriesName);
            System.out.println("tr["+i+"]href="+tt.href);
            System.out.println("tr["+i+"]rating="+tt.rating);
            System.out.println("tr["+i+"]views="+tt.views);
            System.out.println("tr["+i+"]chapters="+tt.chapters);
            System.out.println("tr["+i+"]latestChapter="+tt.latestChapter);
            i++;
        }
        PageClass pageClass = booksInfo.pageClass;

        System.out.println("pageClass.getCurrentPage():"+pageClass.getCurrentPage());
        System.out.println("pageClass.getLastPage():"+pageClass.getLastPage());
    }

    public final class ToStringConverterFactory extends Converter.Factory {
        @Override
        public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
            //noinspection EqualsBetweenInconvertibleTypes
            if (BooksInfo.class.equals(type)) {
                return new Converter<ResponseBody, BooksInfo>() {
                    @Override
                    public BooksInfo convert(ResponseBody responseBody) throws IOException {
                        String content = responseBody.string();
                        BooksInfo booksInfo= new BooksInfo();
                        ArrayList<BookInfo> knouNoticeInfoList=  getBookInfoList(content);
                        booksInfo.bookInfoList=knouNoticeInfoList;
                        PageClass pageClass = getPageClass(content);
                        booksInfo.pageClass=pageClass;

                        return booksInfo;
                    }
                };
            }
            return null;
        }

        @Override
        public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
            //noinspection EqualsBetweenInconvertibleTypes
            if (String.class.equals(type)) {
                return new Converter<String, RequestBody>() {
                    @Override
                    public RequestBody convert(String value) throws IOException {
                        return RequestBody.create(MediaType.parse("text/plain"), value);
                    }
                };
            }
            return null;
        }
    }

    private  ArrayList<BookInfo> getBookInfoList(String content){
        System.out.println("getBookInfoList");
        ArrayList<BookInfo> bookInfoList = new ArrayList<BookInfo>();
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties props = htmlCleaner.getProperties();
        props.setOmitComments(true); // 주석제거
        TagNode tagNode = null;
        tagNode = htmlCleaner.clean(content);
        SimpleHtmlSerializer htmlSerializer = new SimpleHtmlSerializer(props);
        String expression = "//*[@id=\"listing\"]/tbody";

        Object[] myNodes = null;
        try {
            myNodes = tagNode.evaluateXPath(expression);
        } catch (XPatherException e) {
            e.printStackTrace();
        }
        System.out.println("myNodes.length ="+myNodes.length);
        if(myNodes.length<=0){
            return bookInfoList;
        }
        TagNode tableNode = (TagNode) myNodes[0];
        TagNode[] tr = tableNode.getChildTags();
        for(int i=1;i<tr.length;i++){
            BookInfo bookInfo = new BookInfo();
            String seriesName= tr[i].getChildTags()[0].getText().toString().trim();// �쒕ぉ
            String href = tr[i].getChildTags()[0].getChildTags()[0].getAttributeByName("href").toString().trim();
//            System.out.println("tr["+i+"]href="+href);
            //String t2= tr[i].getChildTags()[1].getText().toString(); // 以묒슂��
            TagNode t2= tr[i].getChildTags()[1].getChildTags()[0];
//            System.out.println("t2["+i+"]rating="+t2.getName());
            String rating = t2.getAttributeByName("alt").toString().trim();
            String views= tr[i].getChildTags()[2].getText().toString().trim(); // 以묒슂��
            String chapters= tr[i].getChildTags()[3].getText().toString().trim(); // 以묒슂��
            String latestChapter= tr[i].getChildTags()[4].getText().toString().trim(); // 以묒슂��
//            System.out.println("tr["+i+"]seriesName="+seriesName);
//            System.out.println("tr["+i+"]href="+href);
//            System.out.println("tr["+i+"]rating="+rating);
//            System.out.println("tr["+i+"]views="+views);
//            System.out.println("tr["+i+"]chapters="+chapters);
//            System.out.println("tr["+i+"]latestChapter="+latestChapter);
            bookInfo.seriesName=seriesName;
            bookInfo.href=href;
            bookInfo.rating=Double.parseDouble(rating);
            bookInfo.views=Integer.parseInt(views);
            bookInfo.chapters=Integer.parseInt(chapters);
            bookInfo.latestChapter=latestChapter;
            bookInfoList.add(bookInfo);
        }

        return bookInfoList;
    }


    private  PageClass getPageClass(String content){
        PageClass pageClass =  new PageClass();
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties props = htmlCleaner.getProperties();
        props.setOmitComments(true); // 주석제거
        TagNode tagNode = null;
        tagNode = htmlCleaner.clean(content);
        SimpleHtmlSerializer htmlSerializer = new SimpleHtmlSerializer(props);
        String expression = "//*[@id=\"nav\"]/ul";

        Object[] myNodes = null;
        try {
            myNodes = tagNode.evaluateXPath(expression);
        } catch (XPatherException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("myNodes.length = "+myNodes.length);
        int lastPage=1;
        int currentPage =1;
        if(myNodes.length>0){
            lastPage = lastPage((TagNode)myNodes[0]);
            currentPage =currentPage((TagNode)myNodes[0]);
        }

        pageClass.setLastPage(lastPage);
        pageClass.setCurrentPage(currentPage);
        return pageClass;
    }



    private  int lastPage(TagNode tagNode){
        System.out.println("lastPage");
        String expressionNext = "//span[@class=\"next\"]";
        Object[] myNodesNext = null;
        try {
            TagNode tmp = tagNode;
            System.out.println("tmp.getName()="+tmp.getName());

            myNodesNext =tmp.evaluateXPath(expressionNext);
        } catch (XPatherException e) {
            e.printStackTrace();
        }
        TagNode tagNodeNext = (TagNode)myNodesNext[0];
        System.out.println("tagNodeNext.getName() ="+tagNodeNext.getName());
        TagNode  tagNodeNextLi = searchParent(tagNodeNext,"li");
        System.out.println("tagNodeNextLi.getName() ="+tagNodeNextLi.getName());
        TagNode tagNodeNextLiParent = tagNodeNextLi.getParent();
        List<TagNode> tagNodeUl= tagNodeNextLiParent.getChildTagList();
        int j=-1;
        for(int i =0;i<tagNodeUl.size();i++){
            if(tagNodeUl.get(i)==tagNodeNextLi){
                j=i;
            }
        }
        String lastPageText = "1";
        if(j>0){
            TagNode lastPageTagNode=  tagNodeUl.get(j-1);
            lastPageText = lastPageTagNode.getText().toString().trim();
            System.out.println("lastPageText ="+lastPageText);
        }
        int lastPage = Integer.parseInt(lastPageText);
        return lastPage;
    }
    private static TagNode searchParent(TagNode tagNode,String tagName){
        while(!tagNode.getName().toString().equals(tagName)){
            tagNode=tagNode.getParent();
        }
        return tagNode;
    }

    private   int currentPage(TagNode tagNode){
        System.out.println("currentPage");
        String expressionCurrent = "//li[@class=\"red\"]";
        Object[] myNodesCurrent = null;
        try {
            TagNode tmp = tagNode;
            System.out.println("tmp.getName()=" + tmp.getName());

            myNodesCurrent =tmp.evaluateXPath(expressionCurrent);
        } catch (XPatherException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TagNode tagNodeCurrent = (TagNode)myNodesCurrent[0];
        System.out.println("tagNodeCurrent.getName() =" + tagNodeCurrent.getName());
        String currentPageText = tagNodeCurrent.getText().toString().trim();

        int currentPage = Integer.parseInt(currentPageText);
        return currentPage;
    }
}