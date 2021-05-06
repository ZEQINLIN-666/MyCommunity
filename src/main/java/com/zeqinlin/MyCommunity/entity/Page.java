package com.zeqinlin.MyCommunity.entity;


/**
 * Description:用来封装分页的一些条件
 * date: 2021/5/4 17:43
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */

public class Page {
    //当前页码
    private int currentPage = 1;
    //显示上限
    private int limit = 10;
    //数据总数（用于计算总页数）
    private int rows;
    //查询路径（用于复用分页链接）
    private String path;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage >= 1) {

            this.currentPage = currentPage;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {

            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     *
     * @return
     */
    public int getOffset() {
        //offset = currentPage * limit - limit
        return (currentPage - 1) * limit;
    }

    /**
     * 获取总页数
     *
     * @return
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     *
     * @return
     */
    public int getStart() {
        int start = currentPage - 2;
        return start < 1 ? 1 : start;
    }

    /**
     * 获取终止页码
     * @return
     */
    public int getEnd() {
        int end = currentPage + 2;
        int total = getTotal();
        return end > total ? total : end;
    }
}
