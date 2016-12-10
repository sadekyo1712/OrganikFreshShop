package com.OrganicFreshShop.controller;

import com.OrganicFreshShop.daoImplements.OrderDAOImplement;
import com.OrganicFreshShop.daoImplements.ProductDAOImplement;
import com.OrganicFreshShop.model.Order;
import com.OrganicFreshShop.model.OrderDetail;
import com.OrganicFreshShop.model.PaginatorResult;
import com.OrganicFreshShop.model.Product;
import com.OrganicFreshShop.util.Utils;
import com.OrganicFreshShop.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by root on 11/23/16.
 */
@Controller
public class AdminController {

    @Autowired
    private OrderDAOImplement orderDAOImplement;

    @Autowired
    private ProductDAOImplement productDAOImplement;

    @Autowired
    private ProductValidator productValidator;

    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;

    @InitBinder
    public void initBinder( WebDataBinder dataBinder ) {
        Object target = dataBinder.getTarget();
        if ( target == null )
            return;
        if ( target.getClass() == Product.class ) {
            System.out.println( "Target : " + target );
            dataBinder.setValidator( productValidator );
            dataBinder.registerCustomEditor( byte[].class, new ByteArrayMultipartFileEditor() );
            System.out.println("--------------------------------------------");
        }
    }


    @RequestMapping( value = "/account_info", method = RequestMethod.GET )
    public String accountInfo(ModelMap modelMap, HttpServletRequest request) {

        UserDetails userDetails = ( UserDetails ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("-----------Spring Security support :-------");
        System.out.println( "* Password : " + userDetails.getPassword() );
        System.out.println( "* Username : " + userDetails.getUsername() );
        System.out.println( "* Enabled user : " + userDetails.isEnabled() );
        System.out.println("---------------------------------------------");
        System.out.println("In account info page");
        modelMap.addAttribute( "userDetail", userDetails );
        modelMap.addAttribute( "cartForm", Utils.getCartInSession( request ) );
        return "account_info";
    }

    @RequestMapping( value = "/order_list", method = RequestMethod.GET )
    public String orderList( ModelMap modelMap, HttpServletRequest request,
                             @RequestParam( value = "page", defaultValue = "1") String pageString ) {
        int page = 1;
        try {
            page = Integer.parseInt( pageString );
        } catch ( Exception ex ) {
            System.out.println("Error when cast page number in order_list and is redirecting to index.........");
            ex.printStackTrace();
            return "redirect:/index";
        }
        final int maxResult = 7;
        final int maxNavigationPage = 10;
        PaginatorResult<Order> result =
                orderDAOImplement.listOrderPaginatorResult( page, maxResult, maxNavigationPage );
        modelMap.addAttribute( "paginatorResult", result );
        modelMap.addAttribute( "cartForm", Utils.getCartInSession( request ) );
        System.out.println("In order_list page with order list : " + result ) ;
        return "order_list";
    }

    @RequestMapping( value = "/product_admin", method = RequestMethod.GET )
    public String product( ModelMap modelMap, HttpServletRequest request,
                           @RequestParam( value = "code", defaultValue = "")String code ) {
        Product product = null;
        if ( code != null && code.length() > 0 )
            product = productDAOImplement.fetchProduct( code );
        if ( product == null ) {
            product = new Product();
        }
        modelMap.addAttribute( "productForm", product );
        modelMap.addAttribute( "cartForm", Utils.getCartInSession( request ) );
        System.out.println("In product_admin HTTP_GET page");
        return "product_admin";
    }

    @RequestMapping( value = "/product_admin", method = RequestMethod.POST )
    public String productSave( ModelMap modelMap, HttpServletRequest request,
                               @ModelAttribute( "productForm" ) @Validated Product product,
                               BindingResult bindingResult ) {
        if ( bindingResult.hasErrors() ) {
            System.out.println("Error when binding result");
            return "product_admin";
        }
        try {
            productDAOImplement.saveProduct( product );
        } catch ( Exception ex ) {
            System.out.println("Error when save product in product_admin HTTP_POST");
            ex.printStackTrace();
            modelMap.addAttribute("message", ex.getMessage() );
            return "product_admin";
        }
        modelMap.addAttribute( "cartForm", Utils.getCartInSession( request ) );
        System.out.println("In product_admin HTTP_POST and is redirecting to product_list");
        return "redirect:/product_list";
    }

    @RequestMapping( value = "/order", method = RequestMethod.GET )
    public String viewOrder( ModelMap modelMap, HttpServletRequest request,
                             @RequestParam( value = "orderID") String orderID ) {
        Order order = null;
        if ( orderID != null )
            order = orderDAOImplement.getOrder( orderID );
        if ( order == null ) {
            System.out.println("Not found order with orderID : " + orderID + " and is redirecting to order_list page....." );
            return "redirect:/order_list";
        }
        modelMap.addAttribute( "order", order );
        modelMap.addAttribute( "cartForm", Utils.getCartInSession( request ) );
        System.out.println("Fetch order : " + order + " successfully !");
        return "order_detail_admin";
    }

}
