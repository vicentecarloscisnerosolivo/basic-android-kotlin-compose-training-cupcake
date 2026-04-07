package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.cupcake.ui.SelectOptionScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {
    @get:Rule
    val composableTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun selectOptionsScreen_verifyContent() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        composableTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }

        flavors.forEach { flavor ->
            composableTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        composableTestRule.onNodeWithText(
            composableTestRule.activity.getString(
                com.example.cupcake.R.string.subtotal_price, subtotal
            )
        ).assertIsDisplayed()

        composableTestRule.onNodeWithStringId(com.example.cupcake.R.string.next)
            .assertIsNotEnabled()
    }
}