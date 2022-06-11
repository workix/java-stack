package br.com.codecode.workix.jsf.util.helper;

/**
 * Pagination
 * 
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public class Pagination {

    /**
     * Discover Total Pages
     * 
     * @param limitRows
     *            Limit of Rows
     * @param maxRows
     *            Max Rows in Table
     * @return number of Pages between Limit and Max Rows
     */
    public int discoverTotalPages(int limitRows, int maxRows) {
	
	return Math.round(maxRows / limitRows);
    }

    /**
     * Discover Max Rows between Limit and Total Pages
     * 
     * @param limitRows
     *            Limit of Rows
     * @param totalPages
     *            Number of Total Pages
     * @return number of Rows between Limit and Total Pages
     */
    public int discoverMaxRows(int limitRows, int totalPages) {

	return (totalPages * limitRows);
    }

    /**
     * Discover Start Range between Total Pages and Limit
     * 
     * @param limitRows
     *            Limit of Rows
     * @param currentPage
     *            Current Page
     * @param totalPages
     *            Number of Total Pages
     * @return start Point for Pagination
     * @throws IllegalArgumentException
     *             if CurrentPage Minor Than One
     */
    public int discoverStartRange(int limitRows, int currentPage, int totalPages) throws IllegalArgumentException {

	if (currentPage < 1) throw new IllegalArgumentException("Current Page Less than 1");

	return (limitRows * currentPage) - limitRows + 1;

    }

    /**
     * Discover End Range between Total Pages and Limit
     * 
     * @param limitRows
     *            Limit of Rows
     * @param currentPage
     *            Current Page
     * @param totalPages
     *            Number of Total Pages
     * @return end Point for Pagination
     */
    public int discoverEndRange(int limitRows, int currentPage, int totalPages) {
        int startRange = discoverStartRange(limitRows, currentPage, totalPages);

	return startRange + limitRows - (1);

    }

}
