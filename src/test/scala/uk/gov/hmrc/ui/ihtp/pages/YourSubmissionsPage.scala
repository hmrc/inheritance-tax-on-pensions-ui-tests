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

object YourSubmissionsPage extends BasePage {
  val pageUrl: String = s"$baseUrl/S2400000001/submission-list"
  val pageTitle: String = "Your submissions - inheritance-tax-on-pensions-frontend - GOV.UK"
  val pageHeading: String = "Your submissions"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(): Boolean =
    getTitle == pageTitle

  def verifyPageHeading(): Boolean =
    getPageSource.contains(pageHeading)

  def verifyRegistrationReminderPage(): Boolean = {
    val mainHeading = "You need to register as a pension scheme administrator or practitioner"
    val linkAdmin = "Register as an administrator or recover your administrator details"
    val linkPractitioner = "Register as a practitioner or recover your practitioner details"

    // Check if all key elements are present on the page
    getPageSource.contains(mainHeading) &&
      getPageSource.contains(linkAdmin) &&
      getPageSource.contains(linkPractitioner)
  }
}
