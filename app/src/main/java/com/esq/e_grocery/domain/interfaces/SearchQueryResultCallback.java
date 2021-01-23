package com.esq.e_grocery.domain.interfaces;

/*
 *Interface for SearchQuery in editext
 */
public interface SearchQueryResultCallback {
        void onSuccessfulQuery(String mSearchQuery);
        void onFailedQuery(String errorMessage);
}
