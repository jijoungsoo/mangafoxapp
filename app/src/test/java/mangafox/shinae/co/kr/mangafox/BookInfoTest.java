package mangafox.shinae.co.kr.mangafox;

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

import mangafox.shinae.co.kr.mangafox.api.MangaFoxHttpApiInterface;
import mangafox.shinae.co.kr.mangafox.data.BookInfo;
import mangafox.shinae.co.kr.mangafox.data.Chapter;
import mangafox.shinae.co.kr.mangafox.data.Discussion;
import mangafox.shinae.co.kr.mangafox.data.Page;
import mangafox.shinae.co.kr.mangafox.data.Volume;
import retrofit.Call;
import retrofit.Converter;
import retrofit.Retrofit;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class BookInfoTest {
private String bookName="one_piece";
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

//        System.out.println("ddd1111");

        MangaFoxHttpApiInterface service = client.create(MangaFoxHttpApiInterface.class);

        client.client().interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

//                System.out.println("jijs111");
//                Headers dd = response.headers();
//                for (int i = 0; i < dd.size(); i++) {
//                    System.out.println("dddd = " + dd.name(i) + "==" + dd.value(i));
//
//                }
//                System.out.println("dddd = " + response.request().url());
                // Do anything with response here

                return response;
            }
        });

//
//        System.out.println("ddd1222");


        Call<BookInfo> call = service.getBook(bookName);

//
//        System.out.println("ddd14sdfsdf" + call.toString());

        retrofit.Response<BookInfo> response = call.execute();
//        System.out.println("dfdfdf1333334" + response.isSuccess());
//        System.out.println("ddd1333334" + response.code());
        BookInfo bookInfo =response.body();
        for(Volume dd : bookInfo.volumes){
            System.out.println(dd.title);
            for(Chapter ch : dd.chapters){
                System.out.println(ch.title);
                System.out.println(ch.href);
               // getPages(ch);
            }

        }
    }

    @Test
    public void getTestPage()throws Exception {
        System.out.println("getTestPage");
        Chapter chapter = new Chapter();
        ArrayList<Page> pages= new ArrayList<Page>();
        chapter.page="1.html";
        chapter.book="one_piece";
        chapter.volume="v37";
        chapter.chapter="c356";
        int pageCount = getPageCount(chapter);
        System.out.println(pageCount);
        for(int i=1;i<=pageCount;i++){
            chapter.page=i+".html";
            Page page =getPage(chapter);
            pages.add(page);
        }
        for(int i=0;i<pages.size();i++){
            String src = pages.get(i).src;
            System.out.println("src["+i+"]:"+src);
        }
    }

    private int getPageCount(Chapter chapter)throws Exception {
//        System.out.println("getPage");
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
//        System.out.println("ddd1111");
        MangaFoxHttpApiInterface service = client.create(MangaFoxHttpApiInterface.class);
        client.client().interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
//                System.out.println("jijs111");
//                Headers dd = response.headers();
//                for (int i = 0; i < dd.size(); i++) {
//                    System.out.println("dddd = " + dd.name(i) + "==" + dd.value(i));
//                }
//                System.out.println("dddd = " + response.request().url());
                // Do anything with response here
                return response;
            }
        });

        Call<Integer> call = service.getPageCount(chapter.book, chapter.volume, chapter.chapter, chapter.page);

        retrofit.Response<Integer> response = call.execute();
//        System.out.println("dfdfdf1333334" + response.isSuccess());
//        System.out.println("ddd1333334" + response.code());
        Integer pageCount =response.body();
        return pageCount;
    }


    private Page getPage(Chapter chapter)throws Exception {
//        System.out.println("getPage");
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

        MangaFoxHttpApiInterface service = client.create(MangaFoxHttpApiInterface.class);
        client.client().interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
//                System.out.println("jijs111");
//                Headers dd = response.headers();
//                for (int i = 0; i < dd.size(); i++) {
//                    System.out.println("dddd = " + dd.name(i) + "==" + dd.value(i));
//                }
//                System.out.println("dddd = " + response.request().url());
                // Do anything with response here
                return response;
            }
        });
//        System.out.println("ddd1222");
        Call<Page> call = service.getPage(chapter.book, chapter.volume, chapter.chapter, chapter.page);
//        System.out.println("ddd14sdfsdf" + call.toString());
        retrofit.Response<Page> response = call.execute();
//        System.out.println("dfdfdf1333334" + response.isSuccess());
//        System.out.println("ddd1333334" + response.code());
        Page page =response.body();
        return page;
    }

    public final class ToStringConverterFactory extends Converter.Factory {
        @Override
        public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
            //noinspection EqualsBetweenInconvertibleTypes
            if (BookInfo.class.equals(type)) {
                return new Converter<ResponseBody, BookInfo>() {
                    @Override
                    public BookInfo convert(ResponseBody responseBody) throws IOException {
                        String content = responseBody.string();
                        BookInfo bookInfo= new BookInfo();
                        ArrayList<Volume> volumes= getVolumeList(content);
                        ArrayList<Discussion> discussions=getDiscussionList(content);
                        bookInfo.volumes=volumes;
                        bookInfo.discussions=discussions;
                        return bookInfo;
                    }
                };
            } else if(Integer.class.equals(type)) {
                return new Converter<ResponseBody, Integer>() {
                    @Override
                    public Integer convert(ResponseBody responseBody) throws IOException {
                        ArrayList<Page> pages = new ArrayList<Page>();
                        String content = responseBody.string();

                        Chapter chapter= new Chapter();
                       // System.out.println("content:"+content);
                        int pageCount = getPageCount(content);
                        chapter.pageCount=pageCount;

                        return pageCount;
                    }
                };
            } else if(Page.class.equals(type)) {
                return new Converter<ResponseBody, Page>() {
                    @Override
                    public Page convert(ResponseBody responseBody) throws IOException {
                        String content = responseBody.string();
                            Page page = getPage(content);
                        return page;
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



    private  ArrayList<Volume> getVolumeList(String content){
//        System.out.println("getVolumeList");
        ArrayList<Volume> volumeList = new ArrayList<Volume>();
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties props = htmlCleaner.getProperties();
        props.setOmitComments(true); //
        TagNode tagNode = null;
        tagNode = htmlCleaner.clean(content);
        SimpleHtmlSerializer htmlSerializer = new SimpleHtmlSerializer(props);
        String expression = "//div[@id=\"chapters\"]/ul/[@class=\"chlist\"]";

        Object[] myNodes = null;
        try {
            myNodes = tagNode.evaluateXPath(expression);
        } catch (XPatherException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println("myNodes.length=" + myNodes.length);
        for(int i=0;i<myNodes.length;i++){
            TagNode ul = (TagNode) myNodes[i];

            TagNode ulParentNode = ul.getParent();

            TagNode[] tmp = ulParentNode.getChildTags();
            String title="";
            for(int j=0;j<tmp.length;j++){
                if(tmp[j].equals(ul)){
//                    System.out.println("title=" + j);
                    title  = tmp[j-1].getText().toString();
//                    System.out.println("title=" + title);
//                    System.out.println("=== tmp[j-1].getName() " + tmp[j - 1].getName() + " ====e");
//                    System.out.println("=== tmp[j-1].getText() " + tmp[j - 1].getText() + " ====e");
                }
            }
            Volume volume = new Volume();
            volume.title=title;
            TagNode[] li = ul.getChildTags();
            for(int j=0;j<li.length;j++){
                Chapter chatper = new Chapter();
                String expressionDate = "//div/span[@class=\"date\"]";
                Object[] obejctDate = null;
                try {
                    obejctDate = 	li[j].evaluateXPath(expressionDate);
                } catch (XPatherException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                TagNode dateNode = (TagNode) obejctDate[0];
//                System.out.println("li[" + j + "]dateNode.getName()=" + dateNode.getName());
//                System.out.println("li[" + j + "]dateNode.getText()=" + dateNode.getText());



                String expressionHref = "//div//a[@class=\"tips\"]";
                Object[] obejctHref = null;
                try {
                    obejctHref = 	li[j].evaluateXPath(expressionHref);
                } catch (XPatherException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                TagNode hrefNode = (TagNode) obejctHref[0];

//                System.out.println("li[" + j + "]hrefNode.getName()=" + hrefNode.getName());
//                System.out.println("li[" + j + "]hrefNode.getText()=" + hrefNode.getText());
                String href = hrefNode.getAttributeByName("href").toString().trim();
//                System.out.println("li[" + j + "]href=" + href);
                String title1 = hrefNode.getText().toString().trim();
                String expressionTitle = "//div//span[@class=\"title nowrap\"]";
                Object[] obejctTitle = null;
                try {
                    obejctTitle = 	li[j].evaluateXPath(expressionTitle);
                } catch (XPatherException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

//
//                System.out.println("obejctTitle.length=" + obejctTitle.length);
                String title2="";
                if(obejctTitle.length>0){
                    TagNode titleNode = (TagNode) obejctTitle[0];
//                    System.out.println("li[" + j + "]titleNode.getName()=" + titleNode.getName());
//                    System.out.println("li[" + j + "]titleNode.getText()=" + titleNode.getText());
                    title2=titleNode.getText().toString();
                }

                chatper.date=dateNode.getText().toString().trim();
                chatper.title=title1+"--"+title2;
                if(href.length()>0) {
                    int sp = href.indexOf("/manga/");

                    String href222=href.substring(sp, href.length());
                    String[] tmp1=href222.split("/");
//
//                    System.out.println("href222:"+href222);
//                    System.out.println("sp:"+sp);
//                    System.out.println("dcccccc:"+tmp1.length);
//
//                    System.out.println("tmp1[0]:"+tmp1[0]);  //공백
//                    System.out.println("tmp1[1]:"+tmp1[1]);  //manga
//                    System.out.println("tmp1[2]:"+tmp1[2]);  //one_piece
//                    System.out.println("tmp1[3]:"+tmp1[3]); //vTBD
//                    System.out.println("tmp1[4]"+tmp1[4]); //c808
//                    System.out.println("tmp1[5]"+tmp1[5]); //1.html

                    if(tmp1.length>0 && tmp1.length==6){
                        chatper.book=tmp1[2];
                        chatper.volume=tmp1[3];
                        chatper.chapter=tmp1[4];
                        chatper.page=tmp1[5];
                    }

                }
                chatper.href=href;
                volume.chapters.add(chatper);
            }
            volumeList.add(volume);
        }
        return volumeList;
    }

    private  ArrayList<Discussion> getDiscussionList(String content){
  //      System.out.println("getDiscussionList");
        ArrayList<Discussion>  discussionList = new ArrayList<Discussion> ();
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties props = htmlCleaner.getProperties();
        props.setOmitComments(true); //
        TagNode tagNode = null;
        tagNode = htmlCleaner.clean(content);
        String expressionDiscussion = "//*[@id=\"discussion\"]/ul/li";
        Object[] nodeDiscussion = null;
        try {
            nodeDiscussion = tagNode.evaluateXPath(expressionDiscussion);
        } catch (XPatherException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println("nodeDiscussion.length=" + nodeDiscussion.length);
        for(int i=0;i<nodeDiscussion.length;i++) {
            TagNode tagNodeDiscussion = (TagNode) nodeDiscussion[i];

    //        System.out.println("tagNodeDiscussion.getName()=" + tagNodeDiscussion.getName());
    //        System.out.println("tagNodeDiscussion.getText()=" + tagNodeDiscussion.getText());

            TagNode[] tagNodeDiscussionArray = tagNodeDiscussion.getChildTags();
            String date = tagNodeDiscussionArray[0].getText().toString().trim();
            TagNode tagNodeAnchor = tagNodeDiscussionArray[1].getChildTags()[0];

    //        System.out.println("tagNodeAnchor.getText()=" + tagNodeAnchor.getText());
    //        System.out.println("tagNodeAnchor.getName()=" + tagNodeAnchor.getName());

            String href = tagNodeAnchor.getAttributeByName("href").toString().trim();

    //        System.out.println("date=" + date);
   //         System.out.println("href=" + href);

            String text = tagNodeAnchor.getText().toString();
            String title =  tagNodeAnchor.getAttributeByName("title").toString().trim();

            Discussion discussion = new Discussion();

            discussion.setDate(date);
            discussion.setTitle(title);
            discussion.setHref(href);
            discussion.setText(text);
            discussionList.add(discussion);
        }
        return discussionList;
    }


    private int getPageCount(String content){
      //  System.out.println("getPageCount  content =" + content);
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties props = htmlCleaner.getProperties();
        props.setOmitComments(true);
        TagNode tagNode = null;
        tagNode = htmlCleaner.clean(content);
        SimpleHtmlSerializer htmlSerializer = new SimpleHtmlSerializer(props);
        String expression = "//*[@id=\"top_bar\"]/div/div/select";
        Object[] myNodes = null;
        try {
            myNodes = tagNode.evaluateXPath(expression);
        } catch (XPatherException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TagNode select = (TagNode) myNodes[0];
        TagNode[] option = select.getChildTags();
        int lastPage=0;
        for(int i=0;i<option.length;i++){
            String tmp = option[i].getText().toString().trim();
            try {
                int intTmp=Integer.parseInt(tmp);
                if(lastPage<intTmp){
                    lastPage=intTmp;
                }
            } catch(NumberFormatException e){

            }
     //       System.out.println("tmp[" + i + "]=" + tmp);
        }
     //   System.out.println("lastPage=" + lastPage);
        return lastPage;
    }



    public static Page getPage(String content){
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties props = htmlCleaner.getProperties();
        props.setOmitComments(true); //
        TagNode tagNode = null;
        tagNode = htmlCleaner.clean(content);
        SimpleHtmlSerializer htmlSerializer = new SimpleHtmlSerializer(props);
        String expression = "//*[@id=\"image\"]";
        Object[] myNodes = null;
        try {
            myNodes = tagNode.evaluateXPath(expression);
        } catch (XPatherException e) {
            e.printStackTrace();
        }
        TagNode image = (TagNode) myNodes[0];
        String src = image.getAttributeByName("src").toString().trim();
        String onerror = image.getAttributeByName("onerror").toString().trim();
        String alt = image.getAttributeByName("alt").toString().trim();
        String width = image.getAttributeByName("width").toString().trim();
//        System.out.println("src=" + src);
//        System.out.println("onerror=" + onerror);
//        System.out.println("alt=" + alt);
        Page page = new Page();
        page.src=src;
        page.onerror=onerror;
        page.alt=alt;
        page.width=width;
        return page;
    }

}