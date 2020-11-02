package co.hadam.todayquote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class QuoteEditAdapter(private val dataList: List<Quote>) :
    RecyclerView.Adapter<QuoteEditAdapter.QuoteItemViewHolder>()
{
    class QuoteItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        lateinit var quote: Quote
        val quoteTextEdit = view.findViewById<EditText>(R.id.quote_text_edit)
        val quoteFromEdit = view.findViewById<EditText>(R.id.quote_from_edit)
        val quoteDeleteBtn = view.findViewById<Button>(R.id.quote_delete_btn)
        val quoteModifyBtn = view.findViewById<Button>(R.id.quote_modify_btn)

        init {
            val pref = view.context.getSharedPreferences("quotes", Context.MODE_PRIVATE)

            quoteDeleteBtn.setOnClickListener {
                quoteTextEdit.setText("")
                quoteFromEdit.setText("")
                quote.text = ""
                quote.from = ""
                val pos = this.adapterPosition
                Quote.removeQuoteFromPreference(pref, pos)
                Toast.makeText(view.context, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
            }
            quoteModifyBtn.setOnClickListener {
                quote.text = quoteTextEdit.text.toString()
                quote.from = quoteFromEdit.text.toString()
                val pos = this.adapterPosition
                Quote.saveToPreference(pref, pos, quote.text, quote.from)
                Toast.makeText(view.context, "수정되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(q: Quote) {
            quote = q
            quoteTextEdit.setText(quote.text)
            quoteFromEdit.setText(quote.from)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(viewType, parent, false)

        return QuoteItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteItemViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.quote_edit_list_item
    }

}