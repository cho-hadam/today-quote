package co.hadam.todayquote

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class QuoteMainActivity : AppCompatActivity() {
    private lateinit var pref: SharedPreferences
    private lateinit var quotes: List<Quote>

    fun initializeQuotes() {
        val initialized = pref.getBoolean("initialized", false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quote_activity_main)

        // 뷰 받아오기
        val quoteText = findViewById<TextView>(R.id.quote_text)
        val quoteFrom = findViewById<TextView>(R.id.quote_from)

        // 프리퍼런스 객체 가져오기 (파일 이름은 quotes)
        pref = this.getSharedPreferences("quotes", Context.MODE_PRIVATE)

        // 필요한 기본 명언 초기화
        initializeQuotes()

        // 20개의 명언 가져오기
        quotes = Quote.getQuotesFromPreference(pref)

        // 명언이 있다면
        if(quotes.isNotEmpty()) {
            val randomIdx = Random.nextInt(quotes.size)
            val randomQuote = quotes[randomIdx]
            quoteText.text = randomQuote.text
            quoteFrom.text = randomQuote.from
        } else {
            // 없다면
            quoteText.text = "저장된 명언이 없습니다."
            quoteFrom.text = ""
        }

        val toQuoteListBtn = findViewById<Button>(R.id.quote_list_btn)
        toQuoteListBtn.setOnClickListener {
            val intent = Intent(this, QuoteListActivity::class.java)
            intent.putExtra("quote_size", quotes.size)
            startActivity(intent)
        }

        val toQuoteEditBtn = findViewById<Button>(R.id.quote_edit_btn)
        toQuoteEditBtn.setOnClickListener {
            val intent = Intent(this, QuoteEditActivity::class.java)
            startActivity(intent)
        }



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