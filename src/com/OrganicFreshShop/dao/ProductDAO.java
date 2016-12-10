package com.OrganicFreshShop.dao;

import com.OrganicFreshShop.model.PaginatorResult;
import com.OrganicFreshShop.model.Product;

import java.util.List;

/**
 * Created by root on 11/22/16.
 */
public interface ProductDAO {

    public Product fetchProduct( String code );
    public PaginatorResult<Product> fetchAllProductsPaginatorResult( int page, int resultEachPage,
                                                      int maxNavigationPage );
    public PaginatorResult<Product> findAllProductMatchNamePatternPaginatorResult( int page, int resultEachPage,
                                                                    int maxNavigationPage, String likeName);
    public List<Product> fetchAllProducts();
    public List<Product>  findAllProductMatchNamePattern( String likeName );
    public void saveProduct( Product product );
}
