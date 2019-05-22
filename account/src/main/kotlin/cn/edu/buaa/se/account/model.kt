package cn.edu.buaa.se.account

import org.springframework.format.annotation.DateTimeFormat
import java.util.*

const val SUCCESS = 0
const val USER_EXISTS = 11
const val UNKNOWN_USER = 12
const val WRONG_PASSWORD = 13
const val SAME_PASSWORD = 14
const val UNKNOWN_EXPERT = 21

interface IResponseBody<T> {
    var errcode: Int
    var msg: String
    var date: Date
    var data: T
}

data class ResponseBody<T>(
        override var errcode: Int = 0,
        override var msg: String = "",
        override var date: Date = Date(),
        override var data: T
) : IResponseBody<T>

data class RpUser(
        var id: Long = 0,
        var username: String = "",
        var email: String = "",
        var credit: Int = 0,
        var frozenCredit: Int = 0
)

data class RqNewUser(
        val username: String,
        val password: String,
        val email: String
)

data class RqPassword(
        val password: String,
        val newpassword:String
)

data class RpExpert(
        var subject: String="",
        var education:String="",
        var introduction:String=""
)

data class RqFollow(
        var followed:Long,
        var time:Date=Date()
)