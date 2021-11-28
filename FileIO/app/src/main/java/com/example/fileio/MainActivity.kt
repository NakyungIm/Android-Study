package com.example.fileio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fileio.databinding.ActivityMainBinding
import java.io.*

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        with(binding) {
            val directory_name = "memo"
            val filename = "memo01.txt"
            btnSave.setOnClickListener {
                val content = textWrite.text.toString()
                writeTextFile(directory_name, filename, content)
            }

            val path = directory_name + "/" + filename
            val writtenContent = readTextFile(path)
            textRead.text = writtenContent
        }
    }

    fun readTextFile(path: String): String {
        val fullpath = File(filesDir.path + "/" + path) // path에는 디렉토리, 파일명을 넘겨줌
        if(!fullpath.exists()) return ""

        val reader = FileReader(fullpath)
        val buffer = BufferedReader(reader)

        val result = StringBuilder() // or StringBuffer(), 속도는 builder가 빠르고, buffer는 동시성을 지원
        var temp:String? = ""
        while(true){
            temp = buffer.readLine()
            if(temp == null) break
            result.append(temp).append("\n") // 버퍼에 추가. 더이상 읽을 수 없으면 빠져나감
       }
        buffer.close()
        reader.close()
        return result.toString()
    }

    fun writeTextFile(directory: String, filename: String, content: String){
        // 앱 기본경로/files/memo
        val dir = File(filesDir.path + "/" + directory) // 이름만 넘겨주면 파일 생성. dir : 파일 존재 여부
        if(!dir.exists()) dir.mkdirs()

        // 파일을 사용하기 위한 스트림 열기
        val fullpath = dir.path + "/" + filename
        val writer = FileWriter(fullpath)
        val buffer = BufferedWriter(writer) // 속도를 빠르기 하기 위해 buffer 사용
        buffer.write(content)
        buffer.close()
        writer.close()
   }
}