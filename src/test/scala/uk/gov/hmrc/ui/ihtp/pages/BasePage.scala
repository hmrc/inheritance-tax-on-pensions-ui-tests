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

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.ihtp.conf.TestConfiguration
import uk.gov.hmrc.ui.ihtp.pages.YourSubmissionsPage.getPageSource

import java.time.Duration
import scala.util.Try

trait BasePage extends Matchers with PageObject {

  val pageUrl: String
  val baseUrl: String = TestConfiguration.url("inheritance-tax-on-pensions")

  private def fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(2))
    .pollingEvery(Duration.ofMillis(200))

  def verifyPageLoaded(url: String = this.pageUrl): Unit = fluentWait.until(ExpectedConditions.urlToBe(url))

  def navigateTo(url: String): Unit = {
    Driver.instance.get(url)
    verifyPageLoaded(url)
  }

  def isElementPresent(by: By): Boolean =
    Try(Driver.instance.findElement(by)).isSuccess

  def verifyFooterLinksArePresent(): Boolean =
    isElementPresent(By.linkText("Cookies")) &&
      isElementPresent(By.linkText("Accessibility statement")) &&
      isElementPresent(By.linkText("Privacy policy")) &&
      isElementPresent(By.linkText("Terms and conditions")) &&
      isElementPresent(By.linkText("Help using GOV.UK")) &&
      isElementPresent(By.linkText("Contact")) &&
      isElementPresent(By.linkText("Rhestr o Wasanaethau Cymraeg"))

  def verifyLanguageToggle(): Boolean =
    getPageSource.contains("Cymraeg")

  def verifySignOutLinkText(): Boolean =
    isElementPresent(By.linkText("Sign out"))

  def goTo(page: BasePage): Unit = navigateTo(page.pageUrl)

  /** Can be expanded to include more if necessary * */
  def inputId(id: String, value: String): Unit = input(By.id(id), value)

  def inputDates(id: String, value: String): Unit = input(By.cssSelector(id), value)

  def inputXpath(xpath: String, value: String): Unit = input(By.xpath(xpath), value)

  def inputCss(css: String, value: String): Unit = input(By.cssSelector(css), value)

  /** Input methods * */
  private def input(by: By, value: String): Unit = {
    fluentWait.until(ExpectedConditions.presenceOfElementLocated(by))
    Driver.instance.findElement(by).clear()
    Driver.instance.findElement(by).sendKeys(value)
  }
}
