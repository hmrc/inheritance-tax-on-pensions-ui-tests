/*
 * Copyright 2026 HM Revenue & Customs
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

object EnterAmountofIHTPayable extends BasePage {
  override val pageUrl: String   = s"$baseUrl/enter-iht-payable"
  override val pageTitle: String =
    "Enter the amount of Inheritance Tax payable - Report Inheritance Tax on a pension - GOV.UK"
  val pageHeading: String        = "Enter the amount of Inheritance Tax payable"

  def verifyPageHeading(): Boolean =
    getPageSource.contains(pageHeading)

  def enterAmountOfIHTPayable(textToEnter: String): Unit = {
    enterText("value", textToEnter)
    clickSaveAndContinueButton()
  }

}
