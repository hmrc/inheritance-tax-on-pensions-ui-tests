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
import uk.gov.hmrc.ui.ihtp.pages.EnterTheInheritanceTaxReferenceNumberPage.clickSaveAndContinueButton

object ChooseAddressPage extends BasePage {

  override val pageTitle: String = "Choose the address - Report inheritance tax on a pension - GOV.UK"

  override val pageUrl: String =
    ".*/lookup-address/.../select?postcode=ZZ1+1ZZ"

  def verifyPage(): Unit =
    verifyPageLoadedContains("/select?postcode=ZZ1+1ZZ")

  def SaveAndContinueButton(): Unit =
    clickSaveAndContinueButton()

  def clickRadioButton(text: String): Unit =
    text match {
      case "2"         => click(By.id("addressId"))
      case "3"         => click(By.id("addressId-1"))
      case "4"         => click(By.id("addressId-2"))
      case "5"         => click(By.id("addressId-3"))
      case "6"         => click(By.id("addressId-4"))
      case "Flat 1, 7" => click(By.id("addressId-5"))
      case "Flat 2, 7" => click(By.id("addressId-6"))
      case "Flat 3, 7" => click(By.id("addressId-7"))
      case "8"         => click(By.id("addressId-8"))
      case "9"         => click(By.id("addressId-9"))
      case "10"        => click(By.id("addressId-10"))

    }

}
