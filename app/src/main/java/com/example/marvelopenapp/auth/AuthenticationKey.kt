package com.example.marvelopenapp.auth

import com.example.marvelopenapp.extensions.md5
import com.example.marvelopenapp.utils.DateUtils


class AuthenticationKey {
    companion object {
        val publicKey = ""
        val privateKey = ""


        fun getHash(): String {
            return "${DateUtils.getTimeMillisNow()}$privateKey$publicKey".md5()
        }
    }
}