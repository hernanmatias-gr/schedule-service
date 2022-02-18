package com.inmarket.schedule.utils

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringExtensionsTest : StringSpec({

    "strings.camelToSnakeCase should return string converted if theres camelCase" {
        "aStringWithCamelCase".camelToSnakeCase() shouldBe "a_string_with_camel_case"
    }

    "strings.camelToSnakeCase should return equal string if no camelcase" {
        "a_string_with_camel_case".camelToSnakeCase() shouldBe "a_string_with_camel_case"
    }
})
