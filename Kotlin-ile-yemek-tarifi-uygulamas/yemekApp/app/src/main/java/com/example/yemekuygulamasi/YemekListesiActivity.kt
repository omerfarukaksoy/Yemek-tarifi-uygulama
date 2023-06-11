package com.example.yemekuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView

class YemekListesiActivity : AppCompatActivity() {

    private lateinit var soupRV: RecyclerView
    private lateinit var mainCourseRV: RecyclerView
    private lateinit var saladsRV: RecyclerView
    private lateinit var dessertsRV: RecyclerView
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_listesi)

        dessertsRV = findViewById(R.id.dessertsRV)
        saladsRV = findViewById(R.id.saladsRV)
        mainCourseRV = findViewById(R.id.mainCourseRV)
        soupRV = findViewById(R.id.soupRV)

        val dessertList = listOf(
            Meal("muhallebi", R.drawable.muhallebi, "Muhallebi yapmak için önce uygun bir tencereye toz şeker, nişasta, un ve sütü alarak tel çırpıcı ile güzelce çırpalım.\n" +
                    "Pürüzsüz bir kıvam aldıktan sonra tencereyi ocağa alalım ve karıştırarak pişirelim.\n" +
                    "Muhallebimiz koyulaşıp göz göz olduktan sonra ocaktan alalım ve içerisine tereyağı ve vanilyayı ilave edelim.\n" +
                    "Tereyağı eriyene kadar tekrar karıştıralım. Muhallebimizin kıvamı soğudukça koyulaşacaktır.\n" +
                    "Hazırladığımız muhallebimizi servis kaselerine paylaştıralım ve üzerini bir kaşık yardımı ile düzeltelim.\n" +
                    "Tatlılarımız oda sıcaklığına geldikten sonra üzerini streç ile kapatalım ve dinlenmesi için buzdolabına kaldıralım. En az 3 saat dinlenmeye bırakalım.\n" +
                    "Dinlenen muhallebimizi dolaptan alalım ve dilediğimiz şekilde süsleyerek servis edelim. Afiyet olsun!"),
            Meal("sütlaç", R.drawable.sutlac, "Sütlaç yapmak için öncelikle pirinci yıkayıp su ile ateşe koyun.\n" +
                    "Pirinçler uzayıp suyu çekene kadar kaynatın, soğuk sütü ekleyin.\n" +
                    "1-2 defa karıştırıp, kaynamasını bekleyin.\n" +
                    "Bu arada bir kasede pirinç ununu 1 su bardağı soğuk süt ile ezin.\n" +
                    "Tencerede kaynamakta olan sütten 1-2 kepçe alıp kaseye ekleyin. (pirinç unu ılınmış olmalı).\n" +
                    "Pirinç ununu tencereye ekleyin, ara sıra karıştırarak 10 dakika kadar pişirin.\n" +
                    "Toz şekeri ilave edip karıştırın ve 1-2 taşım kaynatın.\n" +
                    "Sütlacı kaselere paylaştırın.\n" +
                    "Soğuyunca sütlaçların üzerlerine tarçın serperek servis edebilirsiniz. Afiyet olsun."),
            Meal("kazandibi", R.drawable.kazandibi, "Öncelikle orta boy bir tencereye bütün malzemeleri alarak karıştırıyoruz.\n" +
                    "Muhallebi elde ediyoruz. En son tereyağını ve vanilyasını dökerek muhallebimizi 5 dk. kadar pişiriyoruz.\n" +
                    "Orta boy alüminyum tepsiye bolca tereyağı sürüyoruz ve 3 yemek kaşığı kadar tepsiye şeker döküyoruz.\n" +
                    "Her yeri eşit olmasına özen gösterin.\n" +
                    "Sonra pişmiş muhallebiyi tepsiye döküyoruz ve orta ateşte sürekli olarak çevirerek muhallebiyi pişiriyoruz.\n" +
                    "25-30 dk. yeterli burada önemli olan tepsiyi sürekli çevirerek kontrollü pişirmek kenar kısımların da pişmesine özen göstermek biraz dibi tutan muhallebinin kokusu biraz çıkar.\n" +
                    "O zaman hemen ocaktan alıyoruz ve soğumaya bırakıyoruz.\n" +
                    "Soğuduktan sonra 1-2 saat de buzdolabında bekletiyoruz.\n" +
                    "Sonra istediğimiz gibi dilimleyip servis yapabilirsiniz. Afiyet olsun."),
            Meal("künefe", R.drawable.kunefe, "İlk olarak künefenin şerbeti hazırlanır. Şerbet için, su ve şeker bir tencereye alınarak kaynamaya bırakılır. (Şerbetin dibine tutmaması için ara ara karıştırılır.)\n" +
                    "Şerbet kaynamaya başlayınca şekerin kesilmemesi için 1 çay kaşığı limon suyu eklenip 10-15 dakika kadar daha kaynatılır ve şerbet soğumaya bırakılır.\n" +
                    "Künefe için, tereyağı kısık ateşte erimeye bırakılır.\n" +
                    "Eriyen tereyağı bir kenara alınarak bekletilir.\n" +
                    "Tereyağı donduktan sonra altında tereyağının suyu olacaktır bu suyu kullanmayın.\n" +
                    "Hafif donmuş olan tereyağına 1 çay kaşığı pekmezi eklenerek muhallebi kıvamına gelecek şekilde karıştırılır.\n" +
                    "Varsa künefe tepsisi yoksa alüminyum veya teflon tavanın altı bu pekmezli yağ karışımı ile yağlanır.\n" +
                    "Kadayıf tel tel tiftiklenerek ayrılır.\n" +
                    "Ardından bıçakla 1 cm kalınlığında kesilerek iki parçaya ayrılır.\n" +
                    "Ayırdığımız kadayıfın bir parçası yağlanmış tepsinin dibine aralarda boşluk kalmayacak şekilde serilir.\n" +
                    "Rendelenmiş peynirler kadayıfın üzerine yayılır.\n" +
                    "Diğer kadayıf da peynirin üzerinde boşluk kalmayacak şekilde kapatılır.\n" +
                    "Kenarları düzeltilir ve başka bir tepsi altıyla veya eliniz ile üzerine bastırılır.\n" +
                    "İyice bastırarak arasında boşluk kalmamasını dikkat edin.\n" +
                    "En kısık ateşte ocağın üzerinde tepsi çevrilerek pişirilir.\n" +
                    "Altının tamamen kızardığından emin olduğunuzda tepsiyi bir tabağın veya tepsinin üzerine ters çevrilir ve diğer tarafının pişmesi için ikinci tepsinin içi de yağlanır.\n" +
                    "Kızaran kısım üstte kalacak şekilde künefe tepsiye yerleştirilir ve altı kızartılır. Böylece iki tarafı da kızarmış olur.\n" +
                    "Şerbeti kenarından başlanarak dökülür. Antep fıstığı veya süt kaymağı ile servis edilir. Afiyet olsun."),
        )
        val dessertsAdapter = DessertsAdapter(dessertList)
        dessertsRV.adapter = dessertsAdapter

        val saladList = listOf(
            Meal("çoban salatası ", R.drawable.cobansalata, "Soğanı küp küp doğrayın,\n" +
                    "Salatalıkları soyup küp küp doğrayın,\n" +
                    "Biberlerin çekirdeklerini çıkarıp minik minik doğrayın,\n" +
                    "Domateslerin kabuklarını soyup küp küp doğrayın,\n" +
                    "Maydanoz ve dereotunu ince ince kıyın,\n" +
                    "Tüm malzemeyi servis tabağına alın,\n" +
                    "Zeytinyağ, limon suyu ve tuz ekleyip karıştırın."),
            Meal("makarna salatası", R.drawable.makarna_salatasi, "Haşlanmış makarna, garnitür, doğranmış kornişon ve dereotu bir kaba alınır.\n" +
                    "Yoğurtla mayonez çırpılır ezilmiş sarımsak ve tuz ilavesi yapılır. Makarnanın içine ilave edilip karıştırılır.\n" +
                    "Yoğurtlu karışım servisten hemen önce döküp karıştırın.\n" +
                    "Aksi halde makarna yoğurdu çekip kuruyacaktır.\n" +
                    "Afiyet olsun. \uD83C\uDF74"),
            Meal("havuçlu lahana", R.drawable.havuclu_lahana, "Doğranan lahana, geniş bir kase içinde 1 tatlı kaşığı tuzla ovulur, " +
                    "lahananın bu şekilde yumuşaması sağlanır. Üzerine mısır, rendelenmiş havuçlar, doğranan salatalık, maydanoz, dereotu eklenir. Ayrı bir kasede yoğurt, rendelenmiş " +
                    "sarımsak, hardal ve mayonez çırpılır, salataya dökülür."),
            Meal("nohut salatası", R.drawable.nohut_salatasi, "Karıştırma kabına lahana ,havuç ve yeşillikleri alalım.\n" +
                    "Üzerine yoğur, mayonez ve rendelenmiş sarımsak ekleyip karıştıralım. Servis tabağına alalım.\n" +
                    "Üzeri için tavaya yağları alalım. Üzerine baharatları ekleyip karıştıralım. Nohudu ilave edelim. 4-5 dakika kısık ateşte kavuralım.\n" +
                    "Ocaktan alalım. Lahana salatamızın üzerine gezdirelim. Deneyeceklere şimdiden afiyet şifa olsun."),
        )
        val saladsAdapter = SaladsAdapter(saladList)
        saladsRV.adapter = saladsAdapter

        val mainCourseList = listOf(
            Meal("patlıcan yemeği", R.drawable.ana_yemek, "İlk olarak patlıcanlar alacalı soyularak uzunlamasına 4’e bölelim, sonrasında küp küp dilimleyelim. Patlıcanlar tuzlu suda yaklaşık 20 dakika kadar beklemeye bırakalım.\n" +
                    "Bu arada soğanları yemeklik doğrayalım. Yeşil biberi de çok kalın olmayacak şekilde doğrayalım.\n" +
                    "Kırmızı biberin içlerini boşaltarak onları da aynı şekilde doğrayalım.\n" +
                    "Sebzeleri doğrama işlemi bittikten sonra tencereye zeytinyağını alarak soğanları ekleyelim, kavuralım.\n" +
                    "Soğanlar hafif pembeleştikten sonra biberleri de ekleyelim. Diriliği gidene kadar orta ateşte kavurmaya devam edelim.\n" +
                    "2-3 dakika kavrulduktan sonra domates sosunu da ekleyerek karıştıralım.\n" +
                    "Tuzu da ilave ederek yemeğimizi tekrar karıştıralım.\n" +
                    "Tuzlu suyun içinden almış olduğumuz patlıcanları da ekleyerek dikkatli bir şekilde karıştıralım.\n" +
                    "Tencerenin kapağını kapatalım ve ara ara karıştırarak yemeğin kendi suyu ile pişmesi sağlayalım. Bu aşamada ocağın yüksek ateşte olmamasına dikkat edelim.\n" +
                    "Patlıcanlar yumuşayıp piştikten sonra ocak kapatalım ve servis edelim. Afiyet olsun."),
            Meal("pırasa yemeği", R.drawable.pirasa_yemegi, "Pırasa yemeği yapmak için pırasalar temizlenerek 1 cm uzunluğunda doğranır.\n" +
                    "Bol su ile yıkanarak suyunun süzülmesi sağlanır.\n" +
                    "2 adet orta boy havucun dış kısmı soyulur ve ince ince halka şeklinde dilimlenir.\n" +
                    "Tencereye sıvı yağ alınarak salça eklenir ve kavrulur.\n" +
                    "Rendelenmiş  domates  eklenerek 1-2 tur çevirelim.\n" +
                    "Daha sonra havuç ilave edilir ve 2-3 dk hep birlikte kavrulması sağlanır.\n" +
                    "Suyu süzülen pırasalar ilave edildikten sonra karıştırılır ve tencerenin kapağı kapatılır.\n" +
                    "Orta ateşte pırasalar suyunu salıp, suyunu çekene kadar bu şekilde pişirilir.\n" +
                    "Son olarak yıkanmış pirinç ilave edilir, tuzu ayarlanır ve yemekle aynı hizaya gelecek kadar sıcak su eklenir. Su miktarı gerekirse eğer sonradan ilave ederek ayarlayabilirsiniz.\n" +
                    "Tencerenin kapağı kapatılarak havuçlar ve pırasalar pişene kadar kısık ateşte pişirilir. Tüm sebzeler yumuşadıktan sonra yemeğimiz servise hazır. Afiyet olsun."),
            Meal("sebzeli köfte", R.drawable.sebzeli_kofte, "Öncelikle köftesini hazırlıyoruz, bütün köfte malzemelerini yoğurma kabına alıyoruz çok iyi yoğuruyoruz.\n" +
                    "Ceviz büyüklüğünde parçalar kopartıp yuvarlak şekil veriyoruz vaktimiz varsa buzdolabında köfteleri dinlendirelim.\n" +
                    "Sebzeleri hazırlıyoruz patatesin kabuklarını soyup küp şeklinde yemeklik doğruyoruz .\n" +
                    "Havucu ve diğer sebzeleri doğruyoruz.\n" +
                    "Hepsini fırın tepsisine alıyoruz.\n" +
                    "Üzerine dört yemek kaşığı zeytinyağ ilave edip baharatları serpiyoruz .\n" +
                    "Hepsini çok iyi karıştıyoruz.\n" +
                    "160 derece fırında hafif yumuşayana kadar pişiriyoruz .\n" +
                    "Fırından sebzeleri alıyoruz üzerine köfteleri diziyoruz .\n" +
                    "Üzerine salçayla suyu sıvı yağ hepsini çırpıyoruz eşit gezdiriyoruz.\n" +
                    "Üzerine domatesleri ilave edip fırına veriyoruz üzerini yağlı kağıdı ıslatıp kapatarak pişirebiliriz. Afiyetle."),
            Meal("yalancı mantı", R.drawable.yalanci_manti, "İç harcı için uygun bir kap içerisinde kıyma, rendelenmiş soğan, ince kıyılmış maydanoz, yeteri kadar tuz ve karabiberi elimizle güzelce karıştıralım ve yoğuralım.\n" +
                    "Bir adet yufkayı ortadan ikiye keselim. Yufkalardan bir parçasını alarak kenar kısımlarını içe doğru katlayalım.\n" +
                    "Düz kenarı boyunca kıymalı iç harcımızdan koyalım ve rulo şeklinde saralım.\n" +
                    "Yaptığımız ruloyu, yaklaşık iki parmak genişliğinde dilimleyelim. Tüm yufkalar için aynı işlemi yapalım.\n" +
                    "Fırın kabımızı sıvı yağ ile yağlayalım ve kestiğimiz mantı dilimlerini dik bir şekilde dizelim. (Kullanılan fırın kabının çapı 23 cm)\n" +
                    "Üzerlerine bir fırça yardımıyla sıvı yağ sürelim ve 190 derece fırında 30-35 dakika, hafifçe kızarana kadar pişmeye alalım.\n" +
                    "Sosumuz için; uygun bir sos tenceresi veya tavaya sıvı yağı ve salçayı alalım bir iki dakika kavuralım.\n" +
                    "Naneyi ekleyelim ve kısa bir süre de bu şekilde kavuralım.\n" +
                    "Ardından sıcak su ilavesini yapalım ve birkaç dakika pişirerek, sosun bütünleşmesini sağlayalım.\n" +
                    "Fırından aldığımız mantıların üzerine, hazırladığımız sosu gezdirerek dökelim ve yemeğimizi tekrar 10-15 dakika fırına verelim.\n" +
                    "Üzeri için; yoğurt, rendelenmiş sarımsak ve tuzu çırpalım.\n" +
                    "Ayrı bir tavada, tereyağını eriterek, kırmızı toz biber yakalım.\n" +
                    "Pişen yemeğimizin üzerine, ilk sıcağı çıktıktan sonra; sarımsaklı yoğurt dökelim ve kırmızı biberli tereyağını gezdirelim. Afiyet olsun."),
        )
        val mainCoursesAdapter = MainCoursesAdapter(mainCourseList)

        mainCourseRV.adapter = mainCoursesAdapter

        val soupList = listOf(
            Meal("domates çorbası", R.drawable.domates_corbasi, "Domates çorbası yapmak için yağ ve un bir tencerede hafifçe kavrulur.\n" +
                    "Diğer taraftan kabuğu çıkarılıp, küp küp kesilmiş domates robottan geçirilip bu karışıma ilave edilir, birkaç dakika kavrulur.\n" +
                    "Ara verilmeden bir litre kadar su ilave edilip karıştırma işlemini sürdürülür. 15 dakika bu şekilde kaynatılır.\n" +
                    "Daha sonra süt ilave edilip birkaç dakika daha kaynatılarak tuzu ilave edilip ocaktan alınır.\n" +
                    "Arzuya göre servis yaparken üzerine kaşar peyniri rendesi ilave edilir. Domates çorbamız servise hazır, afiyet olsun.\n"),
            Meal("ezogelin çorbası", R.drawable.ezogelin_corbasi, "Tencereye tereyağı ve 1 yemek kaşığı sıvı yağ tencereye alınarak ısıtılır.\n" +
                    "Soğan ve sarımsak küçük küçük doğranır ve tencerede orta ateşte, soğanlar diriliğini kaybedinceye kadar kavrulur. Dilerseniz sarımsakları rendeleyerek de kullanabilirsiniz.\n" +
                    "Üzerine yıkanmış ve suyu süzülmüş olan kırmızı mercimek, pirinç ve bulgur eklenerek karıştırılır ve kavrulur.\n" +
                    "Üzerine sıcak su ilave edilerek tencerenin kapağı kapatılır ve pişmeye bırakılır. Çorba kaynayana kadar yüksek ateşte kaynadıktan sonra kısık ateşte ara ara karıştırılır.\n" +
                    "Bakliyatlar yumuşayınca kadar yaklaşık 35 dakika pişirilir ve ocak kapatılır.\n" +
                    "Ayrı bir yerde 2 yemek kaşığı sıvı yağ ısıtılır.\n" +
                    "1 yemek kaşığı un eklenir ve unun kokusu çıkana kadar karıştırılarak kavrulur.\n" +
                    "Üzerine 2 yemek kaşığı domates salçası eklenir, 1-2 dakika daha kavrulur.\n" +
                    "Salça da kavrulduktan sonra 2 su bardağı kadar su ilave edilerek kaynatılır.\n" +
                    "Nane, kırmızı biber, karabiber ilave edilerek hazırlanan sos ocaktan alınır ve çorbaya ilave edilir.\n" +
                    "Tuzu da eklenerek 1-2 dakika kaynatılır. Bu aşamada gerek duyarsanız sıcak su ekleyebilirsiniz. Ben 2,5 su bardağı kadar sıcak su ekledim ancak siz çorbanızın kıvamına göre ayarlayabilirsiniz.\n" +
                    "Yaklaşık 5 dakika daha kaynattıktan sonra Ezogelin Çorbamız servise hazır. Afiyet olsun."),
            Meal("mercimek çorbası", R.drawable.mercimek_corbasi, "Kırmızı mercimek çorbası için sıvı yağı tencereye alınarak yemeklik doğranan soğanlar hafif pembeleşinceye kadar kavrulur.\n" +
                    "Daha sonra un ilave edilerek kısık ateşte kavurmaya devam edilir.\n" +
                    "Salça kullanılacak ise salça ilave edilir, kavrulduktan sonra küp küp doğranmış havuç ve iyice yıkanıp suyu süzülen mercimekler ilave edilir.\n" +
                    "Üzerine su eklenerek karıştırılır ve tencerenin kapağı kapatılır. Çorbamız kaynayana kadar orta ateşte, kaynadıktan sonra mercimekler ve havuçlar yumuşayana kadar ara ara karıştırılarak kısık ateşte pişirilir.\n" +
                    "Çorba piştikten sonra el blenderı ile güzelce ezilir. Eğer blenderiniz yoksa süzgeçten de geçirebilirsiniz.\n" +
                    "Karabiber, tuz ve isteğe bağlı olarak kimyon eklenir ve karıştırılır. 5 dakika daha pişirelerek ocaktan alınır.\n" +
                    "Kıvamı koyu gelirse size, bir miktar su ilave edilerek bir taşım kaynatılır.\n" +
                    "Bu arada küçük bir tavaya iki yemek kaşığı tereyağı alınır, kızdırılır ve bir tatlı kaşığı kırmızı toz biber eklenerek ocaktan alınır.\n" +
                    "Mercimek çorbası servis kasesine alındıktan sonra üzerine kırmızı biberli sos gezdirilir ve bir dilim limon ile servis edilir."),
            Meal("sebze çorbası", R.drawable.sebzecorbasi, "Yıkayıp kabuklarını soyduğumuz kabak, havuç ve patatesleri küp küp doğrayalım ve defne yapraklarıyla beraber tencereye alalım. Bu tarifte önceden kabak dolması yapmak için oyduğunuz kabak içleriniz varsa onları da kullanabilirsiniz.\n" +
                    "Sebzelerin üzerine sıcak su ilave edelim ve yumuşayıncaya kadar pişmeye bırakalım.\n" +
                    "Ayrı bir tavada, tereyağı ve sıvı yağı eritelim.\n" +
                    "Üzerine un ekleyerek, birkaç dakika kavuralım.\n" +
                    "Karabiber ve kırmızı toz biberi de ekleyelim ve 1-2 dakika daha kavuralım, ateşten alalım.\n" +
                    "Tencereden defne yapraklarını alalım ve yumuşayan sebzeleri blenderdan geçirelim.\n" +
                    "Un ve baharatla kavurduğumuz yağı tencereye ekleyelim. Bu şekilde bir taşım daha kaynatalım.\n" +
                    "Son aşamada, çorbaya süt ilavesini yapalım ve birkaç dakika daha pişirelim.\n" +
                    "Tuzunu ekleyip, karıştıralım ve ocağı kapatalım.\n" +
                    "İsteğe bağlı olarak, çorbamız piştikten sonra içerisine ince kıyılmış dereotu ilavesi de yapabilirsiniz."),
        )
        val soupsAdapter = SoupsAdapter(soupList)

        soupRV.adapter = soupsAdapter

        searchView = findViewById(R.id.searchView)

        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                dessertsAdapter.filterData(dessertList.filter { meal ->
                    meal.mealName.contains(newText)
                })
                saladsAdapter.filterData(saladList.filter { meal ->
                    meal.mealName.contains(newText)
                })
                mainCoursesAdapter.filterData(mainCourseList.filter { meal ->
                    meal.mealName.contains(newText)
                })
                soupsAdapter.filterData(soupList.filter { meal ->
                    meal.mealName.contains(newText)
                })
                return true
            }
        })

    }

}