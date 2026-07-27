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

object SelectTypeOfBeneficiaryToAdd extends BasePage {
  override val pageUrl: String   = s"$baseUrl/select-beneficiary-type/0"
  override val pageTitle: String =
    "Select the type of beneficiary to add - Report Inheritance Tax on a pension - GOV.UK"

  def clickRadioButton(text: String): Unit =
    text match {
      case "An individual"            => click(By.id("value_0"))
      case "An organisation or trust" => click(By.id("value_1"))
    }
    clickSaveAndContinueButton()

}
