package com.zzazzu.intent_200830

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

 // 1000이라는 숫자만 봐서는 => 닉네임 받는 요청이다라는 사실을 인지하기 힘들다.
    val REQUEST_FOR_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToOtherActivityBtn.setOnClickListener {

            val myIntent = Intent(this, other::class.java)
            startActivity(myIntent)

        }

        sendMessageBtn.setOnClickListener {

            val inputMessage = messageEdt.text.toString()

            val myIntent = Intent(this,  message::class.java)

            myIntent.putExtra("message", inputMessage)

            startActivity(myIntent)
        }

        // 닉네임 변경 버튼이 눌리면

        changeNickNameBtn.setOnClickListener {

            // 닉네임입력화면으로 이동(입력 결과를 받으러 가는것임)

            val myIntent = Intent(this, EditNickNameActivity::class.java)

            // (닉네임 입력 결과를 받으러 간다. => 1000 숫자로 대신 표기) 결과를 받으러 간다고 별도로 명시
            // 1000 대신 => 멤버 변수로 만들어둔 REQUEST_FOR_NICKNAME를 활용, 가독성 향

            startActivityForResult(myIntent, REQUEST_FOR_NICKNAME)
 // 요건 왕복
        }

//          Dial 액션 예제

        dialBtn.setOnClickListener{

//          입력한 폰번 받아오기
        val inputPhoneNum = phoneNumEdt.text.toString()

        val myUri = Uri.parse("tel:${inputPhoneNum}")
        val myIntent = Intent(Intent.ACTION_DIAL, myUri)
        startActivity(myIntent)

        }

//          Call 액션 예제

        callBtn.setOnClickListener{

        val inputPhoneNum = phoneNumEdt.text.toString()

        val myUri = Uri.parse("tel:$(inputPhoneNum}")
        val myIntent = Intent(Intent.ACTION_CALL, myUri)
        startActivity(myIntent)




        }


    }



//  결과를 가지고 돌아올 때 실행되는 함수.
//  닉네임 / 이메일 / 폰번 등 모든 입력 결과각 다 이 함수에서 실행됨.


        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

//          닉네임을 가지러 갔다가 오는 길인가?

            if (requestCode == REQUEST_FOR_NICKNAME) {

//              ok를 누른게 맞나? (취소를 누르면 아무 일도 x)

                if (resultCode == Activity.RESULT_OK) {

//                  둘 다 맞아야만 닉네임을 (다른 화면에서 입력해준 값으로) 변경처리.

                val newNickName = data?.getStringExtra("nick")

                nickNameTxt.text = newNickName

                }

            }


    }
}