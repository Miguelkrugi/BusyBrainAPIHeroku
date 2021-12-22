package com.busybrain.api.prototipo.views;

//INTERFACE A UTILIZAR PARA OBTER SITES BLOQUEADOS E DESBLOQUEADOS

public interface WebsiteeView {
    
    
    boolean getBlockedStatus();
    String getNomeWebsite();
    String getDominioWebsite();


}
