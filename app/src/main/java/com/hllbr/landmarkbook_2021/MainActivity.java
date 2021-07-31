package com.hllbr.landmarkbook_2021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hllbr.landmarkbook_update.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark> landMarkArrayList;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //ArrayList initialize operatin area :)
        landMarkArrayList =new ArrayList<>();
        //DATA
        LandMark pisa = new LandMark("Pisa","Italy",R.drawable.pisa);
        LandMark eiffel = new LandMark("Eiffel","France",R.drawable.effiel);
        LandMark colosseum = new LandMark("Colosseum","Italy",R.drawable.colosseum);
        LandMark london_Bridge = new LandMark("London Bridge","England",R.drawable.london_bridge);

        landMarkArrayList.add(pisa);
        landMarkArrayList.add(eiffel);
        landMarkArrayList.add(colosseum);
        landMarkArrayList.add(london_Bridge);//Tek bir arrayList ile tek bir model içerisinde 12 değişkeni tutabiliyor pozisyona gelmiş oldum

        //Adapter = Bizim veri kaynağımız ile xml'i ve listView'i birbirine bağlayan yapımız.
        //ListView =
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                landMarkArrayList.stream().map(landMark -> landMark.name).collect(Collectors.toList())
        );//min SDK 24 daha alt bir sdk versionda bu yapı çalışmaz
        binding.listView.setAdapter(arrayAdapter);
        /*Maping Concept = Haritalamak anlamına gelmektedir.Sadece javada veya android içerisinde kullanılan bir yöntem değildir.Bütün dillerde mevcuttur.
        JavaScript,Python,Kotlin vb... kullanılan bir yöntemdir.
        Genellikle birşeyi birşeye dönüştürmekte kullanılıyor olarak ifade edebiliriz.
        Örnek olarak bir yapıyı başka bir yapıya dönüştürürken kullanılıyor.BU yapıların uyumlu olması şartı mevcuttur.
        biz bu örnekte landmark yapısını sadece isimlere dönüştürmek isitiyoruz.*/

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,landMarkArrayList.get(position).name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Details_Activity.class);
                intent.putExtra("landmark",landMarkArrayList.get(position));
                startActivity(intent);
            }
        });
        /*
        String pisa = "Pisa";
        String eiffel = "Eiffel";
        String london_Bridge = "London Bridge";
        String colosseum = "Colosseum";
        Binlerce veri ile işlem yapmam gereken durumlarda bu yöntemi kullanamam fakat sınırlı sayıda verim varsa şuan üzerinde bulunduğum senaryo gibi o zaman tek tek kaydetmek seçeneklerim arasına girebilir.
        Bu verilerin bir liste içerisinde tutulması gerkeiyorki liste halinde gösterim yapabilelim.
        ArrayList oluşturduk ekledik fakat biz sadece eserin ismini değil ülkesinin adınıdas tutmak zorundayız bunun için farklı bir liste oluşturmamız gerekiyor.

        Biz bunların yanında bir adet resim göstermek istiyoruz bu durumda bir arrayList daha oluşturmak zorundayız.
        Her bir veri yeni bir arrayList ile ifade ediliyor şuan kurmak istediğimiz algoritmada buda bize belirli ölçüde bir zaman kaybı oluşturuyor verimli bir yöntem değil :/

        ***Eğer biz bir sınıf oluşturursak ve verilerimizi bu sınıfa göndererek çekersek bu zaman ve sıkıntılı algoritma kurma mantığından sıyrılmış olabiliriz.
        4 Değişken olacağına tek değiken tek değişken içerisinde istediğim veriyi tutayım daha mantıklı bir durum...!!!!
        ArrayList<String> landmarkNames =new ArrayList<String>();
        landmarkNames.add(pisa);
        landmarkNames.add(eiffel);
        landmarkNames.add(london_Bridge);
        landmarkNames.add(colosseum);
        Bu akıcı bir yöntem sayılmaz basic level olarak ifade edebiliriz.Amatör concept :/
         */


    }
}
/*
View Binding nedir = Görünüm Bağlama anlamına gelir.
View Binding'e neden ihtiyaç duyarız?

View Binding bir jetpack üyesidir.Android geliştiriciler için geliştirilmiş işlemleri hızlandıran verimli hale getiren kütüphaneler toplululuğudur Jetpack

ListView kullanımı kolay fakat verimsiz , RecyclerView ise kullanımı bir complex fakat verimli olan tercihtir.
 */
