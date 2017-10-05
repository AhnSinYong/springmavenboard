package spring.maven.board.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.ognl.IntHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahnsy on 2017-10-04.
 */
@Slf4j
public class PagingUtil {
    private static final int countPerPage = 10;
    private static final int unitPage = 10;

    public static Map<String, Object> setPageInfo(Map<String, Object> param, int defaultCountPerPage) {
        int pageNo = Integer.parseInt(param.get("pageNo").toString());
        int countPerPage = Integer.parseInt(param.get("countPerPage").toString());

        countPerPage = countPerPage < 100 ? countPerPage : 100;

        int first = ((pageNo - 1) * countPerPage) + 1;
        int last = first + countPerPage - 1;

        param.put("countPerPage", countPerPage);
        param.put("first", first);
        param.put("last", last);

        log.info("setPageInfo :::::" + param);
        return param;
    }

    public static Map<String, Object> getPageObject(int totalCount, int currentPageNo) {
        return getPageObject(totalCount, currentPageNo, 10);
    }

    public static Map<String, Object> getPageObject(int totalCount, int currentPageNo, int countPerPage) {
        return getPageObject(totalCount, currentPageNo, countPerPage, 10);
    }

    public static Map<String, Object> getPageObject(int totalCount, int currentPageNo, int countPerPage, int unitPage) {
        int currPage = currentPageNo;
        int unitCount = 100;
        boolean isFirst = false;

        if (totalCount == 0) {
            countPerPage = unitCount;
        } else if (totalCount < countPerPage) {
            countPerPage = totalCount / unitCount * unitCount;
            if (totalCount % unitCount > 0) {
                countPerPage += unitCount;
            }
        }

        int totalPage = getMaxNum(totalCount, countPerPage);
        if (totalPage < currPage) currPage = totalPage;
        int currStartCount;
        int currEndCount;
        if (currPage != 1) {
            currEndCount = currPage * countPerPage;
            currStartCount = currEndCount - countPerPage;
        } else {
            currEndCount = countPerPage;
            currStartCount = 0;
        }
        if (currEndCount > totalCount) currEndCount = totalCount;
        int currStartPage;
        int currEndPage;
        if (totalPage <= unitPage) {
            currEndPage = totalPage;
            currStartPage = 1;
        } else {
            currEndPage = (currPage - 1) / unitPage * unitPage + unitPage;
            currStartPage = currEndPage - unitPage + 1;
        }
        if (currEndPage > totalPage) currEndPage = totalPage;
        int prePage;
        boolean prePage_is;
        if (currStartPage != 1) {
            prePage_is = true;
            prePage = currStartPage - 1;
        } else {
            prePage_is = false;
            prePage = 0;
        }
        int nextPage;
        boolean nextPage_is;
        if (currEndPage != totalPage) {
            nextPage_is = true;
            nextPage = currEndPage + 1;
        } else {
            nextPage_is = false;
            nextPage = 0;
        }
        Map<String, Object> tempJSON = new HashMap<>();
        try {
            tempJSON.put("currPage", currPage);
            tempJSON.put("unitPage", unitPage);
            tempJSON.put("prePage", prePage);
            tempJSON.put("prePage_is", prePage_is);
            tempJSON.put("nextPage", nextPage);
            tempJSON.put("nextPage_is", nextPage_is);
            tempJSON.put("currStartPage", currStartPage);
            tempJSON.put("currEndPage", currEndPage);
            tempJSON.put("totalCount", totalCount);
            tempJSON.put("totalPage", totalPage);
        } catch (Exception localException) {
        }
        return tempJSON;
    }

    private static int getMaxNum(int allPage, int list_num) {
        if (allPage % list_num == 0) {
            return allPage / list_num;
        }
        return allPage / list_num + 1;
    }
}
