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

object CheckYourAnswersPage extends BasePage {
  val pageUrl: String     = s"$baseUrl/check-your-answers"
  val pageTitle: String   = "Check and submit the report - Report inheritance tax on a pension - GOV.UK"
  val pageHeading: String = "Check and submit the report"

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

  def ClickChangeLink(): Unit =
    click(By.cssSelector("dd[class='govuk-summary-list__actions'] a[class='govuk-link']"))

}
