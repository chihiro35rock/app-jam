package app.mita.chatamin.Mochitsuki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //残り秒数を10秒にセット
    var second = 10

    // 餅つき回数を数える変数を準備する
    var mochitsukiCount=0

    //タイマーを設定する
    var timer :CountDownTimer = object : CountDownTimer(10000,1000) {

        //タイマーが終了する時に呼ばれる
        override fun onFinish() {
            //結果画面へ移動する準備をする
            val resultIntent: Intent = Intent(this@MainActivity, ResultActivity::class.java)
            // 餅つき回数をセットする
            resultIntent.putExtra("MochitsukiCount",mochitsukiCount)
            //結果画面に移動する
            startActivity(resultIntent)


        }

        //一秒ごとに呼ばれる
        override fun onTick(millisUntilFinished: Long){
            //餅つきボタンをピンク色にセット
            mochitsukiButton.setBackgroundResource(R.drawable.background_rounded_circle)
            //残り秒数にマイナス1をする
            second = second - 1
            //残り数字をテキストビューに反映する
            secondText.text = second.toString()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //STARTボタンがタップされた時に
        startButton.setOnClickListener {
            //餅つき回数をテキストビューに反映する
            countText.text = mochitsukiCount.toString()
            //STARTボタンを見えない状態にする
            startButton.isVisible = false

            //タイマーを開始する
            timer.start()
        }

        // 餅つきボタンがタップされた時に
        mochitsukiButton.setOnClickListener{

            //残り秒数が10秒より少ないときに
            if (second < 10) {

                // 餅つき回数の変数にプラス1する
                mochitsukiCount = mochitsukiCount + 1

                // 餅つき回数をテキストビューに反映する
                countText.text = mochitsukiCount.toString()

            }

        }

    }
}