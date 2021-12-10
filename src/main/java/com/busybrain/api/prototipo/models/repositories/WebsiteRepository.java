package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Website;
import com.busybrain.api.prototipo.views.WebsiteView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WebsiteRepository extends CrudRepository<Website, Integer>{
    
    @Query(value = "SELECT * FROM website WHERE blocked_status = '1'", nativeQuery = true)
    Iterable<Website> findWebsiteByStatus();

    @Query(value = "SELECT * FROM website WHERE blocked_status = '0'", nativeQuery = true)
    Iterable<Website> findByStatus();

    String querytogetwebsites = "select websites.blocked_status AS blockedStatus, dominios_website.website_name AS nomeWebsite, dominios_website.domain_website AS dominioWebsite " +
    "from website AS websites " + 
    "inner join website_domains dominios_website on websites.website_domain_id = dominios_website.id_website";

    @Query(value = querytogetwebsites, nativeQuery = true)
    Iterable<WebsiteView> findWebsites();

    String querytogetwebsitesbyuserid = "select websites.blocked_status AS blockedStatus, dominios_website.website_name AS nomeWebsite, dominios_website.domain_website " + 
    "from website AS websites " + 
    "inner join website_domains dominios_website on websites.website_domain_id = dominios_website.id_website " +
    "inner join bloqueamento blocks on websites.utilizador_id = blocks.utilizador_id " +
    "inner join utilizador users on blocks.utilizador_id = users.user_id ";

    @Query(value = querytogetwebsitesbyuserid + "where blocks.utilizador_id=:utilizadorid", nativeQuery = true)
    Iterable<WebsiteView> findWebsitesByUserid();

}
