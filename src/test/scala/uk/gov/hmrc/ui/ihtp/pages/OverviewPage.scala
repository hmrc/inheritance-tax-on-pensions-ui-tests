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

object OverviewPage extends BasePage {
  override val pageUrl: String                                       = s"$baseUrl/report-inheritance-tax-on-pension"
  val mpsPageUrl: String                                             = "http://localhost:8204/manage-pension-schemes/you-need-to-register"
  override val pageTitle: String                                     = "Report Inheritance Tax on a pension - Report inheritance tax on a pension - GOV.UK"
  val pageHeading: String                                            = "Report Inheritance Tax on a pension"
  val deceasedNameLinkForUniqueDeceasedName: By                      =
    By.xpath("//a[@id='deceased-name-None' and contains(., 'UniqueDeceasedFirstName UniqueDeceasedSurnameName')]")
  val deceasedNameDrViewOrChangeLink: By                             =
    By.xpath("//a[@id='deceased-name-Some(119000004320)' and contains(., 'View Change')]")
  val deceasedPaymentReferenceForDrViewOrChange: String              = "A123456/25A629671"
  val deceasedInheritanceTaxReferenceNumberForDrViewOrChange: String = "A123456/25A"
  val deceasedNameDeceasedFirstNameLink: By                          =
    By.xpath("//a[@id='deceased-name-None' and contains(., 'DeceasedFirstName DeceasedSurnameName')]")
  val searchBar: By                                                  = By.id("value")
  val paidReportPaymentReferenceForPaidSurname: String               = "F246810/26B999999"
  val paidReportInheritanceTaxReferenceNumberForPaidSurname: String  = "F246810/26B"

  def verifyPageHeading(): Boolean =
    getPageSource.contains(pageHeading)

  def clickLinkBackToReport(): Unit =
    click(By.id("deceased-name-None"))

  def clickLinkByIdAndTextForUniqueDeceasedName(): Unit =
    click(deceasedNameLinkForUniqueDeceasedName)

  def clickLinkByIdAndTextForDrViewOrChange(): Unit =
    click(deceasedNameDrViewOrChangeLink)

  def clickLinkByIdAndTextForDeceasedFirstName(): Unit =
    click(deceasedNameDeceasedFirstNameLink)

  def searchForReportByPaymentReferenceForActiveReport(): Unit = {
    click(searchBar)
    enterText("value", deceasedPaymentReferenceForDrViewOrChange)
    clickSearchButton()
  }

  def searchForReportByPaymentReferenceForPaidReport(): Unit = {
    click(searchBar)
    enterText("value", paidReportPaymentReferenceForPaidSurname)
    clickSearchButton()
  }

  def searchForReportByInheritanceTaxReferenceNumberForActiveReport(): Unit = {
    click(searchBar)
    enterText("value", deceasedInheritanceTaxReferenceNumberForDrViewOrChange)
    clickSearchButton()
  }

  def searchForReportByInheritanceTaxReferenceNumberForPaidReport(): Unit = {
    click(searchBar)
    enterText("value", paidReportInheritanceTaxReferenceNumberForPaidSurname)
    clickSearchButton()
  }

  def clickOnClearLinkForActiveReports(): Unit =
    click(By.cssSelector("a[href='/inheritance-tax-on-pensions/S2400000001/report-inheritance-tax-on-pension']"))

  def clickOnClearLinkForPaidReports(): Unit =
    click(By.cssSelector("a[href='/inheritance-tax-on-pensions/S2400000001/paid-reports']"))

  def verifyReportForDrViewAndChange(): Boolean =
    verifyReportById("deceased-name-Some(119000004320)")

  def verifyPaidReportForPaidSurname(): Boolean =
    verifyReportById("deceased-name-Some(119000004362)")

  def verifyRegistrationReminderPage(): Boolean = {
    val mainHeading      = "You need to register as a pension scheme administrator or practitioner"
    val linkAdmin        = "Register as an administrator or recover your administrator details"
    val linkPractitioner = "Register as a practitioner or recover your practitioner details"

    // Check if all key elements are present on the page
    getPageSource.contains(mainHeading) &&
    getPageSource.contains(linkAdmin) &&
    getPageSource.contains(linkPractitioner)
  }
}
