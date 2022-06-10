package br.com.codecode.workix.rest.dto.out;

import java.util.List;

public class PaginatedList<T> {
    public List<T> rows;
    public int start, end, totalPages, currentPage, limitRows, maxRows;

    public PaginatedList(List<T> rows, int start, int end, int totalPages, int currentPage, int limitRows, int maxRows) {
        this.rows = rows;
        this.start = start;
        this.end = end;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.limitRows = limitRows;
        this.maxRows = maxRows;
    }
}
