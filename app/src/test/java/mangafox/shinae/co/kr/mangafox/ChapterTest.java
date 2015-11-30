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
import mangafox.shinae.co.kr.mangafox.data.Volume;
import retrofit.Call;
import retrofit.Converter;
import retrofit.Retrofit;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ChapterTest {

    @Test
    public void cc() throws Exception {
        String href="http://mangafox.me/manga/one_piece/vTBD/c808/1.html";
        int dd =href.indexOf("/manga/");
        System.out.println("dd:"+dd);
        String href11 = href.substring(dd,href.length());
        System.out.println("href11:"+href11);
    }

}