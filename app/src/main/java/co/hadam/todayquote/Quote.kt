package co.hadam.todayquote

// 데이터 클래스 정의
// data class Person(var name:String, var age:Int, val gender:String)
// 데이터 클래스 이름: Quote
// 받아야 할 속성 이름 (idx, text, from)
// idx는 저장된 위치를 저장할 정수, text는 명언 내용, from은 출처
data class Quote (
    var idx : Int,
    var text : String,
    var from : String
)