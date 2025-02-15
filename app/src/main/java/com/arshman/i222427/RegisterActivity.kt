package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Typeface


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val tvLogin = findViewById<TextView>(R.id.tvLogin)
        val fullText = "Already have an account? Login"
        val spannableString = SpannableString(fullText)

        val startIndex = fullText.indexOf("Login")
        val endIndex = startIndex + "Login".length

// Manually force brown color (bypasses theme)
        val brownColor = 0xFF8B5E3C.toInt()
        spannableString.setSpan(
            ForegroundColorSpan(brownColor),
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

// Make "Login" bold
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

// Make "Login" clickable
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false  // Remove underline
                ds.color = brownColor  // Force brown again here
            }
        }
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

// Apply to TextView
        tvLogin.text = spannableString
        tvLogin.movementMethod = LinkMovementMethod.getInstance()

    }
}
