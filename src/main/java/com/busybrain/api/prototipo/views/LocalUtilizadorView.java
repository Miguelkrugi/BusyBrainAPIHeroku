package com.busybrain.api.prototipo.views;

public interface LocalUtilizadorView {
    
    int getPlaceId();
    String getPlaceName();
    String getPlaceEndereco();
    double getPlaceLatitude();
    double getPlaceLongitude();
    boolean isPlaceFavorite();
    boolean isPlacePresenca();
    int getUserId();

}
