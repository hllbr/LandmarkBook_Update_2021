package com.hllbr.landmarkbook_2021;

import java.io.Serializable;

public class LandMark implements Serializable {//interface implements/uygulandı
    String name;
    String country ;
    int image;
    //Görsel veri neden image olarak tutulur.Neden böyle bir yönteme başvuruyoruz.

    //Constructor bir sınıftan bir obje oluşturulurken çağrılan ilk metod bundan yararlanarak işlemlerişmizi kolaylaştırmayı hedefliyoruz.
    public LandMark(String name,String country,int image){
        this.name = name;
        this.country = country;
        this.image = image ;
    }
}
