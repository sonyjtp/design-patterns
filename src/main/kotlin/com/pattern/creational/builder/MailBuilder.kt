package com.pattern.creational.builder

/**
 * Builder pattern
 */

class MailBuilder {
    private var _recipients = listOf<String>()
    private var _cc = listOf<String>()
    private var _subject = ""
    private var _message = ""
    private var _important = false

    class Mail internal constructor(
        val recipients: List<String>,
        val cc: List<String>,
        val subject: String,
        val message: String,
        val important: Boolean
    )

    fun build(): Mail {
        if (_recipients.isEmpty()) throw MailException("Cannot create an email without recipients")
        return Mail(_recipients, _cc, _subject, _message, _important)
    }

    fun addRecipients(recipients: List<String>) = apply { _recipients = recipients }

    fun addCc(cc: List<String>) = apply { _cc = cc }

    fun addSubject(subject: String) = apply { _subject = subject }

    fun addMessage(message: String) = apply { _message = message }

    fun setImportance(important: Boolean) = apply { _important = important }
}


class MailException(override val message: String) : RuntimeException(message)
