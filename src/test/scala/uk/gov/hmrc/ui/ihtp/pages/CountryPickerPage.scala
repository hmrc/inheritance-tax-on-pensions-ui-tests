/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.ihtp.pages

import uk.gov.hmrc.selenium.webdriver.Driver
import org.openqa.selenium.Keys

import org.openqa.selenium.By

object CountryPickerPage extends BasePage {

  override val pageUrl: String =
    ".*/lookup-address/.../country-picker"

  def verifyPage(): Unit =
    verifyPageLoadedContains("/country-picker")

  override val pageTitle: String =
    "Select the country or territory - Report inheritance tax on a pension - GOV.UK"

  def SaveAndContinueButton(): Unit =
    clickSaveAndContinueButton()

  def clickRadioButton(text: String): Unit =
    text match {
      case "Yes" => click(By.id("value_0"))
      case "No"  => click(By.id("value_1"))
    }

  def enterCountry(textToEnter: String): Unit = {

    val input = Driver.instance.findElement(By.id("countryCode"))

    input.clear()
    input.sendKeys(textToEnter)

    input.sendKeys(Keys.DOWN)
    input.sendKeys(Keys.ENTER)
  }

}
