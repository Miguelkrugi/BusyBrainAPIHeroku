package com.busybrain.api.prototipo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "place")
public class Local {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "place_id") private int id;
    @Column(name = "place_name") private String name;
    @Column(name = "place_endereco") private String endereco;
   // @Column(name = "place_distancia") private int distancia;
    @Column(name = "place_latitude") private double latitude;
    @Column(name = "place_longitude") private double longitude;
    @Column(name = "place_google_id") private String googleid;
    @Column(name = "user_request_id") private int userrequestid;
   
    public Local(){

    }

    public int getUserrequestid() {
        return userrequestid;
    }

public void setUserrequestid(int userrequestid) {
    this.userrequestid = userrequestid;
}

    public String getGoogleid() {
        return googleid;
    }

    public void setGoogleid(String googleid) {
        this.googleid = googleid;
    }

   public double getLatitude() {
       return latitude;
   }
    

   public void setLatitude(double latitude) {
       this.latitude = latitude;
   }

   public double getLongitude() {
       return longitude;
   }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

  /*  public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }*/


}
