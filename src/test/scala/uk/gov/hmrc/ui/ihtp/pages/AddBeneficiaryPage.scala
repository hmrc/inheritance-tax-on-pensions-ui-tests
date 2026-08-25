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
import uk.gov.hmrc.ui.ihtp.pages.EnterBirthDeathPage.clickSaveAndContinueButton

object AddBeneficiaryPage extends BasePage {
  override val pageUrl: String   = s"$baseUrl/add-beneficiary"
  override val pageTitle: String =
    "You have added 1 beneficiary - Report Inheritance Tax on a pension - GOV.UK"
  val pageHeading: String        = "You have added 1 beneficiary"

  def verifyPageHeading(): Boolean =
    getPageSource.contains(pageHeading)

  def clickRadioButton(text: String): Unit = {
    text match {
      case "Yes" => click(By.id("value"))
      case "No"  => click(By.id("value-no"))
    }
    clickSaveAndContinueButton()
  }

  def clickButton(buttonText: String): Unit =
    buttonText match {
      case "Change Hyperlink" =>
        click(By.cssSelector("a[href='/inheritance-tax-on-pensions/S2400000001/change-name-of-beneficiary/0']"))
      case "Remove Hyperlink" =>
        click(By.cssSelector("a[href*='remove-beneficiary/0']"))

    }

  def selectHyperlink(text: String): Unit =
    clickButton(text)
}
