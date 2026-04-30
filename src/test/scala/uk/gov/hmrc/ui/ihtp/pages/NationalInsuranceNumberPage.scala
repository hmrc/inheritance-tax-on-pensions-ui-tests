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

import org.openqa.selenium.By
import uk.gov.hmrc.ui.ihtp.pages.EnterBirthDeathPage.{checkURL, clickSaveAndContinueButton}

object NationalInsuranceNumberPage extends BasePage {
  val pageUrl: String     = s"$baseUrl/ni-or-reason"
  val pageTitle: String   =
    "Does the deceased have a National Insurance number? - Report inheritance tax on a pension - GOV.UK"
  val pageHeading: String = ""

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(): Boolean =
    getTitle == pageTitle

  def verifyPageHeading(): Boolean =
    getPageSource.contains(pageHeading)

  def SaveAndContinueButton(): Unit = {
    checkURL
    clickSaveAndContinueButton()
  }

  def clickRadioButton(text: String): Unit =
    text match {
      case "Yes" => click(By.id("value_0"))
      case "No"  => click(By.id("value_1"))
    }

  def addNino(adding: Boolean): Unit = {
    checkURL
    if (adding) clickRadioButton("Yes")
    else clickRadioButton("No")
    clickSaveAndContinueButton()
  }

  def enterReason(textToEnter: String): Unit = {
    checkURL
    enterText("reasonForNoNino", textToEnter)
    clickSaveAndContinueButton()
  }

}
