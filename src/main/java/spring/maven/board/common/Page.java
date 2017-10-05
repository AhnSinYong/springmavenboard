package spring.maven.board.common;

import com.google.common.primitives.Ints;
import lombok.Data;

/**
 * Created by ahnsy on 2017-10-05.
 */
@Data
public class Page {
    private int countPerPage;
    private int rowStart;
    private int rowEnd;
    private int totalPage;
    private int totalCount;
    private int currentPage;
    private int pageStart;
    private int PageEnd;

    public void calulatePage(Integer totalCount) {

    }
}
