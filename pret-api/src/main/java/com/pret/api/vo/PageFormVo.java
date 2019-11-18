package com.pret.api.vo;

import com.pret.common.vo.SortCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理端分页 s
 *
 * @author wujinsong
 */
public class PageFormVo extends ReqBody implements Pageable {
    /**
     *
     */
    private static final long serialVersionUID = -1377906631428380104L;
    private int page = 1;
    private int rows = 10;
    private String sort = "lastModifiedDate";
    private String order = "desc";
    private Sort sortSet;
    private Integer start;
    private Integer length;
    private Integer draw;
    private List<SortCondition> sortConditions;

    public PageFormVo() {

    }

    /**
     * 构造函数
     *
     * @param page
     * @param rows
     * @param sortSet
     */
    public PageFormVo(int page, int rows, Sort sortSet) {
        this.page = page;
        this.rows = rows;
        this.sortSet = sortSet;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Sort getSortSet() {
        return sortSet;
    }

    public void setSortSet(Sort sortSet) {
        this.sortSet = sortSet;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return page - 1;
    }

    @Override
    public int getPageSize() {
        return rows;
    }

    @Override
    public long getOffset() {
        return (page - 1) * rows;
    }

    @Override
    public Sort getSort() {
        if (sortConditions == null) {
            sortSet = new Sort(Direction.fromString(order), sort);
        } else {
            List<Order> orders = new ArrayList<>();

            for (SortCondition condition : sortConditions) {
                Order order = new Order(condition.getDirection().equals("asc") ? Direction.ASC : Direction.DESC,
                        condition.getProperty());
                orders.add(order);
            }

            sortSet = Sort.by(orders);
        }

        return sortSet;
    }

    @Override
    public Pageable next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? new PageFormVo(page - 2, rows, getSort()) : this;
    }

    @Override
    public Pageable first() {
        return new PageFormVo(page, rows, getSort());
    }

    @Override
    public boolean hasPrevious() {
        return (page - 1) > 0;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start == 0 ? 1 : start / this.length + 1;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
        this.rows = length;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public List<SortCondition> getSortConditions() {
        return sortConditions;
    }

    public void setSortConditions(List<SortCondition> sortConditions) {
        this.sortConditions = sortConditions;
    }
}
