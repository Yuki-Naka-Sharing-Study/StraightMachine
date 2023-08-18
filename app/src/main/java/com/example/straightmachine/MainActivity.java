package com.example.straightmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 使うブロックを決めて名前を付ける
    Button button, button2, button3, button4, button5, button6; //ボタン
    SoundPool soundPool; // 効果音を出す道具 (クラス) である SoundPool
    int sound, sound2, sound3, sound4, sound5, sound6; // サウンドID
    int id; // 押されたボタンのリソースidを入れる整数の箱


    // onCreateメソッド → アプリが開いた時にやることを書く場所
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // おまじないの２行
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // レイアウトとJavaファイルの結び付け
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        // ボタンにクリックリスナーを付ける
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    protected void onResume(){
        // おまじない
        super.onResume();

        // soundPoolをインスタンス化 (たこ焼きにする)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .build())
                    .setMaxStreams(1)
                    .build();
        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }

        // 効果音ファイルをrawフォルダからメモリにロードしてサウンドIDをゲットする
        sound = soundPool.load(this, R.raw.fugoukakudesu, 1);
        sound2 = soundPool.load(this, R.raw.gannbattane, 2);
        sound3 = soundPool.load(this, R.raw.goukakudesu, 3);
        sound4 = soundPool.load(this, R.raw.omedetou, 4);
        sound5 = soundPool.load(this, R.raw.sugoisugoi, 5);
        sound6 = soundPool.load(this, R.raw.zannnen, 6);
    }

    @Override
    protected void onPause(){
        // おまじない
        super.onPause();

        // 使い終わった効果音ファイルを後片付け
        soundPool.release();
    }

    // onClickメソッド → ボタンが押された時にやることを書く場所
    @Override
    public void onClick(View view) {

        // 押されたボタンのリソースidを取得してidに入れる
        id = view.getId();

        // 押されたボタンに対応する音を出す
        if (id == R.id.button) {
            soundPool.play(sound, 1.0f, 1.0f, 0, 0, 1.0f);
        } else if (id == R.id.button2) {
            soundPool.play(sound2, 1.0f, 1.0f, 0, 0, 1.0f);
        } else if (id == R.id.button3) {
            soundPool.play(sound3, 1.0f, 1.0f, 0, 0, 1.0f);
        } else if (id == R.id.button4) {
            soundPool.play(sound4, 1.0f, 1.0f, 0, 0, 1.0f);
        } else if (id == R.id.button5) {
            soundPool.play(sound5, 1.0f, 1.0f, 0, 0, 1.0f);
        } else if (id == R.id.button6) {
            soundPool.play(sound6, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }
}