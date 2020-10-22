package co.hadam.todayquote

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.random.Random

class QuoteMainActivity : AppCompatActivity() {
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quote_activity_main)

        // 뷰 받아오기
        val quoteText = findViewById<TextView>(R.id.quote_text)
        val quoteFrom = findViewById<TextView>(R.id.quote_from)

        // 프리퍼런스 객체 가져오기 (파일 이름은 quotes)
        pref = this.getSharedPreferences("quotes", Context.MODE_PRIVATE)

//        // 수정 가능한 Quote를 저장할 리스트 객체 생성 및 명언 객체 3개 넣어보기
//        var quotes = mutableListOf<Quote>()
//        quotes.add(Quote(1, "명언 내용 1", "출처 1"))
//        quotes.add(Quote(2, "명언 내용 2", "출처 2"))
//        quotes.add(Quote(3, "명언 내용 3", "출처 3"))
//
//        var randomIndex = Random.nextInt(0, 3)
//        var randomQuote = quotes[randomIndex]
//        // var randomQuote = quotes.get(randomIndex)
//
//        // 뷰 객체를 이용해서 출력
//        quoteText.text = randomQuote.text
//        quoteFrom.text = randomQuote.from
//
//        val sp = this.getSharedPreferences("quotes", Context.MODE_PRIVATE)
//        val editor = sp.edit()
//        editor.putInt("key1", 1)
//        editor.putString("key2", "Hello")
//        editor.putBoolean("make_alarm", true)
//        editor.putInt("volumn", 100)
//
//        editor.putString("key2", "World")
//        editor.apply()
//
//        var value1 = sp.getInt("key1", -1)
//        var value2 = sp.getString("key2", null)
    }
}