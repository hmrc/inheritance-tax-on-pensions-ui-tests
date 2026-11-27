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

object WhoRepresentsEstatePage extends BasePage {
  override val pageUrl: String   = s"$baseUrl/who-represents-estate"
  override val pageTitle: String =
    "Who is representing the estate of DeceasedFirstName DeceasedSurnameName? - Report Inheritance Tax on a pension - GOV.UK"

  val pageHeading: String = "Who is representing the estate of DeceasedFirstName DeceasedSurnameName?"

  def clickRadioButton(text: String): Unit =
    text match {
      case "a personal representative (PR)"              => click(By.id("value_0"))
      case "a prospective personal representative (PPR)" => click(By.id("value_1"))
    }
    clickSaveAndContinueButton()

}
