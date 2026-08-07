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

object EnterNationalInsuranceNumberPage extends BasePage {
  override val pageUrl: String   = s"$baseUrl/enter-ni-number"
  override val pageTitle: String =
    "Enter the National Insurance number of the deceased - Report Inheritance Tax on a pension - GOV.UK"
  val pageHeading: String        = "Enter the National Insurance number of Joe Doe"

  def verifyPageHeading(): Boolean =
    getPageSource.contains(pageHeading)

  def clickRadioButton(text: String): Unit = {
    text match {
      case "Yes" => click(By.id("value"))
      case "No"  => click(By.id("value-no"))
    }
    clickSaveAndContinueButton()
  }

  def addNino(adding: Boolean): Unit = {
    checkURL()
    if (adding) clickRadioButton("Yes")
    else clickRadioButton("No")
    clickSaveAndContinueButton()
  }

  def enterNINO(textToEnter: String): Unit = {
    checkURL()
    enterText("value", textToEnter)
    clickSaveAndContinueButton()
  }

  def enterReason(textToEnter: String): Unit = {
    checkURL()
    enterText("reasonForNoNino", textToEnter)
    clickSaveAndContinueButton()
  }

}
