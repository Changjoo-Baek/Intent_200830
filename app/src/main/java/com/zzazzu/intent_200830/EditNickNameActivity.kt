package com.zzazzu.intent_200830

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        okBtn.setOnClickListener{

// 입력한 닉네임 받아오기

            val inputNickName = nickNameEdt.text.toString()

            // 입력한 닉네임을 가지고
            // 입력값을 담기 위한 용도의 Intent 생성

            val resultIntent = Intent()

            // 복귀한 Intent에는 입력값을 resultIntent에 첨부

            resultIntent.putExtra("nick", inputNickName)

            setResult(Activity.RESULT_OK, resultIntent)
            // 완료로 나가는거랑 취소로 나가는 거랑은 다르다.


            // 메인 화면으로 복귀

            finish()

        }


    }
}