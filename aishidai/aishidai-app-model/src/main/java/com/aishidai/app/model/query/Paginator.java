package com.aishidai.app.model.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * 通用分页,默认每页记录数defaultPageSize可重载
 *
 *
 */
public class Paginator implements Serializable {
    /**
     * Paginator
     */
    private static final long serialVersionUID = -7170937170337221913L;

    /**
     * 默认的每页记录数,20条
     */
    private static Integer DEFAULT_PAGE_SIZE = new Integer(10);

    /**
     * 默认的当前页,第一页
     */
    private static Integer DEFAULT_CURRENT_PAGE = new Integer(1);

    //采用包装类型，方便出现null时取默认
    /**
     * 每页记录数
     */
    private Integer pageSize;

    /**
     * 当前页号
     */
    private Integer currentPage;

    /**
     * 总记录数
     */
    private int totalItem;

    /**
     * 开始行
     */
    private transient int startRow;

    /**
     * 结束行
     */
    private transient int endRow;

    /**
     * 排序字段
     */
    private String sortField;

    /***
     * 约定基本的时间的排序字段的名称
     */
    public static final String GMT_CREATE = "gmt_create";

    public static final String GMT_MODIFIED = "gmt_modified";

    public static final String USER_MODIFIED = "user_modified";

    public static final String ID = "id";

    /**
     * 正序或倒序
     */
    private String order;

    public static final String ASC = "asc";

    public static final String DESC = "desc";

    /**
     * 是否已被设置为最后一页
     */
    private transient boolean isSettedLastPage;

    public Paginator(){
        order = ASC;
    }

    /**
     * 当前是否是第一页
     * @return 是否
     */
    public boolean isFirstPage() {
        return getCurrentPage().intValue() == 1;
    }

    /**
     * 获取上一页页号
     * @return 上一页页号
     */
    public int getPreviousPage() {
        int back = getCurrentPage().intValue() - 1;

        return (back <= 0) ? 1 : back;
    }

    /**
     * 当前是否是最后一页
     * @return
     */
    public boolean isLastPage() {
        return getTotalPage() == getCurrentPage().intValue();
    }

    /**
     * 获取下一页页号
     * @return 下一页页号
     */
    public int getNextPage() {
        int back = getCurrentPage().intValue() + 1;

        return (back > getTotalPage()) ? getTotalPage() : back;
    }

    /**
     * 取当前页号
     * @return 当前页号
     */
    public Integer getCurrentPage() {
        return (null == currentPage) ? DEFAULT_CURRENT_PAGE : currentPage;
    }

    /**
     * 字符串方式设置当前页号
     * @param currentPage
     */
    public void setCurrentPageString(String currentPage) {
        if (isBlankString(currentPage)) {
            setCurrentPage(DEFAULT_CURRENT_PAGE);
        } else {
            try {
                Integer integer = new Integer(currentPage);

                setCurrentPage(integer);
            } catch (NumberFormatException ignore) {
                setCurrentPage(DEFAULT_CURRENT_PAGE);
            }
        }
    }

    /**
     * 设置当前页号
     * @param fPage
     */
    public void setCurrentPage(Integer fPage) {
        this.currentPage = ((null == fPage) || (fPage.intValue() <= 0)) ? null
                : fPage;
        //设置开始与结束行
        /*setStartEndRow();*/
    }

    /**
     * 获取每页记录数
     * @return
     */
    public Integer getPageSize() {
        return (null == pageSize) ? Integer.valueOf(0) : pageSize;
    }

    /**
     * 字符串方式设置每页记录数
     * @param pageSizeString
     */
    public void setPageSizeString(String pageSizeString) {
        if (isBlankString(pageSizeString)) {
            setPageSize(getDefaultPageSize());
        } else {
            try {
                Integer integer = new Integer(pageSizeString);

                setPageSize(integer);
            } catch (NumberFormatException ignore) {
                setPageSize(getDefaultPageSize());
            }
        }
    }

    /**
     * 设置开始与结束行
     */
   /* private void setStartEndRow(Integer startRow) {
        this.startRow =*//* (getPageSize().intValue() * (getCurrentPage().intValue() -
                1)) *//**//**//**//*+ 1*//**//**//**//*;*//*startRow;
        this.endRow = (this.startRow + getPageSize().intValue()) - 1;
    }*/


    /**
     * 设置每页记录数
     * @param pSize
     */
    public void setPageSize(Integer pSize) {
        this.pageSize = ((null == pSize) || (pSize.intValue() <= 0)) ? null
                : pSize;
        //设置开始与结束行
        /*setStartEndRow();*/
    }

    /**
     * 是否是空串
     * @param string
     * @return 是否
     */
    private boolean isBlankString(String string) {
        boolean flag = false;

        flag = (string == null || string.trim().length() == 0);

        return flag;
    }

    /**
     * 获取总记录数
     * @return 总记录数
     */
    public int getTotalItem() {
        return totalItem;
    }

    /**
     * 设置总记录数
     * @param tItem
     */
    public void setTotalItem(int tItem) {
        this.totalItem = tItem;

        int currentPage = getCurrentPage().intValue();
        int totalPage = getTotalPage();

        //当前页超过总页数,则取总页数
        if (currentPage > totalPage) {
            setCurrentPage(new Integer(totalPage));
        }
    }

    /**
     * 获取总页数
     * @return 总页数
     */
    public int getTotalPage() {
        int pgSize = getPageSize().intValue();
        int result = 0;

        if (pgSize > 0) {
            result = totalItem / pgSize;

            if ((totalItem == 0) || ((totalItem % pgSize) != 0)) {
                result++;
            }
        }

        return result;
    }

    /**
     * 计算开始行并返回
     * @return 开始行号
     */
    public int getPageFirstItem() {
        int cPage = getCurrentPage().intValue();

        if (cPage == 1) {
            return 1; // 第一页开始当然是第 1 条记录
        }

        cPage--;

        int pgSize = getPageSize().intValue();

        return (pgSize * cPage) + 1;
    }

    /**
     * 计算结束行并返回
     * @return 结束行号
     */
    public int getPageLastItem() {
        int cPage = getCurrentPage().intValue();
        int pgSize = getPageSize().intValue();
        int assumeLast = pgSize * cPage;

        return (assumeLast > totalItem) ? totalItem : assumeLast;
    }

    /**
     * 默认的每页记录数,子类可以重载
     * @return 每页记录数
     */
    protected Integer getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static void main(String[] args) {
        Paginator page = new Paginator();
        page.setCurrentPage(45);
        page.setPageSize(20);
        page.setTotalItem(100);

        //for test
        System.out.println("当前页号 : " + page.getCurrentPage());
        System.out.println("每页记录数 : " + page.getPageSize());
        System.out.println("总记录数 : " + page.getTotalItem());
        System.out.println("-------------------");

        System.out.println("下一页页号 : " + page.getNextPage());
        System.out.println("上一页页号 : " + page.getPreviousPage());
        System.out.println("开始行号 : " + page.getStartRow());
        System.out.println("结束行号 : " + page.getEndRow());

        System.out.println("总页数 : " + page.getTotalPage());
    }

    /**
     * @return the startRow
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * @param startRow the startRow to set
     */
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    /**
     * @return the endRow
     */
    public int getEndRow() {
        return endRow;
    }

    /**
     * @param endRow the endRow to set
     */
    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


    /**
     * 是否被设置为最后一页。
     * 在某此情况下，没法获取TotalPage
     * 只能某场景下决定是否最后一页
     * @return
     */
    public boolean isSettedLastPage() {
        return isSettedLastPage;
    }

    public void setSettedLastPage(boolean settedLastPage) {
        isSettedLastPage = settedLastPage;
    }

    @Override
    public String toString() {
        return "Paginator{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalItem=" + totalItem +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", sortField='" + sortField + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
