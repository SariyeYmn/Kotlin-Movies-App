package com.example.movies_app.Activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.RequestQueue
import com.example.movies_app.Adapter.FilmAdapter
import com.example.movies_app.Domain.DetailDomain
import com.example.movies_app.Domain.Film
import com.example.movies_app.R
import com.example.movies_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val filmList = listOf(
            Film(1,"Avatar","avatar3","12000","02:54:00","2016","Film Na’vi adlı yok olmak üzere olan bir halkın yaşadığı Pandora adlı gezegende geçiyor. Yarı-felçli bir savaş gazisi olan Jake Sully, kendilerine özgü dilleri ve kültürü olan, barış ve doğa ile örtülü bir çevrede yaşayan Na’vi halkının arasına gönderilir. Gezegendeki değerli enerji kaynaklarını elde etmelerine mani olarak görülen Na’vi halkının arasına sızmakla görevlendirilen Jake, güzel bir Na’vi olan Neytiri tarafından hayatı kurtarılınca her şey değişir.","Sam Worthington, Zoe Saldana, Sigourney Weaver, Michelle Rodriquez",
                listOf(DetailDomain(R.drawable.actor1),DetailDomain(R.drawable.actor4),DetailDomain(R.drawable.actor2),DetailDomain(R.drawable.actor3))),
            Film(2,"Supernatural","supernatural3","5005","02:54:00","2005","Dizi Dean Winchester ve Sam Winchester kardeşlerin babalarının kayıp olmasından sonra tekrar bir araya gelip Sam'in bıraktığı avcılığa geri dönmesiyle başlar. İki kardeş hayatlarını babaları ile beraber, annelerinin küçükken bir iblisin (Azazel) yakarak öldürmesi sonucu insanları bu gibi varlıklardan korumaya adamışlardır. Fakat avcılık ile uğraşmak istemeyen ve normal bir yaşam sürmek isteyen Sam babası ile tartışarak evi terk etmiştir. Yıllarca abisi ve babasından ayrı yaşayan Sam, üniversitede eğitim görmüş, Jessica isminde bir kız ile evlenme aşamasına gelmiştir. Üniversiteden mezun oldukları gece uzun zamandır görmediği abisi Dean, babasının birkaç haftadır kayıp olduğunu ve yardımına ihtiyacı olduğunu söyler. Sam babasını bulmak için son bir kez abisinin yardımına gider. Babasını arayışları netice vermeyince Dean ona yeniden avcılığa dönmesi için teşvik eder fakat Sam kabul etmez. Aynı gece Sam eve dönünce, nişanlısı Jessica'nın annesi gibi tavana yapıştığını görür. Müdahale etmesine fırsat kalmadan Jessica'nın alevler içinde kalarak ölmesine tanık olur. Bunun üzerine Sam, hem insanları bu gibi yaratıklardan kurtarmak için hem de annesini ve nişanlısını öldüren iblisi (Azazel) bulup yok etmek için yeniden avcılık yapmaya başlar.","Jensen Ackles, Jared Padalecki, Misha Collins, Alexander Calvert",listOf(DetailDomain(R.drawable.dean),DetailDomain(R.drawable.sam),DetailDomain(R.drawable.castiel),DetailDomain(R.drawable.jack))),
            Film(3,"Seven","seven","1000","02:54:00","1995","Cinayet masasından iki dedektif bir seri katilin peşine düşer. Bu katil, cinayetleri dünyayı yedi ölümcül günahtan temizlemek için işlemektedir. Bu günahları işleyenlerden bir liste yapan katil, kendini tanrının görevlisi sayar ve kurbanlarını acımasızca öldürür.","Brad Pitt, Morgen Freeman, Kevin Spacey, Gwyneth Paltrow",listOf(DetailDomain(R.drawable.brad),DetailDomain(R.drawable.morgen),
                DetailDomain(R.drawable.kevin),DetailDomain(R.drawable.gwyneth))),
            Film(4,"Sihirbazlar Çetesi","eye","1500","02:54:00","2013","'Now You See Me', Atlas isimli son derece karizmatik ve etkileyici bir illüzyonistin liderliğini yaptığı, dünyanın en iyi sihirbazlarından oluşan 'Four Horsemen' ekibinin başından geçenleri konu alıyor. Ekip üstün sihir marifetlerini sadece sahne gösterileri için değil, soygun yaptıkları bankaların sistemlerine erişmek ve izleyicilerini soymak için kullanıyorlar. Bu adamlar izleyicileri önce başka bir kıtadaki bir bankayı soyarak, daha sonra beyaz yakalı bir suçlunun bankadaki milyon dolarlarını izleyicilerin banka hesaplarına aktararak şaşırtıyorlar. Bunun üzerine onları durdurmaya kararlı olan özel FBI ajanı Dylan bu çetenin peşine düşer ...","Mark Ruffalo, Morgan Freeman, Dave Franco, Jesse Eisenberg, Woody Harrelson, Isla Fisher  ", listOf(DetailDomain(R.drawable.mark),DetailDomain(R.drawable.morgen),DetailDomain(R.drawable.dave),DetailDomain(R.drawable.jesse),DetailDomain(R.drawable.woody),DetailDomain(R.drawable.isla)))
        )

        val upcomingFilmlist = listOf(
            Film(2,"Supernatural","supernatural3","5005","02:54:00","2005","Dizi Dean Winchester ve Sam Winchester kardeşlerin babalarının kayıp olmasından sonra tekrar bir araya gelip Sam'in bıraktığı avcılığa geri dönmesiyle başlar. İki kardeş hayatlarını babaları ile beraber, annelerinin küçükken bir iblisin (Azazel) yakarak öldürmesi sonucu insanları bu gibi varlıklardan korumaya adamışlardır. Fakat avcılık ile uğraşmak istemeyen ve normal bir yaşam sürmek isteyen Sam babası ile tartışarak evi terk etmiştir. Yıllarca abisi ve babasından ayrı yaşayan Sam, üniversitede eğitim görmüş, Jessica isminde bir kız ile evlenme aşamasına gelmiştir. Üniversiteden mezun oldukları gece uzun zamandır görmediği abisi Dean, babasının birkaç haftadır kayıp olduğunu ve yardımına ihtiyacı olduğunu söyler. Sam babasını bulmak için son bir kez abisinin yardımına gider. Babasını arayışları netice vermeyince Dean ona yeniden avcılığa dönmesi için teşvik eder fakat Sam kabul etmez. Aynı gece Sam eve dönünce, nişanlısı Jessica'nın annesi gibi tavana yapıştığını görür. Müdahale etmesine fırsat kalmadan Jessica'nın alevler içinde kalarak ölmesine tanık olur. Bunun üzerine Sam, hem insanları bu gibi yaratıklardan kurtarmak için hem de annesini ve nişanlısını öldüren iblisi (Azazel) bulup yok etmek için yeniden avcılık yapmaya başlar.","Jensen Ackles, Jared Padalecki, Misha Collins, Alexander Calvert",listOf(DetailDomain(R.drawable.dean),DetailDomain(R.drawable.sam),DetailDomain(R.drawable.castiel),DetailDomain(R.drawable.jack))),
            Film(3,"Seven","seven","1000","02:54:00","1995","Cinayet masasından iki dedektif bir seri katilin peşine düşer. Bu katil, cinayetleri dünyayı yedi ölümcül günahtan temizlemek için işlemektedir. Bu günahları işleyenlerden bir liste yapan katil, kendini tanrının görevlisi sayar ve kurbanlarını acımasızca öldürür.","Brad Pitt, Morgen Freeman, Kevin Spacey, Gwyneth Paltrow",listOf(DetailDomain(R.drawable.actor1),DetailDomain(R.drawable.actor1))),
            Film(1,"Sihirbazlar Çetesi","eye","1500","02:54:00","2013","'Now You See Me', Atlas isimli son derece karizmatik ve etkileyici bir illüzyonistin liderliğini yaptığı, dünyanın en iyi sihirbazlarından oluşan 'Four Horsemen' ekibinin başından geçenleri konu alıyor. Ekip üstün sihir marifetlerini sadece sahne gösterileri için değil, soygun yaptıkları bankaların sistemlerine erişmek ve izleyicilerini soymak için kullanıyorlar. Bu adamlar izleyicileri önce başka bir kıtadaki bir bankayı soyarak, daha sonra beyaz yakalı bir suçlunun bankadaki milyon dolarlarını izleyicilerin banka hesaplarına aktararak şaşırtıyorlar. Bunun üzerine onları durdurmaya kararlı olan özel FBI ajanı Dylan bu çetenin peşine düşer ...","Mark Ruffalo, Morgan Freeman, Dave Franco, Jesse Eisenberg, Woody Harrelson, Isla Fisher  ", listOf(DetailDomain(R.drawable.actor1),DetailDomain(R.drawable.actor1)))
        )

        val newFilmAdapter = FilmAdapter(this,filmList)
        val upcomingFilmAdapter = FilmAdapter(this,upcomingFilmlist)

        binding.apply{
            recyclerView1.adapter = newFilmAdapter
            recyclerView1.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

            recyclerView2.adapter = upcomingFilmAdapter
            recyclerView2.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

            image2.setOnClickListener {
                val intent = Intent(this@MainActivity,FavoriteActivity::class.java)
                startActivity(intent)
            }

            image5.setOnClickListener {
                val intent = Intent(this@MainActivity,ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }

}