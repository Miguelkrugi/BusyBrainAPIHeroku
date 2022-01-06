package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Website;
import com.busybrain.api.prototipo.views.WebsiteView;
import com.busybrain.api.prototipo.views.WebsiteViiew;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WebsiteRepository extends CrudRepository<Website, Integer>{
    
   /*/QUERIES 'ABANDONADAS'

    String queryToBlockedWebsitesByUserId = "SELECT * FROM website WHERE blocked_status = '1'";

    

    String queryToUnlockedWebsitesByUserId = "SELECT * FROM website WHERE blocked_status = '0'";

    @Query(value = queryToBlockedWebsitesByUserId + " where utilizador_id=:utilizadorid", nativeQuery = true)
    Iterable<Website> findWebsiteByUtilizadorId(@Param("utilizadorid") int utilizadorid);

    @Query(value = queryToUnlockedWebsitesByUserId + " where utilizador_id=:utilizadorid", nativeQuery = true)
    Iterable<Website> findWebsiteByUtilizadorIdStatus();

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
    Iterable<WebsiteView> findWebsitesByUserid(@Param("utilizadorid") int utilizadorid);
    */






    String queryTogetUnlockedwebsitesbyUtilizadorId = "select sites.website_id AS websiteId, sites.website_user_block AS userId , users.user_name AS userName, dominios.website_name AS websiteName,dominios.domain_website AS websiteDomain, sites.website_blocked_status AS blockedStatus " + 
    "from website AS sites " + 
    "inner join website_domains dominios on sites.website_domain_id = id_website " + 
    "inner join utilizador users on sites.website_user_block = users.user_id " + 
    "where sites.website_blocked_status = '0' "; 



    @Query(value = queryTogetUnlockedwebsitesbyUtilizadorId + "and sites.website_user_block=:userid", nativeQuery = true)
    Iterable<WebsiteViiew> findWebsitesByStatus(@Param("userid") int userid);

    String queryTogetLockedwebsitesbyUtilizadorId = "select sites.website_id AS websiteId, sites.website_user_block AS userId , users.user_name AS userName, dominios.website_name AS websiteName,dominios.domain_website AS websiteDomain, sites.website_blocked_status AS blockedStatus " + 
    "from website AS sites " + 
    "inner join website_domains dominios on sites.website_domain_id = id_website " + 
    "inner join utilizador users on sites.website_user_block = users.user_id " + 
    "where sites.website_blocked_status = '1' ";

    @Query(value = queryTogetLockedwebsitesbyUtilizadorId + "and sites.website_user_block=:userid", nativeQuery = true)
    Iterable<WebsiteViiew> findWebsitesByBlockedStatus(@Param("userid") int userid);

    /////////////////////////////////////////////////////QUERIES DE BLOQUEIO DE WEBSITES/////////////////////////////////////////////////////////////

    //QUERY PARA A UPDATE DE WEBSITES (BLOQUEIO):

    // update website set website_blocked_status = '1' where sites.website_domain_id=:domainid  and sites.website_user_block=:userid (PUT MAPPING)

    //QUERY PARA A UPDATE DE WEBSITES (DEBLOQUEIO):

    //update website set website_blocked_status = '0' where sites.website_domain_id=:domainid and sites.website_user_block=:userid (PUT MAPPING)

}
