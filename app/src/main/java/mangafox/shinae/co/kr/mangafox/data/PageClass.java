package mangafox.shinae.co.kr.mangafox.data;


import java.util.logging.Logger;

public class PageClass {
    static Logger log = Logger.getLogger(PageClass.class.getName());
    private int lastPage;
    private int currentPage;
    public int getLastPage() {
        log.info("getLastPage");
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public String getPageHref() {
        return href + "page=";
    }
    public void setHref(String href) {
        this.href = href;
    }
    public int getCurrentPage() {
        log.info("getCurrentPage");
        return this.currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    private String href;
}