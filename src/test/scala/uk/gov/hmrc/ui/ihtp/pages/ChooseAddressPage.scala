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
    ".*/lookup-address/.../select?postcode=ZZ01+1ZZ"

  def verifyPage(): Unit =
    verifyPageLoadedContains("/select?postcode=ZZ01+1ZZ")

  def SaveAndContinueButton(): Unit =
    clickSaveAndContinueButton()

  def clickRadioButton(text: String): Unit = {
    text match {
      case "1" => click(By.id("addressId"))
      case "2" => click(By.id("addressId-1"))
      case "3" => click(By.id("addressId-2"))

    }
    clickSaveAndContinueButton()
  }

}
