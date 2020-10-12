package co.hadam.todayquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.random.Random

class QuoteMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quote_activity_main)

        // 뷰 받아오기
        val quoteText = findViewById<TextView>(R.id.quote_text)
        val quoteFrom = findViewById<TextView>(R.id.quote_from)

        // 수정 가능한 Quote를 저장할 리스트 객체 생성 및 명언 객체 3개 넣어보기
        var quotes = mutableListOf<Quote>()
        quotes.add(Quote(1, "명언 내용 1", "출처 1"))
        quotes.add(Quote(2, "명언 내용 2", "출처 2"))
        quotes.add(Quote(3, "명언 내용 3", "출처 3"))
    }
}