package mangafox.shinae.co.kr.mangafox.api;

import java.util.ArrayList;
import java.util.List;

import mangafox.shinae.co.kr.mangafox.data.BookInfo;
import mangafox.shinae.co.kr.mangafox.data.BooksInfo;
import mangafox.shinae.co.kr.mangafox.data.Chapter;
import mangafox.shinae.co.kr.mangafox.data.Page;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;


public interface MangaFoxHttpApiInterface {
    @GET("/search.php")
    Call<BooksInfo> searchBook(
            @Query("name_method") String name_method
            , @Query("name") String name
            , @Query("type") String type
            , @Query("author_methode") String author_method
            , @Query("authore") String author
            , @Query("artist_method") String artist_method
            , @Query("artist") String artist
            , @Query("genres[Action]") String genresAction
            , @Query("genres[Adult]") String genresAdult
            , @Query("genres[Adventure]") String genresAdventure
            , @Query("genres[Comedy]") String genresComedy
            , @Query("genres[Doujinshi]") String genresDoujinshi
            , @Query("genres[Drama]") String genresDrama
            , @Query("genres[Ecchi]") String genresEcchi
            , @Query("genres[Fantasy]") String genresFantasy
            , @Query("genres[Gender+Bender]") String genresGenderBender
            , @Query("genres[Harem]") String genresHarem
            , @Query("genres[Historical]") String genresHistorical
            , @Query("genres[Horror]") String genresHorror
            , @Query("genres[Josei]") String genresJosei
            , @Query("genres[Martial+Arts]") String genresMartialArts
            , @Query("genres[Mature]") String genresMature
            , @Query("genres[Mecha]") String genresMecha
            , @Query("genres[Mystery]") String genresMystery
            , @Query("genres[One+Shot]") String genresOneShot
            , @Query("genres[Psychological]") String genresPsychological
            , @Query("genres[Romance]") String genresRomance
            , @Query("genres[School+Life]") String genresSchoolLife
            , @Query("genres[Sci-fi]") String genresSciFi
            , @Query("genres[Seinen]") String genresSeinen
            , @Query("genres[Shoujo]") String genresShoujo
            , @Query("genres[Shoujo+Ai]") String genresShoujoAi
            , @Query("genres[Shounen]") String genresShounen
            , @Query("genres[Shounen+Ai]") String genresShounenAi
            , @Query("genres[Slice+of+Life]") String genresSliceOfLife
            , @Query("genres[Smut]") String genresSmut
            , @Query("genres[Sports]") String genresSports
            , @Query("genres[Supernatural]") String genresSupernatural
            , @Query("genres[Tragedy]") String genresTragedy
            , @Query("genres[Webtoons]") String genresWebtoons
            , @Query("genres[Yaoi]") String genresYaoi
            , @Query("genres[Yuri]") String genresYuri
            , @Query("released_method") String released_method
            , @Query("released") String released
            , @Query("rating_method") String rating_method
            , @Query("rating") String rating
            , @Query("is_completed") String is_completed
            , @Query("advopts") String advopts
            , @Query("page") String page
    );

    @GET("/manga/{book}/")
    Call<BookInfo> getBook(@Path("book") String book);


    @GET("/manga/{book}/{volume}/{chapter}/{page}")
    Call<Integer> getPageCount(@Path("book") String manga
            , @Path("volume") String volume
            , @Path("chapter") String chapter
            , @Path("page") String page

    );

    @GET("/manga/{book}/{volume}/{chapter}/{page}")
    Call<Page> getPage(@Path("book") String manga
            , @Path("volume") String volume
            , @Path("chapter") String chapter
            , @Path("page") String page

    );

}
