package com.okugata.sintaksys.core.utils

import java.util.regex.Pattern

object StringUtils {
    fun addPunctuation(withPunctuation: String, withoutPunctuation: String): String {
        val before = withPunctuation.replace("\n","\n ")
        val wordsBefore = before.split(" ")
        val wordsAfter = withoutPunctuation.split(" ")

        if (wordsAfter.size == wordsBefore.size) {
            val sb = StringBuilder()
            for (i in wordsBefore.indices) {
                sb.append(wordsAfter[i])
                if (Pattern.matches("\\p{Punct}", wordsBefore[i])) {
                    sb.append(wordsBefore[i].last())
                }
                if (wordsBefore.contains("\n")) {
                    sb.append("\n")
                }
                sb.append(" ")
            }
            return sb.deleteCharAt(sb.length-1).toString()
        }
        return withoutPunctuation
    }

    fun mergeCorrectedTextInHtml(stringBefore: String, stringAfter: String): String {
        val before = stringBefore.split(" ")
        val after = stringAfter.split(" ")

        if (before.size == after.size) {
            val sb = StringBuilder()
            for (i in after.indices) {
                if (before[i] != after[i]) {
                    sb.append("<span style='background-color:#d95975;'>")
                        .append(before[i])
                        .append("</span> ")
                        .append(newLineToBr(after[i]))
                }
                else {
                    sb.append(newLineToBr(after[i]))
                }
                sb.append(" ")
            }
            return sb.deleteCharAt(sb.length-1).toString()
        }
        return stringAfter
    }

    fun newLineToBr(string: String) =
        string.replace("\n","<br/>")
}