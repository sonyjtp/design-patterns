package com.pattern.creational.builder

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class MailBuilderTest : FunSpec({
    test("test MailBuilder") {
        val mailBuilder = MailBuilder()
        val exception = shouldThrow<MailException> {
            mailBuilder.build()
        }
        exception.message shouldBe "Cannot create an email without recipients"
        mailBuilder.addRecipients(listOf("a@b.com"))
        mailBuilder.addCc(listOf("abc@xyz.com", "xyz@abc.com"))
        mailBuilder.addMessage("email message")
        mailBuilder.setImportance(true)
        mailBuilder.addSubject("subject")
        val mail = mailBuilder.build()
        mail.shouldBeInstanceOf<MailBuilder.Mail>()
        mail.recipients shouldBe listOf("a@b.com")
        mail.cc shouldBe listOf("abc@xyz.com", "xyz@abc.com")
        mail.subject shouldBe "subject"
        mail.message shouldBe "email message"
        mail.important shouldBe true

    }

})
