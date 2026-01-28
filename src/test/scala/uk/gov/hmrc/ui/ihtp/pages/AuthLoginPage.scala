/*
 * Copyright 2023 HM Revenue & Customs
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
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.ihtp.conf.TestConfiguration

object AuthLoginPage extends BasePage {
  override val pageUrl: String = TestConfiguration.url("auth-login-stub") + "/gg-sign-in"

  private val redirectionUrlById: By = By.id("redirectionUrl")
  private val affinityGroupById: By  = By.id("affinityGroupSelect")
  private val authSubmitById: By     = By.id("submit-top")
  private val enrolmentKeyLocator    = "enrolment[0].name"
  private val identifierNameLocator  = "input-0-0-name"
  private val identifierValueLocator = "input-0-0-value"
  private val confidenceLevelLocator = "select[name=confidenceLevel]"
  private val enrolmentKey           = "HMRC-PODS-ORG"
  private val psaEnrolmentKey        = "HMRC-PODS-ORG"
  private val pspEnrolmentKey        = "HMRC-PODSPP-ORG"
  private val identifierName         = "PsaID"
  private val identifierValue        = "A2100005"
  private val confidenceLevel        = "50"
  private val NINOLocator            = "nino"
  private val NINO                   = ""
  private val redirectUrl: String    = TestConfiguration.url("inheritance-tax-on-pensions")

  private def loadPage: this.type = {
    get(pageUrl)
    verifyPageLoaded()
    this
  }

  private def submitAuthPage(): Unit = click(authSubmitById)

  private def submitAuthWithoutEnrolment(affinityGroup: String): Unit = {
    loadPage
    sendKeys(redirectionUrlById, redirectUrl)
    selectByVisibleText(affinityGroupById, affinityGroup)
    enterNINO()
    enterConfidenceLevel(confidenceLevel)
    submitAuthPage()
  }

  private def submitAuthWithEnrolment(
    affinityGroup: String,
    enrolmentKey: String
  ): Unit = {
    loadPage
    sendKeys(redirectionUrlById, redirectUrl)
    selectByVisibleText(affinityGroupById, affinityGroup)
    enterNINO()
    enterConfidenceLevel(confidenceLevel)
    enterEnrolment(enrolmentKey)
    submitAuthPage()
  }

  def enterEnrolment(enrolmentKey: String): Unit = {
    inputId(enrolmentKeyLocator, enrolmentKey)
    inputId(identifierNameLocator, identifierName)
    inputId(identifierValueLocator, identifierValue)
  }

  def loginAsOrgUserWithPsaEnrolment(): Unit =
    submitAuthWithEnrolment("Organisation", psaEnrolmentKey)

  def loginAsOrgUserWithPspEnrolment(): Unit =
    submitAuthWithEnrolment("Organisation", pspEnrolmentKey)

  def loginAsOrgUserWithoutEnrolment(): Unit =
    submitAuthWithoutEnrolment("Organisation")

  def enterConfidenceLevel(level: String): Unit = {
    val confidenceLevel = new Select(Driver.instance.findElement(By.cssSelector(confidenceLevelLocator)))
    confidenceLevel.selectByVisibleText(level)
  }

  def enterNINO(): Unit =
    inputId(NINOLocator, NINO)
}
