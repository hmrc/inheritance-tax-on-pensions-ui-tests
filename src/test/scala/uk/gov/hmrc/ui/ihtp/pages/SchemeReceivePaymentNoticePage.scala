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

object SchemeReceivePaymentNoticePage extends BasePage {
  override val pageUrl: String   = s"$baseUrl/scheme-receive-payment-notice"
  override val pageTitle: String =
    "When did Mr Firstname Middlename Lastname Pension Scheme receive the payment notice? - Report inheritance tax on a pension - GOV.UK"
  val pageHeading: String        = "When did Smith Harper Pension Scheme receive the payment notice?"

  def SaveAndContinueButton(): Unit =
    clickSaveAndContinueButton()

  def dateOfReceivingPaymentNotice(day: String, month: String, year: String): Unit = {
    checkURL()
    enterText("dateThePensionSchemeReceivedNoticeToPay.day", day)
    enterText("dateThePensionSchemeReceivedNoticeToPay.month", month)
    enterText("dateThePensionSchemeReceivedNoticeToPay.year", year)
  }

}
