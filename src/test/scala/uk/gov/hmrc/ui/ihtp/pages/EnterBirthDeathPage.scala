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

object EnterBirthDeathPage extends BasePage {
  val pageUrl: String     = s"$baseUrl/enter-birth-death-date"
  val pageTitle: String   =
    "Enter the birth and death dates of the deceased - Report inheritance tax on a pension - GOV.UK"
  val pageHeading: String = "Enter the birth and death dates of A A"

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

  def enterBirthDate(day: String, month: String, year: String): Unit = {
    checkURL
    enterText("dateOfBirth.day", day)
    enterText("dateOfBirth.month", month)
    enterText("dateOfBirth.year", year)
  }

  def enterDeathDate(day: String, month: String, year: String): Unit = {
    checkURL
    enterText("dateOfDeath.day", day)
    enterText("dateOfDeath.month", month)
    enterText("dateOfDeath.year", year)
    clickSaveAndContinueButton()
  }

}
