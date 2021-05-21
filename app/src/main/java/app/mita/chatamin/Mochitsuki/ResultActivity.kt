package app.mita.chatamin.Mochitsuki

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // メイン画面から餅つき回数を受け取る
        val countText : Int = intent.getIntExtra("MochitsukiCount",0)
        // 餅つき回数をTextViewに反映する
        countResultText.text = "$countText"
        // 美味しい＆まずいイラストを非表示にする
        oishiiImage.isVisible = false
        mazuiImage.isVisible = false

        // 餅つき回数で
        if (countText < 70){
            // "餅はまずかった…"と表示する
            mochitsukiResultText.text = "餅はまずかった…"
            // まずいイラストを表示する
            mazuiImage.isVisible = true
            countResultText.setTextColor(Color.BLUE)
            } else {
                // "餅は美味しくできた"と表示する
            mochitsukiResultText.text = "餅は美味しくできた！"
            oishiiImage.isVisible = true
            countResultText.setTextColor(Color.RED)
        }

        //RETRYボタンがタップされたら
        retryButton.setOnClickListener {
            // メイン画面へ移動する準備をする
            val gameIntent: Intent = Intent (this,MainActivity::class.java)
            // メイン画面に移動する
            startActivity(gameIntent)
        }

    }
}